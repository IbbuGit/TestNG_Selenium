package com.krogerqa.appium.product_locator_app.common.utils;

import com.jayway.jsonpath.JsonPath;
import com.krogerqa.informixdao.InformixDao;
import com.krogerqa.seleniumcentral.framework.main.BaseTest;
import org.testng.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static com.krogerqa.sqldao.SqlDao.getSqlConnection;
import static com.krogerqa.sqldao.utils.SqlResultSetConverter.convertSqlResultSetToJson;

public class DBHelper {

    private Properties prop;

    public DBHelper(){
        prop = BaseUtil.readAPIUrls(BaseTest.class.getResource("/common/data/stageAPI.properties").getPath());
    }

    public <T> T executeDBStatment(String applicationName, String query) throws SQLException{
        Connection conn = null;
        String spsDBName = "", spsUserId = "", spsPassword = "";
        String methodName = "";

        switch (applicationName.toLowerCase()){
            case "mdc":
                spsDBName = prop.getProperty("spsMDCDBName");
                spsUserId = prop.getProperty("spsMDCUserId");
                spsPassword = prop.getProperty("spsMDCPassword");
                break;
            case "etransfer":
                spsDBName = prop.getProperty("spsETransferDBName");
                spsUserId = prop.getProperty("spsETransferUserId");
                spsPassword = prop.getProperty("spsETransferPassword");
                break;
            case "topstock" :
                spsDBName = prop.getProperty("spsTopstockDBName");
                spsUserId = prop.getProperty("spsTopstockUserId");
                spsPassword = prop.getProperty("spsTopstockPassword");
                break;
            case "ilu" :
                spsDBName = prop.getProperty("spsILUDBName");
                spsUserId = prop.getProperty("spsILUUserId");
                spsPassword = prop.getProperty("spsILUDBPassword");
                break;
            case "dsd":
                spsDBName = prop.getProperty("spsDSDDBName");
                spsUserId = prop.getProperty("spsDSDUserId");
                spsPassword = prop.getProperty("spsDSDPassword");
                break;
            case "rfi":
                spsDBName = prop.getProperty("spsRFIDBName");
                spsUserId = prop.getProperty("spsRFIUserId");
                spsPassword = prop.getProperty("spsRFIPassword");
                break;
            case "brc":
                spsDBName = prop.getProperty("spsBRDBName");
                spsUserId = prop.getProperty("spsBRUserId");
                spsPassword = prop.getProperty("spsBRPassword");
                break;
            case "oto":
                spsDBName = prop.getProperty("spsOneTimeDBName");
                spsUserId = prop.getProperty("spsOneTimeUserId");
                spsPassword = prop.getProperty("spsOneTimePassword");
                break;
            case "dbr":
                spsDBName = prop.getProperty("spsDBRDBName");
                spsUserId = prop.getProperty("spsDBRUserId");
                spsPassword = prop.getProperty("spsDBRPassword");
                break;
            case "brcwalkthrough":
                spsDBName = prop.getProperty("spsDBBRCWTName");
                spsUserId = prop.getProperty("spsDBBRCWTUserId");
                spsPassword = prop.getProperty("spsDBBRCWTPassword");
                break;
            case "kimstage":
                spsDBName = prop.getProperty("spsDBKimName");
                spsUserId = prop.getProperty("spsDBKimUserId");
                spsPassword = prop.getProperty("spsDBKimPassword");
                break;
            default:
                spsDBName = prop.getProperty("spsMDCDBName");
                spsUserId = prop.getProperty("spsMDCUserId");
                spsPassword = prop.getProperty("spsMDCPassword");
                break;
        }

        if(query.toLowerCase().startsWith("insert")){
            methodName = "insertRows";
        }else if(query.toLowerCase().startsWith("select")){
            methodName = "executeQuery";
        }else if(query.toLowerCase().startsWith("delete") || query.toLowerCase().startsWith("update")){
            methodName = "updateOrDeleteRows";
        }

        String dbDriver = prop.getProperty("sqlServerDriver");
        String url = prop.getProperty("spsDBServer") + ":"
                + prop.getProperty("spsDBPort") + ";databaseName="
                + spsDBName;
        Object dbResultJSON = "";
        try {
            Class<?> classToUse = Class.forName("com.krogerqa.sqldao.SqlDao");
            conn = getSqlConnection(dbDriver, url, spsUserId, EncryptDecryptUtil.decrypt(spsPassword));
            Class[] parameterTypes = new Class[] {Connection.class, String.class};
            Object[] paramsToPass = new Object[]{conn, query};
            Method methodToCall = classToUse.getDeclaredMethod(methodName, parameterTypes);
            Object returnedVal = methodToCall.invoke(classToUse, paramsToPass);
            ResultSet resultSet;
            Integer noOfRecordsImpacted = 0;

            if(returnedVal.getClass().toString().endsWith("ResultSet")){
                resultSet = (ResultSet) returnedVal;
                dbResultJSON = convertSqlResultSetToJson(resultSet);
            }else{
                dbResultJSON = ((Integer) returnedVal).toString();
            }
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }
        return (T) dbResultJSON;
    }

