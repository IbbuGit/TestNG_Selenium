package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;
import pageClasses.QFund.TitleLoan_VoidResind_PO;

/**
 * @author VSankar
 *
 */
public class TitleLoan_VoidResind_PR extends Helper {

	public TitleLoan_VoidResind_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	/*--------------------------------------------------------------------------------------------------
	 *          Process Name                  : void_Origination
	 *          Test data sheet Name    	   : void_Origination    
	 *          Description                   : To Void or rescind the title loan    
	 *          Prerequisite                  : Existing title loan for a customer    
	 *          Verification Points           : Verify whether title loan is voided or rescind    
	 *          Output values                 :     
	 *          Responsible                   : VSankar   
	 *          Date Created                  : Jul 5, 2018 9:05:00 AM
	 *          Date Modified                 : Jul 5, 2018
	 *  --------------------------------------------------------------------------------------------------
	 */
	public void voidRescindTitleLoan() throws Exception{

		TitleLoan_VoidResind_PO objTitleLoan_VoidResind= new TitleLoan_VoidResind_PO(driver, report);
		
		Qfund_Navigation.Loan_Transaction.Transactions();
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",data("Cust_nbr"),"Y");
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		//assertAreEqual("Transaction selection page",report,objTitleLoan_VoidResind.get_TransactionSelectionPage(data("Transactionpage")),data("Transactionpage"));
		/*objTitleLoan_VoidResind.set_TitleLoan_Transaction_type(data("type"));
		objTitleLoan_VoidResind.click_CustomerForLoanNumber(data("Loan_nbr"));
		*/
		objTitleLoan_VoidResind.set_Transaction_tender_Type(data("DisbType"));
		objTitleLoan_VoidResind.set_Transaction_UserID_Pin(data("UserPassword"));
		objTitleLoan_VoidResind.click_Transaction_FinishVoidLoan(data("Transaction_FinishVoidLoan"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objTitleLoan_VoidResind.get_ErrorMsg(data("alert_message")),data("alert_message"));
		objTitleLoan_VoidResind.acceptAlert();
		Thread.sleep(5000);
		if(data("Trans_Selection").equals("Void")){
			assertAreEqual("Assertion for Void or rescind loan process",report,objTitleLoan_VoidResind.verifyText(),data("VerifyVoidText")); 
		}else{
			assertAreEqual("Assertion for Void or rescind loan process",report,objTitleLoan_VoidResind.verifyText(),data("VerifyRescindText"));
		}

	}

}

