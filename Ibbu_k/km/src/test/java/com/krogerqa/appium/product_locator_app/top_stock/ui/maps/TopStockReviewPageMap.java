package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class TopStockReviewPageMap {
    public By ReviewBtn() {
        return By.id("review_button");
    }

    public By FinishBtn() {
        return By.id("button_finish");
    }

    public By ContinueBtn() {
        return By.id("button_continue");
    }

    public By ReviewHeader() {
        return By.xpath("//*[@text='Review']");
    }

    public By notStockedTab() {
        return By.xpath("//*[contains(@text,'NOT STOCKED')]");
    }

    public By stockedTab() {
        return By.xpath("//*[contains(@text,'STOCKED')]");
    }

    public By UPCsList() {
        return By.id("backroomUpcText");
    }
    public By stockedList(int stockedItemsNum){
        return By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"STOCKED ("+stockedItemsNum+")\"]/android.widget.TextView");
    }
    public By notStockedList(int notStockedItemNum){
        return By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"NOT STOCKED ("+notStockedItemNum+")\"]/android.widget.TextView");
    }

    public By backBtn() {
        return By.xpath("//*[@content-desc=\"Navigate up\"] ");
    }

    public By NoLocationTxt() {
        return By.xpath("//*[@text='No Location']");
    }

    public By wrongAisleTxt() {
        return By.id("status_stock");
    }

    public By relocateProductHdr() {
        return By.xpath("//*[@text='Relocate Product']");
    }

    public By collectProductHdr() {
        return By.id("text_view_collect_product");
    }

    public By moveToLocationHdr() {
        return By.id("text_view_fill_shelf");
    }

    public By doneBtn() {
        return By.id("done_button");
    }

    public By relocatePageCrossMark() {
        return By.xpath("//*[@content-desc=\"Navigate up\"]");
    }

    public By balanceUpdatedLable() {
        return By.xpath("//*[@text='Balance Updated']");
    }

    public By stockedHdrTxt() {
        return By.xpath("//*[@text='Stocked']");
    }

    public By notStockedHdrTxt() {
        return By.xpath("//*[@text='Not Stocked']");
    }

}
