package pageClasses.QFund;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * author = Akula Srikanth Date = 27-July-2018
 */

public class DailyProcessing_EOD_PO extends BasePage {

	public DailyProcessing_EOD_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[contains(text(),'Click the button to start the EOD Process')]")
	private WebElement DP_EODProcess_Header;

	@FindBy(name = "eod")
	private WebElement DP_StartEODProcessingButton;

	@FindBy(xpath = "//td[contains(text(),'Drawers are not deassigned for this Store')]")
	private WebElement DP_Drawer_ErrorMessage;

	@FindBy(xpath = "//td[contains(text(),'Safe not Assigned for this Store')]")
	private WebElement DP_Safe_ErrorMessage;

	@FindBy(xpath = "//td[contains(text(),'Pending Store Transfers')]")
	private WebElement sts_PendingStoreTransfer_Header;

	@FindBy(name = "voidloctoloc")
	private WebElement sts_VoidStoreTransferButton;

	@FindBy(xpath = "//td[contains(text(),'End of Day')]")
	private WebElement DP_EOD_Header;

	@FindBy(xpath = "//tr[@class='tableheadrow']/td[contains(text(),'Safe Balance')]")
	private WebElement EOD_SafeBalance_Header;

	@FindBy(xpath = "//td[contains(text(),'Store Nbr')]")
	private WebElement EOD_SB_StoreNbrVerification;

	@FindBy(name = "requestBean.noOfPennies")
	private WebElement EOD_SB_CountOfPennies;

	@FindBy(name = "requestBean.noOfNickels")
	private WebElement EOD_SB_CountOfNickels;

	@FindBy(name = "requestBean.noOfDimes")
	private WebElement EOD_SB_CountOfDimes;

	@FindBy(name = "requestBean.noOfQuarters")
	private WebElement EOD_SB_CountOfQuarters;

	@FindBy(name = "requestBean.noOfHalfDollars")
	private WebElement EOD_SB_CountOfHalfDollarCoins;

	@FindBy(name = "requestBean.noOfDollars")
	private WebElement EOD_SB_CountOfDollarCoins;

	@FindBy(name = "requestBean.noOfOneDollars")
	private WebElement EOD_SB_CountOf1Dollar;

	@FindBy(name = "requestBean.noOf5Dollars")
	private WebElement EOD_SB_CountOf5Dollar;

	@FindBy(name = "requestBean.noOf10Dollars")
	private WebElement EOD_SB_CountOf10Dollar;

	@FindBy(name = "requestBean.noOf20Dollars")
	private WebElement EOD_SB_CountOf20Dollar;

	@FindBy(name = "requestBean.noOf50Dollars")
	private WebElement EOD_SB_CountOf50Dollar;

	@FindBy(name = "requestBean.noOf100Dollars")
	private WebElement EOD_SB_CountOf100Dollar;

	@FindBy(name = "requestBean.cashAmount")
	private WebElement EOD_SB_CashBalanceVerification;

	@FindBy(name = "ccmoAmount")
	private WebElement EOD_SB_CCMOBalance;

	@FindBy(xpath = "//td[contains(text(),'Total Check Amt')]")
	private WebElement EOD_SB_TotalCheckAmtVerification;

	@FindBy(name = "requestBean.comments")
	private WebElement EOD_SB_EODComments;

	@FindBy(xpath = "//td[contains(text(),'Date/Time')]")
	private WebElement EOD_SB_DateTimeVerification;

	@FindBy(xpath = "//input[@value='Exit EOD']")
	private WebElement EOD_SB_ExitEODButton;

	@FindBy(xpath = "//input[@value='Balance Safe']")
	private WebElement EOD_SB_BalanceSafeButton;

	/*
	 * Alert
	 */

	@FindBy(xpath = "//td[contains(text(),'EOD Over/Short')]")
	private WebElement EOD_OverShortHeader;

	@FindBy(xpath = "//td[contains(text(),'Employee Name :')]")
	private WebElement EOD_OS_EmployeeNameVerification;

	@FindBy(xpath = "//td[contains(text(),'Opening Balance:')]")
	private WebElement EOD_OS_OpeningBalanceVerification;

