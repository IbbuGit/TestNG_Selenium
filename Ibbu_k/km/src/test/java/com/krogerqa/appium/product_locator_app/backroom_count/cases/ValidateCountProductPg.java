package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class ValidateCountProductPg extends Base {
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
    }

    /*
     * Test Name            :   verifyCountProductPg
     * Test Description     :   Verifying count product page validations.
     * Scenario tested      :   The user scans a product and validates count product page.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyCountProductPg() throws Exception {
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
        countProductPage.validateStepperIcons();
        countProductPage.validateCasesTxtBox();
        countProductPage.validateCasesEnterCountPopUp();
        countProductPage.validateUnitsTxtBox();
        countProductPage.validateUnitsEnterCountPopUp();
    }

    /*
     * Test Name            :   verifyCloseBtnCountProductPg
     * Test Description     :   Verifying close button in count product page.
     * Scenario tested      :   The user is on the count product screen taps on close button and validates the alert pop up.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyCloseBtnCountProductPg() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.validateCrossButton();
        countProductPage.validateAlertPopup();
    }
}