package com.krogerqa.appium.product_locator_app.common.ui.pages;


import com.krogerqa.appium.product_locator_app.common.ui.maps.MainMenuPageMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

/** Class Name : MainMenu Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */
public class MainMenuPage {
    MobileCommands mobileCommands = new MobileCommands();
    MainMenuPageMap mainMenuPageMap;

    public MainMenuPage ( ) { mainMenuPageMap = new MainMenuPageMap(); }

    public void validateMainMenuPageTitle ( String mainMenu ) {
        //bc.assertElementText(mainMenuPageMap.mainMenuPageTitle(),mainMenu,true);
        Assert.assertTrue ( mobileCommands.getElementText ( mainMenuPageMap.mainMenuPageTitle ( ) ).contains ( mainMenu ), "Verifying display of Transfer Amount Page Title" );
    }

    public void clickMyDailyCount ( ) { mobileCommands.click ( mainMenuPageMap.myDailyCount() ); }

    public void clickBackroomCount ( ) {
        mobileCommands.click ( mainMenuPageMap.backroomCount());
    }

    public void clickETransfer ( ) {
        mobileCommands.click ( mainMenuPageMap.eTransfer ());
    }

    public void clickOneTimeOrder ( ) { mobileCommands.click ( mainMenuPageMap.oneTimeOrder()); }

    public void clickTopStock ( ) {
        mobileCommands.click (mainMenuPageMap.topStock());
    }

    public void clickRemoveInventory(){ mobileCommands.click(mainMenuPageMap.removeInventory());}

}
