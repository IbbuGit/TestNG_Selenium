package pageClasses.QFund;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_VoidPayments_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}
	
/*	@FindBy(name = "transactionDataBean.tenderType")
	private WebElement loc_void_DisType_ListBox;*/


	@FindBy(name = "Submit22")
	private WebElement loc_void_Payments_Button;
	
	
	@FindBy(name = "transactionDataBean.tenderType")
	private WebElement loc_void_DisType_ListBox;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement loc_void_tenderAmt;
	
	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement loc_pamDisType_ListBox;

	@FindBy(name = "transactionDataBean.change")
	private WebElement loc_void_tenderAmt_Change;

	@FindBy(name = "password")
	private WebElement loc_void_Password;

	@FindBy(name = "cancel")
	private WebElement loc_void_cancel_draw_Button;

	@FindBy(name = "Submit36")
	private WebElement loc_void_history_draw_Button;

	@FindBy(xpath = "//b")
	private WebElement loc_void_success_Msg;

	@FindBy(xpath = "//input[@onclick='submit100()']")
	private WebElement loc_void_Payment_Button;
	
	@FindBy(xpath = "//input[@onclick='finish()']")
	private WebElement loc_void_payoff_ok_Button_pam;
	

	public void set_loc_void_disType_ListBox(String sloc_void_disType_ListBox) {

		doIT(loc_void_DisType_ListBox, sloc_void_disType_ListBox);

	}
	
	public void set_loc_pamDisType_ListBox(String sloc_pamDisType_ListBox) {

		doIT(loc_pamDisType_ListBox, sloc_pamDisType_ListBox);

	}
	
	

	public boolean VerifyVisibilityOfloc_void_Payments_Button() {
		return loc_void_Payments_Button.isDisplayed();
	}
	
	public boolean checkVisibilityOfOk_Button_pam() {
		return loc_void_payoff_ok_Button_pam.isDisplayed();
	}

	public void set_loc_void_tenderAmt(String sloc_void_tenderAmt) {

		doIT(loc_void_tenderAmt, sloc_void_tenderAmt);

	}

	public boolean checkVisibilityOfOk_Button()
	{
		return loc_void_Payment_Button.isDisplayed();
		
	}
	public void set_loc_void_tenderAmt_Change(String sloc_void_tenderAmt_Change) {
		doIT(loc_void_tenderAmt_Change, sloc_void_tenderAmt_Change);
	}

	public void set_loc_void_Password(String sloc_void_Password) {
		doIT(loc_void_Password, sloc_void_Password);
	}
	
	public void click_loc_void_Payoff_Button(String data) {
		doIT(loc_void_Payments_Button, data);
	//	wait.until(ExpectedConditions.visibilityOf(loc_void_success_Msg));
	}

	public void click_loc_void_Payments_Button(String data) {
		doIT(loc_void_Payments_Button, data);
		wait.until(ExpectedConditions.visibilityOf(loc_void_success_Msg));
	}

	public void click_loc_void_cancel_draw_Button(String data) {
		doIT(loc_void_cancel_draw_Button, data);
	}

	public void click_loc_void_history_draw_Button(String data) {
		doIT(loc_void_history_draw_Button, data);
	}

	public String set_loc_void_success_Msg() {
		return loc_void_success_Msg.getText();
	}
	
	public void click_loc_void_ok_Button(String data) {
		doIT(loc_void_Payment_Button, data);
	}


	public void click_loc_void_payoff_ok_Button_pam(String data) {
		doIT(loc_void_payoff_ok_Button_pam, data);
	}

	public void click_CustomerForLoanNumber(String Loan_nbr) {
		String elementStringGo = "//td[contains(text(),'" + Loan_nbr + "')]/..//input[@value='Go']";
		WebElement elementGo = driver.findElement(By.xpath(elementStringGo));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0]);", elementGo);
	}
	
	
}
