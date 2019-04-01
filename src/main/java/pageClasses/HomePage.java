package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(linkText="CRM/SFA") private WebElement crmsfa1;
	public void clickcrm()
	{
		crmsfa1.click();

	}
	public boolean loginVerification() {
		return crmsfa1.isDisplayed();
	}
}
