package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.EnterAmountMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.OutdatedMap;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.ReviewScreenMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;
import java.util.List;

public class OutdatedPage {
    MobileCommands mobileCommands = new MobileCommands();
    OutdatedMap outdatedMap;
    CommonPage commonPage;
    EnterAmountMap enterAmountMap;
    ReviewScreenMap reviewScreenMap;
    private int wait;

    public OutdatedPage() {
        outdatedMap = new OutdatedMap();
        commonPage = new CommonPage();
        enterAmountMap = new EnterAmountMap();
        reviewScreenMap = new ReviewScreenMap();
        wait = 10;
    }

    public void clickOutdated() {
        mobileCommands.click(outdatedMap.btnOutdated());
    }

    public void validateOutdatedTitle() throws IOException, InterruptedException {
        clickOutdated();
        mobileCommands.assertElementDisplayed(outdatedMap.outdatedPageTitle(), true);
        getTitle();
    }

    public String getTitle() {
        return mobileCommands.getElementText(outdatedMap.outdatedPageTitle());
    }

    public void clickExitFromInventoryKababMenuOption() {
        commonPage.clickKebabMenu();
        mobileCommands.click(outdatedMap.exitRemoveFromInventoryBtn());
    }
    public void verifyElementsOnEnterUPCScreen() throws IOException, InterruptedException {
        mobileCommands.assertElementDisplayed(outdatedMap.scanProductImg(),true);
        mobileCommands.assertElementDisplayed(outdatedMap.scanProductText(),true);
        mobileCommands.assertElementDisplayed(outdatedMap.enterUpcBtn(),true);
        mobileCommands.assertElementDisplayed(outdatedMap.productsToRemoveText(),true);
    }

    public String validateOutdated() {
        String titleValue = mobileCommands.getElementText(outdatedMap.outdatedPageTitle());
        return titleValue;
    }
    public void secondChanceBannerValidation(){
        mobileCommands.assertElementDisplayed(outdatedMap.secondChanceBanner(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.secondChanceTitle(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.yesButton(), true);
        mobileCommands.assertElementDisplayed(outdatedMap.noButton(), true);
        mobileCommands.click(outdatedMap.yesButton());
    }

    public void clickTheftAndValidate(){
        mobileCommands.assertElementDisplayed(outdatedMap.btnTheft(), true);
        mobileCommands.click(outdatedMap.btnTheft());
        mobileCommands.assertElementDisplayed(outdatedMap.theftPageTitle(), true);
    }
    public void validateBackButtonOnEnterUpcScreen() {
        mobileCommands.click(outdatedMap.backButtonEnterUPCScreen());
        mobileCommands.assertElementDisplayed(outdatedMap.outdatedPageTitle(), true);
        mobileCommands.click(outdatedMap.btnOutdated());
    }

    public boolean magicItemValidation() {
        mobileCommands.assertElementDisplayed(outdatedMap.magicItemBanner(), true);
        mobileCommands.click(enterAmountMap.reviewIcon());
        try {
            List upc = mobileCommands.elements(reviewScreenMap.addedProductDescription("Miracle-Gro Potting Soil"));
            if(upc.size()==0)
                return true;
            else return false;
        }
        catch(TimeoutException e){
            return true;
        }
    }

    public void barCodeNotRecognizedValidation(){
        mobileCommands.assertElementDisplayed(outdatedMap.barCodeError(), true);
    }
    public void submitBtn() {
        mobileCommands.click(outdatedMap.submitBtn());
    }

}
