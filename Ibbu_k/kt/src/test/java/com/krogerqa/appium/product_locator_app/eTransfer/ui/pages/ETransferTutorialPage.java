package com.krogerqa.appium.product_locator_app.eTransfer.ui.pages;


import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import com.krogerqa.appium.product_locator_app.eTransfer.ui.maps.ETransferTutorialPageMap;
/**
 * Class Name : ETransferTutorial Page
 * description : This class contains validations of related methods.
 *
 * @author SYL9159
 */
public class ETransferTutorialPage{
    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage=new CommonPage ();

    ETransferTutorialPageMap eTransferTutorialPageMap;

    public ETransferTutorialPage ( )
    {
        eTransferTutorialPageMap =new ETransferTutorialPageMap ();
    }

    public void  verifyLocateTheProduct(){
        mobileCommands.assertElementDisplayed (eTransferTutorialPageMap.locateTheProduct(),true );
    }

     public void  clickNext(){mobileCommands.click ( eTransferTutorialPageMap.nextElem());}


    public void  verifyCountProduct(){
        mobileCommands.assertElementDisplayed(eTransferTutorialPageMap.countProduct(),true );
    }

    public void  verifyConfCount(){
        mobileCommands.assertElementDisplayed(eTransferTutorialPageMap.confCount(),true );
    }

    public void  clickGotIt(){ mobileCommands.click ( eTransferTutorialPageMap.gotItElem()); }

    public void  clickETransferTutorial(){
    //    eTransferTutorialPageMap.eTransfersTutorial.click ( );
        commonPage.clickKebabElement("Tutorial");
      }
    }