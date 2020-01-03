package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class CantFindSkipPageMap {
    public By scanProductHdr_CantFindSkip() {
        return By.xpath("//*[@text='Scan Product']");
    }

    public By findAndScanHdr() {
        return By.id("scanText");
    }

    public By cantFindSkipBtn() {
        return By.id("cant_find_button");
    }
}
