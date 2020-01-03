package com.krogerqa.appium.product_locator_app.eTransfer.cases;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.EncryptDecryptUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class InventoryTransfer extends Base {

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

    private ApiRequestDataHelper dataHelper;
    private HttpClientExecutor apiExecutor;
    private String query;
    private DBHelper dbHelper;

    private final int job_IP_Sts_Cd = 1;
    private final int job_CE_Sts_Cd = 2;
    private String upcFromDB = "";

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
        dataHelper = new ApiRequestDataHelper();
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        query = "";
        dbHelper = new DBHelper();
    }
    @Test(groups = {"regression"})
    /*
     * Test Name:           validateSuccessfulTransferInInventory
     * Test Description:    Validating successful transfer
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan two products
     *                      Submit the transfer
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0030997232410
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
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
    public void validateSuccessfulTransferInInventory() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
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
    @Test(groups = {"regression"})
    /*
     * Test Name:           verifyScanAlreadyScannedProductInventoryTransfer
     * Test Description:    Scanning already scanned product
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a product
     *                      Scan the same product
     *                      Update the count from Update amount page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0030997232410
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
    public void verifyScanAlreadyScannedProductInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickForUpdateProductQnty();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }
    @Test(groups = {"regression"})
    /*
     * Test Name:           validateProductCannotBeTrasnferErrorInventoryTransfer
     * Test Description:    Validating Transfer Error
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a rule failure product
     *                      Validate Transfer Error Page
     * Story id:
     * Epic id:
     * Test data:
     *                      0007033073038
     *                      0007046209835
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer Error Page
     */
    public void validateProductCannotBeTrasnferErrorInventoryTransfer() throws IOException, InterruptedException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[0], Symbology.UPC_A);
        transferErrorPage.validateTransferErrorPageTitle(et_Data.getTransferErrorTitle());
        transferErrorPage.validateTransferError(et_Data.getProductCannotTransferError());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateTransferAmountExceedsErrorInventoryTransfer
     * Test Description:    Validating transfer amount exceeds inventory error
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a product
     *                      Enter amount greater than inventory
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0030997232410
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     */
    public void validateTransferAmountExceedsErrorInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.validateTransferAmountExceedError(et_Data.getAmountExceedError());
        transferAmountPage.verifyDisabledAddToTransferButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateScreenAfterScanningOneProductInventoryTransfer
     * Test Description:    Validate Scan Next Page
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a product
     *                      Validate the scan next page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Scan Next Page
     */
    public void validateScreenAfterScanningOneProductInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        transferListPage.validateReviewButton();
        transferListPage.validateEnterUPCButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteFunctionalityInventoryTransfer
     * Test Description:    Delete added product from transfer list
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan two products
     *                      Delete a scanned product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Remove Product Popup
     */
    public void validateDeleteFunctionalityInventoryTransfer() throws IOException, InterruptedException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickDeleteButton ();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton ();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteAllFunctionalityInventoryTransfer
     * Test Description:    Delete all added products from transfer list and discard transfer
     * Scenario tested:     Select Inventory Location Transfer
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
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Discard Transfer Popup
     */
    public void validateDeleteAllFunctionalityInventoryTransfer() throws IOException, InterruptedException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickRemoveAllListButton();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAllAlertTitle());
        transferListPage.clickContinueButton();
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getTransferTypePageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteLastProductFunctionalityInventoryTransfer
     * Test Description:    Navigating to scan First page after deleting last product
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a product
     *                      Delete the scanned product from transfer list
     *                      Navigates to Scan First page
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     */
    public  void validateDeleteLastProductFunctionalityInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickDeleteButton ();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateUpdateProductCountFunctionalityInventoryTransfer
     * Test Description:    Update Product Count Functionality
     * Scenario tested:     Select Inventory Location Transfer
     *                      Scan a product
     *                      Update the count of the added product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0004000000405
     *                      0007046209835
     *                      0002200012030
     *                      0035310020010
     *                      0003400056000
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Transfer Type Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
    public void validateUpdateProductCountFunctionalityInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickOnProductCard();
        transferAmountPage.verifyDisabledUpdateButton();
        transferAmountPage.addStepNumber();
        transferAmountPage.addStepNumber();
        transferAmountPage.clickForUpdateProductQnty();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }
    @Test(groups = {"regression"})
        /*
         * Test Name:           validateRemoveProductFromUpdateScreenFunctionalityInventoryTransfer
         * Test Description:    Deleting product from update amount page
         * Scenario tested:     Select Inventory Location Transfer
         *                      Scan two products
         *                      Delete a scanned product from update amount page
         * Story id:
         * Epic id:
         * Test data:
         *                      0004000000405
         *                      0007046209835
         *                      0002200012030
         *                      0035310020010
         *                      0003400056000
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Update Amount Page
         */
    void validateRemoveProductFromUpdateScreenFunctionalityInventoryTransfer() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickOnProductCard();
        transferAmountPage.clickRemoveProductButton();
        transferAmountPage.clickOnRemove();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression", "SATART1490"})
        /*
         * Test Name:           verifyTransferFromFKToSF
         * Test Description:    Verifying Successful Transfer of products from Fuel Kiosk to Sales Floor
         * Scenario tested:     Select Inventory Location Transfer
         *                      Select transfer type as Fuel Kiosk to Sales Floor
         *                      Scan a product
         *                      Validate DB status for added product inprogress
         *                      Submit the transfer
         *                      Validate DB status for added product complete
         * Story id:            SATART-1490
         * Epic id:
         * Test data:
         *                      0004000000405
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
         */
    void verifyTransferFromFKToSF() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        postBOHUpdate(et_Data.getProductToScan().split ( "@" )[0], QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(et_Data.getProductToScan().split ( "@" )[0], transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='"+login_Data.getUsername()+"'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='"+login_Data.getUsername()+"'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    @Test(groups = {"regression", "SATART1489"})
        /*
         * Test Name:           verifyTransferFromFKToBR
         * Test Description:    Verifying Successful Transfer of products from Fuel Kiosk to Back Room
         * Scenario tested:     Select Inventory Location Transfer
         *                      Select transfer type as Fuel Kiosk to Back Room
         *                      Scan a product
         *                      Validate DB status for added product inprogress
         *                      Submit the transfer
         *                      Validate DB status for added product complete
         * Story id:            SATART-1489
         * Epic id:
         * Test data:
         *                      0004000000405
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
         */
    void verifyTransferFromFKToBR() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        postBOHUpdate(et_Data.getProductToScan().split ( "@" )[0], QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(et_Data.getProductToScan().split ( "@" )[0], transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='"+login_Data.getUsername()+"'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='"+login_Data.getUsername()+"'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    @Test(groups = {"regression", "SATART1488"})
        /*
         * Test Name:           verifyTransferFromSFToBR
         * Test Description:    Verifying Successful Transfer of products from Sales Floor to Back Room
         * Scenario tested:     Select Inventory Location Transfer
         *                      Select transfer type as Sales Floor to Back Room
         *                      Scan a product
         *                      Validate DB status for added product inprogress
         *                      Submit the transfer
         *                      Validate DB status for added product complete
         * Story id:            SATART-1488
         * Epic id:
         * Test data:
         *                      0004000000405
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
         */
    void verifyTransferFromSFToBR() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        postBOHUpdate(et_Data.getProductToScan().split ( "@" )[0], QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(et_Data.getProductToScan().split ( "@" )[0], transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='"+login_Data.getUsername()+"'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='"+login_Data.getUsername()+"'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    @Test(groups = {"regression", "SATART1487"})
        /*
         * Test Name:           verifyTransferFromSFToFK
         * Test Description:    Verifying Successful Transfer of products from Sales Floor to Fuel Kiosk
         * Scenario tested:     Select Inventory Location Transfer
         *                      Select transfer type as Sales Floor to Fuel Kiosk
         *                      Scan a product
         *                      Validate DB status for added product inprogress
         *                      Submit the transfer
         *                      Validate DB status for added product complete
         * Story id:            SATART-1487
         * Epic id:
         * Test data:
         *                      0004000000405
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
         */
    void verifyTransferFromSFToFK() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        postBOHUpdate(et_Data.getProductToScan().split ( "@" )[0], QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(et_Data.getProductToScan().split ( "@" )[0], transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='"+login_Data.getUsername()+"'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='"+login_Data.getUsername()+"'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    @Test(groups = {"regression", "SATART1486"})
        /*
         * Test Name:           verifyTransferFromBRToFK
         * Test Description:    Verifying Successful Transfer of products from Sales Floor to Fuel Kiosk
         * Scenario tested:     Select Inventory Location Transfer
         *                      Select transfer type as Back Room to Fuel Kiosk
         *                      Scan a product
         *                      Validate DB status for added product inprogress
         *                      Submit the transfer
         *                      Validate DB status for added product complete
         * Story id:            SATART-1486
         * Epic id:
         * Test data:
         *                      Drug/Gm Product
         * API tested:
         *                      1. etransstage.kroger.com/etransfer-services/api/v1/buckets
         *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
         * UI screen tested:
         *                      1. Select Transfer Type Page
         *                      2. Transfer Type Page
         *                      3. Scan First
         *                      4. Transfer Amount Page
         *                      5. Transfer List Page
         *                      6. Success Page
         */
    void verifyTransferFromBRToFK() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        //Getting Drug/GM Product from database
        query = "select BASE_UPC_NO from ETRANSFER_ACTIVITY where FROM_SUBDEPARTMENT_CD="+et_Data.getDepartmentCode();
        String drugUPCJson = dbHelper.executeDBStatment("etransfer", query);
        String upcExpression = "$..BASE_UPC_NO";
        List<String> upc_list = JsonPath.read(drugUPCJson,upcExpression);
        upcFromDB = upc_list.get(0);

        postBOHUpdate(upcFromDB, QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(upcFromDB, transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='"+login_Data.getUsername()+"'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton ();
        transferListPage.clickSubmitButton ();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='"+login_Data.getUsername()+"'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    @Test(groups = {"regression","SATART1485"})
    /*
     * Test Name            :   verifyTransferFromBRToSF
     * Test Description     :   Verifying Successful Transfer of products from Backroom to Sales Floor
     * Scenario tested      :   Select Inventory Location Transfer
     *                          Select transfer type as Backroom to Sales Floor
     *                          Scan a product
     *                          Validate DB status for added product inprogress
     *                          Submit the transfer
     *                          Validate DB status for added product complete
     * Story id             :   SATART-1485
     * Epic id              :   -
     * Test data            :    Drug/Gm Products(0001878777432,0001111037575)
     * API tested           :    1. etransstage.kroger.com/etransfer-services/api/v1/buckets
                                 2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested     :    1. Select Transfer Type Page
     *                           2. Transfer Type Page
     *                           3. Scan First
     *                           4. Transfer Amount Page
     *                           5. Transfer List Page
     *                           6. Success Page
     */
    public void verifyTransferFromBRToSF() throws IOException, InterruptedException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //For Test Data
        String QODQuantity = "100";
        String QIBQuantity = "100";
        String QIKQuantity = "100";
        String transferAmount = "25";

        postBOHUpdate(et_Data.getProductToScan().split ( "@" )[0], QODQuantity, QIBQuantity, QIKQuantity);

        addProductToTransferList(et_Data.getProductToScan().split ( "@" )[0], transferAmount);

        //DB Validation for product inprogress status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='IP') and EUID='" + login_Data.getUsername() + "'";
        String expression = "$..ETRANSFER_JOB_STS_CD_ID";
        verifyJobStsCdID(query, expression, job_IP_Sts_Cd);

        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.viewSuccessPageTitle(et_Data.getSuccessPageTitle());

        //DB Validation for product complete status
        query = "select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB where ETRANSFER_JOB_STS_CD_ID in (select ETRANSFER_JOB_STS_CD_ID from ETRANSFER_JOB_STS_CD where JOB_STS_CD_SHORT_DSC='CE') and EUID='" + login_Data.getUsername() + "'";
        verifyJobStsCdID(query, expression, job_CE_Sts_Cd);
    }

    private void postBOHUpdate(String upcToScan, String QODQuantity, String QIBQuantity, String QIKQuantity) throws IOException {
        String body = dataHelper.updateBOHBody(upcToScan, QODQuantity, QIKQuantity, QIBQuantity);
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
    }

    private void verifyJobStsCdID(String query, String expression, int expJobStsCdID) throws SQLException {
        String jobStatusJson = dbHelper.executeDBStatment("etransfer", query);
        List<?> job_sts = JsonPath.read(jobStatusJson,expression);
        Assert.assertEquals(job_sts.get(0), expJobStsCdID, "Status Code Verification");
    }

    private void addProductToTransferList(String upcToScan, String transferAmount) throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickInventoryLocationTransfer ( );
        transferTypePage.viewTransferTypePageTitle ( et_Data.getTransferTypePageTitle () );
        transferTypePage.clickTransferPrdFrmDropDown ();
        String selectedValue=transferTypePage.selectTransferProductFrom (et_Data.getTransferProductFrom ());
        transferTypePage.clickTransferPrdToDropDown ();
        transferTypePage.selectTransferPrdToDropDown (selectedValue,et_Data.getTransferProductTo ());
        transferTypePage.clickNextButton ();
        transferListPage.viewTransferListPageTitle ( et_Data.getTransferListPageTitle () );
        scanProductPage.scanProduct(upcToScan, Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.enterInventoryTransferAmount(transferAmount);
        transferAmountPage.addStepNumber();
        transferAmountPage.minusStepNumber();
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct ( et_Data.getScanScreenTitleAfterScanningProduct () );
    }
}
