package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.maps.LogInMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockKababMenuPageMap;
import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockScanProductPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;

import java.util.HashMap;

public class TopStockKababMenuPage extends Base {

    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();
    LogInMap loginMap = new LogInMap();

    TopStockScanProductPageMap topStockScanProductPageMap = new TopStockScanProductPageMap();

    TopStockKababMenuPageMap kebabMenuPageMap;

    public TopStockKababMenuPage() {
        kebabMenuPageMap = new TopStockKababMenuPageMap();
    }

    public void clickKebabMenuIcon() {
        mobileCommands.click(kebabMenuPageMap.kebabMenu());
    }

    public void clickTutorialKebabMenu() {
        mobileCommands.click(kebabMenuPageMap.kebabTopStockTutorialMenu());
    }

    public void clickFAQKababMenu() {
        mobileCommands.waitForElement(kebabMenuPageMap.kebabFAQMenu());
        mobileCommands.click(kebabMenuPageMap.kebabFAQMenu());
    }

    public void clickFeedbackKababMenu() {
        mobileCommands.click(kebabMenuPageMap.kebabFeedbackMenu());
    }

    public void validateSignOutKebabMenu() {
        mobileCommands.elementDisplayed(kebabMenuPageMap.kebabSignOutMenu());
    }

    public void clickSignOutButton() {
        mobileCommands.click(kebabMenuPageMap.kebabSignOutBtn());
    }

    public void clickAboutButton() {
        mobileCommands.click(kebabMenuPageMap.KebabAboutBtn());
    }

    public void lblAbout() {
        kebabMenuPageMap.kebabAboutText();
    }

    // #################################TUTORIAL PAGE #######
    public void ValidateTutorialTitle(String TutorialTitleMsg) {
        mobileCommands.assertElementText(kebabMenuPageMap.TutorialTitleMsg(), TutorialTitleMsg, true);
    }

    public void ValidateTutorialDescription(String TutorialDescMsg) {
        mobileCommands.assertElementText(kebabMenuPageMap.TutorialDescriptionMsg(), TutorialDescMsg, true);
    }

    public void clickNextBtn() {
        mobileCommands.waitForElement(kebabMenuPageMap.btnNext());
        mobileCommands.click(kebabMenuPageMap.btnNext());
    }

    public void clickBackBtn() {
        mobileCommands.waitForElement(kebabMenuPageMap.btnBack());
        mobileCommands.click(kebabMenuPageMap.btnBack());
    }

    public void fAQTopStockBtn() {
        mobileCommands.click(kebabMenuPageMap.fAQTopStockBtn());
    }

    public void fAQBackArrow() {
        mobileCommands.click(kebabMenuPageMap.fAQBackArrow());
    }

    public void clickTutorialGotIt() {
        mobileCommands.assertElementDisplayed(kebabMenuPageMap.tutorialGotIt(), true);
        mobileCommands.click(kebabMenuPageMap.tutorialGotIt());
    }

    public void validateTutorialScreen() throws Throwable {
        clickKebabMenuIcon();
        clickTutorialKebabMenu();
        clickNextBtn();
        clickNextBtn();
        clickTutorialGotIt();
    }

    public void validateFAQsScreen() throws Throwable {
        clickKebabMenuIcon();
        clickFAQKababMenu();
        fAQTopStockBtn();
        fAQBackArrow();
        fAQBackArrow();
    }

    public void validateAbout() throws Throwable {
        commonPage.clickKebabMenu();
        commonPage.clickAbout();
        lblAbout();
    }

    public void verifyScanProductOnTSTutorialHdr(String scanProductOnTSTutorialHdr) {
        mobileCommands.assertElementText(kebabMenuPageMap.scanProductOnTSHdr(), scanProductOnTSTutorialHdr, true);
    }

    public void verifyScanProductOnTSTutorialDesc(String scanProductOnTSTutorialDesc) {
        mobileCommands.assertElementText(kebabMenuPageMap.scanProductOnTSDes(), scanProductOnTSTutorialDesc, true);
    }

    public void signOutWithOutPopup() {
        if (BaseUtil.isElementPresent(kebabMenuPageMap.kebabMenu(), 3)) {
            mobileCommands.click(kebabMenuPageMap.kebabMenu());
            mobileCommands.click(kebabMenuPageMap.kebabSignOutBtn());
            new LogInPage().validateSecureWEBPageTitle();
        }
    }

    public void loggedOut(boolean found) {
        if (BaseUtil.isElementPresent(kebabMenuPageMap.kebabMenu(), 3)) {
            mobileCommands.click(kebabMenuPageMap.kebabMenu());
            mobileCommands.click(kebabMenuPageMap.kebabSignOutBtn());
            HashMap<By, String> elements = new HashMap<>();
            elements.put(loginMap.secureWEBPageTitle(), "LoginPage");
            elements.put(kebabMenuPageMap.signOutExitBtn(), "TopStockExit");
            String visibleElement = BaseUtil.getVisibleElementFromListOfWebElement(mobileCommands.getWebDriver(), elements);
            if (visibleElement.equals("TopStockExit")) {
                mobileCommands.click(kebabMenuPageMap.signOutExitBtn());
            }
            new LogInPage().validateSecureWEBPageTitle();
        }
    }

    public void verifyScanHeaderAndClickBackArrow() {
        if (BaseUtil.isElementPresent(topStockScanProductPageMap.ScanProduct(), 2)) {
        }
    }
}
