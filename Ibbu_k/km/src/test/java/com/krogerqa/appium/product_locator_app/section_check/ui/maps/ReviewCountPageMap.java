package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class ReviewCountPageMap {
    public By reviewBackArrow(){
        return By.xpath("//*[@content-desc=\"Navigate up\"]");
    }
    public By reviewCountTitle(){ return By.xpath("//*[@text='Review Count']"); }
    public By productAisleTextView(){
        return By.id("textView1");
    }
    public By addMoreBtn(){
        return By.id("button_add_more");
    }
    public By continueBtn(){
        return By.id("button_confirm_review");
    }
    public By submitBtn(){
        return By.id("button_confirm_review");
    }
    public By multiLocationBannerMsg(){
        return By.id("product_status_text");
    }
    public By skippedItems(){
        return By.xpath("//*[@text='Skipped']");
    }
    public By noLocation(){
        return By.xpath("//android.widget.TextView[@text='No Location']");
    }
    public By clickOnSkippedItem(){
        return By.xpath("//*[@text='Unit Count: 0']");
    }
    //Count Remaining Location popup
    public By countRemainingLocationHdr(){
        return By.id("alertTitle");
    }
    public By countRemainingLocationMsg(){
       return By.id("android:id/message");
    }
    public By discardBtn_CountRemainingLocation() {
        return By.id("android:id/button2");
    }

    public By continueBtn_CountRemainingLocation() {
        return By.id("android:id/button1");
    }
    //Remove Product popup
    public By removeProductTitle(){
        return By.id("sc_remove_product");
    }
    public By removeProductPopUpMsg(){
        return By.id("sc_remove_product_description");
    }
    public By cancelBtn_RemoveProduct(){
        return By.id("sc_remove_product_cancel_button");
    }
    public By removeBtn_RemoveProduct(){
        return By.id("sc_remove_product_remove_button");
    }

    public By imageDelete(){
        return By.id("imageDelete");
    }
    public By removeIcon(){ return By.xpath("(//android.widget.ImageView[@content-desc=\"image of product\"])[2]");}
    public By productUPCText(){ return By.id("sectionCheckUpcText"); }
    public By deleteMultiLocationItem(){
        return By.xpath("(//android.widget.ImageView[@content-desc=\"image of product\"])[2]");
    }

}
