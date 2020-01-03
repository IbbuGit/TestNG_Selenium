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

public class SkippedItemsRecount extends Base {
    private ScanProductPage scanProductPage;
    private SectionCheckPage sectionCheckPage;
    private String[] getMultiProductUnitCount;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private CantFindSkipPage cantFindSkipPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        cantFindSkipPage = new CantFindSkipPage();
    }

    @Test(groups = {"Story","regression"})
    public void skipAndRecount_ReviewPage() throws IOException {
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
        sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());
        countProductPage.verifyMultiLocationProductMessage_EnterCount(sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
        scanNextProductPage.clickOnReviewBtn();
        //To verify Multi location Banner Message
        reviewCountPage.verifyMultiLocationBannerMsg_ClickOnContinue(sc_Data.getMultiLocationBannerMsg());
        //To click on Continue button review screen and remaining count popup
        reviewCountPage.clickContinueBtn_RemainingLocationPopup(sc_Data.getCountRemainingLocationHdrMsg());
        //Clicking on Cant Find Skip button
        cantFindSkipPage.clickOnCantFindSkipBtn();
        cantFindSkipPage.clickOnCantFindSkipBtn();
        //To click on skipped item for recount
        reviewCountPage.verifySkippedProducts_AndClick(sc_Data.getSkippedMsg());
        //To enter the count
        countProductPage.verifyMultiLocationProductMessage_EnterCount(sc_Data.getMultiLocationMessage_CountProduct());
        countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
        /*countProductPage.verifyCountProductScreen(UnitsCont1[0]);*/
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifySubmitBtn();
    }

}
