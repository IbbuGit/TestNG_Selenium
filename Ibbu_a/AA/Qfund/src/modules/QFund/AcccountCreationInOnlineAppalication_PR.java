package modules.QFund;
 
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import framework.Helper;
import pageClasses.QFund.AcccountCreationInOnlineAppalication_PO;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.BorrowerRegistrationPersonal_PO;
import pageClasses.QFund.Qfund_Navigation;

public class AcccountCreationInOnlineAppalication_PR extends Helper{
	
	public AcccountCreationInOnlineAppalication_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}
	
	public void getCustomerInfo() throws Exception {
		BorrowerRegistrationPersonal_PO objBorrowerRegistrationPersonal_PO= new BorrowerRegistrationPersonal_PO(driver, report);
		//CustomerLoanHistory_PO objCustomerLoanHistory_Page = new CustomerLoanHistory_PO(driver, report);
		Qfund_Navigation.Borrower.Edit();
		new AppalicationSearch_PO(driver, report).searchByDetailAndSelectCustomer("Customer_Nbr",
				data("as_CustomerNbr"));
		updateDataSheet("SSN1", objBorrowerRegistrationPersonal_PO.get_custSSN());
		updateDataSheet("Regemail", objBorrowerRegistrationPersonal_PO.get_BrwrRegPrsnl_Regemail("Get"));
		updateDataSheet("DOB_MNTH", objBorrowerRegistrationPersonal_PO.get_DOB());
		//updateDataSheet("DOB_DAY", objBorrowerRegistrationPersonal_PO.get_BrwrRegPrsnl_DobDay("Get"));
		//updateDataSheet("DOB_YEAR", objBorrowerRegistrationPersonal_PO.get_BrwrRegPrsnl_DobYear("Get"));
	}

	public void createOnlineAccount() throws Exception {
		AcccountCreationInOnlineAppalication_PO objAcccountCreationInOnlineAppalication_PO= new AcccountCreationInOnlineAppalication_PO(driver, report);
		Thread.sleep(100000);
		objAcccountCreationInOnlineAppalication_PO.click_Login_btn(data("Login_btn"));
		objAcccountCreationInOnlineAppalication_PO.click_CreateAccount_btn(data("CreateAccount_btn"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_EmailAdd(data("CA_EmailAdd"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_ConfirmEmailAdd(data("CA_ConfirmEmailAdd"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_EmpDOB(data("CA_EmpDOB"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_EmpSSN(data("CA_EmpSSN"));
		objAcccountCreationInOnlineAppalication_PO.click_CA_Continuebtn(data("CA_Continuebtn"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_NewPassword(data("NewPassword"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_ConfirmPassword(data("ConfirmPassword"));
		objAcccountCreationInOnlineAppalication_PO.click_CA_SecurityQuestion(data("SecurityQuestion"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_SecurityQuestionOption(data("SecurityQuestionOption"));
		objAcccountCreationInOnlineAppalication_PO.set_CA_SecurityQuestionAnswer(data("SecurityQuestionAnswer"));
		objAcccountCreationInOnlineAppalication_PO.click_CA_CreateAccount_btn(data("CreateAccountBtn"));
		assertAreEqual("Verification Point", report, objAcccountCreationInOnlineAppalication_PO.get_CA_SuccessMsg("Get"), data("Success_Msg"));
		
	}
	
	public void OnlineLogin() throws Exception {
		AcccountCreationInOnlineAppalication_PO objAcccountCreationInOnlineAppalication_PO= new AcccountCreationInOnlineAppalication_PO(driver, report);
		objAcccountCreationInOnlineAppalication_PO.click_Login_btn(data("LoginBtn"));
		objAcccountCreationInOnlineAppalication_PO.set_UserID_Email(data("Email"));
		objAcccountCreationInOnlineAppalication_PO.set_User_Password(data("Password"));
		objAcccountCreationInOnlineAppalication_PO.click_Login_Button(data("SignUp"));
	}
}