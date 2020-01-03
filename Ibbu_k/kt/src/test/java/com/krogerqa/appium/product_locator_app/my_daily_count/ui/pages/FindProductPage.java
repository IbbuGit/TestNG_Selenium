package com.krogerqa.appium.product_locator_app.my_daily_count.ui.pages;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.ThankyouBRCPage;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.my_daily_count.dataBeans.My_Daily_Count_TestDataBean;
import com.krogerqa.appium.product_locator_app.my_daily_count.ui.maps.*;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import net.minidev.json.JSONArray;
import net.sourceforge.marathon.javaagent.Wait;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FindProductPage extends Base {
    private static int totalCount;
    private int currentCount;
    public static int successCount = 0;

    private HashMap<String, Integer> scannedItems = new HashMap<>();
    private AddProductToCountPage addProductToCountPage = new AddProductToCountPage();
    private String body = "";
    private boolean isFreeScanMultiLocation = false;

    MobileCommands mobileCommands = new MobileCommands();
    ScanProductPage scanProductPage = new ScanProductPage();
    CommonPage commonPage = new CommonPage();
    MDCCountProductPage mdcCountProductPage = new MDCCountProductPage();
    SelectYourLocationMap selectYourLocationMap = new SelectYourLocationMap();
    SelectYourLocationPage selectYourLocationPage = new SelectYourLocationPage();
    AddProductToCountMap addProductToCountMap = new AddProductToCountMap();
    FindProductMap findProductMap = new FindProductMap();
    MDCCountProductMap mdcCountProductMap = new MDCCountProductMap();
    MDCReviewCountPage mdcReviewCountPage = new MDCReviewCountPage();


    public void validatePrdCountSize(String prdCountSize) {
        int expectedPrdCount = Integer.parseInt(prdCountSize.split("@")[1]);
        int actualPrdCount = getProductCountStatus();
        Assert.assertTrue(actualPrdCount <= getProductCountStatus(), "");

    }

    public void validateFindProductPageTitle(String findProductTitle) {
        mobileCommands.assertElementText(findProductMap.findProductPageTitle(), findProductTitle, true);
    }

    public int getProductCountStatus() {
        String productsCountStatus = mobileCommands.getElementText(findProductMap.countStatus());
        int ofLetterIndex = productsCountStatus.indexOf("of");
        int spaceIndex = productsCountStatus.indexOf(' ');
        String currentProductString = productsCountStatus.substring(spaceIndex + 1, ofLetterIndex - 1);
        currentCount = Integer.parseInt(currentProductString);
        String totalProductString = productsCountStatus.substring(ofLetterIndex + 3).trim();
        totalCount = Integer.parseInt(totalProductString);
        return totalCount;
    }

    public void verifyGotoText(String gotoText) {
        mobileCommands.assertElementText(findProductMap.gotoText(), gotoText, true);
    }

    public void verifyFindAndScanText() {
        mobileCommands.assertElementDisplayed(findProductMap.findAndScanText(), true);
    }

    public int scanAndSkipAllProducts(My_Daily_Count_TestDataBean mdc_Data) throws Throwable {
        boolean flag = true;

        for (int i = currentCount; i <= totalCount; i++) {
            if (currentCount % 2 == 0) {
                verifyProgressBar();
                String upc = getUPCOfProduct();
                scanProductPage.scanProduct(upc, Symbology.UPC_A);
                mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
                mdcCountProductPage.clickOnEnterQuantityTextField();
                mdcCountProductPage.enterQuantity();
                mdcCountProductPage.clickOnSubmitCountButton();
                successCount++;
            } else if (flag) {
                flag = false;
                mobileCommands.click(findProductMap.skipButton());
            } else {
                flag = true;
                mobileCommands.click(findProductMap.cantFindButton());
            }
            if (currentCount % 50 == 0) {    //User will visit review list after counting every five products
                if (currentCount != totalCount) {
                    mobileCommands.click(findProductMap.reviewButton());
                    mdcReviewCountPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
                    mdcReviewCountPage.scrollReviewListDown();
                    mdcReviewCountPage.scrollReviewListUp();
                    mdcReviewCountPage.clickContinueButton();
                } else {
                    mdcReviewCountPage.validateReviewCountPageTitle(mdc_Data.getReviewPageTitle());
                    mdcReviewCountPage.scrollReviewListDown();
                    mdcReviewCountPage.scrollReviewListUp();
                    mdcReviewCountPage.clickReviewCountSubmitButton();
                }
            }
            if (currentCount != totalCount) {
                getProductCountStatus();
            }
        }
        return successCount;
    }

    public void scanAndSkipWrongLocAllProducts(My_Daily_Count_TestDataBean mdc_Data) throws Throwable {
        boolean flag = true;
        for (int i = 1; i <= totalCount; i++) {
            if (i % 2 == 0) {
                verifyProgressBar();
                String upc = getUPCOfProduct();
                scanProductPage.scanProduct(upc, Symbology.UPC_A);
                mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
                mdcCountProductPage.clickOnEnterQuantityTextField();
                mdcCountProductPage.swipeAndEnterUnitCount();
                mdcCountProductPage.clickOnSubmitCountButton();
                mdcCountProductPage.verifySnackBarText();
                successCount++;
            } else if (flag) {
                flag = false;
                mobileCommands.click(findProductMap.skipButton());
            } else {
                flag = true;
                mobileCommands.click(findProductMap.cantFindButton());
            }
            List<By> elementsFreeScan = new ArrayList<By>();
            elementsFreeScan.add(addProductToCountMap.addProductToCountAlertTitle());
            elementsFreeScan.add(selectYourLocationMap.selectYourLocationDialogTitle());
            elementsFreeScan.add(mdcCountProductMap.countSubmitBtn());
            elementsFreeScan.add(mdcCountProductMap.enterQuantityTextField());

            if (i == totalCount - 75) {
                for (String upcNum : mdc_Data.getFreeScanItem().split("@")) {
                    mobileCommands.waitForElementClickability(findProductMap.gotoText());
                    //  System.out.println("upcNum--->"+upcNum);
                    scanProductPage.scanProduct(upcNum, Symbology.UPC_A);
                    int elementFreeScan = BaseUtil.visibleWebElementFromListOfWebElement(mobileCommands.getWebDriver(), elementsFreeScan);
                    if (elementFreeScan == 1) {
                        // System.out.println("elementFreeScan==1"+ elementFreeScan);
                        addProductToCountPage.viewAddProductToCountPageTitle(mdc_Data.getAddProductToCountAlertTitle());
                        addProductToCountPage.clickAddProductButton();
                        List<By> tempElement = new ArrayList<By>();
                        tempElement.add(mdcCountProductMap.enterQuantityTextField());
                        tempElement.add(selectYourLocationMap.selectYourLocationDialogTitle());
                        if (BaseUtil.visibleWebElementFromListOfWebElement(mobileCommands.getWebDriver(), tempElement) == 2) {
                            elementFreeScan = 2;
                        }
                    }
                    if (elementFreeScan == 2) {
                        //  System.out.println("elementFreeScan==2"+ elementFreeScan);
                        selectYourLocationPage.viewSelectYourLocationPageTitle(mdc_Data.getSelectYourLocationDialogTitle());
                        selectYourLocationPage.selectRadioButton(mdc_Data.getSelectAisle());
                        selectYourLocationPage.verifyEnabledSelectButton();
                        selectYourLocationPage.clickSelectButton();
                        if (BaseUtil.isElementFoundNoException(mobileCommands.getWebDriver(), mdcCountProductMap.otherAlertTitle())) {
                            mdcCountProductPage.clickOnNextButton();
                            continue;
                        } else {
                            if (!mobileCommands.getElementText(mdcCountProductMap.enterQuantityTextField()).equals("Enter Count")) {
                                elementFreeScan = 4;
                            }
                        }
                    }
                    if (elementFreeScan == 3) {
                        //  System.out.println("elementFreeScan==3"+ elementFreeScan);
                        mdcCountProductPage.clickOnNextButton();
                        continue;
                    }
                    if (elementFreeScan == 4) {
                        // System.out.println("elementFreeScan==4"+ elementFreeScan);
                        mdcCountProductPage.clickOnEnterQuantityTextField();
                        commonPage.verticalSwipeByPercentages(0.6, 0.3, 0.5);
                        mobileCommands.clear(mdcCountProductMap.enterQuantityTextField());
                        mobileCommands.enterText(mdcCountProductMap.enterQuantityTextField(), RandomUtils.nextInt(0, 9999), true);
                        mobileCommands.tapByCoordinates(430, 770);
                        mdcCountProductPage.clickMDCNextButton();
                        continue;
                    }

                    mdcCountProductPage.clickOnEnterQuantityTextField();
                    mdcCountProductPage.swipeAndEnterUnitCount();
                    mdcCountProductPage.clickMDCNextButton();
                    mdcCountProductPage.verifySnackBarText();
                }
                mobileCommands.click(findProductMap.skipButton());
            }
        }

    }

    public String getScannedUPC(My_Daily_Count_TestDataBean mdc_Data) throws Throwable {
        String addUpcs = "";
        String upc = "";
        for (int i = 1; i <= 3; i++) {

            if (i == 1) {
                //verifyProgressBar();
                upc = getUPCOfProduct();
                addUpcs += upc + "@";
                scanProductPage.scanProduct(upc, Symbology.UPC_A);
                mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
                mdcCountProductPage.clickOnEnterQuantityTextField();
                mdcCountProductPage.swipeAndEnterUnitCount();
                mdcCountProductPage.clickOnSubmitCountButton();
                mdcCountProductPage.verifySnackBarText();

            } else if (i == 2) {
                verifyProgressBar();
                upc = getUPCOfProduct();
                addUpcs += upc + "@";
                mobileCommands.click(findProductMap.skipButton());
            } else if (i == 3) {
                verifyProgressBar();
                upc = getUPCOfProduct();
                addUpcs += upc;
                mobileCommands.click(findProductMap.cantFindButton());
            }

        }
        return addUpcs;

    }

    public void scanAllProducts(My_Daily_Count_TestDataBean mdc_Data) throws IOException {
        for (int i = currentCount; i <= totalCount; i++) {
            verifyProgressBar();
            String upc = getUPCOfProduct();
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
            mdcCountProductPage.clickOnEnterQuantityTextField();
            mdcCountProductPage.enterQuantity();
            mdcCountProductPage.clickOnSubmitCountButton();
            commonPage.validateToastMessage(mdc_Data.getCountreceivedmessage());

            if (currentCount != totalCount) {
                getProductCountStatus();
            }
        }
    }

    public void scanSingleProduct() throws IOException {
        String upc = getUPCOfProduct();
        scanProductPage.scanProduct(upc, Symbology.UPC_A);
    }

    public static int getSuccessCount() {
        return successCount;
    }

    public FindProductPage() {
        findProductMap = new FindProductMap();
    }

    public void verifyProgressBar() {
        mobileCommands.isElementExist(findProductMap.progerssBar());
    }

    public void verifyUPC() {
        mobileCommands.assertElementDisplayed(findProductMap.upc(), true);
    }

    public String getUPCOfProduct() {
        return mobileCommands.getElementText(findProductMap.upc());
    }

    public void verifyProductDescription() {
        mobileCommands.assertElementDisplayed(findProductMap.productDescription(), true);
    }

    public void verifyProductPrice() {
        mobileCommands.assertElementDisplayed(findProductMap.productPrice(), true);
    }

    public void verifyCantFindButton() {
        mobileCommands.assertElementDisplayed(findProductMap.cantFindButton(), true);
    }

    public void clickOnEnterUPCBtn() {
        mobileCommands.click(findProductMap.enterUPCButton());
    }

    public void clickOnUPCTextField() {
        mobileCommands.click(findProductMap.manualUPCTextField());
    }

    public void enterUPCInTextField(String upc) {
        mobileCommands.enterKeyOnElement(findProductMap.manualUPCTextField());
        mobileCommands.enterText(findProductMap.manualUPCTextField(), upc, true);
    }

    public void clickUPCSubmit() {
        mobileCommands.click(findProductMap.manualUPCSubmitBtn());
    }


    public void clickWrongLocationButton() {
        mobileCommands.click(findProductMap.cantFindButton());
    }

    public void clickSkipButton() {
        mobileCommands.click(findProductMap.skipButton());
    }


    public void verifyDisabledMDCReviewButton() {
        //myAssert.assertEquals ( "false",findProductMap.mdcReviewButton.getAttribute ( "enabled" ) );
        mobileCommands.assertElementEnabled(findProductMap.reviewButton(), false);
    }

    public void verifyEnabledMDCReviewButton() {
        //myAssert.assertEquals ( "true",findProductMap.mdcReviewButton.getAttribute ( "enabled" ) );
        mobileCommands.assertElementEnabled(findProductMap.reviewButton(), true);
    }

    public void verifyImageIcon() {
        mobileCommands.assertElementDisplayed(findProductMap.imageIcon(), true);
    }

    public void openImage() {
        mobileCommands.click(findProductMap.imageIcon());
    }

    public void enlargedImage() {
        mobileCommands.assertElementDisplayed(findProductMap.enlargedImage(), true);
        mobileCommands.click(findProductMap.closeImage());
    }

    public void verifyReviewButton() {
        mobileCommands.assertElementDisplayed(findProductMap.reviewButton(), true);
    }

    public void verifyReviewButtonNotDisplayed() {
        WebDriver driver = mobileCommands.getWebDriver();
        if ((driver.findElements(findProductMap.reviewButton()).size()) == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void clickReviewButton() {
        mobileCommands.click(findProductMap.reviewButton());
    }

    public void verifySkipButton() {
        mobileCommands.assertElementDisplayed(findProductMap.skipButton(), true);
    }

    public void clickOnSkipButton() {
        mobileCommands.click(findProductMap.skipButton());

    }


    public int allPrdScan(My_Daily_Count_TestDataBean mdc_Data) throws IOException {

        for (int i = currentCount; i <= totalCount; i++) {
            verifyProgressBar();
            String upc = getUPCOfProduct();
            scanProductPage.scanProduct(upc, Symbology.UPC_A);
            mdcCountProductPage.validateCountProductPageTitle(mdc_Data.getCountProductTitle());
            mdcCountProductPage.clickOnEnterQuantityTextField();
            mdcCountProductPage.swipeAndEnterUnitCount();
            mdcCountProductPage.clickMDCNextButton();
            if (currentCount != totalCount) {
                getProductCountStatus();
            }
        }return totalCount;
    }

    public void clickMDCReviewButton() {
        mobileCommands.click(findProductMap.reviewButton());
    }

    // E2E -Please dont change

    public HashMap<String, Integer> getScannedItems() {
        return this.scannedItems;
    }

    public void setScannedItems(String upc, Integer qty, Integer brcQty) {
        Integer existingVal = this.getScannedItems().get(upc);
        if (existingVal == null) {
            this.scannedItems.put(upc, qty + brcQty);
        } else {
            this.scannedItems.put(upc, existingVal + qty);
        }
    }


    public void validateBackRoomUpc(My_Daily_Count_TestDataBean mdc_Data, int numberOfProducts) throws IOException {
        boolean backroomItemFound = false;
        for (int i = 0; i < numberOfProducts; i++) {
            verifyProgressBar();
            String backRoomUpc = mdc_Data.getDeliUpc();
            String upc = getUPCOfProduct();
            if (!backroomItemFound && backRoomUpc.equals(upc)) {
                backroomItemFound = true;
            }
            mobileCommands.click(findProductMap.cantFindButton());
        }
        Assert.assertTrue(backroomItemFound, "Backroom scanned item not found in MDC");
        mdcReviewCountPage.clickReviewCountSubmitButton();
    }

    public void scanAndSkipAllProducts(My_Daily_Count_TestDataBean mdc_Data, String[] freeScanUPC,
                                       HttpClientExecutor apiExecutor,
                                       ApiRequestDataHelper dataHelper, Properties prop) throws IOException, URISyntaxException {
        ThankyouBRCPage thankyouBRCPage = new ThankyouBRCPage();
        int numberOfLocInMdc = 1;
        int noOfLoc = 0;
        for (int i = currentCount; i <= totalCount; i++) {
            String upc = getUPCOfProduct();
            String currentUpcQty = mdc_Data.getUserQuantity();
            int backroomCount = 0;
            int currentQibValue = 0;
            String getBohResponse = "";

            if ((i % 2) == 1) {
                verifyProgressBar();
                scanProductPage.scanProduct(upc, Symbology.UPC_A);
                mdcCountProductPage.clickOnEnterQuantityTextField();
                mdcCountProductPage.enterQuantity(currentUpcQty);
                mdcCountProductPage.clickOnNextButton();
            } else {
                mobileCommands.click(findProductMap.cantFindButton());
            }
            getBohResponse = apiExecutor.getHttpClient(dataHelper.getProperties().getProperty("getBOH"), dataHelper.getBOHParams(upc));
            try {
                currentQibValue = JsonPathValueExtractor.extractBOHBucketValue(getBohResponse, "QIB");
            } catch (Exception allException) {
            }
            backroomCount = thankyouBRCPage.getBackroomCount(new String[]{upc}, apiExecutor, dataHelper, dataHelper.getProperties()).get(upc).intValue();
            setScannedItems(upc, Integer.parseInt(currentUpcQty), currentQibValue == 0 ? backroomCount : 0);
            updateBohForUpc(upc, "5", apiExecutor, dataHelper, dataHelper.getProperties());


            if (currentCount != totalCount) {
                getProductCountStatus();
            }
        }
        Iterator<HashMap.Entry<String, Integer>> iterator = getScannedItems().entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> upcToValidate = iterator.next();
            mobileCommands.wait(20);
            String response = apiExecutor.getHttpClient(dataHelper.getProperties().getProperty("getBOH"), dataHelper.getBOHParams(upcToValidate.getKey()));
            try {
                if (response.contains("QOD")) {
                    int newQOD = JsonPathValueExtractor.extractBOHBucketValue(response, "QOD");
                    Assert.assertTrue(newQOD == upcToValidate.getValue(), "QOD update for " + upcToValidate.getKey() + " mismatch - Expected : " +
                            upcToValidate.getValue() + ", Actual : " + newQOD);
                }
            } catch (Exception allException) {
                throw allException;
            }
        }
        if (getFreeScanMultiLocation()) {
            multiLocFreeScanAtTheEnd(freeScanUPC, mdc_Data, apiExecutor, prop, dataHelper);

        }

    }

    public void manualScan(My_Daily_Count_TestDataBean mdc_Data,
                           String freeScanUpcsToScan[], HttpClientExecutor apiExecutor, ApiRequestDataHelper dataHelper, Properties prop) throws IOException, URISyntaxException {
        for (String currentUPC : freeScanUpcsToScan) {
            mobileCommands.wait(20);
            updateBohForUpc(currentUPC, "10", apiExecutor, dataHelper, prop);
            scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
            WebDriver driver = mobileCommands.getWebDriver();

            if ((driver.findElements((addProductToCountMap.addProductButton())).size() > 0)) {
                addProductToCountPage.clickAddProductButton();
            }
            if (selectYourLocationPage.selectRadioButton()) {
                selectYourLocationPage.clickSelectButton();
                setFreeScanMultiLocation(true);
            }
            mdcCountProductPage.enterQuantity(mdc_Data.getUserQuantity());
            mdcCountProductPage.clickOnNextButton();


        }

    }

    public boolean getFreeScanMultiLocation() {
        return this.isFreeScanMultiLocation;
    }

    public void setFreeScanMultiLocation(boolean freeScanMultiLocation) {
        this.isFreeScanMultiLocation = freeScanMultiLocation;
    }

    public void updateBohForUpc(String upc, String qty, HttpClientExecutor apiExecutor,
                                ApiRequestDataHelper dataHelper, Properties prop) throws IOException {
        String body = dataHelper.updateBOHBody(upc, qty, null, null);
        apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
    }

    private void multiLocFreeScanAtTheEnd(String[] freeScanUPC, My_Daily_Count_TestDataBean mdc_Data,
                                          HttpClientExecutor apiExecutor, Properties prop,
                                          ApiRequestDataHelper dataHelper) throws IOException, URISyntaxException {
        ThankyouBRCPage thankyouBRCPage = new ThankyouBRCPage();
        String body = dataHelper.getItemLookupBody(freeScanUPC);
        String responseItemLookup = apiExecutor.postHttpClient(dataHelper.getProperties().getProperty("itemLookup"), body);
        List<Integer> length = JsonPath.read(responseItemLookup, "$..locations.length()");
        int noOfLoc = length.get(0);

        for (int locationIteration = 2; locationIteration <= noOfLoc; locationIteration++) {
            Assert.assertTrue(getUPCOfProduct().contains(freeScanUPC[0]), "UPC displayed " +
                    getUPCOfProduct() + " is different from the manual scan UPC " + freeScanUPC[0]);

            mobileCommands.click(findProductMap.cantFindButton());
        }

        for (String currentUPC : freeScanUPC) {
            body = dataHelper.updateBOHBody(currentUPC, null, null, "0");
            int mdcQuantityToEnter = Integer.parseInt(mdc_Data.getUserQuantity());
            mobileCommands.wait(20);
            apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
            String response = apiExecutor.getHttpClient(prop.getProperty("getBOH"), dataHelper.getBOHParams(currentUPC));
            HashMap<String, Integer> backroomCountMap = thankyouBRCPage.getBackroomCount(new String[]{currentUPC}, apiExecutor, dataHelper, prop);
            int backRoomForCurrentUpc = backroomCountMap.get(currentUPC);
            mobileCommands.wait(20);
            apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
            response = apiExecutor.getHttpClient(prop.getProperty("getBOH"), dataHelper.getBOHParams(currentUPC));
            int afterMdcQod = JsonPathValueExtractor.extractBOHBucketValue(response, "QOD");
            Assert.assertTrue((mdcQuantityToEnter + backRoomForCurrentUpc) == afterMdcQod, "QOD Update failure for :" + currentUPC + " Expected " +
                    (mdcQuantityToEnter + backRoomForCurrentUpc) + " but found " + afterMdcQod);
            apiExecutor.postHttpClient(prop.getProperty("updateBOH"), body);
            response = apiExecutor.getHttpClient(prop.getProperty("getBOH"), dataHelper.getBOHParams(currentUPC));

        }

    }
}

