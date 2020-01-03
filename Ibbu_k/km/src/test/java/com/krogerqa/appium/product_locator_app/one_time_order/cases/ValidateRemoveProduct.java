package com.krogerqa.appium.product_locator_app.one_time_order.cases;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateRemoveProduct extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        scanProductPage = new ScanProductPage();
    }

    @Test(groups = {"regression","removeproduct"}, alwaysRun = true)
    /*
     *   Test Name:          validateRemoveProduct_MyOder_Remove
     *   Test Description:   Verifying REMOVE option in remove popup after clicking on trash icon in MyOrder screen.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and taps on trash icon in My Order screen and verifies REMOVE option in remove pop up
     *   Story id:           8387
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. my Order Screen
     *                       3. Order in progress pop up
     *                       4. Remove pop up - Remove option
     */
    public void validateRemoveProduct_MyOrder_Remove() throws Throwable{
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.enterValueInCase(oto_Data.getCaseValue());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateTrashIcon();
        myOrderScreenPage.clickTrash();
        //Validating the Remove Product Popup
        myOrderScreenPage.validateRemoveProductTitle(oto_Data.getDlgTitle());
        //myOrderScreenPage.validateRemoveProductMsg(oto_Data.getDlgMessage());
        updateOrderScreenPage.clickRemove();
        beginOrderScreenPage.validateBeginOrderTitle();
    }

    @Test(groups = {"regression","removeproduct"}, alwaysRun = true)
    /*
     *   Test Name:          validateRemoveProduct_MyOder_Cancel
     *   Test Description:   Verifying CANCEL option in remove popup after clicking on trash icon in MyOrder screen.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and taps on trash icon in My Order screen adn verifies CANCEL option in remove pop up
     *   Story id:           8387,9432
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. my Order Screen
     *                       3. Order in progress pop up
     *                       4. Remove pop up - Cancel option
     */
    public void validateRemoveProduct_MyOrder_Cancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.enterValueInCase(oto_Data.getCaseValue());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateTrashIcon();
        myOrderScreenPage.clickTrash();
        //Validating the Remove Product Popup
        myOrderScreenPage.validateRemoveProductTitle(oto_Data.getDlgTitle());
       //myOrderScreenPage.validateRemoveProductMsg(oto_Data.getDlgMessage());
        updateOrderScreenPage.clickCancel();
        myOrderScreenPage.validateMyOrderHeaderTxt(oto_Data.getMyOrderTitle());
    }

    @Test(groups = {"regression","removeproduct"}, alwaysRun = true)
    /*
     *   Test Name:          validateRemoveProduct_UpdateOrder_Remove
     *   Test Description:   Verifying REMOVE option in popup after clicking REMOVE button in Update order screen.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and taps on remove button in Update Order screen and verifies REMOVE option in remove pop up
     *   Story id:           1866,9432
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. my Order Screen
     *                       3. Order in progress pop up
     *                       4. Remove pop up - Remove option
     */
    public void validateRemoveProduct_UpdateOrder_Remove() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.enterValueInCase(oto_Data.getCaseValue());
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickProductCard();
        updateOrderScreenPage.clickStepperPlus();
        updateOrderScreenPage.validateAndClickRemoveOrder(Consts.lblRemoveButton);
        //Validating the Remove Product Popup
        myOrderScreenPage.validateRemoveProductTitle(oto_Data.getDlgTitle());
        //myOrderScreenPage.validateRemoveProductMsg(oto_Data.getDlgMessage());
        updateOrderScreenPage.clickRemove();
        beginOrderScreenPage.validateBeginOrderTitle();
    }

    @Test(groups = {"regression","removeproduct"}, alwaysRun = true)
    /*
     *   Test Name:          validateRemoveProduct_UpdateOrder_Cancel
     *   Test Description:   Verifying CANCEL option in popup after clicking REMOVE button in Update order screen.
     *   Scenario tested:    The user is on the new order screen and scans valid upc and taps on remove button in Update Order screen and verifies CANCEL option in remove pop up
     *   Story id:           1866
     *   Epic id:            11488
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. Update Order Screen
     *                       2. my Order Screen
     *                       3. Order in progress pop up
     *                       4. Remove pop up - Cancel option
     */
    public void validateRemoveProduct_UpdateOrder_Cancel() throws Throwable {
        orderInprogressPage.clickNewOrder();
        if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(oto_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            beginOrderScreenPage.validateAndClickEnterUPCButton(Consts.lblEnterUPCButton);
            manualEnterUPCPage.enterProductUPC(oto_Data.getProductToScan());
        }
        updateOrderScreenPage.validateAndClickAddToOrderBtn(Consts.lblAddToOrderButton);
        orderUpdatedScreenPage.validateAndClickReviewBtn(Consts.lblReviewButton);
        myOrderScreenPage.validateAndClickProductCard();
        updateOrderScreenPage.clickStepperPlus();
        updateOrderScreenPage.validateAndClickRemoveOrder(Consts.lblRemoveButton);
        //Validating the Remove Product Popup
        myOrderScreenPage.validateRemoveProductTitle(oto_Data.getDlgTitle());
        //myOrderScreenPage.validateRemoveProductMsg(oto_Data.getDlgMessage());
        updateOrderScreenPage.clickCancel();
        updateOrderScreenPage.validateUpdateOrderHeaderTxt(oto_Data.getUpdateOrderHeaderText());
    }
}