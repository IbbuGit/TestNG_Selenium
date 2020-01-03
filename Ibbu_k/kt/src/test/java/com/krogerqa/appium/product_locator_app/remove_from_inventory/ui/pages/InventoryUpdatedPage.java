package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.dataBeans.Remove_From_Inventory_TestDataBean;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.EnterAmountMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.InventoryUpdatedMap;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.http.NameValuePair;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class InventoryUpdatedPage {
    MobileCommands mobileCommands = new MobileCommands();
    EnterAmountMap enterAmountMap = new EnterAmountMap();
    InventoryUpdatedMap inventoryUpdatedMap = new InventoryUpdatedMap();
    ReviewScreenPage reviewScreenPage = new ReviewScreenPage();
    DBHelper dbHelper = new DBHelper();
    String ActualValue = "";
    String DisplayedValue = "";
    private String expectedChangedReasonCode = "";
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;
    private Properties prop;
    private String rfiJobId = "";
    private String flowType = "";
    private String flowAction = "";

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

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private void initHttpClientExecutor(Login_TestDataBean login_Data) {
        if (this.apiExecutor == null) {
            this.apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
            this.dataHelper = new ApiRequestDataHelper();
        }
    }

    /* Validating all components on "Inventory Updated" screen and "Back to Main Menu" functionality */
    public void validateInventoryUpdatedScreen(String reasonCode) {
        mobileCommands.click(enterAmountMap.submitButton());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.inventoryUpdatedIcon(), true);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.greatJobText(), true);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.productsRemovedText(), true);
        DisplayedValue = mobileCommands.getElementText(inventoryUpdatedMap.reasonCodeText(reasonCode));
        ActualValue = reviewScreenPage.reviewScreenTitleText(reasonCode);
        Assert.assertEquals(DisplayedValue, ActualValue);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.backToMainMenu(), true);
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.moreOptionsEllipsis(), true);
        mobileCommands.click(inventoryUpdatedMap.backToMainMenu());
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.removeFromInventoryIcon(), true);
    }

    public void waitForBackToMainMenuButton() {
        mobileCommands.waitForElementVisibility(inventoryUpdatedMap.backToMainMenu());
    }

    public void validateRemoveFromInventoryIcon() {
        mobileCommands.assertElementDisplayed(inventoryUpdatedMap.removeFromInventoryIcon(), true);
    }

    public void validateQodBucket(Login_TestDataBean loginData, Remove_From_Inventory_TestDataBean rfi_Data, HashMap<String, Integer> countQODListBefore) throws IOException, URISyntaxException {
        initHttpClientExecutor(loginData);
        Set<String> multipleUPCs = countQODListBefore.keySet();
        for (String UPC : multipleUPCs) {
/*
        String body = dataHelper.getItemLookupBody(upcs);
        String responseItemLookup = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        List<String> baseUpcs = JsonPath.read(responseItemLookup, "$..baseItem.upc");

 */
            int incrVal = Integer.parseInt(rfi_Data.getIncrVal());
            int currentBohVal = getBOHCount(UPC);
            if (getFlowType().equalsIgnoreCase("Reclaim") && getFlowAction().equals("Markdown")) {
                mobileCommands.wait(3);
                Assert.assertTrue(countQODListBefore.get(UPC) == currentBohVal, "QOD is not updated for the UPC " + UPC);
            } else {
                mobileCommands.wait(3);
                Assert.assertTrue(countQODListBefore.get(UPC) - incrVal == currentBohVal, "QOD is not updated for the UPC " + UPC);
                System.out.println("UPC : " + UPC + " before -> " + countQODListBefore.get(UPC) + " after -> " + currentBohVal);
            }
        }
    }

    private int getBOHCount(String upc) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(upc);
        String response = apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
        int qod = JsonPathValueExtractor.extractBOHBucketValue(response, "QOD");
        return qod;
    }

    int getBOHCount(String upc, Login_TestDataBean loginData) throws IOException, URISyntaxException {
        initHttpClientExecutor(loginData);
        return getBOHCount(upc);
    }

    public void setRfiJobId(Login_TestDataBean loginData) throws SQLException {
        String queryToRun = "SELECT MAX(REMOVE_FROM_INVENTORY_JOB_ID) REMOVE_FROM_INVENTORY_JOB_ID " +
                "FROM REMOVE_FROM_INVENTORY_JOB WHERE EUID = '" + loginData.getUsername() +
                "' AND ENDUTC_TS is NULL;";
        String rfiJobIdJson = dbHelper.executeDBStatment("rfi", queryToRun);
        String expression = "$..REMOVE_FROM_INVENTORY_JOB_ID";
        List<Integer> jobIdList = JsonPath.read(rfiJobIdJson, expression);
        this.rfiJobId = jobIdList.get(0).toString();
    }

    public void validateChangedReasonCodes(String productsToScan, String expectedChangedReasonCode) throws SQLException {
        this.expectedChangedReasonCode = expectedChangedReasonCode;
        for (String UPC : productsToScan.split(";")) {
            validateChangedReasonCode(UPC);
        }
    }

    private void validateChangedReasonCode(String upc) throws SQLException {
        String queryToRun = "SELECT CHANGED_REASON_CD FROM REMOVE_FROM_INVENTORY_ACTIVITY " +
                "WHERE REMOVE_FROM_INVENTORY_JOB_ID = " + this.rfiJobId + " AND CONSUMER_UPC_NO = '" + upc + "';";
        String changedReasonCdJson = dbHelper.executeDBStatment("rfi", queryToRun);
        String expression = "$..CHANGED_REASON_CD";
        List<String> changedReasonCdList = JsonPath.read(changedReasonCdJson, expression);
        Assert.assertTrue(changedReasonCdList.size() > 0, "Did not get any result from DB");
        String changedReasonCode = changedReasonCdList.get(0);
        Assert.assertTrue(this.expectedChangedReasonCode.equalsIgnoreCase(changedReasonCode),
                "Changed Reason Code is not updated to " + this.expectedChangedReasonCode);

    }

}
