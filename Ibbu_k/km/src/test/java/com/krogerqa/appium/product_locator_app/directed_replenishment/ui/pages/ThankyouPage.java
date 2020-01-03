
package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogOutPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.CollectedPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.MoveProductPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.ThankyouPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThankyouPage {

    MobileCommands mobileCommands = new MobileCommands();

    CollectedPageMap collectedPageMap;
    ThankyouPageMap thankyouPageMap;
    MoveProductPageMap moveProductPageMap;

     public ThankyouPage() {
        thankyouPageMap = new ThankyouPageMap();
        collectedPageMap = new CollectedPageMap();
        moveProductPageMap = new MoveProductPageMap();

    }

    /*
     *   Verify the display of Thank you screen
     */
    public void validateThankYouPgDisplay() throws InterruptedException {
        Thread.sleep(3000);
        if((mobileCommands.getWebDriver().findElements(By.id("text_positive_caption")).size())> 0)
        {
            mobileCommands.click(collectedPageMap.btnDoneCollecting());
        }
        mobileCommands.assertElementDisplayed(thankyouPageMap.headerThankyou(), true);
    }

    /*
     *   Verify the display of finished text in Thankyou screen
     */
    public void validateFinishedDRText() throws InterruptedException {
        mobileCommands.assertElementDisplayed(thankyouPageMap.txtFinishedDR(), true);
    }

    /*
     *   Verify the display of back to main menu button
     */
    public void validateBackToMainMenu() throws IOException, InterruptedException {
        mobileCommands.assertElementDisplayed(thankyouPageMap.btnBackToMainMenu(), true);
    }

    public void validateContReplenishmentButton()
    {
        mobileCommands.assertElementDisplayed(thankyouPageMap.btnContReplenishment(), true);
    }
    public void clickContinueReplenishmentButton()
    {
        mobileCommands.click(thankyouPageMap.btnContReplenishment());
    }
    public void clickBackToMainMenu(){
        mobileCommands.click(thankyouPageMap.btnBackToMainMenu());
    }
    public void logOutApp() throws Throwable {
        new CommonPage().clickKebabMenu();
        new LogOutPage().loggedOut(false);
        new LogInPage().validateSecureWEBPageTitle();
    }
    public void validateThanKYouCount(int collectedUPCSize) throws IOException, InterruptedException {
        validateBackToMainMenu();
        String minProductReplenished = mobileCommands.getElementText(thankyouPageMap.minimumCount());
        String maxProductReplenished = mobileCommands.getElementText(thankyouPageMap.maxCount());
        String Actual = minProductReplenished + " of " + maxProductReplenished;
        String Expected = String.valueOf(collectedUPCSize) + " of " + String.valueOf(collectedUPCSize);
        Assert.assertEquals(Actual,Expected,"Collected and Replenished products matched");

       /* mobileCommands.assertElementText(thankyouPageMap.minimumCount(),String.valueOf(collectedUPCSize),true);
        mobileCommands.assertElementText(thankyouPageMap.maxCount(),String.valueOf(collectedUPCSize),true);
       */ //mobileCommands.isElementExist(thankyouPageMap.thankyouProductCount(collectedUPC.size()));
    }

    public void validateCountInThankYouPage(List<String> collectedUPC) throws IOException, InterruptedException {
        int count = 1;
        List<String> copyOfCollectedUPC=new ArrayList<>(collectedUPC);
        while (!BaseUtil.isElementPresent(moveProductPageMap.btnFinish(),2)) {
            String UPC=mobileCommands.getElementText(moveProductPageMap.txtProdUPC());
            Assert.assertTrue(collectedUPC.contains(UPC));
            copyOfCollectedUPC.remove(UPC);
            mobileCommands.click(moveProductPageMap.btnNext());
            count++;
        }
        String UPC=mobileCommands.getElementText(moveProductPageMap.txtProdUPC());
        Assert.assertTrue(collectedUPC.contains(UPC));
        copyOfCollectedUPC.remove(UPC);
        mobileCommands.wait(3);
        Assert.assertTrue(copyOfCollectedUPC.isEmpty());
        mobileCommands.click(moveProductPageMap.btnFinish());
        validateThanKYouCount(count);
    }


}

