package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockReviewPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopStockReviewPage {
    MobileCommands mobileCommands = new MobileCommands();
    TopStockReviewPageMap topStockreviewpagemap;

    public TopStockReviewPage() {
        topStockreviewpagemap = new TopStockReviewPageMap();
    }

    public void ValidateAndClickFinishBtn(String finishBtnTxt) {
        mobileCommands.assertElementText(topStockreviewpagemap.FinishBtn(), finishBtnTxt, true);
        mobileCommands.click(topStockreviewpagemap.FinishBtn());
    }

    public void clickContinueBtn() {
        mobileCommands.click(topStockreviewpagemap.ContinueBtn());
    }

    public void verifyReviewHeaderTxt(String reviewHdrTxt) {
        mobileCommands.assertElementText(topStockreviewpagemap.ReviewHeader(), reviewHdrTxt, true);
    }

    public void clickNotStockTab() {
        mobileCommands.click(topStockreviewpagemap.notStockedTab());
    }

    public void clickOnFinishBtn() {
        mobileCommands.click(topStockreviewpagemap.FinishBtn());
    }

    public void validateStockedItem(String UPCNumber) {
        List<WebElement> upcsList = mobileCommands.elements(topStockreviewpagemap.UPCsList());
        List<String> upcs = new ArrayList<String>();
        for (WebElement ele : upcsList) {
            upcs.add(ele.getText().replaceAll(" ", ""));
            System.out.println(upcs);
        }
        Assert.assertTrue(upcs.get(0).contains(UPCNumber));
    }

    public void clickOnBackBtn() {
        mobileCommands.click(topStockreviewpagemap.backBtn());
    }

    public void ValidateNoLocationTxtReviewScreen(String noLocationTxt) {
        mobileCommands.assertElementText(topStockreviewpagemap.NoLocationTxt(), noLocationTxt, true);
    }

    public void verifyWrongAisleText(String wrongAisletxt) {
        mobileCommands.assertElementText(topStockreviewpagemap.wrongAisleTxt(), wrongAisletxt, true);
    }

    public void clickOnWrongAisleTxt() {
        mobileCommands.click(topStockreviewpagemap.wrongAisleTxt());
    }

    public void verifyRelocateProductPageHdr(String relocateProductTxt) {
        mobileCommands.assertElementText(topStockreviewpagemap.relocateProductHdr(), relocateProductTxt, true);
    }

    public void validateBOHProductsLabel(String balanceUpdatedLbl) {
        mobileCommands.assertElementText(topStockreviewpagemap.balanceUpdatedLable(), balanceUpdatedLbl, true);
    }

    public void verifyClickingOnStockedProduct() {
        mobileCommands.waitForElement(topStockreviewpagemap.UPCsList());
        mobileCommands.click(topStockreviewpagemap.UPCsList());
    }

    public void verifyStockedHdr(String stockedHdr) {
        mobileCommands.assertElementText(topStockreviewpagemap.stockedHdrTxt(), stockedHdr, true);
    }

    public void verifyNotStockedHdr(String notStockedHdr) {
        mobileCommands.assertElementText(topStockreviewpagemap.notStockedHdrTxt(), notStockedHdr, true);
    }

    public void verifyClickingOnNotStockedProduct() {
        mobileCommands.waitForElement(topStockreviewpagemap.UPCsList());
        mobileCommands.click(topStockreviewpagemap.UPCsList());
    }

    public void validateStockedNotStockedItemCountAndUPC(String[] UPCToScan, String stockOrNotStocked) throws InterruptedException {
        if (stockOrNotStocked.toLowerCase().equals("stocked")) {
            mobileCommands.assertElementExists(topStockreviewpagemap.stockedList(UPCToScan.length), true);
        } else {
            mobileCommands.assertElementExists(topStockreviewpagemap.notStockedList(UPCToScan.length), true);
        }
        Set<String> reviewPageUpc = new HashSet();
        for (String upc : UPCToScan) {
            List<WebElement> upcElements = mobileCommands.elements(topStockreviewpagemap.UPCsList());
            for (WebElement upcElement : upcElements) {
                String temp1=upcElement.getText().replace("UPC", "").replace(" ", "");
                reviewPageUpc.add(temp1);
            }
            BaseUtil.scroll("down",2);
            upcElements = mobileCommands.elements(topStockreviewpagemap.UPCsList());
            String temp2=upcElements.get(upcElements.size() - 1).getText().replace("UPC", "").replace(" ", "");
            if (reviewPageUpc.contains(temp2)) {
                break;
            }
        }

        boolean upcFound = true;
        for (String upc : UPCToScan) {
            if (!reviewPageUpc.contains(upc)) {
                upcFound = false;
            }
        }
        Assert.assertTrue(upcFound);
    }

    public void validateUPCnotInStockedNotStockedTabInReviewPage(String[] UPCToScan, String stockOrNotStocked) throws InterruptedException {
        if (stockOrNotStocked.toLowerCase().equals("stocked")) {
            mobileCommands.assertElementExists(topStockreviewpagemap.stockedList(UPCToScan.length), true);
        } else {
            mobileCommands.assertElementExists(topStockreviewpagemap.notStockedList(UPCToScan.length), true);
        }
        Set<String> reviewPageUpc = new HashSet();
        for (String upc : UPCToScan) {
            List<WebElement> upcElements = mobileCommands.elements(topStockreviewpagemap.UPCsList());
            for (WebElement upcElement : upcElements) {
                String temp1=upcElement.getText().replace("UPC", "").replace(" ", "");
                reviewPageUpc.add(temp1);
            }
            BaseUtil.scroll("down",2);
            upcElements = mobileCommands.elements(topStockreviewpagemap.UPCsList());
            String temp2=upcElements.get(upcElements.size() - 1).getText().replace("UPC", "").replace(" ", "");
            if (reviewPageUpc.contains(temp2)) {
                break;
            }
        }

        boolean upcFound = true;
        for (String upc : UPCToScan) {
            if (reviewPageUpc.contains(upc)) {
                upcFound = false;
            }
        }
        Assert.assertTrue(upcFound);
    }
}
