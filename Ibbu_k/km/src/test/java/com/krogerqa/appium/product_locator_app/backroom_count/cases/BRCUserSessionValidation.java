package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class BRCUserSessionValidation extends Base {
    //private String[] multipleUPCs;
    private MainMenuPage mainMenuPage;
    private CountProductPage countProductPage;
    private ScanproductBRCPage scanproductBRCPage;
    private ReviewCountPage reviewCountPage;
    private ScanProductPage scanProductPage;
    private UnSubmittedCountPage unSubmittedCount;
    private LogOutPage logOutPage;
    private LogInPage logInPage;
    private CommonPage commonPage;
    private String[] multiUPCs;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        mainMenuPage = new MainMenuPage();
        scanproductBRCPage = new ScanproductBRCPage();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        scanProductPage = new ScanProductPage();
        unSubmittedCount = new UnSubmittedCountPage();
        logOutPage = new LogOutPage();
        logInPage = new LogInPage();
        commonPage = new CommonPage();
    }

    /*
     * Test Name            :   userSessionValidation
     * Test Description     :   Verifying user session validations.
     * Scenario tested      :   1.The user1 scans the products
     *                          2.clicks review button in count product screen
     *                          3.user1 logs out with unsubmitted count
     *                          4.user2 signs in and scans the products
     *                          5.clicks review button in count product screen
     *                          6.clicks submit button in review screen
     *                          7.user2 logs out after submitting the count
     *                          8.user1 signs in again
     *                          9.validate unsubmitted count pop up and click continue button
     *                          10.clicks submit button in review screen
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void userSessionValidation() throws Throwable {
        unSubmittedCount.clickNewCount();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        for (String UPC : multiUPCs) {
            scanProductPage.scanProduct(UPC, Symbology.UPC_A);
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        commonPage.clickKebabMenu();
        logOutPage.loggedOut(false);

        logInPage.validateSecureWEBPageTitle();
        logInPage.enterUserID(bc_Data.getSecondUserName());
        logInPage.enterPassword(bc_Data.getSecondPassword());
        logInPage.clickSignInButton();
        mainMenuPage.clickBackroomCount();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanproductBRCPage.waitEnterUPC();
        multiUPCs = bc_Data.getProductToScan().split("@");
        for (String UPC : multiUPCs) {
            scanProductPage.scanProduct(UPC, Symbology.UPC_A);
            scanproductBRCPage.waitForReEnterUPC();
        }
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        commonPage.clickKebabMenu();
        logOutPage.loggedOut(false);
        logInPage.login(login_Data.getUsername(), login_Data.getPassword());
        mainMenuPage.clickBackroomCount();
        unSubmittedCount.clickUnSubmittedContinueBtn();
        reviewCountPage.clickSubmit();
    }
}





