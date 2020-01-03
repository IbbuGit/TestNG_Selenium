package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;



import org.openqa.selenium.By;



/**
 * Class Name : SelectTransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class SelectTransferTypePageMap {

    public By selectTransferTypePageTitle(){
     return By.xpath ( "//*[@text='Select Transfer Type']" );
    }

    public By departmentToDepartment(){ return By.xpath ( "//*[@text='Department to Department']" ); }

    public By storeToStore(){
     return By.xpath ("//*[@text='Store to Store']"  );
    }

    public By inventoryLocationTransfer(){
     return By.xpath ( "//*[@text='Inventory Location Transfer']" );
    }

}