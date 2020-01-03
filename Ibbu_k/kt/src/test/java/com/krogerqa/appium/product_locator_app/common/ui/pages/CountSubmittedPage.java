package com.krogerqa.appium.product_locator_app.common.ui.pages;


import com.krogerqa.appium.product_locator_app.common.ui.maps.CountSubmittedPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

/** Class Name : MainMenu Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */

public class CountSubmittedPage {
    MobileCommands mobileCommands = new MobileCommands();

    CountSubmittedPageMap countSubmittedPageMap;

    public CountSubmittedPage ( ) {

        countSubmittedPageMap =new CountSubmittedPageMap ();
    }


    public void validateCountSubmittedPageTitle ( String countSubmitted ) {
       // myAssert.assertTrue(countSubmittedPageMap.countSubmittedPageTitle.getText().contains(countSubmitted),"Verify display of count Submitted Page Title");
        Assert.assertTrue ( mobileCommands.getElementText ( countSubmittedPageMap.countSubmittedPageTitle ( ) ).contains ( countSubmitted ) );
    }


    public void clickMainMenuButton ( ) {
        mobileCommands.click ( countSubmittedPageMap.buttonNavigateToMainMenu());
    }


    public void validateSuccessImage ( ) {
        mobileCommands.assertElementDisplayed ( countSubmittedPageMap .successImage(),true);
      //  myAssert.assertTrue(isVisibleByElement ( 1,countSubmittedPageMap.successImage));
    }



    public void validateTextNumberOfProductsCompleted ( ) {
        mobileCommands.assertElementDisplayed (countSubmittedPageMap.textNumberOfProductsCompleted(),true);
                //myAssert.assertTrue(isVisibleByElement ( 1,countSubmittedPageMap.textNumberOfProductsCompleted));
    }

    public void validateTextNumberOfProductsCompleted (String  prdCount) {

        //myAssert.assertTrue(countSubmittedPageMap.textNumberOfProductsCompleted.getText ().contains ( prdCount ));
        Assert.assertTrue ( mobileCommands.getElementText ( countSubmittedPageMap.textNumberOfProductsCompleted ( ) ).contains ( prdCount ) );
    }

}
