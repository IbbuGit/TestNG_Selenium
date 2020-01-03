package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_QAJobs_ProcessDateChange_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransaction_QAJobs_ProcessDateChange_PR extends Helper {

	public AdminTransaction_QAJobs_ProcessDateChange_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void adminProcessDateChange() throws Exception {

		AdminTransaction_QAJobs_ProcessDateChange_PO Obj_AdminTransaction_QAJobs_ProcessDateChange_PO = new AdminTransaction_QAJobs_ProcessDateChange_PO(
				driver, report);

		QfundAdmin_Navigation.Transactions_Tab.QAJobsTab.ProcessDateChange();

		/*
		 * Validation of screen
		 */
		assertAreEqual("Process Date Change Page", report,
				Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.get_ProcessDateChange_Header(data("PDC_Header")),
				data("PDC_Header"));

		/*
		 * Store Nbr
		 */
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_StoreNbr(data("PDC_StoreNbr"));

		/*
		 * Process Date
		 */
		String StrPDC_Date = Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Add_DateMMDDYYYY(data("PDC_Date"),data("PDC_AddDays"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Date(StrPDC_Date);
		updateDataSheet("ProcessingDate", StrPDC_Date);

		/*
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Month(data(
		 * "PDC_Month"));
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Day(data("PDC_Day"))
		 * ;
		 * Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Year(data("PDC_Year"
		 * ));
		 */

		assertAreEqual("verify SubmitButton", report,
				Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.isDisplayed_PDC_SubmitButton(), true);

		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.click_PDC_SubmitButton(data("PDC_SubmitButton"));

		/*
		 * Validation of screen
		 */
		assertAreEqual("Process Date Change Page", report,
				Obj_AdminTransaction_QAJobs_ProcessDateChange_PO
						.get_PDC_ProcessDateUpdatedSuccessfully(data("PDC_ProcessDateUpdatedSuccessfully")).trim(),
				data("PDC_ProcessDateUpdatedSuccessfully"));

		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO
				.click_PDC_UpdatedSuccess_OkButton(data("PDC_UpdatedSuccess_OkButton"));

	}

	public void storeStatusChange() throws Exception {

		AdminTransaction_QAJobs_ProcessDateChange_PO Obj_AdminTransaction_QAJobs_ProcessDateChange_PO = new AdminTransaction_QAJobs_ProcessDateChange_PO(
				driver, report);
		QfundAdmin_Navigation.Store_SetUp.StoreConfig.EditStore();

		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Edit_StoreNo(data("Edit_StoreNo"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.click_Edit_StoreNo_SubmitBtn(data("Edit_StoreNo_SubmitBtn"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Edit_StoreStatus(data("Edit_StoreStatus"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Edit_StoreStatus_RM(data("Edit_StoreStatus_RM"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Edit_StoreStatus_DVP(data("Edit_StoreStatus_DVP"));

		assertAreEqual("verify SubmitButton", report,
				Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.isDisplayed_Edit_StoreStatus_Submitbtn(), true);
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO
				.click_Edit_StoreStatus_Submitbtn(data("Edit_StoreStatus_Submitbtn"));

	}
	
	public void adminOnlineProcessDateChange() throws Exception {
		
		AdminTransaction_QAJobs_ProcessDateChange_PO Obj_AdminTransaction_QAJobs_ProcessDateChange_PO = new AdminTransaction_QAJobs_ProcessDateChange_PO(
				driver, report);
		QfundAdmin_Navigation.Transactions_Tab.QAJobsTab.OnlineProcessDateChange();
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_StoreNbr(data("PDC_StoreNbr"));
		String StrPDC_Date = Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Add_DateMMDDYYYY(data("PDC_Date"),data("PDC_AddDays"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Date(StrPDC_Date);
		updateDataSheet("ProcessingDate", StrPDC_Date);
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.click_PDC_SubmitButton(data("PDC_SubmitButton"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO
		.click_PDC_UpdatedSuccess_OkButton(data("PDC_UpdatedSuccess_OkButton"));

	}

}
