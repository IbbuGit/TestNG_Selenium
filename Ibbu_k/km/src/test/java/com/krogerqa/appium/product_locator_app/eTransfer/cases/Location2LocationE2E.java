package com.krogerqa.appium.product_locator_app.eTransfer.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class Location2LocationE2E extends Base {

    private SelectTransferTypePage selectTransferTypePage = new SelectTransferTypePage();
    private TransferListPage transferListPage = new TransferListPage();
    private TransferAmountPage transferAmountPage = new TransferAmountPage();
    private TransferTypePage transferTypePage = new TransferTypePage();
    private SuccessPage successPage = new SuccessPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
    }

    /**
     * Test Name            :   transferBackRoomToSalesFloorWithInventory
     * Test Description     :   Transfer product from BackRoom to Salesfloor and verify BOH transfer
     * Scenario tested      :   User should able transfer product from backroom to sales floor
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory is available for given UPC in test flow)
     * API tested           :   Yes, validated BOH updates on QIB and QOD buckets
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = "e2e")
    public void transferBackRoomToSalesFloorWithInventory() throws Throwable {
        //For Test Data
        String QODQuantity = "1000";
        String QIBQuantity = "1000";
        String QIKQuantity = "100";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity, QIBQuantity, QIKQuantity);

        transferFromToInventory(transferAmount);

        addToListReviewAndSubmit();

        String responseString = getBOH(et_Data.getProductToScan());

        int newQIB = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIB");
        int expectedQIB = Integer.parseInt(QIBQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQIB, expectedQIB, "QIB value is not updated");

        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");
    }

    /**
     * Test Name            :   transferFuelKioskBackRoomWithInventory
     * Test Description     :   Transfer product from fuel kiosk to backroom and verify BOH transfer
     * Scenario tested      :   User should able transfer product from fuel kiosk to backroom
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory is available for given UPC in test flow)
     * API tested           :   Yes, validated BOH updates on QIK and QIB buckets
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = "e2e")
    public void transferFuelKioskBackRoomWithInventory() throws IOException, URISyntaxException {
        //For Test Data
        String QODQuantity = "1000";
        String QIBQuantity = "1000";
        String QIKQuantity = "1000";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity, QIBQuantity, QIKQuantity);

        transferFromToInventory(transferAmount);

        addToListReviewAndSubmit();

        String responseString = getBOH(et_Data.getProductToScan());

        int newQIK = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIK");
        int expectedQIK = Integer.parseInt(QIKQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQIK, expectedQIK, "QIK value is not updated");

        int newQIB = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIB");
        int expectedQIB = Integer.parseInt(QIBQuantity) + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQIB, expectedQIB, "QIB value is not updated");
    }

    /**
     * Test Name            :   transferSalesFloorToFuelKioskWithInventory
     * Test Description     :   Transfer product from sales floor to fuel kiosk and verify BOH transfer
     * Scenario tested      :   User should able transfer product from sales floor to fuel kiosk
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory is available for given UPC in test flow)
     * API tested           :   Yes, validated BOH updates on QOD and QIK buckets
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = "e2e")
    public void transferSalesFloorToFuelKioskWithInventory() throws Throwable {
        //For Test Data
        String QODQuantity = "1000";
        String QIBQuantity = "1000";
        String QIKQuantity = "1000";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity, QIBQuantity, QIKQuantity);

        transferFromToInventory(transferAmount);
        addToListReviewAndSubmit();

        String responseString = getBOH(et_Data.getProductToScan());

        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");

        int newQIK = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIK");
        int expectedQIK = Integer.parseInt(QIKQuantity) + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQIK, expectedQIK, "QIK value is not updated");
    }

    /**
     * Test Name            :   validateTransferWithNegativeInventory
     * Test Description     :   Verify transfer when transfer amount exceeds inventory
     * Scenario tested      :   User should able to transfer when products does not have sufficient inventory
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory less than transfer amount for given UPC in test flow)
     * API tested           :   -
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = "e2e")
    public void validateTransferWithNegativeInventory() throws Throwable {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "1000";
        String QIKQuantity = "1000";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity, QIBQuantity, QIKQuantity);

        transferFromToInventory(transferAmount);
        addToListReviewAndSubmit();

        String responseString = getBOH(et_Data.getProductToScan());

        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");

        int newQIK = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIK");
        int expectedQIK = Integer.parseInt(QIKQuantity) + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQIK, expectedQIK, "QIK value is not updated");
    }

    private void transferFromToInventory(String transferAmount) throws IOException {
        selectTransferTypePage.clickInventoryLocationTransfer();
        transferTypePage.clickTransferPrdFrmDropDown();
        String selectedValue = transferTypePage.selectTransferProductFrom(et_Data.getTransferProductFrom());
        transferTypePage.clickTransferPrdToDropDown();
        transferTypePage.selectTransferPrdToDropDown(selectedValue, et_Data.getTransferProductTo());
        transferTypePage.clickNextButton();
        scanProductPage.scanProduct(et_Data.getProductToScan(), Symbology.UPC_A);
        transferAmountPage.enterInventoryTransferAmount(transferAmount);
        transferAmountPage.addStepNumber();
        transferAmountPage.minusStepNumber();
    }

    private void addToListReviewAndSubmit() {
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();
    }

    private void postBOHUpdate(String QODQuantity, String QIBQuantity, String QIKQuantity) throws IOException {
        String body = dataHelper.updateBOHBody(et_Data.getProductToScan(), QODQuantity, QIKQuantity, QIBQuantity);
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
    }

    private String getBOH(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private int getL1L2Value() throws IOException {
        String body = dataHelper.getItemLookupBody(et_Data.getProductToScan().split(";"));
        String responseString = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        return JsonPathValueExtractor.l1L2Value(responseString);
    }
}

