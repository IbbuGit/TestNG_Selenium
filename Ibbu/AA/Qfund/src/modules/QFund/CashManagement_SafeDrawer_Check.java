package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.CashManagement_Drawer_Assign_AssignDrawer_PO;
import pageClasses.QFund.CashManagement_Drawer_DeAssign_DeAssignDrawer_PO;
import pageClasses.QFund.CashManagement_SafeAssign_PO;
import pageClasses.QFund.CashManagement_SafeDessaign_PO;
import pageClasses.QFund.Qfund_Navigation;

public class CashManagement_SafeDrawer_Check extends Helper {

	LinkedHashMap<String, String> tempData;

	public CashManagement_SafeDrawer_Check(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		tempData = data;
	}

	public void safeCheck() throws Exception{

		if(data("Action").toUpperCase().equals("DEASSIGN")) {

			Qfund_Navigation.Cash_Management.Safe.DeAssign();			
			CashManagement_SafeDessaign_PO objCashManagement_SafeDeAssign = new CashManagement_SafeDessaign_PO(driver,report);

			String deAssignOption=objCashManagement_SafeDeAssign.getVisibleObjForDeAssign();
			if(deAssignOption.equals("NotAssigned")) {
				assertAreEqual("Verification Point- Safe Deassigned already", report,true,true);

				return;
			}else if(deAssignOption.equals("Assigned")) {
				objCashManagement_SafeDeAssign.set_Safe_Deassign_CountOfHundredDollars(data("SafeCash_CountOfHundredDollar"));
				objCashManagement_SafeDeAssign.set_Safe_Deassign_BankerPin(data("Safe_PWD"));
				objCashManagement_SafeDeAssign.click_safe_Deassign_Finish("Y");
				if(objCashManagement_SafeDeAssign.isAlertPresent()) {
					if(!objCashManagement_SafeDeAssign.getAlertText().contains("This action will remove")) {
						objCashManagement_SafeDeAssign.acceptAlert();
						objCashManagement_SafeDeAssign.set_Safe_Deassign_BankerPin(data("Safe_PWD"));
						objCashManagement_SafeDeAssign.click_safe_Deassign_Finish("Y");
						overShortBalanceSafe();
					}else {
						objCashManagement_SafeDeAssign.acceptAlert();
						objCashManagement_SafeDeAssign.click_safe_Deassign_Done("Y");
					}
				}else {
					objCashManagement_SafeDeAssign.click_safe_Deassign_Done("Y");
				}
			}
		}else if(data("Action").toUpperCase().equals("ASSIGN")) {
			CashManagement_SafeAssign_PO objCashManagement_SafeAssign_PO= new CashManagement_SafeAssign_PO(driver, report);
			Qfund_Navigation.Cash_Management.Safe.Assign();
			String AssignOption=objCashManagement_SafeAssign_PO.getVisibleObjForAssign();
			if(AssignOption.equals("Assigned")) {
				assertAreEqual("Verification Point- Safe Assigned already", report,true,true);

				return;
			}else if(AssignOption.equals("EOD_Done")) {
				objCashManagement_SafeAssign_PO.click_sa_IPD_NextButton("Y");
				
				assertAreEqual("Before submission ",report,objCashManagement_SafeAssign_PO.isDisplayed_sa_IPDY_YesButton(), true);
				objCashManagement_SafeAssign_PO.click_sa_IPDY_YesButton("Y");				
				
				Qfund_Navigation.Cash_Management.Safe.Assign();		
				if(objCashManagement_SafeAssign_PO.getVisibleObjForAssign().equals("Assigned")) {
					return;
				}
			}
			objCashManagement_SafeAssign_PO.set_sa_BankerPIN(data("Safe_PWD"));
			objCashManagement_SafeAssign_PO.set_sa_CountOf100Dollar(data("SafeCash_CountOfHundredDollar"));
			objCashManagement_SafeAssign_PO.set_sa_CountOf1Dollar("1");
			objCashManagement_SafeAssign_PO.click_sa_FinishAssignButton("Y");
			objCashManagement_SafeAssign_PO.acceptAlert();
			objCashManagement_SafeAssign_PO.click_sa_Success_OKButton("Y");
		}
	}

