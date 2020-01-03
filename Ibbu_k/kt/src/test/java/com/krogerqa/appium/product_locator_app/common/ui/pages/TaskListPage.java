package com.krogerqa.appium.product_locator_app.common.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.common.ui.maps.TaskListPageMap;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TaskListPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private TaskListPageMap taskListPageMap;
    private CommonPage commonPage = new CommonPage();

    public TaskListPage() {
        taskListPageMap = new TaskListPageMap();
    }

    public void validateMainMenuPageTitle() {
        mobileCommands.assertElementDisplayed(taskListPageMap.mainMenuPageTitle(), true);
    }

    public double clickMyDailyCount() {
        mobileCommands.click(taskListPageMap.myDailyCount());
        return commonPage.getTime();
    }

    public double validateSelectDepartments() {
        double doubleNum = 0;
        try {
            if (mobileCommands.isElementExist(taskListPageMap.selectDepartments())) {
                doubleNum = commonPage.getTime();
            }
        } catch (Exception e) {

        }
        return doubleNum;
    }
    public void clickBackroomCount() {
        mobileCommands.waitForElement(taskListPageMap.backroomCount());
        mobileCommands.click(taskListPageMap.backroomCount());
    }
    public void clickETransfer() {
        if (BaseUtil.isElementPresent(taskListPageMap.eTransfer(), 1)) {
            mobileCommands.click(taskListPageMap.eTransfer());
        } else {
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            mobileCommands.click(taskListPageMap.eTransfer());
        }
    }

    public void clickOneTimeOrder() {
        mobileCommands.click(taskListPageMap.oneTimeOrder());
    }

    public void clickTopStock() {
        mobileCommands.click(taskListPageMap.topStock());
    }

    public void clickDirectedReplenishment() {
        mobileCommands.click(taskListPageMap.directedReplenishment());
    }

    public void clickSectionCheck() {

        if (BaseUtil.isElementPresent(taskListPageMap.sectionCheck(), 2)) {
            mobileCommands.click(taskListPageMap.sectionCheck());
        } else {
            //mobileCommands.scrollDown();
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            mobileCommands.click(taskListPageMap.sectionCheck());
        }
    }

    public void validateMDCButtonResponseTime(double beforeTime, double afterTime) {
        int time = (int) (afterTime - beforeTime) / 1000;
        //System.out.println ( "Time between MDC & Select departments" +time+" Secs " );
        Assert.assertTrue(time > 1 && time < 30);
    }

    //    public void clickBackroomCount() {
//        mobileCommands.click(taskListPageMap.backroomCount());
//    }
    public void clickRemoveFromInventory() {

        if (BaseUtil.isElementPresent(taskListPageMap.removeFromInventory(), 2)) {
            mobileCommands.click(taskListPageMap.removeFromInventory());
        } else {
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            mobileCommands.click(taskListPageMap.removeFromInventory());
        }
    }

    public void clickMarkdowns() {
        mobileCommands.waitForElement(taskListPageMap.markdowns());
        mobileCommands.click(taskListPageMap.markdowns());
    }

    public void tapOnFreshAssistedOrdering() {
        try {
            mobileCommands.element(taskListPageMap.freshAssistedOrdering()).click();
        } catch (NoSuchElementException e) {
            mobileCommands.scrollDownToFindVisibleText("Fresh Assisted Ordering");
            mobileCommands.element(taskListPageMap.freshAssistedOrdering()).click();
        }
    }
    public void validateTaskListScreen(){
        mobileCommands.assertElementDisplayed(taskListPageMap.taskListView(),true);
        BaseUtil.isElementPresent(taskListPageMap.taskTab(),2);
    }
}