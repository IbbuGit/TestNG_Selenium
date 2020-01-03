package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class BRC_Login extends Base {

    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        scanProductPage = new ScanProductPage();
    }

    @Test(groups = {"smoke"})
    void loginTestBRC() throws Throwable {
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
    }
}