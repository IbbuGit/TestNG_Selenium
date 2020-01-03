package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import org.openqa.selenium.By;


/**
 * Class Name : ScanProduct PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class ScanProductDRPageMap {

    public By txtFindAndScanProduct() { return By.id("textview_scan_product");}
    public By headerScanProduct() {return By.xpath("//android.widget.TextView[@text='Scan Product']"); }
    public By txtDrUPC() { return By.id("drUpcText");}
    public By imgScanBG() { return By.id("image_scan_bg");}
    public By btnCantFindAndSkip() {//return By.xpath("//*[@text='CAN'T FIND, SKIP?']");
        return By.id("textview_cant_find_skip");
    }
    public By networkErrorMsg(){
        return By.xpath("//*[@text='Network is not available']");
    }
    public By networkErrorMsgWhenClickDR(){
        return By.xpath("//*[@text='Network Unavailable']");
    }
}