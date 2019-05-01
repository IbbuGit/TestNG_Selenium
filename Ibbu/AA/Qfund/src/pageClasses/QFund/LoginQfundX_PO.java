package pageClasses.QFund;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;
 

public class LoginQfundX_PO extends BasePage{

	/**
	 * @author Manish Kumar Pandey
	 *
	 */
	public LoginQfundX_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name = "q")
	private WebElement temp;
	
	public void set_temp() {
		doIT(temp, "sd");
	}
	/*
	 * Sign in using the format username@aaops.net
	 */
	@FindBy(id = "loginMessage")
	private WebElement qfundxsf_LDAPLogin_SigninMessage;

	// LDAP User Name Input
	@FindBy(id = "userNameInput")
	private WebElement qfundxsf_LDAPLogin_UserName;

	// LDAP Next Button
	@FindBy(id = "nextButton")
	public WebElement qfundxsf_LDAPLogin_NextButton;

	/*
	 * Please enter your username using the format 'username@aaops.net'
	 */
	@FindBy(id = "errorText")
	private WebElement qfundxsf_LDAPLogin_InvalidUserErrorMessage;

	// LDAP Password Input
	@FindBy(id = "passwordInput")
	private WebElement qfundxsf_LDAPLogin_Password;

	// LDAP Sign in Button
	@FindBy(id = "submitButton")
	private WebElement qfundxsf_LDAPLogin_SignInButton;

	/*
	 * Contact the Service Desk at 888.293.4238 
	 */
	@FindBy(id = "errorText")
	private WebElement qfundxsf_LDAPLogin_LoginFailedMessage;

	/*
	 * Login 
	 */

	@FindBy(xpath = "//input[@name='loginRequestBean.userId']")  
	private WebElement qfundxsf_Login_UserName;

	@FindBy(xpath = "//input[@name='loginRequestBean.password']") 
	private WebElement qfundXsf_Login_Password;

	@FindBy(xpath = "//input[@name='loginRequestBean.locNbr']") 
	private WebElement qfundxsf_Login_StoreId;

	@FindBy(xpath = "//input[@name='login']") 
	public WebElement qfundxsf_Login_SubmitButton;

	@FindBy(xpath = "//input[@name='displayLocalIP']") 
	private WebElement qfundxsf_Login_LocalIP;

	@FindBy(xpath = "//table//h3//ul") 
	private WebElement qfundxsf_Login_ErrorMessage;

	@FindBy(id = "imgResp") 
	private WebElement qfundxsf_HomePage_ValidationImage;
	
	
	/* online application locators*/
	
	@FindBy(id = "aaLogoHorizontal") 
	private WebElement AdvanceAmericaLOGO;
	

	/*

	 * 	Invalid Password
	 *	This IP, is not mapped to the given store
		Invalid Username
		Username noe exist
		This Store is Closed.Please Contact QFund Help Desk .
		This account has been locked because of incorrect login attempts and can be unlocked by the Admin or your Manager.

	 * 
	 */




	/*
	 * ------------------------------------------------------------------------------
	 * Locator Methods
	 * ------------------------------------------------------------------------------
	 */

	public boolean isDisplayed_qfundxsf_LDAPLogin_SigninMessage() {
		return isDisplayed(qfundxsf_LDAPLogin_SigninMessage);
	}
	
	public boolean isDisplayed_AdvanceAmericaLogo() {
		return isDisplayed(AdvanceAmericaLOGO);
	}

	public void set_qfundxsf_LDAPLogin_UserName(String TestData_qfundxsf_LDAPLogin_UserName) {
		doIT(qfundxsf_LDAPLogin_UserName, TestData_qfundxsf_LDAPLogin_UserName);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_UserName() {
		return isDisplayed(qfundxsf_LDAPLogin_UserName);
	}

	public void click_qfundxsf_LDAPLogin_NextButton(String TestData_qfundxsf_LDAPLogin_NextButton) {
		doIT(qfundxsf_LDAPLogin_NextButton, TestData_qfundxsf_LDAPLogin_NextButton);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_NextButton() {
		return isDisplayed(qfundxsf_LDAPLogin_NextButton);
	}

	public String get_qfundxsf_LDAPLogin_InvalidUserErrorMessage(String TestData_qfundxsf_LDAPLogin_InvalidUserErrorMessage) {
		return doIT(qfundxsf_LDAPLogin_InvalidUserErrorMessage, TestData_qfundxsf_LDAPLogin_InvalidUserErrorMessage);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_InvalidUserErrorMessage() {
		return isDisplayed(qfundxsf_LDAPLogin_InvalidUserErrorMessage);
	}

	public void set_qfundxsf_LDAPLogin_Password(String TestData_qfundxsf_LDAPLogin_Password) {
		doIT(qfundxsf_LDAPLogin_Password, TestData_qfundxsf_LDAPLogin_Password);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_Password() {
		return isDisplayed(qfundxsf_LDAPLogin_Password);
	}

	public void click_qfundxsf_LDAPLogin_SignInButton(String TestData_qfundxsf_LDAPLogin_SignInButton) {
		doIT(qfundxsf_LDAPLogin_SignInButton, TestData_qfundxsf_LDAPLogin_SignInButton);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_SignInButton() {
		return isDisplayed(qfundxsf_LDAPLogin_SignInButton);
	}

	public String get_qfundxsf_LDAPLogin_LoginFailedMessage(String TestData_qfundxsf_LDAPLogin_LoginFailedMessage) {
		return doIT(qfundxsf_LDAPLogin_LoginFailedMessage, TestData_qfundxsf_LDAPLogin_LoginFailedMessage);
	}

	public boolean isDisplayed_qfundxsf_LDAPLogin_LoginFailedMessage() {
		return isDisplayed(qfundxsf_LDAPLogin_LoginFailedMessage);
	}

	public void set_qfundxsf_Login_UserName(String TestData_qfundxsf_Login_UserName) {
			doIT(qfundxsf_Login_UserName, TestData_qfundxsf_Login_UserName);		
	}
	
	public String get_qfundxsf_Login_UserName() {
		return doIT(qfundxsf_Login_UserName, "Y");
	}

	public boolean isDisplayed_qfundxsf_Login_UserName() {
		return isDisplayed(qfundxsf_Login_UserName);
	}

	public void set_qfundXsf_Login_Password(String TestData_qfundXsf_Login_Password) {
		doIT(qfundXsf_Login_Password, TestData_qfundXsf_Login_Password);
	}

	public boolean isDisplayed_qfundXsf_Login_Password() {
		return isDisplayed(qfundXsf_Login_Password);
	}

	public void set_qfundxsf_Login_StoreId(String TestData_qfundxsf_Login_StoreId) {
		if(isDisplayedNoException(qfundxsf_Login_StoreId)) {
			doIT(qfundxsf_Login_StoreId, TestData_qfundxsf_Login_StoreId);
		}		
	}

	public boolean isDisplayed_qfundxsf_Login_StoreId() {
		return isDisplayed(qfundxsf_Login_StoreId);
	}

	public void click_qfundxsf_Login_SubmitButton(String TestData_qfundxsf_Login_SubmitButton) {
		doIT(qfundxsf_Login_SubmitButton, TestData_qfundxsf_Login_SubmitButton);
	}

	public boolean isDisplayed_qfundxsf_Login_SubmitButton() {
		return isDisplayed(qfundxsf_Login_SubmitButton);
	}

	public void set_qfundxsf_Login_LocalIP(String TestData_qfundxsf_Login_LocalIP) {
		doIT(qfundxsf_Login_LocalIP, TestData_qfundxsf_Login_LocalIP);
	}

	public boolean isDisplayed_qfundxsf_Login_LocalIP() {
		return isDisplayed(qfundxsf_Login_LocalIP);
	}

	public String get_qfundxsf_Login_ErrorMessage(String TestData_qfundxsf_Login_ErrorMessage) {
		return doIT(qfundxsf_Login_ErrorMessage, TestData_qfundxsf_Login_ErrorMessage);
	}

	public boolean isDisplayed_qfundxsf_Login_ErrorMessage() {
		return isDisplayed(qfundxsf_Login_ErrorMessage);
	}

	public String get_qfundxsf_HomePage_ValidationImage(String TestData_qfundxsf_HomePage_ValidationImage) {
		return doIT(qfundxsf_HomePage_ValidationImage, TestData_qfundxsf_HomePage_ValidationImage);
	}

	public boolean isDisplayed_qfundxsf_HomePage_ValidationImage() {		
		selectFrame(frameTop);
		return isDisplayed(qfundxsf_HomePage_ValidationImage);
	}



	/*--------------------------------------------------------------------------------------------------
	 *          Process Name                  : navigateToQfund
	 *          Test data sheet Name    	   :     
	 *          Description                   :     
	 *          Prerequisite                  :     
	 *          Verification Points           :     
	 *          Output values                 :     
	 *          Responsible                   : VSankar   
	 *          Date Created                  : Jul 9, 2018 11:13:05 AM
	 *          Date Modified                 : 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void loadURL_QfundApplication(String url) {
		doIT(null,url);
	}

	public String get_HomePageTitle(String data) {
		//new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains(data));
		return driver.getTitle();
	}

	public void loadURL_QfundXApplication(String url) {
		doIT(null,url);
	}


	public boolean isDisplayed_QfundX_Login_UserName1() {
		return (wait.until(ExpectedConditions.visibilityOf(qfundxsf_Login_UserName))!=null);
	}


	public void click_LDAP_SignInBtn(String data) {
		try {
			doIT(qfundxsf_LDAPLogin_SignInButton,data);
		}catch (Exception e) {
			Alert warningalt=driver.switchTo().alert();
			warningalt.accept();
		}
	}

	public boolean isDisplayed_HomePage_Qfund_Image() {
		boolean found=false;
		try {
			selectFrame(frameTop);
			qfundxsf_HomePage_ValidationImage.click();
			found=true;
		} catch (StaleElementReferenceException e) {
			return isDisplayed_HomePage_Qfund_Image();
		}
		return found;
	}

	public String visibleLoginOption() {		
		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(qfundxsf_LDAPLogin_UserName);
		LoginOptions.add(qfundxsf_Login_UserName);
		
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;
		
		if(foundIndex==1) {Found="LDAP";}
		else if(foundIndex==2) {Found="QFund";}
		
		else {Found="Page not loaded";}

		return Found;
	}
	
	public boolean isLoggedIn() {	

		boolean Found = false;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Found= isDisplayedNoException(topFrame);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return Found;
	}
}
