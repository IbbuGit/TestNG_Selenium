package com.krogerqa.appium.product_locator_app.common.ui.maps;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class TaskListPageMap {
    public By myDailyCount() {return By.xpath("//*[@text='My Daily Count' or @text='Mdc Capability']/..");}
    public By eTransfer() {return By.xpath("//*[@text='eTransfer']/..");}
    public By mainMenuPageTitle() {return By.xpath("//*[@text='Main Menu']");}
    public By backroomCount() {return By.xpath("//*[@text='Back Room Count']/..");}
    public By oneTimeOrder() {return By.xpath("//*[@text='One-Time Order']/..");}
    public By topStock() {return By.xpath("//*[@text='Top Stock']/..");}
    public By directedReplenishment() {return By.xpath("//*[@text='Directed Replenishment' or @text='DR Capability']/..");}
    public By sectionCheck() {return By.xpath("//*[@text='Section Check Capability' or @text='Section Check']/..");}
    public By selectDepartments() {return By.xpath("//*[contains(@text,'Select Department')]");}
    public By removeFromInventory(){return By.xpath("//*[@text='Remove Inventory']");}
    public By markdowns(){return By.xpath("//*[@text='Markdowns']");}
    public By freshAssistedOrdering(){return MobileBy.AndroidUIAutomator("new UiSelector().text(\"Fresh Assisted Ordering\")"); }

    public By taskListView(){return MobileBy.id("task_list_recycler_view");}
    public By taskTab(){return MobileBy.id("taskName");}
}