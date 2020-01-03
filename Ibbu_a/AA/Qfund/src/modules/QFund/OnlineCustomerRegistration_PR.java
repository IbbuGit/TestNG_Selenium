package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.OnlineCustomeRegistration_EmploymentInformation_PO;
import pageClasses.QFund.OnlineCustomerRegistration_PO;

public class OnlineCustomerRegistration_PR extends Helper{
	
	public OnlineCustomerRegistration_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}
	
	public void PersonalInformation() throws Exception {
		
		OnlineCustomerRegistration_PO objOnlineCustomerRegistration_PO = new OnlineCustomerRegistration_PO(driver, report);
		objOnlineCustomerRegistration_PO.click_StartNew_Appalicationbtn(data("StartNew_Appalicationbtn"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_State(data("State"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_TenesseeState(data("TenesseeState"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_FirstName(data("FirstName"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_LastName(data("LastName"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_Email(data("Email"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_ConfirmEmail(data("ConfirmEmail"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_Address(data("Address"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_City(data("City"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_ZipCode(data("ZipCode"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_PrimaryPhoneNo(data("PrimaryPhoneNo"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_PrimaryPhoneCheckBox(data("MobileNo"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_DateOfBirth(data("DOB"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_SSN(data("SSN"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_ConfirmSSN(data("ConfirmSSN"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_LoanProductType(data("ProductType"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_ProductType(data("LoanType"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_SurveyResponse(data("ReferedBy"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_SurveyReason(data("SurveyReason"));
		//objOnlineCustomerRegistration_PO.click_PersonalInfo_ContinueBtn(data("ContinueBtn"));
		
		
	}
	
	public void NewCustomerPasswordCreation() throws Exception {
		
		OnlineCustomerRegistration_PO objOnlineCustomerRegistration_PO = new OnlineCustomerRegistration_PO(driver, report);
		objOnlineCustomerRegistration_PO.set_PersonalInfo_NewPassword(data("NewPassword"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_ConfirmPassword(data("ConfirmPassword"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_SecurityQuestionField(data("SecurityQuestionField"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_SecurityQuestionOption(data("SecurityQuestionOption"));
		objOnlineCustomerRegistration_PO.set_PersonalInfo_SecurityQuestionAnswer(data("Answer"));
		objOnlineCustomerRegistration_PO.click_PersonalInfo_ContinueBtn(data("ContinueBtn"));
	}
	
	public void EmploymentInfo() throws Exception {
		
		OnlineCustomeRegistration_EmploymentInformation_PO objOnlineCustomeRegistration_EmploymentInformation_PO= new OnlineCustomeRegistration_EmploymentInformation_PO(driver, report);
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_SourceOfIncomeOption(data("SourceOfIncomeOption"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_EmpInfo_EmployerName(data("EmployerName"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_EmpInfo_EmployerWorkPh(data("WorkPhNo"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_EmpInfo_EmployeeGrossPay(data("GrossPay"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_EmpInfo_EmployeeNetPay(data("NetPay"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_EmployeeDirectPayNoBtn(data("DirectPayNoBtn"));
		//objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_EmployeePayFrequencyBtn(data("PayFreq"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_EmployeePayFrequencyBiWeeklyBtn(data("BiWeekly"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_NextPayDate(data("PayDate"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_EmpInfo_ContinueBtn(data("ContinueBtn"));
	}
	
	
	public void BankinfInfo() throws Exception {
		
		OnlineCustomeRegistration_EmploymentInformation_PO objOnlineCustomeRegistration_EmploymentInformation_PO= new OnlineCustomeRegistration_EmploymentInformation_PO(driver, report);
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_BankInfo_ABANumber(data("ABA_Number"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_BankInfo_BankAccountNumber(data("AccountNo"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_BankInfo_ConfirmBankAccountNumber(data("ConfirmAccountNo"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.set_BankInfo_BankName(data("BankName"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_BankInfo_Continue(data("ContinueBtn"));
		
	}
	
	
	public void SignUpAndSubmit_Appalication() throws Exception {
		
		OnlineCustomeRegistration_EmploymentInformation_PO objOnlineCustomeRegistration_EmploymentInformation_PO= new OnlineCustomeRegistration_EmploymentInformation_PO(driver, report);
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_SignUp_AgreeTerms(data("AgreeTerms"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_SignUp_TwoPayDayLoans(data("TwoPayDayLoans"));
		objOnlineCustomeRegistration_EmploymentInformation_PO.click_SignUp_SubmitAppalication(data("SubmitBtn"));
	}

}
