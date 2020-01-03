package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.KebabMenuPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class KebabMenuPage {
    MobileCommands mobileCommands = new MobileCommands();
    KebabMenuPageMap kebabMenuPageMap;

    CommonPage commonPage = new CommonPage();

    public KebabMenuPage() {
        kebabMenuPageMap = new KebabMenuPageMap();
    }

    public void clickKebabMenuIcon() {
        mobileCommands.wait(5); //Due to the Toast message in Collect product page
        mobileCommands.click(kebabMenuPageMap.kebabMenu());
    }

    public void clickDRTutorial() {
        mobileCommands.click(kebabMenuPageMap.drTutorialBtn());
    }

    public void clickDR_FAQBtn() {
        mobileCommands.waitForElement(kebabMenuPageMap.drFaqBtn());
        mobileCommands.click(kebabMenuPageMap.drFaqBtn());
    }

    public void clickNextBtn() {
        mobileCommands.click(kebabMenuPageMap.drTutorialNextBtn());
    }

    public void clickBackArrow() {
        mobileCommands.click(kebabMenuPageMap.drFaqBackArrow());
    }

    public void clickTutorialGotItBtn() {
        mobileCommands.assertElementDisplayed(kebabMenuPageMap.drTutorialGotIt(), true);
        mobileCommands.click(kebabMenuPageMap.drTutorialGotIt());
    }

    public void lblAbout() {
        kebabMenuPageMap.drKebabAboutText();
    }

    public void clickFAQDrBtn() {
        mobileCommands.click(kebabMenuPageMap.fAQDrBtn());
    }

    public void validateTutorialPage() {
        clickKebabMenuIcon();
        clickDRTutorial();
        clickNextBtn();
        clickNextBtn();
        clickNextBtn();
        clickNextBtn();
        clickTutorialGotItBtn();
    }

    public void validateFaqScreen() {
        clickKebabMenuIcon();
        clickDR_FAQBtn();
        clickFAQDrBtn();
        clickBackArrow();
        clickBackArrow();
    }

    public void validateAboutScreen() {
        commonPage.clickKebabMenu();
        commonPage.clickAbout();
        lblAbout();
        clickBackArrow();
    }

    public void verifyDRTutorialHdr(String drTutorialHdr) {
        mobileCommands.assertElementText(kebabMenuPageMap.locateProductDRHdr(), drTutorialHdr, true);
    }

    public boolean verifyDRTutorialHdr() {
        return BaseUtil.isElementPresent(kebabMenuPageMap.locateProductDRHdr(),3);
    }

    public void verifyDRTutorialDesc(String drTutorialDesc) {
        mobileCommands.assertElementText(kebabMenuPageMap.locateProductDRDes(), drTutorialDesc, true);
    }


    public static boolean isElementFoundNoException(WebDriver driverTemp, By element) {
        boolean Found = false;
        try {
            Found = driverTemp.findElement(element).isDisplayed();
        } catch (Exception ignored) {
        }
        return Found;
    }

    public static String getVisibleElementFromListOfWebElement(WebDriver driverTemp, HashMap<By, String> listOfElement) {

        driverTemp.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String foundElement = "";

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (elapsedTime < 20 * 1000 && foundElement.isEmpty()) {
            for (By key : listOfElement.keySet()) {
                if (isElementFoundNoException(driverTemp, key)) {
                    foundElement = listOfElement.get(key);
                }
            }
            elapsedTime = (new Date()).getTime() - startTime;
        }

        driverTemp.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return foundElement;
    }

    public void loggedOut() {
        if (BaseUtil.isElementPresent(kebabMenuPageMap.kebabMenu(), 3)) {
            mobileCommands.click(kebabMenuPageMap.kebabMenu());
            mobileCommands.click(kebabMenuPageMap.drSignOutBtn());
            HashMap<By, String> elements = new HashMap<>();
            //elements.put(loginMap.secureWEBPageTitle(), "LoginPage");
            elements.put(kebabMenuPageMap.btnSignOut(), "PopUpExit");
            String visibleElement = getVisibleElementFromListOfWebElement(mobileCommands.getWebDriver(), elements);
            if (visibleElement.equals("PopUpExit")) {
                mobileCommands.click(kebabMenuPageMap.btnSignOut());
            } else {
                new LogInPage().validateSecureWEBPageTitle();
            }

        }
    }

}
