package core;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import enums.Alerts;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base extends SoftAssert {

	protected EventFiringWebDriver driver;
	protected ConfigData configData;
	ExtentReports extent;
	ExtentTest Report = null;
	String testName = null;
	String reportFolder = null;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		
		reportFolder = Files.createTempDirectory(getDateAndTimeNow()).toAbsolutePath().toString();
		extent = new ExtentReports(reportFolder+"\\Report.html", true);
		extent.addSystemInfo("Environment", "Test");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		
		configData=new CsvToBeanBuilder<ConfigData>(new FileReader("testDataSource\\config\\ConfigData.csv")).withType(ConfigData.class).build().parse()
					.stream().filter(x -> x.dataScenarios.equalsIgnoreCase("testEnv")).findAny().get();
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
		extent.flush();
		extent.close();
		FileUtils.copyFile(new File(reportFolder+"\\Report.html"), new File("Reports\\Report.html"), true);
	}

	@BeforeMethod(alwaysRun=true)	
	public void startApp(Method method)
	{

		WebDriver wdriver = null;
		
		if(configData.browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();

			InternetExplorerOptions IEoptions = new InternetExplorerOptions();
			IEoptions.introduceFlakinessByIgnoringSecurityDomains();
			IEoptions.destructivelyEnsureCleanSession();

			wdriver = new InternetExplorerDriver(IEoptions);
		}
		else if(configData.browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("disable-extensions");
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			wdriver = new ChromeDriver(chromeOptions);
		}
		

		driver = new EventFiringWebDriver(wdriver);
		Report = extent.startTest(testName);
		EventHandler handler = new EventHandler(Report);
		driver.register(handler);
		
		Report.setStartedTime(new Date());
		Report.log(LogStatus.INFO, "<----Test Case " + testName + " Start---->");
		
		driver.get(configData.URL);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun=true)
	public void EndApp(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS) {
			Report.log(LogStatus.PASS, Report.addScreenCapture(getscreenshot(driver,reportFolder)));	
		}else if(result.getStatus() == ITestResult.FAILURE) {
			Report.log(LogStatus.FAIL, Report.addScreenCapture(getscreenshot(driver,reportFolder)));
		}else if(result.getStatus() == ITestResult.SKIP) {
			Report.log(LogStatus.SKIP, Report.addScreenCapture(getscreenshot(driver,reportFolder)));
		}
		
		
		Report.log(LogStatus.INFO, "<----Test Case " + testName + " End---->");
		Report.setEndedTime(new Date());
		extent.endTest(Report);
		
		driver.close();
		driver.quit();
	}

	@DataProvider(name="ReadCSV_getRowDataForRowName")	
	public Object[][]  ReadCSV_getRowDataForRowName(ITestContext context,Method method) throws Exception  {	
		
		testName=method.getName();

		CSVReader reader = null;		
		Object[][] datas=null;
		try {
			reader = new CSVReader(new FileReader("testDataSource\\testFlows\\"+context.getCurrentXmlTest().getSuite().getName()+"_Suite.csv"));
			List<String[]> lines=reader.readAll();
			datas=new Object[lines.size()][1];
			int k=0;
			for(int i=0;i<lines.size();i++) {
				LinkedHashMap<String, String> data=new LinkedHashMap<String, String>();
				if(testName.equals(lines.get(i)[0])) {	
					int l=1;
						for(int j=0;j<lines.get(i).length-l;j++) {
							data.put(lines.get(i)[l+j], lines.get(i)[l+j+1]);		
							l++;
						}
						datas[k][0]=data;k++;
					}							
			}
			datas=Arrays.copyOf(datas,k);
			reader.close();
		}catch(Exception e){
			throw e;
		}
		return datas;
	}


	public String alertHandle(Alerts event)
	{
		String i=null;
		Alert alert=driver.switchTo().alert();
		if(event.equals(Alerts.ACCEPT))
		{
			alert.accept();
		}
		if(event.equals(Alerts.DISMISS))
		{
			alert.dismiss();
		}
		if(event.equals(Alerts.GETTEXT))
		{
			i=alert.getText();
		}
		return i;
	}

	public  void switchToChildWindow(int noOfwindow)
	{
		Set<String> windows= driver.getWindowHandles();
		
		for(String window:windows) {
			driver.switchTo().window(window);
		}
	}

	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
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
	
	public void assertAreEqual(String msg,Object oActual, Object oExpected) throws Exception {
		if (oExpected != null && oActual != null) {
			if (!oExpected.toString().isEmpty() && !oActual.toString().isEmpty()) {
				if (oExpected.equals(oActual)) {
					Report.log(LogStatus.PASS, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					System.out.println(LogStatus.PASS + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				} else {
					Report.log(LogStatus.FAIL, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					System.out.println(LogStatus.FAIL + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
					throw new Exception(
							msg + "Expected[" + oExpected.toString() + "] " + "Actual[" + oActual.toString() + "]");
				}
			}
		}
	}

	public void verifyAreEqual(String msg, ExtentTest report, Object oActual, Object oExpected) throws Exception {
		if (oExpected != null && oActual != null) {
			if (!oExpected.toString().isEmpty() && !oActual.toString().isEmpty()) {
				if (oExpected.equals(oActual)) {
					Report.log(LogStatus.PASS, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					Report.log(LogStatus.PASS, Report.addScreenCapture(getscreenshot(driver, reportFolder)));
					System.out.println(LogStatus.PASS + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				} else {
					Report.log(LogStatus.FAIL, msg + ": " + "Expected[" + oExpected.toString() + "] " + "Actual["
							+ oActual.toString() + "]");
					Report.log(LogStatus.FAIL, Report.addScreenCapture(getscreenshot(driver, reportFolder)));
					System.out.println(LogStatus.FAIL + ": " + msg + ": " + "Expected[" + oExpected.toString() + "] "
							+ "Actual[" + oActual.toString() + "]");
				}
			}
		}
	}
}


