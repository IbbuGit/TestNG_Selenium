package com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.ui.maps.ReclaimMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class ReclaimPage {
    MobileCommands mobileCommands = new MobileCommands();
    ReclaimMap reclaimMap;
    CommonPage commonPage;

    public ReclaimPage() {
        reclaimMap = new ReclaimMap();
        commonPage=new CommonPage();
    }

    public void clickReclaimBtnAndValidate(){
        mobileCommands.click(reclaimMap.btnReclaim());
        mobileCommands.assertElementDisplayed(reclaimMap.reclaimPageTitle(), true);
    }

    public void checkReclaimBannerForYes(){
        mobileCommands.assertElementDisplayed(reclaimMap.reclaimBanner(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.reclaimBannerText(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.yesButton(), true);
        mobileCommands.click(reclaimMap.yesButton());
    }

    public void checkReclaimBannerForNo(){
        mobileCommands.assertElementDisplayed(reclaimMap.reclaimBanner(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.reclaimBannerText(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.yesButton(), true);
        mobileCommands.click(reclaimMap.noButton());
    }
    public void validateCorpBrandUPCBanner(){
        mobileCommands.assertElementDisplayed(reclaimMap.corpBrandPopUp(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.corpBrandPopUpText(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.donateRadioButton(),true);
        mobileCommands.assertElementDisplayed(reclaimMap.discardRadioButton(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.markdownRadioButton(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.continueButton(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.cancelButton(), true);
    }
    public void donateCorpBrandButton(){
        mobileCommands.click(reclaimMap.donateRadioButton());
        mobileCommands.click(reclaimMap.continueButton());
    }
    public void discardCorpBrandButton(){
        mobileCommands.click(reclaimMap.discardRadioButton());
        mobileCommands.click(reclaimMap.continueButton());
    }
    public void markdownCorpBrandButton(){
        mobileCommands.click(reclaimMap.markdownRadioButton());
        mobileCommands.click(reclaimMap.continueButton());
        mobileCommands.assertElementDisplayed(reclaimMap.reduceAndSellBanner(), true);
        mobileCommands.assertElementDisplayed(reclaimMap.reduceAndSellText(), true);
    }
    public void clickReclaim(){
        mobileCommands.click(reclaimMap.btnReclaim());
    }
    public void alertTitleMessage(String popUp){
        mobileCommands.assertElementText(reclaimMap.alertTitle(), popUp, true);
}
    public void clickOk(){
mobileCommands.click(reclaimMap.clickOk());
}

    public void clickYes(){
        mobileCommands.click(reclaimMap.yesButton());
}

    public void clickContinue(){
        mobileCommands.click(reclaimMap.continueButton());
}

    public void textCountTitle(){
        mobileCommands.getElementText(reclaimMap.textCountTitle());
}
    public void validatetextCountTitle(String messageTitle) {
        mobileCommands.assertElementDisplayed(reclaimMap.textCountTitle(), true);
        mobileCommands.assertElementText(reclaimMap.textCountTitle(), messageTitle, true);
    }
}
