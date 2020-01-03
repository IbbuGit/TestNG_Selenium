package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;
import org.openqa.selenium.By;

public class OrderUpdatedScreenPageMap {
    public By txtOrderUpdate() {return By.xpath("//*/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");}
    //public By txtBackArrow() {return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    //public By txtOrderScanImg() {return By.id("scan_bg_image");}
    //public By signOut() {return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");}
    public By txtScanProduct() {return By.id("scan_item");}
    public By btnEnterUpc() {return By.xpath("//android.widget.Button[@text='ENTER UPC']");}
    public By btnReviewUpc() {return By.id("review_button");}
    public By orderInProgressDialogContinueBtn () {return By.xpath("//android.widget.Button[@text='CONTINUE']");}}