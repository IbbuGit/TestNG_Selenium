package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class ScannerDisabledScenarios extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private ScanProductPage scanProductPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockCompletePage completePage;
    private String UPCToScan[];
    TopStockSessionInProgressPopUpPage sessionInProgressPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        scanProductPage = new ScanProductPage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        sessionInProgressPage = new TopStockSessionInProgressPopUpPage();
        completePage = new TopStockCompletePage();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabledInLocationPopup
     * Test Description:    Validate Scanner Disabled in Location popup
     * Scenario tested:     Validate Scanner Disabled in No Location popup
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
    public void verifyScannerDisabledInLocationPopup() throws IOException, SQLException {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.verifyConfirmBtnEnabled();
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.verifyConfirmBtnEnabled();
        topStockScanProductPage.clickLocationConfirmBtn();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_BalanceUpdatedPage
     * Test Description:    Validate Scanner Disabled in BalanceUpdated Page
     * Scenario tested:     Validate Scanner disabled in BalanceUpdatedPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. BalanceUpdatedPage
     */
    public void verifyScannerDisabled_BalanceUpdatedPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyBOHHeaderText(ts_Data.getUpdateBalanceHdr());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        stockShelfPage.verifyBOHHeaderText(ts_Data.getUpdateBalanceHdr());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_StockShelfPage
     * Test Description:    Validate Scanner Disabled in StockShelf Page
     * Scenario tested:     Validate Scanner disabled in StockShelfPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. StockShelfPage
     */
    public void verifyScannerDisabled_StockShelfPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_ReviewPage
     * Test Description:    Validate Scanner Disabled in Review Page
     * Scenario tested:     Validate Scanner disabled in ReviewPage
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
    public void verifyScannerDisabled_ReviewPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_StockedPage
     * Test Description:    Validate Scanner Disabled in Stocked Page
     * Scenario tested:     Validate Scanner disabled in StockedPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. Validate StockedPage
     */
    public void verifyScannerDisabled_StockedPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.verifyClickingOnStockedProduct();
        reviewPage.verifyStockedHdr(ts_Data.getStockedHdr());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        reviewPage.verifyStockedHdr(ts_Data.getStockedHdr());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_NotStockedPage
     * Test Description:    Verify Scanner Disabled in NotStockedPage
     * Scenario tested:     Validate Scanner disabled in NotStockedPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. Validate NotStockedPage
     */
    public void verifyScannerDisabled_NotStockedPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnNotStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickNotStockTab();
        reviewPage.verifyClickingOnNotStockedProduct();
        reviewPage.verifyNotStockedHdr(ts_Data.getNotStockedHdr());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        reviewPage.verifyNotStockedHdr(ts_Data.getNotStockedHdr());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_RelocateProductPage
     * Test Description:    Validate Scanner Disabled in RelocateProductPage
     * Scenario tested:     Validate Scanner disabled in RelocateProductPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Review page
     *                      4. Not stocked tab
     *                      5. Validate RelocateProductPage
     */
    public void verifyScannerDisabled_RelocateProductPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickNotStockTab();
        reviewPage.clickOnWrongAisleTxt();
        reviewPage.verifyRelocateProductPageHdr(ts_Data.getRelocateProductTxt());
        scanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        reviewPage.verifyRelocateProductPageHdr(ts_Data.getRelocateProductTxt());
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabled_CompletePage
     * Test Description:    Verify Scanner Disabled in Complete Page
     * Scenario tested:     Validate Scanner disabled in CompletePage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. Validate CompletePage
     */
    public void verifyScannerDisabled_CompletePage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           verifyScannerDisabledInBarCodeNotRecognisedPage
     * Test Description:    Validate Scanner Disabled in Review Page
     * Scenario tested:     Validate Scanner disabled in ReviewPage
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
    public void verifyScannerDisabledInBarCodeNotRecognisedPage() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.CODE_39);
        topStockScanProductPage.verifyBarCodeNotRecognizedHdr(ts_Data.getBarCodeNotRecognizedTxt());
        topStockScanProductPage.scanProduct(UPCToScan[1], Symbology.UPC_A);
        topStockScanProductPage.verifyBarCodeNotRecognizedHdr(ts_Data.getBarCodeNotRecognizedTxt());
    }
}
