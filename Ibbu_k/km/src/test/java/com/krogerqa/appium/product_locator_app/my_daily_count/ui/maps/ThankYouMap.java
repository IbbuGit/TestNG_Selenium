package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;

public class ThankYouMap {
    public By thankYouPageTitle() {
        return By.xpath("//*[@text='Count Submitted']");
    }

    public By successImage() {
        return By.id("success_image");
    }

    public By successMessage() {
        return By.id("text_completed_count");
    }

    public By scannedProducts() {
        return By.id("text_number_of_products_completed");
    }

    public By countText() {
        return By.id("text_count");
    }

    public By backToMainMenu() {
        return By.id("button_navigate_to_main_menu");
    }


}
