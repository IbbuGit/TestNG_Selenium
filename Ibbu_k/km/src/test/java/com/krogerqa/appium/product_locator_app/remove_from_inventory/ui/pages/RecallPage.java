package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.RecallMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class RecallPage {
    MobileCommands mobileCommands = new MobileCommands();
    RecallMap recallMap;
    CommonPage commonPage;

    public RecallPage() {
        recallMap = new RecallMap();
        commonPage=new CommonPage();
    }

    public void clickRecallBtnAndValidate(){
        mobileCommands.click(recallMap.btnRecall());
        mobileCommands.assertElementDisplayed(recallMap.recallPageTitle(), true);
    }

    public void validateRecallBanner(){
        mobileCommands.assertElementDisplayed(recallMap.recallBanner(), true);
        mobileCommands.assertElementDisplayed(recallMap.recallInstructions(), true);
        mobileCommands.click(recallMap.okButton());
    }
}
