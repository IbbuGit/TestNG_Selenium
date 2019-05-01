package pageClasses.QFund;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_Transactions_ACHTransactions_PO extends BasePage {

	public LoanTransactions_Transactions_ACHTransactions_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * ACH Clear
	 */

	@FindBy(xpath = "//*[contains(text(),'ACH Clear Transaction')]")
	private WebElement ac_PageHeader;

	@FindBy(xpath = "//a[contains(text(),'CheckAll')]")
	private WebElement ac_CheckAll;

	@FindBy(xpath = "//a[contains(text(),'UnCheckAll')]")
	private WebElement ac_UnCheckAll;

	@FindBy(name = "requestBean.chkName")
	private WebElement ac_SelectCheck1;
	
	@FindBy(name = "CmdReturnPosting")
	private WebElement ac_FinishACHClearButton;

	@FindBy(xpath = "//*[contains(text(),'ACH Clear Transaction Completed Successfully.')]")
	private WebElement ac_Validation;

	public String get_ac_PageHeader(String TestData_ac_PageHeader) {
		return doIT(ac_PageHeader, TestData_ac_PageHeader);
	}

	public void click_ac_CheckAll(String TestData_ac_CheckAll) {
		doIT(ac_CheckAll, TestData_ac_CheckAll);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ac_CheckAll);
	}

	public void click_ac_UnCheckAll(String TestData_ac_UnCheckAll) {
		doIT(ac_UnCheckAll, TestData_ac_UnCheckAll);
	}

	public void Click_ac_SelectCheck1(String TestData_cr_TenderType) {
		doIT(ac_SelectCheck1, TestData_cr_TenderType);
	}
	
	public void click_ac_FinishACHClearButton(String TestData_ac_FinishACHClearButton) {
		doIT(ac_FinishACHClearButton, TestData_ac_FinishACHClearButton);
	}

	public String get_ac_Validation(String TestData_ac_Validation) {
		return doIT(ac_Validation, TestData_ac_Validation);
	}

	public boolean isDisplayed_ac_FinishACHClearButton() {
		return isDisplayed(ac_FinishACHClearButton);
	}

	public boolean isDisplayed_ac_UnCheckAll() {
		return isDisplayed(ac_UnCheckAll);
	}

	public boolean isDisplayed_ac_CheckAll() {
		return isDisplayed(ac_CheckAll);
	}

	public boolean isDisplayed_ac_PageHeader() {
		return isDisplayed(ac_PageHeader);
	}

	public boolean isDisplayed_ac_Validation() {
		return isDisplayed(ac_Validation);
	}
	/*
	 * CutomerRefund
	 */

	@FindBy(xpath = "//*[contains(text(),'Refund')]")
	private WebElement cr_PageHeader;

	@FindBy(xpath = "//*[contains(text(),'Refund Details')]")
	private WebElement cr_RefundDetailsHeader;

	@FindBy(xpath = "//*[contains(text(),'Over Payment Amt')]/../following-sibling::tr/td[1]")
	private WebElement cr_VerifyOverPaymentAmDue;

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement cr_TenderType;

	@FindBy(xpath = "//*[contains(text(),'Advance Amt')]/../following-sibling::tr/td[1]")
	private WebElement cr_VerifyAdvanceAmt;

	@FindBy(xpath = "//*[contains(text(),'Advance Fee')]/../following-sibling::tr/td[2]")
	private WebElement cr_VerifyAdvanceFee;

	@FindBy(xpath = "//*[contains(text(),'Rebate Amt')]/../following-sibling::tr/td[3]")
	private WebElement cr_VerifyRebateAmt;

	@FindBy(xpath = "//*[contains(text(),'Payments Made')]/../following-sibling::tr/td[4]")
	private WebElement cr_VerifyPaymentsMade;

	@FindBy(xpath = "//*[contains(text(),'Promotions')]/../following-sibling::tr/td[5]")
	private WebElement cr_VerifyPromotions;

	@FindBy(xpath = "//*[contains(text(),'Total Amt Owed')]/../following-sibling::tr/td[6]")
	private WebElement cr_VerifyAmountOwed;

	@FindBy(name = "Submit36")
	private WebElement cr_BackButton;

	@FindBy(name = "finish")
	private WebElement cr_FinishRefundButton;

	@FindBy(xpath = "//*[contains(text(),'Refund completed successfully.')]")
	private WebElement cr_Validation;

	public String get_cr_PageHeader(String TestData_cr_PageHeader) {
		return doIT(cr_PageHeader, TestData_cr_PageHeader);
	}

	public String get_cr_RefundDetailsHeader(String TestData_cr_OutToRepoDetailsHeader) {
		return doIT(cr_RefundDetailsHeader, TestData_cr_OutToRepoDetailsHeader);
	}

	public String get_cr_VerifyOverPaymentAmDue(String TestData_cr_PageHeader) {
		return doIT(cr_VerifyOverPaymentAmDue, TestData_cr_PageHeader);
	}
	public void set_cr_VerifyOverPaymentAmDue(String TestData_cr_VerifyPrincipalDue) {
		doIT(cr_VerifyOverPaymentAmDue, TestData_cr_VerifyPrincipalDue);
	}

	public void set_cr_TenderType(String TestData_cr_TenderType) {
		new Select(cr_TenderType).selectByVisibleText(TestData_cr_TenderType);
		//doIT(cr_TenderType, TestData_cr_TenderType);
	}

	public void set_cr_VerifyAdvanceAmt(String TestData_cr_VerifyAdvanceAmt) {
		doIT(cr_VerifyAdvanceAmt, TestData_cr_VerifyAdvanceAmt);
	}
	public String get_cr_VerifyAdvanceAmt(String TestData_vr_Validation) {
		return doIT(cr_VerifyAdvanceAmt, TestData_vr_Validation);
	}
	public void set_cr_VerifyAdvanceFee(String TestData_cr_VerifyAdvanceFee) {
		doIT(cr_VerifyAdvanceFee, TestData_cr_VerifyAdvanceFee);
	}
	public String get_cr_VerifyAdvanceFee(String TestData_vr_Validation) {
		return doIT(cr_VerifyAdvanceFee, TestData_vr_Validation);
	}
	public void set_cr_VerifyRebateAmt(String TestData_cr_VerifyRebateAmt) {
		doIT(cr_VerifyRebateAmt, TestData_cr_VerifyRebateAmt);
	}
	public String get_cr_VerifyRebateAmt(String TestData_vr_Validation) {
		return doIT(cr_VerifyRebateAmt, TestData_vr_Validation);
	}
	public void set_cr_VerifyPaymentsMade(String TestData_cr_VerifyPaymentsMade) {
		doIT(cr_VerifyPaymentsMade, TestData_cr_VerifyPaymentsMade);
	}
	public String get_cr_VerifyPaymentsMade(String TestData_vr_Validation) {
		return doIT(cr_VerifyPaymentsMade, TestData_vr_Validation);
	}
	public void set_cr_VerifyPromotions(String TestData_cr_VerifyPromotions) {
		doIT(cr_VerifyPromotions, TestData_cr_VerifyPromotions);
	}
	public String get_cr_VerifyPromotions(String TestData_vr_Validation) {
		return doIT(cr_VerifyPromotions, TestData_vr_Validation);
	}
	public void set_cr_VerifyAmountOwed(String TestData_cr_VerifyAmountOwed) {
		doIT(cr_VerifyAmountOwed, TestData_cr_VerifyAmountOwed);
	}
	public String get_cr_VerifyAmountOwed(String TestData_vr_Validation) {
		return doIT(cr_VerifyAmountOwed, TestData_vr_Validation);
	}
	public void click_cr_BackButton(String TestData_cr_BackButton) {
		doIT(cr_BackButton, TestData_cr_BackButton);
	}

	public void click_cr_FinishRefundButton(String TestData_cr_FinishRefundButton) {
		doIT(cr_FinishRefundButton, TestData_cr_FinishRefundButton);
	}
	public boolean isDisplayed_cr_FinishRefundButton() {
		return isDisplayed(cr_FinishRefundButton);
	}
	public String get_cr_Validation(String TestData_cr_Validation) {
		return doIT(cr_Validation, TestData_cr_Validation);
	}

	/*
	 * Void Refund
	 */
	@FindBy(xpath = "//*[contains(text(),'Void Refund')]")
	private WebElement vr_PageHeader;

	@FindBy(name = "finish")
	private WebElement vr_FinishVoidRefundButton;

	@FindBy(xpath = "//*[contains(text(),'Void Refund completed successfully.')]")
	private WebElement vr_Validation;

	public String get_vr_PageHeader(String TestData_vr_PageHeader) {
		return doIT(vr_PageHeader, TestData_vr_PageHeader);
	}
	public boolean isDisplayed_vr_FinishVoidRefundButton() {
		return isDisplayed(vr_FinishVoidRefundButton);
	}
	public void click_vr_FinishVoidRefundButton(String TestData_vr_FinishVoidRefundButton) {
		doIT(vr_FinishVoidRefundButton, TestData_vr_FinishVoidRefundButton);
	}

	public String get_vr_Validation(String TestData_vr_Validation) {
		return doIT(vr_Validation, TestData_vr_Validation);
	}
	/*
	 * Auction
	 */

	/*
	 * Common
	 */

	@FindBy(xpath = "//input[@value='No']")
	private WebElement co_AnotherTranNO;

	@FindBy(xpath = "//input[@value='Yes']")
	private WebElement co_AnotherTranYES;

	public void click_co_AnotherTranYES(String data) {
		doIT(co_AnotherTranYES, data);
	}

	public void click_co_AnotherTranNO(String data) {
		doIT(co_AnotherTranNO, data);
	}

}