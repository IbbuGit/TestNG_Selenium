package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.CustomerLoanHistory_PO;
import pageClasses.QFund.LoanTransactions_TransactionSelection_PO;
import pageClasses.QFund.Qfund_Navigation;
import pageClasses.QFund.VehicleConditionReport_PO;

public class VehicleConditionReport_PR extends Helper {

	public VehicleConditionReport_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: transactions_vehicleConReport
	 * 		Test data sheet Name	: transactions_vehicleConReport
	 * 		Description				: This module verify the customer data regarding loan
	 * 		Prerequisite			: Customer should have any one loan	
	 * 		Verification Points		: At the beginning of the method to ensure script is running on right page
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Jul 5, 2018 9:00:31 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void transactionsVehicleConReport() throws Exception {
		CustomerLoanHistory_PO objCustomerLoanHistory_Page = new CustomerLoanHistory_PO(driver, report);

		Qfund_Navigation.Loan_Transaction.Transactions();

		new AppalicationSearch_PO(driver, report).searchByDetailsAndSelectLoan("Customer_Nbr", data("Customer_Nbr"), "Y");

		new LoanTransactions_TransactionSelection_PO(driver, report).transactionSelection(data("Trans_value"));
		objCustomerLoanHistory_Page.click_History_VCRForm("Y");

		VehicleConditionReport_PO objVehicleConditionReport = new VehicleConditionReport_PO(driver, report);
		objVehicleConditionReport.switchToChildWindow();
		assertAreEqual("Assertion for VCR info process", report,
				objVehicleConditionReport.verifyVisibilityOFvCR_TitleStatus(), true);
		boolean bFound = false;
		for (String col : allProcessData.keySet()) {

			if (col.equals("transactionsVehicleConReport.vCR_BorrowerSsnITIN")) {
				bFound = true;
			}

			if (bFound) {
				if (!allProcessData.get(col).isEmpty()) {
					String Excpected = allProcessData.get(col);
					if (col.toUpperCase().contains("VCR_")) {
						String Actual = (String) objVehicleConditionReport.getClass()
								.getDeclaredMethod("get_" + col.replace("transactionsVehicleConReport.", ""),
										String.class)
								.invoke(objVehicleConditionReport, allProcessData.get(col));
						verifyAreEqual("Verify Field[" + col + "] value", report, Excpected, Actual.trim());
						if (col.contains("vCR_TiresCondition")) {
							bFound = false;
						}
					}
				}
			}
		}
		objVehicleConditionReport.closeWindow();
		objVehicleConditionReport.switchToParentWindow();
	}

}
