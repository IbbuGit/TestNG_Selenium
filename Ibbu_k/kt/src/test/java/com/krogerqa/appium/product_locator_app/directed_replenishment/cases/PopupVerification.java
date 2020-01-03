package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.NotCollectedPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;

public class PopupVerification extends Base {
   private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private  NotCollectedPage notCollectedPage;
    private   ScanProductDRPage scanProductDRPage;
    private  CollectProductPage collectProductPage;
    private  CollectedPage collectedPage;
    private  MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private  NotCollectedPageMap notCollectedPageMap;


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
        notCollectedPageMap = new NotCollectedPageMap();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }


    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateProductsNotCollectedPopup_Cancel
     * Test Description:    Clicking cancel button from Products not collected popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      Clicks on Begin Stocking,Clicks on cancel button from Products not collected popup
     *                      Validates CartIsFull Enabled
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
    public void validateProductsNotCollectedPopup_Cancel() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickCartIsFull();
        notCollectedPage.verifyProductsNotCollectedPopup(dr_Data.getProductNotCollectedHdrPopup());
        notCollectedPage.clickCartIsFullCancel();
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateProductsNotCollectedPopup_DoneCollecting
     * Test Description:    Clicking Done Collecting button from Products not collected popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      Clicks on Begin Stocking,Clicks on Done Collecting button from Products not collected popup
     *                      Validates Move Product title
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
     */
    public void validateProductsNotCollectedPopup_DoneCollecting() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickCartIsFull();
        notCollectedPage.verifyProductsNotCollectedPopup(dr_Data.getProductNotCollectedHdrPopup());
        notCollectedPage.clickCartIsFullDoneCollecting();
        mobileCommands.wait(3);
        moveProductPage.validateMoveProduct();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateUnFinishedWorkPopupExit_MoveProductPage
     * Test Description:    Clicking Exit button from Unfinished work Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Exit button from Unfinished work popup,
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
     *                      8. MainMenu page
     */
    public void validateUnFinishedWorkPopupExit_MoveProductPage() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateCollectedProdDetails();
        selectDepartmentPage.clickBackArrow();
        moveProductPage.verifyUnfinishedPopup_ClickExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateUnFinishedWorkPopupCancel_MoveProductPage
     * Test Description:    Clicking Cancel button from Unfinished work Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Cancel button from Unfinished work popup,
     *                      Validates Move Product title
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
     */
    public void validateUnFinishedWorkPopupCancel_MoveProductPage() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateCollectedProdDetails();
        selectDepartmentPage.clickBackArrow();
        moveProductPage.verifyUnfinishedPopup_ClickCancel(dr_Data.getUnFinishedCollectionListHdr());
        moveProductPage.validateMoveProduct();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateSessionInProgressPopup_CollectMore
     * Test Description:    Clicking Collect More button from Session In Progress Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Collect More button from Session In Progress popup,
     *                      Validates Not Collected page displayed
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
     */
    public void validateSessionInProgressPopup_CollectMore() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        HashMap<By, String> elements = new HashMap<>();
        elements.put(notCollectedPageMap.tabNotCollected(), "NotCollected");
        elements.put(notCollectedPageMap.btnSessionInProgressCollectMore(), "CollectMore");
        String visibleElement = selectDepartmentPage.getVisibleElementFromListOfWebElement(mobileCommands.getWebDriver(), elements);
        if (visibleElement.equals("CollectMore")) {
            notCollectedPage.verifySessionInProgressPopup(dr_Data.getSessionInProgressHdrPopup());
            mobileCommands.click(notCollectedPageMap.btnSessionInProgressCollectMore());
            notCollectedPage.verifyNotCollectedPageDisplay();
        } else {
            notCollectedPage.clickFirstProduct();
            scanProductDRPage.validateScanProductDR();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
            collectedPage.clickCollectedTab();
            collectedPage.clickFinishCollectingBtn();
            moveProductPage.validateCollectedProdDetails();
            selectDepartmentPage.clickBackArrow();
            moveProductPage.verifyUnfinishedPopup_ClickExit(dr_Data.getUnFinishedCollectionListHdr());
            //taskListPage.clickDirectedReplenishment();
            selectDepartmentPage.validateSelectDepartment();
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
            notCollectedPage.verifySessionInProgressPopup(dr_Data.getSessionInProgressHdrPopup());
            mobileCommands.wait(3);
            notCollectedPage.clickSessionInProgressCollectMore();
            notCollectedPage.verifyNotCollectedPageDisplay();
        }
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateSessionInProgressPopup_Continue
     * Test Description:    Clicking Continue button from Session In Progress Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Continue button from Session In Progress popup,
     *                      Validates Move Product title
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
     */
    public void validateSessionInProgressPopup_Continue() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        HashMap<By, String> elements = new HashMap<>();
        elements.put(notCollectedPageMap.tabNotCollected(), "NotCollected");
        elements.put(notCollectedPageMap.btnSessionInProgressContinue(), "Continue");
        String visibleElement = selectDepartmentPage.getVisibleElementFromListOfWebElement(mobileCommands.getWebDriver(), elements);
        if (visibleElement.equals("Continue")) {
            notCollectedPage.verifySessionInProgressPopup(dr_Data.getSessionInProgressHdrPopup());
            notCollectedPage.clickSessionInProgressContinue();
            moveProductPage.validateMoveProduct();
        } else {
            notCollectedPage.clickFirstProduct();
            scanProductDRPage.validateScanProductDR();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
            collectedPage.clickCollectedTab();
            collectedPage.clickFinishCollectingBtn();
            moveProductPage.validateCollectedProdDetails();
            selectDepartmentPage.clickBackArrow();
            moveProductPage.verifyUnfinishedPopup_ClickExit(dr_Data.getUnFinishedCollectionListHdr());
            //taskListPage.clickDirectedReplenishment();
            selectDepartmentPage.validateSelectDepartment();
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
            notCollectedPage.verifySessionInProgressPopup(dr_Data.getSessionInProgressHdrPopup());
            mobileCommands.wait(3);
            notCollectedPage.clickSessionInProgressContinue();
            moveProductPage.validateMoveProduct();
        }
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateCantFindAndSkipPopup_Skip
     * Test Description:    Clicking Skip button from Can't Find and Skip Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Skip button from Can't Find and Skip Popup
     *                      Validates Move Product title
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
     */
    public void validateCantFindAndSkipPopup_Skip() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
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
        moveProductPage.clickCantFindAndSkip();
        moveProductPage.verifyCantFindAndSkipPopupMsg(dr_Data.getCantFindAndSkipPopupMsg());
        moveProductPage.clickSkip();
        thankyouPage.validateThankYouPgDisplay();

    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateCantFindAndSkipPopup_Cancel
     * Test Description:    Clicking Cancel button from Can't Find and Skip Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, clicks on Cancel button from Can't Find and Skip Popup
     *                      Validates Move Product title
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
     */
    public void validateCantFindAndSkipPopup_Cancel() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateCollectedProdDetails();
        moveProductPage.clickCantFindAndSkip();
        moveProductPage.verifyCantFindAndSkipPopupMsg(dr_Data.getCantFindAndSkipPopupMsg());
        moveProductPage.clickCancel();
        moveProductPage.validateMoveProduct();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateGotItPopup
     * Test Description:    Clicking GotIt button from GotIt Popup
     * Scenario tested:     User select a department,clicks on GotIt button from GotIt Popup
     *                      Validates Selects department title
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     */
    public void validateGotItPopup() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.verifyGotItPopupMsg(dr_Data.getGotItPopupMsg());
        selectDepartmentPage.clickBtnGotItInPopup();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateUnFinishedWorkPopupExit_DirectedReplenishmentPage
     * Test Description:    Clicking Exit button from Unfinished work Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      clicks on back arrow button from Directed Replenishment Page,
     *                      clicks on Exit button from Unfinished work Popup,
     *                      Validates MainMenu Page title
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
    public void validateUnFinishedWorkPopupExit_DirectedReplenishmentPage() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        notCollectedPage.verifyNotCollectedPageDisplay();
        selectDepartmentPage.clickBackArrow();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
       // moveProductPage.verifyUnfinishedPopup_ClickExit(dr_Data.getUnFinishedCollectionListHdr());
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateUnFinishedWorkPopupCancel_DirectedReplenishmentPage
     * Test Description:    Clicking Cancel button from Unfinished work Popup
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      clicks on back arrow button from Directed Replenishment Page,
     *                      clicks on Cancel button from Unfinished work Popup,
     *                      Validates Not Collected page displayed
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
    public void validateUnFinishedWorkPopupCancel_DirectedReplenishmentPage() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        notCollectedPage.verifyNotCollectedPageDisplay();
        selectDepartmentPage.clickBackArrow();
        moveProductPage.verifyUnfinishedPopup_ClickCancel(dr_Data.getUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();
    }

    //Fuel Center Popup
    @Test(groups = "Regression")
    /*
     * Test Name:           verifyUnFinishedWork_ClickContinue
     * Test Description:    Fuel Center - Unfinished Work Popup - Continue Validation
     * Scenario tested:     User select fuel department, clicks on Continue in Unfinished work popup
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
     *                      6. Thank You Page
     */
    public void verifyUnFinishedWork_ClickContinue() throws IOException, InterruptedException {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectFuelDept();
            selectDepartmentPage.clickGenerateList();
        }
        //To verify Pull count popup
        //notCollectedPage.verifyUnfinishedCollectionList_ClickContinue(dr_Data.getUnFinishedCollectionListHdr());
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
        //taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.validateSelectDepartment();
        //selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyUnfinishedCollectionList_ClickContinue(dr_Data.getFuelUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();

        /*notCollectedPage.clickCartIsFull();
        notCollectedPage.clickCartIsFullDoneCollecting();
        thankyouPage.validateThankYouPgDisplay();*/
    }

    @Test(groups = "Regression")
    /*
     * Test Name:           verifyUnFinishedWork_ClickNewList
     * Test Description:    Fuel Center - Unfinished Work Popup - New List Validation
     * Scenario tested:     User select fuel department, clicks on New List in Unfinished work popup
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
     *                      6. Thank You Page
     */
    public void verifyUnFinishedWork_ClickNewList() throws IOException, InterruptedException {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectFuelDept();
            selectDepartmentPage.clickGenerateList();
        }
        //To verify UnFinished count popup
        //notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
       // notCollectedPage.verifyNotCollectedPageDisplay();
        collectedPage.clickCollectedTab();
        collectedPage.clickBackArrow();
        moveProductPage.unfinishedWorkPopupSaveAndExit(dr_Data.getUnFinishedCollectionListHdr());
        //collectedPage.clickBackArrow();
        //taskListPage.clickDirectedReplenishment();
        //selectDepartmentPage.verifyDRBtn();
        selectDepartmentPage.validateSelectDepartment();
        //selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getFuelUnFinishedCollectionListHdr());
        notCollectedPage.verifyNotCollectedPageDisplay();

        /*notCollectedPage.clickCartIsFull();
        notCollectedPage.clickCartIsFullDoneCollecting();
        thankyouPage.validateThankYouPgDisplay();*/
    }
}
