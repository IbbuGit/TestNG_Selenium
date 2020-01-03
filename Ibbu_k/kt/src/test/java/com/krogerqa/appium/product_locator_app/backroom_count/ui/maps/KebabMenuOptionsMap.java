package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class KebabMenuOptionsMap {
    public By kebabMenu() {
        return By.xpath("//*[@content-desc='More options']");
    }

    public By backroomTutorialBtn() {
        return By.xpath("//*[@text='Backroom Tutorial']");
    }

    public By btnFAQs() {
        return By.xpath("//*[@text='FAQs']");
    }

    public By aboutBtn() {
        return By.xpath("//*[@text='About']");
    }

    public By fAQBackroomCountBtn() {
        return By.xpath("//*[@text='Backroom Count']");
    }

    public By fAQBackArrow() {
        return By.xpath("//*[@content-desc=\"Navigate up\"]");
    }

    public By nextBtn() {
        return By.id("nextTextView");
    }

}
