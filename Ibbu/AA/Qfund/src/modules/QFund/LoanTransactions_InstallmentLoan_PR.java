package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.InstallmentLoan_po;
import pageClasses.QFund.InstallmentLoanpayments_po;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransactions_InstallmentLoan_PR extends Helper{
	
	public LoanTransactions_InstallmentLoan_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}
	

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: InstallmentLoan
	 * 		Test data sheet Name	: InstallmentLoan
	 * 		Description				: This module covers InstallmentLoan origination	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User is in installment loan page	
	 * 		Output values			: NA
	 * 		Responsible				: chandra sekhar boddi	
	 * 		Date Created			: jan 31, 2019 12:32:28 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */
	
	
	public void InstallmentLoan() throws Exception{
	      
		InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
		
		objInstallmentLoan_po.set_ExpectedPaymentMethod_dropdown(data("ExpectedPaymentMethod"));
		objInstallmentLoan_po.click_Eligibility_btn(data("Eligibility"));
		objInstallmentLoan_po.acceptAlert();
		objInstallmentLoan_po.click_NegotiateLoanAmt_btn(data("NegotiateLoanAmt"));
		objInstallmentLoan_po.switchToChildWindow();
		if(objInstallmentLoan_po.isDisplayed_SelectNoOfInstallments()) {
		   objInstallmentLoan_po.click_SelectNoOfInstallments(data("SelectNoOfInstallments"));
		}else {
			objInstallmentLoan_po.click_SelectNoOfInstallments2(data("SelectNoOfInstallments2"));
		}
		objInstallmentLoan_po.closeWindow();
		objInstallmentLoan_po.switchToParentWindow();
		objInstallmentLoan_po.set_DispType_dropdown(data("DispType"));
		objInstallmentLoan_po.set_DispAmt_textbox(objInstallmentLoan_po.get_TotalDisbAmt("get"));
		objInstallmentLoan_po.set_ElectronicDocuments_dropdown(data("ElectronicDocuments"));
		if (data("DispType").equals("Check")) {
			objInstallmentLoan_po.set_NoOfCheck_dropdown(data("NoOfCheck"));
			
		}
		objInstallmentLoan_po.set_Pin_textbox(data("Pin"));
		objInstallmentLoan_po.click_FinishLoan_btn(data("FinishLoan"));
		if (data("lp_Controller").equalsIgnoreCase("Negative")) {
		assertAreEqual("Page Validation", report,objInstallmentLoan_po.getAlertText(), data("alert_message"));
		}
		
		if (!data("lp_Controller").equalsIgnoreCase("Negative")) {
			objInstallmentLoan_po.click_ConfirmInstallmentLoan_btn(data("ConfirmInstallmentLoan"));
			assertAreEqual("Assertion for InstallmentLoan completed successfully ", report,objInstallmentLoan_po.get_InstallmentLoanCompletedSuccessfully_message("get"),data("success_message"));
			objInstallmentLoan_po.click_InstallmentLoanCompletedSuccessfully_btn("InstallmentLoanCompletedSuccessfully");
			}
		
	}
	
	
	public void InstallmetLoanPayments() throws Exception {
		Qfund_Navigation.Loan_Transaction.Transactions();
		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
	     
    	InstallmentLoanpayments_po objInstallmentLoanpayments_po = new InstallmentLoanpayments_po(driver, report);
        if (data("PaymentType").equals("otheramount")) {
        	objInstallmentLoanpayments_po.click_PayAnyOtherAmt_btn(data("PayAnyOtherAmt"));
        	objInstallmentLoanpayments_po.set_PaymentAmt_textbox(data("PaymentAmt"));
		}
        if (data("PaymentType").equals("InstallmentAmount")) {
        	objInstallmentLoanpayments_po.click_PayInstallmentAmt_btn(data("PayInstallmentAmt"));
        	
		}
        if (data("PaymentType").equals("Payoff")) {
        	objInstallmentLoanpayments_po.click_PayOffTheBalance_btn(data("PayOffTheBalance"));
        }
       
    	objInstallmentLoanpayments_po.set_TenderType1_dropdown(data("TenderType1"));
    	objInstallmentLoanpayments_po.set_TenderAmt1_textbox(objInstallmentLoanpayments_po.get_PaymentAmt_textbox("get"));
    	objInstallmentLoanpayments_po.set_Pin_textbox(data("Pin"));
    	objInstallmentLoanpayments_po.click_Finish_btn(data("Finish"));
    	objInstallmentLoanpayments_po.acceptAlert();
    	if (data("PaymentType").equals("Payoff")) {
    		assertAreEqual("Assertion for EarlyPayoff message ", report,objInstallmentLoanpayments_po.get_Earlypayoff_message("get"),data("EarlyPayOff_message"));
    	}
    	if (data("PaymentType").equals("InstallmentAmount")) {
    		assertAreEqual("Assertion for InstallmentAmount successfull message ", report,objInstallmentLoanpayments_po.get_Transactionsuccessfull_message("get"),data("InstallmentAmount_message"));	
    	}
    	 if (data("PaymentType").equals("otheramount")) {
    		 assertAreEqual("Assertion for PayOtherAmount successfull message ", report,objInstallmentLoanpayments_po.get_Transactionsuccessfull_message("get"),data("PayotherAmount_message")); 
    	 }
    	objInstallmentLoanpayments_po.click_AnotherTransaction_btn("AnotherTransaction");
	}
    
	
	public void InstallmentLoan_Void() throws Exception {
		
		Qfund_Navigation.Loan_Transaction.Transactions();
		if(!data("Loan_nbr").isEmpty()) {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
		}else {
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		}
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

		InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
		
		objInstallmentLoan_po.set_Void_TenderType_drpdown(data("Void_TenderType"));
		objInstallmentLoan_po.set_Void_Pin_textbox(data("Void_Pin"));
		objInstallmentLoan_po.click_Void_Finish_btn(data("Void_Finish"));
		objInstallmentLoan_po.acceptAlert();
		assertAreEqual("Assertion for InstallmentLoan void successfully ", report,objInstallmentLoan_po.get_TransactionVoidedSuccessfully_message("get"),data("void_message"));
		objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");
	}
		
		public void InstallmentLoan_VoidPayments() throws Exception {
			
			Qfund_Navigation.Loan_Transaction.Transactions();
			if(!data("Loan_nbr").isEmpty()) {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
			}else {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
			}
			new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));

			InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
			objInstallmentLoan_po.set_DispType_dropdown(data("VoidPaymentDisbType"));
			objInstallmentLoan_po.set_Void_Pin_textbox(data("Void_Pin"));
			objInstallmentLoan_po.click_VoidEarlyPayOff_btn(data("VoidEarlyPayOff"));
			objInstallmentLoan_po.click_VoidPayment_btn(data("VoidPayment"));
			objInstallmentLoan_po.acceptAlert();
			assertAreEqual("Assertion for InstallmentLoan void successfully ", report,objInstallmentLoan_po.get_TransactionVoidedSuccessfully_message("get"),data("void_message"));
			objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");
		
		}
		  
		  
		public void Installment_DefaultPayment()throws Exception {
			
			Qfund_Navigation.Loan_Transaction.Transactions();
			if(!data("Loan_nbr").isEmpty()) {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
			}else {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
				new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
				
				InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
				if (!data("Trans_Selection").equals("RPP Payment")) {
					objInstallmentLoan_po.set_PaymentAmt_textbox(objInstallmentLoan_po.get_DefaultBalance_message("get"));
				}
				objInstallmentLoan_po.set_TenderType_drpdown(data("TenderType"));
				objInstallmentLoan_po.set_TenderAmt_textbox(objInstallmentLoan_po.get_PaymentAmt_textbox("get"));
				if (!data("TenderType").equals("Cash")) {
					String ccmoNbr= getRandomNumeric(9);
				objInstallmentLoan_po.set_CCMONumber_textbox(ccmoNbr);
				}
				if (!data("Trans_Selection").equals("RPP Payment")) {
					objInstallmentLoan_po.set_WORecoveryPin_Btn(data("WORecoveryPin"));
				}
				objInstallmentLoan_po.set_Pind_textbox(data("Pin"));
				objInstallmentLoan_po.click_Finish_btn(data("Finish"));
				objInstallmentLoan_po.acceptAlert();
				if(data("Trans_Selection").equals("Default Payment")) {
				String s= objInstallmentLoan_po.get_DefaultPaymentSuccessfull_message(data("DefaultPayment_message"));
				String[] a = s.split("\n");
				System.out.println(a[0]);
				assertAreEqual("Assertion for Default Payment successfull ", report,a[0],data("DefaultPayment_message"));
			}   if(data("Trans_Selection").equals("RPP Payment")) {
				String t= objInstallmentLoan_po.get_RPPPaymentSuccessfull_message(data("RPPPayment_message"));
				String[] b = t.split("\n");
				System.out.println(b[0]);
				assertAreEqual("Assertion for RPP Payment successfull ", report,b[0],data("RPPPayment_message"));
			}	if(data("Trans_Selection").equals("WO Recovery")) {
				String t= objInstallmentLoan_po.get_WORecoveryPaymentSuccessfull_message(data("WORecoveryPaymentSuccessfull"));
				String[] b = t.split("\n");
				System.out.println(b[0]);
				assertAreEqual("Assertion for WORecovery Payment successfull ", report,b[0],data("WORecoveryPaymentSuccessfull"));
			}
				objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");
			
		}
		}
			
		public void Installment_PaymentPlan()throws Exception {
				
			Qfund_Navigation.Loan_Transaction.Transactions();
			if(!data("Loan_nbr").isEmpty()) {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Loan_nbr", data("Loan_nbr"), "Click");
			}else {
				new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
				new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
				
				InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
				objInstallmentLoan_po.acceptAlert();
				objInstallmentLoan_po.click_Next_Btn(data("Next"));
				objInstallmentLoan_po.set_collateraltype_drpdwn(data("collateraltype"));
				objInstallmentLoan_po.set_PinPP_Btn(data("Pin"));
				objInstallmentLoan_po.click_FinishPaymentPlan_btn(data("FinishPaymentPlan"));
				objInstallmentLoan_po.click_ConfirmPP_btn(data("ConfirmPP"));
				String s= objInstallmentLoan_po.get_PaymentPlan_message(data("PaymentPlan_message"));
				String[] a = s.split("\n");
				System.out.println(a[0]);
				assertAreEqual("Assertion for Payment Paln successfull ", report,a[0],data("PaymentPlan_message"));
				objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");
			
			}
		}	
	
           public void Installment_VoidPP()throws Exception {
			
			Qfund_Navigation.Loan_Transaction.Transactions();
			new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
			new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
			InstallmentLoan_po objInstallmentLoan_po= new InstallmentLoan_po(driver, report);
   			objInstallmentLoan_po.set_VoidPinPP_textbox(data("VoidPinPP"));
   			if(data("VoidRPPPaymentSuccessfull").equals("Void RPP Payment  Completed Successfully.")) {
   				objInstallmentLoan_po.click_VoidFinishRP_Btn(data("VoidFinishRP"));
   				String s= objInstallmentLoan_po.get_VoidRPPPaymentSuccessfull_message(data("VoidRPPPaymentSuccessfull"));
   				String[] a = s.split("\n");
   				assertAreEqual("Assertion for Void Payment Paln successfull ", report,a[0],data("VoidRPPPaymentSuccessfull"));
   				objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");	
   				
   			}
			objInstallmentLoan_po.click_VoidFinishPP_Btn(data("VoidFinishPP"));;
			String s= objInstallmentLoan_po.get_VoidPP_message(data("VoidPP_message"));
			String[] a = s.split("\n");
			assertAreEqual("Assertion for Void Payment Paln successfull ", report,a[0],data("VoidPP_message"));
			objInstallmentLoan_po.click_Anothertransaction_btn("Anothertransaction");	
           }
}
		
				
		
			
			
		
		


