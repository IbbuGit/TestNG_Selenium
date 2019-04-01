package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyHomePage {
	public MyHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//ul[@class='shortcuts']/li") private List<WebElement> shortCuts;
	public List<WebElement> shortcutList()
	{
		return shortCuts;

	}
	@FindBy(linkText="Create Lead") private WebElement createLead;
	public void clickCL()
	{
		createLead.click();

	}
	@FindBy(linkText="Create Account") private WebElement createAccount;
	public void clickCA()
	{
		createAccount.click();
	}
}
