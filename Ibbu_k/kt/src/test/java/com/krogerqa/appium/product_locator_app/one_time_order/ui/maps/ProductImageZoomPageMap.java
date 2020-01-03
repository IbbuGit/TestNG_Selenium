/*
 * Description :-To verify the Zoom of the product Image
 * ALM Test case id:-2708
 * Created by :-SYL7525 (Ragupathi.D)
 * Created Date :- 24th June 2019
 */

package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;
import org.openqa.selenium.By;

public class ProductImageZoomPageMap {
    public By productZoomedImage() {return By.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]");}
    public By productCancelBtn() {return By.xpath("//android.widget.ImageView[@content-desc=\"Close image imageview\"]");}
    public By orderAddBtn() {return By.id("com.kroger.sps.mobile.debug:id/update_order");}

}