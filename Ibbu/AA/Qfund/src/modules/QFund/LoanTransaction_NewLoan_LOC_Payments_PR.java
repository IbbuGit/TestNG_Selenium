package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_Payments_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_Payments_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_Payments_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: locPayments
	 * 		Test data sheet Name	: locPayments
	 * 		Description				: This module covers LOC payments.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing draw	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Jul 26, 2018 9:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void locPayments() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"),
					"Y");
		}

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_NewLoan_LineOfCredit_Payments_PO objLoanTransaction_NewLoan_LineOfCredit_Payments_PO = new LoanTransaction_NewLoan_LineOfCredit_Payments_PO(
				driver, report);

		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.VerifyVisibilityOftenderAmt(), true);

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_paymentAmt(data("loc_paymentAmt"));

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_tenderType_ListBox(data("loc_tenderType_ListBox"));

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_ccmoNbrFirst(data("CCMO"));
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_tenderAmt(data("loc_tenderAmt"));
		// objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.keyTab("Loc_Tab");

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_password(data("loc_password"));

		// assertAreEqual("Before Finish", report,
		// objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.isDisplayed_loc_finishPayment_Button(),
		// true);

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.click_loc_finishPayment_Button(data("loc_finish_Button"));

		if (data("lp_Controller").equalsIgnoreCase("Negative")) {

			assertAreEqual("Page Validation", report,
					objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.getAlertText(), data("alert_message"));
		}
		
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.click_loc_ok_Button(data("loc_Ok"));

	}
}
