package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class ManualEnterUPCMap {
    public By titleManualProduct() {
        return By.id("manual_upc_entry_header");
    }

    public By lblManualEntryUPCHint() {
        return By.id("manual_upc_entry_helper");
    }

    public By txtUPCEdit() {
        return By.id("manual_upc_entry_edit_text");
    }

    public By dlgManualEnterCancelBtn() {
        return By.id("manual_upc_entry_cancel_button");
    }

    public By dlgManualEnterSubmitBtn() {
        return By.id("manual_upc_entry_submit_button");
    }
}
