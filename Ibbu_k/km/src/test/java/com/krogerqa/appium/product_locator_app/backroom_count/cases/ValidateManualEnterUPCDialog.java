package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ManualEnterUPCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.UnSubmittedCountPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateManualEnterUPCDialog extends Base {
    private String[] multipleUPCs;
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
        manualEnterUPCPage = new ManualEnterUPCPage();

    }

    /*
     * Test Name            :   verifyCancelBtnInManualEnterUPC
     * Test Description     :   Verifying manual enter UPC cancel button.
     * Scenario tested      :   1.The user manually enters the UPC
     *                          2.validates cancel button
     *                          3.taps on cancel button.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */
    @Test(groups = {"regression"})
    public void verifyCancelBtnInManualEnterUPC() {
        unSubmittedCount.clickNewCount();
        scanproductBRCPage.waitForEnterUPCButton();
        scanproductBRCPage.clickEnterUPC();
        manualEnterUPCPage.validateManualEnterUPCTitle(Consts.titleManualEnterUPC_SC);
        manualEnterUPCPage.validateManualEnterHint(Consts.lblManualEnterHint);
        manualEnterUPCPage.valiateCancelButton(Consts.lblCancelButton);
        manualEnterUPCPage.validateSubmitButton(Consts.lblSubmitButton);
        manualEnterUPCPage.clickCancelButton();
    }

    /*
     * Test Name            :   verifySubmitBtnInManualEnterUPC
     * Test Description     :   Verifying manual enter UPC cancel button.
     * Scenario tested      :   1.The user manually enters the UPC
     *                          2.validates submit button
     *                          3.taps on submit button.
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = {"regression"})
    public void verifySubmitBtnInManualEnterUPC() {
        unSubmittedCount.clickNewCount();
        scanproductBRCPage.waitForEnterUPCButton();
        scanproductBRCPage.clickEnterUPC();
        scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
        scanproductBRCPage.clickSubmit();
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
    }
}
