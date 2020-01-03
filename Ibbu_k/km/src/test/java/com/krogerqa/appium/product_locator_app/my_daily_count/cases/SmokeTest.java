package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.MDCCountProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.FindProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.ThankYouPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SmokeTest extends Base {

    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private ThankYouPage thankYouPage;
    private MDCReviewCountPage reviewPage;

    LogInPage logInPage;
    TaskListPage taskListPage;
    MDCCountProductPage mdcCountProductPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    ScanProductPage scanProductPage;
    MDCTutorialPage mdcTutorialPage;

    @BeforeMethod(alwaysRun = true)

    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        reviewPage = new MDCReviewCountPage();
        mdcCountProductPage = new MDCCountProductPage();
        thankYouPage = new ThankYouPage();
    }

    /*
     * Test Name:           MyDailyCount_SmokeSuite
     * Test Description:    My Daily Count happy path
     * Scenario tested:     The user selects a department and does scans, skip ,wrong location for all products
     *                      then reviews the scanned products.And finally checks total no. of counted products on Thank you screen
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
    void smoke_Test() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());       //ISPART-729
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());            //ISPART-7922,ISPAR-1421
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());     //ISPART-14535
        findProductPage.getProductCountStatus();            //ISPAR-873
        findProductPage.scanAndSkipAllProducts(mdc_Data); //ISPART-4215,ISPAR-873,ISPART-801,ISPART-875,ISPART-839,ISPART-2285,ISPART-837
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        reviewPage.clickReviewCountSubmitButton();
        thankYouPage.validateCountSubmittedPageTitle(mdc_Data.getCountSubmittedTitle());     //ISPART-11425
        thankYouPage.verifySuccessText();                   //ISPART-11425
        thankYouPage.verifyTotalProductsCounted();          //ISPART-11425
        thankYouPage.verifyCountWord();                     //ISPART-11425
        thankYouPage.backToMainMenuButton();                //ISPART-823

    }

}
