package com.krogerqa.appium.product_locator_app.common.utils;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;
import com.krogerqa.seleniumcentral.framework.main.BaseTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DbMethods {

    private Properties prop;

    public DbMethods() {
        prop = BaseUtil.readAPIUrls(BaseTest.class.getResource("/common/data/stageAPI.properties").getPath());
    }

    DBHelper dbHelper =new DBHelper();

    public void deleteWalkThroughUsers(String userId) throws SQLException {
        String query = "DELETE FROM WALKTHROUGH_USERS WHERE  EUID='"+userId+"'";
        dbHelper.executeDBStatment("brcwalkthrough", query);
    }

    public void getItemStoreInfo(String upcNo) throws SQLException {
        String query = "select SATH_INFO_VLU, SRC_ID,STORE_ITEM_ID from dbo.ITEM_STORE_INFO where STORE_ITEM_ID in \n" +
                "(SELECT STORE_ITEM_ID FROM STORE_ITEM StoreItem  where STORE_NO in ('"+prop.getProperty("store")+"') AND\n" +
                "UPC_NO IN ('"+upcNo+"'));";
        String itemStoreInfoDetails= dbHelper.executeDBStatment("kimstage", query);
        String expression = "$..SATH_INFO_VLU";
        String expression2 = "$..SRC_ID";
        String expression3 = "$..STORE_ITEM_ID";
        List<String> SATH_INFO_VLU = JsonPath.read(itemStoreInfoDetails, expression);
        List<Integer> SRC_ID = JsonPath.read(itemStoreInfoDetails, expression2);
        List<Integer> STORE_ITEM_ID = JsonPath.read(itemStoreInfoDetails, expression3);
        if(SATH_INFO_VLU.get(0).equals("R") && SRC_ID.get(0).intValue()==790){

        }else{
           updateItemStoreInfo(STORE_ITEM_ID.get(0));
        }

    }

    public void updateItemStoreInfo(int STORE_ITEM_ID) throws SQLException {
        String query = "update dbo.ITEM_STORE_INFO set SATH_INFO_VLU = 'R', SRC_ID = '790' where STORE_ITEM_ID = '"+STORE_ITEM_ID+"';";
        try {
            dbHelper.executeDBStatment("kimstage", query);
            System.out.println("Magic items Successfully updated" );
        }catch(Exception e){
            System.out.println("Magic items Successfully not updated" );
        }
    }
}
