package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_Transactions_CustomerHistory_PO extends BasePage {

	public LoanTransactions_Transactions_CustomerHistory_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Page Elements
	 */

	@FindBy(xpath = "//td[contains(text(),'Customer History')]")
	private WebElement ch_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'SSN / ITIN')]/../following::tr[1]/td[1]/a")
	private WebElement ch_SSN_ISIN_Validation;

	@FindBy(xpath = "//td[contains(text(),'Customer Status')]/../following::tr[1]/td[2]")
	private WebElement ch_CustomerStatus_Validation;

	@FindBy(xpath = "//td[contains(text(),'Name')]/../following::tr[1]/td[3]")
	private WebElement ch_CustomerName_Validation;

	@FindBy(xpath = "//td[contains(text(),'Address')]/../following::tr[1]/td[4]")
	private WebElement ch_CustomerAddr_Validation;

	@FindBy(name = "Flags")
	private WebElement ch_FlagsButton;

	@FindBy(xpath = "//input[@value='Notes']")
	private WebElement ch_NotesButton;

	@FindBy(xpath = "//input[@value='Customer Summary View']")
	private WebElement ch_CustomerSummaryViewButton;

	@FindBy(xpath = "//input[@value='Notes']")
	private WebElement ch_GoButton;

	/*
	 * Page Elements Methods
	 */

	public void switchToFlagwindow() {
		if (wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			parentWindowId = it.next();
			childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			driver.close();
			driver.switchTo().window(parentWindowId);
		}

	}

	public String get_ch_PageHeader(String TestData_ch_PageHeader) {
		return doIT(ch_PageHeader, TestData_ch_PageHeader);
	}

	public boolean isDisplayed_ch_PageHeader() {
		return isDisplayed(ch_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_ch_SSN_ISIN_Validation(String TestData_ch_SSN_ISIN_Validation) {
		return doIT(ch_SSN_ISIN_Validation, TestData_ch_SSN_ISIN_Validation);
	}

	public boolean isDisplayed_ch_SSN_ISIN_Validation() {
		return isDisplayed(ch_SSN_ISIN_Validation);
	}

	// ****************************************************************************************************************************
	public String get_ch_CustomerStatus_Validation(String TestData_ch_CustomerStatus_Validation) {
		return doIT(ch_CustomerStatus_Validation, TestData_ch_CustomerStatus_Validation);
	}

	public boolean isDisplayed_ch_CustomerStatus_Validation() {
		return isDisplayed(ch_CustomerStatus_Validation);
	}

	// **********************************//******************************************************************************************
	public String get_ch_CustomerName_Validation(String TestData_ch_CustomerName_Validation) {
		return doIT(ch_CustomerName_Validation, TestData_ch_CustomerName_Validation);
	}

	public boolean isDisplayed_ch_CustomerName_Validation() {
		return isDisplayed(ch_CustomerName_Validation);
	}

	// **********************************//******************************************************************************************
	public String get_ch_CustomerAddr_Validation(String TestData_ch_CustomerAddr_Validation) {
		return doIT(ch_CustomerAddr_Validation, TestData_ch_CustomerAddr_Validation);
	}

	public boolean isDisplayed_ch_CustomerAddr_Validation() {
		return isDisplayed(ch_CustomerAddr_Validation);
	}

	// **********************************//******************************************************************************************
	public void click_ch_FlagsButton(String TestData_ch_FlagsButton) {
		doIT(ch_FlagsButton, TestData_ch_FlagsButton);
	}

	public boolean isDisplayed_ch_FlagsButton() {
		return isDisplayed(ch_FlagsButton);
	}

	// ****************************************************************************************************************************
	public void click_ch_NotesButton(String TestData_ch_NotesButton) {
		doIT(ch_NotesButton, TestData_ch_NotesButton);
	}

	public boolean isDisplayed_ch_NotesButton() {
		return isDisplayed(ch_NotesButton);
	}

	// ****************************************************************************************************************************
	public void click_ch_CustomerSummaryViewButton(String TestData_ch_CustomerSummaryViewButton) {
		doIT(ch_CustomerSummaryViewButton, TestData_ch_CustomerSummaryViewButton);
	}

	public boolean isDisplayed_ch_CustomerSummaryViewButton() {
		return isDisplayed(ch_CustomerSummaryViewButton);
	}

	public void click_GoButon(String TestData_ch_NotesButton) {
		doIT(ch_NotesButton, TestData_ch_NotesButton);
	}

}