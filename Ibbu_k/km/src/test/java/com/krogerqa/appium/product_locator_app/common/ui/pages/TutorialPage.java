package com.krogerqa.appium.product_locator_app.common.ui.pages;
import com.krogerqa.appium.product_locator_app.common.ui.maps.TutorialMap;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

import java.sql.SQLException;

public class TutorialPage {


    MobileCommands mobileCommands = new MobileCommands();
    TutorialMap tutorialMap;

    public TutorialPage() {
        tutorialMap = new TutorialMap();
    }

    public void clickNext(){
        mobileCommands.click(tutorialMap.nextOption());
    }

    public void clickGotIt(){
        mobileCommands.click(tutorialMap.gotItOption());
    }

    public void clickBack(){
        mobileCommands.click(tutorialMap.backOption());
    }
    public void validateFirstTutorialScreen(){
        mobileCommands.assertElementDisplayed(tutorialMap.firstScreenHeader() ,true);
    }

    public void validateSecondTutorialScreen(){
        mobileCommands.assertElementDisplayed(tutorialMap.secondScreenHeader() ,true);
    }

    public void validateThirdTutorialScreen(){
        mobileCommands.assertElementDisplayed(tutorialMap.thirdScreenHeader() ,true);
    }

    public void validateForthTutorialScreen(){
        mobileCommands.assertElementDisplayed(tutorialMap.forthScreenHeader() ,true);
    }
}
