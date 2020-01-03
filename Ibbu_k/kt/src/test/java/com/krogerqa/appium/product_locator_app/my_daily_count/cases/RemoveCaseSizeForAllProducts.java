package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RemoveCaseSizeForAllProducts extends Base {

    LogInPage logInPage;
    TaskListPage taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    MDCCountProductPage mdcCountProductPage;
    ThankYouPage thankYouPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    MDCReviewCountPage reviewPage;
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
     * Test Name:           MyDailyCount_removeCaseSize
     * Test Description:    Remove Case Size from Count Product screen
     * Scenario tested:     User selects any department and scan any product
     *                      then user should navigated to Count Product screen and Case Size should not be present on same screen
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Scan on Find Product screen
     *                      3. Count Product screen
     *                      4.Case Size field on Count Product screen
     *
     */
    @Test(groups = {"ispart-18141", "Sanity"})
    void removeCaseSize() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateUPC();
        mdcCountProductPage.validateProductDescription();
        mdcCountProductPage.validateProductProce();
        mdcCountProductPage.validateUnitCountText();
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.caseSizeVisibility();
    }

}
