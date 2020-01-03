package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_NewLoan_LineOfCredit_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "intRate")
	private WebElement loc_interestRate;

	@FindBy(name = "advanceRequestBean.paymentCollateralType")
	private WebElement loc_methodOfPayment_Listbox;

	@FindBy(name = "advanceRequestBean.courtesyCallFlag")
	private WebElement loc_paymentReminder_Listbox;

	@FindBy(name = "advanceRequestBean.emailConsentFlag")
	private WebElement loc_electronicCommunicationFlag_Listbox;

	@FindBy(name = "username")
	private WebElement loc_userName;

	@FindBy(name = "requestBean.password")
	private WebElement loc_password;

	@FindBy(name = "canceladvance")
	private WebElement loc_cancel_Button;

	@FindBy(name = "eeeComm")
	private WebElement loc_eligibility_Button;

	@FindBy(name = "finishadvance")
	private WebElement loc_finish_Button;

	public void getloc_interestRate(String data) {
		loc_interestRate.getText();
	}

	public void set_loc_interestRate(String sloc_interestRate) {

		doIT(loc_interestRate, sloc_interestRate);
	}

	public void set_loc_methodOfPayment_Listbox(String sloc_methodOfPayment_Listbox) throws Exception {
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(loc_methodOfPayment_Listbox));
		doIT(loc_methodOfPayment_Listbox, sloc_methodOfPayment_Listbox);
		// new Actions(driver).moveToElement(loc_eligibility_Button).build().perform();
	}

	public boolean checkVisibilityOfLoc_methodOfPayment_Listbox() {
		return isDisplayed(loc_methodOfPayment_Listbox);
	}

	public void set_loc_paymentReminder_Listbox(String sloc_paymentReminder_Listbox) {

		doIT(loc_paymentReminder_Listbox, sloc_paymentReminder_Listbox);
	}

	public void set_loc_electronicCommunicationFlag_Listbox(String sloc_electronicCommunicationFlag_Listbox)
			throws InterruptedException {

		doIT(loc_electronicCommunicationFlag_Listbox, sloc_electronicCommunicationFlag_Listbox);
		Thread.sleep(2000);

	}

	public void set_loc_userName(String sloc_userName) {

		doIT(loc_userName, sloc_userName);
	}

	public void set_loc_password(String sloc_password) throws InterruptedException {
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(loc_password));
		doIT(loc_password, sloc_password);
		Thread.sleep(3000);
	}

	public void click_loc_cancel_Button(String data) {
		doIT(loc_cancel_Button, data);
	}

	public void click_loc_eligibility_Button(String data) {
		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(loc_eligibility_Button));
		} catch (Exception e) {
		}
		doIT(loc_eligibility_Button, data);
	}

	public void wait_loc_finish_ButtonToBeClickable(String data) {
		if (!data.isEmpty()) {
			if (isAlertPresent()) {
				acceptAlert();
			}
			try {
				new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(loc_finish_Button));
			} catch (Exception e) {
			}
		}
	}

	public boolean isDisplayed_loc_finish_Button() {
		return isDisplayed(loc_finish_Button);
	}

	public void click_loc_finish_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loc_finish_Button));
			doIT(loc_finish_Button, data);
		}

	}

	public void waitForRefreshed(String data) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(loc_finish_Button)));
	}

	public void waitUntilEnabled(String data) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(loc_paymentReminder_Listbox)));
	}
}
