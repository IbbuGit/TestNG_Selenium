package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class ScanNextProductPageMap {
    public By backBtn() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

    public By screenHdr() {
        return By.xpath("//*[@text='Scan Product']");
    }

    public By currentSectionHdr() {
        return By.id("text_view_current_section");
    }

    public By productAisleText() {
        return By.id("aisleText");
    }

    public By productAisle() {
        return By.id("aisle");
    }

    public By productSideText() {
        return By.id("sideText");
    }

    public By productSide() {
        return By.id("side");
    }

    public By productBayText() {
        return By.id("bayText");
    }

    public By productBay() {
        return By.id("bay");
    }

    public By productShelfText() {
        return By.id("shelfText");
    }

    public By productShelf() {
        return By.id("shelf");
    }

    public By productPositionText() {
        return By.id("positionText");
    }

    public By productPosition() {
        return By.id("position");
    }

    public By scanBarImage() {
        return By.id("scan_bar_img");
    }

    public By scanText() {
        return By.id("txt_scan");
    }

    public By enterUPCBtn() {
        return By.id("enter_upc_button");
    }

    public By reviewBtn() {
        return By.id("sc_review_button");
    }
}
