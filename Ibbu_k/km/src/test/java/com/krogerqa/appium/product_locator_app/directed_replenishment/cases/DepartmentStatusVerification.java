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

public class DepartmentStatusVerification extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private String text = "";
    private LogInPage logInPage;
    private TaskListPage taskListPage;
    private KebabMenuPage kebabMenuPage;

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
     * Test Name:           verifyDepartmentStatus_InProgress
     * Test Description:    Validate the Department Status as InProgress
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     */
    public void verifyDepartmentStatus_InProgress() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        //mobileCommands.wait(2);
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        mobileCommands.browserBack();
        moveProductPage.clickExit_UnFinishedPopup();
        //selectDepartmentPage.verifyDRBtn();
        //taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.validateSelectDepartment();
        //selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String status = dr_Data.getInProgress();
        depStatus.equalsIgnoreCase(status);
        selectDepartmentPage.clickGenerateList();
        // selectDepartmentPage.getDepStatus(dr_Data.getInProgress());
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyDepartmentStatus_Complete
     * Test Description:    Validate the Department Status as Complete
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then clicks on Begins Stocking
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v1/items
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     *                      4. Collect Product Page
     *                      5. Collected Page
     */
    public void verifyDepartmentStatus_Complete() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.collectAllProducts();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        moveProductPage.validateMoveProduct();
        moveProductPage.clickFinishButton();
        thankyouPage.validateThankYouPgDisplay();
        thankyouPage.clickBackToMainMenu();
        selectDepartmentPage.verifyDRBtn();
        taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String status = dr_Data.getComplete();
        depStatus.equalsIgnoreCase(status);
        selectDepartmentPage.validateGenerateDeptButton();
    }

    public void signOut() throws Throwable {
        kebabMenuPage.loggedOut();
        logInPage.login(dr_Data.getUserName1(), dr_Data.getPassword1());
        taskListPage.clickDirectedReplenishment();
    }
}
