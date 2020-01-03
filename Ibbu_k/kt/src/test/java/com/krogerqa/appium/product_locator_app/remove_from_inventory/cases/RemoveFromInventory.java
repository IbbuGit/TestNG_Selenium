/*
package com.krogerqa.appium.product_locator_app.remove_from_inventory.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.MainMenuPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.EnterUPCPopUpPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.OutdatedPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.EnterAmountPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.ReviewScreenPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.InventoryUpdatedPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.RecallPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.ReclaimPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.DonationPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.DamagedPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class RemoveFromInventory extends Base{
    OutdatedPage outdatedPage;
    MainMenuPage mainMenuPage;
    EnterUPCPopUpPage enterUPCPopUpPage;
    EnterAmountPage enterAmountPage;
    ScanProductPage scanProductPage;
    ReviewScreenPage reviewScreenPage;
    InventoryUpdatedPage inventoryUpdatedPage;
    RecallPage recallPage;
    ReclaimPage reclaimPage;
    DonationPage donationPage;
    DamagedPage damagedPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        outdatedPage=new OutdatedPage();
        mainMenuPage=new MainMenuPage();
        enterUPCPopUpPage = new EnterUPCPopUpPage();
        enterAmountPage = new EnterAmountPage();
        scanProductPage = new ScanProductPage();
        reviewScreenPage = new ReviewScreenPage();
        inventoryUpdatedPage = new InventoryUpdatedPage();
        recallPage = new RecallPage();
        reclaimPage = new ReclaimPage();
        donationPage = new DonationPage();
        damagedPage = new DamagedPage();
    }

*/
/* Includes functionality in JIRA stories ISPART-19277 and ISPART-19278: Login and verify outdated title and sign out *//*

    @Test(groups = {"smoke","regression"})
    void loginTest_RFI() throws Throwable {
        outdatedPage.validateOutdatedTitle();
        outdatedPage.clickExitFromInventoryKababMenuOption();
        mainMenuPage.validateMainMenuPageTitle(rfi_Data.getMainMenuPageTitle());
    }

*/
/*Includes Functionality in JIRA stories ISPART-19318, ISPART-19319, ISPART-19320 and ISPART-19323 : Validate Outdated Screen, Enter Manual UPC and validate Enter Amount screen *//*

    @Test(groups = {"smoke","regression"})
    void manualUPCEntry_RFI() throws Throwable {
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        enterUPCPopUpPage.clickEnterUPC();
        enterUPCPopUpPage.validateManualTextTitle(Consts.titleManualEnterUPC);
        enterUPCPopUpPage.invalidUPCValidation(Consts.lblItemNotFoundError);
        String UPC = rfi_Data.getProductsToScan();
        enterUPCPopUpPage.enterUpcEditText(rfi_Data.getProductsToScan());
        enterUPCPopUpPage.clickSubmitButton();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPC);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enterAmountPage.clickReview();
    }

    */
/*Includes Functionality in JIRA stories ISPART-19316, ISPART-19321, ISPART-19322 and ISPART-19327 :
    Add products using scanning functionality Validate Outdated Screen scanning and scan products in Enter Amount screen *//*

    @Test(groups = {"smoke","regression"})
    void scanProduct_RFI() throws Throwable {
        String[] UPCs;
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateReviewBtn();
        enterAmountPage.validateUpc(UPCs[0]);
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        enterAmountPage.validateUpc(UPCs[1]);
        enterAmountPage.clickReviewAndSubmit();
    }

    */
/* Includes functionality for JIRA Story: ISPART-19361
       Adding multiple products through Manual Entry and validating delete functionality on Enter Amount Screen *//*

    @Test(groups = {"regression"})
    void manualMultipleUPCEntry_RFI() throws Throwable {
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        enterUPCPopUpPage.clickEnterUPC();
        enterUPCPopUpPage.validateManualTextTitle(Consts.titleManualEnterUPC);
        String UPC = rfi_Data.getProductsToScan().split(";")[0];
        enterUPCPopUpPage.enterUpcEditText(rfi_Data.getProductsToScan().split(";")[0]);
        enterUPCPopUpPage.clickSubmitButton();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPC);
        enterAmountPage.deleteUsingHeaderTrashIcon();
        enterUPCPopUpPage.clickEnterUPC();
        String AddedUPC = rfi_Data.getProductsToScan().split(";")[1];
        enterUPCPopUpPage.enterUpcEditText(rfi_Data.getProductsToScan().split(";")[1]);
        enterUPCPopUpPage.clickSubmitButton();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, AddedUPC);
        enterAmountPage.clickReviewAndSubmit();
    }

    */
/*Adding multiple products through Scan and Manual Entry and validating Outdated, Enter Amount screen *//*

    @Test(groups = {"smoke","regression"})
    void manualAndScanMultipleUPCEntry_RFI() throws Throwable {
        String[] UPCs;
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.addMoreButton();
        reviewScreenPage.addMoreManualProducts(rfi_Data.getProductsToScan().split(";")[1], UPCs[1]);
        enterAmountPage.clickReviewAndSubmit();
    }

    */
