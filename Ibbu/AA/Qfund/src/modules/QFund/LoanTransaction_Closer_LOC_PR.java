package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_Closer_LineOfCredit_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_Closer_LOC_PR extends Helper {

	public LoanTransaction_Closer_LOC_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: loanTransactionCloserLOC
	 * 		Test data sheet Name	: loanTransactionCloserLOC
	 * 		Description				: This module originate LOC loan and draw amount.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing draw	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Sep 17, 2018 9:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void locGenericClosure() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		
		LoanTransaction_NewLoan_LineOfCredit_PO objLoanTransaction_NewLoan_LineOfCredit_PO = new LoanTransaction_NewLoan_LineOfCredit_PO(
				driver, report);

		objLoanTransaction_NewLoan_LineOfCredit_PO.set_loc_methodOfPayment_Listbox(data("loc_methodOfPayment_Listbox"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.click_loc_eligibility_Button(data("loc_eligibility_Button"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.acceptAlert();

		objLoanTransaction_NewLoan_LineOfCredit_PO
				.set_loc_electronicCommunicationFlag_Listbox(data("loc_electronicCommunicationFlag_Listbox"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.set_loc_password(data("loc_password"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.click_loc_finish_Button(data("loc_finish_Button"));		

		LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO = new LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO(
				driver, report);

		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.click_yes_Button(data("click_Yes"));		
		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.waitForDrawYesButton();
		
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"),"Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_Closer_LineOfCredit_PO objLoanTransaction_Closer_LineOfCredit_PO = new LoanTransaction_Closer_LineOfCredit_PO(
				driver, report);
		objLoanTransaction_Closer_LineOfCredit_PO.set_loc_password(data("loc_password"));
		objLoanTransaction_Closer_LineOfCredit_PO.click_loc_closer("loc_closer");
	}
	
	public void locClosure() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_Closer_LineOfCredit_PO objLoanTransaction_Closer_LineOfCredit_PO = new LoanTransaction_Closer_LineOfCredit_PO(
				driver, report);
		objLoanTransaction_Closer_LineOfCredit_PO.set_loc_password(data("loc_password"));
		objLoanTransaction_Closer_LineOfCredit_PO.click_loc_closer("loc_closer");
		objLoanTransaction_Closer_LineOfCredit_PO.acceptAlert();
		objLoanTransaction_Closer_LineOfCredit_PO.click_loc_close_Yes_Button(data("click_Yes"));
		objLoanTransaction_Closer_LineOfCredit_PO.click_loc_close_OKButton(data("click_Yes"));

	}
}
