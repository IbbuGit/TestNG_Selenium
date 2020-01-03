package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;


public class MDCCountProductMap {
    public By countProductPageTitle() {
        return By.xpath("//*[@text='Count Product']");
    }

    public By enterQuantityTextField() {
        return By.id("my_count_edit_text_field");
    }

    public By countSubmitBtn() {
        return By.xpath("//*[@id='done_button_count_entry' or @text='Submit']");
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

    public By upcOnCountProductScreen() {
        return By.id("upcText");
    }

    public By productDescriptionOnCountProductScreen() {
        return By.id("descText");
    }

    public By productPrice() {
        return By.id("priceActual");
    }

    public By unitCountText() {
        return By.id("unit_count");
    }

    public By alertMessage() {
        return By.id("alert_message");
    }

    public By inLineErrorMessage() {
        return By.id("tv_error_message");
    }

    public By caseSize() {
        return By.xpath("//*[@text='Case Size:']");
    }

    public By snackBarText() {
        return By.id("snackbar_text");
    }

    public By alertTitle() {
        return By.id("alertTitle");
    }

    public By tryAgainButton() {
        return By.xpath("//*[@text='TRY AGAIN']");
    }

    public By exitTaskButton() {
        return By.xpath("//*[@text='EXIT TASK']");
    }

    public By alertButton() {
        return By.id("button1");
    }

    public By otherAlertTitle() {
        return By.id("other_upc_error_layout");
    }


}
