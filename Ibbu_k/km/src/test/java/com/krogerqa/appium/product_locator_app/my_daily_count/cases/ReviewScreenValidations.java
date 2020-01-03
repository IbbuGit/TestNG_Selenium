package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ReviewScreenValidations extends Base {
    private TaskListPage taskListPage;
    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private MDCReviewCountPage reviewPage;
    private MDCCountProductPage mdcCountProductPage;
    private ThankYouPage thankYouPage;
    private CommonPage commonPage;
    private LogInPage logInPage;
    private LogOutPage logOutPage;
    private ScanProductPage scanProductPage;
    private AddProductToCountPage addProductToCountPage;
    private SelectYourLocationPage selectYourLocationPage;

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
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
    }

    /*
     * Test Name:           MyDailyCount_reviewScreenAfterScanningAllProducts
     * Test Description:    Validate Review Screen after scanning all products
     * Scenario tested:     User selects any department and scan or skip all products
     *                      then validate Review Count screen and functionality of Submit button
     *                      and validate Count Submitted screen
     * Story id:
     * Epic id:
     * Test data:           any available dependent
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Scan ,skip on Find Product screen
     *                      3. After scanning, skipping of all products, redirect to review screen
     *                      4. submit button validation after doing complete count of that department on review screen
     *                      5. Click on submit of review screen and redirect to thank you screen
     */
    @Test(groups = {"Regression"})

    public void reviewScreenAfterScanningAllProducts() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanAndSkipAllProducts(mdc_Data);
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        reviewPage.clickReviewCountSubmitButton();
        thankYouPage.validateCountSubmittedPageTitle(mdc_Data.getCountSubmittedTitle());
    }

    /*
     * Test Name:           MyDailyCount_reviewButtonVisibilityAfterScanningOneProduct
     * Test Description:    Review Button visibility after scanning single product
     * Scenario tested:     User selects any department and scan single product
     *                      then verify Review Button on Find Product screen
     * Story id:
     * Epic id:
     * Test data:           any available dependent
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Scan on Find Product screen
     *                      3. Enter product quantity and screen title validation on Count Product screen
     *                      4. After scanning of single product redirect to Find Product screen
     *                      5.Verify Review Button on Find Product screen
     */
    @Test(groups = {"Regression", "ispart-18718"})

    public void reviewButtonVisibilityAfterScanningOneProduct() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.verifyReviewButtonNotDisplayed();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.verifyReviewButton();
        findProductPage.verifySkipButton();
    }

    /*
     * Test Name:           MyDailyCount_reviewButtonVisibilityAfterSkippingOneProduct
     * Test Description:    Review Button visibility after skipping single product
     * Scenario tested:     User selects any department and skip single product
     *                      then verify visibility of Review Button on Find Product screen
     * Story id:
     * Epic id:
     * Test data:           any available dependent
     * API tested:
     *
     * UI screen tested:
     *                      1. Department Screen
     *                      2. Scan on Find Product screen
     *                      3. Enter product quantity and screen title validation on Count Product screen
     *                      4. After skipping of single product redirect to Find Product screen
     *                      5.Verify Review Button on Find Product screen
     */
    @Test(groups = {"Regression", "ispart-18718"})

    public void reviewButtonVisibilityAfterSkippingOneProduct() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.verifyReviewButtonNotDisplayed();
        findProductPage.clickOnSkipButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.verifyReviewButton();
        findProductPage.verifySkipButton();
    }

    @Test(groups = {"Regression", "ispart-18718"})
    public void validateContinueButtonOfReviewScreen() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.verifyReviewButtonNotDisplayed();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        reviewPage.clickContinueButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.verifyReviewButton();
    }

    @Test(groups = {"Regression", "ispart-18718"})
    public void reviewButtonVisibilityAfterScanningOneProductAndLoggedout() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.verifyReviewButtonNotDisplayed();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.clickKebabMenu();
        logOutPage.loggedOut(false);
        logInPage.login(login_Data.getUsername(), login_Data.getPassword());
        taskListPage.clickMyDailyCount();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.verifyReviewButton();
        findProductPage.verifySkipButton();
    }

    @Test(groups = {"Regression", "ispart-18718"})
    public void reviewButtonVisibilityAfterSkippingOneProductAndLoggedout() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.verifyReviewButtonNotDisplayed();
        findProductPage.clickOnSkipButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.clickKebabMenu();
        logOutPage.loggedOut(false);
        logInPage.login(login_Data.getUsername(), login_Data.getPassword());
        taskListPage.clickMyDailyCount();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.verifyReviewButton();
        findProductPage.verifySkipButton();
    }


    @Test(groups = {"Regression"})
    public void validateThresholdValueOnUpdateInReviewScreen() throws Throwable {
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
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        reviewPage.clickOnProductCardImage();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.enterThresholdValue();
        mdcCountProductPage.verifyThresholdValueError(mdc_Data.getThresholdErrorMessage());
    }


    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCContinueButtonAfterClickingSkip() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickOnSkipButton();
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewCountTitle());
        reviewPage.validateDispalySubmitButton();
        reviewPage.verifyContinueButton(Consts.lblContinueBtn);
    }


    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCContinueBtnAfterClickingWrongLocation() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickWrongLocationButton();
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewCountTitle());
        reviewPage.validateDispalySubmitButton();
        reviewPage.verifyContinueButton(Consts.lblContinueBtn);
    }

    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCContinueBtnAfterClickingSkipAndWrongLocation() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickOnSkipButton();
        findProductPage.clickWrongLocationButton();
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewCountTitle());
        reviewPage.validateDispalySubmitButton();
        reviewPage.verifyContinueButton(Consts.lblContinueBtn);
    }


    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCContinueBtnAfterScanningItem() throws Throwable {
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
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickReviewButton();
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewCountTitle());
        reviewPage.validateDispalySubmitButton();
        reviewPage.verifyContinueButton(Consts.lblContinueBtn);

    }

    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCSubmitBtnAfterScanningAllItem() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        findProductPage.scanAndSkipAllProducts(mdc_Data);
        reviewPage.validateReviewCountPageTitle(mdc_Data.getReviewCountTitle());
        reviewPage.validateDisplayContinueButton();
        reviewPage.verifySubmitButton(Consts.lblSubmitButton);
        reviewPage.clickReviewCountSubmitButton();
        thankYouPage.validateCountSubmittedPageTitle(mdc_Data.getCountSubmittedTitle());


    }


    @Test(groups = {"Regression", "ispart-18553"})
    public void validateManualMDCContinueButtonAfterSingleLocationFreeScanItem() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();


    }

    @Test(groups = {"Regression", "ispart-18553"})
    void validateContinueButtonAfterMultiLocationFreeScanForOneProduct() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.getProductCountStatus();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        selectYourLocationPage.selectRadioButton(mdc_Data.getSelectLocation());
        selectYourLocationPage.clickSelectButton();
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.enterQuantity();
        mdcCountProductPage.clickOnSubmitCountButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.clickReviewButton();
        reviewPage.verifyContinueButton(Consts.lblContinueBtn);

    }

}