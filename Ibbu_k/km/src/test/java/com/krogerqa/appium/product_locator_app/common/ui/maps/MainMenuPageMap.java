package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;


/**
 * Class Name : MainMenu PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class MainMenuPageMap {



    public By myDailyCount(){
        return By.xpath("//*[@text='My Daily Count']/..");
    }

    public By eTransfer(){
        return By.xpath("//*[@text='eTransfer']/..");
    }

    public By mainMenuPageTitle(){
        return By.xpath ("//*[@text='Main Menu']"  );
    }

    public By backroomCount(){
        return By.xpath ( "//*[@text='Backroom Count']/.." );
    }

    public By oneTimeOrder(){
        return By.xpath ( "//*[@text='One Time Order']/.." );
    }

    public By topStock(){
        return By.xpath ("//*[@text='Top Stock']/.."   );
    }

    public By removeInventory(){ return By.xpath("//*[@text='Remove Inventory']/.." );}

}