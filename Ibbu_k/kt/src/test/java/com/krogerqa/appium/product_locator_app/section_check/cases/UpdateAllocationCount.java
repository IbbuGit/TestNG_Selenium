package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateAllocationCount extends Base {
    private String getMultiProductUnitCount[];
    private String getAllocationCount[];
    private String getUpdatedAllocationUnitCount[];
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private SectionCheckPage sectionCheckPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        sectionCheckPage=new SectionCheckPage();
        countProductPage = new CountProductPage();
        unSubmittedWorkPopUpPage=new UnSubmittedWorkPopUpPage();
    }
    @Test(groups = {"Story","regression"})
    public void verifyUpdateCountAllocation_Cancel() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.clickOnCancelBtn_UpdateAllocation();
    }

    @Test(groups = {"Story","regression"})
    public void verifyClickingCrossIcon_CountProduct() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.clickOnCrossBar();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
    }
    @Test(groups = {"Story","regression"})
    public void verifyResetAllocationCount() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        getAllocationCount=sc_Data.getShelfAllocationProdCount().split(";");
        getUpdatedAllocationUnitCount=sc_Data.getUpdatedAllocationCount().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.clickOnShelfAllocationEditIcon();
        countProductPage.clickOnUpdateShelfAllocation(getAllocationCount[0]);
        countProductPage.clickUpdateBtn();
        countProductPage.verifyUpdatedUnitCount(getUpdatedAllocationUnitCount[0]);

        countProductPage.verifyCountProductsPageTitle(sc_Data.getCountProductScreen());
        countProductPage.clickOnShelfAllocationEditIcon();
        countProductPage.clickOnUpdateShelfAllocation(getAllocationCount[1]);
        countProductPage.clickUpdateBtn();
        countProductPage.verifyUpdatedUnitCount(getUpdatedAllocationUnitCount[1]);
    }
    @Test(groups = {"Story","regression"})
    public void verifyResetUnitCount() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyNextBtnToBeDisabled();
        countProductPage.clickOnUpdateUnitCountTextField(getMultiProductUnitCount[0]);
        countProductPage.verifyNextBtn();
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
    }
}
