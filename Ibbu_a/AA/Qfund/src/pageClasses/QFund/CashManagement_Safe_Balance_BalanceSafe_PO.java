package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

//------------------------------------------------------------------------------------------------------------------
//	Module Name			:	Cash Management
//	Method				:	safeBalance
//	Class Name			:	CashManagement_Safe_Balance_SafeBalance_PO
//	Page Name(QFundX)	:	Safe Balance
//	Responsible			:	Lee Huntsinger
//	Date				:	26-Jun-2018	
//	Prerequisite		:	1) Safe MUST be assigned first
//							2) Cash In process should be performed
//							3) The cash in Safe should exceed amount in Drawer(s) in current store
//							
//	Expected results	:	Safe should be Balanced successfully
//------------------------------------------------------------------------------------------------------------------

public class CashManagement_Safe_Balance_BalanceSafe_PO extends BasePage {

 
	/*
	 * Constructor
	 */

	public CashManagement_Safe_Balance_BalanceSafe_PO (WebDriver _driver, ExtentTest report) {
		super(_driver, report);			
	}

	/*
	 * Page Elements
	 */


	@FindBy(xpath="//td[contains(text(),'Safe Balance')]") 
	private WebElement sb_PageHeader;

	@FindBy(name="safeBalanceRequestBean.noOfPennies")				
	private WebElement sb_CountOfPennies;
	
	@FindBy(name="safeBalanceRequestBean.noOfNickels")				
	private WebElement sb_CountOfNickels;
	
	@FindBy(name="safeBalanceRequestBean.noOfDimes")					
	private WebElement sb_CountOfDimes;
	
	@FindBy(name="safeBalanceRequestBean.noOfQuarters")				
	private WebElement sb_CountOfQuarters;
	
	@FindBy(name="safeBalanceRequestBean.noOfHalfDollars")			
	private WebElement sb_CountOfHalfDollarCoins;
	
	@FindBy(name="safeBalanceRequestBean.noOfDollars")				
	private WebElement sb_CountOfDollarCoins;
	
	@FindBy(name="safeBalanceRequestBean.noOfOneDollars")				
	private WebElement sb_CountOf1Dollar;
	
	@FindBy(name="safeBalanceRequestBean.noOf5Dollars")				
	private WebElement sb_CountOf5Dollar;
	
	@FindBy(name="safeBalanceRequestBean.noOf10Dollars")				
	private WebElement sb_CountOf10Dollar;
	
	@FindBy(name="safeBalanceRequestBean.noOf20Dollars")				
	private WebElement sb_CountOf20Dollar;
	
	@FindBy(name="safeBalanceRequestBean.noOf50Dollars")				
	private WebElement sb_CountOf50Dollar;
	
	@FindBy(name="safeBalanceRequestBean.noOf100Dollars")				
	private WebElement sb_CountOf100Dollar;
	
	@FindBy(name="safeBalanceRequestBean.openBal")					
	private WebElement sb_Cash;

	@FindBy(name="safeBalanceRequestBean.checkBal")				
	private WebElement sb_CheckBalance;
	
	@FindBy(name="safeBalanceRequestBean.ccmoAmount")			
	private WebElement sb_CCMOBalance;

	@FindBy(name="username")											
	private WebElement sb_UserID;
	
	@FindBy(name="safeBalanceRequestBean.empPwd")						
	private WebElement sb_UserPIN;
	
	@FindBy(name="safeBalanceRequestBean.userId")						
	private WebElement sb_BankerID;
	
	@FindBy(name="safeBalanceRequestBean.password")					
	private WebElement sb_BankerPIN;
	
	//@FindBy(xpath="//input[@value='Finish Balance Safe']") 
	@FindBy(name="safebalance")						
	private WebElement sb_FinishBanlanceSafeButton;
	
	@FindBy(xpath="//*[contains(text(),'Safe balance completed successfully.')]")
	private WebElement sb_Validation;
	
	@FindBy(xpath="//ul[text()='The Banker Password entered is not valid. Please re-enter']") 
	private WebElement sb_BankerPINInvalid;

	@FindBy(xpath="//input[@value='Ok']") 
	private WebElement sb_Success_OKButton;

	@FindBy(xpath=".//input[@value='Cancel')]")						
	private WebElement sb_CancelButton;
	
	@FindBy(xpath=".//input[@value='History')]")						
	private WebElement sb_HistoryButton;



