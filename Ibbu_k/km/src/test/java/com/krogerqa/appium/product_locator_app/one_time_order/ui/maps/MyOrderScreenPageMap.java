package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;
import org.openqa.selenium.By;

public class MyOrderScreenPageMap {
    public By myOrderHeader() {return By.xpath("//android.widget.TextView[@text = 'My Order']");}
    public By back() { return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    public By txtTotalProducts(){return By.id("product_count_text");}
    public By productCard() {return By.id("card_view");}
    public By txtUpcNumber() {return By.id("upcText");}
    public By txtProductName() {return By.id("descText");}
    public By txtProductCount(){return By.id("caseNumberText");}
    public By txtTrashIcon() {return By.id("deleteBtn");}
    public By txtBtnAddMore () {return By.id("enter_upc_button");}
    public By withoutSubmit () {return By.xpath("//android.widget.Button[@text='CANCEL']");}
    public By btnSubmit () {return By.xpath("//android.widget.Button[@text='SUBMIT']");}
    public By optSubmitBtn() {return By.id("android:id/button1");}
    //Exit Without Submitting? Dialog
    public By titleExitWithoutSubmitting(){return By.id("alertTitle");}
    public By msgExitWithoutSubmitting() {return By.xpath("//android.widget.TextView[@resource-id='android:id/message']");}
    public By btnCancel(){return By.xpath("//android.widget.Button[@text='CANCEL']");}
    public By btnExit(){return By.xpath("//android.widget.Button[@text='EXIT']");}
    //Order Over Limit Dialog
    //public By btnSUBMIT(){return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");}
    public By titleRemoveProduct(){return By.id("alertTitle");}
    public By msgRemoveProduct() {return By.xpath("//android.widget.TextView[@resource-id='android:id/message']");}
    //Submit order? Dialog
    public By btnDialogCancel(){return By.xpath("//android.widget.Button[@text='CANCEL']");}
    public By btnDialogSubmit(){return By.xpath("//android.widget.Button[@text='SUBMIT']");}
    public By btnDialogMessage(){return By.xpath("//android.widget.TextView[@resource-id='android:id/message']");}
    public By btnDialogTitle(){return By.xpath("//android.widget.TextView[@text='Submit Order?']");}
    //TrashIcon: Remove Product Dialog
    public By titleRemoveProd(){return By.xpath("//android.widget.TextView[@text='Remove Product']");}
    public By btnDialogRemove(){return By.xpath("//android.widget.Button[@text='REMOVE']");}
}