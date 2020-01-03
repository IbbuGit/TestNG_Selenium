package com.krogerqa.appium.product_locator_app.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * Rest API Utilities class
 */
public class RestAPIUtil {
    String AUTHORIZATION = null;
    String correlationId = null;
    HttpClient client = null;

    /**
     * Constructor takes username and password for authentication
     *
     * @param username UserName
     * @param password Password
     */
    public RestAPIUtil(String username, String password) {
        String auth = username + ":" + password;
        AUTHORIZATION = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
        correlationId = UUID.randomUUID().toString();
    }

    /**
     * Returns the response for GET request
     *
     * @param URI HTTP GET call URI
     * @return Response as string
     * @throws IOException
     */
    public String get(String URI) throws IOException {

        HttpGet getRequest = new HttpGet(URI);
        getRequest.addHeader("accept", "application/json");
        getRequest.addHeader("X-Correlation-ID", correlationId);
        getRequest.addHeader(HttpHeaders.AUTHORIZATION, AUTHORIZATION);

        buildHttpClient();
        HttpResponse response = client.execute(getRequest);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return responseString;
    }

    /**
     * Returns response for POST request
     *
     * @param URI  HTTP POST call URI
     * @param body Request body
     * @return Response as string
     * @throws IOException
     */
    public String post(String URI, String body) throws IOException {
        HttpPost postRequest = new HttpPost(URI);
        postRequest.addHeader("accept", "application/json");
        postRequest.addHeader("X-Correlation-ID", correlationId);
        postRequest.addHeader(HttpHeaders.AUTHORIZATION, AUTHORIZATION);

        StringEntity entity = new StringEntity(body);
        postRequest.setEntity(entity);

        buildHttpClient();
        HttpResponse response = client.execute(postRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");
        return responseString;
    }

    /**
     * Builds custom httpclient
     */
    private void buildHttpClient() {
        try {
            client = HttpClients
                    .custom()
                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
