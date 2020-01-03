package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;


/**
 * Class Name : TransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class AboutPageMap{

    public By krogerInStockApplication() {return By.xpath("//android.widget.TextView[@text='Kroger InStock Application']");}
    public By appVersion() {return By.xpath("//android.widget.TextView[@text='App Version:']");}
    public By buildDate() {return By.xpath("//android.widget.TextView[@text='Build Date:']");}

}