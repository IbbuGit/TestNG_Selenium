package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class KebabMenu extends Base {

    // Declaration class object
    private BeginOrderScreenPage beginOrderScreenPage;
    private MobileCommands mobileCommands;
    private OrderInProgressPage orderInprogressPage;
    private TutorialPage tutorialPage;
    private FaqPage faqPage;

    //Assign object for class
    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        orderInprogressPage = new OrderInProgressPage();
        faqPage = new FaqPage();
        tutorialPage = new TutorialPage();
        mobileCommands = new MobileCommands();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    /*
     *   Test Name:          faq_kebab
     *   Test Description:   Verifying faq option in kebab menu.
     *   Scenario tested:    The user is on the new order screen and taps on FAQs in Kebab menu and verifies the options in FAQ screen
     *   Story id:           2202
     *   Epic id:            11488
     *   Test data:          data independent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *   UI screen tested:
     *                       1. Begin Order Screen
     *                       2. Order in progress pop up
     *                       3. faq page
     */
    void faq_kebab(){
        //begin order screen
        orderInprogressPage.clickNewOrder();
        mobileCommands.wait(3);
        beginOrderScreenPage.clickKebabMenu();
        beginOrderScreenPage.ValidateAndClickFaq();
        //FAQ screen
        faqPage.ValidateOptOto();
        faqPage.NavigateBack();
    }

    @Test(groups = {"regression"},alwaysRun = true)
    public void tutorial_kebab(){
        /*
         *   Test Name:          tutorial_kebab
         *   Test Description:   Verifying Tutorial option in kebab menu.
         *   Scenario tested:    The user is on the new order screen and taps on Tutorial in Kebab menu and verifies all the screens of One-Time Order Tutorial
         *   Story id:           2202
         *   Epic id:            11488
         *   Test data:          data independent
         *   API tested:
         *                       1. api/v1/adhoc-order-items
         *   UI screen tested:
         *                       1. Begin Order Screen
         *                       2. Order in progress pop up
         *                       3. Tutorial screens
         */
        orderInprogressPage.clickNewOrder();
        mobileCommands.wait(3);
        beginOrderScreenPage.clickKebabMenu();
        beginOrderScreenPage.validateAndClickTutorial();
        tutorialPage.validateScanProductText(oto_Data.getScanProductTitle());
        tutorialPage.validateAndClickNext();
        tutorialPage.validateUpdateOrderText(oto_Data.getUpdateOrderHeaderText());
        tutorialPage.validateAndClickBack();
        tutorialPage.validateScanProductText(oto_Data.getScanProductTitle());
        tutorialPage.validateAndClickNext();
        tutorialPage.validateAndClickNext();
        tutorialPage.validateConfirmOrder(oto_Data.getConfirmOrderTitle());
        tutorialPage.validateAndClickNext();
        beginOrderScreenPage.validateBeginOrderTitle();
    }
}