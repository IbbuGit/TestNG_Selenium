package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.FindProductMap;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.ReviewCountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateManualMDCReviewScreenLoadTesting extends Base {


    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    ScanProductPage scanProductPage;
    MDCCountProductPage mdcCountProductPage;
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;
    MDCReviewCountPage mdcReviewCountPage;
    FindProductMap findProductMap;


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


    @Test(groups = {"ispart-19567", "loadTesting"})
    void validateManualMDCReviewScreenLoadTesting() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        findProductPage.scanAndSkipWrongLocAllProducts(mdc_Data);
        findProductPage.clickReviewButton();
        mdcReviewCountPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
        mdcReviewCountPage.clickSubmitOrContinue(Consts.lblContinueBtn);

    }

}
