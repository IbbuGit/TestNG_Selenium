package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class PayDayLoan_Void_PO extends BasePage {

	public PayDayLoan_Void_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);

	}

	@FindBy(name = "button")
	private WebElement payDay_SelectPayDayLaonButton;
	
	@FindBy(name = "checkyes")
	private WebElement payDay_SelectVoidConfirmButton;

	@FindBy(name = "transactionList")
	private WebElement payDay_TransactionSelectionType;

	@FindBy(name = "button")
	private WebElement payDay_SelectTransactionbutton;

	//@FindBy(xpath = "//b[contains(text(),'100.00')]")
	@FindBy(xpath = "//table/tbody/tr/td/table/tbody/tr[3]/td[2]/b")
	private WebElement payDay_VoidLoanAmount;

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement payDay_VoidTenderType;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement payDay_VoidTenderAmount;

	@FindBy(name = "transactionDataBean.password")
	private WebElement payDay_VoidUserPassword;

	@FindBy(xpath = "//input[contains(@onclick,'hist')]")
	private WebElement payDay_VoidHistoryButton;

	@FindBy(xpath = "//input[contains(@onclick,'back')]")
	private WebElement payDay_VoidBackButton;

	@FindBy(name = "Submit23")
	private WebElement payDay_VoidFinishVoidAdvanceButton;
	
	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement payDay_RescindTenderType;
	
	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement payDay_Pam_VoidTenderType;
	
	@FindBy(name = "checkno")
	private WebElement pymnt_no_pam;
	
	public void click_pymnt_no_pam(String data) {
		wait.until(ExpectedConditions.visibilityOf(pymnt_no_pam));
		doIT(pymnt_no_pam, data);
	}
	 
	public void set_payDay_Pam_VoidTenderType(String spayDay_Pam_VoidTenderType) {
		doIT(payDay_Pam_VoidTenderType, spayDay_Pam_VoidTenderType);
	}
	
	public String get_payDay_VoidLoanAmount(String data){
		return doIT(payDay_VoidLoanAmount, data).replace("$", "").trim();
	}
	
	public void set_payDay_RescindTenderType(String spayDay_RescindTenderType) {
		doIT(payDay_RescindTenderType, spayDay_RescindTenderType);
	}

	public void click_payDay_SelectPayDayLaonButton(String data) {
		doIT(payDay_SelectPayDayLaonButton, data);
	}
	
	public void click_payDay_SelectVoidConfirmButton(String data) {
		doIT(payDay_SelectVoidConfirmButton, data);
	}

	public void set_payDay_TransactionSelectionType(String spayDay_TransactionSelectionType) {
		doIT(payDay_TransactionSelectionType, spayDay_TransactionSelectionType);
	}

	public void set_payDay_SelectTransactionbutton(String spayDay_SelectTransactionbutton) {
		doIT(payDay_SelectTransactionbutton, spayDay_SelectTransactionbutton);
	}

	public void set_payDay_VoidLoanAmount(String spayDay_VoidLoanAmount) {
		doIT(payDay_VoidLoanAmount, spayDay_VoidLoanAmount);
	}

	public void set_payDay_VoidTenderType(String spayDay_VoidTenderType) {
		doIT(payDay_VoidTenderType, spayDay_VoidTenderType);
	}

	public void set_payDay_VoidTenderAmount(String spayDay_VoidTenderAmount) {
		doIT(payDay_VoidTenderAmount, spayDay_VoidTenderAmount);
	}

	public void set_payDay_VoidUserPassword(String spayDay_VoidUserPassword) {
		doIT(payDay_VoidUserPassword, spayDay_VoidUserPassword);
	}

	public void click_payDay_VoidHistoryButton(String data) {
		doIT(payDay_VoidHistoryButton, data);
	}

	public void click_payDay_VoidBackButton(String data) {
		doIT(payDay_VoidBackButton, data);
	}

	public void click_payDay_VoidFinishVoidAdvanceButton(String data) {
		doIT(payDay_VoidFinishVoidAdvanceButton, data);
	}
	
	public boolean isDisplayed_payDay_VoidFinishVoidAdvanceButton() {
		return isDisplayed(payDay_VoidFinishVoidAdvanceButton);
	}

}
