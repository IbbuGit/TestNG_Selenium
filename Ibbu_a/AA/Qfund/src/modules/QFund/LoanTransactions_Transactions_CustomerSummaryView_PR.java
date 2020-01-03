package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_CustomerHistory_PO;
import pageClasses.QFund.LoanTransactions_CustomerSummaryView_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransactions_Transactions_CustomerSummaryView_PR extends Helper {

	public LoanTransactions_Transactions_CustomerSummaryView_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void getLoanNbrByCustNbr() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Customer_Nbr"), "");

		LoanTransactions_CustomerHistory_PO objLoanTransactions_CustomerHistory_PO = new LoanTransactions_CustomerHistory_PO(
				driver, report);

		updateDataSheet("Cust_LoanNumber", objLoanTransactions_CustomerHistory_PO.get_loan_Nbr("Y"));

	}

	public void customerSummaryView() throws Exception {

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "");

		LoanTransactions_CustomerHistory_PO objLoanTransactions_CustomerHistory_PO = new LoanTransactions_CustomerHistory_PO(
				driver, report);
		String loanNbrecpected = objLoanTransactions_CustomerHistory_PO.get_loan_Nbr("Y");
		objLoanTransactions_CustomerHistory_PO.click_custHist_CustomerSummaryView(data("CustomerSummary"));
		objLoanTransactions_CustomerHistory_PO.switchToChildWindow();

		LoanTransactions_CustomerSummaryView_PO objLoanTransactions_CustomerSummaryView_PO = new LoanTransactions_CustomerSummaryView_PO(
				driver, report);
		objLoanTransactions_CustomerSummaryView_PO.get_product_Type(data("product_Type"));
		String loanNbrActual = objLoanTransactions_CustomerSummaryView_PO.get_loan_Nbr("Y");

		assertAreEqual("Verification of Product Type", report,
				objLoanTransactions_CustomerSummaryView_PO.get_product_Type(data("product_Type")),
				data("product_Type"));
		assertAreEqual("Verification of Loan Number", report, loanNbrecpected, loanNbrActual);
		assertAreEqual("Verification of Email ID", report, objLoanTransactions_CustomerSummaryView_PO.get_email_Id("Y"),
				data("emailUpdated"));
		assertAreEqual("Verification of Total Due", report,
				objLoanTransactions_CustomerSummaryView_PO.get_total_Due("Y"), data("totalDue"));
		assertAreEqual("Verification of Total Payment Amount Due", report,
				objLoanTransactions_CustomerSummaryView_PO.get_payment_Amt_Due("Y"), data("PaymentAmtDue"));
		assertAreEqual("Verification of Total Payment Amount Due", report,
				objLoanTransactions_CustomerSummaryView_PO.get_total_Paid("Y"), data("totalPaid"));

	}

}
