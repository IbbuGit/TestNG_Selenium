package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.PayDayVoidPayment_PO;
import pageClasses.QFund.Qfund_Navigation;

public class PayDayVoidPayment_PR extends Helper {

	public PayDayVoidPayment_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);

	}

	public void voidPayDayPayment() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();
		
		
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayVoidPayment_PO objPayDayVoidPayment = new PayDayVoidPayment_PO(driver, report);
		objPayDayVoidPayment.set_payDay_VoidPaymentDisbType(data("payDay_VoidPaymentDisbType"));
		objPayDayVoidPayment.set_payDay_VoidPaymentUserPassword(data("payDay_VoidPaymentUserPassword"));
		//assertAreEqual("Before submission ",report,objPayDayVoidPayment.isDisplayed_payDay_VoidPaymentFinishVoidPaymentButton(), true);
		objPayDayVoidPayment.click_payDay_VoidPaymentFinishVoidPaymentButton(data("payDay_VoidPaymentFinishVoidPaymentButton"));
		objPayDayVoidPayment.click_pymnt_no_pam(data("No_Button"));
	}
	public void voidRppPaymentPlan() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();		
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayVoidPayment_PO objPayDayVoidPayment = new PayDayVoidPayment_PO(driver, report);
		objPayDayVoidPayment.set_payDay_VoidPaymentDisbType(data("payDay_VoidPaymentDisbType"));
		objPayDayVoidPayment.set_payDay_VoidPaymentUserPassword(data("payDay_VoidPaymentUserPassword"));
		//assertAreEqual("Before submission ",report,objPayDayVoidPayment.isDisplayed_payDay_VoidPaymentFinishVoidPaymentButton(), true);
		objPayDayVoidPayment.click_payDay_VoidPaymentFinishVoidPaymentButton(data("payDay_VoidPaymentFinishVoidPaymentButton"));


	}
}