    public <T> T executeInformixDBStatement(String statementToExecute) throws SQLException{

        if(!(statementToExecute.toLowerCase().startsWith("update ") || statementToExecute.toLowerCase().startsWith("delete ")
                || statementToExecute.toLowerCase().startsWith("insert ") || statementToExecute.toLowerCase().startsWith("select "))){
            Assert.assertTrue(false, "Your query should start with one of these values - select, insert, update or delete");
        }
        Connection conn = null;
        String caoUserName = prop.getProperty("caoDBUserName");
        String caoPassword = prop.getProperty("caoDBPassword");
        String dbDriver = prop.getProperty("informixServerDriver");
        String url = prop.getProperty("caoDBServer") + ":"
                + prop.getProperty("caoDBPort") + "/" + prop.getProperty("caoDBName");
        Object returnVal = "";
        try {
            conn = getSqlConnection(dbDriver, url, caoUserName, EncryptDecryptUtil.decrypt(caoPassword));
            InformixDao informixDao = new InformixDao();
            if(statementToExecute.toLowerCase().startsWith("select ")) {
                ResultSet rs = informixDao.executeQuery(conn, statementToExecute);
                returnVal = convertSqlResultSetToJson(rs);
            }else if(statementToExecute.toLowerCase().startsWith("insert ")){
                returnVal = informixDao.insertRows(conn, statementToExecute);
            }else if(statementToExecute.toLowerCase().startsWith("update ") || statementToExecute.toLowerCase().startsWith("delete ")) {
                returnVal = informixDao.updateOrDeleteRows(conn, statementToExecute);
            }
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }

        return (T) returnVal;
    }

    public int updateHccCd(String upcToUpdate, String hccCd){
        return updateCaoStoitColumn(upcToUpdate, "hcc_cd", hccCd);
    }

    public int updatePseudoephedrine(String upcToUpdate){
        int returnCode = 0;
        String queryToFetchSubComCd = "select sub_com_cd from caostoit where con_upc_no = '" + upcToUpdate + "'";
        String queryToFetchPseudoephedrine = "select ctl_var_vlu_tx from caosavar where ctl_var_nam_tx = 'PSEUDOEPHEDRINE'";
        String subComCd;
        String existingCtlVarValue = "";
        String updateStatement;
        try {

            //Fetch the base UPC
            String queryResultInJson = executeInformixDBStatement(queryToFetchSubComCd);
            String expression = "$..sub_com_cd";
            subComCd = ((List<String>) JsonPath.read(queryResultInJson, expression)).get(0);

            queryResultInJson = executeInformixDBStatement(queryToFetchPseudoephedrine);
            expression = "$..ctl_var_vlu_tx";
            existingCtlVarValue = ((List<String>) JsonPath.read(queryResultInJson, expression)).get(0).trim();

            //Update the flag
            if(!existingCtlVarValue.contains(subComCd)){
                updateStatement = "update caosavar set ctl_var_vlu_tx = '" + existingCtlVarValue + "," + subComCd + "' where ctl_var_nam_tx = 'PSEUDOEPHEDRINE'";
                returnCode = executeInformixDBStatement(updateStatement);
            } else {
                returnCode = 1;
            }
        }catch(SQLException sqlException){

        }
        return  returnCode;
    }

    public int updateDivComCd(String upcToUpdate){
        return updateCaoStoitColumn(upcToUpdate, "div_com_cd", "170");
    }

    public int updateCaoStoitColumn(String upcToUpdate, String columnName, String newValue){
        int returnCode = 0;
        String queryToFetchBaseUpc = "select bas_con_upc_no, " + columnName + " from caostoit where " +
                "con_upc_no in (select distinct bas_con_upc_no from informix.caostoit where con_upc_no = '" +
                upcToUpdate + "') and con_typ_cd = 'B'";
        String baseUpc;
        String currentColumnValue;
        String updateStatement;
        try {

            //Fetch the base UPC
            String queryResultInJson = executeInformixDBStatement(queryToFetchBaseUpc);
            String expression = "$..bas_con_upc_no";
            baseUpc = ((List<String>) JsonPath.read(queryResultInJson, expression)).get(0);
            expression = "$.."+columnName;
            currentColumnValue = ((List<String>) JsonPath.read(queryResultInJson, expression)).get(0);
            currentColumnValue = (currentColumnValue==null)?"":currentColumnValue.trim();
            //Update the flag
            if(!newValue.equalsIgnoreCase(currentColumnValue)){
                updateStatement = "update caostoit set " + columnName + " = '" + newValue +
                        "' where con_upc_no = " + baseUpc + " and con_typ_cd = 'B'";
                returnCode = executeInformixDBStatement(updateStatement);
            } else {
                returnCode = 1;
            }
        }catch(SQLException sqlException){

        }
        return  returnCode;
    }

    public int insert2ndChance(String upcToUpdate){
        int returnCode = 0;
        String queryToFetchSubComCd = "select sub_com_cd from caostoit where con_upc_no = '" + upcToUpdate + "'";
        String queryToFetch2ndChance = "select tbl_nam_id from teccodes where key_vlu_cd = 'SUBCOMCD' and tbl_nam_id = '2ndC'";
        String subComCd;
        String insertStatement;
        try {

            //Fetch the base UPC
            String queryResultInJson = executeInformixDBStatement(queryToFetchSubComCd);
            String expression = "$..sub_com_cd";
            Assert.assertTrue(((List<String>) JsonPath.read(queryResultInJson, expression)).size() > 0, "No Record found in CAO for the UPC " + upcToUpdate);

            subComCd = ((List<String>) JsonPath.read(queryResultInJson, expression)).get(0);

            queryToFetch2ndChance = queryToFetch2ndChance.replace("SUBCOMCD", subComCd);
            queryResultInJson = executeInformixDBStatement(queryToFetch2ndChance);
            expression = "$..tbl_nam_id";
            if (((List<String>) JsonPath.read(queryResultInJson, expression)).size()==0){
                insertStatement = "insert into teccodes values('2ndC','" + subComCd +  "','2nd chance subcommodity')";
                returnCode = executeInformixDBStatement(insertStatement);
            }else {
                returnCode = 1;
            }
        }catch(SQLException sqlException){

        }
        return  returnCode;
    }
}
