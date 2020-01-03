package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.*;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.CountProductPage;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.ReviewCountPage;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.ScanNextProductPage;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.UnSubmittedWorkPopUpPage;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Random;

public class DiscontinuedTagsSingleAndMultipleLocations extends Base {
    private HttpClientExecutor apiExecutor;
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private ScanNextProductPage scanNextProductPage = new ScanNextProductPage();
    private ReviewCountPage reviewCountPage = new ReviewCountPage();
    private CountProductPage countProductPage = new CountProductPage();
    private int QIB, QOD, QIK;
    private String count = "0";

    @BeforeMethod(alwaysRun = true)
    public void init() {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        QIB = 0;
        QOD = 0;
        QIK = 0;
    }

    @Test(groups = "regression")
    public void discontinuedTagsWithSingleLocation() throws Exception {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String responseString = caoDiscontinuedService(upcList);
        HashMap<String, Integer> upcUnitcount = new HashMap<>();
        for (String upc : upcList) {
            updateBOHInSPSToZero(upc);
            String caoItemStatus = JsonPathValueExtractor.extractValue(responseString, "$..[?(@.upc=='" + upc + "')].status");
            switch (caoItemStatus) {
                case "AVAILABLE":
                    count = scan(upc, caoItemStatus);
                    break;
                case "DISCONTINUED":
                    count = scan(upc, caoItemStatus);
                    countProductPage.verifyDiscontinuedTags(sc_Data.getDiscontinuedTag());
                    countProductPage.clickContinue();
                    break;
                case "OUT_OF_STOCK":
                    scan(upc, caoItemStatus);
                    countProductPage.verifyDiscontinuedTags(sc_Data.getOutOfStockTag());
                    countProductPage.clickContinue();
                    break;
            }
            upcUnitcount.put(upc, Integer.parseInt(count));
        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        validateBohChange(upcList, upcUnitcount);

    }

    private String caoDiscontinuedService(String[] UPCs) throws IOException {
        String body = dataHelper.getdiscontinuedTagsParams(UPCs,login_Data.getUsername());
        return apiExecutor.postHttpClient(prop.getProperty("discontinuedTags"), body);
    }

    private void updateBOHInSPSToZero(String upc) throws IOException {
        String bohBody = dataHelper.updateBOHBody(upc, String.valueOf(QIB), String.valueOf(QOD), String.valueOf(QIK));
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), bohBody);
    }

    private String scan(String upc, String status) throws IOException, InterruptedException {
        count = "0";
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            if (status.equals("AVAILABLE")) {
                Random random = new Random();
                while (true) {
                    count = String.valueOf(random.nextInt(11));
                    if (!count.equals("0")) break;
                }
            }
            countProductPage.enterUnitCount(count);
        }
        return count;
    }

    private String getBOH(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private void validateBohChange(String[] upcList, HashMap<String, Integer> upcUnitcount) throws IOException, URISyntaxException {
        HashMap<String, Integer> upcQOD = new HashMap<>();
        for (String upc : upcList) {
            String responseString = getBOH(upc);
            if (responseString.contains("QOD"))
                QOD = JsonPathValueExtractor.extractBOHBucketValue(responseString, "QOD");
            upcQOD.put(upc, QOD);
        }
        for (HashMap.Entry<String, Integer> entry1 : upcQOD.entrySet()) {
            for (HashMap.Entry<String, Integer> entry2 : upcUnitcount.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    Assert.assertEquals(entry2.getValue(), entry1.getValue(), "comparing entered unit count with QOD");
                }
            }
        }
    }

}
