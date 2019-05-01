package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_VoidDraw_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_VoidDraw_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: locVoidDraw
	 * 		Test data sheet Name	: locVoidDraw
	 * 		Description				: This module covers LOC Void Draw.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing void draw	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Jul 31, 2018 9:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void locVoidDraw() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"),"Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO = new LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO(
				driver, report);

		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.VerifyVisibilityOfloc_void_draw_Button(), true);

		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO
				.set_loc_void_tenderType_ListBox(data("loc_void_tenderType_ListBox"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.set_loc_void_tenderAmt(data("loc_void_tenderAmt"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.set_loc_void_Password(data("loc_void_Password"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.click_loc_void_draw_Button(data("void_draw_Button"));
		// verifyAreEqual("Verify Home Page landed ", report,
		// objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.set_loc_void_success_Msg(),data("loc_void_success_Msg"));
		
		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.checkVisibilityOfOk_Button(), true);	
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.click_loc_void_ok_Button(data("loc_msg_ok_button"));
		
		
	}
}
