package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Random;

public class EnterAmountPage {
    MobileCommands mobileCommands = new MobileCommands();
    CommonPageMap commonPageMap = new CommonPageMap();
    EnterAmountMap enterAmountMap = new EnterAmountMap();
    EnterUPCPopUpMap enterUPCPopUpMap = new EnterUPCPopUpMap();
    OutdatedMap outdatedMap = new OutdatedMap();
    InventoryUpdatedMap inventoryUpdatedMap = new InventoryUpdatedMap();
    ReviewScreenMap reviewScreenMap = new ReviewScreenMap();
    Random random = new Random();

    String enteredValue = "";
    String displayedValue = "";

    public void validateEnterAmountScreen(String amountScreenIconText, String UPC) {
        mobileCommands.wait(5);
        mobileCommands.waitForElementVisibility(enterAmountMap.enterAmountTitle());
        mobileCommands.assertElementText(enterAmountMap.enterAmountTitle(), amountScreenIconText, true);
        enteredValue = mobileCommands.getElementText(enterAmountMap.upcIdOnAmountScreen());
        Assert.assertEquals(UPC, enteredValue);
        mobileCommands.assertElementDisplayed(enterAmountMap.deleteIcon(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.upcDescriptionOnAmountScreen(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.caseSize(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.caseCount(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.unitsDescription(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.addMoreOnAmountScreen(), true);
    }

    /* Adding random units to be removed on the "EnterAmount" screen and validating the functionality */
    public void addUnitsOnAmountScreen(String headerText) {
        int amountInUnits = random.nextInt(100);
        mobileCommands.assertElementDisplayed(enterAmountMap.countTextBox(), true);
        mobileCommands.click(enterAmountMap.countTextBox());
        mobileCommands.assertElementText(enterUPCPopUpMap.ManualEntryTitle(), headerText, true);
        mobileCommands.clear(enterAmountMap.amountEditText());
        mobileCommands.enterText(enterAmountMap.amountEditText(), Integer.toString(amountInUnits), true);
        mobileCommands.click(enterUPCPopUpMap.btnSubmit());
        displayedValue = mobileCommands.getElementText(enterAmountMap.countTextBox());
        Assert.assertEquals(Integer.toString(amountInUnits), displayedValue);
        mobileCommands.click(enterAmountMap.countPlusSign());
        int newAmountInUnits = amountInUnits + 1;
        displayedValue = mobileCommands.getElementText(enterAmountMap.countTextBox());
        Assert.assertEquals(Integer.toString(newAmountInUnits), displayedValue);
        mobileCommands.click(enterAmountMap.countMinusSign());
        displayedValue = mobileCommands.getElementText(enterAmountMap.countTextBox());
        Assert.assertEquals(Integer.toString(amountInUnits), displayedValue);
    }

    public void validateReviewBtn() {
        mobileCommands.assertElementDisplayed(enterAmountMap.reviewIcon(), true);
    }

    public void clickReview() {
        enteredValue = mobileCommands.getElementText(enterAmountMap.upcDescriptionOnAmountScreen());
        mobileCommands.click(enterAmountMap.reviewIcon());
        displayedValue = mobileCommands.getElementText(enterAmountMap.upcDescriptionOnReviewScreen());
        Assert.assertEquals(enteredValue, displayedValue);
        mobileCommands.click(enterAmountMap.submitButton());
        mobileCommands.waitForElementVisibility(enterAmountMap.backToMainMenu());
    }

    public void validateUpc(String upc) {
        /* wait for the scanned product by given UPC */
        mobileCommands.waitForElement(By.xpath("//*[@text='" + upc + "']"));
        mobileCommands.assertElementDisplayed(By.xpath("//*[@text='" + upc + "']"), true);
    }

    public void clickReviewAndSubmit() {
        mobileCommands.click(enterAmountMap.reviewIcon());
        mobileCommands.click(enterAmountMap.submitButton());
        mobileCommands.waitForElementVisibility(enterAmountMap.backToMainMenu());
    }

    public void waitEnterUPCBtn() {
        mobileCommands.waitForElement(enterAmountMap.addMoreOnAmountScreen());
    }

    public void clickReviewButton() throws SQLException, IOException, URISyntaxException {
        mobileCommands.wait(2);
        mobileCommands.click(enterAmountMap.reviewIcon());
    }

    /* Deleting product from Enter Amount Screen and Review Screen using trash icon */
    public void deleteUsingHeaderTrashIcon(){
        mobileCommands.assertElementDisplayed(enterAmountMap.deleteIcon(), true);
        mobileCommands.click(enterAmountMap.deleteIcon());
        mobileCommands.assertElementDisplayed(outdatedMap.removeProductTitle(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.removeProductAlertText(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.cancelRemoveProduct(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.continueRemoveProduct(), true);
        mobileCommands.click(outdatedMap.continueRemoveProduct());
    }

    /* Validating "Exit Remove From Inventory" functionality, "SignOut" option and alert dialogue box on Enter Amount and Review Screen */
    public void exitFromAmountAndReviewScreen() {
        mobileCommands.click(commonPageMap.kebabMenu());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.exitRemoveFromInventoryIcon(), true);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.signOutIcon(), true);
        mobileCommands.click(inventoryUpdatedMap.exitRemoveFromInventoryIcon());
        mobileCommands.assertElementDisplayed(enterAmountMap.exitAlertTitle(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.exitAlertMessage(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.cancelExitPopUp(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.continueExitPopUp(), true);
        mobileCommands.click(enterAmountMap.continueExitPopUp());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.removeFromInventoryIcon(), true);
        mobileCommands.click(inventoryUpdatedMap.removeFromInventoryIcon());
        mobileCommands.click(outdatedMap.btnOutdated());
    }
public void clickCorpBrandMarkdown(){mobileCommands.click(enterAmountMap.corpBrandMarkdown());}
    public void clickCorpBrandDonate(){mobileCommands.click(enterAmountMap.corpBrandDonate());}
    public void clickCorpBrandDiscard(){mobileCommands.click(enterAmountMap.corpBrandDiscard());}

    public void waitEnterUPCBtnE2E() {
       mobileCommands.waitForElement(enterAmountMap.addMoreOnAmountScreen());
    }

    public void StepperAddUnits() {
        mobileCommands.click(enterAmountMap.countPlusSign());
    }

    public void StepperRemoveUnits() {
        mobileCommands.click(enterAmountMap.countMinusSign());
    }

    public void validateMessageTitle(String messageTitle) {
        mobileCommands.assertElementDisplayed(enterAmountMap.messageTitle(), true);
        mobileCommands.assertElementText(enterAmountMap.messageTitle(), messageTitle, true);
    }

    public void validateAlertPopUp(String popUpTitle) {
        mobileCommands.assertElementDisplayed(enterAmountMap.alertTitle(), true);
        mobileCommands.assertElementText(enterAmountMap.alertTitle(), popUpTitle, true);
    }

    public void clickYesSecondChance() {
        mobileCommands.click(enterAmountMap.secondChanceYesButton());
    }

    public void clickNoSecondChance() {
        mobileCommands.click(enterAmountMap.secondChanceNoButton());
    }

    public void waitForScannedUpc(){
        mobileCommands.waitForElementVisibility(enterAmountMap.upcIdOnAmountScreen());
    }

    public void waitForCaseSize(){
        mobileCommands.waitForElementVisibility(enterAmountMap.caseSize());
    }

    public void waitForUnitDescription(){
        mobileCommands.waitForElementVisibility(enterAmountMap.unitsDescription());
    }

    public void clickProductTileDeleteIconAndValidate(){
        mobileCommands.click(enterAmountMap.productCardDeleteIcon());
        mobileCommands.assertElementDisplayed(enterAmountMap.removeProductHeader(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.removeProductAlertText(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.cancelRemoveProduct(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.continueExitPopUp(), true);
        mobileCommands.click(enterAmountMap.continueExitPopUp());
    }

    public void clickSubmitButton(){
        mobileCommands.click(enterAmountMap.submitButton());
    }

    public void clickCloseOnEnterAMountScreen(){
        mobileCommands.assertElementDisplayed(enterAmountMap.closeInEnterAmountScreen(), true);
        mobileCommands.click(enterAmountMap.closeInEnterAmountScreen());
        mobileCommands.assertElementDisplayed(outdatedMap.outdatedPageTitle(), true);
    }

    public void backButtonPopUpValidation() {
        mobileCommands.click(reviewScreenMap.backButtonOnReviewScreen());
        displayedValue = mobileCommands.getElementText(reviewScreenMap.backButtonTitle());
        Assert.assertTrue(displayedValue.contains("Discard Without Submitting?"));
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonMessage(), true);
//        displayedValue = mobileCommands.getElementText(reviewScreenMap.backButtonMessage());
//        Assert.assertTrue(displayedValue.contains("You have unsubmitted work. Your work will not be saved."));
        mobileCommands.assertElementDisplayed(enterAmountMap.cancelExitPopUp(), true);
        mobileCommands.assertElementDisplayed(enterAmountMap.continueExitPopUp(), true);
    }

    public void backButtonFromAddMoreScreen() {
        mobileCommands.click(enterAmountMap.addMoreOnAmountScreen());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        backButtonPopUpValidation();
        mobileCommands.click(enterAmountMap.cancelExitPopUp());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.click(reviewScreenMap.backButtonOnReviewScreen());
        mobileCommands.click(enterAmountMap.continueExitPopUp());
        mobileCommands.assertElementDisplayed(enterAmountMap.enterAmountTitle(), true);
    }

    public void addMoreScreenValidationOnEnterAmount() {
        mobileCommands.click(enterAmountMap.addMoreOnAmountScreen());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.enterUPCOnAddMoreScreen(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewButtonOnAddMoreScreen(), true);
    }

}
