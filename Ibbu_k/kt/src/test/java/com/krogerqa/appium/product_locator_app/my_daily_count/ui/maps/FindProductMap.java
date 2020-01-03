package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;

public class FindProductMap {
    public By findProductPageTitle() {
        return By.xpath("//*[@text='Find Product']");
    }

    public By progerssBar() {
        return By.id("progress_bar");
    }

    public By countStatus() {
        return By.id("steps_count");
    }

    public By gotoText() {
        return By.id("goto_Text");
    }

    public By findAndScanText() {
        return By.xpath("//*[@text='Find and Scan']");
    }

    public By upc() {
        return By.id("upcText");
    }

    public By productDescription() {
        return By.id("descText");
    }

    public By productPrice() {
        return By.id("priceActual");
    }

    public By enterUPCButton() {
        return By.id("enter_upc_temp");
    }

    public By manualUPCTextField() {
        return By.id("manual_upc_entry_edit_text");
    }

    public By manualUPCSubmitBtn() {
        return By.id("manual_upc_entry_submit_button");
    }

    public By cantFindButton() {
        return By.id("cant_find_button");
    }

    public By skipButton() {
        return By.id("mdc_skip_button");
    }

    public By reviewButton() {
        return By.id("mdc_review_button");
    }

    public By imageIcon() {
        return By.xpath("//*[@id='image_thumbnail_mdc' or @content-desc='image of product']");
    }

    public By enlargedImage() {
        return By.id("image_view");
    }

    public By closeImage() {
        return By.xpath("//*[@id='close_image' or @content-desc='Close image imageview']");
    }
}
