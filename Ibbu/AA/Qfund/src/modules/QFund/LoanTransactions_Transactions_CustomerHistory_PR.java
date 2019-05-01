package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.LoanTransactions_Transactions_CustomerHistory_PO;
import pageClasses.QFund.Qfund_Navigation;;

public class LoanTransactions_Transactions_CustomerHistory_PR extends Helper{

	public LoanTransactions_Transactions_CustomerHistory_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

		/*--------------------------------------------------------------------------------------------------
		 * 		Process Name			: transactions_LoanHistory
		 * 		Test data sheet Name	: transactions_LoanHistory
		 * 		Description				: This module drive the transactions history 	
		 * 		Prerequisite			: Customer should have any one loan	
		 * 		Verification Points		: At the beginning of the method to ensure script is running on right page
		 * 		Output values			: NA
		 * 		Responsible				: Manish Kumar Pandey	
		 * 		Date Created			: Jul 5, 2018 9:14:01 AM
		 * 		Date Modified			: 
		 *  --------------------------------------------------------------------------------------------------
		 */
	
	public void customerHistory()throws Exception {
		
		LoanTransactions_Transactions_CustomerHistory_PO objLoanTransactions_CustomerHistory_PO	=	new LoanTransactions_Transactions_CustomerHistory_PO(driver, report);
		
		Qfund_Navigation.Loan_Transaction.Transactions();

		//objLoanTransactions_CustomerHistory_PO.get_ch_PageHeader(data("ch_PageHeader"));
		//objLoanTransactions_CustomerHistory_PO.isDisplayed_ch_PageHeader(data("ch_PageHeader"));

		assertAreEqual("Verification Point", report, objLoanTransactions_CustomerHistory_PO.get_ch_PageHeader(data("ch_PageHeader")), data("ch_PageHeader"));

		//objLoanTransactions_CustomerHistory_PO.get_ch_SSN_ISIN_Validation(data("ch_SSN_ISIN_Validation"));
		//objLoanTransactions_CustomerHistory_PO.isDisplayed_ch_SSN_ISIN_Validation(data("ch_SSN_ISIN_Validation"));

		assertAreEqual("Verification Point", report, objLoanTransactions_CustomerHistory_PO.get_ch_SSN_ISIN_Validation(data("ch_SSN_ISIN_Validation")), data("ch_SSN_ISIN_Validation"));

		//objLoanTransactions_CustomerHistory_PO.get_ch_CustomerStatus_Validation(data("ch_CustomerStatus_Validation"));
		//objLoanTransactions_CustomerHistory_PO.isDisplayed_ch_CustomerStatus_Validation(data("ch_CustomerStatus_Validation"));

		assertAreEqual("Verification Point", report, objLoanTransactions_CustomerHistory_PO.get_ch_CustomerStatus_Validation(data("ch_CustomerStatus_Validation")), data("ch_CustomerStatus_Validation"));

		//objLoanTransactions_CustomerHistory_PO.get_ch_CustomerName_Validation(data("ch_CustomerName_Validation"));
		//objLoanTransactions_CustomerHistory_PO.isDisplayed_ch_CustomerName_Validation(data("ch_CustomerName_Validation"));

		assertAreEqual("Verification Point", report, objLoanTransactions_CustomerHistory_PO.get_ch_CustomerName_Validation(data("ch_CustomerName_Validation")), data("ch_CustomerName_Validation"));

		//objLoanTransactions_CustomerHistory_PO.get_ch_CustomerAddr_Validation(data("ch_CustomerAddr_Validation"));
		//objLoanTransactions_CustomerHistory_PO.isDisplayed_ch_CustomerAddr_Validation(data("ch_CustomerAddr_Validation"));

		assertAreEqual("Verification Point", report, objLoanTransactions_CustomerHistory_PO.get_ch_CustomerAddr_Validation(data("ch_CustomerAddr_Validation")), data("ch_CustomerAddr_Validation"));

		objLoanTransactions_CustomerHistory_PO.click_ch_FlagsButton(data("ch_FlagsButton"));

		objLoanTransactions_CustomerHistory_PO.click_ch_NotesButton(data("ch_NotesButton"));

		objLoanTransactions_CustomerHistory_PO.click_ch_CustomerSummaryViewButton(data("ch_CustomerSummaryViewButton"));
		
		
	}

}
