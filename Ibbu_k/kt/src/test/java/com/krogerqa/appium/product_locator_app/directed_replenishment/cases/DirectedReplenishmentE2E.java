package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.*;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;

import static java.util.Collections.*;

public class DirectedReplenishmentE2E extends Base {
    private static int countScannedProducts = 0;
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private ThankyouPage thankyouPage;
    private List<HashMap> deptProduct;
    private List<HashMap> deptProduct1;
    private HttpClientExecutor apiExecutor;
    private ApiRequestDataHelper dataHelper;
    private List<String> deptSelected;
    private int initialQIB;
    private int initialQOD;
    private int initialQIK;
    private int endQIB;
    private int endQOD;
    private int endQIK;
    private int sugQty;
    private String query;
    private DBHelper dbHelper;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        collectProductPage = new CollectProductPage();
        collectedPage = new CollectedPage();
        moveProductPage = new MoveProductPage();
        thankyouPage = new ThankyouPage();
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
        deptProduct = null;
        deptProduct1 = null;
        deptSelected = new ArrayList<>();
        query = "";
        dbHelper = new DBHelper();
    }

    /**
     * Test Name            :   replenishAllProductsInSelectedDepartments
     * Test Description     :   Took all the departments, products from department page, Sorting them, selecting the departments with least number of products(min 5)
     *                          scanning all the products, begin stocking, moving all the products and comparing their initial and end BOH buckets
     * Scenario tested      :   <completing the department by scanning all the products in the department>
     * Story id             :   <Story ID>
     * Epic id              :   <Epic ID>
     * Test data            :   <data comes from 84.51 dump, Data Independent >
     * API tested           :   <APIs https://dbrsrvdev.cfcdcinternaltest.kroger.com/replenishment-services/api/v2/replenishment-items>
     * UI screen tested     :   <UI screens tested from Invision>
     */

    @Test(priority = 2, groups = {"e2e"})
    void replenishAllProductsInSelectedDepartments() throws Throwable {
        navigationTillNotCollectedPage();
        int noofproductsToCollect = notCollectedPage.productsToCollect();
        HashMap<String, HashMap<String, Integer>> prodInitialQIBQODQIKSugQty = scanProducts(noofproductsToCollect);
        collectedPage.waitForCollectedTab();
        if (!(collectedPage.collectedTabEnabled())) {
            collectedPage.clickCollectedTab();
            collectedPage.clickBeginStocking();
        } else {
            collectedPage.clickCollectedTab();
            collectedPage.clickBeginStocking();
        }
        moveProductPage.clickGreat();
        HashMap<String, HashMap<String, Integer>> prodEndQIBQODQIK;
        HashSet<String> upcMoved = moveProductPage.clickFinishButtonByProductLocation();
        prodEndQIBQODQIK = beginStockingToEnd(upcMoved);
        validateBOH(prodInitialQIBQODQIKSugQty, prodEndQIBQODQIK, "");
    }

    /**
     * Test Name            :   verifySessionWhenUserExitMiddleOfStocking
     * Test Description     :   Took all the departments, products from department page, Sorting them, selecting the departments with least number of products(min 5)
     *                          scanning half of the products, begin stocking, starting a new session of same user, scan remaining products,
     *                          moving all the products and comparing their initial and end BOH buckets
     * Scenario tested      :   <Test is verifying if the old session Items are coming when moving the products in session2>
     * Story id             :   <Story ID>
     * Epic id              :   <Epic ID>
     * Test data            :   <data comes from 84.51 dump, Data Independent >
     * API tested           :   <APIs https://dbrsrvdev.cfcdcinternaltest.kroger.com/replenishment-services/api/v2/replenishment-items>
     * UI screen tested     :   <UI screens tested from Invision>
     */
    @Test(priority = 2, groups = {"e2e"})
    void verifySessionWhenUserExitMiddleOfStocking() throws Throwable {
        deptSelected = navigationTillNotCollectedPage();
        int noofproductsToCollect = notCollectedPage.productsToCollect();
        HashMap<String, HashMap<String, Integer>> prodInitialQIBQODQIKSugQty;
        prodInitialQIBQODQIKSugQty = scanProducts(noofproductsToCollect / 2);
        collectedPage.waitForCollectedTab();
        if (!(collectedPage.collectedTabEnabled())) {

            collectedPage.clickCollectedTab();
        } else {
            collectedPage.clickCollectedTab();
        }
        collectedPage.clickBeginStocking();
        collectProductPage.clickDoneCollecting();
        moveProductPage.clickAwesome();
        startSession2();
        session2Activities(prodInitialQIBQODQIKSugQty, deptSelected);
    }

    /**
     * Test Name            :   verifyDepartmentLockedStatusWhentheDepartmentIsInProgressByOtherUser
     * Test Description     :   Took all the departments, products from department page, Sorting them, selecting the departments with least number of products(min 5)
     *                          scanning half of the products, begin stocking, starting a new session of different user, check if the department are locked,
     *                          checking if the departments are moving to hand-off after 30 mins
     * Scenario tested      :   <this Test is to verify the same department should not be shared by different users at the same time>
     * Story id             :   <Story ID>
     * Epic id              :   <Epic ID>
     * Test data            :   <data comes from 84.51 dump, Data Independent>
     * API tested           :   <APIs https://dbrsrvdev.cfcdcinternaltest.kroger.com/replenishment-services/api/v2/replenishment-items>
     * UI screen tested     :   <UI screens tested from Invision>
     */
    @Test(priority = 1, groups = {"e2e"})
    void verifyDepartmentLockedStatusWhentheDepartmentIsInProgressByOtherUser() throws Throwable {
        //dataResetAPI();
        deptSelected = navigationTillNotCollectedPage();
        int noofproductsToCollect = notCollectedPage.productsToCollect();
        scanProducts(noofproductsToCollect);
        collectedPage.waitForCollectedTab();
        if (collectedPage.collectedTabEnabled()) collectedPage.clickCollectedTab();
        else collectedPage.clickCollectedTab();
        collectedPage.clickBeginStocking();
        moveProductPage.clickGreat();
        startSession2();
        deptProduct1 = selectDepartmentPage.selectDepartment();
        List<String> deptLocked = selectDepartmentPage.selectDepartmentByStatus(deptProduct1.get(1), "Locked");
        sort(deptSelected);
        sort(deptLocked);
        boolean isTrue = deptSelected.equals(deptLocked);
        Assert.assertTrue(isTrue);
        setHandoff();
        startSession2();
        deptProduct1 = selectDepartmentPage.selectDepartment();
        List<String> deptHandoff;
        deptHandoff = selectDepartmentPage.selectDepartmentByStatus(deptProduct1.get(1), "Handoff");
        sort(deptHandoff);
        boolean isTrue1 = deptLocked.equals(deptHandoff);
        Assert.assertTrue(isTrue1);
    }

    /**
     * Test Name            :   verifyFuelCenterReplenishment
     * Test Description     :   Selecting the Fuel department, generating the dump
     *                          scanning 1st 5 of the products, begin stocking and comparing their initial and end BOH buckets
     * Scenario tested      :   <Test if the dump is creating and appropriate buckets are updated>
     * Story id             :   <Story ID>
     * Epic id              :   <Epic ID>
     * Test data            :   <data comes from fuel dump, Data Independent >
     * API tested           :   <APIs https://dbrsrvdev.cfcdcinternaltest.kroger.com/replenishment-services/api/v2/replenishment-items>
     * UI screen tested     :   <UI screens tested from Invision>
     */
    @Test(priority = 2, groups = {"e2e"})
    void verifyFuelCenterReplenishment() throws Throwable {
        HashMap<String, HashMap<String, Integer>> prodInitialQIBQODQIKSugQty = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> prodEndQIBQODQIK;
        selectDepartmentPage.waitForDepartmentPage();
        BaseUtil.scroll("down", 5);
        List<String> depts = singletonList("Fuel Center");
        selectDepartmentPage.clickDepartments(depts);
        selectDepartmentPage.clickGenerateList();
        selectDepartmentPage.clickFuelNewList();
        int noofproductsToCollect = notCollectedPage.productsToCollect();
        if (noofproductsToCollect > 5) {
            prodInitialQIBQODQIKSugQty = scanProducts(5);
        } else scanProducts(noofproductsToCollect);
        collectedPage.waitForCollectedTab();
        if (collectedPage.collectedTabEnabled()) collectedPage.clickCollectedTab();
        else collectedPage.clickCollectedTab();
        collectedPage.clickBeginStocking();
        collectProductPage.clickDoneCollecting();
        HashSet<String> set = new HashSet<>(prodInitialQIBQODQIKSugQty.keySet());
        prodEndQIBQODQIK = beginStockingToEnd(set);
        validateBOH(prodInitialQIBQODQIKSugQty, prodEndQIBQODQIK, "fuel");
    }

    public void startSession2() throws Throwable {
        thankyouPage.logOutApp();
        new LogInPage().login(dr_Data.getUsername2(), dr_Data.getPassword2());
        TaskListPage taskListPage = new TaskListPage();
        taskListPage.clickDirectedReplenishment();
    }

    public void session2Activities(HashMap<String, HashMap<String, Integer>> prodInitialQIBQODQIKSugQtyS1, List<String> depts) throws Throwable {
        selectDepartmentPage.waitForDepartmentPage();
        BaseUtil.scroll("down", 4);
        selectDepartmentPage.clickDepartments(depts);
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.clickCollectMore();
        int noofproductsToCollect = notCollectedPage.productsToCollect();
        prodInitialQIBQODQIKSugQtyS1.putAll(scanProducts(noofproductsToCollect));
        collectedPage.waitForCollectedTab();
        if (!(collectedPage.collectedTabEnabled())) {
            collectedPage.clickCollectedTab();
        } else {
            collectedPage.clickCollectedTab();
        }
        collectedPage.clickBeginStocking();
        moveProductPage.clickGreat();
        HashMap<String, HashMap<String, Integer>> prodEndQIBQODQIK;
        HashSet<String> upcMoved = moveProductPage.clickFinishButtonByProductLocation();
        prodEndQIBQODQIK = beginStockingToEnd(upcMoved);
        Assert.assertEquals(prodInitialQIBQODQIKSugQtyS1.size(), prodEndQIBQODQIK.size(), "While Comparing Sessions 1 and 2");
        validateBOH(prodInitialQIBQODQIKSugQtyS1, prodEndQIBQODQIK, "");
    }

    private List<String> navigationTillNotCollectedPage() {
        deptProduct = selectDepartmentPage.selectDepartment();
        deptSelected = selectDepartmentPage.selDeptByCount(selectDepartmentPage.sort(deptProduct.get(1)));
        selectDepartmentPage.clickDepartments(deptSelected);
        selectDepartmentPage.clickGenerateList();
        return deptSelected;
    }

    private HashMap<String, HashMap<String, Integer>> scanProducts(int noofproductsToBeScanned) throws Throwable {
        List<String> UpcNoList = notCollectedPage.getUpcList();
        HashMap<String, HashMap<String, Integer>> prodInitialQIBQODQIKSugQty = new HashMap<>();
        int productsScanned = 0;
        for (String upc : UpcNoList) {
            initialQIB = 0;
            initialQOD = 0;
            initialQIK = 500;
            HashMap<String, Integer> initialQIBQODQIKSugQty = new HashMap<>();
            String responseString = getBOH(upc);
            if (responseString.contains("QIB"))
                initialQIB = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIB");
            if (responseString.contains("QOD"))
                initialQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
            if (responseString.contains("QIK"))
                initialQIK = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIK");
            initialQIBQODQIKSugQty.put("initialQIB", initialQIB);
            initialQIBQODQIKSugQty.put("initialQOD", initialQOD);
            initialQIBQODQIKSugQty.put("initialQIK", initialQIK);
            notCollectedPage.clickUpc(upc);
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            sugQty = collectProductPage.getSuggestedQty();
            initialQIBQODQIKSugQty.put("sugQty", sugQty);
            collectProductPage.clickDoneBtn();
            prodInitialQIBQODQIKSugQty.put(upc, initialQIBQODQIKSugQty);
            countScannedProducts = countScannedProducts++;
            if (noofproductsToBeScanned != productsScanned)
                productsScanned++;
            else
                break;
        }
        return prodInitialQIBQODQIKSugQty;
    }

    private HashMap<String, HashMap<String, Integer>> beginStockingToEnd(HashSet<String> upcMoved) throws Throwable {
        thankyouPage.clickBackToMainMenu();
        HashMap<String, HashMap<String, Integer>> prodEndQIBQODQIK = new HashMap<>();
        for (String upc : upcMoved) {
            endQIB = 0;
            endQOD = 0;
            endQIK = 500;
            HashMap<String, Integer> endQIBQODQIK = new HashMap<>();
            String responseString = getBOH(upc);
            if (responseString.contains("QIB"))
                endQIB = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIB");
            if (responseString.contains("QOD"))
                endQOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
            if (responseString.contains("QIK"))
                endQIK = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QIK");
            endQIBQODQIK.put("endQIB", endQIB);
            endQIBQODQIK.put("endQOD", endQOD);
            endQIBQODQIK.put("endQIK", endQIK);
            prodEndQIBQODQIK.put(upc, endQIBQODQIK);
        }
        return prodEndQIBQODQIK;
    }

    private String getBOH(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private void validateBOH(HashMap<String, HashMap<String, Integer>> initial, HashMap<String, HashMap<String, Integer>> end, @Nullable String isFuel) {
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : initial.entrySet()) {
            String initialKey = entry.getKey();
            HashMap<String, Integer> initialValues = entry.getValue();
            for (HashMap.Entry<String, HashMap<String, Integer>> entry1 : end.entrySet()) {
                String endKey = entry1.getKey();
                HashMap<String, Integer> endValues = entry1.getValue();
                initialQIB = initialValues.get("initialQIB");
                sugQty = initialValues.get("sugQty");
                endQIB = endValues.get("endQIB");
                initialQOD = initialValues.get("initialQOD");
                endQOD = endValues.get("endQOD");
                initialQIK = initialValues.get("initialQIK");
                endQIK = endValues.get("endQIK");
                if (initialKey.equals(endKey)) {
                    assert isFuel != null;
                    int expectedQOD;
                    if ("Fuel".equalsIgnoreCase(isFuel))
                        if (initialQOD != 0 && initialQIK != 500) {
                            expectedQOD = initialQOD - sugQty;
                            int expectedQIK = initialQIK + sugQty;
                            Assert.assertEquals(expectedQOD, endQOD, " In fuel QOD is not updated ");
                            Assert.assertEquals(expectedQIK, endQIK, " In Fuel QIK is not updated ");
                        } else {
                            Assert.assertEquals(initialQOD, endQOD, "In fuel This is when the QOD is 0");
                            Assert.assertEquals(initialQIK, endQIK, "In fuel This is QIK when QOD is 0");
                        }
                    else {
                        if (initialQIB == 0) {
                            Assert.assertEquals(initialQIB, endQIB, "This is when the QIB is 0");
                            Assert.assertEquals(initialQOD, endQOD, "This is QOD when QIB is 0");
                        } else {
                            int expectedQIB = initialQIB - sugQty;
                            expectedQOD = initialQOD + sugQty;
                            Assert.assertEquals(expectedQIB, endQIB, " QIB is not updated ");
                            Assert.assertEquals(expectedQOD, endQOD, " QOD is not updated ");
                        }
                    }
                }
            }
        }
    }

    private void setHandoff() throws SQLException {
        query = "update dbr_job set end_utc_ts = dateadd(mi,-31,end_utc_ts) where euid = '" + login_Data.getUsername() + "' and dbr_job_sts_cd_id = '1'";
        dbHelper.executeDBStatment("dbr", query);
    }

    private void dataResetAPI() throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.resetDBRAPI(login_Data.getUsername());
        apiExecutor.getHttpClient(prop.getProperty("dbrReset"), params);
    }
}

