package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.FaqPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class FaqPage {


    private MobileCommands  mobileCommands = new MobileCommands();
    private FaqPageMap Faqpagemap;

    public FaqPage(){
        Faqpagemap=new FaqPageMap();
    }

    public void ValidateOptOto(){
        mobileCommands.assertElementDisplayed(Faqpagemap.OptOto(),true);
    }
    public void NavigateBack(){
        mobileCommands.browserBack();
    }
}
