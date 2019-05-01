package pageClasses.QFund;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_NewLoan_LineOfCredit_Payments_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_Payments_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "requestBean.tenderType")
	private WebElement loc_tenderType_ListBox;

	@FindBy(name = "requestBean.paymentAmt")
	private WebElement loc_paymentAmt;

	@FindBy(name = "requestBean.tenderAmt")
	private WebElement loc_tenderAmt;

	@FindBy(name = "password")
	private WebElement loc_password;

	@FindBy(name = "Submit22")
	private WebElement loc_finishPayment_Button;

	@FindBy(name = "cancel")
	private WebElement loc_cancel_Button;

	@FindBy(name = "Submit36")
	private WebElement loc_history_Button;

	@FindBy(name = "btnADV_Yes")
	private WebElement loc_goToPayOffScreen_Button;

	@FindBy(name = "btnADV_No")
	private WebElement loc_goToPayOffCancel_Button;

	@FindBy(xpath = "//input[@onclick='javascript:ok()']")
	private WebElement loc_ok_Button;

	@FindBy(xpath = "//tbody[input[@value='RevolvingCreditTransaction']]/tr[1]//b")
	private WebElement loc_success_Message;

	@FindBy(name = "requestBean.transactionDataBean.ccmoNbrFirst")
	private WebElement loc_ccmoNbrFirst;

	public void set_loc_ccmoNbrFirst(String data) {
		doIT(loc_ccmoNbrFirst, data);
	}

	public void click_loc_ok_Button(String data) {
		if (!data.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(loc_ok_Button));
			doIT(loc_ok_Button, data);
		}
	}

	public String get_loc_success_Message(String sloc_success_Message) {
		return loc_success_Message.getText();
	}

	public void set_loc_tenderType_ListBox(String sloc_tenderType_ListBox) {

		doIT(loc_tenderType_ListBox, sloc_tenderType_ListBox);
	}

	public void set_loc_paymentAmt(String sloc_paymentAmt) {

		new Actions(driver).moveToElement(loc_paymentAmt).click().build().perform();
		loc_paymentAmt.clear();
		doIT(loc_paymentAmt, sloc_paymentAmt);
	}

	public void set_loc_tenderAmt(String sloc_tenderAmt) {

		doIT(loc_tenderAmt, sloc_tenderAmt);

	}

	public void set_loc_password(String sloc_password) {
		wait.until(ExpectedConditions.visibilityOf(loc_password));
		loc_password.click();
		doIT(loc_password, sloc_password);
	}

	public void keyTab(String data) {

		loc_tenderAmt.sendKeys(Keys.TAB);
	}

	public boolean isDisplayed_loc_finishPayment_Button() {
		return isDisplayed(loc_finishPayment_Button);
	}

	public void click_loc_finishPayment_Button(String data) {
		doIT(loc_finishPayment_Button, data);
	}

	public void click_loc_cancel_Button(String data) {
		doIT(loc_cancel_Button, data);
	}

	public void click_loc_history_Button(String data) {
		doIT(loc_history_Button, data);
	}

	public void click_loc_goToPayOffScreen_Button(String data) {
		doIT(loc_goToPayOffScreen_Button, data);
	}

	public boolean VerifyVisibilityOftenderAmt() {

		return loc_tenderAmt.isDisplayed();
	}
}
