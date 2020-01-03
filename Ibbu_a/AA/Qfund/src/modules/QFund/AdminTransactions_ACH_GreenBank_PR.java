
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_ACH_GreenBank_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransactions_ACH_GreenBank_PR extends Helper {

	public AdminTransactions_ACH_GreenBank_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void admin_ACH_GreenBankNACHAfile() throws Exception {
		AdminTransaction_ACH_GreenBank_PO Obj_AdminTransactions_ACH_GreenBank_PO = new AdminTransaction_ACH_GreenBank_PO(
				driver, report);

		QfundAdmin_Navigation.Transactions_Tab.ACH.GreenBank.ACH_GreenBank_GreenBankNACHAfile();

		/*
		 * Validation of screen
		 */
		assertAreEqual("Page Verification", report,
				Obj_AdminTransactions_ACH_GreenBank_PO.get_GBNF_Header(data("GBNF_Header")), data("GBNF_Header"));

		/*
		 * Process Date
		 */

		Obj_AdminTransactions_ACH_GreenBank_PO.set_GBNF_Date(
				Obj_AdminTransactions_ACH_GreenBank_PO.set_Add_DateMMDDYYYY(data("GBNF_Date"), data("GBNF_AddDays")));

		assertAreEqual("verify SubmitButton", report,
				Obj_AdminTransactions_ACH_GreenBank_PO.isDisplayed_GBNF_SubmitButton(), true);

		Obj_AdminTransactions_ACH_GreenBank_PO.click_GBNF_SubmitButton(data("GBNF_SubmitButton"));

		/*
		 * Validation of screen
		 */
//		assertAreEqual("Your Transaction finished successful", report,
//				Obj_AdminTransactions_ACH_GreenBank_PO.get_GBNF_Validation(data("GBNF_Validation")).trim(),
//				data("GBNF_Validation"));

		Obj_AdminTransactions_ACH_GreenBank_PO.click_GBNF_Validation_OkButton(data("GBNF_Validation_OkButton"));

	}

}
