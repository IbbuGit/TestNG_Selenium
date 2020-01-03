package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CountProductScreenValidation extends Base {
    LogInPage logInPage;
    TaskListPage taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    MDCReviewCountPage reviewPage;
    MDCCountProductPage mdcCountProductPage;
    ThankYouPage thankYouPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    ScanProductPage scanProductPage;
    TutorialPage tutorialPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        logInPage = new LogInPage();
        taskListPage = new TaskListPage();
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        reviewPage = new MDCReviewCountPage();
        mdcCountProductPage = new MDCCountProductPage();
        thankYouPage = new ThankYouPage();
        commonPage = new CommonPage();
        logOutPage = new LogOutPage();
        scanProductPage = new ScanProductPage();
        tutorialPage = new TutorialPage();
    }

    /*
     * Test Name:           MyDailyCount_countProductScreenValidations
     * Test Description:    All Count product screen validations
     * Scenario tested:     Selects a department, Scan a product on Find Product screen
     *                      All elements from Count product screen like Title, Product image, image enlargement, UPD,Product details,etc
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *                      3. Count Product screen
     */
    @Test(groups = {"Regression"})
    void countProductScreenValidations() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnProductImageIcon();
        mdcCountProductPage.validateEnlargeImage();
        mdcCountProductPage.closeImage();
        mdcCountProductPage.validateUPC();
        mdcCountProductPage.validateProductDescription();
        mdcCountProductPage.validateProductProce();
        mdcCountProductPage.validateUnitCountText();
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
    }
    /*
     * Test Name:           MyDailyCount_validateThresholdValue
     * Test Description:    Threshold value validation of calculator in count product screen
     * Scenario tested:      Selects a department, Scan a product on Find Product screen
     *                       Click on text box to enter quantity in Coumt product screen.
     *                       Enter value greater than 9999 and validate error message
     * Story id:
     * Epic id:
     * Test data:           Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     *                      3. Count Product screen

     */

    @Test(groups = {"Regression"})
    void validateThresholdValue() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterThresholdValue();
        mdcCountProductPage.verifyThresholdValueError(mdc_Data.getThresholdErrorMessage());
    }

}
