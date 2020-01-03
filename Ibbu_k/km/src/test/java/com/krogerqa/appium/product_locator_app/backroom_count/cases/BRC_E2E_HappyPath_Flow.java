package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.lang.reflect.Method;

public class BRC_E2E_HappyPath_Flow extends Base {

    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private ScanProductPage scanProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        thankyouBRCPage = new ThankyouBRCPage();
        scanProductPage = new ScanProductPage();
    }

    /*
     * Test Name            :   verifyScanProduct
     * Test Description     :   Verifying scan product.
     * Scenario tested      :   1.user scans a product
     *                          2.validates count product screen and taps on review button in count product screen
     *                          3.validates review count screen and taps on submit button in review count screen
     *                          4.validates thankyouBRC screen
     *                          5.validates begin my daily count button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :   <APIs tested as part of this flow>
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = {"smoke"})
    void verifyScanProduct() throws Throwable {
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.validateEnterUPCTitle(bc_Data.getEnterUPC());
            scanproductBRCPage.validateCancelButton();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.validateProdDetails();
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
        countProductPage.validateProdTotalUnitsCount();
        countProductPage.clickReview();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        reviewCountPage.validateAddMoreButton();
        reviewCountPage.validateProdCard();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.validateBeginMyDailyCountButton();
    }
}