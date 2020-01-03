package com.krogerqa.appium.product_locator_app.common.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.common.ui.maps.LogInMap;
import com.krogerqa.appium.product_locator_app.common.utils.EncryptDecryptUtil;

import java.sql.SQLException;

public class LogInPage {
    MobileCommands mobileCommands= new MobileCommands();
    LogInMap loginMap;


    public LogInPage() {
        loginMap = new LogInMap();
    }

    public void enterUserID(String userName) {
        mobileCommands.enterText(loginMap.userIDField(),userName,false);
    }


    public void enterPassword(String password) throws Throwable {
        mobileCommands.enterText(loginMap.passwordField(), EncryptDecryptUtil.decrypt(password),false);
    }

    public void clickSignInButton() {
        mobileCommands.click(loginMap.signInButton());
    }

    public void validateSecureWEBPageTitle() {
        mobileCommands.assertElementDisplayed(loginMap.secureWEBPageTitle(),true);
    }

    public void validateInvalidCredentials(){
        mobileCommands.assertElementDisplayed(loginMap.wrongCredentials(),true);
    }

    public void verifyEnterUserID() {
        mobileCommands.assertElementDisplayed(loginMap.userIDField(),true);
    }

    public void verifyPassword() {
        mobileCommands.assertElementDisplayed(loginMap.passwordField(),true);
    }

    public void verifySignInButton() {
        mobileCommands.assertElementDisplayed(loginMap.signInButton(),true);
    }




    public void login(String username,String password) throws Throwable {
        enterUserID(username);
        enterPassword(password);
        clickSignInButton();
    }

}