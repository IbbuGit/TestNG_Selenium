package com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class DepartmentMap {
    public By departmentPageTitle() {
        return By.xpath("//*[@text='Select Department(s)']");
    }

    public By bakery() {
        return By.xpath("//*[@text='Bakery']/..");
    }

    public By deli() {
        return By.xpath("//*[@text='Deli']/..");
    }

    public By dairy() {
        return By.xpath("//*[@text='Dairy']/..");
    }

    public By dryGrocery() {
        return By.xpath("//*[@text='Dry Grocery']");
    }

    public By drug() {
        return By.xpath("//*[@text='Drug/GM']/..");
    }

    public By generateCountBtn() {
        return By.id("generate_count_button");
    }

    public By mdcTutorial() {
        return By.xpath("//*[@text='MDC Tutorial']");
    }

    public By selectDepartMsg() {
        return By.xpath("//*[@text='Select a Department']");
    }

    public By productElement() {
        return By.xpath("//*[contains(@text,'Scan Product')]");
    }

    public By pleaseSelectADepartment() {
        return By.id("snackbar_text");
    }

    public By yourCountIsBeingPrepared() {
        return By.id("progress_dialog_text");
    }

    public By nodeList() {
        return By.id("department_layout");
    }

    public By UnlockElements() {
        return By.id("circle_not_selected");
    }

    public By selectDeptErrorMsg() {
        return By.xpath("//*[@text='Please select a department']");
    }

    public By departmentStatus() {
        return By.id("department_status_select");
    }

    public By navigateBacks() {
        return By.xpath("//[@content-desc='Navigate up']");
    }

    public By navigateBack() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }


    public By deliDepartmentStatus() {
        return By.xpath("(//android.widget.TextView[@text='Deli']/following-sibling::*)[1]");
    }

    public By dairyDepartmentProductsStatus() {
        return By.xpath("(//android.widget.TextView[@text='Dairy']/following-sibling::*)[1]");
    }

    public By dairyDepartmentStatus() {
        return By.xpath("(//android.widget.TextView[@text='Dairy']/following-sibling::*)[1]");
    }

    public By deliDepartmentProductsStatus() {
        return By.xpath("(//android.widget.TextView[@text='Deli']/following-sibling::*)[1]");
    }


    public By reminderDialoguetitle() {
        return By.id("alertTitle");
    }

    public By continueButton() {
        return By.xpath("//*[@text='CONTINUE']");
    }

    public By gotoBRCButton() {
        return By.xpath("//*[@text='GO TO BACKROOM COUNT']/..");
    }

    public By scanScreenTitleBRC() {
        return By.xpath("//android.widget.TextView[@text='Scan Product']");
    }
}


