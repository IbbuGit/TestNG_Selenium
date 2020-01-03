package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;

public class AddProductToCountMap {
    public By addProductToCountAlertTitle() {
        return By.id("alertTitle");
    }

    public By addFreeScanProductDialogueMessage() {
        return By.id("message");
    }

    public By addProductButton() {
        return By.xpath("//*[@text='ADD PRODUCT']");
    }

    public By cancelButton() {
        return By.xpath("//*[@text='CANCEL']");
    }

}
