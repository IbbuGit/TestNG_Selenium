package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.ThankYouMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class ThankYouPage {

    MobileCommands mobileCommands = new MobileCommands();

    ThankYouMap thankYouMap;

    public ThankYouPage() {
        thankYouMap = new ThankYouMap();
    }

    public void validateCountSubmittedPageTitle(String countSubmittedTitle) {
        mobileCommands.assertElementText(thankYouMap.thankYouPageTitle(), countSubmittedTitle, true);
    }

    public void successImageVisibility() {
        mobileCommands.isElementExist(thankYouMap.successImage());
    }

    public void verifySuccessText() {
        mobileCommands.assertElementDisplayed(thankYouMap.successMessage(), true);

    }

    public void verifyTotalProductsCounted() {
        int successCount = FindProductPage.getSuccessCount();
        String totalScannedProducts = mobileCommands.getElementText(thankYouMap.scannedProducts());
        Assert.assertEquals(totalScannedProducts, successCount + " Products");
    }

    public void verifyTotalProductsCountSubmitted(int scannedCount) {
        String totalScannedProducts = mobileCommands.getElementText(thankYouMap.scannedProducts());
        Assert.assertEquals(totalScannedProducts, scannedCount + " Products");
    }

    public void verifyCountWord() {
        mobileCommands.isElementExist(thankYouMap.countText());
    }

    public void backToMainMenuButton() {
        mobileCommands.click(thankYouMap.backToMainMenu());
    }
}
