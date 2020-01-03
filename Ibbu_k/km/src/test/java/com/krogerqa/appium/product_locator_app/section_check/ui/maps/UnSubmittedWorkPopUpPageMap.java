package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class UnSubmittedWorkPopUpPageMap {
    public By unSubmittedTitle(){
        return By.id("alertTitle");
    }
    public  By alertMessage(){return By.id("message");
    }
    public By cancelBtn(){
        return By.id("android:id/button2");
    }
    public By saveAndExitBtn(){
        return By.id("android:id/button1");
    }
    public By unSubmittedTitle_ScanProduct(){
        return By.xpath("//*[@text='Unsubmitted Work']");
    }

    public By eraseAndStartNewBtn(){
        return By.id("sc_erase_start");
    }
    public By continueBtn(){
        return By.xpath("//*[@text='CONTINUE']");
    }
    public By dlgUnsubmiteedWork() {
        return By.id("android:id/content");
    }
}
