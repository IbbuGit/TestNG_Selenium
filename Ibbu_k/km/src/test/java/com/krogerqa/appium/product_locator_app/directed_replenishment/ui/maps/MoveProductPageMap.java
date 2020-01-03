package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import org.openqa.selenium.By;


/**
 * Class Name : MoveProduct PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class MoveProductPageMap {

    public By headerMoveProduct() { return By.xpath("//android.widget.TextView[contains(@text,'Move Product') and contains(@text,'/')]");}
    public By txtPageHeader() {
        return By.xpath("//android.widget.TextView[@text='Collect Product']");
    }
    public By txtMoveProdToShelf() {
        return By.id("text_move_to_shelf");
    }
    public By txtAisle() {
        return By.id("aisleText");
    }
    public By txtSide() {
        return By.id("sideText");
    }
    public By txtBay() {
        return By.id("bayText");
    }
    public By txtShelf() {
        return By.id("shelfText");
    }
    public By txtPosition() {
        return By.id("positionText");
    }
    public By txtAisleValue() {
        return By.id("aisle");
    }
    public By txtSideValue() {
        return By.id("side");
    }
    public By btnNext() {
        return By.id("btn_next");
    }
    public By btnCantFindSkip() {
        return By.id("textview_cant_find_skip");
    }
    public By btnSkip() { return By.id("text_positive_caption");}
    public By btnCancel() { return By.id("text_negative_caption");}
    public By headerCantFindSkip() { return By.id("text_title");}
    public By txtCantFindSkipProd() { return By.id("text_body_message");}
    public By btnFinish() { return By.id("btn_finish");}
    public By txtProdUPC() { return By.id("drUpcText");}
    public By txtprodDesc() { return By.id("drDescText");}
    public By imgProd() { return By.id("drImage");}
    public By awesome() { return By.id("great_message");}
    public By great(){ return By.xpath("//android.widget.TextView[@text= 'Great!']");}
    public By unFinishedWorkPopUp_Cancel() {return By.xpath("//*[@text='CANCEL']");}
    public By unFinishedWorkPopUp_Exit() {return By.xpath("//*[@text='EXIT']");}
    //public By unFinishedWorkPopUp_Exit() {return By.id("text_positive_caption");}
    public By unFinishedTitle_MoveProduct() {return By.xpath("//*[@text='Unfinished Work']");}
    public By moveProductCount(int min,int max){
        return By.xpath("//*[@text='Move Product "+min+"/"+max+"']");
    }

}