package mainClass;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.opencsv.CSVReader;

public class base {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters({"URL","Browser"})
	public void startApp(String appURL,String browser )
	{
		
		if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}


		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun=true)
	public void EndApp()
	{
		driver.close();
		driver.quit();
	}

	@DataProvider(name="ReadCSV_getRowDataForRowName")	
	public Object[][]  ReadCSV_getRowDataForRowName(ITestContext context,Method method) throws Exception  {	

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
					if(method.getName().equals(lines.get(i)[0])) {						
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


	public String alertHandle(String a)
	{
		String i=null;
		Alert alert=driver.switchTo().alert();
		if(a.equalsIgnoreCase("accept"))
		{
			alert.accept();
		}
		else if(a.equalsIgnoreCase("dismiss"))
		{
			alert.dismiss();
		}
		else if(a.equalsIgnoreCase("gettext"))
		{
			i=alert.getText();
		}
		else 
		{
			alert.sendKeys(a);
		}
		return i;
	}

	public  void switchToChildWindow(int noOfwindow)
	{
		Set<String> s= driver.getWindowHandles();
		List<String> winNames=new ArrayList<String>(s);//conversion of set to list
		
		//String parentWindow=driver.getWindowHandle();
		
		for(int i=0;i<winNames.size();i++) {
			if(i==noOfwindow-1) {
				driver.switchTo().window(winNames.get(i));
			}
		}
	}

	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
	}

}


