package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO;
import pageClasses.QFund.AdminTransaction_ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile_PO;
import pageClasses.QFund.AdminTransaction_ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransaction_OnlineEODProcess_PR extends Helper {

	//constructor
	public AdminTransaction_OnlineEODProcess_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	//Perform LOC Pre ACH Deposit Inserts on the admin side
	public void adminLOCPreACHDepositInserts() throws Exception{

		//Navigate the LOC Pre ACH Deposit Inserts menu option
		QfundAdmin_Navigation.Transactions_Tab.ACH.LOC.ACH_LOC_LOCpreACHdepositsInserts();
		
		//Create an object for the page
		AdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO	= new AdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO(driver,report);
		
		//page check
		assertAreEqual("Page Name Check", report, objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO.get_locPreACHDepositInsert_pageHeader(data("DI_Header")), data("DI_Header"));
		
		//input business date values
		objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO.set_businessDate_Month(data("DI_BusinessDate_BeginMonth"));
		objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO.set_businessDate_Day(data("DI_BusinessDate_BeginDay"));
		objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO.set_businessDate_Year(data("DI_BusinessDate_BeginYear"));

		//click on submit button
		objAdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO.click_submitButton(data("DI_SubmitButton"));
		
	}

	public void admnRCCPaymentBeforeDEFOrigFile() throws Exception {		
		
		//Navigation
		QfundAdmin_Navigation.Transactions_Tab.ACH.ACH_RCCPayments.ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile();
		
		//create an object for the page 
		AdminTransaction_ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile_PO objRCCPaymentsBeforeDEFOriginationFile_PO = new AdminTransaction_ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile_PO(driver,report);
	
		//page check
		assertAreEqual("Page Name Check", report, objRCCPaymentsBeforeDEFOriginationFile_PO.get_RCCPaymentsBeforeDEFOriginationFile_pageHeader(data("RCCPO_Header")), data("RCCPO_Header"));
		
		//input process date
		objRCCPaymentsBeforeDEFOriginationFile_PO.set_businessDate_Month(data("RCCPO_ProcessDate_BeginMonth"));
		objRCCPaymentsBeforeDEFOriginationFile_PO.set_businessDate_Month(data("RCCPO_ProcessDate_BeginDay"));
		objRCCPaymentsBeforeDEFOriginationFile_PO.set_businessDate_Year(data("RCCPO_ProcessDate_BeginYear"));
		
		//click on the submit button
		objRCCPaymentsBeforeDEFOriginationFile_PO.click_submitButton("Y");
	}


	/*
	 *QfundAdmin_Navigation needs to be corrected for this one. Update this information in it-
	 *	@FindBy(id = "503401") 
	 * Also the header needs to be added to the data file and test needs to be tested against UI
	 * 
	 */
	public void adminRCCPaymentAfterDEFOriginFile() throws Exception {		
		
		//Navigation
		QfundAdmin_Navigation.Transactions_Tab.ACH.ACH_RCCPayments.ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile();
		
		//create an object for the page 
		AdminTransaction_ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile_PO objRCCPaymentsAfterDEFOriginationFile_PO = new AdminTransaction_ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile_PO(driver,report);
	
		//page check
		assertAreEqual("Page Name Check", report, objRCCPaymentsAfterDEFOriginationFile_PO.get_RCCPaymentsAfterDEFOriginationFile_pageHeader(data("RCCPAO_Header")), data("RCCPAO_Header"));
				
		//input process date
		objRCCPaymentsAfterDEFOriginationFile_PO.set_businessDate_Month(data("RCCPAO_ProcessDate_BeginMonth"));
		objRCCPaymentsAfterDEFOriginationFile_PO.set_businessDate_Month(data("RCCPAO_ProcessDate_BeginDay"));
		objRCCPaymentsAfterDEFOriginationFile_PO.set_businessDate_Year(data("RCCPAO_ProcessDate_BeginYear"));
		
		//click on the submit button
		objRCCPaymentsAfterDEFOriginationFile_PO.click_submitButton("Y");
	}
	
		
	
}


