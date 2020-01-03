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

public class RemoveProduct extends Base {
    private String[] multiProductScan;
    private String[] getMultiProductUnitCount;
    private ManualEnterUPCPage manualEnterUPCPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private SectionCheckPage sectionCheckPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        sectionCheckPage = new SectionCheckPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyRemoveProduct_ReviewCount() throws IOException {
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
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnDeleteIcon(sc_Data.getRemoveProductTitle());
        reviewCountPage.verifySubmitBtn_Disabled();
    }

    @Test(groups = {"Story","regression"})
    public void verifyRemove_MultiLocation() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyCountProductScreen(sc_Data.getUnitsCount());

        scanNextProductPage.clickOnReviewBtn();
        //To verify Multi location banner message
        reviewCountPage.verifyMultiProductLocationMessage(sc_Data.getMultiLocationBannerMsg());
        // To click on Delete icon
        reviewCountPage.clickOnDeleteIcon(sc_Data.getRemoveProductTitle());
        //To verify after removal of the product
        reviewCountPage.verifySubmitBtn_Disabled();
    }
}
