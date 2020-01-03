package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.FindProductPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.MDCCountProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateMDCErrorHandlingForDeptList extends Base {

    private MDCCountProductPage mdcCountProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        mdcCountProductPage = new MDCCountProductPage();

    }

    @Test(groups = {"ispart-16721"})
    void ValidateErrorHandlingForMDCDeptList() throws Throwable {

        mdcCountProductPage.validateWrngAltTitle(mdc_Data.getSomethingWentWrongAlertTitle());
        mdcCountProductPage.clickTryAgainButton();
        mdcCountProductPage.validateProceedAltTitle(mdc_Data.getUnableToProceedAlertTitle());
        mdcCountProductPage.clickExitTaskButton();

    }


}
