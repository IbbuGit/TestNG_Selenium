package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.EnterAmountMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.EnterUPCPopUpMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.OutdatedMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.ReviewScreenMap;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class ReviewScreenPage {
    MobileCommands mobileCommands = new MobileCommands();
    CommonPageMap commonPageMap = new CommonPageMap();
    EnterAmountMap enterAmountMap = new EnterAmountMap();
    EnterUPCPopUpMap enterUPCPopUpMap = new EnterUPCPopUpMap();
    ReviewScreenMap reviewScreenMap = new ReviewScreenMap();
    EnterAmountPage enterAmountPage = new EnterAmountPage();
    RecallPage recallPage = new RecallPage();
    OutdatedMap outdatedMap = new OutdatedMap();

    Random random = new Random();

    String enteredDescription = "";
    String displayedDescription = "";
    String enteredCount = "";
    String displayedCount = "";
    String enteredValue = "";

    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;

    private Properties prop;

    public ReviewScreenPage(){
        //add additional code if need be
    }

    public ReviewScreenPage(Login_TestDataBean loginData){
       apiExecutor = new HttpClientExecutor(loginData.getUsername(), loginData.getPassword());
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public void validateProductCard() {
        enteredDescription = mobileCommands.getElementText(enterAmountMap.upcDescriptionOnAmountScreen());
        enteredCount = mobileCommands.getElementText(enterAmountMap.countTextBox());
        mobileCommands.click(enterAmountMap.reviewIcon());
        displayedDescription = mobileCommands.getElementText(reviewScreenMap.upcDescriptionOnReviewScreen());
        displayedCount = mobileCommands.getElementText(reviewScreenMap.caseCount());
        displayedCount = displayedCount.substring(0, displayedCount.length() - 6);
        Assert.assertEquals(enteredDescription, displayedDescription);
        Assert.assertEquals(enteredCount, displayedCount);
    }

    public void validateReviewScreen(String reasonCode) {
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewScreenTitle(reasonCode), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.countTextTitle(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.productCard(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.productCardDeleteIcon(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreButton(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.submitButton(), true);
    }

    public void addMoreScreenValidation() {
        mobileCommands.click(reviewScreenMap.addMoreButton());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.enterUPCOnAddMoreScreen(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewButtonOnAddMoreScreen(), true);
    }

    /* Adding new products on "Add More" screen by manual entry */
    public void addMoreManualProducts(String addProduct, String UPC) {
        mobileCommands.click(reviewScreenMap.enterUPCOnAddMoreScreen());
        mobileCommands.assertElementDisplayed(enterUPCPopUpMap.ManualEntryTitle(), true);
        mobileCommands.enterText(enterUPCPopUpMap.productUPCEditText(), addProduct, true);
        mobileCommands.click(enterUPCPopUpMap.btnSubmit());
        enteredValue = mobileCommands.getElementText(enterAmountMap.upcIdOnAmountScreen());
        Assert.assertEquals(UPC, enteredValue);
    }

    /* Validating new products added from "Add More" screen. Validating description and units count */
    public void validateAddedProducts() {
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enteredDescription = mobileCommands.getElementText(enterAmountMap.upcDescriptionOnAmountScreen());
        enteredCount = mobileCommands.getElementText(enterAmountMap.countTextBox());
        mobileCommands.click(enterAmountMap.reviewIcon());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addedProductDescription(enteredDescription), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.addedProductUnits(enteredCount), true);
    }

    public void addMoreButton() {
        mobileCommands.click(reviewScreenMap.addMoreButton());
    }

    /* CLicking on product card in Review Screen and validating in Enter Amount Screen */
    public void clickAndValidateProductCard() {
        mobileCommands.assertElementDisplayed(reviewScreenMap.productCard(), true);
        enteredDescription = mobileCommands.getElementText(reviewScreenMap.upcDescriptionOnReviewScreen());
        mobileCommands.click(reviewScreenMap.productCard());
        displayedDescription = mobileCommands.getElementText(enterAmountMap.upcDescriptionOnAmountScreen());
        Assert.assertEquals(enteredDescription, displayedDescription);
        mobileCommands.click(enterAmountMap.reviewIcon());
    }

    public String reviewScreenTitleText(String reasonCode){
        String titleValue = mobileCommands.getElementText(reviewScreenMap.reviewScreenTitle(reasonCode));
        return titleValue;
    }

    public void addManualProductForRecallFlow(String addProduct, String UPC){
        mobileCommands.click(reviewScreenMap.enterUPCOnAddMoreScreen());
        mobileCommands.assertElementDisplayed(enterUPCPopUpMap.ManualEntryTitle(), true);
        mobileCommands.enterText(enterUPCPopUpMap.productUPCEditText(), addProduct, true);
        mobileCommands.click(enterUPCPopUpMap.btnSubmit());
        recallPage.validateRecallBanner();
        enteredValue = mobileCommands.getElementText(enterAmountMap.upcIdOnAmountScreen());
        Assert.assertEquals(UPC,enteredValue);
    }

    public void clickSubmitButton(){
        mobileCommands.click(reviewScreenMap.submitButton());
    }

    public HashMap<String, Integer> getQodValues(String productsToScan) throws IOException, URISyntaxException {
        HashMap<String, Integer> qodList = new HashMap<>();
        for (String UPC : productsToScan.split(";")) {
            qodList.put(UPC, getBOHCount(UPC));
        }
        return  qodList;
    }

    private int getBOHCount(String upc) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(upc);
        String response = apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
        int qod = JsonPathValueExtractor.extractBOHBucketValue(response, "QOD");
        return qod;
    }


    public void backButtonFromReviewScreen(String reasonCode) {
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewScreenTitle(reasonCode), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        enterAmountPage.backButtonPopUpValidation();
        mobileCommands.click(enterAmountMap.cancelExitPopUp());
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewScreenTitle(reasonCode), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreButton(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.submitButton(), true);
        enterAmountPage.backButtonPopUpValidation();
        mobileCommands.click(enterAmountMap.continueExitPopUp());
        mobileCommands.assertElementDisplayed(outdatedMap.scanProductImg(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.scanProductText(), true);
    }

    public void backButtonFromAddMoreOnReviewScreen(String reasonCode) {
        mobileCommands.click(reviewScreenMap.addMoreButton());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.backButtonOnReviewScreen(), true);
        enterAmountPage.backButtonPopUpValidation();
        mobileCommands.click(enterAmountMap.cancelExitPopUp());
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreTitle(), true);
        mobileCommands.click(reviewScreenMap.backButtonOnReviewScreen());
        mobileCommands.click(enterAmountMap.continueExitPopUp());
        mobileCommands.assertElementDisplayed(reviewScreenMap.reviewScreenTitle(reasonCode), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.submitButton(), true);
        mobileCommands.assertElementDisplayed(reviewScreenMap.addMoreButton(), true);
    }


}