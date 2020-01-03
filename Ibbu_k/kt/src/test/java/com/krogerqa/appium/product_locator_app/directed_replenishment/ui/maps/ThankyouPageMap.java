package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import org.openqa.selenium.By;


/**
 * Class Name : Thankyou PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class ThankyouPageMap {

    public By txtFinishedDR() { return By.id("textview_dr_completed");}
    public By imgCircleProgressBar() { return By.id("circularProgressBar");}
    public By btnBackToMainMenu() { return By.xpath("//android.widget.Button[@text='BACK TO MAIN MENU']");}
    public By headerThankyou() {return By.xpath("//android.widget.TextView[@text='Thank You']");}
    public By btnBackToMM() { return By.xpath("//android.widget.Button[@text='BACK TO MAIN MENU']");}
    public By txtPageHeader() {return By.xpath("//android.widget.TextView[@text='Thank You']");}
    public By btnContReplenishment() { return By.id("dr_continue_replenishment_btn");}
    public By minimumCount(){
        return By.id("tvProductCountMin");
    }
    public By maxCount(){
        return By.id("tvProductCountMax");
    }
    public By thankYouProductCount(int ReplenishedProductsCount)
    {
        //return By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"("+ReplenishedProductsCount+") of\"]/android.widget.TextView");
        return By.xpath("//*[contains(text(),'"+ReplenishedProductsCount+" of "+ReplenishedProductsCount+"')]");
    }


}