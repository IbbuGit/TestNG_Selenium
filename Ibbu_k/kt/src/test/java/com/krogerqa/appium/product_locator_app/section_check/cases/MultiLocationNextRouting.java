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

public class MultiLocationNextRouting extends Base {
    private String[] getMultiProductUnitCount;
    SectionCheckPage sectionCheckPage;
    ScanProductPage scanProductPage;
    ManualEnterUPCPage manualEnterUPCPage;
    CountProductPage countProductPage;
    ScanNextProductPage scanNextProductPage;
    ReviewCountPage reviewCountPage;
    ThankYouPage thankYouPage;
    UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    CantFindSkipPage cantFindSkipPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        thankYouPage = new ThankYouPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        cantFindSkipPage = new CantFindSkipPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyNextAction_MultiLocationRouting() throws IOException, InterruptedException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyMultiLocationProductMessage_EnterCount( sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifyMultiLocationBannerMsg_ClickOnContinue(sc_Data.getMultiLocationBannerMsg());
        //To click on Continue button on review screen and remaining popup
        reviewCountPage.clickContinueBtn_RemainingLocationPopup(sc_Data.getCountRemainingLocationHdrMsg());
        //Scan the next location
        scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        //Enter the count and click on Next button
        countProductPage.verifyMultiLocationProductMessage_EnterCount( sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
        cantFindSkipPage.verifyCantFindButton();
        scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        //cantFindSkipPage.clickOnFindAndScan();
        countProductPage.verifyMultiLocationProductMessage_EnterCount( sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[2]);
        //To verify the submit button in review count and click on review Submit
        reviewCountPage.verifySubmitBtn();
        thankYouPage.verifyCountSubmittedTitle(sc_Data.getThankYouScreen());
    }
}