	public void drawerCheck() throws Exception{

		if(data("Action").toUpperCase().equals("DEASSIGN")) {
			CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objDrawer_DeAssign= new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(driver, report);			
			Qfund_Navigation.Cash_Management.Drawer.DeAssign();
			String deAssignOption=objDrawer_DeAssign.getVisibleObjForDeAssign();
			if(deAssignOption.equals("NotAssigned") || deAssignOption.equals("EOD_Done")) {
				assertAreEqual("Verification Point- Drawer Deassigned already", report,true,true);
				Thread.sleep(60000);
				return;
			}else if(deAssignOption.equals("Assigned")) {
				objDrawer_DeAssign.set_dd_100DollarBillCount(data("Drawer_CountOfHundredDollar"));
				objDrawer_DeAssign.set_dd_UserPassword(data("Drawer_PWD"));				
				objDrawer_DeAssign.set_dd_BankerPwd(data("Safe_PWD"));
				objDrawer_DeAssign.click_dd_FinishDeAssignButton("Y");
				if(objDrawer_DeAssign.isAlertPresent()) {
					if(!objDrawer_DeAssign.getAlertText().contains("This action will remove")) {
						objDrawer_DeAssign.acceptAlert();
						objDrawer_DeAssign.set_dd_UserPassword(data("Drawer_PWD"));				
						objDrawer_DeAssign.set_dd_BankerPwd(data("Safe_PWD"));
						objDrawer_DeAssign.click_dd_FinishDeAssignButton("Y");
						objDrawer_DeAssign.acceptAlert();
						overShortBalanceDrawer();
					}else {
						objDrawer_DeAssign.acceptAlert();
						objDrawer_DeAssign.click_dd_SuccessfulDeAssignOKButton("Y");
						assertAreEqual("Verification Point- Drawer is deassigned successfully", report,true,true);
					}	
				}else {
					objDrawer_DeAssign.click_dd_SuccessfulDeAssignOKButton("Y");
					assertAreEqual("Verification Point- Drawer is deassigned successfully", report,true,true);
				}

			}
		}else if(data("Action").toUpperCase().equals("ASSIGN")){
			CashManagement_Drawer_Assign_AssignDrawer_PO objCashMngmnt_Drawer_Assign = new CashManagement_Drawer_Assign_AssignDrawer_PO(driver, report);			
			Qfund_Navigation.Cash_Management.Drawer.Assign();
			String AssignOption=objCashMngmnt_Drawer_Assign.getVisibleObjForAssign();
			if(AssignOption.equals("Assigned")) {
				assertAreEqual("Verification Point- Drawer Assigned already", report,true,true);
				return;
			}else if(AssignOption.equals("EmloyeeNotAvailable")) {
				assertAreEqual("Verification Point- Drawer Emloyee Not Available", report,true,false);
				return;			
			}
			else if(AssignOption.equals("EOD_Done")) {
				objCashMngmnt_Drawer_Assign.click_da_IPD_NextButton();
				objCashMngmnt_Drawer_Assign.click_da_IPDY_YesButton();				
			}

			Qfund_Navigation.Cash_Management.Drawer.Assign();
			objCashMngmnt_Drawer_Assign.set_EmployeeName(data("EmployeeName"));
			objCashMngmnt_Drawer_Assign.set_da_100DollarBillCount(data("Drawer_CountOfHundredDollar"));
			objCashMngmnt_Drawer_Assign.set_da_10DollarBillCount("1");
			objCashMngmnt_Drawer_Assign.set_da_UserPassword(data("Drawer_PWD"));
			objCashMngmnt_Drawer_Assign.set_da_BankerPassword(data("Safe_PWD"));
			objCashMngmnt_Drawer_Assign.click_da_FinishAssignButton("Y");
			objCashMngmnt_Drawer_Assign.acceptAlert();
			objCashMngmnt_Drawer_Assign.click_da_SuccessfulAssignOKButton("Y");
			assertAreEqual("Verification Point- Drawer is assigned successfully", report,true,true);

		}
	}

	public void overShortBalanceSafe() throws Exception {

		CashManagement_SafeDessaign_PO objCashManagement_SafeDeAssign = new CashManagement_SafeDessaign_PO(driver,
				report);

		objCashManagement_SafeDeAssign.DeleteOSInsatances();

		objCashManagement_SafeDeAssign
		.set_safeDifferenceAmount(objCashManagement_SafeDeAssign.get_safeOverShortAmount("Get"));

		objCashManagement_SafeDeAssign.set_safeDifferenceAmountPrimaryReason("Other");


		objCashManagement_SafeDeAssign.set_safeDifferenceAmountNotes("Automation safe deassign note");
		objCashManagement_SafeDeAssign.click_safeAddOSinstanceButton("Y");
		objCashManagement_SafeDeAssign.set_safeDesignUserPassword(data("Safe_PWD"));
		objCashManagement_SafeDeAssign.click_safeDesignFinishDesignButton("Y");
		objCashManagement_SafeDeAssign.acceptAlert();
	}

	public void overShortBalanceDrawer() throws Exception {

		CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objDrawer_DeAssign = new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(
				driver, report);



		objDrawer_DeAssign.set_admindd_EnterShortAmount(objDrawer_DeAssign
				.get_admindd_OverShortAmount("Get"));

		objDrawer_DeAssign.set_admindd_PrimaryReason("Other");

		objDrawer_DeAssign.DeleteOSInsatances();

		objDrawer_DeAssign.set_admindd_ShortNotes("Automation safe deassign reason notes");
		objDrawer_DeAssign.click_admindd_AddOSinstanceButton("Y");
		objDrawer_DeAssign.set_admindd_OverShortUserPassword(data("Drawer_PWD"));
		objDrawer_DeAssign.click_admindd_FinishDesignButton("Y");
		objDrawer_DeAssign.acceptAlert();
	}

}
