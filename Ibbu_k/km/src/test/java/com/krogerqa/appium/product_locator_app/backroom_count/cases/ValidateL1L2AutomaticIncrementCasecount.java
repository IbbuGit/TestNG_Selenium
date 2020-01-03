package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.UnSubmittedCountMap;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ScanproductBRCPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.UnSubmittedCountPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;


public class ValidateL1L2AutomaticIncrementCasecount extends Base {
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    UnSubmittedCountMap unSubmittedCountMap = new UnSubmittedCountMap();
    private String[] multiUPCs;
    ReviewCountPage reviewCountPage = new ReviewCountPage();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
    }


    @Test (groups = {"regression","satart-784"})
    public void verifyL1L2AutomaticIncrementCaseCount() throws Exception {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanproductBRCPage.waitForEnterUPCButton();
            scanProductPage.scanProduct(bc_Data.getProductToScan(), Symbology.UPC_A);
        }
        else {
            scanproductBRCPage.waitForEnterUPCButton();
            scanproductBRCPage.clickEnterUPC();
            scanproductBRCPage.enterUPC(bc_Data.getProductToScan());
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
        countProductPage.validateAutoIncCaseCount();
        String unitCount=  countProductPage.getProdTotalUnitsCount();
        countProductPage.clickReview();
        countProductPage.verifyProductCountsExists(unitCount);
    }


    @Test(groups = {"regression", "satart-784"})
    public void verifyL1L2AutomaticIncrementCaseCounts() throws Exception {

        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        multiUPCs = bc_Data.getProductToScan().split("@");
        scanproductBRCPage.waitForEnterUPCButton();
        for (String upc : multiUPCs) {
            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanProductPage.scanProduct(upc, Symbology.UPC_A);

            } else {
                scanproductBRCPage.clickEnterUPC();
                scanproductBRCPage.enterUPC(upc);
                scanproductBRCPage.clickSubmit();
            }
            countProductPage.validateCountProductTitle(bc_Data.getCountProductScreen());
            countProductPage.validateAutoIncCaseCount();
            String unitCount=  countProductPage.getProdTotalUnitsCount();
            countProductPage.clickReview();
            countProductPage.verifyProductCountsExists(unitCount);
            scanproductBRCPage.waitForReEnterUPC();
        }
    }
}
