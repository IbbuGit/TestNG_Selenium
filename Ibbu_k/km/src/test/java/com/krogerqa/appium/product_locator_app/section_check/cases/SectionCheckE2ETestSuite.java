package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class SectionCheckE2ETestSuite extends Base {
    private HttpClientExecutor apiExecutor;
    private ApiRequestDataHelper dataHelper = new ApiRequestDataHelper();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private CountProductPage countProductPage = new CountProductPage();
    private ScanNextProductPage scanNextProductPage = new ScanNextProductPage();
    private ReviewCountPage reviewCountPage = new ReviewCountPage();
    private ThankYouPage thankYouPage = new ThankYouPage();
    private ManualEnterUPCPage manualEnterUPCPage = new ManualEnterUPCPage();
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
    private ThankyouBRCPage thankyouBRCPage = new ThankyouBRCPage();
    private SectionCheckPage sectionCheckPage = new SectionCheckPage();
    private CantFindSkipPage cantFindSkipPage = new CantFindSkipPage();

    private HashMap<String, HashMap<String, Integer>> upcBohMapping;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        upcBohMapping = new HashMap<>();
    }

    @Test(groups = "e2e")
    public void countMultipleProductsWithSingleLocation() throws Exception {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String[] allocations = sc_Data.getAllocationCount().split(";");
        String[] units = sc_Data.getUnitsCount().split(";");

        int iteration = 0;
        for (String upc : upcList) {
            String count = units[iteration];
            extractQIBAndCountToMap(upc, count);

            scanUpc(upc);
            countProductPage.UpdateShelfAllocation(allocations[iteration]);
            countProductPage.enterUnitCount(count);
            Thread.sleep(2000);
            iteration++;

        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.clickOnMainMenu();

        getNewQODAndBackRoomCount(upcList);
        int index = 0;
        for (String upc : upcList) {
            String updatedShelfAllocation = JsonPathValueExtractor.extractShelfAllocation(getSectionCheckScan(upc));
            Assert.assertEquals(allocations[index], updatedShelfAllocation);
            index++;
        }
        validateBuckets(upcBohMapping, false);
    }


    @Test(groups = "e2e")
    public void removeAndEditProductsWithSingleLocation() throws Throwable {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String[] units = sc_Data.getUnitsCount().split(";");

        int iteration = 0;
        for (String upc : upcList) {
            String count = units[iteration];
            extractQIBAndCountToMap(upc, count);

            scanUpc(upc);
            countProductPage.enterUnitCount(units[iteration]);
            Thread.sleep(2000);
            iteration++;
        }

        scanNextProductPage.clickOnReviewBtn();
        String upcToRemove = reviewCountPage.firstUpcInReviewPage();
        reviewCountPage.removeAnItem();
        String upcToEdit = reviewCountPage.firstUpcInReviewPage();
        reviewCountPage.editAnItem();
        countProductPage.editUnitCount(sc_Data.getEditCount());
        upcBohMapping.get(upcToEdit).put("count", Integer.parseInt(sc_Data.getEditCount()));
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.verifyProductsCounted(upcList);
        thankYouPage.clickOnMainMenu();

        getNewQODAndBackRoomCount(upcList);
        upcBohMapping.remove(upcToRemove);
        validateBuckets(upcBohMapping, false);
    }

    @Test(groups = "e2e")
    public void retainSession() throws Exception {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String[] units = sc_Data.getUnitsCount().split(";");

        int iteration = 0;
        for (String upc : upcList) {
            String count = units[iteration];
            extractQIBAndCountToMap(upc, count);

            scanUpc(upc);
            countProductPage.enterUnitCount(units[iteration]);
            Thread.sleep(2000);
            iteration++;
        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.exitSession(Arrays.asList(upcList));
        thankYouPage.clickOnMainMenu();

        getNewQODAndBackRoomCount(upcList);
        validateBuckets(upcBohMapping, false);
    }

    @Test(groups = "e2e")
    public void countMultipleProductsWithMultiLocations() throws Exception {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String[] units = sc_Data.getUnitsCount().split(";");

        int iteration = 0;
        int noOfLocations = 0;
        for (String upc : upcList) {
            String count = units[iteration];
            extractQIBAndCountToMap(upc, count);
            scanUpc(upc);
            String response = getSectionCheckScan(upc);
            noOfLocations += JsonPathValueExtractor.extractNoOfLocations(response);
            sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());

            countProductPage.verifyCountProductScreen(count);
            Thread.sleep(2000);

            iteration++;

        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifyMultiLocationBannerMsg_ClickOnContinue(sc_Data.getMultiLocationBannerMsg());
        reviewCountPage.clickContinueBtn_RemainingLocationPopup(sc_Data.getCountRemainingLocationHdrMsg());
        noOfLocations = noOfLocations - upcList.length;
        while (noOfLocations > 0) {
            String upc = scanProductPage.getUpcText();
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            int count = upcBohMapping.get(upc).get("count");
            countProductPage.verifyCountProductScreen(Integer.toString(count));
            upcBohMapping.get(upc).put("count", count + count);
            noOfLocations--;
        }

        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.clickOnMainMenu();

        getNewQODAndBackRoomCount(upcList);
        validateBuckets(upcBohMapping, false);
    }

    @Test(groups = "e2e")
    public void countMultipleProductsWithMultiLocationsWithSkipLogic() throws Exception {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        String[] upcList = sc_Data.getProductToScan().split(";");
        String[] units = sc_Data.getUnitsCount().split(";");

        int iteration = 0;
        int noOfLocations = 0;
        for (String upc : upcList) {
            String count = units[iteration];
            extractQIBAndCountToMap(upc, count);
            scanUpc(upc);
            String response = getSectionCheckScan(upc);
            noOfLocations += JsonPathValueExtractor.extractNoOfLocations(response);
            sectionCheckPage.selectLocationRadioBtn(sc_Data.getLocationId());

            countProductPage.verifyCountProductScreen(count);
            Thread.sleep(2000);

            iteration++;
        }
        scanNextProductPage.clickOnReviewBtn();
        reviewCountPage.verifyMultiLocationBannerMsg_ClickOnContinue(sc_Data.getMultiLocationBannerMsg());
        reviewCountPage.clickContinueBtn_RemainingLocationPopup(sc_Data.getCountRemainingLocationHdrMsg());
        noOfLocations = noOfLocations - upcList.length;
        while (noOfLocations > 1) {
            String upc = scanProductPage.getUpcText();
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            int count = upcBohMapping.get(upc).get("count");
            countProductPage.verifyCountProductScreen(Integer.toString(count));
            upcBohMapping.get(upc).put("count", count + count);
            noOfLocations--;
        }

        cantFindSkipPage.clickOnCantFindSkipBtn();
        reviewCountPage.clickOnSubmitBtn();
        thankYouPage.clickOnMainMenu();

        getNewQODAndBackRoomCount(upcList);
        validateBuckets(upcBohMapping, true);
    }

    private void getNewQODAndBackRoomCount(String[] upcList) throws IOException, URISyntaxException {
        HashMap<String, Integer> backRoomCountList = thankyouBRCPage.getBackroomCount(upcList, apiExecutor, dataHelper, prop);
        for (String upc : upcList) {
            HashMap<String, Integer> map = upcBohMapping.get(upc);
            map.put("newQOD", JsonPathValueExtractor.extractBOHBucketValue(getBOH(upc), "QOD"));
            map.put("backRoomCount", backRoomCountList.getOrDefault(upc, 0));
            upcBohMapping.put(upc, map);
        }
    }

    private String getBOH(String UPC) throws IOException, URISyntaxException {
        NameValuePair[] params = dataHelper.getBOHParams(UPC);
        return apiExecutor.getHttpClient(prop.getProperty("getBOH"), params);
    }

    private String getSectionCheckScan(String UPC) throws IOException {
        String body = dataHelper.sectionCheckScan(UPC, login_Data.getUsername());
        return apiExecutor.postHttpClient(prop.getProperty("sectionCheckScan"), body);
    }

    private void scanUpc(String upc) throws IOException {
        if (sc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
        } else {
            scanNextProductPage.clickOnEnterUPCBtn();
            manualEnterUPCPage.enterProductUPC(upc);
            manualEnterUPCPage.clickSubmitButton();
        }
    }

    private void validateBuckets(HashMap<String, HashMap<String, Integer>> upcBohMapping, boolean skip) {
        Set<String> upcList;
        upcList = upcBohMapping.keySet();
        int expectedQOD;
        for (String upc : upcList) {
            int newQOD = upcBohMapping.get(upc).get("newQOD");
            int QIB = upcBohMapping.get(upc).get("QIB");
            int backRoomCount = upcBohMapping.get(upc).get("backRoomCount");
            int count = upcBohMapping.get(upc).get("count");
            if (QIB == 0) {
                expectedQOD = backRoomCount + count;
            } else {
                expectedQOD = count;
            }
            if (skip) {
                int oldQOD = upcBohMapping.get(upc).get("oldQOD");
                expectedQOD = Math.max(expectedQOD, oldQOD);
            }
            Assert.assertEquals(newQOD, expectedQOD, "Expected and Actual QOD buckets are not equals");
        }
    }

    private void extractQIBAndCountToMap(String upc, String count) throws IOException, URISyntaxException {
        HashMap<String, Integer> bohMap = new HashMap<>();
        int QIB = JsonPathValueExtractor.extractBOHBucketValue(getBOH(upc), "QIB");
        int oldQOD = JsonPathValueExtractor.extractBOHBucketValue(getBOH(upc), "QOD");
        bohMap.put("QIB", QIB);
        bohMap.put("oldQOD", oldQOD);
        bohMap.put("count", Integer.parseInt(count));
        upcBohMapping.put(upc, bohMap);
    }
}


