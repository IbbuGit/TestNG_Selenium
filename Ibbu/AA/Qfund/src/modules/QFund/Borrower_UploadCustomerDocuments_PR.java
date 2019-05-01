
package modules.QFund;

import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.AppalicationSearch_PO;
import pageClasses.QFund.Borrower_UploadCustomerDocs_PO;
import pageClasses.QFund.Qfund_Navigation;


public class Borrower_UploadCustomerDocuments_PR extends Helper{

	public Borrower_UploadCustomerDocuments_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void uploadCustomerDocs() throws Exception
	{

		Qfund_Navigation.Borrower.Upload_Customer_Documents();

		AppalicationSearch_PO objAppalicationSearch_PO = new AppalicationSearch_PO(driver, report);
		objAppalicationSearch_PO.set_AppSch_SSN(data("Cust_SSN"));
		/*objAppalicationSearch_PO.set_AppSch_LoanNbr(data("Loan_Nbr"));
		objAppalicationSearch_PO.set_AppSch_CustomerNbr(data("Cust_Nbr"));
		objAppalicationSearch_PO.set_AppSch_LastName(data("Cust_LastName"));
		objAppalicationSearch_PO.set_AppSch_AppSch_FirstName(data("Cust_FirstName"));*/

		objAppalicationSearch_PO.click_AppSch_Submit(data("AppSch_Submit"));
		objAppalicationSearch_PO.click_AppSch_Select_Customer(data("AppSch_Select_Customer"));

		Borrower_UploadCustomerDocs_PO objBorrower_UploadCustomerDocs_PO = new Borrower_UploadCustomerDocs_PO(driver, report);
		objBorrower_UploadCustomerDocs_PO.click_setCustDocs_Upload(data("Customer_Upload"));
		Thread.sleep(3000);
		objBorrower_UploadCustomerDocs_PO.click_setCustDocs_Upload(data("Upload_Docs"));
		objBorrower_UploadCustomerDocs_PO.uploadFile(data("Filepath1"));
		Thread.sleep(3000);
		objBorrower_UploadCustomerDocs_PO.click_setSubmit_Docs(data("Submit_Docs"));
		Thread.sleep(3000);
		objBorrower_UploadCustomerDocs_PO.click_setok_button(data("Ok_button"));

	}


}
