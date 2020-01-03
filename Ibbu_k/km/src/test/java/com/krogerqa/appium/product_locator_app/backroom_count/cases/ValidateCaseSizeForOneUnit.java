package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.UnSubmittedCountPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateCaseSizeForOneUnit extends Base {
    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    private CountProductPage countProductPage;
    private ReviewCountPage reviewCountPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
    }

    @Test(groups = {"regression", "ispart-18143"})
    public void validateCaseSizeIsOneUnitCasesStepperShouldNotBeDisplayed() throws Exception {
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        scanProductPage.scanProduct(bc_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
        countProductPage.validateCaseSizeIsOne();
        countProductPage.clickReview();
        reviewCountPage.clickEditCard();
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
        countProductPage.validateCaseSizeIsOne();
    }
}