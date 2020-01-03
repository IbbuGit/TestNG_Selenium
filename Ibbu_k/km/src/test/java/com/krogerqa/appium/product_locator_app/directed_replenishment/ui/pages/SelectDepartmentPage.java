package com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.maps.SelectDepartmentPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SelectDepartmentPage {
    MobileCommands mobileCommands = new MobileCommands();
    CommonPage commonPage = new CommonPage();

    List<MobileElement> lockElements = null;
    SelectDepartmentPageMap selectDepartmentPageMap;
    HashMap<Set<String>, List<Integer>> dept_count = new HashMap<>();

    List<String> depts = new ArrayList<>();
    public int countTotalProducts;

    public SelectDepartmentPage() {
        selectDepartmentPageMap = new SelectDepartmentPageMap();

    }

    public void clickGenerateList() {
        mobileCommands.click(selectDepartmentPageMap.btnGenerateList());
    }

    /*
     *   Verify the display of Select Department screen
     */
    public boolean validateSelectDepartment() throws InterruptedException, IOException {
        mobileCommands.assertElementDisplayed(selectDepartmentPageMap.headerSelectDept(), true);
        return true;
    }

    public void validateGenerateListButtonDisabled() {
        Assert.assertFalse(mobileCommands.elementEnabled(selectDepartmentPageMap.btnGenerateList()));
    }

    public void validateGenerateDeptButton() throws InterruptedException, IOException {

        mobileCommands.assertElementDisplayed(selectDepartmentPageMap.btnGenerateList(), true);
    }

    public String selectDepartment(String selectDepartment) throws Throwable {
        String selectedDepartment = "";
        for (int i = 0; i < 4; i++) {

            selectedDepartment = clickDepartment(selectDepartment);

            if (selectedDepartment.equals("No department selected")) {
                commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            } else {
                break;
            }
        }
        return selectedDepartment;
    }

    public String clickDepartment(String department) throws Throwable {
        int prdctSize = 0;
        String selectedDepartment = "";
        boolean flag = false;
        boolean flag2 = false;
        String departmentSelection = "No department selected";
        List departmentList = mobileCommands.elements(selectDepartmentPageMap.nodeList());
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
                        // lockElements.get ( 0 ).click ( );
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
            clickGenerateList();
            if (commonPage.isElementVisible(selectDepartmentPageMap.selectDepartMsg())) {
                flag = true;
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

    public void swipe02() {
        AndroidDriver androidDriver = (AndroidDriver) mobileCommands.getWebDriver();
        MobileElement elementToClick = (MobileElement) androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.kroger.sps.mobile.debug:id/recycler_view\")).scrollIntoView("
                + "new UiSelector().text(\"Meat06\"));");
        elementToClick.click();
    }

    public void selectFuelDept() {
        while (!(mobileCommands.getWebDriver().findElements(By.xpath("//*[@text='Fuel Center']")).size() > 0)) {
            commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
        }
        mobileCommands.click(selectDepartmentPageMap.fuelCenter());


    }

    public void validateOtherDeptWhenFuelIsSelected() throws InterruptedException {
        //List departmentList = mobileCommands.elements(selectDepartmentPageMap.nodeList());
        //lockElements = ((MobileElement) departmentList.get(0)).findElements(By.id("dr_product_locked"));
        //lockElements.get(0).click();
        AndroidDriver driver = (AndroidDriver) mobileCommands.getWebDriver();
        lockElements = driver.findElements(By.id("department_name_meat"));
        for (int i = 0; i < lockElements.size(); i++) {
            if (lockElements.get(i).getText() != "Fuel Center") {
                lockElements.get(i).click();
                break;
            }
        }

        //mobileCommands.assertElementDisplayed(selectDepartmentPageMap.txtFuelMessage(), true);
        //mobileCommands.assertElementDisplayed(selectDepartmentPageMap.btnFuelGotIt(), true);
        //mobileCommands.click(selectDepartmentPageMap.btnFuelGotIt());
        Thread.sleep(5000);
        mobileCommands.tapByCoordinates(380, 420);
    }

    public void validateNoRepNeeded() {
        mobileCommands.assertElementDisplayed(selectDepartmentPageMap.txtNoReplenishmentNeeded(), true);
    }

    public void clickBackToMM() {
        mobileCommands.click(selectDepartmentPageMap.btnBackToMainMenu());
    }

    public void selectDep(String deptName) {
        while (!BaseUtil.isElementPresent(selectDepartmentPageMap.departement(deptName),1)) {
           BaseUtil.scroll("down",2);
        }
        mobileCommands.click(selectDepartmentPageMap.departement(deptName));
    }

    //E2E capturing departments in the dump along with their counts
    public List<HashMap> selectDepartment() {
        //kon2055
        //collect all the departments on the screen to a hashmap of dept name and no of products
        int k = 0;
        int duplicate = 0;
        boolean skipround2 = false;
        HashMap<String, String> productNameCountWithFuel = new HashMap<>();
        HashMap<String, String> productNameCountWithOutFuel = new HashMap<>();
        List<HashMap> rawProductsNumProducts = new ArrayList<>();
        do {
            int index = 0;

            List<WebElement> deptLayout = mobileCommands.elements(selectDepartmentPageMap.departmentList());
            for (WebElement layout : deptLayout) {
                if (skipround2) {
                    skipround2 = false;
                    continue;
                }
                String prodName1, prodCount;
                try {

                    prodName1 = layout.findElement(selectDepartmentPageMap.deptList()).getText();
                    index++;
                    if (!productNameCountWithFuel.containsKey(prodName1)) {
                        if (!prodName1.equals("Fuel Center")) {
                            prodCount = layout.findElement(selectDepartmentPageMap.departmentStatus()).getText().split(" ")[0];
                            productNameCountWithOutFuel.put(prodName1, prodCount);
                            productNameCountWithFuel.put(prodName1, prodCount);
                        } else productNameCountWithFuel.put(prodName1, null);
                    } else {
                        duplicate++;
                    }

                } catch (Exception e) {
                    skipround2 = true;
                }
                if (duplicate >= 4) {
                    if (index == 6) {
                        break;
                    }
                } else {
                    if (index == 4) {
                        break;
                    }
                }
            }
            if (index == 6) break;
            BaseUtil.scroll("down", 2);
            k++;
        } while (k < 5);
        rawProductsNumProducts.add(productNameCountWithFuel);
        rawProductsNumProducts.add(productNameCountWithOutFuel);
        return rawProductsNumProducts;
    }

    //E2E selecting departments locked
    public List<String> selectDepartmentByStatus(HashMap<String, String> h, String status) {
        List<String> deptStatus = new ArrayList<>();
        Set<String> itr = h.keySet();
        for (String key : itr) {
            if (status.equalsIgnoreCase("Locked")) {
                if (h.get(key).equalsIgnoreCase("In")) deptStatus.add(key);
            }
            if (status.equalsIgnoreCase("Handoff")) {
                if (h.get(key).equalsIgnoreCase("Hand-off")) deptStatus.add(key);
            }
        }
        return deptStatus;
    }

    //E2E selecting the department with least product counts
    public List<String> selDeptByCount(LinkedHashMap<String, Integer> productNameCountAfterSorting) {
        //kon2055
        int i = 0;
        List<String> depts = new ArrayList<>();
        int count = 0;
        Set<String> itr5 = productNameCountAfterSorting.keySet();
        for (String key : itr5) {
            count = count + productNameCountAfterSorting.get(key);
            if (count <= 5) {
                depts.add(i, key);
                i++;
            } else break;
        }
        for (String s : depts) countTotalProducts = countTotalProducts + productNameCountAfterSorting.get(s);
        return depts;
    }

    //E2E selecting the department and sorting according to the product counts
    public LinkedHashMap<String, Integer> sort(HashMap<String, String> productNameCountWithOutFuel) {
        LinkedHashMap<String, Integer> filteredMap = new LinkedHashMap<>();
        List<String> ignoreValues = Arrays.asList("Completed", "In", "Hand-off");
        productNameCountWithOutFuel = productNameCountWithOutFuel.entrySet().stream().filter(i -> !ignoreValues.contains(i.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, String> entry : productNameCountWithOutFuel.entrySet())
            filteredMap.put(entry.getKey(), Integer.parseInt(entry.getValue()));
        filteredMap = filteredMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return filteredMap;
    }

    //E2E selecting the departments after sorting
    public void clickDepartments(List<String> deptSelected) {
        //kon2055
        int i = 0;
        List<String> deptdups = new ArrayList<>();

        do {
            List<WebElement> departmentList = mobileCommands.elements(selectDepartmentPageMap.deptList());
            for (WebElement e : departmentList) {
                for (String department : deptSelected) {
                    if (department.equals(e.getText()) && !deptdups.contains(e.getText())) {
                        deptdups.add(e.getText());
                        e.click();
                        i++;
                        break;
                    }
                }
            }
            BaseUtil.scroll("up");
        } while (i < deptSelected.size());
    }

    public void waitForDepartmentPage() {
        mobileCommands.waitForElement(selectDepartmentPageMap.headerSelectDept());
    }

    public void clickFuelNewList() {
        mobileCommands.click(selectDepartmentPageMap.btnFuelNewList());
    }

    public void clickBackArrow() {
        mobileCommands.waitForElement(selectDepartmentPageMap.backArrow());
        mobileCommands.click(selectDepartmentPageMap.backArrow());
    }

    public void verifyGotItPopup() {
        selectDepartmentPageMap.fuelPopUp();
    }

    public void clickGotItPopup() {
        selectDepartmentPageMap.btnFuelGotIt();
    }

    public void verifyGotItPopupMsg(String gotItPopupMsg) {
        mobileCommands.waitForElement(selectDepartmentPageMap.msgGotItPopup());
        mobileCommands.assertElementText(selectDepartmentPageMap.msgGotItPopup(), gotItPopupMsg, true);
    }

    public void clickBtnGotItInPopup() {
        mobileCommands.waitForElement(selectDepartmentPageMap.btnGotItInPopUp());
        mobileCommands.click(selectDepartmentPageMap.btnGotItInPopUp());
    }

    public void validateFuelWhenOtherDeptIsSelected() {
        selectFuelDept();
        clickBtnGotItInPopup();
    }

    public static String getVisibleElementFromListOfWebElement(WebDriver driverTemp, HashMap<By, String> listOfElement) {
        driverTemp.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String foundElement = "";
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (elapsedTime < 20 * 1000 && foundElement.isEmpty()) {
            for (By key : listOfElement.keySet()) {
                if (isElementFoundNoException(driverTemp, key)) {
                    foundElement = listOfElement.get(key);
                }
            }
            elapsedTime = (new Date()).getTime() - startTime;
        }

        driverTemp.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return foundElement;
    }

    public static boolean isElementFoundNoException(WebDriver driverTemp, By element) {
        boolean Found = false;
        try {
            Found = driverTemp.findElement(element).isDisplayed();
        } catch (Exception e) {
        }
        return Found;
    }

    public void selectDept(String dep) {
        /*for (int i = 0; i <= 2; i++) {
            By tem1 = selectDepartmentPageMap.departement(dep);
            if (BaseUtil.isElementPresent(tem1, 1)) {
                mobileCommands.click(tem1);
                for (int j = 0; i <= 2; j++) {
                    By tem2 = selectDepartmentPageMap.btnGenerateList();
                    if (BaseUtil.isElementPresent(tem2, 1)) {
                        mobileCommands.click(tem2);
                    }
                    BaseUtil.scroll("down", 2);
                }
            }
            BaseUtil.scroll("down", 2);
        }*/

        mobileCommands.scrollDownToFindVisibleText(dep);
        mobileCommands.click(selectDepartmentPageMap.departement(dep));
    }

    public String getDepStatus(String dep) {
        mobileCommands.scrollDownToFindVisibleText(dep);
        return mobileCommands.getElementText(selectDepartmentPageMap.departementStatus(dep));
    }

    public void verifyDRBtn() {
        mobileCommands.assertElementDisplayed(selectDepartmentPageMap.directedReplenishment(), true);
    }
}



