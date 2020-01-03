package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.MainMenuPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateUnSubmittedCountPopup extends Base {
    private CountProductPage countProductPage;
    private MainMenuPage mainMenuPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    private TaskListPage taskListPage;
    private String[] multipleUPCs;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        mainMenuPage = new MainMenuPage();
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
        taskListPage = new TaskListPage();
    }

    /*
     * Test Name            :   verifyUnsubmittedPopupCancelBtn
     * Test Description     :   Verifying cancel button in unsubmitted pop up.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on navigation button in review count screen
     *                          4.validates and taps on cancel button in unsubmitted count pop up
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyUnsubmittedPopupCancelBtn() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        countProductPage.clickNavigationBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedCancelBtn();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
    }

    /*
     * Test Name            :   verifyUnsubmittedPopupLeaveBtn
     * Test Description     :   Verifying leave button in unsubmitted pop up.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on navigation button in review count screen
     *                          4.validates and taps on leave button in unsubmitted count pop up
     *                          5.verify task list page and tap on new count in unsubmitted count pop up
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyUnsubmittedPopupLeaveBtn() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        countProductPage.clickNavigationBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedLeaveBtn();
        mainMenuPage.validateMainMenuPageTitle(Consts.titleMainMenu);
        taskListPage.clickBackroomCount();
        unSubmittedCount.clickNewCount();
    }

    /*
     * Test Name            :   verifyMultiScanUnsubmittedPopupLeaveBtn
     * Test Description     :   Verifying leave button in unsubmitted pop up for multi product scan.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on add more in review count screen
     *                          4.scans multiple products and taps on review button in count product screen
     *                          5.taps on navigation button in review count screen
     *                          6.validates unsubmitted count pop up and taps on leave button
     *                          6.verify task list page and tap on new count in unsubmitted count pop up
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyMultiScanUnsubmittedPopupLeaveBtn() throws Exception {
        multipleUPCs = bc_Data.getProductToScan().split(";");
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[0], Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[0]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickAddMore();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[1], Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[1]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        countProductPage.clickNavigationBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedLeaveBtn();
        mainMenuPage.validateMainMenuPageTitle(Consts.titleMainMenu);
        taskListPage.clickBackroomCount();
        unSubmittedCount.clickNewCount();
    }

    /*
     * Test Name            :   verifyMultiScanUnsubmittedPopupCancel
     * Test Description     :   Verifying cancel button in unsubmitted pop up for multi product scan.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on add more in review count screen
     *                          4.scans multiple products and taps on review button in count product screen
     *                          5.taps on navigation button in review count screen
     *                          6.validates unsubmitted count pop up and taps on cancel button
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyMultiScanUnsubmittedPopupCancel() throws Exception {
        multipleUPCs = bc_Data.getProductToScan().split(";");
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(multipleUPCs[0], Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(multipleUPCs[0]);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickEnterUPC();
        scanproductBRCPage.enterUPC(multipleUPCs[1]);
        scanproductBRCPage.clickSubmit();
        countProductPage.clickReview();
        countProductPage.clickNavigationBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedCancelBtn();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
    }

    /*
     * Test Name            :   verifyUnsubmittedPopupScanProductPg
     * Test Description     :   Verifying unsubmitted pop up in scan product screen.
     * Scenario tested      :   1.The user scans a product
     *                          2.taps on review button in count product screen
     *                          3.taps on add more in review count screen
     *                          4.validates and taps on cancel button in unsubmitted count pop up in scan product screen
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void verifyUnsubmittedPopupScanProductPg() throws Exception {
        unSubmittedCount.clickNewCount();
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        reviewCountPage.clickAddMore();
        scanproductBRCPage.clickBackBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedCancelBtn();
        scanproductBRCPage.clickEnterUPC();
        scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
        scanproductBRCPage.clickSubmit();
        countProductPage.clickReview();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        countProductPage.clickNavigationBtn();
        unSubmittedCount.validateUnSubmittedTitle();
        unSubmittedCount.ValidateAndClickUnsubmittedLeaveBtn();
        mainMenuPage.validateMainMenuPageTitle(Consts.titleMainMenu);
        taskListPage.clickBackroomCount();
        unSubmittedCount.clickNewCount();
    }
}