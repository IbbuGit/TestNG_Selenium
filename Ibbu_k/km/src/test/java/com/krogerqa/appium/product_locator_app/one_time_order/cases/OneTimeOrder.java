package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

class OneTimeOrder extends Base {
    // Declaration class object
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private OrderSummaryPage orderSummaryScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;


    //Assign object for class
    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage=new BeginOrderScreenPage();
        updateOrderScreenPage=new UpdateOrderScreenPage();
        orderUpdatedScreenPage=new OrderUpdatedScreenPage();
        myOrderScreenPage=new MyOrderScreenPage();
        orderSummaryScreenPage=new OrderSummaryPage();
        scanProductPage=new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     * Test Name:           oneTimeOrder_SmokeSuite
     * Test Description:    One time order happy path
     * Scenario tested:     The user updates the order for 1st upc, reviews the order and
     *                      then updates the 2nd upc add and then submits the updated order.
     * Story id:            8741
     * Epic id:             11488
     * Test data:           data dependent
     * API tested:
     *                      1. api/v1/adhoc-order-items
     *                      2. api/v1/update-adhoc-items
     * UI screen tested:
     *                      1. Update Order Screen
     *                      2. Stepper Plus and Stepper Minus
     *                      2. Add to Order functionality
     *                      3. Exit without submitting pop up - Cancel option
     *                      4. Submit order pop up
     *                      5. Order summary page
     *                      6. Thank You screen
     */
    public void oneTimeOrder_SmokeSuite() throws Throwable {
        String[] scanProduct;
        orderInprogressPage.clickNewOrder();
        scanProduct = oto_Data.getProductToScan().split(";");
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(scanProduct[0],Symbology.UPC_A);
        }
        else
        {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(scanProduct[0]);
        }
        //Update order screen
        updateOrderScreenPage.validateUpdateOrderHeaderTxt(oto_Data.getUpdateOrderHeaderText());
        updateOrderScreenPage.validateUpcTxt(scanProduct[0]);
        //updateOrderScreenPage.validateProductName(oto_Data.getProductName());
        updateOrderScreenPage.clickStepperPlus();
        updateOrderScreenPage.clickStepperMinus();
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        //Order update screen
        //orderUpdatedScreenPage.clickContinueBtn();
        //orderUpdatedScreenPage.validateOrderUpdateHeaderTxt(oto_Data.getTextOrderUpdate());
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        //My order screen
        myOrderScreenPage.validateMyOrderHeaderTxt(oto_Data.getMyOrderTitle());
        myOrderScreenPage.clickAddMoreBtn();
        //Scanning Additional UPCs using Add More Button
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(scanProduct[1],Symbology.UPC_A);
        }
        else
        {
            orderUpdatedScreenPage.validateAndClickBtnUpc(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(scanProduct[1]);
        }
        //Update order screen
        updateOrderScreenPage.validateUpdateOrderHeaderTxt(oto_Data.getUpdateOrderHeaderText());
        updateOrderScreenPage.validateUpcTxt(scanProduct[1]);
        updateOrderScreenPage.clickStepperPlus();
        updateOrderScreenPage.validateProductCountPlus(oto_Data.getProductCountPlus());
        updateOrderScreenPage.clickStepperMinus();
        updateOrderScreenPage.validateProductCountMinus(oto_Data.getProductCountMinus());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        //Order update screen
        myOrderScreenPage.navigateBack();
        myOrderScreenPage.ClickWithoutCancelBtn();
        myOrderScreenPage.validateAndClickSubmitBtn(Consts.lblSubmitButton);
        myOrderScreenPage.validateAndClickPopupSubmitBtn(Consts.lblSubmitButton);
        //order summary screen
        orderSummaryScreenPage.validateOrderSummaryHeaderTxt(oto_Data.getOrderSummaryHeader());
        //orderSummaryScreenPage.mainMenuBtnClick();

    }
}