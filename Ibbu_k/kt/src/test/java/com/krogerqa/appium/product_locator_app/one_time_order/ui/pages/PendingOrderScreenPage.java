package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.PendingOrderScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class PendingOrderScreenPage {

    MobileCommands mobileCommands = new MobileCommands();
    PendingOrderScreenPageMap pendingOrderScreenPageMap;

    public PendingOrderScreenPage() {
        pendingOrderScreenPageMap = new PendingOrderScreenPageMap();
    }

    public void validatePendingOrderHeader(String pendingOrderHeader){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.pendingOrderHeader(), pendingOrderHeader,true);
    }

    public void validateAndClickXBtn(){
        mobileCommands.assertElementDisplayed(pendingOrderScreenPageMap.cancelXButton(),true);
        mobileCommands.click(pendingOrderScreenPageMap.cancelXButton());
    }

    public void validatePlacedDateAndTime(String dateAndTime){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.pendingDate(),dateAndTime,true);
    }

    public void validatePendingMsg(String pendingMsg){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.pendingProductsMsg(),pendingMsg,true);
    }

    public void validatePendingCatHeader(String pendingCat){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.pendingCatHeader(),pendingCat,true);
    }

    public void validateAndClickMainMenuBtn(String mainMenu){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.mainMenuBtn(),mainMenu,true);
        mobileCommands.click(pendingOrderScreenPageMap.mainMenuBtn());
    }

    public void validateAndClickContinueBtn(String continueTxt){
        mobileCommands.assertElementText(pendingOrderScreenPageMap.continueBtn(),continueTxt,true);
        mobileCommands.click(pendingOrderScreenPageMap.continueBtn());
    }


}
