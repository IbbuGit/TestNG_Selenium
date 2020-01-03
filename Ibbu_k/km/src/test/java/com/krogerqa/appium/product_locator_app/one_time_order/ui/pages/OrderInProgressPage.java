package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.OrderInProgressMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class OrderInProgressPage {
    MobileCommands mobileCommands = new MobileCommands();
    OrderInProgressMap orderInProgressMap = new OrderInProgressMap();

    public void validateOrderInProgressTitle(String titleOrderInProgress) {
        mobileCommands.assertElementText(orderInProgressMap.titleOrderInProgress(), titleOrderInProgress, true);
    }

    public void validateOrderInProgressMsg(String msgDailog) {
        mobileCommands.assertElementText(orderInProgressMap.msgOrderInProgress(), msgDailog, true);
    }

//    public void clickCancel() {
//        mobileCommands.waitForElement(orderInProgressMap.btnNewOrder());
//        mobileCommands.click(orderInProgressMap.btnNewOrder());
//    }
//
//    public void clickExit() {
//        mobileCommands.waitForElement(orderInProgressMap.btnContinue());
//        mobileCommands.click(orderInProgressMap.btnContinue());
//    }

    public void clickContinue() {
            mobileCommands.waitForElement(orderInProgressMap.btnContinue());
            mobileCommands.click(orderInProgressMap.btnContinue());
            }

    public void clickNewOrder() {
        try {
            if (mobileCommands.elements(orderInProgressMap.btnNewOrder()).size() > 0) {
                mobileCommands.click(orderInProgressMap.btnNewOrder());
            }
        } catch (Exception e) {
            //do nothing
        }
    }
    public void clickDialogContinue() {
        try {
            if (mobileCommands.elements(orderInProgressMap.btnContinue()).size() > 0) {
                mobileCommands.click(orderInProgressMap.btnContinue());
            }
        } catch (Exception e) {
            //do nothing
        }
    }
}
