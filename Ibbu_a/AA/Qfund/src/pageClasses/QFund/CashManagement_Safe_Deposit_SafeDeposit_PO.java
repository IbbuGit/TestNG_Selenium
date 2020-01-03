package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_Deposit_SafeDeposit_PO extends BasePage {

	public CashManagement_Safe_Deposit_SafeDeposit_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	// ------------------------------------------------------------------------------------------------------------------
	// Module Name : Cash Management
	// Method : safeDeposit
	// Class Name : CashManagement_Safe_Deposit_SafeDeposit_PO
	// Page Name(QFundX) : Safe Deposit
	// Responsible : Lee Huntsinger
	// Date : 28-Jun-2018
	// Prerequisite : 1) Safe MUST be assigned first
	// 2) Cash In process should be performed
	// 3) The cash in Safe should exceed amount in Drawer(s) in current store
	//
	// Expected results : Safe Deposit should be successful
	// ------------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'Safe Deposit')]")
	private WebElement sd_PageHeader;

	@FindBy(name = "safeDepositRequestBean.abaCode")
	private WebElement sd_DepositBank;

	@FindBy(name = "safeDepositRequestBean.noOfPennies")
	private WebElement sd_CountOfPennies;

	@FindBy(name = "safeDepositRequestBean.noOfNickels")
	private WebElement sd_CountOfNickels;

	@FindBy(name = "safeDepositRequestBean.noOfDimes")
	private WebElement sd_CountOfDimes;

	@FindBy(name = "safeDepositRequestBean.noOfQuarters")
	private WebElement sd_CountOfQuarters;

	@FindBy(name = "safeDepositRequestBean.noOfHalfDollars")
	private WebElement sd_CountOfHalfDollarCoins;

	@FindBy(name = "safeDepositRequestBean.noOfDollars")
	private WebElement sd_CountOfDollarCoins;

	@FindBy(name = "safeDepositRequestBean.noOfOneDollars")
	private WebElement sd_CountOf1Dollar;

	@FindBy(name = "safeDepositRequestBean.noOf5Dollars")
	private WebElement sd_CountOf5Dollar;

	@FindBy(name = "safeDepositRequestBean.noOf10Dollars")
	private WebElement sd_CountOf10Dollar;

	@FindBy(name = "safeDepositRequestBean.noOf20Dollars")
	private WebElement sd_CountOf20Dollar;

	@FindBy(name = "safeDepositRequestBean.noOf50Dollars")
	private WebElement sd_CountOf50Dollar;

	@FindBy(name = "safeDepositRequestBean.noOf100Dollars")
	private WebElement sd_CountOf100Dollar;

	@FindBy(name = "safeDepositRequestBean.cashInAmount")
	private WebElement sd_Cash;

	@FindBy(name = "safeDepositRequestBean.bagNbr")
	private WebElement sd_BagNbr;

	@FindBy(name = "username")
	private WebElement sd_UserID;

	@FindBy(name = "safeDepositRequestBean.empPwd")
	private WebElement sd_UserPIN;

	@FindBy(name = "safeDepositRequestBean.userId")
	private WebElement sd_BankerID;

	@FindBy(name = "safeDepositRequestBean.password")
	private WebElement sd_BankerPIN;

	@FindBy(name = "finishdeposit")
	private WebElement sd_FinishDepositButton;

	@FindBy(xpath = "//td[contains(text(),'Deposit Verification')]")
	private WebElement sdv_PageHeader;

	@FindBy(xpath = "//input[@name='finishdeposit' and @onclick='finish()']")
	private WebElement sd_DepositVerifyButton;

	@FindBy(xpath = "//*[contains(text(),'Deposit completed successfully.')]")
	private WebElement sd_Validation;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement sd_Success_OKButton;

	@FindBy(xpath = ".//input[@value='Cancel')]")
	private WebElement sd_CancelButton;

	@FindBy(xpath = ".//input[@value='History')]")
	private WebElement sd_HistoryButton;

	/*
	 * Page Elements Methods
	 */
	public String get_sd_PageHeader(String TestData_sd_PageHeader) {
		return doIT(sd_PageHeader, TestData_sd_PageHeader);
	}

	public boolean isDisplayed_sd_PageHeader() {
		return isDisplayed(sd_PageHeader);
	}

	// ****************************************************************************************************************************
	public void set_sd_DepositBank(String TestData_sd_DepositBank) {
		doIT(sd_DepositBank, TestData_sd_DepositBank);
	}

	public boolean isDisplayed_sd_DepositBank() {
		return isDisplayed(sd_DepositBank);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfPennies(String TestData_sd_CountOfPennies) {
		doIT(sd_CountOfPennies, TestData_sd_CountOfPennies);
	}

	public boolean isDisplayed_sd_CountOfPennies() {
		return isDisplayed(sd_CountOfPennies);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfNickels(String TestData_sd_CountOfNickels) {
		doIT(sd_CountOfNickels, TestData_sd_CountOfNickels);
	}

	public boolean isDisplayed_sd_CountOfNickels() {
		return isDisplayed(sd_CountOfNickels);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfDimes(String TestData_sd_CountOfDimes) {
		doIT(sd_CountOfDimes, TestData_sd_CountOfDimes);
	}

	public boolean isDisplayed_sd_CountOfDimes() {
		return isDisplayed(sd_CountOfDimes);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfQuarters(String TestData_sd_CountOfQuarters) {
		doIT(sd_CountOfQuarters, TestData_sd_CountOfQuarters);
	}

	public boolean isDisplayed_sd_CountOfQuarters() {
		return isDisplayed(sd_CountOfQuarters);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfHalfDollarCoins(String TestData_sd_CountOfHalfDollarCoins) {
		doIT(sd_CountOfHalfDollarCoins, TestData_sd_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_sd_CountOfHalfDollarCoins() {
		return isDisplayed(sd_CountOfHalfDollarCoins);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOfDollarCoins(String TestData_sd_CountOfDollarCoins) {
		doIT(sd_CountOfDollarCoins, TestData_sd_CountOfDollarCoins);
	}

	public boolean isDisplayed_sd_CountOfDollarCoins() {
		return isDisplayed(sd_CountOfDollarCoins);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf1Dollar(String TestData_sd_CountOf1Dollar) {
		doIT(sd_CountOf1Dollar, TestData_sd_CountOf1Dollar);
	}

	public boolean isDisplayed_sd_CountOf1Dollar() {
		return isDisplayed(sd_CountOf1Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf5Dollar(String TestData_sd_CountOf5Dollar) {
		doIT(sd_CountOf5Dollar, TestData_sd_CountOf5Dollar);
	}

	public boolean isDisplayed_sd_CountOf5Dollar() {
		return isDisplayed(sd_CountOf5Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf10Dollar(String TestData_sd_CountOf10Dollar) {
		doIT(sd_CountOf10Dollar, TestData_sd_CountOf10Dollar);
	}

	public boolean isDisplayed_sd_CountOf10Dollar() {
		return isDisplayed(sd_CountOf10Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf20Dollar(String TestData_sd_CountOf20Dollar) {
		doIT(sd_CountOf20Dollar, TestData_sd_CountOf20Dollar);
	}

	public boolean isDisplayed_sd_CountOf20Dollar() {
		return isDisplayed(sd_CountOf20Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf50Dollar(String TestData_sd_CountOf50Dollar) {
		doIT(sd_CountOf50Dollar, TestData_sd_CountOf50Dollar);
	}

	public boolean isDisplayed_sd_CountOf50Dollar() {
		return isDisplayed(sd_CountOf50Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_CountOf100Dollar(String TestData_sd_CountOf100Dollar) {
		doIT(sd_CountOf100Dollar, TestData_sd_CountOf100Dollar);
	}

	public boolean isDisplayed_sd_CountOf100Dollar() {
		return isDisplayed(sd_CountOf100Dollar);
	}

	// ****************************************************************************************************************************
	public void set_sd_Cash(String TestData_sd_Cash) {
		doIT(sd_Cash, TestData_sd_Cash);
	}

	public boolean isDisplayed_sd_Cash() {
		return isDisplayed(sd_Cash);
	}

	public String get_sd_Cash(String data) {

		return doIT(sd_Cash, data);
	}

	// ****************************************************************************************************************************
	public void set_sd_BagNbr(String TestData_sd_BagNbr) {
		doIT(sd_BagNbr, TestData_sd_BagNbr);
	}

	public boolean isDisplayed_sd_BagNbr() {
		return isDisplayed(sd_BagNbr);
	}

	// ****************************************************************************************************************************
	public String get_sd_UserID(String TestData_sd_UserID) {
		return doIT(sd_UserID, TestData_sd_UserID);
	}

	public boolean isDisplayed_sd_UserID() {
		return isDisplayed(sd_UserID);
	}

	// ****************************************************************************************************************************
	public void set_sd_UserPIN(String data) {
		if (isDisplayedNoException(sd_UserPIN)) {
			doIT(sd_UserPIN, data);
		}
	}

	public boolean isDisplayed_sd_UserPIN() {
		return isDisplayed(sd_UserPIN);
	}

	// ****************************************************************************************************************************
	public String get_sd_BankerID(String TestData_sd_BankerID) {
		return doIT(sd_BankerID, TestData_sd_BankerID);
	}

	public boolean isDisplayed_sd_BankerID() {
		return isDisplayed(sd_BankerID);
	}

	// ****************************************************************************************************************************
	public void set_sd_BankerPIN(String TestData_sd_BankerPIN) {
		if (isDisplayedNoException(sd_BankerPIN)) {
			doIT(sd_BankerPIN, TestData_sd_BankerPIN);
		}
	}

	public boolean isDisplayed_sd_BankerPIN() {
		return isDisplayed(sd_BankerPIN);
	}

	// ****************************************************************************************************************************
	public void click_sd_FinishDepositButton(String TestData_sd_FinishDepositButton) {
		doIT(sd_FinishDepositButton, TestData_sd_FinishDepositButton);
	}

	public boolean isDisplayed_sd_FinishDepositButton() {
		return isDisplayed(sd_FinishDepositButton);
	}

	// ****************************************************************************************************************************
	public void click_sd_DepositVerifyButton(String TestData_sd_DepositVerifyButton) {
		doIT(sd_DepositVerifyButton, TestData_sd_DepositVerifyButton);
	}

	public boolean isDisplayed_sd_DepositVerifyButton() {
		return isDisplayed(sd_DepositVerifyButton);
	}

	// ****************************************************************************************************************************
	public String get_sd_Validation(String TestData_sd_Validation) {
		return doIT(sd_Validation, TestData_sd_Validation);
	}

	public boolean isDisplayed_sd_Validation() {
		return isDisplayed(sd_Validation);
	}

	// ****************************************************************************************************************************
	public void click_sd_Success_OKButton(String TestData_sd_Success_OKButton) {
		doIT(sd_Success_OKButton, TestData_sd_Success_OKButton);
	}

	public boolean isDisplayed_sd_Success_OKButton() {
		return isDisplayed(sd_Success_OKButton);
	}

	// ****************************************************************************************************************************
	public void click_sd_CancelButton(String TestData_sd_CancelButton) {
		doIT(sd_CancelButton, TestData_sd_CancelButton);
	}

	public boolean isDisplayed_sd_CancelButton() {
		return isDisplayed(sd_CancelButton);
	}

	// ****************************************************************************************************************************
	public void click_sd_HistoryButton(String TestData_sd_HistoryButton) {
		doIT(sd_HistoryButton, TestData_sd_HistoryButton);
	}

	public boolean isDisplayed_sd_HistoryButton() {
		return isDisplayed(sd_HistoryButton);
	}

}
