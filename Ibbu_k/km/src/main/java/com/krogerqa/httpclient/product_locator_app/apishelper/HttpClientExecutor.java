package com.krogerqa.httpclient.product_locator_app.apishelper;

import com.beust.jcommander.internal.Lists;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;


/**
 * @author Omar Ortega
 * This is the class to build and set up the HttpClient Executer
 */

public class HttpClientExecutor {
    private String environment;
    private String endpointServer;
    private String body;
    private HttpClient httpclient;
    private List<Header> headersList ;
    private NameValuePair[] params;
    String AUTHORIZATION = null;
    String correlationId = null;

    public HttpClientExecutor(String environment, String endpointServer, String body, List header){
        this.environment = environment;
        this.endpointServer = endpointServer;
        this.body = body;
        this.headersList = header;
    }

    public HttpClientExecutor(String environment, String endpointServer, NameValuePair[] params, List header){
        this.environment = environment;
        this.endpointServer = endpointServer;
        this.headersList = header;
        this.params = params;
    }

    public HttpClientExecutor(String userName, String password){
        String auth = null;
        try {
            auth = userName + ":" + EncryptDecryptUtil.decrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AUTHORIZATION = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
        correlationId = UUID.randomUUID().toString();
        this.headersList = headersList();
    }

    public HttpResponse postHttpClient() throws IOException {
        
        setExecutor();
        HttpPost postRequest = new HttpPost(endpointServer);
         StringEntity entity = new StringEntity(body);
        postRequest.setEntity(entity);
       
        HttpResponse response;
        response = httpclient.execute(postRequest);
        //System.out.println("API RESPONSE: " + response);
        return response;
    }

    public String postHttpClient(String URI, String body) throws IOException {
        setExecutor();
        HttpPost postRequest = new HttpPost(URI);

        StringEntity entity = new StringEntity(body);
        postRequest.setEntity(entity);

        HttpResponse response = httpclient.execute(postRequest);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, "UTF-8");
        return responseString;
    }
    
    public HttpResponse putHttpClient() throws IOException {
        
        setExecutor();
        HttpPut postRequest = new HttpPut(endpointServer);
        StringEntity entity = new StringEntity(body);
        postRequest.setEntity(entity);
        
        HttpResponse response;
        response = httpclient.execute(postRequest);
        //System.out.println("API RESPONSE: " + response);
        return response;
    }


    public HttpResponse getHttpClient() throws IOException, URISyntaxException {

        setExecutor();
        URIBuilder builder = new URIBuilder(endpointServer);
        builder.addParameters(Arrays.asList(this.params));

        HttpGet getRequest = new HttpGet(builder.build());

        HttpResponse response;
        response = httpclient.execute(getRequest);
       //System.out.println("API RESPONSE: " + response);
        return response;
    }

    public String getHttpClient(String URI, NameValuePair[] params) throws IOException, URISyntaxException {
        setExecutor();
        URIBuilder builder = new URIBuilder(URI);
        builder.addParameters(Arrays.asList(params));

        HttpGet getRequest = new HttpGet(builder.build());

        HttpResponse response = httpclient.execute(getRequest);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return responseString;
    }

    private void setExecutor(){
         SSLContext sslContext = null;
        try {
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (KeyManagementException e) {
            e.printStackTrace();
        }
        catch (KeyStoreException e) {
            e.printStackTrace();
        }
         this.httpclient =
                HttpClients.custom().setDefaultHeaders(headersList).setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
    }

    private List headersList(){
        List<Header> headersList = Lists.newArrayList();
        headersList.add(new BasicHeader(HttpHeaders.AUTHORIZATION, AUTHORIZATION));
        headersList.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json" ));
        headersList.add(new BasicHeader("X-Correlation-Id", correlationId ));
        headersList.add(new BasicHeader(HttpHeaders.CACHE_CONTROL, "no-cache" ));
        headersList.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));
        headersList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate"));
        headersList.add(new BasicHeader(HttpHeaders.ACCEPT, "*/*"));
        return headersList;
    }

}

