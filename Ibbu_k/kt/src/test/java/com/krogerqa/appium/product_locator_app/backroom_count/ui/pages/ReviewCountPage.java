package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.ReviewCountPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class ReviewCountPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private ReviewCountPageMap reviewCountPageMap;

    private int wait;
    private int beforeCount;
    private String productCount;

    public ReviewCountPage() {
        reviewCountPageMap = new ReviewCountPageMap();
        wait = 10;
    }

    /*
     *   To click submit button
     */
    public void clickDeleteIcon() {
        mobileCommands.click(reviewCountPageMap.deleteIcon());
    }

    public void clickCancel() {
        mobileCommands.click(reviewCountPageMap.btnCancel());
    }

    public void validateRemoveProductPopup() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.alertTitle(), true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.message(), true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.btnCancel(), true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.btnRemove(), true);
    }

    public void clickRemove() {
        mobileCommands.click(reviewCountPageMap.btnRemove());

    }

    public void clickSubmit() {
        mobileCommands.click(reviewCountPageMap.btnSubmit());
    }

    public void clickAddMore() {
        mobileCommands.click((reviewCountPageMap.btnAddMore()));
    }

    //public void clickAddMore() { mobileCommands.click((reviewCountPageMap.btnAddMore())); }

    /*
     *   To validate Review product page title
     */
    public void validateReviewProductTitle(String reviewCount) {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.headerReviewProduct(), true);
    }

    public void validateAddMoreButton() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.btnAddMore(), true);
    }

    public void validateProdCard() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.txtProdDesc(), true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.imgProd(), true);
        mobileCommands.assertElementDisplayed(reviewCountPageMap.txtCaseNumber(), true);
    }

    public void clickEditCard() {
        mobileCommands.click(reviewCountPageMap.editCard());
    }

    public void clickAddMore(int UPCs) throws InterruptedException {
        mobileCommands.click((reviewCountPageMap.btnAddMore()));
    }

    public void clickProductUnitCount(int randomIndex) {
        mobileCommands.click(reviewCountPageMap.txtCaseNumber());
    }

    public void clickDeleteBtn(int randGen) {
        if (System.getenv("TESTTYPE").equalsIgnoreCase("e2e")) {
            productCount = productCountTextDetails();
            beforeCount = Integer.parseInt(productCount.split(" ")[0]);
        }
        mobileCommands.click(reviewCountPageMap.deleteIcon());
    }

    public String productCountTextDetails() {
        return mobileCommands.getElementText(reviewCountPageMap.productCountText());
    }

    public void productCountCheck() {
        if (System.getenv("TESTTYPE").equalsIgnoreCase("e2e")) {
            String expectedText = productCount.replace(Integer.toString(beforeCount), Integer.toString(beforeCount - 1));
            mobileCommands.assertElementText(reviewCountPageMap.productCountText(), expectedText, true);
        }
    }

    public void verifyBackgroundLoadingSpinnerDisabled() {
        mobileCommands.assertElementDisplayed(reviewCountPageMap.loadingSpinnerText(), false);
    }
}
