package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.my_daily_count.dataBeans.My_Daily_Count_TestDataBean;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.DepartmentMap;
import com.krogerqa.seleniumcentral.framework.main.BaseCommands;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class DepartmentPage extends Base {

    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();
    WebDriver driver = mobileCommands.getWebDriver();

    DepartmentMap departmentMap;


    public DepartmentPage() throws Throwable {
        departmentMap = new DepartmentMap();

    }

    public void validateDepartmentPageTitle(String department) {
        mobileCommands.assertElementText(departmentMap.departmentPageTitle(), department, true);

    }

    public void clickMDCTutorial() {
        mobileCommands.click(departmentMap.mdcTutorial());
    }

    public void clickBakeryDepartment() {
        mobileCommands.click(departmentMap.bakery());
    }

    public void clickDairyDepartment() {
        mobileCommands.click(departmentMap.dairy());
    }

    public void clickGroceryDepartment() {
        mobileCommands.click(departmentMap.dryGrocery());
    }

    public void clickDeliDepartment() {
        mobileCommands.click(departmentMap.deli());
    }

    public void clickDrugDepartment() {
        mobileCommands.click(departmentMap.drug());

    }

    public void clickGenerateCountButton() {

        mobileCommands.click(departmentMap.generateCountBtn());

    }


    public void verifyGenerateCountButton() {
        mobileCommands.assertElementDisplayed(departmentMap.generateCountBtn(), true);
    }

    public void verifyReminderDialogueTitle() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        if ((driver.findElements(departmentMap.reminderDialoguetitle()).size() > 0)) {
            mobileCommands.assertElementDisplayed(departmentMap.reminderDialoguetitle(), true);
        }
    }

    public void clickOnContinueOfReminderDialogue() {

        if ((driver.findElements(departmentMap.continueButton()).size() > 0)) {
            mobileCommands.click(departmentMap.continueButton());
        }
    }

    public void clickOnGotoBRC() {


        if ((driver.findElements(departmentMap.gotoBRCButton()).size() > 0)) {
            mobileCommands.click(departmentMap.gotoBRCButton());
        }
    }

    public void validateScanProductTitle(String scanProduct) {
        mobileCommands.assertElementText(departmentMap.scanScreenTitleBRC(), scanProduct, true);
    }

    public String selectDepartment(String selectDepartment) throws Throwable {
        String selectedDepartment = "";
        for (int i = 0; i < 6; i++) {

            selectedDepartment = clickDepartment(selectDepartment);

            if (selectedDepartment.equals("No department selected")) {
                commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            } else {
                break;
            }
        }
        return selectedDepartment;
    }


    public void swipe02() {
        AndroidDriver androidDriver = (AndroidDriver) mobileCommands.getWebDriver();
        MobileElement elementToClick = (MobileElement) androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.kroger.sps.mobile.debug:id/recycler_view\")).scrollIntoView("
                + "new UiSelector().text(\"Meat06\"));");
        elementToClick.click();
    }


    public String clickDepartment(String department) throws Throwable {
        int prdctSize = 0;
        String selectedDepartment = "";
        boolean flag = false;
        boolean flag2 = false;
        String departmentSelection = "No department selected";
        List departmentList = mobileCommands.elements(departmentMap.nodeList());
        List<MobileElement> lockElements = null;
        for (int i = 0; i < departmentList.size(); i++) {
            String prductSize;
            List nodetList = ((MobileElement) departmentList.get(i)).findElements(By.className("android.widget.TextView"));
            try {
                prductSize = ((MobileElement) departmentList.get(i)).findElementByXPath("//*[contains(@text,'Products')]").getText();
                lockElements = ((MobileElement) departmentList.get(i)).findElements(By.id("circle_not_selected"));
                //String departName=( ( MobileElement ) departmentList.get ( i ) ).findElementByXPath ( "//*[@id='department_name_meat']" ).getText ( );
                selectedDepartment = ((MobileElement) nodetList.get(0)).getText();
                if (!department.equalsIgnoreCase("Any department")) {
                    // System.out.println ( "selectedDepartment:"+selectedDepartment );
                    //  System.out.println ( "department:"+department );
                    //  System.out.println ( "selectedDepartment.equalsIgnoreCase ( department ) :"+selectedDepartment.equalsIgnoreCase ( department )  );

                    if (selectedDepartment.equalsIgnoreCase(department)) {
                        flag2 = true;
                        lockElements.get(0).click();
                    } else {
                        continue;
                    }
                } else {
                    flag2 = true;
                    lockElements.get(0).click();
                }
            } catch (Exception e) {
                continue;
            }
            prdctSize = Integer.parseInt(prductSize.split(" ")[0]);
            clickGenerateCountButton();
            if (commonPage.isElementVisible(departmentMap.selectDepartMsg())) {
              /* if(brcAlert.equals("brcalerton")){
                   verifyBrcEnabledAlertMessage();
               }else if(brcAlert.equals("brcalertoff")){
                   verifyBrcDisabledAlertMessage();
               }*/
                break;
            }
            if (flag2) {
                departmentSelection = selectedDepartment + "@" + prdctSize;
                break;
            }
        }

        // Assert.assertTrue ( flag, departmentSelection );
        return departmentSelection;
    }

    public void selectAllDepartments() throws Throwable{
        String status="";

        for(int i=0;i<4;i++) {
            status = clickAllDepartment ();
            if (status.equalsIgnoreCase ( "scroll" ) ) {
               // scroll("Down");
                commonPage.verticalSwipeByPercentages ( 0.6 , 0.3 , 0.5 );
            }else{
                break;
            }
        }

    }

    private String clickAllDepartment() {
        List departmentList = mobileCommands.elements ( departmentMap.nodeList ( ) );
        //List< MobileElement > lockElements;
        //lockElements = ( ( MobileElement ) departmentList.get () ).findElements (  );
        List<WebElement> lockElements = mobileCommands.elements(By.id ( "circle_not_selected" ));
        for(WebElement element:lockElements) {
            element.click();
        }
        return "scroll";
    }


    ////E2E -Changes

    public void navigateBack() {
        mobileCommands.click(departmentMap.navigateBack());
    }

    public int getCountOfProducts() {
        String departmentStatus = mobileCommands.getElementText(departmentMap.deliDepartmentStatus());
        int noOfProducts = Integer.parseInt(departmentStatus.split(" ")[0]);
        System.out.println("no of products in Deli :" + noOfProducts);
        return noOfProducts;
    }

    public int isCountIncreased(int countBeforeBackroom) {
        int countAfterBackroom = getCountOfProducts();
        Assert.assertTrue(countBeforeBackroom < countAfterBackroom, "The number of products did not change");
        return countAfterBackroom;
    }

    public String getDeliDepartmentStatus() {
        String departmentStatus = mobileCommands.getElementText(departmentMap.deliDepartmentStatus());
        return departmentStatus;
    }

    public String getDairyDepartmentStatus() {
        String departmentStatus = mobileCommands.getElementText(departmentMap.dairyDepartmentStatus());
        return departmentStatus;
    }

    public void deliDepartmentInProgressStatus() {
        String departmentStatus = getDeliDepartmentStatus();
        Assert.assertTrue(departmentStatus.contains("In Progress"));
    }

    public void dairyDepartmentInProgressStatus() {
        String departmentStatus = getDairyDepartmentStatus();
        Assert.assertTrue(departmentStatus.contains("In Progress"));
    }

}
