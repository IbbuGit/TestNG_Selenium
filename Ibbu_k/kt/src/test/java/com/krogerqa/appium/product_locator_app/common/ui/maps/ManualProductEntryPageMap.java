package com.krogerqa.appium.product_locator_app.common.ui.maps;

import org.openqa.selenium.By;



/**
 * Class Name : TransferType PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9159
 */

public class ManualProductEntryPageMap {

    public By manualProductEntryTitle(){
        return By.id ("manualentry_title" );
    }

    public By manualEnterUPCOrPLU(){
        return By.id ( "enter_upc_plu" );
    }

    public By submitButton(){
        return By.id ( "dialog_submit_button" );
    }

    public By manualUPCEntrySubmitButton(){
        return By.id ("manual_upc_entry_submit_button"  );
    }

    public By barcodeNotRecognizedTitle(){
        return By.id ("manual_upc_entry_header"  );
    }

    public By enterProductUPC(){
        return By.id ( "manual_upc_entry_view" );
    }

    public By manualEnterProductUPC(){
        return By.id ( "manual_upc_entry_edit_text" );
    }
    public By clickOnTextField(){
        return By.id ( "dialog_edit_text" );
    }
}