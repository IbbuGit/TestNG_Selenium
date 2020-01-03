package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class EnterUPCPopUpMap {

    public By productUPCEditText() { return By.id("dialog_edit_text"); }
    public By enterUPCButton() { return By.id("enter_upc"); }
    public By btnSubmit() {
        return By.id("dialog_submit_button");
    }
    public By erase_start() {
        return By.id("sc_erase_start");
    }
    public By ManualEntryTitle() { return By.id("manualentry_title");}
    public By itemNotFoundText() { return By.id("manualentry_hint");}
}
