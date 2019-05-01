package pageObjects;

import org.openqa.selenium.WebDriver;
import managers.FileReaderManager;

public class HomePage extends BasePage{

	public HomePage(WebDriver _driver) {super(_driver);}
	
	 public void launchApplication() {
		 driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
}
