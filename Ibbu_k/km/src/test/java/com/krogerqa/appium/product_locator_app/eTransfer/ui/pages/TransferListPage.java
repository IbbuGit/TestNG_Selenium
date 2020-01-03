package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.TransferListPageMap;


    public class TransferListPage {

    MobileCommands mobileCommands = new MobileCommands();
    TransferListPageMap transferListPageMap;

    public TransferListPage ( ) {
        transferListPageMap =new TransferListPageMap ( );

    }

    public void viewTransferListPageTitle ( String transferList ) {
    mobileCommands.assertElementText(transferListPageMap.transferListPageTitle(),transferList,true);
    }

        public void verifyTransferListPageTitleAfterScanningProduct ( String transferList ) {
            mobileCommands.assertElementText(transferListPageMap.transferListPageTitleAfterScanningProduct(),transferList,true);
        }

    public void clickEnterUPCButton( ) { mobileCommands.click ( transferListPageMap.enterUPCButton()) ; }


    public void clickSubmitButton( ) {mobileCommands.click (  transferListPageMap.submitButton ()); }

  /*  public void viewTransferListPageTitle ( ETransfersDataMap eTransfersDataMap ){
        viewTransferListPageTitle(eTransfersDataMap.transferListPageTitle);
    }*/


    public void verifyProductDesc ( String productDesc ) {
        //myAssert.assertTrue ( transferListPageMap.itemDetailsText.getText ().contains (productDesc) , "Verifying Product Description" );
        Assert.assertTrue ( mobileCommands.getElementText ( transferListPageMap.itemDetailsText ( ) ).contains ( productDesc ),"Verifying Product Description"  );
    }

    public void verifyProductQnty ( String productQnty ) {
        //myAssert.assertTrue ( transferListPageMap.caseNumberText.getText ().contains (productQnty) , "Verifying display of Product Count" );
        Assert.assertTrue ( mobileCommands.getElementText ( transferListPageMap.caseNumberText ( ) ).contains ( productQnty ),"Verifying display of Product Count"  );
    }

    public void verifyProductCount (  ) {
       // myAssert.assertTrue ( transferListPageMap.textProductTransfer.getText ().contains ("1") , "Verifying display of Product Count" );
        Assert.assertTrue ( mobileCommands.getElementText ( transferListPageMap.textProductTransfer ( ) ).contains ( "1"),"Verifying display of Product Count"  );
    }

    public void verifyProductDetails ( String productDesc, String productQnty ){
        verifyProductDesc(productDesc);
        verifyProductQnty(productQnty);
        verifyProductCount();
    }

    public void clickForTransferAmountPage (  ) { mobileCommands.click ( transferListPageMap.itemDetailsText());
    }

    public void verifyUpdateQnty ( ) {
       // myAssert.assertTrue (isVisible ( 5, transferListPageMap.snackBarText ) );
        mobileCommands.assertElementDisplayed ( transferListPageMap.snackBarText(),true );
    }

    public void clickAddMoreButton( ) { mobileCommands.click (transferListPageMap.addMoreButton ( )) ; }

    public void clickReviewButton( ) { mobileCommands.click (transferListPageMap.reviewButton()) ; }

    public void verifyProductList (int productCount ){
        Assert.assertEquals ( productCount,transferListPageMap.productList.size ( ) );
       // myAssert.assertEquals ( productCount, transferListPageMap.productList.size ());
    }

    public void clickDeleteButton( ) { mobileCommands.click (transferListPageMap.deleteProduct( )) ; }

    public void verifyDisabledSubmitButton ( ){
        mobileCommands.assertElementEnabled (transferListPageMap.submitButton(),true  );
      // myAssert.assertEquals ( "false",transferListPageMap.submitButton.getAttribute ( "enabled" ) );
    }

    public void verifyProductsTransferred( ){
       // myAssert.assertTrue(transferListPageMap.textProductTransfer.getText ().contains ( "0" ) );
        Assert.assertTrue ( mobileCommands.getElementText ( transferListPageMap.textProductTransfer ( ) ).contains ( "0") );
    }

    public void clickRemoveButton ( ){ mobileCommands.click (transferListPageMap.removeButton()); }

    public void clickContinueButton ( ){ mobileCommands.click (transferListPageMap.continueButton()); }


    public void clickRemoveAllListButton ( ){
        mobileCommands.click ( transferListPageMap.deleteAll( ));
    }


    public void backFromTransferPage (  ){
        backAndroidButton ();
    }

    public void clickDeleteButtonMoreThanOne( ) {
        transferListPageMap.deleteProductList.get ( 0 ).click (); ; }


    protected void backAndroidButton() {
        (( AppiumDriver )mobileCommands.getWebDriver ( )).navigate ( ).back ( );
    }
        public void clickOnChangeDepartment(){
            mobileCommands.click(transferListPageMap.changeDepartmentBtn());
        }

        public void verifyTransferToText(){
        mobileCommands.assertElementDisplayed(transferListPageMap.transferToText(),true);
        }

        public void verifyDepartmentChangeIcon(){
        mobileCommands.assertElementDisplayed(transferListPageMap.departmentIcon(),true);
        }

        public void verifyDepartmentName(String departmentName){
        //mobileCommands.assertElementText(transferListPageMap.departmentName(),departmentName,true);
            Assert.assertTrue(mobileCommands.getElementText ( transferListPageMap.departmentName()).contains (departmentName),"Verifying name of the Selected Department"  );

        }

        public void validateReviewButton(){
        mobileCommands.assertElementDisplayed(transferListPageMap.reviewButton(),true);
        }

        public void validateEnterUPCButton(){
            mobileCommands.assertElementDisplayed(transferListPageMap.enterUPCButton(),true);
        }

        public void validateDeleteAlertTitle(String deleteAlertTitle){
        mobileCommands.assertElementText(transferListPageMap.deleteAlertTitle(),deleteAlertTitle,true);
        }

        public void clickOnProductCard(){
        mobileCommands.click(transferListPageMap.productCardImage());
        }

        public void validateDeptErrorPopUp(){
            mobileCommands.assertElementDisplayed(transferListPageMap.deptErrorTitle(), true);
            mobileCommands.assertElementDisplayed(transferListPageMap.btnOkay(), true);
            mobileCommands.click(transferListPageMap.btnOkay());
        }
}