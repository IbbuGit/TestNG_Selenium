
/**
 * Test case to verify scan product stock details screen screen
 * ALM test case
 * Created by -Raguapthi(syl7525)
 */
package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockProductStockMessagePageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class TopstockProductStockMessagePage {
    MobileCommands mc = new MobileCommands();
    TopStockProductStockMessagePageMap productStockMessagePageMap;

    public TopstockProductStockMessagePage() {
        productStockMessagePageMap = new TopStockProductStockMessagePageMap();
    }

    //Update unit count details
    public void EnterBalanceUnit(String BalanceUnit) throws Throwable {
        mc.enterText(productStockMessagePageMap.bohUnitCount(), BalanceUnit, true);
    }

    public void ClickUpdateBalanceBtn() throws Throwable {
        mc.click(productStockMessagePageMap.UpdateBalanceBtn());
    }

    public void NavigateBack() throws Throwable {
        mc.scrollToElement(productStockMessagePageMap.bohUnitCount(), "up");
    }

    public void validateAndClickStockBtn(String stockBtnTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.stockedBtn(), stockBtnTxt, true);
        mc.click(productStockMessagePageMap.stockedBtn());
    }

    public void ValidateAndClickNotStockedBtn(String notStockedBtnTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.notStockedBtn(), notStockedBtnTxt, true);
        mc.click(productStockMessagePageMap.notStockedBtn());
    }

    public void EnterStockUpcTxt(String stockUpcTxt) throws Throwable {
        mc.enterText(productStockMessagePageMap.upcNumber(), stockUpcTxt, true);
    }

    public void ValidateStockUpcTxt(String stockUpcTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.upcNumber(), stockUpcTxt, true);
    }

    public void ValidateBOHHeaderText(String bOHHeaderTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.BOHScreenHeaderTxt(), bOHHeaderTxt, true);

    }

    public void ValidateBOHincorrectProdcutText(String BOHIncorrectProdcutText) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.BOHIncorrectProductBalanceMsg(), BOHIncorrectProdcutText, true);
    }

    public void ValidateBOHUnitCountText(String BOHUnitCountText) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.BOHUnitCountTxt(), BOHUnitCountText, true);
    }

    public void ValidateBOHProdcutBalanceText(String BOHBalanceText) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.BOHBalanceTxt(), BOHBalanceText, true);
    }

    public void ValidateUpcprice(String ProductPrice) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.ProductPrice(), ProductPrice, true);
    }

    public void ValidateLessthanOneErrorMessage(String BOHLessthanOneErrMsg) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.BOHInLineErrorMsg(), BOHLessthanOneErrMsg, true);
    }

    public void verifyUnitCountTextField() throws Throwable {
        mc.elementEnabled(productStockMessagePageMap.bohUnitCount());
    }

    public void verifyStockShelfHeaderTxt(String stockShelfHdrTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.StockShelfHeaderTxt(), stockShelfHdrTxt, true);
    }

    public void verifyStockShelfHeaderTxt(){
        mc.elementExists(productStockMessagePageMap.StockShelfHeaderTxt());
    }

    public void ValidateProductStatus(String stockProductStatus) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.productStatus(), stockProductStatus, true);
    }

    public void ValidateScanProductStockStatus(String ProductStatus) throws Throwable {
        mc.waitForElement(productStockMessagePageMap.productStatus());
        mc.assertElementText(productStockMessagePageMap.productStatus(), ProductStatus, true);
    }

    public void ValidateAndClickSubmitBtn(String SubmitBtnTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.Dialog_Sub_Btn(), SubmitBtnTxt, true);
        mc.click(productStockMessagePageMap.Dialog_Sub_Btn());
    }

    public void ValidateAndClickCancelBtn(String CancelBtnTxt) throws Throwable {
        mc.assertElementText(productStockMessagePageMap.Dialog_Cancel_Btn(), CancelBtnTxt, true);
    }

    public void clickStockedBtn() {
            mc.click(productStockMessagePageMap.stockedBtn());
    }

    public void clickNotStockedBtn() {
        mc.click(productStockMessagePageMap.notStockedBtn());
    }

    public void clickOnReviewBtn() {
        mc.click(productStockMessagePageMap.reviewBtn());
    }

    public void clickOnNotStockedBtn() {
        mc.click(productStockMessagePageMap.notStockedBtn());
    }

    public void verifystockedBtn(){
        mc.elementExists(productStockMessagePageMap.stockedBtn());
    }

    public void verifyNoStockingNeededMsg(String noStockingNeededMsg) {
        mc.assertElementText(productStockMessagePageMap.noStockingNeededMsg(), noStockingNeededMsg, true);
    }
    public void verifyBOHHeaderText(String updateBalanceHdr){
        mc.assertElementText(productStockMessagePageMap.BOHScreenHeaderTxt(),updateBalanceHdr,true);
    }
}
