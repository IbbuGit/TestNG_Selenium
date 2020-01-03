package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateRemoveProduct extends Base {
    private String[] multipleUPCs;
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
    }

    /*
     * Test Name            :   verifyRemoveProductSingleUPCCancelBtn
     * Test Description     :   Verifying cancel remove product for single UPC scan .
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on delete icon
     *                          4.validates remove product pop up
     *                          5.taps on cancel button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyRemoveProductSingleUPCCancelBtn() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickCancel();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        reviewCountPage.clickSubmit();
    }

    /*
     * Test Name            :   verifyRemoveProductFromSingleUPC
     * Test Description     :   Verifying remove in remove product for single UPC scan .
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on delete icon
     *                          4.validates remove product pop up
     *                          5.taps on remove button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyRemoveProductFromSingleUPC() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickRemove();
        //reviewCountPage.clickSubmit();
    }

    /*
     * Test Name            :   verifyRemoveProductFromMultipleUPCsCancelBtn
     * Test Description     :   Verifying cancel in remove product for multiple UPC scan .
     * Scenario tested      :   1.The user scans multiple product in count product screen
     *                          2.taps on review button in count product screen
     *                          3.taps on delete icon
     *                          4.validates remove product pop up
     *                          5.taps on cancel button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyRemoveProductFromMultipleUPCsCancelBtn() throws Exception {
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
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickCancel();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        //reviewCountPage.clickSubmit();
    }

    /*
     * Test Name            :   verifyRemoveProductFromMultipleUPCs
     * Test Description     :   Verifying remove in remove product for multiple UPC scan .
     * Scenario tested      :   1.The user scans multiple product in count product screen
     *                          2.taps on review button in count product screen
     *                          3.taps on delete icon
     *                          4.validates remove product pop up
     *                          5.taps on remove button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyRemoveProductFromMultipleUPCs() throws Exception {
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
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickRemove();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        reviewCountPage.clickSubmit();
    }

    /*
     * Test Name            :   verifyRemoveProductInCountProductPg
     * Test Description     :   Verifying remove product in count product screen.
     * Scenario tested      :   1.The user scans a product in count product screen
     *                          2.taps on review button in count product screen
     *                          3.taps on delete icon
     *                          4.validates remove product pop up
     *                          5.taps on remove button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyRemoveProductInCountProductPg() throws Exception {
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
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickRemove();
        reviewCountPage.clickSubmit();
    }
}