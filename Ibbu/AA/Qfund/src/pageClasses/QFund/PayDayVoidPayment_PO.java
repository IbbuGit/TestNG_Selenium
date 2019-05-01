package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class PayDayVoidPayment_PO extends BasePage {

	public PayDayVoidPayment_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);

	}

	@FindBy(name = "transactionDataBean.disbursementType")
	private WebElement payDay_VoidPaymentDisbType;

	@FindBy(name = "transactionDataBean.password")
	private WebElement payDay_VoidPaymentUserPassword;

	@FindBy(name = "Submit22")
	private WebElement payDay_VoidPaymentFinishVoidPaymentButton;

	@FindBy(name = "checkno")
	private WebElement pymnt_no_pam;
	
	public void click_pymnt_no_pam(String data) {
		wait.until(ExpectedConditions.visibilityOf(pymnt_no_pam));
		doIT(pymnt_no_pam, data);
	}

	public void set_payDay_VoidPaymentDisbType(String spayDay_VoidPaymentDisbType) {
		doIT(payDay_VoidPaymentDisbType, spayDay_VoidPaymentDisbType);
	}

	public void set_payDay_VoidPaymentUserPassword(String spayDay_VoidPaymentUserPassword) {
		doIT(payDay_VoidPaymentUserPassword, spayDay_VoidPaymentUserPassword);
	}

	public void click_payDay_VoidPaymentFinishVoidPaymentButton(String data) {
		doIT(payDay_VoidPaymentFinishVoidPaymentButton, data);
	}

	public boolean isDisplayed_payDay_VoidPaymentFinishVoidPaymentButton() {
		return isDisplayed(payDay_VoidPaymentFinishVoidPaymentButton);
	}
}
