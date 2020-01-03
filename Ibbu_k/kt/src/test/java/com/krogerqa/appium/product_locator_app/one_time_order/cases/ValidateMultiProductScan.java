package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateMultiProductScan extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private OrderSummaryPage orderSummaryScreenPage;
    private ScanProductPage scanProductPage;
    private String[] scanProduct;
    private int length;

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
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyMultiProductScan_AddMore
     *   Test Description:   Verifying scanning multiple products using scanner.
     *   Scenario tested:    The user is on the new order screen and scans multiple products using Add more button
     *   Story id:           8763
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
    public void verifyMultiProductScan_AddMore() throws Throwable {
        orderInprogressPage.clickNewOrder();
        scanProduct = oto_Data.getProductToScan().split(";");
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(scanProduct[0], Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(scanProduct[0]);
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.clickAddMoreBtn();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(scanProduct[1], Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(scanProduct[1]);
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickSubmitBtn(Consts.lblSubmitButton);
        myOrderScreenPage.validateExitWithoutSubmittingTitle(oto_Data.getDlgTitle());
        myOrderScreenPage.clickSubmit();
        //order summary screen
        orderSummaryScreenPage.validateOrderSummaryHeaderTxt(oto_Data.getOrderSummaryHeader());
        //orderSummaryScreenPage.mainMenuBtnClick();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyMultiProductScan_EnterUPC
     *   Test Description:   Verifying functionality of adding multiple products using Scanner and Enter UPC button.
     *   Scenario tested:    The user is on the new order screen and scans multiple products using Enter UPC button
     *   Story id:           8763
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
     *                       5. Enter UPC pop up
     */
    public void verifyMultiProductScan_EnterUPC() throws Throwable {
        orderInprogressPage.clickNewOrder();
        scanProduct = oto_Data.getProductToScan().split(";");
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(scanProduct[0], Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(scanProduct[0]);
        }
        updateOrderScreenPage.validateUpdateOrderHeaderTxt(oto_Data.getUpdateOrderHeaderText());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);

        orderUpdatedScreenPage.validateAndClickBtnUpc(Consts.lblEnterUPCButton);
        manualEnterUPCPage.enterProductUPC(scanProduct[1]);

        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickSubmitBtn(Consts.lblSubmitButton);
        myOrderScreenPage.validateExitWithoutSubmittingTitle(oto_Data.getDlgTitle());
        myOrderScreenPage.clickSubmit();
        //order summary screen
        orderSummaryScreenPage.validateOrderSummaryHeaderTxt(oto_Data.getOrderSummaryHeader());
        //orderSummaryScreenPage.mainMenuBtnClick();
    }
}