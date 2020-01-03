package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class DamagedMap {
    public By btnDamaged() {return By.xpath("//*[@text='Damaged']");}
    public By damagedPageTitle(){return By.xpath("//*[@text='Damaged']"); }

    /* Limited Quantity Sticker Validations */

    public By reclamationPopUp () {return By.id("title_template");}
    public By reclamationPopUpMessage(){ return By.xpath("//*[@text='Send to Reclamation']");}
    public By limitedQtyMessage(){ return By.xpath("//*[@text='Use Limited Qty Sticker']");}

    /*See Pharmacy <=Manager Banner validation */
    public By pharmacyBanner(){ return By.id("cl_validation");}
    public By pharmacyBannerMessage(){ return By.id("tv_message_title");}

}
