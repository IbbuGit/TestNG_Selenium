package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;


/**
 * Class Name : Collected PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class CollectedPageMap {


    public By headerCollected() {
        return By.xpath("//android.widget.TextView[@text='COLLECTED']");
    }

    public By tabNotCollected() {
        return By.xpath("//android.widget.TextView[@text='NOT COLLECTED']");
    }

    public By tabCollected() {
        return By.xpath("//android.widget.TextView[@text='COLLECTED']");
    }

    public By txtFindAndScanInBR() {
        return By.id("find_scan_txt");
    }

    public By txtProductsCollected() {
        return By.id("products_to_collect");
    }

    public By txtAisleNo() {
        return By.id("aisle_text");
    }

    //public Bys productCards() {return By.id("parent_container");}
    public By btnBeginStocking() {
        return By.id("begin_stocking_btn");
    }

    public By btnDoneCollecting() {
        return By.id("text_positive_caption");
    }

    public By btnCancel() {
        return By.id("text_negative_caption");
    }

    public By txtDialogBoxHeader() {
        return By.id("text_title");
    }

    public By titleBackAlert() {
        return By.id("alertTitle");
    }

    public By txtBackMessage() {
        return By.id("message");
    }

    public By cancelBtn() {
        return By.id("button2");
    }

    public By saveAndExitBtn() {
        return By.xpath("//*[@text='SAVE & EXIT']");
        //return By.id("button1");
    }
    public By backArrow() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'parent_container')]")
    public List<MobileElement> prodCollected;

    public By txtDrUPC() {return By.id("drUpcText");}
    public By awesomeText() {return By.id("great_message");}
    public By greatText() {return By.xpath("//android.widget.TextView[@text='Great!']");}
}