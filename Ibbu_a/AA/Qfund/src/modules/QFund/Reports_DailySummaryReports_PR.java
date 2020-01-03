
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.Qfund_Navigation;
import pageClasses.QFund.Reports_DailySummaryReports_PO;

public class Reports_DailySummaryReports_PR extends Helper {

	public Reports_DailySummaryReports_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void rep_DailySummaryReports() throws Exception {

		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		switch (data("dsr_PageHeader")) {

		case "EOD Summary Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.EODSummary();
			break;
		case "Daily Transaction Journal":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.DailyTransactionJournal();
			break;
		case "Store Cash Management Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.StoreCashManagement();
			break;
		case "Voided Transactions Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.VoidedTransactions();
			break;
		case "Cash Over/Short Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.CashOverShortReport();
			break;
		case "Cash Balance Transaction Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.CashBalanceTransactionReport();
			break;
		case "Daily Center Summary Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.DailyCenterSummaryReport();
			break;
		case "Store Cash Management Summary Report":
			Qfund_Navigation.Reports_Tab.DailySummaryReports.StoreCashManagementSummaryReport();
			break;

		default:
			break;
		}

		assertAreEqual("Verification Point", report,
				objReports_DailySummaryReports_PO.get_dsr_PageHeader(data("dsr_PageHeader")), data("dsr_PageHeader"));

		// objReports_DailySummaryReports_PO.set_dsr_StoreNbr(data("dsr_StoreNbr"));
		objReports_DailySummaryReports_PO.set_dtj_TransactionType(data("dsr_TransactionType"));
		if (!data("dsr_BeginDate").isEmpty()) {
			objReports_DailySummaryReports_PO.set_BeginDate(objReports_DailySummaryReports_PO
					.set_Add_DateMMDDYYYY(data("dsr_BeginDate"), data("dsr_BDAddDays")));
		}
		if (!data("dsr_EndDate").isEmpty()) {

			objReports_DailySummaryReports_PO.set_EndDate(
					objReports_DailySummaryReports_PO.set_Add_DateMMDDYYYY(data("dsr_EndDate"), data("dsr_EDAddDays")));
		}
		objReports_DailySummaryReports_PO.click_dsr_SubmitButton(data("dsr_SubmitButton"));

		objReports_DailySummaryReports_PO.click_dsr_ResetButton(data("dsr_ResetButton"));

		objReports_DailySummaryReports_PO.get_Error_EODnotcompletedfortheday(data("err_EODnotcompletedfortheday"));
		objReports_DailySummaryReports_PO.get_Error_Page(data("err_Page"));

		assertAreEqual("Verification Point", report,
				objReports_DailySummaryReports_PO.get_dsr_ReportRecordsHeader(data("dsr_RecordsHeader")),
				data("dsr_RecordsHeader"));

		switch (data("dsr_PageHeader")) {

		case "EOD Summary Report":
			dsr_EODSummary();
			break;
		case "Daily Transaction Journal":
			dsr_DailyTransactionJournalReport();
			break;
		case "Store Cash Management Report":
			dsr_StoreCashManagement();
			break;
		case "Voided Transactions Report":
			dsr_VoidedTransactions();
			break;
		case "Cash Over/Short Report":
			dsr_CashOverShortReport();
			break;
		case "Cash Balance Transaction Report":
			dsr_CashBalanceTransactionReport();
			break;
		case "Daily Center Summary Report":
			dsr_DailyCenterSummaryReport();
			break;
		case "Store Cash Management Summary Report":
			dsr_StoreCashManagementSummaryReport();
			break;

		default:
			break;
		}

		if (!data("rep_PrintButton").isEmpty()) {
			assertAreEqual("Before submission ", report,
					objReports_DailySummaryReports_PO.isDisplayed_eods_PrintButton(), true);
			objReports_DailySummaryReports_PO.click_eods_PrintButton(data("rep_PrintButton"));
		}
		if (!data("rep_GenerateExcelButton").isEmpty()) {
			assertAreEqual("Before submission ", report,
					objReports_DailySummaryReports_PO.isDisplayed_eods_GenerateExcelButton(), true);
			
			objReports_DailySummaryReports_PO.click_eods_GenerateExcelButton(data("rep_GenerateExcelButton"));
			if (objReports_DailySummaryReports_PO.qfund_HandleChildWindow()) {
				//objReports_DailySummaryReports_PO.click_eods_GenerateExcelButton(data("rep_GenerateExcelButton"));
			}

			try {
				objReports_DailySummaryReports_PO.saveas_Windows_Robot(data("ReportType"));
				// saveFile_defaultlocation_Windows_Robot();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void dsr_EODSummary() throws Exception {

		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_eods_Verify_BeginningBalance(data("eods_BeginningBalance"));
		objReports_DailySummaryReports_PO
				.get_eods_SCD_Verify_TotalDepositedAmount(data("eods_SCD_TotalDepositedAmount"));

	}

	public void dsr_DailyTransactionJournalReport() throws Exception {

		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_dtjr_Verify_TotalIssChkAmount(data("dtjr_TotalIssChkAmount"));
		objReports_DailySummaryReports_PO.get_dtjr_Verify_TotalTranAmount(data("dtjr_TotalTranAmount"));

	}

	public void dsr_StoreCashManagement() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_scm_Verify_SafeOpeningBal(data("scm_Verify_SafeOpeningBal"));
		objReports_DailySummaryReports_PO
				.get_scm_Verify_TotalLoanChecksDeposited(data("scm_Verify_TotalLoanChecksDeposited"));

	}

	public void dsr_VoidedTransactions() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_vt_Verify_TotalFeeAmount(data("vt_Verify_TotalFeeAmount"));
		objReports_DailySummaryReports_PO.get_vt_Verify_TotalPrinAmount(data("vt_Verify_TotalPrinAmount"));
		objReports_DailySummaryReports_PO
				.get_WebElement_DynamicValueXpath_vt_xpath_CustomerNbr(data("dsr_CustomerNbr"));
		objReports_DailySummaryReports_PO.get_WebElement_DynamicValueXpath_vt_xpath_LoanNbr(data("dsr_LoanNbr"));
	}

