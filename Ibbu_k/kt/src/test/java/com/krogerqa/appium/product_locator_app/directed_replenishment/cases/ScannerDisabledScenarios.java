package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class ScannerDisabledScenarios extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;

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
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyScannerDisabled_MoveProductPage
     * Test Description:    Validating the The scanner is disabled in MoveProductPage
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then verifies the scanner disabled in Move product page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5.Move product page
     */
    public void verifyScannerDisabled_MoveProductPage() throws IOException, InterruptedException {
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
        collectedPage.clickDoneCollecting();
        moveProductPage.validateMoveProduct();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyScannerDisabled_CollectedPage
     * Test Description:    Validating the The scanner is disabled in collected page
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then verifies the scanner disabled in collected page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     */
    public void verifyScannerDisabled_CollectedPage() throws IOException, InterruptedException {
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
        mobileCommands.wait(2);
        collectedPage.clickCollectedTab();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyScannerDisabled_ThankYouPage
     * Test Description:    Validating the The scanner is disabled in ThankYouPage
     * Scenario tested:     User select a department, scans a product, collects it,Move product page,
     *                      then verifies the scanner disabled in ThankYouPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Move product page
     *                      6. Thank You page
     */
    public void verifyScannerDisabled_ThankYouPage() throws IOException, InterruptedException {
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
        moveProductPage.validateCollectedProdDetails();
        moveProductPage.clickFinishButton();
        thankyouPage.validateThankYouPgDisplay();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
    }
}
