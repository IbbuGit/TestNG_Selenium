package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.PayDayLoan_PartialPayment_PO;
import pageClasses.QFund.Qfund_Navigation;

public class PayDay_PartialPayment_PR extends Helper {

	public PayDay_PartialPayment_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);

	}

	public void payDayLoanPayment() throws Exception {

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

		objPayDayLoan_PartialPayment.set_payDay_PaymentAmount(data("payDay_PaymentAmount"));

		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentTenderTypeone(data("payDay_PartialPaymentTenderTypeone"));
		Thread.sleep(1000);
		objPayDayLoan_PartialPayment
		.set_payDay_PartialPaymentTenderAmountone(data("payDay_PartialPaymentTenderAmountone"));

		if (data("CCMO_Nbr").equalsIgnoreCase("Random")) {
			objPayDayLoan_PartialPayment.set_LnPymnt_Tender_CCMONBR(getRandomNumeric(9));
		} else {
			objPayDayLoan_PartialPayment.set_LnPymnt_Tender_CCMONBR(data("CCMO_Nbr"));
		}
		objPayDayLoan_PartialPayment
		.set_payDay_PartialPaymentTenderTypeSecond(data("payDay_PartialPaymentTenderTypeSecond"));
		objPayDayLoan_PartialPayment
		.set_payDay_PartialPaymentTenderAmountsecond(data("payDay_PartialPaymentTenderAmountsecond"));

		if (data("Trans_Selection").equalsIgnoreCase("ACH Pre-Payment")) {
			objPayDayLoan_PartialPayment.set_ach_Password(data("payDay_PartialPaymentUserPassword"));
		} else if (data("Trans_Selection").equalsIgnoreCase("Partial Payment")) {
			objPayDayLoan_PartialPayment
			.set_payDay_PartialPaymentUserPassword(data("payDay_PartialPaymentUserPassword"));
		}

		if (data("Trans_Selection").equalsIgnoreCase("ACH Pre-Payment")) {
			assertAreEqual("Before submission ",report,objPayDayLoan_PartialPayment.isDisplayed_FinishACHPrePayment(), true);

			objPayDayLoan_PartialPayment.click_FinishACHPrePayment(data("payDay_PartialPaymentFinish"));
		} else if (data("Trans_Selection").equalsIgnoreCase("Partial Payment")) {
			assertAreEqual("Before submission ",report,objPayDayLoan_PartialPayment.isDisplayed_payDay_PartialPaymentFinish(), true);

			objPayDayLoan_PartialPayment.click_payDay_PartialPaymentFinish(data("payDay_PartialPaymentFinish"));
		}
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
				objPayDayLoan_PartialPayment.getAlertText(data("alert_message").trim()),
				data("alert_message").trim());
		objPayDayLoan_PartialPayment.acceptAlert();

		if (data("Trans_Selection").equalsIgnoreCase("ACH Pre-Payment")) {
			objPayDayLoan_PartialPayment.click_pay_AnotherTransactionNO(data("No_Button"));
		} else if (data("Trans_Selection").equalsIgnoreCase("Partial Payment")) {
			try {
				objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));
			} catch (Exception e) {
				
			}
			
		}		


	}

	public void payDayBuyBack() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		if (!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("Customer_Nbr"), "Y");
		}
		

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
		if (data("Disp_Amount").isEmpty()) {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(objPayDayLoan_PartialPayment.get_LnPymnt_pymnt_CCMONBR_txt("get"));
		} else {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(data("Disp_Amount"));
		}
		//objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(objPayDayLoan_PartialPayment.get_LnPymnt_pymnt_CCMONBR_txt("get"));
		objPayDayLoan_PartialPayment.set_payDay_BuyBackUserPassword(data("payDay_BuyBackUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_BuyBackFinishButton(data("BuyBackFinishButton"));
		if (!data("alert_message").isEmpty()) {
			assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
					objPayDayLoan_PartialPayment.getAlertText(data("alert_message").trim()),
					data("alert_message").trim());
		}
		if (data("alert_message").isEmpty()) {
			objPayDayLoan_PartialPayment.acceptAlert();
			//objPayDayLoan_PartialPayment.click_payDay_BuyBackFinishButton(data("BuyBackFinishButton"));
			objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));
		}
		
		

	}

	public void rPPPayment() throws Exception {
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
		String s = objPayDayLoan_PartialPayment.get_payDay_CustAccountDisp("Get").substring(3, 7);
		objPayDayLoan_PartialPayment.closeWindow();
		objPayDayLoan_PartialPayment.switchToParentWindow();
		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentAmount(data("payDay_PartialPaymentAmount"));
		if (data("payDay_BuyBackTenderType").equals("Cash")) {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
		} else {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderType(data("payDay_BuyBackTenderType"));
			objPayDayLoan_PartialPayment.set_Rpp_PartialPayment_CCMONo(data("CCMO_Number"));
		}
		
		if (!data("payDay_BuyBackTenderAmount").isEmpty()) {
			objPayDayLoan_PartialPayment.set_payDay_BuyBackTenderAmount(data("payDay_BuyBackTenderAmount"));
		} else {
			objPayDayLoan_PartialPayment
			.set_payDay_BuyBackTenderAmount(objPayDayLoan_PartialPayment.get_payDay_PartialPaymentAmount("Get"));
		}
		
		objPayDayLoan_PartialPayment.set_payDay_CheckingAccountNo(s);
		objPayDayLoan_PartialPayment.set_payDay_RPPPaymentUserPassword(data("payDay_RPPPaymentUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_RppPaymentPlan(data("payDay_RppPaymentPlan"));
		if(objPayDayLoan_PartialPayment.isAlertPresent()) {
			objPayDayLoan_PartialPayment.acceptAlert();
		}
		assertAreEqual("Verifyig payment process message", report, objPayDayLoan_PartialPayment.get_LnPymnt_Confirm_Text("LnPymnt_Confirm_Text").trim().replace("Would you like to complete another transaction for this Customer?", " ").trim(),data("LnPymnt_Confirm_Text"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
				objPayDayLoan_PartialPayment.getAlertText(data("alert_message").trim()),
				data("alert_message").trim());
		if(objPayDayLoan_PartialPayment.isAlertPresent()) {
			objPayDayLoan_PartialPayment.acceptAlert();
		}
		objPayDayLoan_PartialPayment.acceptAlert();
		objPayDayLoan_PartialPayment.click_pymnt_no_pam(data("No_Button"));
	}

	public void cashAtStore() throws Exception {
		Qfund_Navigation.Loan_Transaction.Cash_At_Store();

		new AppalicationSearch_PO(driver, report).set_CashAtStoreApplicationNubBtn(data("Loan_nbr"));

		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_CashAtStorePin(data("payDay_cashAtStore"));
		//assertAreEqual("Before submission ",report,objPayDayLoan_PartialPayment.isDisplayed_payDay_CashAtStoreFinishButton(), true);
		objPayDayLoan_PartialPayment.click_payDay_CashAtLoanFinishButton(data("CashAtLoanFinishButton"));
		objPayDayLoan_PartialPayment.click_CashAtStoreYesBtn("CashAtLoanYesButton");

	}

	public void customerCheckStatus() throws Exception, Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailAndSelectCustomer("Customer_Nbr", data("CustNbr"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentUserPassword(data("payDay_PartialPaymentUserPassword"));
		objPayDayLoan_PartialPayment.click_payDay_PartialPaymentFinish(data("payDay_PartialPaymentFinish"));
		objPayDayLoan_PartialPayment.acceptAlert();
	}
	
	
	public void payDayWriteOffRecovery() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
				data("as_CustomerNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		PayDayLoan_PartialPayment_PO objPayDayLoan_PartialPayment = new PayDayLoan_PartialPayment_PO(driver, report);
		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentTenderTypeone(data("TenderTypeone"));
		objPayDayLoan_PartialPayment.set_payDay_PartialPaymentTenderAmountone(objPayDayLoan_PartialPayment.get_payDay_PaymentAmount("Get"));
		objPayDayLoan_PartialPayment.set_ach_Password(data("Password"));
		objPayDayLoan_PartialPayment.click_FinishACHPrePayment(data("FinishWiteOffRecovery"));
		objPayDayLoan_PartialPayment.acceptAlert();
	}

}
