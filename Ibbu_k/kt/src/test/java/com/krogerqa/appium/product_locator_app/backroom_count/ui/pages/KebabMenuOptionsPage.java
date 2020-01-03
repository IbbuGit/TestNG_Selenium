package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;


import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.KebabMenuOptionsMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class KebabMenuOptionsPage {
    MobileCommands mc = new MobileCommands();
    private KebabMenuOptionsMap kebabMenuOptionsMap;

    public KebabMenuOptionsPage() {
        kebabMenuOptionsMap = new KebabMenuOptionsMap();
    }

    public void clickKebabMenuIcon() {
        mc.click(kebabMenuOptionsMap.kebabMenu());
    }

    public void clickBackroomTutorial() {
        mc.click(kebabMenuOptionsMap.backroomTutorialBtn());
    }

    public void clickFAQBtn() {
        mc.click(kebabMenuOptionsMap.btnFAQs());
    }

    public void clickFAQBackroomBtn() {
        mc.click(kebabMenuOptionsMap.fAQBackroomCountBtn());
    }

    public void clickFAQBackArrow() {
        mc.click(kebabMenuOptionsMap.fAQBackArrow());
    }

    public void clickAbout() {
        mc.click(kebabMenuOptionsMap.aboutBtn());
    }

    public void ClickNextBtn() {

        mc.click(kebabMenuOptionsMap.nextBtn());

    }

}
