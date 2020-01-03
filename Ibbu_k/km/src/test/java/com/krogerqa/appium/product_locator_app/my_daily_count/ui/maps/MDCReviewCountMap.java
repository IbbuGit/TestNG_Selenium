package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;

public class MDCReviewCountMap {

    public By reviewPageTitle() {
        return By.xpath("//*[@text='Review Count']");
    }

    public By continueButton() {
        return By.id("btnContinue");
    }

    public By reviewButtonSubmit() {
        return By.xpath("//*[@id='btnSubmit' or @text='Finish']");
    }

    public By productCardImage() {
        return By.id("productImage");
    }

}
