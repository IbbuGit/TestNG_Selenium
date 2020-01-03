package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.FindProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.MDCCountProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.ThankYouPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class validateFAQ extends Base {
    LogInPage logInPage;
    TaskListPage taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    MDCCountProductPage mdcCountProductPage;
    ThankYouPage thankYouPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    ScanProductPage scanProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        logInPage = new LogInPage();
        taskListPage = new TaskListPage();
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        mdcCountProductPage = new MDCCountProductPage();
        thankYouPage = new ThankYouPage();
        commonPage = new CommonPage();
        logOutPage = new LogOutPage();
        scanProductPage = new ScanProductPage();
    }

    @Test(groups = {"Sanity"})
    public void validateFAQ() {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        commonPage.clickKebabMenu();
        commonPage.verifyMDCFaq();

    }
}