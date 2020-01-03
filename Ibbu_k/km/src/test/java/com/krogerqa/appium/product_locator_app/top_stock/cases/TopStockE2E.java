package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TopStockE2E extends Base {

    private TaskListPage taskListPage = new TaskListPage();
    private TopstockProductStockMessagePage topstockProductStockMessagePage = new TopstockProductStockMessagePage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private TopstockScanProductPage topStockScanProductOrderPage ;
    private TopStockReviewPage topStockReviewPage = new TopStockReviewPage();
    private TopStockCompletePage topStockCompletePage = new TopStockCompletePage();
    private TopStockSessionInProgressPopUpPage topStockInProgressPopUp = new TopStockSessionInProgressPopUpPage();
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private String body = null;

    private HttpClientExecutor apiExecutor;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        topStockScanProductOrderPage = new TopstockScanProductPage(login_Data,prop);
    }

    /**
     * Test Name            :   stockProductAndVerifyInReviewPageWithUpdateBOH
     * Test Description     :   Update the BOH When UPS has incorrect BOH, Stock the product and verify in review page
     * Scenario tested      :   Scan Product > Update the BOH > Select Stocked option > Review the stocked product in Review page > Finish it
     *                          (Make sure Test data UPC has -ve BOH value (for that we are calling updateBOH API to make it -ve)
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC (making Actionable flag true)
     * API tested           :   Not required
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void stockProductAndVerifyInReviewPageWithUpdateBOH() throws Throwable {
        String QOD = "-1", QIK = "-2", QIB = "-1";
        body = dataHelper.updateBOHBody(ts_Data.getUpcNo(), QOD, QIK, QIB);
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);

        scanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);

        topStockScanProductOrderPage.optionBtnlocationselection();
        topstockProductStockMessagePage.EnterBalanceUnit(ts_Data.getBalanceUnit());

        topstockProductStockMessagePage.ClickUpdateBalanceBtn();

        topstockProductStockMessagePage.clickStockedBtn();
        topstockProductStockMessagePage.clickOnReviewBtn();
        topStockReviewPage.validateStockedItem(ts_Data.getUpcNo());
        topStockReviewPage.clickOnFinishBtn();

        apiExecutor.getHttpClient(prop.getProperty("getBOH"), dataHelper.getBOHParams(ts_Data.getUpcNo()));
        int actualQOD = JsonPathValueExtractor.extractBOHBucketValue(
                apiExecutor.getHttpClient(prop.getProperty("getBOH"), dataHelper.getBOHParams(ts_Data.getUpcNo())),
                "QOD");
        Assert.assertEquals(actualQOD, Integer.parseInt(ts_Data.getBalanceUnit()) + Integer.parseInt(QOD), "QOD value is not updated");
    }

    /**
     * Test Name            :   savedSessionExistsAndSubmitItAndNoStockingNeededMessage
     * Test Description     :   Verify session exists in top stock & no stocking needed message with in 15 mins after stocking
     * Scenario tested      :   Scan Product > Select Stocked option > Review the stocked product in Review page > Go back to Main Menu options (TaskList) >
     *                          Go back to top Stock > Verify session exists > Go back to scan page > Scan same product >
     *                          Verify No Stocking needed message > Finish the flow
     *                          (Make sure Test data UPC has Actionable Flag as True (For that we are calling updateBOH api to make BOH < Case Quantity))
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC (making Actionable flag true)
     * API tested           :   Not required
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void savedSessionExistsAndSubmitItAndNoStockingNeededMessage() throws Throwable {
        body = dataHelper.updateBOHBody(ts_Data.getUpcNo(), "1", "1", "1");
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);

        scanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);

        topStockScanProductOrderPage.optionBtnlocationselection();

        topstockProductStockMessagePage.clickStockedBtn();
        topstockProductStockMessagePage.clickOnReviewBtn();

        topStockReviewPage.clickOnBackBtn();

        scanProductPage.clickOnBackBtn();

        topStockInProgressPopUp.clickOnExit();
        taskListPage.clickTopStock();
        topStockInProgressPopUp.clickOnContinue();

        topStockReviewPage.validateStockedItem(ts_Data.getUpcNo());

        topStockReviewPage.clickOnBackBtn();

        scanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);

        topstockProductStockMessagePage.ValidateScanProductStockStatus(ts_Data.getProductStatus());

        topstockProductStockMessagePage.clickOnReviewBtn();

        topStockReviewPage.clickOnFinishBtn();
    }

    /**
     * Test Name            :   stockProductAndVerifyInReviewPageWithUpdateBOH
     * Test Description     :   Update the BOH When UPS has incorrect BOH, Stock the product and verify in review page
     * Scenario tested      :   Scan Product > Select NoT Stocked option > Review the not stocked product in Review page > Finish it
     *                          Make sure Test data UPC has Actionable Flag as True (For that we are calling updateBOH api to make BOH < Case Quantity)
     * Story id             :   -
     * Epic id              :   -
     * Test data            :   Single UPC (making Actionable flag true)
     * API tested           :   Not required
     * UI screen tested     :   UI flow tested
     */
    @Test(groups = {"e2e"})
    public void notStockedProductAndVerifyInReviewPage() throws Throwable {
        body = dataHelper.updateBOHBody(ts_Data.getUpcNo(), "1", "1", "1");
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);

        scanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);

        topStockScanProductOrderPage.optionBtnlocationselection();

        topstockProductStockMessagePage.clickOnNotStockedBtn();
        topstockProductStockMessagePage.clickOnReviewBtn();

        //topStockReviewPage.ClickNotstockbtn();
        topStockReviewPage.clickNotStockTab();
        topStockReviewPage.validateStockedItem(ts_Data.getUpcNo());

        topStockReviewPage.clickOnFinishBtn();

        topStockCompletePage.ClickMainMenuBtn();
    }
}