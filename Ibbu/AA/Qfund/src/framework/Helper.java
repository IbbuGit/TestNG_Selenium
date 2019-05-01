package framework;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codoid.products.fillo.Connection;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.QFund.QfundAdmin_Navigation;
import pageClasses.QFund.Qfund_Navigation;

public class Helper {

	protected LinkedHashMap<String, String> allProcessData;
	protected WebDriver driver;
	protected ExtentTest report;
	protected String testName;
	protected String processName;

	public Helper() {}

	protected Helper(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		driver = _driver;
		report = _report;
		allProcessData = data;
		testName = data.get("testName");
		processName = data.get("processName");
		new Qfund_Navigation(driver, report);
		new QfundAdmin_Navigation(driver, report);
	}

	public void ulterDataAndProcess(LinkedHashMap<String, String> data, String process) {
		report.log(LogStatus.INFO, "<---- " + process + "---->");
		System.out.println("<---- " + process + "---->");

		data.put("processName", process);
		allProcessData = data;
		processName = process;
	}
	
	  /**
	   * This method is used to simplify Map get function  
	   * @param key It is column name you are declaring in data csv files
	   */

	public String data(String key) throws Exception {

		String Val = null;

		if (key.contains("Config_") || key.contains("StateData_")) {
			Val = allProcessData.get(key);
		} else {
			if (!allProcessData.containsKey(processName + "." + key.toString())) {
				report.log(LogStatus.FAIL, "Column[" + key + "] not found in the data sheet[" + processName + "]");
				throw new Exception("Column[" + key + "] not found in the data sheet[" + processName + "]");
			} else {
				Val = allProcessData.get(processName + "." + key.toString());
			}
		}

		return Val;
	}
	
	  /**
	   * This method is used to verify expected and actual results for test verification
	   * @param msg Message which should appear in the result file
	   * @param report  It is extent report object should be passed from the process
	   * @param oActual Mostly It is taken from the application will be passed to this function
	   * @param oExpected Expected data we provide from the csv file for test verification
	   * @throws If actual and expected are not matching it will return exception, script execution will stop
	   */

