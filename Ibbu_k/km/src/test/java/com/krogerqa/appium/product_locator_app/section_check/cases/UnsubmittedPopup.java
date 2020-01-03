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

public class UnsubmittedPopup extends Base {
    private TaskListPage taskListPage;
    private ScanProductPage scanProductPage;
    private SectionCheckPage sectionCheckPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private ThankYouPage thankYouPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        taskListPage = new TaskListPage();
        sectionCheckPage = new SectionCheckPage();
        scanProductPage = new ScanProductPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        thankYouPage = new ThankYouPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }

    @Test(groups = "regression")
    public void verifyUnSubmittedPopup_EraseAndStartNew() throws IOException {
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
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifySubmitBtn();
        //To click on Back arrow on review count screen
        reviewCountPage.clickOnBackArrow();
        //To verify Un submitted popup and clicking on save and exit button
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_SaveAndExit();
        //To verify Main Menu
        taskListPage.validateMainMenuPageTitle();
        //To click on Section check
        taskListPage.clickSectionCheck();
        //To verify UnSubmitted work popup
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopupTitle(sc_Data.getUnSubmittedTitle());
        //To verify Section check header
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
    }

    @Test(groups = "regression")
    public void verifyUnSubmittedPopup_Continue() throws IOException {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            //To Scan single location product
            scanProductPage.scanProduct(sc_Data.getProductToScan(), Symbology.UPC_A);
        } else {
            sectionCheckPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
            manualEnterUPCPage.clickSubmitButton();
        }
        countProductPage.verifyCountProductScreen(sc_Data.getUnitsCount());
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifySubmitBtn();
        //To click on Back arrow on review count screen
        reviewCountPage.clickOnBackArrow();
        //To verify Un submitted popup and clicking on save and exit button
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_SaveAndExit();
        //To verify Main Menu
        taskListPage.validateMainMenuPageTitle();
        //To click on Section check
        taskListPage.clickSectionCheck();
        //To click on Continue button on popup
        unSubmittedWorkPopUpPage.clickOnContinueBtn();
        unSubmittedWorkPopUpPage.waitForReviewCountScreen();
        //To verify Review Count screen
        reviewCountPage.verifyPageTitle(sc_Data.getReviewCountScreen());
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.verifySectionCheckCompletedMsg(sc_Data.getThankYouScreen());
    }
}