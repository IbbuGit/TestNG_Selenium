package com.krogerqa.appium.product_locator_app.eTransfer.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class StoreToStore extends Base {
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
    DepartmentListPage departmentListPage;
    TransferErrorPage transferErrorPage;
    StoreListPage storeListPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        commonPage = new CommonPage();
        aboutPage = new AboutPage();
        mainMenuPage = new MainMenuPage();
        selectTransferTypePage = new SelectTransferTypePage();
        etransferTutorialPage = new ETransferTutorialPage();
        transferTypePage = new TransferTypePage();
        transferListPage = new TransferListPage();
        manualProductEntryPage = new ManualProductEntryPage();
        transferAmountPage = new TransferAmountPage();
        scanProductPage = new ScanProductPage();
        successPage = new SuccessPage();
        departmentListPage = new DepartmentListPage();
        transferErrorPage = new TransferErrorPage();
        storeListPage = new StoreListPage();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateScreenAfterScanningOneProductInS2S
     * Test Description:    Validate Scan Next Page
     * Scenario tested:     Select Store to Store
     *                      Scan a product
     *                      Validate the scan next page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Scan Next Page
     */
    public void validateScreenAfterScanningOneProductInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        transferListPage.validateReviewButton();
        transferListPage.validateEnterUPCButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteFunctionalityInS2S
     * Test Description:    Delete added product from transfer list
     * Scenario tested:     Select Store to Store
     *                      Scan two products
     *                      Delete a scanned product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Remove Product Popup
     */
    public void validateDeleteFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickDeleteButton();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());

    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteAllFunctionalityInS2S
     * Test Description:    Delete all added products from transfer list and discard transfer
     * Scenario tested:     Select Store to Store
     *                      Scan two products
     *                      Delete all products
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Discard Transfer Popup
     */
    public void validateDeleteAllFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickRemoveAllListButton();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAllAlertTitle());
        transferListPage.clickContinueButton();
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getTransferTypePageTitle());

    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateProductCannotBeTrasnferErrorInS2S
     * Test Description:    Validating Transfer Error
     * Scenario tested:     Select Store to Store
     *                      Scan a rule failure product
     *                      Validate Transfer Error Page
     * Story id:
     * Epic id:
     * Test data:
     *                      0078212600306
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer Error Page
     */
    public void validateProductCannotBeTrasnferErrorInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferErrorPage.validateTransferErrorPageTitle(et_Data.getTransferErrorTitle());
        transferErrorPage.validateTransferError(et_Data.getProductCannotTransferError());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateTransferAmountExceedsErrorInS2S
     * Test Description:    Validating transfer amount exceeds inventory error
     * Scenario tested:     Select Store to Store
     *                      Scan a product
     *                      Enter amount greater than inventory
     * Story id:
     * Epic id:
     * Test data:
     *                      0001878777432
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     */
    public void validateTransferAmountExceedsErrorInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.validateTransferAmountExceedError(et_Data.getAmountExceedError());
        transferAmountPage.verifyDisabledAddToTransferButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteLastProductFunctionalityInS2S
     * Test Description:    Navigating to scan First page after deleting last product
     * Scenario tested:     Select Store to Store
     *                      Scan a product
     *                      Delete the scanned product from transfer list
     *                      Navigates to Scan First page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     */
    public void validateDeleteLastProductFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickDeleteButton();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateUpdateProductCountFunctionalityInS2S
     * Test Description:    Update Product Count Functionality
     * Scenario tested:     Select Store to Store
     *                      Scan a product
     *                      Update the count of the added product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
    public void validateUpdateProductCountFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickOnProductCard();
        transferAmountPage.verifyDisabledUpdateButton();
        transferAmountPage.addStepNumber();
        transferAmountPage.addStepNumber();
        transferAmountPage.clickForUpdateProductQnty();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateRemoveLastProductFromUpdateScreenFunctionalityInS2S
     * Test Description:    Navigating to scan First page after deleting last product from update amount page
     * Scenario tested:     Select Store to Store
     *                      Scan a product
     *                      Delete the scanned product from update amount page
     *                      Navigates to Scan First page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
    public void validateRemoveLastProductFromUpdateScreenFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickOnProductCard();
        transferAmountPage.clickRemoveProductButton();
        transferAmountPage.clickOnRemove();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateRemoveProductFromUpdateScreenFunctionalityInS2S
     * Test Description:    Deleting product from update amount page
     * Scenario tested:     Select Store to Store
     *                      Scan two products
     *                      Delete a scanned product from update amount page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
    public void validateRemoveProductFromUpdateScreenFunctionalityInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickOnProductCard();
        transferAmountPage.clickRemoveProductButton();
        transferAmountPage.clickOnRemove();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateSuccessfulTransferInS2S
     * Test Description:    Validating successful transfer
     * Scenario tested:     Select Store to Store
     *                      Scan two products
     *                      Submit the transfer
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0004126036072
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v2/stores
     *                      2. etransstage.kroger.com/etransfer-services/api/v2/items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Division Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Success Page
     */
    public void validateSuccessfulTransferInS2S() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickStoreToStore();
        storeListPage.validateStoreListPageTitle(et_Data.getStoteToStoreTitle());
        storeListPage.selectStore(et_Data.getStoreName());
        storeListPage.enterStoreNumber(et_Data.getStoreNumber());
        storeListPage.clickStoreNumberLabel();
        storeListPage.clickNextbtn();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );
        successPage.clickOnBackToMainMenuButton();
    }

}

