package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.PendingOrderScreenPage;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.PendingPopPage;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidatePendingOrder extends Base {

    private MobileCommands mobileCommands;
    private PendingPopPage pendingPopPage;
    private PendingOrderScreenPage pendingOrderScreenPage;
    private TaskListPage taskListPage;



    //Assign object for class
    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {

        pendingPopPage = new PendingPopPage();
        pendingOrderScreenPage = new PendingOrderScreenPage();
        taskListPage = new TaskListPage();
        mobileCommands = new MobileCommands();
    }


    @Test(groups = {"regression"}, alwaysRun = true)
    /*
     *   Test Name:          validatePendingOrderScreen
     *   Test Description:   Verifying Pending products status popup functionality and Pending Order Update screen.
     *   Scenario tested:    The user is on the new order screen gets the poll time pending pop up and verifies the pending pop up, taps on VIEW DETAILS in pop up and verifies pending Order screen
     *   Story id:           14181,19162,18540,19046,18229,18228,18541,18539,18810
     *   Epic id:            17115
     *   Test data:          data dependent
     *   API tested:
     *                       1. api/v1/adhoc-order-items
     *                       2. api/v1/update-adhoc-items
     *   UI screen tested:
     *                       1. pending product status pop up
     *                       2. pending order update Screen
     */
    public void validatePendingOrderScreen() {
        //Getting the Date and time while clicking Submit button from ValidateOrderSummaryUI Class
        //and appended the "Placed" keyword
        String dateAndTime = "Placed " + ValidateOrderSummaryUI.currentDate;
        //Given wait statement because of pending status popup taking few seconds to display
        mobileCommands.wait(3);
        pendingPopPage.validatePendingPopTitle(oto_Data.getDlgTitle());
        mobileCommands.browserBack();
        taskListPage.clickOneTimeOrder();
        pendingPopPage.validatePendingMsg(oto_Data.getPendingProducts());
        pendingPopPage.validateTextDisclaimer();
        pendingPopPage.validateAndClickMainMenu(oto_Data.getTextMainMenu());
        taskListPage.clickOneTimeOrder();
        pendingPopPage.validateAndClickViewDetails(oto_Data.getTextViewDetails());

        //Pending Order Screen
        pendingOrderScreenPage.validatePendingOrderHeader(oto_Data.getPendingHeader());
        pendingOrderScreenPage.validatePlacedDateAndTime(dateAndTime);
        pendingOrderScreenPage.validatePendingMsg(oto_Data.getPendingMsg());
        pendingOrderScreenPage.validateAndClickMainMenuBtn(oto_Data.getTextMainMenu());
        mobileCommands.wait(600);
        taskListPage.clickOneTimeOrder();
        pendingPopPage.validateAndClickViewDetails(oto_Data.getTextViewDetails());
        pendingOrderScreenPage.validateAndClickXBtn();

        mobileCommands.wait(300);

        taskListPage.clickOneTimeOrder();
        mobileCommands.wait(3);
        pendingPopPage.validatePendingPopTitle(oto_Data.getDlgTitle());
        pendingPopPage.validateContinue(oto_Data.getTextcontinue());
        pendingPopPage.validateAndClickViewDetails(oto_Data.getTextViewDetails());
        //pendingPopPage.validateUnsuccessfulMsg(oto_Data.getUnsuccessfulProducts());
        pendingOrderScreenPage.validateAndClickContinueBtn(oto_Data.getTextcontinue());

    }
}
