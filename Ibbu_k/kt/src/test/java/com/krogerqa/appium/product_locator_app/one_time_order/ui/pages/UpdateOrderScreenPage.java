package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.UpdateOrderScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;


public class UpdateOrderScreenPage {
    MobileCommands mobileCommands = new MobileCommands();
    UpdateOrderScreenPageMap updateOrderScreen;
    public UpdateOrderScreenPage() {
        updateOrderScreen = new UpdateOrderScreenPageMap();
    }

    public void navigateBack(){ mobileCommands.click(updateOrderScreen.backBtn()); }

    public void validateUpdateOrderHeaderTxt(String UpdateOrderHeaderText) {
        mobileCommands.assertElementText(updateOrderScreen.updateOrderHeader(),UpdateOrderHeaderText,true);
    }
    public void validateAndClickCancelXBtn() {
        mobileCommands.assertElementDisplayed(updateOrderScreen.cancelXButton(),true);
        mobileCommands.click(updateOrderScreen.cancelXButton());
    }
    public void validateUpcTxt(String UpdateorderscreenUpcText) {
        mobileCommands.assertElementText(updateOrderScreen.backRoomUpcTxt(),UpdateorderscreenUpcText,true);
    }

    public void validateUpdateOrderTitle(String titleUpdateOrder) {
        mobileCommands.assertElementText(updateOrderScreen.updateOrderHeader(),titleUpdateOrder,true);
    }

    public void validateProductName(String ProductName) {
        mobileCommands.assertElementText(updateOrderScreen.textProductName(),ProductName,true);
    }

    public void validateAndClickAddToOrderBtn(String lblAddOrderButton) {
        mobileCommands.assertElementText(updateOrderScreen.addBtnOrder(),lblAddOrderButton,true);
        mobileCommands.click(updateOrderScreen.addBtnOrder());
    }

    public void clickAddToOrder(){
        mobileCommands.click(updateOrderScreen.addBtnOrder());
    }

    public void validateAndClickCancelBtn() {
        mobileCommands.click(updateOrderScreen.cancelBtn());
    }
    public void clickStepperPlus() {
        mobileCommands.click(updateOrderScreen.textCaseStepperPlus());
    }
    public void clickStepperMinus() {
        mobileCommands.click(updateOrderScreen.textCaseStepperMinus());
    }

    public void validateProductCountPlus(String caseCountPlus) {
        mobileCommands.assertElementText(updateOrderScreen.textProductCaseEditBox(), caseCountPlus,true);
    }
    public void validateProductCountMinus(String caseCountMinus) {
        mobileCommands.assertElementText(updateOrderScreen.textProductCaseEditBox(), caseCountMinus,true);
    }

    public void clickCasesTextBox(){
        mobileCommands.click(updateOrderScreen.textProductCaseEditBox());
    }

    public void enterValueInCase(String  CasesValue) throws InterruptedException {
        Thread.sleep(5000);
        mobileCommands.waitForElement(updateOrderScreen.textCaseStepperPlus());
        mobileCommands.enterText(updateOrderScreen.textProductCaseEditBox(),CasesValue,true);
    }

    public void enterValueInEnlargedCase(String caseValue){
        mobileCommands.waitForElement(updateOrderScreen.textEnlargedCaseEditBox());
        mobileCommands.enterText(updateOrderScreen.textEnlargedCaseEditBox(),caseValue,true);
    }

    public void validateErrorMsg(String errorMsg){
        mobileCommands.assertElementText(updateOrderScreen.textThresholdErrorMsg(),errorMsg,true);
    }

    public void validateAndClickRemoveOrder(String lblRemoveBtn){
        mobileCommands.assertElementText(updateOrderScreen.removeBtn(),lblRemoveBtn,true);
        mobileCommands.click(updateOrderScreen.removeBtn());
    }

    public void validateOrderOverLimitTitle(String titleOrderOverLimit) {
        mobileCommands.assertElementText(updateOrderScreen.titleOrderOverLimit(), titleOrderOverLimit, true);
    }

    public void validateOrderOverLimitMsg(String msgOrderOverLimit) {
        mobileCommands.assertElementText(updateOrderScreen.msgOrderOverLimit(), msgOrderOverLimit, true);
    }

    public void clickCancel() {
        mobileCommands.waitForElement(updateOrderScreen.btnCancel());
        mobileCommands.click(updateOrderScreen.btnCancel());
    }

    public void clickContinue() {
        mobileCommands.waitForElement(updateOrderScreen.btnContinue());
        mobileCommands.click(updateOrderScreen.btnContinue());
    }

    public void clickRemove() {
        mobileCommands.waitForElement(updateOrderScreen.btnRemove());
        mobileCommands.click(updateOrderScreen.btnRemove());
    }
    public int getRandomInteger(int max, int min){
        return((int)(Math.random()*(max-min)))+min;
    }
    public void clickAddToOrderBtn() {
        mobileCommands.click(updateOrderScreen.addBtnOrder());
    }
    public String getUpcOnTheScreen(){
       return mobileCommands.element(updateOrderScreen.backRoomUpcTxt()).getText();
    }
}