package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

 


public class CashManagement_Drawer_Balance_DrawerBalance_PO extends BasePage{

		public CashManagement_Drawer_Balance_DrawerBalance_PO(WebDriver _driver, ExtentTest report) {
			super(_driver, report);

	}	
	
		
	//------------------------------------------------------------------------------------------------------------------
	//	Module Name			:	Cash Management
	//	Method				:	drawerBalance
	//	Class Name			:	CashManagement_Drawer_Balance_DrawerBalance_PO
	//	Page Name(QFundX)	:	Drawer Balance
	//	Responsible			:	Lee Huntsinger
	//	Date				:	14-Jun-2018	
	//	Prerequisite		:	1) Safe MUST be assigned first
	//							2) Cash In process should be performed
	//							3) The cash in Safe should exceed amount in Drawer(s) in current store
	//							4) Drawer must be assigned
	//	Expected results	:	Drawer should be Balanced successfully
	//------------------------------------------------------------------------------------------------------------------
	
	
	// Drawer Balance Header
	@FindBy(xpath="formHeading")	public WebElement CM_BalanceDrawer_Header;
	
	
	// Store Nbr
	@FindBy(xpath="rightheading")	public WebElement CM_Balance_StoreNbr;	
	
	// Drawer Nbr
	@FindBy(xpath="rightheading")	public WebElement CM_Balance_DrawerNbr;

	// Opening Balance
	@FindBy(xpath="rightheading")	public WebElement CM_Balance_OpeningBal;
	
		
	

	// Count of Pennies
	@FindBy(name="drawerBalanceRequestBean.noOfPennies")		
	private WebElement CM_Balance_PennyCount;
	
	// Count of Nickels 
	@FindBy(name="drawerBalanceRequestBean.noOfNickels")		
	private WebElement CM_Balance_NickelCount;
	
	// Count of Dimes
	@FindBy(name="drawerBalanceRequestBean.noOfDimes")			
	private WebElement CM_Balance_DimeCount;
	
	// Count of Quarters
	@FindBy(name="drawerBalanceRequestBean.noOfQuarters")		
	private WebElement CM_Balance_QuarterCount;
	
	// Count of Half Dollar Coins
	@FindBy(name="drawerBalanceRequestBean.noOfHalfDollars")	
	private WebElement CM_Balance_HalfDollarCount;
	
	// Count of Dollar Coins
	@FindBy(name="drawerBalanceRequestBean.noOfDollars")		
	private WebElement CM_Balance_DollarCoinCount;
	
	// Count of $1
	@FindBy(name="drawerBalanceRequestBean.noOfOneDollars")		
	private WebElement CM_Balance_DollarBillCount;
	
	// Count of $5
	@FindBy(name="drawerBalanceRequestBean.noOf5Dollars")		
	private WebElement CM_Balance_5DollarBillCount;
	
	// Count of $10
	@FindBy(name="drawerBalanceRequestBean.noOf10Dollars")		
	private WebElement CM_Balance_10DollarBillCount;
	
	// Count of $20
	@FindBy(name="drawerBalanceRequestBean.noOf20Dollars")		
	private WebElement CM_Balance_20DollarBillCount;
	
	// Count of $50
	@FindBy(name="drawerBalanceRequestBean.noOf50Dollars")		
	private WebElement CM_Balance_50DollarBillCount;
	
	// Count of $100
	@FindBy(name="drawerBalanceRequestBean.noOf100Dollars")		
	private WebElement CM_Balance_100DollarBillCount;
	
	// Cash Balance
	@FindBy(name="drawerBalanceRequestBean.cashAmount")			
	private WebElement CM_Balance_CashBalance;
	
	// CC/MO Balance
	@FindBy(name="drawerBalanceRequestBean.ccmoAmount")			
	private WebElement CM_Balance_CCMOBalance;
	
	// Check Balance
	@FindBy(name="drawerBalanceRequestBean.checkBal")			
	private WebElement CM_Balance_CheckBalance;
	
	
	
	
	// User Id
	@FindBy(name="username")							
	private WebElement CM_Balance_UserID;
	
