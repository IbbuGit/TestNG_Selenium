package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.FindProductMap;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateMDCShowUPCOnReviewScreen extends Base {


    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    ScanProductPage scanProductPage;
    MDCCountProductPage mdcCountProductPage;
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;
    MDCReviewCountPage mdcReviewCountPage;
    FindProductMap findProductMap;
    ThankYouPage thankYouPage=new ThankYouPage();
    CommonPage commonPage = new CommonPage();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        mdcCountProductPage = new MDCCountProductPage();
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
        mdcReviewCountPage = new MDCReviewCountPage();
        findProductMap = new FindProductMap();

    }


    @Test(groups = {"ispart-20318", "Regression"})
    void validateManualMDCUPConReviewPage() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        String usedUPC = findProductPage.getScannedUPC(mdc_Data);
        findProductPage.clickReviewButton();
        mdcReviewCountPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        commonPage.validateUPC(usedUPC,"MDC");
    }
}
