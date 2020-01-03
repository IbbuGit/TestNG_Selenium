
/**
 * Test case to verify scan product first screen screen
 * ALM test case
 * Created by -Ragupathi(syl7525)
 */

package com.krogerqa.appium.product_locator_app.top_stock.ui.pages;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.utils.*;
import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockProductStockMessagePageMap;
import com.krogerqa.appium.product_locator_app.top_stock.ui.maps.TopStockScanProductPageMap;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.NameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;


public class TopstockScanProductPage {
    MobileCommands mc = new MobileCommands();
    TopStockScanProductPageMap scanProductPageMap;
    TopStockProductStockMessagePageMap stockShelfPageMap;
    Login_TestDataBean login_Data;
    Properties prop;
    HttpClientExecutor apiExecutor;
    ApiRequestDataHelper dataHelper;
    DBHelper dbHelper;


    public TopstockScanProductPage(Login_TestDataBean login_Data, Properties prop) {
        this.login_Data = login_Data;
        this.prop = prop;
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
        dbHelper = new DBHelper();
        scanProductPageMap = new TopStockScanProductPageMap();
        stockShelfPageMap = new TopStockProductStockMessagePageMap();
    }

    public void ValidateScanProductHeaderTxt(String scanProductText) {
        mc.assertElementText(scanProductPageMap.ScanProduct(), scanProductText, true);
    }

    public void ClickBackArrowButton() {
        mc.click(scanProductPageMap.BackArrow());
    }

    public void ClickCrossButton() {
        mc.click(scanProductPageMap.BackArrow());
    }

    public void selectLocation() {
        mc.click(scanProductPageMap.ConfirmLocation());
    }

    public void selectLocation(int index) {
        mc.click(scanProductPageMap.ConfirmLocation(index));
    }

    public void selectOtherLocation() {
        mc.click(scanProductPageMap.ConfirmOtherLocation());
    }

    public void optionBtnlocationselection() {
        mc.click(scanProductPageMap.ConfirmLocation());
        mc.click(scanProductPageMap.ConfirmLocationBtn());
    }

    public void clickLocationConfirmBtn() {
        mc.click(scanProductPageMap.ConfirmLocationBtn());
    }

    public void verifyConfirmButton(String confirmBtnTxt) {
        mc.assertElementText(scanProductPageMap.ConfirmLocationBtn(), confirmBtnTxt, true);
    }

    public void ClickNewSession() {
        WebDriver driver = mc.getWebDriver();
        if ((driver.findElements(scanProductPageMap.newSessionBtn()).size() > 0)) {
            mc.click(scanProductPageMap.OrderInProgressDialog());
        }
    }

    public void clickCancelBtn_LocationPopup(String cancelBtn) {
        mc.assertElementText(scanProductPageMap.cancelBtn(), cancelBtn, true);
        mc.click(scanProductPageMap.cancelBtn());
    }

    public void clickOnReviewBtn_ScanProductScreen() {
        mc.click(scanProductPageMap.reviewBtn());
    }

    public void verifyNetWorkErrorMessage(String networkErrorMsg) {
        mc.assertElementText(scanProductPageMap.networkErrorMsg(), networkErrorMsg, true);
    }

    public void validateMagicProductScannedMsg(String magicProductMsg) {
        mc.assertElementText(scanProductPageMap.magicProductScanned(), magicProductMsg, true);
    }

    public void verifyConfirmBtnEnabled() {
        mc.assertElementEnabled(scanProductPageMap.ConfirmLocationBtn(), true);
    }

    public String getUpdateQuerryForAllCntAndCaseQTY(int allCnt, int caseQTY, String upc, String storeNo) {
        return "update item_store_info set allocations_cnt='" + allCnt + "', case_qty='" + caseQTY + "' where " +
                "store_item_id =(select store_item_id from store_item where upc_no='" + upc + "' and store_no='" + storeNo + "')";
    }

    public String getQuerryForUPCwithLocation(String storeNo) {
        return "select store_item.upc_no from item_store_info join store_item on item_store_info.store_item_id = store_item.store_item_id " +
                "where store_item.store_no='" + storeNo + "' and " +
                "item_store_info.allocations_cnt>0 and " +
                "item_store_info.allocations_cnt< (item_store_info.case_qty/2) and " +
                "item_store_info.sath_authorization_flg = 'true' and " +
                "item_store_info.dsd_vendor_txt is NULL and " +
                "item_store_info.sath_info_vlu <> 'R'";
    }

