package pageClasses.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author VKumar
 *
 */
public class Borrower_Collections_PO extends BasePage {

	/**
	 * @param _driver
	 * @param report
	 */
	public Borrower_Collections_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}


	@FindBy(className ="toggler")
	private WebElement Collections_Sidebar_Button;

	@FindBy(xpath ="//a[@aria-controls='collapseOne']")
	public WebElement Collections_SearchByCustomer_Button;

	@FindBy(xpath ="//a[@aria-controls='collapseTwo']")
	private WebElement Collections_SearchByQueue_Button;	

	@FindBy(xpath ="//a[@aria-controls='collapseFour']")
	private WebElement Collections_FundsVerification_Button;


	@FindBy(xpath ="//input[@id='storeNbr']")
	private WebElement Collections_StoreNbr;

	@FindBy(xpath ="//button[contains(@onclick,'search(')]")
	private WebElement Collections_Search_Button;


	@FindBy(name = "fname")
	private WebElement Collections_FirstName;

	@FindBy(name = "lname")
	private WebElement Collections_LastName;

	@FindBy(name = "ssn")
	private WebElement Collections_SSNumber;

	@FindBy(name = "email")
	private WebElement Collections_Email;

	@FindBy(name = "loanNbr")
	private WebElement Collections_LoanNbr;

	@FindBy(name = "bnkAcntNbr")
	private WebElement Collections_BankNumber;

	@FindBy(name = "queueProduct")
	private WebElement Collections_ProductType_Queue;

	@FindBy(name = "queue")
	private WebElement Collections_QueueName_Queue;

	@FindBy(xpath="//input[(@value='pd') and (@type='radio')]")
	private WebElement Collections_Funds_PastDue_Button;

	@FindBy(xpath="//input[(@value='rtn') and (@type='radio')]")
	private WebElement Collections_Funds_Returned_Button;


	@FindBy(xpath="//input[(@value='nsf') and (@type='checkbox')]")
	private WebElement Collections_Funds_RNSF_Button;

	@FindBy(xpath="//input[(@value='sp') and (@type='checkbox')]")
	private WebElement Collections_Funds_RStopPayment_Button;

	@FindBy(xpath="//input[(@value='ac') and (@type='checkbox')]")
	private WebElement Collections_Funds_RACCClosed_Button;

	@FindBy(xpath="//input[(@value='oth') and (@type='checkbox')]")
	private WebElement Collections_Funds_ROther_Button;

	@FindBy(xpath="//input[(@value='all') and (@type='checkbox')]")
	private WebElement Collections_Funds_RAll_Button;


	@FindBy(xpath="//input[(@value='wo') and (@type='radio')]")
	private WebElement Collections_Funds_WriteOff_Button;


	@FindBy(name = "startDt")
	private WebElement Collections_Funds_WStartDate;

	@FindBy(name = "endDt")
	private WebElement Collections_Funds_WEndDate;


	@FindBy(xpath="//table[@id='results']/tbody/tr[3]/td[16]")
	private WebElement Collections_SearchResults_CustNbr;

	@FindBy(xpath="//table[@id='results']/tbody/tr[3]/td[19]/input[@name='myButton']")
	private WebElement Collections_SearchResults_Ok_Button;
	

	
	public String xpathStrig_prefix="//table/tbody//tr//td[16][text()=";

	public String xpathStrig_suffix="]/following-sibling::td[3]/input[@name='myButton']";
	
	
	

	// Collections Effort

	@FindBy(xpath="//select[@id='actions']")
	private WebElement Collections_CEActions;

	@FindBy(xpath="//select[@id='result']")
	private WebElement Collections_CEResult;

	@FindBy(id="followUpDt")
	private WebElement Collections_CEFollowUpDate;

	@FindBy(id="comments")
	//@FindBy(xpath="//textarea[@id='comments' and @placeholder='Notes']")
	private WebElement Collections_CEComments;

	@FindBy(xpath ="//button[contains(@onclick,'submitCollData')]")
	private WebElement Collections_CESave_Button;


	// Collections History
	@FindBy(xpath="//table[@id='workHist']/tbody/tr/th")
	private WebElement Collections_CHHeading;

	@FindBy(xpath="//table[@id='workHist']/tbody/tr[3]/td[1]")
	private WebElement Collections_CHDate;

	@FindBy(xpath="//table[@id='workHist']/tbody/tr[3]/td[2]")
	private WebElement Collections_CHUser;

	@FindBy(xpath="//table[@id='workHist']/tbody/tr[3]/td[3]")
	private WebElement Collections_CHAction;

	@FindBy(xpath="//table[@id='workHist']/tbody/tr[3]/td[4]")
	private WebElement Collections_CHResponse;

	@FindBy(xpath="//table[@id='workHist']/tbody/tr[3]/td[5]")
	private WebElement Collections_CHComments;
	
	
	// Payment Info
	
	@FindBy(xpath="//input[@id='payDt']")
	private WebElement Collections_PaymentDate;
	
	@FindBy(xpath="//input[@id='payAmt']")
	private WebElement Collections_PaymentAmount;
	
	@FindBy(xpath="//select[@id='payType']")
	private WebElement Collections_PaymentType;
		
	@FindBy(xpath="//input[@id='payNote']")
	private WebElement Collections_PaymentNotes;
		
	@FindBy(xpath="//button[contains(@onclick,'return addPay')]")
	private WebElement Collections_AddPaymentbtn;
	
	
	// MULTIPLE ACTS
	
	@FindBy(xpath="//button[contains(@onclick,'custView')]")
	private WebElement Collections_CustRecord_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'custSummery')]")
	private WebElement Collections_CustSummary_Btn;

	@FindBy(xpath="//button[contains(@onclick,'tranHistory')]")
	private WebElement Collections_TransHistory_Btn;
	
	@FindBy(xpath="//button[@id='makePay']")
	private WebElement Collections_MakePaymentBtn;
		
	@FindBy(xpath="//button[contains(@onclick,'letterHist')]")
	private WebElement Collections_LetterHist_Btn;
	
	@FindBy(xpath="//button[@id='paySchedule']")
	private WebElement Collections_PaySchedule_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'ptpHist')]")
	private WebElement Collections_PTPHist_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'smsHist')]")
	private WebElement Collections_SMSHist_Btn;
	
	@FindBy(xpath="//button[@id='vehicleHist']")
	private WebElement Collections_VehicleHist_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'optInOut')]")
	private WebElement Collections_OptInOut_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'emailHist')]")
	private WebElement Collections_EmailHist_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'calcEPayOff')]")
	private WebElement Collections_CalcEpayOff_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'collHist')]")
	private WebElement Collections_CollHist_Btn;
	
	@FindBy(xpath="//button[contains(@onclick,'notes')]")
	private WebElement Collections_NotesHist_Btn;
	
	public void click_Collections_CustRecord_Btn(String data) {
		doIT(Collections_CustRecord_Btn,data);
	}
	public void click_Collections_CustSummary_Btn(String data) {
		doIT(Collections_CustSummary_Btn,data);
	}
	
	public void click_Collections_TransHistory_Btn(String data) {
		doIT(Collections_TransHistory_Btn,data);
	}
	public void click_Collections_LetterHist_Btn(String data) {
		doIT(Collections_LetterHist_Btn,data);
	}
	public void click_Collections_PaySchedule_Btn(String data) {
		doIT(Collections_PaySchedule_Btn,data);
	}
	public void click_Collections_PTPHist_Btn(String data) {
		doIT(Collections_PTPHist_Btn,data);
	}
	
	public void click_Collections_SMSHist_Btn(String data) {
		doIT(Collections_SMSHist_Btn,data);
	}
	public void click_Collections_VehicleHist_Btn(String data) {
		doIT(Collections_VehicleHist_Btn,data);
	}
	public void click_Collections_OptInOut_Btn(String data) {
		doIT(Collections_OptInOut_Btn,data);
	}
	public void click_Collections_EmailHist_Btn(String data) {
		doIT(Collections_EmailHist_Btn,data);
	}
	
	public void click_Collections_CalcEpayOff_Btn(String data) {
		doIT(Collections_CalcEpayOff_Btn,data);
	}
	public void click_Collections_CollHist_Btn(String data) {
		doIT(Collections_CollHist_Btn,data);
	}
	public void click_Collections_NotesHist_Btn(String data) {
		doIT(Collections_NotesHist_Btn,data);
	}
	
	
	
	
	
	// Loan info
	//@FindBy(xpath="//table[@id='brick-border-loan']/tbody/tr/td/table/tbody/tr[4]/td[2]/span")
	@FindBy(id="amountDue")
	private WebElement Collections_Loan_AmountDue;
	
	
	public String get_Collections_Loan_AmountDue(String data) {
		wait.until(ExpectedConditions.visibilityOf(Collections_Loan_AmountDue));
		return doIT(Collections_Loan_AmountDue, data);
	}
	
	public void click_Collections_MakePaymentBtn(String data) {
		doIT(Collections_MakePaymentBtn,data);
	}
	
	
	public void set_Collections_PaymentDate(String sCollections_PaymentDate) {
		doIT(Collections_PaymentDate, sCollections_PaymentDate);
	}
	
	public String get_Collections_PaymentDate(String data) {
		return doIT(Collections_PaymentDate, data);
	}


	public void set_Collections_PaymentAmount(String sCollections_PaymentAmount) {
		doIT(Collections_PaymentAmount, sCollections_PaymentAmount);
	}
	
	public String get_Collections_PaymentAmount(String data) {
		return doIT(Collections_PaymentAmount, data);
	}

	public void set_Collections_PaymentType(String sCollections_PaymentType) {
		doIT(Collections_PaymentType, sCollections_PaymentType);
	}
	public String get_Collections_PaymentType(String data) {
		return doIT(Collections_PaymentType, data);
	}
	

	public void set_Collections_PaymentNotes(String sCollections_PaymentNotes) {
		doIT(Collections_PaymentNotes, sCollections_PaymentNotes);
	}
	
	
	
	public void click_Collections_AddPaymentbtn(String data) {
		doIT(Collections_AddPaymentbtn,data);
	}
	
	
	
	
	
	

	public String get_Collections_CHHeading(String data) {
		return doIT(Collections_CHHeading, data);
	}

	public String get_Collections_CHDate(String data) {
		return doIT(Collections_CHDate, data);
	}

	public String get_Collections_CHUser(String data) {
		return doIT(Collections_CHUser, data);
	}

	public String get_Collections_CHAction(String data) {
		return doIT(Collections_CHAction, data);
	}

	public String get_Collections_CHResponse(String data) {
		return doIT(Collections_CHResponse, data);
	}

	public String get_Collections_CHComments(String data) {
		return doIT(Collections_CHComments, data);
	}



	public void set_Collections_CEActions(String sCollections_CEActions) {
		doIT(Collections_CEActions, sCollections_CEActions);
	}

	public void set_Collections_CEResult(String sCollections_CEResult) {
		doIT(Collections_CEResult, sCollections_CEResult);
	}


	public void set_Collections_CEFollowUpDate(String sCollections_CEFollowUpDate) {
		doIT(Collections_CEFollowUpDate, sCollections_CEFollowUpDate);
	}

	public void set_Collections_CEComments(String sCollections_CEComments) {
		Collections_CEComments.sendKeys(sCollections_CEComments);
	}

	public void click_Collections_CESave_Button(String data) {
		wait.until(ExpectedConditions.visibilityOf(Collections_CESave_Button));
		doIT(Collections_CESave_Button,data);
	}



	public void click_Collections_SearchResults_Ok_Button(String data) {
		doIT(Collections_SearchResults_Ok_Button,data);
	}

	public boolean Collections_SearchResults_Ok_Button() {
		//wait.until(ExpectedConditions.visibilityOf(Collections_SearchResults_Ok_Button));
		return true;

	}



	public String get_Collections_SearchResults_CustNbr(String data) {
		return doIT(Collections_SearchResults_CustNbr, data);
	}




	public boolean click_Collections_Sidebar_btn() {
		Collections_SearchByCustomer_Button.isDisplayed();
		return true;
	}


	public void click_Collections_Sidebar_Button(String data) {
		try {
			/*if(!isDisplayedNoException(Collections_SearchByCustomer_Button)) {
			doIT(Collections_Sidebar_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_SearchByCustomer_Button));
			doIT(Collections_SearchByCustomer_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_FirstName));
			}*/
			if(isDisplayedNoException(Collections_SearchByCustomer_Button))
			{
				doIT(Collections_SearchByCustomer_Button,data);
				wait.until(ExpectedConditions.elementToBeClickable(Collections_FirstName));
			}else {
				doIT(Collections_Sidebar_Button,data);
				wait.until(ExpectedConditions.elementToBeClickable(Collections_SearchByCustomer_Button));
				doIT(Collections_SearchByCustomer_Button,data);
				wait.until(ExpectedConditions.elementToBeClickable(Collections_FirstName));
			}
		}catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(Collections_SearchByCustomer_Button));
			doIT(Collections_SearchByCustomer_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_FirstName));

		}
	}
	
	public void click_Collections_Sidebar_Btn(String data) {
		try {
			if(isDisplayedNoException(Collections_SearchByQueue_Button))
			{
				doIT(Collections_SearchByQueue_Button,data);
				wait.until(ExpectedConditions.elementToBeClickable(Collections_ProductType_Queue));
			}else {
			doIT(Collections_Sidebar_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_SearchByQueue_Button));
			doIT(Collections_SearchByQueue_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_ProductType_Queue));
			}
		}catch(Exception e)
		{
			wait.until(ExpectedConditions.elementToBeClickable(Collections_SearchByQueue_Button));
			doIT(Collections_SearchByQueue_Button,data);
			wait.until(ExpectedConditions.elementToBeClickable(Collections_ProductType_Queue));

		}
	}




	public void click_Collections_SearchByCustomer_Button(String data) {
		doIT(Collections_SearchByCustomer_Button,data);
		wait.until(ExpectedConditions.visibilityOf(Collections_FirstName));
	}



	public void click_Collections_SearchByQueue_Button(String data) {
		doIT(Collections_SearchByQueue_Button,data);
	}



	public void click_Collections_FundsVerification_Button(String data) {
		doIT(Collections_FundsVerification_Button,data);
	}



	public void set_Collections_StoreNbr(String sCollections_StoreNbr) {
		Collections_StoreNbr.clear();
		doIT(Collections_StoreNbr, sCollections_StoreNbr);
	}


	public void click_Collections_Search_Button(String data) {
		wait.until(ExpectedConditions.visibilityOf(Collections_Search_Button));
		doIT(Collections_Search_Button,data);
	}




	public void set_Collections_FirstName(String sCollections_FirstName) {
		wait.until(ExpectedConditions.visibilityOf(Collections_FirstName));
		doIT(Collections_FirstName, sCollections_FirstName);
	}


	public void set_Collections_LastName(String sCollections_LastName) {
		doIT(Collections_LastName, sCollections_LastName);
	}


	public void set_Collections_SSNumber(String sCollections_SSNumber) {
		doIT(Collections_SSNumber, sCollections_SSNumber);
	}


	public void set_Collections_Email(String sCollections_Email) {
		doIT(Collections_Email, sCollections_Email);
	}


	public void set_Collections_LoanNbr(String sCollections_LoanNbr) {
		doIT(Collections_LoanNbr, sCollections_LoanNbr);
	}


	public void set_Collections_BankNumber(String sCollections_BankNumber) {
		doIT(Collections_BankNumber, sCollections_BankNumber);
	}


	public void set_Collections_ProductType_Queue(String sCollections_ProductType_Queue) {
		wait.until(ExpectedConditions.elementToBeClickable(Collections_ProductType_Queue));
		Collections_ProductType_Queue.click();
		doIT(Collections_ProductType_Queue, sCollections_ProductType_Queue);
	}


	public void set_Collections_QueueName_Queue(String sCollections_QueueName_Queue) {
		doIT(Collections_QueueName_Queue, sCollections_QueueName_Queue);
	}


	public void click_Collections_Funds_PastDue_Button(String data) {
		doIT(Collections_Funds_PastDue_Button,data);
	}



	public void click_Collections_Funds_Returned_Button(String data) {
		doIT(Collections_Funds_Returned_Button,data);
	}



	public void click_Collections_Funds_RNSF_Button(String data) {
		doIT(Collections_Funds_RNSF_Button,data);
	}



	public void click_Collections_Funds_RStopPayment_Button(String data) {
		doIT(Collections_Funds_RStopPayment_Button,data);
	}



	public void click_Collections_Funds_RACCClosed_Button(String data) {
		doIT(Collections_Funds_RACCClosed_Button,data);
	}



	public void click_Collections_Funds_ROther_Button(String data) {
		doIT(Collections_Funds_ROther_Button,data);
	}



	public void click_Collections_Funds_RAll_Button(String data) {
		doIT(Collections_Funds_RAll_Button,data);
	}


	public void click_Collections_Funds_WriteOff_Button(String data) {
		doIT(Collections_Funds_WriteOff_Button,data);
	}


	public void set_Collections_Funds_WStartDate(String sCollections_Funds_WStartDate) {
		doIT(Collections_Funds_WStartDate, sCollections_Funds_WStartDate);
	}


	public void set_Collections_Funds_WEndDate(String sCollections_Funds_WEndDate) {
		doIT(Collections_Funds_WEndDate, sCollections_Funds_WEndDate);
	}



	public void searchByCustomerDetails(String process,LinkedHashMap<String, String> searchData) throws Exception{	
		if(!isDisplayedNoException(Collections_FirstName)) {
			click_Collections_Sidebar_Button("Y");
		}			
		set_Collections_FirstName(searchData.get(process+"."+"Collections_FirstName"));
		set_Collections_LastName(searchData.get(process+"."+"Collections_LastName"));
		set_Collections_SSNumber(searchData.get(process+"."+"Collections_SSNumber"));
		set_Collections_Email(searchData.get(process+"."+"Collections_Email"));
		set_Collections_LoanNbr(searchData.get(process+"."+"Collections_LoanNbr"));
		set_Collections_BankNumber(searchData.get(process+"."+"Collections_BankNumber"));
		set_Collections_StoreNbr(searchData.get(process+"."+"Collections_StoreNbr"));
	
		click_Collections_Search_Button("Y");			
	}	
	public void searchByQueue(String process,LinkedHashMap<String, String> searchData) throws Exception{	
		if(!isDisplayedNoException(Collections_ProductType_Queue)) {
			click_Collections_Sidebar_Btn("Y");
		}			
		set_Collections_ProductType_Queue(searchData.get(process+"."+"Collections_ProductType"));
		set_Collections_QueueName_Queue(searchData.get(process+"."+"Collections_QueueName"));
		set_Collections_StoreNbr(searchData.get(process+"."+"Collections_StoreNbr"));
		click_Collections_Search_Button("Y");			
	}	
	
	
	
	// PTP History
	
	@FindBy(xpath="//table/tbody/tr[3]/td[1]")
	private WebElement Collections_PTPpaymentDt;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	private WebElement Collections_PTPpaymentAmt;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[3]")
	private WebElement Collections_PTPpaymentType;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[4]")
	private WebElement Collections_PTPpaymentTrType;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[6]")
	private WebElement Collections_PTPStatus;

	
	public String get_Collections_PTPpaymentDt(String data) {
		return doIT(Collections_PTPpaymentDt, data);
	}
	
	
	public String get_Collections_PTPpaymentAmt(String data) {
		return doIT(Collections_PTPpaymentAmt, data);
	}

	public String get_Collections_PTPpaymentType(String data) {
		return doIT(Collections_PTPpaymentType, data);
	}


	public String get_Collections_PTPpaymentTrType(String data) {
		return doIT(Collections_PTPpaymentTrType, data);
	}

	public String get_Collections_PTPStatus(String data) {
		return doIT(Collections_PTPStatus, data);
	}

	
	// Vehicle History
	
	@FindBy(xpath="//table/tbody/tr[3]/td[1]")
	private WebElement Collections_VehicleHist_VIN;

	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	private WebElement Collections_VehicleHist_Make;

	@FindBy(xpath="//table/tbody/tr[3]/td[3]")
	private WebElement Collections_VehicleHist_Model;

	@FindBy(xpath="//table/tbody/tr[3]/td[4]")
	private WebElement Collections_VehicleHist_Year;

	@FindBy(xpath="//table/tbody/tr[3]/td[5]")
	private WebElement Collections_VehicleHist_BlackBookValue;

	@FindBy(xpath="//table/tbody/tr[3]/td[6]")
	private WebElement Collections_VehicleHist_VehicleStatus;
	
	
	
	
	public String get_Collections_VehicleHist_VIN(String data) {
		return doIT(Collections_VehicleHist_VIN, data);
	}
	
	public String get_Collections_VehicleHist_Make(String data) {
		return doIT(Collections_VehicleHist_Make, data);
	}
	
	public String get_Collections_VehicleHist_Model(String data) {
		return doIT(Collections_VehicleHist_Model, data);
	}
	
	public String get_Collections_VehicleHist_Year(String data) {
		return doIT(Collections_VehicleHist_Year, data);
	}
	
	public String get_Collections_VehicleHist_BlackBookValue(String data) {
		return doIT(Collections_VehicleHist_BlackBookValue, data);
	}
	
	public String get_Collections_VehicleHist_VehicleStatus(String data) {
		return doIT(Collections_VehicleHist_VehicleStatus, data);
	}
	
	
	// Payment Schedule
	
	
	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	private WebElement Collections_PaymentSch_PmtDate;

	@FindBy(xpath="//table/tbody/tr[3]/td[3]")
	private WebElement Collections_PaymentSch_PmtStatus;

	@FindBy(xpath="//table/tbody/tr[3]/td[4]")
	private WebElement Collections_PaymentSch_PmtDays;

	@FindBy(xpath="//table/tbody/tr[3]/td[5]")
	private WebElement Collections_PaymentSch_PmtAmt;

	@FindBy(xpath="//table/tbody/tr[3]/td[6]")
	private WebElement Collections_PaymentSch_PmtInt;

	@FindBy(xpath="//table/tbody/tr[3]/td[10]")
	private WebElement Collections_PaymentSch_PmtBal;

	
	public String get_Collections_PaymentSch_PmtDate(String data) {
		return doIT(Collections_PaymentSch_PmtDate, data);
	}
	
	
	public String get_Collections_PaymentSch_PmtStatus(String data) {
		return doIT(Collections_PaymentSch_PmtStatus, data);
	}

	public String get_Collections_PaymentSch_PmtDays(String data) {
		return doIT(Collections_PaymentSch_PmtDays, data);
	}

	public String get_Collections_PaymentSch_PmtAmt(String data) {
		return doIT(Collections_PaymentSch_PmtAmt, data);
	}

	public String get_Collections_PaymentSch_PmtInt(String data) {
		return doIT(Collections_PaymentSch_PmtInt, data);
	}

	public String get_Collections_PaymentSch_PmtBal(String data) {
		return doIT(Collections_PaymentSch_PmtBal, data);
	}
	
	/* Notes History*/

	//@FindBy(name="requestBean.notesData")
	@FindBy(xpath="//table/tbody/tr[2]/td[2]/textarea")
	private WebElement Collections_Notes;
		
	@FindBy(name="SubButton")
	private WebElement Collections_Submitbtn;
	

	@FindBy(xpath="//table/tbody/tr[3]/td[1]")
	private WebElement colllections_NotesUrgent;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	private WebElement colllections_Notesdate;
		
	@FindBy(xpath="//table/tbody/tr[3]/td[3]")
	private WebElement colllections_NotesLoanNbr;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[4]")
	private WebElement colllections_NotesModules;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[5]")
	private WebElement colllections_NotesComments;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[6]")
	private WebElement colllections_Notesby;
	
	
	@FindBy(name="requestBean.chkBox")
	private WebElement Collections_Urgent_chkbox;
	
	public void click_Collections_Urgent_chkbox(String data) {
		doIT(Collections_Urgent_chkbox,data);
	}
	
	
	public void set_Collections_Notes(String collections_Notes) {
		wait.until(ExpectedConditions.elementToBeClickable(Collections_Notes));
		doIT(Collections_Notes, collections_Notes);
	}


	public void click_Collections_Submitbtn(String data) {
		doIT(Collections_Submitbtn,data);
	}

	
	public String get_colllections_NotesUrgent(String data) {
		return doIT(colllections_NotesUrgent, data);
	}
	
	public String get_colllections_Notesdate(String data) {
		return doIT(colllections_Notesdate, data);
	}

	
	public String get_colllections_NotesLoanNbr(String data) {
		return doIT(colllections_NotesLoanNbr, data);
	}
	
	
	public String get_colllections_NotesModules(String data) {
		return doIT(colllections_NotesModules, data);
	}
	
	
	public String get_colllections_NotesComments(String data) {
		return doIT(colllections_NotesComments, data);
	}
		
	public String get_colllections_Notesby(String data) {
		return doIT(colllections_Notesby, data);
	}
	
	@FindBy(xpath="//table/tbody/tr[3]/td[1]")
	private WebElement colllections_EmailDateSent;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	private WebElement colections_EmailLoanNbr;
		
	@FindBy(xpath="//table/tbody/tr[3]/td[3]")
	private WebElement collections_Emailemailid;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[4]")
	private WebElement collections_EmailDesc;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[5]")
	private WebElement colllections_EmailResponse;
	
	public String get_collections_EmailDateSent(String data) {
		return doIT(colllections_EmailDateSent, data);
	}
	
	public String get_collections_EmailLoanNbr(String data) {
		return doIT(colections_EmailLoanNbr, data);
	}
	
	
	public String get_collections_Emailemailid(String data) {
		return doIT(collections_Emailemailid, data);
	}
	
	public String get_collections_EmailDesc(String data) {
		return doIT(collections_EmailDesc, data);
	}
	public String get_colllections_EmailResponse(String data) {
		return doIT(colllections_EmailResponse, data);
	}
	
	// Customer Summary View 
	
	
	@FindBy(xpath="//table/tbody/tr[2]/td[4]")
	private WebElement collections_SummaryView_Emailid;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[5]")
	private WebElement collections_SummaryView_Dob;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[7]")
	private WebElement collections_SummaryView_Photoid;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]")
	private WebElement collections_SummaryView_PhoneNbr;

	public String get_collections_SummaryView_Emailid(String Collections_SummaryView_Emailid) {
		return doIT(collections_SummaryView_Emailid, Collections_SummaryView_Emailid);
	}
	
	public String get_collections_SummaryView_Dob(String Collections_SummaryView_Dob) {
		return doIT(collections_SummaryView_Dob, Collections_SummaryView_Dob);
	}
	
	public String get_collections_SummaryView_Photoid(String Collections_SummaryView_Photoid) {
		return doIT(collections_SummaryView_Photoid, Collections_SummaryView_Photoid);
	}
	
	public String get_collections_SummaryView_PhoneNbr(String Collections_SummaryView_PhoneNbr) {
		return doIT(collections_SummaryView_PhoneNbr, Collections_SummaryView_PhoneNbr);
	}
	
	
	
	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[1]")
	private WebElement product_Type;
	
	@FindBy(xpath = "//td[contains(text(),'@gmail.com')]")
	private WebElement email_Id;
	
	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[2]")
	private WebElement loan_Nbr;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[3]")
	private WebElement total_Due;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[4]")
	private WebElement total_Paid;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[5]")
	private WebElement next_Due_Date;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[6]")
	private WebElement payment_Amt_Due;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[7]")
	private WebElement check_Card_Nbr;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[4]")
	private WebElement transtion;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[5]")
	private WebElement voided;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[9]]")
	private WebElement principal_Fee;

	public String get_product_Type(String sproduct_Type) {
		return doIT(product_Type, sproduct_Type);
	}
	
	public String get_email_Id(String sproduct_Type) {
		return doIT(email_Id, sproduct_Type);
	}

	public String get_loan_Nbr(String sloan_Nbr) {
		return doIT(loan_Nbr, sloan_Nbr);
	}

	public String get_total_Due(String stotal_Due) {
		return  doIT(total_Due, stotal_Due);
	}

	public String get_total_Paid(String stotal_Paid) {
		return doIT(total_Paid, stotal_Paid);
	}

	public void set_next_Due_Date(String snext_Due_Date) {
		doIT(next_Due_Date, snext_Due_Date);
	}
	public String get_next_Due_Date(String ssnext_Due_Date) {
		return doIT(next_Due_Date, ssnext_Due_Date);
	}
	
	public String get_payment_Amt_Due(String spayment_Amt_Due) {
		return doIT(payment_Amt_Due, spayment_Amt_Due);
	}

	public void set_check_Card_Nbr(String scheck_Card_Nbr) {
		doIT(check_Card_Nbr, scheck_Card_Nbr);
	}

	public void set_transaction(String stranstion) {
		doIT(transtion, stranstion);
	}

	public void set_voided(String svoided) {
		doIT(voided, svoided);
	}

	public void set_principal_Fee(String sprincipal_Fee) {
		doIT(principal_Fee, sprincipal_Fee);
	}

	@FindBy(xpath = "//*[@id='tableHeading']/th")
	private WebElement Coll_THeading;
	
	public String get_Coll_THeading(String coll_THeading) {
		return doIT(Coll_THeading, coll_THeading);
	}
	
	@FindBy(xpath = "//span[@id='nxtPayDt']")
	private WebElement Coll_Nextpayday;
	
	
	public String get_Coll_Nextpayday() {
		return doIT(Coll_Nextpayday, "get");
	}
	
	
	public void acceptAlerttext() {
		if (isAlertPresent()) {
			String alertText = getAlertText();
			System.out.println(alertText.trim());
			System.out.println(alertText.length());
			String Paydate= alertText.substring(43, 53);
			System.out.println(Paydate);
			report.log(LogStatus.INFO, "Alert accept = " + alertText.trim());
			AlertDecesion("accept");
			set_Collections_PaymentDate(Paydate);

		}
	}
	
	

	public void click_WebElementForDynamicString(String data) {

		WebElement FoundElement = null;
		if (!data.isEmpty()) {
			String	xpathStrig = xpathStrig_prefix+data+xpathStrig_suffix;
			System.out.println(xpathStrig);
			FoundElement = driver.findElement(By.xpath(xpathStrig));
			doIT(FoundElement,data);
		} else {
			FoundElement = null;
		}
		
	}

	
	
}

	