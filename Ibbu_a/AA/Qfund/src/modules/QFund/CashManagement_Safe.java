
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.CashManagement_SafeAssign_PO;
import pageClasses.QFund.CashManagement_SafeDessaign_PO;
import pageClasses.QFund.CashManagement_Safe_Balance_BalanceSafe_PO;
import pageClasses.QFund.CashManagement_Safe_CashIn_SafeCashIn_PO;
import pageClasses.QFund.CashManagement_Safe_Deposit_SafeDepositVoid_PO;
import pageClasses.QFund.CashManagement_Safe_Deposit_SafeDeposit_PO;
import pageClasses.QFund.CashManagement_Safe_InternalTransfer_PO;
import pageClasses.QFund.CashManagement_Safe_ManualDepositSlip_PO;
import pageClasses.QFund.CashManagement_Safe_StoreToStore_PO;
import pageClasses.QFund.CashManagement_Safe_StoreToStore_TransferVoid_PO;
import pageClasses.QFund.Qfund_Navigation;


public class CashManagement_Safe extends Helper{

	public CashManagement_Safe(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void safeCashIn() throws Exception {

		CashManagement_Safe_CashIn_SafeCashIn_PO objCashManagement_Safe_CashIn_SafeCashIn_PO	=	new CashManagement_Safe_CashIn_SafeCashIn_PO(driver,report);

		Qfund_Navigation.Cash_Management.Safe.Cash_In();

		assertAreEqual("Verification Point", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_sci_PageHeader(data("sci_PageHeader")), data("sci_PageHeader"));
		
		assertAreEqual("Display Error Message", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_sci_Error(data("sci_Error")), data("sci_Error"));

		
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfPennies(data("sci_CountOfPennies"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfNickels(data("sci_CountOfNickels"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfDimes(data("sci_CountOfDimes"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfQuarters(data("sci_CountOfQuarters"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfHalfDollarCoins(data("sci_CountOfHalfDollarCoins"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOfDollarCoins(data("sci_CountOfDollarCoins"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf1Dollar(data("sci_CountOf1Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf5Dollar(data("sci_CountOf5Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf10Dollar(data("sci_CountOf10Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf20Dollar(data("sci_CountOf20Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf50Dollar(data("sci_CountOf50Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_CountOf100Dollar(data("sci_CountOf100Dollar"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_Cash(data("sci_Cash"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_UserID(data("sci_UserID"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_UserPIN(data("sci_UserPIN"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_BankerID(data("sci_BankerID"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.set_sci_BankerPIN(data("sci_BankerPIN"));

		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_sci_FinishCashInButton(data("sci_FinishCashInButton"));

		objCashManagement_Safe_CashIn_SafeCashIn_PO.acceptAlert();
		//objCashManagement_Safe_CashIn_SafeCashIn_PO.click_sci_FinishCashInButton(data("sci_FinishCashInButton"));
		//objCashManagement_Safe_CashIn_SafeCashIn_PO.get_sci_Validation(data("sci_Validation"));
		//objCashManagement_Safe_CashIn_SafeCashIn_PO.isDisplayed_sci_Validation(data("sci_Validation"));

//		assertAreEqual("Display Error Message", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_sci_Error(data("sci_Validation")), data("sci_Error"));
		assertAreEqual("Verification Point", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_sci_Validation(data("sci_Validation")), data("sci_Validation"));

		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_sci_Success_OKButton(data("sci_Success_OKButton"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_sci_CancelButton(data("sci_CancelButton"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_sci_HistoryButton(data("sci_HistoryButton"));

		//objCashManagement_Safe_CashIn_SafeCashIn_PO.get_vci_PageHeader(data("vci_PageHeader"));
		//objCashManagement_Safe_CashIn_SafeCashIn_PO.isDisplayed_vci_PageHeader(data("vci_PageHeader"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_vci_PageHeader(data("vci_PageHeader")), data("vci_PageHeader"));

		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_vci_SelectCashInToVoid(data("vci_SelectCashInToVoid"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_vci_FinishVoidCashInButton(data("vci_FinishVoidCashInButton"));

		//objCashManagement_Safe_CashIn_SafeCashIn_PO.get_vci_Validation(data("vci_Validation"));
		//objCashManagement_Safe_CashIn_SafeCashIn_PO.isDisplayed_vci_Validation(data("vci_Validation"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_CashIn_SafeCashIn_PO.get_vci_Validation(data("vci_Validation")), data("vci_Validation"));

		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_vci_Success_OKButton(data("vci_Success_OKButton"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_vci_MoreButton(data("vci_MoreButton"));
		objCashManagement_Safe_CashIn_SafeCashIn_PO.click_vci_CancelButton(data("vci_CancelButton"));

	}	

	public void safeAssign() throws Exception{

		CashManagement_SafeAssign_PO objCashManagement_SafeAssign_PO= new CashManagement_SafeAssign_PO(driver, report);

		Qfund_Navigation.Cash_Management.Safe.Assign();

		String AssignOption=objCashManagement_SafeAssign_PO.getVisibleObjForAssign();
		if(AssignOption.equals("EOD_Done")) {
			assertAreEqual("Verification Point", report, objCashManagement_SafeAssign_PO.get_sa_IPD_PageHeader(data("sa_IPD_PageHeader")), data("sa_IPD_PageHeader"));
			objCashManagement_SafeAssign_PO.click_sa_IPD_NextButton(data("sa_IPD_NextButton"));
			//objCashManagement_SafeAssign_PO.get_sa_IPDY_PageHeader(data("sa_IPDY_PageHeader"));
			//objCashManagement_SafeAssign_PO.isDisplayed_sa_IPDY_PageHeader(data("sa_IPDY_PageHeader"));
			assertAreEqual("Verification Point", report, objCashManagement_SafeAssign_PO.get_sa_IPDY_PageHeader(data("sa_IPDY_PageHeader")), data("sa_IPDY_PageHeader"));
			objCashManagement_SafeAssign_PO.click_sa_IPDY_YesButton(data("sa_IPDY_YesButton"));
			//objCashManagement_SafeAssign_PO.get_sa_PageHeader(data("sa_PageHeader"));
			//objCashManagement_SafeAssign_PO.isDisplayed_sa_PageHeader(data("sa_PageHeader"));
			Qfund_Navigation.Cash_Management.Safe.Assign();
		}

		assertAreEqual("Safe Assigned Error Message", report, objCashManagement_SafeAssign_PO.get_sa_safeAlreadyAssignedError(data("sa_AssignedError")), data("sa_AssignedError"));
		assertAreEqual("Verification Point", report, objCashManagement_SafeAssign_PO.get_sa_PageHeader(data("sa_PageHeader")), data("sa_PageHeader"));

		objCashManagement_SafeAssign_PO.set_sa_BankerID(data("sa_BankerID"));
		objCashManagement_SafeAssign_PO.set_sa_BankerPIN(data("sa_BankerPIN"));

		objCashManagement_SafeAssign_PO.set_sa_CountOfPennies(data("sa_CountOfPennies"));
		objCashManagement_SafeAssign_PO.set_sa_CountOfNickels(data("sa_CountOfNickels"));
		objCashManagement_SafeAssign_PO.set_sa_CountOfDimes(data("sa_CountOfDimes"));
		objCashManagement_SafeAssign_PO.set_sa_CountOfQuarters(data("sa_CountOfQuarters"));
		objCashManagement_SafeAssign_PO.set_sa_CountOfHalfDollarCoins(data("sa_CountOfHalfDollarCoins"));
		objCashManagement_SafeAssign_PO.set_sa_CountOfDollarCoins(data("sa_CountOfDollarCoins"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf1Dollar(data("sa_CountOf1Dollar"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf5Dollar(data("sa_CountOf5Dollar"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf10Dollar(data("sa_CountOf10Dollar"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf20Dollar(data("sa_CountOf20Dollar"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf100Dollar(data("sa_CountOf100Dollar"));
		objCashManagement_SafeAssign_PO.set_sa_CountOf50Dollar(data("sa_CountOf50Dollar"));
		
		objCashManagement_SafeAssign_PO.set_sa_CountOfPennies("");

		objCashManagement_SafeAssign_PO.set_sa_CashBalance(data("sa_CashBalance"));
		objCashManagement_SafeAssign_PO.set_sa_CheckBalance(data("sa_CheckBalance"));
		objCashManagement_SafeAssign_PO.set_sa_CCMOBalance(data("sa_CCMOBalance"));
		
				
		objCashManagement_SafeAssign_PO.click_sa_FinishAssignButton(data("sa_FinishAssignButton"));
		if(objCashManagement_SafeAssign_PO.isAlertPresent()) {
			objCashManagement_SafeAssign_PO.acceptAlert();
		}
		//objCashManagement_SafeAssign_PO.get_sa_Validation(data("sa_Validation"));
		//objCashManagement_SafeAssign_PO.isDisplayed_sa_Validation(data("sa_Validation"));

		assertAreEqual("Verification Point", report, objCashManagement_SafeAssign_PO.get_sa_Validation(data("sa_Validation")), data("sa_Validation"));
		
//		assertAreEqual("Safe Assigned Error Message", report, objCashManagement_SafeAssign_PO.get_sa_safeAlreadyAssignedError(data("sa_AssignedError")), data("sa_AssignedError"));

		objCashManagement_SafeAssign_PO.click_sa_Success_OKButton(data("sa_Success_OKButton"));

	}

	public void safeBalance() throws Exception { 

		CashManagement_Safe_Balance_BalanceSafe_PO objCashManagement_Safe_Balance_BalanceSafe_PO	=	new CashManagement_Safe_Balance_BalanceSafe_PO(driver,report);

		Qfund_Navigation.Cash_Management.Safe.Balance();

		assertAreEqual("Verification Point", report, objCashManagement_Safe_Balance_BalanceSafe_PO.get_sb_PageHeader(data("sb_PageHeader")), data("sb_PageHeader"));

		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfPennies(data("sb_CountOfPennies"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfNickels(data("sb_CountOfNickels"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfDimes(data("sb_CountOfDimes"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfQuarters(data("sb_CountOfQuarters"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfHalfDollarCoins(data("sb_CountOfHalfDollarCoins"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOfDollarCoins(data("sb_CountOfDollarCoins"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf1Dollar(data("sb_CountOf1Dollar"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf5Dollar(data("sb_CountOf5Dollar"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf10Dollar(data("sb_CountOf10Dollar"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf20Dollar(data("sb_CountOf20Dollar"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf50Dollar(data("sb_CountOf50Dollar"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CountOf100Dollar(data("sb_CountOf100Dollar"));

		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_Cash(data("sb_Cash"));
		
		
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CCMOBalance(data("sb_CCMOBalance"));		
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_CheckBalance(data("sb_CheckBalance"));

		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_UserID(data("sb_UserID"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_UserPIN(data("sb_UserPIN"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_BankerID(data("sb_BankerID"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.set_sb_BankerPIN(data("sb_BankerPIN"));

		assertAreEqual("Before submission ",report,objCashManagement_Safe_Balance_BalanceSafe_PO.isDisplayed_sb_FinishBanlanceSafeButton(), true);
		
		objCashManagement_Safe_Balance_BalanceSafe_PO.click_sb_FinishBanlanceSafeButton(data("sb_FinishBanlanceSafeButton"));

		// Acknowledge Counted Balance Does not Match Calculated Balance
		objCashManagement_Safe_Balance_BalanceSafe_PO.acceptAlert();

		objCashManagement_Safe_Balance_BalanceSafe_PO.click_sb_FinishBanlanceSafeButton(data("sb_FinishBanlanceSafeButton"));

		// Acknowledge Counted Balance Does not Match Calculated Balance
		objCashManagement_Safe_Balance_BalanceSafe_PO.acceptAlert();

		//objCashManagement_Safe_Balance_BalanceSafe_PO.get_sb_Validation(data("sb_Validation"));
		//objCashManagement_Safe_Balance_BalanceSafe_PO.isDisplayed_sb_Validation(data("sb_Validation"));

		assertAreEqual("Banker PIN Invalid Error Message", report, objCashManagement_Safe_Balance_BalanceSafe_PO.get_sb_BankerPINInvalid(data("sb_BankerPINInvalid")), data("sb_BankerPINInvalid"));
		assertAreEqual("Verification Point", report, objCashManagement_Safe_Balance_BalanceSafe_PO.get_sb_Validation(data("sb_Validation")), data("sb_Validation"));
		
		
		objCashManagement_Safe_Balance_BalanceSafe_PO.click_sb_Success_OKButton(data("sb_Success_OKButton"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.click_sb_CancelButton(data("sb_CancelButton"));
		objCashManagement_Safe_Balance_BalanceSafe_PO.click_sb_HistoryButton(data("sb_HistoryButton"));
	}

	public void safeDessign() throws Exception {
		CashManagement_SafeDessaign_PO objCashManagement_SafeDessaign = new CashManagement_SafeDessaign_PO(driver,
				report);
		Qfund_Navigation.Cash_Management.Safe.DeAssign();

		objCashManagement_SafeDessaign.set_Safe_Deassign_CountOfHundredDollars(data("100_Dollars"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		objCashManagement_SafeDessaign.set_Safe_Deassign_BankerPin(data("Banker_Pin"));
		objCashManagement_SafeDessaign.click_safe_Deassign_Finish(data("safe_Deassign_Finish"));
		objCashManagement_SafeDessaign.acceptAlert();
		objCashManagement_SafeDessaign.waitForButton();
		objCashManagement_SafeDessaign.set_Safe_Deassign_BankerPin(data("Banker_Pin"));
		
		assertAreEqual("Before submission ",report,objCashManagement_SafeDessaign.isDisplayed_safe_Deassign_Finish(), true);
				
		objCashManagement_SafeDessaign.click_safe_Deassign_Finish(data("safe_Deassign_Finish"));
		
		assertAreEqual("Banker PIN Invalid Error Message", report, objCashManagement_SafeDessaign.get_sd_BankerPINInvalid(data("sd_BankerPINInvalid")), data("sd_BankerPINInvalid"));
		

		overShortBalance();
	}

	public void safeInternalTrans() throws Exception { 

		CashManagement_Safe_InternalTransfer_PO objCashManagement_Safe_InternalTransfer_PO	=	new CashManagement_Safe_InternalTransfer_PO(driver,report);
		Qfund_Navigation.Cash_Management.Safe.Internal_Transfer();

		//objCashManagement_Safe_InternalTransfer_PO.get_sit_PageHeader(data("sit_PageHeader"));
		//objCashManagement_Safe_InternalTransfer_PO.isDisplayed_sit_PageHeader(data("sit_PageHeader"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_InternalTransfer_PO.get_sit_PageHeader(data("sit_PageHeader")), data("sit_PageHeader"));
		
		assertAreEqual("Safe not assigned Error Msg", report, objCashManagement_Safe_InternalTransfer_PO.get_sit_SafeNotAssigned(data("sit_SafeNotAssigned_Error")), data("sit_SafeNotAssigned_Error"));
		
		assertAreEqual("Drawer not assigned Error Msg", report, objCashManagement_Safe_InternalTransfer_PO.get_sit_DrawerNotAssigned(data("sit_DrawerNotAssigned_Error")), data("sit_DrawerNotAssigned_Error"));

		objCashManagement_Safe_InternalTransfer_PO.set_sit_Action(data("sit_Action"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CashAmt(data("sit_CashAmt"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfPennies(data("sit_CountOfPennies"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfNickels(data("sit_CountOfNickels"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfDimes(data("sit_CountOfDimes"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfQuarters(data("sit_CountOfQuarters"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfHalfDollarCoins(data("sit_CountOfHalfDollarCoins"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOfDollarCoins(data("sit_CountOfDollarCoins"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf1Dollar(data("sit_CountOf1Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf5Dollar(data("sit_CountOf5Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf10Dollar(data("sit_CountOf10Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf20Dollar(data("sit_CountOf20Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf50Dollar(data("sit_CountOf50Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_CountOf100Dollar(data("sit_CountOf100Dollar"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_UserID(data("sit_UserID"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_UserPIN(data("sit_UserPIN"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_BankerID(data("sit_BankerID"));
		objCashManagement_Safe_InternalTransfer_PO.set_sit_BankerPIN(data("sit_BankerPIN"));

		objCashManagement_Safe_InternalTransfer_PO.click_sit_FinishInternalTransferButton(data("sit_FinishInternalTransferButton"));
		objCashManagement_Safe_InternalTransfer_PO.acceptAlert();
		//objCashManagement_Safe_InternalTransfer_PO.get_sit_Validation(data("sit_Validation"));
		//objCashManagement_Safe_InternalTransfer_PO.isDisplayed_sit_Validation(data("sit_Validation"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_InternalTransfer_PO.get_sit_Validation(data("sit_Validation")), data("sit_Validation"));

		objCashManagement_Safe_InternalTransfer_PO.click_sit_Success_OKButton(data("sit_Success_OKButton"));

	}

	public void safeDeposit() throws Exception { 

		//-------------------------------------------------	 
		CashManagement_Safe_Deposit_SafeDeposit_PO objCashManagement_Safe_Deposit_SafeDeposit_PO	=	new CashManagement_Safe_Deposit_SafeDeposit_PO(driver,report);
		Qfund_Navigation.Cash_Management.Safe.Deposit();

		assertAreEqual("Verification Point", report, objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_PageHeader(data("sd_PageHeader")), data("sd_PageHeader"));

		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_DepositBank(data("sd_DepositBank"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfPennies(data("sd_CountOfPennies"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfNickels(data("sd_CountOfNickels"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfDimes(data("sd_CountOfDimes"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfQuarters(data("sd_CountOfQuarters"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfHalfDollarCoins(data("sd_CountOfHalfDollarCoins"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOfDollarCoins(data("sd_CountOfDollarCoins"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf1Dollar(data("sd_CountOf1Dollar"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf5Dollar(data("sd_CountOf5Dollar"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf10Dollar(data("sd_CountOf10Dollar"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf20Dollar(data("sd_CountOf20Dollar"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf50Dollar(data("sd_CountOf50Dollar"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_CountOf100Dollar(data("sd_CountOf100Dollar"));

		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_BagNbr(data("sd_BagNbr"));

		objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_UserID(data("sd_UserID"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_UserPIN(data("sd_UserPIN"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_BankerID(data("sd_BankerID"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.set_sd_BankerPIN(data("sd_BankerPIN"));
		
		objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_Cash(data("sd_Cash"));
		updateDataSheet("sd_Cash", objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_Cash("Get"));

		objCashManagement_Safe_Deposit_SafeDeposit_PO.click_sd_FinishDepositButton(data("sd_FinishDepositButton"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.acceptAlert();

		assertAreEqual("Before submission ",report,objCashManagement_Safe_Deposit_SafeDeposit_PO.isDisplayed_sd_DepositVerifyButton(), true);
		
		objCashManagement_Safe_Deposit_SafeDeposit_PO.click_sd_DepositVerifyButton(data("sd_DepositVerifyButton"));
		objCashManagement_Safe_Deposit_SafeDeposit_PO.acceptAlert();

		//objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_Validation(data("sd_Validation"));
		//objCashManagement_Safe_Deposit_SafeDeposit_PO.isDisplayed_sd_Validation(data("sd_Validation"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_Deposit_SafeDeposit_PO.get_sd_Validation(data("sd_Validation")), data("sd_Validation"));

		objCashManagement_Safe_Deposit_SafeDeposit_PO.click_sd_Success_OKButton(data("sd_Success_OKButton"));


		//objCashManagement_Safe_Deposit_SafeDeposit_PO.click_sd_CancelButton(data("sd_CancelButton"));

	}

	public void storeToStoreTransfer() throws Exception { 

		CashManagement_Safe_StoreToStore_PO objCashManagement_Safe_StoreToStore_PO	=	new CashManagement_Safe_StoreToStore_PO(driver,report);

		Qfund_Navigation.Cash_Management.Safe.Store_To_StoreTransfers();

		//objCashManagement_Safe_StoreToStore_PO.get_sts_PageHeader(data("sts_PageHeader"));
		//objCashManagement_Safe_StoreToStore_PO.isDisplayed_sts_PageHeader(data("sts_PageHeader"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_StoreToStore_PO.get_sts_PageHeader(data("sts_PageHeader")), data("sts_PageHeader"));

		objCashManagement_Safe_StoreToStore_PO.set_sts_Action(data("sts_Action"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_StoreNbr(data("sts_StoreNbr"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CashAmt(data("sts_CashAmt"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfPennies(data("sts_CountOfPennies"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfNickels(data("sts_CountOfNickels"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfDimes(data("sts_CountOfDimes"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfQuarters(data("sts_CountOfQuarters"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfHalfDollarCoins(data("sts_CountOfHalfDollarCoins"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOfDollarCoins(data("sts_CountOfDollarCoins"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf1Dollar(data("sts_CountOf1Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf5Dollar(data("sts_CountOf5Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf10Dollar(data("sts_CountOf10Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf20Dollar(data("sts_CountOf20Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf50Dollar(data("sts_CountOf50Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_CountOf100Dollar(data("sts_CountOf100Dollar"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_Cash(data("sts_Cash"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_UserID(data("sts_UserID"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_UserPIN(data("sts_UserPIN"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_BankerID(data("sts_BankerID"));
		objCashManagement_Safe_StoreToStore_PO.set_sts_BankerPIN(data("sts_BankerPIN"));

		objCashManagement_Safe_StoreToStore_PO.click_sts_StoreToStoreButton(data("sts_StoreToStoreButton"));
		objCashManagement_Safe_StoreToStore_PO.click_sts_CancelButton(data("sts_CancelButton"));
		objCashManagement_Safe_StoreToStore_PO.click_sts_HistoryButton(data("sts_HistoryButton"));

		//objCashManagement_Safe_StoreToStore_PO.get_sts_Validation(data("sts_Validation"));
		//objCashManagement_Safe_StoreToStore_PO.isDisplayed_sts_Validation(data("sts_Validation"));

		assertAreEqual("Verification Point", report, objCashManagement_Safe_StoreToStore_PO.get_sts_Validation(data("sts_Validation")), data("sts_Validation"));

		objCashManagement_Safe_StoreToStore_PO.click_sts_Success_OKButton(data("sts_Success_OKButton"));

	}

	public void manualDepositSlip() throws Exception {			

		CashManagement_Safe_ManualDepositSlip_PO objPage_CashManagement_Safe_ManualDepositSlip_PO	=	new CashManagement_Safe_ManualDepositSlip_PO (driver, report);

		Qfund_Navigation.Cash_Management.Safe.Manual_Deposit_Slip();

		assertAreEqual("Verification Point", report, objPage_CashManagement_Safe_ManualDepositSlip_PO.get_mds_PageHeader(data("mds_PageHeader")), data("mds_PageHeader"));

		objPage_CashManagement_Safe_ManualDepositSlip_PO.waitForButton();
		objPage_CashManagement_Safe_ManualDepositSlip_PO.click_mds_PrintDepositSlip(data("mds_PrintDepositSlip"));	

		assertAreEqual("Verification Point", report, objPage_CashManagement_Safe_ManualDepositSlip_PO.get_mds_Validation(data("mds_Validation")), data("mds_Validation").trim());

		objPage_CashManagement_Safe_ManualDepositSlip_PO.click_mds_Success_OKButton(data("mds_Success_OKButton"));
	}

	public void storeToStoreTransferVoid() throws Exception { 

		CashManagement_Safe_StoreToStore_TransferVoid_PO objCashManagement_Safe_StoreToStore_TransferVoid= new CashManagement_Safe_StoreToStore_TransferVoid_PO(driver, report);
		
		Qfund_Navigation.Cash_Management.Safe.Store_To_StoreTransfers();
		
		// Assertion for Store to Store Transfer Page
		assertAreEqual("Assertion for Store to Store Transfer Page",report,objCashManagement_Safe_StoreToStore_TransferVoid.checkVisibiltyOfStoreNbr(),true);
		
		// Select Store to Store Action (Sending, Receiving and Pending)
		objCashManagement_Safe_StoreToStore_TransferVoid.set_CM_Safe_StoretoStore_Action(data("CM_Safe_StoretoStore_Action"));
		
		// Assertion for Pending Transfer Page
		assertAreEqual("Assertion for Pending Transfer Page",report,objCashManagement_Safe_StoreToStore_TransferVoid.checkVisibiltyOfHistoryBtn(),true);
		
		// Get Transfer Code
		String transCode=objCashManagement_Safe_StoreToStore_TransferVoid.get_transferVoidTransaction(data("StoreNbr"));
		
		// Click the History Button
		objCashManagement_Safe_StoreToStore_TransferVoid.click_StoreToStoreTransfer_HistoryBtn(data("CM_StoreToStoreTransfer_HistoryBtn"));
		
		// Assertion for Void Transfer Page
		assertAreEqual("Assertion for Void Store to Store Transfer Page",report,objCashManagement_Safe_StoreToStore_TransferVoid.checkVisibiltyOfFinishVoidTransferBtn(),true);
		
		// Select the Store to Store Transfer to be voided Radio Button
		objCashManagement_Safe_StoreToStore_TransferVoid.click_VoidTransactionRadioBtn(transCode, transCode);

		// Click the Finish Void Store to Store Transfer Button
		objCashManagement_Safe_StoreToStore_TransferVoid.click_FinishVoidStoreToStoreTransferBtn(data("CM_FinishVoidStoreToStoreTransfer_Btn"));
		
		// Assertion for Void Transaction Successful Message
		assertAreEqual("Assertion for Void Transaction Successful Page",report,objCashManagement_Safe_StoreToStore_TransferVoid.checkVisibiltyOfVoidTransactionOKBtn(),true);

		
		// Click the Void Transaction Completed Successfully OK Button
		objCashManagement_Safe_StoreToStore_TransferVoid.click_VoidTransfer_SuccessfulOKBtn(data("CM_VoidTransfer_SuccessfulOKBtn"));		

	}
	
	public void safeDepositVoid() throws Exception { 

		//-------------------------------------------------	 
		CashManagement_Safe_Deposit_SafeDepositVoid_PO objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects	=	new CashManagement_Safe_Deposit_SafeDepositVoid_PO(driver, report);
		Qfund_Navigation.Cash_Management.Safe.Deposit();

		// Assertion for Safe Deposit Page
		assertAreEqual("Assertion for Safe Deposit Page",report,objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.checkVisibiltyOfHistoryBtn(),true);

		// Click the History Button
		objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.click_CM_Safe_DepositVoid_HistoryBtn(data("CM_Safe_DepositVoid_HistoryBtn"));

		// Assertion for Void Deposit Page
		assertAreEqual("Assertion for Void Deposit Page",report,objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.checkVisibilityofFinishVoidBtn(),true);

		// Click Void Deposit Radio Button
		objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.click_VoidTransactionRadioBtn(data("CM_Safe_DepositVoid_DepositRadioBtn"));

		// Click the Finish Deposit Button in the Deposit Verification
		objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.click_CM_Safe_DepositVoid_FinishDepositBtn(data("CM_Safe_DepositVoid_FinishVoidDepositBtn"));
		objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.acceptAlert();
		// Assertion for OK Button for Deposit completed successfully message
		assertAreEqual("Assertion for Void Deposit Completed Successfully message",report,objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.checkVisibilityofVoidSuccessfulOKBtn(),true);

		// Click the Deposit Completed Successfully OK Button
		objCashManagement_Safe_Deposit_SafeDepositVoid_PageObjects.click_CM_Safe_DepositVoid_DepositCompOKBtn(data("CM_Safe_DepositVoid_DepositCompOKBtn"));

	}
	
	public void overShortBalance() throws Exception {

		CashManagement_SafeDessaign_PO objCashManagement_SafeDessaign = new CashManagement_SafeDessaign_PO(driver,report);

		objCashManagement_SafeDessaign.DeleteOSInsatances();
		if (data("OverShortAmount").equals("Application")) {
			objCashManagement_SafeDessaign.set_safeDifferenceAmount(objCashManagement_SafeDessaign.get_safeOverShortAmount("Get"));
		} else {
			objCashManagement_SafeDessaign.set_safeDifferenceAmount(objCashManagement_SafeDessaign.get_safeOverShortAmount(data("OverShortAmount")));
		}
		objCashManagement_SafeDessaign.set_safeDifferenceAmountPrimaryReason(data("AdminDrawerDesignPrimaryReason"));
		objCashManagement_SafeDessaign.set_safeDifferenceAmountNotes(data("AdminDrawerDesignShortNotes"));
		objCashManagement_SafeDessaign.click_safeAddOSinstanceButton(data("AdminDrawerAddOSinstanceButton"));
		objCashManagement_SafeDessaign.set_safeDesignUserPassword(data("AdminDrawerDesignOverShortUserPassword"));

		objCashManagement_SafeDessaign.click_safeDesignFinishDesignButton(data("AdminDrawerDesignFinishDesignButton"));
		objCashManagement_SafeDessaign.acceptAlert();
	}

}
