package com.krogerqa.appium.product_locator_app.section_check.ui.maps;

import org.openqa.selenium.By;

public class ThankYouPageMap {
    public By countSubmittedTitle() {
        return By.xpath("//*[@text='Count Submitted']");
    }
    public By thankYouImg(){
        return By.id("tq_img");
    }
    public By thankYouCompletedText(){
        return By.id("tvCompletedTS");
    }
    public By numberOfProducts(){
        return By.id("productsHaveStockedCount");
    }
    public By countedText(){
        return By.id("productsHaveStocked");
    }
    public By countAnotherSectionBtn(){
        return By.id("count_another_section");
    }
    public By mainMenuBtn(){
        return By.id("btn_main_menu");
    }
}
