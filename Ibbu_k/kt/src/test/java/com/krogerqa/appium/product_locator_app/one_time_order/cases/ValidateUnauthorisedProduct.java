package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.BeginOrderScreenPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.ManualEnterUPCPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.OrderInProgressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateUnauthorisedProduct extends Base {

    private BeginOrderScreenPage beginOrderScreenPage;
    private ScanProductPage scanProductPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private OrderInProgressPage orderInprogressPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        orderInprogressPage = new OrderInProgressPage();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
        /*
         *   Test Name:          verifyUnauthorisedProduct
         *   Test Description:   Verifying Unauthorised UI screen.
         *   Scenario tested:    The user is on the new order screen and scans Unauthorised item, navigating to Unauthorised UI screen.
         *   Story id:
         *   Epic id:            11488
         *   Test data:          data dependent
         *   API tested:
         *                       1. api/v1/adhoc-order-items
         *   UI screen tested:
         *                       1. Begin Order Screen
         *                       2. Order in progress pop up
         *                       3. Unauthorised UI screen
         */
    void verifyUnauthorisedProduct() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        beginOrderScreenPage.validateUnauthorisedMsg(oto_Data.getErrorMsg());
    }
}
