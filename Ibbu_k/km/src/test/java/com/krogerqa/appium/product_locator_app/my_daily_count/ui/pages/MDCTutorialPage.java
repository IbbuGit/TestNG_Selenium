package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.MDCTutorialMap;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.ThankYouMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MDCTutorialPage {


    MobileCommands mobileCommands = new MobileCommands();
    MDCTutorialMap mdc_tutorialMap;

    public MDCTutorialPage() {
        mdc_tutorialMap = new MDCTutorialMap();
    }

    public void clickNext() {
        mobileCommands.click(mdc_tutorialMap.nextOption());
    }

    public void clickGotIt() {
        mobileCommands.click(mdc_tutorialMap.gotItOption());
    }

    public void clickBack() {
        mobileCommands.click(mdc_tutorialMap.backOption());
    }

    public void validateFirstTutorialScreen() {
        mobileCommands.assertElementDisplayed(mdc_tutorialMap.firstScreenHeader(), true);
    }

    public void validateSecondTutorialScreen() {
        mobileCommands.assertElementDisplayed(mdc_tutorialMap.secondScreenHeader(), true);
    }

    public void validateThirdTutorialScreen() {
        mobileCommands.assertElementDisplayed(mdc_tutorialMap.thirdScreenHeader(), true);
    }

    public void validateForthTutorialScreen() {
        mobileCommands.assertElementDisplayed(mdc_tutorialMap.forthScreenHeader(), true);
    }


}