	// PIN#
	@FindBy(name="drawerBalanceRequestBean.empPwd")		
	private WebElement CM_Balance_UserPIN;
	
	// Finish Drawer Balance Button
	@FindBy(name="drawerbalance")						
	private WebElement CM_Balance_FinishDrawerBalBtn;
	
	// Drawer Balance completed successfully OK button
	@FindBy(name="done")								
	private WebElement CM_Balance_SuccessfulBalOKBtn;
	
	// Invalid password message
	@FindBy(xpath="//ul[text()='The password entered is not valid. Please re-enter']") 
	private WebElement drawerInvalidPwdError;

	

	// Check for User ID Field on Drawer Balance Page
    public boolean checkVisibiltyOfUserID(){
    	return CM_Balance_UserID.isDisplayed();
    }
    
	// Check for Drawer Balance Successful message
    public boolean checkVisibiltyOfSuccessfulOKBtn(){
    	return CM_Balance_SuccessfulBalOKBtn.isDisplayed();
    }

	
	
		
	// Set Number of Pennies from data sheet
	public String get_CM_Balance_PennyCount(String data) {
		return doIT(CM_Balance_PennyCount, data);
	}
			
	public void set_CM_Balance_PennyCount(String cM_Balance_PennyCount) {
		doIT(CM_Balance_PennyCount, cM_Balance_PennyCount);
	}
	
	// Set Number of Nickels from data sheet
	public String get_CM_Balance_NickelCount(String data) {
		return doIT(CM_Balance_NickelCount, data);
	}
			
	public void set_CM_Balance_NickelCount(String cM_Balance_NickelCount) {
		doIT(CM_Balance_NickelCount, cM_Balance_NickelCount);
	}
	
	// Set Number of Dimes from data sheet
	public String get_CM_Balance_DimeCount(String data) {
		return doIT(CM_Balance_DimeCount, data);
	}
			
	public void set_CM_Balance_DimeCount(String cM_Balance_DimeCount) {
		doIT(CM_Balance_DimeCount, cM_Balance_DimeCount);
	}
	
	//Set Number of Quarters from data sheet
	public String get_CM_Balance_QuarterCount(String data) {
		return doIT(CM_Balance_QuarterCount, data);
	}
			
	public void set_CM_Balance_QuarterCount(String cM_Balance_QuarterCount) {
		doIT(CM_Balance_QuarterCount, cM_Balance_QuarterCount);
	}
	
	// Set Number of Half Dollars from data sheet
	public String get_CM_Balance_HalfDollarCount(String data) {
		return doIT(CM_Balance_HalfDollarCount, data);
	}
		
	public void set_CM_Balance_HalfDollarCount(String cM_Balance_HalfDollarCount) {
		doIT(CM_Balance_HalfDollarCount, cM_Balance_HalfDollarCount);
	}
	
	// Set Number of Dollar Coins from data sheet
	public String get_CM_Balance_DollarCoinCount(String data) {
		return doIT(CM_Balance_DollarCoinCount, data);
	}
		
	public void set_CM_Balance_DollarCoinCount(String cM_Balance_DollarCoinCount) {
		doIT(CM_Balance_DollarCoinCount, cM_Balance_DollarCoinCount);
	}
	
	// Set Number of $1 Bills from data sheet
	public String get_CM_Balance_DollarBillCount(String data) {
		return doIT(CM_Balance_DollarBillCount, data);
	}
		
	public void set_CM_Balance_DollarBillCount(String cM_Balance_DollarBillCount) {
		doIT(CM_Balance_DollarBillCount, cM_Balance_DollarBillCount);
	}

	// Set Number of $5 Bills from data sheet
	public String get_CM_Balance_5DollarBillCount(String data) {
		return doIT(CM_Balance_5DollarBillCount, data);
	}
		
	public void set_CM_Balance_5DollarBillCount(String cM_Balance_5DollarBillCount) {
		doIT(CM_Balance_5DollarBillCount, cM_Balance_5DollarBillCount);
	}
	
