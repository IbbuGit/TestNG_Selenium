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

public class QfundAdmin_Navigation  {

	static WebDriver driver;
	static ExtentTest report;
	static WebDriverWait wait;

	static String frameTop="TOP";
	static String frameMiddle="MIDDLE";
	static String frameMain="MAIN";
	static String frameBottom="BOTTOM";
	static String frameDefault="DEFAULT";


	public QfundAdmin_Navigation(WebDriver _driver, ExtentTest _report) {
		driver=_driver;
		report=_report;
		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver, 20);		
	}

	@FindBy(xpath = "//img[@alt='Loading...']")
	protected static WebElement pageLoader;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	protected static WebElement qFundLogo;
	
	public static void selectMenu(WebElement[] elements) {
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
	
	

	public static void selectFrame(String frameName) {

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

	public static void click(WebElement element){
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

//	public static void ActionClick(WebElement element){	
//		//		String temp=Thread.currentThread().getStackTrace()[2].getMethodName();
//		//		String elementName=temp.substring(temp.indexOf("_")+1, temp.length());
//		//		try {
//		//			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
//		//			new Actions(driver).moveToElement(element).click().build().perform();
//		//			report.log(LogStatus.INFO, "Clicked " + elementName);
//		//			System.out.println(LogStatus.INFO+ ": Clicked [" + elementName + "]");
//		//		}catch(Exception e) {
//		//			report.log(LogStatus.FAIL, "Not able to click " + elementName);
//		//			System.out.println(LogStatus.FAIL+ " :Not able to click" + elementName);			
//		//			throw e;
//		//		}
//
//		String temp=Thread.currentThread().getStackTrace()[2].getMethodName();
//		String elementName=temp.substring(temp.indexOf("_")+1, temp.length());
//		try {
//			element.click();
//
//			report.log(LogStatus.INFO, "Clicked " + elementName);
//			System.out.println(LogStatus.INFO+ ": Clicked [" + elementName + "]");
//
//
//		}catch(Exception e) {
//
//			report.log(LogStatus.FAIL, "Not able to click " + elementName);
//			System.out.println(LogStatus.FAIL+ " :Not able to click" + elementName);
//
//			throw e;
//		}
//	}


	//---------------------------------Store set up start---------------------------------------

	@FindBy(id = "100000")
	private static WebElement Admin_StoreSetUp;

	@FindBy(id = "101000")
	private static WebElement Admin_StoreSetUp_StoreConfig;

	@FindBy(id = "101010")
	private static WebElement Admin_StoreSetUp_StoreConfig_AddNew;

	@FindBy(id = "101100")
	private static WebElement Admin_StoreSetUp_StoreConfig_AddNew_AddDivisionalField;

	@FindBy(id = "101101")
	private static WebElement Admin_StoreSetUp_StoreConfig_AddNew_AddRegion;

	@FindBy(id = "101102")
	private static WebElement Admin_StoreSetUp_StoreConfig_AddNew_AddDistrictArea;

	@FindBy(id = "101103")
	private static WebElement Admin_StoreSetUp_StoreConfig_AddNew_AddStore;

	@FindBy(id = "101020")
	private static WebElement Admin_StoreSetUp_StoreConfig_EditStore;

	@FindBy(id = "101030")
	private static WebElement Admin_StoreSetUp_StoreConfig_Systems;

	@FindBy(id = "101040")
	private static WebElement Admin_StoreSetUp_StoreConfig_Drawers;

	@FindBy(id = "101050")
	private static WebElement Admin_StoreSetUp_StoreConfig_Printers;

	@FindBy(id = "988190429")
	private static WebElement Admin_StoreSetUp_StoreConfig_Scanners;


	@FindBy(id = "102000")
	private static WebElement Admin_StoreSetUp_BankAccounts;

	@FindBy(id = "102010")
	private static WebElement Admin_StoreSetUp_BankAccounts_bankAccounts;

	@FindBy(id = "102020")
	private static WebElement Admin_StoreSetUp_BankAccounts_BankMaster;

	@FindBy(id = "102021")
	private static WebElement Admin_StoreSetUp_BankAccounts_BankMaster_AddBank;

	@FindBy(id = "102022")
	private static WebElement Admin_StoreSetUp_BankAccounts_BankMaster_EditBank;

	@FindBy(id = "98819081139")
	private static WebElement Admin_StoreSetUp_BankAccounts_GLAccounts;

	@FindBy(id = "98819081140")
	private static WebElement Admin_StoreSetUp_BankAccounts_GLAccounts_AddGL;

	@FindBy(id = "98819081141")
	private static WebElement Admin_StoreSetUp_BankAccounts_GLAccounts_EditGL;

	@FindBy(id = "98819081152")
	private static WebElement Admin_StoreSetUp_BankAccounts_PendingApprovals;

	@FindBy(id = "98819081153")
	private static WebElement Admin_StoreSetUp_BankAccounts_PendingApprovals_BankApproval;

	@FindBy(id = "98819081154")
	private static WebElement Admin_StoreSetUp_BankAccounts_PendingApprovals_BankAccountApproval;

	@FindBy(id = "98819081155")
	private static WebElement Admin_StoreSetUp_BankAccounts_PendingApprovals_GLAccountsApproval;



	@FindBy(id = "106001")
	private static WebElement Admin_StoreSetUp_MaxBrinksStoreCash;

	@FindBy(id = "106040")
	private static WebElement Admin_StoreSetUp_MaxBrinksStoreCash_AddBrinksCashLimitSet;

	@FindBy(id = "106050")
	private static WebElement Admin_StoreSetUp_MaxBrinksStoreCash_EditBrinkCashLimitSet;

	@FindBy(id = "106060")
	private static WebElement Admin_StoreSetUp_MaxBrinksStoreCash_MapBrinksStoreCashLimit;


	public static class Store_SetUp {
		
		public static void StoeSetUp() {selectMenu(new WebElement[] {Admin_StoreSetUp}); }
		public static void StoreConfig() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig}); }
		public static void BankAccounts() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts}); }
		public static void MaxBrinkStoreCash() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_MaxBrinksStoreCash}); }
		
	
		public static class StoreConfig{
			public static void AddNew() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_AddNew}); }
			
			public static class AddNew {
				public static void StoreConfig_AddNew_AddDivisionalField() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_AddNew,Admin_StoreSetUp_StoreConfig_AddNew_AddDivisionalField}); }
				public static void StoreConfig_AddNew_AddRegion() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_AddNew,Admin_StoreSetUp_StoreConfig_AddNew_AddRegion}); }
				public static void StoreConfig_AddNew_AddDistrictArea() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_AddNew,Admin_StoreSetUp_StoreConfig_AddNew_AddDistrictArea}); }
				public static void StoreConfig_AddNew_AddStore() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_AddNew,Admin_StoreSetUp_StoreConfig_AddNew_AddStore}); }
								
			}
			public static void EditStore() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_EditStore}); }
			public static void Systems() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_Systems}); }
			public static void Drawers() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_Drawers}); }
			public static void Printers() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_Printers}); }
			public static void Scanners() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_StoreConfig,Admin_StoreSetUp_StoreConfig_Scanners}); }

		}

		public static class BankAccount_Tab {
			public static void BankAccounts() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_bankAccounts}); }
			public static void BankMaster() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_BankMaster}); }
		

			public static class BankMaster {
				public static void BankAccounts_BankMaster_AddBank() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_BankMaster,Admin_StoreSetUp_BankAccounts_BankMaster_AddBank}); }
				public static void BankAccounts_BankMaster_EditBank() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_BankMaster,Admin_StoreSetUp_BankAccounts_BankMaster_EditBank}); }

		}
			public static void GL_Accounts() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_GLAccounts}); }
			
			public static class GL_Accounts {
				public static void BankAccounts_GLAccounts_AddGL() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_GLAccounts,Admin_StoreSetUp_BankAccounts_GLAccounts_AddGL}); }
				public static void BankAccounts_GLAccounts_EditGL() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_GLAccounts,Admin_StoreSetUp_BankAccounts_GLAccounts_EditGL}); }

			}
			
			
			public static void PendingApprovals() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_PendingApprovals}); }
			

			public static class PendingApprovals {
				public static void BankAccounts_PendingApprovals_BankApproval() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_PendingApprovals,Admin_StoreSetUp_BankAccounts_PendingApprovals_BankApproval}); }
				public static void BankAccounts_PendingApprovals_BankAccountApproval() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_PendingApprovals,Admin_StoreSetUp_BankAccounts_PendingApprovals_BankAccountApproval}); }
				public static void BankAccounts_PendingApprovals_GLAccountsApproval() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_BankAccounts,Admin_StoreSetUp_BankAccounts_PendingApprovals,Admin_StoreSetUp_BankAccounts_PendingApprovals_GLAccountsApproval}); }
								
			}
		}

		public static class MaxBrinksStoreCash {
			public static void AddBrinksCashLimitSet() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_MaxBrinksStoreCash,Admin_StoreSetUp_MaxBrinksStoreCash_AddBrinksCashLimitSet}); }
			public static void EditBrinksCashLimitSet() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_MaxBrinksStoreCash,Admin_StoreSetUp_MaxBrinksStoreCash_EditBrinkCashLimitSet}); }
			public static void MapBrinksStoreCashLimit() {selectMenu(new WebElement[] {Admin_StoreSetUp,Admin_StoreSetUp_MaxBrinksStoreCash,Admin_StoreSetUp_MaxBrinksStoreCash_MapBrinksStoreCashLimit}); }

		}

	}

	//------------------Employee Starts-------------------------------------------------------------------

	@FindBy(id = "200000")
	private static WebElement Employee;

	@FindBy(id = "201000")
	private static WebElement Employee_AddEmployee;

	@FindBy(id = "202000")
	private static WebElement Employee_EditEmployee;

	@FindBy(id = "203000")
	private static WebElement Employee_Pin;

	@FindBy(id = "203010")
	private static WebElement Employee_Pin_ResetPin;

	@FindBy(id = "203020")
	private static WebElement Employee_Pin_UnlockEmployee;

	@FindBy(id = "205000")
	private static WebElement Employee_EncryptionKey;

	@FindBy(id = "205020")
	private static WebElement Employee_EncryptionKey_Encryption;


	public static class EmployeeTab {
		public static void Employee() {selectMenu(new WebElement[] {Employee}); }
		public static void AddEmployee() {selectMenu(new WebElement[] {Employee,Employee_AddEmployee}); }
		public static void EditEmployee() {selectMenu(new WebElement[] {Employee,Employee_EditEmployee}); }
		public static void Pin() {selectMenu(new WebElement[] {Employee,Employee_Pin}); }
		public static void EncryptionKey() {selectMenu(new WebElement[] {Employee,Employee_EncryptionKey}); }

		public static class Pin {
			public static void ResetPin() {selectMenu(new WebElement[] {Employee,Employee_Pin,Employee_Pin_ResetPin}); }
			public static void UnlockEmployee() {selectMenu(new WebElement[] {Employee,Employee_Pin,Employee_Pin_UnlockEmployee}); }
			
		}

		public static class EncryptionKey {
			public static void Encryption() {selectMenu(new WebElement[] {Employee,Employee_EncryptionKey,Employee_EncryptionKey_Encryption}); }
			
		}
	}

	//------------------------Access Rights starts-------------------------------------------------

	@FindBy(id = "300000")
	private static WebElement AccessRights;

	@FindBy(id = "301000")
	private static WebElement AccessRights_RoleSetUp;

	@FindBy(id = "302000")
	private static WebElement AccessRights_MapRole_ACL;

	@FindBy(id = "303000")
	private static WebElement AccessRights_EditRole_ACL;



	public static class Access_Rights {
		public static void AccessRights() {selectMenu(new WebElement[] {AccessRights}); }
		public static void RoleSetUp() {selectMenu(new WebElement[] {AccessRights,AccessRights_RoleSetUp}); }
		public static void MapRoleACL() {selectMenu(new WebElement[] {AccessRights,AccessRights_MapRole_ACL}); }
		public static void EditRoleACL() {selectMenu(new WebElement[] {AccessRights,AccessRights_EditRole_ACL}); }

	}


	//---------------------------------Transactions Starts--------------------------------------------------

	@FindBy(id = "500000")
	private static WebElement Transactions;

	@FindBy(id = "407")
	private static WebElement Transactions_QueueManagement;

	@FindBy(id = "408")
	private static WebElement QueueManagement_QueueConfiguration;

	@FindBy(id = "409")
	private static WebElement QueueManagement_QueueMapping;

	@FindBy(id = "98819081161")
	private static WebElement QueueManagement_QueueMapping_MapQueue;

	@FindBy(id = "98819081163")
	private static WebElement QueueManagement_QueueMapping_EditMapping;

	@FindBy(id = "98819081174")
	private static WebElement QueueManagement_QueueMapping_UnMapQueue;


	@FindBy(id = "101061")
	private static WebElement Transactions_LetterManagement;

	@FindBy(id = "501000")
	private static WebElement Transactions_CollateralChecks;

	@FindBy(id = "501020")
	private static WebElement CollateralChecks_InstallmentLoan;

	@FindBy(id = "501021")
	private static WebElement CollateralChecks_InstallmentLoan_ReturnPosting;

	@FindBy(id = "988190742")
	private static WebElement CollateralChecks_InstallmentLoan_Deposit;

	@FindBy(id = "988190743")
	private static WebElement CollateralChecks_InstallmentLoan_Clear;

	@FindBy(id = "988190747")
	private static WebElement CollateralChecks_InstallmentLoan_Redeposit_Representment;

	@FindBy(id = "988190814")
	private static WebElement CollateralChecks_InstallmentLoan_RedepositClear;

	@FindBy(id = "988190815")
	private static WebElement CollateralChecks_InstallmentLoan_RedepositReturn;

	@FindBy(id = "988190744")
	private static WebElement Transactions_DebitCards;


	@FindBy(id = "988190745")
	private static WebElement DebitCards_InstallmentLoan;

	@FindBy(id = "988190746")
	private static WebElement DebitCards_InstallmentLoan_ReDeposit_Representment;

	@FindBy(id = "988190797")
	private static WebElement DebitCards_InstallmentLoan_Deposit;

	@FindBy(id = "9881908022")
	private static WebElement DebitCards_InstallmentLoan_DebitCardOnFile;


	@FindBy(id = "988190807")
	private static WebElement DebitCards_PaydayLoan;

	@FindBy(id = "988190806")
	private static WebElement DebitCards_PaydayLoan_Deposit;

	@FindBy(id = "988190808")
	private static WebElement DebitCards_PaydayLoan_ReDeposit_Representment;

	@FindBy(id = "9881908025")
	private static WebElement DebitCards_PaydayLoan_DebitCardOnFile;


	@FindBy(id = "9881908054")
	private static WebElement DebitCards_TitleLoan;

	@FindBy(id = "9881908090")
	private static WebElement DebitCards_TitleLoan_DebitCardOnFile;


	@FindBy(id = "9881901112")
	private static WebElement DebitCards_MarkChargeBack;

	@FindBy(id = "9881901113")
	private static WebElement DebitCards_ChargeBackReturnPayment;

	@FindBy(id = "9881901115")
	private static WebElement DebitCards_DebitCardBatchProcess;

	@FindBy(id = "9881901137")
	private static WebElement DebitCards_DebitCardEODRepresentment;

	@FindBy(id = "9881901137")
	private static WebElement DebitCards_DebitCardRepresentmentBatchProcess;

	@FindBy(id = "502000")
	private static WebElement Transactions_Borrower;

	@FindBy(id = "502030")
	private static WebElement Borrower_ExitHitList;

	@FindBy(id = "502060")
	private static WebElement Borrower_Transfer;

	@FindBy(id = "502070")
	private static WebElement Borrower_DrawerDeassign;

	@FindBy(id = "502080")
	private static WebElement Borrower_SafeDeassign;

	@FindBy(id = "502090")
	private static WebElement Borrower_ReprintCheck;

	@FindBy(id = "502091")
	private static WebElement Borrower_ReprintRefundCheck;

	@FindBy(id = "502120")
	private static WebElement Borrower_EditSSN;

	@FindBy(id = "502140")
	private static WebElement Borrower_LegalAndGarnishment;

	@FindBy(id = "502170")
	private static WebElement Borrower_Email;

	@FindBy(id = "502171")
	private static WebElement Borrower_Email_InsertToEmailBatchProcess;

	@FindBy(id = "502172")
	private static WebElement Borrower_Email_CreateEmailBatchProcessFile;

	@FindBy(id = "502180")
	private static WebElement Borrower_Text;

	@FindBy(id = "502181")
	private static WebElement Borrower_Text_InsertToTextBatchProcess;

	@FindBy(id = "502182")
	private static WebElement Borrower_Text_CreateTextBatchProcessFile;

	@FindBy(id = "95519009")
	private static WebElement Borrower_BorrowerSearch;

	@FindBy(id = "95519017")
	private static WebElement Borrower_CheckScanningImage;

	@FindBy(id = "988190496")
	private static WebElement Borrower_Bankruptcy_DeceasedSuite;

	@FindBy(id = "988190626")
	private static WebElement Borrower_ReprintCollateralCheck;

	@FindBy(id = "98819081157")
	private static WebElement Borrower_CustomerBankEdit;

	@FindBy(id = "503000")
	private static WebElement Transactions_ACH;

	@FindBy(id = "503010")
	private static WebElement ACH_PaydayLoan;

	@FindBy(id = "503011")
	private static WebElement ACH_PaydayLoan_ACHdeposit;

	@FindBy(id = "503012")
	private static WebElement ACH_PaydayLoan_ACHclear;

	@FindBy(id = "503013")
	private static WebElement ACH_PaydayLoan_ACHreturn;

	@FindBy(id = "503015")
	private static WebElement ACH_PaydayLoan_Redeposit_Representment;

	@FindBy(id = "503018")
	private static WebElement ACH_PaydayLoan_ACHreturnProcess;

	@FindBy(id = "503019")
	private static WebElement ACH_PaydayLoan_ACHprocessing;

	@FindBy(id = "5030111")
	private static WebElement ACH_PaydayLoan_Download;

	@FindBy(id = "5030112")
	private static WebElement ACH_PaydayLoan_ProcessPreACHdeposit;

	@FindBy(id = "5030113")
	private static WebElement ACH_PaydayLoan_PDLpreACHdepositInserts;

	@FindBy(id = "503030")
	private static WebElement ACH_InstallmentLoan;

	@FindBy(id = "503031")
	private static WebElement ACH_InstallmentLoan_DefaultACHreturn;

	@FindBy(id = "503032")
	private static WebElement ACH_InstallmentLoan_VoidDefaultACHreturn;

	@FindBy(id = "503033")
	private static WebElement ACH_InstallmentLoan_ACHreturnProcess;

	@FindBy(id = "503036")
	private static WebElement ACH_InstallmentLoan_ACHprocessing;

	@FindBy(id = "503037")
	private static WebElement ACH_InstallmentLoan_Download;

	@FindBy(id = "98819128")
	private static WebElement ACH_InstallmentLoan_ACHdeposit;

	@FindBy(id = "988190792")
	private static WebElement ACH_InstallmentLoan_ACHclear;

	@FindBy(id = "988190793")
	private static WebElement ACH_InstallmentLoan_ReDeposit_Representment;

	@FindBy(id = "988190816")
	private static WebElement ACH_InstallmentLoan_ReDepositClear;

	@FindBy(id = "988190818")
	private static WebElement ACH_InstallmentLoan_ACHreturn;

	@FindBy(id = "503100")
	private static WebElement ACH_RCC;

	@FindBy(id = "503200")
	private static WebElement ACH_RCPO;

	@FindBy(id = "503300")
	private static WebElement ACH_GreenBank;

	@FindBy(id = "503301")
	private static WebElement ACH_GreenBank_GreenBankNACHAfile;

	@FindBy(id = "503302")
	private static WebElement ACH_GreenBank_GreenBankACHreturnProcess;

	@FindBy(id = "503400")
	private static WebElement ACH_RCCPayments;
	
	@FindBy(id = "503401")
	private static WebElement ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile;

