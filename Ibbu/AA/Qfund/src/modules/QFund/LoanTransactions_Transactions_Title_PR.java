package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.LoanTransactions_Transactions_Title_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransactions_Transactions_Title_PR extends Helper {

	public LoanTransactions_Transactions_Title_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void titleTransactions() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Customer_Nbr"),
				"Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		switch (data("TransactionType")) {

		case "Payment":
			Payment();
			break;
		case "VoidPayment":
			VoidPayment();
			break;
		case "RescindPayment":
			RescindPayment();
			break;
		case "VoluntarySurrender":
			VoluntarySurrender();
			break;

		default:
			break;
		}

		pdt_PostTransaction();

	}

	public void Payment() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);
		/*
		 * Payment
		 */
		objLoanTransactions_Transactions_Title_PO.set_ts_paytype(data("ts_Paytype"));
		objLoanTransactions_Transactions_Title_PO.set_ts_PaymentAmount(data("ts_PayOtherAmt"));

		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Type1(data("ts_TenderType1"));
		objLoanTransactions_Transactions_Title_PO
				.set_ts_Tender_Amt1(objLoanTransactions_Transactions_Title_PO.get_ts_PaymentAmount("get"));

		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Type2(data("ts_TenderType2"));
		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Amt2(data("ts_TenderAmount2"));

		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_CCMONBR(data("ts_CCMONbr"));

		objLoanTransactions_Transactions_Title_PO.set_ts_Drawer_PIN(data("ts_DrawerPIN"));
		objLoanTransactions_Transactions_Title_PO.click_ts_Finsih_Button(data("ts_FinsihButton"));
		objLoanTransactions_Transactions_Title_PO.click_ts_RenewLoanButton(data("ts_RenewLoanButton"));
		assertAreEqual("Verifyig payment process message", report,
				objLoanTransactions_Transactions_Title_PO.get_ts_Confirm_Text(data("ts_Validation")),
				data("ts_Validation"));
	}

	public void defaultPayment() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);
		/*
		 * Payment
		 */

		//objLoanTransactions_Transactions_Title_PO.get_dp_PageHeader(data("ts_PageHeader"));
		//objLoanTransactions_Transactions_Title_PO.isDisplayed_dp_PageHeader(data("ts_PageHeader"));

		assertAreEqual("Verification Point", report, objLoanTransactions_Transactions_Title_PO.get_dp_PageHeader(data("ts_PageHeader")), data("ts_PageHeader"));

		//objLoanTransactions_Transactions_Title_PO.get_dp_PaymentDetailsHeader(data("ts_PaymentDetailsHeader"));
		//objLoanTransactions_Transactions_Title_PO.isDisplayed_dp_PaymentDetailsHeader(data("ts_PaymentDetailsHeader"));

		assertAreEqual("Verification Point", report, objLoanTransactions_Transactions_Title_PO.get_dp_PaymentDetailsHeader(data("ts_PaymentDetailsHeader")), data("ts_PaymentDetailsHeader"));

		objLoanTransactions_Transactions_Title_PO.set_dp_VerifyDefaultBalance(data("ts_VerifyDefaultBalance"));
		objLoanTransactions_Transactions_Title_PO.set_dp_PaymentAmount(data("ts_PaymentAmount"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_Type1(data("ts_Tender_Type1"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_Amt1(data("ts_Tender_Amt1"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_CCMONBR1(data("ts_Tender_CCMONBR1"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_Type2(data("ts_Tender_Type2"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_Amt2(data("ts_Tender_Amt2"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Tender_CCMONBR2(data("ts_Tender_CCMONBR2"));
		objLoanTransactions_Transactions_Title_PO.get_dp_Change(data("ts_Change"));
		objLoanTransactions_Transactions_Title_PO.set_dp_Drawer_PIN(data("ts_Drawer_PIN"));

		objLoanTransactions_Transactions_Title_PO.click_dp_Finsih_Button(data("ts_Finsih_Button"));

		//objLoanTransactions_Transactions_Title_PO.get_dp_Validation(data("ts_Validation"));
		//objLoanTransactions_Transactions_Title_PO.isDisplayed_dp_Validation(data("ts_Validation"));

		assertAreEqual("Verification Point", report, objLoanTransactions_Transactions_Title_PO.get_dp_Validation(data("ts_Validation")), data("ts_Validation"));

		
	}
	
	public void VoidPayment() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);
		/*
		 * Void /Rescind
		 */

		objLoanTransactions_Transactions_Title_PO.set_ts_tenderType(data("ts_DisbType"));
		objLoanTransactions_Transactions_Title_PO.get_ts_UserID_Pin(data("ts_DrawerPIN"));
		objLoanTransactions_Transactions_Title_PO.click_ts_FinishVoidLoanButton(data("ts_FinishVoidLoanButton"));
		assertAreEqual("Assertion for Void loan process", report,objLoanTransactions_Transactions_Title_PO.verifyText(), data("ts_Validation"));

	}

	public void RescindPayment() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);
		/*
		 * Void /Rescind
		 */

		objLoanTransactions_Transactions_Title_PO.set_ts_tenderType(data("ts_DisbType"));
		objLoanTransactions_Transactions_Title_PO.get_ts_UserID_Pin(data("ts_DrawerPIN"));
		objLoanTransactions_Transactions_Title_PO.click_ts_FinishVoidLoanButton(data("ts_FinishVoidLoanButton"));
		assertAreEqual("Assertion for rescind loan process", report,objLoanTransactions_Transactions_Title_PO.verifyText(), data("ts_Validation"));

	}

	public void VoluntarySurrender() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_Title_PO.get_vs_PageHeader(data("vs_PageHeader").trim()),
				data("vs_PageHeader").trim());

		// objLoanTransactions_Transactions_Title_PO.get_slv_SalvageDetailsHeader(data("slv_SalvageDetailsHeader"));
		// objLoanTransactions_Transactions_Title_PO.isDisplayed_slv_SalvageDetailsHeader(data("slv_SalvageDetailsHeader"));

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_Title_PO.get_vs_PaymentDetailsHeader(data("vs_PaymentDetailsHeader")),
				data("vs_PaymentDetailsHeader"));

		objLoanTransactions_Transactions_Title_PO
				.get_vs_VeifyVoluntarySurrenderAmount(data("vs_VeifyVoluntarySurrenderAmount"));
		objLoanTransactions_Transactions_Title_PO.set_vs_Comments(data("vs_Comments"));
		objLoanTransactions_Transactions_Title_PO.get_tran_VerifyUserId(data("tran_VerifyUserId"));
		objLoanTransactions_Transactions_Title_PO.set_tran_PIN(data("ts_DrawerPIN"));

	}

	public void pdt_PostTransaction() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);

		objLoanTransactions_Transactions_Title_PO.click_tran_FinishButton(data("tran_SubmitButton"));

		objLoanTransactions_Transactions_Title_PO.click_tran_CancelButton(data("tran_CancelButton"));

		objLoanTransactions_Transactions_Title_PO.click_tran_HistoryButton(data("tran_HistoryButton"));

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_Title_PO.get_vs_Validation(data("vs_Validation")),
				data("vs_Validation"));

	}

	public void loanPayment() throws Exception {
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Cust_nbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
					
		objLoanTransactions_Transactions_Title_PO.set_ts_paytype(data("LnPymnt_type"));
		objLoanTransactions_Transactions_Title_PO.set_ts_PayAny_Other(data("PayOtherAmt"));
		
		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Type1(data("Tender_T1"));
		if (data("CCMO_Nbr").equalsIgnoreCase("Random")) {
			objLoanTransactions_Transactions_Title_PO.set_ts_Tender_CCMONBR(getRandomNumeric(9));
		} else {
			objLoanTransactions_Transactions_Title_PO.set_ts_Tender_CCMONBR(data("CCMO_Nbr"));
		}
		
		String tenderamt= objLoanTransactions_Transactions_Title_PO.get_ts_PayAny_Other("get");
		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Amt1(tenderamt);
		objLoanTransactions_Transactions_Title_PO.set_ts_Drawer_PIN(data("Drawer_PIN"));
		objLoanTransactions_Transactions_Title_PO.click_ts_Finsih_Button(data("Finsih_Button"));
		//Thread.sleep(4000);
		objLoanTransactions_Transactions_Title_PO.click_ts_RenewLoanButton(data("Lnpymnt_RenewLoan"));
		
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objLoanTransactions_Transactions_Title_PO.getAlertTextmsg(data("alert_message")),data("alert_message"));
		assertAreEqual("Verifyig payment process message", report,objLoanTransactions_Transactions_Title_PO.get_ts_Confirm_Text(data("LnPymnt_Confirm_Text")),data("LnPymnt_Confirm_Text"));
		
		

	}
}
