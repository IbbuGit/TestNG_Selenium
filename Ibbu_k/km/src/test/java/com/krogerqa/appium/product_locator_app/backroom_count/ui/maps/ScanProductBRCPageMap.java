package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class ScanProductBRCPageMap {

    public By btnEnterUPC() {
        return By.id("enter_upc");
    }

    public By btnReEnterUPC() {
        return By.id("enter_upc_button");
    }

    public By enterUPC() {
        return By.id("dialog_edit_text");
    }

    public By btnSubmit() {
        return By.id("dialog_submit_button");
    }

    public By btnCancel() {
        return By.id("dialog_cancel_button");
    }

    public By headerScanProd() {
        return By.xpath("//android.widget.TextView[@text='Scan Product']");
    }

    public By headerEnterUPC() {
        return By.xpath("//android.widget.TextView[@text='Enter UPC']");
    }

    public By txtScanProd() {
        return By.id("textview_scan_product");
    }

    public By lblUnauthorizedDSDMsg() {
        return By.id("scan_dsd_prodcut");
    }

    public By enterUPCError() {
        return By.id("manual_err_icon");
    }

    public By btnBack() {
        return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    }

    public By alertTitle() {
        return By.id(("alertTitle"));
    }

    public By tryAgainButton() {
        return By.xpath("//*[@text='TRY AGAIN']");
    }

    public By exitTaskButton() {
        return By.xpath("//*[@text='EXIT TASK']");
    }

    public By serviceFailed() {
        return By.xpath("//android.widget.TextView[@text='Service Failed']");
    }

    public By magicItemErrorMessage() {
        return By.xpath("//android.widget.TextView[@text='MAGIC Product Scanned']");
    }
}
