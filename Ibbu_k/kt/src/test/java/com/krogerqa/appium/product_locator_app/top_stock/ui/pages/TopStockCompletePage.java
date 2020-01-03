package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockCompletePageMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class TopStockCompletePage {

    MobileCommands mobileCommands = new MobileCommands();
    TopStockCompletePageMap topStockCompletePageMap;

    public TopStockCompletePage() {
        topStockCompletePageMap = new TopStockCompletePageMap();
    }

    public void ValidateCompletescreenHeaderTxt(String completeheadertxt) throws Throwable {
        mobileCommands.assertElementText(topStockCompletePageMap.CompleteHeader(), completeheadertxt, true);
    }

    public void ValidateCompleteThankYouMsg(String completeThankYouMsgTxt) throws Throwable {
        mobileCommands.assertElementText(topStockCompletePageMap.thankYouMsg(), completeThankYouMsgTxt, true);
    }

    public void ValidateCompletesTxtMsg(String completeTxtMsg) throws Throwable {
        mobileCommands.assertElementText(topStockCompletePageMap.CompleteTsMsg(), completeTxtMsg, true);
    }

    public void ClickMainMenuBtn() throws Throwable {
        mobileCommands.click(topStockCompletePageMap.mainMenuBtn());
    }

    /*public void verifyStockedCountInCompletedScreen(String productCount){
        mobileCommands.assertElementText(topStockCompletePageMap.stockedCount(),productCount,true);

    }*/
    public void verifyStockedCountInCompletedScreen(int productCount) {
        String productCounts;
        if (productCount > 0 && productCount == 1) {
            productCounts = productCount + " Product ";
            mobileCommands.assertElementText(topStockCompletePageMap.stockedCount(), productCounts, true);
        } else {
            productCounts = productCount + " Products ";
            mobileCommands.assertElementText(topStockCompletePageMap.stockedCount(), productCounts, true);
        }

    }
}
