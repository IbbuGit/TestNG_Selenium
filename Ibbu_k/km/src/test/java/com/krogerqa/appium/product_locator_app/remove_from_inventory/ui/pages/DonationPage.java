package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.util.List;


public class DonationPage {
    MobileCommands mobileCommands = new MobileCommands();
    DonationMap donationMap;
    CommonPage commonPage;
    DamagedMap damagedMap;
    RecallMap recallMap;
    EnterAmountMap enterAmountMap;
    ReviewScreenMap reviewScreenMap;


    public DonationPage() {
        donationMap = new DonationMap();
        commonPage=new CommonPage();
        damagedMap = new DamagedMap();
        recallMap = new RecallMap();
        enterAmountMap = new EnterAmountMap();
        reviewScreenMap = new ReviewScreenMap();
    }
    String actualvalue = "";
    String displayedValue = "";
    public void clickDonationBtnAndValidate(){
        mobileCommands.click(donationMap.btnDonation());
        mobileCommands.assertElementDisplayed(donationMap.donationPageTitle(), true);
    }

    public void validateSmokingCessationBanner(){
        mobileCommands.assertElementDisplayed(donationMap.smokingCessationBanner(), true);
        displayedValue = mobileCommands.getElementText(donationMap.smokingCessationTitle());
        Assert.assertTrue(displayedValue.contains("Smoking Cessation. Expires < 10 days? Send to Reclaim. Void in California"));
    }
    public void batteryStickerPopUpValidation(){
        mobileCommands.assertElementDisplayed(damagedMap.reclamationPopUp(), true);
        mobileCommands.assertElementDisplayed(damagedMap.reclamationPopUpMessage(), true);
        mobileCommands.click(recallMap.okButton());
        mobileCommands.assertElementDisplayed(donationMap.batteryStickerMessage(), true);
        mobileCommands.click(recallMap.okButton());
    }

    public boolean holdForVendorPickUpValidation(){
        mobileCommands.assertElementDisplayed(donationMap.holdForVendorPickupBanner(), true);
        mobileCommands.click(enterAmountMap.reviewIcon());
        /*Validation to check Hold For Vendor Pickup item is not added to the bucket list in the review screen */
        try {
            List upc = mobileCommands.elements(reviewScreenMap.addedProductDescription("Miller Lite"));
            if(upc.size()==0)
                return true;
            else return false;
        }
        catch(TimeoutException e){
            return true;
        }
    }
}
