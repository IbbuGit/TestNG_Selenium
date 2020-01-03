package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.section_check.ui.maps.ReviewCountPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ReviewCountPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private ReviewCountPageMap reviewCountPageMap;
    UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    TaskListPage taskListPage;
    CommonPage commonPage;

    public ReviewCountPage() {
        reviewCountPageMap = new ReviewCountPageMap();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        reviewCountPageMap = new ReviewCountPageMap();
        taskListPage = new TaskListPage();
        commonPage = new CommonPage();
    }

    public void clickingOnAddMoreBtn() {
        mobileCommands.waitForElementClickability(reviewCountPageMap.addMoreBtn());
        mobileCommands.click(reviewCountPageMap.addMoreBtn());
    }


    public void clickOnSubmitBtn() {
        mobileCommands.waitForElement(reviewCountPageMap.submitBtn());
        mobileCommands.click(reviewCountPageMap.submitBtn());
    }

    public void verifyPageTitle(String reviewCount) {
        mobileCommands.waitForElement(reviewCountPageMap.reviewCountTitle());
        mobileCommands.assertElementText(reviewCountPageMap.reviewCountTitle(), reviewCount, true);
    }

    public void verifyMultiProductLocationMessage(String multiLocationBannerMsg) {
        mobileCommands.waitForElement(reviewCountPageMap.multiLocationBannerMsg());
        mobileCommands.assertElementText(reviewCountPageMap.multiLocationBannerMsg(), multiLocationBannerMsg, true);
    }

    public void verifySubmitBtn() {
        mobileCommands.assertElementEnabled(reviewCountPageMap.submitBtn(), true);
    }

    public void verifySubmitBtn_Disabled() {
        mobileCommands.assertElementEnabled(reviewCountPageMap.submitBtn(), false);
    }

    public void verifyContinueBtn() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.continueBtn(), true);
    }

    public void clickOnBackArrow() {
        mobileCommands.waitForElement(reviewCountPageMap.reviewBackArrow());
        mobileCommands.click(reviewCountPageMap.reviewBackArrow());
    }

    public void verifySkippedProducts_AndClick(String skippedMsg) {
        mobileCommands.assertElementText(reviewCountPageMap.skippedItems(), skippedMsg, true);
        mobileCommands.waitForElement(reviewCountPageMap.clickOnSkippedItem());
        mobileCommands.click(reviewCountPageMap.clickOnSkippedItem());
    }

    public void verifyNoLocationHdr() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.noLocation(), true);
    }

    public void clickOnDeleteIcon(String removeProductTitle) {
        mobileCommands.waitForElement(reviewCountPageMap.imageDelete());
        mobileCommands.click(reviewCountPageMap.imageDelete());
        mobileCommands.assertElementText(reviewCountPageMap.removeProductTitle(), removeProductTitle, true);
        mobileCommands.click(reviewCountPageMap.removeBtn_RemoveProduct());

    }

    public void verifyMultiLocationBannerMsg_ClickOnContinue(String multiLocationBannerMsg) {
        mobileCommands.waitForElement(reviewCountPageMap.multiLocationBannerMsg());
        mobileCommands.assertElementText(reviewCountPageMap.multiLocationBannerMsg(), multiLocationBannerMsg, true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.continueBtn(), true);
        mobileCommands.waitForElement(reviewCountPageMap.continueBtn());
        mobileCommands.click(reviewCountPageMap.continueBtn());
    }

    public void clickContinueBtn_RemainingLocationPopup(String countRemainingLocationHdrMsg) {
        mobileCommands.assertElementText(reviewCountPageMap.countRemainingLocationHdr(), countRemainingLocationHdrMsg, true);
        mobileCommands.waitForElement(reviewCountPageMap.continueBtn_CountRemainingLocation());
        mobileCommands.click(reviewCountPageMap.continueBtn_CountRemainingLocation());
        mobileCommands.wait(5);
    }

    public void verifyRemovePopUpMessage(String removeProductMsg) {
        mobileCommands.assertElementText(reviewCountPageMap.removeProductPopUpMsg(), removeProductMsg, true);
    }

    public void verifyPopUpTitle(String removeProductTitle) {
        mobileCommands.assertElementText(reviewCountPageMap.removeProductTitle(), removeProductTitle, true);
    }


    public void removeAnItem() {
        mobileCommands.click(reviewCountPageMap.removeIcon());
        mobileCommands.click(reviewCountPageMap.removeBtn_RemoveProduct());
    }

    public void editAnItem() throws Throwable {
        mobileCommands.click(reviewCountPageMap.productUPCText());
    }

    public void exitSession(List<String> UPCsToScan) {
        mobileCommands.click(reviewCountPageMap.reviewBackArrow());
        unSubmittedWorkPopUpPage.clickOnSaveAndExitBtn();
        taskListPage.clickSectionCheck();
        unSubmittedWorkPopUpPage.clickOnContinueBtn();
        List<String> upcsOnReviewPage = UPCsCounted();
        for (String upcToValidate : UPCsToScan) {

            Assert.assertTrue(upcsOnReviewPage.contains(upcToValidate), "One of the UPCs missing");
        }
        clickOnSubmitBtn();

    }

    public List<String> UPCsCounted() {
        List<String> upcsOnReviewPage = new ArrayList<String>();
        int i = 0;
        boolean foundNew = false;
        do {
            List<WebElement> listOfUpcText =
                    mobileCommands.elements(reviewCountPageMap.productUPCText());

            foundNew = false;
            for (WebElement currentUpcText : listOfUpcText) {
                if (!upcsOnReviewPage.contains(currentUpcText.getText())) {
                    upcsOnReviewPage.add(currentUpcText.getText());
                    foundNew = true;
                }
            }
            BaseUtil.scroll("down");
            //scrollDown();
            i++;
        } while (foundNew);
        return upcsOnReviewPage;

    }

    public String firstUpcInReviewPage() {
        return mobileCommands.getElementText(reviewCountPageMap.productUPCText());
    }
}