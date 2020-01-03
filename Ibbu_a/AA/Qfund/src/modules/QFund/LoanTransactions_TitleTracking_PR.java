package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.LoanTransaction_TitleTracking_SearchResults_PO;
import pageClasses.QFund.LoanTransaction_TitleTracking_TitleTrackingSearch_PO;
import pageClasses.QFund.Qfund_Navigation;

public class LoanTransactions_TitleTracking_PR extends Helper {

	public LoanTransactions_TitleTracking_PR(WebDriver _driver, LinkedHashMap<String, String> data,
			ExtentTest report) {
		super(_driver, data, report);
	}

	public void titleTracking() throws Exception {
	
	Qfund_Navigation.Loan_Transaction.Title_Loan.Title_Tracking();

	LoanTransaction_TitleTracking_TitleTrackingSearch_PO objTitleTrackingSearch_PO=new LoanTransaction_TitleTracking_TitleTrackingSearch_PO(driver, report);
	objTitleTrackingSearch_PO.set_loanNbr(data("Cust_LoanNumber"));
	objTitleTrackingSearch_PO.click_submit_Button("Y");
	
	LoanTransaction_TitleTracking_SearchResults_PO objLoanTransaction_TitleTracking_SearchResults_PO=new LoanTransaction_TitleTracking_SearchResults_PO(driver, report);
	objLoanTransaction_TitleTracking_SearchResults_PO.click_select_checkBox("Y");
	objLoanTransaction_TitleTracking_SearchResults_PO.title_Track_Id_ListBox(data("TrackIDListBox"));
	objLoanTransaction_TitleTracking_SearchResults_PO.click_submit_Button("Y");
	assertAreEqual("Assertion for titleTracking ", report,true, true);
	
	}

}
