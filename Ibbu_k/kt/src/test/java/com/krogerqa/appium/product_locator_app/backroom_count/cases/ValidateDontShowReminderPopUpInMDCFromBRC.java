package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.DepartmentPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateDontShowReminderPopUpInMDCFromBRC extends Base {
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private ScanProductPage scanProductPage;
    private String[] multiUPCs;
    private DepartmentPage departmentpage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        thankyouBRCPage = new ThankyouBRCPage();
        scanProductPage = new ScanProductPage();
        departmentpage = new DepartmentPage();
    }

    @Test(groups = {"ispart-20271", "regression"})
    void validateDontShowReminderPopUp() throws Throwable {
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        for (String UPC : multiUPCs) {
            scanProductPage.scanProduct(UPC, Symbology.UPC_A);
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateThankyouTitle(bc_Data.getTitleThankYouScreen());
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.verifyBeginMyDailyCountIsEnabled();
        thankyouBRCPage.clickBeginMyDailyCount();
        thankyouBRCPage.validateSpinner();
        departmentpage.validateDepartmentPageTitle(Consts.lblDepartmentTitle);
        departmentpage.selectDepartment(bc_Data.getDepartmentName());
        departmentpage.clickOnContinueOfReminderDialogue();
    }

}