package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.KebabMenuOptionsPage;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.UnSubmittedCountPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidateKebabMenuOptions extends Base {
    private UnSubmittedCountPage unSubmittedCount;
    private KebabMenuOptionsPage kebabMenuOptionsPage;
    private CommonPage commonPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        unSubmittedCount = new UnSubmittedCountPage();
        kebabMenuOptionsPage = new KebabMenuOptionsPage();
        commonPage = new CommonPage();
    }

    /*
     * Test Name            :   validateKebabMenuOptionsInScanProduct
     * Test Description     :   Verifying kebab menu options for the scan product screen.
     * Scenario tested      :   1.The user clicks the kebab menu in scan product screen
     *                          2.verifies backroom tutorial and clicks next button in the tutorial
     *                          3.verifies FAQ
     *                          4.verifies About
     * Story id             :   8741
     * Epic id              :
     * Test data            :   data dependent
     * API tested           :
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(groups = "regression")
    public void validateKebabMenuOptionsInScanProduct() {
        unSubmittedCount.clickNewCount();
        kebabMenuOptionsPage.clickKebabMenuIcon();
        kebabMenuOptionsPage.clickBackroomTutorial();
        kebabMenuOptionsPage.ClickNextBtn();
        kebabMenuOptionsPage.ClickNextBtn();
        kebabMenuOptionsPage.ClickNextBtn();
        kebabMenuOptionsPage.clickKebabMenuIcon();
        kebabMenuOptionsPage.clickFAQBtn();
        kebabMenuOptionsPage.clickFAQBackroomBtn();
        kebabMenuOptionsPage.clickFAQBackArrow();
        commonPage.clickBackArrowButton();
        kebabMenuOptionsPage.clickKebabMenuIcon();
        kebabMenuOptionsPage.clickAbout();
        commonPage.clickBackArrowButton();
    }
}

