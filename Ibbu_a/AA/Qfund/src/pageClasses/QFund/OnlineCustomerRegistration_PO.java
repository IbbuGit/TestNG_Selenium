package pageClasses.QFund;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class OnlineCustomerRegistration_PO extends BasePage{
	
	public OnlineCustomerRegistration_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
		
	}
	
	@FindBy(id = "Start_Application_btn_id")
	private WebElement StartNew_Appalicationbtn;
	
	@FindBy(id = "FirstName")
	private WebElement PersonalInfo_FirstName;
	
	@FindBy(id = "LastName")
	private WebElement PersonalInfo_LastName;
	
	@FindBy(id = "EmailAddress")
	private WebElement PersonalInfo_Email;
	
	@FindBy(id = "ConfirmEmail")
	private WebElement PersonalInfo_ConfirmEmail;
	
	@FindBy(id = "Address1")
	private WebElement PersonalInfo_Address;
	
	@FindBy(id = "City")
	private WebElement PersonalInfo_City;
	
	@FindBy(id = "HomeState")
	private WebElement PersonalInfo_State;
	
	@FindBy(id = "HomeStateOption42")
	private WebElement PersonalInfo_TenesseeState;
	
	@FindBy(id = "ZipCode")
	private WebElement PersonalInfo_ZipCode;
	
	@FindBy(id = "PrimaryPhone")
	private WebElement PersonalInfo_PrimaryPhoneNo;
	
	@FindBy(id = "PrimaryPhoneUnchecked")
	private WebElement PersonalInfo_PrimaryPhoneCheckBox;
	
	@FindBy(id = "DOB")
	private WebElement PersonalInfo_DateOfBirth;
	
	@FindBy(id = "SSN")
	private WebElement PersonalInfo_SSN;
	
	@FindBy(id = "ConfirmSSN")
	private WebElement PersonalInfo_ConfirmSSN;
	
	@FindBy(id = "LoanProductTypeTog")
	private WebElement PersonalInfo_LoanProductType;
	
	@FindBy(id = "POSCustomerSurveyResponse")
	private WebElement PersonalInfo_SurveyResponse;
	
	@FindBy(id = "btnContinue1")
	private WebElement PersonalInfo_ContinueBtn;
	
	@FindBy(id = "POSCustomerSurveyResponseOption1")
	private WebElement PersonalInfo_SurveyReason;	
	
	@FindBy(xpath = "//span[contains(text(),'Payday Loan')]")
	private WebElement PersonalInfo_ProductType;
	
	
	public void set_PersonalInfo_FirstName(String sPersonalInfo_FirstName) {
		wait.until(ExpectedConditions.visibilityOf(PersonalInfo_FirstName));
		doIT(PersonalInfo_FirstName, sPersonalInfo_FirstName);
	}
	
	public void set_PersonalInfo_LastName(String sPersonalInfo_LastName) {
		doIT(PersonalInfo_LastName, sPersonalInfo_LastName);
	}
	
	public void set_PersonalInfo_Email(String sPersonalInfo_Email) {
		doIT(PersonalInfo_Email, sPersonalInfo_Email);
	}
	
	public void set_PersonalInfo_ConfirmEmail(String sPersonalInfo_ConfirmEmail) {
		doIT(PersonalInfo_ConfirmEmail, sPersonalInfo_ConfirmEmail);
	}
	
	public void set_PersonalInfo_Address(String sPersonalInfo_Address) {
		doIT(PersonalInfo_Address, sPersonalInfo_Address);
	}
	
	public void set_PersonalInfo_City(String sPersonalInfo_City) {
		doIT(PersonalInfo_City, sPersonalInfo_City);
	}
	
	public void set_PersonalInfo_State(String sPersonalInfo_State) {
		doIT(PersonalInfo_State, sPersonalInfo_State);
	}
	
	public void set_PersonalInfo_ZipCode(String sPersonalInfo_ZipCode) {
		PersonalInfo_ZipCode.click();
		doIT(PersonalInfo_ZipCode, sPersonalInfo_ZipCode);
	}
	
	public void set_PersonalInfo_PrimaryPhoneNo(String sPersonalInfo_PrimaryPhoneNo) {
		PersonalInfo_PrimaryPhoneNo.click();
		PersonalInfo_PrimaryPhoneNo.clear();
		doIT(PersonalInfo_PrimaryPhoneNo, sPersonalInfo_PrimaryPhoneNo);
	}
	
	public void set_PersonalInfo_DateOfBirth(String sPersonalInfo_DateOfBirth) {
		PersonalInfo_DateOfBirth.click();
		PersonalInfo_DateOfBirth.clear();
		doIT(PersonalInfo_DateOfBirth, sPersonalInfo_DateOfBirth);
	}
	
	public void set_PersonalInfo_SSN(String sPersonalInfo_SSN) {
		PersonalInfo_SSN.click();
		PersonalInfo_SSN.clear();
		doIT(PersonalInfo_SSN, sPersonalInfo_SSN);
	}
	
	public void set_PersonalInfo_ConfirmSSN(String sPersonalInfo_ConfirmSSN) {
		PersonalInfo_ConfirmSSN.click();
		PersonalInfo_ConfirmSSN.clear();
		doIT(PersonalInfo_ConfirmSSN, sPersonalInfo_ConfirmSSN);
	}
	
	public void set_PersonalInfo_LoanProductType(String sPersonalInfo_LoanProductType) {
		doIT(PersonalInfo_LoanProductType, sPersonalInfo_LoanProductType);
	}
	
	public void click_PersonalInfo_SurveyResponse(String sPersonalInfo_SurveyResponse) {
		doIT(PersonalInfo_SurveyResponse, sPersonalInfo_SurveyResponse);
	}
	
	public void click_StartNew_Appalicationbtn(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(StartNew_Appalicationbtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,100);", StartNew_Appalicationbtn);
		doIT(StartNew_Appalicationbtn, data);
		
	}
	
	public void click_PersonalInfo_TenesseeState(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo_TenesseeState));
		doIT(PersonalInfo_TenesseeState, data);
	}
	
	public void click_PersonalInfo_ProductType(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo_ProductType));
		doIT(PersonalInfo_ProductType, data);
	}
	
	public void click_PersonalInfo_SurveyReason(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo_SurveyReason));
		doIT(PersonalInfo_SurveyReason, data);
	}
	
	public void click_PersonalInfo_PrimaryPhoneCheckBox(String data) {
		doIT(PersonalInfo_PrimaryPhoneCheckBox, data);
	}
	
	public void click_PersonalInfo_ContinueBtn(String data) {
		doIT(PersonalInfo_ContinueBtn, data);
	}
	
	//New customer account creation
	
	@FindBy(id = "NewPassword")
	private WebElement PersonalInfo_NewPassword;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement PersonalInfo_ConfirmPassword;
	
	@FindBy(id = "SecurityQuestionID1")
	private WebElement PersonalInfo_SecurityQuestionField;
	
	@FindBy(id = "SecurityQuestionID1Option0")
	private WebElement PersonalInfo_SecurityQuestionOption;
	
	@FindBy(id = "SecurityQuestionAnswer1")
	private WebElement PersonalInfo_SecurityQuestionAnswer;
	
	
	public void set_PersonalInfo_NewPassword(String sPersonalInfo_NewPassword) {
		wait.until(ExpectedConditions.visibilityOf(PersonalInfo_NewPassword));
		doIT(PersonalInfo_NewPassword, sPersonalInfo_NewPassword);
	}
	
	public void set_PersonalInfo_ConfirmPassword(String sPersonalInfo_ConfirmPassword) {
		doIT(PersonalInfo_ConfirmPassword, sPersonalInfo_ConfirmPassword);
	}
	
	public void click_PersonalInfo_SecurityQuestionField(String data) {
		doIT(PersonalInfo_SecurityQuestionField, data);
	}
	
	public void click_PersonalInfo_SecurityQuestionOption(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo_SecurityQuestionOption));
		doIT(PersonalInfo_SecurityQuestionOption, data);
	}
	
	public void set_PersonalInfo_SecurityQuestionAnswer(String sPersonalInfo_SecurityQuestionAnswer) {
		doIT(PersonalInfo_SecurityQuestionAnswer, sPersonalInfo_SecurityQuestionAnswer);
	}
	
}
