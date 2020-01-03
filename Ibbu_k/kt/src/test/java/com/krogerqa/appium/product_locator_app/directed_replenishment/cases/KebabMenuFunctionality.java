package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;


public class KebabMenuFunctionality extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private TaskListPage taskListPage;
    private LogInPage logInPage;
    private KebabMenuPage kebabMenuPage;


    private String text = "";

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
        moveProductPage = new MoveProductPage();
        thankyouPage = new ThankyouPage();
        taskListPage = new TaskListPage();
        logInPage = new LogInPage();
        kebabMenuPage = new KebabMenuPage();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_Departments
     * Test Description:    Verify Kebab Menu Items from Departments
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from Departments
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.tutorial Page
     *                      3.FAQ screen
     *                      4. About Screen
     */
    public void validateKebabMenuItem_Departments() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_DirectReplenishment
     * Test Description:    Verify Kebab Menu Items from Directed Replenishment page
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from Directed Replenishment page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Directed Replenishment
     *                      3.tutorial Page
     *                      4.FAQ screen
     *                      5. About Screen
     */
    public void validateKebabMenuItem_DirectReplenishment() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_ScanProduct
     * Test Description:    Verify Kebab Menu Items from Directed ScanProduct page
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from ScanProduct page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Directed Replenishment
     *                      3. Scan product page
     *                      4.tutorial Page
     *                      5.FAQ screen
     *                      6. About Screen
     */
    public void validateKebabMenuItem_ScanProduct() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_CollectProduct
     * Test Description:    Verify Kebab Menu Items from Directed CollectProduct page
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from CollectProduct page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Directed Replenishment
     *                      3. Scan product page
     *                      4.Collect product page
     *                      5.tutorial Page
     *                      6.FAQ screen
     *                      7. About Screen
     */
    public void validateKebabMenuItem_CollectProduct() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_MoveProduct
     * Test Description:    Verify Kebab Menu Items from MoveProduct page
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from Move Product page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Directed Replenishment
     *                      3. Scan product page
     *                      4.Collect product page
     *                      5. Move Product page
     *                      6.tutorial Page
     *                      7.FAQ screen
     *                      8. About Screen
     */
    public void validateKebabMenuItem_MoveProduct() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateKebabMenuItem_ThankYou
     * Test Description:    Verify Kebab Menu Items from ThankYou page
     * Scenario tested:     Validate Tutorial page,FAQ Screen, About Screen from ThankYOu Page
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Directed Replenishment
     *                      3. Scan product page
     *                      4.Collect product page
     *                      5. Move Product page
     *                      6.ThankYou PAge
     *                      7.tutorial Page
     *                      8.FAQ screen
     *                      9.About Screen
     */
    public void validateKebabMenuItem_ThankYou() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        moveProductPage.validateCollectedProdDetails();
        moveProductPage.clickFinishButton();
        thankyouPage.validateThankYouPgDisplay();
        kebabMenuPage.validateTutorialPage();
        kebabMenuPage.validateFaqScreen();
        kebabMenuPage.validateAboutScreen();
        signOut();
    }

    public void signOut() throws Throwable {
        kebabMenuPage.loggedOut();
        logInPage.login(dr_Data.getUserName1(), dr_Data.getPassword1());
        taskListPage.clickDirectedReplenishment();
    }

}