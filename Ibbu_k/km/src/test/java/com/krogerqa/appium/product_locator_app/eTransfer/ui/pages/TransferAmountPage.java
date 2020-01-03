package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.TransferAmountPageMap;

/**
 * Class Name : TransferType Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */

    public class TransferAmountPage {
    MobileCommands mobileCommands = new MobileCommands();
    //BaseCommands bc =new BaseCommands();
    TransferAmountPageMap transferAmountPageMap;

    public TransferAmountPage (  ){
            transferAmountPageMap =new TransferAmountPageMap (  );
        }

    public void viewTransferAmountPageTitle ( String transferAmount ) {
        Assert.assertTrue (mobileCommands.getElementText (  transferAmountPageMap.transferAmountPageTitle( )).contains ( transferAmount ), "Verifying display of Transfer Amount Page Title" );
    }

    public void clickAddToTransferButton( ) {mobileCommands.click ( transferAmountPageMap.addToTransferButton ()); }

    public void clickCloseImageButton( ) { mobileCommands.click (transferAmountPageMap.closeImageButton()); }

    public void validateStepNumber(){
        Assert.assertEquals ( "",mobileCommands.getElementText (transferAmountPageMap.stepperNumberBox ()) );
    }

    public void addStepNumber ( ){
        mobileCommands.click ( transferAmountPageMap.stepperPlus ());
    }
    public void minusStepNumber ( ){
        mobileCommands.click ( transferAmountPageMap.stepperMinus ());
    }

    public void validateStepNumberForItemCount(String stepNumber){
        Assert.assertTrue(mobileCommands.getElementText (transferAmountPageMap.stepperNumberBox()).contains (stepNumber  ) );
    }

    public void verifyDisabledAddToTransferButton(){
        Assert.assertFalse (  mobileCommands.elementEnabled (  transferAmountPageMap.addToTransferButton()) );
    }


    public void verifyEnabledAddToTransferButton(){
        Assert.assertTrue( mobileCommands.elementEnabled (  transferAmountPageMap.addToTransferButton()));
    }

   // public void viewTransferAmountPageTitle ( ETransfersDataMap eTransfersData ){
     //   viewTransferAmountPageTitle(eTransfersData.transferAmountPageTitle);
    //}

    public void clickShowDetails ( ){ mobileCommands.click ( transferAmountPageMap.showDetails());
    }

    public void validateDeptNamesFromToDropDown (String transferProductFrom,String transferProductTo){
            String fromXpath  ="//*[contains(@text,'"+transferProductFrom+"')]";
            String toXpath    ="//*[contains(@text,'"+transferProductTo+"')]";
        mobileCommands.assertElementDisplayed ( By.xpath ( fromXpath ) ,true);
        mobileCommands.assertElementDisplayed ( By.xpath ( toXpath ) ,true);


    }

    public String getProductDesc(){
        return mobileCommands.getElementText (transferAmountPageMap.productDesc());

    }
    public String getStepNumber(){

        return mobileCommands.getElementText (transferAmountPageMap.stepperNumberBox());
    }

    public void verifyDisabledUpdateButton ( ){
        mobileCommands.assertElementEnabled ( transferAmountPageMap.buttonUpdate(),false );
       // myAssert.assertEquals ( "false", transferAmountPageMap.buttonUpdate.getAttribute ( "enabled" ) );
    }

    public void verifyEnabledUpdateButton ( ){
        mobileCommands.assertElementEnabled (transferAmountPageMap.buttonUpdate(),true);
       // myAssert.assertEquals ( "true", transferAmountPageMap.buttonUpdate.getAttribute ( "enabled" ) );
    }

    public void clickForUpdateProductQnty ( ){
        mobileCommands.click ( transferAmountPageMap.buttonUpdate());
    }

    public void clickRemoveProductButton ( ){mobileCommands.click ( transferAmountPageMap.removeProductButton());
    }

    public void clickOkButton ( ){ mobileCommands.click (transferAmountPageMap.okButton ( ));
    }

    public void clickTransferErrorOkayButton ( ){mobileCommands.click ( transferAmountPageMap.okayButton ( ));
    }
    public boolean handleInvetoryError(){

        if(mobileCommands.elementDisplayed (transferAmountPageMap.inventoryError())){
            clickTransferErrorOkayButton();
            mobileCommands.click ( transferAmountPageMap.closeImageButton( ));
            return true;
     }else{
            return false;
        }

    }

    public void validateTransferAmountExceedError(String amountExceedErrorMessage){
        mobileCommands.assertElementText(transferAmountPageMap.transferError(),amountExceedErrorMessage,true);
    }

    public void clickOnRemove(){
        mobileCommands.click(transferAmountPageMap.removeButton());
    }

    public void enterInventoryTransferAmount(String transferAmount){
        mobileCommands.enterText(transferAmountPageMap.stepperNumberBox(), transferAmount, true);
    }
}