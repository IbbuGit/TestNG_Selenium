package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.CollectedPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.MoveProductPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.NotCollectedPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotCollectedPage {

    private int sessionSize = 0;
    private int noOfProdsCollected = 0;
    private String text = "";
    List<WebElement> UpcElementList;
    private int totalProducts = 0;
    private MobileCommands mobileCommands = new MobileCommands();
    private NotCollectedPageMap notCollectedPageMap;
    private ScanProductDRPage scanProductDRPage;
    private ScanProductPage scanProductPage;
    private CollectProductPage collectProductPage;
    private MoveProductPage moveProductPage;
    private MoveProductPageMap moveProductPageMap;
    private CollectedPageMap collectedPageMap;

    public NotCollectedPage() {
        notCollectedPageMap = new NotCollectedPageMap();
        scanProductDRPage = new ScanProductDRPage();
        scanProductPage = new ScanProductPage();
        collectProductPage = new CollectProductPage();
        moveProductPage = new MoveProductPage();
        collectedPageMap = new CollectedPageMap();
        moveProductPageMap = new MoveProductPageMap();

    }

    public void verifyNotCollectedPageDisplay() {
        mobileCommands.assertElementDisplayed(notCollectedPageMap.tabNotCollected(), true);
    }

    public void clickFirstProduct() {
        List<WebElement> products = mobileCommands.getWebDriver().findElements(By.id("drUpcText"));
        products.get(0).click();
    }

    public void validateCartIsFullPopUI() {
        mobileCommands.assertElementDisplayed(notCollectedPageMap.headerPrdsNotCollected(), true);
        mobileCommands.assertElementDisplayed(notCollectedPageMap.txtProdNotCollectedMsg(), true);
        mobileCommands.assertElementDisplayed(notCollectedPageMap.btnDoneCollecting(), true);
        mobileCommands.assertElementDisplayed(notCollectedPageMap.btnCancel(), true);

    }

    public void clickCartIsFull() {
        mobileCommands.click(notCollectedPageMap.btnCartIsFull());
    }

    public void clickCartIsFullDoneCollecting() {
        mobileCommands.wait(3);
        mobileCommands.click(notCollectedPageMap.btnDoneCollecting());
    }

    public void clickCartIsFullCancel() {
        mobileCommands.click(notCollectedPageMap.btnCancel());
    }

    public void clickNotCollected() {
        mobileCommands.click(notCollectedPageMap.tabNotCollected());

    }

    public void validateNotCollectedEnabled() {
        mobileCommands.assertElementEnabled(notCollectedPageMap.tabNotCollected(), true);
    }

    public void validateCartIsFullDisabled() {
        if (!mobileCommands.elementEnabled(notCollectedPageMap.btnCartIsFull())) {
            System.out.println("Cart Is Full button is disabled");
        } else {
            System.out.println("Cart Is Full button is Enabled");
        }
    }

    public void validateCartIsFullEnabled() {
        mobileCommands.elementEnabled(notCollectedPageMap.btnCartIsFull());
    }

    public int sessionPopDisplay() {
        sessionSize = mobileCommands.getWebDriver().findElements(By.id("text_negative_caption")).size();
        return sessionSize;
    }

    public void clickSessionInProgressContinue() {
        if (sessionPopDisplay() > 0) {
            mobileCommands.click(notCollectedPageMap.btnSessionInProgressContinue());
        }

    }

    public void clickSessionInProgressCollectMore() {
        if (sessionPopDisplay() > 0) {
            mobileCommands.click(notCollectedPageMap.btnSessionInProgressCollectMore());
        }
    }

    public void validateSkipped() {
        mobileCommands.scrollToElement(notCollectedPageMap.txtSkipped(), "down");
        mobileCommands.assertElementDisplayed(notCollectedPageMap.txtSkipped(), true);
    }

    public void scrollToFirstElement() {
        mobileCommands.scrollToElement(notCollectedPageMap.txtFindAndScanInBR(), "up");
    }

    public int prodsToCollect() {
        String prodsCollected = mobileCommands.getElementText(notCollectedPageMap.txtProductsToCollect());
        int index = prodsCollected.indexOf("o");
        String noOfProdsToCollect = prodsCollected.substring(0, index - 1);
        noOfProdsCollected = Integer.parseInt(noOfProdsToCollect);
        return noOfProdsCollected;
    }

    public void validateFindAndScanText() {
        mobileCommands.assertElementDisplayed(notCollectedPageMap.txtFindAndScanInBR(), true);
    }

    public void collectAllProducts() throws IOException {
        String prodsToCollect = mobileCommands.getElementText(notCollectedPageMap.txtProductsToCollect());
        int index = prodsToCollect.indexOf("o");
        String noOfProdsToCollect = prodsToCollect.substring(0, index - 1);
        int prods = Integer.parseInt(noOfProdsToCollect);
        for (int i = 0; i < prods; i++) {
            waitForNotCollectedTab();
            clickFirstProduct();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
        }
        mobileCommands.assertElementDisplayed(notCollectedPageMap.tabCollected(), true);
    }

    public void waitForNotCollectedTab() {
        mobileCommands.waitForElement(notCollectedPageMap.tabNotCollected());
    }

    public void cartIsFull() throws IOException, InterruptedException {
        CollectedPage collectedPage = new CollectedPage();
        if (!(collectedPage.collectedTabEnabled())) {
            clickCartIsFull();
            validateCartIsFullPopUI();
            clickCartIsFullCancel();
            validateNotCollectedEnabled();
            clickCartIsFull();
            clickCartIsFullDoneCollecting();

            moveProductPage.validateMoveProduct();
        } else {
            clickNotCollected();
            validateCartIsFullDisabled();
        }
    }

    public void cartIsFullEnabled() {
        CollectedPage collectedPage = new CollectedPage();
        if (collectedPage.validateAtleastOneProdCollected() == 0) {
            clickNotCollected();
            validateCartIsFullDisabled();
        } else {
            clickNotCollected();
            validateCartIsFullEnabled();
        }
    }

    public int productsToCollect() {
        totalProducts = Integer.parseInt(mobileCommands.element(notCollectedPageMap.txtProductsToCollect()).getText().split(" ")[2]);
        return totalProducts;
    }

    public List<String> getUpcList() {
        totalProducts = productsToCollect();
        if (totalProducts > 10) {
            totalProducts = 5;
        }
        List<String> UpcNoList = new ArrayList<>();
        int i = 0;
        do {
            UpcElementList = mobileCommands.elements(notCollectedPageMap.findUpc());
            for (WebElement ele : UpcElementList) {
                if (!UpcNoList.contains(ele.getText())) {
                    UpcNoList.add(ele.getText());
                    i++;
                    break;
                }
            }
            BaseUtil.scroll("down");
        } while (i < totalProducts);
        return UpcNoList;
    }

    public void clickUpc(String upc) {
        do {
            UpcElementList = mobileCommands.elements(notCollectedPageMap.findUpc());
            if (UpcElementList.get(0).getText().equals(upc)) {
                break;
            }
            BaseUtil.scroll("up");
        } while (!UpcElementList.get(0).getText().equals(upc));
        for (WebElement ele : UpcElementList) {
            if (ele.getText().equals(upc)) {
                ele.click();
                break;
            }
        }
    }

    public void clickCollectMore() {
        try {
            if ((mobileCommands.elements(notCollectedPageMap.btnCollectMore()).size()) > 0) {
                mobileCommands.click(notCollectedPageMap.btnCollectMore());
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    public void verifyUnfinishedCollectionList_ClickNewList(String fuelUnFinishedCollectionListHdr) {
        mobileCommands.waitForElement(notCollectedPageMap.txtUnFinishedWorkHdr());
        mobileCommands.assertElementText(notCollectedPageMap.txtUnFinishedWorkHdr(), fuelUnFinishedCollectionListHdr, true);
        mobileCommands.waitForElement(notCollectedPageMap.btnNewList());
        mobileCommands.click(notCollectedPageMap.btnNewList());
    }

    public void verifyUnfinishedCollectionList_ClickContinue(String fuelUnFinishedCollectionListHdr) {
        mobileCommands.waitForElement(notCollectedPageMap.txtUnFinishedWorkHdr());
        mobileCommands.assertElementText(notCollectedPageMap.txtUnFinishedWorkHdr(), fuelUnFinishedCollectionListHdr, true);
        mobileCommands.waitForElement(notCollectedPageMap.btnContinue());
        mobileCommands.click(notCollectedPageMap.btnContinue());
    }

    public void verifyProductsNotCollectedPopup(String productNotCollectedHdrPopup) {
        mobileCommands.assertElementText(notCollectedPageMap.headerProductNotCollectedPopup(), productNotCollectedHdrPopup, true);
    }

    public void verifySessionInProgressPopup(String sessionInProgressHdrPopup) {
        mobileCommands.assertElementText(notCollectedPageMap.headerSessionInProgress(), sessionInProgressHdrPopup, true);
    }

    public void collectAllProductsAndReplenish() throws IOException {
        String prodsToCollect = mobileCommands.getElementText(notCollectedPageMap.txtProductsToCollect());
        int index = prodsToCollect.indexOf("o");
        String noOfProdsToCollect = prodsToCollect.substring(0, index - 1);
        int prods = Integer.parseInt(noOfProdsToCollect);
        for (int i = 1; i <= prods; i++) {
            waitForNotCollectedTab();
            clickFirstProduct();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
        }
        mobileCommands.click(collectedPageMap.btnBeginStocking());
        while ((mobileCommands.getWebDriver().findElements(By.id("btn_finish")).size()) == 0) {
            //Assert.assertTrue(collectedUPC.contains(mobileCommands.getElementText(moveProductPageMap.txtProdUPC())));
            mobileCommands.click(moveProductPageMap.btnNext());
        }
        //Assert.assertTrue(collectedUPC.contains(mobileCommands.getElementText(moveProductPageMap.txtProdUPC())));
        mobileCommands.wait(5);
        mobileCommands.click(moveProductPageMap.btnFinish());

    }

    public void verifyNotCollectedProductsCount(int minimum, int max) {
        mobileCommands.isElementExist(notCollectedPageMap.numOfProductsInNotCollected(minimum, max));
    }
}