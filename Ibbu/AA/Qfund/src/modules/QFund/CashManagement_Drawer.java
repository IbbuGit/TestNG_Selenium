package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.CashManagement_Drawer_Assign_AssignDrawer_PO;
import pageClasses.QFund.CashManagement_Drawer_Balance_DrawerBalance_PO;
import pageClasses.QFund.CashManagement_Drawer_DeAssign_DeAssignDrawer_PO;
import pageClasses.QFund.QfundAdmin_Navigation;
import pageClasses.QFund.Qfund_Navigation;

public class CashManagement_Drawer extends Helper {

	public CashManagement_Drawer(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void drawerAssign() throws Exception {

		// test

		// -------------------------------------------------

		CashManagement_Drawer_Assign_AssignDrawer_PO objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects = new CashManagement_Drawer_Assign_AssignDrawer_PO(
				driver, report);

		// Click the Cash Management, Drawer and Assign Menu Items
		Qfund_Navigation.Cash_Management.Drawer.Assign();

		// Assertion for Drawer Already Assigned Error Message
		assertAreEqual("Display Drawer Already Assigned Error Message", report, 
				objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.get_drawerAlreadyAssignedError(data("drawerAlreadyAssignedError")), data("drawerAlreadyAssignedError"));

		// Assertion for Drawer Assignment Page
		assertAreEqual("Assertion for Drawer Assignment Page", report,
				objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.checkVisibiltyOfBankerID(data("AD_100DollarBillCount")), true);

		// Enter '5' into the $100 Count field
		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects
		.set_da_100DollarBillCount(data("AD_100DollarBillCount"));

		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.set_EmployeeName(data("EmployeeName"));


		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.set_da_UserPassword(data("UserPassword"));

		// Enter Banker Password
		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.set_da_BankerPassword(data("AD_BankerPwd"));

		// Click the Finish Assign Button
		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects
		.click_da_FinishAssignButton(data("CashManagement_Assign_FinishAssignButton"));

		// Handles Dialog Box
		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.acceptAlert();

		// Assertion for Successful OK Button
		assertAreEqual("Assertion for Drawer Assigned Successfully Message", report,
				objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects.checkVisibiltyOfSuccessfulOKBtn(data("CashManagement_Assign_SuccessfulAssignOKButton")), true);

		// Click the Successfully Assigned OK Button
		objPage_CashManagement_Drawer_Assign_AssignDrawer_PageObjects
		.click_da_SuccessfulAssignOKButton(data("CashManagement_Assign_SuccessfulAssignOKButton"));

	}

	public void drawerBalance() throws Exception {

		// -------------------------------------------------

		CashManagement_Drawer_Balance_DrawerBalance_PO CashManagement_Drawer_Balance_DrawerBalance_PageObjects = new CashManagement_Drawer_Balance_DrawerBalance_PO(
				driver, report);

		Qfund_Navigation.Cash_Management.Drawer.Balance();

		// Assertion for Drawer Balance Page
		assertAreEqual("Assertion for Drawer Balance Page", report,
				CashManagement_Drawer_Balance_DrawerBalance_PageObjects.checkVisibiltyOfUserID(), true);

		// Enter '5' into the $100 Count field
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects
		.set_CM_Balance_100DollarBillCount(data("BAL_100DollarBillCount"));

		// Enter '0' into the CC/MO Balance field
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects.set_CM_Balance_CCMOBalance(data("CCMOBalance"));

		// Enter "0' into the Check Balance field
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects.set_CM_Balance_CheckBalance(data("CheckBalance"));

		// Enter PIN#
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects.set_CM_Balance_UserPIN(data("BAL_UserPIN"));


		// Click the Finish Balance Drawer Button
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects
		.click_CM_Balance_FinishDrawerBalBtn(data("CM_Balance_FinishDrawerBalBtn"));

		// Handles Drawer Balance not correct dialog box
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects.acceptAlert();

		CashManagement_Drawer_Balance_DrawerBalance_PageObjects
		.click_CM_Balance_FinishDrawerBalBtn(data("CM_Balance_FinishDrawerBalBtn"));


		// Handles additional dialog box
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects.acceptAlert();

		// Assertion for Invalid Password Error Message
		assertAreEqual("Display Invalid Password Error Message", report, 
				CashManagement_Drawer_Balance_DrawerBalance_PageObjects.get_drawerInvalidPwdMsg(data("drawerInvalidPwdError")), data("drawerInvalidPwdError"));


		// Assertion for Drawer Balance Successful Message
		// assertAreEqual("Assertion for Drawer Balance Successful
		// Message",report,CashManagement_Drawer_Balance_DrawerBalance_PageObjects.checkVisibiltyOfSuccessfulOKBtn(),true);

		// Click the Successfully Balanced OK Button
		CashManagement_Drawer_Balance_DrawerBalance_PageObjects
		.click_CM_Balance_SuccessfulBalOKBtn(data("CM_Balance_SuccessfulBalOKBtn"));

	}

	public void drawerDeAssign() throws Exception {

		// -------------------------------------------------

		CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objCashMangmnt_Drawer_DeAssign = new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(
				driver, report);

		Qfund_Navigation.Cash_Management.Drawer.DeAssign();


		// Assertion for Drawer De-assignment Page
		assertAreEqual("Assertion for Drawer De-assignment Page", report,
				objCashMangmnt_Drawer_DeAssign.checkVisibiltyOfDeAssignBtn(), true);

		// Enter '5' into the $100 Count field
		objCashMangmnt_Drawer_DeAssign.set_dd_100DollarBillCount(data("dd_100DollarBillCount"));

		// Enter User Id Password (If present)
		objCashMangmnt_Drawer_DeAssign.set_dd_UserPassword(data("dd_UserPassword"));

		// Enter Banker Password
		objCashMangmnt_Drawer_DeAssign.set_dd_BankerPwd(data("dd_BankerPwd"));

		assertAreEqual("Before submission ", report,
				objCashMangmnt_Drawer_DeAssign.isDisplayed_dd_FinishDeAssignButton(), true);

		// Click the Finish Assign Button
		objCashMangmnt_Drawer_DeAssign.click_dd_FinishDeAssignButton(data("dd_FinishDeAssignButton"));

		objCashMangmnt_Drawer_DeAssign.acceptAlert();

		// objCashMangmnt_Drawer_DeAssign.waitForButton();

		objCashMangmnt_Drawer_DeAssign.set_dd_UserPassword(data("dd_UserPassword"));

		// Enter Banker Password
		objCashMangmnt_Drawer_DeAssign.set_dd_BankerPwd(data("dd_BankerPwd"));

		objCashMangmnt_Drawer_DeAssign.click_dd_FinishDeAssignButton(data("dd_FinishDeAssignButton"));

		objCashMangmnt_Drawer_DeAssign.acceptAlert();

		assertAreEqual("Display Invalid Password Error Message", report,
				objCashMangmnt_Drawer_DeAssign.get_drawerDeassignInvalidPINMsg(data("dd_InvalidUserPIN")), data("dd_InvalidUserPIN"));


		overShortBalance();

		objCashMangmnt_Drawer_DeAssign.click_dd_SuccessfulDeAssignOKButton(data("dd_SuccessfulDeAssignOKButton"));

	}

	public void overShortBalance() throws Exception {

		CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objCashMangmnt_Drawer_DeAssign = new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(
				driver, report);

		objCashMangmnt_Drawer_DeAssign.DeleteOSInsatances();
		
		if (data("OverShortAmount").equals("Application")) {
			objCashMangmnt_Drawer_DeAssign
			.set_admindd_EnterShortAmount(objCashMangmnt_Drawer_DeAssign.get_admindd_OverShortAmount("Get"));
		} else {
			objCashMangmnt_Drawer_DeAssign
			.set_admindd_EnterShortAmount(objCashMangmnt_Drawer_DeAssign.get_admindd_OverShortAmount(data("OverShortAmount")));
		}
		
		
		objCashMangmnt_Drawer_DeAssign.set_admindd_PrimaryReason(data("add_PrimaryReason"));

		objCashMangmnt_Drawer_DeAssign.set_admindd_ShortNotes(data("add_ShortNotes"));
		
		objCashMangmnt_Drawer_DeAssign.click_admindd_AddOSinstanceButton(data("add_AddOSinstanceButton"));
		assertAreEqual("Assertion for Alert Text "+data("OverShort_AlertMsg"), report,
				objCashMangmnt_Drawer_DeAssign.getAlertText(data("OverShort_AlertMsg").trim()),
				data("OverShort_AlertMsg").trim());
		objCashMangmnt_Drawer_DeAssign.set_admindd_OverShortUserPassword(data("add_OverShortUserPassword"));
		objCashMangmnt_Drawer_DeAssign.click_admindd_FinishDesignButton(data("add_FinishDesignButton"));
		assertAreEqual("Assertion for Alert Text "+data("Message"), report,
				objCashMangmnt_Drawer_DeAssign.getAlertText(data("Message").trim()),
				data("Message").trim());
		//objCashMangmnt_Drawer_DeAssign.set_admindd_OverShortAmount(data("OverShortAmount"));
		
		objCashMangmnt_Drawer_DeAssign.acceptAlert();
	}

	public void adminDrawerDessign() throws Exception {

		CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objCashMangmnt_Drawer_DeAssign = new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(
				driver, report);

		QfundAdmin_Navigation.Transactions_Tab.Borrower.DrawerDeassign();

		objCashMangmnt_Drawer_DeAssign.set_admindd_StoreNo(data("add_StoreNo"));
		
		objCashMangmnt_Drawer_DeAssign.click_admindd_SubmitButton(data("add_SubmitButton"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,
				objCashMangmnt_Drawer_DeAssign.getAlertText(data("alert_message").trim()),
				data("alert_message").trim());
		String deAssignOption = objCashMangmnt_Drawer_DeAssign.getVisibleObjForAdminDrawerDeAssign();

		if (deAssignOption.equals("Assigned")) {

			int totalDrawers = objCashMangmnt_Drawer_DeAssign.noOfDrawers();
			for (int i = 1; i <= totalDrawers; i++) {
				objCashMangmnt_Drawer_DeAssign.click_DrawerRow_GoButton(data("add_GoButton"));
				adminDrawerDessignProcess();
				if (totalDrawers > i) {
					QfundAdmin_Navigation.Transactions_Tab.Borrower.DrawerDeassign();
					objCashMangmnt_Drawer_DeAssign.set_admindd_StoreNo(data("add_StoreNo"));
					objCashMangmnt_Drawer_DeAssign.click_admindd_SubmitButton(data("add_SubmitButton"));
				}
			}
		} else {
			assertAreEqual("Before submission ", report,
					objCashMangmnt_Drawer_DeAssign.isDisplayed_admindd_SubmitButton(), true);
		}
	}

	public void adminDrawerDessignProcess() throws Exception {

		CashManagement_Drawer_DeAssign_DeAssignDrawer_PO objCashMangmnt_Drawer_DeAssign = new CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(
				driver, report);

		objCashMangmnt_Drawer_DeAssign.set_dd_DollarBillCount(data("add_DollarBillCount"));
		objCashMangmnt_Drawer_DeAssign.set_admindd_Password(data("add_Password"));
		objCashMangmnt_Drawer_DeAssign.click_dd_FinishDeAssignButton(data("add_FinishDeAssignButton"));
		assertAreEqual("Assertion for Alert Text "+data("Deassign_alertmsg"), report,
				objCashMangmnt_Drawer_DeAssign.getAlertText(data("Deassign_alertmsg").trim()),
				data("Deassign_alertmsg").trim());
		objCashMangmnt_Drawer_DeAssign.acceptAlert();
		objCashMangmnt_Drawer_DeAssign.waitForButton();
		objCashMangmnt_Drawer_DeAssign.set_admindd_Password(data("add_Password"));
		assertAreEqual("Before submission ", report,
				objCashMangmnt_Drawer_DeAssign.isDisplayed_dd_FinishDeAssignButton(), true);

		objCashMangmnt_Drawer_DeAssign.click_dd_FinishDeAssignButton(data("add_FinishDeAssignButton"));
		objCashMangmnt_Drawer_DeAssign.acceptAlert();

		overShortBalance();

	}
}
