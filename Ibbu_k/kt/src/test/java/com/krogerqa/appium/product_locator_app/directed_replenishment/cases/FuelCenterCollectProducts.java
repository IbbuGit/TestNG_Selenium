package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FuelCenterCollectProducts extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;

    private String text = "";

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateCartIsFull
     * Test Description:    Fuel Center Cart is Full Validation
     * Scenario tested:     User select fuel department, scans a product, collects it,
     *                      clicks Cart is Full
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
    public void validateCartIsFull() throws Throwable {
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
        collectedPage.waitForCollectedTab();
        collectedPage.validateFuelCartIsFull();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           fuelBeginStocking
         * Test Description:    Fuel Center Begin Stocking Validation
         * Scenario tested:     User select fuel department, scans a product, collects it,
         *                      clicks Begin Stocking
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
    void fuelBeginStocking() throws Throwable {
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
        collectedPage.waitForCollectedTab();
        collectedPage.fuelBeginStocking();
    }
}
