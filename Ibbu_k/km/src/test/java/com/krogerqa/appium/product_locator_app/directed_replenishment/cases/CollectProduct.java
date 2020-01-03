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
import java.util.ArrayList;
import java.util.List;

public class CollectProduct extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private List<String> collectedUPC = new ArrayList<>();
    private String text = "";
    private LogInPage logInPage;
    private TaskListPage taskListPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
        taskListPage = new TaskListPage();
        logInPage = new LogInPage();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateCartIsFullBtnInNotCollectedPage
     * Test Description:    Validating the Cart is Full button
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then verifies the Cart is full button
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
     */
    public void validateCartIsFullBtnInNotCollectedPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.validateFindAndScanText();
        notCollectedPage.cartIsFullEnabled();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.waitForCollectedTab();
        notCollectedPage.cartIsFull();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyProductAvailable_CollectedTab
     * Test Description:    Validate the product available in collected tab
     * Scenario tested:     User select a department, scans a product, collects it,
     *                      then verifies the Cart is full button
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
     */
    public void verifyProductAvailable_CollectedTab() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        for (int i = 0; i < 4; i++) {
            notCollectedPage.waitForNotCollectedTab();
            notCollectedPage.clickFirstProduct();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
            collectedUPC.add(text);
        }
        signOut();
        taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        collectedPage.clickCollectedTab();
        collectedPage.validateCollectedProductUPC(collectedUPC);
    }

    @Test(groups = {"Regression"})
    /*
    @Test(groups = {"smoke", "regression"})
        /*
         * Test Name:           validateBeginStockingBtn
         * Test Description:    Validating Begin Stocking Button after collecting a product
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
    public void validateBeginStockingBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyCollectedItems
     * Test Description:    Validate collected products
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
    public void verifyCollectedItems() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        //notCollectedPage.getUpcList();
        for (int i = 0; i < 4; i++) {
            notCollectedPage.waitForNotCollectedTab();
            notCollectedPage.clickNotCollected();
            notCollectedPage.clickFirstProduct();
            scanProductDRPage.validateScanProductDR();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
        }
        collectedPage.clickCollectedTab();
        logOutApp();
        logInPage.login(dr_Data.getUserName1(), dr_Data.getPassword1());
        taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.clickSessionInProgressContinue();
        collectedPage.clickCollectedTab();
        // collectedPage.validateCollectedProductUPC(collectedUPC);
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           verifyGreatMessageInTimerPage
         * Test Description:    Validate Great Message In Timer Page
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
    void verifyGreatMessageInTimerPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.collectAllProducts();
        collectedPage.clickBeginStocking();
        collectedPage.verifyTimerGreatMsg(dr_Data.getGreatTxt());
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifyAwesomeMessageInTimerPage
     * Test Description:    Validate Awesome Message In Timer Page
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
    public void verifyAwesomeMessageInTimerPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        collectedPage.verifyTimerPageMsg(dr_Data.getAwesomeText());
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateNotCollectedItems
     * Test Description:    Validate Not Collected products
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
    public void validateNotCollectedItems() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String productsCount = depStatus.replace("products", "").replace(" ", "").replace("product", "");
        int updatedProductsCount = Integer.parseInt(productsCount);
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        for (int i = 0; i < updatedProductsCount; i++) {
            if (i == 2) {
                break;
            } else {
                notCollectedPage.waitForNotCollectedTab();
                notCollectedPage.clickNotCollected();
                notCollectedPage.clickFirstProduct();
                scanProductDRPage.validateScanProductDR();
                text = scanProductDRPage.getUPCText();
                scanProductPage.scanProduct(text, Symbology.UPC_A);
                collectProductPage.validateCollectProduct();
                collectProductPage.clickDoneBtn();
                collectedUPC.add(text);
            }
        }
        int min = updatedProductsCount - collectedUPC.size();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.verifyNotCollectedProductsCount(min, updatedProductsCount);
    }

    //Reusable method for Logout and Login
    public void signOut() throws Throwable {
        logOutApp();
        logInPage.login(dr_Data.getUserName1(), dr_Data.getPassword1());
    }
}
