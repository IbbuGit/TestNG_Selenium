package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class Login_DateChange_Safe_Drawer_Registration_LoanOrigination_PR extends Helper {

	LinkedHashMap<String, String> tempData;

	public Login_DateChange_Safe_Drawer_Registration_LoanOrigination_PR(WebDriver _driver,
			LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		tempData = data;
	}

	public void PreRequisite() throws Exception {

		/*
		 * ProcessDateChange
		 */

		if (!tempData.get("PreRequisite.si_ProcessDate").isEmpty()) {
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_Admin"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(
					getData("adminProcessDateChange", tempData.get("PreRequisite.si_ProcessDate"), tempData),
					"adminProcessDateChange");
			new AdminTransaction_QAJobs_ProcessDateChange_PR(driver, allProcessData, report).adminProcessDateChange();

			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

		}

		/*
		 * EOD
		 */
		if (tempData.get("PreRequisite.si_EOD").equalsIgnoreCase("Yes")) {

			/*
			 * adminSafeDessign
			 */
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_Admin"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(getData("adminSafeDessign", "adminsafedessign", tempData),"adminSafeDessign");
			new AdminTransaction_Drawer_Dessign_PR(driver, allProcessData, report).adminSafeDessign();
			
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

			/*
			 * safeAssign
			 */
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_CSRSafe"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(getData("safeAssign", "CommonSafeAssign", tempData), "safeAssign");
			new CashManagement_Safe(driver, allProcessData, report).safeAssign();
			
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

			/*
			 * adminDrawerDessign
			 */
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_Admin"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(
					getData("adminDrawerDessign", tempData.get("PreRequisite.si_adminDrawerDessign"), tempData),
					"adminDrawerDessign");
			new CashManagement_Drawer(driver, allProcessData, report).adminDrawerDessign();
			
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_CSRSafe"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			/*
			 * EOD
			 */
			ulterDataAndProcess(getData("safeCheck", "Assign_Safe", tempData), "safeCheck");
			new CashManagement_SafeDrawer_Check(driver, allProcessData, report).safeCheck();
			
			ulterDataAndProcess(getData("safeBalance", "CommonSafeBalance", tempData), "safeBalance");
			new CashManagement_Safe(driver, allProcessData, report).safeBalance();

			ulterDataAndProcess(getData("safeDeposit", "CommonSafeDep", tempData), "safeDeposit");
			new CashManagement_Safe(driver, allProcessData, report).safeDeposit();

			ulterDataAndProcess(getData("eodProcessing", "Commoneod", tempData), "eodProcessing");
			new DailyProcessing_EOD_PR(driver, allProcessData, report).eodProcessing();

			/*
			 * storeStatusChange
			 */
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_Admin"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(
					getData("storeStatusChange", tempData.get("PreRequisite.si_storeStatusChange"), tempData),
					"storeStatusChange");
			new AdminTransaction_QAJobs_ProcessDateChange_PR(driver, allProcessData, report).storeStatusChange();

			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

		}

		/*
		 * BOD
		 */
		if (tempData.get("PreRequisite.si_BOD").equalsIgnoreCase("Yes")) {
			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_CSRSafe"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			if (tempData.get("PreRequisite.si_DeAssign").equalsIgnoreCase("Yes")) {
				ulterDataAndProcess(getData("safeCheck", "DeAssign_Safe", tempData), "safeCheck");
				new CashManagement_SafeDrawer_Check(driver, allProcessData, report).safeCheck();

				ulterDataAndProcess(getData("safeAssign", "CommonSafeAssign", tempData), "safeAssign");
				new CashManagement_Safe(driver, allProcessData, report).safeAssign();
			} else {
				ulterDataAndProcess(getData("safeCheck", "Assign_Safe", tempData), "safeCheck");
				new CashManagement_SafeDrawer_Check(driver, allProcessData, report).safeCheck();

			}