/* Includes functionality from JIRA Stories: ISPART-19330
    Add products through Manual entry and validate Outdated, Enter Amount, Review Screen, Add More and Inventory Updated Screen
    Click "Back to Main Menu" and validate Main Menu Screen*//*

    @Test(groups = {"smoke","regression"})
    void manualUPCEntryHappyPath_RFI() throws Throwable{
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        enterUPCPopUpPage.clickEnterUPC();
        enterUPCPopUpPage.validateManualTextTitle(Consts.titleManualEnterUPC);
        String UPC = rfi_Data.getProductsToScan().split(";")[0];
        enterUPCPopUpPage.enterUpcEditText(rfi_Data.getProductsToScan().split(";")[0]);
        enterUPCPopUpPage.clickSubmitButton();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPC);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleOutdated);
        reviewScreenPage.addMoreScreenValidation();
        String AddedUPC = rfi_Data.getProductsToScan().split(";")[1];
        reviewScreenPage.addMoreManualProducts(rfi_Data.getProductsToScan().split(";")[1],AddedUPC);
        reviewScreenPage.validateAddedProducts();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleOutdated);
    }

    */
/* Includes functionality from JIRA stories ISPART-19332 and ISPART-19333
    Validating "Exit Remove Form Inventory" and "Sign Out" option in the Kebab menu from all Screens,
    Clicking on product card and validating UPC on enter amount screen *//*

    @Test(groups = {"regression"})
    void exitRFIFunctionality_RFI() throws Throwable {
        String[] UPCs;
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        enterUPCPopUpPage.exitFromEnterUPCAndSuccessScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.exitFromAmountAndReviewScreen();
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[1]);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.clickAndValidateProductCard();
        enterAmountPage.exitFromAmountAndReviewScreen();
        scanProductPage.scanProduct(UPCs[2], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[2]);
        enterAmountPage.clickReviewAndSubmit();
        enterUPCPopUpPage.exitFromEnterUPCAndSuccessScreen();
    }

    */
/* Includes functionality from JIRA story ISPART-20601
Validating second chance item banner in "Outdated" flow and validating Review and inventory updated screen *//*

    @Test(groups = {"regression2"})
    void outdatedSecondChanceFLow_RFI() throws Throwable{
        String[] UPCs;
        outdatedPage.validateOutdatedTitle();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        outdatedPage.secondChanceBannerValidation();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleOutdated);
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleOutdated);
    }
    */
/*Includes functionality of JIRA story ISPART-19325
    Validating "Recall" flow and banners for Recall flow UPC's *//*

    @Test(groups = {"regression"})
    void recallFlow_RFI() throws Throwable{
        String[] UPCs;
        recallPage.clickRecallBtnAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        recallPage.validateRecallBanner();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleRecall);
        reviewScreenPage.addMoreScreenValidation();
        String AddedUPC = rfi_Data.getProductsToScan().split(";")[1];
        reviewScreenPage.addManualProductForRecallFlow(rfi_Data.getProductsToScan().split(";")[1],AddedUPC);
        reviewScreenPage.validateAddedProducts();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleRecall);
    }

    */
/*Includes functionality of JIRA story ISPART-19364
    Validating "Reclaim" flow and banners for Reclaim flow UPC's *//*

    @Test(groups = {"regression"})
    void reclaimFLow_RFI() throws Throwable{
        String[] UPCs;
        reclaimPage.clickReclaimBtnAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        reclaimPage.checkReclaimBannerForYes();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen,UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleReclaim);
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        reclaimPage.checkReclaimBannerForYes();
        reclaimPage.validateCorpBrandUPCBanner();
        reclaimPage.discardCorpBrandButton();
        reviewScreenPage.validateAddedProducts();
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[2], Symbology.UPC_A);
        reclaimPage.checkReclaimBannerForYes();
        reclaimPage.donateCorpBrandButton();
        reviewScreenPage.validateAddedProducts();
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[3], Symbology.UPC_A);
        reclaimPage.checkReclaimBannerForYes();
        reclaimPage.markdownCorpBrandButton();
        enterAmountPage.clickReviewButton();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleReclaim);
    }

    */
/* Includes functionality from JIRA storie ISPART-20602 and ISPART-20604
    Validating "Donation" flow and validating "Smoking Cessation" banner for Blue Banner UPC's *//*

    @Test(groups = {"regression"})
    void donationFlow_RFI() throws Throwable{
        String[] UPCs;
        donationPage.clickDonationBtnAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        donationPage.validateSmokingCessationBanner();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen,UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleDonation);
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleDonation);
    }

    */
