package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;


import org.openqa.selenium.By;



/**
 * Class Name : TransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class SuccessPageMap {


    public By successPageTitle(){
     return By.xpath ( "//*[@text='Transfer Complete']" );
    }

    public By productTransferMsg(){
     return By.id ( "products_transfer" );
    }

    public By backToMainMenuButton(){
        return By.id ( "back_to_main_menu_button" );
    }

}

