
package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.CollectedPageMap;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.ThankyouPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CollectedPage {

    private int prodsCollected = 0;
    private MobileCommands mobileCommands = new MobileCommands();
    private CollectedPageMap collectedPageMap;
    private ThankyouPage thankyouPage;
    private NotCollectedPage notCollectedPage;
    private ThankyouPageMap thankyouPageMap;

    private boolean bool;


    public CollectedPage() {
        collectedPageMap = new CollectedPageMap();
        thankyouPage = new ThankyouPage();
        notCollectedPage = new NotCollectedPage();
        thankyouPageMap = new ThankyouPageMap();


    }

    /*
     *   Verify the display of Collected tab
     */
    public void validateCollectedTab() {

        mobileCommands.assertElementDisplayed(collectedPageMap.headerCollected(), true);
    }

    public void clickCollectedTab() {
        mobileCommands.wait(2);
        mobileCommands.click(collectedPageMap.headerCollected());
    }

    public void validateBeginStockingButton() {
        mobileCommands.assertElementDisplayed(collectedPageMap.btnBeginStocking(), true);
    }

    /*
     *   Click Begin Stocking button
     */
    public void clickBeginStocking() {
        mobileCommands.click(collectedPageMap.btnBeginStocking());
    }

    public boolean collectedTabEnabled() {
        bool = mobileCommands.getWebDriver().findElement(By.xpath("//android.widget.TextView[@text='COLLECTED']")).isSelected();
        return bool;
    }

    public int validateAtleastOneProdCollected() {
        if (!(collectedTabEnabled())) {
            clickCollectedTab();
            if (collectedPageMap.prodCollected != null) {
                prodsCollected = collectedPageMap.prodCollected.size();
            }

        }
        return prodsCollected;
    }

    /*
     *   Click Done Collecting button
     */
    public void clickDoneCollecting() throws NullPointerException {
        mobileCommands.wait(3);
        if (mobileCommands.getWebDriver().findElements(By.id("text_positive_caption")).size() > 0) {
            mobileCommands.click(collectedPageMap.btnDoneCollecting());
        }
    }

    public void clickCancel() {
        mobileCommands.wait(3);
        mobileCommands.click(collectedPageMap.btnCancel());
    }

    public void waitForCollectedTab() {
        mobileCommands.wait(3);
        mobileCommands.waitForElement(collectedPageMap.tabCollected());
    }

    public void clickFinishCollectingBtn() {
        validateBeginStockingButton();
        clickBeginStocking();
        clickDoneCollecting();
    }

    public void fuelBeginStocking() throws InterruptedException {
        if (!(collectedTabEnabled())) {
            clickCollectedTab();
        }
        validateCollectedTab();
        validateBeginStockingButton();
        clickBeginStocking();
        clickCancel();
        validateCollectedTab();
        clickBeginStocking();
        thankyouPage.validateThankYouPgDisplay();
    }

    public void validateFuelCartIsFull() throws IOException, InterruptedException {
        if (!(collectedTabEnabled())) {
            notCollectedPage.clickCartIsFull();
            notCollectedPage.validateCartIsFullPopUI();
            notCollectedPage.clickCartIsFullCancel();
            notCollectedPage.validateNotCollectedEnabled();
            notCollectedPage.clickCartIsFull();
            notCollectedPage.clickCartIsFullDoneCollecting();
            thankyouPage.validateThankYouPgDisplay();
        } else {
            notCollectedPage.clickNotCollected();
            notCollectedPage.validateCartIsFullDisabled();
        }
    }

    public void validateCollectedProductUPC(List<String> collectedUPC) {
        Set<String> notCollectedItems = new HashSet();
        for (String upcNum : collectedUPC) {
            List<WebElement> upcElements = mobileCommands.elements(collectedPageMap.txtDrUPC());
            for (WebElement upcElement : upcElements) {
                notCollectedItems.add(upcElement.getText());
            }
            BaseUtil.scroll("down");
            if (notCollectedItems.contains(upcElements.get(upcElements.size() - 1).getText())) {
                break;
            }
        }
        boolean upcFound = true;
        for (String upcText : notCollectedItems) {
            if (!notCollectedItems.contains(upcText)) {
                upcFound = false;
            }
        }
    }

    public void verifyTimerPageMsg(String awesomeText) {
        mobileCommands.waitForElement(collectedPageMap.awesomeText());
        mobileCommands.assertElementText(collectedPageMap.awesomeText(), awesomeText, true);
    }

    public void verifyTimerGreatMsg(String greatTxt) {
        mobileCommands.waitForElement(collectedPageMap.greatText());
        mobileCommands.assertElementText(collectedPageMap.greatText(), greatTxt, true);
    }

    public void clickBackArrow() {
        mobileCommands.click(collectedPageMap.backArrow());
    }

    public void validateBlueScreenCount(int collectedUPCSize) {
        String minProductReplenished = mobileCommands.getElementText(thankyouPageMap.minimumCount());
        String maxProductReplenished = mobileCommands.getElementText(thankyouPageMap.maxCount());
        String Actual = minProductReplenished + " of " + maxProductReplenished;
        String Expected = collectedUPCSize + " of " + collectedUPCSize;
        Assert.assertEquals(Actual, Expected, "Collected products matched");
    }
}




