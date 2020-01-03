package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_QAJobs_ProcessDateChange_PO;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.PayDayLaon_PO;
import pageClasses.QFund.QfundAdmin_Navigation;
import pageClasses.QFund.Qfund_Navigation;

public class PayDayLoan_PR extends Helper {

	public PayDayLoan_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);
	}

	public void payDayLoan() throws Exception {

		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		objPayDayLaon_PO.set_payDay_CollateralType(data("payDay_CollateralType"));
		
		assertAreEqual("Verifying Message", report,
				objPayDayLaon_PO.get_payDay_NoBankAlertMsg(data("payDay_NoBankAlertMsg")),
				data("payDay_NoBankAlertMsg"));
		
		assertAreEqual("Before submission ",report,objPayDayLaon_PO.isDisplayed_payDay_EligibilityButton(), true);

		objPayDayLaon_PO.click_payDay_EligibilityButton(data("payDay_EligibilityButton"));
		verifyAreEqual("Verifying Applicant has been denied Message", report,
				objPayDayLaon_PO.checkApplicationDeniedMsg(data("payDay_EligibilityErrorMsg")), true);
		// objPayDayLaon_PO.set_payDay_LoanAmount(data("payDay_LoanAmount"));
		// objPayDayLaon_PO.set_payDay_DueDateMonth(data("payDay_DueDateMonth"));
		// objPayDayLaon_PO.set_payDay_DueDateDay(data("payDay_DueDateDay"));
		// objPayDayLaon_PO.set_payDay_DueDateYear(data("payDay_DueDateYear"));
		// objPayDayLaon_PO.set_payDay_RoutingNo(data("payDay_RoutingNo"));
		// objPayDayLaon_PO.set_payDay_CheckingAccountNo(data("payDay_CheckingAccountNo"));
		objPayDayLaon_PO.set_payDay_DisbType(data("payDay_DisbType"));

		if (data("payDay_DisbAmount").equalsIgnoreCase("LoanAmount")) {
			objPayDayLaon_PO.set_payDay_DisbAmount(objPayDayLaon_PO.get_payDay_LoanAmount("get"));
		} else {
			objPayDayLaon_PO.set_payDay_DisbAmount(data("payDay_DisbAmount"));
		}

		objPayDayLaon_PO.set_payDay_ElectronicCommunicationConsent(data("payDay_ElectronicCommunicationConsent"));
		if (data("payDay_DisbType").equals("Check")) {
			objPayDayLaon_PO.set_payDay_noOfChecks(data("NoOfChecks"));
			objPayDayLaon_PO.set_payDay_checkNo(data("CheckNo"));
			objPayDayLaon_PO.set_payDay_UserPassword(data("payDay_UserPassword"));
			assertAreEqual("verify payDay_FinishLoanButton",report,objPayDayLaon_PO.isDisplayed_payDay_FinishLoanButton(),true);

			objPayDayLaon_PO.click_payDay_FinishLoanButton(data("payDay_FinishLoanButton"));
			objPayDayLaon_PO.click_payDay_ProcessLaon(data("payDay_ProcessLaon"));

		} else {
			objPayDayLaon_PO.set_payDay_UserPassword(data("payDay_UserPassword"));
			assertAreEqual("verify payDay_FinishLoanButton",report,objPayDayLaon_PO.isDisplayed_payDay_FinishLoanButton(),true);
			
			objPayDayLaon_PO.click_payDay_FinishLoanButton(data("payDay_FinishLoanButton"));
			objPayDayLaon_PO.click_payDay_ProcessLaon(data("payDay_ProcessLaon"));
			objPayDayLaon_PO.acceptPrinterPopUp();
		}
		// new AppalicationSearch_PO(driver,
		// report).NavigateToSearchTransAndGetLoanID("Customer_Nbr",data("CustNbr"));
	}

	public void RPPEnrolment() throws Exception {
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		objPayDayLaon_PO.acceptAlert();
		objPayDayLaon_PO.click_rpp_next_btn(data("next_btn"));
		objPayDayLaon_PO.set_rpp_password(data("rpp_password"));
		//assertAreEqual("Before submission ",report,objPayDayLaon_PO.isDisplayed_rpp_finsish_paymentplan(), true);
		objPayDayLaon_PO.click_rpp_finsish_paymentplan(data("finsish_paymentplan"));
		if (!data("alert_message").isEmpty()) {
			assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
					objPayDayLaon_PO.getAlertText(data("alert_message").trim()),
					data("alert_message").trim());
		}
		objPayDayLaon_PO.click_rpp_Yes_btn(data("rpp_Yes_btn"));
	}

	public void voidRPPEnrolment() throws Exception, Exception {
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		objPayDayLaon_PO.set_rpp_VoidPassword(data("rppPassword"));
		//assertAreEqual("Before submission ",report,objPayDayLaon_PO.isDisplayed_rpp_VoidPymentPlan(), true);
		objPayDayLaon_PO.click_rpp_VoidPymentPlan(data("VoidPaymentPlan"));
		if (!data("alert_message").isEmpty()) {
			assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
					objPayDayLaon_PO.getAlertText(data("alert_message").trim()),
					data("alert_message").trim());
		}
	}

	public void scheduleACH() throws Exception, Exception {
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		objPayDayLaon_PO.set_scheduleACH_Password(data("scheduleACH_Password"));
		//assertAreEqual("Before submission ",report,objPayDayLaon_PO.isDisplayed_reschdule_Payment(), true);
		objPayDayLaon_PO.click_reschdule_Payment(data("click_reschdule_Payment"));
	}

	public void initiateRPPdefaultReturn() throws Exception {
		AdminTransaction_QAJobs_ProcessDateChange_PO Obj_AdminTransaction_QAJobs_ProcessDateChange_PO = new AdminTransaction_QAJobs_ProcessDateChange_PO(
				driver, report);
		QfundAdmin_Navigation.Transactions_Tab.ACH.GreenBank.ACH_GreenBank_GreenBankNACHAfile();
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Date(Obj_AdminTransaction_QAJobs_ProcessDateChange_PO
				.set_Add_DateMMDDYYYY(data("PDC_Date"), data("PDC_AddDays")));
		/*
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Month(data(
		 * "PDC_Month"));
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Day(data(
		 * "PDC_Day"));
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Year(data(
		 * "PDC_Year"));
		 */
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.click_PDC_SubmitButton(data("PDC_SubmitButton"));
	}

	public void checkACHStatus() throws Exception {
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		Qfund_Navigation.Loan_Transaction.Transactions();
		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("CustNbr"), "Y");
		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_Selection"));
		assertAreEqual("Verifying Message", report, objPayDayLaon_PO.get_ACH_Status("Get"), data("ACHstatus"));

	}

	public void adminACHreturn() throws Exception {
		PayDayLaon_PO objPayDayLaon_PO = new PayDayLaon_PO(driver, report);
		QfundAdmin_Navigation.Transactions_Tab.ACH.PaydayLoan.ACH_PaydayLoan_ACHreturn();
		objPayDayLaon_PO.set_ACHreturn_StoreNO(data("ACHreturn_StoreNO"));
		objPayDayLaon_PO.click_ACHReturn_Submitbtn(data("ACHReturn_Submitbtn"));
		objPayDayLaon_PO.click_CustNbr(data("CustNbr"));
		objPayDayLaon_PO.set_ACHReturn_CustReason(data("ACHReturn_CustReason"));
		//assertAreEqual("Before submission ",report,objPayDayLaon_PO.isDisplayed_FinishCustomerACHReturn(), true);
		objPayDayLaon_PO.click_FinishCustomerACHReturn(data("FinishCustomerACHReturn"));
	}
}