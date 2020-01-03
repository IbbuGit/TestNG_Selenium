package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;

import org.openqa.selenium.By;

public class TransferErrorMap {

    public By transferErrorPageTitle(){
        return By.xpath ( "//*[@text='Transfer Error']" );
    }

    public By transferErrorMessage(){
        return By.id ( "product_transfer_error_text" );
    }
}
