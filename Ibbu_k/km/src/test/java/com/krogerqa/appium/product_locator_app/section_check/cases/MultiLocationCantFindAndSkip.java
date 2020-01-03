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

public class MultiLocationCantFindAndSkip extends Base {
    private ScanProductPage scanProductPage;
    private SectionCheckPage sectionCheckPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private CantFindSkipPage cantFindSkipPage;
    private ManualEnterUPCPage manualEnterUPCPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        cantFindSkipPage = new CantFindSkipPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyCantFindSkipFunctionality() throws IOException {
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
        countProductPage.verifyMultiLocationProductMessage_EnterCount(sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(sc_Data.getUnitsCount());
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifyMultiLocationBannerMsg_ClickOnContinue(sc_Data.getMultiLocationBannerMsg());
        reviewCountPage.clickContinueBtn_RemainingLocationPopup(sc_Data.getCountRemainingLocationHdrMsg());
        //Clicking on Cant Find Skip button
        cantFindSkipPage.clickOnCantFindSkipBtn();
        cantFindSkipPage.clickOnCantFindSkipBtn();
        //To verify submit button in review count screen
        reviewCountPage.verifySubmitBtn();
    }
}
