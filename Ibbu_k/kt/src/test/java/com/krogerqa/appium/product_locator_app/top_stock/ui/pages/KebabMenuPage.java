package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.KebabMenuPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class KebabMenuPage {
    MobileCommands mc = new MobileCommands();
    KebabMenuPageMap kebabMenuPageMap;

    public KebabMenuPage() {
        kebabMenuPageMap = new KebabMenuPageMap();
    }

    public void clickKebabMenuIcon() throws Throwable {
        mc.click(kebabMenuPageMap.kebabMenu());
    }

    public void clickTopStockTutorial() throws Throwable {
        mc.click(kebabMenuPageMap.topStockTutorialBtn());
    }

    public void clickFAQBtn() throws Throwable {
        mc.click(kebabMenuPageMap.fAQBtn());
    }

    public void clickAbout() throws Throwable {
        mc.click(kebabMenuPageMap.aboutBtn());
    }

    public void clickSignOutBtn() throws Throwable {
        mc.elementDisplayed(kebabMenuPageMap.signOutBtn());
        mc.click(kebabMenuPageMap.signOutBtn());
    }


    public void verifyTopStockTutorialTitle(String TutorialtitleMsg) throws Throwable {
        mc.assertElementText(kebabMenuPageMap.tutorialTitleMsg(), TutorialtitleMsg, true);
    }

    public void validateTutorialDescription(String TutorialDescMsg) throws Throwable {
        mc.assertElementText(kebabMenuPageMap.tutorialDescriptionMsg(), TutorialDescMsg, true);
    }

    public void ClickNextBtn() throws Throwable {
        mc.click(kebabMenuPageMap.nextBtn());
    }

    public void ClickBackBtn() throws Throwable {
        mc.click(kebabMenuPageMap.backBtn());
    }
}
