package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;


import java.util.List;


/**
 * Class Name : TransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class TransferTypePageMap {



    public By transferTypePageTitle(){
     return By.xpath ( "//*[@text='Transfer Type']" );
    }

    public By clickBackArrowButton(){
        return By.xpath ("//android.widget.ImageButton[@index='0']"  );
    }

    public By clickNextButton(){
     return By.xpath ( "//*[@text='NEXT']" );
    }

    public By transferPrdFrmDropDown(){
        return By.id ( "rl_from" );
    }

    public By frmDrpDwnList(){
        return By.xpath ( "//*[@class='android.widget.ListView']" );
    }

    public By selectBackroom(){
     return By.xpath ("//*[@text='Backroom']");
    }

    public By transferPrdToDropDown(){
        return By.id ( "rl_to" );
    }

    public By selectKiosk(){
     return By.xpath ( "//*[@text='Kiosk']" );
    }

    public By nextButton(){
        return By.id ( "btn_next" );
    }

    @AndroidFindBy ( id =( "text1" ))
    public List < MobileElement > frmToDrpList;

}