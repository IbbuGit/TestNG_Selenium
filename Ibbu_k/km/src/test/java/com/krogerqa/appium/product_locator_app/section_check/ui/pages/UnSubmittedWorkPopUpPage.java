package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.section_check.ui.maps.UnSubmittedWorkPopUpPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class UnSubmittedWorkPopUpPage {
    MobileCommands mobileCommands = new MobileCommands();
    UnSubmittedWorkPopUpPageMap unSubmittedWorkPopUpPageMap;

    public UnSubmittedWorkPopUpPage() {
        unSubmittedWorkPopUpPageMap = new UnSubmittedWorkPopUpPageMap();
    }

    public void clickOnCancelBtn() {
        mobileCommands.click(unSubmittedWorkPopUpPageMap.cancelBtn());
    }

    public void clickOnSaveAndExitBtn() {
        mobileCommands.click(unSubmittedWorkPopUpPageMap.saveAndExitBtn());
    }

    public void waitForReviewCountScreen() {
        mobileCommands.wait(10);
    }

    public void clickOnContinueBtn() {
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.continueBtn());
        mobileCommands.click(unSubmittedWorkPopUpPageMap.continueBtn());
    }

    public void verifyUnSubmittedPopupTitle(String unSubmittedTitle) {
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.unSubmittedTitle_ScanProduct());
        mobileCommands.assertElementText(unSubmittedWorkPopUpPageMap.unSubmittedTitle_ScanProduct(), unSubmittedTitle, true);
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.eraseAndStartNewBtn());
        mobileCommands.click(unSubmittedWorkPopUpPageMap.eraseAndStartNewBtn());
    }

    public void verifyUnSubmittedPopUpMessage_Cancel(String unSubmittedTitle) {
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.unSubmittedTitle_ScanProduct());
        mobileCommands.assertElementText(unSubmittedWorkPopUpPageMap.unSubmittedTitle_ScanProduct(), unSubmittedTitle, true);
        mobileCommands.assertElementDisplayed(unSubmittedWorkPopUpPageMap.cancelBtn(), true);
        mobileCommands.click(unSubmittedWorkPopUpPageMap.cancelBtn());
    }

    public void verifyUnSubmittedPopUpMessage_SaveAndExit() {
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.unSubmittedTitle());
        mobileCommands.assertElementDisplayed(unSubmittedWorkPopUpPageMap.unSubmittedTitle(), true);
        mobileCommands.waitForElement(unSubmittedWorkPopUpPageMap.saveAndExitBtn());
        mobileCommands.click(unSubmittedWorkPopUpPageMap.saveAndExitBtn());
    }

    public void clickEraseAndStartNewBtn() {
        if (BaseUtil.isElementPresent(unSubmittedWorkPopUpPageMap.eraseAndStartNewBtn(), 3)) {
            mobileCommands.click(unSubmittedWorkPopUpPageMap.eraseAndStartNewBtn());
        }
    }
}
