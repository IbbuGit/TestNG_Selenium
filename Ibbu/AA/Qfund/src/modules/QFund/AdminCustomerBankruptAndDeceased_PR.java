package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminCustomerBankruptAndDeceased_PO;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.QfundAdmin_Navigation;


public class AdminCustomerBankruptAndDeceased_PR extends Helper {

	public AdminCustomerBankruptAndDeceased_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void bankruptcyAndDeceased() throws Exception, Exception {
		AdminCustomerBankruptAndDeceased_PO objAdminCustomerBankruptAndDeceased_PO = new AdminCustomerBankruptAndDeceased_PO(
				driver, report);
		QfundAdmin_Navigation.Transactions_Tab.Borrower.Bankruptcy_DeceasedSuite();
		
		new AppalicationSearch_PO(driver, report).searchByDetailAndSelectCustomer("Customer_Nbr", data("CustNbr"));
		objAdminCustomerBankruptAndDeceased_PO.click_Loan_CheckBox(data("Loan_CheckBox"));
	
		objAdminCustomerBankruptAndDeceased_PO.set_Loan_Status(data("Loan_Status"));
		objAdminCustomerBankruptAndDeceased_PO.set_FilingMonth(data("FilingMonth"));
		objAdminCustomerBankruptAndDeceased_PO.set_FilingDay(data("FilingDay"));
		objAdminCustomerBankruptAndDeceased_PO.set_FilingYear(data("FilingYear"));
		objAdminCustomerBankruptAndDeceased_PO.set_CaseNbr(data("CaseNbr"));
		Thread.sleep(3000);
		objAdminCustomerBankruptAndDeceased_PO.set_Chapter(data("Chapter"));
		objAdminCustomerBankruptAndDeceased_PO.set_AttyName(data("AttyName"));
		objAdminCustomerBankruptAndDeceased_PO.set_AttyPhone1(data("AttyPhone1"));
		objAdminCustomerBankruptAndDeceased_PO.set_AttyPhone2(data("AttyPhone2"));
		objAdminCustomerBankruptAndDeceased_PO.set_AttyPhone3(data("AttyPhone3"));
		objAdminCustomerBankruptAndDeceased_PO.set_DismissedOrDecesedDateMonth(data("DismissedOrDecesedDateMonth"));
		objAdminCustomerBankruptAndDeceased_PO.click_SaveBtn(data("SaveBtn"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
				objAdminCustomerBankruptAndDeceased_PO.getAlertText(data("alert_message").trim()),
				data("alert_message").trim());
		objAdminCustomerBankruptAndDeceased_PO.waitForElement();
		assertAreEqual("Verification Point", report, objAdminCustomerBankruptAndDeceased_PO.get_PendingMessage("get"), data("Message"));
		//objQfund_Navigation_PO.navigateTo_Admin_Transactions_Borrower_BorrowerSearch();
		//new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
	}

	public void deceased_Void() throws Exception, Exception {
		AdminCustomerBankruptAndDeceased_PO objAdminCustomerBankruptAndDeceased_PO = new AdminCustomerBankruptAndDeceased_PO(
				driver, report);
		QfundAdmin_Navigation.Transactions_Tab.Borrower.Bankruptcy_DeceasedSuite();
		
		new AppalicationSearch_PO(driver, report).searchByDetailAndSelectCustomer("Customer_Nbr", data("CustNbr"));
		objAdminCustomerBankruptAndDeceased_PO.click_Gobtn(data("Gobtn"));
		objAdminCustomerBankruptAndDeceased_PO.set_Loan_Status(data("Loan_Status"));
		//if (!data("Loan_Status").equals("Void Pending")&&!data("Loan_Status").equals("Discharged")) {
		//	objAdminCustomerBankruptAndDeceased_PO.set_DismissedOrDecesedDateDay(objAdminCustomerBankruptAndDeceased_PO.get_Date("Get"));	
		//}
		objAdminCustomerBankruptAndDeceased_PO.set_DismissedOrDecesedDateMonth(data("DismissedOrDecesedDateMonth"));
		objAdminCustomerBankruptAndDeceased_PO.set_DismissedOrDecesedDateDay(data("DismissedOrDecesedDateDay"));
		objAdminCustomerBankruptAndDeceased_PO.set_DismissedOrDecesedDateYear(data("DismissedOrDecesedDateYear"));
		objAdminCustomerBankruptAndDeceased_PO.click_SaveBtn(data("SaveBtn"));
		//objQfund_Navigation_PO.navigateTo_Admin_Transactions_Borrower_BorrowerSearch();
		//new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
	}

}
