package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.BeginOrderScreenPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.ManualEnterUPCPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.OrderInProgressPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.UpdateOrderScreenPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateManualEnterUPCDialog extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderInProgressPage orderInprogressPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderInprogressPage = new OrderInProgressPage();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:         verifyManualEnterUPC_Cancel
     *   Test Description:  Verifying CANCEL option in Manual Product Entry popup.
     *   Scenario tested:   The user is on the new order screen and taps on Enter upc and verifies the CANCEL option in Manual entry Pop up dialog
     *   Story id:          1913,1912,1926
     *   Epic id:           11488
     *   Test data:         data dependent
     *   API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                      1. Update Order Screen
     *                      2. Enter UPC pop up - Submit option
     *                      3. Order in progress pop up
     */
    public void verifyManualEnterUPC_Cancel() {
        orderInprogressPage.clickNewOrder();
        beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
        manualEnterUPCPage.validateManualEnterUPCTitle(Consts.titleManualEnterUPC);
        manualEnterUPCPage.validateEnterUPCOrPLU(Consts.lblEnterUPCOrPLU);
        manualEnterUPCPage.validateManualEnterHint(Consts.lblManualEnterHint);
        manualEnterUPCPage.validateCancelButton(Consts.lblCancelButton);
        manualEnterUPCPage.validateSubmitButton(Consts.lblSubmitButton);
        manualEnterUPCPage.clickCancelButton();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyManualEnterUPC_Submit
     *   Test Description:   Verifying SUBMIT option in Manual Product Entry popup.
     *   Scenario tested:    The user is on the new order screen and taps on Enter upc and verifies the SUBMIT option in Manual entry Pop up dialog
     *   Story id:           1913,1912,1926
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Enter UPC pop up - Submit option
     *                       3. Order in progress pop up
     */
    public void verifyManualEnterUPC_Submit() {
        orderInprogressPage.clickNewOrder();
        beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
        manualEnterUPCPage.validateManualEnterUPCTitle(Consts.titleManualEnterUPC);
        manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        updateOrderScreenPage.validateUpdateOrderTitle(oto_Data.getUpdateOrderHeaderText());
    }
}