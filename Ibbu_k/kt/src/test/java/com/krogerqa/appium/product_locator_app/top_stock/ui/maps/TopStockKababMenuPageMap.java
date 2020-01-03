package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class TopStockKababMenuPageMap {
    public By kebabMenu() {
        return By.xpath("//*[@content-desc='More options']");
    }

    public By kebabTopStockTutorialMenu() {
        return By.xpath("//android.widget.TextView[@text='Topstock Tutorial']");
    }

    public By kebabFAQMenu() {
        return By.xpath("//*[@text='FAQs']");
    }

    public By kebabFeedbackMenu() {
        return By.xpath("//android.widget.TextView[@text='Feedback']");
    }

    public By kebabSignOutMenu() {
        return By.xpath("//android.widget.TextView[@text='Sign Out']");
    }

    public By kebabSignOutBtn() {
        return By.xpath("//*[@text='Sign Out']");
    }

    public By KebabAboutBtn() {
        return By.xpath("//*[@text='About']");
    }

    public By kebabAboutText() {
        return By.xpath("//*[@text='Kroger InStock Application']");
    }

    public By TutorialTitleMsg() {
        return By.id("titleTextView");
    }

    public By TutorialDescriptionMsg() {
        return By.id("desTextView");
    }

    public By btnNext() {
        return By.xpath("//*[@text='Next']");
    }

    public By btnBack() {
        return By.id("backTextView");
    }

    public By fAQTopStockBtn() {
        return By.xpath("//*[@text='Top Stock']");
    }

    public By fAQBackArrow() {
        return By.xpath("//*[@content-desc=\"Navigate up\"]");
    }

    public By tutorialGotIt() {
        return By.id("nextTextView");
    }
    public By scanProductOnTSHdr(){return By.id("titleTextView"); }
    public By scanProductOnTSDes(){return By.id("desTextView"); }
    public By signOutPopupHdr(){
        return By.xpath("//*[@text='Are you sure you want to exit Top Stock?");
    }
    public By signOutExitBtn(){
        return By.xpath("//*[@text='EXIT']");
    }
    public By signOutCancelBtn(){
        return By.xpath("//*[@text='CANCEL']");
    }
}
