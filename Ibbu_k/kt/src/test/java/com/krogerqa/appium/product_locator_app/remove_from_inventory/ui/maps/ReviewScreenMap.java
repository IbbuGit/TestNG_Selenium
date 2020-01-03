package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps;

import org.openqa.selenium.By;

public class ReviewScreenMap {
    public By reviewScreenTitle(String reasonCode) { return By.xpath("//*[@text='"+ reasonCode +"']");}
    public By backButtonOnReviewScreen() { return By.xpath("//*[@content-desc='Navigate up']");}
    public By countTextTitle() { return By.id("rifi_text_count_title");}
    public By productCard() { return By.id("card_view");}
    public By caseCount() { return By.id("caseNumberText");}
    public By productCardDeleteIcon() { return By.id("removeText");}
    public By addMoreButton() { return By.id("add_more_button");}
    public By submitButton() { return By.id("submit_button");}
    public By upcDescriptionOnReviewScreen() { return By.id("itemDetailsText");}
    public By addedProductDescription(String productDescription){ return By.xpath("//*[@text='"+ productDescription +"']");}
    public By addedProductUnits(String productUnits){ return By.xpath("//*[@text='"+ productUnits +" Units']");}

    /* Locators for Add More Screen when "Add More" is clicked from Review Screen*/
    public By addMoreTitle(){ return By.xpath("//*[@text='Add More']");}
    public By enterUPCOnAddMoreScreen(){ return By.id("enter_upc2");}
    public By reviewButtonOnAddMoreScreen(){ return By.id("brc_review");}

    /* BackButton Pop Up on Add More Screen */
    public By backButtonTitle() { return By.id("alertTitle");}
    public By backButtonMessage() { return By.xpath("//*[@text='You have unsubmitted work. Your work will not be saved.']");}
}

