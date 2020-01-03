package com.krogerqa.appium.product_locator_app.common.ui.pages;


import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.common.ui.maps.ScanProductPageMap;

import java.io.IOException;

public class ScanProductPage {
    ScanProductPageMap scanProductPageMap;
    MobileCommands mobileCommands= new MobileCommands();

    public ScanProductPage() {
        scanProductPageMap = new ScanProductPageMap();
    }

    public void waitenterUpcButtonBeforeScan(){
        mobileCommands.waitForElementClickability(scanProductPageMap.enterUpcBeforeScan());
    }

    public void waitenterUpcButtonAfterScan(){
        mobileCommands.waitForElementClickability(scanProductPageMap.enterUpcAfterScan());
    }

    public void waitForReviewButton(){
        mobileCommands.waitForElementClickability(scanProductPageMap.reviewButton());
    }

    public void scanProduct (String upc,Symbology symbology) throws IOException {
        BaseUtil.scanUPC(mobileCommands.getWebDriver(),upc, symbology);
    }

    public void clickOnBackBtn(){
        mobileCommands.click(scanProductPageMap.backBtn());
    }

    public String getUpcText(){
        return mobileCommands.getElementText(scanProductPageMap.upcText());
    }
}
