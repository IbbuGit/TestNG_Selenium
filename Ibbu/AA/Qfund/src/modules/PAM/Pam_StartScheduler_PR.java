package modules.PAM;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.PAM.PAM_AccountManagement_StartSchedulers_PO;
import pageClasses.QFund.Qfund_Navigation;

public class Pam_StartScheduler_PR extends Helper {

	//constructor
	public Pam_StartScheduler_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);

	}
	
	//main method
	public void pamStartScheduler() throws Exception {
	
		//Navigate to the menu option Account Management>Start Schedulers
		Qfund_Navigation.Account_Management.Start_Schedulers();
		
		//create object for the object page
		PAM_AccountManagement_StartSchedulers_PO objAM_SS_PO = new PAM_AccountManagement_StartSchedulers_PO(driver, report);
		
		//Page Name Check //page verification
		assertAreEqual("Page Name Check", report, objAM_SS_PO.get_startScheduler_Header(data("SS_Header")),data("SS_Header"));

		//Select values for the options on the page
		objAM_SS_PO.set_scheduleName(data("SS_ScheduleName"));
		objAM_SS_PO.set_storeCode(data("SS_StoreCode"));
		objAM_SS_PO.set_dateMonth(data("SS_ToDateMonth"));
		objAM_SS_PO.set_dateDay(data("SS_ToDateDay"));
		objAM_SS_PO.set_dateYear(data("SS_ToDateYear"));
		objAM_SS_PO.click_runScheduler_button("Y");
	}	
}