package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

import org.openqa.selenium.By;

public class TopStockProductStockMessagePageMap {

    public By productStatus() {return By.id("product_Status");}
    public By upcNumber(){return By.id("backroomUpcText");}
    public By ProductName(){return By.id("backroomDescText");}
    public By ProductPrice(){return By.id("backroomPriceText");}
    public By Dialog_Cancel_Btn() {return By.id("dialog_cancel_button");}
    public By Dialog_Sub_Btn() {return By.id("dialog_submit_button");}
    public By stockedBtn(){return By.id("button_stocked");}
    public By reviewBtn(){return By.id("review_button");}
    public By notStockedBtn(){return By.id("button_not_stocked");}
    public By StockShelfHeaderTxt() {return By.xpath("//*[@text='Stock Shelf']");}
    public By BOHUnitCountTxt() {return By.xpath("//*[@text='Unit Count:']");}
    public By BOHScreenHeaderTxt() {return By.xpath("//*[@text='Update Balance']");}
    public By BOHIncorrectProductBalanceMsg() {return By.xpath("//*[@text='Incorrect Product Balance']");}
    public By bohUnitCount(){return By.id("et_unit_count");}
    public By UpdateBalanceBtn(){return By.id("button_updatebalance");}
    public By KeyboardClick(){return By.id("topstock_keyboard_view_id");}
    public By BOHBalanceTxt() {return By.xpath("//*[@text='Update Product Balance']");}
    public By BOHInLineErrorMsg() {return By.xpath("//*[@text='Value cannot be less than 1']");}
    public By BOHExceed() {return By.xpath("//*[@text='Value cannot exceed 9999']");}
    public By BOHErrorMsg() {return By.id("tv_invalid_format");}
    public By noStockingNeededMsg(){
        return By.xpath("//*[@text='No Stocking Needed']");
    }
    public By productStockedMsg(){
        return By.xpath("//*[@text='Product Stocked']");
    }
    }
