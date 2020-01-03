package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class EnterAmountMap {

    public By enterAmountTitle(){return By.xpath("//*[@text='Enter Amount']");}
    public By deleteIcon() {return By.xpath("//android.widget.TextView[@content-desc='Delete']");}
    public By upcIdOnAmountScreen() {return By.id("rifi_upcText");}
    public By upcDescriptionOnAmountScreen() {return By.id("rifi_desc_Text");}
    public By caseSize() { return By.id("case_size");}
    public By countTextBox() { return By.id("stepperNumberBox");}
    public By countPlusSign() { return By.id("stepperPlus");}
    public By countMinusSign() { return By.id("stepperMinus");}
    public By unitsDescription() { return By.id("textAmountValidationMessage"); }
    public By addMoreOnAmountScreen() { return By.id("enter_upc_button");}
    public By reviewIcon() { return By.id("submit_button");}
    public By amountEditText() { return By.id("dialog_edit_text");}
    public By upcDescriptionOnReviewScreen() { return By.id("itemDetailsText");}
    public By submitButton() { return By.id("submit_button");}
    public By backToMainMenu() {return By.id("back_to_main_menu_button");}
    public By caseCount() { return By.id("case_count");}
    public By exitAlertTitle(){ return By.xpath("//*[@text='Exit Without Submitting?']");}
    public By exitAlertMessage(){ return By.xpath("//*[@text='You have unsubmitted work. Your work will not be saved.']"); }
    public By cancelExitPopUp(){ return By.xpath("//*[@text='CANCEL']");}
    public By continueExitPopUp(){ return By.xpath("//*[@text='CONTINUE']");}
    public By messageTitle(){return By.id("tv_message_title");}
    public By secondChanceYesButton(){return By.id("android:id/button2");}
    public By secondChanceNoButton(){return By.id("android:id/button1");}
    public By alertTitle(){return By.id("alertTitle");}
    public By corpBrandDonate(){return By.xpath("//android.widget.CheckedTextView[@text='Donate']");}
    public By corpBrandDiscard(){return By.xpath("//*[@text='Discard']");}
    public By corpBrandMarkdown(){return By.xpath("//*[@text='Markdown']");}
    public By productCardDeleteIcon() {return By.id("removeText");}
    public By removeProductHeader(){ return By.xpath("//*[@text='Remove Product']");}
    public By closeInEnterAmountScreen() {return By.xpath("//*[@content-desc='Navigate up']"); }
}

