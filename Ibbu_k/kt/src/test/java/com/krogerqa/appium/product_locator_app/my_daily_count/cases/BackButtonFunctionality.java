package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class BackButtonFunctionality extends Base {
    LogInPage      logInPage;
    TaskListPage   taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    MDCCountProductPage mdcCountProductPage;
    CommonPage     commonPage;
    LogOutPage     logOutPage;
    ScanProductPage scanProductPage;
    TutorialPage tutorialPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        logInPage = new LogInPage();
        taskListPage = new TaskListPage();
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        mdcCountProductPage = new MDCCountProductPage();
        commonPage = new CommonPage();
        logOutPage = new LogOutPage();
        scanProductPage = new ScanProductPage();
        tutorialPage = new TutorialPage();
    }
    /*
     * Test Name:           MyDailyCount_backFromFindProductScreen
     * Test Description:    Back button functionality from Find Product screen
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then click on back button and user should redirect on Department screen
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Back button on Find Product screen
     *                      4. Again validate department screen title
     */
    @Test(groups = {"Regression"})

    public void backFromFindProductScreen() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.clickBackButton();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
    }
    /*
     * Test Name:           MyDailyCount_backFromCountProductScreen
     * Test Description:    Back button functionality from Count Product screen
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then scan a product and user should redirect on Count Product screen.
     *                      then click on back button, and user should be redirected to Find product screen
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)and scan a product
     *                      3. Count Product screen
     *                      4. Back button on Count Product screen
     *                      5. Again validate Find Product screen title
     */
    @Test(groups = {"Regression"})

    public void backFromCountProductScreen() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.scanSingleProduct();
        commonPage.clickBackButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }
    /*
     * Test Name:           MyDailyCount_backFromCountProductScreenWhenCalculatorIsOpened
     * Test Description:    Back button functionality from Count Product screen when calculator is open
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then scan a product .user should redirect on Count Product screen and click on test box to open calculator
     *                      then click on back button, and user should remain on same count product screen by closing calculator
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)and scan a product
     *                      3. Count Product screen
     *
     */
    @Test(groups = {"Regression"})

    public void backFromCountProductScreenWhenCalculatorIsOpened() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle ( mdc_Data.getCountProductTitle ( ) );
        mdcCountProductPage.clickOnEnterQuantityTextField ( );
        commonPage.clickBackButton();
        mdcCountProductPage.validateCountProductPageTitle ( mdc_Data.getCountProductTitle ( ) );
    }
    /*
     * Test Name:           MyDailyCount_backFromCountProductScreenAfterEnteringCount
     * Test Description:    Back button functionality from Count Product screen after entering quantity
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then scan a product and user should redirect on Count Product screen.
     *                      Enter quantity of that product and click on green tick on calculator
     *                      then click on back button, and user should be redirected to Find product screen
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)and scan a product
     *                      3. Count Product screen

     */
    @Test(groups = {"Regression"})

    public void backFromCountProductScreenAfterEnteringCount() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle ( mdc_Data.getCountProductTitle ( ) );
        mdcCountProductPage.clickOnEnterQuantityTextField ( );
        mdcCountProductPage.enterQuantity ( );
        commonPage.clickBackButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

}