package com.krogerqa.httpclient.product_locator_app.apishelper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Omar Ortega
 * This is the class to set and get the Http entity
 */

public class ResponseEntity {
    private static HttpEntity instance = null;

    /**
     * getInstance Method, to validate if the Http entity was already created and to retrieve the Response entity
     *
     * @param response, retrieves the httpResponse
     * @return
     */
    public static HttpEntity getInstance(HttpResponse response) {
        if (instance == null) {
            instance = response.getEntity();
        }

        return instance;
    }

    /**
     * getResponseString, to get the Http entity as String
     *
     * @param entity
     * @return
     * @throws IOException
     */
    public static String getResponseString(HttpEntity entity) throws IOException {
        String responseString = EntityUtils.toString(entity);
        System.out.println("Printing Respond Body: " + responseString);
        return responseString;
    }

}
