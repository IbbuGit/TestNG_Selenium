package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.SelectYourLocationMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SelectYourLocationPage {


    BaseCommands baseCommands = new BaseCommands();

    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();

    SelectYourLocationMap selectYourLocationMap;

    public SelectYourLocationPage() {
        selectYourLocationMap = new SelectYourLocationMap();
    }

    public void selectRadioButton(String selectRadioButton) {
        /* mobileCommands.swipeElementUp ( By.id (selectRadioButton )  );
        mobileCommands.element ( By.id (selectRadioButton )).click ();*/
        mobileCommands.click(selectYourLocationMap.radioButton());
    }

    public void selectRadioButton(int position) {
        mobileCommands.getWebDriver().findElements(By.id("radioBtnLocation")).get(position).click();
    }

    public boolean selectRadioButton() {
        boolean returnVal = false;
        try {
            if (isSelectLocationDialogDisplayed()) {
                mobileCommands.click(selectYourLocationMap.radioButton());
                return true;
            }
        } catch (TimeoutException toe) {

        } catch (Exception everythingElse) {
            throw everythingElse;
        }
        return returnVal;
    }


    public void clickSelectButton() {
        mobileCommands.click(selectYourLocationMap.selectButton());
    }


    public void viewSelectYourLocationPageTitle(String selectYourLocation) {
        mobileCommands.assertElementText(selectYourLocationMap.selectYourLocationDialogTitle(), selectYourLocation, true);
    }


    public void verifyDisabledSelectButton() {
        mobileCommands.assertElementEnabled(selectYourLocationMap.selectButton(), false);
    }

    public void verifyEnabledSelectButton() {
        mobileCommands.assertElementEnabled(selectYourLocationMap.selectButton(), true);
    }

    public void clickCancelButton() {
        mobileCommands.click(selectYourLocationMap.cancelButton());
    }

    public void selectLocation() {
        mobileCommands.click(selectYourLocationMap.radioButton());
    }

    public boolean isSelectLocationDialogDisplayed() {
        return baseCommands.isElementExist(selectYourLocationMap.selectYourLocationDialogTitle());
    }

    public int getAisleDescriptionCount() {

        return mobileCommands.getWebDriver().findElements(By.className("android.view.ViewGroup")).size();

    }

    public void clickNoneOfTheAboveRadioButton() {
        mobileCommands.click(selectYourLocationMap.noneOfTheAboveRadioButton());
    }

    public void validateAisleDescriptionCounts(int before, int after) {
        System.out.println(" before " + before + " after " + after);
        Assert.assertEquals(before, after, "Count is validated");
    }
}
