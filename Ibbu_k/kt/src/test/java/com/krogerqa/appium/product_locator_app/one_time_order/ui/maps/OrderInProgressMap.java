package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;

import org.openqa.selenium.By;

public class OrderInProgressMap {
    public By titleOrderInProgress(){return By.id("alertTitle");}
    //public By msgOrderInProgress() {return By.id("message");}
    public By msgOrderInProgress() {return By.xpath("//android.widget.TextView[@resource-id='android:id/message']");}
    public By btnNewOrder(){return By.xpath("//android.widget.Button[@text= 'NEW ORDER']");}
    public By btnContinue(){return By.xpath("//android.widget.Button[@text= 'CONTINUE']");}
}
