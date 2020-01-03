package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;



import org.openqa.selenium.By;



/**
 * Class Name : ETransferTutorial PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class ETransferTutorialPageMap {


    public By locateTheProduct(){
      return By.xpath ( "//*[@text='Select Transfer Location']" ) ;
    }

    public By nextElem(){
     return By.xpath ( "//*[@text='Next']" );
    }

    public By countProduct(){
     return By.xpath ( "//*[@text='Add Product to Transfer']" );
    }

    public By gotItElem(){
      return By.xpath ( "//*[@text='Got it!']" )  ;
    }

    public By confCount(){
       return By.xpath ( "//*[@text='Submit Transfer']" ) ;
    }

    public By eTransfersTutorial(){
        return By.xpath ( "//*[@text='e-Transfers Tutorial']" );
    };

}