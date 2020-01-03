package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DepartmentScreenValidationAndTutorial extends Base {
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
    MDCTutorialPage mdcTutorialPage;
    ScanproductBRCPage scanproductBRCPage;

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
        mdcTutorialPage = new MDCTutorialPage();
        scanproductBRCPage = new ScanproductBRCPage();
    }

    /*
     * Test Name:           MyDailyCount_verify_MDC_Tutorial
     * Test Description:    All tutorials screens of MDC
     * Scenario tested:      Selects a department, click on kebab menu and select Tutorial
     *                       Validate all tutorial screens
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. MDC Tutorial screens

     */
    @Test(groups = {"Regression"})
    void verifyMDCTutorial() {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        commonPage.clickKebabMenu();
        departmentpage.clickMDCTutorial();
        mdcTutorialPage.validateFirstTutorialScreen();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.validateSecondTutorialScreen();
        mdcTutorialPage.clickBack();
        mdcTutorialPage.validateFirstTutorialScreen();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.validateThirdTutorialScreen();
        mdcTutorialPage.clickBack();
        mdcTutorialPage.validateSecondTutorialScreen();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.validateForthTutorialScreen();
        mdcTutorialPage.clickBack();
        mdcTutorialPage.validateThirdTutorialScreen();
        mdcTutorialPage.clickNext();
        mdcTutorialPage.clickGotIt();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
    }

    /*
     * Test Name:           MyDailyCount_noDepartmentSelected_Test
     * Test Description:    No department selected error
     * Scenario tested:     Redirect to department screen
     *                      And click on Begin button without selecting any department
     *                      And validate error message
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     */
    @Test(groups = {"Regression"})
    void noDepartmentSelected_Test() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.clickGenerateCountButton();
        commonPage.validateToastMessage(mdc_Data.getNoDepartmentSelectedToast());
        Thread.sleep(2000);
    }

    /*
     * Test Name:           MyDailyCount_departmentScreenValidations
     * Test Description:    All department screen validations
     * Scenario tested:     Redirect to department screen
     *                      Click on kebab menu and validate all kebab options
     *                      Also validate Begin button which should be there on department screen
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     */
    @Test(groups = {"Regression"})
    void departmentScreenValidations() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        commonPage.clickKebabMenu();
        commonPage.verifyMDCTutorial();
        commonPage.verifyAbout();
        commonPage.verifyMDCFaq();
        departmentpage.verifyGenerateCountButton();
    }

    @Test(groups = {"Regression", "satart-906"})
    void selectAllDepartmentsAndSubmit() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectAllDepartments();
        departmentpage.clickGenerateCountButton();
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanAndSkipAllProducts(mdc_Data);
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        reviewPage.clickReviewCountSubmitButton();
        thankYouPage.validateCountSubmittedPageTitle(mdc_Data.getCountSubmittedTitle());
        thankYouPage.backToMainMenuButton();
    }

    /*
     * Test Name:           MyDailyCount_validateReminderPopUpAndContinue
     * Test Description:    Validate Reminder pop up and then continue
     * Scenario tested:     Redirect to department screen
     *                      Select a department which has total count is equal to remaining count
     *                      Validate reminder pop up which will appear o screen and click on continue button
     *                      User should redirect to Find product screen
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Find Product screen
     */
    @Test(groups = {"ispart-20226","Sanity"})
    void validateReminderPopUpAndContinue() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.verifyReminderDialogueTitle();
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateReminderPopUpAndGotoBRC
     * Test Description:    Validate Reminder pop up and then Go To Backroom
     * Scenario tested:     Redirect to department screen
     *                      Select a department which has total count is equal to remaining count
     *                      Validate reminder pop up which will appear o screen and click on Go To backrrom button
     *                      User should redirect to Scan screen of backroom Count
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Scan Screen of Backroom count
     */
    @Test(groups = {"ispart-20226","Sanity"})
    void validateReminderPopUpAndGotoBRC() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.verifyReminderDialogueTitle();
        departmentpage.clickOnGotoBRC();
        departmentpage.validateScanProductTitle(Consts.lblScanScreenTitle);
    }


}
