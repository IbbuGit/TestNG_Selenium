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

public class AppendingCountForSingleLocation extends Base {
    private String multiProductScan[];
    private SectionCheckPage sectionCheckPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        scanProductPage = new ScanProductPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyAppendingCountForSingleLocation() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        multiProductScan = sc_Data.getProductToScan().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[0]);
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(sc_Data.getUnitsCount());
        scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyNextBtn();
    }

}
