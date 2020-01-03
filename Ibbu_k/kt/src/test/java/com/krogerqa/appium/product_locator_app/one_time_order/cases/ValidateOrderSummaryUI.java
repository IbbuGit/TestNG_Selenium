package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
//import com.sun.xml.internal.bind.v2.TODO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateOrderSummaryUI extends Base {

    private MobileCommands mobileCommands;
    private BeginOrderScreenPage beginOrderScreenPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private OrderSummaryPage orderSummaryScreenPage;
    private ScanProductPage scanProductPage;
//    private CommonPage commonPage;

    public static String currentDate;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        orderSummaryScreenPage = new OrderSummaryPage();
        scanProductPage = new ScanProductPage();
//        commonPage = new CommonPage();
        mobileCommands = new MobileCommands();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          VerifyOrderSummary
     *   Test Description:   Verifying Order Summary Screen.
     *   Scenario tested:    The user is on the new order screen and scans two products and submits, then verifying Order Summary screen
     *   Story id:           8326,3794,5268
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. my Order Screen
     *                       3. Order in progress pop up
     *                       4. Order Summary Screen
     */
    public void VerifyOrderSummary() throws Throwable {
        String[] multiUPCs;
        int length;
        SimpleDateFormat current = new SimpleDateFormat("hh:mm a MMM dd, yyyy");
        multiUPCs = oto_Data.getProductToScan().split(";");
        length = multiUPCs.length;
        orderInprogressPage.clickNewOrder();
        //begin order screen
        for (int i = 0; i < length; i++) {
            if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
                mobileCommands.wait(3);
                scanProductPage.scanProduct(multiUPCs[i], Symbology.UPC_A);
            } else {
                beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
                //Enter Upc Screen
                manualEnterUPCPage.enterProductUPC(multiUPCs[i]);
            }
            updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        }
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickSubmitBtn(Consts.lblSubmitButton);
        myOrderScreenPage.validateExitWithoutSubmittingTitle(oto_Data.getDlgTitle());
        myOrderScreenPage.clickSubmit();
        currentDate = current.format(new Date());
        //order summary screen
        orderSummaryScreenPage.validateOrderSummaryHeaderTxt(oto_Data.getOrderSummaryHeader());

        //TODO - API should be mocked for automation of unsuccessful message in Thank You Screen.
        // Currently commenting the Unsuccessful message.
        // Udayashankar Muthu - Commented
        //orderSummaryScreenPage.validateUnsuccessHeader(oto_Data.getUnsuccessCat());
        //orderSummaryScreenPage.validateUnsuccessUPC(multiUPCs[1]);
        //commonPage.verticalSwipeByPercentages(0.6, 0.1, 0.5);
        //orderSummaryScreenPage.validatePendingHeader(oto_Data.getPendingCat());
    }

}