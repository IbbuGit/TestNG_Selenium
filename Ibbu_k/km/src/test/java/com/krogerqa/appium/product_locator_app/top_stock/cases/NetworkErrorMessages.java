package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopStockReviewPage;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopstockProductStockMessagePage;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopstockScanProductPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class NetworkErrorMessages extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topstockScanProductPage;
    private TopStockReviewPage reviewPage;
    private CommonPage commonPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topstockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        commonPage = new CommonPage();
    }

    @AfterMethod(alwaysRun = true)
    public void enableWiFi(Method test) throws InterruptedException {
        commonPage.enableWiFi();
        commonPage.enableMobileData();
    }
    /*
     * Test Name:           verifyNetworkErrorMsgInScanProductPage
     * Test Description:    Validate Network Error Message
     * Scenario tested:     Scan the Product, select location,Click Confirm Button,Verify Network Error Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Verify Network Error Message
     */

    @Test(groups = {"Regression"})
    public void verifyNetworkErrorMsgInScanProductPage() throws Throwable {
        topstockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topstockScanProductPage.scanProduct(topstockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topstockScanProductPage.selectLocation();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        topstockScanProductPage.clickLocationConfirmBtn();
        topstockScanProductPage.verifyNetWorkErrorMessage(ts_Data.getNetworkErrorMsg());
    }
    /*
     * Test Name:           verifyNetworkErrorMsgInClickStockedBtn
     * Test Description:    Validate Network Error Message on clicking stocked button
     * Scenario tested:     Scan the Product, select location,Click Confirm Button,  Click Stocked button,Verify Network Error Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Stocked Button
     *                      4. Verify Network Error Message
     */

    @Test(groups = {"Regression"})
    public void verifyNetworkErrorMsgInClickStockedBtn() throws Throwable {
        topstockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topstockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topstockScanProductPage.selectLocation();
        topstockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        stockShelfPage.clickStockedBtn();
        topstockScanProductPage.verifyNetWorkErrorMessage(ts_Data.getNetworkErrorMsg());
    }
    /*
     * Test Name:           verifyNetworkErrorMsgInClickNotStockedBtn
     * Test Description:    Validate Network Error Message on clicking Not Stocked Button
     * Scenario tested:     Scan the Product, select location,Click Confirm Button,  Click Not Stocked button,Verify Network Error Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Not Stocked Button
     *                      4. Verify Network Error Message
     */

    @Test(groups = {"Regression"})
    public void verifyNetworkErrorMsgInClickNotStockedBtn() throws Throwable {
        topstockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topstockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topstockScanProductPage.selectLocation();
        topstockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        stockShelfPage.clickOnNotStockedBtn();
        topstockScanProductPage.verifyNetWorkErrorMessage(ts_Data.getNetworkErrorMsg());
    }
    /*
     * Test Name:           verifyNetworkErrorMsgInClickFinishBtn
     * Test Description:    Validate Network Error Message on clicking Finish Button
     * Scenario tested:     Scan the Product, select location,Click Confirm Button, Click Stocked button,
     *                      Click On Review Button and Verify Network Error Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Stocked Button
     *                      4. Click On Review Button
     *                      5. Click on Finish Button
     *                      6. Verify Network Error Message
     */

    @Test(groups = {"Regression"})
    public void verifyNetworkErrorMsgClickReviewBtn() throws Throwable {
        topstockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topstockScanProductPage.scanProduct(topstockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topstockScanProductPage.selectLocation();
        topstockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        stockShelfPage.clickOnReviewBtn();
        topstockScanProductPage.verifyNetWorkErrorMessage(ts_Data.getNetworkErrorMsg());
    }
    /*
     * Test Name:           verifyNetworkErrorMsgInClickFinishBtn
     * Test Description:    Validate Network Error Message on clicking Finish Button
     * Scenario tested:     Scan the Product, select location,Click Confirm Button, Click Stocked button,
     *                      Click On Review Button,Click On Finish ButtonVerify Network Error Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Stocked Button
     *                      4. Click On Review Button
     *                      5. Click on Finish Button
     *                      6. Verify Network Error Message
     */

    @Test(groups = {"Regression"})
    public void verifyNetworkErrorMsgInClickFinishBtn() throws Throwable {
        topstockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topstockScanProductPage.scanProduct(topstockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topstockScanProductPage.selectLocation();
        topstockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        reviewPage.clickOnFinishBtn();
        topstockScanProductPage.verifyNetWorkErrorMessage(ts_Data.getNetworkErrorMsg());
    }
}
