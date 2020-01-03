package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class ReclaimMap {
    public By btnReclaim(){return By.xpath("//*[@text='Reclaim']"); }
    public By reclaimPageTitle(){ return By.xpath("//*[@text='Reclaim']");}
    public By reclaimBanner() {return By.id("title_template");}
    public By reclaimBannerText() { return By.xpath("//*[@text='Is item leaking or damaged?']");}
    public By yesButton(){ return By.xpath("//*[@text='YES']");}
    public By noButton(){ return By.xpath("//*[@text='NO']");}
    public By corpBrandPopUp(){ return By.id("title_template");}
    public By corpBrandPopUpText() { return By.xpath("//*[@text='CORP BRANDS: Markdown, Discard or Donate']");}
    public By donateRadioButton() { return By.xpath("//*[@text='Donate']");}
    public By discardRadioButton() { return By.xpath("//*[@text='Discard']");}
    public By markdownRadioButton() { return By.xpath("//*[@text='Markdown']");}
    public By continueButton() { return By.xpath("//*[@text='CONTINUE']");}
    public By cancelButton() { return By.xpath("//*[@text='CANCEL']");}
    public By reduceAndSellBanner(){ return By.id("cl_validation");}
    public By reduceAndSellText(){ return By.xpath("//*[@text='Reduce and Sell']");}
    public By alertTitle(){return By.id("com.kroger.sps.mobile.qa:id/alertTitle");}
    public By clickOk(){return By.id("android:id/button1");}
    public By textCountTitle(){return By.id("rifi_text_count_title");}

}
