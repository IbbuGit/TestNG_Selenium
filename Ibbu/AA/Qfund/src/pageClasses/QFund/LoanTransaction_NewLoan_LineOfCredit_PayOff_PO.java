package pageClasses.QFund;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author akula srikanth
 * 
 */

public class LoanTransaction_NewLoan_LineOfCredit_PayOff_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_PayOff_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "changeAmount")
	private WebElement change_Amount;

	@FindBy(name = "tenderType")
	private WebElement loc_tenderType_ListBox;

	@FindBy(name = "payOffAmount")
	private WebElement loc_paymentAmt;

	@FindBy(name = "tenderAmount")
	private WebElement loc_tenderAmt;

	@FindBy(name = "password")
	private WebElement loc_password;

	@FindBy(id = "FinishPayOff")
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

	@FindBy(name = "payOffAmount")
	private WebElement loc_po_PaymentAmt;

	@FindBy(name = "tenderType")
	private WebElement loc_po_TenderType;

	@FindBy(name = "tenderAmount")
	private WebElement loc_po_TenderAmt;

	@FindBy(xpath = "//input[@value='Finish PayOff']")
	private WebElement loc_finishPayoff_Button;

	@FindBy(name = "ok")
	private WebElement po_Validation_OKButton;

	@FindBy(name = "ccmoNbrFirst")
	private WebElement loc_po_ccNbr;

	public String get_loc_change_Amount(String sloc_success_Message) {
		return change_Amount.getText();
	}

	public void click_loc_ok_Button() {
		doIT(loc_ok_Button, "y");
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
		doIT(loc_password, sloc_password);
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

	public void click_loc_finishPayoff_Button(String data) {
		doIT(loc_finishPayoff_Button, data);
	}

	public void click_po_Validation_OKButton(String data) {
		doIT(po_Validation_OKButton, data);
	}

	public String get_loc_paymentAmt(String strloc_po_PaymentAmt) {
		return doIT(loc_po_PaymentAmt, strloc_po_PaymentAmt);
	}

	public void set_loc_po_TenderType(String sloc_tenderType_ListBox) {
		doIT(loc_po_TenderType, sloc_tenderType_ListBox);
	}

	public void set_loc_po_TenderAmt(String data) {

		if (!data.isEmpty()) {
			if (data.equalsIgnoreCase("SAME AS PAYMENT AMOUNT")) {
				doIT(loc_po_TenderAmt, get_loc_paymentAmt("get"));
			} else {
				doIT(loc_po_TenderAmt, data);
			}
		}

	}

	public String getAlertText(String data) {
		if (!data.isEmpty()) {

			return AlertDecesion("getText");

		} else {
			return null;
		}

	}

	public void set_loc_po_ccNbr(String data) {
		doIT(loc_po_ccNbr, data);

	}

	public void keyTab(String string) {
		loc_po_TenderAmt.sendKeys(Keys.TAB);

	}

}
