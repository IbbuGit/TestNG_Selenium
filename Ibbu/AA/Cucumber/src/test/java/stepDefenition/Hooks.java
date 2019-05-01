package stepDefenition;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pageObjects.HomePage;
import util.Helper;

public class Hooks {
	TestContext testContext;	
	WebDriver driver;
	HomePage homePage;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before()
	public void beforeScenario() {		
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();	
		
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		homePage.launchApplication();
	}
	
	@After
	public void afterScenario() throws Throwable {
		Reporter.addScreenCaptureFromPath(getscreenshot(testContext.getWebDriverManager().getDriver()));
		testContext.getWebDriverManager().closeDriver();		
	}

	public String getscreenshot(WebDriver driver) throws Exception {
		String filepath="\\\\aacss\\cssfiles\\QA\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFundx_Reports_Phase4\\Qfund_"+Helper.getDateAndTimeNow();
		
		
		try {
			driver.getTitle();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filepath));
		} catch (Exception e) {
			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(filepath));
		}
		return filepath;
	}
}
