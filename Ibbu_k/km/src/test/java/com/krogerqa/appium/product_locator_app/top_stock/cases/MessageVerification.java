package com.krogerqa.appium.product_locator_app.top_stock.cases;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.TaskListPage;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.top_stock.ui.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

public class MessageVerification extends Base {
    private TopstockProductStockMessagePage stockShelfPage;
    private TopstockScanProductPage topStockScanProductPage;
    private TopStockReviewPage reviewPage;
    private TopStockCompletePage completePage;
    private TopStockKababMenuPage kebabMenuPage;
    private String UPCToScan[];

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) throws IOException, URISyntaxException {
        stockShelfPage = new TopstockProductStockMessagePage();
        topStockScanProductPage = new TopstockScanProductPage(login_Data, prop);
        reviewPage = new TopStockReviewPage();
        completePage = new TopStockCompletePage();
        kebabMenuPage = new TopStockKababMenuPage();
    }

    /*
     * Test Name:           verifyCompleteMsgInNoProductStocked
     * Test Description:    Validate Thank you Screen when No Product Stocked
     * Scenario tested:     Scan the Product, select location,Verify No Stocking Needed Message,
     *                      Click On Review Button,Click On Finish Button,Verify Complete Thank You Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Verify No Stocking Needed Message
     *                      4. Click On Review Button
     *                      5. Click on Finish Button
     *                      6. Verify Thank You Message
     */
    @Test(groups = {"Regression"})
    void verifyCompleteMsgInNoProductStocked() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectOtherLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.clickOnFinishBtn();
        completePage.ValidateCompleteThankYouMsg(ts_Data.getCompleteThankYouMsgTxt());
    }

    /*
     * Test Name:           validateProductStockedMsg
     * Test Description:    Scan the Product and verify the Product Stocked Message
     * Scenario tested:     Scan the Product, select location, STOCKED the product
     *                      and Validate Thank You page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      2. Stock Self
     *                      3. Scan Product
     *                      4. Review
     *                      5. Compete (Thank You)
     */
    @Test(groups = {"Regression"})
    public void validateProductStockedMsg() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
        stockShelfPage.clickOnReviewBtn();
        reviewPage.ValidateAndClickFinishBtn(ts_Data.getFinishBtn());
        completePage.ValidateCompletescreenHeaderTxt(ts_Data.getCompleteHeader());
        completePage.ValidateCompleteThankYouMsg(ts_Data.getCompleteThankYouMsgTxt());
        completePage.ValidateCompletesTxtMsg(ts_Data.getCompleteTxtMsg());
    }

    /*
     * Test Name:           validateShelfAlreadyFullMsg
     * Test Description:    Scan the Product and verify The Shelf Already Full Message
     * Scenario tested:     Scan the Product, select location, NOT STOCKED the product
     *                      and Validate Thank You page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      2. Stock Self
     *                      3. Scan Product
     *                      4. Review
     *                      5. Compete (Thank You)
     */
    @Test(groups = {"Regression"})
    public void validateShelfAlreadyFullMsg() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(topStockScanProductPage.getUPCwithLocation(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.clickOnNotStockedBtn();
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
    }

    /*
     * Test Name:           validateNoStockingNeededMsg
     * Test Description:    Scan the Product and Validate No Stocking Needed message
     * Scenario tested:     Scan the Product, select location, validate No Stocking Needed message
     *                      and Validate Thank You page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Scan Product (No Stock Needed Message)
     *                      3. Review (Not Stocked Tab)
     *                      4. Compete (Thank You)
     */
    @Test(groups = {"Regression"})
    public void validateNoStockingNeededMsg() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(ts_Data.getUpcNo(), Symbology.UPC_A);
        stockShelfPage.ValidateScanProductStockStatus(ts_Data.getProductStatus());
    }

    /*
     * Test Name:           validateBOHInCorrectProductBalanceMsg
     * Test Description:    Verify Correct product Balance Message In BOH Page
     * Scenario tested:     Scan the Product, select location, STOCKED the product
     *                      and Validate Thank You page
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Enter Balance Units and Click Update Balance
     *                      4. Review
     *                      5. Compete (Thank You)
     */
    @Test(groups = {"Regression"})
    public void validateBOHInCorrectProductBalanceMsg() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.clickStockedBtn();
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
    }

    /*
     * Test Name:           ValidateBalanceOnHandUI
     * Test Description:    Verify Balance On Hand UI elements
     * Scenario tested:     Validate the Balance on Hand Page with Incorrect Product and
     *                      Value cannot be less than 1 messages
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. Validate the BOH Screen
     *                      4. Validate Incorrect Product and Value cannot be less than 1 messages
     */
    @Test(groups = {"Regression"})
    void ValidateBalanceOnHandUI() throws Throwable {
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct("UC-" + ts_Data.getUpcNo(), Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.ValidateBOHincorrectProdcutText(ts_Data.getProductStatus());
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
    }

    /*
     * Test Name:           verifyMagicProductScannedMsg
     * Test Description:    Validate Magic Product Scanning Message
     * Scenario tested:     Scan the Product, Verify the Magic product Message
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Magic Product Scanned Message
     */
    @Test(groups = "Regression")
    public void verifyMagicProductScannedMsg() throws Throwable {
        String obj = new DBHelper().executeDBStatment("ILU", "select store_item.upc_no from item_store_info join store_item on item_store_info.store_item_id = store_item.store_item_id where store_item.store_no='00445' and item_store_info.sath_info_vlu='R'");
        List<String> lUPC = JsonPath.read(obj, "$..upc_no");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(lUPC.get(0), Symbology.UPC_A);
        topStockScanProductPage.scanProduct(lUPC.get(0), Symbology.UPC_A);
        topStockScanProductPage.validateMagicProductScannedMsg(ts_Data.getMagicProductMsg());
    }

    /*
     * Test Name:           verifyL1L2ProductLogic
     * Test Description:    verifyL1L2ProductLogic
     * Scenario tested:
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Scan the BOH Product
     *                      3. Verifying the L1L2 Product count
     */
    @Test(groups = "Regression")
    public void verifyL1L2ProductLogic() throws Throwable {
        String upc = ts_Data.getUpcNo();
        String baseUPC = topStockScanProductPage.get_L1L2_BaseUPCValue(upc, "baseupc");
        int l1l2value = Integer.parseInt(topStockScanProductPage.get_L1L2_BaseUPCValue(upc, "l1l2"));
        topStockScanProductPage.setActionableUPC("UC-" + baseUPC);
        topStockScanProductPage.scanProduct(upc, Symbology.UPC_A);
        topStockScanProductPage.selectLocation();
        topStockScanProductPage.clickLocationConfirmBtn();
        stockShelfPage.EnterBalanceUnit(ts_Data.getBalanceUnit());
        stockShelfPage.ClickUpdateBalanceBtn();
        stockShelfPage.verifyStockShelfHeaderTxt(ts_Data.getStockShelfHdrTxt());
        stockShelfPage.ValidateStockUpcTxt(upc);
        stockShelfPage.validateAndClickStockBtn(ts_Data.getStockBtn());
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        int bohQOD = topStockScanProductPage.getBOH_QOD_Value(baseUPC);
        Assert.assertEquals(bohQOD, l1l2value * Integer.parseInt(ts_Data.getBalanceUnit()));
    }


    /*
     * Test Name:           topStockTutorialValidation
     * Test Description:    Validate TopStock Tutorial when User login for first time
     * Scenario tested:     TopStock tutorial
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Login into the Application
     *                      2. Click on TopStock
     *                      3. Verifying the TopStock Tutorial
     */
    @Test(groups = "Regression")
    public void topStockTutorialValidation() throws Throwable {
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
    }
    @Test(groups = "Regression")
    /*
     * Test Name:           validateProductNotFoundErrorMsg
     * Test Description:    Validate Scanner Disabled in Review Page
     * Scenario tested:     Validate Scanner disabled in ReviewPage
     * Story Id:
     * Epic Id:
     * Test data:
     * API tested:
     * UI screen tested:
     *                      1. Scan Product
     *                      2. Confirm Your Location
     *                      3. STOKED the product
     *                      4. Scan the second Product
     *                      5. Validate Location Popup
     */
    public void validateProductNotFoundErrorMsg() throws Throwable {
        UPCToScan = ts_Data.getUpcNo().split(";");
        topStockScanProductPage.ValidateScanProductHeaderTxt(ts_Data.getScanProductHeader());
        topStockScanProductPage.scanProduct(UPCToScan[0], Symbology.CODE_39);
        topStockScanProductPage.verifyBarCodeNotRecognizedHdr(ts_Data.getBarCodeNotRecognizedTxt());
        topStockScanProductPage.enterUPC(UPCToScan[1]);
        topStockScanProductPage.clickSubmitBtn();
        topStockScanProductPage.verifyProductNotFoundTxt(ts_Data.getProductNotFound());
    }
}
