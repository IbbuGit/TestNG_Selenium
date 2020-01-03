package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;

import org.openqa.selenium.By;

public class PendingOrderScreenPageMap {

    public By pendingOrderHeader(){return By.xpath("//android.widget.TextView[@text='Pending Order Update']");}
    public By cancelXButton() {return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    public By pendingDate(){return By.id("pending_date_text_view");}
    public By pendingProductsMsg(){return By.id("text_pending");}
    public By pendingCatHeader(){return By.id("header");}
    public By mainMenuBtn(){return By.id("scan_upc_button");}
    public By continueBtn(){return By.id("confirm_button");}
}