    public void scanProduct(String upc, Symbology symbology) throws SQLException, IOException {
        BaseUtil.scanUPC(mc.getWebDriver(), setActionableUPC(upc), symbology);
        System.out.println(upc);
    }

    public String setActionableUPC(String upc) throws IOException, SQLException {
        String body = "";
        String rUPC = "";
        if (upc.contains("UC-")) {
            rUPC = upc.replace("UC-", "");
            body = dataHelper.updateBOHBody(rUPC, "-1", "-2", "-1");
        } else {
            rUPC = upc;
            body = dataHelper.updateBOHBody(upc, "1", "1", "1");
        }

        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
        dbHelper.executeDBStatment("ILU",
                getUpdateQuerryForAllCntAndCaseQTY(6, 90, upc, prop.getProperty("store")));
        return rUPC;
    }

    public String getUPCwithLocation() throws IOException, SQLException, URISyntaxException {
        String upcWithLocation = "";
        String sUPCwithLocation = dbHelper.executeDBStatment("ILU", getQuerryForUPCwithLocation(prop.getProperty("store")));
        List<String> lUPCwithLocation = JsonPath.read(sUPCwithLocation, "$..upc_no");

        for (int i = 0; 1 <= lUPCwithLocation.size(); i++) {
            String sUpc = lUPCwithLocation.get(RandomUtils.nextInt(0, lUPCwithLocation.size()));
            List<String> loctions = getLocationFromKim(sUpc);
            if (loctions.size() > 0) {
                NameValuePair[] params = dataHelper.getBOHParams(sUpc);
                List<String> NoUPCcheckInBOH = JsonPath.read(apiExecutor.getHttpClient(prop.getProperty("getBOH"), params), "$..boh");
                if (NoUPCcheckInBOH.size() > 0) {
                    upcWithLocation = sUpc;
                    break;
                }
            }
        }
        return upcWithLocation;
    }

    public Map<String,String> getMultiLocationUPC() throws IOException, SQLException, URISyntaxException {
        String upcWithLocation = "";
        String sUPCwithLocation = dbHelper.executeDBStatment("ILU", getQuerryForUPCwithLocation(prop.getProperty("store")));
        List<String> lUPCwithLocation = JsonPath.read(sUPCwithLocation, "$..upc_no");
        Map<String,String> MultiLocationUPC=new LinkedHashMap<String,String>();

        for (int i = 0; 1 <= lUPCwithLocation.size(); i++) {
            String sUpc = lUPCwithLocation.get(RandomUtils.nextInt(0, lUPCwithLocation.size()));
            List<String> loctions = getLocationFromKim(sUpc);
            if (loctions.size() > 2) {
                NameValuePair[] params = dataHelper.getBOHParams(sUpc);
                List<String> NoUPCcheckInBOH = JsonPath.read(apiExecutor.getHttpClient(prop.getProperty("getBOH"), params), "$..boh");
                if (NoUPCcheckInBOH.size() > 0) {
                    upcWithLocation = sUpc;
                    MultiLocationUPC.put(upcWithLocation,String.valueOf(NoUPCcheckInBOH.size()));
                    break;
                }
            }
        }
        return MultiLocationUPC;
    }

    public String get_L1L2_BaseUPCValue(String upc, String key) throws IOException {
        String value = "";
        String body = dataHelper.getItemLookupBody(new String[]{upc});
        String responseItemLookup = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        if (key.toLowerCase().equals("baseupc")) {
            List<String> baseUPC = JsonPath.read(responseItemLookup, "$..baseItem.upc");
            value = String.valueOf(baseUPC.get(0));
        } else if (key.toLowerCase().equals("l1l2")) {
            List<String> l1l2 = JsonPath.read(responseItemLookup, "$..l1L2Details.l1L2");
            value = String.valueOf(l1l2.get(0));
        }
        return value;
    }