	@FindBy(xpath = "//td[contains(text(),'Counted Balance:')]")
	private WebElement EOD_OS_CountedBalanceVerification;

	@FindBy(xpath = "//td[contains(text(),'System safe Balance:')]")
	private WebElement EOD_OS_SystemSafeBalanceVerification;

	@FindBy(xpath = "//td/strong[contains(text(),'Safe Over/Short Amount:')]/parent::td/following-sibling::td")
	// @FindBy(name="requestBean.safeOverShort')]")
	private WebElement EOD_OS_SafeOverShortAmountVerification;

	/*
	 * Out of Balance Reason
	 */

	@FindBy(xpath = "//td[contains(text(),'Out of Balance Reason')]")
	private WebElement EOD_OS_OutofBalReason_Header;

	@FindBy(name = "requestBean.amount")
	private WebElement EOD_OS_Amount;

	@FindBy(name = "requestBean.primary")
	private WebElement EOD_OS_PrimaryReason;

	@FindBy(name = "requestBean.product")
	private WebElement EOD_OS_Product;

	@FindBy(name = "requestBean.loanNbr")
	private WebElement EOD_OS_LoanNbr;

	@FindBy(name = "requestBean.notes")
	private WebElement EOD_OS_Notes;

	// @FindBy(xpath="//input[@value='Add O/S Instance')]")
	@FindBy(name = "bt_AddDrawer")
	private WebElement EOD_OS_AddOSInstanceButton;

	@FindBy(xpath = "//table//td[contains(text(),'Primary Reason')]")
	private WebElement EOD_OS_TableInstanceVerification;

	@FindBy(xpath = "//select[@name='menu']")
	private WebElement EOD_OS_EditDelete;

	@FindBy(xpath = "//input[@value='Go']")
	private WebElement EOD_OS_GoButton;

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement EOD_OS_BackButton;

	@FindBy(xpath = "//input[@value='Exit EOD']")
	private WebElement EOD_OS_ExitEODButton;

	@FindBy(xpath = "//input[@value='Next']")
	private WebElement EOD_OS_NextButton;

	/*
	 * Deposit
	 * 
	 */

	@FindBy(xpath = "//td[contains(text(),'Deposit')]")
	private WebElement EOD_Deposit_Header;

	@FindBy(name = "cashBal")
	private WebElement EOD_DP_DepositCashBalance;

	@FindBy(xpath = "//input[@value='Calc Dep Amt']")
	private WebElement EOD_DP_CalcDepAmtButton;

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement EOD_DP_BackButton;

	@FindBy(xpath = "//input[@value='Exit EOD']")
	private WebElement EOD_DP_ExitEODButton;

	@FindBy(xpath = "//input[@value='Next']")
	private WebElement EOD_DP_NextButton;

	/*
	 * End of the Day Deposit
	 * 
	 */

	@FindBy(xpath = "//td[contains(text(),'End of the Day Deposit')]")
	private WebElement EOD_EODDeposit_Header;

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement EOD_EODDeposit_BackButton;

	@FindBy(xpath = "//input[@value='Exit EOD']")
	private WebElement EOD_EODDeposit_ExitEODButton;

	@FindBy(xpath = "//input[@value='Next']")
	private WebElement EOD_EODDeposit_NextButton;

	/*
	 * Deposit Verification
	 * 
	 */

	@FindBy(xpath = "//td[contains(text(),'Deposit Verification')]")
	private WebElement EOD_DepositVerification_Header;

	@FindBy(xpath = "//td[contains(text(),'Current Cash Balance ')]")
	private WebElement EOD_DV_CurrentCashBalanceVerification;

	@FindBy(xpath = "//td[contains(text(),'Opening Safe balance ')]")
	private WebElement EOD_DV_OpeningSafeBalanceVerification;

	@FindBy(name = "requestBean.bagNbr")
	private WebElement EOD_EV_BagNbr;

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement EOD_DV_BackButton;

	@FindBy(xpath = "//input[@value='Exit EOD']")
	private WebElement EOD_DV_ExitEODButton;

	@FindBy(xpath = "//input[@value='Finish Deposit']")
	private WebElement EOD_DV_FinishDepositButton;

