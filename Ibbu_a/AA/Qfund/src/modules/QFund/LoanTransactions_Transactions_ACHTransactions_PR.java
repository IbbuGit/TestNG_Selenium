package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.ACHAuthorizationDetails_PO;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.LoanTransactions_Transactions_ACHTransactions_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransactions_Transactions_ACHTransactions_PR extends Helper {

	public LoanTransactions_Transactions_ACHTransactions_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void achLoanTransactions() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("as_Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("as_CustomerNbr"), "Click");
		}

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		LoanTransactions_Transactions_ACHTransactions_PO obj_LoanTransactions_Transactions_ACHTransactions_PO = new LoanTransactions_Transactions_ACHTransactions_PO(
				driver, report);
		obj_LoanTransactions_Transactions_ACHTransactions_PO.acceptAlert();

		switch (data("LoanTransactions")) {

		case "ACH Revoke":
			achRevoke();
			break;
		case "ACH Authorization":
			achAuthorization();
			break;
		case "ACH Clear":
			achClear();
			break;
		case "CustomerRefund":
			CustomerRefund();
			break;
		case "VoidCustomerRefund":
			VoidCustomerRefund();
			break;
		default:
			break;
		}

		ach_AnotherTransaction();

	}

	public void achRevoke() throws Exception {

		ACHAuthorizationDetails_PO objACHAuthorizationDetails_PO = new ACHAuthorizationDetails_PO(driver, report);

		// assertAreEqual("Page
		// Validation",report,objACHAuthorizationDetails_PO.get_Page_Header(data("Page_Header")),data("Page_Header"));

		objACHAuthorizationDetails_PO.click_ACHRevokeButton(data("ACH_Revoke"));

		objACHAuthorizationDetails_PO.set_ABA_RoutingNum(data("ABA_Routing Nbr"));

		objACHAuthorizationDetails_PO.set_ConfirmABA_RoutingNum(data("ABA_Routing Nbr"));

		objACHAuthorizationDetails_PO.set_CheckAcctNum(data("Check_AccountNbr"));

		objACHAuthorizationDetails_PO.set_ConfirmCheckAcctNum(data("Check_AccountNbr"));

		objACHAuthorizationDetails_PO.click_ACHRadioButton(data("ACH_Radio(Y/N)"));

		objACHAuthorizationDetails_PO.set_pinTextBox(data("PIN"));

		objACHAuthorizationDetails_PO.click_ACHAuthorizationButton(data("ACH_Authorization"));

		objACHAuthorizationDetails_PO.click_Yes_button("Y");

	}

	public void achAuthorization() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report)
				.transactionSelection(data("Trans_Selection_ACH_Revoke"));

		new LoanTransactions_TransactionSelection_PO(driver, report)
				.transactionSelection(data("Trans_Selection_ACH_Auth"));

		ACHAuthorizationDetails_PO objACHAuthorizationDetails_PO = new ACHAuthorizationDetails_PO(driver, report);

		objACHAuthorizationDetails_PO.acceptAlert();

		objACHAuthorizationDetails_PO.click_ACHRevokeButton(data("ACH_Revoke"));

		objACHAuthorizationDetails_PO.set_ABA_RoutingNum(data("ABA_Routing Nbr"));

		objACHAuthorizationDetails_PO.set_ConfirmABA_RoutingNum(data("ABA_Routing Nbr"));

		objACHAuthorizationDetails_PO.set_CheckAcctNum(data("Check_AccountNbr"));

		objACHAuthorizationDetails_PO.set_ConfirmCheckAcctNum(data("Check_AccountNbr"));

		objACHAuthorizationDetails_PO.click_ACHRadioButton(data("ACH_Radio(Y/N)"));

		objACHAuthorizationDetails_PO.set_pinTextBox(data("PIN"));

		objACHAuthorizationDetails_PO.click_ACHAuthorizationButton(data("ACH_Authorization"));

		objACHAuthorizationDetails_PO.click_Ok_Button("Y");
	}

	public void achClear() throws Exception {

		LoanTransactions_Transactions_ACHTransactions_PO objLoanTransactions_Transactions_ACHTransactions_PO = new LoanTransactions_Transactions_ACHTransactions_PO(
				driver, report);

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_ac_PageHeader(data("ac_PageHeader")),
				data("ac_PageHeader"));

		objLoanTransactions_Transactions_ACHTransactions_PO.click_ac_CheckAll(data("ac_CheckAll"));
		objLoanTransactions_Transactions_ACHTransactions_PO.click_ac_UnCheckAll(data("ac_UnCheckAll"));

		// objLoanTransactions_Transactions_ACHTransactions_PO.Click_ac_SelectCheck1(data("ac_CheckAll"));
		assertAreEqual("Before submission ", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_ac_FinishACHClearButton(), true);

		objLoanTransactions_Transactions_ACHTransactions_PO
				.click_ac_FinishACHClearButton(data("ac_FinishACHClearButton"));

		// objLoanTransactions_Transactions_ACHTransactions_PO.get_ac_Validation(data("ac_Validation"));
		// objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_ac_Validation(data("ac_Validation"));

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_ac_Validation(data("ac_Validation")),
				data("ac_Validation"));

	}

	public void CustomerRefund() throws Exception {

		LoanTransactions_Transactions_ACHTransactions_PO objLoanTransactions_Transactions_ACHTransactions_PO = new LoanTransactions_Transactions_ACHTransactions_PO(
				driver, report);

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_cr_PageHeader(data("cr_PageHeader")),
				data("cr_PageHeader"));

		// objLoanTransactions_Transactions_ACHTransactions_PO.get_cr_OutToRepoDetailsHeader(data("cr_OutToRepoDetailsHeader"));
		// objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_cr_OutToRepoDetailsHeader(data("cr_OutToRepoDetailsHeader"));

		assertAreEqual("Verification Point", report, objLoanTransactions_Transactions_ACHTransactions_PO
				.get_cr_RefundDetailsHeader(data("cr_RefundDetailsHeader")), data("cr_RefundDetailsHeader"));

		objLoanTransactions_Transactions_ACHTransactions_PO
				.get_cr_VerifyOverPaymentAmDue(data("cr_VerifyOverPaymentAmDue"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_TenderType(data("cr_TenderType"));

		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyAdvanceAmt(data("cr_VerifyAdvanceAmt"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyAdvanceFee(data("cr_VerifyAdvanceFee"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyRebateAmt(data("cr_VerifyRebateAmt"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyPaymentsMade(data("cr_VerifyPaymentsMade"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyPromotions(data("cr_VerifyPromotions"));
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyAmountOwed(data("cr_VerifyAmountOwed"));

		objLoanTransactions_Transactions_ACHTransactions_PO.click_cr_BackButton(data("cr_BackButton"));

		assertAreEqual("Before submission ", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_cr_FinishRefundButton(), true);

		objLoanTransactions_Transactions_ACHTransactions_PO.click_cr_FinishRefundButton(data("cr_FinishRefundButton"));

		// objLoanTransactions_Transactions_ACHTransactions_PO.get_cr_Validation(data("cr_Validation"));
		// objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_cr_Validation(data("cr_Validation"));

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_cr_Validation(data("cr_Validation")),
				data("cr_Validation"));
	}

	public void VoidCustomerRefund() throws Exception {

		LoanTransactions_Transactions_ACHTransactions_PO objLoanTransactions_Transactions_ACHTransactions_PO = new LoanTransactions_Transactions_ACHTransactions_PO(
				driver, report);

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_vr_PageHeader(data("vr_PageHeader")),
				data("vr_PageHeader"));

		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_TenderType(data("cr_TenderType"));

		assertAreEqual("Before submission ", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_vr_FinishVoidRefundButton(), true);

		objLoanTransactions_Transactions_ACHTransactions_PO
				.click_vr_FinishVoidRefundButton(data("vr_FinishVoidRefundButton"));
		objLoanTransactions_Transactions_ACHTransactions_PO.acceptAlert();

		// objLoanTransactions_Transactions_ACHTransactions_PO.get_vr_Validation(data("vr_Validation"));
		// objLoanTransactions_Transactions_ACHTransactions_PO.isDisplayed_vr_Validation(data("vr_Validation"));

		assertAreEqual("Verification Point", report,
				objLoanTransactions_Transactions_ACHTransactions_PO.get_vr_Validation(data("vr_Validation")),
				data("vr_Validation"));

		objLoanTransactions_Transactions_ACHTransactions_PO.click_co_AnotherTranNO(data("co_AnotherTranNO"));
	}

	public void ach_AnotherTransaction() throws Exception {
		LoanTransactions_Transactions_ACHTransactions_PO objLoanTransactions_Transactions_ACHTransactions_PO = new LoanTransactions_Transactions_ACHTransactions_PO(
				driver, report);
		objLoanTransactions_Transactions_ACHTransactions_PO.set_cr_VerifyAmountOwed(data("cr_VerifyAmountOwed"));

	}

}
