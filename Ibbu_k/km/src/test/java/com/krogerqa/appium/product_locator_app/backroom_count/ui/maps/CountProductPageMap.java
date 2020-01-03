package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class CountProductPageMap {

    public By btnUnitsStepperMinus() {
        return By.xpath("//*[@text='Units']/preceding-sibling::*[2]");
    }

    public By btnCasesStepperMinus() {
        return By.xpath("//*[@text='Cases']/preceding-sibling::*[2]");
    }

    public By btnUnitsStepperPlus() {
        return By.xpath("//*[@text='Units']/following-sibling::*[1]");
    }

    public By btnCasesStepperPlus() {
        return By.xpath("//*[@text='Cases']/following-sibling::*[1]");
    }

    public By casesTxtBox() {
        return By.xpath("//*[@text='Cases']/preceding-sibling::*[1]");
    }

    public By casesTxt() {
        return By.xpath("//*[@text='Cases']");
    }

    public By enterCountTxt() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
    }

    public By casesCountTxtBox() {
        return By.id("dialog_edit_text");
    }

    public By maxCountErrorMsg() {
        return By.id("manualentry_hint");
    }

    public By btnSubmit() {
        return By.id("dialog_submit_button");
    }

    public By unitsCountTxtBox() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
    }

    public By btnCancel() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]");
    }

    public By unitsTxtBox() {
        return By.xpath("//*[@text='Units']/preceding-sibling::*[1]");
    }

    public By unitsTxt() {
        return By.xpath("//*[@text='Units']");
    }

    public By btnEnterUPC() {
        return By.id("enter_upc_button");
    }

    public By btnReview() {
        return By.id("review_button");
    }

    public By headerCountProduct() {
        return By.xpath("//android.widget.TextView[@text='Count Products']");
    }

    public By txtProdUPC() {
        return By.id("backroomUpcText");
    }

    public By txtProdDesc() {
        return By.id("backroomDescText");
    }

    public By imgProd() {
        return By.id("backroomImage");
    }

    public By txtCaseSize() {
        return By.id("backroomCaseText");
    }

    //public By btnNavigation() (return By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))
    public By txtTotalUnitsCount() { return By.id("mTextViewCustomStepperViewTotalCountValue");}
    public By crossButton() { return  By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");}
    public By alertTitle() { return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");}
    public By message() { return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");}
    public By btnGoBack() { return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");}
    public By btnRemove() { return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");}
    public By txtScanningTips(){return By.xpath("//*[@text='Scanning Tips']");}
    public By continueButton(){return By.xpath("//*[@text='CONTINUE']");}
    public By caseNumber(){ return By.id("stepperNumberBox");}
}