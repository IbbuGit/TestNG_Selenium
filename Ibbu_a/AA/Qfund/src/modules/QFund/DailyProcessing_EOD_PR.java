package modules.QFund;
	 
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.DailyProcessing_EOD_PO;
import pageClasses.QFund.Qfund_Navigation;

public class DailyProcessing_EOD_PR extends Helper {

	public DailyProcessing_EOD_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void eodProcessing() throws Exception{

		DailyProcessing_EOD_PO objDailyProcessing_EOD_PO	=	new DailyProcessing_EOD_PO(driver,report);
		
		Qfund_Navigation.Daily_Processing.DailyProcessing();
		Qfund_Navigation.Daily_Processing.DailyProcessing();
		
		/*
		 * Validation of screen
		 */

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_DP_EODProcess_Header(data("DP_EODProcess_Header")), data("DP_EODProcess_Header"));


		objDailyProcessing_EOD_PO.click_DP_StartEODProcessingButton(data("DP_StartEODProcessingButton"));

		//objDailyProcessing_EOD_PO.get_DP_Drawer_ErrorMessage(data("DP_Drawer_ErrorMessage"));
		//objDailyProcessing_EOD_PO.isDisplayed_DP_Drawer_ErrorMessage(data("DP_Drawer_ErrorMessage"));

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_DP_Drawer_ErrorMessage(data("DP_Drawer_ErrorMessage")), data("DP_Drawer_ErrorMessage"));

		//objDailyProcessing_EOD_PO.get_DP_Safe_ErrorMessage(data("DP_Safe_ErrorMessage"));
		//objDailyProcessing_EOD_PO.isDisplayed_DP_Safe_ErrorMessage(data("DP_Safe_ErrorMessage"));

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_DP_Safe_ErrorMessage(data("DP_Safe_ErrorMessage")), data("DP_Safe_ErrorMessage"));

		//objDailyProcessing_EOD_PO.get_DP_EOD_Header(data("DP_EOD_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_DP_EOD_Header(data("DP_EOD_Header"));
		
		objDailyProcessing_EOD_PO.click_sts_VoidStoreTransferButton("IFEXIST");
		
		
		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_DP_EOD_Header(data("DP_EOD_Header")), data("DP_EOD_Header"));

		//objDailyProcessing_EOD_PO.get_EOD_SafeBalance_Header(data("EOD_SafeBalance_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_SafeBalance_Header(data("EOD_SafeBalance_Header"));

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_EOD_SafeBalance_Header(data("EOD_SafeBalance_Header")), data("EOD_SafeBalance_Header"));

		objDailyProcessing_EOD_PO.set_EOD_SB_StoreNbrVerification(data("EOD_SB_StoreNbrVerification"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfPennies(data("EOD_SB_CountOfPennies"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfNickels(data("EOD_SB_CountOfNickels"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfDimes(data("EOD_SB_CountOfDimes"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfQuarters(data("EOD_SB_CountOfQuarters"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfHalfDollarCoins(data("EOD_SB_CountOfHalfDollarCoins"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOfDollarCoins(data("EOD_SB_CountOfDollarCoins"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf1Dollar(data("EOD_SB_CountOf1Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf5Dollar(data("EOD_SB_CountOf5Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf10Dollar(data("EOD_SB_CountOf10Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf20Dollar(data("EOD_SB_CountOf20Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf50Dollar(data("EOD_SB_CountOf50Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CountOf100Dollar(data("EOD_SB_CountOf100Dollar"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CashBalanceVerification(data("EOD_SB_CashBalanceVerification"));
		objDailyProcessing_EOD_PO.set_EOD_SB_CCMOBalance(data("EOD_SB_CCMOBalance"));
		objDailyProcessing_EOD_PO.set_EOD_SB_TotalCheckAmtVerification(data("EOD_SB_TotalCheckAmtVerification"));
		objDailyProcessing_EOD_PO.set_EOD_SB_EODComments(data("EOD_SB_EODComments"));
		objDailyProcessing_EOD_PO.set_EOD_SB_DateTimeVerification(data("EOD_SB_DateTimeVerification"));

		objDailyProcessing_EOD_PO.click_EOD_SB_ExitEODButton(data("EOD_SB_ExitEODButton"));

		if (data("EOD_SB_ExitEODButton") != null) {
			objDailyProcessing_EOD_PO.click_EOD_SB_BalanceSafeButton(data("EOD_SB_BalanceSafeButton"));
			Thread.sleep(2000);
			objDailyProcessing_EOD_PO.acceptAlert();
			Thread.sleep(9000);
			assertAreEqual("Verification Point BalanceSafe Button", report, objDailyProcessing_EOD_PO.isDisplayed_EOD_SB_BalanceSafeButton(), true);
			objDailyProcessing_EOD_PO.click_EOD_SB_BalanceSafeButton(data("EOD_SB_BalanceSafeButton"));

		}

		objDailyProcessing_EOD_PO.EOD_DeleteOSInsatances();
				
		assertAreEqual("Verification Point EOD Outstanding", report, objDailyProcessing_EOD_PO.get_EOD_OverShortHeader(data("EOD_OverShortHeader")), data("EOD_OverShortHeader"));
		objDailyProcessing_EOD_PO.set_EOD_OS_EmployeeNameVerification(data("EOD_OS_EmployeeNameVerification"));
		objDailyProcessing_EOD_PO.set_EOD_OS_OpeningBalanceVerification(data("EOD_OS_OpeningBalanceVerification"));
		objDailyProcessing_EOD_PO.set_EOD_OS_CountedBalanceVerification(data("EOD_OS_CountedBalanceVerification"));
		objDailyProcessing_EOD_PO.set_EOD_OS_SystemSafeBalanceVerification(data("EOD_OS_SystemSafeBalanceVerification"));
		
		assertAreEqual("Verification Point BalanceSafe Button", report, objDailyProcessing_EOD_PO.isDisplayed_EOD_OS_SafeOverShortAmountVerification(), true);

		String strget_EOD_OS_SafeOverShortAmountVerification = objDailyProcessing_EOD_PO.get_EOD_OS_SafeOverShortAmountVerification(data("EOD_OS_SafeOverShortAmountVerification")).replace("$", "").trim();
		//objDailyProcessing_EOD_PO.get_EOD_OS_OutofBalReason_Header(data("EOD_OS_OutofBalReason_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_OS_OutofBalReason_Header(data("EOD_OS_OutofBalReason_Header"));

		assertAreEqual("Verification Point OutofBalReason", report, objDailyProcessing_EOD_PO.get_EOD_OS_OutofBalReason_Header(data("EOD_OS_OutofBalReason_Header")), data("EOD_OS_OutofBalReason_Header"));

		//objDailyProcessing_EOD_PO.set_EOD_OS_Amount(data("EOD_OS_Amount"));
		objDailyProcessing_EOD_PO.set_EOD_OS_Amount(strget_EOD_OS_SafeOverShortAmountVerification);
		
		objDailyProcessing_EOD_PO.set_EOD_OS_PrimaryReason(data("EOD_OS_PrimaryReason"));
		objDailyProcessing_EOD_PO.set_EOD_OS_Product(data("EOD_OS_Product"));
		objDailyProcessing_EOD_PO.set_EOD_OS_LoanNbr(data("EOD_OS_LoanNbr"));
		objDailyProcessing_EOD_PO.set_EOD_OS_Notes(data("EOD_OS_Notes"));
		Thread.sleep(1000);

		objDailyProcessing_EOD_PO.click_EOD_OS_AddOSInstanceButton(data("EOD_OS_AddOSInstanceButton"));
		Thread.sleep(3000);

		objDailyProcessing_EOD_PO.set_EOD_OS_TableInstanceVerification(data("EOD_OS_TableInstanceVerification"));

		objDailyProcessing_EOD_PO.click_EOD_OS_BackButton(data("EOD_OS_BackButton"));


		objDailyProcessing_EOD_PO.click_EOD_OS_ExitEODButton(data("EOD_OS_ExitEODButton"));


		objDailyProcessing_EOD_PO.click_EOD_OS_NextButton(data("EOD_OS_NextButton"));
		objDailyProcessing_EOD_PO.acceptAlert();
		//objDailyProcessing_EOD_PO.get_EOD_Deposit_Header(data("EOD_Deposit_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_Deposit_Header(data("EOD_Deposit_Header"));

		//assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_EOD_Deposit_Header(data("EOD_Deposit_Header")), data("EOD_Deposit_Header"));

		objDailyProcessing_EOD_PO.set_EOD_DP_DepositCashBalance(data("EOD_DP_DepositCashBalance"));

		objDailyProcessing_EOD_PO.click_EOD_DP_CalcDepAmtButton(data("EOD_DP_CalcDepAmtButton"));


		objDailyProcessing_EOD_PO.click_EOD_DP_BackButton(data("EOD_DP_BackButton"));


		objDailyProcessing_EOD_PO.click_EOD_DP_ExitEODButton(data("EOD_DP_ExitEODButton"));


		objDailyProcessing_EOD_PO.click_EOD_DP_NextButton(data("EOD_DP_NextButton"));

		//objDailyProcessing_EOD_PO.get_EOD_EODDeposit_Header(data("EOD_EODDeposit_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_EODDeposit_Header(data("EOD_EODDeposit_Header"));

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_EOD_EODDeposit_Header(data("EOD_EODDeposit_Header")), data("EOD_EODDeposit_Header"));


		objDailyProcessing_EOD_PO.click_EOD_EODDeposit_BackButton(data("EOD_EODDeposit_BackButton"));


		objDailyProcessing_EOD_PO.click_EOD_EODDeposit_ExitEODButton(data("EOD_EODDeposit_ExitEODButton"));


		objDailyProcessing_EOD_PO.click_EOD_EODDeposit_NextButton(data("EOD_EODDeposit_NextButton"));

		//objDailyProcessing_EOD_PO.get_EOD_DepositVerification_Header(data("EOD_DepositVerification_Header"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_DepositVerification_Header(data("EOD_DepositVerification_Header"));

		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_EOD_DepositVerification_Header(data("EOD_DepositVerification_Header")), data("EOD_DepositVerification_Header"));

		objDailyProcessing_EOD_PO.set_EOD_DV_CurrentCashBalanceVerification(data("EOD_DV_CurrentCashBalanceVerification"));
		objDailyProcessing_EOD_PO.set_EOD_DV_OpeningSafeBalanceVerification(data("EOD_DV_OpeningSafeBalanceVerification"));
		objDailyProcessing_EOD_PO.set_EOD_EV_BagNbr(data("EOD_EV_BagNbr"));

		objDailyProcessing_EOD_PO.click_EOD_DV_BackButton(data("EOD_DV_BackButton"));


		objDailyProcessing_EOD_PO.click_EOD_DV_ExitEODButton(data("EOD_DV_ExitEODButton"));


		objDailyProcessing_EOD_PO.click_EOD_DV_FinishDepositButton(data("EOD_DV_FinishDepositButton"));

		if (data("EOD_DV_FinishDepositButton") != null) {
			objDailyProcessing_EOD_PO.acceptAlert();
		}

		//objDailyProcessing_EOD_PO.get_EOD_CompletedSuccessfully(data("EOD_CompletedSuccessfully"));
		//objDailyProcessing_EOD_PO.isDisplayed_EOD_CompletedSuccessfully(data("EOD_CompletedSuccessfully"));
		objDailyProcessing_EOD_PO.WaitForElement();
		assertAreEqual("Verification Point", report, objDailyProcessing_EOD_PO.get_EOD_CompletedSuccessfully(data("EOD_CompletedSuccessfully")), data("EOD_CompletedSuccessfully"));


		objDailyProcessing_EOD_PO.click_EOD_Success_OkButton(data("EOD_Success_OkButton"));
		
	}

}

