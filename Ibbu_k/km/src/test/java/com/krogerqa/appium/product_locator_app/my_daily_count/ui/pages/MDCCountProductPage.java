package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.MDCCountProductMap;

import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.commons.lang3.RandomUtils;
import net.minidev.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class MDCCountProductPage {

    CommonPage commonPage = new CommonPage();
    MobileCommands mobileCommands = new MobileCommands();


    MDCCountProductMap mdcCountProductMap;


    public MDCCountProductPage() {
        mdcCountProductMap = new MDCCountProductMap();

    }

    public void validateCountProductPageTitle(String countProductTitle) {

        mobileCommands.assertElementText(mdcCountProductMap.countProductPageTitle(), countProductTitle, true);
    }

    public void clickOnProductImageIcon() {
        mobileCommands.click(mdcCountProductMap.imageIcon());
    }


    public void validateEnlargeImage() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.enlargedImage(), true);
    }

    public void closeImage() {
        mobileCommands.click(mdcCountProductMap.closeImage());
    }


    public void clickMDCNextButton() {
        mobileCommands.click(mdcCountProductMap.countSubmitBtn());
    }


    public void verifyCaseSize() {
        Assert.assertTrue(commonPage.isElementVisible(mdcCountProductMap.caseSize()));
    }

    public void clickOnNextButton() {
        mobileCommands.click(mdcCountProductMap.countSubmitBtn());
    }

    public void validateUPC() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.upcOnCountProductScreen(), true);
    }

    public void validateProductDescription() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.productDescriptionOnCountProductScreen(), true);
    }


    public void validateAlertMessage(String alertMessage) {
        Assert.assertTrue(mobileCommands.getElementText(mdcCountProductMap.alertMessage()).contains(alertMessage));
    }

    public void validateProductProce() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.productPrice(), true);
    }

    public void validateUnitCountText() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.unitCountText(), true);
    }

    public void verifyThresholdValueError(String thresholdErrorMessage) {
        mobileCommands.assertElementText(mdcCountProductMap.inLineErrorMessage(), thresholdErrorMessage, true);
    }

    public void clickOnEnterQuantityTextField() {
        mobileCommands.click(mdcCountProductMap.enterQuantityTextField());
    }

    public void enterQuantity() {
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), RandomUtils.nextInt(0, 9999), true);
        boolean isCalDisplayed = true;
        do {
            mobileCommands.tapByCoordinates(430, 770);
            // mobileCommands.tapByCoordinates(690, 1130);
            try {
                mobileCommands.isElementExist(mdcCountProductMap.countSubmitBtn());
                isCalDisplayed = false;
            } catch (TimeoutException timeoutException) {
                //isCalDisplayed = true;
            }
        } while (isCalDisplayed);
    }

    public void enterThresholdValue() {
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), 55555, true);
    }

    public void enterUnitCount() {
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), RandomUtils.nextInt(0, 9999), true);

        commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
        mobileCommands.tapByCoordinates(690, 1130);
    }


    public void submitUnitCount() {
        mobileCommands.tapByCoordinates(690, 1130);
    }

    public void verifyEnabledButtonCountEntry() {
        mobileCommands.assertElementEnabled(mdcCountProductMap.countSubmitBtn(), true);
    }

    public void verifyDisabledButtonCountEntry() {
        mobileCommands.assertElementEnabled(mdcCountProductMap.countSubmitBtn(), false);
    }


    public void clickOnSubmitCountButton() {
        mobileCommands.click(mdcCountProductMap.countSubmitBtn());
    }


    public void swipeAndEnterUnitCount() {
        commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), RandomUtils.nextInt(0, 9999), true);
        mobileCommands.tapByCoordinates(690, 1130);
    }

    public void waitAndClickNextButton() throws InterruptedException, IOException {
        mobileCommands.waitForElementClickability(mdcCountProductMap.countSubmitBtn());
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), RandomUtils.nextInt(0, 9999), true);
        mobileCommands.tapByCoordinates(430, 770);
        clickMDCNextButton();
    }


    public void verifySnackBarText() throws Throwable {
        mobileCommands.assertElementEnabled(mdcCountProductMap.snackBarText(), true);
        mobileCommands.waitForElementInvisible(By.id("snackbar_text"));
    }

    public void validateWrngAltTitle(String somethingWentWrongTitle) {
        mobileCommands.assertElementText(mdcCountProductMap.alertTitle(), somethingWentWrongTitle, true);
    }

    public void validateProceedAltTitle(String unableToProceedAlertTitle) {
        mobileCommands.assertElementText(mdcCountProductMap.alertTitle(), unableToProceedAlertTitle, true);
    }

    public void clickTryAgainButton() {
        mobileCommands.click(mdcCountProductMap.tryAgainButton());
    }

    public void clickAlertButton() {
        mobileCommands.click(mdcCountProductMap.alertButton());
    }


    public void submitButtonVisibility() {
        mobileCommands.assertElementDisplayed(mdcCountProductMap.countSubmitBtn(), true);

    }

    public void clickExitTaskButton() {
        mobileCommands.click(mdcCountProductMap.exitTaskButton());
    }

    public void caseSizeVisibility() {
        WebDriver driver = mobileCommands.getWebDriver();
        if ((driver.findElements(mdcCountProductMap.caseSize()).size()) == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void enterQuantity(String quantity) {
        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), quantity, true);
        boolean isCalDisplayed = true;
        do {
            mobileCommands.tapByCoordinates(690, 1130);
            try {
                mobileCommands.isElementExist(mdcCountProductMap.countSubmitBtn());
                isCalDisplayed = false;
            } catch (TimeoutException timeoutException) {
                //isCalDisplayed = true;
            }
        } while (isCalDisplayed);
    }
}
