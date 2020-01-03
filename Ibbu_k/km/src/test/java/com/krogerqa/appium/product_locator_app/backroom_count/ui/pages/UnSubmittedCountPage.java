package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.UnSubmittedCountMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebDriver;

public class UnSubmittedCountPage {
    MobileCommands mobileCommands = new MobileCommands();
    UnSubmittedCountMap unSubmittedCountMap = new UnSubmittedCountMap();

    public void validateUnSubmittedTitle() {
        mobileCommands.assertElementDisplayed(unSubmittedCountMap.alertTitle(), true);
        mobileCommands.assertElementDisplayed(unSubmittedCountMap.alertMessage(), true);
    }

    public void ValidateAndClickUnsubmittedLeaveBtn() {
        mobileCommands.click(unSubmittedCountMap.btnLeave());
    }

    public void ValidateAndClickUnsubmittedCancelBtn() {
        mobileCommands.click(unSubmittedCountMap.btnCancel());
    }

    public void clickNewCount() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        WebDriver driver = mobileCommands.getWebDriver();

        if ((driver.findElements(unSubmittedCountMap.btnNewCount()).size() > 0)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());

        }
    }

    public void clickUnSubmittedContinueBtn() {
        mobileCommands.click(unSubmittedCountMap.btnContinue());
    }

}
