package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import com.krogerqa.appium.product_locator_app.common.utils.*;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.dataBeans.Remove_From_Inventory_TestDataBean;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.EnterUPCPopUpMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.InventoryUpdatedMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.OutdatedMap;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class EnterUPCPopUpPage extends Base {
    String[] multipleUPCs;
    MobileCommands mobileCommands = new MobileCommands();
    EnterUPCPopUpMap enterUPCPopUpMap = new EnterUPCPopUpMap();
    CommonPageMap commonPageMap = new CommonPageMap();
    InventoryUpdatedMap inventoryUpdatedMap = new InventoryUpdatedMap();
    OutdatedMap outdatedMap = new OutdatedMap();
    private Login_TestDataBean login_Data;
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;
    private DBHelper dbHelper;
    private String flowType = "";
    private String flowAction = "";

    public EnterUPCPopUpPage() {
        //Expand this if need be
    }

    public EnterUPCPopUpPage(Login_TestDataBean login_Data) {
        this.login_Data = login_Data;
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
        dbHelper = new DBHelper();
    }

    private String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

  private String getFlowAction() {
        return flowAction;
    }

    public void setFlowAction(String flowAction) {
        this.flowAction = flowAction;
    }

    public String enterUpcEditText(String UpcEditText) {
        mobileCommands.enterText(enterUPCPopUpMap.productUPCEditText(), UpcEditText, false);
        return UpcEditText;
    }

    public void clickEnterUPC() {

        mobileCommands.tap(enterUPCPopUpMap.enterUPCButton());
    }

    public void clickSubmitButton() {
        mobileCommands.click(enterUPCPopUpMap.btnSubmit());
    }

    public void validateManualTextTitle(String titleName) {
        mobileCommands.waitForElementVisibility(enterUPCPopUpMap.ManualEntryTitle());
        mobileCommands.assertElementText(enterUPCPopUpMap.ManualEntryTitle(), titleName, true);
    }

    public void clickKebabMenu() {
        mobileCommands.click(commonPageMap.kebabMenu());
    }

    public void invalidUPCValidation(String errorText) {
        /* Giving an invalid UPC in order to check the "Item Not Found" error message and validating it */
        mobileCommands.enterText(enterUPCPopUpMap.productUPCEditText(), "0014486164562", true);
        mobileCommands.click(enterUPCPopUpMap.btnSubmit());
        mobileCommands.assertElementText(enterUPCPopUpMap.itemNotFoundText(), errorText, true);
        mobileCommands.clear(enterUPCPopUpMap.productUPCEditText());
    }

    /* Validating "Exit Remove From Inventory" functionality and "SignOut" options on Enter UPC and Inventory Updated Screen */
    public void exitFromEnterUPCAndSuccessScreen() {
        mobileCommands.click(commonPageMap.kebabMenu());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.exitRemoveFromInventoryIcon(), true);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.signOutIcon(), true);
        mobileCommands.click(inventoryUpdatedMap.exitRemoveFromInventoryIcon());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.removeFromInventoryIcon(), true);
        mobileCommands.click(inventoryUpdatedMap.removeFromInventoryIcon());
        mobileCommands.click(outdatedMap.btnOutdated());
    }

    public void scanProduct(String upc, Symbology symbology) throws IOException {
        BaseUtil.scanUPC(mobileCommands.getWebDriver(), upc, symbology);
    }

    public void enterOrScanUpcs(Remove_From_Inventory_TestDataBean rfi_Data, Symbology symbology) throws IOException, URISyntaxException, SQLException {
        EnterAmountPage enterAmountPage = new EnterAmountPage();
        ReclaimPage reclaimPage = new ReclaimPage();
        multipleUPCs = rfi_Data.getProductsToScan().split(";");
        for(String UPC : multipleUPCs){
            if (rfi_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                BaseUtil.scanUPC(mobileCommands.getWebDriver(), UPC, symbology);

            }else{
                clickEnterUPC();
                enterUpcEditText(UPC);
                clickSubmitButton();
            }
            mobileCommands.wait(3);
            if(getFlowType().equalsIgnoreCase("Reclaim")) {
                if(getFlowAction().equalsIgnoreCase("Donate")) {
                    enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                    reclaimPage.clickYes();
                    enterAmountPage.clickCorpBrandDonate();
                    reclaimPage.clickContinue();
                    dbHelper.updateHccCd(UPC,"K");
                }else if (getFlowAction().equalsIgnoreCase("Discard")){
                    enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                    reclaimPage.clickYes();
                    enterAmountPage.validateAlertPopUp(rfi_Data.getReclamationMessage());
                    reclaimPage.clickOk();
                    enterAmountPage.validateAlertPopUp(rfi_Data.getLimitedSticker());
                    reclaimPage.clickOk();
                    enterAmountPage.clickCorpBrandDiscard();
                    reclaimPage.clickContinue();
                }
                else if (getFlowAction().equalsIgnoreCase("Markdown")) {
                    enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                    reclaimPage.clickYes();
                    enterAmountPage.validateAlertPopUp(rfi_Data.getReclamationMessage());
                    reclaimPage.clickOk();
                    enterAmountPage.validateAlertPopUp(rfi_Data.getLimitedSticker());
                    reclaimPage.clickOk();
                    enterAmountPage.clickCorpBrandMarkdown();
                    reclaimPage.clickContinue();
                }

            }
            else if(getFlowType().equalsIgnoreCase("Outdated")){
                if(getFlowAction().equalsIgnoreCase("NotUsedForSecondChance")){
                    enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                    enterAmountPage.clickNoSecondChance();
                }
                else if(getFlowAction().equalsIgnoreCase("UsedForSecondChance")){
                    enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                    enterAmountPage.clickYesSecondChance();
                }

                else if(getFlowAction().equalsIgnoreCase("SeePharmacyManager")||getFlowAction().equalsIgnoreCase("SmokingCessation")||getFlowAction().equalsIgnoreCase("Recall")){
                    enterAmountPage.validateMessageTitle(rfi_Data.getMessageTitle());
                }

            }
            else if(getFlowType().equalsIgnoreCase("Donation")){
                enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
                reclaimPage.clickYes();

            }

        }
    }

    public void waitForEnterUPCBtn() {
        mobileCommands.waitForElement(enterUPCPopUpMap.enterUPCButton());
    }

}

