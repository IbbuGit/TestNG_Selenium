package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.ThankyouBRCPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.JsonPathValueExtractor;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import net.minidev.json.JSONArray;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;

public class ThankyouBRCPage {

    class ScratchPadValues{
        Integer spValue = 0;
        Integer l1l2Value = 1;
        ScratchPadValues(Integer spVal, Integer l1l2Val){
            spValue = spVal;
            l1l2Value = l1l2Val;
        }
    }

    MobileCommands mobileCommands = new MobileCommands();
    ThankyouBRCPageMap thankyouBRCPageMap;
    CommonPage commonPage = new CommonPage ();

    private HashMap<String, ScratchPadValues> backroomCountBeforeSubmit = new HashMap<>();
    private HashMap<String, ScratchPadValues> backroomCountAfterSubmit = new HashMap<>();
    private int wait;

    public ThankyouBRCPage() {
        thankyouBRCPageMap = new ThankyouBRCPageMap();
        wait = 10;
    }

    public void setBackroomCountBeforeSubmit(String[] upcs, HttpClientExecutor apiExecutor, ApiRequestDataHelper dataHelper, Properties prop)
            throws IOException {
        this.backroomCountBeforeSubmit = getBackroomCountL1L2(upcs, apiExecutor, dataHelper, prop);
    }

    public void setBackroomCountAfterSubmit(String[] upcs, HttpClientExecutor apiExecutor, ApiRequestDataHelper dataHelper, Properties prop)
            throws IOException {
        this.backroomCountAfterSubmit = getBackroomCountL1L2(upcs, apiExecutor, dataHelper, prop);
    }


    /*
     *   To click Main Menu button
     */
    public void clickBackMenu() throws InterruptedException, IOException {
        mobileCommands.click(thankyouBRCPageMap.btnMainMenu());
    }

    /*
     *   To validate Thank you page title
     */
    public void validateThankyouTitle(String thankyouScreenTitle) throws InterruptedException, IOException {
        mobileCommands.assertElementDisplayed(thankyouBRCPageMap.headerThankyou(), true);
    }

    /*
     *   To validate Thank you page title
     */
    public void validateTextThankyou(String thankyouText) throws InterruptedException, IOException {
        mobileCommands.assertElementDisplayed(thankyouBRCPageMap.txtThankyou(), true);
    }

    /*public void validateStartAnotherCountButton() {
        mobileCommands.assertElementDisplayed(thankyouBRCPageMap.btnStartAnotherCount(), true);
    }*/

    public void validateBeginMyDailyCountButton() {
        mobileCommands.assertElementDisplayed(thankyouBRCPageMap.beginMyDailyCountButton(), true);
    }

    public void validateProductCount(String expProductCount) {
        mobileCommands.assertElementText(thankyouBRCPageMap.lblProductsCounted(), expProductCount, true);
    }

    public HashMap<String, Integer> getBackroomCount(String[] upcs, HttpClientExecutor apiExecutor, ApiRequestDataHelper dataHelper, Properties prop) throws IOException {
        //Get the base UPC
        HashMap<String, Integer> backroomCount = new HashMap<>();
        String body = dataHelper.getItemLookupBody(upcs);
        String responseItemLookup = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        List<String> baseUpcs = JsonPath.read(responseItemLookup, "$..baseItem.upc");
        List<String> l1L2Value = JsonPath.read(responseItemLookup,"$..items[0].l1L2Details.l1L2");

        //Get the backroom count
        body = dataHelper.getBackroomCount(baseUpcs.stream().toArray(String[]::new));
        String responseBackroomCount = apiExecutor.postHttpClient(prop.getProperty("backroomCount"), body);
        JSONArray itemsNotFound = JsonPath.read(responseBackroomCount, "$.itemsNotFound");
        itemsNotFound.forEach(itemNotFound -> backroomCount.put(itemNotFound.toString(), 0));
        //backroomCountBeforeSubmit.put(itemNotFound.getAsString(),0);
        JSONArray itemsFound = JsonPath.read(responseBackroomCount, "$.items[*].upc");

        itemsFound.forEach(itemFound -> backroomCount.put(itemFound.toString(),
                (int) Double.parseDouble(JsonPath.read(responseBackroomCount,
                        "$.items[?(@.upc =~ /.*" + itemFound
                                + "/)].backroomCount").toString().replaceAll("\\[", "").replaceAll("]", ""))));
        return backroomCount;
    }

