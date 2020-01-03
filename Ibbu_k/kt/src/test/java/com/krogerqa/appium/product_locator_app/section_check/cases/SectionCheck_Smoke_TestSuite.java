package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
public class SectionCheck_Smoke_TestSuite extends Base {
    private String[] multiProductScan;
    private String[] getMultiProductUnitCount;
    private TaskListPage taskListPage;
    private ScanProductPage scanProductPage;
    private CountProductPage countProductPage;
    private ScanNextProductPage scanNextProductPage;
    //private EnterUPCPopUpPage enterUpcPage;
    private SectionCheckPage sectionCheckPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private ReviewCountPage reviewCountPage;
    private ThankYouPage thankYouPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;

        @BeforeMethod(alwaysRun = true)
        public void init() {
            taskListPage= new TaskListPage();
            scanProductPage = new ScanProductPage();
            sectionCheckPage=new SectionCheckPage();
            manualEnterUPCPage=new ManualEnterUPCPage();
            //enterUpcPage = new EnterUPCPopUpPage();
            countProductPage = new CountProductPage();
            scanNextProductPage = new ScanNextProductPage();
            reviewCountPage = new ReviewCountPage();
            thankYouPage = new ThankYouPage();
            unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        }

        @Test(groups = "smoke")
        public void sectionCheckHappyPath() throws IOException {
            //Click on Erase and Start button if there are any Unsubmitted UPCs
            unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
            //Get the UPCs and Store split UPC in an Array
            multiProductScan = sc_Data.getProductToScan().split(";");
            //Get the Units Count and Store split UPC in an Array
            getMultiProductUnitCount = sc_Data.getUnitsCount().split(";");
            taskListPage.clickSectionCheck();
            if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanProductPage.scanProduct(multiProductScan[0], Symbology.UPC_A);
            }
            else
            {
                sectionCheckPage.clickOnEnterUPCBtn();
                manualEnterUPCPage.enterProductUPC(multiProductScan[0]);
                manualEnterUPCPage.clickSubmitButton();
            }
            countProductPage.verifyCountProductScreen(getMultiProductUnitCount[0]);
            scanNextProductPage.clickOnReviewBtn();
            //Add More Button
            reviewCountPage.clickingOnAddMoreBtn();
            if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanProductPage.scanProduct(multiProductScan[1], Symbology.UPC_A);
            }
            else
            {
                scanNextProductPage.clickOnEnterUPCBtn();
                manualEnterUPCPage.enterProductUPC(multiProductScan[1]);
                manualEnterUPCPage.clickSubmitButton();
            }
            countProductPage.verifyCountProductScreen(getMultiProductUnitCount[1]);
            scanNextProductPage.clickOnReviewBtn();
            reviewCountPage.clickOnSubmitBtn();
            thankYouPage.clickOnMainMenu();
        }
}