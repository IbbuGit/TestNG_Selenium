package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_StoreToStore_PO extends BasePage{


 
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


	/*
	 * Constructor
	 */

	public CashManagement_Safe_StoreToStore_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);			
	}

	/*
	 * Page Elements
	 */

	@FindBy(xpath="//*[contains(text(),'Store to Store  Transfer')]") 
	private WebElement sts_PageHeader;
	
	@FindBy(name="locToLocRequestBean.actionCode")		
	private WebElement sts_Action;

	@FindBy(name="locToLocRequestBean.locationNbr")		
	private WebElement sts_StoreNbr;

	@FindBy(xpath="//input[contains(@name,'cashAmount')]")
	private WebElement sts_CashAmt;
		
	@FindBy(xpath="//input[contains(@name,'noOfPennies')]")
	private WebElement sts_CountOfPennies;
	
	@FindBy(xpath="//input[contains(@name,'noOfNickels')]")	
	private WebElement sts_CountOfNickels;

	@FindBy(xpath="//input[contains(@name,'noOfDimes')]")
	private WebElement sts_CountOfDimes;
	
	@FindBy(xpath="//input[contains(@name,'noOfQuarters')]")
	private WebElement sts_CountOfQuarters;

	@FindBy(xpath="//input[contains(@name,'noOfHalfDollars')]")		
	private WebElement sts_CountOfHalfDollarCoins;
	
	@FindBy(xpath="//input[contains(@name,'noOfDollars')]")
	private WebElement sts_CountOfDollarCoins;
	
	@FindBy(xpath="//input[contains(@name,'noOfOneDollars')]")
	private WebElement sts_CountOf1Dollar;
	
	@FindBy(xpath="//input[contains(@name,'noOf5Dollars')]")
	private WebElement sts_CountOf5Dollar;
	
	@FindBy(xpath="//input[contains(@name,'noOf10Dollars')]")
	private WebElement sts_CountOf10Dollar;
	
	@FindBy(xpath="//input[contains(@name,'noOf20Dollars')]")
	private WebElement sts_CountOf20Dollar;
	
	@FindBy(xpath="//input[contains(@name,'noOf50Dollars')]")
	private WebElement sts_CountOf50Dollar;
	
	@FindBy(xpath="//input[contains(@name,'noOf100Dollars')]")
	private WebElement sts_CountOf100Dollar;
	
	@FindBy(name="locToLocRequestBean.cashAmt")											
	private WebElement sts_Cash;

	@FindBy(name="username")											
	private WebElement sts_UserID;
	
	@FindBy(name="locToLocRequestBean.empPwd")						
	public WebElement sts_UserPIN;
	
	@FindBy(name=".*userId")						
	private WebElement sts_BankerID;
	
	@FindBy(name="locToLocRequestBean.password")					
	private WebElement sts_BankerPIN;
	
	@FindBy(name="loctoloc")				
	private WebElement sts_StoreToStoreButton;

	@FindBy(xpath="//input[@value='Cancel']") 
	private WebElement sts_CancelButton;

	@FindBy(xpath="//input[@value='History']") 
	private WebElement sts_HistoryButton;

	@FindBy(xpath="//*[contains(text(),'Store to Store transfer completed successfully.')]") 
	private WebElement sts_Validation;

	@FindBy(xpath="//input[@value='Ok']") 
	private WebElement sts_Success_OKButton;


	/*
	 * Page Elements Methods
	 */

	public String get_sts_PageHeader(String TestData_sts_PageHeader) {
		return doIT(sts_PageHeader, TestData_sts_PageHeader);
	}

	public boolean isDisplayed_sts_PageHeader() {
		return isDisplayed(sts_PageHeader);
	}

	public void set_sts_Action(String TestData_sts_Action) {
		doIT(sts_Action, TestData_sts_Action);
	}

	public boolean isDisplayed_sts_Action() {
		return isDisplayed(sts_Action);
	}

	public void set_sts_StoreNbr(String TestData_sts_StoreNbr) {
		doIT(sts_StoreNbr, TestData_sts_StoreNbr);
	}

	public boolean isDisplayed_sts_StoreNbr() {
		return isDisplayed(sts_StoreNbr);
	}

	public void set_sts_CashAmt(String TestData_sts_CashAmt) {
		doIT(sts_CashAmt, TestData_sts_CashAmt);
	}

	public boolean isDisplayed_sts_CashAmt() {
		return isDisplayed(sts_CashAmt);
	}

	public void set_sts_CountOfPennies(String TestData_sts_CountOfPennies) {
		doIT(sts_CountOfPennies, TestData_sts_CountOfPennies);
	}

	public boolean isDisplayed_sts_CountOfPennies() {
		return isDisplayed(sts_CountOfPennies);
	}

	public void set_sts_CountOfNickels(String TestData_sts_CountOfNickels) {
		doIT(sts_CountOfNickels, TestData_sts_CountOfNickels);
	}

	public boolean isDisplayed_sts_CountOfNickels() {
		return isDisplayed(sts_CountOfNickels);
	}

	public void set_sts_CountOfDimes(String TestData_sts_CountOfDimes) {
		doIT(sts_CountOfDimes, TestData_sts_CountOfDimes);
	}

	public boolean isDisplayed_sts_CountOfDimes() {
		return isDisplayed(sts_CountOfDimes);
	}

	public void set_sts_CountOfQuarters(String TestData_sts_CountOfQuarters) {
		doIT(sts_CountOfQuarters, TestData_sts_CountOfQuarters);
	}

	public boolean isDisplayed_sts_CountOfQuarters() {
		return isDisplayed(sts_CountOfQuarters);
	}

	public void set_sts_CountOfHalfDollarCoins(String TestData_sts_CountOfHalfDollarCoins) {
		doIT(sts_CountOfHalfDollarCoins, TestData_sts_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_sts_CountOfHalfDollarCoins() {
		return isDisplayed(sts_CountOfHalfDollarCoins);
	}

	public void set_sts_CountOfDollarCoins(String TestData_sts_CountOfDollarCoins) {
		doIT(sts_CountOfDollarCoins, TestData_sts_CountOfDollarCoins);
	}

	public boolean isDisplayed_sts_CountOfDollarCoins() {
		return isDisplayed(sts_CountOfDollarCoins);
	}

	public void set_sts_CountOf1Dollar(String TestData_sts_CountOf1Dollar) {
		doIT(sts_CountOf1Dollar, TestData_sts_CountOf1Dollar);
	}

	public boolean isDisplayed_sts_CountOf1Dollar() {
		return isDisplayed(sts_CountOf1Dollar);
	}

	public void set_sts_CountOf5Dollar(String TestData_sts_CountOf5Dollar) {
		doIT(sts_CountOf5Dollar, TestData_sts_CountOf5Dollar);
	}

	public boolean isDisplayed_sts_CountOf5Dollar() {
		return isDisplayed(sts_CountOf5Dollar);
	}

	public void set_sts_CountOf10Dollar(String TestData_sts_CountOf10Dollar) {
		doIT(sts_CountOf10Dollar, TestData_sts_CountOf10Dollar);
	}

	public boolean isDisplayed_sts_CountOf10Dollar() {
		return isDisplayed(sts_CountOf10Dollar);
	}

	public void set_sts_CountOf20Dollar(String TestData_sts_CountOf20Dollar) {
		doIT(sts_CountOf20Dollar, TestData_sts_CountOf20Dollar);
	}

	public boolean isDisplayed_sts_CountOf20Dollar() {
		return isDisplayed(sts_CountOf20Dollar);
	}

	public void set_sts_CountOf50Dollar(String TestData_sts_CountOf50Dollar) {
		doIT(sts_CountOf50Dollar, TestData_sts_CountOf50Dollar);
	}

	public boolean isDisplayed_sts_CountOf50Dollar() {
		return isDisplayed(sts_CountOf50Dollar);
	}

	public void set_sts_CountOf100Dollar(String TestData_sts_CountOf100Dollar) {
		doIT(sts_CountOf100Dollar, TestData_sts_CountOf100Dollar);
	}

	public boolean isDisplayed_sts_CountOf100Dollar() {
		return isDisplayed(sts_CountOf100Dollar);
	}

	public void set_sts_Cash(String TestData_sts_Cash) {
		doIT(sts_Cash, TestData_sts_Cash);
	}

	public boolean isDisplayed_sts_Cash() {
		return isDisplayed(sts_Cash);
	}

	public void set_sts_UserID(String TestData_sts_UserID) {
		doIT(sts_UserID, TestData_sts_UserID);
	}

	public boolean isDisplayed_sts_UserID() {
		return isDisplayed(sts_UserID);
	}

	public void set_sts_UserPIN(String TestData_sts_UserPIN) {
		doIT(sts_UserPIN, TestData_sts_UserPIN);
	}

	public boolean isDisplayed_sts_UserPIN() {
		return isDisplayed(sts_UserPIN);
	}

	public void set_sts_BankerID(String TestData_sts_BankerID) {
		doIT(sts_BankerID, TestData_sts_BankerID);
	}

	public boolean isDisplayed_sts_BankerID() {
		return isDisplayed(sts_BankerID);
	}

	public void set_sts_BankerPIN(String TestData_sts_BankerPIN) {
		doIT(sts_BankerPIN, TestData_sts_BankerPIN);
	}

	public boolean isDisplayed_sts_BankerPIN() {
		return isDisplayed(sts_BankerPIN);
	}

	public void click_sts_StoreToStoreButton(String TestData_sts_StoreToStoreButton) {
		doIT(sts_StoreToStoreButton, TestData_sts_StoreToStoreButton);
	}

	public boolean isDisplayed_sts_StoreToStoreButton() {
		return isDisplayed(sts_StoreToStoreButton);
	}

	public void click_sts_CancelButton(String TestData_sts_CancelButton) {
		doIT(sts_CancelButton, TestData_sts_CancelButton);
	}

	public boolean isDisplayed_sts_CancelButton() {
		return isDisplayed(sts_CancelButton);
	}

	public void click_sts_HistoryButton(String TestData_sts_HistoryButton) {
		doIT(sts_HistoryButton, TestData_sts_HistoryButton);
	}

	public boolean isDisplayed_sts_HistoryButton() {
		return isDisplayed(sts_HistoryButton);
	}

	public String get_sts_Validation(String TestData_sts_Validation) {
		return doIT(sts_Validation, TestData_sts_Validation);
	}

	public boolean isDisplayed_sts_Validation() {
		return isDisplayed(sts_Validation);
	}

	public void click_sts_Success_OKButton(String TestData_sts_Success_OKButton) {
		doIT(sts_Success_OKButton, TestData_sts_Success_OKButton);
	}

	public boolean isDisplayed_sts_Success_OKButton() {
		return isDisplayed(sts_Success_OKButton);
	}

}