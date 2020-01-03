package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.LogInPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
public class NetworkErrorMessage extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private CollectedPage collectedPage;
    private MoveProductPage moveProductPage;
    private TaskListPage taskListPage;
    private CommonPage commonPage;
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
        taskListPage = new TaskListPage();
        commonPage = new CommonPage();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }
    @AfterMethod(alwaysRun = true)
    public void enableWiFi(Method test) throws InterruptedException {
        commonPage.enableWiFi();
        commonPage.enableMobileData();
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickDRBtn
     * Test Description:    Verify Network Error Message on Clicking DR button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickDRBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.clickBackArrow();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        taskListPage.clickDirectedReplenishment();
        scanProductDRPage.verifyNetWorkErrorMessageWhenClickDR(dr_Data.getNetworkErrorMsgWhenClickDR());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickGenerateListBtn
     * Test Description:    Verify Network Error Message on Clicking GenerateList button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickGenerateListBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        selectDepartmentPage.clickGenerateList();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickCartIsFullBtn
     * Test Description:    Verify Network Error Message on Clicking Cart Is Full button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickCartIsFullBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.clickDoneBtn();
        mobileCommands.wait(1);
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        notCollectedPage.clickCartIsFull();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickBeginStockingBtn
     * Test Description:    Verify Network Error Message on Clicking Begin Stocking button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickBeginStockingBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        collectedPage.clickBeginStocking();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickDoneBtn
     * Test Description:    Verify Network Error Message on Clicking Done button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickDoneBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        collectProductPage.clickDoneBtn();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickDoneCollectingBtn
     * Test Description:    Verify Network Error Message on Clicking Done Collecting button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickDoneCollectingBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.clickDoneBtn();
        collectedPage.clickCollectedTab();
        collectedPage.clickBeginStocking();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        collectedPage.clickDoneCollecting();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickFinishBtn
     * Test Description:    Verify Network Error Message on Clicking Finish button
     * Scenario tested:     Validate Success Product message from CollectProductPage
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickFinishBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.clickDoneBtn();
        notCollectedPage.clickCartIsFull();
        notCollectedPage.clickCartIsFullDoneCollecting();
        moveProductPage.validateMoveProduct();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        moveProductPage.clickFinishButton();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateErrorMessageWhenClickSkipBtn
     * Test Description:   Verify Network Error Message on Clicking Skip button
     * Scenario tested:     Validate Network message on Clicking Skip Button
     * Story id:
     * Epic id:
     * Test data:
     * API tested:
     *
     * UI screen tested:    1.Select Departments
     *                      2.Not collected page
     *                      3.collect product page
     */
    public void validateErrorMessageWhenClickSkipBtn() throws Throwable {
        selectDepartmentPage.validateSelectDepartment();
        selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
        selectDepartmentPage.clickGenerateList();
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.clickDoneBtn();
        notCollectedPage.clickCartIsFull();
        notCollectedPage.clickCartIsFullDoneCollecting();
        moveProductPage.clickCantFindAndSkip();
        commonPage.disableWiFi();
        commonPage.disableMobileData();
        moveProductPage.clickSkip();
        scanProductDRPage.verifyNetWorkErrorMessage(dr_Data.getNetworkErrorMsg());
    }
}


