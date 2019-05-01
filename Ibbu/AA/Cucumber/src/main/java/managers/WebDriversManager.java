
package managers;

import java.util.concurrent.TimeUnit;
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

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriversManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	
	public WebDriversManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {     
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {     
		case FIREFOX : 
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile());
			// fireFoxOptions.setBinary(configData.get("FirefoxBinary"));
			driver = new FirefoxDriver(fireFoxOptions);
			break;
			
		case CHROME : 
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("disable-extensions");
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(chromeOptions);
			break;
			
		case INTERNETEXPLORER : 
			
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions IEoptions = new InternetExplorerOptions();
			IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			IEoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(IEoptions);
			break;
			
		case EDGE:
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions Edgeoptions = new EdgeOptions();
			driver = new EdgeDriver(Edgeoptions);
			break;

		case MOBILE:
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("openDeviceTimeout", 1);
			break;

		default:
			break;

		}

		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	} 

	public void closeDriver() {
		driver.close();
		driver.quit();
	}



}