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

public class ReviewCountScreen extends Base {
    private TaskListPage taskListPage;
    private SectionCheckPage sectionCheckPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    private ReviewCountPage reviewCountPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        taskListPage = new TaskListPage();
        sectionCheckPage = new SectionCheckPage();
        manualEnterUPCPage=new ManualEnterUPCPage();
        scanProductPage = new ScanProductPage();
        countProductPage = new CountProductPage();
        scanNextProductPage = new ScanNextProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    }

    @Test(groups = {"Story","regression"})
    public void verifyUnSubmittedWork_Cancel_ReviewCountPage() throws IOException {
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
        reviewCountPage.clickOnBackArrow();
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_Cancel(sc_Data.getUnSubmittedTitle());
        reviewCountPage.verifyPageTitle(sc_Data.getReviewCountScreen());
    }

    @Test(groups = {"Story","regression"})
    public void verifyUnSubmittedWork_SaveAndExit_ReviewCountPage() throws IOException {
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
        reviewCountPage.clickOnBackArrow();
        unSubmittedWorkPopUpPage.verifyUnSubmittedPopUpMessage_SaveAndExit();
        taskListPage.validateMainMenuPageTitle();
    }
}