package com.krogerqa.appium.product_locator_app.common.ui.maps;


import org.openqa.selenium.By;


/**
 * Class Name : MainMenu PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class CountSubmittedPageMap {


    public By countSubmittedPageTitle(){
        return By.xpath ("//*[@text='Count Submitted']");
    }

    public By successImage(){
        return By.id("success_image");
    }

    public By textCompletedCount(){
        return By.id ( "text_completed_count"  );
    }

    public By textNumberOfProductsCompleted(){
        return By.id ( "text_number_of_products_completed" );
    }

    public By buttonNavigateToMainMenu(){
        return By.id ( "button_navigate_to_main_menu" );
    }
}