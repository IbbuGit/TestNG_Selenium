
package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.CollectedPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.MoveProductPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MoveProductPage {

    private MobileCommands mobileCommands = new MobileCommands();
    private MoveProductPageMap moveProductPageMap;
    private CollectedPageMap collectedPageMap;
    private ThankyouPage thankyouPage;


    public MoveProductPage() {
        moveProductPageMap = new MoveProductPageMap();
        collectedPageMap = new CollectedPageMap();
        thankyouPage = new ThankyouPage();
    }

    /*
     *   Click Finish button
     */
    public void clickFinishButton() {

        while ((mobileCommands.getWebDriver().findElements(By.id("btn_next")).size()) > 0) {
            mobileCommands.click(moveProductPageMap.btnNext());
            try {
                mobileCommands.waitForElementVisibility(moveProductPageMap.btnNext());
            } catch (Exception e) {
                //Do Nothing
            }
        }
        mobileCommands.click(moveProductPageMap.btnFinish());
    }

    /*
     *   Verify the display of Move Product
     */
    public void validateMoveProduct(){
        if (!mobileCommands.isElementExist(moveProductPageMap.headerMoveProduct())) {
            mobileCommands.click(collectedPageMap.btnDoneCollecting());
        }
        mobileCommands.assertElementDisplayed(moveProductPageMap.headerMoveProduct(), true);
    }

    public void validateCollectedProdDetails() {
        mobileCommands.assertElementDisplayed(moveProductPageMap.txtProdUPC(), true);
        mobileCommands.assertElementDisplayed(moveProductPageMap.txtprodDesc(), true);
        mobileCommands.assertElementDisplayed(moveProductPageMap.imgProd(), true);
    }

    public void clickCantFindAndSkip() {
        mobileCommands.click(moveProductPageMap.btnCantFindSkip());
    }

    public void validateCantFindAndSkipUI() {
        mobileCommands.assertElementDisplayed(moveProductPageMap.headerCantFindSkip(), true);
        mobileCommands.assertElementDisplayed(moveProductPageMap.txtCantFindSkipProd(), true);
        mobileCommands.assertElementDisplayed(moveProductPageMap.btnSkip(), true);
        mobileCommands.assertElementDisplayed(moveProductPageMap.btnCancel(), true);
    }

    public void clickSkip() {
        mobileCommands.click(moveProductPageMap.btnSkip());

    }

    public int FindNoOfProdsForRepl() {
        String header = mobileCommands.getElementText(moveProductPageMap.headerMoveProduct());
        int index = header.indexOf("/");
        String str2 = header.substring(index + 1);
        int totalCount = Integer.parseInt(str2);
        return totalCount;
    }

    public void clickCancel() {
        mobileCommands.click((moveProductPageMap.btnCancel()));
    }

    public void validatingCantFindAndSkip() throws IOException, InterruptedException {
        if (FindNoOfProdsForRepl() == 1) {
            clickCantFindAndSkip();
            validateCantFindAndSkipUI();
            clickCancel();
            validateMoveProduct();
            clickCantFindAndSkip();
            clickSkip();
            thankyouPage.validateThankYouPgDisplay();
        } else {
            clickCantFindAndSkip();
            validateCantFindAndSkipUI();
            clickCancel();
            validateMoveProduct();
            clickCantFindAndSkip();
            clickSkip();
            clickFinishButton();
        }
    }

    public void validateSkipProducts() throws IOException, InterruptedException {
        CollectedPage collectedPage = new CollectedPage();
        if (!(collectedPage.collectedTabEnabled())) {
            collectedPage.clickCollectedTab();
        }
        collectedPage.validateCollectedTab();
        collectedPage.validateBeginStockingButton();
        collectedPage.clickFinishCollectingBtn();
        validateCollectedProdDetails();
        validatingCantFindAndSkip();
        thankyouPage.validateThankYouPgDisplay();
        thankyouPage.validateFinishedDRText();
        thankyouPage.validateBackToMainMenu();
        thankyouPage.validateContReplenishmentButton();
    }

    public void clickAwesome() {
        if ((mobileCommands.elements(moveProductPageMap.awesome()).size()) > 0) {
            mobileCommands.click(moveProductPageMap.awesome());
        }
    }

    public void clickGreat() {
        if ((mobileCommands.elements(moveProductPageMap.great()).size()) > 0) {
            mobileCommands.click(moveProductPageMap.great());
        }
    }

    public HashSet<String> clickFinishButtonByProductLocation() {
        mobileCommands.waitForElementVisibility(moveProductPageMap.headerMoveProduct());
        int totalLoc = Integer.parseInt(mobileCommands.element(moveProductPageMap.headerMoveProduct()).getText().split("/")[1]);
        HashSet<String> upcToMove = new HashSet<>();
        for (int i = 0; i < totalLoc - 1; i++) {
            try {
                upcToMove.add(mobileCommands.element(moveProductPageMap.txtProdUPC()).getText());
                mobileCommands.waitForElementVisibility(moveProductPageMap.btnNext());
                mobileCommands.click(moveProductPageMap.btnNext());
            } catch (Exception e) {
                //Do Nothing
            }
        }
        upcToMove.add(mobileCommands.element(moveProductPageMap.txtProdUPC()).getText());
        mobileCommands.waitForElementVisibility(moveProductPageMap.btnFinish());
        mobileCommands.click(moveProductPageMap.btnFinish());
        return upcToMove;
    }

    public void clickExit_UnFinishedPopup() {
        mobileCommands.waitForElement(moveProductPageMap.unFinishedWorkPopUp_Exit());
        mobileCommands.click(moveProductPageMap.unFinishedWorkPopUp_Exit());
    }

    public void verifyUnfinishedPopup_ClickExit(String unFinishedCollectionListHdr) {
        mobileCommands.waitForElement(moveProductPageMap.unFinishedTitle_MoveProduct());
        mobileCommands.assertElementText(moveProductPageMap.unFinishedTitle_MoveProduct(), unFinishedCollectionListHdr, true);
        mobileCommands.waitForElement(moveProductPageMap.unFinishedWorkPopUp_Exit());
        mobileCommands.click(moveProductPageMap.unFinishedWorkPopUp_Exit());
    }

    public void verifyUnfinishedPopup_ClickCancel(String unFinishedCollectionListHdr) {
        mobileCommands.waitForElement(moveProductPageMap.unFinishedTitle_MoveProduct());
        mobileCommands.assertElementText(moveProductPageMap.unFinishedTitle_MoveProduct(), unFinishedCollectionListHdr, true);
        mobileCommands.waitForElement(moveProductPageMap.unFinishedWorkPopUp_Cancel());
        mobileCommands.click(moveProductPageMap.unFinishedWorkPopUp_Cancel());
    }

    public void verifyCantFindAndSkipPopup(String CantFindAndSkipHdrPopup) {
        mobileCommands.assertElementText(moveProductPageMap.headerCantFindSkip(), CantFindAndSkipHdrPopup, true);
    }

    public void verifyCantFindAndSkipPopupMsg(String cantFindAndSkipPopupMsg) {
        mobileCommands.waitForElement(moveProductPageMap.txtCantFindSkipProd());
        mobileCommands.assertElementText(moveProductPageMap.txtCantFindSkipProd(), cantFindAndSkipPopupMsg, true);
    }

    public void clickNextBtn() {
        mobileCommands.click(moveProductPageMap.btnNext());
    }

    public void validateCollectedProductUPC(List<String> collectedUPC) {
        Set<String> notCollectedItems = new HashSet();
        for (String upc : collectedUPC) {
            List<WebElement> upcElements = mobileCommands.elements(moveProductPageMap.txtProdUPC());
            for (WebElement upcElement : upcElements) {
                String temp1 = upcElement.getText().replace("UPC", "").replace(" ", "");
                notCollectedItems.add(temp1);
            }
            BaseUtil.scroll("down", 2);
            upcElements = mobileCommands.elements(moveProductPageMap.txtProdUPC());
            String temp2 = upcElements.get(upcElements.size() - 1).getText().replace("UPC", "").replace(" ", "");
            if (notCollectedItems.contains(temp2)) {
                break;
            }
        }
    }

    public void validateMultipleUPCAndClickFinish(List<String> collectedUPC) {

        int count = 1;
        while ((mobileCommands.getWebDriver().findElements(By.id("btn_next")).size()) > 0) {
            mobileCommands.click(moveProductPageMap.btnNext());
            try {
                //second argument not yet done need to fix it
                moveProductPageMap.moveProductCount(count, collectedUPC.size());
                validateCollectedProductUPC(collectedUPC);
                mobileCommands.waitForElementVisibility(moveProductPageMap.btnNext());
                count++;
            } catch (Exception e) {
                //Do Nothing
            }
        }
        mobileCommands.click(moveProductPageMap.btnFinish());
    }

    public void validateCollectedProductUPC1(List<String> collectedUPC) {
        while ((mobileCommands.getWebDriver().findElements(By.id("btn_finish")).size()) == 0) {
            Assert.assertTrue(collectedUPC.contains(mobileCommands.getElementText(moveProductPageMap.txtProdUPC())));
            mobileCommands.click(moveProductPageMap.btnNext());
        }
        Assert.assertTrue(collectedUPC.contains(mobileCommands.getElementText(moveProductPageMap.txtProdUPC())));
        mobileCommands.wait(5);
        mobileCommands.click(moveProductPageMap.btnFinish());
    }

    public void unfinishedWorkPopupSaveAndExit(String unFinishedCollectionListHdr) {
        mobileCommands.waitForElement(moveProductPageMap.unFinishedTitle_MoveProduct());
        mobileCommands.assertElementText(moveProductPageMap.unFinishedTitle_MoveProduct(), unFinishedCollectionListHdr, true);
        mobileCommands.waitForElement(collectedPageMap.saveAndExitBtn());
        mobileCommands.click(collectedPageMap.saveAndExitBtn());
    }

}

