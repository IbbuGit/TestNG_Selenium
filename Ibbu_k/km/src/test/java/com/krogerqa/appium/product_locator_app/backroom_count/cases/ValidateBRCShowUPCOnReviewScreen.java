package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateBRCShowUPCOnReviewScreen extends Base {



    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ThankyouBRCPage thankyouBRCPage;
    private ScanProductPage scanProductPage;
    private String[] multiUPCs;
    private DepartmentPage departmentpage;
    private CommonPage commonPage;
    MDCReviewCountPage mdcReviewCountPage = new MDCReviewCountPage();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws Throwable {
        scanproductBRCPage=new ScanproductBRCPage();
        countProductPage=new CountProductPage();
        reviewCountPage=new ReviewCountPage();
        thankyouBRCPage=new ThankyouBRCPage();
        scanProductPage=new ScanProductPage();
        departmentpage=new DepartmentPage();
        commonPage = new CommonPage ();

    }


    @Test(groups = {"satart-798","Regression"})
    void validateManualBRCUPConReviewPage() throws Throwable {
        String addUpcs="";
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split ( "@" );
        for(String UPC:multiUPCs) {
            addUpcs+=UPC+"@";
            scanProductPage.scanProduct ( UPC, Symbology.UPC_A );
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        reviewCountPage.validateReviewProductTitle(bc_Data.getReviewProductScreen());
        commonPage.validateUPC(addUpcs,"BRC");
    }
}
