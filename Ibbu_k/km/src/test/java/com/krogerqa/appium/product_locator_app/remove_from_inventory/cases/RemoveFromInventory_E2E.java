package com.krogerqa.appium.product_locator_app.remove_from_inventory.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.MainMenuPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

public class RemoveFromInventory_E2E extends Base {
    HttpClientExecutor apiExecutor;
    ApiRequestDataHelper dataHelper;
    HashMap<String, Integer> countQODListBefore = new HashMap<>();
    private OutdatedPage outdatedPage;
    private InventoryUpdatedPage inventoryUpdatedPage;
    private MainMenuPage mainMenuPage;
    private EnterUPCPopUpPage enterUPCPopUpPage;
    private ReviewScreenPage reviewScreenPage;
    private EnterAmountPage enterAmountPage;
    private ReclaimPage reclaimPage;
    private DonationPage donationPage;
    private RecallPage recallPage;
    private Random random;
    private int min = 0;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
        random = new Random();
        enterAmountPage = new EnterAmountPage();
        enterUPCPopUpPage = new EnterUPCPopUpPage(login_Data);
        mainMenuPage = new MainMenuPage();
        reviewScreenPage = new ReviewScreenPage(login_Data);
        outdatedPage = new OutdatedPage();
        donationPage = new DonationPage();
        reclaimPage = new ReclaimPage();
        recallPage = new RecallPage();
        inventoryUpdatedPage = new InventoryUpdatedPage();
    }

           /*
                              Test Name                                        :  verifySmokingCessation
                              Test Description                              :  Verifying Smoking Cessation alert message and QOD update.
                              Scenario tested                                :  <Smoking Cessation upc is scanned and removed from inventory>
                              Story id                                              :  <N/A>
                              Epic id                                                : <N/A>
                              Test data                                           : < (data dependent) >
                              API tested                                         : <APIs tested as part of this flow>
                              UI screen tested                              : <N/A>
                              */


    @Test(groups = "e2e")
    public void verifySmokingCessation() throws Exception {
        outdatedPage.clickOutdated();
        enterUPCPopUpPage.setFlowType("Outdated");
        enterUPCPopUpPage.setFlowAction("SmokingCessation");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
          /*
                              Test Name                                        :  verifySeePharmacyManager
                              Test Description                              :  Verifying see Pharmacy Manager alert message and QOD update.
                              Scenario tested                                :  <Business use case of the scenarios tested>
                              Story id                                              :  <N/A>
                              Epic id                                                : <N/A>
                              Test data                                           : < (data dependent) >
                              API tested                                         : <APIs tested as part of this flow>
                              UI screen tested                              : <N/A>
                              */

@Test(groups="e2e")
    public void verifySeePharmacyManager() throws Exception {
        outdatedPage.clickOutdated();
        enterUPCPopUpPage.setFlowType("Outdated");
        enterUPCPopUpPage.setFlowAction("SeePharmacyManager");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }

    /*
                            Test Name                                        :  itemUsedForSecondChance
                            Test Description                              :  Verifying item used for second chance popup choose yes option , validate QOD update and reason code change to XC in DB.
                            Scenario tested                                :  <Business use case of the scenarios tested>
                            Story id                                              :  <N/A>
                            Epic id                                                : <N/A>
                            Test data                                           : < (data dependent) >
                            API tested                                         : <APIs tested as part of this flow>
                            UI screen tested                              : <N/A>
                            Additional Comments: This fails with reason code not updated, please refer https://jira.kroger.com/jira/browse/ISPART-21152?filter=-2
                            */
//@Test(groups = "e2e")
    public void itemUsedForSecondChance() throws Exception {
        outdatedPage.clickOutdated();
        enterUPCPopUpPage.setFlowType("Outdated");
        enterUPCPopUpPage.setFlowAction("UsedForSecondChance");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        inventoryUpdatedPage.setRfiJobId(login_Data);
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
        inventoryUpdatedPage.validateChangedReasonCodes(rfi_Data.getProductsToScan(), "XC");
    }


   /*
                              Test Name                                        :  itemNotUsedForSecondChance
                              Test Description                              :  Verifying item used for second chance pop up choose no option and verify QOD update.
                              Scenario tested                                :  <Choose No for item used for second>
                              Story id                                              :  <N/A>
                              Epic id                                                : <N/A>
                              Test data                                           : < (data dependent) >
                              API tested                                         : <APIs tested as part of this flow>
                              UI screen tested                              : <N/A>
                              */

@Test(groups = "e2e")
    public void itemNotUsedForSecondChance() throws Exception {
        outdatedPage.clickOutdated();
        enterUPCPopUpPage.setFlowType("Outdated");
        enterUPCPopUpPage.setFlowAction("NotUsedForSecondChance");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
       /* enterAmountPage.validateAlertPopUp(rfi_Data.getMessageTitle());
        enterAmountPage.clickNoSecondChance();*/
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
       /*
                              Test Name                                        :  theftReasonCode
                              Test Description                              :  Verifying QOD update.
                              Scenario tested                                :  <Scan products in theft reason code and verify QOD update>
                              Story id                                              :  <N/A>
                              Epic id                                                : <N/A>
                              Test data                                           : < (data dependent) >
                              API tested                                         : <APIs tested as part of this flow>
                              UI screen tested                              : <N/A>
                              */

 @Test(groups="e2e")
    public void theftReasonCode() throws Exception {
        outdatedPage.clickTheftAndValidate();
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }

    /*
                               Test Name                                        :  reclaimCorpBrandMarkdown
                               Test Description                              :  Verifying corp brands: Markdown and QOD should not be updated.
                               Scenario tested                                :  <Corp Brand Markdown is validated and No change in QOD is verified>
                               Story id                                              :  <N/A>
                               Epic id                                                : <N/A>
                               Test data                                           : < (data dependent) >
                               API tested                                         : <APIs tested as part of this flow>
                               UI screen tested                              : <N/A>
                               */
 @Test(groups="e2e")
    public void reclaimCorpBrandMarkdown() throws Exception {
        reclaimPage.clickReclaim();
        enterUPCPopUpPage.setFlowType("Reclaim");
        enterUPCPopUpPage.setFlowAction("Markdown");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        // reviewScreenPage.clickSubmitButton();
        // inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.setFlowType("Reclaim");
        inventoryUpdatedPage.setFlowAction("Markdown");
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
    /*
                                Test Name                                        :  reclaimCorpBrandDiscard
                                Test Description                              :  Verifying corp brands: Discard and QOD should be updated.
                                Scenario tested                                :  <Corp Brand Discard is verified in DR reason code and validated QOD change>
                                Story id                                              :  <N/A>
                                Epic id                                                : <N/A>
                                Test data                                           : < (data dependent) >
                                API tested                                         : <APIs tested as part of this flow>
                                UI screen tested                              : <N/A>
                                */
@Test(groups="e2e")
    public void reclaimCorpBrandDiscard() throws SQLException, IOException, URISyntaxException {
        reclaimPage.clickReclaim();
        enterUPCPopUpPage.setFlowType("Reclaim");
        enterUPCPopUpPage.setFlowAction("Discard");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
       /*
                               Test Name                                        :  reclaimCorpBrandDonate
                               Test Description                              :  Verifying corp brands: Donate and verify QOD update and Reason code change to DN.
                               Scenario tested                                :  <Reclaim Donate>
                               Story id                                              :  <N/A>
                               Epic id                                                : <N/A>
                               Test data                                           : < (data dependent) >
                               API tested                                         : <APIs tested as part of this flow>
                               UI screen tested                              : <N/A>
                               Additional Comments: This test fails as Changed Reason Code is not updated to DN, please refer https://jira.kroger.com/jira/browse/ISPART-21152?filter=-2
                               */


//@Test(groups="e2e")
    public void reclaimCorpBrandDonate() throws Exception {
        DBHelper dbHelper = new DBHelper();
        reclaimPage.clickReclaim();
        enterUPCPopUpPage.setFlowType("Reclaim");
        enterUPCPopUpPage.setFlowAction("Donate");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        inventoryUpdatedPage.setRfiJobId(login_Data);
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
        inventoryUpdatedPage.validateChangedReasonCodes(rfi_Data.getProductsToScan(), "DN");
    }
       /*
                               Test Name                                        :  donationLeakingItem
                               Test Description                              :  Verifying donation reason code and QOD update.
                               Scenario tested                                :  <Reason Code: DN, verify QOD>
                               Story id                                              :  <N/A>
                               Epic id                                                : <N/A>
                               Test data                                           : < (data dependent) >
                               API tested                                         : <APIs tested as part of this flow>
                               UI screen tested                              : <N/A>
                               */

    //ReasonCode-DN
@Test(groups="e2e")
    public void donationLeakingItem() throws IOException, URISyntaxException, SQLException {
        donationPage.clickDonationBtnAndValidate();
        enterUPCPopUpPage.setFlowType("Donation");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
       /*
                               Test Name                                        : recallYes
                               Test Description                              :  Verify recall reason code and QOD update.
                               Scenario tested                                :  <Business use case of the scenarios tested>
                               Story id                                              :  <N/A>
                               Epic id                                                : <N/A>
                               Test data                                           : < (data dependent) >
                               API tested                                         : <APIs tested as part of this flow>
                               UI screen tested                              : <N/A>
                               */

 @Test(groups = "e2e")
    public void recallYes() throws IOException, URISyntaxException, SQLException {
        recallPage.clickRecallBtnAndValidate();
        enterUPCPopUpPage.setFlowType("Recall");
        enterUPCPopUpPage.enterOrScanUpcs(rfi_Data, Symbology.UPC_A);
        enterAmountPage.clickReviewButton();
        reviewScreenPage.setProp(prop);
        countQODListBefore = reviewScreenPage.getQodValues(rfi_Data.getProductsToScan());
        reviewScreenPage.clickSubmitButton();
        inventoryUpdatedPage.setProp(prop);
        inventoryUpdatedPage.waitForBackToMainMenuButton();
        inventoryUpdatedPage.validateQodBucket(login_Data, rfi_Data, countQODListBefore);
    }
}
