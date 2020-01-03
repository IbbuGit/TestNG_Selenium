package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.DepartmentListMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;

public class DepartmentListPage extends Base {


    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();

    DepartmentListMap departmentListMap;

    public DepartmentListPage() {
        departmentListMap = new DepartmentListMap();
    }

    public void validateDepartmentListPageTitle(String departmentListTitle) {
        mobileCommands.assertElementText(departmentListMap.departmentTitle(), departmentListTitle, true);
    }

    public void selectDepartment(String deptName) {
        while(!(mobileCommands.getWebDriver().findElements(By.xpath("//*[contains(@text,'"+deptName+"')]")).size()>0)){
            commonPage.verticalSwipeByPercentages(0.6,0.3,0.5);
        }
        mobileCommands.click(By.xpath("//*[contains(@text,'"+deptName+"')]"));
    }


}
