
/**
 * Test case to verify the Order Updated screen
 * ALM test case -1374
 * Created by -Raguapthi(syl7525)
 */


package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.OrderUpdatedScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebDriver;

public class OrderUpdatedScreenPage {
    MobileCommands mobileCommands = new MobileCommands();
    OrderUpdatedScreenPageMap orderUpdateScreen;

    public OrderUpdatedScreenPage() {
        orderUpdateScreen = new OrderUpdatedScreenPageMap();
    }
    public void validateOrderUpdateHeaderTxt(String TextOrderUpdate) {
        mobileCommands.assertElementText(orderUpdateScreen.txtOrderUpdate(),TextOrderUpdate,true);
    }

    public void validateAndClickBtnUpc(String OrderUpcText) {
        mobileCommands.assertElementText(orderUpdateScreen.btnEnterUpc(),OrderUpcText,true);
        mobileCommands.click(orderUpdateScreen.btnEnterUpc());
    }
    public void validateAndClickReviewBtn(String orderReviewButton) {
        mobileCommands.assertElementText(orderUpdateScreen.btnReviewUpc(),orderReviewButton,true);
        mobileCommands.click(orderUpdateScreen.btnReviewUpc());
    }
    public void waitForReivewButton(){
        mobileCommands.waitForElement(orderUpdateScreen.btnReviewUpc());
    }

    public void clickContinueBtn() {
        WebDriver driver=mobileCommands.getWebDriver();
        if (( driver.findElements(orderUpdateScreen.orderInProgressDialogContinueBtn()).size()>0))
        {
            mobileCommands.click(orderUpdateScreen.orderInProgressDialogContinueBtn());
        }
    }

    public void navigateBack(){
        mobileCommands.browserBack();
    }
    public void clickEnterUpc(){
        mobileCommands.click(orderUpdateScreen.btnEnterUpc());
    }
    public void clickReview(){
        mobileCommands.click(orderUpdateScreen.btnReviewUpc());
    }
}