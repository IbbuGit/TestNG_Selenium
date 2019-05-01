
package modules.QFund;
 
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.Qfund_Navigation;
import pageClasses.QFund.Reports_LoanReports_PO;
 
public class Reports_LoanReports_PR extends Helper {

	public Reports_LoanReports_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void rep_LoanReports() throws Exception {

		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

		switch (data("lr_PageHeader")) {

		case "Default Report":
			Qfund_Navigation.Reports_Tab.LoanReports.DefaultReport();
			break;
		case "PWO Report":
			Qfund_Navigation.Reports_Tab.LoanReports.PwoReport();
			break;
		case "Write Off Loans Report":
			Qfund_Navigation.Reports_Tab.LoanReports.WriteOffLoansReport();
			break;
		case "Returned Items Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ReturnedItemsReport();
			break;
		case "Sold Loan Report":
			Qfund_Navigation.Reports_Tab.LoanReports.SoldLoanReport();
			break;
		case "All Payments Report":
			Qfund_Navigation.Reports_Tab.LoanReports.AllPaymentsReport();
			break;
		case "Check Register Report":
			Qfund_Navigation.Reports_Tab.LoanReports.CheckRegisterReport();
			break;
		case "Outstanding Presentment report":
			Qfund_Navigation.Reports_Tab.LoanReports.OutStandingPresenetmentReport();
			break;
		case "Waive Fee Report":
			Qfund_Navigation.Reports_Tab.LoanReports.WaiveFeeReport();
			break;
		case "Refund Transaction Report":
			Qfund_Navigation.Reports_Tab.LoanReports.RefundTransactionReport();
			break;
		case "New Loan Report":
			Qfund_Navigation.Reports_Tab.LoanReports.NewLoanReport();
			break;
		case "Returned Items Inventory Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ReturnedItemsInventoryReport();
			break;
		case "Coupon Tracking Report":
			Qfund_Navigation.Reports_Tab.LoanReports.CouponTrackingReport();
			break;
		case "ACH Details Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ACHDetailsReport();
			break;
		case "Held Check Summary":
			Qfund_Navigation.Reports_Tab.LoanReports.HeldCheckSummary();
			break;
		case "ACH and RCC Activity Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ACHandRCCActivityReport();
			break;
		case "Active Prenote Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ActivePreNoteReport();
			break;
		case "Non-Center Payment Report":
			Qfund_Navigation.Reports_Tab.LoanReports.NonCenterPaymentReport();
			break;
		case "ACH Credit Rejection Report":
			Qfund_Navigation.Reports_Tab.LoanReports.ACHCreditRejectionReport();
			break;

		default:
			break;
		}

		assertAreEqual("Verification Point", report,
				objReports_LoanReports_PO.get_rep_PageHeader(data("lr_PageHeader")), data("lr_PageHeader"));

		if (!data("lr_PageHeader").equalsIgnoreCase("PWO Report")) {
			objReports_LoanReports_PO.click_rep_ResetButton("Click");
		}

		
		objReports_LoanReports_PO.set_lr_CustomerNbr(data("lr_CustomerNbr"));
		objReports_LoanReports_PO.set_lr_LoanNbr(data("lr_LoanNbr"));
		objReports_LoanReports_PO.set_lr_StoreNbr(data("lr_StoreNbr"));
		objReports_LoanReports_PO.set_lr_ProductType(data("lr_ProductType"));
		objReports_LoanReports_PO.set_lr_TransactionType(data("lr_TransactionType"));
		objReports_LoanReports_PO.set_apr_OwningStore(data("lr_OwningStore"));
		objReports_LoanReports_PO.set_ri_DepositType(data("lr_DepositType"));
		objReports_LoanReports_PO.set_ri_DepositActionType(data("lr_DepositActionType"));
		objReports_LoanReports_PO.set_ri_ReturnedReason(data("lr_ReturnedReason"));
		
		if (!data("lr_BeginDate").isEmpty()) {
			objReports_LoanReports_PO.set_BeginDate(
					objReports_LoanReports_PO.set_Add_DateMMDDYYYY(data("lr_BeginDate"), data("lr_BDAddDays")));
		}
		
		if (!data("lr_EndDate").isEmpty()) {

			objReports_LoanReports_PO.set_EndDate(
					objReports_LoanReports_PO.set_Add_DateMMDDYYYY(data("lr_EndDate"), data("lr_EDAddDays")));
		}
		
		objReports_LoanReports_PO.click_rep_SubmitButton(data("rep_SubmitButton"));

		objReports_LoanReports_PO.get_repError_EODnotcompletedfortheday(data("err_EODnotcompletedfortheday"));
		objReports_LoanReports_PO.get_repError_Page(data("err_Page"));

		assertAreEqual("Verification Point", report,
				objReports_LoanReports_PO.get_lr_ReportRecordsHeader(data("lr_RecordsHeader")),
				data("lr_RecordsHeader"));

		switch (data("lr_PageHeader")) {


		case "Default Report":
			lr_Default_ReportHeader();
			break;
		case "PWO Report":
			lr_PWO_ReportHeader();
			break;
		case "Write Off Loans Report":
			lr_WriteOffLoans_ReportHeader();
			break;
		case "Returned Items Report":
			lr_ReturnedItems_ReportHeader();
			break;
		case "Sold Loan Report":
			lr_SoldLoan_ReportHeader();
			break;
		case "All Payments Report":
			lr_Allpayments_ReportHeader();
			break;
		case "Check Register Report":
			lr_CheckRegister_ReportHeader();
			break;
		case "Outstanding Presentment report":
			lr_OutstandingPresentment_ReportHeader();
			break;
		case "Waive Fee Report":
			lr_WaiveFee_ReportHeader();
			break;
		case "Refund Transaction Report":
			lr_RefundTransaction_ReportHeader();
			break;
		case "New Loan Report":
			lr_NewLoan_ReportHeader();
			break;
		case "Returned Items Inventory Report":
			lr_ReturnedItemsInventory_ReportHeader();
			break;
		case "Coupon Tracking Report":
			lr_CouponTracking_ReportHeader();
			break;
		case "ACH Details Report":
			lr_ACHDetails_ReportHeader();
			break;
		case "Held Check Summary":
			lr_HeldCheckSummary_ReportHeader();
			break;
		case "ACH and RCC Activity Report":
			lr_ACHandRCCActivity_ReportHeader();
			break;
		case "Active Prenote Report":
			lr_ActivePrenote_ReportHeader();
			break;
		case "Non-Center Payment Report":
			lr_NonCenterPayment_ReportHeader();
			break;
		case "ACH Credit Rejection Report":
			lr_ACHCreditRejection_ReportHeader();
			break;
			
		default:
			break;
		}

		if (!data("rep_PrintButton").isEmpty()) {
			assertAreEqual("Before submission ", report, objReports_LoanReports_PO.isDisplayed_rep_PrintButton(),
					true);
			objReports_LoanReports_PO.click_rep_PrintButton(data("rep_PrintButton"));
		}
		if (!data("rep_GenerateExcelButton").isEmpty()) {
			assertAreEqual("Before submission ", report,
					objReports_LoanReports_PO.isDisplayed_rep_GenerateExcelButton(), true);

			objReports_LoanReports_PO.click_rep_GenerateExcelButton(data("rep_GenerateExcelButton"));
			if (objReports_LoanReports_PO.qfund_HandleChildWindow()) {
				// objReports_LoanReports_PO.click_eods_GenerateExcelButton(data("rep_GenerateExcelButton"));
			}

			try {
				objReports_LoanReports_PO.saveas_Windows_Robot(data("lr_PageHeader"));
				// saveFile_defaultlocation_Windows_Robot();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

	private void lr_ACHCreditRejection_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_NonCenterPayment_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_ActivePrenote_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_ACHandRCCActivity_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_HeldCheckSummary_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_ACHDetails_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_CouponTracking_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_ReturnedItemsInventory_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_NewLoan_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_RefundTransaction_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_WaiveFee_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_OutstandingPresentment_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_CheckRegister_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_Allpayments_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_SoldLoan_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_ReturnedItems_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_WriteOffLoans_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_PWO_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

	private void lr_Default_ReportHeader() {
		Reports_LoanReports_PO objReports_LoanReports_PO = new Reports_LoanReports_PO(driver, report);

	}

}
