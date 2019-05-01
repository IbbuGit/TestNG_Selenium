package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_Deposit_SafeDepositVoid_PO extends BasePage{ 

	public CashManagement_Safe_Deposit_SafeDepositVoid_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		
	}
	
	//------------------------------------------------------------------------------------------------------------------
	//	Module Name			:	Cash Management
	//	Method				:	safeDepositVoid
	//	Class Name			:	CashManagement_Safe_Deposit_SafeDepositVoid_PO
	//	Page Name(QFundX)	:	Safe Deposit
	//	Responsible			:	Lee Huntsinger
	//	Date				:	10-Sep-2018	
	//	Prerequisite		:	1) Safe MUST be assigned first
	//							2) Cash In process should be performed
	//							3) The cash in Safe should exceed amount in Drawer(s) in current store
	//							4) Safe Deposit should be performed first
	//							
	//	Expected results	:	Safe Deposit Void should be successful
	//------------------------------------------------------------------------------------------------------------------
	

	// Safe Deposit Header
	@FindBy(xpath="formHeading")	public WebElement CM_SafeDeposit_Header;
	
	
	// Deposit Bank
	@FindBy(name="safeDepositRequestBean.abaCode")	public WebElement CM_DepositVoid_Bank;	
	
	

	// Count of Pennies
	@FindBy(name="safeDepositRequestBean.noOfPennies")			
	private WebElement CM_Safe_DepositVoid_PennyCount;
	
	// Count of Nickels 
	@FindBy(name="safeDepositRequestBean.noOfNickels")			
	private WebElement CM_Safe_DepositVoid_NickelCount;
	
	// Count of Dimes
	@FindBy(name="safeDepositRequestBean.noOfDimes")			
	private WebElement CM_Safe_DepositVoid_DimeCount;
	
	// Count of Quarters
	@FindBy(name="safeDepositRequestBean.noOfQuarters")			
	private WebElement CM_Safe_DepositVoid_QuarterCount;
		
	// Count of Half Dollar Coins
	@FindBy(name="safeDepositRequestBean.noOfHalfDollars")		
	private WebElement CM_Safe_DepositVoid_HalfDollarCount;
	
	// Count of Dollar Coins
	@FindBy(name="safeDepositRequestBean.noOfDollars")			
	private WebElement CM_Safe_DepositVoid_DollarCoinCount;
	
	// Count of $1
	@FindBy(name="safeDepositRequestBean.noOfOneDollars")		
	private WebElement CM_Safe_DepositVoid_DollarBillCount;
	
	// Count of $5
	@FindBy(name="safeDepositRequestBean.noOf5Dollars")			
	private WebElement CM_Safe_DepositVoid_5DollarBillCount;
	
	// Count of $10
	@FindBy(name="safeDepositRequestBean.noOf10Dollars")		
	private WebElement CM_Safe_DepositVoid_10DollarBillCount;
	
	// Count of $20
	@FindBy(name="safeDepositRequestBean.noOf20Dollars")		
	private WebElement CM_Safe_DepositVoid_20DollarBillCount;
	
	// Count of $50
	@FindBy(name="safeDepositRequestBean.noOf50Dollars")		
	private WebElement CM_Safe_DepositVoid_50DollarBillCount;
	
	// Count of $100
	@FindBy(name="safeDepositRequestBean.noOf100Dollars")		
	private WebElement CM_Safe_DepositVoid_100DollarBillCount;
	
	// Cash
	@FindBy(name="safeDepositRequestBean.cashInAmount")			
	private WebElement CM_Safe_DepositVoid_CashAmt;
	
	// Bag Nbr
	@FindBy(name="safeDepositRequestBean.bagNbr")				
	private WebElement CM_Safe_DepositVoid_BagNbr;
	
	// User Id
	@FindBy(name="username")
	private WebElement CM_Safe_DepositVoid_UserID;
	
	// User PIN#
	@FindBy(name="safeDepositRequestBean.empPwd")
	private WebElement CM_Safe_DepositVoid_UserPIN;
		
	// Banker Id
	@FindBy(name="safeDepositRequestBean.userId")		
	private WebElement CM_Safe_DepositVoid_BankerID;
	
	// Banker PIN#
	@FindBy(name="safeDepositRequestBean.password")		
	private WebElement CM_Safe_DepositVoid_BankerPIN;
	
	// History Button
	@FindBy(xpath="//input[@value='History' and @onclick='voi()']")
	private WebElement CM_Safe_DepositVoid_HistoryBtn;
	
	// Finish Void Deposit Button
	@FindBy(xpath="//input[@name='voiddeposit']")						
	private WebElement CM_Safe_DepositVoid_FinishVoidDepositBtn;
	
	// Finish Deposit Verify Button
	@FindBy(name="finishdeposit")						
	private WebElement CM_Safe_DepositVoid_DepositVerifyBtn;
	
	// Void Deposit Completed Successfully OK Button
	@FindBy(xpath="//input[@value='Ok']")				
	private WebElement CM_Safe_DepositVoid_DepositCompOKBtn;
	
	// Void Deposit Radio Button
	@FindBy(name="depvoid")				
	private WebElement CM_Safe_DepositVoid_DepositRadioBtn;

	
	
	// Check for Deposit Bank on Safe Deposit Page
	  public boolean checkVisibiltyOfHistoryBtn() {
	    return isDisplayed(CM_Safe_DepositVoid_HistoryBtn);
	  }
	  
	// Check for Finish Void Button on Void Deposit page
	  public boolean checkVisibilityofFinishVoidBtn() {
		return isDisplayed(CM_Safe_DepositVoid_FinishVoidDepositBtn);
	  }
	  
	// Check for OK Button for Void Deposit completed successfully
	  public boolean checkVisibilityofVoidSuccessfulOKBtn() {
		  wait.until(ExpectedConditions.elementToBeClickable(CM_Safe_DepositVoid_DepositCompOKBtn));
		return isDisplayed(CM_Safe_DepositVoid_DepositCompOKBtn);
	  }	
  

	
	
	// Set Number of Pennies from data sheet
	public String get_CM_Safe_DepositVoid_PennyCount(String data) {
		return doIT(CM_Safe_DepositVoid_PennyCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_PennyCount(String cM_Safe_DepositVoid_PennyCount) {
		doIT(CM_Safe_DepositVoid_PennyCount, cM_Safe_DepositVoid_PennyCount);
	}
	
	// Set Number of Nickels from data sheet
	public String get_CM_Safe_DepositVoid_NickelCount(String data) {
		return doIT(CM_Safe_DepositVoid_NickelCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_NickelCount(String cM_Safe_DepositVoid_NickelCount) {
		doIT(CM_Safe_DepositVoid_NickelCount, cM_Safe_DepositVoid_NickelCount);
	}
	
	// Set Number of Dimes from data sheet
	public String get_CM_Safe_DepositVoid_DimeCount(String data) {
		return doIT(CM_Safe_DepositVoid_DimeCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_DimeCount(String cM_Safe_DepositVoid_DimeCount) {
		doIT(CM_Safe_DepositVoid_DimeCount, cM_Safe_DepositVoid_DimeCount);
	}
	
	//Set Number of Quarters from data sheet
	public String get_CM_Safe_DepositVoid_QuarterCount(String data) {
		return doIT(CM_Safe_DepositVoid_QuarterCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_QuarterCount(String cM_Safe_DepositVoid_QuarterCount) {
		doIT(CM_Safe_DepositVoid_QuarterCount, cM_Safe_DepositVoid_QuarterCount);
	}
	
	// Set Number of Half Dollars from data sheet
	public String get_CM_Safe_DepositVoid_HalfDollarCount(String data) {
		return doIT(CM_Safe_DepositVoid_HalfDollarCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_HalfDollarCount(String cM_Safe_DepositVoid_HalfDollarCount) {
		doIT(CM_Safe_DepositVoid_HalfDollarCount, cM_Safe_DepositVoid_HalfDollarCount);
	}
	
	// Set Number of Dollar Coins from data sheet
	public String get_CM_Safe_DepositVoid_DollarCoinCount(String data) {
		return doIT(CM_Safe_DepositVoid_DollarCoinCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_DollarCoinCount(String cM_Safe_DepositVoid_DollarCoinCount) {
		doIT(CM_Safe_DepositVoid_DollarCoinCount, cM_Safe_DepositVoid_DollarCoinCount);
	}
	
	// Set Number of $1 Bills from data sheet
	public String get_CM_Safe_DepositVoid_DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_DollarBillCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_DollarBillCount(String cM_Safe_DepositVoid_DollarBillCount) {
		doIT(CM_Safe_DepositVoid_DollarBillCount, cM_Safe_DepositVoid_DollarBillCount);
	}
	
	// Set Number of $5 Bills from data sheet
	public String get_CM_Safe_DepositVoid_5DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_5DollarBillCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_5DollarBillCount(String cM_Safe_DepositVoid_5DollarBillCount) {
		doIT(CM_Safe_DepositVoid_5DollarBillCount, cM_Safe_DepositVoid_5DollarBillCount);
	}
	
	// Set Number of $10 Bills from data sheet
	public String get_CM_Safe_DepositVoid_10DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_10DollarBillCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_10DollarBillCount(String cM_Safe_DepositVoid_10DollarBillCount) {
		doIT(CM_Safe_DepositVoid_10DollarBillCount, cM_Safe_DepositVoid_10DollarBillCount);
	}
	
	// Set Number of $20 Bills from data sheet
	public String get_CM_Safe_DepositVoid_20DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_20DollarBillCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_20DollarBillCount(String cM_Safe_DepositVoid_20DollarBillCount) {
		doIT(CM_Safe_DepositVoid_20DollarBillCount, cM_Safe_DepositVoid_20DollarBillCount);
	}
	
	// Set Number of $50 Bills from data sheet
	public String get_CM_Safe_DepositVoid_50DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_50DollarBillCount, data);
	}
		
	public void set_CM_Safe_DepositVoid_50DollarBillCount(String cM_Safe_DepositVoid_50DollarBillCount) {
		doIT(CM_Safe_DepositVoid_50DollarBillCount, cM_Safe_DepositVoid_50DollarBillCount);
	}
	
	// Set Number of $100 Bills from data sheet
	public String get_CM_Safe_DepositVoid_100DollarBillCount(String data) {
		return doIT(CM_Safe_DepositVoid_100DollarBillCount, data);
	}
	
	public void set_CM_Safe_DepositVoid_100DollarBillCount(String cM_Safe_DepositVoid_100DollarBillCount) {
		doIT(CM_Safe_DepositVoid_100DollarBillCount, cM_Safe_DepositVoid_100DollarBillCount);
	}
	
	// Set Cash
	public String get_CM_Safe_DepositVoid_CashAmt(String data) {
		return doIT(CM_Safe_DepositVoid_CashAmt, data);
	}
	
	public void set_CM_Safe_DepositVoid_CashAmt(String cM_Safe_DepositVoid_CashAmt) {
		doIT(CM_Safe_DepositVoid_CashAmt, cM_Safe_DepositVoid_CashAmt);
	}
	
	// Set Bag Nbr
	public String get_CM_Safe_DepositVoid_BagNbr(String data) {
		return doIT(CM_Safe_DepositVoid_BagNbr, data);
	}
	
	public void set_CM_Safe_DepositVoid_BagNbr(String cM_Safe_DepositVoid_BagNbr) {
		doIT(CM_Safe_DepositVoid_BagNbr, cM_Safe_DepositVoid_BagNbr);
	}
	
	// Set User PIN#
	public String get_CM_Safe_DepositVoid_UserPIN(String data) {
		return doIT(CM_Safe_DepositVoid_UserPIN, data);
	}
	
	public void set_CM_Safe_DepositVoid_UserPIN(String cM_Safe_DepositVoid_UserPIN) {
		doIT(CM_Safe_DepositVoid_UserPIN, cM_Safe_DepositVoid_UserPIN);
	}
	
	// Set Banker PIN#
	public String get_CM_Safe_DepositVoid_BankerPIN(String data) {
		return doIT(CM_Safe_DepositVoid_BankerPIN, data);
	}
	
	public void set_CM_Safe_DepositVoid_BankerPIN(String cM_Safe_DepositVoid_BankerPIN) {
		doIT(CM_Safe_DepositVoid_BankerPIN, cM_Safe_DepositVoid_BankerPIN);
	}

	// Click History Button
	public void click_CM_Safe_DepositVoid_HistoryBtn(String data) {
		doIT(CM_Safe_DepositVoid_HistoryBtn,data);
	}

	
	// Click Finish Deposit Button
	public void click_CM_Safe_DepositVoid_FinishDepositBtn(String data) {
		doIT(CM_Safe_DepositVoid_FinishVoidDepositBtn,data);
	}
	
	// Click Finish Deposit Verify Button
	public void click_CM_Safe_DepositVoid_DepositVerifyBtn(String data) {
		doIT(CM_Safe_DepositVoid_DepositVerifyBtn,data);
	}

	// Click Deposit Completed Successfully OK Button
	public void click_CM_Safe_DepositVoid_DepositCompOKBtn(String data) {
		doIT(CM_Safe_DepositVoid_DepositCompOKBtn,data);
	}
	
    // Get Transfer Transaction for Void
    private String transCode="//td[text()='DYNAMIC_TEXT']/preceding-sibling::td";
    public String get_transferVoidTransaction(String storeID){
    	return doIT(getWebElementForDynamicText(transCode,storeID),"y").trim();
	}


    private String test="(//input[@name='depvoid' and contains(@value,'DYNAMIC_TEXT') and not(@disabled)])[1]";
    public void click_VoidTransactionRadioBtn(String amnt) {
           doIT(getWebElementForDynamicText(test,amnt),amnt);
    }

		
	
}
