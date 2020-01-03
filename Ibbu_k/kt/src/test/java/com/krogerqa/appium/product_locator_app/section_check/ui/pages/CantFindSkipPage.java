package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.section_check.ui.maps.CantFindSkipPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class CantFindSkipPage {
    MobileCommands mobileCommands = new MobileCommands();
    CantFindSkipPageMap cantFindSkipPageMap = new CantFindSkipPageMap();

    public void clickOnFindAndScan() {
        mobileCommands.waitForElement(cantFindSkipPageMap.findAndScanHdr());
        mobileCommands.click(cantFindSkipPageMap.findAndScanHdr());
    }

    public void clickOnCantFindSkipBtn() {
        mobileCommands.waitForElement(cantFindSkipPageMap.cantFindSkipBtn());
        mobileCommands.click(cantFindSkipPageMap.cantFindSkipBtn());
    }

    public void verifyCantFindButton() {
        mobileCommands.waitForElement(cantFindSkipPageMap.cantFindSkipBtn());
        mobileCommands.assertElementDisplayed(cantFindSkipPageMap.cantFindSkipBtn(), true);
    }
}
