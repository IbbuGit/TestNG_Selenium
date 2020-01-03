package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.MDCReviewCountMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MDCReviewCountPage extends Base {

    BaseCommands baseCommands = new BaseCommands();
    MobileCommands mobileCommands = new MobileCommands();
    MDCReviewCountMap MDCReviewCountMap;
    CommonPage commonPage = new CommonPage();
    MDCCountProductPage mdcCountProductPage = new MDCCountProductPage();


    public MDCReviewCountPage() {
        MDCReviewCountMap = new MDCReviewCountMap();
    }

    public void validateReviewCountPageTitle(String ReviewCountTitle) {
        mobileCommands.assertElementText(MDCReviewCountMap.reviewPageTitle(), ReviewCountTitle, true);
    }

    public void verifySubmitButton(String submitBtn) {
        mobileCommands.assertElementText(MDCReviewCountMap.reviewButtonSubmit(), submitBtn, true);
    }

    public void clickContinueButton() {
        mobileCommands.click(MDCReviewCountMap.continueButton());
    }

    public void verifyContinueButton(String continueBtn) {
        mobileCommands.assertElementText(MDCReviewCountMap.continueButton(), continueBtn, true);
    }

    public void clickSubmitOrContinue(String submitBtn) {
        if (mobileCommands.getElementAttribute(MDCReviewCountMap.continueButton(), "enabled").equals("true")) {
            clickContinueButton();
        } else {
            verifySubmitButton(submitBtn);
            clickReviewCountSubmitButton();
        }
    }


    public void verifyEnabledReviewCountSubmitButton() {
        mobileCommands.assertElementEnabled(MDCReviewCountMap.reviewButtonSubmit(), true);
    }

    public void verifyDisabledReviewCountSubmitButton() {
        mobileCommands.assertElementEnabled(MDCReviewCountMap.reviewButtonSubmit(), false);
    }

    public void clickReviewCountSubmitButton() {
        mobileCommands.click(MDCReviewCountMap.reviewButtonSubmit());
    }


    public void clickOnProductCardImage() {
        mobileCommands.click(MDCReviewCountMap.productCardImage());
    }

    public void validateDispalySubmitButton() {
        WebDriver driver = mobileCommands.getWebDriver();
        if ((driver.findElements(MDCReviewCountMap.reviewButtonSubmit()).size()) == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void validateDisplayContinueButton() {
        WebDriver driver = mobileCommands.getWebDriver();
        if ((driver.findElements(MDCReviewCountMap.continueButton()).size()) == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public int updateWrongAndSkipProduct() throws Throwable {

        int submittedCount = 0;
        do {
            if (commonPage.isElementVisible(By.xpath("(//*[@text='Wrong Location'])[1]"))) {
                clickProduct(mobileCommands.getWebDriver().findElements(By.xpath("//*[@text='Wrong Location']")).get(0));
                submittedCount++;
                break;
            }
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
        }
        while (!commonPage.isElementVisible(By.xpath("(//*[@text='Wrong Location'])[1]")));

        do {
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            if (commonPage.isElementVisible(By.xpath("(//*[@text='Skipped'])[1]"))) {
                clickProduct(mobileCommands.getWebDriver().findElements(By.xpath("//*[@text='Skipped']")).get(0));
                submittedCount++;
                break;
            }
        }
        while (!commonPage.isElementVisible(By.xpath("(//*[@text='Skipped'])[1]")));

        return submittedCount;
    }

    public void clickProduct(WebElement element) throws Throwable {
        element.click();
        mdcCountProductPage.clickOnEnterQuantityTextField();
        mdcCountProductPage.swipeAndEnterUnitCount();
        mdcCountProductPage.clickOnSubmitCountButton();
        mdcCountProductPage.verifySnackBarText();
    }

    public void validateUPC(String upcNums) {
        Set<String> reviewPageUpc = new HashSet();

        List<WebElement> upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));

        for (WebElement upcElement : upcElements) {
            reviewPageUpc.add(upcElement.getText());
        }
        commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
        upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));

        for (WebElement upcElement : upcElements) {
            reviewPageUpc.add(upcElement.getText());
        }
        int k = 0;
        Iterator itr = reviewPageUpc.iterator();
        String[] upcArray = upcNums.split("@");
        while (itr.hasNext()) {
            String upcNum = itr.next().toString();
            for (int j = 0; j < upcArray.length; j++) {
                if (upcArray[j].equals(upcNum)) {
                    System.out.println("FindProduct Page:" + upcArray[j] + "   ReviewCount Page:" + upcNum);
                    k++;
                }
            }

        }
        Assert.assertEquals(k, upcArray.length);
    }
    /*
     * The purpose of below mentined list reviewPageUpc1 and reviewPageUpc2 is to store UPCs temperoryly for scrolling purpose
     * */
    public void scrollReviewListDown() {

        List<String> reviewPageUpc1 = new ArrayList<>();
        List<String> reviewPageUpc2 = new ArrayList<>();
        boolean value;
        do {
            List<WebElement> upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));

            reviewPageUpc1.add(upcElements.get(upcElements.size() - 1).getText());
            scroll("Down");
            upcElements.clear();
            upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));
            reviewPageUpc2.add(upcElements.get(upcElements.size() - 1).getText());
            value = reviewPageUpc1.equals(reviewPageUpc2);
            reviewPageUpc1.clear();
            reviewPageUpc2.clear();
        }
        while (!value);
    }
    /*
     * The purpose of below mentined list reviewPageUpc1 and reviewPageUpc2 is to store UPCs temperoryly for scrolling purpose
     * */
    public void scrollReviewListUp() {

        List<String> reviewPageUpc1 = new ArrayList<>();
        List<String> reviewPageUpc2 = new ArrayList<>();
        boolean value;
        do {
            List<WebElement> upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));

            reviewPageUpc1.add(upcElements.get(0).getText());
            scroll("Up", 2);

            upcElements.clear();
            upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));
            reviewPageUpc2.add(upcElements.get(0).getText());
            value = reviewPageUpc1.equals(reviewPageUpc2);
            reviewPageUpc1.clear();
            reviewPageUpc2.clear();
        }
        while (!value);
    }
}
