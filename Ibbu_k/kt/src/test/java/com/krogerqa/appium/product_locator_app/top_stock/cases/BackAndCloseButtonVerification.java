package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class BackAndCloseButtonVerification extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockCompletePage completePage;
    private MobileCommands mc;
    private TaskListPage taskListPage;
    private String getProductMsg[];
    private String getUpcNumber[];

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        completePage = new TopStockCompletePage();
        mc = new MobileCommands();
        taskListPage = new TaskListPage();
     }

    /*
     * Test Name:           validateAndroidBackButtonInScanProductPage
     * Test Description:    Verify Android Back Button in scan product page
     * Scenario tested:     Scan a Product, select location, click on Scan product page Android back arrow,
     *                         follow the same procedure for multiple products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. Stocked screen
     *                      4. Stock Shelf Screen
     */
    @Test(groups = {"Regression"})
    public void validateAndroidBackButtonInScanProductPage() throws Throwable {
        getProductMsg = ts_Data.getProductStatus().split(";");
        getUpcNumber=ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        mc.browserBack();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        //To verify Android back Button from Stock Shelf Screen
        topStockScanProductPage.scanProduct(getUpcNumber[0],Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        //To verify Android Back Button from Product Stocked message screen
        topStockScanProductPage.scanProduct(getUpcNumber[1],Symbology.UPC_A);
        topStockScanProductPage.selectLocation(2);
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        //To verify Product Stocked Message
        stockShelfPage.ValidateProductStatus(getProductMsg[0]);
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        //To verify Android Back Button from No Stocking Needed screen
        topStockScanProductPage.scanProduct(getUpcNumber[1], Symbology.UPC_A);
        //To verify No Stocking Needed Message
        stockShelfPage.ValidateProductStatus(getProductMsg[1]);
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateAndroidBackButtonInUpdateCountBOHPage
     * Test Description:    Verify Android Back Button in BOH page
     * Scenario tested:     Scan a Product, select location, click on Scan product page browser back arrow,
     *                      follow the same procedure for multiple products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. BOH Update balance screen
     */
    public void validateAndroidBackButtonInUpdateCountBOHPage() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyBOHHeaderText(ts_Data.getUpdateBalanceHdr());
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }

    /*
     * Test Name:           validateAndroidBackButtonInShelfAlreadyFullPage
     * Test Description:    Verify Android Back Button in ShelfAlreadyFullPage
     * Scenario tested:     Scan a Product, select location, Click NotStocked button,verify product status,
                            click on ShelfAlreadyFullPage browser back arrow
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. NotStocked screen
     *                      4. Verify product status
     */

    @Test(groups = {"Regression"})
    public void validateAndroidBackButtonInShelfAlreadyFullPage() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(),Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickNotStockedBtn();
        //To verify Shelf Already Full Message
        stockShelfPage.ValidateProductStatus(ts_Data.getProductStatus());
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }
    /*
     * Test Name:           validateAndroidBackButtonInReviewPage
     * Test Description:    Verify Android Back Button in ReviewPage
     * Scenario tested:     Scan a Product, select location, Click Stocked button,verify product status,
                            Click Review Button,Click on ReviewPage browser back arrow
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. Stocked screen
     *                      4. Verify product status
     */

    @Test(groups = {"Regression"})
    public void validateAndroidBackButtonInReviewPage() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        //To verify Product stocked Message
        stockShelfPage.ValidateProductStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        mc.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }
     /*
     * Test Name:           validateAndroidBackButtonInCompletePage
     * Test Description:    Verify Android Back Button in CompletePage
     * Scenario tested:     Scan a Product, select location, Click Stocked button,verify product status,
                            Click Review Button,Click on Finish Button,Click on Thank You Page browser back arrow
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. Stocked screen
     *                      4. Verify product status
     *                      5. Thank Tou screen
     */

    @Test(groups = {"Regression"})
    public void validateAndroidBackButtonInCompletePage() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        //To verify Product stocked Message
        stockShelfPage.ValidateProductStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
        mc.browserBack();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
    }
    /*
     * Test Name:           validateAndroidBackButtonInRelocateProductPage
     * Test Description:    Verify Android Back Button in RelocateProductPage
     * Scenario tested:     Scan a Product, select location, Click NotStocked button,verify product status,
                            Click Review Button,Click on Wrong Aisle text,Click on Relocate Product Page browser back arrow
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location Pop-up
     *                      3. NotStocked screen
     *                      4. Verify product status
     *                      5. Relocate Product pge
     */

    @Test(groups = {"Regression"})
    public void validateAndroidBackButtonInRelocateProductPage() throws Throwable {
        getUpcNumber = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(getUpcNumber[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickNotStockedBtn();
        stockShelfPage.ValidateProductStatus(ts_Data.getProductStatus());
        topStockScanProductPage.scanProduct(getUpcNumber[1], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.clickNotStockTab();
        reviewPage.clickOnWrongAisleTxt();
        reviewPage.verifyRelocateProductPageHdr(ts_Data.getRelocateProductTxt());
        mc.browserBack();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
    }

    /*
     * Test Name:           ValidateBackAndCloseButtonForBOHProducts
     * Test Description:    Verify Back and Close Button for BOH Products
     * Scenario tested:     Validate the functional flow while clicking Back and Close buttons
     *                      for BOH Products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Back Button OR Cross Button
     *                      4. Validate the Scan Product
     */
    @Test(groups = {"Regression"})
    void ValidateBackAndCloseButtonForBOHProducts() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ClickBackArrowButton();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        String BOHHeaderTxt = ts_Data.getStockShelfHdrTxt();
        String[] BOHHeaderTxt1 = BOHHeaderTxt.split(";");
        stockShelfPage.ValidateBOHHeaderText(BOHHeaderTxt1[0]);
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        stockShelfPage.ValidateBOHHeaderText(BOHHeaderTxt1[0]);
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(BOHHeaderTxt1[1]);
    }

    /*
     * Test Name:           ValidateBackAndCloseButtonForStockedProducts
     * Test Description:    Verify Back and Close Button for Stocked Products
     * Scenario tested:     Validate the functional flow while clicking Back and Close buttons
     *                      for Stocked Products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Back Button OR Cross Button
     *                      4. Validate the Scan Product
     */
    @Test(groups = {"Regression"})
    void ValidateBackAndCloseButtonForStockedProducts() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ClickBackArrowButton();
        topStockScanProductPage.verifyTopStockBtn();
        taskListPage.clickTopStock();
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }

    /*
     * Test Name:           ValidateBackAndCloseButtonForNoStockingProducts
     * Test Description:    Verify Back and Close Button for No Stocking Products
     * Scenario tested:     Validate the functional flow while clicking Back and Close buttons
     *                      for No Stocking Needed Products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Back Button OR Cross Button
     *                      4. Validate the Scan Product
     */
    @Test(groups = {"Regression"})
    void ValidateBackAndCloseButtonForNoStockingProducts() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnNotStockedBtn();
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.clickOnReviewBtn_ScanProductScreen();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.ValidateAndClickFinishBtn(ts_Data.getFinishBtn());
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
    }

    /*
     * Test Name:           ValidateBackAndCloseButtonForNotStockedProducts
     * Test Description:    Verify Back and Close Button for Not Stocked Products
     * Scenario tested:     Validate the functional flow while clicking Back and Close buttons
     *                      for Not Stocked Products
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Back Button OR Cross Button
     *                      4. Validate the Scan Product
     */
    @Test(groups = {"Regression"})
    void ValidateBackAndCloseButtonForNotStockedProducts() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickOnNotStockedBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.ClickCrossButton();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
    }
}
