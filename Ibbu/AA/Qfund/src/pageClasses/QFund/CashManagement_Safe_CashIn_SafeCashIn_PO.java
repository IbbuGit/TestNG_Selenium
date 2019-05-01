
/*---------------------------------------------------------------------------------------------------------------
 * Created By			:	Akula Srikanth
 * Date Created			: 	June 13th 2018
 * Modification Log 	:	<< Sameer >>	<< 13-June-2018>> 	<<Sprint 5>>
 * 							<< ABC >> 		<< 14-June-2018>> 	<<Sprint 6>>
 * 							<< asd >> 		<< 15-June-2018>> 	<<Sprint 7>>
 * --------------------------------------------------------------------------------------------------------------- 
 */

package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_CashIn_SafeCashIn_PO extends BasePage {

	/*
	 * Constructor
	 */

	public CashManagement_Safe_CashIn_SafeCashIn_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Page Elements
	 */

	@FindBy(id = "930000")
	private WebElement CashManagement_Tab;

	@FindBy(id = "932000")
	private WebElement Safe_Menu;

	@FindBy(id = "406")
	private WebElement CashIn_SubMenu;

	@FindBy(xpath = "formHeading")
	private WebElement sci_SafeCahInHeader;

	@FindBy(xpath = "//*[contains(text(),'Safe Cash In')]")
	private WebElement sci_PageHeader;

	@FindBy(name = "safeCashInRequestBean.noOfPennies")
	private WebElement sci_CountOfPennies;

	@FindBy(name = "safeCashInRequestBean.noOfNickels")
	private WebElement sci_CountOfNickels;

	@FindBy(name = "safeCashInRequestBean.noOfDimes")
	private WebElement sci_CountOfDimes;

	@FindBy(name = "safeCashInRequestBean.noOfQuarters")
	private WebElement sci_CountOfQuarters;

	@FindBy(name = "safeCashInRequestBean.noOfHalfDollars")
	private WebElement sci_CountOfHalfDollarCoins;

	@FindBy(name = "safeCashInRequestBean.noOfDollars")
	private WebElement sci_CountOfDollarCoins;

	@FindBy(name = "safeCashInRequestBean.noOfOneDollars")
	private WebElement sci_CountOf1Dollar;

	@FindBy(name = "safeCashInRequestBean.noOf5Dollars")
	private WebElement sci_CountOf5Dollar;

	@FindBy(name = "safeCashInRequestBean.noOf10Dollars")
	private WebElement sci_CountOf10Dollar;

	@FindBy(name = "safeCashInRequestBean.noOf20Dollars")
	private WebElement sci_CountOf20Dollar;

	@FindBy(name = "safeCashInRequestBean.noOf50Dollars")
	private WebElement sci_CountOf50Dollar;

	@FindBy(name = "safeCashInRequestBean.noOf100Dollars")
	private WebElement sci_CountOf100Dollar;

	@FindBy(name = "safeCashInRequestBean.openBal")
	private WebElement sci_Cash;

	@FindBy(name = "username")
	private WebElement sci_UserID;

	@FindBy(name = "safeCashInRequestBean.empPwd")
	private WebElement sci_UserPIN;

	@FindBy(name = "safeCashInRequestBean.userId")
	private WebElement sci_BankerID;

	@FindBy(name = "safeCashInRequestBean.password")
	private WebElement sci_BankerPIN;

	@FindBy(name = "cashIn")
	private WebElement sci_FinishCashInButton;

	@FindBy(xpath = "//*[contains(text(),'Cash-In completed successfully.')]")
	private WebElement sci_Validation;
	
	@FindBy(xpath = "//*[contains(text(),'Safe is not assigned for this Store')]")
	private WebElement sci_Error;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement sci_Success_OKButton;

	@FindBy(xpath = ".//input[@value='Cancel')]")
	private WebElement sci_CancelButton;

	@FindBy(xpath = ".//input[@value='History')]")
	private WebElement sci_HistoryButton;

	@FindBy(xpath = "//td[contains(text(),'Void Cash In')]")
	private WebElement vci_PageHeader;

	@FindBy(xpath = "//table//tr[@class='tableheadrow']/following-sibling::tr[1]//input[@name='cashvoid']")
	private WebElement vci_SelectCashInToVoid;

	@FindBy(xpath = ".//input[@value='Finish Void Cash In')]")
	private WebElement vci_FinishVoidCashInButton;

	@FindBy(xpath = "//td[contains(text(),'Transaction voided successfully.')]")
	private WebElement vci_Validation;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement vci_Success_OKButton;

	@FindBy(xpath = ".//input[@value='More')]")
	private WebElement vci_MoreButton;

	@FindBy(xpath = ".//input[@value='Cancel')]")
	private WebElement vci_CancelButton;

	/*
	 * Page Elements Methods
	 */
	public void click_CashManagement_Tab(String TestData_CashManagement_Tab) {
		doIT(CashManagement_Tab, TestData_CashManagement_Tab);
	}

	public boolean isDisplayed_CashManagement_Tab() {
		return isDisplayed(CashManagement_Tab);
	}

	public void click_Safe_Menu(String TestData_Safe_Menu) {
		doIT(Safe_Menu, TestData_Safe_Menu);
	}

	public boolean isDisplayed_Safe_Menu() {
		return isDisplayed(Safe_Menu);
	}

	public void click_CashIn_SubMenu(String TestData_CashIn_SubMenu) {
		doIT(CashIn_SubMenu, TestData_CashIn_SubMenu);
	}

	public boolean isDisplayed_CashIn_SubMenu() {
		return isDisplayed(CashIn_SubMenu);
	}

	public String get_sci_SafeCahInHeader(String TestData_sci_SafeCahInHeader) {
		return doIT(sci_SafeCahInHeader, TestData_sci_SafeCahInHeader);
	}

	public boolean isDisplayed_sci_SafeCahInHeader() {
		return isDisplayed(sci_SafeCahInHeader);
	}

	public String get_sci_PageHeader(String TestData_sci_PageHeader) {
		return doIT(sci_PageHeader, TestData_sci_PageHeader);
	}

	public boolean isDisplayed_sci_PageHeader() {
		return isDisplayed(sci_PageHeader);
	}

	public void set_sci_CountOfPennies(String TestData_sci_CountOfPennies) {
		doIT(sci_CountOfPennies, TestData_sci_CountOfPennies);
	}

	public boolean isDisplayed_sci_CountOfPennies() {
		return isDisplayed(sci_CountOfPennies);
	}

	public void set_sci_CountOfNickels(String TestData_sci_CountOfNickels) {
		doIT(sci_CountOfNickels, TestData_sci_CountOfNickels);
	}

	public boolean isDisplayed_sci_CountOfNickels() {
		return isDisplayed(sci_CountOfNickels);
	}

	public void set_sci_CountOfDimes(String TestData_sci_CountOfDimes) {
		doIT(sci_CountOfDimes, TestData_sci_CountOfDimes);
	}

	public boolean isDisplayed_sci_CountOfDimes() {
		return isDisplayed(sci_CountOfDimes);
	}

	public void set_sci_CountOfQuarters(String TestData_sci_CountOfQuarters) {
		doIT(sci_CountOfQuarters, TestData_sci_CountOfQuarters);
	}

	public boolean isDisplayed_sci_CountOfQuarters() {
		return isDisplayed(sci_CountOfQuarters);
	}

	public void set_sci_CountOfHalfDollarCoins(String TestData_sci_CountOfHalfDollarCoins) {
		doIT(sci_CountOfHalfDollarCoins, TestData_sci_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_sci_CountOfHalfDollarCoins() {
		return isDisplayed(sci_CountOfHalfDollarCoins);
	}

	public void set_sci_CountOfDollarCoins(String TestData_sci_CountOfDollarCoins) {
		doIT(sci_CountOfDollarCoins, TestData_sci_CountOfDollarCoins);
	}

	public boolean isDisplayed_sci_CountOfDollarCoins() {
		return isDisplayed(sci_CountOfDollarCoins);
	}

	public void set_sci_CountOf1Dollar(String TestData_sci_CountOf1Dollar) {
		doIT(sci_CountOf1Dollar, TestData_sci_CountOf1Dollar);
	}

	public boolean isDisplayed_sci_CountOf1Dollar() {
		return isDisplayed(sci_CountOf1Dollar);
	}

	public void set_sci_CountOf5Dollar(String TestData_sci_CountOf5Dollar) {
		doIT(sci_CountOf5Dollar, TestData_sci_CountOf5Dollar);
	}

	public boolean isDisplayed_sci_CountOf5Dollar() {
		return isDisplayed(sci_CountOf5Dollar);
	}

	public void set_sci_CountOf10Dollar(String TestData_sci_CountOf10Dollar) {
		doIT(sci_CountOf10Dollar, TestData_sci_CountOf10Dollar);
	}

	public boolean isDisplayed_sci_CountOf10Dollar() {
		return isDisplayed(sci_CountOf10Dollar);
	}

	public void set_sci_CountOf20Dollar(String TestData_sci_CountOf20Dollar) {
		doIT(sci_CountOf20Dollar, TestData_sci_CountOf20Dollar);
	}

	public boolean isDisplayed_sci_CountOf20Dollar() {
		return isDisplayed(sci_CountOf20Dollar);
	}

	public void set_sci_CountOf50Dollar(String TestData_sci_CountOf50Dollar) {
		doIT(sci_CountOf50Dollar, TestData_sci_CountOf50Dollar);
	}

	public boolean isDisplayed_sci_CountOf50Dollar() {
		return isDisplayed(sci_CountOf50Dollar);
	}

	public void set_sci_CountOf100Dollar(String TestData_sci_CountOf100Dollar) {
		doIT(sci_CountOf100Dollar, TestData_sci_CountOf100Dollar);
	}

	public boolean isDisplayed_sci_CountOf100Dollar() {
		return isDisplayed(sci_CountOf100Dollar);
	}

	public void set_sci_Cash(String TestData_sci_Cash) {
		doIT(sci_Cash, TestData_sci_Cash);
	}

	public boolean isDisplayed_sci_Cash() {
		return isDisplayed(sci_Cash);
	}

	public void set_sci_UserID(String TestData_sci_UserID) {
		doIT(sci_UserID, TestData_sci_UserID);
	}

	public boolean isDisplayed_sci_UserID() {
		return isDisplayed(sci_UserID);
	}

	public void set_sci_UserPIN(String data) {
		if (isDisplayedNoException(sci_UserPIN)) {
			doIT(sci_UserPIN, data);

		}
	}

	public boolean isDisplayed_sci_UserPIN() {
		return isDisplayed(sci_UserPIN);
	}

	public void set_sci_BankerID(String TestData_sci_BankerID) {
		doIT(sci_BankerID, TestData_sci_BankerID);
	}

	public boolean isDisplayed_sci_BankerID() {
		return isDisplayed(sci_BankerID);
	}

	public void set_sci_BankerPIN(String TestData_sci_BankerPIN) {
		doIT(sci_BankerPIN, TestData_sci_BankerPIN);
	}

	public boolean isDisplayed_sci_BankerPIN() {
		return isDisplayed(sci_BankerPIN);
	}

	public void click_sci_FinishCashInButton(String TestData_sci_FinishCashInButton) {
		doIT(sci_FinishCashInButton, TestData_sci_FinishCashInButton);
	}

	public boolean isDisplayed_sci_FinishCashInButton() {
		return isDisplayed(sci_FinishCashInButton);
	}

	public String get_sci_Validation(String TestData_sci_Validation) {
		return doIT(sci_Validation, TestData_sci_Validation);
	}

	public boolean isDisplayed_sci_Validation() {
		return isDisplayed(sci_Validation);
	}
	
	public String get_sci_Error(String TestData_sci_Error) {
		return doIT(sci_Error, TestData_sci_Error);
	}

	public void click_sci_Success_OKButton(String TestData_sci_Success_OKButton) {
		doIT(sci_Success_OKButton, TestData_sci_Success_OKButton);
	}

	public boolean isDisplayed_sci_Success_OKButton() {
		return isDisplayed(sci_Success_OKButton);
	}

	public void click_sci_CancelButton(String TestData_sci_CancelButton) {
		doIT(sci_CancelButton, TestData_sci_CancelButton);
	}

	public boolean isDisplayed_sci_CancelButton() {
		return isDisplayed(sci_CancelButton);
	}

	public void click_sci_HistoryButton(String TestData_sci_HistoryButton) {
		doIT(sci_HistoryButton, TestData_sci_HistoryButton);
	}

	public boolean isDisplayed_sci_HistoryButton() {
		return isDisplayed(sci_HistoryButton);
	}

	public String get_vci_PageHeader(String TestData_vci_PageHeader) {
		return doIT(vci_PageHeader, TestData_vci_PageHeader);
	}

	public boolean isDisplayed_vci_PageHeader() {
		return isDisplayed(vci_PageHeader);
	}

	public void click_vci_SelectCashInToVoid(String TestData_vci_SelectCashInToVoid) {
		doIT(vci_SelectCashInToVoid, TestData_vci_SelectCashInToVoid);
	}

	public boolean isDisplayed_vci_SelectCashInToVoid() {
		return isDisplayed(vci_SelectCashInToVoid);
	}

	public void click_vci_FinishVoidCashInButton(String TestData_vci_FinishVoidCashInButton) {
		doIT(vci_FinishVoidCashInButton, TestData_vci_FinishVoidCashInButton);
	}

	public boolean isDisplayed_vci_FinishVoidCashInButton() {
		return isDisplayed(vci_FinishVoidCashInButton);
	}

	public String get_vci_Validation(String TestData_vci_Validation) {
		return doIT(vci_Validation, TestData_vci_Validation);
	}

	public boolean isDisplayed_vci_Validation() {
		return isDisplayed(vci_Validation);
	}

	public void click_vci_Success_OKButton(String TestData_vci_Success_OKButton) {
		doIT(vci_Success_OKButton, TestData_vci_Success_OKButton);
	}

	public boolean isDisplayed_vci_Success_OKButton() {
		return isDisplayed(vci_Success_OKButton);
	}

	public void click_vci_MoreButton(String TestData_vci_MoreButton) {
		doIT(vci_MoreButton, TestData_vci_MoreButton);
	}

	public boolean isDisplayed_vci_MoreButton() {
		return isDisplayed(vci_MoreButton);
	}

	public void click_vci_CancelButton(String TestData_vci_CancelButton) {
		doIT(vci_CancelButton, TestData_vci_CancelButton);
	}

	public boolean isDisplayed_vci_CancelButton() {
		return isDisplayed(vci_CancelButton);
	}

}