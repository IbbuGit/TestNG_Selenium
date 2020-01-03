package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;

import com.krogerqa.appium.product_locator_app.backroom_count.dataBeans.Backroom_Count_TestDataBean;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.ScanProductBRCPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.dataBeans.Remove_From_Inventory_TestDataBean;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Random;

public class ScanproductBRCPage {
    private MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();
    UnSubmittedCountPage unSubmittedCountPage;
    private Random random = new Random();
    private ScanProductBRCPageMap scanProductBRCPageMap;
    private ScanProductPage scanProductPage;
    ReviewCountPage reviewCountPage;
    CountProductPage countProductPage;

    private String[] multipleUPCs;
    private int min = 0;

    public ScanproductBRCPage() {
        scanProductBRCPageMap = new ScanProductBRCPageMap();
        countProductPage = new CountProductPage();
        reviewCountPage = new ReviewCountPage();
        unSubmittedCountPage = new UnSubmittedCountPage();
        scanProductPage = new ScanProductPage();
    }

    public void clickEnterUPC(boolean firstTime) {
        if(firstTime) {
            clickEnterUPC();
        }else {
            clickReEnterUPC();
        }
    }

    /*
     *   To click Enter UPC button
     */
    public void clickEnterUPC() {
        mobileCommands.click(scanProductBRCPageMap.btnEnterUPC());
    }

    /*
     *   To enter UPC
     */
    public void enterUPC(String manualUPC) {
        mobileCommands.enterText(scanProductBRCPageMap.enterUPC(), manualUPC, true);
    }

    /*
     *   To click Enter UPC button
     */
    public void clickReEnterUPC() {
        mobileCommands.click(scanProductBRCPageMap.btnReEnterUPC());
    }

    /*
     *   To Click Submit button
     */
    public void clickSubmit() {
        mobileCommands.click(scanProductBRCPageMap.btnSubmit());

    }

    /*
     *   To validate scan product page title
     */
    public void validateScanProductTitle(String scanProduct) {
        mobileCommands.assertElementDisplayed(scanProductBRCPageMap.headerScanProd(), true);
        mobileCommands.assertElementText(scanProductBRCPageMap.headerScanProd(), scanProduct, true);
    }

    /*
     *   To validate enter UPC page title
     */
    public void validateEnterUPCTitle(String enterUPC) {
        mobileCommands.assertElementDisplayed(scanProductBRCPageMap.headerEnterUPC(), true);
        mobileCommands.assertElementText(scanProductBRCPageMap.headerEnterUPC(), enterUPC, true);
    }

    /*
     *   To validate Scan text
     */
    public void validateScanText() {
        mobileCommands.assertElementDisplayed(scanProductBRCPageMap.txtScanProd(), true);
    }

    /*
     *   To validate Cancel button
     */
    public void validateCancelButton() {
        mobileCommands.assertElementDisplayed(scanProductBRCPageMap.btnCancel(), true);
    }

    public void validateEnterUPCButton(String lblEnterUPCBtn) {
        mobileCommands.waitForElement(scanProductBRCPageMap.btnEnterUPC());
        mobileCommands.assertElementText(scanProductBRCPageMap.btnEnterUPC(), lblEnterUPCBtn, true);
    }

    public void waitForEnterUPCButton() {
        mobileCommands.waitForElement(scanProductBRCPageMap.btnEnterUPC());
    }

    public void validateUnauthorizedDSDMsg(String msgUnauthorizedDSD) {
        mobileCommands.assertElementText(scanProductBRCPageMap.lblUnauthorizedDSDMsg(), msgUnauthorizedDSD, true);
    }

    public void clickBackBtn() {
        mobileCommands.click(scanProductBRCPageMap.btnBack());

    }

    public void waitEnterUPC() {
        mobileCommands.waitForElementClickability(scanProductBRCPageMap.btnEnterUPC());
    }

    public void waitForReEnterUPC() {

        if (BaseUtil.isElementPresent(scanProductBRCPageMap.btnEnterUPC(), 3)) {

            mobileCommands.waitForElementVisibility(scanProductBRCPageMap.btnEnterUPC());
        } else {
            mobileCommands.waitForElementVisibility(scanProductBRCPageMap.btnReEnterUPC());
        }

    }


    public void handleUPCError() {
        try {
            if (mobileCommands.isElementExist(scanProductBRCPageMap.enterUPCError())) {
                mobileCommands.click(scanProductBRCPageMap.btnCancel());
            }
        } catch (Exception e) {

        }
    }

    public void validateWrngAltTitle(String somethingWentWrongTitle) {
        mobileCommands.assertElementText(scanProductBRCPageMap.alertTitle(), somethingWentWrongTitle, true);
    }

    public void validateProceedAltTitle(String unableToProceedAlertTitle) {
        mobileCommands.assertElementText(scanProductBRCPageMap.alertTitle(), unableToProceedAlertTitle, true);
    }

    public void clickTryAgainButton() {
        mobileCommands.click(scanProductBRCPageMap.tryAgainButton());
    }

    public void clickExitTaskButton() {
        mobileCommands.click(scanProductBRCPageMap.exitTaskButton());
    }

    public void scanmultipleProducts(Backroom_Count_TestDataBean bc_Data) throws InterruptedException, IOException {
        unSubmittedCountPage.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int currentIterationNo = multipleUPCs.length - 1;
        for (String currentUPC : multipleUPCs) {
            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                waitForEnterUPCButton();
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
            } else {
                clickEnterUPC();
                enterUPC(currentUPC);
                clickSubmit();
            }

            countProductPage.clickReview();
            if (currentIterationNo > 0) {
                reviewCountPage.clickAddMore(currentIterationNo--);
            }

        }
    }

    public void validateMagicItemErrorMessage(String alertMessage) {
        mobileCommands.assertElementText(scanProductBRCPageMap.magicItemErrorMessage(), alertMessage, true);
    }
}