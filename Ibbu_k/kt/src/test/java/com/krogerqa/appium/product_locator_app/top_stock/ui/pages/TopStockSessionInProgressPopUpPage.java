package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockSessionInProgressMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class TopStockSessionInProgressPopUpPage {
    MobileCommands mobileCommands = new MobileCommands();
    TopStockSessionInProgressMap sessionProgressPageMap;

    public TopStockSessionInProgressPopUpPage() {
        sessionProgressPageMap = new TopStockSessionInProgressMap();
    }

    public void clickOnContinue() {
        mobileCommands.click(sessionProgressPageMap.continueSession());
    }

    public void clickOnNewSession() {
        mobileCommands.click(sessionProgressPageMap.newSession());
    }

    public void clickOnExit() {
        mobileCommands.click(sessionProgressPageMap.exit());
    }

    public void clickOnCancel() {
        mobileCommands.click(sessionProgressPageMap.cancel());
    }

    public void verifySessionInProgressHdr(String sessionInProgressHdrTxt) {
        mobileCommands.assertElementText(sessionProgressPageMap.sessionInProgressHdr(), sessionInProgressHdrTxt, true);
    }

    public void verifyExitPopupTitle(String exitPopupTitle) {
        mobileCommands.assertElementText(sessionProgressPageMap.SessionPopupTitle(), exitPopupTitle, true);
    }
}