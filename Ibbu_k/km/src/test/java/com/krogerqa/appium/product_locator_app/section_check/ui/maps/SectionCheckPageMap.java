package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class SectionCheckPageMap {
    public By sectionCheckHdr(){
        return By.xpath("//*[@text='Section Check']");
    }
    public By btnEnterUPC(){
        return By.id("button_enter_upc");
    }
    public By selectYourLocationHdr(){
        return By.id("tvDialogTitle");
    }
    public By btnCancel_Location(){
        return By.id("btnCancel");
    }
    public By btnSelect_Location(){
        return By.id("btnSelect");
    }

}
