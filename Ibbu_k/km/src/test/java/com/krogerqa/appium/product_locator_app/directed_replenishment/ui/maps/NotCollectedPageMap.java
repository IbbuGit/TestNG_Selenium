package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import org.openqa.selenium.By;


/**
 * Class Name : Collected PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class NotCollectedPageMap {
    public By headerDirectedReplenish() { return By.xpath("//android.widget.TextView[@text='Directed Replenish…']");}
    public By txtFindAndScanInBR() { return By.id("find_scan_txt");}
    public By txtProductsToCollect() { return By.id("products_to_collect");}
    public By txtSessionInProgress() { return By.id("//android.widget.TextView[@text='Session in progress']");}
    public By btnCollectMore() { return By.xpath("//*[@text='COLLECT MORE']");}
    public By tabNotCollected() { return By.xpath("//*[@text='NOT COLLECTED']");}
    public By tabCollected() { return By.xpath("//*[@text='COLLECTED']");}
    public By txtDrUPC() {return By.id("drUpcText");}
    public By btnCartIsFull() { return By.id("cart_full_btn");}
    public By headerPrdsNotCollected() { return By.id("text_title");}
    public By txtProdNotCollectedMsg() { return By.id("text_body_message");}
    public By btnCancel(){return By.id("text_negative_caption");}
    public By btnDoneCollecting() {return By.id("text_positive_caption");}
    public By btnSessionInProgressContinue() {return By.id("text_positive_caption");}
    public By btnSessionInProgressCollectMore(){ return By.id("text_negative_caption");}
    public By txtSkipped() {return By.id("aisle_text"); }
    public By titleBackAlert() { return By.id("alertTitle");}
    public By txtBackMessage() { return By.id("message");}
    public By btnBackCancel() { return By.id("button2");}
    public By btnBackExit(){ return By.id("button1");}
    public By findUpc(){return By.id("drUpcText");}
    public By txtUnFinishedWorkHdr(){return By.id("text_title");}
    public By txtUnfinishedBodyMessage(){return By.id("text_body_message");}
    public By btnNewList(){return By.id("text_negative_caption");}
    public By btnContinue(){return By.id("text_positive_caption");}
    public By headerSessionInProgress() { return By.id("text_title");}
    public By headerProductNotCollectedPopup() {return By.xpath("//android.widget.TextView[@text='Products not collected']");}
    public By noOfProducts(int number){
        return By.xpath("//*[@content-desc="+number+"products]");
    }
    public By numOfProductsInNotCollected(int minimum, int max){
        return By.xpath("//*[contains(@text,'"+minimum+" of "+max+" Products Collected')]");
    }
    public By backArrow(){
        return By.xpath("");
    }
}