    public HashMap<String, ScratchPadValues> getBackroomCountL1L2(String[] upcs, HttpClientExecutor apiExecutor, ApiRequestDataHelper dataHelper, Properties prop) throws IOException {
        //Get the base UPC
        HashMap<String, ScratchPadValues> backroomCount = new HashMap<>();
        String body = dataHelper.getItemLookupBody(upcs);
        String responseItemLookup = apiExecutor.postHttpClient(prop.getProperty("itemLookup"), body);
        //List<String> baseUpcs = JsonPath.read(responseItemLookup, "$..baseItem.upc");
        HashMap<String, Integer> upcsNL1l2 = new HashMap<String, Integer>();
        int numberOfItemsArray = JsonPath.read(responseItemLookup,"$.count");
        for(int currentItem=0;currentItem<numberOfItemsArray;currentItem++){
            upcsNL1l2.put((String) JsonPathValueExtractor.extractValue(responseItemLookup,"$.items["+ currentItem +"]..baseItem.upc"),
                    Integer.parseInt(JsonPathValueExtractor.extractValue(responseItemLookup,"$.items[" + currentItem + "]..l1L2Details.l1L2")));
        }

        //Get the backroom count
        body = dataHelper.getBackroomCount(upcsNL1l2.keySet().stream().toArray(String[]::new));
        String responseBackroomCount = apiExecutor.postHttpClient(prop.getProperty("backroomCount"), body);
        JSONArray itemsNotFound = JsonPath.read(responseBackroomCount, "$.itemsNotFound");
        itemsNotFound.forEach(itemNotFound -> backroomCount.put(itemNotFound.toString(), new ScratchPadValues(0, 1)));
        //backroomCountBeforeSubmit.put(itemNotFound.getAsString(),0);
        JSONArray itemsFound = JsonPath.read(responseBackroomCount, "$.items[*].upc");

        itemsFound.forEach(itemFound -> {
            String tmpUpc = itemFound.toString();
            Integer tmpScratchPadVal = (int) Double.parseDouble(JsonPath.read(responseBackroomCount,
                    "$.items[?(@.upc =~ /.*" + itemFound
                            + "/)].backroomCount").toString().replaceAll("\\[", "").replaceAll("]", ""));
            Object tmpObj = upcsNL1l2.get(tmpUpc);
            Integer tmpL1L2 = Integer.parseInt(upcsNL1l2.get(tmpUpc).toString());
            backroomCount.put(tmpUpc, new ScratchPadValues(tmpScratchPadVal, tmpL1L2));
        });
        return backroomCount;
    }

    public void validateBackroomCount() {
        Iterator hmIterator = this.backroomCountAfterSubmit.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry currentItem = (Map.Entry)hmIterator.next();
            ScratchPadValues spValAfterSubmit = (ScratchPadValues) currentItem.getValue();
            ScratchPadValues spValBeforeSubmit = this.backroomCountBeforeSubmit.get(currentItem.getKey());
            String msgSuffix = " for UPC = " + currentItem.getKey() +
                    " value after submit = " + ((ScratchPadValues) currentItem.getValue()).spValue;
            Assert.assertTrue(spValAfterSubmit.spValue == (spValBeforeSubmit.spValue + spValBeforeSubmit.l1l2Value),
                    "Backroom count was not updated properly" + msgSuffix);
        }
        /*
        Assert.assertTrue(this.backroomCountAfterSubmit.entrySet().stream()
            .allMatch(currentItem -> currentItem.getValue().spValue
            .equals(this.backroomCountBeforeSubmit.get(currentItem.getKey()).spValue +
            currentItem.getValue().l1l2Value)), "Backroom count was not updated properly");
         */
    }

    public void verifyBeginMyDailyCountIsEnabled (){
        mobileCommands.assertElementEnabled(thankyouBRCPageMap.beginMyDailyCountButton(), true);
    }

    public double clickBeginMyDailyCount (){
        mobileCommands.waitForElementVisibility(thankyouBRCPageMap.beginMyDailyCountButton());
        mobileCommands.click(thankyouBRCPageMap.beginMyDailyCountButton());
        return commonPage.getTime ();
    }

    public void validateSpinner(){
        mobileCommands.waitForElementVisibility(thankyouBRCPageMap.spinner());
        mobileCommands.waitForElementInvisible(thankyouBRCPageMap.spinner());
    }
}