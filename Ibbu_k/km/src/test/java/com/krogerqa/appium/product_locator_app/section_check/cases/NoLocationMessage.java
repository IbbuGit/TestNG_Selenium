package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class NoLocationMessage extends Base {
    private ScanProductPage scanProductPage;
    private SectionCheckPage sectionCheckPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    //private EnterUPCPopUpPage enterUPCPopUpPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        //enterUPCPopUpPage = new EnterUPCPopUpPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyNoLocationMessage() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(sc_Data.getUnitsCount());
        scanNextProductPage.clickOnReviewBtn();
        //To verify review Count Page No Location Header
        reviewCountPage.verifyNoLocationHdr();
    }
}