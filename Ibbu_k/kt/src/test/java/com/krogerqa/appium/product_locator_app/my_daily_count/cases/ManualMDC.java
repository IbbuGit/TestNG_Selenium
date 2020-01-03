package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ManualMDC extends Base {
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
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;

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
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
    }

    /*
     * Test Name:           MyDailyCount_validateCancelButtonOfManualMDCPopUp
     * Test Description:    Validate free scan pop up and then click on cancel button
     * Scenario tested:     User selects Given department and redirect to Find product screen.
     *                      then scan the Given upc
     *                      A free scan pop up should appear on screen
     *                     Click on cancel button then pop up should get close and user will stay on same screen
     * Story id:
     * Epic id:
     * Test data:          Drug/GM department
     *                     UPC: 0002200000838
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen
     *                      4. Free scan pop up
     *
     */
    @Test(groups = {"Regression"})
    void validateCancelButtonOfManualMDCPopUp() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        addProductToCountPage.clickCancelButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateAddButtonOfManualMDCPopUpAndCancel
     * Test Description:    Validate free scan pop up  then select location and cancel
     * Scenario tested:     User selects Given department and redirect to Find product screen.
     *                      then scan the Given upc
     *                      A free scan pop up should appear on screen
     *                      Click on submit button then pop up
     *                      Location pop up will appear on screen and click on cancel on that pop up
     *                      User should remain on find product screen
     *
     * Story id:
     * Epic id:
     * Test data:          Drug/GM department
     *                     UPC: 0002200000838
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen
     *                      4. Free scan pop up
     *                      5. Location pop up
     *
     *
     */
    @Test(groups = {"Regression"})
    void validateAddButtonOfManualMDCPopUpAndCancel() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        addProductToCountPage.clickAddProductButton();
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        selectYourLocationPage.clickCancelButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateAddButtonOfManualMDCPopUpAndSubmit
     * Test Description:    Validate free scan pop up  then select location and submit
     * Scenario tested:     User selects Given department and redirect to Find product screen.
     *                      then scan the Given upc
     *                      A free scan pop up should appear on screen
     *                      Click on submit button then pop up
     *                      Location pop up will appear on screen and select location the submit that product
     *                      User should redirect to count product screen
     *                      Enter quantity and submit it
     * Story id:
     * Epic id:
     * Test data:          Bakery department
     *                     UPC: 0001111045661
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen
     *                      4. Free scan pop up
     *                      5. Location pop up
     *                      6. Count product screen
     *
     */
    @Test(groups = {"Regression"})
    void validateAddButtonOfManualMDCPopUpAndSubmit() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        addProductToCountPage.clickAddProductButton();
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        selectYourLocationPage.selectRadioButton(mdc_Data.getSelectLocation());
        selectYourLocationPage.clickSelectButton();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
    }
}
