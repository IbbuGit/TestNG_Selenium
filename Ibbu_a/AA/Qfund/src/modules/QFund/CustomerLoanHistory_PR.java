package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.CustomerLoanHistory_PO;
import pageClasses.QFund.LoanTransactions_CustomerHistory_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;;

public class CustomerLoanHistory_PR extends Helper {

	private LinkedHashMap<String, String> ThisPRData;

	public CustomerLoanHistory_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		this.ThisPRData = data;
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

	public void transactions_LoanHistory() throws Exception {
		CustomerLoanHistory_PO objCustomerLoanHistory_Page = new CustomerLoanHistory_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		if (!data("as_Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("as_CustomerNbr"), "Y");
		}

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("ch_Transaction"));
		new LoanTransactions_TransactionSelection_PO(driver, report).SendDataHashmap(this.ThisPRData);

		assertAreEqual("Verification Point", report, objCustomerLoanHistory_Page.verifyPage_Header(), true);
		// assertAreEqual("Assertion for customer's transaction info
		// process",report,objCustomerLoanHistory_Page.verifyVisibilityOfhistory_AccountStatus(),true);
		if (data("th_TransDtls_CancelButton").equals("y")) {
			objCustomerLoanHistory_Page.click_th_TransDtls_CancelButton(data("th_TransDtls_CancelButton"));
		} else {

			boolean bFound = false;
			for (String col : allProcessData.keySet()) {

				if (col.equals("transactions_LoanHistory.History_CustomerName")) {
					bFound = true;
				}

				if (!allProcessData.get(col).isEmpty()) {
					if (bFound) {
						if (col.contains("EOC")) {
							bFound = false;
						}
						String Excpected = allProcessData.get(col);
						String Actual = (String) objCustomerLoanHistory_Page.getClass()
								.getDeclaredMethod("get_" + col.replace("transactions_LoanHistory.", ""), String.class)
								.invoke(objCustomerLoanHistory_Page, allProcessData.get(col));
						verifyAreEqual("Verify Field[" + col + "] value", report, Excpected, Actual.trim());

					}
				}

			}

		}
	}

