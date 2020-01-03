package com.krogerqa.appium.product_locator_app.one_time_order.ui.maps;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UpdateOrderScreenPageMap extends By {
    public By updateOrderHeader() {return By.xpath("//android.widget.TextView[@text='Update Order']");}
    public By cancelXButton() {return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    public By backRoomUpcTxt() {return By.id("backroomUpcText");}
    public By backRoomUpcImg() {return By.id("backroomImage");}
    public By textProductName() {return By.id("backroomDescText");}
    public By textProductCaseEditBox() {return By.id("stepperNumberBox");}
    public By textEnlargedCaseEditBox(){return By.id("stepperenlargedText");}
    public By textThresholdErrorMsg(){return By.id("stepperenlargedMsgTxt");}
    public By backBtn(){return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    public By textCaseStepperPlus() {return By.id("stepperPlus");}
    public By textCaseStepperMinus() {return By.id("stepperMinus");}
    public By addBtnOrder() {return By.id("update_order");}
    public By removeBtn(){return By.id("remove");}
    //Order Over Limit Dialog
    public By titleOrderOverLimit(){return By.id("alertTitle");}
    public By msgOrderOverLimit() {return By.xpath("//android.widget.TextView[@resource-id='android:id/message']");}
    public By btnCancel(){return By.xpath("//android.widget.Button[@text='CANCEL']");}
    public By btnContinue(){return By.xpath("//android.widget.Button[@text='CONTINUE']");}
    //Remove Product Dialog
    public By btnRemove(){return By.xpath("//android.widget.Button[@text='REMOVE']");}
    public By cancelBtn() {return By.xpath("//android.widget.Button[@text='CANCEL']");}
    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        return null;
    }
}