package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.SuccessPageMap;

/**
 * Class Name : TransferType Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */

    public class SuccessPage {

    MobileCommands mobileCommands = new MobileCommands();
    SuccessPageMap successPageMap;

   public SuccessPage ( )
   {
       successPageMap = new SuccessPageMap (  );
   }

    public void viewSuccessPageTitle ( String success ) {
        //mc.assertElementText ( successPageMap.successPageTitle (),success,true);
        Assert.assertTrue ( mobileCommands.getElementText ( successPageMap.successPageTitle ( ) ).contains ( success ), "Verifying display of Success Page Title" );
    }

    public void verifyTransferredProducts(int productsSize){
        Assert.assertTrue ( Integer.parseInt (mobileCommands.getElementText ( successPageMap.productTransferMsg ( ) ).split ( " " )[0])== productsSize,"Assert: Verify products transferred message" );
    }

    public void clickOnBackToMainMenuButton(){
        mobileCommands.click(successPageMap.backToMainMenuButton ());

    }
}