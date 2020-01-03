package com.krogerqa.appium.product_locator_app.common.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.krogerqa.appium.product_locator_app.common.ui.pages.*;
import com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.dataBeans.Fresh_Assisted_Ordering_TestDataBean;
import com.krogerqa.appium.product_locator_app.markdowns.dataBeans.Markdowns_TestDataBean;
import com.krogerqa.appium.product_locator_app.backroom_count.dataBeans.Backroom_Count_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.dataBeans.Login_TestDataBean;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.core_component.dataBeans.Core_Component_TestDataBean;
import com.krogerqa.appium.product_locator_app.directed_replenishment.dataBeans.Directed_Replenishment_TestDataBean;
import com.krogerqa.appium.product_locator_app.eTransfer.dataBeans.Etransfer_TestDataBean;
import com.krogerqa.appium.product_locator_app.my_daily_count.dataBeans.My_Daily_Count_TestDataBean;
import com.krogerqa.appium.product_locator_app.one_time_order.dataBeans.One_Time_Order_TestDataBean;
import com.krogerqa.appium.product_locator_app.remove_from_inventory.dataBeans.Remove_From_Inventory_TestDataBean;
import com.krogerqa.appium.product_locator_app.section_check.dataBeans.Section_Check_TestDataBean;
import com.krogerqa.appium.product_locator_app.top_stock.dataBeans.Top_Stock_TestDataBean;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import com.krogerqa.httpclient.product_locator_app.apishelper.JSONDataProvider;
import com.krogerqa.seleniumcentral.framework.main.BaseTest;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.*;

public class Base extends BaseTest {

    private Logger log = LoggerFactory.getLogger(Base.class);
    private File dataFile;
    private JSONObject jsonDataObject =null;
    protected JSONObject jsonCredentials = null;

    private static Map<String, List<Map<String, String>>> testDataMaps = new HashMap<>();


    final String backroom_count = "backroom_count";
    final String core_component = "core_component";
    final String directed_replenishment = "directed_replenishment";
    final String eTransfer = "eTransfer";
    final String my_daily_count = "my_daily_count";
    final String one_time_order = "one_time_order";
    final String section_check = "section_check";
    final String top_stock = "top_stock";
    final String remove_from_inventory = "remove_from_inventory";
    final String markdowns = "markdowns";
    final String fresh_assisted_ordering = "fresh_assisted_ordering";

    protected Login_TestDataBean login_Data;
    protected Backroom_Count_TestDataBean bc_Data;
    protected Core_Component_TestDataBean cc_Data;
    protected Directed_Replenishment_TestDataBean dr_Data;
    protected Etransfer_TestDataBean et_Data;
    protected My_Daily_Count_TestDataBean mdc_Data;
    protected One_Time_Order_TestDataBean oto_Data;
    protected Section_Check_TestDataBean sc_Data;
    protected Top_Stock_TestDataBean ts_Data;
    protected Remove_From_Inventory_TestDataBean rfi_Data;
    protected Markdowns_TestDataBean md_Data;
    protected Fresh_Assisted_Ordering_TestDataBean fao_Data;