	public void assertAreEqual(String msg, ExtentTest report, Object oActual, Object oExpected) throws Exception {
		if (oExpected != null && oActual != null) {
			if (!oExpected.toString().isEmpty() && !oActual.toString().isEmpty()) {
				if (oExpected.equals(oActual)) {
					report.log(LogStatus.PASS, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					report.log(LogStatus.PASS, report.addScreenCapture(getscreenshot(driver, Driver.strReportPath)));
					System.out.println(LogStatus.PASS + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				} else {
					report.log(LogStatus.FAIL, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					System.out.println(LogStatus.FAIL + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
					throw new Exception(
							msg + "Expected[" + oExpected.toString() + "] " + "Actual[" + oActual.toString() + "]");
				}
			}
		}
	}
	
	  /**
	   * This method is used to verify expected and actual results for test verification
	   * @param msg Message which should appear in the result file
	   * @param report  It is extent report object should be passed from the process
	   * @param oActual Mostly It is taken from the application will be passed to this function
	   * @param oExpected Expected data we provide from the csv file for test verification
	   * @throws If actual and expected are not matching it wont return exception, script execution will continue
	   */

	public void verifyAreEqual(String msg, ExtentTest report, Object oActual, Object oExpected) throws Exception {
		if (oExpected != null && oActual != null) {
			if (!oExpected.toString().isEmpty() && !oActual.toString().isEmpty()) {
				if (oExpected.equals(oActual)) {
					report.log(LogStatus.PASS, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					report.log(LogStatus.PASS, report.addScreenCapture(getscreenshot(driver, Driver.strReportPath)));
					System.out.println(LogStatus.PASS + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				} else {
					report.log(LogStatus.FAIL, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					report.log(LogStatus.FAIL, report.addScreenCapture(getscreenshot(driver, Driver.strReportPath)));
					System.out.println(LogStatus.FAIL + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				}
			}
		}
	}
	
	  /**
	   * This method is used for Initializing Webdriver object to corresponding browser driver
	   * @param browser Browser name passed from the run configuration, Maven pom.xml and jenkins
	   * @return Webdriver Corresponding browser webdriver will be instantiated to the Webdriver interface and which will be returned		
	   */

	public WebDriver GetDriver(String browser) throws Exception {

		WebDriver driver = null;
		try {
			switch (browser) {

			case "Firefox":

				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions fireFoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile());
				// fireFoxOptions.setBinary(configData.get("FirefoxBinary"));
				driver = new FirefoxDriver(fireFoxOptions);

				break;

			case "CHROME":

				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				// chromeOptions.setCapability("chrome.binary",
				// configData.get("ChromeBinary").toString());
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("disable-extensions");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);

				driver = new ChromeDriver(chromeOptions);

				break;

			case "IE":

				WebDriverManager.iedriver().setup();

				InternetExplorerOptions IEoptions = new InternetExplorerOptions();

				IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				// System.setProperty("webdriver.ie.driver",
				// System.getProperty("java.io.tmpdir")+"\\"+browser+Driver.IE_Driver_Version+".exe");

				// IEoptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true);
				// if(Jenkins)
				// {IEoptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);}
				// IEoptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
				IEoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				// IEoptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);

				
				IEoptions.setCapability("browser.download.folderList", 2);
				IEoptions.setCapability("browser.download.manager.showWhenStarting", false);
				IEoptions.setCapability("browser.download.dir", "\\\\Aacss\\cssfiles\\QA\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFundx_Reports_Phase5\\FuseReports");
				IEoptions.setCapability("browser.helperApps.neverAsk.openFile",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				IEoptions.setCapability("browser.helperApps.neverAsk.saveToDisk",
		"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				IEoptions.setCapability("browser.helperApps.alwaysAsk.force", false);
				IEoptions.setCapability("browser.download.manager.alertOnEXEOpen", false);
				IEoptions.setCapability("browser.download.manager.focusWhenStarting", false);
				IEoptions.setCapability("browser.download.manager.useWindow", false);
				IEoptions.setCapability("browser.download.manager.showAlertOnComplete", false);
				IEoptions.setCapability("browser.download.manager.closeWhenDone", false);

				driver = new InternetExplorerDriver(IEoptions);

				break;

			case "EDGE":

				WebDriverManager.edgedriver().setup();

				EdgeOptions Edgeoptions = new EdgeOptions();

				driver = new EdgeDriver(Edgeoptions);

				break;

			case "MOBILE":

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("openDeviceTimeout", 1);

				break;

			default:
				break;

			}			
		} catch (Exception e) {			
			throw e;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}

	  /**
	   * This method is used to get all the data from CSV file which matches your requirement 
	   * @param filePath Absolute path of csv
	   * @param Matches It is for row should be picked for the values which is present in single or multiple columns(Eg. "ProductType=LOC,CustomerStaus=New" or "TestCaseName=VerifySafeAssign")
	   * @param readAllRow If you pass true it will search for all the rows and return collection row data for matches, if you pass false it will find the row and get the data and skips next rows.
	   * @return List of LinkedHashMap each LinkedHashMap will have one row value(Key-Column, Value- cell value for from the matched row)
	   */	
	
	public static List<LinkedHashMap<String, String>> ReadCSV_getRowDataForMatch(String filePath, String Matches,boolean readAllRow)
			throws Exception {
		List<LinkedHashMap<String, String>> dataList = new ArrayList<LinkedHashMap<String, String>>();
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(filePath));
			List<String[]> csvBody = reader.readAll();
			reader.close();
			List<Integer> rows=findRowNumberCSVForMatch(filePath,Matches,readAllRow);

			if (rows.size()==0) {
				throw new Exception("Data[" + Matches + "] not found in[" + filePath + "]");
			}

			String columns[] = csvBody.get(0);
			String line[];

			for(int rowNo:rows) {
				LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
				line=csvBody.get(rowNo);
				for (int i = 0; i <= line.length - 1; i++) {
					if (filePath.contains("Config.csv")) {
						data.put("Config_" + columns[i], line[i]);
					} else if (filePath.contains("StateData.csv")) {
						data.put("StateData_" + columns[i], line[i]);
					} else {
						data.put(columns[i], line[i]);
					}
				}
				dataList.add(data);
			}

		} catch (Exception e) {
			throw e;
		}
		return dataList;
	}
	
	  /**
	   * This method is used for updating the cell values in CSV file for the matches
	   * @param filePath Absolute path of csv
	   * @param match It is for row should be picked for the values which is present in single or multiple columns(Eg. "ProductType=LOC,CustomerID=123456" or "CustomerID=123456")
	   * @param columnName Column name to be updated
	   * @param valueToBeUpdated value which we are going to update in the cell
	   * @return Webdriver Corresponding browser webdriver will be instantiated to the Webdriver interface and which will be returned		
	   */
	
	public static void updateCSV(String filePath, String match, String columnName, String valueToBeUpdated)
			throws Exception {

		int row = findRowNumberCSVForMatch(filePath, match,true).get(0);
		int col = findColumnNumberCSV(filePath, columnName);
		File inputFile = new File(filePath);

		// Read existing file
		CSVReader reader = new CSVReader(new FileReader(inputFile));
		List<String[]> csvBody = reader.readAll();
		int colsPresent = csvBody.get(row).length;
		if (colsPresent != col) {
			for (int i = colsPresent; i <= col - 1; i++) {
				csvBody.get(row)[col] = "";
			}
		}

		// get CSV row column and replace with by using row and column
		csvBody.get(row)[col] = valueToBeUpdated;
		reader.close();

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}
	
	  /**
	   * This method is used for updating the cell values in CSV file for the matches
	   * @param filePath Absolute path of csv
	   * @param columnName Column name to be find for getting index of it
	   * @return Integer value which is column name		
	   */
	private static Integer findColumnNumberCSV(String filePath, String colName) throws Exception {
		int colNo = 0;
		CSVReader reader = new CSVReader(new FileReader(filePath));
		String[] line = reader.readNext();
		int count = 0;
		for (String col : line) {
			if (col.equals(colName)) {
				colNo = count;
				break;
			}
			count = count + 1;
		}
		reader.close();
		return colNo;
	}

	private static List<Integer> findRowNumberCSVForMatch(String filePath, String dataName,boolean readAllRow) throws Exception {
		int rowNo = 1;
		List<Integer> rowNos=new ArrayList<Integer>();
		CSVReader reader = null;

		reader = new CSVReader(new FileReader(filePath));
		String[] line;
		HashMap<String, Integer> columnsNo = new HashMap<String, Integer>();
		String[] dataColumn = null;
		String[] dataCellValue = null;

		if (dataName.contains(",") && dataName.contains("=")) {
			String temp1[] = dataName.split(",");
			dataColumn = new String[temp1.length];
			dataCellValue = new String[temp1.length];
			for (int i = 0; i < temp1.length; i++) {
				String temp2[] = temp1[i].split("=");
				dataColumn[i] = temp2[0];
				dataCellValue[i] = temp2[1];
			}
		} else if (dataName.contains("=")) {
			dataColumn = new String[1];
			dataCellValue = new String[1];
			String temp2[] = dataName.split("=");
			dataColumn[0] = temp2[0];
			dataCellValue[0] = temp2[1];
		}

		String columns[] = reader.readNext();
		for (int i = 0; i < columns.length; i++) {
			columnsNo.put(columns[i], i);
		}

		while ((line = reader.readNext()) != null) {
			boolean foundRow = false;
			for (int i = 0; i < dataColumn.length; i++) {
				if (dataCellValue[i].equals(line[columnsNo.get(dataColumn[i])])) {
					foundRow = true;
				} else {
					foundRow = false;
					break;
				}
			}
			if (foundRow) {
				rowNos.add(rowNo);
				if(!readAllRow) {break;}
			}
			rowNo++;
		}

		reader.close();
		return rowNos;
	}

	public static void updateOutPutData(String match, String columnName, String valueToBeUpdated) throws Exception {
		if (Driver.outPutData) {
			updateCSV(Driver.configDataPath + "\\QFundOutputData.csv", match, columnName, valueToBeUpdated);
		}
	}

	public static void writeNewLineInOutPutData(String dataName) throws Exception {
		if (Driver.outPutData) {
			writeNewLineInCSV(Driver.configDataPath + "\\QFundOutputData.csv", dataName);
		}
	}

	public static void writeNewLineInCSV(String filePath, String dataName) throws Exception {
		// Read existing file
		CSVReader reader = new CSVReader(new FileReader(filePath));
		List<String[]> csvBody = reader.readAll();
		reader.close();
		int colsPresent = csvBody.get(0).length;
		String[] temp = new String[colsPresent];
		temp[0] = dataName;
		for (int i = 1; i < colsPresent; i++) {
			temp[i] = "";
		}

		csvBody.add(temp);

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(filePath));
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}

	  /**
	   * This method is used to get the test flow from TestCase.csv file
	   * @param filePath Absolute path of TestCase.csv
	   * @param testCase Name of the test case
	   * @return LinkedHashMap which will contains collection of process and corresponding data name(Key-Process, Value- Data name)
	   */	
	public static LinkedHashMap<String, String> getTestDetails(String filePath, String testCase) throws Exception {
		LinkedHashMap<String, String> Tests = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> TestAndProcess = ReadCSV_getRowDataForMatch(filePath, "TestName="+testCase,false).get(0);
		String process = null, processName = null, dataName = null;
		for (String testFlow : TestAndProcess.keySet()) {
			String value = TestAndProcess.get(testFlow);
			if (!value.isEmpty()) {
				if (testFlow.toLowerCase().contains("process")) {
					process = testFlow;
					processName = value;
				}
				if (testFlow.toLowerCase().contains("data")) {
					dataName = value;
				}
			} else {
				break;
			}
			if (dataName != null) {
				Tests.put(process, processName + "-->" + dataName);
			}
		}
		return Tests;
	}
	
	public LinkedHashMap<String, String> getData(String process, String dataName,
			LinkedHashMap<String, String> configData) throws Exception {
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> tempData = ReadCSV_getRowDataForMatch(
				Driver.testDataPath + "\\" + process + ".csv", "DataName="+dataName,false).get(0);

		for (String filed : tempData.keySet()) {
			String key = filed;
			String value = tempData.get(filed);
			if (value != null) {
				if (value.contains("CDF(")) {
					String temp[] = (value.replace("CDF(", "").replace(")", "")).split("\\.");
					if (value.contains("CDF(Config.")) {
						value = configData.get("Config_" + temp[1].trim());
					} else if (value.contains("CDF(StateData.")) {
						value = configData.get("StateData_" + temp[1].trim());
					} else {
						value = Driver.allProcessdataForTest.get(temp[0] + "." + temp[1]);
					}
				}
				data.put(process + "." + key, value);
			}
		}

		data.putAll(configData);
		Driver.allProcessdataForTest.putAll(data);
		return data;
	}


	public void updateDataSheet(String colName, String valueToUpdate) throws Exception {
		try {
			Driver.allProcessdataForTest.put(processName + "." + colName, valueToUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getscreenshot(WebDriver driver, String reportPath) {

		String filepath = reportPath + "\\" + getDateAndTimeNow() + ".png";

		try {
			driver.getTitle();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filepath));
		} catch (Exception e) {
			try {
				BufferedImage image = new Robot()
						.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				ImageIO.write(image, "png", new File(filepath));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return filepath;
	}

	
	public static String getDateAndTimeNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now).replace("/", "_").replace(" ", "_").replace(":", "_");
	}


	public static String getSystemDate() {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String strSystemDate = dateFormat.format(date);

		return strSystemDate.replace("/", ".");
	}

	
	public String getTempFolderPath() throws IOException {
		File temp = File.createTempFile("temp-file-name", ".tmp");
		String absolutePath = temp.getAbsolutePath();
		String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
		return tempFilePath;
	}

	
	public static String getRandomValue(String value) {
		Random r = new Random();
		String[] values = {};
		try {
			values = URLDecoder.decode(value, "UTF-8").split("\\|");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values[r.nextInt(values.length)];
	}

	
	public static String getRandomNumeric(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	
	public static String getRandomAlphabetic(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	
	public static String getrandomTestMailId(int length) {
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		String randomEmail = generatedString.toLowerCase() + "@gmail.com";
		return randomEmail;
	}

	
	public static ArrayList<String> allTCStatus(Elements allLLTags) {
		ArrayList<String> listTCStatus = new ArrayList<String>();
		for (int i = 0; i < allLLTags.size(); i++) {
			Elements el = allLLTags.get(i).select("li>div>span.test-name");
			Elements sts = allLLTags.get(i).select("li>div>span.test-status");
			String val = el.text();
			String stsVal = sts.text();
			StringBuffer sb = new StringBuffer(val + "::" + stsVal);
			listTCStatus.add(sb.toString());
		}
		return listTCStatus;
	}


	public static void testCaseStatusInDetail(Elements allLLTags) {
		for (int j = 0; j < allLLTags.size(); j++) {
			Elements el = allLLTags.get(j).select("li>div>span.test-name");
			Elements sts = allLLTags.get(j).select("li>div>span.test-status");

			String val = el.text();
			String stsVal = sts.text();
			System.out.println("'" + val + "' testcase status is : '" + stsVal + "'.");

			Elements tcSteps = allLLTags.get(j).select("li>div.test-body>div.test-steps>table>tbody>tr");
			for (int k = 0; k < tcSteps.size(); k++) {
				System.out.println("*********Test steps start*******");
				String status = tcSteps.get(k).select("tr>td:first-child").get(0).attributes().get("title");
				String timeStamp = tcSteps.get(k).select("tr>td.timestamp").text();
				String stepDetails = tcSteps.get(k).select("tr>td.step-details").text();

				System.out.println("Step-" + (k + 1) + " status '" + status + "', timeStamp '" + timeStamp
						+ "', stepDetails '" + stepDetails + "'.");

				System.out.println("*********Test steps end*******");

			}

		}
	}


	public static void writeDataToExcel(Connection con, Document doc, String reportFile) throws Throwable {
		try {
			con.deleteTable("Report");
		} catch (Throwable t) {
			t.getCause();
		}
		con.createTable("Report", new String[] { "ExecutionDate", "State", "Env", "Team", "TestCaseName", "Status",
		"ExecutionReportPath" });
		Elements allulTags = doc.getElementsByTag("ul").select("ul#test-collection");
		Elements allLLTags = allulTags.select("li");
		String env = doc.getElementsByTag("tr").select("tr>td:contains(Environment)").get(0).siblingElements().text();
		String[] envArr = env.split("_");

		/*
		String userName = doc.getElementsByTag("tr").select("tr>td:contains(User Name)").get(0).siblingElements()
				.text();
		String hostName = doc.getElementsByTag("tr").select("tr>td:contains(Host Name)").get(0).siblingElements()
				.text();
		String javaVersion = doc.getElementsByTag("tr").select("tr>td:contains(Java Version)").get(0).siblingElements()
				.text();
		String os = doc.getElementsByTag("tr").select("tr>td:contains(OS)").get(0).siblingElements().text();
		 */
		SimpleDateFormat frmt = new SimpleDateFormat("dd-MM-yyyy");
		String curDate = frmt.format(new Date());

		ArrayList<String> tcStatus = allTCStatus(allLLTags);
		for (int i = 0; i < tcStatus.size(); i++) {
			String[] tcData = tcStatus.get(i).split("::");
			String tcName = tcData[0];
			String tcSttus = tcData[1];
			String sql = "INSERT INTO Report(ExecutionDate,State,Env,Team,TestCaseName,Status,ExecutionReportPath) VALUES('"
					+ curDate + "','" + envArr[2] + "','" + envArr[0] + "','" + "QFund_StoreFront" + "','" + tcName
					+ "','" + tcSttus + "','" + reportFile + "')";
			con.executeUpdate(sql);
		}
		con.close();

	}

}
