package com.krogerqa.appium.product_locator_app.common.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

import com.krogerqa.appium.product_locator_app.common.ui.maps.AboutPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;


public class AboutPage {
    MobileCommands mobileCommands = new MobileCommands();
    AboutPageMap aboutPageMap;
    private int wait;

    public AboutPage() {
        aboutPageMap = new AboutPageMap();
        wait = 10;
    }


    public void validateAboutPage() {
        mobileCommands.assertElementDisplayed(aboutPageMap.krogerInStockApplication(), true);
        mobileCommands.assertElementDisplayed(aboutPageMap.appVersion(), true);
        mobileCommands.assertElementDisplayed(aboutPageMap.buildDate(), true);

    }

    public void validateAboutPage_ToFail() {
        mobileCommands.assertElementDisplayed(aboutPageMap.krogerInStockApplication(), true);
    }
}

