package com.krogerqa.httpclient.product_locator_app.apishelper;

import java.util.HashMap;

/**
 * @author Omar Ortega
 * This is the class to convert a json object to a Map.
 */
public class JsonConverter {

    /**
     * jsonToMap method, to convert a json object to a Map list, it changes the barcode and quantity to identify them with an specific name
     *
     * @param responseString
     * @return
     */
    public static HashMap<String, String> jsonToMap(String responseString) {
        String[] parts = responseString.split(",");
        HashMap<String, String> jsonHash = new HashMap<String, String>();
        String[] subparts;
         for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("\"", "");
            parts[i] = parts[i].replace("{", "");
            parts[i] = parts[i].replace("}", "");
            subparts = parts[i].split(":");
            jsonHash.put(subparts[0], subparts[0]);
            
            

        }
        return jsonHash;
    }
}
