package com.krogerqa.appium.product_locator_app.directed_replenishment.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.CollectProductPage;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.NotCollectedPage;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.ScanProductDRPage;
import com.krogerqa.appium.product_locator_app.directed_replenishment.ui.pages.SelectDepartmentPage;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class MessageVerification extends Base {
    private ScanProductPage scanProductPage;
    private SelectDepartmentPage selectDepartmentPage;
    private NotCollectedPage notCollectedPage;
    private ScanProductDRPage scanProductDRPage;
    private CollectProductPage collectProductPage;
    private String text = "";

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        scanProductPage = new ScanProductPage();
        selectDepartmentPage = new SelectDepartmentPage();
        notCollectedPage = new NotCollectedPage();
        scanProductDRPage = new ScanProductDRPage();
        collectProductPage = new CollectProductPage();
        apiExecutor.getHttpClient(prop.getProperty("resetDRData"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
    }

    @Test(groups = {"Regression"})
    /*
     * Test Name:           verifySuccessProductMessage_CollectProductPage
     * Test Description:    Verify Success Product Message in CollectProductPage
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
    public void verifySuccessProductMessage_CollectProductPage() throws Exception {
        if (selectDepartmentPage.validateSelectDepartment()) {
            selectDepartmentPage.selectDep(dr_Data.getDepartmentName());
            selectDepartmentPage.clickGenerateList();
        }
        notCollectedPage.verifyNotCollectedPageDisplay();
        notCollectedPage.validateFindAndScanText();
        notCollectedPage.cartIsFullEnabled();
        notCollectedPage.clickFirstProduct();
        scanProductDRPage.validateScanProductDR();
        text = scanProductDRPage.getUPCText();
        scanProductPage.scanProduct(text, Symbology.UPC_A);
        collectProductPage.validateSuccessMsg();
        collectProductPage.validateCollectProduct();
    }
}