package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_EODBatchProcess_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransaction_EODBatchProcess_PR extends Helper {

	public AdminTransaction_EODBatchProcess_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void adminEODBatchProcess() throws Exception {

		AdminTransaction_EODBatchProcess_PO Obj_AdminTransaction_EODBatchProcess_PO = new AdminTransaction_EODBatchProcess_PO(
				driver, report);

		QfundAdmin_Navigation.Transactions_Tab.EODBatchProcess();

		/*
		 * Validation of screen
		 */
		assertAreEqual(
				"EOD Batch Process Page", report, Obj_AdminTransaction_EODBatchProcess_PO
						.get_EOD_BP_Admin_EODBatchProcess_Header(data("EOD_BP_Admin_Header")),
				data("EOD_BP_Admin_Header"));

		/*
		 * Store Nbr
		 * 
		 */

		Thread.sleep(1000);
		Obj_AdminTransaction_EODBatchProcess_PO.set_EOD_BP_Admin_StoreNbr(data("EOD_BP_Admin_StoreNbr"));

		/*
		 * Process Date
		 */

		Obj_AdminTransaction_EODBatchProcess_PO.set_EOD_BP_Admin_Date(
				Obj_AdminTransaction_EODBatchProcess_PO.set_Add_DateMMDDYYYY(data("EOD_Date"), data("EOD_AddDays")));

		// String strTemp_akula =
		// RandomStringUtils.randomAlphabetic(2)+RandomStringUtils.randomNumeric(6);
		// Obj_AdminTransaction_EODBatchProcess_PO.set_EOD_BP_Admin_Year(getRandomValue("Clean"));

		assertAreEqual(" Before submission ",report,Obj_AdminTransaction_EODBatchProcess_PO.isDisplayed_EOD_BP_Admin_SubmitButton(), true);
		
		Obj_AdminTransaction_EODBatchProcess_PO.click_EOD_BP_Admin_SubmitButton(data("EOD_BP_Admin_SubmitButton"));

		/*
		 * Validation of screen
		 */
		assertAreEqual("EOD Page", report,
				Obj_AdminTransaction_EODBatchProcess_PO
						.get_EOD_BP_Admin_ProcessDateUpdatedSuccessfully(data("EOD_BP_Admin_EODSuccess")).trim(),
				data("EOD_BP_Admin_EODSuccess").trim());

	}

}
