package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class TopStockCompletePageMap {
    public By thankYouMsg() {
        return By.id("thank_you_tv");
    }

    public By CompleteTsMsg() {
        return By.id("tvCompletedTS");
    }

    public By CompleteHeader() {
        return By.xpath("//android.widget.TextView[@text='Complete']");
    }

    public By mainMenuBtn() {
        return By.id("button_main_menu");
    }

    public By stockedCount() {
        return By.id("productsHaveStockedCount");
    }

    public By stockedOneProduct(){
        //return By.xpath("//*[@text='"+count+"Product']");
        return By.id("productsHaveStockedCount");
    }
    //productsHaveStockedCount
    public By haveBeenText(){
        return By.id("productsHaveStocked");
    }
    public By hasBeenText(){
        //return By.xpath("//[@text='Has Been Stocked']");
        return By.id("productsHaveStocked");
    }
}
