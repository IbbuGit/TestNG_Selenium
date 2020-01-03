package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MDCE2ETestSuite extends Base {
    LogInPage logInPage;
    TaskListPage taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    ThankYouPage thankYouPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    TutorialPage tutorialPage;
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;
    MDCCountProductPage mdcCountProductPage;
    CountProductPage countProductPage;
    ReviewCountPage reviewCountPage;
    MDCReviewCountPage mdcReviewCountPage;
    ThankyouBRCPage thankyouBRCPage;
    ScanproductBRCPage scanproductBRCPage;
    ScanProductPage scanProductPage;
    HttpClientExecutor apiExecutor;
    ApiRequestDataHelper dataHelper;
    String body = null;


    @BeforeMethod(alwaysRun = true)
    public void initPages() throws Throwable {
        logInPage = new LogInPage();
        taskListPage = new TaskListPage();
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        mdcReviewCountPage = new MDCReviewCountPage();
        thankYouPage = new ThankYouPage();
        commonPage = new CommonPage();
        logOutPage = new LogOutPage();
        scanProductPage = new ScanProductPage();
        tutorialPage = new TutorialPage();
        addProductToCountPage = new AddProductToCountPage();
        mdcCountProductPage = new MDCCountProductPage();
        reviewCountPage = new ReviewCountPage();
        countProductPage = new CountProductPage();
        thankyouBRCPage = new ThankyouBRCPage();
        scanproductBRCPage = new ScanproductBRCPage();
        selectYourLocationPage = new SelectYourLocationPage();
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
    }

    @Test(groups = {"e2e"})
    void countMdcProducts() throws Throwable {
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.getProductCountStatus();
        String freeScanUpcsToScan[] = mdc_Data.getFreeScanUPC().split(";");
        findProductPage.scanAndSkipAllProducts(mdc_Data, freeScanUpcsToScan, apiExecutor, dataHelper, prop);
        mdcReviewCountPage.clickReviewCountSubmitButton();
    }

    @Test(groups = {"e2e"})
    void departmentLockedStatus() throws Throwable {
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.scanSingleProduct();
        mdcCountProductPage.enterQuantity(mdc_Data.getUserQuantity());
        mdcCountProductPage.clickOnNextButton();
        logOutApp();
        logInPage.login(mdc_Data.getUser2Name(), mdc_Data.getUser2Password());
        taskListPage.clickMyDailyCount();
        departmentpage.dairyDepartmentInProgressStatus();
    }

    @Test(groups = {"e2e"})
    void backroomToMdc() throws Throwable {
        int noOfProductsBeforeBackroom = departmentpage.getCountOfProducts();
        departmentpage.navigateBack();
        taskListPage.clickBackroomCount();
        scanproductBRCPage.clickEnterUPC();
        scanproductBRCPage.enterUPC(mdc_Data.getDeliUpc());
        scanproductBRCPage.clickSubmit();
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.clickBackMenu();
        taskListPage.clickMyDailyCount();
        int noOfProductsAfterBackroom = departmentpage.isCountIncreased(noOfProductsBeforeBackroom);
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.getProductCountStatus();
        findProductPage.validateBackRoomUpc(mdc_Data, noOfProductsAfterBackroom);
    }

    @Test(groups = {"e2e"})
    void manualMdcScan() throws Throwable {
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        String freeScanUpcsToScan[] = mdc_Data.getFreeScanUPC().split(";");
        findProductPage.manualScan(mdc_Data, freeScanUpcsToScan, apiExecutor, dataHelper, prop);
        findProductPage.getProductCountStatus();
        findProductPage.scanAndSkipAllProducts(mdc_Data, freeScanUpcsToScan, apiExecutor, dataHelper, prop);
        mdcReviewCountPage.clickReviewCountSubmitButton();
    }

    @Test(groups = {"e2e"})
    void multiLocationFreeScan() throws Throwable {
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        String freeScanUpcsToScan[] = mdc_Data.getFreeScanUPC().split(";");
        findProductPage.manualScan(mdc_Data, freeScanUpcsToScan, apiExecutor, dataHelper, prop);
        findProductPage.getProductCountStatus();
        findProductPage.scanAndSkipAllProducts(mdc_Data, freeScanUpcsToScan, apiExecutor, dataHelper, prop);
        mdcReviewCountPage.clickReviewCountSubmitButton();
    }

}
