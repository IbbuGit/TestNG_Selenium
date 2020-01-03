package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.DamagedMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.RecallMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class DamagedPage {
    MobileCommands mobileCommands = new MobileCommands();
    DamagedMap damagedMap;
    RecallMap recallMap;

    public DamagedPage() {
        damagedMap = new DamagedMap();
        recallMap = new RecallMap();
    }

    String displayedValue = "";
    public void clickDamagedBtnAndValidate(){
        mobileCommands.click(damagedMap.btnDamaged());
        mobileCommands.assertElementDisplayed(damagedMap.damagedPageTitle(), true);
    }

    public void limitedQuantityBannerValidation(){
        mobileCommands.assertElementDisplayed(damagedMap.reclamationPopUp(), true);
        mobileCommands.assertElementDisplayed(damagedMap.reclamationPopUpMessage(), true);
        mobileCommands.click(recallMap.okButton());
        mobileCommands.assertElementDisplayed(damagedMap.limitedQtyMessage(), true);
        mobileCommands.click(recallMap.okButton());
    }

    public void validatePharmacyManagerBanner(){
        mobileCommands.assertElementDisplayed(damagedMap.pharmacyBanner(), true);
        displayedValue = mobileCommands.getElementText(damagedMap.pharmacyBannerMessage());
        Assert.assertTrue(displayedValue.contains("See Pharmacy Manager or Store Manager for Return Instructions"));
    }

}
