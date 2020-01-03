package com.krogerqa.appium.product_locator_app.common.ui.maps;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class LogInMap {
    public By userIDField() {return MobileBy.id("login_username");}
    public By passwordField() {return MobileBy.id("login_password");}
    public By signInButton() {return MobileBy.id("login_submit");}
    public By secureWEBPageTitle() {return By.xpath("//*[@id='footers' or contains(@text,'By proceeding')]");}
    public By wrongCredentials() {return By.xpath("//*[@text='Wrong Credentials' or @text='Network Failure']");}
}