package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.TutorialMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class TutorialPage {

    MobileCommands mobileCommands = new MobileCommands();

    TutorialMap tutorialMap;

    public TutorialPage() {
        tutorialMap = new TutorialMap();
    }

    public void validateScanProductText(String scanProductMsg){
        mobileCommands.assertElementText(tutorialMap.screenTitleMsg(),scanProductMsg,true);
    }

    public void validateAndClickNext(){
        mobileCommands.assertElementDisplayed(tutorialMap.navigateNext(),true);
        mobileCommands.click(tutorialMap.navigateNext());
    }

    public void validateAndClickBack(){
        mobileCommands.assertElementDisplayed(tutorialMap.navigateBack(),true);
        mobileCommands.click(tutorialMap.navigateBack());
    }

    public void validateUpdateOrderText(String updateOrder){
        mobileCommands.assertElementText(tutorialMap.screenTitleMsg(),updateOrder,true);
    }

    public void validateConfirmOrder(String confirmOrder){
        mobileCommands.assertElementText(tutorialMap.screenTitleMsg(),confirmOrder,true);
    }
}
