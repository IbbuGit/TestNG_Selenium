package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testDataTypes.LoginData;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver _driver) {super(_driver);}


	@FindBy(name = "username")
	private WebElement username_txtbox;

	@FindBy(name = "password")
	private WebElement password_txtbox;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignIn_Btn;
	
	@FindBy(xpath = "//span[@class='name']/span")
	private WebElement verifyUserName_txt;
	
	public void setUserName(String data) {
		username_txtbox.sendKeys(data);
	}
	
	public void setPassword(String data) {
		password_txtbox.sendKeys(data);
	}
	
	public void setClick() {
		SignIn_Btn.click();
	}
	
	public void loginApp(LoginData loginData) {
		setUserName(loginData.username);
		setPassword(loginData.password);
		SignIn_Btn.click();
	}
	
	public String getVerifyUserName() {
		return verifyUserName_txt.getText();
	}
	
	
}