	@FindBy(xpath = "//td[contains(text(),'End Of Day completed successfully.')]")
	private WebElement EOD_CompletedSuccessfully;

	@FindBy(xpath = ".//input[@value='Ok']")
	private WebElement EOD_Success_OkButton;

	/*-----------------------------------------------------------
	 *  Locator Methods
	 * ---------------------------------------------------------
	 */

	public String get_DP_EODProcess_Header(String TestData_DP_EODProcess_Header) {
		selectFrame(frameMiddle);
		return doIT(DP_EODProcess_Header, TestData_DP_EODProcess_Header);
	}

	public boolean isDisplayed_DP_EODProcess_Header() {
		selectFrame(frameMiddle);
		return isDisplayed(DP_EODProcess_Header);
	}

	public void click_DP_StartEODProcessingButton(String TestData_DP_StartEODProcessingButton) {
		selectFrame(frameMiddle);
		doIT(DP_StartEODProcessingButton, TestData_DP_StartEODProcessingButton);
	}

	public boolean isDisplayed_DP_StartEODProcessingButton() {
		selectFrame(frameMiddle);
		return isDisplayed(DP_StartEODProcessingButton);
	}

	public String get_DP_Drawer_ErrorMessage(String TestData_DP_Drawer_ErrorMessage) {
		return doIT(DP_Drawer_ErrorMessage, TestData_DP_Drawer_ErrorMessage);
	}

	public boolean isDisplayed_DP_Drawer_ErrorMessage() {
		return isDisplayed(DP_Drawer_ErrorMessage);
	}

	public String get_DP_Safe_ErrorMessage(String TestData_DP_Safe_ErrorMessage) {
		return doIT(DP_Safe_ErrorMessage, TestData_DP_Safe_ErrorMessage);
	}

	public boolean isDisplayed_DP_Safe_ErrorMessage() {
		return isDisplayed(DP_Safe_ErrorMessage);
	}

	public String get_DP_EOD_Header(String TestData_DP_EOD_Header) {
		return doIT(DP_EOD_Header, TestData_DP_EOD_Header);
	}

	public boolean isDisplayed_DP_EOD_Header() {
		return isDisplayed(DP_EOD_Header);
	}

	public String get_EOD_SafeBalance_Header(String TestData_EOD_SafeBalance_Header) {
		return doIT(EOD_SafeBalance_Header, TestData_EOD_SafeBalance_Header);
	}

	public boolean isDisplayed_EOD_SafeBalance_Header() {
		return isDisplayed(EOD_SafeBalance_Header);
	}

	public void set_EOD_SB_StoreNbrVerification(String TestData_EOD_SB_StoreNbrVerification) {
		doIT(EOD_SB_StoreNbrVerification, TestData_EOD_SB_StoreNbrVerification);
	}

	public boolean isDisplayed_EOD_SB_StoreNbrVerification() {
		return isDisplayed(EOD_SB_StoreNbrVerification);
	}

	public void set_EOD_SB_CountOfPennies(String TestData_EOD_SB_CountOfPennies) {
		doIT(EOD_SB_CountOfPennies, TestData_EOD_SB_CountOfPennies);
	}

	public boolean isDisplayed_EOD_SB_CountOfPennies() {
		return isDisplayed(EOD_SB_CountOfPennies);
	}

	public void set_EOD_SB_CountOfNickels(String TestData_EOD_SB_CountOfNickels) {
		doIT(EOD_SB_CountOfNickels, TestData_EOD_SB_CountOfNickels);
	}

	public boolean isDisplayed_EOD_SB_CountOfNickels() {
		return isDisplayed(EOD_SB_CountOfNickels);
	}

	public void set_EOD_SB_CountOfDimes(String TestData_EOD_SB_CountOfDimes) {
		doIT(EOD_SB_CountOfDimes, TestData_EOD_SB_CountOfDimes);
	}

	public boolean isDisplayed_EOD_SB_CountOfDimes() {
		return isDisplayed(EOD_SB_CountOfDimes);
	}

