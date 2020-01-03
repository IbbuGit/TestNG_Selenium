package com.krogerqa.appium.product_locator_app.one_time_order.cases;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.DBHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OneTimeOrderE2E extends Base {
    private BeginOrderScreenPage beginOrderScreenPage;
    private UpdateOrderScreenPage updateOrderScreenPage;
    private OrderUpdatedScreenPage orderUpdatedScreenPage;
    private MyOrderScreenPage myOrderScreenPage;
    private ScanProductPage scanProductPage;
    private OrderInProgressPage orderInprogressPage;
    private ManualEnterUPCPage manualEnterUPCPage;
    private OrderSummaryPage orderSummaryPage;
    private String query;
    private DBHelper dbHelper;
    private HashMap<String, String> mapProductCountReview;
    private HashMap<String, String> mapProductQtyScanned;
    private HashMap<String, String> mapDBProductQty;



    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        beginOrderScreenPage = new BeginOrderScreenPage();
        updateOrderScreenPage = new UpdateOrderScreenPage();
        orderUpdatedScreenPage = new OrderUpdatedScreenPage();
        myOrderScreenPage = new MyOrderScreenPage();
        scanProductPage = new ScanProductPage();
        orderInprogressPage = new OrderInProgressPage();
        manualEnterUPCPage = new ManualEnterUPCPage();
        orderSummaryPage = new OrderSummaryPage();
        query = "";
        dbHelper = new DBHelper();
        mapProductCountReview = new HashMap<>();
        mapProductQtyScanned = new HashMap<>();
        mapDBProductQty = new HashMap<>();
    }

    @Test(groups = {"e2e"})
    public void addItemsVerifyInReviewPage() throws Throwable {
        mapProductQtyScanned = flowTillReview();
        reviewAndSubmitValidation(mapProductQtyScanned);
    }

    @Test(groups = {"e2e"})
    public void updateItemsVerifyInReviewPage() throws Throwable {
        mapProductQtyScanned = flowTillReview();
        myOrderScreenPage.clickItemToUpdate();
        int unit = updateOrderScreenPage.getRandomInteger(10, 1);
        updateOrderScreenPage.enterValueInCase(String.valueOf(unit));
        mapProductQtyScanned.put(updateOrderScreenPage.getUpcOnTheScreen(), String.valueOf(unit));
        updateOrderScreenPage.clickAddToOrderBtn();
        reviewAndSubmitValidation(mapProductQtyScanned);
    }

    @Test(groups = {"e2e"})
    public void deleteItemsVerifyInReviewPage() throws Throwable {
        mapProductQtyScanned = flowTillReview();
        String upc = myOrderScreenPage.clickItemToDelete();
        mapProductQtyScanned.remove(upc);
        myOrderScreenPage.clickDialogRemove();
        reviewAndSubmitValidation(mapProductQtyScanned);
    }

    @Test(groups = {"e2e"})
    public void sessionVerifyInReviewPage() throws Throwable {
        mapProductQtyScanned = flowTillReview();
        myOrderScreenPage.clickBack();
        myOrderScreenPage.clickDialogExitWOSubmiting();
        beginOrderScreenPage.clickOneTimeOrder();
        orderInprogressPage.clickDialogContinue();
        reviewAndSubmitValidation(mapProductQtyScanned);
    }

    public HashMap<String, String> flowTillReview() throws InterruptedException, IOException {
        String[] upcsToScan = oto_Data.getProductToScan().split(";");
        for (String currentUPC : upcsToScan) {
            if (oto_Data.getScanOrManualEntry().equalsIgnoreCase(Consts.scanUPC)) {
                beginOrderScreenPage.waitForTheScanPage();
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
                int unit = updateOrderScreenPage.getRandomInteger(10, 1);
                updateOrderScreenPage.enterValueInCase(String.valueOf(unit));
                mapProductQtyScanned.put(currentUPC, String.valueOf(unit));
                updateOrderScreenPage.clickAddToOrderBtn();
                beginOrderScreenPage.waitForTheScanPage();
            } else {
                beginOrderScreenPage.clickEnterUPCButton();
                manualEnterUPCPage.enterProductUPC(currentUPC);
                manualEnterUPCPage.clickSubmitButton();
                int unit = updateOrderScreenPage.getRandomInteger(10, 1);
                updateOrderScreenPage.enterValueInCase(String.valueOf(unit));
                updateOrderScreenPage.clickAddToOrderBtn();
                mapProductQtyScanned.put(currentUPC, String.valueOf(unit));
                orderUpdatedScreenPage.clickEnterUpc();
            }

        }
        orderUpdatedScreenPage.clickReview();
        return mapProductQtyScanned;
    }
    public void validateProductsAndCounts(HashMap<String, String> productsScanned, HashMap<String, String> productsReviewed, HashMap<String, String> productsDB){
        Assert.assertTrue(productsScanned.equals(productsReviewed),"Products and cases Reviewed and scanned are not equal");
        if(productsScanned.equals(productsReviewed)){
            Assert.assertTrue(productsReviewed.equals(productsDB),"Products and cases Reviewed and in database are not equal");
        }
    }

    public HashMap<String, String> getDBProductCaseQty(Set<String> upcScanned) throws SQLException {

        for(String upc:upcScanned) {
            query = "select CASE_QTY from ADHOC_ORDER_ITEM where ADHOC_ORDER_ID in (select max(ADHOC_ORDER_ID) from ADHOC_ORDER where euid = '"+login_Data.getUsername()+"' ) and base_upc_no = '"+upc+"';";
            String caseQtyJson = dbHelper.executeDBStatment("oto", query);
            String expression = "$..CASE_QTY";
            List<Integer> caseQty= JsonPath.read(caseQtyJson,expression);
            mapDBProductQty.put(upc,caseQty.get(0).toString());
        }
        return mapDBProductQty;
    }

    public void reviewAndSubmitValidation(HashMap<String, String> mapProductQtyScanned) throws Throwable{
        mapProductCountReview = myOrderScreenPage.getListProductcount();
        beginOrderScreenPage.validateScannedReviewedProducts(mapProductQtyScanned, mapProductCountReview);
        myOrderScreenPage.clickSubmit();
        myOrderScreenPage.clickDialogSubmit();
        Set<String> upcsScanned = mapProductQtyScanned.keySet();
        String orderScreenStatus = orderSummaryPage.getOrderStatusTxt();
        HashMap<String, String> mapThankYouProductQty = orderSummaryPage.getProductCount(upcsScanned.size());
        orderSummaryPage.mainMenuBtnClick();
        validateOrderStatus(orderScreenStatus);
        mapDBProductQty = getDBProductCaseQty(upcsScanned);
        validateProductsAndCounts(mapProductQtyScanned,mapThankYouProductQty, mapDBProductQty);
    }

    public void validateOrderStatus(String orderScreenStatus) throws SQLException{
        query="select order_sts from adhoc_order where adhoc_order_id in (SELECT max(adhoc_order_id) FROM ADHOC_ORDER where euid = '"+login_Data.getUsername()+"' group by euid)";
        String orderStatusJson = dbHelper.executeDBStatment("oto", query);
        String expression = "$..order_sts";
        List<String> order_sts= JsonPath.read(orderStatusJson,expression);
        if(orderScreenStatus.contains("successful")){
            Assert.assertEquals(order_sts.get(0),"SUBMITTED", "comparing when SUCCESSFUL in the screen");
        }
        else{
            Assert.assertEquals(order_sts.get(0),"PENDING","comparing when PENDING in the screen");
        }
    }
}
