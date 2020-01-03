package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ManualMDCReviewButton extends Base {


    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private ScanProductPage scanProductPage;
    private MDCCountProductPage mdcCountProductPage;
    private AddProductToCountPage addProductToCountPage;
    private SelectYourLocationPage selectYourLocationPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        mdcCountProductPage = new MDCCountProductPage();
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();

    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCReviewButtonAfterClickingWrongLocationForFirstProduct
     * Test Description:    Review button after wrong location of a product
     * Scenario tested:     Selects a department, make wrong location a product on Find Product screen
     *                      User will stay on same find product screen
     *                      Review button should be visible after one wrong location
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *
     */
    @Test(groups = {"ispart-11734"})
    void validateManualMDCReviewButtonAfterClickingWrongLocationForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickWrongLocationButton();
        findProductPage.verifyEnabledMDCReviewButton();

    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCReviewButtonAfterClickingSkipForFirstProduct
     * Test Description:    Review button after skipping product
     * Scenario tested:     Selects a department, skip a product on Find Product screen
     *                      User will stay on same find product screen
     *                      Review button should be visible after skipping a product
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *
     */
    @Test(groups = {"ispart-11734"})
    void validateManualMDCReviewButtonAfterClickingSkipForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickSkipButton();
        findProductPage.verifyEnabledMDCReviewButton();

    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCReviewButtonAfterCountSubmittedForFirstProduct
     * Test Description:    Review button after scanning product
     * Scenario tested:     Selects a department, scan a product on Find Product screen
     *                      User will stay on same find product screen
     *                      Review button should be visible after scanning a product
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *
     */
    @Test(groups = {"ispart-11734"})
    void validateManualMDCReviewButtonAfterCountSubmittedForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        //departmentpage.selectDepartment(mdc_Data);
        //departmentpage.clickGenerateCountButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(findProductPage.getUPCOfProduct(), Symbology.UPC_A);
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.swipeAndEnterUnitCount();
        mdcCountProductPage.clickMDCNextButton();
        mdcCountProductPage.verifySnackBarText();
        findProductPage.verifyEnabledMDCReviewButton();

    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCReviewButtonAfterCountSubmittedForSingleLocationFreeScanItemForFirstProduct
     * Test Description:    Review button after scanning product
     * Scenario tested:     Selects a department, scan a free scan single location product on Find Product screen
     *                      User will stay on same find product screen
     *                      Review button should be visible after scanning a single location free scan product
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *
     */
    @Test(groups = {"ispart-11734"})
    void validateManualMDCReviewButtonAfterCountSubmittedForSingleLocationFreeScanItemForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanItem().split("@")[3], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.swipeAndEnterUnitCount();
        mdcCountProductPage.clickMDCNextButton();
        mdcCountProductPage.verifySnackBarText();
        findProductPage.verifyEnabledMDCReviewButton();

    }
    /*
     * Test Name:           MyDailyCount_validateManualMDCReviewButtonAfterCountSubmittedForMultiLocationFreeScanItemForFirstProduct
     * Test Description:    Review button after scanning product
     * Scenario tested:     Selects a department, scan a free scan multi location product on Find Product screen
     *                      User will stay on same find product screen
     *                      Review button should be visible after scanning a multi location free scan product
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *
     */

    @Test(groups = {"ispart-11734"})
    void validateManualMDCReviewButtonAfterCountSubmittedForMultiLocationFreeScanItemForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanItem().split("@")[7], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        // selectYourLocationPage.selectRadioButton ( mdc_Data.getSelectAisle () );
        selectYourLocationPage.selectRadioButton(1);
        selectYourLocationPage.verifyEnabledSelectButton();
        selectYourLocationPage.clickSelectButton();
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.swipeAndEnterUnitCount();
        mdcCountProductPage.clickMDCNextButton();
        mdcCountProductPage.verifySnackBarText();
        findProductPage.verifyEnabledMDCReviewButton();

    }


}
