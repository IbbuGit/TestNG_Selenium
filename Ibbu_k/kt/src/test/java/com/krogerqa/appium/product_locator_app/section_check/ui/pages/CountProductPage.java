package com.krogerqa.appium.product_locator_app.section_check.ui.pages;

import com.krogerqa.appium.product_locator_app.section_check.ui.maps.CountProductPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class CountProductPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private CountProductPageMap countProductPageMap;

    public CountProductPage() {
        countProductPageMap = new CountProductPageMap();
    }

    public void verifyCountProductScreen(String unitsCount) {
        mobileCommands.waitForElement(countProductPageMap.btnNext());
        mobileCommands.elementDisplayed(countProductPageMap.btnNext());
        mobileCommands.click(countProductPageMap.unitCountEditTextField());
        mobileCommands.enterText(countProductPageMap.unitCountEditTextField(), unitsCount, false);
        mobileCommands.click(countProductPageMap.unitCountHdr());
        mobileCommands.click(countProductPageMap.btnNext());
    }

    public void verifyCountProductsPageTitle(String countProductTitle) {
        mobileCommands.waitForElement(countProductPageMap.countProductPageTitle());
        mobileCommands.assertElementText(countProductPageMap.countProductPageTitle(), countProductTitle, true);
    }

    public void clickNextBtn() {
        mobileCommands.waitForElementClickability(countProductPageMap.btnNext());
        mobileCommands.click(countProductPageMap.btnNext());
    }

    public void verifyNextBtnToBeDisabled() {
        mobileCommands.waitForElement(countProductPageMap.btnNext());
        mobileCommands.assertElementEnabled(countProductPageMap.btnNext(), true);
    }

    public void verifyNextBtn() {
        mobileCommands.waitForElement(countProductPageMap.btnNext());
        mobileCommands.assertElementEnabled(countProductPageMap.btnNext(), true);
    }

    public void clickOnCrossBar() {
        mobileCommands.waitForElement(countProductPageMap.crossBar());
        mobileCommands.click(countProductPageMap.crossBar());
    }

    public void verifyErrorMessages(String unitsCount, String inlineErrorMessage) {
        mobileCommands.elementDisplayed(countProductPageMap.btnNext());
        mobileCommands.click(countProductPageMap.unitCountEditTextField());
        mobileCommands.enterText(countProductPageMap.unitCountEditTextField(), unitsCount, false);
        mobileCommands.assertElementText(countProductPageMap.inLineErrorMessages(), inlineErrorMessage, true);
    }

    public void clickOnUpdateShelfAllocation(String shelfAllocationProdCount) {
        mobileCommands.waitForElement(countProductPageMap.shelfAllocationEditText());
        mobileCommands.click(countProductPageMap.shelfAllocationEditText());
        mobileCommands.enterText(countProductPageMap.shelfAllocationEditText(), shelfAllocationProdCount, false);
    }

    public void clickUpdateBtn() {
        mobileCommands.waitForElement(countProductPageMap.btnUpdate());
        mobileCommands.click(countProductPageMap.btnUpdate());
    }

    public void verifyUpdatedUnitCount(String updatedAllocationCount) {
        mobileCommands.waitForElement(countProductPageMap.unitCount());
        mobileCommands.assertElementText(countProductPageMap.unitCount(), updatedAllocationCount, true);
    }

    public void enterUnitCount(String unitsCount) throws InterruptedException {
        mobileCommands.click(countProductPageMap.unitCountEditTextField());
        mobileCommands.enterText(countProductPageMap.unitCountEditTextField(), unitsCount, false);
        mobileCommands.click(countProductPageMap.shelfAllocationTile());
        mobileCommands.click(countProductPageMap.btnNext());
    }

    public void editUnitCount(String editCount) throws InterruptedException {
        mobileCommands.click(countProductPageMap.unitCountEditTextField());
        mobileCommands.enterText(countProductPageMap.unitCountEditTextField(), editCount, false);
        mobileCommands.click(countProductPageMap.shelfAllocationTile());
        mobileCommands.click(countProductPageMap.btnNext());
    }

    public void UpdateShelfAllocation(String allocationCount) {
        mobileCommands.waitForElementClickability(countProductPageMap.ShelfAllocationEditIcon());
        mobileCommands.click(countProductPageMap.ShelfAllocationEditIcon());
        mobileCommands.enterText(countProductPageMap.shelfAllocationEditText(), allocationCount, false);
        mobileCommands.click(countProductPageMap.btnUpdate());

    }

    public void clickOnCrossIcon() {
        mobileCommands.waitForElement(countProductPageMap.crossBar());
        mobileCommands.click(countProductPageMap.crossBar());
    }

    public void clickOnShelfAllocationEditIcon() {
        mobileCommands.waitForElement(countProductPageMap.ShelfAllocationEditIcon());
        mobileCommands.click(countProductPageMap.ShelfAllocationEditIcon());
    }

    public void clickOnCancelBtn_UpdateAllocation() {
        mobileCommands.waitForElement(countProductPageMap.ShelfAllocationEditIcon());
        mobileCommands.click(countProductPageMap.ShelfAllocationEditIcon());
        mobileCommands.wait(5);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnCancel(), true);
        mobileCommands.waitForElement(countProductPageMap.btnCancel());
        mobileCommands.click(countProductPageMap.btnCancel());
    }

    public void verifyMultiLocationProductMessage_EnterCount(String multiLocationMessage_CountProduct) {
        mobileCommands.waitForElement(countProductPageMap.multiLocationMessage());
        mobileCommands.assertElementText(countProductPageMap.multiLocationMessage(), multiLocationMessage_CountProduct, true);
    }

    public void clickOnUpdateUnitCountTextField(String unitsCount) {
        mobileCommands.click(countProductPageMap.unitCountEditTextField());
        mobileCommands.enterText(countProductPageMap.unitCountEditTextField(), unitsCount, false);
        mobileCommands.click(countProductPageMap.unitCountHdr());
    }

    public void verifyDiscontinuedTags(String tagTxt) {
        mobileCommands.assertElementText(countProductPageMap.txtTag(), tagTxt, true);

    }

    public void clickContinue() {
        mobileCommands.click(countProductPageMap.btnContinue());
    }

}
