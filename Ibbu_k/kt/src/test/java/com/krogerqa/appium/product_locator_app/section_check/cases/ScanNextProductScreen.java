package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScanNextProductScreen extends Base {
    private TaskListPage taskListPage;
    private ScanProductPage scanProductPage;
    private SectionCheckPage sectionCheckPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        taskListPage = new TaskListPage();
        sectionCheckPage=new SectionCheckPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        scanProductPage = new ScanProductPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }
    @Test(groups = {"Story","regression"})
    public void verifyNextButtonFunctionality() throws IOException {
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
        scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
    }

    @Test(groups = {"Story","regression"})
    public void verifyUnSubmittedWork_Cancel_ScanNextScreen() throws IOException {
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
        scanNextProductPage.clickOnBackArrow();
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_Cancel(sc_Data.getUnSubmittedTitle());
        scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
    }
    @Test(groups = {"Story","regression"})
    public void verifyUnSubmittedWork_SaveAndExit_ScanNextScreen() throws IOException {
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
        scanNextProductPage.clickOnBackArrow();
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_SaveAndExit();
        taskListPage.validateMainMenuPageTitle();
    }
}
