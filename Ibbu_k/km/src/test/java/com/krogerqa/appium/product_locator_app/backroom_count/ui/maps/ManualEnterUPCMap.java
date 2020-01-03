package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class ManualEnterUPCMap {
    public By titleManualProduct() {
        return By.id("manualentry_title");
    }

    public By lblEnterUPCOrPLU() {
        return By.id("enter_upc_plu");
    }

    public By lblManualEntryUPCHint() {
        return By.id("manualentry_hint");
    }

    public By txtUPCEdit() {
        return By.id("dialog_edit_text");
    }

    public By dlgManualEnterCancelBtn() {
        return By.id("dialog_cancel_button");
    }

    public By dlgManualEnterSubmitBtn() {
        return By.id("dialog_submit_button");
    }
}
