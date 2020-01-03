package com.krogerqa.appium.product_locator_app.common.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.maps.LogInMap;
import com.krogerqa.appium.product_locator_app.common.ui.maps.LogOutPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;

import java.util.HashMap;

public class LogOutPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private LogOutPageMap logOutPageMap;
    CommonPageMap commonPageMap ;
    LogInMap loginMap;

    public LogOutPage() {
        logOutPageMap = new LogOutPageMap();
        commonPageMap = new CommonPageMap();
        loginMap = new LogInMap();
    }

    public void loggedOut(boolean found) {
        if(BaseUtil.isElementPresent(commonPageMap.kebabMenu(),3)) {
            mobileCommands.click(commonPageMap.kebabMenu());
            mobileCommands.click(logOutPageMap.signOutButton());
            HashMap<By, String> elements = new HashMap<>();
            elements.put(loginMap.secureWEBPageTitle(), "LoginPage");
            elements.put(logOutPageMap.signOutDialogExit(), "PopUpExit");
            String visibleElement = BaseUtil.getVisibleElementFromListOfWebElement(mobileCommands.getWebDriver(), elements);
            if (visibleElement.equals("PopUpExit")) {
                mobileCommands.click(logOutPageMap.signOutDialogExit());
            }
            new LogInPage().validateSecureWEBPageTitle();
        }
    }

    public void validateUnSubmittedTransferAlertTitle(String title) {
        mobileCommands.assertElementText(logOutPageMap.unSubmittedTransferAlertTitle(), title, true);
    }
}