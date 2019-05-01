package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_PayOff_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_PayOff_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_PayOff_PR(WebDriver _driver, LinkedHashMap<String, String> data,
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

	public void locPayOff() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"),
					"Y");
		}

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_NewLoan_LineOfCredit_PayOff_PO objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO = new LoanTransaction_NewLoan_LineOfCredit_PayOff_PO(
				driver, report);

		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.VerifyVisibilityOftenderAmt(), true);

		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.set_loc_po_TenderType(data("loc_po_TenderType"));

		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.set_loc_po_ccNbr(data("loc_po_CcNbr"));

		/*
		 * String strloc_po_TenderAmt = "0";
		 * 
		 * if (!data("change_Amount").isEmpty()) { float num =
		 * Float.parseFloat(strlocpayoff); String change = String.valueOf(num +
		 * Float.parseFloat("1.00"));
		 * objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.set_loc_po_TenderAmt(change
		 * ); String val =
		 * objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.get_loc_change_Amount("Y");
		 * assertAreEqual("Verify Change Amount", report, val, 1.00);
		 * 
		 * } else if (!data("Money_Flag").isEmpty()) {
		 * 
		 * } else if (!data("Less_Tender_Amt").isEmpty()) { float num =
		 * Float.parseFloat(strlocpayoff); strloc_po_TenderAmt = String.valueOf(num -
		 * Float.parseFloat("5.00")); }
		 */
		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.set_loc_po_TenderAmt(data("loc_po_TenderAmt"));

		// objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.keyTab("Y");

		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.set_loc_password(data("loc_po_Password"));
		
		if (!data("loc_finish_Button").isEmpty()) {
			assertAreEqual("Before submission ", report,
					objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.isDisplayed_loc_finishPayment_Button(), true);

		}
		
		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.click_loc_finishPayment_Button(data("loc_finish_Button"));

		if (data("lp_Controller").equalsIgnoreCase("Negative")) {

			assertAreEqual("Page Validation", report, objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.getAlertText(),
					data("alert_message"));
		}

		objLoanTransaction_NewLoan_LineOfCredit_PayOff_PO.click_po_Validation_OKButton(data("poValidation_OKButton"));
	}
}
