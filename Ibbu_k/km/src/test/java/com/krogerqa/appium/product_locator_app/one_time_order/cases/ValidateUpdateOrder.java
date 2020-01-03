package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateUpdateOrder extends Base{
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private OrderInProgressPage orderInprogressPage;
    private ScanProductPage scanProductPage;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        scanProductPage = new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          validateUpdateOrder_AddToOrder
     *   Test Description:   Verifying header text of Update Order screen.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and verifies Add to Order button in Update Order screen
     *   Story id:           1864
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     *                       3. Add To Order button
     */
    public void validateUpdateOrder_AddToOrder() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateOrderUpdateHeaderTxt(oto_Data.getTextOrderUpdate());
    }

    @Test(groups = {"regression"} ,alwaysRun = true)
    /*
     *   Test Name:          validateUpdateOrder_Cancel
     *   Test Description:   Verifying cancel button functionality after scanning a product.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and verifies Cancel button in Update Order screen
     *   Story id:           1864
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     *                       3. Cancel button
     */
    public void validateUpdateOrder_Cancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickCancelBtn();
        beginOrderScreenPage.validateBeginOrderTitle();
    }
    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          validateUpdateOrder_XCancel
     *   Test Description:   Verifying 'X' button functionality after scanning a product.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and verifies 'X' button in Update Order screen
     *   Story id:           1864
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     *                       3. 'X' button
     */
    public void validateUpdateOrder_XCancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickCancelXBtn();
        beginOrderScreenPage.validateBeginOrderTitle();
    }
}