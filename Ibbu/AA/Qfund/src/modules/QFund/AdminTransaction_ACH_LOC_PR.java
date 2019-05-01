package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AdminTransaction_ACH_LOC_PO;
import pageClasses.QFund.AdminTransaction_QAJobs_ProcessDateChange_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransaction_ACH_LOC_PR extends Helper {

	public AdminTransaction_ACH_LOC_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void adminACHUnsecuredStatement() throws Exception {
		AdminTransaction_QAJobs_ProcessDateChange_PO Obj_AdminTransaction_QAJobs_ProcessDateChange_PO	=	new AdminTransaction_QAJobs_ProcessDateChange_PO(driver, report);
		
		QfundAdmin_Navigation.Transactions_Tab.ACH.LOC.ACH_LOC_UnsecureLOCStatement();
				
		//page check
		assertAreEqual(" Page header",report,Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.get_us_Header(data("us_Header")),data("us_Header"));

		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_us_StoreNbr(data("us_StoreNbr"));
		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_PDC_Date(Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.set_Add_DateMMDDYYYY(data("us_Date"),data("us_AddDays")) );

		assertAreEqual(" Before submission ",report,Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.isDisplayed_us_SubmitButton(), true);

		Obj_AdminTransaction_QAJobs_ProcessDateChange_PO.click_us_SubmitButton(data("us_SubmitButton"));
	}
	
	public void adminACHLOCDefaultLOC() throws Exception {

		AdminTransaction_ACH_LOC_PO objAdminTransaction_ACH_LOC_DefaultLOC_PO = new AdminTransaction_ACH_LOC_PO(
				driver, report);
		QfundAdmin_Navigation.Transactions_Tab.ACH.LOC.ACH_LOC_DefaultLOC();

		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsd_Header(data("locsd_Header"));
		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.isDisplayed_locsd_Header(data("locsd_Header"));

		assertAreEqual("Verification Point", report,
				objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsd_Header(data("locsd_Header")), data("locsd_Header"));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.set_locsd_StoreNbr(data("locsd_StoreNbr"));
		objAdminTransaction_ACH_LOC_DefaultLOC_PO.set_locsd_Date(objAdminTransaction_ACH_LOC_DefaultLOC_PO
				.set_Add_DateMMDDYYYY(data("locsd_Date"), data("locsd_AddDays")));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.click_locsd_SubmitButton(data("locsd_SubmitButton"));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.click_locsd_CancelButton(data("locsd_CancelButton"));

		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsd_Validation(data("locsd_Validation"));
		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.isDisplayed_locsd_Validation(data("locsd_Validation"));

		assertAreEqual("Verification Point", report,
				objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsd_Validation(data("locsd_Validation")),
				data("locsd_Validation"));

	}

	public void adminACHLOCWriteOffLOC() throws Exception {

		AdminTransaction_ACH_LOC_PO objAdminTransaction_ACH_LOC_DefaultLOC_PO = new AdminTransaction_ACH_LOC_PO(
				driver, report);
		
		QfundAdmin_Navigation.Transactions_Tab.ACH.LOC.ACH_LOC_WriteOffLOC();

		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsw_Header(data("locsw_Header"));
		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.isDisplayed_locsw_Header(data("locsw_Header"));

		assertAreEqual("Verification Point", report,
				objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsw_Header(data("locsw_Header")),
				data("locsw_Header"));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.set_locsw_StoreNbr(data("locsw_StoreNbr"));
		objAdminTransaction_ACH_LOC_DefaultLOC_PO.set_locsw_Date(objAdminTransaction_ACH_LOC_DefaultLOC_PO
				.set_Add_DateMMDDYYYY(data("locsw_Date"), data("locsw_AddDays")));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.click_locsw_SubmitButton(data("locsw_SubmitButton"));

		objAdminTransaction_ACH_LOC_DefaultLOC_PO.click_locsw_CancelButton(data("locsw_CancelButton"));

		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsw_Validation(data("locsw_Validation"));
		// objAdminTransaction_ACH_LOC_DefaultLOC_PO.isDisplayed_locsw_Validation(data("locsw_Validation"));

		assertAreEqual("Verification Point", report,
				objAdminTransaction_ACH_LOC_DefaultLOC_PO.get_locsw_Validation(data("locsw_Validation")),
				data("locsw_Validation"));

	}
}
