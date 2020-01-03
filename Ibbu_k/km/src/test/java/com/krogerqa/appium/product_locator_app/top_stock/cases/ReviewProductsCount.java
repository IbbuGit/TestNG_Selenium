package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewProductsCount extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private String UPCToScan[];
    private String productStatusMsg[];
    private LogInPage logInPage;
    private TaskListPage taskListPage;
    private TopStockSessionInProgressPopUpPage sessionInProgressPage;
    private TopStockCompletePage completePage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        taskListPage = new TaskListPage();
        sessionInProgressPage = new TopStockSessionInProgressPopUpPage();
        logInPage = new LogInPage();
        mobileCommands = new MobileCommands();
        completePage = new TopStockCompletePage();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateStockedItemsCountAndUPCInReviewPage
     * Test Description:    Validate No Location and Wrong Aisle message
     * Scenario tested:     Scan the Product, select Other location, click Not Stocked Tab
     *                      and Validate No Location and Wrong Aisle message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Not Stocked Tab
     *                      4. Review Validating Stocked UPC's and  count
     */
    public void validateStockedItemsCountAndUPCInReviewPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        for (int i = 0; i < UPCToScan.length; i++) {
            topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
            topStockScanProductPage.scanProduct(UPCToScan[i], Symbology.UPC_A);
            topStockScanProductPage.handleLocationPopupAndClickStockedBtn();
        }
        logOutApp();
        logInPage.login(ts_Data.getUserName1(), ts_Data.getPassword1());
        taskListPage.clickTopStock();
        sessionInProgressPage.clickOnContinue();
        reviewPage.validateStockedNotStockedItemCountAndUPC(UPCToScan, "Stocked");
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateNotStockedItemsCountAndUPCInReviewPage
     * Test Description:    Validate No Location and Wrong Aisle message
     * Scenario tested:     Scan the Product, select Other location, click Not Stocked Tab
     *                      and Validate No Location and Wrong Aisle message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Not Stocked Tab
     *                      4. RReview Validating Stocked UPC's and  count
     */
    public void validateNotStockedItemsCountAndUPCInReviewPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        for (int i = 0; i < UPCToScan.length; i++) {
            topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
            topStockScanProductPage.scanProduct(UPCToScan[i], Symbology.UPC_A);
            topStockScanProductPage.handleLocationPopupAndClickNotStockedBtn();
        }
        logOutApp();
        logInPage.login(ts_Data.getUserName1(), ts_Data.getPassword1());
        taskListPage.clickTopStock();
        sessionInProgressPage.clickOnContinue();
        reviewPage.clickNotStockTab();
        reviewPage.validateStockedNotStockedItemCountAndUPC(UPCToScan, "NotStocked");
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateBOHCountInReviewPage
     * Test Description:    Verify Balance On Hand Count In Review Page
     * Scenario tested:     Scan the Product, select Other location, click Not Stocked Tab
     *                      and Validate No Location and Wrong Aisle message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Not Stocked Tab
     *                      4. Review (Balance Update text)
     */
    public void validateBOHCountInReviewPage() throws Throwable {
        productStatusMsg = ts_Data.getProductStatus().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        //stockShelfPage.ValidateScanProductStockStatus(productStatusMsg[0]);
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(productStatusMsg[1]);
        stockShelfPage.clickOnReviewBtn();
        reviewPage.validateBOHProductsLabel(ts_Data.getBalanceUpdatedLbl());
    }

    /*
     * Test Name:           validateWrongAisleHeaderTxt
     * Test Description:    Validate Wrong Aisle Header Text message
     * Scenario tested:     Scan the Product, select Other location, click Not Stocked Tab
     *                      and Validate No Location and Wrong Aisle message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Not Stocked Tab
     *                      4. Review (No Location and Wrong Aisle message)
     */

    @Test(groups = {"Regression"})
    void validateWrongAisleHeaderTxt() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectOtherLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickNotStockTab();
        reviewPage.verifyWrongAisleText(ts_Data.getWrongAisletxt());
    }

    /*
     * Test Name:           validateNoLocationHeaderInReviewPage
     * Test Description:    Validate No Location Header In Review Page
     * Scenario tested:     Validate No Location popup while scanning the multiple UPCs on
     *                      same Aisle (Use Case 1 & 2)
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. Validate No Location Popup
     */
    @Test(groups = {"Regression"})
    void validateNoLocationHeaderInReviewPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickNotStockTab();
        reviewPage.ValidateNoLocationTxtReviewScreen(ts_Data.getNoLocationTxt());
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           validateDBClearAfterSubmit
         * Test Description:    Verify New Session popup when user logout after submitting the products and login back
         * Scenario tested:     Validate No Location popup while scanning the multiple UPCs on
         *                      same Aisle (Use Case 1 & 2)
         * Story Id:
         * Epic Id:
         * Test data:
         * API tested:
         * UI screen tested:
         *                      1. Scan Product
         *                      2. Confirm Your Location
         *                      3. STOKED the product
         *                      4. Scan the second Product
         *                      5. Click Finish
         *                      6.Validate Location Popup
         */
    void validateDBClearAfterSubmit() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
        completePage.ClickMainMenuBtn();
        taskListPage.clickTopStock();
        logOutApp();
        logInPage.login(ts_Data.getUserName1(), ts_Data.getPassword1());
        taskListPage.clickTopStock();
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.verifyConfirmBtnEnabled();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           validateDBClearAfterClickingNewSessionPopup
         * Test Description:    Verify New Session popup when user logout without submitting the products and login back
         * Scenario tested:     Validate No Location popup while scanning the multiple UPCs on
         *                      same Aisle (Use Case 1 & 2)
         * Story Id:
         * Epic Id:
         * Test data:
         * API tested:
         * UI screen tested:
         *                      1. Scan Product
         *                      2. Confirm Your Location
         *                      3. STOKED the product
         *                      4. Scan the second Product
         *                      5. Validate Location Popup
         */
    void validateDBClearAfterClickingNewSessionPopup() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickContinueBtn();
        topStockScanProductPage.ClickBackArrowButton();
        sessionInProgressPage.clickOnExit();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        sessionInProgressPage.clickOnNewSession();
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.verifyConfirmBtnEnabled();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyNotActionableProductsInReviewScreen
     * Test Description:    Validate Not Actionable Product in Review Screen
     * Scenario tested:     Validate Stocked and Not Stocked UPC Count in Review page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4.
     *                      5.
     */
    public void verifyNotActionableProductsInReviewScreen() throws Throwable {
        String getProductMsg[] = ts_Data.getProductStatus().split(";");
        String stocked=topStockScanProductPage.getUPCwithLocation();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(stocked, Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        //To verify the Product Stocked Message
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[0]);

        UPCToScan = ts_Data.getUpcNo().split(";");
        for (int i = 0; i < UPCToScan.length; i++) {
            topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
            topStockScanProductPage.scanProduct(UPCToScan[i], Symbology.UPC_A);
            //Verifying No stocking needed message
            stockShelfPage.ValidateScanProductStockStatus(getProductMsg[1]);
        }
        stockShelfPage.clickOnReviewBtn();
        reviewPage.validateStockedNotStockedItemCountAndUPC(new String[]{stocked}, "Stocked");
        reviewPage.clickNotStockTab();
        reviewPage.validateUPCnotInStockedNotStockedTabInReviewPage(UPCToScan, "NotStocked");
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyBarcodeNotRecognized
     * Test Description:    validate Barcode Not Recognized
     * Scenario tested:
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Review page
     *                      5. Complete Screen
     */
    public void verifyBarcodeNotRecognized() throws Throwable {
        String stocked[]=new String[1];
        stocked[0]=topStockScanProductPage.setActionableUPC(topStockScanProductPage.getUPCwithLocation());
        UPCToScan=ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.CODE_39);
        topStockScanProductPage.verifyBarCodeNotRecognizedHdr(ts_Data.getBarCodeNotRecognizedTxt());
        topStockScanProductPage.enterUPC(stocked[0]);
        topStockScanProductPage.clickSubmitBtn();
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.validateStockedNotStockedItemCountAndUPC(stocked, "Stocked");
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
    }
}
