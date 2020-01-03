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

public class ExitWithoutSubmittingDialog extends Base{
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private TaskListPage taskListPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        scanProductPage = new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        taskListPage = new TaskListPage();
    }
    @Test(groups = {"regression"},alwaysRun = true)
    /*
     * Test Name:           verifyExitWithoutSubmittingDialog_Exit
     * Test Description:    Verifying EXIT option in exit order popup.
     * Scenario tested:     The user updates a existing order and validates the Exit Pop up (Exit Option) without submitting the order
     * Story id:            8741
     * Epic id:             11488
     * Test data:           data dependent
     * API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     * UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order functionality
     *                      3. Exit without submitting pop up - Exit option
     *                      4. Order in progress pop up
     */
    public void verifyExitWithoutSubmittingDialog_Exit() throws Throwable {
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
        myOrderScreenPage.validateExitWithoutSubmittingTitle(oto_Data.getDlgTitle());
        myOrderScreenPage.validateExitWithoutSubmittingMsg(oto_Data.getDlgMessage());
        myOrderScreenPage.clickExit();
        taskListPage.clickOneTimeOrder();
        orderInprogressPage.clickNewOrder();
    }
    @Test(groups = {"regression"},alwaysRun = true)
    /*
     * Test Name:           verifyExitWithoutSubmittingDialog_Cancel
     * Test Description:    Verifying EXIT option in exit order popup.
     * Scenario tested:     The user updates a existing order and validates the Exit Pop up (Cancel Option) without submitting the order
     * Story id:            8741
     * Epic id:             11488
     * Test data:           data dependent
     * API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     * UI screen tested:
     *                      1. Update Order Screen
     *                      2. Add to Order functionality
     *                      3. Exit without submitting pop up - Cancel option
     */
    public void verifyExitWithoutSubmittingDialog_Cancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        }
        else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        updateOrderScreenPage.navigateBack();
        myOrderScreenPage.validateExitWithoutSubmittingTitle(oto_Data.getDlgTitle());
        myOrderScreenPage.validateExitWithoutSubmittingMsg(oto_Data.getDlgMessage());
        myOrderScreenPage.clickCancel();
        orderUpdatedScreenPage.validateOrderUpdateHeaderTxt(oto_Data.getTextOrderUpdate());
    }

    @Test(groups = {"regression"},alwaysRun = true)
    public void verifyExitWithoutUserAction(){
        /*
         * Test Name:           verifyExitWithoutUserAction
         * Test Description:    Verifying EXIT option in kebab menu
         * Scenario tested:     The user is exiting order without adding any products using kebab menu.
         * Story id:            8741
         * Epic id:             11488
         * Test data:           data independent
         * API tested:
         *                      1. api/v1/adhoc-order-items
         *                      2. api/v1/update-adhoc-items
         * UI screen tested:
         *                      1. Begin Order Screen
         */
        orderInprogressPage.clickNewOrder();
        beginOrderScreenPage.validateBeginOrderTitle();
        beginOrderScreenPage.clickKebabMenu();
        beginOrderScreenPage.validateAndClickExitOrder();
        taskListPage.clickOneTimeOrder();
        beginOrderScreenPage.validateBeginOrderTitle();
    }
}