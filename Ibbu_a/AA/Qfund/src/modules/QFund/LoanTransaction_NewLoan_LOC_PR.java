package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransaction_NewLoan_LOC_PR extends Helper {

	public LoanTransaction_NewLoan_LOC_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: loanTransactionLOC
	 * 		Test data sheet Name	: loanTransactionLOC
	 * 		Description				: This module originate LOC loan and draw amount.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User initial LOC page and finishing draw	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Jul 24, 2018 9:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */
	// public void loanDecisioningLOC() throws Exception {
	//
	// LoanDecisioning_PO objLoanDecisioning_PO = new LoanDecisioning_PO(driver,
	// report);
	// objLoanDecisioning_PO.acceptAlert();
	// objLoanDecisioning_PO.switchToChildWindow();
	// objLoanDecisioning_PO.click_ChildWindowClose(data("ChildWindowClose"));
	// objLoanDecisioning_PO.switchToParentWindow();
	// objLoanDecisioning_PO.selectFrame(objLoanDecisioning_PO.frameMain);
	// objLoanDecisioning_PO.click_selectLOCLoan(data("selectLOCLoan"));
	//
	// //Share Customer Summary added
	// objLoanDecisioning_PO.click_ShareCustomer_Summary(data("ShareCustomer_Summary"));
	// objLoanDecisioning_PO.switchToChildWindow();
	// objLoanDecisioning_PO.click_Confirm_Summary(data("Confirm_Summary"));
	// /*objLoanDecisioning_PO.switchToParentWindow();
	// objLoanDecisioning_PO.switchToChildWindow();
	// //objLoanDecisioning_PO.click_Confirm_Signaturepad(data("Confirm_SignaturePad"));
	// objLoanDecisioning_PO.closeWindow();
	// */
	// objLoanDecisioning_PO.switchToParentWindow();
	// // Share Customer Summary added
	// objLoanDecisioning_PO.selectFrame(objLoanDecisioning_PO.frameMain);
	//
	// objLoanDecisioning_PO.click_LoanDec_NewLoan(data("LoanDec_NewLoan"));
	// }

	public void locDrawExistingCust() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Cust_nbr"),
					"Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails = new LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO(
				driver, report);
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_loanAmount_Textbox(data("loanAmount_Textbox"));
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
				.set_disbTypeFirst_Listbox(data("disbTypeFirst_Listbox"));
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_disbAmtFirst_Textbox(data("disbAmtFirst_Textbox"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_password_Textbox(data("loc_password"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_finish_Button(data("finish_Button"));
		assertAreEqual("Assertion for Finish LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.checkVisibilityOfOk_Button(data("oK_Button")),
				true);
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_oK_Button(data("oK_Button"));

	}

	public void locLoan() throws Exception {

		LoanTransaction_NewLoan_LineOfCredit_PO objLoanTransaction_NewLoan_LineOfCredit_PO = new LoanTransaction_NewLoan_LineOfCredit_PO(
				driver, report);
		assertAreEqual("Assertion for LOC Page", report,
				objLoanTransaction_NewLoan_LineOfCredit_PO.checkVisibilityOfLoc_methodOfPayment_Listbox(), true);
		objLoanTransaction_NewLoan_LineOfCredit_PO.set_loc_methodOfPayment_Listbox(data("loc_methodOfPayment_Listbox"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.click_loc_cancel_Button(data("LOC_Cancel"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.click_loc_eligibility_Button(data("loc_eligibility_Button"));

		String Temp_AlertText = objLoanTransaction_NewLoan_LineOfCredit_PO.getAlertText();
		if (!(Temp_AlertText.contains("Eligibility Assessment"))) {
			if (!data("alert_message").isEmpty()) {
				assertAreEqual("Page Validation", report, Temp_AlertText, data("alert_message"));
			}
		}

		verifyAreEqual("Verifying Applicant has been denied Message", report,
				objLoanTransaction_NewLoan_LineOfCredit_PO.checkApplicationDeniedMsg(data("loc_EligibilityErrorMsg")),
				true);

		objLoanTransaction_NewLoan_LineOfCredit_PO.wait_loc_finish_ButtonToBeClickable(data("loc_finish_Button"));

		// objLoanTransaction_NewLoan_LineOfCredit_PO.set_loc_paymentReminder_Listbox(data("loc_paymentReminder_Listbox"));
		objLoanTransaction_NewLoan_LineOfCredit_PO
				.set_loc_electronicCommunicationFlag_Listbox(data("loc_electronicCommunicationFlag_Listbox"));

		objLoanTransaction_NewLoan_LineOfCredit_PO.set_loc_password(data("loc_password"));

		assertAreEqual("Before submission ", report,
				objLoanTransaction_NewLoan_LineOfCredit_PO.isDisplayed_loc_finish_Button(), true);
		objLoanTransaction_NewLoan_LineOfCredit_PO.click_loc_finish_Button(data("loc_finish_Button"));

		LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO = new LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO(
				driver, report);

		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.click_yes_Button(data("yes_Button"));
		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.click_no_Button(data("No_LOC_Originate"));

		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.click_drawYes_Button(data("drawYes_Button"));
		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.acceptPrinterPopUp();
		objLoanTransaction_NewLoan_LineOfCredit_Confirmation_PO.click_drawNo_Button(data("drawNo_Button"));

		if (!data("drawYes_Button").isEmpty()) {
			/*
			 * Draw
			 */

			LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails = new LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO(
					driver, report);
			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_password_Textbox(data("loc_passwordDraw"));
			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_loanAmount_Textbox(data("loanAmount_Textbox"));
			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
					.set_disbTypeFirst_Listbox(data("disbTypeFirst_Listbox"));

			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
					.set_disbAmtFirst_Textbox(data("disbAmtFirst_Textbox"));
			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_locdraw_NoOfCheck(data("locdraw_NoOfCheck"));

			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_locdraw_CheckAmt1(data("locdraw_CheckAmt1"));

			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
					.set_disbTypeSecond_Listbox(data("disbTypeSecond_Listbox"));

			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
					.set_disbAmtSecond_Textbox(data("disbAmtSecond_Textbox"));

			if (!data("finish_Button").isEmpty()) {
				assertAreEqual("Before Finsish PayOff ", report,
						objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.isDisplayed_finish_Button(), true);

				objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_finish_Button(data("finish_Button"));

			}

			if (!data("alert_message").isEmpty()) {
				assertAreEqual("Page Validation", report,
						objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.getAlertText(), data("alert_message"));

			}

			assertAreEqual("Assertion for Finish LOC ", report, objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
					.checkVisibilityOfOk_Button(data("oK_Button")), true);
			objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_oK_Button(data("oK_Button"));

		}

	}

	public void pamlocLoanDrawer() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("as_Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("as_CustomerNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails = new LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO(
				driver, report);

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails
				.set_disbTypeFirst_Listbox(data("disbTypeFirst_Listbox"));
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_disbAmtFirst_Textbox(
				objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.get_loanAmount_Textbox("get"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_password_Textbox(data("loc_password"));
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_finish_Button(data("finish_Button"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_oK_Button(data("oK_Button"));
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"), "Y");

		assertAreEqual("Assertion for avilable credit for  LOC ", report,
				objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.get_avail_credit("get").contains("0.0"), true);

	}

}