	public void set_EOD_SB_CountOfQuarters(String TestData_EOD_SB_CountOfQuarters) {
		doIT(EOD_SB_CountOfQuarters, TestData_EOD_SB_CountOfQuarters);
	}

	public boolean isDisplayed_EOD_SB_CountOfQuarters() {
		return isDisplayed(EOD_SB_CountOfQuarters);
	}

	public void set_EOD_SB_CountOfHalfDollarCoins(String TestData_EOD_SB_CountOfHalfDollarCoins) {
		doIT(EOD_SB_CountOfHalfDollarCoins, TestData_EOD_SB_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_EOD_SB_CountOfHalfDollarCoins() {
		return isDisplayed(EOD_SB_CountOfHalfDollarCoins);
	}

	public void set_EOD_SB_CountOfDollarCoins(String TestData_EOD_SB_CountOfDollarCoins) {
		doIT(EOD_SB_CountOfDollarCoins, TestData_EOD_SB_CountOfDollarCoins);
	}

	public boolean isDisplayed_EOD_SB_CountOfDollarCoins() {
		return isDisplayed(EOD_SB_CountOfDollarCoins);
	}

	public void set_EOD_SB_CountOf1Dollar(String TestData_EOD_SB_CountOf1Dollar) {
		doIT(EOD_SB_CountOf1Dollar, TestData_EOD_SB_CountOf1Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf1Dollar() {
		return isDisplayed(EOD_SB_CountOf1Dollar);
	}

	public void set_EOD_SB_CountOf5Dollar(String TestData_EOD_SB_CountOf5Dollar) {
		doIT(EOD_SB_CountOf5Dollar, TestData_EOD_SB_CountOf5Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf5Dollar() {
		return isDisplayed(EOD_SB_CountOf5Dollar);
	}

	public void set_EOD_SB_CountOf10Dollar(String TestData_EOD_SB_CountOf10Dollar) {
		doIT(EOD_SB_CountOf10Dollar, TestData_EOD_SB_CountOf10Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf10Dollar() {
		return isDisplayed(EOD_SB_CountOf10Dollar);
	}

	public void set_EOD_SB_CountOf20Dollar(String TestData_EOD_SB_CountOf20Dollar) {
		doIT(EOD_SB_CountOf20Dollar, TestData_EOD_SB_CountOf20Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf20Dollar() {
		return isDisplayed(EOD_SB_CountOf20Dollar);
	}

	public void set_EOD_SB_CountOf50Dollar(String TestData_EOD_SB_CountOf50Dollar) {
		doIT(EOD_SB_CountOf50Dollar, TestData_EOD_SB_CountOf50Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf50Dollar() {
		return isDisplayed(EOD_SB_CountOf50Dollar);
	}

	public void set_EOD_SB_CountOf100Dollar(String TestData_EOD_SB_CountOf100Dollar) {
		doIT(EOD_SB_CountOf100Dollar, TestData_EOD_SB_CountOf100Dollar);
	}

	public boolean isDisplayed_EOD_SB_CountOf100Dollar() {
		return isDisplayed(EOD_SB_CountOf100Dollar);
	}

	public void set_EOD_SB_CashBalanceVerification(String TestData_EOD_SB_CashBalanceVerification) {
		doIT(EOD_SB_CashBalanceVerification, TestData_EOD_SB_CashBalanceVerification);
	}

	public boolean isDisplayed_EOD_SB_CashBalanceVerification() {
		return isDisplayed(EOD_SB_CashBalanceVerification);
	}

	public void set_EOD_SB_CCMOBalance(String TestData_EOD_SB_CCMOBalance) {
		doIT(EOD_SB_CCMOBalance, TestData_EOD_SB_CCMOBalance);
	}

	public boolean isDisplayed_EOD_SB_CCMOBalance() {
		return isDisplayed(EOD_SB_CCMOBalance);
	}

	public void set_EOD_SB_TotalCheckAmtVerification(String TestData_EOD_SB_TotalCheckAmtVerification) {
		doIT(EOD_SB_TotalCheckAmtVerification, TestData_EOD_SB_TotalCheckAmtVerification);
	}

	public boolean isDisplayed_EOD_SB_TotalCheckAmtVerification() {
		return isDisplayed(EOD_SB_TotalCheckAmtVerification);
	}

	public void set_EOD_SB_EODComments(String TestData_EOD_SB_EODComments) {
		doIT(EOD_SB_EODComments, TestData_EOD_SB_EODComments);
	}

	public boolean isDisplayed_EOD_SB_EODComments() {
		return isDisplayed(EOD_SB_EODComments);
	}

	public void set_EOD_SB_DateTimeVerification(String TestData_EOD_SB_DateTimeVerification) {
		doIT(EOD_SB_DateTimeVerification, TestData_EOD_SB_DateTimeVerification);
	}

	public boolean isDisplayed_EOD_SB_DateTimeVerification() {
		return isDisplayed(EOD_SB_DateTimeVerification);
	}

	public void click_EOD_SB_ExitEODButton(String TestData_EOD_SB_ExitEODButton) {
		doIT(EOD_SB_ExitEODButton, TestData_EOD_SB_ExitEODButton);
	}

	public boolean isDisplayed_EOD_SB_ExitEODButton() {
		return isDisplayed(EOD_SB_ExitEODButton);
	}

	public void click_EOD_SB_BalanceSafeButton(String TestData_EOD_SB_BalanceSafeButton) {
		doIT(EOD_SB_BalanceSafeButton, TestData_EOD_SB_BalanceSafeButton);
	}

	public boolean isDisplayed_sts_VoidStoreTransferButton() {
		return isDisplayed(EOD_SB_BalanceSafeButton);
	}

	public void click_sts_VoidStoreTransferButton(String data) {
		if (isDisplayedNoException(sts_VoidStoreTransferButton)) {
			doIT(sts_VoidStoreTransferButton, data);
		}
	}

	public boolean isDisplayed_EOD_SB_BalanceSafeButton() {
		return isDisplayed(EOD_SB_BalanceSafeButton);
	}

	public String get_EOD_OverShortHeader(String TestData_EOD_OverShortHeader) {
		return doIT(EOD_OverShortHeader, TestData_EOD_OverShortHeader);
	}

	public boolean isDisplayed_EOD_OverShortHeader() {
		return isDisplayed(EOD_OverShortHeader);
	}

	public void set_EOD_OS_EmployeeNameVerification(String TestData_EOD_OS_EmployeeNameVerification) {
		doIT(EOD_OS_EmployeeNameVerification, TestData_EOD_OS_EmployeeNameVerification);
	}

	public boolean isDisplayed_EOD_OS_EmployeeNameVerification() {
		return isDisplayed(EOD_OS_EmployeeNameVerification);
	}

	public void set_EOD_OS_OpeningBalanceVerification(String TestData_EOD_OS_OpeningBalanceVerification) {
		doIT(EOD_OS_OpeningBalanceVerification, TestData_EOD_OS_OpeningBalanceVerification);
	}

	public boolean isDisplayed_EOD_OS_OpeningBalanceVerification() {
		return isDisplayed(EOD_OS_OpeningBalanceVerification);
	}

	public void set_EOD_OS_CountedBalanceVerification(String TestData_EOD_OS_CountedBalanceVerification) {
		doIT(EOD_OS_CountedBalanceVerification, TestData_EOD_OS_CountedBalanceVerification);
	}

	public boolean isDisplayed_EOD_OS_CountedBalanceVerification() {
		return isDisplayed(EOD_OS_CountedBalanceVerification);
	}

	public void set_EOD_OS_SystemSafeBalanceVerification(String TestData_EOD_OS_SystemSafeBalanceVerification) {
		doIT(EOD_OS_SystemSafeBalanceVerification, TestData_EOD_OS_SystemSafeBalanceVerification);
	}

	public boolean isDisplayed_EOD_OS_SystemSafeBalanceVerification() {
		return isDisplayed(EOD_OS_SystemSafeBalanceVerification);
	}

	public void set_EOD_OS_SafeOverShortAmountVerification(String TestData_EOD_OS_SafeOverShortAmountVerification) {
		doIT(EOD_OS_SafeOverShortAmountVerification, TestData_EOD_OS_SafeOverShortAmountVerification);
	}

	public String get_EOD_OS_SafeOverShortAmountVerification(String TestData_SafeOverShortAmountVerification) {
		return doIT(EOD_OS_SafeOverShortAmountVerification, TestData_SafeOverShortAmountVerification);
	}

	public boolean isDisplayed_EOD_OS_SafeOverShortAmountVerification() {
		return isDisplayed(EOD_OS_SafeOverShortAmountVerification);
	}

	public String get_EOD_OS_OutofBalReason_Header(String TestData_EOD_OS_OutofBalReason_Header) {
		return doIT(EOD_OS_OutofBalReason_Header, TestData_EOD_OS_OutofBalReason_Header);
	}

	public boolean isDisplayed_EOD_OS_OutofBalReason_Header() {
		return isDisplayed(EOD_OS_OutofBalReason_Header);
	}

	public void set_EOD_OS_Amount(String TestData_EOD_OS_Amount) {
		doIT(EOD_OS_Amount, TestData_EOD_OS_Amount);
	}

	public boolean isDisplayed_EOD_OS_Amount() {
		return isDisplayed(EOD_OS_Amount);
	}

	public void set_EOD_OS_PrimaryReason(String TestData_EOD_OS_PrimaryReason) {
		doIT(EOD_OS_PrimaryReason, TestData_EOD_OS_PrimaryReason);
	}

	public boolean isDisplayed_EOD_OS_PrimaryReason() {
		return isDisplayed(EOD_OS_PrimaryReason);
	}

	public void set_EOD_OS_Product(String TestData_EOD_OS_Product) {
		doIT(EOD_OS_Product, TestData_EOD_OS_Product);
	}

	public boolean isDisplayed_EOD_OS_Product() {
		return isDisplayed(EOD_OS_Product);
	}

	public void set_EOD_OS_LoanNbr(String TestData_EOD_OS_LoanNbr) {
		doIT(EOD_OS_LoanNbr, TestData_EOD_OS_LoanNbr);
	}

	public boolean isDisplayed_EOD_OS_LoanNbr() {
		return isDisplayed(EOD_OS_LoanNbr);
	}

	public void set_EOD_OS_Notes(String TestData_EOD_OS_Notes) {
		doIT(EOD_OS_Notes, TestData_EOD_OS_Notes);
	}

	public boolean isDisplayed_EOD_OS_Notes() {
		return isDisplayed(EOD_OS_Notes);
	}

	public void click_EOD_OS_AddOSInstanceButton(String TestData_EOD_OS_AddOSInstanceButton) {
		doIT(EOD_OS_AddOSInstanceButton, TestData_EOD_OS_AddOSInstanceButton);
	}

	public boolean isDisplayed_EOD_OS_AddOSInstanceButton() {
		return isDisplayed(EOD_OS_AddOSInstanceButton);
	}

	public void set_EOD_OS_TableInstanceVerification(String TestData_EOD_OS_TableInstanceVerification) {
		doIT(EOD_OS_TableInstanceVerification, TestData_EOD_OS_TableInstanceVerification);
	}

	public boolean isDisplayed_EOD_OS_TableInstanceVerification() {
		return isDisplayed(EOD_OS_TableInstanceVerification);
	}

	public void click_EOD_OS_BackButton(String TestData_EOD_OS_BackButton) {
		doIT(EOD_OS_BackButton, TestData_EOD_OS_BackButton);
	}

	public boolean isDisplayed_EOD_OS_BackButton() {
		return isDisplayed(EOD_OS_BackButton);
	}

	public void click_EOD_OS_ExitEODButton(String TestData_EOD_OS_ExitEODButton) {
		doIT(EOD_OS_ExitEODButton, TestData_EOD_OS_ExitEODButton);
	}

	public boolean isDisplayed_EOD_OS_ExitEODButton() {
		return isDisplayed(EOD_OS_ExitEODButton);
	}

	public void click_EOD_OS_NextButton(String TestData_EOD_OS_NextButton) {
		doIT(EOD_OS_NextButton, TestData_EOD_OS_NextButton);
	}

	public boolean isDisplayed_EOD_OS_NextButton() {
		return isDisplayed(EOD_OS_NextButton);
	}

	public String get_EOD_Deposit_Header(String TestData_EOD_Deposit_Header) {
		return doIT(EOD_Deposit_Header, TestData_EOD_Deposit_Header);
	}

	public boolean isDisplayed_EOD_Deposit_Header() {
		return isDisplayed(EOD_Deposit_Header);
	}

	public void set_EOD_DP_DepositCashBalance(String TestData_EOD_DP_DepositCashBalance) {
		doIT(EOD_DP_DepositCashBalance, TestData_EOD_DP_DepositCashBalance);
	}

	public boolean isDisplayed_EOD_DP_DepositCashBalance() {
		return isDisplayed(EOD_DP_DepositCashBalance);
	}

	public void click_EOD_DP_CalcDepAmtButton(String TestData_EOD_DP_CalcDepAmtButton) {
		doIT(EOD_DP_CalcDepAmtButton, TestData_EOD_DP_CalcDepAmtButton);
	}

	public boolean isDisplayed_EOD_DP_CalcDepAmtButton() {
		return isDisplayed(EOD_DP_CalcDepAmtButton);
	}

	public void click_EOD_DP_BackButton(String TestData_EOD_DP_BackButton) {
		doIT(EOD_DP_BackButton, TestData_EOD_DP_BackButton);
	}

	public boolean isDisplayed_EOD_DP_BackButton() {
		return isDisplayed(EOD_DP_BackButton);
	}

	public void click_EOD_DP_ExitEODButton(String TestData_EOD_DP_ExitEODButton) {
		doIT(EOD_DP_ExitEODButton, TestData_EOD_DP_ExitEODButton);
	}

	public boolean isDisplayed_EOD_DP_ExitEODButton() {
		return isDisplayed(EOD_DP_ExitEODButton);
	}

	public void click_EOD_DP_NextButton(String TestData_EOD_DP_NextButton) {
		doIT(EOD_DP_NextButton, TestData_EOD_DP_NextButton);
	}

	public boolean isDisplayed_EOD_DP_NextButton() {
		return isDisplayed(EOD_DP_NextButton);
	}

	public String get_EOD_EODDeposit_Header(String TestData_EOD_EODDeposit_Header) {
		return doIT(EOD_EODDeposit_Header, TestData_EOD_EODDeposit_Header);
	}

	public boolean isDisplayed_EOD_EODDeposit_Header() {
		return isDisplayed(EOD_EODDeposit_Header);
	}

	public void click_EOD_EODDeposit_BackButton(String TestData_EOD_EODDeposit_BackButton) {
		doIT(EOD_EODDeposit_BackButton, TestData_EOD_EODDeposit_BackButton);
	}

	public boolean isDisplayed_EOD_EODDeposit_BackButton() {
		return isDisplayed(EOD_EODDeposit_BackButton);
	}

	public void click_EOD_EODDeposit_ExitEODButton(String TestData_EOD_EODDeposit_ExitEODButton) {
		doIT(EOD_EODDeposit_ExitEODButton, TestData_EOD_EODDeposit_ExitEODButton);
	}

	public boolean isDisplayed_EOD_EODDeposit_ExitEODButton() {
		return isDisplayed(EOD_EODDeposit_ExitEODButton);
	}

	public void click_EOD_EODDeposit_NextButton(String TestData_EOD_EODDeposit_NextButton) {
		doIT(EOD_EODDeposit_NextButton, TestData_EOD_EODDeposit_NextButton);
	}

	public boolean isDisplayed_EOD_EODDeposit_NextButton() {
		return isDisplayed(EOD_EODDeposit_NextButton);
	}

	public String get_EOD_DepositVerification_Header(String TestData_EOD_DepositVerification_Header) {
		return doIT(EOD_DepositVerification_Header, TestData_EOD_DepositVerification_Header);
	}

	public boolean isDisplayed_EOD_DepositVerification_Header() {
		return isDisplayed(EOD_DepositVerification_Header);
	}

	public void set_EOD_DV_CurrentCashBalanceVerification(String TestData_EOD_DV_CurrentCashBalanceVerification) {
		doIT(EOD_DV_CurrentCashBalanceVerification, TestData_EOD_DV_CurrentCashBalanceVerification);
	}

	public boolean isDisplayed_EOD_DV_CurrentCashBalanceVerification() {
		return isDisplayed(EOD_DV_CurrentCashBalanceVerification);
	}

	public void set_EOD_DV_OpeningSafeBalanceVerification(String TestData_EOD_DV_OpeningSafeBalanceVerification) {
		doIT(EOD_DV_OpeningSafeBalanceVerification, TestData_EOD_DV_OpeningSafeBalanceVerification);
	}

	public boolean isDisplayed_EOD_DV_OpeningSafeBalanceVerification() {
		return isDisplayed(EOD_DV_OpeningSafeBalanceVerification);
	}

	public void set_EOD_EV_BagNbr(String TestData_EOD_EV_BagNbr) {
		doIT(EOD_EV_BagNbr, TestData_EOD_EV_BagNbr);
	}

	public boolean isDisplayed_EOD_EV_BagNbr() {
		return isDisplayed(EOD_EV_BagNbr);
	}

	public void click_EOD_DV_BackButton(String TestData_EOD_DV_BackButton) {
		doIT(EOD_DV_BackButton, TestData_EOD_DV_BackButton);
	}

	public boolean isDisplayed_EOD_DV_BackButton() {
		return isDisplayed(EOD_DV_BackButton);
	}

	public void click_EOD_DV_ExitEODButton(String TestData_EOD_DV_ExitEODButton) {
		doIT(EOD_DV_ExitEODButton, TestData_EOD_DV_ExitEODButton);
	}

	public boolean isDisplayed_EOD_DV_ExitEODButton() {
		return isDisplayed(EOD_DV_ExitEODButton);
	}

	public void click_EOD_DV_FinishDepositButton(String TestData_EOD_DV_FinishDepositButton) {
		//doIT(EOD_DV_FinishDepositButton, TestData_EOD_DV_FinishDepositButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", EOD_DV_FinishDepositButton);
	}

	public boolean isDisplayed_EOD_DV_FinishDepositButton() {
		return isDisplayed(EOD_DV_FinishDepositButton);
	}

	public String get_EOD_CompletedSuccessfully(String TestData_EOD_CompletedSuccessfully) {
		return doIT(EOD_CompletedSuccessfully, TestData_EOD_CompletedSuccessfully);
	}

	public boolean isDisplayed_EOD_CompletedSuccessfully() {
		return isDisplayed(EOD_CompletedSuccessfully);
	}

	public void click_EOD_Success_OkButton(String TestData_EOD_Success_OkButton) {
		doIT(EOD_Success_OkButton, TestData_EOD_Success_OkButton);
	}

	public boolean isDisplayed_EOD_Success_OkButton() {
		return isDisplayed(EOD_Success_OkButton);
	}

	public void set_EOD_OS_EditDelete(String data) {
		doIT(EOD_OS_EditDelete, data);
	}

	public void click_EOD_OS_GoButton(String data) {
		doIT(EOD_OS_GoButton, data);
	}
	
	public void WaitForElement( ) {
		new WebDriverWait(driver,120).until(ExpectedConditions.visibilityOf(EOD_CompletedSuccessfully));

	}

	@FindBy(xpath = "//input[@value='Go']")
	private List<WebElement> AddosInstancOKbtnList;

	public void EOD_DeleteOSInsatances() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {

			AddosInstancOKbtnList.get(0).isDisplayed();
			int count = AddosInstancOKbtnList.size();

			if (count != 0) {
				for (int i = 0; i < count; i++) {
					WebElement AddosInstancMenu = driver.findElement(By.xpath("(//select[@name='menu'])[1]"));
					WebElement AddosInstancOKbtn = driver.findElement(By.xpath("(//input[@value='Go'])[1]"));
					new Select(AddosInstancMenu).selectByVisibleText("Delete");
					AddosInstancOKbtn.click();
					acceptAlert();
				}
				report.log(LogStatus.INFO, "Deleted OS Insatances");
				System.out.println(LogStatus.INFO + "Deleted OS Insatances");
			}

		} catch (Exception e) {
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
