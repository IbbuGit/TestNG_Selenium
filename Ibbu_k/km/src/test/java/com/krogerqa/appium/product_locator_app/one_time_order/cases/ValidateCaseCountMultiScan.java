package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateCaseCountMultiScan extends Base {

    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private ScanProductPage scanProductPage;

    public String[] multiUPCs;
    public int length;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        scanProductPage = new ScanProductPage();
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyCaseCountScanSameProductUpdateOrder
     *   Test Description:   Verifying functionality of scanning same product using Scanner.
     *   Scenario tested:    The user is on the new order screen and scans single product twice using scanner
     *   Story id:
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     */
    public void verifyCaseCountScanSameProductUpdateOrder() throws Throwable{

        multiUPCs = oto_Data.getProductToScan().split(";");
        length = multiUPCs.length;
        orderInprogressPage.clickNewOrder();
        for (int i = 0; i < length; i++) {
            mobileCommands.wait(3);
            scanProductPage.scanProduct(multiUPCs[i], Symbology.UPC_A);
        }
        updateOrderScreenPage.validateProductCountPlus(Integer.toString(length));
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyCaseCountScanSameProductScanScreen
     *   Test Description:   Verifying functionality of scanning same product using Scanner.
     *   Scenario tested:    The user is on the new order screen and scans single product twice using scanner
     *   Story id:
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     */
    public void verifyCaseCountScanSameProductScanScreen() throws Throwable{

        multiUPCs = oto_Data.getProductToScan().split(";");
        length = multiUPCs.length;
        orderInprogressPage.clickNewOrder();
        for (int i = 0; i < length; i++) {
            mobileCommands.wait(3);
            scanProductPage.scanProduct(multiUPCs[i], Symbology.UPC_A);
            updateOrderScreenPage.clickAddToOrder();
        }
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickProductCard();
        updateOrderScreenPage.validateProductCountPlus(Integer.toString(length));
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyCaseCountScanAndEnterSameUPC
     *   Test Description:   Verifying functionality of scanning same product using Scanner.
     *   Scenario tested:    The user is on the new order screen and scans single product twice using scanner
     *   Story id:
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     */
    public void verifyCaseCountScanAndEnterSameUPC() throws Throwable{

        multiUPCs = oto_Data.getProductToScan().split(";");
        length = multiUPCs.length;
        orderInprogressPage.clickNewOrder();
        for (int i = 0; i < length; i++) {
            if(i == 0) {
                mobileCommands.wait(3);
                scanProductPage.scanProduct(multiUPCs[i], Symbology.UPC_A);
                updateOrderScreenPage.clickAddToOrder();
            }
            else {
                orderUpdatedScreenPage.validateAndClickBtnUpc(Consts.lblEnterUPCButton);
                manualEnterUPCPage.enterProductUPC(multiUPCs[1]);
                updateOrderScreenPage.clickAddToOrder();
            }
        }
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickProductCard();
        updateOrderScreenPage.validateProductCountPlus(Integer.toString(length));
    }

    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          verifyCaseCountEnterSameUPC
     *   Test Description:   Verifying functionality of scanning same product using Scanner.
     *   Scenario tested:    The user is on the new order screen and scans single product twice using scanner
     *   Story id:
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. Order in progress pop up
     */
    public void verifyCaseCountEnterSameUPC() throws Throwable{

        multiUPCs = oto_Data.getProductToScan().split(";");
        length = multiUPCs.length;
        orderInprogressPage.clickNewOrder();
        for (int i = 0; i < length; i++) {
            orderUpdatedScreenPage.validateAndClickBtnUpc(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(multiUPCs[1]);
            updateOrderScreenPage.clickAddToOrder();
        }
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickProductCard();
        updateOrderScreenPage.validateProductCountPlus(Integer.toString(length));
    }
}
