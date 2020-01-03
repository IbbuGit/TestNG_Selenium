package com.krogerqa.httpclient.product_locator_app.endpoints;

import org.testng.Assert;

/**
 * @author Omar Ortega
 * This is the class to select the token of a specific environment
 */

public class TokenSelection {

    private static String TOKEN = null;
    private static final String STAGE_TOKEN = Global_VARS.STAGE_TOKEN;
    private static final String TEST_TOKEN = Global_VARS.TEST_TOKEN;
    private static final String PROD_TOKEN = Global_VARS.PROD_TOKEN;
    
    /**
     * getToken Method, to retrieve the Token
     *
     * @param environment
     * @return
     */
    public static String getTOKEN(String environment) {
        return selectToken(environment);
    }

    /**
     * selectToken Method, selects the token for iOS and Android (Test, Stage environments)
     *
     * @param environment
     * @return
     */
    private static String selectToken(String environment) {
        environment = environment.toUpperCase();
        switch (environment) {

            case "TEST":
                    TOKEN = TEST_TOKEN;
                    break;
            case "STAGE":
                    TOKEN = STAGE_TOKEN;
                    break;
            case "PRODUCTION":
                    TOKEN = PROD_TOKEN;
                    break;
            default:
                    //System.out.println("The selected environment was not found...");
                    Assert.fail();
                    break;
                }
        return TOKEN;
    }
}
