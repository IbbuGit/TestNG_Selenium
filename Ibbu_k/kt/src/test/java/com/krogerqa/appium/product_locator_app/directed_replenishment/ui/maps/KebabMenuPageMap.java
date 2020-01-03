package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;

import org.openqa.selenium.By;

public class KebabMenuPageMap {
    public By kebabMenu() {
        return By.xpath("//android.widget.ImageView[@content-desc='More options']");
    }
    public By drTutorialBtn(){return By.xpath("//android.widget.TextView[@text='Directed Replenishment Tutorial']");}
    public By drFaqBtn(){return By.xpath("//*[@text='FAQs']");}
    //public By drAboutBtn(){return By.xpath("//*[@text='About']");}
    public By drSignOutBtn(){return By.xpath("//*[@text='Sign Out']");}
    public By drTutorialTitleMsg(){return By.id("titleTextView");}
    public By drTutorialDescriptionMsg(){return By.id("desTextView");}
    public By drTutorialNextBtn(){return By.id("nextTextView");}
    public By drTutorialBackBtn(){return By.id("backTextView");}
    public By drFaqBackArrow(){return By.xpath("//*[@content-desc=\"Navigate up\"]");}
    public By drTutorialGotIt(){
        return By.id("nextTextView");
    }
    public By drKebabAboutText(){return By.xpath("//*[@text='Kroger InStock Application']");}
    public By fAQDrBtn(){
        return By.xpath("//*[@text='Directed Replenishment']");
    }
    public By locateProductDRHdr(){return By.id("titleTextView"); }
    public By locateProductDRDes(){return By.id("desTextView"); }
    public By btnSignOut(){return By.xpath("//*[@text='SIGN OUT']");}
}