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

public class Department2DepartmentE2E extends Base {

    private SelectTransferTypePage selectTransferTypePage = new SelectTransferTypePage();
    private TransferListPage transferListPage = new TransferListPage();
    private TransferAmountPage transferAmountPage = new TransferAmountPage();
    private SuccessPage successPage = new SuccessPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private DepartmentListPage departmentListPage = new DepartmentListPage();
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private HttpClientExecutor apiExecutor;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
    }

    /**
     * Test Name            :   transferProductFromDeptToDept
     * Test Description     :   Transfer product from one dept to other dept and verify product BOH update (BOH should be reduced)
     * Scenario tested      :   User should able transfer product from one dept to other dept
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (Making sure inventory is available for given UPC in test flow)
     *                          UPC can be DSD or non-DSD
     * API tested           :   Yes, validated BOH updates on QOD
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferProductFromDeptToDept() throws Throwable {

        String QODQuantity = "1000";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity);
        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        String responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");
    }

    /**
     * Test Name            :   transferNonDSDProductFromDeptToDeptWithNegativeBOH
     * Test Description     :   Verify transfer for non DSD product when there is no sufficient balance
     * Scenario tested      :   User should able transfer non-DSD product when it does not have sufficient balance
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (no sufficient BOH and Non-DSD product)
     * API tested           :   -
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferNonDSDProductFromDeptToDeptWithNegativeBOH() throws Throwable {

        String QODQuantity = "-100";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity);
        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        String responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");
    }

    /**
     * Test Name            :   transferDSDProductFromDeptToDeptWithNegativeBOH
     * Test Description     :   Transfer DSD product with -ve BOH and verify BOH
     * Scenario tested      :   User should able transfer DSD product with -Ve BOH balance also
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC transfer (-Ve BOH and DSD product)
     * API tested           :   Validated BOH update
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void transferDSDProductFromDeptToDeptWithNegativeBOH() throws Throwable {

        String QODQuantity = "-100";
        String transferAmount = "400";

        postBOHUpdate(QODQuantity);
        transferInventoryFlow(transferAmount);
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.clickOnBackToMainMenuButton();

        String responseString = getBOH(et_Data.getProductToScan());
        int newQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
        int expectedQOD = Integer.parseInt(QODQuantity) - Integer.parseInt(transferAmount) * getL1L2Value();
        Assert.assertEquals(newQOD, expectedQOD, "QOD value is not updated");
    }

    private void transferInventoryFlow(String transferAmount) throws IOException {
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
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

    private int getL1L2Value() throws IOException {
        String body = dataHelper.getItemLookupBody(et_Data.getProductToScan().split(";"));
        String responseString = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        return JsonPathValueExtractor.l1L2Value(responseString);
    }
}
