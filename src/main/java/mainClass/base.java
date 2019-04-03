package mainClass;

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
import org.testng.annotations.Parameters;
import com.opencsv.CSVReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import enums.Alerts;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	protected EventFiringWebDriver driver;
	ExtentReports extent;
	ExtentTest Report = null;
	String testName = null;
	String reportFolder = null;
	
	@BeforeSuite
	public void beforeSuite() {
		try {
			reportFolder = Files.createTempDirectory(getDateAndTimeNow()).toAbsolutePath().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent = new ExtentReports(reportFolder+"\\report.html", true);
		extent.addSystemInfo("Environment", "Test");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
	
	@AfterSuite
	public void afterSuite() {
		Report.setEndedTime(new Date());
		extent.endTest(Report);		
		try {
			FileUtils.copyFile(new File(reportFolder+"\\report.html"), new File("Reports\\report.html"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@BeforeMethod(alwaysRun=true)
	@Parameters({"URL","Browser"})
	public void startApp(String appURL,String browser,Method method)
	{

		WebDriver wdriver = null;
		
		if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();

			InternetExplorerOptions IEoptions = new InternetExplorerOptions();
			IEoptions.introduceFlakinessByIgnoringSecurityDomains();
			IEoptions.destructivelyEnsureCleanSession();

			wdriver = new InternetExplorerDriver(IEoptions);
		}
		else if(browser.equalsIgnoreCase("chrome"))
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
		
		driver.get(appURL);	
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
		extent.endTest(Report);
		extent.flush();
		extent.close();
		
		driver.close();
		driver.quit();
	}

	@DataProvider(name="ReadCSV_getRowDataForRowName")	
	public Object[][]  ReadCSV_getRowDataForRowName(ITestContext context,Method method) throws Exception  {	
		
		testName=method.getName();

		CSVReader reader = null;		
		Object[][] datas=null;
		String[] columns = null;

		try {
			reader = new CSVReader(new FileReader("testDataSource\\"+context.getCurrentXmlTest().getSuite().getName()+".csv"));
			List<String[]> lines=reader.readAll();
			datas=new Object[lines.size()][1];
			int k=0;
			for(int i=0;i<lines.size();i++) {
				LinkedHashMap<String, String> data=new LinkedHashMap<String, String>();
				if(i>0) {
					if(testName.equals(lines.get(i)[0])) {						
						for(int j=0;j<=lines.get(i).length-1;j++) {
							data.put(columns[j], lines.get(i)[j]);						
						}
						datas[k][0]=data;k++;
					}					
				}else {columns=lines.get(i);}				
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

}


