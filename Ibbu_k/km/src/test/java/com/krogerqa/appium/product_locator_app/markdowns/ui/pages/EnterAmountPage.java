package com.krogerqa.appium.product_locator_app.markdowns.ui.pages;

import com.krogerqa.appium.product_locator_app.markdowns.ui.maps.EnterAmountPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class EnterAmountPage {

    MobileCommands mobileCommands = new MobileCommands();

    EnterAmountPageMap EnterAmountPageMap;

    public EnterAmountPage ( )
    {
        EnterAmountPageMap =new EnterAmountPageMap();
    }


    public void verifyEnterAmountPageTitle(String EnterAmount){
        mobileCommands.waitForElementVisibility(EnterAmountPageMap.enterAmountPageTitle());
        Assert.assertTrue ( mobileCommands.getElementText ( EnterAmountPageMap.enterAmountPageTitle() ).contains ( EnterAmount ), "Verifying the display of Markdownspage title" );
    }

}
