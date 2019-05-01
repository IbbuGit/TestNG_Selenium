package modules.QFund;

import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import framework.Helper;
import pageClasses.QFund.CashManagement_SafeAssign_PO;
import pageClasses.QFund.Qfund_Navigation;

public class AdminSafeAndDrawerDessign_PR extends Helper {
	
	String storeNo;
	public AdminSafeAndDrawerDessign_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		
	}
	
	public void GetStoreNo() throws Exception {
		
		CashManagement_SafeAssign_PO objCashManagement_SafeAssign_PO= new CashManagement_SafeAssign_PO(driver, report);
		Qfund_Navigation.Cash_Management.Safe.Assign();
		if (objCashManagement_SafeAssign_PO.isDisplayed_sa_CountOf100Dollar()) {
			assertAreEqual("Safe is already assigned", report,true,true);
		}
		else {
			if(objCashManagement_SafeAssign_PO.isDisplayed_sa_IPD_NextButton()) {
				objCashManagement_SafeAssign_PO.click_sa_IPD_NextButton("Y");
				assertAreEqual("Before submission ",report,objCashManagement_SafeAssign_PO.isDisplayed_sa_IPDY_YesButton(), true);
				objCashManagement_SafeAssign_PO.click_sa_IPDY_YesButton("Y");				
				Qfund_Navigation.Cash_Management.Safe.Assign();
			}
			
			if(objCashManagement_SafeAssign_PO.getVisibleObjForAssign().equals("Assigned")) {
				updateDataSheet("SafeStoreNo", data("LoginStore"));
			}
			else {
				storeNo= objCashManagement_SafeAssign_PO.get_safeAssignedStoreNo("Get").replace("The logged-in user is currently assigned to Safe in Store", "").replace(".", "").trim();
				System.out.println(storeNo);
				updateDataSheet("SafeStoreNo", storeNo);
			}
			
		
	}
	}
}
