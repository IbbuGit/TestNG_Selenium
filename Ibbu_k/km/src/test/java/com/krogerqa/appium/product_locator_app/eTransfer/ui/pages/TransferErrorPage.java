package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.TransferErrorMap;

public class TransferErrorPage {


    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();

    TransferErrorMap transferErrorMap;

    public TransferErrorPage() {
        transferErrorMap = new TransferErrorMap();
    }

    public void validateTransferErrorPageTitle(String transferError){
        mobileCommands.assertElementText(transferErrorMap.transferErrorPageTitle(),transferError,true);
    }

    public void validateTransferError(String transferErrorMessage){
        mobileCommands.assertElementText(transferErrorMap.transferErrorMessage(),transferErrorMessage,true);
    }
}
