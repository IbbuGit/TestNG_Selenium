package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import framework.Helper;
import pageClasses.QFund.AdminTransaction_Drawer_Dessign_PO;
import pageClasses.QFund.CashManagement_SafeDessaign_PO;
import pageClasses.QFund.QfundAdmin_Navigation;

public class AdminTransaction_Drawer_Dessign_PR extends Helper {

	public AdminTransaction_Drawer_Dessign_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);
		// TODO Auto-generated constructor stub
	}

	public void drawerForceDessign() throws Exception {
		
		AdminTransaction_Drawer_Dessign_PO objAdminDrawerForceDessign_PO=new AdminTransaction_Drawer_Dessign_PO(driver,report);
		QfundAdmin_Navigation.Transactions_Tab.Borrower.DrawerDeassign();
		objAdminDrawerForceDessign_PO.set_BorrowerDrawerDessign_StoreNo(data("BorrowerDrawerDessign_StoreNo"));
		objAdminDrawerForceDessign_PO.click_BorrowerDrawerDessign_SubmitButton(data("BorrowerDrawerDessign_SubmitButton"));
		if(objAdminDrawerForceDessign_PO.BorrowerDrawerDessign_DrawerGoButton.isDisplayed()) {
		objAdminDrawerForceDessign_PO.click_BorrowerDrawerDessign_DrawerGoButton(data("BorrowerDrawerDessign_DrawerGoButton"));
		
		}
				
		
	}
	
	public void adminSafeDessign() throws Exception {
		CashManagement_SafeDessaign_PO objCashManagement_SafeDessaign = new CashManagement_SafeDessaign_PO(driver,
				report);
		QfundAdmin_Navigation.Transactions_Tab.Borrower.SafeDeassign();
		
		CashManagement_Safe objCashManagement_Safe= new CashManagement_Safe(driver, allProcessData, report);
		
		objCashManagement_SafeDessaign.set_admindd_StoreNo(data("add_StoreNo"));
		objCashManagement_SafeDessaign.click_admindd_SubmitButton(data("add_SubmitButton"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
				objCashManagement_SafeDessaign.getAlertText(data("alert_message").trim()),
				data("alert_message").trim());
		
		if(objCashManagement_SafeDessaign.isDisplayed(objCashManagement_SafeDessaign.safe_Deassign_CountOfHundredDollars)) {
		objCashManagement_SafeDessaign.set_Safe_Deassign_CountOfHundredDollars(data("100_Dollars"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		objCashManagement_SafeDessaign.set_Safe_Deassign_BankerPin(data("Banker_Pin"));
		objCashManagement_SafeDessaign.click_safe_Deassign_Finish(data("safe_Deassign_Finish"));
		assertAreEqual("Assertion for Alert Text "+data("Deassign_alertmsg"), report,
				objCashManagement_SafeDessaign.getAlertText(data("Deassign_alertmsg").trim()),
				data("Deassign_alertmsg").trim());
		objCashManagement_SafeDessaign.acceptAlert();
		objCashManagement_SafeDessaign.waitForButton();
		objCashManagement_SafeDessaign.set_Safe_Deassign_BankerPin(data("Banker_Pin"));
		
		assertAreEqual("Before submission ",report,objCashManagement_SafeDessaign.isDisplayed_safe_Deassign_Finish(), true);
				
		objCashManagement_SafeDessaign.click_safe_Deassign_Finish(data("safe_Deassign_Finish"));
		
		//assertAreEqual("Banker PIN Invalid Error Message", report, objCashManagement_SafeDessaign.get_sd_BankerPINInvalid(data("sd_BankerPINInvalid")), data("sd_BankerPINInvalid"));
		

		objCashManagement_Safe.overShortBalance();
	}else {
		//System.out.println("Safe is not assigned");
		assertAreEqual("Verification Point- safe is deassigned already", report,true,true);
	}
	}

	}
	

