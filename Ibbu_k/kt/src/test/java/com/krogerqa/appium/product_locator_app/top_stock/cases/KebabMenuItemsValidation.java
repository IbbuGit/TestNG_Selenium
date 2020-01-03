package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopStockKababMenuPage;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopStockReviewPage;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopstockProductStockMessagePage;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopstockScanProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class KebabMenuItemsValidation extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockKababMenuPage kababMenuPage;
    private CommonPage commonPage;
    private TaskListPage taskListPage;
    private LogInPage logInPage;
    private String productStatusMsg[];

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        kababMenuPage = new TopStockKababMenuPage();
        commonPage = new CommonPage();
        taskListPage = new TaskListPage();
        logInPage = new LogInPage();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItems_ScanProduct
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Scan Page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Tutorial Screen
     *                      3. FAQs Screen
     *                      4. About Screen
     */
    public void validateMenuItemsInScanProduct() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOut();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInStockShelf
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Tutorial Screen
     *                      3. FAQs Screen
     *                      4. About Screen
     */
    public void validateMenuItemsInStockShelf() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOut();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInBOHScreen
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. BOH screen
     *                      3. Tutorial Screen
     *                      4. FAQs Screen
     *                      5. About Screen
     */
    public void validateMenuItemsInBOHScreen() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.verifyBOHHeaderText(ts_Data.getUpdateBalanceHdr());
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOut();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInStockedScreen
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Tutorial Screen
     *                      3. FAQs Screen
     *                      4. About Screen
     */
    public void validateMenuItemsInStockedScreen() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.validateAndClickStockBtn(ts_Data.getStockBtn());
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
        topStockScanProductPage.ClickNewSession();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInNotStockedScreen
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1.Scan Product and select location and Not Stocked the product
     *                      2.verify Shelf Already full message
     *                      3.From Shelf Already full message page click on Kebab menu
     *                      4.Validate FAQ's, About, Tutorial and SignOut main menu items
     */
    public void validateMenuItemsInNotStockedScreen() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnNotStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
        topStockScanProductPage.ClickNewSession();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInNoStockingNeeded
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1.1.Scan Product and select location and stock the product
     *                      2.Scan same product again and verify no stocking needed message
     *                      3.From No stocking needed page click on Kebab menu
     *                      4.Validate FAQ's, About, Tutorial and SignOut main menu items
     */
    public void validateMenuItemsInNoStockingNeeded() throws Throwable {
        productStatusMsg = ts_Data.getProductStatus().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(productStatusMsg[0]);
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        stockShelfPage.ValidateScanProductStockStatus(productStatusMsg[1]);
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
        topStockScanProductPage.ClickNewSession();
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInReviewScreen
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1.Scan Product and select location and stock the product
     *                      2.verify Product Stocked message and click on review button
     *                      3.Validate Review Review Page header and click on Kebab menu
     *                      4.Validate FAQ's, About, Tutorial and SignOut main menu items
     */
    public void validateMenuItemsInReviewScreen() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
        topStockScanProductPage.ClickNewSession();

    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateMenuItemsInCompleteScreen
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1.Scan Product and select location and stock the product
     *                      2.verify Product Stocked message and click on review button
     *                      3.Click on Finish button
     *                      4.Verify Complete screen header and click on Kebab menu
     *                      4.Validate FAQ's, About, Tutorial and SignOut main menu items
     */
    public void validateMenuItemsInCompleteScreen() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.validateAndClickStockBtn(ts_Data.getStockBtn());
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnFinishBtn();
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
    }

    @Test(groups = "Regression007")
    /*
     * Test Name:           validateMenuItemsInRelocateProductPage
     * Test Description:    Validate FAQs, About, Tutorial and SigOut from Kebab menu
     * Scenario tested:     Validate FAQs, About, Tutorial and SigOut from Kebab menu
     *                      in Stock Shelf page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1.Scan Product and select location and stock the product
     *                      2.verify Product Stocked message and click on review button
     *                      3.Validate Review Review Page header and click on NotStocked Tab
     *                      4.Click on Wrong aisle text and click on Kebab menu
     *                      4.Validate FAQ's, About, Tutorial and SignOut main menu items
     */
    public void validateMenuItemsInRelocateProductPage() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickNotStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickNotStockTab();
        reviewPage.clickOnWrongAisleTxt();
        kababMenuPage.validateTutorialScreen();
        kababMenuPage.validateFAQsScreen();
        kababMenuPage.validateAbout();
        commonPage.clickBackArrowButton();
        signOutPopup();
        topStockScanProductPage.ClickNewSession();
    }

    //Reusable Method for SignOut which Covers SignOut without popup and Login
    public void signOut() throws Throwable {
        kababMenuPage.signOutWithOutPopup();
        logInPage.login(ts_Data.getUserName1(), ts_Data.getPassword1());
        taskListPage.clickTopStock();
    }

    public void signOutPopup() throws Throwable {
        kababMenuPage.loggedOut(true);
        logInPage.login(ts_Data.getUserName1(), ts_Data.getPassword1());
        taskListPage.clickTopStock();
    }

}
