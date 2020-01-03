package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class BackAndCloseButtonVerification extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private TaskListPage taskListPage;
    private MobileCommands mc;

    private String text = "";

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
        moveProductPage = new MoveProductPage();
        thankyouPage = new ThankyouPage();
        taskListPage = new TaskListPage();
        mc = new MobileCommands();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }

    /*
     * Test Name:           verifyBackAndCloseButtonInDirectedReplenishmentPage
     * Test Description:    Clicking back arrow button from Direct Replenishment Page
     * Scenario tested:     User select a department, Clicks on Generate list button,
     *                      clicks on Back arrow button from Direct Replenishment page,
     *                      Validates Select Departments text in Select Department page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Direct Replenishment Page
     */
    @Test(groups = {"Regression"})
    public void verifyBackAndCloseButtonInDirectedReplenishmentPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        selectDepartmentPage.clickBackArrow();
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    /*
     * Test Name:           verifyBackAndCloseButtonInScanProductPage
     * Test Description:    Clicking Close button from Scan Product Page
     * Scenario tested:     User select a department, scans a product,
     *                      clicks on Close button from Scan Product page,
     *                      Validates Not Collected page displays
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     */
    @Test(groups = {"Regression"})
    public void verifyBackAndCloseButtonInScanProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        selectDepartmentPage.clickBackArrow();
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    /*
     * Test Name:           verifyBackAndCloseButtonInCollectProductPage
     * Test Description:    Clicking back arrow button from Collect Product Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      clicks on Back arrow button from Collect Product page,
     *                      Validates Not Collected page displays
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     */
    @Test(groups = {"Regression"})
    public void verifyBackAndCloseButtonInCollectProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        selectDepartmentPage.clickBackArrow();
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    /*
     * Test Name:           verifyBackAndCloseButtonInMoveProductPage
     * Test Description:    Clicking Close button from Move Product Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Close button from MoveProduct page,
     *                      click Exit from Unfinished Popup, Validates MainMenu page title
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     *                      6. Move Product Page
     *                      7. MainMenu page
     */
    @Test(groups = {"Regression"})
    public void verifyBackAndCloseButtonInMoveProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        selectDepartmentPage.clickBackArrow();
        moveProductPage.clickExit_UnFinishedPopup();
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    /*
     * Test Name:           verifyBackAndCloseButtonInThankYouPage
     * Test Description:    Clicking back arrow button from ThankYou Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Back Arrow from ThankYou page,
     *                      Validates MainMenu page title
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     *                      6. Move Product Page
     *                      7. Thank You Page
     *                      8. MainMenu page
     */
    @Test(groups = {"Regression"})
    public void verifyBackAndCloseButtonInThankYouPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        moveProductPage.clickFinishButton();
        thankyouPage.validateThankYouPgDisplay();
        selectDepartmentPage.clickBackArrow();
        selectDepartmentPage.verifyDRBtn();
    }

    /*
     * Test Name:           verifyAndroidBackButtonInDirectedReplenishmentPage
     * Test Description:    Clicking Android Back button from Direct Replenishment Page
     * Scenario tested:     User select a department, Clicks on Generate list button,
     *                      clicks on Android Back button from Direct Replenishment page,
     *                      Validates Select Departments text in Select Department page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Direct Replenishment Page
     */
    @Test(groups = {"Regression"})
    public void verifyAndroidBackButtonInDirectedReplenishmentPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        mc.browserBack();
        taskListPage.validateSelectDepartments();
    }

    /*
     * Test Name:           verifyAndroidBackButtonInScanProductPage
     * Test Description:    Clicking Close Android Back button from Scan Product Page
     * Scenario tested:     User select a department, scans a product,
     *                      clicks on Android Back button from Scan Product page,
     *                      Validates Not Collected page displays
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     */
    @Test(groups = {"Regression"})
    public void verifyAndroidBackButtonInScanProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        mc.browserBack();
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    /*
     * Test Name:           verifyAndroidBackButtonInCollectProductPage
     * Test Description:    Clicking Android Back button from Collect Product Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      clicks on Android Back button from Collect Product page,
     *                      Validates Not Collected page displays
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     */
    @Test(groups = {"Regression"})
    public void verifyAndroidBackButtonInCollectProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        mc.browserBack();
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    /*
     * Test Name:           verifyAndroidBackButtonInMoveProductPage
     * Test Description:    Clicking Android Back button from Move Product Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Android back button from MoveProduct page,
     *                      click Exit from Unfinished Popup, Validates MainMenu page title
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     *                      6. Move Product Page
     *                      7. MainMenu page
     */
    @Test(groups = {"Regression"})
    public void verifyAndroidBackButtonInMoveProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        mc.browserBack();
        moveProductPage.clickExit_UnFinishedPopup();
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    /*
     * Test Name:           verifyAndroidBackButtonInThankYouProductPage
     * Test Description:    Clicking Android back button from ThankYou Page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Android Back button from ThankYou page,
     *                      Validates MainMenu page title
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Direct Replenishment Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     *                      6. Move Product Page
     *                      7. Thank You Page
     *                      8. MainMenu page
     */
    @Test(groups = {"Regression"})
    public void verifyAndroidBackButtonInThankYouProductPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        moveProductPage.clickFinishButton();
        thankyouPage.validateThankYouPgDisplay();
        mc.browserBack();
        selectDepartmentPage.verifyDRBtn();
    }

    //Fuel CENTER BACK button functionality
    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateAndroidBackButtonInFuelCollectedPage
     * Test Description:    Android Back Functionality - Fuel Center
     * Scenario tested:     User select fuel department, scans a product, collects it,
     *                      click Android Back from Collected page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
     *                      2. dbrsrvstage.kroger.com/replenishment-services/api/v1/replenishment-departments
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     */
    public void validateAndroidBackButtonInFuelCollectedPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
       // notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        mc.browserBack();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           validateBackButtonInCollectedPage_Fuel
         * Test Description:    Back Arrow Functionality - Fuel Center
         * Scenario tested:     User select fuel department, scans a product, collects it,
         *                      click Back Arrow from Collected page
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
         *                      2. dbrsrvstage.kroger.com/replenishment-services/api/v1/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         *                      4. Collect Product Page
         *                      5. Collected Page
         */
    void validateBackButtonInCollectedPage_Fuel() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        //notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickBackArrow();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           validateAndroidBackButtonInNotCollectedPage_Fuel
         * Test Description:    Android Back Functionality in NotCollectedPage - Fuel Center
         * Scenario tested:     User select fuel department, scans a product, collects it,
         *                      click Back Arrow from Collected page
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
         *                      2. dbrsrvstage.kroger.com/replenishment-services/api/v1/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         *                      4. Collect Product Page
         *                      5. Collected Page
         */
    void validateAndroidBackButtonInNotCollectedPage_Fuel() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        //notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        notCollectedPage.verifyNotCollectedPageDisplay();
        mc.browserBack();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           validateBackButtonInNotCollectedPage_Fuel
         * Test Description:    Back Arrow Functionality NotCollectedPage - Fuel Center
         * Scenario tested:     User select fuel department, scans a product, collects it,
         *                      click Back Arrow from Not Collected page
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
         *                      2. dbrsrvstage.kroger.com/replenishment-services/api/v1/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         *                      4. Collect Product Page
         *                      5. Collected Page
         */
    void validateBackButtonInNotCollectedPage_Fuel() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        notCollectedPage.verifyNotCollectedPageDisplay();
        collectedPage.clickBackArrow();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }
}

