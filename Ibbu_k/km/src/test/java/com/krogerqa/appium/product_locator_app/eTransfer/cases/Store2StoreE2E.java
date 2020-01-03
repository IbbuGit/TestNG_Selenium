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

public class Store2StoreE2E extends Base {
    private SelectTransferTypePage selectTransferTypePage = new SelectTransferTypePage();
    private TransferListPage transferListPage = new TransferListPage();
    private TransferAmountPage transferAmountPage = new TransferAmountPage();
    private SuccessPage successPage = new SuccessPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private StoreListPage storeListPage = new StoreListPage();
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
    }

    /**
     * Test Name            :   transferProductFromS2S
     * Test Description     :   Transfer product from one store to other store and verify From Store BOH needs to reduce and
     *                          To Store BOH increases
     * Scenario tested      :   User should able transfer product from one store to other store
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory is available for given UPC in test flow)
     *                          UPC can be DSD or non-DSD
     * API tested           :   Yes, validated BOH updates on QOD in From store and To Store
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferProductFromS2S() throws IOException, URISyntaxException {
        String QODQuantity = "1000";
        String transferAmount = "400";

        String responseString = getBOHInToStore(et_Data.getProductToScan());
        int QODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");

        postBOHUpdate(QODQuantity);

        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        //Validation in From Store QOD
        responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");

        //Validation in To Store QOD
        responseString = getBOHInToStore(et_Data.getProductToScan());
        int newQODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedNewQODInToStore = QODInToStore + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQODInToStore, expectedNewQODInToStore, "QOD value is not updated in to Store");

    }

    /**
     * Test Name            :   transferNonDSDProductFromS2SWithNegativeBOHVerifyErrorPopUp
     * Test Description     :   Verify error message for non DSD product when there is no sufficient balance
     * Scenario tested      :   User should able transfer non-DSD product when it does not have sufficient balance
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (no sufficient BOH and Non-DSD product)
     * API tested           :   -
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferNonDSDProductFromS2SWithNegativeBOH() throws Throwable {
        String QODQuantity = "-100";
        String transferAmount = "400";

        String responseString = getBOHInToStore(et_Data.getProductToScan());
        int QODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");

        postBOHUpdate(QODQuantity);
        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        //Validation in From Store QOD
        responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");

        //Validation in To Store QOD
        responseString = getBOHInToStore(et_Data.getProductToScan());
        int newQODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedNewQODInToStore = QODInToStore + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQODInToStore, expectedNewQODInToStore, "QOD value is not updated in to Store");
    }

    /**
     * Test Name            :   transferDSDProductFromS2StWithNegativeBOH
     * Test Description     :   Transfer DSD product with -ve BOH and verify BOH from Store to Store
     * Scenario tested      :   User should able transfer DSD product with -Ve BOH balance also
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (-Ve BOH and DSD product)
     * API tested           :   Validated BOH update
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferDSDProductFromS2StWithNegativeBOH() throws Throwable {
        String QODQuantity = "-100";
        String transferAmount = "400";

        String responseString = getBOHInToStore(et_Data.getProductToScan());
        int QODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");

        postBOHUpdate(QODQuantity);

        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        //Validation in From Store QOD
        responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");

        //Validation in To Store QOD
        responseString = getBOHInToStore(et_Data.getProductToScan());
        int newQODInToStore = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedNewQODInToStore = QODInToStore + Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQODInToStore, expectedNewQODInToStore, "QOD value is not updated in to Store");

    }

    private void transferInventoryFlow(String transferAmount) throws IOException {
        selectTransferTypePage.clickStoreToStore();
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        scanProductPage.scanProduct(et_Data.getProductToScan(), Symbology.UPC_A);
        transferAmountPage.enterInventoryTransferAmount(transferAmount);
        transferAmountPage.addStepNumber();
        transferAmountPage.minusStepNumber();
    }

    private void postBOHUpdate(String QODQuantity) throws IOException {
        String body = dataHelper.updateBOHBody(et_Data.getProductToScan(), QODQuantity, null, null);
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
    }

    private String getBOH(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private String getBOHInToStore(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(et_Data.getStoreNumber(), et_Data.getDivisionNumber(), UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private int getL1L2Value() throws IOException {
        String body = dataHelper.getItemLookupBody(et_Data.getProductToScan().split(";"));
        String responseString = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        return JsonPathValueExtractor.l1L2Value(responseString);
    }
}

