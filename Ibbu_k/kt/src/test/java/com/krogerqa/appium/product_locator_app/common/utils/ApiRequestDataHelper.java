package com.krogerqa.appium.product_locator_app.common.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.krogerqa.seleniumcentral.framework.main.BaseTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ApiRequestDataHelper {

    private Properties prop;

    public ApiRequestDataHelper() {
        prop = BaseUtil.readAPIUrls(BaseTest.class.getResource("/common/data/stageAPI.properties").getPath());
    }

    public String updateBOHBody(String UPC, String QODQuantity, String QIKQuantity, String QIBQuantity){
        JsonObject body = new JsonObject();
        body.addProperty("store", prop.getProperty("store"));
        body.addProperty("source", "DR");
        body.addProperty("division", prop.getProperty("division"));
        JsonArray upcList = new JsonArray();
        if(!(QODQuantity == null)){

            JsonObject QODObject = new JsonObject();
            QODObject.addProperty("baseUpc", UPC);
            QODObject.addProperty("trailerUpc", UPC);
            QODObject.addProperty("reasonCodeType", "R");
            QODObject.addProperty("location", "STO_QOD");
            QODObject.addProperty("scanQty", QODQuantity);
            upcList.add(QODObject);
        }
        if(!(QIKQuantity == null)) {
            JsonObject QIKObject = new JsonObject();
            QIKObject.addProperty("baseUpc", UPC);
            QIKObject.addProperty("trailerUpc", UPC);
            QIKObject.addProperty("reasonCodeType", "R");
            QIKObject.addProperty("location", "STO_QIK");
            QIKObject.addProperty("scanQty", QIKQuantity);
            upcList.add(QIKObject);
        }
        if(!(QIBQuantity == null)){
            JsonObject QIBObject = new JsonObject();
            QIBObject.addProperty("baseUpc", UPC);
            QIBObject.addProperty("trailerUpc", UPC);
            QIBObject.addProperty("reasonCodeType", "R");
            QIBObject.addProperty("location", "STO_QIB");
            QIBObject.addProperty("scanQty", QIBQuantity);
            upcList.add(QIBObject);
        }

        body.add("upcList", upcList);
        return body.toString();
    }

    public NameValuePair[] getBOHParams(String UPC){
        NameValuePair storeParam = new BasicNameValuePair("store", prop.getProperty("store"));
        NameValuePair divisionParam = new BasicNameValuePair("division", prop.getProperty("division"));
        NameValuePair upcsParam = new BasicNameValuePair("upcs", UPC);
        NameValuePair[] params = new NameValuePair[] {storeParam, divisionParam, upcsParam};
        return params;
    }

    public NameValuePair[] getBOHParams(String store, String division, String UPC){
        NameValuePair storeParam = new BasicNameValuePair("store", store);
        NameValuePair divisionParam = new BasicNameValuePair("division", division);
        NameValuePair upcsParam = new BasicNameValuePair("upcs", UPC);
        NameValuePair[] params = new NameValuePair[] {storeParam, divisionParam, upcsParam};
        return params;
    }

    public NameValuePair[] resetDBRAPI(String euid){
        NameValuePair euidParam = new BasicNameValuePair("euid", euid);
        NameValuePair[] params = new NameValuePair[] {euidParam};
        return params;
    }

    public String  getItemLookupBody(String[] UPCs){
        JsonObject body = new JsonObject();
        JsonArray upcList = new JsonArray();
        for(String upc : UPCs){
            upcList.add(upc);
        }
        body.add("upcs", upcList);
        body.addProperty("euid", prop.getProperty("euidForAPI"));
        body.addProperty("division", prop.getProperty("division"));
        body.addProperty("store", prop.getProperty("store"));
        return body.toString();
    }

    public String getdiscontinuedTagsParams(String[] upcs, String euid){
        JsonObject body = new JsonObject();
        JsonArray upcList = new JsonArray();
        for(String upc : upcs){
            upcList.add(upc);
        }
        body.add("upcs", upcList);
        body.addProperty("euid", euid);
        body.addProperty("division", prop.getProperty("division"));
        body.addProperty("store", prop.getProperty("store"));
        return body.toString();
    }

    public String getBackroomCount(String[] UPCs){
        JsonObject body = new JsonObject();
        JsonArray upcList = new JsonArray();
        for(String upc : UPCs){
            upcList.add(upc);
        }
        body.add("upcs", upcList);

        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = currentDate.format(currentDateFormatter);

        body.addProperty("backroomDate", formatDateTime);
        body.addProperty("division", prop.getProperty("division"));
        body.addProperty("store", prop.getProperty("store"));
        return body.toString();
    }

    public String sectionCheckScan(String UPC, String euid) {
        JsonObject body = new JsonObject();
        JsonArray upcList = new JsonArray();
        upcList.add(UPC);
        body.add("upc", upcList);
        body.addProperty("euid", euid);
        body.addProperty("division", prop.getProperty("division"));
        body.addProperty("store", prop.getProperty("store"));
        return body.toString();
    }


    public Properties getProperties(){
     return this.prop;
    }
}
