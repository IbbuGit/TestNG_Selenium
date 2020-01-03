package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class ValidateMultipleProductScan extends Base {
    private String[] multipleUPCs;
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        thankyouBRCPage = new ThankyouBRCPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
    }

    /*
     * Test Name            :   verifyMultipleScanCountProductPg
     * Test Description     :   Verifying multi UPCs scan in count product page.
     * Scenario tested      :   1.The user scans multiple products at count product page
     *                          2.taps on review button
     *                          3.clicks submit button in review count page
     *                          4.validates thankyouBRC screen.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyMultipleScanCountProductPg() throws Exception {
        multipleUPCs = bc_Data.getProductToScan().split(";");
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[0], Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[0]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickEnterUPC();
        scanproductBRCPage.enterUPC(multipleUPCs[1]);
        scanproductBRCPage.clickSubmit();
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.validateProductCount(bc_Data.getProductCount());
    }

    /*
     * Test Name            :   verifyMultipleScanReviewCountPg
     * Test Description     :   Verifying multi UPCs scan in review count page.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on add more button in review count screen
     *                          4.scans multiple products.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyMultipleScanReviewCountPg() throws Exception {
        multipleUPCs = bc_Data.getProductToScan().split(";");
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[0], Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[0]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickAddMore();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[1], Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[1]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.validateProductCount(bc_Data.getProductCount());
        thankyouBRCPage.validateBeginMyDailyCountButton();
    }
}