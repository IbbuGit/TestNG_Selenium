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
  
public class Reports_LoanReports_PO extends BasePage {

	public Reports_LoanReports_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[@class='formHeading']")
	private WebElement rep_PageHeader;

	@FindBy(xpath = "//td[contains(text(),'Default Report')]")
	private WebElement lr_Default_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'PWO Report')]")
	private WebElement lr_PWO_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Write Off Loans Report')]")
	private WebElement lr_WriteOffLoans_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Returned Items Report')]")
	private WebElement lr_ReturnedItems_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Sold Loan Report')]")
	private WebElement lr_SoldLoan_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'All Payments Report')]")
	private WebElement lr_Allpayments_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Check Register Report')]")
	private WebElement lr_CheckRegister_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Outstanding Presentment report')]")
	private WebElement lr_OutstandingPresentment_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Waive Fee Report')]")
	private WebElement lr_WaiveFee_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Refund Transaction Report')]")
	private WebElement lr_RefundTransaction_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'New Loan Report')]")
	private WebElement lr_NewLoan_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Returned Items Inventory Report')]")
	private WebElement lr_ReturnedItemsInventory_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Coupon Tracking Report')]")
	private WebElement lr_CouponTracking_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'ACH Details Report')]")
	private WebElement lr_ACHDetails_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Held Check Summary')]")
	private WebElement lr_HeldCheckSummary_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'ACH and RCC Activity Report')]")
	private WebElement lr_ACHandRCCActivity_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Active Prenote Report')]")
	private WebElement lr_ActivePrenote_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'Non-Center Payment Report')]")
	private WebElement lr_NonCenterPayment_ReportHeader;

	@FindBy(xpath = "//td[contains(text(),'ACH Credit Rejection Report')]")
	private WebElement lr_ACHCreditRejection_ReportHeader;

	@FindBy(name = "requestBean.transaction")
	private WebElement lr_CustomerNbr;

	@FindBy(name = "requestBean.transaction")
	private WebElement lr_LoanNbr;

	@FindBy(name = "requestBean.transaction")
	private WebElement lr_StoreNbr;

	@FindBy(name = "productType")
	private WebElement lr_ProductType;

	@FindBy(name = "tranCode")
	private WebElement lr_TransactionType;

	@FindBy(name = "owner")
	private WebElement apr_OwningStore;

	@FindBy(name = "depositType")
	private WebElement ri_DepositType;

	@FindBy(name = "depositActionType")
	private WebElement ri_DepositActionType;

	@FindBy(name = "returnReason")
	private WebElement ri_ReturnedReason;

	@FindBy(name = "beginMonth")
	private WebElement rep_BeginMonth;

	@FindBy(name = "beginDay")
	private WebElement rep_BeginDay;

	@FindBy(name = "beginYear")
	private WebElement rep_BeginYear;

	@FindBy(name = "endMonth")
	private WebElement rep_EndMonth;

	@FindBy(name = "endDay")
	private WebElement rep_EndDay;

	@FindBy(name = "endYear")
	private WebElement rep_EndYear;

	@FindBy(name = "btnPreview")
	private WebElement rep_SubmitButton;

	@FindBy(name = "B2")
	private WebElement rep_ResetButton;

	@FindBy(xpath = "//td[contains(text(),'End of Day has not been completed for the date entered. Report not available.')]")
	private WebElement repError_EODnotcompletedfortheday;

	@FindBy(xpath = "//font[@color='red']/ul")
	private WebElement repError_Page;

	@FindBy(xpath = ".//input[@value='Print']")
	private WebElement rep_PrintButton;

	@FindBy(xpath = ".//input[@value='Generate Excel']")
	private WebElement rep_GenerateExcelButton;

	// ****************************************************************************************************************************
	// Getter and Setter Begin
	// ****************************************************************************************************************************

	public void set_BeginDate(String strdate) {
		if (!strdate.isEmpty()) {
			String[] s_Date = strdate.split("/", -2);
			doIT(rep_BeginMonth, s_Date[0]);
			doIT(rep_BeginDay, s_Date[1]);
			doIT(rep_BeginYear, s_Date[2]);
		}
	}

	public void set_EndDate(String strdate) {
		if (!strdate.isEmpty()) {
			String[] s_Date = strdate.split("/", -2);
			doIT(rep_EndMonth, s_Date[0]);
			doIT(rep_EndDay, s_Date[1]);
			doIT(rep_EndYear, s_Date[2]);
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

	public String get_lr_ReportRecordsHeader(String strReportType) {

		switch (strReportType) {

		case "lr_Default_ReportHeader":
			return get_lr_Default_ReportHeader(strReportType);
		case "lr_PWO_ReportHeader":
			return get_lr_PWO_ReportHeader(strReportType);
		case "lr_WriteOffLoans_ReportHeader":
			return get_lr_WriteOffLoans_ReportHeader(strReportType);
		case "lr_ReturnedItems_ReportHeader":
			return get_lr_ReturnedItems_ReportHeader(strReportType);
		case "lr_SoldLoan_ReportHeader":
			return get_lr_SoldLoan_ReportHeader(strReportType);
		case "lr_Allpayments_ReportHeader":
			return get_lr_Allpayments_ReportHeader(strReportType);
		case "lr_CheckRegister_ReportHeader":
			return get_lr_CheckRegister_ReportHeader(strReportType);
		case "lr_OutstandingPresentment_ReportHeader":
			return get_lr_OutstandingPresentment_ReportHeader(strReportType);
		case "lr_WaiveFee_ReportHeader":
			return get_lr_WaiveFee_ReportHeader(strReportType);
		case "lr_RefundTransaction_ReportHeader":
			return get_lr_RefundTransaction_ReportHeader(strReportType);
		case "lr_NewLoan_ReportHeader":
			return get_lr_NewLoan_ReportHeader(strReportType);
		case "lr_ReturnedItemsInventory_ReportHeader":
			return get_lr_ReturnedItemsInventory_ReportHeader(strReportType);
		case "lr_CouponTracking_ReportHeader":
			return get_lr_CouponTracking_ReportHeader(strReportType);
		case "lr_ACHDetails_ReportHeader":
			return get_lr_ACHDetails_ReportHeader(strReportType);
		case "lr_HeldCheckSummary_ReportHeader":
			return get_lr_HeldCheckSummary_ReportHeader(strReportType);
		case "lr_ACHandRCCActivity_ReportHeader":
			return get_lr_ACHandRCCActivity_ReportHeader(strReportType);
		case "lr_ActivePrenote_ReportHeader":
			return get_lr_ActivePrenote_ReportHeader(strReportType);
		case "lr_NonCenterPayment_ReportHeader":
			return get_lr_NonCenterPayment_ReportHeader(strReportType);
		case "lr_ACHCreditRejection_ReportHeader":
			return get_lr_ACHCreditRejection_ReportHeader(strReportType);

		}
		return strReportType;

	}

	// ****************************************************************************************************************************
	public String get_rep_PageHeader(String TestData_rep_PageHeader) {
		if (!TestData_rep_PageHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(rep_PageHeader));
		}
		return doIT(rep_PageHeader, TestData_rep_PageHeader);
	}

	public boolean isDisplayed_rep_PageHeader() {
		return isDisplayed(rep_PageHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_Default_ReportHeader(String TestData_lr_Default_ReportHeader) {
		if (!TestData_lr_Default_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_Default_ReportHeader));
		}
		return doIT(lr_Default_ReportHeader, TestData_lr_Default_ReportHeader);
	}

	public boolean isDisplayed_lr_Default_ReportHeader() {
		return isDisplayed(lr_Default_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_PWO_ReportHeader(String TestData_lr_PWO_ReportHeader) {
		if (!TestData_lr_PWO_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_PWO_ReportHeader));
		}
		return doIT(lr_PWO_ReportHeader, TestData_lr_PWO_ReportHeader);
	}

	public boolean isDisplayed_lr_PWO_ReportHeader() {
		return isDisplayed(lr_PWO_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_WriteOffLoans_ReportHeader(String TestData_lr_WriteOffLoans_ReportHeader) {
		if (!TestData_lr_WriteOffLoans_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_WriteOffLoans_ReportHeader));
		}
		return doIT(lr_WriteOffLoans_ReportHeader, TestData_lr_WriteOffLoans_ReportHeader);
	}

	public boolean isDisplayed_lr_WriteOffLoans_ReportHeader() {
		return isDisplayed(lr_WriteOffLoans_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ReturnedItems_ReportHeader(String TestData_lr_ReturnedItems_ReportHeader) {
		if (!TestData_lr_ReturnedItems_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_ReturnedItems_ReportHeader));
		}
		return doIT(lr_ReturnedItems_ReportHeader, TestData_lr_ReturnedItems_ReportHeader);
	}

	public boolean isDisplayed_lr_ReturnedItems_ReportHeader() {
		return isDisplayed(lr_ReturnedItems_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_SoldLoan_ReportHeader(String TestData_lr_SoldLoan_ReportHeader) {
		if (!TestData_lr_SoldLoan_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_SoldLoan_ReportHeader));
		}
		return doIT(lr_SoldLoan_ReportHeader, TestData_lr_SoldLoan_ReportHeader);
	}

	public boolean isDisplayed_lr_SoldLoan_ReportHeader() {
		return isDisplayed(lr_SoldLoan_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_Allpayments_ReportHeader(String TestData_lr_Allpayments_ReportHeader) {
		if (!TestData_lr_Allpayments_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_Allpayments_ReportHeader));
		}
		return doIT(lr_Allpayments_ReportHeader, TestData_lr_Allpayments_ReportHeader);
	}

	public boolean isDisplayed_lr_Allpayments_ReportHeader() {
		return isDisplayed(lr_Allpayments_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_CheckRegister_ReportHeader(String TestData_lr_CheckRegister_ReportHeader) {
		if (!TestData_lr_CheckRegister_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_CheckRegister_ReportHeader));
		}
		return doIT(lr_CheckRegister_ReportHeader, TestData_lr_CheckRegister_ReportHeader);
	}

	public boolean isDisplayed_lr_CheckRegister_ReportHeader() {
		return isDisplayed(lr_CheckRegister_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_OutstandingPresentment_ReportHeader(String TestData_lr_OutstandingPresentment_ReportHeader) {
		if (!TestData_lr_OutstandingPresentment_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_OutstandingPresentment_ReportHeader));
		}
		return doIT(lr_OutstandingPresentment_ReportHeader, TestData_lr_OutstandingPresentment_ReportHeader);
	}

	public boolean isDisplayed_lr_OutstandingPresentment_ReportHeader() {
		return isDisplayed(lr_OutstandingPresentment_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_WaiveFee_ReportHeader(String TestData_lr_WaiveFee_ReportHeader) {
		if (!TestData_lr_WaiveFee_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_WaiveFee_ReportHeader));
		}
		return doIT(lr_WaiveFee_ReportHeader, TestData_lr_WaiveFee_ReportHeader);
	}

	public boolean isDisplayed_lr_WaiveFee_ReportHeader() {
		return isDisplayed(lr_WaiveFee_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_RefundTransaction_ReportHeader(String TestData_lr_RefundTransaction_ReportHeader) {
		if (!TestData_lr_RefundTransaction_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_RefundTransaction_ReportHeader));
		}
		return doIT(lr_RefundTransaction_ReportHeader, TestData_lr_RefundTransaction_ReportHeader);
	}

	public boolean isDisplayed_lr_RefundTransaction_ReportHeader() {
		return isDisplayed(lr_RefundTransaction_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_NewLoan_ReportHeader(String TestData_lr_NewLoan_ReportHeader) {
		if (!TestData_lr_NewLoan_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_NewLoan_ReportHeader));
		}
		return doIT(lr_NewLoan_ReportHeader, TestData_lr_NewLoan_ReportHeader);
	}

	public boolean isDisplayed_lr_NewLoan_ReportHeader() {
		return isDisplayed(lr_NewLoan_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ReturnedItemsInventory_ReportHeader(String TestData_lr_ReturnedItemsInventory_ReportHeader) {
		if (!TestData_lr_ReturnedItemsInventory_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_ReturnedItemsInventory_ReportHeader));
		}
		return doIT(lr_ReturnedItemsInventory_ReportHeader, TestData_lr_ReturnedItemsInventory_ReportHeader);
	}

	public boolean isDisplayed_lr_ReturnedItemsInventory_ReportHeader() {
		return isDisplayed(lr_ReturnedItemsInventory_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_CouponTracking_ReportHeader(String TestData_lr_CouponTracking_ReportHeader) {
		if (!TestData_lr_CouponTracking_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_CouponTracking_ReportHeader));
		}
		return doIT(lr_CouponTracking_ReportHeader, TestData_lr_CouponTracking_ReportHeader);
	}

	public boolean isDisplayed_lr_CouponTracking_ReportHeader() {
		return isDisplayed(lr_CouponTracking_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ACHDetails_ReportHeader(String TestData_lr_ACHDetails_ReportHeader) {
		if (!TestData_lr_ACHDetails_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_ACHDetails_ReportHeader));
		}
		return doIT(lr_ACHDetails_ReportHeader, TestData_lr_ACHDetails_ReportHeader);
	}

	public boolean isDisplayed_lr_ACHDetails_ReportHeader() {
		return isDisplayed(lr_ACHDetails_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_HeldCheckSummary_ReportHeader(String TestData_lr_HeldCheckSummary_ReportHeader) {
		if (!TestData_lr_HeldCheckSummary_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_HeldCheckSummary_ReportHeader));
		}
		return doIT(lr_HeldCheckSummary_ReportHeader, TestData_lr_HeldCheckSummary_ReportHeader);
	}

	public boolean isDisplayed_lr_HeldCheckSummary_ReportHeader() {
		return isDisplayed(lr_HeldCheckSummary_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ACHandRCCActivity_ReportHeader(String TestData_lr_ACHandRCCActivity_ReportHeader) {
		if (!TestData_lr_ACHandRCCActivity_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_ACHandRCCActivity_ReportHeader));
		}
		return doIT(lr_ACHandRCCActivity_ReportHeader, TestData_lr_ACHandRCCActivity_ReportHeader);
	}

	public boolean isDisplayed_lr_ACHandRCCActivity_ReportHeader() {
		return isDisplayed(lr_ACHandRCCActivity_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ActivePrenote_ReportHeader(String TestData_lr_ActivePrenote_ReportHeader) {
		if (!TestData_lr_ActivePrenote_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lr_ActivePrenote_ReportHeader));
		}
		return doIT(lr_ActivePrenote_ReportHeader, TestData_lr_ActivePrenote_ReportHeader);
	}

	public boolean isDisplayed_lr_ActivePrenote_ReportHeader() {
		return isDisplayed(lr_ActivePrenote_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_NonCenterPayment_ReportHeader(String TestData_lr_NonCenterPayment_ReportHeader) {
		if (!TestData_lr_NonCenterPayment_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_NonCenterPayment_ReportHeader));
		}
		return doIT(lr_NonCenterPayment_ReportHeader, TestData_lr_NonCenterPayment_ReportHeader);
	}

	public boolean isDisplayed_lr_NonCenterPayment_ReportHeader() {
		return isDisplayed(lr_NonCenterPayment_ReportHeader);
	}

	// ****************************************************************************************************************************
	public String get_lr_ACHCreditRejection_ReportHeader(String TestData_lr_ACHCreditRejection_ReportHeader) {
		if (!TestData_lr_ACHCreditRejection_ReportHeader.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(lr_ACHCreditRejection_ReportHeader));
		}
		return doIT(lr_ACHCreditRejection_ReportHeader, TestData_lr_ACHCreditRejection_ReportHeader);
	}

	public boolean isDisplayed_lr_ACHCreditRejection_ReportHeader() {
		return isDisplayed(lr_ACHCreditRejection_ReportHeader);
	}

	// ****************************************************************************************************************************
	public void set_lr_CustomerNbr(String TestData_lr_CustomerNbr) {
		doIT(lr_CustomerNbr, TestData_lr_CustomerNbr);
	}

	public boolean isDisplayed_lr_CustomerNbr() {
		return isDisplayed(lr_CustomerNbr);
	}

	// ****************************************************************************************************************************
	public void set_lr_LoanNbr(String TestData_lr_LoanNbr) {
		doIT(lr_LoanNbr, TestData_lr_LoanNbr);
	}

	public boolean isDisplayed_lr_LoanNbr() {
		return isDisplayed(lr_LoanNbr);
	}

	// ****************************************************************************************************************************
	public void set_lr_StoreNbr(String TestData_lr_StoreNbr) {
		doIT(lr_StoreNbr, TestData_lr_StoreNbr);
	}

	public boolean isDisplayed_lr_StoreNbr() {
		return isDisplayed(lr_StoreNbr);
	}

	// ****************************************************************************************************************************
	public void set_lr_ProductType(String TestData_lr_ProductType) {
		doIT(lr_ProductType, TestData_lr_ProductType);
	}

	public boolean isDisplayed_lr_ProductType() {
		return isDisplayed(lr_ProductType);
	}

	// ****************************************************************************************************************************
	public void set_lr_TransactionType(String TestData_lr_TransactionType) {
		doIT(lr_TransactionType, TestData_lr_TransactionType);
	}

	public boolean isDisplayed_lr_TransactionType() {
		return isDisplayed(lr_TransactionType);
	}
	
	// ****************************************************************************************************************************
	public void set_apr_OwningStore(String TestData_apr_OwningStore) {
		doIT(apr_OwningStore, TestData_apr_OwningStore);
	}

	public boolean isDisplayed_apr_OwningStore() {
		return isDisplayed(apr_OwningStore);
	}
	
	// ****************************************************************************************************************************
	public void set_ri_DepositType(String TestData_ri_DepositType) {
		doIT(ri_DepositType, TestData_ri_DepositType);
	}

	public boolean isDisplayed_ri_DepositType() {
		return isDisplayed(ri_DepositType);
	}

	// ****************************************************************************************************************************
	public void set_ri_DepositActionType(String TestData_ri_DepositActionType) {
		doIT(ri_DepositActionType, TestData_ri_DepositActionType);
	}

	public boolean isDisplayed_ri_DepositActionType() {
		return isDisplayed(ri_DepositActionType);
	}

	// ****************************************************************************************************************************
	public void set_ri_ReturnedReason(String TestData_ri_ReturnedReason) {
		doIT(ri_ReturnedReason, TestData_ri_ReturnedReason);
	}

	public boolean isDisplayed_ri_ReturnedReason() {
		return isDisplayed(ri_ReturnedReason);
	}

	// ****************************************************************************************************************************
	public void set_rep_BeginMonth(String TestData_rep_BeginMonth) {
		doIT(rep_BeginMonth, TestData_rep_BeginMonth);
	}

	public boolean isDisplayed_rep_BeginMonth() {
		return isDisplayed(rep_BeginMonth);
	}

	// ****************************************************************************************************************************
	public void set_rep_BeginDay(String TestData_rep_BeginDay) {
		doIT(rep_BeginDay, TestData_rep_BeginDay);
	}

	public boolean isDisplayed_rep_BeginDay() {
		return isDisplayed(rep_BeginDay);
	}

	// ****************************************************************************************************************************
	public void set_rep_BeginYear(String TestData_rep_BeginYear) {
		doIT(rep_BeginYear, TestData_rep_BeginYear);
	}

	public boolean isDisplayed_rep_BeginYear() {
		return isDisplayed(rep_BeginYear);
	}

	// ****************************************************************************************************************************
	public void set_rep_EndMonth(String TestData_rep_EndMonth) {
		doIT(rep_EndMonth, TestData_rep_EndMonth);
	}

	public boolean isDisplayed_rep_EndMonth() {
		return isDisplayed(rep_EndMonth);
	}

	// ****************************************************************************************************************************
	public void set_rep_EndDay(String TestData_rep_EndDay) {
		doIT(rep_EndDay, TestData_rep_EndDay);
	}

	public boolean isDisplayed_rep_EndDay() {
		return isDisplayed(rep_EndDay);
	}

	// ****************************************************************************************************************************
	public void set_rep_EndYear(String TestData_rep_EndYear) {
		doIT(rep_EndYear, TestData_rep_EndYear);
	}

	public boolean isDisplayed_rep_EndYear() {
		return isDisplayed(rep_EndYear);
	}

	// ****************************************************************************************************************************
	public void click_rep_SubmitButton(String TestData_rep_SubmitButton) {
		doIT(rep_SubmitButton, TestData_rep_SubmitButton);
	}

	public boolean isDisplayed_rep_SubmitButton() {
		return isDisplayed(rep_SubmitButton);
	}

	// ****************************************************************************************************************************
	public void click_rep_ResetButton(String TestData_rep_ResetButton) {
		doIT(rep_ResetButton, TestData_rep_ResetButton);
	}

	public boolean isDisplayed_rep_ResetButton() {
		return isDisplayed(rep_ResetButton);
	}

	// ****************************************************************************************************************************
	public String get_repError_EODnotcompletedfortheday(String TestData_repError_EODnotcompletedfortheday) {
		if (!TestData_repError_EODnotcompletedfortheday.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(repError_EODnotcompletedfortheday));
		}
		return doIT(repError_EODnotcompletedfortheday, TestData_repError_EODnotcompletedfortheday);
	}

	public boolean isDisplayed_repError_EODnotcompletedfortheday() {
		return isDisplayed(repError_EODnotcompletedfortheday);
	}

	// ****************************************************************************************************************************
	public String get_repError_Page(String TestData_repError_Page) {
		if (!TestData_repError_Page.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(repError_Page));
		}
		return doIT(repError_Page, TestData_repError_Page);
	}

	public boolean isDisplayed_repError_Page() {
		return isDisplayed(repError_Page);
	}

	// ****************************************************************************************************************************
	public void click_rep_PrintButton(String TestData_rep_PrintButton) {
		doIT(rep_PrintButton, TestData_rep_PrintButton);
	}

	public boolean isDisplayed_rep_PrintButton() {
		return isDisplayed(rep_PrintButton);
	}

	// ****************************************************************************************************************************
	public void click_rep_GenerateExcelButton(String TestData_rep_GenerateExcelButton) {
		doIT(rep_GenerateExcelButton, TestData_rep_GenerateExcelButton);
	}

	public boolean isDisplayed_rep_GenerateExcelButton() {
		return isDisplayed(rep_GenerateExcelButton);
	}
	// ****************************************************************************************************************************
	// Getter and Setter End
	// ****************************************************************************************************************************

}
