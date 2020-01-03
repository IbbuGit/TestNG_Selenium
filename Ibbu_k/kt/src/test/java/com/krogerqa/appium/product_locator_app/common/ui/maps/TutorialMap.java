package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;

public class TutorialMap {

    public By firstScreenHeader() { return By.xpath("//*[@text='Find and Scan Product']"); }

    public By secondScreenHeader() {
        return By.xpath("//*[@text='or Scan Items of Interest']");
    }

    public By thirdScreenHeader() {
        return By.xpath("//*[@text='Count Products on Shelf']");
    }

    public By forthScreenHeader() {
        return By.xpath("//*[@text='Submit Your Count']");
    }

    public By nextOption() {
        return By.xpath("//*[@text='Next']");
    }

    public By backOption() {
        return By.xpath("//*[@text='Back']");
    }

    public By gotItOption() {
        return By.xpath("//*[@text='Got it!']");
    }

}
