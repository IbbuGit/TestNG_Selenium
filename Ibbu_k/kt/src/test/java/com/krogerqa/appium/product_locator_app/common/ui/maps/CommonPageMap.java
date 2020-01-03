package com.krogerqa.appium.product_locator_app.common.ui.maps;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class CommonPageMap {

    public By kebabMenu() {
        return By.xpath("//android.widget.ImageView[@content-desc='More options']");
    }

    public By kebabMenuList() {
        return By.id("title");
    }

    public By faqPageTitle() {
        return By.xpath("//*[@text='FAQs']");
    }

    public By faqMDC() {
        return By.xpath("//*[@text='MDC']");
    }

    public By faqBackroomCount() {
        return By.xpath("//*[@text='Backroom Count']");
    }
    public By toastMessage() {
        return By.id("snackbar_text");
    }

    public By faqLayout() {
        return By.xpath("//*[@text='FAQs']");
    }

    public By faqMDCOption() {
        return By.xpath("//*[@text='My Daily Count']");
    }

    public By faqMDCHeading() {
        return By.xpath("//*[@text='My Daily Count']");
    }

    public By about() {
        return By.xpath("//android.widget.TextView[@text='About']");
    }

    public By mdcTutorial() {
        return By.xpath("//*[@text='MDC Tutorial']");
    }

    public By feedback() {
        return By.xpath("//*[@text='Feedback']");
    }

    public By backButton() {
        return By.xpath("//android.widget.ImageButton");
    }

    public By removeButton() {
        return By.id("button1");
    }

    public By transferError() {
        return By.xpath("//*[@text='Transfer Error']");
    }

    public By okayButton() {
        return By.id("button1");
    }

    public By errorMessage() {
        return By.id("snackbar_text");
    }

    public By backArrow() {
        return By.xpath("//android.widget.ImageButton[@index='0']");
    }

    public By btnBackArrow() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

    public By loadDeptList() {
        return By.xpath("//*[@text='Loading the department list']");
    }
}