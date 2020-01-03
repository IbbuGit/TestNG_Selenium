package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;
import org.openqa.selenium.By;

public class ThankYouScreenPageMap {
    //public By kebabMenu() {return By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");}
    public By orderSummary() {return By.xpath("//android.widget.TextView[@text='Order Summary']");}
    public By textThankYou() {return By.id("thank_you_text_view");}
    public By textSubmitted() {return By.id("order_submitted_text_view");}
    //public By catalogDisplay(){return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ExpandableListView/android.view.ViewGroup[2]/android.widget.TextView[1]");}
    public By mainMenuBtn(){return By.id("button_backtomain_menu");}
    public By successMessage(){return By.id("success_message_text_view");}
    public By unsuccessHeader(){return By.id("header");}
    public By unsuccessUPC(){return By.id("upcText");}
    public By pendingHeader(){return By.xpath("//*/android.view.ViewGroup[4]/android.widget.TextView[1]");}
    public By pendingUPC(){return By.xpath("//android.widget.TextView[1][@text='0001111000120']");}
    public By productCount(){ return By.id("product_count_text_view");}
    public By prodCase(){ return By.id("caseNumberText");}
}
