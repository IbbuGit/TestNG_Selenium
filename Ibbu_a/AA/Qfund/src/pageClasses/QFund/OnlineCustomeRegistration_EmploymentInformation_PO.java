package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class OnlineCustomeRegistration_EmploymentInformation_PO extends BasePage{
	
	public OnlineCustomeRegistration_EmploymentInformation_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
		
	}
	
	@FindBy(id = "SelectedEmploymentTypeJob1")
	private WebElement EmpInfo_SourceOfIncome;
	
	@FindBy(id = "SelectedEmploymentTypeJob1Option0")
	private WebElement EmpInfo_SourceOfIncomeOption;
	
	@FindBy(id = "EmployerNameJob1")
	private WebElement EmpInfo_EmployerName;
	
	@FindBy(id = "WorkPhoneJob1")
	private WebElement EmpInfo_EmployerWorkPh;
	
	@FindBy(id = "GrossPayPerCheckFieldJob1")
	private WebElement EmpInfo_EmployeeGrossPay;
	
	@FindBy(id = "NetPayPerCheckFieldJob1")
	private WebElement EmpInfo_EmployeeNetPay;
	
	@FindBy(id = "directDepositYesJob1")
	private WebElement EmpInfo_EmployeeDirectPayYesBtn;
	
	@FindBy(id = "directDepositNoJob1")
	private WebElement EmpInfo_EmployeeDirectPayNoBtn;
	
	@FindBy(id = "PayFrequencyGroupIDJob1")
	private WebElement EmpInfo_EmployeePayFrequencyBtn;
	
	@FindBy(id = "PayFrequencyGroupIDJob1Option1")
	private WebElement EmpInfo_EmployeePayFrequencyBiWeeklyBtn;
	
	@FindBy(id = "btnContinue2")
	private WebElement EmpInfo_ContinueBtn;
	
	@FindBy(id = "BiWeeklySelectedDateJob1")
	private WebElement EmpInfo_NextPayField;
	
	@FindBy(id = "BiWeeklySelectedDateJob1Option0")
	private WebElement EmpInfo_NextPayDate;
	
	
	public void set_EmpInfo_EmployerName(String sEmpInfo_EmployerName) {
		doIT(EmpInfo_EmployerName, sEmpInfo_EmployerName);
	}
	
	public void set_EmpInfo_EmployerWorkPh(String sEmpInfo_EmployerWorkPh) {
		EmpInfo_EmployerWorkPh.clear();
		EmpInfo_EmployerWorkPh.click();
		doIT(EmpInfo_EmployerWorkPh, sEmpInfo_EmployerWorkPh);
	}
	
	public void set_EmpInfo_EmployeeGrossPay(String sEmpInfo_EmployeeGrossPay) {
		wait.until(ExpectedConditions.elementToBeClickable(EmpInfo_EmployeeGrossPay));
		EmpInfo_EmployeeGrossPay.click();
		//EmpInfo_EmployeeGrossPay.clear();
		//EmpInfo_EmployeeGrossPay.click();
		doIT(EmpInfo_EmployeeGrossPay, sEmpInfo_EmployeeGrossPay);
	}
	
	public void set_EmpInfo_EmployeeNetPay(String sEmpInfo_EmployeeNetPay) {
		EmpInfo_EmployeeNetPay.click();
		doIT(EmpInfo_EmployeeNetPay, sEmpInfo_EmployeeNetPay);
	}
	
	public void click_EmpInfo_SourceOfIncomeOption(String sEmpInfo_SourceOfIncomeOption) {
		wait.until(ExpectedConditions.elementToBeClickable(EmpInfo_SourceOfIncome));
		EmpInfo_SourceOfIncome.click();
		doIT(EmpInfo_SourceOfIncomeOption, sEmpInfo_SourceOfIncomeOption);
	}
	
	public void click_EmpInfo_EmployeeDirectPayYesBtn(String sEmpInfo_EmployeeDirectPayYesBtn) {
		doIT(EmpInfo_EmployeeDirectPayYesBtn, sEmpInfo_EmployeeDirectPayYesBtn);
	}
	
	public void click_EmpInfo_EmployeeDirectPayNoBtn(String sEmpInfo_EmployeeDirectPayNoBtn) {
		doIT(EmpInfo_EmployeeDirectPayNoBtn, sEmpInfo_EmployeeDirectPayNoBtn);
	}
	
	public void click_EmpInfo_EmployeePayFrequencyBtn(String sEmpInfo_EmployeePayFrequencyBtn) {
		EmpInfo_EmployeePayFrequencyBtn.click();
		doIT(EmpInfo_EmployeePayFrequencyBtn, sEmpInfo_EmployeePayFrequencyBtn);
	}
	
	public void click_EmpInfo_EmployeePayFrequencyBiWeeklyBtn(String sEmpInfo_EmployeePayFrequencyBiWeeklyBtn) {
		EmpInfo_EmployeePayFrequencyBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(EmpInfo_EmployeePayFrequencyBiWeeklyBtn));
		doIT(EmpInfo_EmployeePayFrequencyBiWeeklyBtn, sEmpInfo_EmployeePayFrequencyBiWeeklyBtn);
	}
	
	public void click_EmpInfo_NextPayField(String sEmpInfo_NextPayField) {
		wait.until(ExpectedConditions.elementToBeClickable(EmpInfo_NextPayField));
		doIT(EmpInfo_NextPayField, sEmpInfo_NextPayField);
	}
	
	public void click_EmpInfo_NextPayDate(String sEmpInfo_NextPayDate) {
		EmpInfo_NextPayField.click();
		wait.until(ExpectedConditions.elementToBeClickable(EmpInfo_NextPayDate));
		doIT(EmpInfo_NextPayDate, sEmpInfo_NextPayDate);
	}
	
	public void click_EmpInfo_ContinueBtn(String sEmpInfo_ContinueBtn) {
		doIT(EmpInfo_ContinueBtn, sEmpInfo_ContinueBtn);
	}
	
	
	// Banking Information Locators
	
	@FindBy(id = "BankABANumber")
	private WebElement BankInfo_ABANumber;
	
	@FindBy(id = "BankAccountNumber")
	private WebElement BankInfo_BankAccountNumber;
	
	@FindBy(id = "ConfirmBankAccountNumber")
	private WebElement BankInfo_ConfirmBankAccountNumber;
	
	@FindBy(id = "BankName")
	private WebElement BankInfo_BankName;
	
	@FindBy(id = "btnContinue3")
	private WebElement BankInfo_Continue;
	
	
	
	public void set_BankInfo_ABANumber(String sBankInfo_ABANumber) {
		wait.until(ExpectedConditions.elementToBeClickable(BankInfo_ABANumber));
		BankInfo_ABANumber.click();
		doIT(BankInfo_ABANumber, sBankInfo_ABANumber);
	}
	
	public void set_BankInfo_BankAccountNumber(String sBankInfo_BankAccountNumber) {
		BankInfo_BankAccountNumber.click();
		doIT(BankInfo_BankAccountNumber, sBankInfo_BankAccountNumber);
	}
	
	public void set_BankInfo_ConfirmBankAccountNumber(String sBankInfo_ConfirmBankAccountNumber) {
		BankInfo_ConfirmBankAccountNumber.click();
		doIT(BankInfo_ConfirmBankAccountNumber, sBankInfo_ConfirmBankAccountNumber);
	}
	
	public void set_BankInfo_BankName(String sBankInfo_BankName) {
		BankInfo_BankName.clear();
		doIT(BankInfo_BankName, sBankInfo_BankName);
	}
	
	public void click_BankInfo_Continue(String sBankInfo_Continue) {
		doIT(BankInfo_Continue, sBankInfo_Continue);
	}
	
	
	
	// Sign and Submit Details page locators
	
	@FindBy(id = "eccDisclosureCheckboxUnchecked")
	private WebElement SignUp_AgreeTerms;
	
	@FindBy(id = "excessiveLoansAgreementRadioInput1")
	private WebElement SignUp_TwoPayDayLoans;
	
	@FindBy(id = "excessiveLoansAgreementRadioInput2")
	private WebElement SignUp_MorePayDayLoans;
	
	@FindBy(id = "btnContinue4")
	private WebElement SignUp_SubmitAppalication;
	
	
	
	public void click_SignUp_AgreeTerms(String sSignUp_AgreeTerms) {
		wait.until(ExpectedConditions.elementToBeClickable(SignUp_AgreeTerms));
		doIT(SignUp_AgreeTerms, sSignUp_AgreeTerms);
	}
	
	public void click_SignUp_TwoPayDayLoans(String sSignUp_TwoPayDayLoans) {
		wait.until(ExpectedConditions.elementToBeClickable(SignUp_TwoPayDayLoans));
		doIT(SignUp_TwoPayDayLoans, sSignUp_TwoPayDayLoans);
	}
	
	public void click_SignUp_SubmitAppalication(String sSignUp_SubmitAppalication) {
		wait.until(ExpectedConditions.elementToBeClickable(SignUp_SubmitAppalication));
		doIT(SignUp_SubmitAppalication, sSignUp_SubmitAppalication);
	}
	
}
