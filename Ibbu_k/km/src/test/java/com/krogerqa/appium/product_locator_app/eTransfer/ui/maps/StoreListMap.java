package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;

import org.openqa.selenium.By;

public class StoreListMap {
    public By storeTitle() {
        return By.xpath("//*[@text='Store to Store']");
    }

    public By storeNumberTxtBox() {
        return By.id("edit_text_store_number");
    }

    public By btnNext() {
        return By.id("next_button");
    }

    public By storeNumberLabel() {
        return By.id("text_view_store_number_label");
    }

}
