package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.FindProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.MDCCountProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateManualMDCErrorHandlingMDCItem extends Base {
    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private ScanProductPage scanProductPage;
    private MDCCountProductPage mdcCountProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        mdcCountProductPage = new MDCCountProductPage();
    }

    @Test(groups = {"ispart-18557"})
    void ValidateErrorHandlingForMDCItem() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment("Any department");
        departmentpage.clickOnContinueOfReminderDialogue();
        mdcCountProductPage.validateWrngAltTitle(mdc_Data.getSomethingWentWrongAlertTitle());
        mdcCountProductPage.clickTryAgainButton();
        mdcCountProductPage.validateProceedAltTitle(mdc_Data.getUnableToProceedAlertTitle());
        mdcCountProductPage.clickExitTaskButton();

    }

}
