package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class DR_Smoke_Suite extends Base {

    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private ThankyouPage thankyouPage;
    private KebabMenuPage kebabMenuPage;
    private String text = "";
    private List<String> collectedUPC = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
        thankyouPage = new ThankyouPage();
        kebabMenuPage = new KebabMenuPage();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           drSmokeTest
     * Test Description:    DR_Happy Path
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking, completes replenishment
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
     *                      6. Move Product Page
     *                      7. Thank You Page
     */
    public void drSmokeTest() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String productsCount = depStatus.replace("products", "").replace(" ", "").replace("product", "");
        int updatedProductsCount = Integer.parseInt(productsCount);
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        for (int i = 0; i < updatedProductsCount; i++) {
            if (i == 4) {
                break;
            } else {
                notCollectedPage.waitForNotCollectedTab();
                notCollectedPage.clickNotCollected();
                notCollectedPage.clickFirstProduct();
                scanProductDRPage.validateScanProductDR();
                text = scanProductDRPage.getUPCText();
                scanProductPage.scanProduct(text, Symbology.UPC_A);
                collectProductPage.validateCollectProduct();
                collectProductPage.clickDoneBtn();
                collectedUPC.add(text);
            }
        }
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        thankyouPage.validateCountInThankYouPage(collectedUPC);
        }


    //Fuel Center Happy path
    @Test(groups = {"Regression"})
    /*
     * Test Name:           fuelSmokeTest
     * Test Description:    Fuel Center Replenishment Flow - Happy Path
     * Scenario tested:     User select fuel department, scans a product, collects it,
     *                      then completes replenishment
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
    void fuelSmokeTest() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectFuelDept();
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        //notCollectedPage.verifyUnfinishedCollectionList_ClickNewList(dr_Data.getFuelUnFinishedCollectionListHdr());
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        notCollectedPage.verifyNotCollectedPageDisplay();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        thankyouPage.validateThankYouPgDisplay();


    }

    @Test(groups = "Regression")
    /*
     * Test Name:           validateDRTutorial
     * Test Description:    validateDRTutorial
     * Scenario tested:     User select kebab menu, click Tutorial,Click Next Button, click GotIT button
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Tutorial page
     */
    public void validateDRTutorial() throws Throwable {
        String[] header = dr_Data.getDrTutorialHdr().split(";");
        String[] desc = dr_Data.getDrTutorialDesc().split(";");
        if(kebabMenuPage.verifyDRTutorialHdr()){
            for (int i = 0; i < header.length; i++) {
                if (i == header.length - 1) {
                    kebabMenuPage.clickTutorialGotItBtn();
                    break;
                } else {
                    kebabMenuPage.clickNextBtn();
                }
            }
            selectDepartmentPage.validateSelectDepartment();
        }
        apiExecutor.getHttpClient(prop.getProperty("resetAllDataForUser"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
        selectDepartmentPage.clickBackArrow();
        new TaskListPage().clickDirectedReplenishment();
        for (int i = 0; i < header.length; i++) {
            kebabMenuPage.verifyDRTutorialHdr(header[i]);
            kebabMenuPage.verifyDRTutorialDesc(desc[i]);
            if (i == header.length - 1) {
                kebabMenuPage.clickTutorialGotItBtn();
                break;
            } else {
                kebabMenuPage.clickNextBtn();
            }
        }
    }
}