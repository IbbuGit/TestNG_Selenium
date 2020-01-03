package com.krogerqa.appium.product_locator_app.common.ui.pages;


import com.krogerqa.appium.product_locator_app.common.ui.maps.ManualProductEntryPageMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

/**
 * Class Name : TransferType Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */
    public class ManualProductEntryPage {
    MobileCommands mobileCommands = new MobileCommands();
    ManualProductEntryPageMap manualProductEntryPageMap;

    public ManualProductEntryPage (  )
    {
        manualProductEntryPageMap =new ManualProductEntryPageMap (  );
    }


    public void viewManualProductEntryPageTitle ( String manualProductEntry ) {
        //myAssert.assertTrue(manualProductEntryPageMap.manualProductEntryTitle.getText ().contains ( manualProductEntry ),"Verifying display of Manual Product Entry Page Title");
        Assert.assertTrue ( mobileCommands.getElementText ( manualProductEntryPageMap.manualProductEntryTitle ( ) ).contains ( manualProductEntry ) );
    }

    public void clickManualEnterUPCOrPLU( ) {
        mobileCommands.click ( manualProductEntryPageMap.clickOnTextField());
    }


    public void enterProductManually( ) {
        mobileCommands.assertElementDisplayed ( manualProductEntryPageMap.clickOnTextField(),true );
        //myAssert.assertTrue(isVisible(20, manualProductEntryPageMap.manualEnterUPCOrPLU));
    }

    public void verifyEnabledSubmitButton(){
        mobileCommands.assertElementEnabled ( manualProductEntryPageMap.submitButton(),true );
    }

    public void verifyDisabledSubmitButton(){
        mobileCommands.assertElementEnabled ( manualProductEntryPageMap.submitButton(),false );
    }

    public void clickManualUPCEntrySubmitButton( ) {mobileCommands.click (manualProductEntryPageMap.clickOnTextField()); }

    public void clickSubmitButton( ) {
        mobileCommands.click (  manualProductEntryPageMap.submitButton());
    }

    public void manualEntryUPC(String UPC) {
        mobileCommands.enterText ( manualProductEntryPageMap.clickOnTextField(),UPC,true );
    }

    public void enterUPCManually ( String upcData )
    {
        manualEntryUPC (upcData );
        //viewManualProductEntryPageTitle(data.manualProductEntryPageTitle);
    }

    public void viewBarcodeNotRecognizedPageTitle ( String barcodeNotRecognized ) {
        //myAssert.assertTrue ( manualProductEntryPageMap.barcodeNotRecognizedTitle.getText ( ).contains ( barcodeNotRecognized ), "Verifying display of Barcode Not Recognized Page Title" );
        Assert.assertTrue ( mobileCommands.getElementText ( manualProductEntryPageMap.barcodeNotRecognizedTitle ( ) ).contains ( barcodeNotRecognized ) );
    }

    //public void viewBarcodeNotRecognizedPageTitle( ManualMDCDataMap manualMDCDataMap ){
      //  viewBarcodeNotRecognizedPageTitle ( manualMDCDataMap.barcodeNotRecognizedPageTitle );
    //}

    //public void viewManualProductEntryPageTitle ( ETransfersDataMap eTransfersData ){
      //  viewManualProductEntryPageTitle(eTransfersData.manualProductEntryPageTitle);
    //}

    public void clickEnterProductUPC( ) { mobileCommands.click (manualProductEntryPageMap.enterProductUPC()); }

    public void clickManualEnterProductUPC( ) { mobileCommands.click (manualProductEntryPageMap.manualEnterProductUPC()); }


    public void manualEntryProductUPC(String UPC) {mobileCommands.enterText ( manualProductEntryPageMap.manualEnterProductUPC(), UPC,true ); }

    public void manualEnterProductUPC ( String upcData )
    {
        manualEntryProductUPC (upcData );
        //viewManualProductEntryPageTitle(data.manualProductEntryPageTitle);
    }

}