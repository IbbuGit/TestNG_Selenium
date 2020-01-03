package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class CountProductPageMap {
    public By crossBar() {
        return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    }

    public By shelfAllocationTile() {
        return By.id("tv_sc_shelf_allocation");
    }

    public By ShelfAllocationEditIcon() {
        return By.id("img_sc_shelf_allocation");
    }

    public By unitCountEditTextField() {
        return By.id("et_sc_unit_count");
    }

    public By multiLocationMessage() {
        return By.id("product_status_text");
    }

    public By btnNext() {
        return By.id("button_next");
    }

    public By sCUnitCountNumberKeyBord() {
        return By.id("sc_keyboard_view_id");
    }

    public By inLineErrorMessages() {
        return By.id("tv_invalid_format");
    }

    //Allocation Count page
    public By updateAllocationTitle() {
        return By.id("section_check_manual_entry_header");
    }

    public By shelfAllocationEditText() {
        return By.id("section_check_manual_entry_edit_text");
    }

    public By btnCancel() {
        return By.id("section_check_manual_entry_cancel_button");
    }

    public By btnUpdate() {
        return By.id("section_check_manual_entry_update_button");
    }

    public By sCManualEntryKeyBord() {
        return By.id("manual_upc_entry_keyboard_view");
    }

    public By countProductPageTitle() {
        return By.xpath("//*[@text='Count Product']");
    }

    public By kebabMoreOption() {
        return By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    }

    public By productUPCText() {
        return By.id("backroomUpcText");
    }

    public By productNameText() {
        return By.id("backroomDescText");
    }

    public By productPriceText() {
        return By.id("tv_sc_shelf_allocation");
    }

    public By productImg() {
        return By.id("backroomImage");
    }

    public By unitCount() {
        return By.id("tv_sc_shelf_allocation_unites");
    }

    public By unitCountHdr() {
        return By.id("tv_sc_unit_count");
    }

    public By prodExistInMultiLocationMessage() {
        return By.id("product_status_text");
    }

    public By barCodeNotRecognisedMsg() {
        return By.id("product_status_text");
    }

    //Discontinued Tags
    public By txtTag() {
        return By.id("alertTitle");
    }

    public By txtMessage() {
        return By.id("message_text");
    }

    public By btnContinue() {
        return By.xpath("//android.widget.Button[@text='CONTINUE']");
    }

}
