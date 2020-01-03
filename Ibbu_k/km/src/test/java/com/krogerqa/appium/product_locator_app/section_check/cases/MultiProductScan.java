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

public class MultiProductScan extends Base {
    private String[] multiProductScan;
    private String[] getMultiProductUnitCount;
    private ManualEnterUPCPage manualEnterUPCPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private ThankYouPage thankYouPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private SectionCheckPage sectionCheckPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        thankYouPage = new ThankYouPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        sectionCheckPage = new SectionCheckPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyMultiProductScan_SingleLocation_AddMore() throws IOException {
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
        reviewCountPage.verifySubmitBtn();
        reviewCountPage.clickingOnAddMoreBtn();
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.verifyCountSubmittedTitle(sc_Data.getCountSubmittedHdr());
    }

    @Test(groups = {"Story","regression"})
    public void verifyMultiProductScan_SingleLocation_EnterUPC() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        multiProductScan = sc_Data.getProductToScan().split(";");
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            //To Scan single location product
            scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[0]);
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
        } else {
            scanNextProductPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.verifyCountSubmittedTitle(sc_Data.getCountSubmittedHdr());
    }

    @Test(groups = "Story")
    public void verifyMultiProductScan_200() throws IOException, InterruptedException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        multiProductScan = sc_Data.getProductToScan().split(";");
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        for (int i = 0; i < multiProductScan.length; i++) {
            if (i == 0) {
                sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
            } else {
                scanNextProductPage.verifyPageTitle(sc_Data.getScanNextProductScreen());
            }
            scanProductPage.scanProduct(multiProductScan[i], Symbology.UPC_A);
            countProductPage.verifyCountProductScreen(getMultiProductUnitCount[i]);
        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.verifySectionCheckCompletedMsg(sc_Data.getThankYouScreen());
    }
}
