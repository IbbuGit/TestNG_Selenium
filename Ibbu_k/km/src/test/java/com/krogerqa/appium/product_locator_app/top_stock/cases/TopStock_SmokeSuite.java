package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class TopStock_SmokeSuite extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockCompletePage completePage;
    private String getUPCToScan[];
    private String getProductMsg[];
    private TopStockKababMenuPage kebabMenuPage;
    private MobileCommands mc;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        completePage = new TopStockCompletePage();
        kebabMenuPage = new TopStockKababMenuPage();
        mc = new MobileCommands();
    }

    /*
     * Test Name:           verifyMultiProductScanning
     * Test Description:    Validate Multiple Product Scans by Stocking
     * Scenario tested:     Scan the Product, select location, click Stocked, Verify the product status
     *                      follow the same for multiple products.
     *                      Scan the Product, select location, click NotStocked tab, Click on Review Button,
     *                      Verify No location text on Review Screen,Click Finish Button,Validate Thank You Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Stocked Button
     *                      4. Click Not stocked Tab
     *                      5. No location Text Review Screen
     *                      6. Thank You Page
     */

    @Test(groups = "Smoke")
    public void topStock_SmokeTest() throws Throwable {
        String stocked[] = new String[6];
        String notStocked[] = new String[3];
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        apiExecutor.getHttpClient(prop.getProperty("resetAllDataForUser"), new NameValuePair[]{new BasicNameValuePair("euid", login_Data.getUsername())});
        topStockScanProductPage.ClickBackArrowButton();
        new TaskListPage().clickTopStock();
        String[] header = ts_Data.getScanProductOnTSTutorialHdr().split(";");
        String[] desc = ts_Data.getScanProductOnTSTutorialDesc().split(";");
        for (int i = 0; i < header.length; i++) {
            kebabMenuPage.verifyScanProductOnTSTutorialHdr(header[i]);
            kebabMenuPage.verifyScanProductOnTSTutorialDesc(desc[i]);
            if (i == header.length - 1) {
                kebabMenuPage.clickTutorialGotIt();
                break;
            } else {
                kebabMenuPage.clickNextBtn();
            }
        }
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        getUPCToScan = ts_Data.getUpcNo().split(";");
        getProductMsg = ts_Data.getProductStatus().split(";");

        //Scanning 1st product
        topStockScanProductPage.scanProduct(getUPCToScan[0], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        //To verify the Product Stocked Message
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[0]);
        stocked[0] = getUPCToScan[0];
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        mobileCommands.browserBack();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());

        //Scanning the same UPC again
        topStockScanProductPage.scanProduct(getUPCToScan[0], Symbology.UPC_A);

        //Scanning 2nd product with same location
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(getUPCToScan[1], Symbology.UPC_A);
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[0]);
        stocked[1] = getUPCToScan[1];

        //Scanning 3rd product with same location
        topStockScanProductPage.scanProduct(getUPCToScan[2], Symbology.UPC_A);
        stockShelfPage.clickNotStockedBtn();
        //To verify the Shelf Already full Message
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[1]);
        notStocked[0] = getUPCToScan[2];

        //Scanning 4th product belongs to different location and user location
        topStockScanProductPage.scanProduct(getUPCToScan[3], Symbology.UPC_A);
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[0]);
        stocked[2] = getUPCToScan[3];

        //Scanning 5th Product as BOH Count updated
        topStockScanProductPage.scanProduct("UC-" + getUPCToScan[4], Symbology.UPC_A);
        topStockScanProductPage.selectLocation(2);
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateBOHHeaderText(ts_Data.getUpdateBalanceHdr());
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[0]);
        stocked[3] = getUPCToScan[4];

        //Scanning 6th Product Magic Product
        String obj = new DBHelper().executeDBStatment("ILU", "select store_item.upc_no from item_store_info join store_item on item_store_info.store_item_id = store_item.store_item_id where store_item.store_no='00445' and item_store_info.sath_info_vlu='R'");
        List<String> lUPC = JsonPath.read(obj, "$..upc_no");
        topStockScanProductPage.scanProduct(lUPC.get(0), Symbology.UPC_A);
        topStockScanProductPage.scanProduct(lUPC.get(0), Symbology.UPC_A);
        topStockScanProductPage.validateMagicProductScannedMsg(ts_Data.getMagicProductMsg());

        //Scanning 7th product belongs different location
        topStockScanProductPage.scanProduct(getUPCToScan[5], Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[3]);
        notStocked[1] = getUPCToScan[5];
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickNotStockTab();
        reviewPage.verifyWrongAisleText(ts_Data.getWrongAisletxt());
        reviewPage.clickContinueBtn();

        //Scanning 8th product L1L2 Item
        String upc = getUPCToScan[6];
        String baseUPC = topStockScanProductPage.get_L1L2_BaseUPCValue(upc, "baseupc");
        int l1l2value = Integer.parseInt(topStockScanProductPage.get_L1L2_BaseUPCValue(upc, "l1l2"));
        topStockScanProductPage.setActionableUPC("UC-" + baseUPC);
        topStockScanProductPage.scanProduct(upc, Symbology.UPC_A);
        topStockScanProductPage.selectLocation(2);
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateBOHHeaderText(ts_Data.getUpdateBalanceHdr());
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.ValidateStockUpcTxt(upc);
        stockShelfPage.clickStockedBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        stocked[4] = getUPCToScan[6];
        int bohQOD = topStockScanProductPage.getBOH_QOD_Value(baseUPC);
        Assert.assertEquals(bohQOD, l1l2value * Integer.parseInt(ts_Data.getBalanceUnit()));

        //Scanning 9th product belongs to no location
        topStockScanProductPage.scanProduct(getUPCToScan[7], Symbology.UPC_A);
        //Verifying No stocking needed message
        stockShelfPage.ValidateScanProductStockStatus(getProductMsg[3]);
        notStocked[2] = getUPCToScan[7];
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());

        //Scanning 10th product belongs to barcode not recognized
        topStockScanProductPage.scanProduct(getUPCToScan[8], Symbology.CODE_39);
        //Verifying Bar Code Not Recognized popup
        topStockScanProductPage.verifyBarCodeNotRecognizedHdr(ts_Data.getBarCodeNotRecognizedTxt());
        stocked[5] =topStockScanProductPage.setActionableUPC(topStockScanProductPage.getUPCwithLocation());
        topStockScanProductPage.enterUPC(stocked[5]);
        topStockScanProductPage.clickSubmitBtn();
        topStockScanProductPage.selectLocation(2);
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.clickOnReviewBtn();
        reviewPage.verifyReviewHeaderTxt(ts_Data.getReviewHdrTxt());
        reviewPage.validateStockedNotStockedItemCountAndUPC(stocked, "Stocked");
        reviewPage.clickNotStockTab();
        reviewPage.ValidateNoLocationTxtReviewScreen(ts_Data.getNoLocationTxt());
        reviewPage.validateStockedNotStockedItemCountAndUPC(notStocked, "NotStocked");
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
        completePage.ValidateCompleteThankYouMsg(ts_Data.getCompleteThankYouMsgTxt());
        /*String productCount = stocked.length + " Products";
        completePage.verifyStockedCountInCompletedScreen(productCount);*/
        completePage.verifyStockedCountInCompletedScreen(stocked.length);
    }

    @Test(groups = "Performance")
    /*
     * Test Name:           verifyTopStockPerformanceByAdding_100Products
     * Test Description:    Validate Top Stock performance by adding 100 Products
     * Scenario tested:     Scan the Product, select location, click Stocked, Verify the product status
     *                      follow the same for multiple products.
     *                      Scan the Product, select location, click NotStocked tab, Click on Review Button,
     *                      Verify No location text on Review Screen,Click Finish Button,Validate Thank You Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Click Stocked Button
     *                      4. Click Not stocked Tab
     *                      5. No location Text Review Screen
     *                      6. Thank You Page
     */
    public void verifyTopStockPerformanceByAdding_100Products() throws Throwable {
        String UPC="";
        List<String> lStocked=new ArrayList<String>();
        List<String> lNotStocked=new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
            UPC=topStockScanProductPage.getUPCwithLocation();
            topStockScanProductPage.scanProduct(UPC,Symbology.UPC_A);
            if(topStockScanProductPage.verifyClickingStockedAndNotStocked(i)){
                lStocked.add(UPC);
            }else{
                lNotStocked.add(UPC);
            }
        }
        stockShelfPage.clickOnReviewBtn();
        String[] stocked=new String[lStocked.size()];
        reviewPage.validateStockedNotStockedItemCountAndUPC(lStocked.toArray(stocked), "Stocked");
        reviewPage.clickNotStockTab();
        String[] NotStocked=new String[lNotStocked.size()];
        reviewPage.validateStockedNotStockedItemCountAndUPC(lNotStocked.toArray(NotStocked), "NotStocked");
    }
}