    protected MobileCommands mobileCommands = new MobileCommands();
    protected Properties prop;
    protected HttpClientExecutor apiExecutor;


    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext testContext) {
        String moduleName = getModuleName(this.getClass());
        String xmlDataProviderPath = testContext.getCurrentXmlTest().getParameter("dataProviderPath");
        if (!testDataMaps.containsKey(moduleName)) {
            String testType = System.getenv("TESTTYPE");
            if (testType == null) {
                testType = "";
            }
            String fileNameToRead = "/" + moduleName + "/data/" + moduleName + (testType.isEmpty() ? "" : "_" + testType) + "_TestData.csv";
            boolean isDataFound = false;
            List<String> errors = new ArrayList<>();
            try {
                testDataMaps.put(moduleName, BaseUtil.readCSV(BaseTest.class.getResource(fileNameToRead).getPath()));
                log.info("Test Data CSV File read completed successfully from path :" + fileNameToRead);
                isDataFound=true;
            } catch (IOException e) {
                isDataFound = false;
                log.warn(e.toString());
                errors.add(e.toString());

            }catch (NullPointerException e){
               isDataFound =false;
                log.warn("Test data csv File Not Found");
                errors.add(e.toString()+" : test data csv File Not Found ");
            }

            try{
                dataFile = new File(ClassLoader.getSystemClassLoader().getResource(xmlDataProviderPath).getFile());
                log.info("Fetching JSON test data from : " + dataFile.getAbsolutePath());
                String DATA_FILE_MOBILE ;
                if (dataFile.exists()) {
                    DATA_FILE_MOBILE = dataFile.getAbsolutePath();
                } else
                    throw new NullPointerException("File not found at the path provided in TestNG XML");
                JSONDataProvider.dataFile = DATA_FILE_MOBILE;

                try {
                    jsonDataObject = JSONDataProvider.extractData_JSON(DATA_FILE_MOBILE);

                } catch (ParseException e) {
                    log.error("{}|{}", "JSON Parser could not find the the Login Credentials", e.toString());
                    e.printStackTrace();
                } catch (IOException e) {
                    log.error("{}|{}", "JSON Parser could not find the file at location : " + DATA_FILE_MOBILE, e.toString());
                    e.printStackTrace();
                }
                jsonCredentials = (JSONObject) jsonDataObject.get("app_loginCredentials");
                log.info("JSON Data read completed successfully");

                isDataFound=true;
            }
            catch (NullPointerException e){
                if(isDataFound ==false) {
                    log.warn("Test data json File Not Found");
                    errors.add(e.toString() + " : test data json File Not Found ");
                }
            }

            if(isDataFound == false){
                throw new NullPointerException(errors.toString());
            }

            if (!testDataMaps.containsKey("login") && jsonCredentials==null) {
                try {
                    testDataMaps.put("login", BaseUtil.readCSV(BaseTest.class.getResource("/common/data/login_TestData.csv").getPath()));
                    log.info("Login Data CSV File read completed successfully");
                } catch (IOException e) {
                    log.error(e.toString());
                    e.printStackTrace();
                }
            }

        }
    }

    @BeforeMethod(alwaysRun = true)
    public void initDataAndLoginApp(Method test, Object[] testArgs) throws Throwable {
            if (androidApkPath.contains("qa")) {
                prop = BaseUtil.readAPIUrls(BaseTest.class.getResource("/common/data/stageAPI.properties").getPath());
            } else {
                prop = BaseUtil.readAPIUrls(BaseTest.class.getResource("/common/data/stageAPI.properties").getPath());
            }
        String moduleName = getModuleName(this.getClass());
        Map<String, String> testDataMap = null;

        if ((testArgs.length == 0) && (testDataMaps.get(moduleName) != null)) {
            testDataMap = testDataMaps.get(moduleName).stream().filter(oMap -> test.getName().equals(oMap.get("testName")))
                                  .findAny()
                                  .orElse(null);

        }
        if (testDataMap != null) {
            login_Data = getLogin_Data(testDataMap.get("login_Data"));
            new LogInPage().login(login_Data.getUsername(), login_Data.getPassword());
        }
        else if (jsonCredentials != null) {
            new LogInPage().login(jsonCredentials.get("username").toString(), jsonCredentials.get("encryptedPassword").toString());
        }
        else {
            log.error("Test Data source could not be identified");
            throw new NullPointerException("Test Data source could not be identified");
        }
        TaskListPage taskListPage = new TaskListPage();
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());

        // taskListPage.validateMainMenuPageTitle();


        switch (moduleName) {
            case backroom_count:
                bc_Data = new ObjectMapper().convertValue(testDataMap, Backroom_Count_TestDataBean.class);
                taskListPage.clickBackroomCount();
                break;
            case core_component:
                cc_Data = new ObjectMapper().convertValue(testDataMap, Core_Component_TestDataBean.class);
                break;
            case directed_replenishment:
                dr_Data = new ObjectMapper().convertValue(testDataMap, Directed_Replenishment_TestDataBean.class);
                taskListPage.clickDirectedReplenishment();
                break;
            case eTransfer:
                et_Data = new ObjectMapper().convertValue(testDataMap, Etransfer_TestDataBean.class);
                taskListPage.clickETransfer();
                break;
            case my_daily_count:
                mdc_Data = new ObjectMapper().convertValue(testDataMap, My_Daily_Count_TestDataBean.class);
                taskListPage.clickMyDailyCount();
                break;
            case one_time_order:
                oto_Data = new ObjectMapper().convertValue(testDataMap, One_Time_Order_TestDataBean.class);
                taskListPage.clickOneTimeOrder();
                break;
            case section_check:
                sc_Data = new ObjectMapper().convertValue(testDataMap, Section_Check_TestDataBean.class);
                taskListPage.clickSectionCheck();
                break;
            case top_stock:
                ts_Data = new ObjectMapper().convertValue(testDataMap, Top_Stock_TestDataBean.class);
                apiExecutor.getHttpClient(prop.getProperty("resetTopStockDataForUser"),new NameValuePair[] {new BasicNameValuePair("euid",login_Data.getUsername())});
                taskListPage.clickTopStock();
                break;
            case remove_from_inventory:
                rfi_Data = new ObjectMapper().convertValue(testDataMap, Remove_From_Inventory_TestDataBean.class);
                taskListPage.clickRemoveFromInventory();
                break;
            case markdowns:
                md_Data = new ObjectMapper().convertValue(testDataMap, Markdowns_TestDataBean.class);
                taskListPage.clickMarkdowns();
                break;
            case fresh_assisted_ordering:
                fao_Data = getDataFromJson(Fresh_Assisted_Ordering_TestDataBean.class);
                taskListPage.validateTaskListScreen();
                taskListPage.tapOnFreshAssistedOrdering();
                break;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void logOutApp(Method test) {
        logOutApp();
    }


    public void logOutApp() {
        new LogOutPage().loggedOut(false);
    }


    public Login_TestDataBean getLogin_Data(String testName) {
        Map<String, String> loginDataMap = testDataMaps.get("login").stream().filter(oMap -> testName.equals(oMap.get("testName")))
                                                   .findAny()
                                                   .orElse(null);
        return new ObjectMapper().convertValue(loginDataMap, Login_TestDataBean.class);

    }

    @DataProvider(name = "getData")
    public Object[][] dataSupplier(Method test) throws IOException {
        String moduleName = getModuleName(this.getClass());
        return BaseUtil.dataSupplier(testDataMaps.get(moduleName), test.getName());
    }

    String getModuleName(Class obj) {
        return ((obj.getPackage().getName().split("com.krogerqa.appium.product_locator_app."))[1]).split(".cases")[0];
    }

    public void scroll(String scrollDirection, int rounds) {
        for (int i = 0; i < rounds; i++) {
            scroll(scrollDirection);
        }
    }

    public void scroll(String scrollDirection) {
        Double screenPerecentage = scrollDirection.trim().equalsIgnoreCase("UP") ? 0.8D : 0.2D;
        try {
            mobileCommands = new MobileCommands();
            Dimension dimensions = mobileCommands.getWebDriver().manage().window().getSize();
            Double screenHeightStart = (double) dimensions.getHeight() * 0.5D;
            int scrollStart = screenHeightStart.intValue();
            double anchor = dimensions.width * 0.5;
            Double screenHeightEnd = (double) dimensions.getHeight() * screenPerecentage;
            int scrollEnd = screenHeightEnd.intValue();
            TouchAction action = new TouchAction((PerformsTouchActions) mobileCommands.getWebDriver());
            action.press(PointOption.point((int) anchor, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300L))).moveTo(PointOption.point((int) anchor, scrollEnd)).release().perform();
        } catch (Exception var8) {

            throw var8;
        }
    }

    private <T>T  getDataFromJson(Class<T> databean) {

        return new Gson().fromJson(String.valueOf(jsonDataObject.get("element_text")),(Type)databean);
    }
}


