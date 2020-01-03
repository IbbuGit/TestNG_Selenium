package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.PendingPopPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class PendingPopPage extends Base{

    MobileCommands mobileCommands = new MobileCommands();
    ScanProductPage scanProductPage;
    PendingPopPageMap pendingPopPageMap;

    public PendingPopPage() {  pendingPopPageMap = new  PendingPopPageMap(); }

    public void validatePendingPopTitle(String PendingPopTitle){
        mobileCommands.assertElementText(pendingPopPageMap.textPendingPopTitle(),PendingPopTitle,true);
    }

    public void validateUnsuccessfulMsg(String UnsuccessfulMsg){
        mobileCommands.assertElementText(pendingPopPageMap.unsuccessful_Msg(),UnsuccessfulMsg,true);
    }

    public void validateSuccessfulMsg(String SuccessfulMsg){
        mobileCommands.assertElementText(pendingPopPageMap.successful_Msg(),SuccessfulMsg,true);
    }

    public void validatePendingMsg(String PendingMsg){
        mobileCommands.assertElementText(pendingPopPageMap.pending_Msg(),PendingMsg,true);
    }

    public void validateAndClickViewDetails(String ViewDetailsText){
        mobileCommands.assertElementText(pendingPopPageMap.dialog_ViewDetails_Btn(),ViewDetailsText,true);
        mobileCommands.click(pendingPopPageMap.dialog_ViewDetails_Btn());
    }

    public void validateContinue(String ContinueText){
        mobileCommands.assertElementText(pendingPopPageMap.dialog_Continue_Btn(),ContinueText,true);
    }

    public void validateAndClickMainMenu(String MainMenuText){
        mobileCommands.assertElementText(pendingPopPageMap.dialog_MainMenu_Btn(),MainMenuText,true);
        mobileCommands.click(pendingPopPageMap.dialog_MainMenu_Btn());
    }

    public void validateTextDisclaimer(){
        mobileCommands.assertElementDisplayed(pendingPopPageMap.textDisclaimer(),true);
    }

}