	// Set Number of $10 Bills from data sheet
	public String get_CM_Balance_10DollarBillCount(String data) {
		return doIT(CM_Balance_10DollarBillCount, data);
	}
		
	public void set_CM_Balance_10DollarBillCount(String cM_Balance_10DollarBillCount) {
		doIT(CM_Balance_10DollarBillCount, cM_Balance_10DollarBillCount);
	}
	
	// Set Number of $20 Bills from data sheet
	public String get_CM_Balance_20DollarBillCount(String data) {
		return doIT(CM_Balance_20DollarBillCount, data);
	}
		
	public void set_CM_Balance_20DollarBillCount(String cM_Balance_20DollarBillCount) {
		doIT(CM_Balance_20DollarBillCount, cM_Balance_20DollarBillCount);
	}
	
	// Set Number of $50 Bills from data sheet
	public String get_CM_Balance_50DollarBillCount(String data) {
		return doIT(CM_Balance_50DollarBillCount, data);
	}
		
	public void set_CM_Balance_50DollarBillCount(String cM_Balance_50DollarBillCount) {
		doIT(CM_Balance_50DollarBillCount, cM_Balance_50DollarBillCount);
	}
	
	// Set Number of $100 Bills from data sheet
	public String get_CM_Balance_100DollarBillCount(String data) {
		return doIT(CM_Balance_100DollarBillCount, data);
	}
	
	public void set_CM_Balance_100DollarBillCount(String cM_Balance_100DollarBillCount) {
		doIT(CM_Balance_100DollarBillCount, cM_Balance_100DollarBillCount);
	}
	
	// Set CC/MO Balance from data sheet
	public String get_CM_Balance_CCMOBalance(String data) {
		return doIT(CM_Balance_CCMOBalance, data);
	}
	
	public void set_CM_Balance_CCMOBalance(String cM_Balance_CCMOBalance) {
		doIT(CM_Balance_CCMOBalance, cM_Balance_CCMOBalance);
	}
	
	// Set Check Balance from data sheet
	public String get_CM_Balance_CheckBalance(String data) {
		return doIT(CM_Balance_CheckBalance, data);
	}
	
	public void set_CM_Balance_CheckBalance(String cM_Balance_CheckBalance) {
		doIT(CM_Balance_CheckBalance, cM_Balance_CheckBalance);
	}

	// Set PIN#
	public String get_CM_Balance_UserPIN(String data) {
		return doIT(CM_Balance_UserPIN, data);
	}
	
	public void set_CM_Balance_UserPIN(String cM_Balance_UserPIN) {
		doIT(CM_Balance_UserPIN, cM_Balance_UserPIN);
	}
	
	public String get_drawerInvalidPwdMsg(String TestData_drawerInvalidPwdError) {
		return doIT(drawerInvalidPwdError, TestData_drawerInvalidPwdError);
	}


	// Click Finish Drawer Balance Button
	public void click_CM_Balance_FinishDrawerBalBtn(String data) {
		doIT(CM_Balance_FinishDrawerBalBtn,data);
	}
	
	// Click Drawer Balance completed successfully OK Button
	public void click_CM_Balance_SuccessfulBalOKBtn(String data) {
		doIT(CM_Balance_SuccessfulBalOKBtn,data);
	}
	
	// Acknowledge the Counted Balance Does Not Match Calculated Balance dialog box
	public void click_CM_Drawer_CountedBal_NotEqual_CalcBal_OK_Btn(String data) {
		Alert countedBalNotEqualClacBalmsg =driver.switchTo().alert();
		String strcountedBalNotEqualClacBalmsg = countedBalNotEqualClacBalmsg.getText();
		System.out.println(strcountedBalNotEqualClacBalmsg);
		countedBalNotEqualClacBalmsg.accept();
	}
	
	// Acknowledge the Counted Cash Balance Short dialog box
	public void click_CM_Drawer_CountedBal_Short_OK_Btn(String data) {
		Alert countedBalShortmsg =driver.switchTo().alert();
		String strcountedBalShortmsg = countedBalShortmsg.getText();
		System.out.println(strcountedBalShortmsg);
		countedBalShortmsg.accept();
	}


	

}
