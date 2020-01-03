package com.krogerqa.httpclient.product_locator_app.apishelper;

import com.krogerqa.httpclient.product_locator_app.endpoints.APIsEndpoints;
import org.apache.http.HttpResponse;

/**
 * @author Omar Ortega
 * This is the class to get and validate the response codes
 */
public class ResponseCodes {
    private APIsEndpoints endpoints;

    /**
     * ResponseCodes constructor, to set up the environment variable.
     *
     * @param environment
     */
    public ResponseCodes(String environment, String service) {
        endpoints = new APIsEndpoints(environment, service);
    }

    /**
     * getResponseCode Method, get the status code of the http response
     *
     * @param response
     * @return
     */
    private static int getResponseCode(HttpResponse response) {

        return response.getStatusLine().getStatusCode();
    }

    /**
     * validateResponseCode Method, validate if the response code is 200
     *
     * @param response
     * @return
     */
    public static boolean validateReponseCode(HttpResponse response) {

        return ResponseCodes.getResponseCode(response) == 200;
    }

    public static boolean validateReponseCode422(HttpResponse response) {

        return ResponseCodes.getResponseCode(response) == 422;
    }
}
