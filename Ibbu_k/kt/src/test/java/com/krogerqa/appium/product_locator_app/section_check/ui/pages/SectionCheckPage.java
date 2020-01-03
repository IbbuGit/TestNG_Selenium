package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.section_check.ui.maps.SectionCheckPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SectionCheckPage {
    MobileCommands mobileCommands = new MobileCommands();
    SectionCheckPageMap sectionCheckPageMap = new SectionCheckPageMap();

    public void verifySectionCheckHdr(String sectionCheckHdr) {
        mobileCommands.waitForElement(sectionCheckPageMap.sectionCheckHdr());
        mobileCommands.assertElementText(sectionCheckPageMap.sectionCheckHdr(), sectionCheckHdr, true);
    }

    public void clickOnEnterUPCBtn() {
        mobileCommands.waitForElement(sectionCheckPageMap.btnEnterUPC());
        mobileCommands.click(sectionCheckPageMap.btnEnterUPC());
    }

    public void verifySelectYourLocationHdr() {
        mobileCommands.waitForElement(sectionCheckPageMap.selectYourLocationHdr());
        mobileCommands.assertElementDisplayed(sectionCheckPageMap.selectYourLocationHdr(), true);
    }

    public void verifyCancelBtn_ClickCancel() {
        mobileCommands.waitForElement(sectionCheckPageMap.btnCancel_Location());
        mobileCommands.assertElementDisplayed(sectionCheckPageMap.btnCancel_Location(), true);
        mobileCommands.click(sectionCheckPageMap.btnCancel_Location());
    }

    public void selectLocationRadioBtn(String locationId) {
        mobileCommands.waitForElement(sectionCheckPageMap.selectYourLocationHdr());
        mobileCommands.assertElementDisplayed(sectionCheckPageMap.selectYourLocationHdr(), true);
        WebDriver driver;
        driver = mobileCommands.getWebDriver();
        List<WebElement> listRadioBtn = driver.findElements(By.className("android.widget.RadioButton"));
        int count1 = listRadioBtn.size();
        if (locationId.equalsIgnoreCase("None of the Above")) {
            listRadioBtn.get(count1 - 1).click();
        } else {
            listRadioBtn.get(0).click();
        }
        mobileCommands.waitForElement(sectionCheckPageMap.btnSelect_Location());
        mobileCommands.click(sectionCheckPageMap.btnSelect_Location());
    }

}
