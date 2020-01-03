package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class OrderOverLimit extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        scanProductPage = new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     *   Test Name:         verifyOrderOverLimitDialog_Cancel
     *   Test Description:  Verifying CANCEL option in Order Over limit popup.
     *   Scenario tested:   The user is on the new order screen and scans valid upc,enters case value exceeding limit and verifies the CANCEL option in Order over limit Pop up dialog
     *   Story id:          9084,1917,1942
     *   Epic id:           11488
     *   Test data:         data dependent
     *   API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order button
     *                      3. Order over limit pop up
     */
    public void verifyOrderOverLimitDialog_Cancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.enterValueInCase(oto_Data.getCaseValue());

        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        updateOrderScreenPage.validateOrderOverLimitTitle(oto_Data.getDlgTitle());
        updateOrderScreenPage.clickCancel();
        updateOrderScreenPage.validateUpdateOrderHeaderTxt(oto_Data.getUpdateOrderHeaderText());
    }
    @Test(groups = {"regression"},alwaysRun = true)
    /*
     *   Test Name:         verifyOrderOverLimitDialog_Continue
     *  Test Description:   Verifying CONTINUE option in Order Over limit popup.
     *   Scenario tested:   The user is on the new order screen and scans valid upc,enters case value exceeding limit and verifies the CONTINUE option in Order over limit Pop up dialog
     *   Story id:          9084
     *   Epic id:           11488
     *   Test data:         data dependent
     *   API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order button
     *                      3. Order over limit pop up
     */
    public void verifyOrderOverLimitDialog_Continue() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.enterValueInCase(oto_Data.getCaseValue());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        updateOrderScreenPage.validateOrderOverLimitTitle(oto_Data.getDlgTitle());
        updateOrderScreenPage.validateOrderOverLimitMsg(oto_Data.getDlgMessage());
        updateOrderScreenPage.clickContinue();
        orderUpdatedScreenPage.validateOrderUpdateHeaderTxt(oto_Data.getTextOrderUpdate());

    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     *   Test Name:         verifyThreshold99999
     *   Test Description:  verifying Threshold message while entering case value
     *   Scenario tested:   The user is on the new order screen and scans valid upc,enters case value exceeding Threshold limit and validates Threshold error message
     *   Story id:
     *   Epic id:           11488
     *   Test data:         data dependent
     *   API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                      1. Update Order Screen
     *                      2. Order in progress pop up
     */
    public void verifyThresholdErrorMsgInCase() throws IOException {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.clickCasesTextBox();
        updateOrderScreenPage.enterValueInEnlargedCase(oto_Data.getCaseValue());
        updateOrderScreenPage.validateErrorMsg(oto_Data.getErrorMsg());
    }

}