package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class DepartmentListMap {

    public By departmentTitle(){
        return By.xpath ( "//*[@text='Your Department']" );
    }

  /*  public By bakeryDepartment(){
        return By.xpath ("//*[contains(@text,'Bakery')]" );
    }
    public By foodServiceDepartment(){
        return By.xpath ("//*[contains(@text,'Food Service')]" );
    }

    @AndroidFindBy(id = "etransfer_dept_list_item")
    public List<MobileElement> deptList;*/

}
