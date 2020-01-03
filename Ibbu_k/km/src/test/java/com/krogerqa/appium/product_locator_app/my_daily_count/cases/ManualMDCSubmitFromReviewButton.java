package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ManualMDCSubmitFromReviewButton extends Base {


    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    ScanProductPage scanProductPage;
    MDCCountProductPage mdcCountProductPage;
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;
    MDCReviewCountPage reviewCountPage;
    ThankYouPage thankYouPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        mdcCountProductPage = new MDCCountProductPage();
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
        reviewCountPage = new MDCReviewCountPage();
        thankYouPage = new ThankYouPage();

    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCClickSubmitFromReviewButton
     * Test Description:    Validate submit button of review screen after counting all products
     * Scenario tested:     The user selects a department and does scans, skip ,wrong location for all products
     *                      then reviews the scanned products on Review screen
     *                      Validate submit button is displayed on review screen
     *                      Also checks total no. of counted products on Thank you screen
     * Story id:
     * Epic id:
     * Test data:           Any dependent
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product Screen
     *                      3. Count Product screen
     *                      4. Review screen
     *                      5. Thank you screen
     */
    @Test(groups = {"smoke"})
    void validateManualMDCClickSubmitFromReviewButton() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        int scannedItemNum=findProductPage.allPrdScan(mdc_Data);
        reviewCountPage.validateReviewCountPageTitle ( mdc_Data.getReviewCountTitle () );
        reviewCountPage.verifyEnabledReviewCountSubmitButton ();
        reviewCountPage.clickReviewCountSubmitButton ();
        thankYouPage.validateCountSubmittedPageTitle ( mdc_Data.getCountSubmittedTitle () );
        thankYouPage.successImageVisibility();
        thankYouPage.verifySuccessText();
        thankYouPage.verifyTotalProductsCountSubmitted(scannedItemNum);
        thankYouPage.verifyCountWord();
        thankYouPage.backToMainMenuButton();

    }

}