/* Includes functionality from JIRA story ISPART-19359 and ISPART-19334
     Validating "Theft" Flow and validating delete functionality on "Review Screen" *//*

    @Test(groups = {"regression"})
    void theftFlow_RFI() throws Throwable{
        String[] UPCs;
        outdatedPage.clickTheftAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.addMoreButton();
        reviewScreenPage.addMoreManualProducts(rfi_Data.getProductsToScan().split(";")[1], UPCs[1]);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.validateReviewScreen(Consts.titleTheft);
        enterAmountPage.deleteUsingHeaderTrashIcon();
        inventoryUpdatedPage.validateRemoveFromInventoryIcon();
    }

    /*Includes functionality from JIRA stories ISPART-20606. ISPART-20603, ISPART-19329
    Validating "damaged" functionality, Limited quantity banner, See pharmacy manager banner and delete functionality from product card */
    /*@Test(groups = {"regression"})
    void damagedFLow_RFI() throws Throwable{
        String[] UPCs;
        damagedPage.clickDamagedBtnAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        damagedPage.limitedQuantityBannerValidation();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        damagedPage.validatePharmacyManagerBanner();
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.validateReviewScreen(Consts.titleDamaged);
        enterAmountPage.clickProductTileDeleteIconAndValidate();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleDamaged);
    }
*/
    /* Includes functionality from JIRA story ISPART-19367,
    Validating and handling Enter UPC functionality from all screens and validate them*/
  /*  @Test(groups = {"regression"})
    void UPCHandlingFLow_RFI() throws Throwable{
        String[] UPCs;
        outdatedPage.clickTheftAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[1]);
        enterAmountPage.addMoreScreenValidationOnEnterAmount();
        scanProductPage.scanProduct(UPCs[2], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[2]);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.validateReviewScreen(Consts.titleTheft);
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[3], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[3]);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.addMoreScreenValidation();
        String AddedUPC = rfi_Data.getProductsToScan().split(";")[4];
        reviewScreenPage.addMoreManualProducts(rfi_Data.getProductsToScan().split(";")[4],AddedUPC);
        enterAmountPage.clickReviewButton();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleTheft);
    }*/

    /* Includes functionality from JIRA story ISPART-20607,
    Validating back button functionality form all the screens and handling pop ups for unsaved data */
    /*@Test(groups = {"regression"})
    void backButtonFLow_RFI() throws Throwable {
        String[] UPCs;
        outdatedPage.clickOutdated();
        outdatedPage.validateBackButtonOnEnterUpcScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.clickCloseOnEnterAMountScreen();
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        enterAmountPage.backButtonFromAddMoreScreen();
        enterAmountPage.clickReviewButton();
        reviewScreenPage.backButtonFromReviewScreen(Consts.titleOutdated);
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[0]);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.backButtonFromAddMoreOnReviewScreen(Consts.titleOutdated);
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleOutdated);
    }*/

    /*Includes functionality from JIRA story ISPART-20605 and ISPART-20608
    Validating Battery Sticker Pop Up in donation flow and validate that the product with yellow banner is not added to the review screen*/
    /*@Test(groups = {"regression"})
    void donationBannerFLow_RFI() throws Throwable {
        String[] UPCs;
        donationPage.clickDonationBtnAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        reclaimPage.checkReclaimBannerForYes();
        donationPage.batteryStickerPopUpValidation();
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen,UPCs[0]);
        enterAmountPage.addUnitsOnAmountScreen(Consts.titleEnterAmountScreen);
        reviewScreenPage.validateProductCard();
        reviewScreenPage.validateReviewScreen(Consts.titleDonation);
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        Assert.assertTrue(donationPage.holdForVendorPickUpValidation());
        enterAmountPage.clickSubmitButton();
    }
*/
    /* Includes functionality from JIRA stories ISPART-20605 and ISPART-19366
    Validating Magic Item banner in the theft flow, asserting product is not added to the review screen and validating incorrect UPC scan error */
    /*@Test(groups = {"regression"})
    void magicItemTheftFLow_RFI() throws Throwable {
        String[] UPCs;
        outdatedPage.clickTheftAndValidate();
        outdatedPage.verifyElementsOnEnterUPCScreen();
        UPCs = rfi_Data.getProductsToScan().split(";");
        scanProductPage.scanProduct(UPCs[0], Symbology.UPC_A);
        Assert.assertTrue(outdatedPage.magicItemValidation());
        reviewScreenPage.addMoreScreenValidation();
        scanProductPage.scanProduct(UPCs[1], Symbology.UPC_A);
        outdatedPage.barCodeNotRecognizedValidation();
        scanProductPage.scanProduct(UPCs[2], Symbology.UPC_A);
        enterAmountPage.validateEnterAmountScreen(Consts.titleEnterAmountScreen, UPCs[2]);
        enterAmountPage.clickReviewButton();
        inventoryUpdatedPage.validateInventoryUpdatedScreen(Consts.titleTheft);
    }

}*/