//	@FindBy(id = "503401")
	private static WebElement ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile;
	
	@FindBy(id = "955190290")
	private static WebElement ACH_LOC;

	@FindBy(id = "988190515")
	private static WebElement ACH_LOC_ACHclear;

	@FindBy(id = "98819081009")
	private static WebElement ACH_LOC_WriteOffLOC;

	@FindBy(id = "98819081100")
	private static WebElement ACH_LOC_UnsecureLOCStatement;

	@FindBy(id = "98819081102")
	private static WebElement ACH_LOC_DefaultLOC;

	@FindBy(id = "98819081104")
	private static WebElement ACH_LOC_LOCpreACHdeposit;

	@FindBy(id = "98819081106")
	private static WebElement ACH_LOC_LOCpreACHdepositsInserts;

	@FindBy(id = "9881908058")
	private static WebElement ACH_TitleLoan;

	@FindBy(id = "506000")
	private static WebElement Transactions_CheckCashing;

	@FindBy(id = "506009")
	private static WebElement CheckCashing_ListAllUsers;

	@FindBy(id = "506010")
	private static WebElement CheckCashing_Warnings;

	@FindBy(id = "506021")
	private static WebElement CheckCashing_CheckTypes;

	@FindBy(id = "506023")
	private static WebElement CheckCashing_Verification;

	@FindBy(id = "506024")
	private static WebElement CheckCashing_TurnDown;

	@FindBy(id = "506025")
	private static WebElement CheckCashing_ReturnPosting;

	@FindBy(id = "506026")
	private static WebElement CheckCashing_Clear;

	@FindBy(id = "506027")
	private static WebElement CheckCashing_VoidReturnPosting;

	@FindBy(id = "506028")
	private static WebElement CheckCashing_VoidClear;

	@FindBy(id = "506029")
	private static WebElement CheckCashing_ReDeposit_Representment;

	@FindBy(id = "506031")
	private static WebElement CheckCashing_ReDepositReturn;

	@FindBy(id = "506032")
	private static WebElement CheckCashing_RedepositClear;

	@FindBy(id = "509004")
	private static WebElement Transactions_PaymentCHKReturnPosting;

	@FindBy(id = "988190418")
	private static WebElement Transactions_ThirdPartyCollections;

	@FindBy(id = "988190844")
	private static WebElement ThirdPartyCollections_VOApps;

	@FindBy(id = "507000")
	private static WebElement Transactions_QAJobs;

	@FindBy(id = "502150")
	private static WebElement QAJobs_ProcessDateChange;

	@FindBy(id = "507040")
	private static WebElement QAJobs_IPDLPreNoteDepositProcess;

	@FindBy(id = "507041")
	private static WebElement QAJobs_TLPPreNoteDepositProcess;

	@FindBy(id = "507042")
	private static WebElement QAJobs_PDLPreNoteDepositProcess;

	@FindBy(id = "507050")
	private static WebElement QAJobs_OnlineJobs;
	
	@FindBy(id = "98819081226")
	private static WebElement QAJobs_OnlineProcessDateChange;

	@FindBy(id = "508000")
	private static WebElement Transactions_EODBatchProcess;

	@FindBy(id = "9881908084")
	private static WebElement Transactions_TitleLoan;

	@FindBy(id = "9881908085")
	private static WebElement TitleLoan_TitleTracking;

	@FindBy(id = "98819081097")
	private static WebElement TitleLoan_PostDefaultTransactions;

	@FindBy(id = "98819081109")
	private static WebElement TitleLoan_AddEditPayeeName;

	@FindBy(id = "98819081121")
	private static WebElement TitleLoan_ManualDefaultTransaction;

	@FindBy(id = "98819081145")
	private static WebElement TitleLoan_SendVehicleStatusMail;

	@FindBy(id = "98819081182")
	private static WebElement Transactions_Collections;


	public static class Transactions_Tab {
		public static void Trasactions() {selectMenu(new WebElement[] {Transactions}); }
		public static void QueueManagement() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement}); }
		public static void LetterManagement() {selectMenu(new WebElement[] {Transactions,Transactions_LetterManagement}); }
		public static void CollateralChecks() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks}); }
		public static void DebitCards() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards}); }
		public static void Borrower() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower}); }
		public static void ACH() {selectMenu(new WebElement[] {Transactions,Transactions_ACH}); }
		public static void CheckCashing() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing}); }
		public static void PaymentCheckReturnPosting() {selectMenu(new WebElement[] {Transactions,Transactions_PaymentCHKReturnPosting}); }
		public static void ThirdPartyCollections() {selectMenu(new WebElement[] {Transactions,Transactions_ThirdPartyCollections}); }
		public static void QAjobs() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs}); }
		public static void EODBatchProcess() {selectMenu(new WebElement[] {Transactions,Transactions_EODBatchProcess}); }
		public static void TitleLoan() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan}); }
		public static void Collections() {selectMenu(new WebElement[] {Transactions,Transactions_Collections}); }
	

		public static class QueueManagement {
			public static void QueueConfiguration() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement,QueueManagement_QueueConfiguration}); }
			public static void QueueMapping() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement,QueueManagement_QueueMapping}); }
			
			public static class QueueMapping {
				public static void QueueManagement_QueueMapping_MapQueue() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement,QueueManagement_QueueMapping,QueueManagement_QueueMapping_MapQueue}); }
				public static void QueueManagement_QueueMapping_EditMapping() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement,QueueManagement_QueueMapping,QueueManagement_QueueMapping_EditMapping}); }
				public static void QueueManagement_QueueMapping_UnMapQueue() {selectMenu(new WebElement[] {Transactions,Transactions_QueueManagement,QueueManagement_QueueMapping,QueueManagement_QueueMapping_UnMapQueue}); }
								
			}
		}

		public static class CollateralChecks {
			public static void CollateralChecks_InstallmentLoan() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan}); }
			
			public static class InstallmentLoan {
				public static void CollateralChecks_InstallmentLoan_ReturnPosting() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_ReturnPosting}); }
				public static void CollateralChecks_InstallmentLoan_Deposit() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_Deposit}); }
				public static void CollateralChecks_InstallmentLoan_Clear() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_Clear}); }
				public static void CollateralChecks_InstallmentLoan_Redeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_Redeposit_Representment}); }
				public static void CollateralChecks_InstallmentLoan_RedepositClear() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_RedepositClear}); }
				public static void CollateralChecks_InstallmentLoan_RedepositReturn() {selectMenu(new WebElement[] {Transactions,Transactions_CollateralChecks,CollateralChecks_InstallmentLoan,CollateralChecks_InstallmentLoan_RedepositReturn}); }
				
			}

		}

		public static class DebitCards {
			public static void DebitCards_InstallmentLoan() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_InstallmentLoan}); }
			
			public static class InstallmentLoan {
				public static void DebitCards_InstallmentLoan_ReDeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_InstallmentLoan,DebitCards_InstallmentLoan_ReDeposit_Representment}); }
				public static void DebitCards_InstallmentLoan_Deposit() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_InstallmentLoan,DebitCards_InstallmentLoan_Deposit}); }
				public static void DebitCards_InstallmentLoan_DebitCardOnFile() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_InstallmentLoan,DebitCards_InstallmentLoan_DebitCardOnFile}); }
				
			}
			public static void PayDayLoan() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_PaydayLoan}); }
			
			public static class PayDayLoan {
				public static void DebitCards_PaydayLoan_Deposit() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_PaydayLoan,DebitCards_PaydayLoan_Deposit}); }
				public static void DebitCards_PaydayLoan_ReDeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_PaydayLoan,DebitCards_PaydayLoan_ReDeposit_Representment}); }
				public static void DebitCards_PaydayLoan_DebitCardOnFile() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_PaydayLoan,DebitCards_PaydayLoan_DebitCardOnFile}); }

			}
			public static void DebitCards_TitleLoan() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_TitleLoan}); }
			

			public static class TitleLoan {
				public static void DebitCards_TitleLoan_DebitCardOnFile() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_TitleLoan,DebitCards_TitleLoan_DebitCardOnFile}); }
				
			}
			public static void MarkChargeBack() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_MarkChargeBack}); }
			public static void ChargeBackReturnPayment() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_ChargeBackReturnPayment}); }
			public static void DebitCardBatchProcesses() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_DebitCardBatchProcess}); }
			public static void DebitCardEODRepresentment() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_DebitCardEODRepresentment}); }
			public static void DebitCardRepresentmentBatchProcess() {selectMenu(new WebElement[] {Transactions,Transactions_DebitCards,DebitCards_DebitCardRepresentmentBatchProcess}); }
			
		}

		public static class Borrower {
			public static void ExitHitList() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_ExitHitList}); }
			public static void Transfer() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Transfer}); }
			public static void DrawerDeassign() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_DrawerDeassign}); }
			public static void SafeDeassign() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_SafeDeassign}); }
			public static void ReprintCheck() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_ReprintCheck}); }
			public static void ReprintRefundCheck() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_ReprintRefundCheck}); }
			public static void EditSSN() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_EditSSN}); }
			public static void LegalAndGarnishment() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_LegalAndGarnishment}); }
			public static void Email() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Email}); }
			

			public static class Email {
				public static void Borrower_Email_InsertToEmailBatchProcess() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Email,Borrower_Email_InsertToEmailBatchProcess}); }
				public static void Borrower_Email_CreateEmailBatchProcessFile() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Email,Borrower_Email_CreateEmailBatchProcessFile}); }
				
			}
			public static void Text() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Text}); }
			
			public static class Text {
				public static void Borrower_Text_InsertToTextBatchProcess() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Text,Borrower_Text_InsertToTextBatchProcess}); }
				public static void Borrower_Text_CreateTextBatchProcessFile() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Text,Borrower_Text_CreateTextBatchProcessFile}); }
				
			}
			public static void BorrowerSearch() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_BorrowerSearch}); }
			public static void CheckScanningImage() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_CheckScanningImage}); }
			public static void Bankruptcy_DeceasedSuite() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_Bankruptcy_DeceasedSuite}); }
			public static void ReprintCollateralCheck() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_ReprintCollateralCheck}); }
			public static void CustomerBankEdit() {selectMenu(new WebElement[] {Transactions,Transactions_Borrower,Borrower_CustomerBankEdit}); }
	}

		public static class ACH {
			public static void ACH_PaydayLoan() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan}); }
			

			public static class PaydayLoan {
				public static void ACH_PaydayLoan_ACHdeposit() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ACHdeposit}); }
				public static void ACH_PaydayLoan_ACHclear() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ACHclear}); }
				public static void ACH_PaydayLoan_ACHreturn() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ACHreturn}); }
				public static void ACH_PaydayLoan_Redeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_Redeposit_Representment}); }
				public static void ACH_PaydayLoan_ACHreturnProcess() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ACHreturnProcess}); }
				public static void ACH_PaydayLoan_ACHprocessing() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ACHprocessing}); }
				public static void ACH_PaydayLoan_Download() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_Download}); }
				public static void ACH_PaydayLoan_ProcessPreACHdeposit() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_ProcessPreACHdeposit}); }
				public static void ACH_PaydayLoan_PDLpreACHdepositInserts() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_PaydayLoan,ACH_PaydayLoan_PDLpreACHdepositInserts}); }

			}
			public static void ACH_InstallmentLoan() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan}); }
			
			public static class InstallmentLoan {
				public static void ACH_InstallmentLoan_DefaultACHreturn() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_DefaultACHreturn}); }
				public static void ACH_InstallmentLoan_VoidDefaultACHreturn() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_VoidDefaultACHreturn}); }
				public static void ACH_InstallmentLoan_ACHreturnProcess() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ACHreturnProcess}); }
				public static void ACH_InstallmentLoan_ACHprocessing() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ACHprocessing}); }
				public static void ACH_InstallmentLoan_Download() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_Download}); }
				public static void ACH_InstallmentLoan_ACHdeposit() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ACHdeposit}); }
				public static void ACH_InstallmentLoan_ACHclear() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ACHclear}); }
				public static void ACH_InstallmentLoan_ReDeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ReDeposit_Representment}); }
				public static void ACH_InstallmentLoan_ReDepositClear() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ReDepositClear}); }
				public static void ACH_InstallmentLoan_ACHreturn() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_InstallmentLoan,ACH_InstallmentLoan_ACHreturn}); }
				
			}
			public static void ACH_RCC() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCC}); }
			public static void ACH_RCPO() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCPO}); }
			public static void ACH_GreenBank() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_GreenBank}); }
		

			public static class GreenBank {
				public static void ACH_GreenBank_GreenBankNACHAfile() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_GreenBank,ACH_GreenBank_GreenBankNACHAfile}); }
				public static void ACH_GreenBank_GreenBankACHreturnProcess() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_GreenBank,ACH_GreenBank_GreenBankACHreturnProcess}); }

			}
			
