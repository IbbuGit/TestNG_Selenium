package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;

public class LogOutPageMap{
    public By unSubmittedTransferAlertTitle() {return By.id("alertTitle");}
    public By logOut() {return By.xpath("//android.widget.TextView[@text='Log Out']");}
    public By signOutButton() {return By.xpath("//android.widget.TextView[contains(@text,'Sign')]");}
    public By signOutDialog() {return By.id("android:id/parentPanel");}
    public By signOutDialogExit() {return By.id("android:id/button1");}
}