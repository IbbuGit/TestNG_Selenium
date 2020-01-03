package com.krogerqa.appium.product_locator_app.eTransfer.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class SmokeTest extends Base {
    CommonPage commonPage;
    AboutPage aboutPage;
    MainMenuPage mainMenuPage;
    SelectTransferTypePage selectTransferTypePage;
    ETransferTutorialPage etransferTutorialPage;
    TransferTypePage transferTypePage;
    TransferListPage transferListPage;
    ManualProductEntryPage manualProductEntryPage;
    TransferAmountPage transferAmountPage;
    SuccessPage successPage;
    ScanProductPage scanProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test)
    {
        commonPage = new CommonPage ();
        aboutPage = new AboutPage ();
        mainMenuPage = new MainMenuPage (  );
        selectTransferTypePage = new SelectTransferTypePage (  );
        etransferTutorialPage = new ETransferTutorialPage ( );
        transferTypePage = new TransferTypePage (  );
        transferListPage = new TransferListPage (  );
        manualProductEntryPage = new ManualProductEntryPage (  );
        transferAmountPage = new TransferAmountPage (  );
        scanProductPage=new ScanProductPage();
        successPage = new SuccessPage (  );
    }

    @Test(groups = {"smoke"})
    /*
         * Test Name:           validateSuccessItemsInSuccessPage
         * Test Description:    eTransfer Smoke Test - Happy Path - Inventory Transfer
         * Scenario tested:     Select Inventory Location Transfer
         *                      Scan two products
         *                      Delete a scanned product from transfer list
         *                      Submit the transfer
         * Story id:
         * Epic id:
         * Test data:
         *                      0071514150349
         *                      0001111060903
         *                      0001111040601
         *                      0007047000307
         *                      0001111050719
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         *                      3. etransstage.kroger.com/etransfer-services/api/v1/transfer-items
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
    */

    void validateSuccessItemsInSuccessPage() throws IOException, InterruptedException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct ( et_Data.getScanScreenTitleAfterScanningProduct () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickDeleteButton ();
        transferListPage.clickRemoveButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );
        successPage.clickOnBackToMainMenuButton();
    }
}