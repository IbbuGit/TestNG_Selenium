package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateUnauthorizedDSDMsg extends Base {
    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
    }

    /*
     * Test Name            :   verifyUnauthorizedUPCMsg
     * Test Description     :   Verifying unauthorized UPC msg.
     * Scenario tested      :   1.The user scans an unauthorized UPC
     *                          2.validates unauthorized UPC msg
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyUnauthorizedUPCMsg() throws Exception {
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
        scanproductBRCPage.validateUnauthorizedDSDMsg(bc_Data.getUnauthorizedDSDMsg());
    }

    /*
     * Test Name            :   verifyDSDUPCMsg
     * Test Description     :   Verifying DSD UPC msg.
     * Scenario tested      :   1.The user scans a DSD UPC
     *                          2.validates DSD UPC msg
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyDSDUPCMsg() throws Exception {
        //Thread.sleep(5000);
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
        scanproductBRCPage.validateUnauthorizedDSDMsg(bc_Data.getUnauthorizedDSDMsg());
    }
}