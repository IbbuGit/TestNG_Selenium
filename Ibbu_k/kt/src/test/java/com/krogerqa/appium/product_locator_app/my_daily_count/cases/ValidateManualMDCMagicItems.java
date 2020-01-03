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

public class ValidateManualMDCMagicItems extends Base {
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

    @Test(groups = {"regression", "ispart-15828", "ispart-19798"})
    void validateManualMDCMagicItemsErrorMessage() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
        mdcCountProductPage.validateAlertMessage(mdc_Data.getMagicItemsInfoMessage());
        mdcCountProductPage.clickOnProductImageIcon();
        mdcCountProductPage.validateEnlargeImage();
        mdcCountProductPage.closeImage();
        mdcCountProductPage.clickOnNextButton();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
    }
}
