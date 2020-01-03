package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.BorrowerRegistrationBanking_PO;
import pageClasses.QFund.BorrowerRegistrationPersonal_PO;
import pageClasses.QFund.Borrower_Collections_PO;
import pageClasses.QFund.CustomerLoanHistory_PO;
import pageClasses.QFund.LoanTransactions_Transactions_Title_PO;
import pageClasses.QFund.Qfund_Navigation;

/**
 * @author VIVEK V
 *
 */
public class Borrower_Collections_PR extends Helper {

	public Borrower_Collections_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void collectionsSearch() throws Exception {

		if (data("DataName").contains("PAM")) {

			Qfund_Navigation.Borrower.Collectionspam();
		} else {

			Qfund_Navigation.Borrower.Collections();
		}

		/*
		 * if (Qfund_Navigation.Collections.isDisplayed()) {
		 * Qfund_Navigation.Borrower.Collections(); } else {
		 * Qfund_Navigation.Borrower.Collectionspam(); }
		 */

		// Collections General Flow
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		// objBorrower_Collections_PO.searchByCustomerDetails("Collections_SSNumber",data("Collections_SSNumber"));
		objBorrower_Collections_PO.searchByCustomerDetails(processName, allProcessData);
		assertAreEqual("Verifying the Customer Number", report,objBorrower_Collections_PO.get_Collections_SearchResults_CustNbr("CustomberNbr"),data("Verify_CustomerNbr"));
		objBorrower_Collections_PO.click_Collections_SearchResults_Ok_Button("Y");
		
		String AmountdueBF = objBorrower_Collections_PO.get_Collections_Loan_AmountDue("get");
		System.out.println("Amount Due before TR:" + AmountdueBF);
	}

	public void collectionsEffort() throws Exception {

		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);

		String NextPaydate = objBorrower_Collections_PO.get_Coll_Nextpayday();

		updateDataSheet("Coll_NextPayDay", objBorrower_Collections_PO.get_Coll_Nextpayday());

		// Collections Effort
		objBorrower_Collections_PO.set_Collections_CEActions(data("CEActions"));
		objBorrower_Collections_PO.set_Collections_CEResult(data("CEResult"));
		objBorrower_Collections_PO.set_Collections_CEFollowUpDate(data("CEFollowUpDate"));
		objBorrower_Collections_PO.set_Collections_CEComments("Good");

		// PTP Promise to Pay
		if (data("CEResult").equalsIgnoreCase("Promise to pay")) {
			objBorrower_Collections_PO.set_Collections_PaymentDate(objBorrower_Collections_PO.get_Coll_Nextpayday());

			// objBorrower_Collections_PO.set_Collections_PaymentDate(data("Coll_NextPayDay"));
			objBorrower_Collections_PO.set_Collections_PaymentAmount(data("CEPaymentAmt"));
			objBorrower_Collections_PO.acceptAlerttext();
			String Paymentamt = objBorrower_Collections_PO.get_Collections_PaymentAmount("CEPaymentAmt");
			objBorrower_Collections_PO.set_Collections_PaymentType(data("CEPaymentType"));
			objBorrower_Collections_PO.set_Collections_PaymentNotes(data("CEPaymentNotes"));
			objBorrower_Collections_PO.click_Collections_AddPaymentbtn(data("CEAddPayments"));
		}

		objBorrower_Collections_PO.click_Collections_CESave_Button("Y");
		objBorrower_Collections_PO.acceptAlert();

