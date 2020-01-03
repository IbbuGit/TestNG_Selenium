package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.UnSubmittedCountMap;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class BackroomToMDCFamilyTree extends Base {
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private TaskListPage taskListPage;
    private ScanProductPage scanProductPage;
    private String[] multiUPCs;
    UnSubmittedCountMap unSubmittedCountMap = new UnSubmittedCountMap();
    UnSubmittedCountPage unSubmittedCountPage = new UnSubmittedCountPage();


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        thankyouBRCPage = new ThankyouBRCPage();
        taskListPage = new TaskListPage();
        scanProductPage = new ScanProductPage();
    }

    /*
     * Test Name            :   backroomCount_MDC
     * Test Description     :   Verifying begin my daily count in backroomCount.
     * Scenario tested      :   1.user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on submit button in review count screen
     *                          4.verifies begin my daily count button is enabled
     *                          5.taps on begin my daily count button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :   <APIs tested as part of this flow>
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = {"regression"})
    void backroomCountMDC() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        for (String UPC : multiUPCs) {
            scanProductPage.scanProduct(UPC, Symbology.UPC_A);
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        reviewCountPage.verifyBackgroundLoadingSpinnerDisabled();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.verifyBeginMyDailyCountIsEnabled();
        double before = thankyouBRCPage.clickBeginMyDailyCount();
        double after = taskListPage.validateSelectDepartments();
        taskListPage.validateMDCButtonResponseTime(before, after);
    }

    @Test(groups = {"regression"})
    void validateBRCRapidScan() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        Map<String, String> scannedUPScount = new LinkedHashMap<String, String>();
        int scanCount = 0;
        int i;
        for (int j = 0; j < multiUPCs.length; j++) {
            if (j == 0) {
                scanCount = 8;
            }
            if (j == 1) {
                scanCount = 6;
            }
            if (j == 2) {
                scanCount = 5;
            }
            for (i = 0; i <= scanCount; i++) {
                scanProductPage.scanProduct(multiUPCs[j], Symbology.UPC_A);
            }
            scannedUPScount.put(multiUPCs[j], countProductPage.getProdTotalUnitsCount());
        }
        countProductPage.clickReview();
        for (String key : scannedUPScount.keySet()) {
            countProductPage.verifyProductCountsExists(scannedUPScount.get(key));
        }
        String totalCountProduct = reviewCountPage.productCountTextDetails().replace(" Counted In Backroom", "");
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.validateProductCount(totalCountProduct);
    }
}