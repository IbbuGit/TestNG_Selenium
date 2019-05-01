package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.PayDayLoan_Void_PO;
import pageClasses.QFund.Qfund_Navigation;

public class PayDayLoan_Void_PR extends Helper {
 
	public PayDayLoan_Void_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);

	}

	public void voidPayDayLoan() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();
		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayLoan_Void_PO objPayDayLoan_Void = new PayDayLoan_Void_PO(driver, report);
		objPayDayLoan_Void.set_payDay_VoidLoanAmount(data("payDay_VoidLoanAmount"));
		objPayDayLoan_Void.set_payDay_VoidTenderType(data("payDay_VoidTenderType"));
		objPayDayLoan_Void.set_payDay_VoidTenderAmount(objPayDayLoan_Void.get_payDay_VoidLoanAmount("Get"));
		objPayDayLoan_Void.set_payDay_VoidUserPassword(data("payDay_VoidUserPassword"));
		//assertAreEqual("Before submission ",report,objPayDayLoan_Void.isDisplayed_payDay_VoidFinishVoidAdvanceButton(), true);
		objPayDayLoan_Void.click_payDay_VoidFinishVoidAdvanceButton(data("payDay_VoidFinishVoidAdvanceButton"));
		objPayDayLoan_Void.acceptAlert();
		objPayDayLoan_Void.click_pymnt_no_pam(data("No_Button"));
	}
	
	public void pamRescindPayDayLoan() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

	
	    new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		PayDayLoan_Void_PO objPayDayLoan_Void = new PayDayLoan_Void_PO(driver, report);
		objPayDayLoan_Void.set_payDay_VoidLoanAmount(data("payDay_VoidLoanAmount"));
		objPayDayLoan_Void.set_payDay_RescindTenderType(data("payDay_VoidTenderType"));
		objPayDayLoan_Void.set_payDay_VoidTenderAmount(objPayDayLoan_Void.get_payDay_VoidLoanAmount("Get"));
		objPayDayLoan_Void.set_payDay_VoidUserPassword(data("payDay_VoidUserPassword"));
		objPayDayLoan_Void.click_payDay_VoidFinishVoidAdvanceButton(data("payDay_VoidFinishVoidAdvanceButton"));
		objPayDayLoan_Void.acceptAlert();
		objPayDayLoan_Void.click_pymnt_no_pam(data("No_Button"));

}
	

		public void pamvoidPayDayLoan() throws Exception {

			Qfund_Navigation.Loan_Transaction.Transactions();

			
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
			new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

			PayDayLoan_Void_PO objPayDayLoan_Void = new PayDayLoan_Void_PO(driver, report);
			objPayDayLoan_Void.set_payDay_VoidLoanAmount(data("payDay_VoidLoanAmount"));
			objPayDayLoan_Void.set_payDay_Pam_VoidTenderType(data("payDay_VoidTenderType"));
			objPayDayLoan_Void.set_payDay_VoidTenderAmount(objPayDayLoan_Void.get_payDay_VoidLoanAmount("Get"));
			objPayDayLoan_Void.set_payDay_VoidUserPassword(data("payDay_VoidUserPassword"));
			objPayDayLoan_Void.click_payDay_VoidFinishVoidAdvanceButton(data("payDay_VoidFinishVoidAdvanceButton"));
			objPayDayLoan_Void.acceptAlert();
			objPayDayLoan_Void.click_pymnt_no_pam(data("No_Button"));
		
		}
	}


