package pageClasses.QFund;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Akula Srikanth Date = 10-April-2019
 */

public class Reports_DailySummaryReports_PO extends BasePage {

	public Reports_DailySummaryReports_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[@class='formHeading']")
	private WebElement dsr_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'EOD Summary')]")
	private WebElement dsr_EODSummary_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Daily Transaction Journal')]")
	private WebElement dsr_DailyTransactionJournal_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Store Cash Management')]")
	private WebElement dsr_StoreCashManagement_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Voided Transactions')]")
	private WebElement dsr_VoidedTransactions_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Store Cash Management Summary Report')]")
	private WebElement dsr_StoreCashManagementSummaryReport_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Cash Over/Short Report')]")
	private WebElement dsr_CashOverShortReport_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Cash Balance Transaction Report')]")
	private WebElement dsr_CashBalanceTransactionReport_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Daily Center Summary Report')]")
	private WebElement dsr_DailyCenterSummaryReport_PageHeader;

	@FindBy(xpath = "//input[contains(@name,'storeCode')]")
	private WebElement dsr_StoreNbr;

	@FindBy(name = "requestBean.transaction")
	private WebElement dtj_TransactionType;

	@FindBy(name = "beginMonth")
	private WebElement dsr_BeginMonth;

	@FindBy(name = "beginDay")
	private WebElement dsr_BeginDay;

	@FindBy(name = "beginYear")
	private WebElement dsr_BeginYear;

	@FindBy(name = "endMonth")
	private WebElement dsr_EndMonth;

	@FindBy(name = "endDay")
	private WebElement dsr_EndDay;

	@FindBy(name = "endYear")
	private WebElement dsr_EndYear;

	@FindBy(name = "btnPreview")
	private WebElement dsr_SubmitButton;

	@FindBy(name = "B2")
	private WebElement dsr_ResetButton;

	@FindBy(xpath = "//td[contains(text(),'End of Day has not been completed for the date entered. Report not available.')]")
	private WebElement Error_EODnotcompletedfortheday;

	@FindBy(xpath = "//font[@color='red']/ul")
	private WebElement Error_Page;

	@FindBy(xpath = "//b[contains(text(),'End of Day Summary')]")
	private WebElement eods_EndOfDaySummary_RecordsHeader;

	@FindBy(xpath = "//td[font[text()='Beginning Balance']]/following-sibling::td/font")
	private WebElement eods_Verify_BeginningBalance;

	@FindBy(xpath = "//td[font[text()='StartUpCheckAmount']]/following-sibling::td/font")
	private WebElement eods_Verify_StartUpCheckAmount;

	@FindBy(xpath = "//td[font[text()='Over/Short Amount']]/following-sibling::td/font")
	private WebElement eods_Verify_OverShortAmount;

	@FindBy(xpath = "//td[font[text()='Cash Amount']]/following-sibling::td[2]/font")
	private WebElement eods_SCD_Verify_CashAmount;

	@FindBy(xpath = "//td[font[text()='Check Amount']]/following-sibling::td[2]/font")
	private WebElement eods_SCD_Verify_CheckAmount;

	@FindBy(xpath = "//td[font[text()='CC/MO Amount']]/following-sibling::td[2]/font")
	private WebElement eods_SCD_Verify_CCMOMAmount;

	@FindBy(xpath = "//td[font[b[text()='Total EndOfDay Deposited Amount']]]/following-sibling::td[2]/font")
	private WebElement eods_SCD_Verify_TotEODAmount;

	@FindBy(xpath = "//td[font[contains(text(),'Count of Customer')]]/following-sibling::td/font")
	private WebElement eods_SCD_Verify_CountofCustomerChecks;

	@FindBy(xpath = "//td[font[contains(text(),'Count of CC/MO')]]/following-sibling::td/font")
	private WebElement eods_SCD_Verify_CountofCCMO;

	@FindBy(xpath = "//td[font[contains(text(),'Next Beginning Balance')]]/following-sibling::td/font")
	private WebElement eods_SCD_Verify_NextBeginningBalance;

	@FindBy(xpath = "//td[font[contains(text(),'Next Processing')]]/following-sibling::td/font")
	private WebElement eods_SCD_Verify_NextProcessing;

	@FindBy(xpath = "//td[font[b[contains(text(),'Total Deposited Amount')]]]/following-sibling::td/font")
	private WebElement eods_SCD_Verify_TotalDepositedAmount;

	@FindBy(xpath = "//td[contains(text(),'Daily Transaction Journal Report')]")
	private WebElement dtjr_DailyTransactionJournalReport_RecordsHeader;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[8]")
	private WebElement dtjr_Verify_TotalIssChkAmount;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[10]")
	private WebElement dtjr_Verify_TotalTranAmount;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[11]")
	private WebElement dtjr_Verify_TotalPrinAmount;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[12]")
	private WebElement dtjr_Verify_TotalFeeAmount;

	@FindBy(xpath = "//td[contains(text(),'Store Cash Management Report  on')]")
	private WebElement scm_StoreCashManagement_RecordsHeader;

	@FindBy(xpath = "//table//td[p[contains(text(),'Opening Balance of Cash in Safe')]]/following-sibling::td")
	private WebElement scm_Verify_SafeOpeningBal;

	@FindBy(xpath = "//table//td[p[contains(text(),'Safe Withdrawls from Bank')]]/following-sibling::td")
	private WebElement scm_Verify_SafeWithdrawlsBank;

	@FindBy(xpath = "//table//td[p[contains(text(),'Closing Balance of Cash in Safe on')]]/following-sibling::td")
	private WebElement scm_Verify_SafelosingOpeningBal;

	@FindBy(xpath = "//table//td[p[contains(text(),'Disbursements Made by Check')]]/following-sibling::td")
	private WebElement scm_Verify_DisbByCheck;

	@FindBy(xpath = "//table//td[p[contains(text(),'Total Loan Checks Deposited')]]/following-sibling::td")
	private WebElement scm_Verify_TotalLoanChecksDeposited;

	@FindBy(xpath = "//table//td[p[contains(text(),'Total CC Checks Deposited')]]/following-sibling::td")
	private WebElement scm_Verify_TotalCCChecksDeposited;

	@FindBy(xpath = "//td[contains(text(),'Voided Transactions Report')]")
	private WebElement vt_VoidedTransactions_RecordsHeader;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Tran Type')]]]/following-sibling::tr[2]/td[8])[1]")
	private WebElement vt_TransactiomType;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Customer Nbr')]]]/following-sibling::tr/td[p[text()='626818']])[1]")
	private WebElement vt_xpath_CustomerNbr;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Loan Nbr')]]]/following-sibling::tr/td[p[text()='310855']])[1]")
	private WebElement vt_xpath_LoanNbr;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[9]")
	private WebElement vt_Verify_TotalTranAmount;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[10]")
	private WebElement vt_Verify_TotalPrinAmount;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[11]")
	private WebElement vt_Verify_TotalFeeAmount;

	@FindBy(xpath = "//table//td[p[text()='Store Cash Management Summary Report']]')]")
	private WebElement scms_StoreCashManagementSummaryReport_RecordsHeader;

	@FindBy(xpath = "//table//td[@class='address']/p[contains(text(),'For Store')]")
	private WebElement scms_Verify_StoreNbr;

	@FindBy(xpath = "//table//tr[td[a[contains(text(),'Opening Balance')]]]/following-sibling::tr[2]/td[2]")
	private WebElement scms_Verify_OpeningBalance;

	@FindBy(xpath = "//table//tr[td[a[contains(text(),'Quarter Coins')]]]/following-sibling::tr[2]/td[31]")
	private WebElement scms_Verify_QuarterCoins;

	@FindBy(xpath = "//table//tr[td[a[contains(text(),'Penny')]]]/following-sibling::tr[2]/td[34]")
	private WebElement scms_Verify_Penny;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[2]")
	private WebElement scms_Verify_TotOpeningBalance;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[31]")
	private WebElement scms_Verify_TotQuarterCoins;

	@FindBy(xpath = "//table//tr[td/p[contains(text(),'Total') and contains(text(),'Record')]]/td[34]")
	private WebElement scms_Verify_TotPenny;

	@FindBy(xpath = "//table//td[p[text()='Cash Over/Short Report']]")
	private WebElement cos_CashOverShortReport_RecordsHeader;

	@FindBy(xpath = "(//table//td[@class='address']/p[contains(text(),'For Store : ')])[1]")
	private WebElement cos_Verify_StoreNbr;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Tran Type')]]]/following-sibling::tr[2]/td[3])[1]")
	private WebElement cos_Verify_TranType;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Over/Short Amt')]]]/following-sibling::tr[2]/td[4])[1]")
	private WebElement cos_Verify_OverShortAmt;

	@FindBy(xpath = "(//table//tr[td[a[contains(text(),'Emp Name')]]]/following-sibling::tr[2]/td[6])[1]")
	private WebElement cos_Verify_EmpName;

	@FindBy(xpath = "//table//td[p[text()='Cash Balance Transaction Report']]")
	private WebElement cbt_CashBalanceTransactionReport_RecordsHeader;

	@FindBy(xpath = "(//table//td[@class='address']/p[contains(text(),'For Store')])[1]")
	private WebElement cbt_Verify_StoreNbr;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Emp Nbr')]]]//following-sibling::tr[2]/td[4])[1]")
	private WebElement cbt_Verify_EmpNbr;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Emp Name')]]]//following-sibling::tr[2]/td[5])[1]")
	private WebElement cbt_Verify_EmpName;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Counted Cash Balance')]]]//following-sibling::tr[2]/td[6])[1]")
	private WebElement cbt_Verify_CountCashBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Counted CC/MO Balance')]]]//following-sibling::tr[2]/td[7])[1]")
	private WebElement cbt_Verify_CountCCMOBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Counted Check Balance')]]]//following-sibling::tr[2]/td[8])[1]")
	private WebElement cbt_Verify_CountCheckBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Calculated Cash Balance')]]]//following-sibling::tr[2]/td[9])[1]")
	private WebElement cbt_Verify_CalCashBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Calculated CC/MO Balance')]]]//following-sibling::tr[2]/td[10])[1]")
	private WebElement cbt_Verify_CalCCMOBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Calculated Check Balance')]]]//following-sibling::tr[2]/td[11])[1]")
	private WebElement cbt_Verify_CalCheckBal;

	@FindBy(xpath = "(//table//tr[td[a[@class='titlesmall' and contains(text(),'Over/Short Amt')]]]//following-sibling::tr[2]/td[12])[1]")
	private WebElement cbt_Verify_OverShortAmt;

	@FindBy(xpath = "//table//td[p[text()='Daily Center Summary Report']]")
	private WebElement dcsr_DailyCenterSummaryReport_RecordsHeader;

	@FindBy(xpath = ".//input[@value='Print']")
	private WebElement eods_PrintButton;

	@FindBy(xpath = ".//input[@value='Generate Excel']")
	private WebElement eods_GenerateExcelButton;

	public void set_BeginDate(String strdate) {
		if (!strdate.isEmpty()) {
			String[] s_Date = strdate.split("/", -2);
			dsr_BeginYear.clear();
			doIT(dsr_BeginMonth, s_Date[0]);
			doIT(dsr_BeginDay, s_Date[1]);
			doIT(dsr_BeginYear, s_Date[2]);
		}
	}

	public void set_EndDate(String strdate) {
		if (!strdate.isEmpty()) {
			String[] s_Date = strdate.split("/", -2);
			dsr_EndYear.clear();
			doIT(dsr_EndMonth, s_Date[0]);
			doIT(dsr_EndDay, s_Date[1]);
			doIT(dsr_EndYear, s_Date[2]);
		}
	}

	public String get_BuildXpath_CustNbr(String data) {
		String xpath_Text = "//table//td[@class='rptdata' and p[text()='" + data + "']]";
		return xpath_Text;
	}

	public String get_WebElementCustNbr(String data) {
		String xpath_Text = get_BuildXpath_CustNbr(data);
		WebElement CustNbr = get_WebElement_XpatByDynamicXpath(xpath_Text);
		return doIT(CustNbr, "get");
	}

	public String get_WebElement_DynamicValueXpath_CustNbr(String data) {
		String xpath_Text = "//table//td[@class='rptdata' and p[text()='" + data + "']]";
		WebElement WebElement_DynamicValueXpath = driver.findElement(By.xpath(xpath_Text));
		return doIT(WebElement_DynamicValueXpath, "get");
	}

	public WebElement get_WebElement_XpatByDynamicXpath(String xpath_Text) {
		WebElement WebElement_DynamicXpath = driver.findElement(By.xpath(xpath_Text));
		return WebElement_DynamicXpath;
	}

	public String get_dsr_ReportRecordsHeader(String ReportType) {

		switch (ReportType) {
		case "EODSummary":
			return get_eods_EndOfDaySummary_RecordsHeader(ReportType);
		case "DailyTransactionJournalReport":
			return get_dtjr_DailyTransactionJournalReport_RecordsHeader(ReportType);
		case "StoreCashManagement":
			return get_scm_StoreCashManagement_RecordsHeader(ReportType);
		case "VoidedTransactions":
			return get_vt_VoidedTransactions_RecordsHeader(ReportType);
		case "StoreCashManagementSummaryReport":
			return get_scms_StoreCashManagementSummaryReport_RecordsHeader(ReportType);
		case "CashOverShortReport":
			return get_cos_CashOverShortReport_RecordsHeader(ReportType);
		case "CashBalanceTransactionReport":
			return get_cbt_CashBalanceTransactionReport_RecordsHeader(ReportType);
		case "DailyCenterSummaryReport":
			return get_dcsr_DailyCenterSummaryReport_RecordsHeader(ReportType);
		}
		return ReportType;

	}

	// ****************************************************************************************************************************
	// Getter and Setter Begin
	// ****************************************************************************************************************************
	public String get_dsr_PageHeader(String TestData_dsr_PageHeader) {
		if (!TestData_dsr_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dsr_PageHeader));
		}
		return doIT(dsr_PageHeader, TestData_dsr_PageHeader);
	}

	public boolean isDisplayed_dsr_PageHeader() {
		return isDisplayed(dsr_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_EODSummary_PageHeader(String TestData_dsr_EODSummary_PageHeader) {
		if (!TestData_dsr_EODSummary_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dsr_EODSummary_PageHeader));
		}
		return doIT(dsr_EODSummary_PageHeader, TestData_dsr_EODSummary_PageHeader);
	}

	public boolean isDisplayed_dsr_EODSummary_PageHeader() {
		return isDisplayed(dsr_EODSummary_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_DailyTransactionJournal_PageHeader(String TestData_dsr_DailyTransactionJournal_PageHeader) {
		if (!TestData_dsr_DailyTransactionJournal_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_DailyTransactionJournal_PageHeader));
		}
		return doIT(dsr_DailyTransactionJournal_PageHeader, TestData_dsr_DailyTransactionJournal_PageHeader);
	}

	public boolean isDisplayed_dsr_DailyTransactionJournal_PageHeader() {
		return isDisplayed(dsr_DailyTransactionJournal_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_StoreCashManagement_PageHeader(String TestData_dsr_StoreCashManagement_PageHeader) {
		if (!TestData_dsr_StoreCashManagement_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_StoreCashManagement_PageHeader));
		}
		return doIT(dsr_StoreCashManagement_PageHeader, TestData_dsr_StoreCashManagement_PageHeader);
	}

	public boolean isDisplayed_dsr_StoreCashManagement_PageHeader() {
		return isDisplayed(dsr_StoreCashManagement_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_VoidedTransactions_PageHeader(String TestData_dsr_VoidedTransactions_PageHeader) {
		if (!TestData_dsr_VoidedTransactions_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_VoidedTransactions_PageHeader));
		}
		return doIT(dsr_VoidedTransactions_PageHeader, TestData_dsr_VoidedTransactions_PageHeader);
	}

	public boolean isDisplayed_dsr_VoidedTransactions_PageHeader() {
		return isDisplayed(dsr_VoidedTransactions_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_StoreCashManagementSummaryReport_PageHeader(
			String TestData_dsr_StoreCashManagementSummaryReport_PageHeader) {
		if (!TestData_dsr_StoreCashManagementSummaryReport_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_StoreCashManagementSummaryReport_PageHeader));
		}
		return doIT(dsr_StoreCashManagementSummaryReport_PageHeader,
				TestData_dsr_StoreCashManagementSummaryReport_PageHeader);
	}

	public boolean isDisplayed_dsr_StoreCashManagementSummaryReport_PageHeader() {
		return isDisplayed(dsr_StoreCashManagementSummaryReport_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_CashOverShortReport_PageHeader(String TestData_dsr_CashOverShortReport_PageHeader) {
		if (!TestData_dsr_CashOverShortReport_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_CashOverShortReport_PageHeader));
		}
		return doIT(dsr_CashOverShortReport_PageHeader, TestData_dsr_CashOverShortReport_PageHeader);
	}

	public boolean isDisplayed_dsr_CashOverShortReport_PageHeader() {
		return isDisplayed(dsr_CashOverShortReport_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_CashBalanceTransactionReport_PageHeader(
			String TestData_dsr_CashBalanceTransactionReport_PageHeader) {
		if (!TestData_dsr_CashBalanceTransactionReport_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_CashBalanceTransactionReport_PageHeader));
		}
		return doIT(dsr_CashBalanceTransactionReport_PageHeader, TestData_dsr_CashBalanceTransactionReport_PageHeader);
	}

	public boolean isDisplayed_dsr_CashBalanceTransactionReport_PageHeader() {
		return isDisplayed(dsr_CashBalanceTransactionReport_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_dsr_DailyCenterSummaryReport_PageHeader(String TestData_dsr_DailyCenterSummaryReport_PageHeader) {
		if (!TestData_dsr_DailyCenterSummaryReport_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dsr_DailyCenterSummaryReport_PageHeader));
		}
		return doIT(dsr_DailyCenterSummaryReport_PageHeader, TestData_dsr_DailyCenterSummaryReport_PageHeader);
	}

	public boolean isDisplayed_dsr_DailyCenterSummaryReport_PageHeader() {
		return isDisplayed(dsr_DailyCenterSummaryReport_PageHeader);
	}

	// ****************************************************************************************************************************
	public void set_dsr_StoreNbr(String TestData_dsr_StoreNbr) {
		doIT(dsr_StoreNbr, TestData_dsr_StoreNbr);
	}

	public boolean isDisplayed_dsr_StoreNbr() {
		return isDisplayed(dsr_StoreNbr);
	}

	// ****************************************************************************************************************************
	public void set_dtj_TransactionType(String TestData_dtj_TransactionType) {
		doIT(dtj_TransactionType, TestData_dtj_TransactionType);
	}

	public boolean isDisplayed_dtj_TransactionType() {
		return isDisplayed(dtj_TransactionType);
	}

	// ****************************************************************************************************************************
	public void set_dsr_BeginMonth(String TestData_dsr_BeginMonth) {
		doIT(dsr_BeginMonth, TestData_dsr_BeginMonth);
	}

	public boolean isDisplayed_dsr_BeginMonth() {
		return isDisplayed(dsr_BeginMonth);
	}

	// ****************************************************************************************************************************
	public void set_dsr_BeginDay(String TestData_dsr_BeginDay) {
		doIT(dsr_BeginDay, TestData_dsr_BeginDay);
	}

	public boolean isDisplayed_dsr_BeginDay() {
		return isDisplayed(dsr_BeginDay);
	}

	// ****************************************************************************************************************************
	public void set_dsr_BeginYear(String TestData_dsr_BeginYear) {
		doIT(dsr_BeginYear, TestData_dsr_BeginYear);
	}

	public boolean isDisplayed_dsr_BeginYear() {
		return isDisplayed(dsr_BeginYear);
	}

	// ****************************************************************************************************************************
	public void set_dsr_EndMonth(String TestData_dsr_EndMonth) {
		doIT(dsr_EndMonth, TestData_dsr_EndMonth);
	}

	public boolean isDisplayed_dsr_EndMonth() {
		return isDisplayed(dsr_EndMonth);
	}

	// ****************************************************************************************************************************
	public void set_dsr_EndDay(String TestData_dsr_EndDay) {
		doIT(dsr_EndDay, TestData_dsr_EndDay);
	}

	public boolean isDisplayed_dsr_EndDay() {
		return isDisplayed(dsr_EndDay);
	}

	// ****************************************************************************************************************************
	public void set_dsr_EndYear(String TestData_dsr_EndYear) {
		doIT(dsr_EndYear, TestData_dsr_EndYear);
	}

	public boolean isDisplayed_dsr_EndYear() {
		return isDisplayed(dsr_EndYear);
	}

	// ****************************************************************************************************************************
	public void click_dsr_SubmitButton(String TestData_dsr_SubmitButton) {
		doIT(dsr_SubmitButton, TestData_dsr_SubmitButton);
	}

	public boolean isDisplayed_dsr_SubmitButton() {
		return isDisplayed(dsr_SubmitButton);
	}

	// ****************************************************************************************************************************
	public void click_dsr_ResetButton(String TestData_dsr_ResetButton) {
		doIT(dsr_ResetButton, TestData_dsr_ResetButton);
	}

	public boolean isDisplayed_dsr_ResetButton() {
		return isDisplayed(dsr_ResetButton);
	}

	// ****************************************************************************************************************************
	public String get_Error_EODnotcompletedfortheday(String TestData_Error_EODnotcompletedfortheday) {
		if (!TestData_Error_EODnotcompletedfortheday.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(Error_EODnotcompletedfortheday));
		}
		return doIT(Error_EODnotcompletedfortheday, TestData_Error_EODnotcompletedfortheday);
	}

	public boolean isDisplayed_Error_EODnotcompletedfortheday() {
		return isDisplayed(Error_EODnotcompletedfortheday);
	}

	// ****************************************************************************************************************************
	public String get_Error_Page(String TestData_Error_Page) {
		if (!TestData_Error_Page.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Error_Page));
		}
		return doIT(Error_Page, TestData_Error_Page);
	}

	public boolean isDisplayed_Error_Page() {
		return isDisplayed(Error_Page);
	}

	// ****************************************************************************************************************************
	public String get_eods_EndOfDaySummary_RecordsHeader(String TestData_eods_EndOfDaySummary_RecordsHeader) {
		if (!TestData_eods_EndOfDaySummary_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(eods_EndOfDaySummary_RecordsHeader));
		}
		return doIT(eods_EndOfDaySummary_RecordsHeader, TestData_eods_EndOfDaySummary_RecordsHeader);
	}

	public boolean isDisplayed_eods_EndOfDaySummary_RecordsHeader() {
		return isDisplayed(eods_EndOfDaySummary_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_eods_Verify_BeginningBalance(String TestData_eods_Verify_BeginningBalance) {
		if (!TestData_eods_Verify_BeginningBalance.isEmpty()) {
		}
		return doIT(eods_Verify_BeginningBalance, TestData_eods_Verify_BeginningBalance);
	}

	public boolean isDisplayed_eods_Verify_BeginningBalance() {
		return isDisplayed(eods_Verify_BeginningBalance);
	}

	// ****************************************************************************************************************************
	public String get_eods_Verify_StartUpCheckAmount(String TestData_eods_Verify_StartUpCheckAmount) {
		if (!TestData_eods_Verify_StartUpCheckAmount.isEmpty()) {
		}
		return doIT(eods_Verify_StartUpCheckAmount, TestData_eods_Verify_StartUpCheckAmount);
	}

	public boolean isDisplayed_eods_Verify_StartUpCheckAmount() {
		return isDisplayed(eods_Verify_StartUpCheckAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_Verify_OverShortAmount(String TestData_eods_Verify_OverShortAmount) {
		if (!TestData_eods_Verify_OverShortAmount.isEmpty()) {
		}
		return doIT(eods_Verify_OverShortAmount, TestData_eods_Verify_OverShortAmount);
	}

	public boolean isDisplayed_eods_Verify_OverShortAmount() {
		return isDisplayed(eods_Verify_OverShortAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_CashAmount(String TestData_eods_SCD_Verify_CashAmount) {
		if (!TestData_eods_SCD_Verify_CashAmount.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_CashAmount, TestData_eods_SCD_Verify_CashAmount);
	}

	public boolean isDisplayed_eods_SCD_Verify_CashAmount() {
		return isDisplayed(eods_SCD_Verify_CashAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_CheckAmount(String TestData_eods_SCD_Verify_CheckAmount) {
		if (!TestData_eods_SCD_Verify_CheckAmount.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_CheckAmount, TestData_eods_SCD_Verify_CheckAmount);
	}

	public boolean isDisplayed_eods_SCD_Verify_CheckAmount() {
		return isDisplayed(eods_SCD_Verify_CheckAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_CCMOMAmount(String TestData_eods_SCD_Verify_CCMOMAmount) {
		if (!TestData_eods_SCD_Verify_CCMOMAmount.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_CCMOMAmount, TestData_eods_SCD_Verify_CCMOMAmount);
	}

	public boolean isDisplayed_eods_SCD_Verify_CCMOMAmount() {
		return isDisplayed(eods_SCD_Verify_CCMOMAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_TotEODAmount(String TestData_eods_SCD_Verify_TotEODAmount) {
		if (!TestData_eods_SCD_Verify_TotEODAmount.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_TotEODAmount, TestData_eods_SCD_Verify_TotEODAmount);
	}

	public boolean isDisplayed_eods_SCD_Verify_TotEODAmount() {
		return isDisplayed(eods_SCD_Verify_TotEODAmount);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_CountofCustomerChecks(String TestData_eods_SCD_Verify_CountofCustomerChecks) {
		if (!TestData_eods_SCD_Verify_CountofCustomerChecks.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_CountofCustomerChecks, TestData_eods_SCD_Verify_CountofCustomerChecks);
	}

	public boolean isDisplayed_eods_SCD_Verify_CountofCustomerChecks() {
		return isDisplayed(eods_SCD_Verify_CountofCustomerChecks);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_CountofCCMO(String TestData_eods_SCD_Verify_CountofCCMO) {
		if (!TestData_eods_SCD_Verify_CountofCCMO.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_CountofCCMO, TestData_eods_SCD_Verify_CountofCCMO);
	}

	public boolean isDisplayed_eods_SCD_Verify_CountofCCMO() {
		return isDisplayed(eods_SCD_Verify_CountofCCMO);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_NextBeginningBalance(String TestData_eods_SCD_Verify_NextBeginningBalance) {
		if (!TestData_eods_SCD_Verify_NextBeginningBalance.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_NextBeginningBalance, TestData_eods_SCD_Verify_NextBeginningBalance);
	}

	public boolean isDisplayed_eods_SCD_Verify_NextBeginningBalance() {
		return isDisplayed(eods_SCD_Verify_NextBeginningBalance);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_NextProcessing(String TestData_eods_SCD_Verify_NextProcessing) {
		if (!TestData_eods_SCD_Verify_NextProcessing.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_NextProcessing, TestData_eods_SCD_Verify_NextProcessing);
	}

	public boolean isDisplayed_eods_SCD_Verify_NextProcessing() {
		return isDisplayed(eods_SCD_Verify_NextProcessing);
	}

	// ****************************************************************************************************************************
	public String get_eods_SCD_Verify_TotalDepositedAmount(String TestData_eods_SCD_Verify_TotalDepositedAmount) {
		if (!TestData_eods_SCD_Verify_TotalDepositedAmount.isEmpty()) {
		}
		return doIT(eods_SCD_Verify_TotalDepositedAmount, TestData_eods_SCD_Verify_TotalDepositedAmount);
	}

	public boolean isDisplayed_eods_SCD_Verify_TotalDepositedAmount() {
		return isDisplayed(eods_SCD_Verify_TotalDepositedAmount);
	}

	// ****************************************************************************************************************************
	public String get_dtjr_DailyTransactionJournalReport_RecordsHeader(
			String TestData_dtjr_DailyTransactionJournalReport_RecordsHeader) {
		if (!TestData_dtjr_DailyTransactionJournalReport_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dtjr_DailyTransactionJournalReport_RecordsHeader));
		}
		return doIT(dtjr_DailyTransactionJournalReport_RecordsHeader,
				TestData_dtjr_DailyTransactionJournalReport_RecordsHeader);
	}

	public boolean isDisplayed_dtjr_DailyTransactionJournalReport_RecordsHeader() {
		return isDisplayed(dtjr_DailyTransactionJournalReport_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_dtjr_Verify_TotalIssChkAmount(String TestData_dtjr_Verify_TotalIssChkAmount) {
		if (!TestData_dtjr_Verify_TotalIssChkAmount.isEmpty()) {
		}
		return doIT(dtjr_Verify_TotalIssChkAmount, TestData_dtjr_Verify_TotalIssChkAmount);
	}

	public boolean isDisplayed_dtjr_Verify_TotalIssChkAmount() {
		return isDisplayed(dtjr_Verify_TotalIssChkAmount);
	}

	// ****************************************************************************************************************************
	public String get_dtjr_Verify_TotalTranAmount(String TestData_dtjr_Verify_TotalTranAmount) {
		if (!TestData_dtjr_Verify_TotalTranAmount.isEmpty()) {
		}
		return doIT(dtjr_Verify_TotalTranAmount, TestData_dtjr_Verify_TotalTranAmount);
	}

	public boolean isDisplayed_dtjr_Verify_TotalTranAmount() {
		return isDisplayed(dtjr_Verify_TotalTranAmount);
	}

	// ****************************************************************************************************************************
	public String get_dtjr_Verify_TotalPrinAmount(String TestData_dtjr_Verify_TotalPrinAmount) {
		if (!TestData_dtjr_Verify_TotalPrinAmount.isEmpty()) {
		}
		return doIT(dtjr_Verify_TotalPrinAmount, TestData_dtjr_Verify_TotalPrinAmount);
	}

	public boolean isDisplayed_dtjr_Verify_TotalPrinAmount() {
		return isDisplayed(dtjr_Verify_TotalPrinAmount);
	}

	// ****************************************************************************************************************************
	public String get_dtjr_Verify_TotalFeeAmount(String TestData_dtjr_Verify_TotalFeeAmount) {
		if (!TestData_dtjr_Verify_TotalFeeAmount.isEmpty()) {
		}
		return doIT(dtjr_Verify_TotalFeeAmount, TestData_dtjr_Verify_TotalFeeAmount);
	}

	public boolean isDisplayed_dtjr_Verify_TotalFeeAmount() {
		return isDisplayed(dtjr_Verify_TotalFeeAmount);
	}

	// ****************************************************************************************************************************
	public String get_scm_StoreCashManagement_RecordsHeader(String TestData_scm_StoreCashManagement_RecordsHeader) {
		if (!TestData_scm_StoreCashManagement_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(scm_StoreCashManagement_RecordsHeader));
		}
		return doIT(scm_StoreCashManagement_RecordsHeader, TestData_scm_StoreCashManagement_RecordsHeader);
	}

	public boolean isDisplayed_scm_StoreCashManagement_RecordsHeader() {
		return isDisplayed(scm_StoreCashManagement_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_SafeOpeningBal(String TestData_scm_Verify_SafeOpeningBal) {
		if (!TestData_scm_Verify_SafeOpeningBal.isEmpty()) {
		}
		return doIT(scm_Verify_SafeOpeningBal, TestData_scm_Verify_SafeOpeningBal);
	}

	public boolean isDisplayed_scm_Verify_SafeOpeningBal() {
		return isDisplayed(scm_Verify_SafeOpeningBal);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_SafeWithdrawlsBank(String TestData_scm_Verify_SafeWithdrawlsBank) {
		if (!TestData_scm_Verify_SafeWithdrawlsBank.isEmpty()) {
		}
		return doIT(scm_Verify_SafeWithdrawlsBank, TestData_scm_Verify_SafeWithdrawlsBank);
	}

	public boolean isDisplayed_scm_Verify_SafeWithdrawlsBank() {
		return isDisplayed(scm_Verify_SafeWithdrawlsBank);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_SafelosingOpeningBal(String TestData_scm_Verify_SafelosingOpeningBal) {
		if (!TestData_scm_Verify_SafelosingOpeningBal.isEmpty()) {
		}
		return doIT(scm_Verify_SafelosingOpeningBal, TestData_scm_Verify_SafelosingOpeningBal);
	}

	public boolean isDisplayed_scm_Verify_SafelosingOpeningBal() {
		return isDisplayed(scm_Verify_SafelosingOpeningBal);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_DisbByCheck(String TestData_scm_Verify_DisbByCheck) {
		if (!TestData_scm_Verify_DisbByCheck.isEmpty()) {
		}
		return doIT(scm_Verify_DisbByCheck, TestData_scm_Verify_DisbByCheck);
	}

	public boolean isDisplayed_scm_Verify_DisbByCheck() {
		return isDisplayed(scm_Verify_DisbByCheck);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_TotalLoanChecksDeposited(String TestData_scm_Verify_TotalLoanChecksDeposited) {
		if (!TestData_scm_Verify_TotalLoanChecksDeposited.isEmpty()) {
		}
		return doIT(scm_Verify_TotalLoanChecksDeposited, TestData_scm_Verify_TotalLoanChecksDeposited);
	}

	public boolean isDisplayed_scm_Verify_TotalLoanChecksDeposited() {
		return isDisplayed(scm_Verify_TotalLoanChecksDeposited);
	}

	// ****************************************************************************************************************************
	public String get_scm_Verify_TotalCCChecksDeposited(String TestData_scm_Verify_TotalCCChecksDeposited) {
		if (!TestData_scm_Verify_TotalCCChecksDeposited.isEmpty()) {
		}
		return doIT(scm_Verify_TotalCCChecksDeposited, TestData_scm_Verify_TotalCCChecksDeposited);
	}

	public boolean isDisplayed_scm_Verify_TotalCCChecksDeposited() {
		return isDisplayed(scm_Verify_TotalCCChecksDeposited);
	}

	// ****************************************************************************************************************************
	public String get_vt_VoidedTransactions_RecordsHeader(String TestData_vt_VoidedTransactions_RecordsHeader) {
		if (!TestData_vt_VoidedTransactions_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(vt_VoidedTransactions_RecordsHeader));
		}
		return doIT(vt_VoidedTransactions_RecordsHeader, TestData_vt_VoidedTransactions_RecordsHeader);
	}

	public boolean isDisplayed_vt_VoidedTransactions_RecordsHeader() {
		return isDisplayed(vt_VoidedTransactions_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public void set_vt_TransactiomType(String TestData_vt_TransactiomType) {
		doIT(vt_TransactiomType, TestData_vt_TransactiomType);
	}

	public boolean isDisplayed_vt_TransactiomType() {
		return isDisplayed(vt_TransactiomType);
	}

	// ****************************************************************************************************************************
	public String get_WebElement_DynamicValueXpath_vt_xpath_CustomerNbr(String TestData_vt_xpath_CustomerNbr) {
		if (!TestData_vt_xpath_CustomerNbr.isEmpty()) {
			String xpath_Text = "(//table//tr[td[a[contains(text(),'Customer Nbr')]]]/following-sibling::tr/td[p[text()='"
					+ TestData_vt_xpath_CustomerNbr + "']])[1]";

			WebElement WebElement_DynamicValueXpath_CustomerNbr = driver.findElement(By.xpath(xpath_Text));
			vt_xpath_CustomerNbr = WebElement_DynamicValueXpath_CustomerNbr;
		}
		return doIT(vt_xpath_CustomerNbr, TestData_vt_xpath_CustomerNbr);

	}

	public boolean isDisplayed_vt_xpath_CustomerNbr() {
		return isDisplayed(vt_xpath_CustomerNbr);
	}

	// ****************************************************************************************************************************
	public String get_WebElement_DynamicValueXpath_vt_xpath_LoanNbr(String TestData_vt_xpath_LoanNbr) {
		if (!TestData_vt_xpath_LoanNbr.isEmpty()) {
			String xpath_Text = "(//table//tr[td[a[contains(text(),'Loan Nbr')]]]/following-sibling::tr/td[p[text()='"
					+ TestData_vt_xpath_LoanNbr + "']])[1]";
			WebElement WebElement_DynamicValueXpath_LoanNbr = driver.findElement(By.xpath(xpath_Text));
			vt_xpath_LoanNbr = WebElement_DynamicValueXpath_LoanNbr;

		}
		return doIT(vt_xpath_LoanNbr, TestData_vt_xpath_LoanNbr);

	}

	public boolean isDisplayed_vt_xpath_LoanNbr() {
		return isDisplayed(vt_xpath_LoanNbr);
	}

	// ****************************************************************************************************************************
	public String get_vt_Verify_TotalTranAmount(String TestData_vt_Verify_TotalTranAmount) {
		if (!TestData_vt_Verify_TotalTranAmount.isEmpty()) {
		}
		return doIT(vt_Verify_TotalTranAmount, TestData_vt_Verify_TotalTranAmount);
	}

	public boolean isDisplayed_vt_Verify_TotalTranAmount() {
		return isDisplayed(vt_Verify_TotalTranAmount);
	}

	// ****************************************************************************************************************************
	public String get_vt_Verify_TotalPrinAmount(String TestData_vt_Verify_TotalPrinAmount) {
		if (!TestData_vt_Verify_TotalPrinAmount.isEmpty()) {
		}
		return doIT(vt_Verify_TotalPrinAmount, TestData_vt_Verify_TotalPrinAmount);
	}

	public boolean isDisplayed_vt_Verify_TotalPrinAmount() {
		return isDisplayed(vt_Verify_TotalPrinAmount);
	}

	// ****************************************************************************************************************************
	public String get_vt_Verify_TotalFeeAmount(String TestData_vt_Verify_TotalFeeAmount) {
		if (!TestData_vt_Verify_TotalFeeAmount.isEmpty()) {
		}
		return doIT(vt_Verify_TotalFeeAmount, TestData_vt_Verify_TotalFeeAmount);
	}

	public boolean isDisplayed_vt_Verify_TotalFeeAmount() {
		return isDisplayed(vt_Verify_TotalFeeAmount);
	}

	// ****************************************************************************************************************************
	public void click_eods_PrintButton(String TestData_eods_PrintButton) {
		doIT(eods_PrintButton, TestData_eods_PrintButton);
	}

	public boolean isDisplayed_eods_PrintButton() {
		return isDisplayed(eods_PrintButton);
	}

	// ****************************************************************************************************************************
	public void click_eods_GenerateExcelButton(String TestData_eods_GenerateExcelButton) {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.elementToBeClickable(eods_GenerateExcelButton));
		
		doIT(eods_GenerateExcelButton, TestData_eods_GenerateExcelButton);
//		
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", eods_GenerateExcelButton);

	}

	public boolean isDisplayed_eods_GenerateExcelButton() {
		return isDisplayed(eods_GenerateExcelButton);
	}
	// ****************************************************************************************************************************
	public String get_scms_StoreCashManagementSummaryReport_RecordsHeader(
			String TestData_scms_StoreCashManagementSummaryReport_RecordsHeader) {
		if (!TestData_scms_StoreCashManagementSummaryReport_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(
					ExpectedConditions.elementToBeClickable(scms_StoreCashManagementSummaryReport_RecordsHeader));
		}
		return doIT(scms_StoreCashManagementSummaryReport_RecordsHeader,
				TestData_scms_StoreCashManagementSummaryReport_RecordsHeader);
	}

	public boolean isDisplayed_scms_StoreCashManagementSummaryReport_RecordsHeader() {
		return isDisplayed(scms_StoreCashManagementSummaryReport_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_StoreNbr(String TestData_scms_Verify_StoreNbr) {
/*		if (!TestData_scms_Verify_StoreNbr.isEmpty()) {
			String xpath_Text = "//table//tr[td[a[contains(text(),'Store Nbr')]]]/following-sibling::tr/td[p[text()='+ TestData_scms_Verify_StoreNbr +']]";

			WebElement WebElement_DynamicValueXpath_StoreNbr = driver.findElement(By.xpath(xpath_Text));
			scms_Verify_StoreNbr = WebElement_DynamicValueXpath_StoreNbr;
			

		}*/
		return doIT(scms_Verify_StoreNbr, TestData_scms_Verify_StoreNbr);

	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_OpeningBalance(String TestData_scms_Verify_OpeningBalance) {
		return doIT(scms_Verify_OpeningBalance, TestData_scms_Verify_OpeningBalance);
	}

	public boolean isDisplayed_scms_Verify_OpeningBalance() {
		return isDisplayed(scms_Verify_OpeningBalance);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_QuarterCoins(String TestData_scms_Verify_QuarterCoins) {
		return doIT(scms_Verify_QuarterCoins, TestData_scms_Verify_QuarterCoins);
	}

	public boolean isDisplayed_scms_Verify_QuarterCoins() {
		return isDisplayed(scms_Verify_QuarterCoins);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_Penny(String TestData_scms_Verify_Penny) {
		return doIT(scms_Verify_Penny, TestData_scms_Verify_Penny);
	}

	public boolean isDisplayed_scms_Verify_Penny() {
		return isDisplayed(scms_Verify_Penny);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_TotOpeningBalance(String TestData_scms_Verify_TotOpeningBalance) {
		return doIT(scms_Verify_TotOpeningBalance, TestData_scms_Verify_TotOpeningBalance);
	}

	public boolean isDisplayed_scms_Verify_TotOpeningBalance() {
		return isDisplayed(scms_Verify_TotOpeningBalance);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_TotQuarterCoins(String TestData_scms_Verify_TotQuarterCoins) {
		return doIT(scms_Verify_TotQuarterCoins, TestData_scms_Verify_TotQuarterCoins);
	}

	public boolean isDisplayed_scms_Verify_TotQuarterCoins() {
		return isDisplayed(scms_Verify_TotQuarterCoins);
	}

	// ****************************************************************************************************************************
	public String get_scms_Verify_TotPenny(String TestData_scms_Verify_TotPenny) {
		return doIT(scms_Verify_TotPenny, TestData_scms_Verify_TotPenny);
	}

	public boolean isDisplayed_scms_Verify_TotPenny() {
		return isDisplayed(scms_Verify_TotPenny);
	}

	// ****************************************************************************************************************************
	public String get_cos_CashOverShortReport_RecordsHeader(String TestData_cos_CashOverShortReport_RecordsHeader) {
		if (!TestData_cos_CashOverShortReport_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(cos_CashOverShortReport_RecordsHeader));
		}
		return doIT(cos_CashOverShortReport_RecordsHeader, TestData_cos_CashOverShortReport_RecordsHeader);
	}

	public boolean isDisplayed_cos_CashOverShortReport_RecordsHeader() {
		return isDisplayed(cos_CashOverShortReport_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_cos_Verify_StoreNbr(String TestData_cos_Verify_StoreNbr) {
		return doIT(cos_Verify_StoreNbr, TestData_cos_Verify_StoreNbr);
	}

	public boolean isDisplayed_cos_Verify_StoreNbr() {
		return isDisplayed(cos_Verify_StoreNbr);
	}

	// ****************************************************************************************************************************
	public String get_cos_Verify_TranType(String TestData_cos_Verify_TranType) {
		return doIT(cos_Verify_TranType, TestData_cos_Verify_TranType);
	}

	public boolean isDisplayed_cos_Verify_TranType() {
		return isDisplayed(cos_Verify_TranType);
	}

	// ****************************************************************************************************************************
	public String get_cos_Verify_OverShortAmt(String TestData_cos_Verify_OverShortAmt) {
		return doIT(cos_Verify_OverShortAmt, TestData_cos_Verify_OverShortAmt);
	}

	public boolean isDisplayed_cos_Verify_OverShortAmt() {
		return isDisplayed(cos_Verify_OverShortAmt);
	}

	// ****************************************************************************************************************************
	public String get_cos_Verify_EmpName(String TestData_cos_Verify_EmpName) {
		return doIT(cos_Verify_EmpName, TestData_cos_Verify_EmpName);
	}

	public boolean isDisplayed_cos_Verify_EmpName() {
		return isDisplayed(cos_Verify_EmpName);
	}

	// ****************************************************************************************************************************
	public String get_cbt_CashBalanceTransactionReport_RecordsHeader(
			String TestData_cbt_CashBalanceTransactionReport_RecordsHeader) {
		if (!TestData_cbt_CashBalanceTransactionReport_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(cbt_CashBalanceTransactionReport_RecordsHeader));
		}
		return doIT(cbt_CashBalanceTransactionReport_RecordsHeader,
				TestData_cbt_CashBalanceTransactionReport_RecordsHeader);
	}

	public boolean isDisplayed_cbt_CashBalanceTransactionReport_RecordsHeader() {
		return isDisplayed(cbt_CashBalanceTransactionReport_RecordsHeader);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_StoreNbr(String TestData_cbt_Verify_StoreNbr) {
		return doIT(cbt_Verify_StoreNbr, TestData_cbt_Verify_StoreNbr);
	}

	public boolean isDisplayed_cbt_Verify_StoreNbr() {
		return isDisplayed(cbt_Verify_StoreNbr);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_EmpNbr(String TestData_cbt_Verify_EmpNbr) {
		return doIT(cbt_Verify_EmpNbr, TestData_cbt_Verify_EmpNbr);
	}

	public boolean isDisplayed_cbt_Verify_EmpNbr() {
		return isDisplayed(cbt_Verify_EmpNbr);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_EmpName(String TestData_cbt_Verify_EmpName) {
		return doIT(cbt_Verify_EmpName, TestData_cbt_Verify_EmpName);
	}

	public boolean isDisplayed_cbt_Verify_EmpName() {
		return isDisplayed(cbt_Verify_EmpName);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CountCashBal(String TestData_cbt_Verify_CountCashBal) {
		return doIT(cbt_Verify_CountCashBal, TestData_cbt_Verify_CountCashBal);
	}

	public boolean isDisplayed_cbt_Verify_CountCashBal() {
		return isDisplayed(cbt_Verify_CountCashBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CountCCMOBal(String TestData_cbt_Verify_CountCCMOBal) {
		return doIT(cbt_Verify_CountCCMOBal, TestData_cbt_Verify_CountCCMOBal);
	}

	public boolean isDisplayed_cbt_Verify_CountCCMOBal() {
		return isDisplayed(cbt_Verify_CountCCMOBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CountCheckBal(String TestData_cbt_Verify_CountCheckBal) {
		return doIT(cbt_Verify_CountCheckBal, TestData_cbt_Verify_CountCheckBal);
	}

	public boolean isDisplayed_cbt_Verify_CountCheckBal() {
		return isDisplayed(cbt_Verify_CountCheckBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CalCashBal(String TestData_cbt_Verify_CalCashBal) {
		return doIT(cbt_Verify_CalCashBal, TestData_cbt_Verify_CalCashBal);
	}

	public boolean isDisplayed_cbt_Verify_CalCashBal() {
		return isDisplayed(cbt_Verify_CalCashBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CalCCMOBal(String TestData_cbt_Verify_CalCCMOBal) {
		return doIT(cbt_Verify_CalCCMOBal, TestData_cbt_Verify_CalCCMOBal);
	}

	public boolean isDisplayed_cbt_Verify_CalCCMOBal() {
		return isDisplayed(cbt_Verify_CalCCMOBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_CalCheckBal(String TestData_cbt_Verify_CalCheckBal) {
		return doIT(cbt_Verify_CalCheckBal, TestData_cbt_Verify_CalCheckBal);
	}

	public boolean isDisplayed_cbt_Verify_CalCheckBal() {
		return isDisplayed(cbt_Verify_CalCheckBal);
	}

	// ****************************************************************************************************************************
	public String get_cbt_Verify_OverShortAmt(String TestData_cbt_Verify_OverShortAmt) {
		return doIT(cbt_Verify_OverShortAmt, TestData_cbt_Verify_OverShortAmt);
	}

	public boolean isDisplayed_cbt_Verify_OverShortAmt() {
		return isDisplayed(cbt_Verify_OverShortAmt);
	}

	// ****************************************************************************************************************************
	public String get_dcsr_DailyCenterSummaryReport_RecordsHeader(
			String TestData_dcsr_DailyCenterSummaryReport_RecordsHeader) {
		if (!TestData_dcsr_DailyCenterSummaryReport_RecordsHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(dcsr_DailyCenterSummaryReport_RecordsHeader));
		}
		return doIT(dcsr_DailyCenterSummaryReport_RecordsHeader, TestData_dcsr_DailyCenterSummaryReport_RecordsHeader);
	}

	public boolean isDisplayed_dcsr_DailyCenterSummaryReport_RecordsHeader() {
		return isDisplayed(dcsr_DailyCenterSummaryReport_RecordsHeader);
	}
}
