package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.MainMenuPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateManualMDCWiFiErrorHandling extends Base {

    private DepartmentPage departmentpage;
    private FindProductPage findProductPage;
    private ScanProductPage scanProductPage;
    private MDCCountProductPage MDCCountProductPage;
    private AddProductToCountPage addProductToCountPage;
    private SelectYourLocationPage selectYourLocationPage;
    private CommonPage commonPage;
    private TaskListPage taskListPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        departmentpage = new DepartmentPage();
        findProductPage = new FindProductPage();
        scanProductPage = new ScanProductPage();
        MDCCountProductPage = new MDCCountProductPage();
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
        commonPage = new CommonPage();
        taskListPage = new TaskListPage();

    }

    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnMainMenu() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        commonPage.backAndroidButton();
        commonPage.enableModes("WIFIDISABLE");
        taskListPage.clickMyDailyCount();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }

    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickMDCBegin() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        commonPage.enableModes("WIFIDISABLE");
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickGenerateCountButton();
        departmentpage.clickOnContinueOfReminderDialogue();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickBackArrowInFindProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        commonPage.enableModes("WIFIDISABLE");
        commonPage.clickBackArrow();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickAndroidBackButtonInFindProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        commonPage.enableModes("WIFIDISABLE");
        commonPage.backAndroidButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickSkipInFindProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        commonPage.enableModes("WIFIDISABLE");
        findProductPage.clickSkipButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickWrongLocationInFindProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        commonPage.enableModes("WIFIDISABLE");
        findProductPage.clickWrongLocationButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ISPART-18761"})
    void validateErrorMessageOnClickReviewButtonInFindProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.clickWrongLocationButton();
        commonPage.enableModes("WIFIDISABLE");
        findProductPage.clickMDCReviewButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }

    @Test(groups = {"ispart-11734"})
    void validateErrorMessageOnCountSubmit() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(findProductPage.getUPCOfProduct(), Symbology.UPC_A);
        MDCCountProductPage.clickOnEnterQuantityTextField();
        MDCCountProductPage.swipeAndEnterUnitCount();
        commonPage.enableModes("WIFIDISABLE");
        MDCCountProductPage.clickMDCNextButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }

    @Test(groups = {"ispart-11734"})
    void validateErrorMessageAfterCountSubmittedForSingleLocationFreeScanItemForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanItem().split("@")[3], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        MDCCountProductPage.clickOnEnterQuantityTextField();
        MDCCountProductPage.swipeAndEnterUnitCount();
        commonPage.enableModes("WIFIDISABLE");
        MDCCountProductPage.clickMDCNextButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }


    @Test(groups = {"ispart-11734"})
    void validateErrorMessageAfterCountSubmittedForMultiLocationFreeScanItemForFirstProduct() throws Throwable {

        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        String selectedDeptAndSize = departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        findProductPage.validatePrdCountSize(selectedDeptAndSize);
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanItem().split("@")[7], Symbology.UPC_A);
        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
        addProductToCountPage.clickAddProductButton();
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        selectYourLocationPage.selectRadioButton(mdc_Data.getSelectAisle());
        selectYourLocationPage.verifyEnabledSelectButton();
        selectYourLocationPage.clickSelectButton();
        MDCCountProductPage.clickOnEnterQuantityTextField();
        MDCCountProductPage.swipeAndEnterUnitCount();
        commonPage.enableModes("WIFIDISABLE");
        MDCCountProductPage.clickMDCNextButton();
        commonPage.verifyErrorMessageText();
        commonPage.enableModes("WIFIENABLE");

    }

}
