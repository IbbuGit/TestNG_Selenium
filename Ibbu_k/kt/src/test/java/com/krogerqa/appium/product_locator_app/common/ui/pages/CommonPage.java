package com.krogerqa.appium.product_locator_app.common.ui.pages;

import com.google.common.collect.ImmutableMap;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.common.ui.maps.CommonPageMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.util.concurrent.TimeUnit;

import java.util.Date;

import io.appium.java_client.android.connection.*;


public class CommonPage {


    MobileCommands mobileCommands = new MobileCommands();

    CommonPageMap commonPageMap;

    public CommonPage() {
        commonPageMap = new CommonPageMap();
    }

    public void clickKebabMenu() {
        mobileCommands.click(commonPageMap.kebabMenu());
    }

    public boolean isElementVisible(By locator) {
        boolean flag = true;
        try {
            flag = mobileCommands.isElementExist(locator);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = mobileCommands.getWebDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction((AppiumDriver) mobileCommands.getWebDriver())
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }


    public void validateToastMessage(String noDepartmentSelectedToast) {
        mobileCommands.assertElementText(commonPageMap.toastMessage(), noDepartmentSelectedToast, true);
    }


    public void clickAbout() {
        mobileCommands.click(commonPageMap.about());

    }

    public void verifyAbout() {
        mobileCommands.assertElementDisplayed(commonPageMap.about(), true);
    }

    public void verifyMDCTutorial() {
        mobileCommands.assertElementDisplayed(commonPageMap.mdcTutorial(), true);
    }

    public void verifyMDCFaq() {
        mobileCommands.click(commonPageMap.faqLayout());
        mobileCommands.click(commonPageMap.faqMDCOption());
        mobileCommands.assertElementDisplayed(commonPageMap.faqMDCHeading(), true);
        backAndroidButton();
        backAndroidButton();
    }

    public void clickKebabElement(String kebabElements) {
        for (WebElement kebabElement : mobileCommands.elements(commonPageMap.kebabMenuList())) {
            if (((MobileElement) kebabElement).getText().contains(kebabElements)) {
                kebabElement.click();
                break;
            }
        }
    }

    public void clickRemoveButton() {
        mobileCommands.click(commonPageMap.removeButton());
    }

    public void clickBackButton() {
        mobileCommands.click(commonPageMap.backButton());
    }

    public void clickExitTransfer() {
        clickKebabElement("Exit Transfer");
    }


    public void validateKebabMenu(String kebabTitlesValues) {
        String kebabTitles[] = kebabTitlesValues.split("@");
        List<WebElement>
                kababElements = mobileCommands.elements(commonPageMap.kebabMenuList());
        for (int i = 0; i < kababElements.size(); i++) {
            if (!kababElements.get(i).getText().equalsIgnoreCase(kebabTitles[i].toLowerCase())) {
                Assert.assertTrue(kababElements.get(i).getText().equalsIgnoreCase(kebabTitles[i].toLowerCase()), "Kebab menu validation failed");
            }
        }
    }

    public void clickFAQLayout() {
        clickKebabElement("FAQ");
    }


    public void clickFaqGroups(String faqTextValues) throws InterruptedException {
        if (mobileCommands.elementDisplayed(commonPageMap.faqLayout())) {
            String[] faqsText = faqTextValues.split("@");
            for (int i = 0; i < faqsText.length; i++) {
                MobileElement mobileElement = (MobileElement) mobileCommands.element(By.xpath("//*[@text='" + faqsText[i] + "']"));
                if (mobileCommands.elementDisplayed(By.xpath("//*[@text='" + faqsText[i] + "']"))) {
                    mobileElement.click();
                    Thread.sleep(2000);
                    Assert.assertTrue(mobileCommands.elementDisplayed(By.xpath("//*[@text='" + faqsText[i] + "']")));
                }
                clickBackButton();
                Thread.sleep(2000);
            }

            clickBackButton();
        }
    }

    public void clickSpecifedTrackFAQ(String faqTrackName){
        mobileCommands.click(By.xpath("//*[@text='" + faqTrackName + "']"));
    }
    public void clickFAQBackroomCount(){
        mobileCommands.click(commonPageMap.faqBackroomCount());
    }


    public void verifyFAQTitle() {
        mobileCommands.assertElementDisplayed(commonPageMap.faqPageTitle(), true);
    }


    public void validateFaqQuery(String faqsStr) {
        String xpath = "//*[@text='" + faqsStr + "']";
        MobileElement element = (MobileElement) mobileCommands.element(By.xpath(xpath));

        Assert.assertTrue(mobileCommands.elementDisplayed(By.xpath(xpath)), faqsStr + " displayed in faq page");
    }

    public boolean handleTransferError() {
        if (mobileCommands.elementDisplayed(commonPageMap.transferError())) {
            clickTransferErrorOkayButton();
            return true;
        } else {

            return false;
        }
    }

    public void clickBackArrowButton() {
        mobileCommands.click(commonPageMap.btnBackArrow());
    }


    public void clickTransferErrorOkayButton() {
        mobileCommands.click(commonPageMap.okayButton());
    }

    public void backAndroidButton() {
        ((AppiumDriver) mobileCommands.getWebDriver()).navigate().back();
    }


    public boolean scrollAndClickTextInElement(String id, String text) {
        boolean flag = false;
        try {
            AndroidDriver androidDriver = (AndroidDriver) mobileCommands.getWebDriver();
            MobileElement elementToClick
                    = (MobileElement) androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                    + ".resourceId(\"" + id + "\")).scrollIntoView("
                    + "new UiSelector().text(\"" + text + "\"));");
            elementToClick.click();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }


      public double getTime(){
        Date date =new Date();

        return date.getTime();
    }


    public static void main(String m[]) throws Exception {
        CommonPage commonPage = new CommonPage();
        double before = commonPage.getTime();

        Thread.sleep(3000);
        double after = commonPage.getTime();

        System.out.println((int) (after - before) / 1000 + " Secs ");

    }

    public void enableWiFi(){
        ((AndroidDriver)mobileCommands.getWebDriver()).executeScript("mobile: shell", new Object[]{ImmutableMap.of("command", "svc wifi enable")});
        mobileCommands.wait(3);
    }

    public void disableWiFi(){
        ((AndroidDriver)mobileCommands.getWebDriver()).executeScript("mobile: shell", new Object[]{ImmutableMap.of("command", "svc wifi disable")});
        mobileCommands.wait(3);
    }

    public void enableMobileData(){
        ((AndroidDriver)mobileCommands.getWebDriver()).executeScript("mobile: shell", new Object[]{ImmutableMap.of("command", "svc data enable")});
        mobileCommands.wait(3);
    }

    public void disableMobileData(){
        ((AndroidDriver)mobileCommands.getWebDriver()).executeScript("mobile: shell", new Object[]{ImmutableMap.of("command", "svc data disable")});
        mobileCommands.wait(3);
    }

    public void enableModes(String mode) throws Throwable {

        AndroidDriver androidDriver = (AndroidDriver) mobileCommands.getWebDriver();
        switch (mode.toUpperCase()) {
            case "WIFIENABLE":
                androidDriver.setConnection(new ConnectionStateBuilder().withWiFiEnabled ().build ());
                Assert.assertTrue(androidDriver.getConnection().isWiFiEnabled(),"Wifi should be turned On");
                break;
            case "WIFIDISABLE":
                androidDriver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
                Assert.assertFalse(androidDriver.getConnection().isWiFiEnabled(), "Wifi should be turned Off");
                break;
            case "ENABLEAIROPLANE":
                androidDriver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
                Assert.assertTrue(androidDriver.getConnection().isAirplaneModeEnabled(), "Airplane Mode should be turned On");
                break;
            case "DISABLEAIROPLANE":
                androidDriver.setConnection(new ConnectionStateBuilder().withAirplaneModeDisabled().build());
                Assert.assertFalse(androidDriver.getConnection().isAirplaneModeEnabled(), "Airplane Mode should be turned Off");
                break;
            case "ENABLEMOBILEDATA":
                androidDriver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
                Assert.assertTrue(androidDriver.getConnection().isDataEnabled(), "Mobile Data should be turned On");
                break;
            case "DISABLEMOBILEDATA":
                androidDriver.setConnection(new ConnectionStateBuilder().withDataDisabled().build());
                Assert.assertFalse(androidDriver.getConnection().isDataEnabled(), "Mobile Data should be turned Off");
                break;

            default:
                throw new Exception("Not matched with any mode");
        }
    }

    public void verifyErrorMessageText() throws Throwable {
        mobileCommands.waitForElementVisibility(commonPageMap.errorMessage());
        mobileCommands.assertElementDisplayed(commonPageMap.errorMessage(), true);
    }

    public void clickBackArrow() {
        mobileCommands.click(commonPageMap.backArrow());
    }

    public void visibleLoadDeptList() {
        mobileCommands.waitForElementVisibility(commonPageMap.loadDeptList());
        mobileCommands.assertElementDisplayed(commonPageMap.loadDeptList(), true);
    }

    // This method is for verifying what are all the upcs' we scan and validate the same upc is review page, by swiping once.
    public void validateUPC(String upcNums,String from){

        Set<String> reviewPageUpc=new HashSet();
        List<WebElement>  upcElements=null;
        if(from.equals("MDC")) {
            upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));
        }else{
            upcElements = mobileCommands.getWebDriver().findElements(By.id("itemUpcText"));
        }
        for(WebElement upcElement:upcElements){
            reviewPageUpc.add(upcElement.getText());
        }
        BaseUtil.scroll("DOWN",2);
        if(from.equals(from)) {
            upcElements = mobileCommands.getWebDriver().findElements(By.id("upcText"));
        }else{
            upcElements = mobileCommands.getWebDriver().findElements(By.id("itemUpcText"));
        }

        for(WebElement upcElement:upcElements){
            reviewPageUpc.add(upcElement.getText());
        }
        int k=0;
        Iterator itr=reviewPageUpc.iterator();
        String[] upcArray=upcNums.split("@");
        while(itr.hasNext()){
            String upcNum=itr.next().toString();
            for (int j=0;j<upcArray.length;j++){
                if(upcArray[j].equals(upcNum)){
                    k++;
                }
            }
        }
        Assert.assertEquals(k,upcArray.length);
    }
}
