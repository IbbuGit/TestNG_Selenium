package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_VoidPayments_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_VoidPayments_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: locVoidPayments
	 * 		Test data sheet Name	: locVoidPayments
	 * 		Description				: This module covers LOC Void Payments.
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing void Payments	
	 * 		Output values			: NA
	 * 		Responsible				: VIVEK V
	 * 		Date Created			: Sep, 17 th 2018
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void locVoidPayments() throws Exception {
		
		Qfund_Navigation.Loan_Transaction.Transactions();

		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO = new LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO(driver, report);
				
		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.VerifyVisibilityOfloc_void_Payments_Button(), true);
		if(data("loc_void_Disb_ListBox").equals("Cash")) {
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_void_disType_ListBox(data("loc_void_Disb_ListBox"));
		}else {
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_pamDisType_ListBox(data("loc_void_Disb_ListBox"));
		}
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_void_Password(data("loc_void_Password"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.click_loc_void_Payments_Button(data("void_Payments_Button"));
		
		assertAreEqual("Assertion for Finish Void Payments LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.checkVisibilityOfOk_Button(), true);
		//objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.click_loc_void_ok_Button(data("loc_msg_ok_button"));
		
		
	}
public void locVoidPayOff() throws Exception {
		
		Qfund_Navigation.Loan_Transaction.Transactions();

		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO = new LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO(driver, report);
				
		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.VerifyVisibilityOfloc_void_Payments_Button(), true);
		if(data("loc_void_Disb_ListBox").equals("Cash")) {
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_void_disType_ListBox(data("loc_void_Disb_ListBox"));
		}else {
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_pamDisType_ListBox(data("loc_void_Disb_ListBox"));
		}
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.set_loc_void_Password(data("loc_void_Password"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.click_loc_void_Payoff_Button(data("void_Payments_Button"));
		
		assertAreEqual("Assertion for Finish Void Payments LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.checkVisibilityOfOk_Button_pam(), true);
		objLoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO.click_loc_void_payoff_ok_Button_pam(data("loc_msg_ok_button"));
	
}}
