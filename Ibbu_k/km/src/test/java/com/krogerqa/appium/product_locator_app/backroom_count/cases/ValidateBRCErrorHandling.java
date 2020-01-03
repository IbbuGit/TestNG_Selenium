package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateBRCErrorHandling
        extends Base {

    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    private TaskListPage taskListPage;
    private CommonPage commonPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
        taskListPage = new TaskListPage();
        commonPage = new CommonPage();

    }

    @Test(groups = {"ispart-18841"})
    void ValidateErrorHandlingForOnClickBRC() {

        unSubmittedCount.clickNewCount();
        scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
        scanproductBRCPage.clickEnterUPC();
        scanproductBRCPage.validateEnterUPCTitle(bc_Data.getEnterUPC());
        scanproductBRCPage.validateCancelButton();
        scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
        scanproductBRCPage.clickSubmit();
        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();
    }

    @Test(groups = {"ispart-18291"})
    void ValidateErrorHandlingForReviewAndSubmitButton() throws Throwable {

        unSubmittedCount.clickNewCount();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.validateEnterUPCTitle(bc_Data.getEnterUPC());
            scanproductBRCPage.validateCancelButton();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.validateProdDetails();
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
        countProductPage.validateProdTotalUnitsCount();
        countProductPage.clickReview();

        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();

        taskListPage.clickBackroomCount();
        unSubmittedCount.clickUnSubmittedContinueBtn();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        reviewCountPage.clickSubmit();

        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();
    }

    @Test(groups = {"ispart-19085"})
    void ValidateErrorHandlingFromDeleteIcon() throws Throwable {

        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickDeleteIcon();
        reviewCountPage.validateRemoveProductPopup();
        reviewCountPage.clickRemove();

        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();


    }

    @Test(groups = {"ispart-19085"})
    void ValidateErrorHandlingFromUnSubmittedNewCount() throws Throwable {

        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan().split("@")[1], Symbology.UPC_A);
        } else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.validateEnterUPCButton(Consts.lblEnterUPCButton);
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        commonPage.backAndroidButton();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedLeaveBtn();
        taskListPage.clickBackroomCount();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.clickNewCount();

        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();
    }

    @Test(groups = {"ispart-18843"})
    void ValidateErrorHandlingOnClickBackroom() {

        scanproductBRCPage.validateWrngAltTitle(bc_Data.getSomethingWentWrongAlertTitle());
        scanproductBRCPage.clickTryAgainButton();
        scanproductBRCPage.validateProceedAltTitle(bc_Data.getUnableToProceedAlertTitle());
        scanproductBRCPage.clickExitTaskButton();

    }


}
