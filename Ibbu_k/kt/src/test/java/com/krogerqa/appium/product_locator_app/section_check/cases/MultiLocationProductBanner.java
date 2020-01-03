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

public class MultiLocationProductBanner extends Base {
    private String[] multiProductScan;
    private String[] getMultiProductUnitCount;
    private SectionCheckPage sectionCheckPage;
    private ScanProductPage scanProductPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyContinueButtonTurnsIntoSubmit_WarningBannerRemoved() throws IOException {
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
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
        scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickingOnAddMoreBtn();
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyMultiLocationProductMessage_EnterCount( sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
        scanNextProductPage.clickOnReviewBtn();
        //verifying the multi location banner message
        reviewCountPage.verifyMultiProductLocationMessage(sc_Data.getMultiLocationBannerMsg());
        //Clicking on delete icon for multi location product
        reviewCountPage.clickOnDeleteIcon(sc_Data.getRemoveProductTitle());
        //verifying the Continue turns in to submit when multi location product deletes
        reviewCountPage.verifySubmitBtn();
    }
}
