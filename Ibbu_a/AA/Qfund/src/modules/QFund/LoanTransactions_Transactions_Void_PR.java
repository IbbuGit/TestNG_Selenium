package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;
import pageClasses.QFund.Void_LoanPayment_PO;

public class LoanTransactions_Transactions_Void_PR extends Helper{

	public LoanTransactions_Transactions_Void_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void voidPayment() throws Exception {		
		
		Qfund_Navigation.Loan_Transaction.Transactions();
		
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr",data("Cust_nbr"),"Y");
		
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));	
		Void_LoanPayment_PO objVoid_LoanPayment_PO=new Void_LoanPayment_PO(driver, report); 
		objVoid_LoanPayment_PO.set_Disbursment_type(data("Disbursment_type"));
		objVoid_LoanPayment_PO.set_Drawer_PIN_Input(data("Drawer_PIN"));
		objVoid_LoanPayment_PO.click_VoidLnPymn_Button(data("VoidLnPymn_Button"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objVoid_LoanPayment_PO.getAlertTextmsg(data("alert_message")),data("alert_message"));
		objVoid_LoanPayment_PO.click_Renew_Loanbtn(data("Renew_Loanbtn"));
		Thread.sleep(4000);
		assertAreEqual("Verifyig payment process message", report, objVoid_LoanPayment_PO.get_LnPymnt_Confirm_Text("LnPymnt_Confirm_Text"), data("LnPymnt_Confirm_Text"));
		objVoid_LoanPayment_PO.click_CompOk_btn(data("CompOk_btn"));
	}

}
