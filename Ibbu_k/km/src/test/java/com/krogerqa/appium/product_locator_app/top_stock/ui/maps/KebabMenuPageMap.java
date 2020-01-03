package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class KebabMenuPageMap {
    public By kebabMenu() {
        return By.xpath("//*[@content-desc='More options']");
    }

    public By topStockTutorialBtn() {
        return By.xpath("//*[@text='Topstock Tutorial']");
    }

    public By fAQBtn() {
        return By.xpath("//*[@text='FAQ']");
    }

    public By aboutBtn() {
        return By.xpath("//*[@text='About']");
    }

    public By signOutBtn() {
        return By.xpath("//*[@text='Sign Out']");
    }

    public By tutorialTitleMsg() {
        return By.id("titleTextView");
    }

    public By tutorialDescriptionMsg() {
        return By.id("desTextView");
    }

    public By nextBtn() {
        return By.id("nextTextView");
    }

    public By backBtn() {
        return By.id("backTextView");
    }

    public By fAQTopStockBtn() {
        return By.xpath("//*[@text='Top Stock']");
    }

    public By fAQBackArrow() {
        return By.xpath("//*[@content-desc=\"Navigate up\"]");
    }

}
