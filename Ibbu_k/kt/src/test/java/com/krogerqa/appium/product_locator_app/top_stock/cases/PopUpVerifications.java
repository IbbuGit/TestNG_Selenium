package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class PopUpVerifications extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private ScanProductPage scanProductPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockSessionInProgressPopUpPage sessionInProgressPopup;
    private TaskListPage taskListPage;
    private TopStockCompletePage completePage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        scanProductPage = new ScanProductPage();
        sessionInProgressPopup = new TopStockSessionInProgressPopUpPage();
        completePage = new TopStockCompletePage();
        taskListPage = new TaskListPage();
    }


    /*
     * Test Name:           verifyCancelBtnInLocationPopup
     * Test Description:    Validate Cancel button on Location Popup
     * Scenario tested:     Validate Cancel button on Location popup when user scans the product successfully
     *
     * Story Id:            20305
     * Epic Id:
     * Test data:           4000000435
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Verify the Cancel button on location popup
     */
    @Test(groups = {"Regression"})
    public void verifyCancelBtnInLocationPopup() throws IOException, SQLException {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.clickCancelBtn_LocationPopup(ts_Data.getCancelBtn());
    }
    /*
     * Test Name:           verifyConfirmBtnInLocationPopup
     * Test Description:    Validate Confirm button on Location Popup
     * Scenario tested:     Validate Confirm button on Location popup when user scans the product successfully
     *
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Verify the Confirm button on location popup
     */

    @Test(groups = {"Regression"})
    public void verifyConfirmBtnInLocationPopup() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.verifyConfirmButton(ts_Data.getConfirmBtnTxt());
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
    }

    /*
     * Test Name:           ValidateReInitiateSessionsClickNewSession
     * Test Description:    Validate Click New Session after ReInitiate Sessions
     * Scenario tested:
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Stocked the product
     *                      4. Click review and click continue button
     *                      5. Verify Exit popup
     *                      6. Verify New Session
     */

    @Test(groups = {"Regression"})
    void ValidateReInitiateSessionsClickNewSession() throws Throwable {
        topStockScanProductPage.ClickNewSession();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.validateAndClickStockBtn(ts_Data.getStockBtn());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnBackBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ClickCrossButton();
        //sessionInProgressPopup.verifyExitPopupTitle(ts_Data.getExitPopupTitle());
        sessionInProgressPopup.clickOnExit();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        sessionInProgressPopup.verifySessionInProgressHdr(ts_Data.getSessionInProgressHdrTxt());
        sessionInProgressPopup.clickOnNewSession();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           ValidateReInitiateSessionsClickContinue
         * Test Description:    Validate Click Continue after ReInitiate Sessions
         * Scenario tested:
         * Story Id:
         * Epic Id:
         * Test data:
         * API tested:
         * UI screen tested:
         *                      1. Scan Product
         *                      2. Confirm Your Location
         *                      3. Stocked the product
         *                      4. Click review and click continue button
         *                      5. Verify Exit popup
         *                      6. Verify Continue
         */
    void ValidateReInitiateSessionsClickContinue() throws Throwable {
        topStockScanProductPage.ClickNewSession();
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        scanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.validateAndClickStockBtn(ts_Data.getStockBtn());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnBackBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ClickCrossButton();
        //sessionInProgressPopup.verifyExitPopupTitle(ts_Data.getExitPopupTitle());
        sessionInProgressPopup.clickOnExit();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        sessionInProgressPopup.verifySessionInProgressHdr(ts_Data.getSessionInProgressHdrTxt());
        sessionInProgressPopup.clickOnContinue();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompleteThankYouMsg(ts_Data.getCompleteThankYouMsgTxt());
    }
}
