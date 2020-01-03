
package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.ScanProductDRPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

import java.io.IOException;


public class ScanProductDRPage {

    //BaseCommands baseCommands=new BaseCommands();
    MobileCommands mobileCommands = new MobileCommands();

    ScanProductDRPageMap scanProductDRPageMap;

    public ScanProductDRPage() {
        scanProductDRPageMap = new ScanProductDRPageMap();

    }

    /*
     *   Click Find and Scan product
     */
    public void clickFindAndScan() throws IOException, InterruptedException {
        mobileCommands.click(scanProductDRPageMap.txtFindAndScanProduct());
    }

    /*
     *   Verify the display of Scan Product
     */
    public void validateScanProductDR() throws InterruptedException, IOException {
        mobileCommands.assertElementDisplayed(scanProductDRPageMap.headerScanProduct(), true);
    }

    public String getUPCText() {
        String text =  mobileCommands.getElementText(scanProductDRPageMap.txtDrUPC());
        return text;
    }
    public void validateImageScanBG() throws InterruptedException, IOException {
        mobileCommands.assertElementDisplayed(scanProductDRPageMap.imgScanBG(), true);
    }

    public void validateTextFindAndScan(String txtFindAndScan)
    {
        String text = mobileCommands.getElementText(scanProductDRPageMap.txtFindAndScanProduct());
        text = text.replace(" \n", "");
        Assert.assertEquals(text,txtFindAndScan);

    }
    public void clickCantFindAndSkip() {
        mobileCommands.wait(2);
        mobileCommands.click(scanProductDRPageMap.btnCantFindAndSkip());}
    public void verifyNetWorkErrorMessage(String networkErrorMsg) {
        //mobileCommands.waitForElement(scanProductDRPageMap.networkErrorMsg());
        mobileCommands.assertElementText(scanProductDRPageMap.networkErrorMsg(), networkErrorMsg, true);
    }
    public void verifyNetWorkErrorMessageWhenClickDR(String networkErrorMsgWhenClickDR) {
        mobileCommands.assertElementText(scanProductDRPageMap.networkErrorMsgWhenClickDR(), networkErrorMsgWhenClickDR, true);
    }
}

