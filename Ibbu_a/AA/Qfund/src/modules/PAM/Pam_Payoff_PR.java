package modules.PAM;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO;
import pageClasses.QFund.LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.PayDayLaon_PO;
import pageClasses.QFund.PayDayLoan_PartialPayment_PO;
import pageClasses.QFund.PayDayVoidPayment_PO;
import pageClasses.QFund.Qfund_Navigation;

public class Pam_Payoff_PR extends Helper {

	public Pam_Payoff_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);

	}

	public void pamPaydaypartialPayment() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);

		objPayDayLoan_PartialPayment.set_payDay_PaymentAmount(data("payDay_PaymentAmount"));
		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentTenderTypeone(data("payDay_PaymentTenderType1"));

		if (data("CCMO_Nbr").equalsIgnoreCase("Random")) {
			objPayDayLoan_PartialPayment.set_LnPymnt_Tender_CCMONBR(getRandomNumeric(9));
		} else {
			objPayDayLoan_PartialPayment.set_LnPymnt_Tender_CCMONBR(data("CCMO_Nbr"));
		}

		objPayDayLoan_PartialPayment
				.set_payDay_PartialPaymentTenderAmountone(data("payDay_PartialPaymentTenderAmountone"));

		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentUserPassword(data("payDay_PartialPaymentUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_PartialPaymentFinish(data("payDay_PartialPaymentFinish"));
		objPayDayLoan_PartialPayment.acceptAlert();
		objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));

	}

	public void pamlocPayoff() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType_payoff(data("Payoff_TenderType"));
		objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount_payoff(
				objPayDayLoan_PartialPayment.get_LnPymnt_pymnt_CCMONBR_txt_payoff("get"));
		objPayDayLoan_PartialPayment.set_payDay_BuyBackUserPassword_payoff(data("Payoff_Password"));
		objPayDayLoan_PartialPayment.click_payDay_BuyBackFinishButton_payoff(data("Payoff_finish_Button"));
		objPayDayLoan_PartialPayment.click_ok_Button_payoff(data("ok_Button"));

	}

	public void pamPaydayBuyBack() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
		objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(
				objPayDayLoan_PartialPayment.get_LnPymnt_pymnt_CCMONBR_txt_buybkpam("get"));
		objPayDayLoan_PartialPayment.set_payDay_BuyBackUserPassword(data("payDay_BuyBackUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_BuyBackFinishButton(data("BuyBackFinishButton"));
		objPayDayLoan_PartialPayment.acceptAlert();
		objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));
	}

	public void pamPaydayVoidPayment() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayVoidPayment_PO objPayDayVoidPayment = new PayDayVoidPayment_PO(driver, report);
		objPayDayVoidPayment.set_payDay_VoidPaymentDisbType(data("payDay_VoidPaymentDisbType"));
		objPayDayVoidPayment.set_payDay_VoidPaymentUserPassword(data("payDay_VoidPaymentUserPassword"));
		objPayDayVoidPayment
				.click_payDay_VoidPaymentFinishVoidPaymentButton(data("payDay_VoidPaymentFinishVoidPaymentButton"));
		objPayDayVoidPayment.click_pymnt_no_pam(data("No_Button"));

	}

	public void pamlocDrawNow() throws Exception {
		LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails = new LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO(
				driver, report);
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_disbAmtFirst_Textbox(
				objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.get_loanAmount_Textbox("get"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.set_password_Textbox(data("loc_password"));
		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_finish_Button(data("finish_Button"));

		objLoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails.click_oK_Button(data("oK_Button"));
	}

	public void pamlocVoidDraw() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_voidDraw_TenderType_csr(data("VoidDraw_TenderType_pam"));
		if (data("DataName").contains("VoidDraw")) {
			objPayDayLoan_PartialPayment
					.set_voidDraw_TenderAmt_pam(objPayDayLoan_PartialPayment.get_voidDraw_drawAmt("get"));
		}
		LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO = new LoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO(
				driver, report);
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.set_loc_void_Password(data("VoidDraw_password_pam"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.click_loc_void__Button(data("Void_Draw_Button"));
		objLoanTransaction_NewLoan_LineOfCredit_VoidDraw_PO.click_loc_void_ok_Button(data("loc_msg_ok_button"));
		
	}

	public void pamPaydayEppInitiate() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		objPayDayLaon_PO.acceptAlert();
		objPayDayLaon_PO.click_rpp_next_btn(data("next_btn"));
		objPayDayLaon_PO.set_pam_Pin(data("PAM_password"));
		objPayDayLaon_PO.click_rpp_finsish_paymentplan(data("finsish_paymentplan"));
		objPayDayLaon_PO.click_rpp_Yes_btn(data("rpp_Yes_btn"));

	}

	public void pamrPPPayment() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		if (!data("as_Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("as_CustomerNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.click_payDay_RppCustInfo(data("payDay_RppCustInfo"));
		objPayDayLoan_PartialPayment.switchToChildWindow();
		String s = objPayDayLoan_PartialPayment.get_payDay_CustAccountDisp("Get").substring(5, 9);
		objPayDayLoan_PartialPayment.closeWindow();
		objPayDayLoan_PartialPayment.switchToParentWindow();
		if (data("payDay_BuyBackTenderType").equals("Cash")) {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
		} else {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
			objPayDayLoan_PartialPayment.set_Rpp_PartialPayment_CCMONo(data("CCMO_Number"));
		}

		if (!data("payDay_BuyBackTenderAmount").isEmpty()) {
			objPayDayLoan_PartialPayment.set_payDay_PartialPaymentAmount(data("payDay_PartialPaymentAmount"));
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(data("payDay_BuyBackTenderAmount"));
		} else {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(
					objPayDayLoan_PartialPayment.get_payDay_PartialPaymentAmount("Get"));
		}

		objPayDayLoan_PartialPayment.set_payDay_CheckingAccountNo(s);
		objPayDayLoan_PartialPayment.set_payDay_RPPPaymentUserPassword(data("payDay_RPPPaymentUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_RppPaymentPlan(data("payDay_RppPaymentPlan"));
		assertAreEqual("Assertion for Alert Text " + data("Success_message"), report,
				objPayDayLoan_PartialPayment.get_payDay_Rpp_Succesmsg(data("Success_message")),
				data("Success_message").trim());
		if (objPayDayLoan_PartialPayment.isAlertPresent()) {
			objPayDayLoan_PartialPayment.acceptAlert();
		}

		objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));
	}

}