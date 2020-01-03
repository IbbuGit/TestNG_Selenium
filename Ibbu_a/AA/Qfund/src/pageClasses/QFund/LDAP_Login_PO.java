package pageClasses.QFund;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class LDAP_Login_PO extends BasePage {

	public LDAP_Login_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	// LDAP User Name Input
	@FindBy(id = "userNameInput")
	private WebElement LDAP_UserName;

	// LDAP Next Button
	@FindBy(id = "nextButton")
	private WebElement LDAP_NextBtn;

	// LDAP Password Input
	@FindBy(id = "passwordInput")
	private WebElement LDAP_Password;

	// LDAP Sign in Button
	@FindBy(id = "submitButton")
	private WebElement LDAP_SignInBtn;
	
	
	public String get_LDAP_UserName(String data){
		return doIT(LDAP_UserName, data);
	}


	public void set_LDAP_UserName(String lDAP_UserName) {
		doIT(LDAP_UserName, lDAP_UserName);
	}

	
	
	public String get_LDAP_Password(String data){
		return doIT(LDAP_Password, data);
	}


	public void set_LDAP_Password(String lDAP_Password) {
		doIT(LDAP_Password, lDAP_Password);
	}

	
	
	public void click_LDAP_NextBtn(String data) {
		doIT(LDAP_NextBtn, data);
	}
	
	public void click_LDAP_SignInBtn(String data) {
		try {
			doIT(LDAP_SignInBtn,data);
		}catch (Exception e) {
	Alert warningalt=driver.switchTo().alert();
	warningalt.accept();

		}
	}
	
	
	
	
	public void loadURL_QfundXApplication(String url) {
		doIT(null,url);
	}
	
	
	
		/* ---------------------------------------------------------------------------
		 * Locator Methods
		 * ------------------------------------------------------------------------------
		 */
		
	/*// Enters the User Name in the field 
	public void set_LDAP_UserName() {
		doIT(LDAP_UserName, "CS14500@aaops.net");
	}

	// Enters the User Password in the field
	public void set_LDAP_Password() {
		doIT(LDAP_Password, "QAFirstUse18");
	}
	
	// Clicks the Next Button
	public void click_LDAP_NextBtn() {
		doIT(LDAP_NextBtn, "y");
	}

	// Clicks the Sign in Button
	public void click_LDAP_SigninBtn() {
		doIT(LDAP_SignInBtn, "y");
	}
	
	// Accepts Alert window
	public void click_YesBtn() {
		driver.switchTo().alert().accept();
	}
	
	public void login_LDAP() {
		set_LDAP_UserName();
		click_LDAP_NextBtn();
		set_LDAP_Password();
		click_LDAP_SigninBtn();
		click_YesBtn();
		}
*/
}
