package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class OutdatedMap {
    public By btnOutdated() {
        return By.xpath("//*[@text='Outdated']");
    }
    public By scanProductImg(){return By.id("imageview_scan_product");}
    public By scanProductText(){return By.id("textview_scan_product");}
    public By enterUpcBtn(){return By.id("enter_upc");}
    public By trashIcon(){return By.id("//*[@content-desc='Delete'");}
    public By productsToRemoveText(){return By.id("textview_Product");}
    public By exitRemoveFromInventoryBtn(){return By.xpath("//*[@text='Exit Remove From Inventory']");}
    public By outdatedPageTitle(){return By.xpath("//*[@text='Outdated']");}
    public By unitCountOnOutdatedPage(){
       return By.id("caseNumberText");
    }
    public By submitBtn(){ return By.id("submit_button");}
    public By removeProductTitle(){ return By.id("alertTitle");}
    public By removeProductAlertText(){ return By.xpath("//*[@text='Would you like to remove this product from the list?']");}
    public By cancelRemoveProduct(){ return By.xpath("//*[@text='CANCEL']");}
    public By continueRemoveProduct(){ return By.xpath("//*[@text='REMOVE']");}
    public By secondChanceBanner(){ return By.id("title_template");}
    public By secondChanceTitle(){ return By.xpath("//*[@text='Will item be used for 2nd chance']");}
    public By yesButton(){ return By.xpath("//*[@text='YES']");}
    public By noButton(){ return By.xpath("//*[@text='NO']");}
    public By backButtonEnterUPCScreen() { return By.xpath("//*[@content-desc='Navigate up']");}
    /*Contains Theft button and Banner title */
    public By btnTheft() { return By.xpath("//*[@text='Theft']"); }
    public By theftPageTitle(){ return By.xpath("//*[@text='Theft']"); }

    public By magicItemBanner() { return By.xpath("//*[@text='Log into MAGIC to Return Inv']");}
    public By barCodeError() { return By.xpath("//*[@text='Barcode Not Recognized']");}
}
