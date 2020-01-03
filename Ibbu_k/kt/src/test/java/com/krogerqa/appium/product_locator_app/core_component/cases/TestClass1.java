package com.krogerqa.appium.product_locator_app.core_component.cases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.core_component.dataBeans.Core_Component_TestDataBean;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.common.base.Base;

import java.lang.reflect.Method;
import java.util.Map;

public class TestClass1 extends Base {

    TaskListPage taskListPage;
    ScanProductPage scanProductPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        taskListPage=new TaskListPage();
        scanProductPage=new ScanProductPage();
    }

    @Test(groups = {"debug"})
    void debug_Test() throws Throwable {
        taskListPage.clickBackroomCount();
        scanProductPage.waitenterUpcButtonBeforeScan();
        scanProductPage.scanProduct(cc_Data.getProductToScan(),Symbology.UPC_A);
    }

    @Test(groups = {"Login test"})
    void LoginTest1() throws Throwable {
    }

    @Test(groups = {"Login test1"},dataProvider = "getData")
    void LoginTest3(Map<String, String> eachData) throws Throwable {

    }
}
