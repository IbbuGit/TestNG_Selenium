package com.krogerqa.appium.product_locator_app.backroom_count.ui.maps;

import org.openqa.selenium.By;

public class ReviewCountPageMap {

    public By deleteIcon() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");
    }

    public By btnSubmit() {
        return By.id("brc_review_finish");
    }

    public By btnAddMore() {
        return By.id("brc_add_more");
    }

    public By headerReviewProduct() {
        return By.xpath("//android.widget.TextView[@text='Review Count']");
    }

    public By txtProdDesc() {
        return By.id("backroomDescText");
    }

    public By imgProd() {
        return By.id("backroomImage");
    }

    public By txtCaseNumber() {
        return By.id("caseNumberText");
    }

    public By alertTitle() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    }

    public By message() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    }

    public By btnCancel() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
    }

    public By btnRemove() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    }

    public By unubmittedPopUp() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    }

    public By unsubmittedPopUpMessage() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    }

    public By popupBtnCancel() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
    }

    public By popupBtnRemove() {
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
    }

    public By editCard() {
        return By.xpath("(//*[contains(@text,'Total')])[2]/..");
    }

    public By productCountText() {
        return By.id("product_count_text");
    }

    public By loadingSpinnerText(){return By.id("backroom_loading_text");}
}
