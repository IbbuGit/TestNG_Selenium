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
import java.lang.reflect.Method;

public class AppendingCountForMultiLocation extends Base {
    private String multiProductScan[];
    private String getMultiProductUnitCount[];
    private SectionCheckPage sectionCheckPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyAppendingCountForMultiLocation() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        multiProductScan = sc_Data.getProductToScan().split(";");
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[0]);
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyMultiLocationProductMessage_EnterCount(sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
        scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyNextBtn();
    }
    @Test(groups = {"Story","regression"})
    public void verifySelect_NoneOfTheAbove_LocationPopup() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        multiProductScan = sc_Data.getProductToScan().split(";");
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[0]);
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
    }
    //Scan should not work when location popup displayed
    @Test(groups = {"Story","regression"})
    public void Scan_WhileLocationPopup() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        multiProductScan = sc_Data.getProductToScan().split(";");
        scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
        sectionCheckPage.verifySelectYourLocationHdr();
        scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        sectionCheckPage.verifyCancelBtn_ClickCancel();
    }
}
