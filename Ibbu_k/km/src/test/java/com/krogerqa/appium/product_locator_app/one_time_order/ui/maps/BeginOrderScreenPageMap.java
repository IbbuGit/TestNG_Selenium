package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;

import org.openqa.selenium.By;

public class BeginOrderScreenPageMap {
    public By textBeginOrder() {return By.xpath("//*/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");}
    public By scanProductMsg() {return By.id("scan_item");}
    //public By btnEnterUPC () {return By.id("enter_upc_button");}
    public By btnEnterUPC () {return By.xpath("//android.widget.Button[@text='ENTER UPC']");}
    public By dsdMsg(){return By.id("snackbar_text");}
    public By unauthorizedMsg(){return By.id("dsdunauthtextView");}
    public By magicMsg(){return By.id("dsdunauthtextView");}
    public By Faq(){return By.xpath("//android.widget.TextView[@text='FAQs']");}
    public By exitOrder(){return By.xpath("//android.widget.TextView[@text='Exit Order']");}
    public By tutorial(){return By.xpath("//android.widget.TextView[@text='Tutorial']");}
    //Pending Products Status Dialog if order is pending
    public By dialogTitlePending () {return By.id("text_title");}
    public By dialogTxtPending () {return By.id("text_pending");}
    public By dialogDisclaimerMsg () {return By.id("disclaimer_message");}
    public By btnDialogMainMenu () {return By.id("text_negative_caption");}
    public By btnDialogViewDetails () {return By.id("text_positive_caption");}
    //Pending Products Status Dialog if order is unsuccessful
    public By dialogTitleUnsuccessful () {return By.id("text_title");}
    public By dialogTxtUnsuccessful () {return By.id("text_unsuccessful");}
    public By btnDialogContinue () {return By.id("text_negative_caption");}
    public By btnUnsucessfulDialogViewDetails () {return By.id("text_positive_caption");}
    public By oneTimeOrder(){ return By.xpath("//android.widget.TextView[@text= 'One-Time Order']");}

}