	public void dsr_CashOverShortReport() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_cos_Verify_StoreNbr(data("dsr_StoreNbr"));
		objReports_DailySummaryReports_PO.get_cos_Verify_TranType(data("cos_Verify_TranType"));
		objReports_DailySummaryReports_PO.get_cos_Verify_OverShortAmt(data("cos_Verify_OverShortAmt"));
		objReports_DailySummaryReports_PO.get_cos_Verify_EmpName(data("cos_Verify_EmpName"));

	}

	public void dsr_CashBalanceTransactionReport() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_cbt_Verify_StoreNbr(data("dsr_StoreNbr"));
		objReports_DailySummaryReports_PO.get_cbt_Verify_CountCashBal(data("cbt_Verify_CountCashBal"));
		objReports_DailySummaryReports_PO.get_cbt_Verify_CalCashBal(data("cbt_Verify_CalCashBal"));
		objReports_DailySummaryReports_PO.get_cbt_Verify_OverShortAmt(data("cbt_Verify_OverShortAmt"));
	}

	public void dsr_StoreCashManagementSummaryReport() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_scms_Verify_StoreNbr(data("dsr_StoreNbr"));
		objReports_DailySummaryReports_PO.get_scms_Verify_OpeningBalance(data("scms_Verify_OpeningBalance"));
		objReports_DailySummaryReports_PO.get_scms_Verify_TotPenny(data("scms_Verify_TotPenny"));

	}

	public void dsr_DailyCenterSummaryReport() throws Exception {
		Reports_DailySummaryReports_PO objReports_DailySummaryReports_PO = new Reports_DailySummaryReports_PO(driver,
				report);

		objReports_DailySummaryReports_PO.get_cbt_Verify_StoreNbr(data("dsr_StoreNbr"));

	}

}
