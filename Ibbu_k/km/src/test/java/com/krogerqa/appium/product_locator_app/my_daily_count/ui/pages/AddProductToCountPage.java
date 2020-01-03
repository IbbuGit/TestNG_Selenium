package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;


import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.AddProductToCountMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class AddProductToCountPage {

    MobileCommands mobileCommands = new MobileCommands();

    AddProductToCountMap addProductToCountMap;

    public AddProductToCountPage() {
        addProductToCountMap = new AddProductToCountMap();
    }

    public void clickAddProductButton() {
        mobileCommands.click(addProductToCountMap.addProductButton());
    }

    public void clickCancelButton() {
        mobileCommands.click(addProductToCountMap.cancelButton());
    }

    public void viewAddProductToCountPageTitle(String addProductToCount) {
        mobileCommands.assertElementText(addProductToCountMap.addProductToCountAlertTitle(), addProductToCount, true);
    }
}
