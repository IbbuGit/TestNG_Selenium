package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.section_check.ui.maps.ThankYouPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class ThankYouPage {
    MobileCommands mobileCommands = new MobileCommands();
    ThankYouPageMap thankYouPageMap;

    public ThankYouPage() {
        thankYouPageMap = new ThankYouPageMap();
    }

    public void clickOnCountAnotherSection() {
        mobileCommands.waitForElement(thankYouPageMap.countAnotherSectionBtn());
        mobileCommands.click(thankYouPageMap.countAnotherSectionBtn());
    }

    public void clickOnMainMenu() {
        mobileCommands.click(thankYouPageMap.mainMenuBtn());
    }

    public void verifyCountSubmittedTitle(String countSubmittedHdr) {
        mobileCommands.assertElementText(thankYouPageMap.countSubmittedTitle(), countSubmittedHdr, true);
    }


    public void verifyImage() {
        mobileCommands.assertElementDisplayed(thankYouPageMap.thankYouImg(), true);
    }

    public void verifySectionCheckCompletedMsg(String thankYouScreen) {
        mobileCommands.assertElementText(thankYouPageMap.countSubmittedTitle(), thankYouScreen, true);
    }

    public void verifyTotalProductsCounted() {
        mobileCommands.getElementText(thankYouPageMap.numberOfProducts());
    }

    public void verifyProductsCounted(String UPCsToScan[]) {
        String noOfUpcs = Integer.toString(UPCsToScan.length - 1);
        String totalCount = mobileCommands.getElementText(thankYouPageMap.numberOfProducts()).trim();
        noOfUpcs = (noOfUpcs) + " " + "Product" + ((Integer.parseInt(noOfUpcs) > 1) ? "s" : "");
        Assert.assertTrue(noOfUpcs.equalsIgnoreCase(totalCount), "Section Check : The UPCs scanned is not matching with the count shown in Thank you page");
    }

}
