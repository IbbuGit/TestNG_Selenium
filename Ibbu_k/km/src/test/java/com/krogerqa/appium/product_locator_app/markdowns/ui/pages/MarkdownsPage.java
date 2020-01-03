package com.krogerqa.appium.product_locator_app.markdowns.ui.pages;

import com.krogerqa.appium.product_locator_app.markdowns.ui.maps.MarkdownsPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.Assert;

public class  MarkdownsPage {
    MobileCommands mobileCommands = new MobileCommands();

    MarkdownsPageMap MarkdownsPageMap;

    public MarkdownsPage ( )
    {
        MarkdownsPageMap =new MarkdownsPageMap();
    }

    public void verifyMarkdownsPageTitle(String Markdowns){
        mobileCommands.waitForElementVisibility(MarkdownsPageMap.markdownsPageTitle());
        Assert.assertTrue ( mobileCommands.getElementText ( MarkdownsPageMap.markdownsPageTitle() ).contains ( Markdowns ), "Verifying the display of Markdownspage title" );
    }

    public void selectingPrinter(){
        mobileCommands.waitForElementVisibility(MarkdownsPageMap.printerSelection());
        mobileCommands.click(MarkdownsPageMap.printerSelection());
    }

    public void clickEnterUPC(){
        mobileCommands.waitForElementVisibility(MarkdownsPageMap.enterUPCButton());
        mobileCommands.click(MarkdownsPageMap.enterUPCButton());
    }

    public void provideDataInEnterUPC(String UPC){
        mobileCommands.waitForElementVisibility(MarkdownsPageMap.enterUPCInputField());
        mobileCommands.enterText(MarkdownsPageMap.enterUPCInputField(),UPC,true);
    }

    public void clickEnterUPCSubmitLink(){
        mobileCommands.waitForElementVisibility(MarkdownsPageMap.enterUPCSubmitlink());
        mobileCommands.click(MarkdownsPageMap.enterUPCSubmitlink());
    }
}