	public void transactionHistory_get() throws Exception, Exception {
		CustomerLoanHistory_PO objCustomerLoanHistory_Page = new CustomerLoanHistory_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();

		if (!data("as_Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("as_Loan_nbr"),
					"Click");
		} else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",
					data("as_CustomerNbr"), "Y");
		}

		LoanTransactions_CustomerHistory_PO objLoanTransactions_CustomerHistory_PO = new LoanTransactions_CustomerHistory_PO(
				driver, report);

		//updateDataSheet("as_Loan_nbr", objLoanTransactions_CustomerHistory_PO.get_loan_Nbr("Y"));

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("as_Transaction"));

		if (data("th_LoanType").toUpperCase().equals("TITLE")) {
			assertAreEqual("Verification Point", report, objCustomerLoanHistory_Page.get_th_Header(data("th_Header")),
					data("th_Header"));

		} else if (data("th_LoanType").toUpperCase().equals("LOC")) {
			assertAreEqual("Verification Point", report,
					objCustomerLoanHistory_Page.get_th_Header(data("th_loc_Header")), data("th_loc_Header"));

		} else if (data("th_LoanType").toUpperCase().equals("PAYDAY")) {
			assertAreEqual("Verification Point", report, objCustomerLoanHistory_Page.get_th_Header(data("th_Header")),
					data("th_Header"));
        
		} else if (data("th_LoanType").toUpperCase().equals("INSTALLMENT")) {
			assertAreEqual("Verification Point", report, objCustomerLoanHistory_Page.get_th_Header(data("th_Header")),
					data("th_Header"));
		}

		/*
		 * Product
		 * 
		 */

		if (data("th_LoanType").toUpperCase().equals("TITLE")) {
			updateDataSheet("History_CustomerName", objCustomerLoanHistory_Page.get_History_CustomerName("get"));
			updateDataSheet("History_MigrationSource", objCustomerLoanHistory_Page.get_History_MigrationSource("get"));

			updateDataSheet("History_LoanStatus", objCustomerLoanHistory_Page.get_History_LoanStatus("get"));
			updateDataSheet("History_BalanceStatus", objCustomerLoanHistory_Page.get_History_BalanceStatus("get"));
			updateDataSheet("History_NextDueDate", objCustomerLoanHistory_Page.get_History_NextDueDate("get"));
			updateDataSheet("History_LatestPaymentDate",
					objCustomerLoanHistory_Page.get_History_LatestPaymentDate("get"));
			updateDataSheet("History_DefaultDate", objCustomerLoanHistory_Page.get_History_DefaultDate("get"));
			updateDataSheet("History_WriteOffDate", objCustomerLoanHistory_Page.get_History_WriteOffDate("get"));
			updateDataSheet("History_BankruptcyStatus",
					objCustomerLoanHistory_Page.get_History_BankruptcyStatus("get"));
			updateDataSheet("History_LoanNbr", objCustomerLoanHistory_Page.get_History_LoanNbr("get"));
			updateDataSheet("History_RenewalFlag", objCustomerLoanHistory_Page.get_History_RenewalFlag("get"));
			updateDataSheet("History_RenewalDate", objCustomerLoanHistory_Page.get_History_RenewalDate("get"));
			updateDataSheet("History_OutforRepo", objCustomerLoanHistory_Page.get_History_OutforRepo("get"));

			updateDataSheet("th_titleRenewal_PmtDate1",
					objCustomerLoanHistory_Page.get_th_titleRenewal_PmtDate1("get"));
			updateDataSheet("th_titleRenewal_PmtDate2",
					objCustomerLoanHistory_Page.get_th_titleRenewal_PmtDate2("get"));
			updateDataSheet("th_titleRenewal_PmtDate3",
					objCustomerLoanHistory_Page.get_th_titleRenewal_PmtDate3("get"));
			updateDataSheet("th_titleRenewal_PmtDate4",
					objCustomerLoanHistory_Page.get_th_titleRenewal_PmtDate4("get"));
			updateDataSheet("th_titleRenewal_PmtDate5",
					objCustomerLoanHistory_Page.get_th_titleRenewal_PmtDate5("get"));

		} else if (data("th_LoanType").toUpperCase().equals("LOC")) {
			updateDataSheet("History_CustomerName", objCustomerLoanHistory_Page.get_th_loc_CustomerName("get"));
			updateDataSheet("th_LineStatus", objCustomerLoanHistory_Page.get_th_loc_LineStatus("get"));
			updateDataSheet("th_PastDueAmount",
					objCustomerLoanHistory_Page.get_th_loc_PastDueAmount("get").replace("$", ""));
			updateDataSheet("th_loc_NextStatementDate",
					objCustomerLoanHistory_Page.get_th_loc_NextStatementDate("get"));
			updateDataSheet("th_loc_DueDate", objCustomerLoanHistory_Page.get_th_loc_DueDate("get"));
			updateDataSheet("history_PayFrequency", objCustomerLoanHistory_Page.get_th_loc_PayFrequency("get"));
			updateDataSheet("th_loc_PaymentStatus", objCustomerLoanHistory_Page.get_th_loc_PaymentStatus("get"));
			updateDataSheet("th_loc_DelinquentDate", objCustomerLoanHistory_Page.get_th_loc_DelinquentDate("get"));
			updateDataSheet("th_loc_LoaninCurePeriod", objCustomerLoanHistory_Page.get_th_loc_LoaninCurePeriod("get"));
			updateDataSheet("th_loc_CurePeriodEndDate",
					objCustomerLoanHistory_Page.get_th_loc_CurePeriodEndDate("get"));
        
		} else if (data("th_LoanType").toUpperCase().equals("INSTALLMENT")) {
			updateDataSheet("Ith_Customername", objCustomerLoanHistory_Page.get_Ith_Customername("get"));
			updateDataSheet("Ith_Nextduedate",
					objCustomerLoanHistory_Page.get_Ith_Nextduedate("get").replace("$", ""));
			//updateDataSheet("Ith_Payfrequency", objCustomerLoanHistory_Page.get_Ith_Payfrequency("get"));
			//updateDataSheet("Ith_Loannumber", objCustomerLoanHistory_Page.get_Ith_Loannumber("get"));
			updateDataSheet("Ith_PaymentStatus", objCustomerLoanHistory_Page.get_Ith_PaymentStatus("get"));
			//updateDataSheet("Ith_LoanInCurePeriod", objCustomerLoanHistory_Page.get_Ith_LoanInCurePeriod("get"));
			updateDataSheet("Ith_CurePeriodEndDate", objCustomerLoanHistory_Page.get_Ith_CurePeriodEndDate("get"));
			
			
		} else if (data("th_LoanType").toUpperCase().equals("PAYDAY")) {
			updateDataSheet("History_CustomerName", objCustomerLoanHistory_Page.get_History_CustomerName("get"));
			updateDataSheet("history_MigrationSource", objCustomerLoanHistory_Page.get_History_MigrationSource("get"));

			updateDataSheet("History_LoanStatus", objCustomerLoanHistory_Page.get_History_LoanStatus("get"));
			updateDataSheet("History_CheckStatus", objCustomerLoanHistory_Page.get_History_CheckStatus("get"));
			updateDataSheet("History_NextDueDate", objCustomerLoanHistory_Page.get_History_NextDueDate("get"));
			updateDataSheet("History_LoanDate", objCustomerLoanHistory_Page.get_History_LoanDate("get"));

			updateDataSheet("History_DefaultDate", objCustomerLoanHistory_Page.get_History_DefaultDate("get"));
			updateDataSheet("History_WriteOffDate", objCustomerLoanHistory_Page.get_History_WriteOffDate("get"));
			updateDataSheet("History_BankruptcyStatus",
					objCustomerLoanHistory_Page.get_History_BankruptcyStatus("get"));
			updateDataSheet("History_LoanNbr", objCustomerLoanHistory_Page.get_History_LoanNbr("get"));

		} else {

		}

	}

	public void emailDocumentDelivery() throws Exception, Exception {

		CustomerLoanHistory_PO objCustomerLoanHistory_Page = new CustomerLoanHistory_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Cust_nbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		assertAreEqual("Verifying the Email Constent Descrption", report,
				objCustomerLoanHistory_Page.get_email_ConstentHistory_Desc("EmailConst_Desc"), data("EmailConst_Desc"));
		assertAreEqual("Verifying the Email Constent Status", report,
				objCustomerLoanHistory_Page.get_email_ConstentHistory_Status("EmailConst_Status"),
				data("EmailConst_Status"));
		assertAreEqual("Verifying the Email Constent Response", report,
				objCustomerLoanHistory_Page.get_email_ConstentHistory_Response("EmailConst_Resp"),
				data("EmailConst_Resp"));

	}

	/*
	 * public void collections_TransLoanHistory() throws Exception {
	 * CustomerLoanHistory_PO objCustomerLoanHistory_Pages = new
	 * CustomerLoanHistory_PO(driver, report);
	 * 
	 * boolean bFound = false; for (String col : allProcessData.keySet()) {
	 * 
	 * if (col.equals("collections_TransLoanHistory.History_CustomerName")) { bFound
	 * = true; }
	 * 
	 * if (!allProcessData.get(col).isEmpty()) { if (bFound) { if
	 * (col.contains("EOC")) { bFound = false;
	 * objBorrower_Collections_PO.closeWindow();
	 * objBorrower_Collections_PO.switchToParentWindow(); } String Excpected =
	 * allProcessData.get(col); String Actual = (String)
	 * objCustomerLoanHistory_Pages.getClass() .getDeclaredMethod("get_" +
	 * col.replace("collections_TransLoanHistory.", ""), String.class)
	 * .invoke(objCustomerLoanHistory_Pages, allProcessData.get(col));
	 * verifyAreEqual("Verify Field[" + col + "] value", report, Excpected,
	 * Actual.trim());
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

}
