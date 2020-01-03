package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;


/**
 * Class Name : SelectDepartment PageMap
 * description : This class contains MobileElements of related page.
 *
 * @author SYL9692
 */

public class SelectDepartmentPageMap {
    public By headerSelectDept() {
        return By.xpath("//android.widget.TextView[@text='Select Department(s)']");
    }

    public By btnGenerateList() {
        return By.id("select_department_generate_list_button");
    }

    public By departmentList() {
        return By.xpath("//*[contains(@resource-id,'department_layout')]");
    }

    public By departmentStatus() {
        return By.xpath("//*[contains(@resource-id,'department_status_select')]");
    }

    public By txtNoReplenishmentNeeded() {
        return By.id("no_replenishment_needed_label");
    }

    public By btnBackToMainMenu() {
        return By.id("dr_back_to_menu_btn");
    }

    public By bakery() {
        return By.xpath("//*[@text='Bakery']/..");
    }

    public By fuelCenter() {
        return By.xpath("//*[@text='Fuel Center']/..");
    }

    public By nodeList() {
        return By.id("department_layout");
    }

    public By selectDepartMsg() {
        return By.xpath("//*[@text='Select a Department']");
    }

    public By btnFuelGotIt() {
        return By.id("button2");
    }

    public By fuelPopUp() {
        return By.xpath("/hierarchy/android.widget.FrameLayout");
    }

    public By deptList() {
        return By.id("department_name_meat");
    }

    public By msgGotItPopup() {
        return By.xpath("//android.widget.TextView[@text='Fuel Center cannot be selected with other departments']");
    }

    public By btnGotItInPopUp() {
        return By.xpath("//*[@text='GOT IT!']");
    }

    public By directedReplenishment() {
        return By.xpath("//*[@text='Directed Replenishment' or @text='DR Capability']/..");
    }

    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'department_name_meat')]")
    public List<MobileElement> departmentName;

    public By departement(String depName) {
        return By.xpath("//android.widget.TextView[contains(@resource-id,'department_name_meat') and @text='" + depName + "']");
    }

    public By departementStatus(String depName) {
        return By.xpath("//android.widget.TextView[contains(@resource-id,'department_name_meat') and @text='" + depName + "']//following-sibling::android.widget.TextView[contains(@resource-id,'department_status_select')]");
    }

    //Fuel Pop up
    public By btnFuelNewList() {
        return By.id("text_negative_caption");
    }

    public By btnFuelContinue() {
        return By.id("text_positive_caption");
    }

    public By backArrow() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }
    public By unfinishedCollectionListHdrFuel(){
        return By.id("text_title");
    }
}