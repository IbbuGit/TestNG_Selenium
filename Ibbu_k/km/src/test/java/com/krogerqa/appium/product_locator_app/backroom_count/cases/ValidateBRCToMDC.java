package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateBRCToMDC extends Base {
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private TaskListPage taskListPage;
    private ScanProductPage scanProductPage;
    private String[] multiUPCs;


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
     * Test Name            :   validateBRCToMDC
     * Test Description     :   Verifying products being submitted to MDC from Backroom.
     * Scenario tested      :   1.The user scans the product
     *                          2.clicks review button in count product screen
     *                          3.clicks submit in review screen
     *                          4.validates thankyou screen
     *                          5.verifies begin my daily count button is enabled
     *                          6.clicks begin my daily count and validates select department
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = {"regression"})
    void validateBRCToMDC() throws Throwable {
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        for (String UPC : multiUPCs) {
            scanProductPage.scanProduct(UPC, Symbology.UPC_A);
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.verifyBeginMyDailyCountIsEnabled();
        double before = thankyouBRCPage.clickBeginMyDailyCount();
        double after = taskListPage.validateSelectDepartments();
        taskListPage.validateMDCButtonResponseTime(before, after);
    }
}
