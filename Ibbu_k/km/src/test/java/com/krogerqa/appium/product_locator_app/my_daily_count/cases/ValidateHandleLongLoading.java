package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.FindProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.MDCCountProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateHandleLongLoading extends Base {
    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private ScanProductPage scanProductPage;
    private MDCCountProductPage mdcCountProductPage;
    CommonPage commonPage = new CommonPage();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        mdcCountProductPage = new MDCCountProductPage();

    }

    @Test(groups = {"Regression", "ispart-818"})
    void validateManualMDCLongLoadingBackArrow() throws Throwable {
        commonPage.visibleLoadDeptList();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.clickBackArrow();
        commonPage.visibleLoadDeptList();
    }


    @Test(groups = {"Regression", "ispart-818"})
    void validateManualMDCLongLoadingBackAndroidButton() throws Throwable {
        commonPage.visibleLoadDeptList();
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        commonPage.backAndroidButton();
        commonPage.visibleLoadDeptList();
    }
}
