package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.section_check.ui.maps.ScanNextProductPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class ScanNextProductPage {
    MobileCommands mobileCommands = new MobileCommands();
    ScanNextProductPageMap scanNextProductPageMap;

    public ScanNextProductPage() {
        scanNextProductPageMap = new ScanNextProductPageMap();
    }

    public void clickOnReviewBtn() {
        mobileCommands.waitForElement(scanNextProductPageMap.reviewBtn());
        mobileCommands.click(scanNextProductPageMap.reviewBtn());
    }

    public void clickOnEnterUPCBtn() {
        mobileCommands.waitForElement(scanNextProductPageMap.enterUPCBtn());
        mobileCommands.click(scanNextProductPageMap.enterUPCBtn());
    }

    public void verifyPageTitle(String scanNextProductScreen) {
        mobileCommands.waitForElement(scanNextProductPageMap.screenHdr());
        mobileCommands.assertElementText(scanNextProductPageMap.screenHdr(), scanNextProductScreen, true);
    }

    public void clickOnBackArrow() {
        mobileCommands.waitForElement(scanNextProductPageMap.backBtn());
        mobileCommands.click(scanNextProductPageMap.backBtn());
    }
}