		// Collections History
		if (data("CEResult").equalsIgnoreCase("Filing Bankruptcy")) {
			assertAreEqual("Verifying in the Collections History", report,
					objBorrower_Collections_PO.get_Collections_CHComments("CEComments"), "Good");
		}
		assertAreEqual("Verifying in the Collections History", report,
				objBorrower_Collections_PO.get_Collections_CHUser("CH_user"), data("CH_user"));
		assertAreEqual("Verifying in the Collections History", report,
				objBorrower_Collections_PO.get_Collections_CHAction("CEActions"), data("CEActions"));
		assertAreEqual("Verifying in the Collections History", report,
				objBorrower_Collections_PO.get_Collections_CHResponse("CEResult"), data("CEResult"));

	}

	public void collectionsMakepayment() throws Exception

	{
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_MakePaymentBtn("Y");
		objBorrower_Collections_PO.switchToChildWindow();
		LoanTransactions_Transactions_Title_PO objLoanTransactions_Transactions_Title_PO = new LoanTransactions_Transactions_Title_PO(
				driver, report);

		objLoanTransactions_Transactions_Title_PO.set_ts_paytype(data("LnPymnt_type"));
		objLoanTransactions_Transactions_Title_PO.set_ts_PayAny_Other(data("PayOtherAmt"));
		objLoanTransactions_Transactions_Title_PO.set_ts_Tender_Type1(data("Tender_T1"));
		if (data("CCMO_Nbr").equalsIgnoreCase("Random")) {
			objLoanTransactions_Transactions_Title_PO.set_ts_Tender_CCMONBR(getRandomNumeric(9));
		} else {
			objLoanTransactions_Transactions_Title_PO.set_ts_Tender_CCMONBR(data("CCMO_Nbr"));
		}
		objLoanTransactions_Transactions_Title_PO
				.set_ts_Tender_Amt1(objLoanTransactions_Transactions_Title_PO.get_ts_PayAny_Other("get"));
		objLoanTransactions_Transactions_Title_PO.set_ts_Drawer_PIN(data("Drawer_PIN"));
		objLoanTransactions_Transactions_Title_PO.click_ts_Finsih_Button(data("Finsih_Button"));
		Thread.sleep(4000);
		if (!data("LnPymnt_type").equalsIgnoreCase("Pay Off the balance")) {
			objLoanTransactions_Transactions_Title_PO.click_ts_RenewLoanButton(data("Lnpymnt_RenewLoan"));
		}
		assertAreEqual("Verifyig payment process message", report,
				objLoanTransactions_Transactions_Title_PO.get_ts_Confirm_Text(data("LnPymnt_Confirm_Text")),
				data("LnPymnt_Confirm_Text"));
		objLoanTransactions_Transactions_Title_PO.click_ts_Payment_Confirm("Y");
		objBorrower_Collections_PO.switchToParentWindow();
		String AmountdueAF = objBorrower_Collections_PO.get_Collections_Loan_AmountDue("get");
		System.out.println("Amount Due after TR:" + AmountdueAF);
		
	}

	public void collectionsSearchByQueue() throws Exception {

		Qfund_Navigation.Borrower.Collections();

		// Collections General Flow Search By Queue
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.searchByQueue(processName, allProcessData);
		// assertAreContain("Verifying the Customer Number", report,
		// objBorrower_Collections_PO.get_Collections_SearchResults_CustNbr("CustomberNbr"),
		// data("CustomberNbr"));
		assertAreEqual("Verifying the Visiblity of the Ok Button", report, true,objBorrower_Collections_PO.Collections_SearchResults_Ok_Button());
		
		objBorrower_Collections_PO.click_WebElementForDynamicString(data("CustomerNbr"));

		
	}

	public void collectionsCustomerRecord() throws Exception

	{
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_CustRecord_Btn("Y");
		objBorrower_Collections_PO.switchToChildWindow();
		BorrowerRegistrationPersonal_PO objBorrowerRegistrationPersonal_PO = new BorrowerRegistrationPersonal_PO(driver,
				report);

		String fname = objBorrowerRegistrationPersonal_PO.get_BrwrRegPrsnl_firstName("get");
		assertAreEqual("Verifying First Name", report, fname.toUpperCase(), data("fname"));

		String SSN = objBorrowerRegistrationPersonal_PO.get_BrwrRegPrsnl_ssnLast("get");
		assertAreEqual("Verifying the Last 4 SSN", report, SSN, data("SSN"));

		BorrowerRegistrationBanking_PO objBorrowerRegistrationBanking_PO = new BorrowerRegistrationBanking_PO(driver,
				report);

		String AccNbr = objBorrowerRegistrationBanking_PO.get_BrwrRegBnkng_chkgAcctNbr("get");
		assertAreEqual("Verifying  Account Number", report, AccNbr, data("AccountNbr"));

		String RouningNbr = objBorrowerRegistrationBanking_PO.get_BrwrRegBnkng_routingNbr("get");
		assertAreEqual("Verifying  Account Number", report, RouningNbr, data("RouningNbr"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();

	}

	public void collectionsPTPHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_PTPHist_Btn("Y");
		objBorrower_Collections_PO.switchToChildWindow();
		// assertAreEqual("Verifying the PTP Amount to Pay",
		// report,objBorrower_Collections_PO.get_Collections_PTPpaymentAmt("get"),data("PTPAmount"));
		// assertAreEqual("Verifying in the PTP Date the Customer needs to pay",
		// report,objBorrower_Collections_PO.get_Collections_PTPpaymentDt("get"),data("PTPTRDate"));
		assertAreEqual("Verifying in the Collections TR Type", report,
				objBorrower_Collections_PO.get_Collections_PTPpaymentTrType("get"), "Promise To Pay");
		assertAreEqual("Verifying in the Collections PTP Status", report,
				objBorrower_Collections_PO.get_Collections_PTPStatus("get"), data("PTPStatus"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();

	}

	public void collectionsVehicleHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_VehicleHist_Btn("Y");
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying the Vehicles Details VIN", report,
				objBorrower_Collections_PO.get_Collections_VehicleHist_VIN("get"), data("VIN"));
		assertAreEqual("Verifying the Vehicles History Make", report,
				objBorrower_Collections_PO.get_Collections_VehicleHist_Make("get"), data("VehHist_Make"));
		assertAreEqual("Verifying the Vehicles History Model", report,
				objBorrower_Collections_PO.get_Collections_VehicleHist_Model("get"), data("VehHist_Model"));
		assertAreEqual("Verifying the Vehicles History Year", report,
				objBorrower_Collections_PO.get_Collections_VehicleHist_Year("get"), data("VehHist_Year"));
		assertAreEqual("Verifying the Vehicles History BlackBook Value", report,
				objBorrower_Collections_PO.get_Collections_VehicleHist_BlackBookValue("get"),
				data("VehHist_BlackBookVal"));
		//assertAreEqual("Verifying the Vehicles History Vehicle Status", report,objBorrower_Collections_PO.get_Collections_VehicleHist_VehicleStatus("get"), data("VehHist_VehStatus"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();
	}

	public void collectionsTranscationHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_TransHistory_Btn("Y");
		objBorrower_Collections_PO.switchToChildWindow();
		collections_TransLoanHistory();
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();

	}

	public void collectionsPaymentSchedule() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_PaySchedule_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtDate("get"), data("PaymentSch_PmtDate"));
		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtAmt("get"), data("PaymentSch_PmtAmt"));
		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtDays("get"), data("PaymentSch_PmtDays"));
		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtStatus("get"), data("PaymentSch_PmtStatus"));
		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtInt("get"), data("PaymentSch_PmtInt"));
		assertAreEqual("Verifying the Payment Schedule Details", report,
				objBorrower_Collections_PO.get_Collections_PaymentSch_PmtBal("get"), data("PaymentSch_PmtBal"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();
	}

	public void collectionsNotesHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_NotesHist_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();
		objBorrower_Collections_PO.set_Collections_Notes(data("NotesComments"));
		objBorrower_Collections_PO.click_Collections_Urgent_chkbox("Y");
		objBorrower_Collections_PO.click_Collections_Submitbtn("Y");

		assertAreEqual("Verifying the Notes History Details", report,
				objBorrower_Collections_PO.get_colllections_NotesUrgent("get"), data("NotesUrgent"));
		assertAreEqual("Verifying the Notes History Details", report,
				objBorrower_Collections_PO.get_colllections_NotesModules("get"), data("NotesModules"));
		assertAreEqual("Verifying the Notes History Details", report,
				objBorrower_Collections_PO.get_colllections_NotesComments("get"), data("NotesComments"));
		assertAreEqual("Verifying the Notes History Details", report,
				objBorrower_Collections_PO.get_colllections_Notesby("get"), data("Notesby"));
		// assertAreEqual("Verifying the Notes History Details",
		// report,objBorrower_Collections_PO.get_colllections_Notesdate("get"),data("Notesdate"));
		assertAreEqual("Verifying the Notes History Details", report,
				objBorrower_Collections_PO.get_colllections_NotesLoanNbr("get"), data("NotesLoanNbr"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();
	}

	public void collectionsEmailHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_EmailHist_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying the Notes EmailHist Details", report,
				objBorrower_Collections_PO.get_collections_Emailemailid("get"), data("EmailID"));
		assertAreEqual("Verifying the Notes EmailHist Details", report,
				objBorrower_Collections_PO.get_collections_EmailLoanNbr("get"), data("EmailLoanNbr"));
		assertAreEqual("Verifying the Notes EmailHist Details", report,
				objBorrower_Collections_PO.get_collections_EmailDesc("get"), data("EmailDesc"));
		assertAreEqual("Verifying the Notes EmailHist Details", report,
				objBorrower_Collections_PO.get_colllections_EmailResponse("get"), data("EmailResponse"));
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();
	}

	public void collectionsSummaryView() throws Exception {

		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_CustSummary_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying in the Summary View details", report,objBorrower_Collections_PO.get_collections_SummaryView_Dob("get"), data("ColSummaryView_Dob"));
		assertAreEqual("Verifying in the Summary View details", report,objBorrower_Collections_PO.get_collections_SummaryView_Emailid("get"), data("ColSummaryView_Emailid"));
		//assertAreEqual("Verifying in the Summary View details", report,objBorrower_Collections_PO.get_collections_SummaryView_Photoid("get"), data("ColSummaryView_Photoid"));
		assertAreEqual("Verification of Product Type", report, objBorrower_Collections_PO.get_product_Type("get"),data("Coll_product_Type"));
		assertAreEqual("Verification of Loan Number", report, objBorrower_Collections_PO.get_loan_Nbr("get"),data("Coll_LoanNbr"));
		assertAreEqual("Verification of Loan Number", report, objBorrower_Collections_PO.get_next_Due_Date("get"),data("Coll_NextDueDate"));

		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();

	}

	public void collectionsSMSHistory() throws Exception {
		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_SMSHist_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying the Collections Table Heading", report,
				objBorrower_Collections_PO.get_Coll_THeading("get"), "SMS History");
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();
	}

	public void collectionsLetterHistory() throws Exception {

		Borrower_Collections_PO objBorrower_Collections_PO = new Borrower_Collections_PO(driver, report);
		objBorrower_Collections_PO.click_Collections_LetterHist_Btn(("Y"));
		objBorrower_Collections_PO.switchToChildWindow();

		assertAreEqual("Verifying the Collections Table Heading", report,
				objBorrower_Collections_PO.get_Coll_THeading("get"), "Letters History");
		objBorrower_Collections_PO.closeWindow();
		objBorrower_Collections_PO.switchToParentWindow();

	}

	public void collections_TransLoanHistory() throws Exception {
		CustomerLoanHistory_PO objCustomerLoanHistory_Pages = new CustomerLoanHistory_PO(driver, report);

		boolean bFound = false;
		for (String col : allProcessData.keySet()) {

			if (col.equals("collectionsTranscationHistory.History_CustomerName")) {
				bFound = true;
			}

			if (!allProcessData.get(col).isEmpty()) {
				if (bFound) {
					if (col.contains("EOC")) {
						bFound = false;

					}
					String Excpected = allProcessData.get(col);
					String Actual = (String) objCustomerLoanHistory_Pages.getClass()
							.getDeclaredMethod("get_" + col.replace("collectionsTranscationHistory.", ""), String.class)
							.invoke(objCustomerLoanHistory_Pages, allProcessData.get(col));
					verifyAreEqual("Verify Field[" + col + "] value", report, Excpected, Actual.trim());

				}

			}

		}

	}

}
