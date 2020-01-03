package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.ACHAuthorizationDetails_PO;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanACHRevokeAuthorize_PR extends Helper {

	public LoanACHRevokeAuthorize_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void paydayACH_Revoke_Authorize() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();				
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_ACH_Revoke"));
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_ACH_Auth"));
		
		ACHAuthorizationDetails_PO objACHAuthorizationDetails_PO = new ACHAuthorizationDetails_PO(driver,report);
		
		assertAreEqual("ACH Authorization Details Loaded successfully",report,objACHAuthorizationDetails_PO.verifyACH_AuthorizationPage(),true);
		

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
	
	public void loc_ACH_Revoke_Authorize() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();				
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_ACH_Revoke"));
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_ACH_Auth"));
		
		ACHAuthorizationDetails_PO objACHAuthorizationDetails_PO = new ACHAuthorizationDetails_PO(driver,report);
		
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
	public void loc_RCC_Revoke_Authorize() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();				
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_RCC_Revoke"));
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection_RCC_Auth"));
		
		ACHAuthorizationDetails_PO objACHAuthorizationDetails_PO = new ACHAuthorizationDetails_PO(driver,report);
		
		objACHAuthorizationDetails_PO.acceptAlert();
		  
		objACHAuthorizationDetails_PO.click_rcc_RevokeButton(data("RCC_Revoke"));
		
		 objACHAuthorizationDetails_PO.set_ABA_RoutingNum(data("ABA_Routing Nbr"));
		
		objACHAuthorizationDetails_PO.set_ConfirmABA_RoutingNum(data("ABA_Routing Nbr"));
		
		objACHAuthorizationDetails_PO.set_CheckAcctNum(data("Check_AccountNbr"));
		
		objACHAuthorizationDetails_PO.set_ConfirmCheckAcctNum(data("Check_AccountNbr"));
		
		objACHAuthorizationDetails_PO. set_pinTextBox(data("PIN"));
		
		objACHAuthorizationDetails_PO.click_rcc_AuthorizationButton(data("RCC_Authorization"));
		
		objACHAuthorizationDetails_PO.click_Ok_Button("Y");
		
		
		
		
		
}}