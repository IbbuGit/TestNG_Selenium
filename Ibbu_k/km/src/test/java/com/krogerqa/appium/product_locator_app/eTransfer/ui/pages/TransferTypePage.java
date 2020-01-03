package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.TransferTypePageMap;

import org.openqa.selenium.By;
import org.testng.Assert;


/**
 * Class Name : TransferType Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */
    public class TransferTypePage  {

    MobileCommands mobileCommands = new MobileCommands();
    TransferTypePageMap transferTypePageMap;

    public TransferTypePage ( )
    {
        transferTypePageMap =new TransferTypePageMap ( );
    }

    public void viewTransferTypePageTitle ( String transferType ) {
        Assert.assertTrue(mobileCommands.getElementText (transferTypePageMap.transferTypePageTitle()).contains (transferType  ) );
    }

    public void clickTransferPrdFrmDropDown( ) { mobileCommands.click (transferTypePageMap.transferPrdFrmDropDown()); }

   // public String selectTransferPrdFrmDropDown(ETransfersDataMap data ) {
     //  return selectTransferProductFrom(data.transferProductFrom );
    //}

    public String selectTransferProductFrom ( String transferProductFrom ) {
        mobileCommands.click ( By.xpath ("//android.widget.ListView/android.widget.CheckedTextView[@text='"+transferProductFrom+"']"));
       return transferProductFrom;
    }

    public void clickTransferPrdToDropDown( ) { mobileCommands.click ( transferTypePageMap.transferPrdToDropDown()); }

    public void selectTransferPrdToDropDown(String selectedValue,String  transferProductTo ){
        mobileCommands.click ( By.xpath ("//android.widget.ListView/android.widget.CheckedTextView[@text='"+transferProductTo+"']"));

       /* for( MobileElement element:transferTypePageMap.frmToDrpList ){
            if(element.getText ().equalsIgnoreCase ( selectedValue )){
                Assert.assertFalse ( element.getText ( ).equalsIgnoreCase ( selectedValue ), "Selected from value:" + selectedValue + " displayed in to list dropdown" );
            }
        }*/
         //selectTransferPrdToDropDown( transferProductTo );
    }

  /*  public void selectTransferPrdToDropDown(String toValue ) {
        for( MobileElement element:transferTypePageMap.frmToDrpList ) {
            if(element.getText ( ).equalsIgnoreCase ( toValue )) {
               element.click ( );
               break;
            }
        }
    }*/


    public void verifyEnabledNextButton ( ){
        mobileCommands.assertElementEnabled ( transferTypePageMap.nextButton(),true );
    }


    public void verifyDisabledNextButton ( ){
        mobileCommands.assertElementEnabled ( transferTypePageMap.nextButton(),false );
    }



    public void clickNextButton( ) {mobileCommands.click ( transferTypePageMap.nextButton()); }

   // public void viewTransferTypePageTitle ( ETransfersDataMap eTransfersDataMap ){
     //   viewTransferTypePageTitle(eTransfersDataMap.transferTypePageTitle);
    //}

}