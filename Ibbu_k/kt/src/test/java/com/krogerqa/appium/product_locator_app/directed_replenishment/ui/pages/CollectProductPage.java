
package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.CollectProductPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;


public class CollectProductPage {
    MobileCommands mobileCommands = new MobileCommands();
    CollectProductPageMap collectProductPageMap;

    public CollectProductPage() {
        collectProductPageMap = new CollectProductPageMap();
    }

    public void clickDoneBtn() {
        mobileCommands.click((collectProductPageMap.btnDone()));

    }

    public void validateCollectProduct() {
        mobileCommands.wait(3);
        mobileCommands.assertElementDisplayed(collectProductPageMap.headerCollectProduct(), true);
    }

    public void clickDoneCollecting() {
        if ((mobileCommands.getWebDriver().findElements(collectProductPageMap.btnDoneCollecting()).size()) > 0) {
            mobileCommands.click(collectProductPageMap.btnDoneCollecting());
        }
    }

    public int getSuggestedQty() {
        return Integer.parseInt(mobileCommands.element(collectProductPageMap.txtBoxStepperNumber()).getText());
    }

    public void validateSuccessMsg() {
        mobileCommands.assertElementEnabled(collectProductPageMap.txtSuccessProductMsg(), true);
    }
}

