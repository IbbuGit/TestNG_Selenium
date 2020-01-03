package com.krogerqa.httpclient.product_locator_app.endpoints;

import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.beust.jcommander.internal.Lists;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.List;

/**
 * @author Omar Ortega
 * This is the class to start and add items
 */

public class APIsEndpoints {
    
    private static String ENVIRONMENT = null;
    private String endpointServer;

    
    
    public APIsEndpoints(String environment, String service) {
        switch (service.toLowerCase()){
            case "update-boh":
                setUpdateBohAsEndPoint(environment);
                break;
            case "item-boh":
                setItemBohAsEndPoint(environment);
                break;
            default:
                    break;

        }

        this.endpointServer = Global_VARS.BOH_UPDATE;
    }

    private void setUpdateBohAsEndPoint(String environment){
        this.ENVIRONMENT = environment;
        if (ENVIRONMENT.toUpperCase().equals("TEST")) {
            this.endpointServer = Global_VARS.BOH_UPDATE;

        } else if (ENVIRONMENT.toUpperCase().equals("STAGE")) {
            this.endpointServer = Global_VARS.BOH_UPDATE_QA;

        } else if (ENVIRONMENT.toUpperCase().contains("PROD")) {
            this.endpointServer = Global_VARS.BOH_UPDATE;
        }
    }

    private void setItemBohAsEndPoint(String environment){
        this.ENVIRONMENT = environment;
        if (ENVIRONMENT.toUpperCase().equals("TEST")) {
            this.endpointServer = Global_VARS.ITEM_BOH;

        } else if (ENVIRONMENT.toUpperCase().equals("STAGE")) {
            this.endpointServer = Global_VARS.ITEM_BOH;

        } else if (ENVIRONMENT.toUpperCase().contains("PROD")) {
            this.endpointServer = Global_VARS.ITEM_BOH;
        }
    }

    public HttpResponse httpPostRequest(String body) throws IOException {
        
        
        //System.out.println("Endpoint Server : " + endpointServer);
        
        HttpClientExecutor httpClient = new HttpClientExecutor(ENVIRONMENT,endpointServer,body, headersList());
        
        return httpClient.postHttpClient(); // "OK" for succeeded calls
    }

    public HttpResponse httpGetRequest(NameValuePair[] params) throws IOException {


        //System.out.println("Endpoint Server : " + endpointServer);

        HttpClientExecutor httpClient = new HttpClientExecutor(ENVIRONMENT,endpointServer,params, headersList());

        return httpClient.postHttpClient(); // "OK" for succeeded calls
    }

    private List headersList(){
        List<Header> headersList = Lists.newArrayList();
        headersList.add(new BasicHeader(HttpHeaders.AUTHORIZATION, TokenSelection.getTOKEN(ENVIRONMENT)));
        headersList.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json" ));
        headersList.add(new BasicHeader("X-Correlation-Id", "12334" ));
        headersList.add(new BasicHeader(HttpHeaders.CACHE_CONTROL, "no-cache" ));
        headersList.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));
        headersList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate"));
        headersList.add(new BasicHeader(HttpHeaders.ACCEPT, "*/*"));
    
        return headersList;
    }

   

}
