package com.krogerqa.appium.product_locator_app.common.utils;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonPathValueExtractor {

    /**
     * Returns BOH value for given bucket
     *
     * @param json   Response string from GetBOH API
     * @param bucket QOD/QIB/QIK/QOR
     * @return
     */
    public static int extractBOHBucketValue(String json, String bucket) {
        String expression = null;
        switch (bucket.toUpperCase()) {
            case "QOD":
                expression = "$..[?(@.location=='STO_QOD')].boh";
                break;
            case "QIB":
                expression = "$..[?(@.location=='STO_QIB')].boh";
                break;
            case "QIK":
                expression = "$..[?(@.location=='STO_QIK')].boh";
                break;
            case "QOR":
                expression = "$..[?(@.location=='STO_QOR')].boh";
                break;
            default:
                break;
        }
        List<Double> extractedJson = JsonPath.read(json, expression);
        if (extractedJson.isEmpty()){
            return 0;
        }else{
            return extractedJson.get(0).intValue();
        }
    }

    public static String extractShelfAllocation(String json){
        List<Integer> extractedJson = JsonPath.read(json, "$..storeInfo.allocations");
        return extractedJson.get(0).toString();
    }

    public static int extractNoOfLocations(String json){
        List<Integer> extractedJson = JsonPath.read(json, "$..locationDetails.locations.length()");
        return extractedJson.get(0).intValue();
    }

    public static String extractValue(String json, String expression) {
        List<String> extractedJson = JsonPath.read(json, expression);
        if (extractedJson.isEmpty()){
            return "0";
        }else{
            Object tmpVal = extractedJson.get(0);
            if(!tmpVal.toString().contains("String")){
                return tmpVal.toString();
            }
            return extractedJson.get(0);
        }
    }

    public static int l1L2Value(String json){
        List<Integer> extractedJson = JsonPath.read(json,"$..l1L2Details.l1L2");
        return extractedJson.get(0);
    }
}
