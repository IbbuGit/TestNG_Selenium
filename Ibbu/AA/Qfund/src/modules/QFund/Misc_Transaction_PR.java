package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.MiscDisbursement_PO;
import pageClasses.QFund.MiscReceipts_PO;
import pageClasses.QFund.Qfund_Navigation;

public class Misc_Transaction_PR extends Helper{


	public Misc_Transaction_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}
	
	
	public void MiscReceipts() throws Exception{
		
		Qfund_Navigation.Misc_Transactions.Misc_Receipts.Miscellaneous_Receipts();
		
		MiscReceipts_PO objMOR_PO=new MiscReceipts_PO(driver,report);
		
		assertAreEqual("Verification Point", report, objMOR_PO.get_MOR_Header(data("MOR_Header")), data("MOR_Header"));
		
		objMOR_PO.set_MOR_Receipt_Type(data("MOR_Receipt_Type"));
		objMOR_PO.set_MOR_LastName(data("MOR_LastName"));
		objMOR_PO.set_MOR_FirstName(data("MOR_FirstName"));
		objMOR_PO.set_MOR_MiddleName(data("MOR_MiddleName"));
		objMOR_PO.set_MOR_CustIdType(data("MOR_CustIdType"));
		objMOR_PO.set_MOR_IDNbr_SSN1(data("MOR_IDNbr_SSN1"));
		objMOR_PO.set_MOR_IDNbr_SSN2(data("MOR_IDNbr_SSN2"));
		objMOR_PO.set_MOR_IDNbr_SSN3(data("MOR_IDNbr_SSN3"));
		objMOR_PO.set_MOR_IDNbr_ITIN1(data("MOR_IDNbr_ITIN1"));
		objMOR_PO.set_MOR_IDNbr_ITIN2(data("MOR_IDNbr_ITIN2"));
		objMOR_PO.set_MOR_IDNbr_ITIN3(data("MOR_IDNbr_ITIN3"));
		objMOR_PO.set_MOR_ID_Alien(data("MOR_ID_Alien"));
		objMOR_PO.set_MOR_ID_Foreign(data("MOR_ID_Foreign"));
		objMOR_PO.set_MOR_PrimaryPhone_Nbr1(data("MOR_PrimaryPhone_Nbr1"));
		objMOR_PO.set_MOR_PrimaryPhone_Nbr2(data("MOR_PrimaryPhone_Nbr2"));
		objMOR_PO.set_MOR_PrimaryPhone_Nbr3(data("MOR_PrimaryPhone_Nbr3"));
		objMOR_PO.set_MOR_CtrlNbr(data("MOR_CtrlNbr"));
		String Price=objMOR_PO.set_MOR_Price(data("MOR_Price"));
		objMOR_PO.set_MOR_OtherFee(data("MOR_OtherFee"));
		objMOR_PO.set_MOR_TotalAmtDue(data("MOR_TotalAmtDue"));
		objMOR_PO.set_MOR_PayAmt(data("MOR_PayAmt"));
		
		if(data("MOR_TendAmt").equals("MOR_Price")) {
			objMOR_PO.set_MOR_TendAmt(Price);
		}else {objMOR_PO.set_MOR_TendAmt(data("MOR_TendAmt"));}
		
		objMOR_PO.set_MOR_Tender_Type(data("MOR_Tender_Type"));
		objMOR_PO.set_MOR_Change(data("MOR_Change"));
		objMOR_PO.set_MOR_Username(data("MOR_Username"));
		objMOR_PO.set_MOR_Password(data("MOR_Password"));
		
		objMOR_PO.click_MOR_Cancel_Button(data("MOR_Cancel_Button"));
		objMOR_PO.click_MOR_Submit_Button(data("MOR_Submit_Button"));
		
		assertAreEqual("Verification Point for tarnsaction success msg", report, 
				objMOR_PO.click_MOR_Transaction_CompletedSuccessfully_OK_Btn(data("MOR_Transaction_CompletedSuccessfully_OK_Btn")),true);
		
		Qfund_Navigation.Misc_Transactions.Misc_Receipts.Miscellaneous_Receipts();	
		
		objMOR_PO.set_MOR_Receipt_Type(data("MOR_Receipt_Type"));

		objMOR_PO.click_MOR_History_Button(data("MOR_History_Button"));
		
		assertAreEqual("Verification Point for created MOR record:", report, objMOR_PO.verify_MOR_RecordInHistoryTable(Price),true);

	}


	public void MiscDisbursement() throws Exception{
		
		Qfund_Navigation.Misc_Transactions.Misc_Disbursement.Other_Disbursements();
		
		MiscDisbursement_PO objMiscsDisbursement_PO	=	new MiscDisbursement_PO(driver,report);
		
		assertAreEqual("Page Verification Point", report, objMiscsDisbursement_PO.get_MD_Header(data("MD_Header")), data("MD_Header"));

		objMiscsDisbursement_PO.set_MD_Amt(data("MD_Amt"));
		objMiscsDisbursement_PO.set_MD_Disbursement_Type(data("MD_Disbursement_Type"));		
		String Comments=objMiscsDisbursement_PO.set_MD_Comments(data("MD_Comments"));
		objMiscsDisbursement_PO.set_MD_Username(data("MD_Username"));
		objMiscsDisbursement_PO.set_MD_PIN(data("MD_PIN"));
		objMiscsDisbursement_PO.set_MD_Banker_PIN(data("MD_Banker_PIN"));
				
		objMiscsDisbursement_PO.click_MD_FinishMiscDisbursements_Button(data("MD_FinishMiscDisbursements_Button"));
		objMiscsDisbursement_PO.click_MD_Cancel_Button(data("MD_Cancel_Button"));
		
		assertAreEqual("Verification Point for tarnsaction success msg", report, 
				objMiscsDisbursement_PO.click_MD_Transaction_CompletedSuccessfully_OK_Btn(data("MD_Transaction_CompletedSuccessfully_OK_Btn")),true);
		
		Qfund_Navigation.Misc_Transactions.Misc_Disbursement.Other_Disbursements();	

		objMiscsDisbursement_PO.click_MD_History_Button(data("MD_History_Button"));
		
		//assertAreEqual("Verification Point for created MD record:", report, objMiscsDisbursement_PO.verify_MD_RecordInHistoryTable(Comments),true);

		
		assertAreEqual("Verification Point that we land on the Page", report, objMiscsDisbursement_PO.Confirm_MD_Header(),true);


	}



}