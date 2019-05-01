package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_Payments_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_Payments_MoneyOrder_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_Payments_MoneyOrder_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: locPayments
	 * 		Test data sheet Name	: locPayments
	 * 		Description				: This module covers LOC payments By Money orders.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing draw	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Oct 10, 2018 9:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void locPaymentsMoneyOrder() throws Exception {
		
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",data("CustNbr"),"Y");
		

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_NewLoan_LineOfCredit_Payments_PO objLoanTransaction_NewLoan_LineOfCredit_Payments_PO = new LoanTransaction_NewLoan_LineOfCredit_Payments_PO(
				driver, report);

		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.VerifyVisibilityOftenderAmt(), true);

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_paymentAmt(data("loc_paymentAmt"));
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_tenderType_ListBox(data("loc_tenderType_ListBox"));
		String ccmoNbr= getRandomNumeric(9);
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_ccmoNbrFirst(ccmoNbr);

		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_tenderAmt(data("loc_tenderAmt"));
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.set_loc_password(data("loc_password"));
		
		objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.click_loc_finishPayment_Button(data("loc_finish_Button"));

		verifyAreEqual("Verify Payment Success Message", report, data("loc_Success_Message"),
				objLoanTransaction_NewLoan_LineOfCredit_Payments_PO
						.get_loc_success_Message(data("loc_Success_Message")));
		//objLoanTransaction_NewLoan_LineOfCredit_Payments_PO.click_loc_ok_Button();

	}
}
