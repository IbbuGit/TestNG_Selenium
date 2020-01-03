package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.TopstockScanProductPage;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsReplenishment extends Base {

    private ScanProductPage scanProductPage;
    private TopstockScanProductPage topstockScanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private TaskListPage taskListPage;
    private LogInPage logInPage;
    private DBHelper dbHelper;
    private String query;

    private String text = "";
    private List<String> collectedUPC = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        topstockScanProductPage = new TopstockScanProductPage(login_Data, prop);
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
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
        dbHelper = new DBHelper();
    }


    @Test(groups = {"Regression"})
        /*
         * Test Name:           verifyMultiLocationProduct
         * Test Description:    Validate Multi location product in move product screen
         * Scenario tested:     User selects a department, clicks a product, skips it,
         *                      then verifies the product under Skipped Tag
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         */
    void verifyMultiLocationProduct() throws Exception {
        String UPC = "";
        String locationCount = "";
        String sDump_ID = "";

        query = "INSERT INTO DBR_DUMP (DATA_LOAD_TS) VALUES (GETDATE())";
        dbHelper.executeDBStatment("dbr", query);
        query = "select max(dbr_dump_id) from dbr_dump";
        String sFor_Dump_ID = dbHelper.executeDBStatment("dbr", query);
        List<String> lDump_ID = JsonPath.read(sFor_Dump_ID, "$..*");
        sDump_ID = String.valueOf(lDump_ID.get(1));
        Map<String, String> multilocationUPC = topstockScanProductPage.getMultiLocationUPC();
        UPC = String.valueOf(multilocationUPC.keySet().toArray()[0]);
        locationCount = multilocationUPC.get(UPC);
        //thankyouPage.validateThanKYouCount();

        query = "Insert into DBR_DUMP_DETAILS(DBR_DUMP_ID,DIVISION_NO,STORE_NO,BASE_UPC_NO,SUB_DEPARTMENT_NO,PROPOSED_QTY)VALUES" +
                "('" + sDump_ID + "','" + prop.get("division") + "','" + prop.get("store") + "','" + UPC + "','01',13.000)";
        dbHelper.executeDBStatment("dbr", query);

        selectDepartmentPage.clickBackArrow();
        new TaskListPage().clickDirectedReplenishment();

        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        collectedPage.validateCollectedTab();
        scanProductPage.scanProduct(UPC, Symbology.UPC_A);
        collectProductPage.validateCollectProduct();
        collectProductPage.clickDoneBtn();
        collectedUPC.add(UPC);
        collectedPage.clickCollectedTab();
        collectedPage.clickBeginStocking();
        collectedPage.verifyTimerGreatMsg(dr_Data.getGreatTxt());
        collectedPage.validateBlueScreenCount(collectedUPC.size());
        moveProductPage.validateMoveProduct();
        thankyouPage.validateCountInThankYouPage(collectedUPC);

        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
        dbHelper.executeDBStatment("dbr", query);
        query = "delete DBR_DUMP_DETAILS where dbr_dump_id='" + sDump_ID + "'";
        dbHelper.executeDBStatment("dbr", query);
        query = "delete dbr_dump where dbr_dump_id='" + sDump_ID + "'";
        dbHelper.executeDBStatment("dbr", query);
    }

    private void setHandoff() throws SQLException {
        String query = "update dbr_job set end_utc_ts = dateadd(mi,-31,end_utc_ts) where euid = '" + login_Data.getUsername() + "' and dbr_job_sts_cd_id = '1'";
        dbHelper.executeDBStatment("dbr", query);
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           cantFindAndSkip
         * Test Description:    Validating Can't Find, Skip flow in Scan Product page
         * Scenario tested:     User selects a department, clicks a product, skips it,
         *                      then verifies the product under Skipped Tag
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         */
    void cantFindAndSkip() throws Throwable {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        if (notCollectedPage.prodsToCollect() >= 2) {
            notCollectedPage.clickFirstProduct();
            scanProductDRPage.validateScanProductDR();
            scanProductDRPage.clickCantFindAndSkip();
            notCollectedPage.verifyNotCollectedPageDisplay();
            notCollectedPage.validateSkipped();
            notCollectedPage.scrollToFirstElement();
            notCollectedPage.clickFirstProduct();
            scanProductDRPage.validateScanProductDR();
            text = scanProductDRPage.getUPCText();
            scanProductPage.scanProduct(text, Symbology.UPC_A);
            collectProductPage.validateCollectProduct();
            collectProductPage.clickDoneBtn();
            notCollectedPage.clickCartIsFull();
            notCollectedPage.clickCartIsFullCancel();
            moveProductPage.validateSkipProducts();
        } else {
            System.out.println("No Products to Skip");
        }
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validatePendingReplenishmentProduct
     * Test Description:    Validating Pending Replenished products in Move product page
     * Scenario tested:     User selects a department, clicks a product, skips it,
     *                      then verifies the product under Skipped Tag
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     */
    public void validatePendingReplenishmentProduct() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String productCount = depStatus.replace("products", "").replace(" ", "");
        int updatedProductsCount = Integer.parseInt(productCount);
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        for (int i = 0; i < updatedProductsCount; i++) {
            if (i == 4) {
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
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        for (int i = 0; i < collectedUPC.size() - 1; i++) {
            moveProductPage.validateMoveProduct();
            moveProductPage.validateCollectedProdDetails();
            moveProductPage.clickNextBtn();
        }
        logOutApp();
        mobileCommands.wait(2);
        logInPage.login(dr_Data.getUserName1(), dr_Data.getPassword1());
        taskListPage.clickDirectedReplenishment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.clickSessionInProgressContinue();
        moveProductPage.validateCollectedProductUPC1(collectedUPC);
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           validateCountInThankYouPage
     * Test Description:    Validating the product count in thank you page
     * Scenario tested:     User selects a department, clicks a product, skips it,
     *                      then verifies the product under Skipped Tag
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
     * UI screen tested:
     *                      1. Select Department Page
     *                      2. Not Collected Page
     *                      3. Scan Product Page
     */
    public void validateCountInThankYouPage() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDept(dr_Data.getDepartmentName());
        String depStatus = selectDepartmentPage.getDepStatus(dr_Data.getDepartmentName());
        String productsCount = depStatus.replace("products", "").replace(" ", "").replace("product", "");
        int updatedProductsCount = Integer.parseInt(productsCount);
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        for (int i = 0; i < updatedProductsCount; i++) {
            if (i == 4) {
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
        //int updatedDeptCount=productscount-(collectedUPC.size());
        collectedPage.clickCollectedTab();
        collectedPage.clickFinishCollectingBtn();
        thankyouPage.validateCountInThankYouPage(collectedUPC);
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           collectAndReplenishAllProductsForOneDept
         * Test Description:    Validating the all collected and Replenished products for one department
         * Scenario tested:     User selects a department, clicks a product, skips it,
         *                      then verifies the product under Skipped Tag
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         */
    void collectAndReplenishAllProductsForOneDept() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.collectAllProductsAndReplenish();
        thankyouPage.validateThankYouPgDisplay();
    }

    @Test(groups = {"Regression"})
        /*
         * Test Name:           collectAndReplenishAllProductsForMultiDepts
         * Test Description:    Validating the all collected and Replenished products for Multi department
         * Scenario tested:     User selects a department, clicks a product, skips it,
         *                      then verifies the product under Skipped Tag
         * Story id:
         * Epic id:
         * Test data:
         * API tested:
         *                      1. dbrsrvstage.kroger.com/replenishment-services/api/v2/replenishment-departments
         * UI screen tested:
         *                      1. Select Department Page
         *                      2. Not Collected Page
         *                      3. Scan Product Page
         */
    void collectAndReplenishAllProductsForMultiDepts() throws Throwable {
        String depts[] = dr_Data.getDepartmentName().split(";");
        selectDepartmentPage.validateSelectDepartment();
        for (int i = 0; i < depts.length; i++) {
            selectDepartmentPage.selectDep(depts[i]);
        }
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.collectAllProductsAndReplenish();
        thankyouPage.validateThankYouPgDisplay();
    }
}
