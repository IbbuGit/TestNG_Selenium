package modules.QFund;

import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Driver;
import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.QfundAdmin_Navigation;
import pageClasses.QFund.Qfund_Navigation;

public class AppalicationSearch_PR extends Helper{

 
	public AppalicationSearch_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}


	public void searchbyApplicantDetails() throws Exception{
		
		AppalicationSearch_PO objAppalicationSearch= new AppalicationSearch_PO(driver, report);
		
		if(data("SearchType").equalsIgnoreCase("Customer")) {			
			Qfund_Navigation.Borrower.Edit();
		}else if(data("SearchType").equalsIgnoreCase("NewLoan")) {			
			Qfund_Navigation.Loan_Transaction.New_Loan();
		}else if(data("SearchType").equalsIgnoreCase("PostDefaultTransactions")) {			
			QfundAdmin_Navigation.Transactions_Tab.TitleLoanTab.PostDefaultTransactions();		
		}
		
		assertAreEqual("Applicant Search Loaded successfully",report,objAppalicationSearch.verifyAppalicantSearch(),true);		
		objAppalicationSearch.set_as_storeId(data("as_storeId"));
		objAppalicationSearch.set_AppSch_AppSch_FirstName(data("First_Name"));
		objAppalicationSearch.set_AppSch_LastName(data("Last_Name"));
		objAppalicationSearch.set_AppSch_SSN(data("SSN"));		
		
		String customerNbr=null;
		if(data("Customer_Nbr").equalsIgnoreCase("FromOutputSheet")) {
			customerNbr=Helper.ReadCSV_getRowDataForMatch(Driver.configDataPath+"\\QFundOutputData.csv","DataName=NewCustomer,ProductType="+data("LoanType"),false).get(0).get("CustomerNbr");
			if(customerNbr!=null) {Helper.updateOutPutData("CustomerNbr="+customerNbr, "DataName", "NewLoan");}
		}else {customerNbr=data("Customer_Nbr");}
		
		if(customerNbr!=null) {updateDataSheet("Customer_Nbr", customerNbr);}
		
		objAppalicationSearch.set_AppSch_CustomerNbr(customerNbr);
		
		objAppalicationSearch.set_AppSch_LoanNbr(data("Loan_nbr"));
		objAppalicationSearch.set_AppSch_PhoneNbr(data("Phone_Nbr"));
		objAppalicationSearch.set_AppSch_MigratedCustomerID(data("Migrated_CustomerId"));
		objAppalicationSearch.set_AppSch_MigratedLoanID(data("Migrated_LoanId"));
		objAppalicationSearch.set_as_Status(data("as_Status"));

		objAppalicationSearch.click_AppSch_Submit(data("AppSch_Submit"));
		objAppalicationSearch.click_AppSch_Select_Customer(data("AppSch_Select_Customer"));
	}



}