//			public static void ACH_RCCPayments() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCCPayments}); }
			public static class ACH_RCCPayments {
				public static void ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile(){selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCCPayments,ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile});} 
				public static void ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile(){selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCCPayments,ACH_RCCPayments_RCCPaymentsAfterDEFOriginationFile});}
			}
			
			public static void ACH_LOC() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC}); }

			public static class LOC {
				public static void ACH_LOC_ACHclear() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_ACHclear}); }
				public static void ACH_LOC_WriteOffLOC() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_WriteOffLOC}); }
				public static void ACH_LOC_UnsecureLOCStatement() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_UnsecureLOCStatement}); }
				public static void ACH_LOC_DefaultLOC() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_DefaultLOC}); }
				public static void ACH_LOC_LOCpreACHdeposit() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_LOCpreACHdeposit}); }
				public static void ACH_LOC_LOCpreACHdepositsInserts() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_LOC,ACH_LOC_LOCpreACHdepositsInserts}); }
			}
			
			public static void ACH_TitleLoan() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_TitleLoan}); }
			
		}
		
//		public static class RCCPayments {
//			
//			public static void ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile() {selectMenu(new WebElement[] {Transactions,Transactions_ACH,ACH_RCCPayments,ACH_RCCPayments_RCCPaymentsBeforeDEFOriginationFile});
//		}

		public static class CheckCashing {
			public static void ListAllUsers() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_ListAllUsers}); }
			public static void Warnings() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_Warnings}); }
			public static void CheckTypes() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_CheckTypes}); }
			public static void Verification() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_Verification}); }
			public static void TurnDown() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_TurnDown}); }
			public static void ReturnPosting() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_ReturnPosting}); }
			public static void Clear() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_Clear}); }
			public static void VoidReturnPosting() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_VoidReturnPosting}); }
			public static void VoidClear() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_VoidClear}); }
			public static void ReDeposit_Representment() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_ReDeposit_Representment}); }
			public static void ReDepositReturn() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_ReDepositReturn}); }
			public static void RedepositClear() {selectMenu(new WebElement[] {Transactions,Transactions_CheckCashing,CheckCashing_RedepositClear}); }
		}

		public static class ThirdPartyCollectionsTab {
			public static void VOApps() {selectMenu(new WebElement[] {Transactions,Transactions_ThirdPartyCollections,ThirdPartyCollections_VOApps}); }
			
		}

		public static class QAJobsTab {

			 public static void ProcessDateChange() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_ProcessDateChange});}
			 public static void IPDLPreNoteDepositProcess() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_IPDLPreNoteDepositProcess});}
			 public static void TLPPreNoteDepositProcess() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_TLPPreNoteDepositProcess});}
			 public static void PDLPreNoteDepositProcess() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_PDLPreNoteDepositProcess});}
			 public static void OnlineJobs() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_OnlineJobs});}
			 public static void OnlineProcessDateChange() {selectMenu(new WebElement[] {Transactions,Transactions_QAJobs,QAJobs_OnlineProcessDateChange});}
			 
			
		}

		public static class TitleLoanTab {
			public static void TitleTracking() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan,TitleLoan_TitleTracking}); }
			public static void PostDefaultTransactions() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan,TitleLoan_PostDefaultTransactions}); }
			public static void AddEditPayeeName() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan,TitleLoan_AddEditPayeeName}); }
			public static void ManualDefaultTransaction() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan,TitleLoan_ManualDefaultTransaction}); }
			public static void SendVehicleStatusMail() {selectMenu(new WebElement[] {Transactions,Transactions_TitleLoan,TitleLoan_SendVehicleStatusMail}); }
			
		}

	}

	//---------------------------------------Reports starts-----------------------------------

	@FindBy(id = "600000")
	private static WebElement Reports;

	@FindBy(id = "601000")
	private static WebElement Reports_CollectionReports;

	@FindBy(id = "601010")
	private static WebElement CollectionReports_PastDueReport;

	@FindBy(id = "601040")
	private static WebElement CollectionReports_CollectionActivity;

	@FindBy(id = "602070")
	private static WebElement CollectionReports_CourtestCallReport;

	@FindBy(id = "608163")
	private static WebElement CollectionReports_PromiseToPay;

	@FindBy(id = "988190673")
	private static WebElement CollectionReports_StoreToCentralCollectionsReport;

	@FindBy(id = "988190734")
	private static WebElement CollectionReports_StoreCallReport;

	@FindBy(id = "98819081192")
	private static WebElement CollectionReports_WriteOffRecoveriesReport;


	@FindBy(id = "602000")
	private static WebElement Reports_CustomerReports;

	@FindBy(id = "601030")
	private static WebElement CustomerReports_BankruptcyReport;

	@FindBy(id = "601050")
	private static WebElement CustomerReports_BankruptcyPayments;

	@FindBy(id = "601194")
	private static WebElement CustomerReports_PendingBankruptcyReport;

	@FindBy(id = "602010")
	private static WebElement CustomerReports_InactiveCustomer;

	@FindBy(id = "602020")
	private static WebElement CustomerReports_ActiveCustomer;

	@FindBy(id = "988190518")
	private static WebElement CustomerReports_ActiveMilitary;

	@FindBy(id = "988190606")
	private static WebElement CustomerReports_HitListReport;

	@FindBy(id = "988190628")
	private static WebElement CustomerReports_CustomerCamReport;

	@FindBy(id = "988190651")
	private static WebElement CustomerReports_UpdatedCustomerInformationReport;

	@FindBy(id = "988190654")
	private static WebElement CustomerReports_OFACResponceReport;

	@FindBy(id = "988190658")
	private static WebElement CustomerReports_DoNotCallReport;

	@FindBy(id = "988190772")
	private static WebElement CustomerReports_InactiveBankAccountReport;

	@FindBy(id = "9881908051")
	private static WebElement CustomerReports_FormerBorrowersReport;

	@FindBy(id = "98819081160")
	private static WebElement CustomerReports_BSATransactionLogReport;

	@FindBy(id = "98819081195")
	private static WebElement CustomerReports_StatusChangeReport;

	@FindBy(id = "98819081200")
	private static WebElement CustomerReports_DeceasedCustomerReport;

	@FindBy(id = "98819081204")
	private static WebElement CustomerReports_MostRecentCustomerReport;

	@FindBy(id = "603000")
	private static WebElement Reports_DailySummeryReports;

	@FindBy(id = "603020")
	private static WebElement DailySummeryReports_DailyTransactionJournal;

	@FindBy(id = "603040")
	private static WebElement DailySummeryReports_StoreCashManagement;

	@FindBy(id = "603050")
	private static WebElement DailySummeryReports_EODSummary;

	@FindBy(id = "603070")
	private static WebElement DailySummeryReports_VoidedTransactions;

	@FindBy(id = "988190503")
	private static WebElement DailySummeryReports_AccountsReceivableAgingReport;

	@FindBy(id = "988190630")
	private static WebElement DailySummeryReports_CashOverShort;

	@FindBy(id = "988190644")
	private static WebElement DailySummeryReports_CashBalanceTransactionReport;

	@FindBy(id = "988190663")
	private static WebElement DailySummeryReports_StoreCashManagementReport;

	@FindBy(id = "988190668")
	private static WebElement DailySummeryReports_AllPaymentsReport;

	@FindBy(id = "988190739")
	private static WebElement DailySummeryReports_CashBalanceReport;

	@FindBy(id = "988190740")
	private static WebElement DailySummeryReports_DrawerJournelReport;

	@FindBy(id = "9881908097")
	private static WebElement DailySummeryReports_DailyPerformanceReport;

	@FindBy(id = "604000")
	private static WebElement Reports_LoanReports;

	@FindBy(id = "603120")
	private static WebElement LoanReports_OutStandingPresentmentReport;

	@FindBy(id = "604010")
	private static WebElement LoanReports_ReturnedItemsReport;

	@FindBy(id = "604030")
	private static WebElement LoanReports_HeldCheckSummary;

	@FindBy(id = "604100")
	private static WebElement LoanReports_CheckRegisterReport;

	@FindBy(id = "604170")
	private static WebElement LoanReports_WaiveNSF_FeeReport;

	@FindBy(id = "604196")
	private static WebElement LoanReports_PWOReport;

	@FindBy(id = "609041")
	private static WebElement LoanReports_WriteOffLoansReport;

	@FindBy(id = "13700009")
	private static WebElement LoanReports_SoldLoanReport;

	@FindBy(id = "988190424")
	private static WebElement LoanReports_CouponTrackingReport;

	@FindBy(id = "988190507")
	private static WebElement LoanReports_RefundTransactionReport;

	@FindBy(id = "988190650")
	private static WebElement LoanReports_ACHDetailsReport;

	@FindBy(id = "988190662")
	private static WebElement LoanReports_RepresentmentReport;

	@FindBy(id = "988190675")
	private static WebElement LoanReports_NewLoanReport;

	@FindBy(id = "988190676")
	private static WebElement LoanReports_ReturnedItemsInventoryReport;

	@FindBy(id = "988190678")
	private static WebElement LoanReports_CurrentLoanInventoryReport;

	@FindBy(id = "988190729")
	private static WebElement LoanReports_TransferPaymentsReport;

	@FindBy(id = "988190730")
	private static WebElement LoanReports_PendingCheck21Report;

	@FindBy(id = "988190732")
	private static WebElement LoanReports_DefaultReport;

	@FindBy(id = "98819081167")
	private static WebElement LoanReports_ScheduledPaymentReport;

	@FindBy(id = "98819081168")
	private static WebElement LoanReports_ACHandRCCPaymentReport;

	@FindBy(id = "98819081196")
	private static WebElement LoanReports_ActivePernoteReport;

	@FindBy(id = "605000")
	private static WebElement Reports_OtherReports;

	@FindBy(id = "605030")
	private static WebElement OtherReports_MonetaryTransferLog;

	@FindBy(id = "988190516")
	private static WebElement OtherReports_RescissionReport;

	@FindBy(id = "988190519")
	private static WebElement OtherReports_PaymentPlanReport;

	@FindBy(id = "988190532")
	private static WebElement OtherReports_EncryptionKeyReport;

	@FindBy(id = "988190537")
	private static WebElement OtherReports_MiscDisbursementsLogReport;

	@FindBy(id = "988190602")
	private static WebElement OtherReports_MiscReciptsLog;

	@FindBy(id = "605000")
	private static WebElement OtherReports_ActiveUsersReport;

	@FindBy(id = "988190667")
	private static WebElement OtherReports_CurrencyTransactionReport;

	@FindBy(id = "988190669")
	private static WebElement OtherReports_TellerProductivityReport;

	@FindBy(id = "988190670")
	private static WebElement OtherReports_LoansCreditBalanceReport;

	@FindBy(id = "988190671")
	private static WebElement OtherReports_DebitCardPaymentsReport;

	@FindBy(id = "988190672")
	private static WebElement OtherReports_NOATMissingReport;

	@FindBy(id = "988190736")
	private static WebElement OtherReports_LoanDenialReport;

	@FindBy(id = "988190771")
	private static WebElement OtherReports_LargeScaleReport;

	@FindBy(id = "988190801")
	private static WebElement OtherReports_ACHCollectionReport;

	@FindBy(id = "9881908012")
	private static WebElement OtherReports_VeritecReport;

	@FindBy(id = "9881908019")
	private static WebElement OtherReports_RefinanceReport;

	@FindBy(id = "9881908026")
	private static WebElement OtherReports_LegalGarnishmentReport;

	@FindBy(id = "9881908035")
	private static WebElement OtherReports_ClosedInstallementLoansReport;

	@FindBy(id = "9881908050")
	private static WebElement OtherReports_TrainingDataReport;

	@FindBy(id = "609000")
	private static WebElement Reports_AccountingReports;

	@FindBy(id = "609065")
	private static WebElement AccountingReports_GLmapping;

	@FindBy(id = "988190679")
	private static WebElement AccountingReports_GLreport;

	@FindBy(id = "988190684")
	private static WebElement AccountingReports_TRECreport;

	@FindBy(id = "9881908093")
	private static WebElement AccountingReports_BankReturnReport;

	@FindBy(id = "9881908094")
	private static WebElement AccountingReports_StoreCashSummaryReport;

	@FindBy(id = "9881908095")
	private static WebElement AccountingReports_InventorySummeryReport;

	@FindBy(id = "9881908104")
	private static WebElement AccountingReports_InventoryReconReport;

	@FindBy(id = "9881908107")
	private static WebElement AccountingReports_DTJdownloadReport;

	@FindBy(id = "9881908109")
	private static WebElement AccountingReports_ACHrevokeReport;

	@FindBy(id = "9881908110")
	private static WebElement AccountingReports_PotentialDefaultReport;

	@FindBy(id = "98819081206")
	private static WebElement AccountingReports_HoldOverReport;

	@FindBy(id = "9881908114")
	private static WebElement Reports_TitleReports;

	@FindBy(id = "9881908103")
	private static WebElement TitleReports_BlackBookReport;

	@FindBy(id = "9881908120")
	private static WebElement TitleReports_TitleNewLoansReport;

	@FindBy(id = "98819081175")
	private static WebElement TitleReports_TitleOpenLoanReport;

	@FindBy(id = "98819081183")
	private static WebElement TitleReports_TitleRepoLogReport;

	@FindBy(id = "98819081184")
	private static WebElement TitleReports_TitleTrackingStatusReport;

	@FindBy(id = "98819081185")
	private static WebElement TitleReports_TitleSequentialLoanReport;

	@FindBy(id = "98819081188")
	private static WebElement TitleReports_TitleOutToRepoReport;

	@FindBy(id = "98819081190")
	private static WebElement TitleReports_TitleSecuredPastDueReport;

	@FindBy(id = "98819081205")
	private static WebElement TitleReports_TitleNewOriginationReport;

	@FindBy(id = "98819081229")
	private static WebElement TitleReports_TitleCheckRegisterReport;

	@FindBy(id = "98819081142")
	private static WebElement Reports_TimeKeepingExtracts;

	@FindBy(id = "98819081198")
	private static WebElement Reports_PCCReports;

	@FindBy(id = "98819081199")
	private static WebElement Reports_PCCReports_CardSaleAndLoadReport;


	public static class ReportsTab {
		public static void Reports() {selectMenu(new WebElement[] {Reports}); }
		public static void Reports_CollectionReports() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports}); }
		public static void Reports_CustomerReports() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports}); }
		public static void Reports_DailySummeryReports() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports}); }
		public static void Reports_LoanReports() {selectMenu(new WebElement[] {Reports,Reports_LoanReports}); }
		public static void Reports_OtherReports() {selectMenu(new WebElement[] {Reports,Reports_OtherReports}); }
		public static void Reports_AccountingReports() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports}); }
		public static void Reports_TitleReports() {selectMenu(new WebElement[] {Reports,Reports_TitleReports}); }
		public static void Reports_TimeKeepingExtracts() {selectMenu(new WebElement[] {Reports,Reports_TimeKeepingExtracts}); }
		public static void Reports_PCCReports() {selectMenu(new WebElement[] {Reports,Reports_PCCReports}); }


		public static class Collection_Report {
			public static void Reports_CollectionReports() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_PastDueReport}); }
			public static void CollectionReports_CollectionActivity() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_CollectionActivity}); }
			public static void CollectionReports_CourtestCallReport() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_CourtestCallReport}); }
			public static void CollectionReports_PromiseToPay() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_PromiseToPay}); }
			public static void CollectionReports_StoreToCentralCollectionsReport() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_StoreToCentralCollectionsReport}); }
			public static void CollectionReports_StoreCallReport() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_StoreCallReport}); }
			public static void CollectionReports_WriteOffRecoveriesReport() {selectMenu(new WebElement[] {Reports,Reports_CollectionReports,CollectionReports_WriteOffRecoveriesReport}); }

		}

		public static class CustomerReports {
			public static void CustomerReports_BankruptcyReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_BankruptcyReport}); }
			public static void CustomerReports_BankruptcyPayments() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_BankruptcyPayments}); }
			public static void CustomerReports_PendingBankruptcyReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_PendingBankruptcyReport}); }
			public static void CustomerReports_InactiveCustomer() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_InactiveCustomer}); }
			public static void CustomerReports_ActiveCustomer() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_ActiveCustomer}); }
			public static void CustomerReports_ActiveMilitary() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_ActiveMilitary}); }
			public static void CustomerReports_HitListReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_HitListReport}); }
			public static void CustomerReports_CustomerCamReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_CustomerCamReport}); }
			public static void CustomerReports_UpdatedCustomerInformationReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_UpdatedCustomerInformationReport}); }
			public static void CustomerReports_OFACResponceReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_OFACResponceReport}); }
			public static void CustomerReports_DoNotCallReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_DoNotCallReport}); }
			public static void CustomerReports_InactiveBankAccountReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_InactiveBankAccountReport}); }
			public static void CustomerReports_FormerBorrowersReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_FormerBorrowersReport}); }
			public static void CustomerReports_BSATransactionLogReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_BSATransactionLogReport}); }
			public static void CustomerReports_StatusChangeReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_StatusChangeReport}); }
			public static void CustomerReports_DeceasedCustomerReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_DeceasedCustomerReport}); }
			public static void CustomerReports_MostRecentCustomerReport() {selectMenu(new WebElement[] {Reports,Reports_CustomerReports,CustomerReports_MostRecentCustomerReport}); }
				
		}

		public static class DailySummeryReports {
			public static void DailySummeryReports_DailyTransactionJournal() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_DailyTransactionJournal}); }
			public static void DailySummeryReports_StoreCashManagement() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_StoreCashManagement}); }
			public static void DailySummeryReports_EODSummary() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_EODSummary}); }
			public static void DailySummeryReports_VoidedTransactions() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_VoidedTransactions}); }
			public static void DailySummeryReports_AccountsReceivableAgingReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_AccountsReceivableAgingReport}); }
			public static void DailySummeryReports_CashOverShort() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_CashOverShort}); }
			public static void DailySummeryReports_CashBalanceTransactionReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_CashBalanceTransactionReport}); }
			public static void DailySummeryReports_StoreCashManagementReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_StoreCashManagementReport}); }
			public static void DailySummeryReports_AllPaymentsReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_AllPaymentsReport}); }
			public static void DailySummeryReports_CashBalanceReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_CashBalanceReport}); }
			public static void DailySummeryReports_DrawerJournelReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_DrawerJournelReport}); }
			public static void DailySummeryReports_DailyPerformanceReport() {selectMenu(new WebElement[] {Reports,Reports_DailySummeryReports,DailySummeryReports_DailyPerformanceReport}); }
		}

		public static class LoanReports {
			public static void LoanReports_OutStandingPresentmentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_OutStandingPresentmentReport}); }
			public static void LoanReports_ReturnedItemsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ReturnedItemsReport}); }
			public static void LoanReports_HeldCheckSummary() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_HeldCheckSummary}); }
			public static void LoanReports_CheckRegisterReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_CheckRegisterReport}); }
			public static void LoanReports_WaiveNSF_FeeReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_WaiveNSF_FeeReport}); }
			public static void LoanReports_PWOReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_PWOReport}); }
			public static void LoanReports_WriteOffLoansReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_WriteOffLoansReport}); }
			public static void LoanReports_SoldLoanReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_SoldLoanReport}); }
			public static void LoanReports_CouponTrackingReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_CouponTrackingReport}); }
			public static void LoanReports_RefundTransactionReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_RefundTransactionReport}); }
			public static void LoanReports_ACHDetailsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ACHDetailsReport}); }
			public static void LoanReports_RepresentmentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_RepresentmentReport}); }
			public static void LoanReports_NewLoanReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_NewLoanReport}); }
			public static void LoanReports_ReturnedItemsInventoryReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ReturnedItemsInventoryReport}); }
			public static void LoanReports_CurrentLoanInventoryReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_CurrentLoanInventoryReport}); }
			public static void LoanReports_TransferPaymentsReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_TransferPaymentsReport}); }
			public static void LoanReports_PendingCheck21Report() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_PendingCheck21Report}); }
			public static void LoanReports_DefaultReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_DefaultReport}); }
			public static void LoanReports_ScheduledPaymentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ScheduledPaymentReport}); }
			public static void LoanReports_ACHandRCCPaymentReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ACHandRCCPaymentReport}); }
			public static void LoanReports_ActivePernoteReport() {selectMenu(new WebElement[] {Reports,Reports_LoanReports,LoanReports_ActivePernoteReport}); }
			
		}

		public static class OtherReports {
			public static void OtherReports_MonetaryTransferLog() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MonetaryTransferLog}); }
			public static void OtherReports_RescissionReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_RescissionReport}); }
			public static void OtherReports_PaymentPlanReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_PaymentPlanReport}); }
			public static void OtherReports_EncryptionKeyReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_EncryptionKeyReport}); }
			public static void OtherReports_MiscDisbursementsLogReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MiscDisbursementsLogReport}); }
			public static void OtherReports_MiscReciptsLog() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_MiscReciptsLog}); }
			public static void OtherReports_ActiveUsersReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_ActiveUsersReport}); }
			public static void OtherReports_CurrencyTransactionReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_CurrencyTransactionReport}); }
			public static void OtherReports_TellerProductivityReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_TellerProductivityReport}); }
			public static void OtherReports_LoansCreditBalanceReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LoansCreditBalanceReport}); }
			public static void OtherReports_DebitCardPaymentsReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_DebitCardPaymentsReport}); }
			public static void OtherReports_NOATMissingReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_NOATMissingReport}); }
			public static void OtherReports_LoanDenialReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LoanDenialReport}); }
			public static void OtherReports_LargeScaleReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LargeScaleReport}); }
			public static void OtherReports_ACHCollectionReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_ACHCollectionReport}); }
			public static void OtherReports_VeritecReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_VeritecReport}); }
			public static void OtherReports_RefinanceReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_RefinanceReport}); }
			public static void OtherReports_LegalGarnishmentReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_LegalGarnishmentReport}); }
			public static void OtherReports_ClosedInstallementLoansReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_ClosedInstallementLoansReport}); }
			public static void OtherReports_TrainingDataReport() {selectMenu(new WebElement[] {Reports,Reports_OtherReports,OtherReports_TrainingDataReport}); }

		}

		public static class AccountingReports {
			public static void AccountingReports_GLmapping() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_GLmapping}); }
			public static void AccountingReports_GLreport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_GLreport}); }	
			public static void AccountingReports_TRECreport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_TRECreport}); }
			public static void AccountingReports_BankReturnReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_BankReturnReport}); }
			public static void AccountingReports_StoreCashSummaryReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_StoreCashSummaryReport}); }
			public static void AccountingReports_InventorySummeryReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_InventorySummeryReport}); }	
			public static void AccountingReports_InventoryReconReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_InventoryReconReport}); }
			public static void AccountingReports_DTJdownloadReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_DTJdownloadReport}); }
			public static void AccountingReports_ACHrevokeReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_ACHrevokeReport}); }
			public static void AccountingReports_PotentialDefaultReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_PotentialDefaultReport}); }
			public static void AccountingReports_HoldOverReport() {selectMenu(new WebElement[] {Reports,Reports_AccountingReports,AccountingReports_HoldOverReport}); }

		}

		public static class TitleReports {
			public static void TitleReports_BlackBookReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_BlackBookReport}); }
			public static void TitleReports_TitleNewLoansReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleNewLoansReport}); }
			public static void TitleReports_TitleOpenLoanReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleOpenLoanReport}); }
			public static void TitleReports_TitleRepoLogReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleRepoLogReport}); }
			public static void TitleReports_TitleTrackingStatusReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleTrackingStatusReport}); }
			public static void TitleReports_TitleSequentialLoanReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleSequentialLoanReport}); }
			public static void TitleReports_TitleOutToRepoReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleOutToRepoReport}); }
			public static void TitleReports_TitleSecuredPastDueReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleSecuredPastDueReport}); }
			public static void TitleReports_TitleNewOriginationReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleNewOriginationReport}); }
			public static void TitleReports_TitleCheckRegisterReport() {selectMenu(new WebElement[] {Reports,Reports_TitleReports,TitleReports_TitleCheckRegisterReport}); }

		}

		public static class PCCReports {
			public static void PCCReports_CardSaleAndLoadReport() {selectMenu(new WebElement[] {Reports,Reports_PCCReports,Reports_PCCReports_CardSaleAndLoadReport}); }
			
		}

	}
}

















































