	/*
	 * Page Elements Methods
	 */
	public String get_sb_PageHeader(String TestData_sb_PageHeader) {
		return doIT(sb_PageHeader, TestData_sb_PageHeader);
	}

	public boolean isDisplayed_sb_PageHeader() {
		return isDisplayed(sb_PageHeader);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfPennies(String TestData_sb_CountOfPennies) {
		doIT(sb_CountOfPennies, TestData_sb_CountOfPennies);
	}

	public boolean isDisplayed_sb_CountOfPennies() {
		return isDisplayed(sb_CountOfPennies);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfNickels(String TestData_sb_CountOfNickels) {
		doIT(sb_CountOfNickels, TestData_sb_CountOfNickels);
	}

	public boolean isDisplayed_sb_CountOfNickels() {
		return isDisplayed(sb_CountOfNickels);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfDimes(String TestData_sb_CountOfDimes) {
		doIT(sb_CountOfDimes, TestData_sb_CountOfDimes);
	}

	public boolean isDisplayed_sb_CountOfDimes() {
		return isDisplayed(sb_CountOfDimes);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfQuarters(String TestData_sb_CountOfQuarters) {
		doIT(sb_CountOfQuarters, TestData_sb_CountOfQuarters);
	}

	public boolean isDisplayed_sb_CountOfQuarters() {
		return isDisplayed(sb_CountOfQuarters);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfHalfDollarCoins(String TestData_sb_CountOfHalfDollarCoins) {
		doIT(sb_CountOfHalfDollarCoins, TestData_sb_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_sb_CountOfHalfDollarCoins() {
		return isDisplayed(sb_CountOfHalfDollarCoins);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOfDollarCoins(String TestData_sb_CountOfDollarCoins) {
		doIT(sb_CountOfDollarCoins, TestData_sb_CountOfDollarCoins);
	}

	public boolean isDisplayed_sb_CountOfDollarCoins() {
		return isDisplayed(sb_CountOfDollarCoins);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf1Dollar(String TestData_sb_CountOf1Dollar) {
		doIT(sb_CountOf1Dollar, TestData_sb_CountOf1Dollar);
	}

	public boolean isDisplayed_sb_CountOf1Dollar() {
		return isDisplayed(sb_CountOf1Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf5Dollar(String TestData_sb_CountOf5Dollar) {
		doIT(sb_CountOf5Dollar, TestData_sb_CountOf5Dollar);
	}

	public boolean isDisplayed_sb_CountOf5Dollar() {
		return isDisplayed(sb_CountOf5Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf10Dollar(String TestData_sb_CountOf10Dollar) {
		doIT(sb_CountOf10Dollar, TestData_sb_CountOf10Dollar);
	}

	public boolean isDisplayed_sb_CountOf10Dollar() {
		return isDisplayed(sb_CountOf10Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf20Dollar(String TestData_sb_CountOf20Dollar) {
		doIT(sb_CountOf20Dollar, TestData_sb_CountOf20Dollar);
	}

	public boolean isDisplayed_sb_CountOf20Dollar() {
		return isDisplayed(sb_CountOf20Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf50Dollar(String TestData_sb_CountOf50Dollar) {
		doIT(sb_CountOf50Dollar, TestData_sb_CountOf50Dollar);
	}

	public boolean isDisplayed_sb_CountOf50Dollar() {
		return isDisplayed(sb_CountOf50Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_CountOf100Dollar(String TestData_sb_CountOf100Dollar) {
		doIT(sb_CountOf100Dollar, TestData_sb_CountOf100Dollar);
	}

	public boolean isDisplayed_sb_CountOf100Dollar() {
		return isDisplayed(sb_CountOf100Dollar);
	}

	//****************************************************************************************************************************
	public void set_sb_Cash(String TestData_sb_Cash) {
		doIT(sb_Cash, TestData_sb_Cash);
	}

	public boolean isDisplayed_sb_Cash() {
		return isDisplayed(sb_Cash);
	}

	//****************************************************************************************************************************
	public void click_sb_CheckBalance(String TestData_sb_CheckBalance) {
		doIT(sb_CheckBalance, TestData_sb_CheckBalance);
	}
	
	public void set_sb_CheckBalance(String TestData_sb_CheckBalance) {
		doIT(sb_CheckBalance, TestData_sb_CheckBalance);
	}

	public boolean isDisplayed_sb_CheckBalance() {
		return isDisplayed(sb_CheckBalance);
	}

	//****************************************************************************************************************************
	
	public void click_sb_CCMOBalance(String TestData_sb_CCMOBalance) {
		doIT(sb_CCMOBalance, TestData_sb_CCMOBalance);
	}
	
	public void set_sb_CCMOBalance(String TestData_sb_CCMOBalance) {
		doIT(sb_CCMOBalance, TestData_sb_CCMOBalance);
	}

	public boolean isDisplayed_sb_CCMOBalance() {
		return isDisplayed(sb_CCMOBalance);
	}

	//****************************************************************************************************************************

	public void set_sb_UserID(String TestData_sb_UserID) {
		doIT(sb_UserID, TestData_sb_UserID);
	}
	public boolean isDisplayed_sb_UserID() {
		return isDisplayed(sb_UserID);
	}

	//****************************************************************************************************************************
	public void set_sb_UserPIN(String TestData_sb_UserPIN) {
		doIT(sb_UserPIN, TestData_sb_UserPIN);
	}

	public boolean isDisplayed_sb_UserPIN() {
		return isDisplayed(sb_UserPIN);
	}

	//****************************************************************************************************************************
	public void set_sb_BankerID(String TestData_sb_BankerID) {
		doIT(sb_BankerID, TestData_sb_BankerID);
	}

	public boolean isDisplayed_sb_BankerID() {
		return isDisplayed(sb_BankerID);
	}

	//****************************************************************************************************************************
	public void set_sb_BankerPIN(String TestData_sb_BankerPIN) {
		doIT(sb_BankerPIN, TestData_sb_BankerPIN);
	}

	public boolean isDisplayed_sb_BankerPIN() {
		return isDisplayed(sb_BankerPIN);
	}

	//****************************************************************************************************************************
	public void click_sb_FinishBanlanceSafeButton(String data) {
		doIT(sb_FinishBanlanceSafeButton, data);
	}

	public boolean isDisplayed_sb_FinishBanlanceSafeButton() {
		return isDisplayed(sb_FinishBanlanceSafeButton);
	}

	//****************************************************************************************************************************
	public String get_sb_Validation(String TestData_sb_Validation) {
		return doIT(sb_Validation, TestData_sb_Validation);
	}

	public boolean isDisplayed_sb_Validation() {
		return isDisplayed(sb_Validation);
	}
	
	//****************************************************************************************************************************
	public String get_sb_BankerPINInvalid(String TestData_sb_BankerPINInvalid) {
		return doIT(sb_BankerPINInvalid, TestData_sb_BankerPINInvalid);
	}

	//****************************************************************************************************************************
	public void click_sb_Success_OKButton(String TestData_sb_Success_OKButton) {
		doIT(sb_Success_OKButton, TestData_sb_Success_OKButton);
	}

	public boolean isDisplayed_sb_Success_OKButton() {
		return isDisplayed(sb_Success_OKButton);
	}

	//****************************************************************************************************************************
	public void click_sb_CancelButton(String TestData_sb_CancelButton) {
		doIT(sb_CancelButton, TestData_sb_CancelButton);
	}

	public boolean isDisplayed_sb_CancelButton() {
		return isDisplayed(sb_CancelButton);
	}

	//****************************************************************************************************************************
	public void click_sb_HistoryButton(String TestData_sb_HistoryButton) {
		doIT(sb_HistoryButton, TestData_sb_HistoryButton);
	}

	public boolean isDisplayed_sb_HistoryButton() {
		return isDisplayed(sb_HistoryButton);
	}

	// Acknowledge the Counted Balance Does Not Match Calculated Balance dialog box
	public void click_CM_Safe_CountedBal_NotEqual_CalcBal_OK_Btn(String data) {
		Alert countedBalNotEqualClacBalmsg =driver.switchTo().alert();
		String strcountedBalNotEqualClacBalmsg = countedBalNotEqualClacBalmsg.getText();
		System.out.println(strcountedBalNotEqualClacBalmsg);
		countedBalNotEqualClacBalmsg.accept();
	}
	
	// Acknowledge the Counted Cash Balance Short dialog box
	public void click_CM_Safe_CountedBal_Short_OK_Btn(String data) {
		Alert countedBalShortmsg =driver.switchTo().alert();
		String strcountedBalShortmsg = countedBalShortmsg.getText();
		System.out.println(strcountedBalShortmsg);
		countedBalShortmsg.accept();
	}

	
}