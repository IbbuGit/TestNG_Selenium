package com.krogerqa.appium.product_locator_app.eTransfer.ui.maps;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import java.util.List;



public class TransferListPageMap {


    public By transferListPageTitle(){
        return By.xpath ( "//*[@text='Transfer List']" );
    }

    public By transferListPageTitleAfterScanningProduct(){
        return By.xpath ( "//*[@text='Add More']" );
    }

    public By enterUPCButton(){
     return By.xpath ( "//*[@text='ENTER UPC']" );
    }

    public By submitButton(){
     return By.id ( "button_submit" );
    }

    public By caseNumberText(){
     return By.id ( "caseNumberText" );
    }

    public By itemDetailsText(){
     return By.id ( "itemDetailsText" );
    }

    public By textProductTransfer(){
     return By.id ( "text_product_transfer" );
    }

    public By snackBarText(){
        return By.id ( "snackbar_text" );
    }

    public By addMoreButton(){
     return By.id ( "button_add_more" );
    }

    public By reviewButton(){
     return By.id ( "etransfer_review_button" );
    }

    public By removeButton(){
        return By.xpath ( "//*[@text='REMOVE']" );
    }

    public By continueButton(){
        return By.xpath ( "//*[@text='CONTINUE']" );
    }

    @AndroidFindBy ( id = "itemDetailsText")
    public List < MobileElement > productList;

    @AndroidFindBy ( id = "delete_etransfer_item")
    public List < MobileElement > deleteProductList;

    public By deleteProduct(){
     return By.id ( "delete_etransfer_item" );
    }

    public By deleteAll(){
        return By.id ( "delete_transfer_list" );
    }

    public By changeDepartmentBtn(){
        return By.id ("dtd_change_text");
    }

    public By transferToText(){
        return By.id ("dtd_to_text_view");
    }

    public By departmentIcon(){
        return By.id ("dtd_to_image_icon");
    }

    public By departmentName(){
        return By.id ("dtd_to_text");
    }

    public By deleteAlertTitle(){
        return By.id ("alertTitle");
    }

    public By productCardImage(){
        return By.id ("image");
    }
    public By deptErrorTitle(){
        return By.id ("alertTitle");
    }
    public By deptErrorMsg(){
        return By.id ("alertTitle");
    }
    public By btnOkay() {
        return By.xpath ("//*[@text='OKAY']");
    }





}