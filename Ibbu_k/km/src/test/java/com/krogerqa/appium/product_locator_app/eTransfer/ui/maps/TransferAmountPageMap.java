package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;



import org.openqa.selenium.By;



/**
 * Class Name : TransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class TransferAmountPageMap {


    public By transferAmountPageTitle(){
     return By.xpath ( "//*[@text='Transfer Amount']" );
    }

    public By addToTransferButton(){
     return By.id ( "add_to_transfer_button" );
    }

    public By closeImageButton(){
        return By.className ( "android.widget.ImageButton" );
    }

    public By stepperNumberBox(){
       return By.id ( "stepperNumberBox" );
    }

    public By stepperPlus(){
     return By.id ( "stepperPlus" );
    }

    public By stepperMinus(){
     return By.id ( "stepperMinus" );
    }

    public By showDetails(){
     return By.id ( "showDetails" );
    }

    public By productDesc(){
     return By.id ( "etransfer_desc_Text" );
    }

    public By buttonUpdate(){
     return By.id ("button_update");
    }

    public By removeProductButton(){
     return By.id ("button_delete");
    }

    public By okButton(){
        return By.id ( "button1" );
    }

    public By okayButton(){
     return By.id ( "message" );
    }

    public By inventoryError(){
     return By.xpath ( "//*[@text='Inventory Error']" );
    }

    public By transferError(){
        return By.id ("product_transfer_error_text");
    }

    public By removeButton(){
        return By.xpath ( "//*[@text='REMOVE']" );
    }


}