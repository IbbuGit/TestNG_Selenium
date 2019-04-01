package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="username") private WebElement userName;
	@FindBy(id="password") private WebElement passWord;
	@FindBy(className="decorativeSubmit") private WebElement loginButton;
	@FindBy (className="serviceError") private  WebElement appDownErr;
	@FindBy(xpath="//div[@class='serviceError']/p") private List<WebElement> loginFailErr;
	public String getLoginFailError()
	{
		String a=" ";
		for(WebElement ele:loginFailErr)
		{
			a=a+","+ele.getText();
		}
		return a.replace(" ,", "");

	}
	public void enterUserName(String data)
	{
		userName.sendKeys(data); 
	}

	public void enterpassWord(String data)
	{
		passWord.sendKeys(data);
	}


	public void clickbutton()
	{
		loginButton.click();

	}

	public boolean displayAppDownError() {

		return appDownErr.isDisplayed();
	}

	public void loginApp(String userName,String passWord)
	{
		enterUserName(userName);
		enterpassWord(passWord);
		clickbutton();		 
	}

	public String loginbutontext()
	{
		return  loginButton.getAttribute("value");	

	}
}