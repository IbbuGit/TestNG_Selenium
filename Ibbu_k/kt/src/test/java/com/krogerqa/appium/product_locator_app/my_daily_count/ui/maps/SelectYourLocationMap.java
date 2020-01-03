package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import org.openqa.selenium.By;

public class SelectYourLocationMap {

    public By selectYourLocationDialogTitle() {
        return By.id("tvDialogTitle");
    }

    public By radioButton() {
        return By.xpath("(//*[@class='android.widget.RadioButton'])[1]");
    }

    public By selectButton() {
        return By.id("btnSelect");
    }

    public By cancelButton() {
        return By.id("btnCancel");
    }

    public By locationListScrollView() {
        return By.id("locationListRecyclerView");
    }

    public By noneOfTheAboveRadioButton() {
        return By.xpath("//*[@text='None of the Above']");
    }

}
