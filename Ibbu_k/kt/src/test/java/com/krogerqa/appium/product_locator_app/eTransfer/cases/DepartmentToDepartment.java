package com.krogerqa.appium.product_locator_app.eTransfer.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;

public class DepartmentToDepartment extends Base {

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
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDepartmentChangeD2D
     * Test Description:    Change Selected To Department - D2D
     * Scenario tested:     Select Department to Department Transfer
     *                      Select a department
     *                      Change the department
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     */
    public void validateDepartmentChangeD2D() {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        transferListPage.clickOnChangeDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getUpdatedDepartment());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentName(et_Data.getUpdatedDepartment());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateScreenAfterScanningOneProductInD2D
     * Test Description:    Validate Scan Next Page
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Validate the scan next page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Scan Next Page
     */
   public  void validateScreenAfterScanningOneProductInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        transferListPage.validateReviewButton();
        transferListPage.validateEnterUPCButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteFunctionalityInD2D
     * Test Description:    Delete added product from transfer list
     * Scenario tested:     Select Department to Department
     *                      Scan two products
     *                      Delete a scanned product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Remove Product Popup
     */
    public void validateDeleteFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickDeleteButton ();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton ();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());

    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteAllFunctionalityInD2D
     * Test Description:    Delete all added products from transfer list and discard transfer
     * Scenario tested:     Select Department to Department
     *                      Scan two products
     *                      Delete all products
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Discard Transfer Popup
     */
   public  void validateDeleteAllFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickRemoveAllListButton();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAllAlertTitle());
        transferListPage.clickContinueButton();
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getTransferTypePageTitle());

    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateProductCannotBeTrasnferErrorInD2D
     * Test Description:    Validating Transfer Error
     * Scenario tested:     Select Department to Department
     *                      Scan a rule failure product
     *                      Validate Transfer Error Page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer Error Page
     */
     public void validateProductCannotBeTrasnferErrorInD2D() throws IOException{
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[3], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferErrorPage.validateTransferErrorPageTitle(et_Data.getTransferErrorTitle());
        transferErrorPage.validateTransferError(et_Data.getProductCannotTransferError());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateTransferAmountExceedsErrorInD2D
     * Test Description:    Validating transfer amount exceeds inventory error
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Enter amount greater than inventory
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     */
  public void validateTransferAmountExceedsErrorInD2D() throws IOException{
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[4], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.addStepNumber();
        transferAmountPage.validateTransferAmountExceedError(et_Data.getAmountExceedError());
        transferAmountPage.verifyDisabledAddToTransferButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateDeleteLastProductFunctionalityInD2D
     * Test Description:    Navigating to scan First page after deleting last product
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Delete the scanned product from transfer list
     *                      Navigates to Scan First page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     */
   public void validateDeleteLastProductFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickDeleteButton ();
        transferListPage.validateDeleteAlertTitle(et_Data.getDeleteAlertTitle());
        transferListPage.clickRemoveButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateUpdateProductCountFunctionalityInD2D
     * Test Description:    Update Product Count Functionality
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Update the count of the added product from transfer list
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
   public void validateUpdateProductCountFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
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
     * Test Name:           validateRemoveLastProductFromUpdateScreenFunctionalityInD2D
     * Test Description:    Navigating to scan First page after deleting last product from update amount page
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Delete the scanned product from update amount page
     *                      Navigates to Scan First page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
   public void validateRemoveLastProductFromUpdateScreenFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickOnProductCard();
        transferAmountPage.clickRemoveProductButton();
        transferAmountPage.clickOnRemove();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           validateRemoveProductFromUpdateScreenFunctionalityInD2D
     * Test Description:    Deleting product from update amount page
     * Scenario tested:     Select Department to Department
     *                      Scan two products
     *                      Delete a scanned product from update amount page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
   public void validateRemoveProductFromUpdateScreenFunctionalityInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle ( et_Data.getSelectTransferTypePageTitle () );
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle ( et_Data.getTransferAmountPageTitle ());
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber ( );
        transferAmountPage.clickAddToTransferButton ();
        transferListPage.clickReviewButton ();
        transferListPage.clickOnProductCard();
        transferAmountPage.clickRemoveProductButton();
        transferAmountPage.clickOnRemove();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           verifySuccessfulTransferD2D
     * Test Description:    Validating successful transfer
     * Scenario tested:     Select Department to Department
     *                      Scan two products
     *                      Submit the transfer
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     *                      3. etransstage.kroger.com/etransfer-services/api/v1/transfer-items
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Success Page
     */
    public void verifySuccessfulTransferD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        transferListPage.verifyDepartmentName(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split ( "@" )[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.validateStepNumber();
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickAddMoreButton();
        scanProductPage.scanProduct (et_Data.getProductToScan().split ( "@" )[1], Symbology.UPC_A);
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.clickReviewButton();
        transferListPage.clickSubmitButton();
        successPage.viewSuccessPageTitle ( et_Data.getSuccessPageTitle () );
        successPage.clickOnBackToMainMenuButton();
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           verifyScanAlreadyScannedProductInD2D
     * Test Description:    Scanning already scanned product
     * Scenario tested:     Select Department to Department
     *                      Scan a product
     *                      Scan the same product
     *                      Update the count from Update amount page
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Transfer Amount Page
     *                      5. Transfer List Page
     *                      6. Update Amount Page
     */
   public void verifyScanAlreadyScannedProductInD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
        transferListPage.verifyDepartmentChangeIcon();
        transferListPage.verifyTransferToText();
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferAmountPage.viewTransferAmountPageTitle(et_Data.getTransferAmountPageTitle());
        transferAmountPage.validateStepNumber();
        transferAmountPage.addStepNumber();
        transferAmountPage.clickAddToTransferButton();
        transferListPage.verifyTransferListPageTitleAfterScanningProduct(et_Data.getScanScreenTitleAfterScanningProduct());
        scanProductPage.scanProduct (et_Data.getProductToScan().split("@")[2], Symbology.UPC_A);
        transferAmountPage.addStepNumber();
        transferAmountPage.clickForUpdateProductQnty();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

    @Test(groups = {"regression"})
    /*
     * Test Name:           verifyDeptErrorD2D
     * Test Description:    Verifying Department Error - D2D
     * Scenario tested:     Select Department to Department
     *                      Select a department
     *                      Scan a product belonging to the selected department
     *                      Verify the Department error popup
     * Story id:
     * Epic id:
     * Test data:
     *                      0000000004011
     *                      0007033073038
     *                      0001111071295
     *                      0001111037575
     * API tested:
     *                      1. etransstage.kroger.com/etransfer-services/api/v1/departments
     *                      2. etransstage.kroger.com/etransfer-services/api/v1/transfer-item
     * UI screen tested:
     *                      1. Select Transfer Type Page
     *                      2. Your Department Page
     *                      3. Scan First
     *                      4. Department Error Popup
     */
    public void verifyDeptErrorD2D() throws IOException {
        selectTransferTypePage.viewSelectTransferTypePageTitle(et_Data.getSelectTransferTypePageTitle());
        selectTransferTypePage.clickDepartmentToDepartment();
        departmentListPage.validateDepartmentListPageTitle(et_Data.getDepartmentScreenTitle());
        departmentListPage.selectDepartment(et_Data.getDepartmentName());
        scanProductPage.scanProduct(et_Data.getProductToScan().split("@")[0], Symbology.UPC_A);
        transferListPage.validateDeptErrorPopUp();
        transferListPage.viewTransferListPageTitle(et_Data.getTransferListPageTitle());
    }

}