    public Integer getBOH_QOD_Value(String upc) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(upc);
        return JsonPathValueExtractor.extractBOHBucketValue(apiExecutor.getHttpClient(prop.getProperty("getBOH"), params), "QOD");
    }

    public List<String> getLocationFromKim(String sUpc) throws IOException {
        String body = dataHelper.getItemLookupBody(new String[]{sUpc});
        String responseItemLookup = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        List<String> loctions = JsonPath.read(responseItemLookup, "$..aisleNumber");
        return loctions;
    }

    public void handleLocationPopupAndClickStockedBtn() {
        WebDriver driver = mc.getWebDriver();
        List<By> list = new ArrayList<>();
        list.add(scanProductPageMap.ConfirmLocation());
        list.add(stockShelfPageMap.stockedBtn());
        int i = BaseUtil.visibleWebElementFromListOfWebElement(driver, list);
        if (i == 1) {
            mc.click(scanProductPageMap.ConfirmLocation());
            mc.click(scanProductPageMap.ConfirmLocationBtn());
            List<By> list2 = new ArrayList<>();
            list2.add(stockShelfPageMap.stockedBtn());
            list2.add(stockShelfPageMap.productStatus());
            int j = BaseUtil.visibleWebElementFromListOfWebElement(driver, list2);
            if (j == 1) {
                mc.click(stockShelfPageMap.stockedBtn());
            }
        } else if (i == 2) {
            mc.click(stockShelfPageMap.stockedBtn());
        }
    }

    public void handleLocationPopupAndClickNotStockedBtn() throws SQLException, IOException, URISyntaxException {
        WebDriver driver = mc.getWebDriver();
        List<By> list = new ArrayList<>();
        list.add(scanProductPageMap.ConfirmLocation());
        list.add(stockShelfPageMap.notStockedBtn());
        int i = BaseUtil.visibleWebElementFromListOfWebElement(driver, list);
        if (i == 1) {
            mc.click(scanProductPageMap.ConfirmLocation());
            mc.click(scanProductPageMap.ConfirmLocationBtn());
            List<By> list2 = new ArrayList<>();
            list2.add(stockShelfPageMap.notStockedBtn());
            list2.add(stockShelfPageMap.productStatus());
            int j = BaseUtil.visibleWebElementFromListOfWebElement(driver, list2);
            if (j == 1) {
                mc.click(stockShelfPageMap.notStockedBtn());
            }
        } else if (i == 2) {
            mc.click(stockShelfPageMap.notStockedBtn());
        }
    }

    public void verifyTopStockBtn() {
        mc.assertElementExists(scanProductPageMap.topStockBtn(), true);
    }

    public boolean verifyClickingStockedAndNotStocked(int upcCnt) {
        boolean stocked = false;
        HashMap<By, String> elements = new HashMap<>();
        elements.put(scanProductPageMap.ConfirmLocation(), "POPUP");
        elements.put(stockShelfPageMap.stockedBtn(), "STOCKED");
        elements.put(stockShelfPageMap.noStockingNeededMsg(), "No Stocking Needed");
        String visibleElement = BaseUtil.getVisibleElementFromListOfWebElement(mc.getWebDriver(), elements);
        if (visibleElement.equals("POPUP")) {
            if (upcCnt % 3 == 0 & upcCnt != 0) {
                mc.click(scanProductPageMap.ConfirmLocation(2));
            } else {
                mc.click(scanProductPageMap.ConfirmLocation());
            }
            mc.click(scanProductPageMap.ConfirmLocationBtn());
            HashMap<By, String> elements1 = new HashMap<>();
            elements1.put(stockShelfPageMap.stockedBtn(), "STOCKED");
            elements1.put(stockShelfPageMap.noStockingNeededMsg(), "No Stocking Needed");
            String visibleElement1 = BaseUtil.getVisibleElementFromListOfWebElement(mc.getWebDriver(), elements1);
            if (visibleElement1.equals("STOCKED")) {
                if (upcCnt % 2 == 0 & upcCnt != 0) {
                    mc.click(stockShelfPageMap.notStockedBtn());
                    stocked = false;
                } else {
                    mc.click(stockShelfPageMap.stockedBtn());
                    stocked = true;
                }
            }
        } else if (visibleElement.equals("STOCKED")) {
            mc.click(stockShelfPageMap.stockedBtn());
            stocked = true;
        } else if (visibleElement.equals("No Stocking Needed")) {
        }
        return stocked;
    }
    public void enterUPC(String manualUPC) {
        mc.enterText(scanProductPageMap.enterUPC(), manualUPC, true);
    }
    public void clickSubmitBtn(){
        mc.click(scanProductPageMap.submitBtn());
    }
    public void verifyBarCodeNotRecognizedHdr(String barCodeNotRecognizedTxt){
        mc.assertElementText(scanProductPageMap.barCodeNotRecognizedHdr(), barCodeNotRecognizedTxt,true);
    }
    public void verifyProductNotFoundTxt(String productNotFound){
        mc.assertElementText(scanProductPageMap.productNotFountTxt(),productNotFound,true);
    }
}


