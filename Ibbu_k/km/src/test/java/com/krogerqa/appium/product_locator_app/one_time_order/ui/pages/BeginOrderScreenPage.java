package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.BeginOrderScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

import java.util.HashMap;

public class BeginOrderScreenPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private BeginOrderScreenPageMap beginOrderPageMap;
    private CommonPageMap commonPageMap;

    public BeginOrderScreenPage() {
        beginOrderPageMap = new BeginOrderScreenPageMap();
        commonPageMap = new CommonPageMap();
    }

    public void validateBeginOrderTitle() {
        mobileCommands.assertElementDisplayed(beginOrderPageMap.textBeginOrder(), true);
    }

    public void validateBeginOrderMsg(String msgBeginOrder) {
        mobileCommands.assertElementText(beginOrderPageMap.scanProductMsg(),msgBeginOrder, true);
    }

    public void validateAndClickEnterUPCButton(String lblEnterUPC) {
        mobileCommands.assertElementText(beginOrderPageMap.btnEnterUPC(), lblEnterUPC, true);
        mobileCommands.click(beginOrderPageMap.btnEnterUPC());
    }
    public void ValidateAndClickFaq(){
        mobileCommands.assertElementDisplayed(beginOrderPageMap.Faq(),true);
        mobileCommands.click(beginOrderPageMap.Faq());
    }

    public void validateAndClickExitOrder(){
        mobileCommands.assertElementDisplayed(beginOrderPageMap.exitOrder(),true);
        mobileCommands.click(beginOrderPageMap.exitOrder());
    }

    public void validateAndClickTutorial(){
        mobileCommands.assertElementDisplayed(beginOrderPageMap.tutorial(),true);
        mobileCommands.click(beginOrderPageMap.tutorial());
    }
    public void clickKebabMenu() {
        new CommonPage().clickKebabMenu();
    }
    public void validateDSDMsg(String lblDSDMsg){
        //mobileCommands.assertElementDisplayed(beginOrderPageMap.dsdMsg(),true);
        mobileCommands.assertElementText(beginOrderPageMap.dsdMsg(),lblDSDMsg,true);
    }
    public void validateMagicMsg(String lblMagic){
        mobileCommands.assertElementText(beginOrderPageMap.magicMsg(),lblMagic,true);
    }
    public void validateUnauthorisedMsg(String lblUnauthorizedMsg){
        mobileCommands.assertElementText(beginOrderPageMap.unauthorizedMsg(), lblUnauthorizedMsg,true);
    }
    public void clickEnterUPCButton() {
        mobileCommands.click(beginOrderPageMap.btnEnterUPC());
    }
    //when the order is pending and the next session will get a popup
    /*public void clickDialogViewDetails(){
        try{
            if(mobileCommands.elements(beginOrderPageMap.btnDialogViewDetails()).size()>0){
                mobileCommands.click(beginOrderPageMap.btnDialogViewDetails());
            }
        }catch(Exception e){

        }

    }*/
    //when the order is unsuccessful and the next session will get the pop up
    /*public void clickContinueUnsuccessful(){
        try{
            if(mobileCommands.elements(beginOrderPageMap.btnDialogContinue()).size()>0){
                mobileCommands.click(beginOrderPageMap.btnDialogContinue());
            }
        }catch(Exception e){

        }
    }*/
    public void clickOneTimeOrder(){
        mobileCommands.click(beginOrderPageMap.oneTimeOrder());
    }
    public void validateScannedReviewedProducts(HashMap<String,String> a, HashMap<String,String> b){
        Assert.assertTrue(a.equals(b),"Comparing scanned and reviewed products");
    }
    public void waitForTheScanPage(){
        mobileCommands.waitForElement(beginOrderPageMap.textBeginOrder());
    }
}