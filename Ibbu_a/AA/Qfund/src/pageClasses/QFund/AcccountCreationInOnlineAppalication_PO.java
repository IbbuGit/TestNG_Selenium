package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.ExtentTest;

public class AcccountCreationInOnlineAppalication_PO extends BasePage{

	public AcccountCreationInOnlineAppalication_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
		
	}
	
	@FindBy(xpath = "//*[@class='loginLinkWrap']")
	private WebElement Login_btn;
	
	@FindBy(xpath = "//a[contains(text(),'Create Account')]")
	private WebElement CreateAccount_btn;
	
	@FindBy(id = "EmailAddress")
	private WebElement CA_EmailAdd;
	
	@FindBy(id = "ConfirmEmail")
	private WebElement CA_ConfirmEmailAdd;
	
	@FindBy(id = "DOB")
	private WebElement CA_EmpDOB;
	
	@FindBy(id = "SSN")
	private WebElement CA_EmpSSN;
	
	@FindBy(id = "btnContinue1")
	private WebElement CA_Continuebtn;
	
	@FindBy(id = "NewPassword")
	private WebElement CA_NewPassword;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement CA_ConfirmPassword;
	
	@FindBy(xpath = "//input[@id='SecurityQuestionID1']")
	private WebElement CA_SecurityQuestion;
	
	@FindBy(xpath = "//li[@id='SecurityQuestionID1Option4']")
	private WebElement CA_SecurityQuestionOption;
	
	@FindBy(id = "SecurityQuestionAnswer1")
	private WebElement CA_SecurityQuestionAnswer;
	
	@FindBy(id = "btnContinue2")
	private WebElement CA_CreateAccount_btn;
	
	@FindBy(id = "Password")
	private WebElement User_Password;
	
	@FindBy(xpath = "//h2[contains(text(),'Your account has been created.')]")
	private WebElement CA_SuccessMsg;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement Login_Button;
	
	@FindBy(id = "Username")
	private WebElement UserID_Email;
	
	public String get_CA_SuccessMsg(String sCA_SuccessMsg) {
		return doIT(CA_SuccessMsg, sCA_SuccessMsg);
	}
	
	public void click_CA_SecurityQuestion(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(CA_SecurityQuestion));
		doIT(CA_SecurityQuestion, data);
		//CA_SecurityQuestion.click();
	}
	
	
	public void click_CA_CreateAccount_btn(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(CA_CreateAccount_btn));
		doIT(CA_CreateAccount_btn, data);
	}
	
	public void click_Login_Button(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(Login_Button));
		doIT(Login_Button, data);
	}
	
	
	public void click_Login_btn(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(Login_btn));
		doIT(Login_btn, data);
	}
	
	public void click_CreateAccount_btn(String data) {
		wait.until(ExpectedConditions.visibilityOf(CreateAccount_btn));
		doIT(CreateAccount_btn, data);
	}
	
	public void click_CA_Continuebtn(String data) {
		wait.until(ExpectedConditions.visibilityOf(CA_Continuebtn));
		doIT(CA_Continuebtn, data);
	}
	
	public void set_CA_EmailAdd(String sCA_EmailAdd) {
		wait.until(ExpectedConditions.visibilityOf(CA_EmailAdd));
		doIT(CA_EmailAdd, sCA_EmailAdd);
	}
	
	public void set_UserID_Email(String sUserID_Email) {
		wait.until(ExpectedConditions.visibilityOf(UserID_Email));
		doIT(UserID_Email, sUserID_Email);
	}
	
	
	public void set_User_Password(String sUser_Password) {
		wait.until(ExpectedConditions.visibilityOf(User_Password));
		doIT(User_Password, sUser_Password);
	}
	
	public void set_CA_ConfirmEmailAdd(String sCA_ConfirmEmailAdd) {
		wait.until(ExpectedConditions.visibilityOf(CA_ConfirmEmailAdd));
		doIT(CA_ConfirmEmailAdd, sCA_ConfirmEmailAdd);
	}
	
	public void set_CA_NewPassword(String sCA_NewPassword) {
		wait.until(ExpectedConditions.visibilityOf(CA_NewPassword));
		doIT(CA_NewPassword, sCA_NewPassword);
	}
	
	public void set_CA_ConfirmPassword(String sCA_ConfirmPassword) {
		wait.until(ExpectedConditions.visibilityOf(CA_ConfirmPassword));
		doIT(CA_ConfirmPassword, sCA_ConfirmPassword);
	}
	
	public void set_CA_SecurityQuestionOption(String sCA_SecurityQuestionOption) {
		wait.until(ExpectedConditions.visibilityOf(CA_SecurityQuestionOption));
		//Select s= new Select(CA_SecurityQuestion);
		//s.selectByValue(sCA_SecurityQuestion);
		//doIT(CA_SecurityQuestionOption, sCA_SecurityQuestionOption);
		CA_SecurityQuestionOption.click();
		CA_ConfirmPassword.click();
	}
	
	public void set_CA_SecurityQuestionAnswer(String sCA_SecurityQuestionAnswer) {
		wait.until(ExpectedConditions.visibilityOf(CA_SecurityQuestionAnswer));
		doIT(CA_SecurityQuestionAnswer, sCA_SecurityQuestionAnswer);
	}
	
	public void set_CA_EmpDOB(String sCA_EmpDOB) {
		wait.until(ExpectedConditions.visibilityOf(CA_EmpDOB));
		CA_EmpDOB.click();
		CA_EmpDOB.clear();
		doIT(CA_EmpDOB, sCA_EmpDOB);
		
	}
	
	public void set_CA_EmpSSN(String sCA_EmpSSN) {
		wait.until(ExpectedConditions.visibilityOf(CA_EmpSSN));
		CA_EmpSSN.click();
		CA_EmpSSN.clear();
		doIT(CA_EmpSSN, sCA_EmpSSN);
	
	}

}
