package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.UnSubmittedCountMap;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.DbMethods;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import org.testng.annotations.Test;

public class ValidateBrcScanningTips extends Base {
    private CountProductPage countProductPage = new CountProductPage();
    private ScanproductBRCPage scanproductBRCPage = new ScanproductBRCPage();
    private ReviewCountPage reviewCountPage = new ReviewCountPage();
    private ThankyouBRCPage thankyouBRCPage = new ThankyouBRCPage();
    private TaskListPage taskListPage = new TaskListPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private String[] multiUPCs;
    CommonPage commonPage = new CommonPage();
    TutorialPage tutorialPage = new TutorialPage();
    UnSubmittedCountMap unSubmittedCountMap = new UnSubmittedCountMap();
    DbMethods dbMethods = new DbMethods();


    @Test(groups = {"regression", "satart-812", "satart-1949"})
    void validateScanningTips() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String upcText = bc_Data.getProductToScan().split("@")[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        commonPage.backAndroidButton();
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
    }


    @Test(groups = {"regression", "satart-812"})
    void validateScanningTipsSameUPC() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String upcText = bc_Data.getProductToScan().split("@")[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }

    @Test(groups = {"regression", "satart-812"})
    void validateScanningTipsDifferentUPC() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String[] UPC = bc_Data.getProductToScan().split("@");
        String upcText = UPC[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }

    @Test(groups = {"regression", "satart-812"})
    void validateScanningTipsAfterScanningUnauthorizedUPC() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String[] UPC = bc_Data.getProductToScan().split("@");
        String[] MSG = bc_Data.getUnauthorizedDSDMsg().split("@");
        for (int i = 0; i <= 3; i++) {
            scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
            scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        }
        String upcText = UPC[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        scanProductPage.scanProduct(UPC[3], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }

    @Test(groups = {"regression", "satart-812"})
    void validateScanningTipsAfterScanningDSDUPC() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String[] UPC = bc_Data.getProductToScan().split("@");
        String[] MSG = bc_Data.getUnauthorizedDSDMsg().split("@");
        for (int i = 0; i <= 3; i++) {
            scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
            scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        }
        String upcText = UPC[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        scanProductPage.scanProduct(UPC[3], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }

    @Test(groups = {"regression", "satart-8121"})
    void validateScanningTipsAfterScanningMagicUPC() throws Throwable {
        String[] UPC = bc_Data.getProductToScan().split("@");
        String[] MSG = bc_Data.getUnauthorizedDSDMsg().split("@");
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        dbMethods.getItemStoreInfo(UPC[0]);
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        for (int i = 0; i <= 3; i++) {
            scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
            scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        }
        String upcText = UPC[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        scanProductPage.scanProduct(UPC[3], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }


    @Test(groups = {"regression", "satart-812"})
    void validateScanningTipsAfterScanningMultipleUPCS() throws Throwable {
        String[] UPC = bc_Data.getProductToScan().split("@");
        String[] MSG = bc_Data.getUnauthorizedDSDMsg().split("@");
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        dbMethods.getItemStoreInfo(UPC[2]);
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        scanProductPage.scanProduct(UPC[1], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        String upcText = bc_Data.getProductToScan().split("@")[3];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        countProductPage.clickContinueButton();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[4], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        scanProductPage.scanProduct(UPC[1], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        scanProductPage.scanProduct(UPC[5], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }


    @Test(groups = {"satart-1949"})
    void validateScanningTipsEnableAndroidBack() throws Throwable {
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        String upcText = bc_Data.getProductToScan().split("@")[1];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        commonPage.backAndroidButton();
        countProductPage.verifyScanningTipsTextDisabled();
        countProductPage.verifyUpcIsDisplayed(upcText);
    }

    @Test(groups = {"satart-1949"})
    void validateScanningTipsAfterScanningMultipleUPCSForEnableAndroidBack() throws Throwable {
        String[] UPC = bc_Data.getProductToScan().split("@");
        String[] MSG = bc_Data.getUnauthorizedDSDMsg().split("@");
        if (BaseUtil.isElementPresent(unSubmittedCountMap.alertTitle(), 3)) {
            mobileCommands.click(unSubmittedCountMap.btnNewCount());
        }
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        dbMethods.deleteWalkThroughUsers(login_Data.getUsername());
        dbMethods.getItemStoreInfo(UPC[2]);
        commonPage.clickBackArrow();
        taskListPage.clickBackroomCount();
        tutorialPage.clickNext();
        tutorialPage.clickNext();
        tutorialPage.clickGotIt();
        scanproductBRCPage.validateScanProductTitle(bc_Data.getScanProductScreen());
        scanproductBRCPage.validateScanText();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        scanProductPage.scanProduct(UPC[1], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        String upcText = bc_Data.getProductToScan().split("@")[3];
        scanProductPage.scanProduct(upcText, Symbology.UPC_A);
        countProductPage.verifyScanningTipsTextEnabled();
        commonPage.backAndroidButton();
        countProductPage.verifyScanningTipsTextDisabled();
        countProductPage.verifyUpcIsDisplayed(upcText);
        scanProductPage.scanProduct(UPC[4], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        scanProductPage.scanProduct(UPC[0], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[0]);
        scanProductPage.scanProduct(UPC[1], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[1]);
        scanProductPage.scanProduct(UPC[2], Symbology.UPC_A);
        scanproductBRCPage.validateUnauthorizedDSDMsg(MSG[2]);
        scanProductPage.scanProduct(UPC[5], Symbology.UPC_A);
        scanproductBRCPage.waitForReEnterUPC();
        countProductPage.validateScanningTipsText();
    }
}