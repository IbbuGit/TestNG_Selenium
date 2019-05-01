package modules.PAM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.PAM.PAM_AppalicationSearch_PO;
import pageClasses.PAM.PAM_NewLoan_PO;
import pageClasses.PAM.PAM_SearchResult_PO;
import pageClasses.PAM.PAM_VerificationAction_PO;
import pageClasses.QFund.Qfund_Navigation;


public class LoanOrigination_PR extends Helper{


	public LoanOrigination_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void searchOnlineLoanbyPAM() throws Exception{
		
		Qfund_Navigation.Borrower.PAM();
		PAM_AppalicationSearch_PO objAppalicationSearch_PO= new PAM_AppalicationSearch_PO(driver, report);
		assertAreEqual("Appaliicant search Loaded successfully",report,objAppalicationSearch_PO.verifyAppalicantSearch(),true);
		
		objAppalicationSearch_PO.set_applicationStatus(data("applicationStatus"));
		objAppalicationSearch_PO.set_firstName(data("firstName"));
		objAppalicationSearch_PO.set_lastName(data("lastName"));
		objAppalicationSearch_PO.set_SSN(data("SSN"));
		objAppalicationSearch_PO.set_DOB(data("DOB"));
		objAppalicationSearch_PO.set_customerNbr(data("customerNbr"));
		objAppalicationSearch_PO.set_applicationNbr(data("loanNumber"));
		objAppalicationSearch_PO.set_phoneType(data("phoneType"));
		objAppalicationSearch_PO.set_phoneNum(data("phoneNumber"));
		String onlineDate = data("applicationDateFrom");
		if(!(onlineDate.isEmpty()))
		{
		String[] strArr= onlineDate.split("/");
		String formattedDate= strArr[1]+"/"+strArr[0]+"/"+strArr[2];
		objAppalicationSearch_PO.set_ApplicationDate(formattedDate,formattedDate);
		}
		else
		{
		objAppalicationSearch_PO.set_ApplicationDate(data("applicationDateFrom"),data("applicationDateTo"));
		}
		
		
		
		objAppalicationSearch_PO.click_submit_Button(data("submit"));
		assertAreEqual("No record found on searched criteria",report,objAppalicationSearch_PO.getNoRecordError(),false);
		
		PAM_SearchResult_PO objSearchResult_PO = new PAM_SearchResult_PO(driver,report);
		assertAreEqual("Search Result Loaded successfully",report,objSearchResult_PO.verifySearchResults(),true);
		validateTableData(objSearchResult_PO,"Source","Online");
		validateTableData(objSearchResult_PO,"Name",data("firstName"));
		validateTableData(objSearchResult_PO,"Name",data("lastName"));
		validateTableData(objSearchResult_PO,"CustNbr",data("customerNbr"));
		validateTableData(objSearchResult_PO,"DOB",data("DOB").replace("-", "/"));
		validateTableData(objSearchResult_PO,"SSN / ITIN",objSearchResult_PO.getSSNnumber(data("SSN")));
		objSearchResult_PO.click_GoButton("Y");
			
	}
	

	public void verificationActionPAM() throws Exception{
		
		PAM_VerificationAction_PO objVerificationAction_PO = new PAM_VerificationAction_PO(driver,report);
		
		objVerificationAction_PO.click_OtherReceived(data("otherReceived"));
		objVerificationAction_PO.click_OtherVerified(data("otherVerified"));
		objVerificationAction_PO.click_pofReceived(data("pofReceived"));
		objVerificationAction_PO.click_pofVerified(data("pofVerified"));
		objVerificationAction_PO.click_bpocReceived(data("bpocReceived"));
		objVerificationAction_PO.click_bpocVerified(data("bpocVerified"));
		objVerificationAction_PO.click_primaryPhoneVerified(data("primaryPhoneVerified"));
		if(data("applicationStatus").contains("Approve"))
		assertAreEqual("Validate Need E-Signature dorp down",report,objVerificationAction_PO.getApprovedAmount(),"Need E-Signature");	
		objVerificationAction_PO.set_verificationActionId(data("applicationStatus"));
		if(data("applicationStatus").equals("Denied"))
		objVerificationAction_PO.set_denialReason(data("denialReason"));
		objVerificationAction_PO.click_Submit_Button(data("Submit_Button"));
		if(data("applicationStatus").equals("Hold")){
			assertAreEqual("Loan Hold validation",report,objVerificationAction_PO.get_infoMessage("Y").contains("Hold"),true);}
		else if(data("applicationStatus").equals("Need Info/Docs")){
			assertAreEqual("Loan Needs More Documents validation",report,objVerificationAction_PO.get_infoMessage("Y").contains("Needs More Documents"),true);}
		else if(data("applicationStatus").equals("Denied")){
			assertAreEqual("Loan Denied validation",report,objVerificationAction_PO.get_infoMessage("Y").contains("Denied Successfully"),true);}
		
	}
	
	public void loanOriginationPAM() throws Exception
	{
		PAM_NewLoan_PO objPAM_NewLoan_PO = new PAM_NewLoan_PO(driver,report);
		objPAM_NewLoan_PO.click_FinishLoan_Button(data("finishLoan_btn"));
		objPAM_NewLoan_PO.clickyesButton(data("loanOriginationYes"));
		
	}


	public void validateTableData(PAM_SearchResult_PO objSearchResult_PO,String tableColName, String expect) throws Exception
	{
		if (!expect.isEmpty()) {
			List<String> data = objSearchResult_PO.getTableColumn(tableColName);
			for (String actual : data) {
				assertAreEqual("Search result table "+tableColName+" column match ",report,actual.toLowerCase(),expect.toLowerCase());
			}
		}
	}

	
}