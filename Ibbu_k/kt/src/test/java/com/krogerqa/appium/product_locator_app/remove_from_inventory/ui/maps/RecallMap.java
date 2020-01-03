package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class RecallMap {
    public By btnRecall(){return By.xpath("//*[@text='Recall']"); }
    public By recallPageTitle(){ return By.xpath("//*[@text='Recall']");}
    public By recallBanner(){ return By.id("title_template");}
    public By recallInstructions(){ return By.xpath("//*[@text='Follow Recall Instructions']");}
    public By okButton(){ return By.xpath("//*[@text='OK']");}
}
