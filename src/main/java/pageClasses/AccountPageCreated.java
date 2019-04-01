package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageCreated {
	public AccountPageCreated(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="sectionHeaderTitle_accounts") private WebElement Account;
	public boolean accountIsDisplayed()
	{
		return Account.isDisplayed();
	}


}
