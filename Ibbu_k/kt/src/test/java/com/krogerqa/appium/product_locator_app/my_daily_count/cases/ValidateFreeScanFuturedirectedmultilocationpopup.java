package com.krogerqa.appium.product_locator_app.my_daily_count.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateFreeScanFuturedirectedmultilocationpopup extends Base {
    LogInPage logInPage;
    TaskListPage taskListPage;
    DepartmentPage departmentpage;
    FindProductPage findProductPage;
    MDCReviewCountPage reviewPage;
    MDCCountProductPage mdcCountProductPage;
    ThankYouPage thankYouPage;
    CommonPage commonPage;
    LogOutPage logOutPage;
    ScanProductPage scanProductPage;
    MDCTutorialPage mdcTutorialPage;
    AddProductToCountPage addProductToCountPage;
    SelectYourLocationPage selectYourLocationPage;

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
        mdcTutorialPage = new MDCTutorialPage();
        addProductToCountPage = new AddProductToCountPage();
        selectYourLocationPage = new SelectYourLocationPage();
    }

    @Test(groups = {"ISPART-21134", "Regression"})
    void validateFreeScanFutureDirectedMultiLocationPopupCancelScanSameItem() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        for (int i = 0; i <= 3; i++) {
            scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
            selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
            selectYourLocationPage.clickCancelButton();
        }
    }

    @Test(groups = {"ISPART-21134", "Regression"})
    void validateFreeScanFutureDirectedMultiLocationPopupClickOnNoneOfTheAbove() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        int aisleDescriptionCountBefore = selectYourLocationPage.getAisleDescriptionCount();
        selectYourLocationPage.clickNoneOfTheAboveRadioButton();
        selectYourLocationPage.verifyEnabledSelectButton();
        selectYourLocationPage.clickSelectButton();
        mdcCountProductPage.clickOnNextButton();
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        int aisleDescriptionCountAfter = selectYourLocationPage.getAisleDescriptionCount();
        selectYourLocationPage.clickNoneOfTheAboveRadioButton();
        selectYourLocationPage.verifyEnabledSelectButton();
        selectYourLocationPage.clickSelectButton();
        commonPage.clickBackArrow();
        selectYourLocationPage.validateAisleDescriptionCounts(aisleDescriptionCountBefore, aisleDescriptionCountAfter);
    }


    @Test(groups = {"ISPART-21134", "Regression"})
    void validateFreeScanFutureDirectedMultiLocationPopupCountSubmitted() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        int j = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                j = 0;
            }
            scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
            selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
            selectYourLocationPage.selectRadioButton(j);
            selectYourLocationPage.verifyEnabledSelectButton();
            selectYourLocationPage.clickSelectButton();
            mdcCountProductPage.clickOnEnterQuantityTextField();
            mdcCountProductPage.swipeAndEnterUnitCount();
            mdcCountProductPage.clickMDCNextButton();
            mdcCountProductPage.verifySnackBarText();
            j = j + 1;
        }
    }


    @Test(groups = {"ISPART-21134", "Regression"})
    void validateFreeScanFutureDirectedMultiLocationPopupScannerDisabled() throws Throwable {
        departmentpage.validateDepartmentPageTitle(mdc_Data.getDepartmentTitle());
        departmentpage.selectDepartment(mdc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
        findProductPage.validateFindProductPageTitle(mdc_Data.getFindProductTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
        scanProductPage.scanProduct(mdc_Data.getFreeScanUPC().split("@")[1], Symbology.UPC_A);
        selectYourLocationPage.clickCancelButton();
    }
}
