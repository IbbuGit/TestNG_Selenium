package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
 
public class CashManagement_Safe_StoreToStoreTransfer_PO extends BasePage{

	public CashManagement_Safe_StoreToStoreTransfer_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	//------------------------------------------------------------------------------------------------------------------
	//	Module Name			:	Cash Management
	//	Method				:	safeStoreToStore
	//	Class Name			:	CashManagement_Safe_StoreToStore_PO
	//	Page Name(QFundX)	:	Store to Store Transfer
	//	Responsible			:	Lee Huntsinger
	//	Date				:	31-Jul-2018	
	//	Prerequisite		:	1) Safe MUST be assigned first
	//							2) Cash In process should be performed
	//							3) The cash in Safe should exceed amount in Drawer(s) in current store
	//							4) A Store Number MUST be known for transfer
	//							
	//	Expected results	:	Store to Store Transfer should be successful
	//------------------------------------------------------------------------------------------------------------------



	// Store to Store Transfer Header
	@FindBy(xpath="formHeading")	
	private WebElement CM_Safe_StoretoStoreTransfer_Header;
	
	// Store Nbr Field
	@FindBy(name="locToLocRequestBean.locationNbr")	
	private WebElement CM_Safe_StoreToStore_Nbr;	

	// Count of Pennies 
	@FindBy(name="locToLocRequestBean.noOfPennies")			
	private WebElement CM_StoreToStore_PennyCount;
	
	// Count of Nickels 
	@FindBy(name="locToLocRequestBean.noOfNickels")			
	private WebElement CM_StoreToStore_NickelCount;
	
	// Count of Dimes 
	@FindBy(name="locToLocRequestBean.noOfDimes")			
	private WebElement CM_StoreToStore_DimeCount;
	
	// Count of Quarters
	@FindBy(name="locToLocRequestBean.noOfQuarters")			
	private WebElement CM_StoreToStore_QuarterCount;

	// Count of Half Dollars
	@FindBy(name="locToLocRequestBean.noOfHalfDollars")		
	private WebElement CM_StoreToStore_HalfDollarCount;
	
	// Count of Dollar Coins
	@FindBy(name="locToLocRequestBean.noOfDollars")			
	private WebElement CM_StoreToStore_DollarCoinCount;
	
	// Count of $1 Bills
	@FindBy(name="locToLocRequestBean.noOfOneDollars")		
	private WebElement CM_StoreToStore_DollarBillCount;
	
	// Count of $5 Bills
	@FindBy(name="locToLocRequestBean.noOf5Dollars")			
	private WebElement CM_StoreToStore_5DollarBillCount;
	
	// Count of $10 Bills
	@FindBy(name="locToLocRequestBean.noOf10Dollars")		
	private WebElement CM_StoreToStore_10DollarBillCount;
	
	// Count of $20 Bills
	@FindBy(name="locToLocRequestBean.noOf20Dollars")		
	private WebElement CM_StoreToStore_20DollarBillCount;
	
	// Count of $50 Bills
	@FindBy(name="locToLocRequestBean.noOf50Dollars")		
	private WebElement CM_StoreToStore_50DollarBillCount;
	
	// Count of $100 Bills
	@FindBy(name="locToLocRequestBean.noOf100Dollars")		
	private WebElement CM_StoreToStore_100DollarBillCount;
	
	// Cash Field
	@FindBy(name="locToLocRequestBean.cashAmt")
	private WebElement CM_StoreToStore_Cash;
	
	// User ID
	@FindBy(name="username")		
	private WebElement CM_StoreToStore_UserID;

	// User PIN#
	@FindBy(name="locToLocRequestBean.empPwd")		
	private WebElement CM_StoreToStore_UserPIN;
	
	// Banker ID
	@FindBy(name="locToLocRequestBean.userId")		
	private WebElement CM_StoreToStore_BankerID;

	// User PIN#
	@FindBy(name="locToLocRequestBean.password")		
	private WebElement CM_StoreToStore_BankerPIN;


	// Finish Store to Store Transfer Button
	@FindBy(name="loctoloc")							
	private WebElement CM_FinishStoreToStoreTransfer_Btn;
	
	// Store to Store transfer completed successfully OK button
	@FindBy(xpath="//input[@value='Ok']")				
	private WebElement CM_StoreToStoreTransfer_SuccessfulOKBtn;

	
	// Check for Store Nbr Field on Store to Store Transfer Page
    public boolean checkVisibiltyOfStoreNbr(){
    	return CM_Safe_StoreToStore_Nbr.isDisplayed();
    }
    
	
	public void set_CM_Safe_StoretoStoreTransfer_Header(String cM_Safe_StoretoStoreTransfer_Header) {
		doIT(CM_Safe_StoretoStoreTransfer_Header, cM_Safe_StoretoStoreTransfer_Header);
	}
	
