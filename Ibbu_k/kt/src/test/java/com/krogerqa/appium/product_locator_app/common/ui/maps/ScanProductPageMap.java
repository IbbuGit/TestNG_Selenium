package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;

public class ScanProductPageMap {
    public By enterUpcBeforeScan() {return By.id("com.kroger.sps.mobile.qa:id/enter_upc");}

    public By enterUpcAfterScan() {return By.id("com.kroger.sps.mobile.qa:id/enter_upc_button");}

    public By reviewButton() {return By.id("com.kroger.sps.mobile.qa:id/review_button");}

    public By backBtn(){return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"] ");}

    public By upcText() {return By.id("backroomUpcText");}
}
