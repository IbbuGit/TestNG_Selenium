package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FindProductScreenValidationsAndScanningAllTypesOfProducts extends Base {

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
        selectYourLocationPage = new SelectYourLocationPage();
    }

    /*
     * Test Name:           MyDailyCount_findProductScreenValidations
     * Test Description:    All Find Product screen validations
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then validate all the elements from find product screen like Title,kebab Menu ,Product image, image enlargement, UPD,Product details,etc
     * Story id:
     * Epic id:
     * Test data:           any available department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *
     */
    @Test(groups = {"Regression"})
    void findProductScreenValidations() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.clickKebabMenu();
        commonPage.verifyMDCTutorial();
        commonPage.verifyAbout();
        commonPage.verifyMDCFaq();
        findProductPage.verifyProgressBar();
        findProductPage.verifyGotoText(mdc_Data.getGotoText());
        findProductPage.verifyFindAndScanText();
        findProductPage.verifyUPC();
        findProductPage.verifyProductDescription();
        findProductPage.verifyProductPrice();
        findProductPage.verifyImageIcon();
        findProductPage.openImage();
        findProductPage.enlargedImage();
        findProductPage.verifyCantFindButton();
    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCDSDErrorMessage
     * Test Description:    DSD product validation
     * Scenario tested:     User selects given department and redirect to Find product screen.
     *                      then scan the given upc
     *                      User should redirect to count product screen with DSD Product scanned message
     * Story id:
     * Epic id:
     * Test data:           Dairy department
     *                      UPC: 0004900002891
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen with DSD message
     *
     */
    @Test(groups = {"Regression"})
    void validateManualMDCDSDErrorMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getProductToScanDsd().split("@")[0], Symbology.UPC_A);
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateAlertMessage(mdc_Data.getDsdItem());
        mdcCountProductPage.clickOnNextButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCProductNotInSelectedDepartmentErrorMessage
     * Test Description:    Product not in selected department validation
     * Scenario tested:     User selects given department and redirect to Find product screen.
     *                      then scan the given upc
     *                      User should redirect to count product screen with Product not in selected department message
     * Story id:
     * Epic id:
     * Test data:           Dry Grocery department
     *                      UPC: 0001600026460
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen with Product not in selected department message
     *
     */
    @Test(groups = {"Regression"})
    void validateManualMDCProductNotInSelectedDepartmentErrorMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getProductToScanOtherDep().split("@")[0], Symbology.UPC_A);
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateAlertMessage(mdc_Data.getOtherDepartment());
        mdcCountProductPage.clickOnNextButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCUnauthorizedErrorMessage
     * Test Description:    Unauthorized Product validation
     * Scenario tested:     User selects given department and redirect to Find product screen.
     *                      then scan the given upc
     *                      User should redirect to count product screen with Unauthorized Product message
     * Story id:
     * Epic id:
     * Test data:           Dry Grocery department
     *                      UPC: 0000000004093
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen with  Unauthorized Product scanned message
     *
     */
    @Test(groups = {"Regression"})
    void validateManualMDCUnauthorizedErrorMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getProductToScanUnauthorized().split("@")[1], Symbology.UPC_A);
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateAlertMessage(mdc_Data.getUnauthorizedItem());
        mdcCountProductPage.clickOnNextButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateManualMDCBarcodeNotRecognizedErrorMessage
     * Test Description:    Barcode not Recognized product validation
     * Scenario tested:     User selects given department and redirect to Find product screen.
     *                      then scan the given upc
     *                      User should redirect to count product screen with Barcode not Recognized message
     * Story id:
     * Epic id:
     * Test data:           Dry Grocery department
     *                      UPC: 0030838322241
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen with  Barcode not Recognized message
     *
     */
    @Test(groups = {"Regression"})
    void validateManualMDCBarcodeNotRecognizedErrorMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getProductToScanBNR().split("@")[1], Symbology.UPC_A);
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateAlertMessage(mdc_Data.getBarcodeNotRecognized());
        mdcCountProductPage.clickOnNextButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

    /*
     * Test Name:           MyDailyCount_validateCountReceivedMessage
     * Test Description:    Count Received toast message validation
     * Scenario tested:     User selects any department and redirect to Find product screen.
     *                      then scan the any product
     *                      User should redirect to count product screen and enter quantity of that product and submit it
     *                      A count Received toast message will appear on Find product screen
     * Story id:
     * Epic id:
     * Test data:          Any department
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen(Title, Begin button)
     *                      2. Find Product screen (Title)
     *                      3. Count Product screen with
     *                      4. Count Received toast message on Find Product screen
     *
     */
    @Test(groups = {"Regression"})
    void validateCountReceivedMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
        commonPage.validateToastMessage(mdc_Data.getCountreceivedmessage());
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }

}
