package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OrderInprogressDialog extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private TaskListPage taskListPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        scanProductPage = new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        taskListPage=new TaskListPage();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     * Test Name:           verifyOrderInprogressDialog_NewOrder
     * Test Description:    One time order happy path
     * Scenario tested:     The user updates the order for an upc and exits One time order and click on One time order and
     *                      verifies the Order in progress pop up
     * Story id:            5826
     * Epic id:             11488
     * Test data:           data dependent
     * API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     * UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order button
     *                      3. Order In progress pop up
     */

    public void verifyOrderInprogressDialog_NewOrder() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        updateOrderScreenPage.navigateBack();
        myOrderScreenPage.clickExit();
        taskListPage.clickOneTimeOrder();
        orderInprogressPage.validateOrderInProgressTitle(oto_Data.getDlgTitle());
        orderInprogressPage.validateOrderInProgressMsg(oto_Data.getDlgMessage());
        orderInprogressPage.clickNewOrder();
        beginOrderScreenPage.validateBeginOrderTitle();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     * Test Name:           verifyOrderInprogressDialog_NewOrder
     * Test Description:    One time order happy path
     * Scenario tested:     The user updates the order for an upc and exits One time order and click on One time order and
     *                      verifies the Order in progress pop up
     * Story id:            5826
     * Epic id:             11488
     * Test data:           data dependent
     * API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     * UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order button
     *                      3. Order In progress pop up - Continue option
     */
    public void verifyOrderInprogressDialog_Continue() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        updateOrderScreenPage.navigateBack();
        myOrderScreenPage.clickExit();
        taskListPage.clickOneTimeOrder();
        orderInprogressPage.clickContinue();
        myOrderScreenPage.validateMyOrderHeaderTxt(oto_Data.getMyOrderTitle());
    }
}
