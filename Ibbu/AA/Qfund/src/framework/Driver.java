package framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Driver {

	public static String strReportPath = "\\\\aacss\\cssfiles\\QA\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFundx_Reports_Phase5";
	public static String AppEnv_QFundSF = "";
	public static String AppState_QFundSF = "";
	public static String pReportDownloadPath = "";

	static String strQFundDataSharePath = "\\\\aacss\\cssfiles\\QA\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\TestData_ForManualTeam";
	public static String configDataPath = "testDataResources\\qfund\\config";
	public static String testDataPath = "testDataResources\\qfund\\testData";
	public static String newDataName;
	static boolean outPutData = false;
	static LinkedHashMap<String, String> allProcessdataForTest = new LinkedHashMap<String, String>();
	static String app = null;
	static String sharePath = null;
	static int loginFailedCount = 1;
	String reportFile = null;

	WebDriver driver = null;
	ExtentReports extent = null;
	ExtentTest testReport = null;
	Class<?> processClass;

	Helper flObj = null;
	
	  /**
	   * This is main method used to receive input parameters and trigger the execution
	   * @param recieving 4 arguments in Array(args), Arguments can be passed from run configuration, Maven POM file and Jenkins
	   * args1-Browser Name
	   * args2-ConfigDetails
	   * args3-Rerun flag "Yes or NO"
	   * args4-Test case name or Test suite name
	   * Example:
			   	IE
				QA1_CSR_TN
				RERUN_FAILED-NO
				Test_AnotherStore_SafeAndDrawerDessign
	   */

	public static void main(String[] args) throws Throwable {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			FileUtils.copyFile(new File(configDataPath + "\\QFundOutputData.csv"),
					new File(System.getProperty("java.io.tmpdir") + "\\QFundOutputData.csv"));

			if (InetAddress.getLocalHost().getCanonicalHostName().toLowerCase().contains("aeaonline")) {
				sharePath = "\\\\cssprod1.advanceamerica.net\\";
			} else {
				sharePath = "\\\\aacss\\cssfiles\\";
			}

			if (args.length == 4) {
				new Driver().executeTest(args[0].toUpperCase(), args[1].toUpperCase(), args[2], args[3]);
			} else if (args.length < 4) {
				System.out.println("Error: Run parameters are missing");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  /**
	   * This method is used to initialize suite level extend report and execute the test suite 
	   * @param browser Browser name should be passed
	   * @param env  configuration information Eg.QA1_CSR_TN
	   * @param FailedTest Yes or No or MANUAL should be passed
	   * @param testCaseType test case name or test suite shoulbe passed
	   */

	void executeTest(String browser, String env, String FailedTest, String testCaseType) throws IOException, Throwable {

		String[] envArr = env.split("_");
		AppEnv_QFundSF = envArr[0];
		AppState_QFundSF = envArr[2];
		AppState_QFundSF = envArr[2];

		String aYYYYMMDD[] = Helper.getDateAndTimeNow().split("_");
		pReportDownloadPath = Driver.strReportPath;
		pReportDownloadPath = pReportDownloadPath + "\\FuseReports";
		// new File(pReportDownloadPath).mkdir();
		pReportDownloadPath = pReportDownloadPath + "\\" + AppState_QFundSF;
		// new File(pReportDownloadPath).mkdir();
		pReportDownloadPath = pReportDownloadPath + "\\" + AppEnv_QFundSF;
		// new File(pReportDownloadPath).mkdir();
		pReportDownloadPath = pReportDownloadPath + "\\" + aYYYYMMDD[0];
		// new File(pReportDownloadPath).mkdir();
		pReportDownloadPath = pReportDownloadPath + "\\" + aYYYYMMDD[1];
		// new File(pReportDownloadPath).mkdir();
		pReportDownloadPath = pReportDownloadPath + "\\" + aYYYYMMDD[2];
		// new File(pReportDownloadPath).mkdir();

		new File(pReportDownloadPath).mkdirs();

		// pReportDownloadPath = Driver.strReportPath + "\\FuseReports";

		String mainReport = System.getProperty("user.dir") + "\\report\\Report.html";
		strReportPath = strReportPath.replace("\\\\aacss\\cssfiles\\", sharePath) + "\\" + Helper.getSystemDate() + "\\"
				+ System.getProperty("user.name");
		reportFile = strReportPath + "\\FUSEAutomationReport_" + AppEnv_QFundSF + "_" + AppState_QFundSF + "_"
				+ Helper.getDateAndTimeNow() + ".html";

		try {
			flObj = new Helper();

			//Getting configuration information from Config.csv
			LinkedHashMap<String, String> configData = Helper
					.ReadCSV_getRowDataForMatch(configDataPath + "\\Config.csv", "CONFIG_NAME="+env,false).get(0);
			configData.put("Config_Browser", browser);
			configData.putAll(Helper
					.ReadCSV_getRowDataForMatch(configDataPath + "\\StateData.csv", "DataName="+configData.get("Config_State"),false)
					.get(0));

			//Initializing extend report 
			extent = new ExtentReports(reportFile, true);
			extent.addSystemInfo("Environment", env);
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
			System.out.println(reportFile);

			//Setting testDataSource path to sharepath location for manual team execution
			if (FailedTest.toUpperCase().contains("MANUAL")) {

				configDataPath = strQFundDataSharePath + "\\" + configDataPath;
				testDataPath = strQFundDataSharePath + "\\" + testDataPath;
				outPutData = true;
			}

			String testCase = null;

			List<LinkedHashMap<String, String>> tests;

			if (testCaseType.toUpperCase().contains("_SUITE")) {
				tests = Helper.ReadCSV_getRowDataForMatch(
						"testDataResources\\qfund\\testSuites\\" + testCaseType + ".csv", "Run=Y",true);
			} else {
				testCase = testCaseType;
				tests = Helper.ReadCSV_getRowDataForMatch(configDataPath + "\\TestCases.csv", "TestName="+testCaseType,false);
			}

			// Executing all test cases one by one from suite
			for (int i = 0; i < tests.size(); i++) {

				newDataName = "NewData" + Helper.getRandomNumeric(6);

				if (testCaseType.toUpperCase().contains("_SUITE")) {
					testCase = tests.get(i).get("TestCases");
				}

				if (ExecuteTest(testCase, configData, browser).equals("FAILED")
						&& FailedTest.toUpperCase().contains("YES")) {
					if (loginFailedCount == 1) {						
						ExecuteTest(testCase, configData, browser);
					}
					if (loginFailedCount > 5) {
						testReport.log(LogStatus.FAIL, "<----Application down test suite Ends---->");
						return;
					}
				}

				// allProcessdataForTest.clear();

			}
		} catch (Exception e) {
			e.printStackTrace();
			if (testReport == null) {
				testReport = extent.startTest("FATAL ERROR");
			}
		} finally {
			if (testReport != null && flObj != null) {
				extent.endTest(testReport);
				extent.flush();
				extent.close();
				try {
					FileUtils.copyFile(new File(reportFile), new File(mainReport), true);
					// new ProcessBuilder("C:\\Program Files\\internet explorer\\iexplore.exe",
					// mainReport).start();
				} catch (Exception e) {
				}
			}

			if (driver != null) {
				driver.quit();
			}
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			/*
			 * Report data extraction
			 */

			Document doc = Jsoup.parse(new File(reportFile), "utf-8");
			Fillo f = new Fillo();
			Connection con = null;
			String dataExtract1 = strReportPath + "\\" + env + "\\" + Helper.getDateAndTimeNow();
			// File fl = new File(dataExtract1+ "\\FUSEAutomationReport_" + env + "_" +
			// Helper.getDateAndTimeNow() + ".xlsx");
			XSSFWorkbook wb = new XSSFWorkbook();
			// String fileName =strReportPath + "\\" + env + "_" +
			// Helper.getDateAndTimeNow() + ".xlsx";
			String fileName = strReportPath + "\\FUSEAutomationReport" + env + "_" + Helper.getDateAndTimeNow()
					+ ".xlsx";
			FileOutputStream fos = new FileOutputStream(fileName);
			wb.write(fos);
			fos.close();
			try {
				con = f.getConnection(fileName);
			} catch (FilloException e) {
				e.printStackTrace();
			}

			/*
			 * Document doc = Jsoup.parse(new File(reportFile), "utf-8"); Fillo f = new
			 * Fillo(); Connection con = null; String dataExtract1 = strReportPath +
			 * "\\" + env + "\\" + Helper.getDateAndTimeNow(); // File fl = new
			 * File(dataExtract1+ "\\FUSEAutomationReport_" + env + "_" +
			 * Helper.getDateAndTimeNow() + ".xlsx"); XSSFWorkbook wb = new XSSFWorkbook();
			 * //String fileName =strReportPath +
			 * "\\" + env + "_" + Helper.getDateAndTimeNow() + ".xlsx"; String fileName
			 * =strReportPath + "\\FUSEAutomationReort" + env + "_" +
			 * Helper.getDateAndTimeNow() + ".xlsx"; FileOutputStream fos = new
			 * FileOutputStream(fileName); wb.write(fos); fos.close();
			 * 
			 * try { con = f.getConnection(fileName); } catch (FilloException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * try { Helper.writeDataToExcel(con, doc, reportFile); } catch (Throwable e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 */

		}
	}
	
	  /**
	   * This method is used to initialize test case level extend report and execute single test case 
	   * @param testCase test case name
	   * @param configData  hasMap which has configuration information
	   * @param browser browser name
	   */	

	String ExecuteTest(String testCase, LinkedHashMap<String, String> configData, String browser) {
		int loginProcessRepeat = 1;
		String testStatus = "PASS";

		try {

			driver = flObj.GetDriver(browser);

			testReport = extent.startTest(testCase);
			testReport.log(LogStatus.INFO, "<----Test Case " + testCase + " Start---->");
			System.out.println("<----Test Case " + testCase + " Start---->");
			testReport.setStartedTime(new Date());

			//Getting test flow details for the test case
			LinkedHashMap<String, String> testFlow = Helper.getTestDetails(configDataPath + "\\TestCases.csv",
					testCase);

			//Excuting process one by one
			for (String processName : testFlow.keySet()) {

				String temp[] = testFlow.get(processName).split("-->");
				String process = temp[0];
				String dataName = temp[1];

				testReport.log(LogStatus.INFO, "<----" + process + " Starts---->");
				System.out.println("<----Process " + process + " Start---->");

				//Getting class name for the process
				LinkedHashMap<String, String> packageDetails = Helper
						.ReadCSV_getRowDataForMatch(configDataPath + "\\ProcessDetails.csv", "ProcessName="+process,false).get(0);

				// Creating object for process class with the constructor calling using reflection concept 
				processClass = Class
						.forName("modules." + packageDetails.get("AppType") + "." + packageDetails.get("Modules"));
				Constructor<?> Constructor = processClass.getConstructor(WebDriver.class, LinkedHashMap.class,
						ExtentTest.class);

				LinkedHashMap<String, String> data = flObj.getData(process, dataName, configData);
				
				data.put("testName", testCase);
				data.put("processName", process);

				/*
				 * life cycle related test case where we open and close the browser multiple times within a test case workflow
				 */
				
				if (process.equals("loginApplication")) {
					if (loginProcessRepeat > 1) {
						driver.close();
						driver = flObj.GetDriver(browser);
					}
					loginProcessRepeat++;
				}

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//Calling the process method using reflection concept 
				processClass.getMethod(process).invoke(Constructor.newInstance(driver, data, testReport));

				testReport.log(LogStatus.INFO, "<----" + process + " Ends---->");

			}
		} catch (Exception e) {

			testStatus = "FAILED";
			e.printStackTrace();

			if (e instanceof NoSuchMethodException) {
				testReport.log(LogStatus.FATAL, e.toString());
			} else {
				testReport.log(LogStatus.FAIL, testReport.addScreenCapture(flObj.getscreenshot(driver, strReportPath)));
				if (e.getCause() != null) {
					testReport.log(LogStatus.FAIL, e.getCause().getClass() + ":" + e.getCause());

					if (e.getCause().toString().contains("login page not loaded")) {
						loginFailedCount++;
					}
				} else {
					testReport.log(LogStatus.FAIL, e.toString());
				}
			}
		} finally {
			testReport.setEndedTime(new Date());
			extent.endTest(testReport);
			testReport.log(LogStatus.INFO, "<----Test Case " + testCase + " End---->");
			System.out.println("<----Test Case " + testCase + " End---->");
			try {
				for (String window : driver.getWindowHandles()) {
					driver.switchTo().window(window).close();
				}
			} catch (Exception e) {
			}
		}
		return testStatus;
	}
}