	public void set_CM_Safe_StoreToStore_Nbr(String cM_Safe_StoreToStore_Nbr) {
		doIT(CM_Safe_StoreToStore_Nbr, cM_Safe_StoreToStore_Nbr);
	}


	public void set_CM_StoreToStore_PennyCount(String cM_StoreToStore_PennyCount) {
		doIT(CM_StoreToStore_PennyCount, cM_StoreToStore_PennyCount);
	}

	public void set_CM_StoreToStore_NickelCount(String cM_StoreToStore_NickelCount) {
		doIT(CM_StoreToStore_NickelCount, cM_StoreToStore_NickelCount);
	}

	public void set_CM_StoreToStore_DimeCount(String cM_StoreToStore_DimeCount) {
		doIT(CM_StoreToStore_DimeCount, cM_StoreToStore_DimeCount);
	}

	public void set_CM_StoreToStore_QuarterCount(String cM_StoreToStore_QuarterCount) {
		doIT(CM_StoreToStore_QuarterCount, cM_StoreToStore_QuarterCount);
	}

	public void set_CM_StoreToStore_HalfDollarCount(String cM_StoreToStore_HalfDollarCount) {
		doIT(CM_StoreToStore_HalfDollarCount, cM_StoreToStore_HalfDollarCount);
	}

	public void set_CM_StoreToStore_DollarCoinCount(String cM_StoreToStore_DollarCoinCount) {
		doIT(CM_StoreToStore_DollarCoinCount, cM_StoreToStore_DollarCoinCount);
	}

	public void set_CM_StoreToStore_DollarBillCount(String cM_StoreToStore_DollarBillCount) {
		doIT(CM_StoreToStore_DollarBillCount, cM_StoreToStore_DollarBillCount);
	}

	public void set_CM_StoreToStore_5DollarBillCount(String cM_StoreToStore_5DollarBillCount) {
		doIT(CM_StoreToStore_5DollarBillCount, cM_StoreToStore_5DollarBillCount);
	}

	public void set_CM_StoreToStore_10DollarBillCount(String cM_StoreToStore_10DollarBillCount) {
		doIT(CM_StoreToStore_10DollarBillCount, cM_StoreToStore_10DollarBillCount);
	}

	public void set_CM_StoreToStore_20DollarBillCount(String cM_StoreToStore_20DollarBillCount) {
		doIT(CM_StoreToStore_20DollarBillCount, cM_StoreToStore_20DollarBillCount);
	}

	public void set_CM_StoreToStore_50DollarBillCount(String cM_StoreToStore_50DollarBillCount) {
		doIT(CM_StoreToStore_50DollarBillCount, cM_StoreToStore_50DollarBillCount);
	}

	public void set_CM_StoreToStore_100DollarBillCount(String cM_StoreToStore_100DollarBillCount) {
		doIT(CM_StoreToStore_100DollarBillCount, cM_StoreToStore_100DollarBillCount);
	}


	// Enter User ID
	public void set_CM_StoreToStore_UserID(String cM_StoreToStore_UserID) {
		doIT(CM_StoreToStore_UserID, cM_StoreToStore_UserID);
	}

	// Enter User ID PIN#
	public void set_CM_StoreToStore_UserPIN(String cM_StoreToStore_UserPIN) {
		doIT(CM_StoreToStore_UserPIN, cM_StoreToStore_UserPIN);
	}
	
	// Enter Banker ID
	public void set_CM_StoreToStore_BankerID(String cM_StoreToStore_BankerID) {
		doIT(CM_StoreToStore_BankerID, cM_StoreToStore_BankerID);
	}

	//Enter Banker PIN#
	public void set_CM_StoreToStore_BankerPIN(String cM_StoreToStore_BankerPIN) {
		doIT(CM_StoreToStore_BankerPIN, cM_StoreToStore_BankerPIN);
	}


	// Click Finish Store to Store Transfer Button
	public void click_FinishStoreToStoreTransferBtn(String data) {
		doIT(CM_FinishStoreToStoreTransfer_Btn,data);
	}
	
	// Click Store to Store Transfer Completed Successfully OK Button
	public void click_StoreToStoreSuccessfulOKBtn(String data) {
		doIT(CM_StoreToStoreTransfer_SuccessfulOKBtn,data);
	}


	
}