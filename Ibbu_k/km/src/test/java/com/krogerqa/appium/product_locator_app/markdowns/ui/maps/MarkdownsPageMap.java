package com.krogerqa.appium.product_locator_app.markdowns.ui.maps;

import org.openqa.selenium.By;

public class MarkdownsPageMap {

    public By markdownsPageTitle(){
        return By.xpath ( "//*[@text='Markdowns']" );
    }
    public By printerSelection(){
        return By.xpath ( "//*[@text='Back Room Printer']" );
    }
    public By enterUPCButton(){
        return By.xpath ( "//*[@text='ENTER UPC']" );
    }
    public By enterUPCInputField(){
        return By.xpath ( "(//*[@text='Enter UPC or PLU'])[1]" );
    }
    public By enterUPCSubmitlink(){
        return By.xpath ( "//*[@text='SUBMIT']" );
    }

}
