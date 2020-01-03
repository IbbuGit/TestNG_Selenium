package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.SelectTransferTypePageMap;

/**
 * Class Name : SelectTransferType Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */
    public class SelectTransferTypePage {

    MobileCommands mobileCommands = new MobileCommands();

  SelectTransferTypePageMap selectTransferTypePageMap;

    public SelectTransferTypePage ()
    {
        selectTransferTypePageMap =new SelectTransferTypePageMap ();
    }


    public void viewSelectTransferTypePageTitle ( String transferType ) {
       // mc.assertElementText (selectTransferTypePageMap.selectTransferTypePageTitle(),transferType ,true);
        Assert.assertTrue ( mobileCommands.getElementText ( selectTransferTypePageMap.selectTransferTypePageTitle ( ) ).contains ( transferType ), "Verifying display of Transfer Amount Page Title" );
    }


    public void clickInventoryLocationTransfer ( ) { mobileCommands.click ( selectTransferTypePageMap.inventoryLocationTransfer( )); }



    public void clickDepartmentToDepartment( ) {
        mobileCommands.click ( selectTransferTypePageMap.departmentToDepartment( ));
    }

    public void clickStoreToStore( ) {
        mobileCommands.click ( selectTransferTypePageMap.storeToStore());
    }




   // public void viewSelectTransferTypePageTitle( ETransfersDataMap eTransfersDataMap ){
     //   viewSelectTransferTypePageTitle(eTransfersDataMap.transferTypePageTitle);
    //}
}