package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class DonationMap {
    public By btnDonation(){return By.xpath("//*[@text='Donation']"); }
    public By donationPageTitle(){ return By.xpath("//*[@text='Donation']");}
    public By smokingCessationBanner(){ return By.id("cl_validation");}
    public By smokingCessationTitle() { return By.id("tv_message_title");}
    public By batteryStickerMessage() { return By.xpath("//*[@text='Use Battery Sticker']");}
    public By holdForVendorPickupBanner() { return By.xpath("//*[@text='Hold for Vendor Pick-up']");}
}