//			ulterDataAndProcess(getData("clockOut", "autoClockOut", tempData), "clockOut");
//			new LoginQfundX_PR(driver, allProcessData, report).clockOut();
			
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_CSRDrawer"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			if (tempData.get("PreRequisite.si_DeAssign").equalsIgnoreCase("Yes")) {
				ulterDataAndProcess(getData("drawerCheck", "DeAssign_Drawer", tempData), "drawerCheck");
				new CashManagement_SafeDrawer_Check(driver, allProcessData, report).drawerCheck();

				ulterDataAndProcess(getData("drawerAssign", "CommonDrawerAssign", tempData), "drawerAssign");
				new CashManagement_Drawer(driver, allProcessData, report).drawerAssign();
			} else {
				ulterDataAndProcess(getData("drawerCheck", "Assign_Drawer", tempData), "drawerCheck");
				new CashManagement_SafeDrawer_Check(driver, allProcessData, report).drawerCheck();

			}

//			ulterDataAndProcess(getData("clockOut", "autoClockOut", tempData), "clockOut");
//			new LoginQfundX_PR(driver, allProcessData, report).clockOut();
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();

		}

		/*
		 * Registration
		 */
		if (tempData.get("PreRequisite.si_Registration").equalsIgnoreCase("Yes")) {

			ulterDataAndProcess(getData("loginApplication", tempData.get("PreRequisite.si_CSRDrawer"), tempData),
					"loginApplication");
			new LoginQfundX_PR(driver, allProcessData, report).loginApplication();

			ulterDataAndProcess(getData("brwrRegPersonalInfo", tempData.get("PreRequisite.si_PersonalInfo"), tempData),
					"brwrRegPersonalInfo");
			new BorrowerRegistration_PR(driver, allProcessData, report).brwrRegPersonalInfo();

			ulterDataAndProcess(getData("brwrRegIncome", tempData.get("PreRequisite.si_Income"), tempData),
					"brwrRegIncome");
			new BorrowerRegistration_PR(driver, allProcessData, report).brwrRegIncome();

			ulterDataAndProcess(getData("brwrRegBanking", tempData.get("PreRequisite.si_Banking"), tempData),
					"brwrRegBanking");
			new BorrowerRegistration_PR(driver, allProcessData, report).brwrRegBanking();

			ulterDataAndProcess(getData("brwrRegOthers", tempData.get("PreRequisite.si_Others"), tempData),
					"brwrRegOthers");
			new BorrowerRegistration_PR(driver, allProcessData, report).brwrRegOthers();
		}

		/*
		 * Loan Origination
		 */

		if (tempData.get("PreRequisite.si_LoanOrigination").equalsIgnoreCase("Yes")) {
			ulterDataAndProcess(
					getData("LoanDecisioningProcess", tempData.get("PreRequisite.si_LoanProduct"), tempData),
					"LoanDecisioningProcess");
			new LoanDecisioning_PR(driver, allProcessData, report).LoanDecisioningProcess();

			if (tempData.get("PreRequisite.si_LoanProduct").equalsIgnoreCase("Payday")) {
				/*
				 * Payday
				 */
				ulterDataAndProcess(getData("payDayLoan", tempData.get("PreRequisite.si_LoanDisbursment"), tempData),
						"payDayLoan");
				new PayDayLoan_PR(driver, allProcessData, report).payDayLoan();

				ulterDataAndProcess(getData("transactionHistory_get", "getPaydayData", tempData),
						"transactionHistory_get");
				new CustomerLoanHistory_PR(driver, allProcessData, report).transactionHistory_get();

			} else if (tempData.get("PreRequisite.si_LoanProduct").equalsIgnoreCase("Title")) {
				/*
				 * Title
				 */
				ulterDataAndProcess(getData("titleLoan", tempData.get("PreRequisite.si_LoanDisbursment"), tempData),
						"titleLoan");
				new LoanTransactions_TitleLoan_PR(driver, allProcessData, report).titleLoan();

				ulterDataAndProcess(getData("transactionHistory_get", "getTitleData", tempData),
						"transactionHistory_get");
				new CustomerLoanHistory_PR(driver, allProcessData, report).transactionHistory_get();

			} else if (tempData.get("PreRequisite.si_LoanProduct").equalsIgnoreCase("LOC")) {
				/*
				 * LOC
				 */
				ulterDataAndProcess(getData("locLoan", tempData.get("PreRequisite.si_LoanDisbursment"), tempData),
						"locLoan");
				new LoanTransaction_NewLoan_LOC_PR(driver, allProcessData, report).locLoan();

				/*
				 * transactionHistory_get
				 */

				ulterDataAndProcess(getData("transactionHistory_get", "getLOCData", tempData),
						"transactionHistory_get");
				new CustomerLoanHistory_PR(driver, allProcessData, report).transactionHistory_get();

			} else if(tempData.get("PreRequisite.si_LoanProduct").equalsIgnoreCase("Installment")) {
			/*
			 * Installment
			 */
				ulterDataAndProcess(getData("InstallmentLoan", tempData.get("PreRequisite.si_LoanDisbursment"), tempData),
						"InstallmentLoan");
				new LoanTransactions_InstallmentLoan_PR(driver, allProcessData, report).InstallmentLoan();

				ulterDataAndProcess(getData("transactionHistory_get", "getINSTdata", tempData),
						"transactionHistory_get");
				new CustomerLoanHistory_PR(driver, allProcessData, report).transactionHistory_get();
			/*
			 * clockOut
			 */

/*			ulterDataAndProcess(getData("clockOut", "autoClockOut", tempData), "clockOut");
			new LoginQfundX_PR(driver, allProcessData, report).clockOut();
*/			
 			 
			ulterDataAndProcess(getData("logoutApplication", "Common_Logout", tempData), "logoutApplication");
			new LoginQfundX_PR(driver, allProcessData, report).logoutApplication();
		}
		}

	}

	public void CreateBulkLaon() throws Exception {
		int NoOfLoan = Integer.parseInt(tempData.get("CreateBulkLaon.NoOfLoans"));
		for (int i = 1; i <= NoOfLoan; i++) {
			try {

				ulterDataAndProcess(getData("searchbyApplicantDetails",
						tempData.get("CreateBulkLaon.searchbyApplicantDetails"), tempData), "searchbyApplicantDetails");

				new AppalicationSearch_PR(driver, allProcessData, report).searchbyApplicantDetails();

				if (tempData.get("CreateBulkLaon.Customer_LoanType").equalsIgnoreCase("Payday Loan")) {

					ulterDataAndProcess(getData("LoanDecisioningProcess", "Payday", tempData),
							"LoanDecisioningProcess");
					new LoanDecisioning_PR(driver, allProcessData, report).LoanDecisioningProcess();
					/*
					 * Payday
					 */
					ulterDataAndProcess(getData("payDayLoan", tempData.get("CreateBulkLaon.LoanDisbursment"), tempData),
							"payDayLoan");
					new PayDayLoan_PR(driver, allProcessData, report).payDayLoan();

				} else if (tempData.get("CreateBulkLaon.Customer_LoanType").equalsIgnoreCase("Title Loan")) {

					ulterDataAndProcess(getData("LoanDecisioningProcess", "Title", tempData), "LoanDecisioningProcess");
					new LoanDecisioning_PR(driver, allProcessData, report).LoanDecisioningProcess();
					/*
					 * Title
					 */
					ulterDataAndProcess(getData("titleLoan", tempData.get("CreateBulkLaon.LoanDisbursment"), tempData),
							"titleLoan");
					new LoanTransactions_TitleLoan_PR(driver, allProcessData, report).titleLoan();

				} else if (tempData.get("CreateBulkLaon.Customer_LoanType").equalsIgnoreCase("Line of Credit")) {
					ulterDataAndProcess(getData("LoanDecisioningProcess", "LOC", tempData), "LoanDecisioningProcess");
					new LoanDecisioning_PR(driver, allProcessData, report).LoanDecisioningProcess();
					/*
					 * LOC
					 */
					ulterDataAndProcess(getData("locLoan", tempData.get("CreateBulkLaon.LoanDisbursment"), tempData),
							"locLoan");
					new LoanTransaction_NewLoan_LOC_PR(driver, allProcessData, report).locLoan();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
