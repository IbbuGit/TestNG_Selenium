package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class TopStockSessionInProgressMap {
    public By sessionInProgressHdr(){
        return By.id("session_in_progress");
    }
    public By continueSession() {
        return By.xpath("//*[@text='CONTINUE']");
    }

    public By newSession() {
        return By.xpath("//*[@text='NEW SESSION']");
    }
    public By SessionPopupTitle(){
        return By.id("session_description");
    }
    public By cancel() {
        return By.xpath("//*[@text='CANCEL']");
    }

    public By exit() {
        return By.xpath("//*[@text='EXIT']");
    }
}
