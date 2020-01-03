package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;

import org.openqa.selenium.By;


/**
 * Class Name : CollectProduct PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class CollectProductPageMap {
    public By headerCollectProduct() {return By.xpath("//android.widget.TextView[@text='Collect Product']");}
    public By txtPageHeader() {return By.xpath("//android.widget.TextView[@text='Collect Product']");}
    public By txtSuccessMsg() {return By.id("snackbar_text");}
    public By txtCollectItems() {return By.id("collect_items_text_view");}
    public By txtAmtCollected() { return By.id("stpperTextView");}
    public By btnStepperMinus() { return By.id("stepperMinus");}
    public By btnStepperPlus() { return By.id("stepperPlus");}
    public By txtBoxStepperNumber() { return By.id("stepperNumberBox");}
    public By btnDone() { return By.id ("done_btn");}
    public By txtBoxStepperNoEnlarged() { return By.id("stepperenlargedText");}
    public By txtProdUPC() { return By.id("drUpcText");}
    public By txtProdDesc() { return By.id("drDescText");}
    public By imgProd() { return By.id("drImage");}
    public By txtCaseSizeValue() { return By.id("textview_case_size_value");}
    public By btnDoneContinue() { return By.id("text_positive_caption");}
    public By txtCaseSize() { return By.id("textview_case_size");}
    public By keyBoardView() { return By.id("dr_keyboard_view");}
    public By calcErrorMessage() {return By.id("stepperenlargedMsgTxt");}
    public By btnDoneCollecting() { return By.id("text_positive_caption");}
    public By txtSuccessProductMsg(){return By.xpath("//*[@text= 'Success! Product Found!']");}

}