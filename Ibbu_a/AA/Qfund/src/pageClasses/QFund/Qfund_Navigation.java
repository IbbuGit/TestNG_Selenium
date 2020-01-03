package pageClasses.QFund;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Qfund_Navigation {

	static WebDriver driver;
	static ExtentTest report;
	static WebDriverWait wait;

	static String frameTop="TOP";
	static String frameMiddle="MIDDLE";
	static String frameMain="MAIN";
	static String frameBottom="BOTTOM";
	static String frameDefault="DEFAULT";

	public Qfund_Navigation(WebDriver _driver, ExtentTest _report) {
		driver=_driver;
		report=_report;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);		
	}

	@FindBy(xpath = "//img[@alt='Loading...']")
	protected static WebElement pageLoader;


	@FindBy(xpath = "//img[@class='img-responsive']")
	protected static WebElement qFundLogo;

	static void selectMenu(WebElement[] elements) {
		driver.navigate().refresh();
		try {Thread.sleep(2000);} catch (Exception e) {}

		for(int i=0;i<elements.length;i++) {
			if(i==0) {			
				selectFrame(frameTop);
				wait.until(ExpectedConditions.visibilityOf(elements[0]));
				elements[0].click();
				selectFrame(frameMiddle);
			}else if(i==elements.length-1 && i!=0){
				wait.until(ExpectedConditions.visibilityOf(elements[i]));
				elements[i].click();
				selectFrame(frameTop);
				try {Thread.sleep(2000);} catch (Exception e) {}
				qFundLogo.click();
				selectFrame(frameMain);
			}else {
				wait.until(ExpectedConditions.visibilityOf(elements[i]));
				String javaScript = "var evObj = document.createEvent('MouseEvents');" +
						"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
						"arguments[0].dispatchEvent(evObj);";
				((JavascriptExecutor)driver).executeScript(javaScript, elements[i]);
			}
		}		
	}

	static void selectFrame(String frameName) {

		driver.switchTo().defaultContent();
		try {
			wait.until(ExpectedConditions.invisibilityOf(pageLoader));
		}catch(Exception e) {}


		if(frameName.toUpperCase().equals("TOP")) {			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topFrame"));			
		}else if(frameName.toUpperCase().equals("MIDDLE")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));						
		}else if(frameName.toUpperCase().equals("MAIN")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
		}else if(frameName.toUpperCase().equals("BOTTOM")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		}else if(frameName.toUpperCase().equals("DEFAULT")) {
			driver.switchTo().defaultContent();			
		}	
	}

	static void click(WebElement element){
		String temp=Thread.currentThread().getStackTrace()[2].getMethodName();
		String elementName=temp.substring(temp.indexOf("_")+1, temp.length());
		try {
			element.click();

			report.log(LogStatus.INFO, "Clicked " + elementName);
			System.out.println(LogStatus.INFO+ ": Clicked [" + elementName + "]");


		}catch(Exception e) {

			report.log(LogStatus.FAIL, "Not able to click " + elementName);
			System.out.println(LogStatus.FAIL+ " :Not able to click" + elementName);

			throw e;
		}
	}

	public static boolean isAlertPresent() 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	} 

	//-----------Borrower Start--------------------------------------------------------------------------	
	// Borrower Navigation
	@FindBy(id = "900000")
	private static WebElement borrower_tab;

	@FindBy(id = "901000")
	private static WebElement Registration;

	@FindBy(name = "summary")
	private static WebElement BrwrRegSummary_Tab;

	@FindBy(name = "personal")
	private static WebElement BrwrRegPrsnl_Tab;

	@FindBy(name = "income")
	public static WebElement BrwrRegIncome_Tab;

	@FindBy(name = "banking")
	private static WebElement BrwrRegBanking_TAB;

	@FindBy(name = "others")
	public static WebElement BrwrRegOthers_Tab;

	@FindBy(id = "902000")
	private static WebElement Edit;

	@FindBy(id = "903001")
	public static WebElement Collections;

	@FindBy(id = "940003")
	private static WebElement Collectionspam;

	@FindBy(id = "988190443")
	private static WebElement Active_Military;

	@FindBy(id = "98819081105")
	private static WebElement Upload_Customer_Documents;

	@FindBy(id = "98819081209")
	private static WebElement RePrint_Agreements;

	@FindBy(id = "955190406")
	private static WebElement PAM;

	public static class Borrower {		

		public static void Borrower_Tab(){selectMenu(new WebElement[] {borrower_tab}); }

		public static void Registration() {selectMenu(new WebElement[] {borrower_tab,Registration}); }	

		public static void PAM() {selectMenu(new WebElement[] {borrower_tab,PAM}); }

		public static class Registration {		

			public static void Summary() {	
				Registration();
				click(BrwrRegSummary_Tab);
			}

			public static void Personal() {		
				Registration();
				click(BrwrRegPrsnl_Tab);
			}

			public static void Income() {	
				Registration();
				click(BrwrRegIncome_Tab);
			}

			public static void Banking() {	
				Registration();
				click(BrwrRegBanking_TAB);
			}

			public static void Other() {	
				Registration();
				click(BrwrRegOthers_Tab);
			}
		}

		public static void Edit() {selectMenu(new WebElement[] {borrower_tab,Edit}); }		


		public static class Edit {		

			public static void Summary() {

				click(BrwrRegSummary_Tab);
			}

			public static void Personal() {	

				click(BrwrRegPrsnl_Tab);
			}

			public static void Income() {		

				click(BrwrRegIncome_Tab);
			}

			public static void Banking() {	

				click(BrwrRegBanking_TAB);
			}

			public static void Other() {	

				click(BrwrRegOthers_Tab);
			}
		}

		public static void Collections() {selectMenu(new WebElement[] {borrower_tab,Collections}); }
		public static void Collectionspam() {selectMenu(new WebElement[] {borrower_tab,Collectionspam}); }

		public static void Active_Military() {selectMenu(new WebElement[] {borrower_tab,Active_Military}); }

		public static void Upload_Customer_Documents() {selectMenu(new WebElement[] {borrower_tab,Upload_Customer_Documents}); }

		public static void RePrint_Agreements() {selectMenu(new WebElement[] {borrower_tab,RePrint_Agreements}); }

	}
	//-----------Borrower End------------------------------------------------------------------------------------

	//-----------Loan Transactions Tab Start-------------------------------------------------------------------------------------------------------------------------------
	/*
	 * LoanTransaction
	 */
	@FindBy(id = "910000")
	private static WebElement LoanTransactions_Tab;
	/*
	 * New Loan
	 */
	@FindBy(id = "911100")
	private static WebElement NewLoan;
	/*
	 * Transactions
	 */ @FindBy(id = "911101")
	 private static WebElement Transactions;

	 @FindBy(id = "955190407")
	 private static WebElement Cash_At_Store;

	 /*
	  * VIN Validation Menu
	  */
	 @FindBy(id = "988190677")
	 private static  WebElement VINValidation;
	 /*
	  * Vehicle Image Upload Menu
	  */
	 @FindBy(id = "98819081107")
	 private static WebElement VehicleImageUpload;
	 /*
	  * Title Loan Menu
	  */
	 @FindBy(id = "98819081117")
	 private static  WebElement TitleLoan;
	 /*
	  * Title Tracking
	  */
	 @FindBy(id = "98819081118")
	 private static WebElement Title_Tracking;


	 public static class Loan_Transaction {		
		 public static void LoanTransaction() {selectMenu(new WebElement[] {LoanTransactions_Tab}); }			

		 public static void New_Loan() {selectMenu(new WebElement[] {LoanTransactions_Tab,NewLoan}); }

		 public static void Transactions() {
			 selectMenu(new WebElement[] {LoanTransactions_Tab,Transactions}); 			 
			 if(isAlertPresent()) {
				 driver.switchTo().alert().accept();
			 }			 
		 }

		 public static void Cash_At_Store() {selectMenu(new WebElement[] {LoanTransactions_Tab,Cash_At_Store}); }

		 public static void VIN_Validation() {selectMenu(new WebElement[] {LoanTransactions_Tab,VINValidation}); }

		 public static void Vehicle_Image_Upload() {selectMenu(new WebElement[] {LoanTransactions_Tab,VehicleImageUpload}); }

		 public static void TitleLoan() {selectMenu(new WebElement[] {LoanTransactions_Tab,TitleLoan}); }

		 public static class Title_Loan {		
			 public static void Title_Tracking() {selectMenu(new WebElement[] {LoanTransactions_Tab,TitleLoan,Title_Tracking}); }
		 }
	 }

	 //-----------Loan Transactions Tab End---------------------------------------------------------------------------------------------------------------------------------

	 //-----------Account Management Start---------------------------------------------------------------------------------------------------------------------------------

	 /*
	  * Account Management Tab
	  */
	 @FindBy(id = "940000")
	 private static WebElement AccountManagement_Tab;
	 /*
	  * Start Schedulers menu option
	  */
	 @FindBy(id = "940005")
	 private static WebElement Start_Schedulers;

	 public static class Account_Management {	

		 public static void AccountManagement() {selectMenu(new WebElement[] {AccountManagement_Tab}); }		

		 public static void Start_Schedulers() {selectMenu(new WebElement[] {AccountManagement_Tab,Start_Schedulers}); }

	 }

	 //-----------Account Management End---------------------------------------------------------------------------------------------------------------------------------

	 //-----------Misc Transactions Start---------------------------------------------------------------------------------------------------------------------------
	 /*
	  * MiscTransactions Tab
	  */
	 @FindBy(id = "920000")
	 private static WebElement MiscTransactions_Tab;
	 /*
	  * Misc Receipts
	  */
	 @FindBy(id = "921000")
	 private static WebElement Misc_Receipts;
	 /*
	  * Miscellaneous Receipts
	  */
	 @FindBy(id = "921009")
	 private static WebElement Miscellaneous_Receipts;
	 /*
	  * Misc Disbursement
	  */
	 @FindBy(id = "922000")
	 private static WebElement Misc_Disbursement;
	 /*
	  * Other Disbursements
	  */
	 @FindBy(id = "922003")
	 private static WebElement Other_Disbursements;


	 public static class Misc_Transactions {	

		 public static void MiscTransactions() {selectMenu(new WebElement[] {MiscTransactions_Tab}); }		

		 public static void Misc_Receipts() {selectMenu(new WebElement[] {MiscTransactions_Tab,Misc_Disbursement}); }

		 public static void Misc_Disbursement() {selectMenu(new WebElement[] {MiscTransactions_Tab,Misc_Disbursement}); }

		 public static class Misc_Receipts {						
			 public static void Miscellaneous_Receipts() {selectMenu(new WebElement[] {MiscTransactions_Tab,Misc_Receipts,Miscellaneous_Receipts}); }				
		 }
		 public static class Misc_Disbursement {		
			 public static void Other_Disbursements() {selectMenu(new WebElement[] {MiscTransactions_Tab,Misc_Disbursement,Other_Disbursements}); }				
		 }
	 }
	 //-----------Misc Transactions End---------------------------------------------------------------------------------------------------------------------------	

	 //-----------Cash Management Start--------------------------------------------------------------------------
	 @FindBy(id = "930000")
	 private static WebElement CashManagement_Tab;

	 @FindBy(id = "931000")
	 private static WebElement Drawer;
	 /*
	  * Assign SubMenu
	  */
	 @FindBy(id = "931010")
	 private static WebElement DrawerAssign;
	 /*
	  * Balance
	  */
	 @FindBy(id = "931020")
	 private static WebElement DrawerBalance;
	 /*
	  * Deassign
	  */
	 @FindBy(id = "931030")
	 private static WebElement DrawerDeassign;
	 /*
	  * Safe Menu
	  */
	 @FindBy(id = "932000")
	 private static WebElement safe;
	 /*
	  * Cash In
	  */
	 @FindBy(id = "406")
	 private static WebElement SafeCashIn;
	 /*
	  * Assign
	  */
	 @FindBy(id = "932010")
	 private static WebElement SafeAssign;
	 /*
	  * Balance
	  */
	 @FindBy(id = "932020")
	 private static WebElement SafeBalance;
	 /*
	  * Deassign
	  */
	 @FindBy(id = "932030")
	 private static WebElement SafeDeassign;
	 /*
	  * Internal Transfer
	  */
	 @FindBy(id = "932040")
	 private static WebElement SafeInternalTransfer;
	 /*
	  * Deposit
	  */
	 @FindBy(id = "932050")
	 private static WebElement SafeDeposit;
	 /*
	  * Store To Store Transfers
	  */
	 @FindBy(id = "988190495")
	 private static WebElement SafeStoreToStoreTransfers;

	 /*
	  * Manual Deposit Slip
	  */
	 @FindBy(id = "98819081143")
	 private static WebElement ManualDepositSlip;

	 public static class Cash_Management {		

		 static void CashManagement() {selectMenu(new WebElement[] {CashManagement_Tab}); }

		 static void Drawer() {selectMenu(new WebElement[] {CashManagement_Tab,Drawer}); }

		 static void Safe() {selectMenu(new WebElement[] {CashManagement_Tab,safe}); }

		 public static class Drawer {		

			 public static void Assign() {selectMenu(new WebElement[] {CashManagement_Tab,Drawer,DrawerAssign}); }

			 public static void Balance() {selectMenu(new WebElement[] {CashManagement_Tab,Drawer,DrawerBalance}); }

			 public static void DeAssign() {selectMenu(new WebElement[] {CashManagement_Tab,Drawer,DrawerDeassign}); }

		 }

		 public static class Safe {		

			 public static void Cash_In() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeCashIn}); }

			 public static void Assign() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeAssign}); }

			 public static void Balance() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeBalance}); }

			 public static void DeAssign() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeDeassign}); }

			 public static void Internal_Transfer() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeInternalTransfer}); }

			 public static void Deposit() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeDeposit}); }

			 public static void Store_To_StoreTransfers() {selectMenu(new WebElement[] {CashManagement_Tab,safe,SafeStoreToStoreTransfers}); }

			 public static void Manual_Deposit_Slip() {selectMenu(new WebElement[] {CashManagement_Tab,safe,ManualDepositSlip}); }				
		 }

	 }

	 //-----------Chash Management End--------------------------------------------------------------------------

	 //-----------Daily Processins Start-----------------------------------------------------------------------------------------------------------------------
	 /*
	  * DailyProcessing Tab
	  */ 
	 @FindBy(id = "daily")
	 private static WebElement DailyProcessing_Tab;

	 public static class Daily_Processing {		
		 public static void DailyProcessing() {selectMenu(new WebElement[] {DailyProcessing_Tab}); }			
	 }
	 //-----------Daily Processin End--------------------------------------------------------------------------------------------------------------------------

	 //----------------------Reports Start----------------------------------------------------------------------------------------------------------------------------------

	 @FindBy(id = "950000")
	 private static WebElement Reports;

	 @FindBy(id = "951000")
	 private static WebElement Reports_Collections;
	 	
	 	@FindBy(id = "988190720")
	 	private static WebElement Collections_PastDueReport;
	 	
	 	@FindBy(id = "988190721")
		private static WebElement Collections_PromiseToPay;
	 	
	 	@FindBy(id = "988190722")
		private static WebElement Collections_CollectionActivity;
	 	
	 	@FindBy(id = "988190724")
		private static WebElement Collections_CoutesyCallReport;
	 	
	 	@FindBy(id = "988190725")
		private static WebElement Collections_StoreToCentralCollectionReport;
	 	
	 	@FindBy(id = "988190741")
		private static WebElement Collections_StoreCallReport;
	 	
	 	@FindBy(id = "98819081193")
		private static WebElement Collections_WriteOffRecoveriesReport;
	 	

	 @FindBy(id = "952000")
	 private static WebElement Reports_CustomerReports;
	 
	 	@FindBy(id = "951010")
	 	private static WebElement CustomerReports_BankruptcyReport;
	 	
	 	@FindBy(id = "952020")
		 private static WebElement CustomerReports_ActiveCustomer;
	 	
	 	@FindBy(id = "988190695")
		 private static WebElement CustomerReports_DonotCallReport;
	 	
	 	@FindBy(id = "988190713")
		 private static WebElement CustomerReports_ActiveMiliteryReport;
	 	
	 	@FindBy(id = "988190719")
		 private static WebElement CustomerReports_PendingBankruptcyReport;
	 	
	 	@FindBy(id = "988190774")
		 private static WebElement CustomerReports_CustomerInformationSummaryReport;
	 	
	 	@FindBy(id = "98819081203")
		 private static WebElement CustomerReports_DeceasedCustomerReport;
	 	
	 	@FindBy(id = "98819081207")
		 private static WebElement CustomerReports_MostRecentCustomerReport;
	 	
	 	@FindBy(id = "98819081210")
		 private static WebElement CustomerReports_BSACustomerLogReport;
	 	
	 	@FindBy(id = "98819081213")
		 private static WebElement CustomerReports_StatusChangeReport;
	 	
	 	@FindBy(id = "98819081215")
		 private static WebElement CustomerReports_NonActiveCustomer;
	 	
	 	@FindBy(id = "98819081268")
		 private static WebElement CustomerReports_InstantFundingRejectionReport;
	 	
	 	@FindBy(id = "98819081269")
		 private static WebElement CustomerReports_ReviewApprovedApplicationReport;

	 @FindBy(id = "953000")
	 private static WebElement Reports_DailySummaryReports;
	 
	 	@FindBy(id = "953020")
	 	private static WebElement DailySummaryReports_EODSummary;
	 	
	 	@FindBy(id = "953030")
	 	private static WebElement DailySummaryReports_DailyTransactionJournal;
	 	
	 	@FindBy(id = "953050")
	 	private static WebElement DailySummaryReports_StoreCashManagement;
	 	
	 	@FindBy(id = "953060")
	 	private static WebElement DailySummaryReports_VoidedTransactions;
	 	
	 	@FindBy(id = "988190698")
	 	private static WebElement DailySummaryReports_StoreCashManagementSummaryReport;
	 	
	 	@FindBy(id = "988190700")
	 	private static WebElement DailySummaryReports_CashOverShortReport;
	 	
	 	@FindBy(id = "988190701")
	 	private static WebElement DailySummaryReports_CashBalanceTransactionReport;
	 	
	 	@FindBy(id = "98819081219")
	 	private static WebElement DailySummaryReports_DailyCentreSummaryReport;

	 @FindBy(id = "954000")
	 private static WebElement Reports_LoanReports;
	 
	   	 @FindBy(id = "954070")
	 	 private static WebElement LoanReports_DefaultReport;
	 	
	 	 @FindBy(id = "954092")
		 private static WebElement LoanReports_PWOReport;
	 	 
	 	 @FindBy(id = "954093")
		 private static WebElement LoanReports_WriteOffLoansReport;
	 	 
	 	 @FindBy(id = "954095")
		 private static WebElement LoanReports_ReturenedItemsReport;
	 	 
	 	 @FindBy(id = "13700008")
		 private static WebElement LoanReports_SoldLoanReport;
	 	 
	 	 @FindBy(id = "988190699")
		 private static WebElement LoanReports_AllPaymentsReport;
	 	 
	 	 @FindBy(id = "988190702")
		 private static WebElement LoanReports_CheckRegisterReport;
	 	 
	 	 @FindBy(id = "988190703")
		 private static WebElement LoanReports_OutStandingPresentmentReport;
	 	 
	 	 @FindBy(id = "988190704")
		 private static WebElement LoanReports_WaiveFeeReport;
	 	 
	 	 @FindBy(id = "988190706")
		 private static WebElement LoanReports_RefundTransactionReport;
	 	 
	 	 @FindBy(id = "988190708")
		 private static WebElement LoanReports_NewLoanReport;
	 	 
	 	 @FindBy(id = "988190709")
		 private static WebElement LoanReports_ReturnedItemsInventoryReport;
	 	 
	 	 @FindBy(id = "988190716")
		 private static WebElement LoanReports_CouponTrackingReport;
	 	 
	 	 @FindBy(id = "988190717")
		 private static WebElement LoanReports_ACHDetailsReport;
	 	 
	 	 @FindBy(id = "988190718")
		 private static WebElement LoanReports_HeldCheckSummary;
	 	 
	 	 @FindBy(id = "98819081173")
		 private static WebElement LoanReports_AChandRccActivityReport;
	 	 
	 	 @FindBy(id = "98819081208")
		 private static WebElement LoanReports_ActivePrenoteReport;
	 	 
	 	 @FindBy(id = "98819081225")
		 private static WebElement LoanReports_NonCenterPaymentReport;
	 	
	 	 @FindBy(id = "98819081245")
		 private static WebElement LoanReports_AchCreditRejectionReport;

	 @FindBy(id = "955000")
	 private static WebElement Reports_OtherReports;
	 
	 	@FindBy(id = "955030")
	 	private static WebElement OtherReports_MonetaryTransferLog;
	 	
	 	@FindBy(id = "988190776")
	 	private static WebElement OtherReports_ActiveUsersReport;
	 	
	 	@FindBy(id = "988190777")
	 	private static WebElement OtherReports_MiscDisbursementsLogReport;
	 	
	 	@FindBy(id = "988190779")
	 	private static WebElement OtherReports_RescissionReport;
	 	
	 	@FindBy(id = "988190780")
	 	private static WebElement OtherReports_DebitCardPaymentsReport;
	 	
	 	@FindBy(id = "988190781")
	 	private static WebElement OtherReports_LoansWithCreditBalanceReport;
	 	
	 	@FindBy(id = "988190783")
	 	private static WebElement OtherReports_MiscellaneousRecieptsReport;
	 	
	 	@FindBy(id = "988190786")
	 	private static WebElement OtherReports_LoanDenialReport;
	 	
	 	@FindBy(id = "988190851")
	 	private static WebElement OtherReports_PaymentPlanReport;
	 	
	 	@FindBy(id = "98819081216")
	 	private static WebElement OtherReports_TimeSheetReport;
	 	
	 	@FindBy(id = "98819081228")
	 	private static WebElement OtherReports_WorkBreakAuditReport;

	 @FindBy(id = "98819081178")
	 private static WebElement Reports_TitleReports;
	 
	 	@FindBy(id = "98819081179")
	 	private static WebElement TitleReports_TitleOpenLoanReport;
	 	
	 	@FindBy(id = "98819081180")
	 	private static WebElement TitleReports_TitleNewLoanOriginationReport;
	 	
	 	@FindBy(id = "98819081181")
	 	private static WebElement TitleReports_TitleRepoLogReport;
	 	
	 	@FindBy(id = "98819081186")
	 	private static WebElement TitleReports_TitleTrackingStatusReport;
	 	
	 	@FindBy(id = "98819081187")
	 	private static WebElement TitleReports_TitleSequentialLoanReport;
	 	
	 	@FindBy(id = "98819081189")
	 	private static WebElement TitleReports_TitleOutToRepoReport;
	 	
	 	@FindBy(id = "98819081194")
	 	private static WebElement TitleReports_TitleSecuredPastDueReport;
	 
	 

	 @FindBy(id = "98819081201")
	 private static WebElement Reports_PccReports;
	 
	 	@FindBy(id = "98819081202")
	 	private static WebElement PccReports_CardSaleAndLoanReport;



	 public static class Reports_Tab {		

		 static void ReportsTab() {selectMenu(new WebElement[] {Reports}); }

		 static void Collections() {selectMenu(new WebElement[] {Reports,Reports_Collections}); }

		 static void CustomerReports() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports}); }
		 
		 static void DailySummaryReports() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports}); }
		 
		 static void LoanReports() {selectMenu(new WebElement[] {Reports,Reports_LoanReports}); }
		 
		 static void OtherReports() {selectMenu(new WebElement[] {Reports,Reports_OtherReports}); }
		 
		 static void TitleReports() {selectMenu(new WebElement[] {Reports,Reports_TitleReports}); }
		 
		 static void PccReports() {selectMenu(new WebElement[] {Reports,Reports_PccReports}); }
		 
		 
		 public static class Collections{
			 
			 public static void PastDueReport() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_PastDueReport}); }
			 
			 public static void PromiseToPay() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_PromiseToPay}); }
			 
			 public static void CollectionActivity() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_CollectionActivity}); }
			 
			 public static void CoutesyCallReport() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_CoutesyCallReport}); }
			 
			 public static void StoreToCentralCollectionReport() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_StoreToCentralCollectionReport}); }
			 
			 public static void StoreCallReport() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_StoreCallReport}); }
			 
			 public static void WriteOffRecoveriesReport() {selectMenu(new WebElement[] {Reports,Reports_Collections,Collections_WriteOffRecoveriesReport}); }
			 
		 }
		 
		 public static class CustomerReports{
			 
			 public static void BankruptcyReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_BankruptcyReport}); }
			 
			 public static void ActiveCustomer() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_ActiveCustomer}); }
			 
			 public static void DoNotCallReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_DonotCallReport}); }
			 
			 public static void ActiveMiliteryReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_ActiveMiliteryReport}); }
			 
			 public static void PendingBankruptcyReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_PendingBankruptcyReport}); }
			 
			 public static void CustomerInformationSummaryReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_CustomerInformationSummaryReport}); }
			 
			 public static void DeceasedCustomerReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_DeceasedCustomerReport}); }
			 
			 public static void MostRecentCustomerReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_MostRecentCustomerReport}); }
			 
			 public static void BSACustomerLogReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_BSACustomerLogReport}); }
			 
			 public static void StatusChangeReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_StatusChangeReport}); }
			 
			 public static void NonActiveCustomer() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_NonActiveCustomer}); }
			 
			 public static void InstantFundingRejectionReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_InstantFundingRejectionReport}); }
			 
			 public static void ReviewApprovedApplicationReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_ReviewApprovedApplicationReport}); }
			 
			 
			 
		 }
		 
		 public static class DailySummaryReports{
			 
			 public static void EODSummary() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_EODSummary}); }
			 
			 public static void DailyTransactionJournal() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_DailyTransactionJournal}); }
			 
			 public static void StoreCashManagement() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_StoreCashManagement}); }
			 
			 public static void VoidedTransactions() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_VoidedTransactions}); }
			 
			 public static void StoreCashManagementSummaryReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_StoreCashManagementSummaryReport}); }
			 
			 public static void CashOverShortReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_CashOverShortReport}); }
			 
			 public static void CashBalanceTransactionReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_CashBalanceTransactionReport}); }
			 
			 public static void DailyCenterSummaryReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummaryReports,DailySummaryReports_DailyCentreSummaryReport}); }
			 
		 }
		 
		 
		 public static class LoanReports{
			 
			 public static void DefaultReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_DefaultReport}); }
			 
			 public static void PwoReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_PWOReport}); }
			 
			 public static void WriteOffLoansReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_WriteOffLoansReport}); }
			 
			 public static void ReturnedItemsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ReturenedItemsReport}); }
			 
			 public static void SoldLoanReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_SoldLoanReport}); }
			 
			 public static void AllPaymentsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_AllPaymentsReport}); }
			 
			 public static void CheckRegisterReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_CheckRegisterReport}); }
			 
			 public static void OutStandingPresenetmentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_OutStandingPresentmentReport}); }
			 
			 public static void WaiveFeeReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_WaiveFeeReport}); }
			 
			 public static void RefundTransactionReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_RefundTransactionReport}); }
			 
			 public static void NewLoanReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_NewLoanReport}); }
			 
			 public static void ReturnedItemsInventoryReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ReturnedItemsInventoryReport}); }
			 
			 public static void CouponTrackingReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_CouponTrackingReport}); }
			 
			 public static void ACHDetailsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ACHDetailsReport}); }
			 
			 public static void HeldCheckSummary() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_HeldCheckSummary}); }
			 
			 public static void ACHandRCCActivityReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_AChandRccActivityReport}); }
			 
			 public static void ActivePreNoteReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ActivePrenoteReport}); }
			 
			 public static void NonCenterPaymentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_NonCenterPaymentReport}); }
			 
			 public static void ACHCreditRejectionReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_AchCreditRejectionReport}); }
		 }
		 
		 public static class OtherReports{
			 
			 public static void MonetoryTransferLog() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MonetaryTransferLog}); }
			 
			 public static void ActiveUsersReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_ActiveUsersReport}); }
			 
			 public static void MiscDisbursmentsLogReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MiscDisbursementsLogReport}); }
			 
			 public static void RescissionReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_RescissionReport}); }
			 
			 public static void DebitCardPaymentReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_DebitCardPaymentsReport}); }
			 
			 public static void LoansWithCreditBalanceReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LoansWithCreditBalanceReport}); }
			 
			 public static void MiscellaneousRecieptsReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MiscellaneousRecieptsReport}); }
			 
			 public static void LoanDenialReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LoanDenialReport}); }
			 
			 public static void PaymentPlanReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_PaymentPlanReport}); }
			 
			 public static void TimeSheetReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_TimeSheetReport}); }
			 
			 public static void WorkBreakAuditReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_WorkBreakAuditReport}); }
			 
		 }
		 
		 public static class TitleReports{
			 
			 public static void TitleOpenLoanReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleOpenLoanReport}); }
			 
			 public static void TitleNewLoanOriginationReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleNewLoanOriginationReport}); }
			 
			 public static void TitleRepoLogReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleRepoLogReport}); }
			 
			 public static void TitleTrackingStatusReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleTrackingStatusReport}); }
			 
			 public static void TitleSequentialLoanReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleSequentialLoanReport}); }
			 
			 public static void TitleOutToRepoReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleOutToRepoReport}); }
			 
			 public static void TitleSecuredPastDueReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleSecuredPastDueReport}); }
			 
		 }
		 
		 public static class PccReports{
			 
			 public static void CardSaleAndLoanReport() {selectMenu(new WebElement[] {Reports,Reports_PccReports,PccReports_CardSaleAndLoanReport}); }
			 
		 }

	 }

	 }
