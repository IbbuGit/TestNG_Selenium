package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class ThankyouBRCPageMap {

    public By btnMainMenu() {
        return By.id("main_menu_button");
    }

    public By headerThankyou() {
        return By.xpath("//android.widget.TextView[@text='Count Submitted']");
    }

    public By txtThankyou() {
        return By.id("thank_you_tv");
    }

    public By btnStartAnotherCount() {
        return By.id("start_another_count_text_view");
    }

    public By lblProductsCounted() {
        return By.id("text_view_products");
    }

    public By beginMyDailyCountButton() {
        return By.id("mdc_button");
    }

    public By spinner() {
        return By.xpath("(//*[@class='android.widget.ProgressBar'])[1]");
    }

}
