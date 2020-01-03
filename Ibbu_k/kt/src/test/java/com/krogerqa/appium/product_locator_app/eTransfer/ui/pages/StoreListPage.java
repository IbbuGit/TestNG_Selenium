package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.StoreListMap;

public class
StoreListPage extends Base {
    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();

    StoreListMap storeListMap;

    public StoreListPage() {
        storeListMap = new StoreListMap();
    }

    public void validateStoreListPageTitle(String storeListTitle) {
        mobileCommands.assertElementText(storeListMap.storeTitle(), storeListTitle, true);
    }

    public void selectStore(String storeName) {
        mobileCommands.click(By.xpath("//*[contains(@text,'" + storeName + "')]"));
    }

    public void clickStoreNumberTxtBox() {
        mobileCommands.click(storeListMap.storeNumberTxtBox());
    }

    public void enterStoreNumber(String StoreNumber) {
        mobileCommands.enterText(storeListMap.storeNumberTxtBox(), StoreNumber, true);

    }

    public void clickStoreNumberLabel() {
        mobileCommands.click(storeListMap.storeNumberLabel());
    }

    public void clickNextbtn() {
        mobileCommands.click(storeListMap.btnNext());

    }
}




