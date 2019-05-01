package pageClasses.QFund;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @author vsankar
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class PayDayLaon_PO extends BasePage {

	public PayDayLaon_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(name = "advanceRequestBean.collateralTypeId")
	private WebElement payDay_CollateralType;

	@FindBy(name = "advanceRequestBean.advanceAmt")
	private WebElement payDay_LoanAmount;

	@FindBy(name = "dueDate1")
	private WebElement payDay_DueDateMonth;

	@FindBy(name = "dueDate2")
	private WebElement payDay_DueDateDay;

	@FindBy(name = "dueDate3")
	private WebElement payDay_DueDateYear;

	@FindBy(name = "abaNbr")
	private WebElement payDay_RoutingNo;

	@FindBy(name = "advanceRequestBean.chkgAcctNbr")
	private WebElement payDay_CheckingAccountNo;

	@FindBy(name = "advanceRequestBean.disbursementType")
	private WebElement payDay_DisbType;

	@FindBy(name = "advanceRequestBean.disbAmtFirst")
	private WebElement payDay_DisbAmount;

	@FindBy(name = "advanceRequestBean.courtesyCallFlag")
	private WebElement payDay_PaymentReminderConsent;

	@FindBy(name = "advanceRequestBean.emailConsentFlag")
	private WebElement payDay_ElectronicCommunicationConsent;

	@FindBy(name = "advanceRequestBean.loggedUserPassword")
	private WebElement payDay_UserPassword;

	@FindBy(name = "cancel")
	private WebElement payDay_CancelButton;

	@FindBy(name = "eeeComm")
	private WebElement payDay_EligibilityButton;

	@FindBy(name = "finishadvance")
	private WebElement payDay_FinishLoanButton;

	@FindBy(name = "requestBean.noOfChecks")
	private WebElement payDay_noOfChecks;

	@FindBy(name = "chkNbr0")
	private WebElement payDay_checkNo;
	
	@FindBy(xpath = "//td[contains(text(),'IN Process')]")
	private WebElement ACH_Status;
	
	@FindBy(name = "requestBean.locationNbr")
	private WebElement ACHreturn_StoreNO;

	@FindBy(id = "OKBut")
	private WebElement payDay_ProcessLaon;

	@FindBy(xpath="//input[@value='Next']")
	private WebElement rpp_next_btn;

	@FindBy(name = "password")
	private WebElement rpp_password ;
	
	@FindBy(id="password")
	private WebElement pam_Pin;
	

	@FindBy(id = "submitBtn")
	private WebElement rpp_finsish_paymentplan ;

	@FindBy(id = "OKBut")
	private WebElement rpp_Yes_btn ;

	@FindBy(name = "transactionDataBean.password")
	private WebElement rpp_VoidPassword ;

	@FindBy(name = "Submit22")
	private WebElement rpp_VoidPymentPlan ;
	
	@FindBy(name = "requestBean.password")
	private WebElement scheduleACH_Password ;
	
	@FindBy(name = "Submit22")
	private WebElement reschdule_Payment ;
	
	@FindBy(name = "submit")
	private WebElement ACHReturn_Submitbtn ;
	
	@FindBy(name = "rtnReasonId")
	private WebElement ACHReturn_CustReason ;
	
	@FindBy(name = "CmdReturnPosting")
	private WebElement FinishCustomerACHReturn ;
	
	public void set_pam_Pin(String spam_Pin) {
		doIT(pam_Pin, spam_Pin);
	}
	
	
	private String CustNbr="//input[contains(@value,'DYNAMIC_TEXT')]";
	
	public void click_CustNbr(String returncust) {
		doIT(getWebElementForDynamicText(CustNbr,returncust),returncust);		
	}
	
	public void click_reschdule_Payment(String sreschdule_Payment) {
		doIT(reschdule_Payment, sreschdule_Payment);
	}
	
	public void click_ACHReturn_Submitbtn(String sACHReturn_Submitbtn) {
		doIT(ACHReturn_Submitbtn, sACHReturn_Submitbtn);
	}
	
	public void click_FinishCustomerACHReturn(String sFinishCustomerACHReturn) {
		doIT(FinishCustomerACHReturn, sFinishCustomerACHReturn);
	}
	

	public void click_rpp_VoidPymentPlan(String data) {
		doIT(rpp_VoidPymentPlan, data);
	}

	public void click_rpp_next_btn(String data) {
		doIT(rpp_next_btn, data);
	}


	public void set_rpp_VoidPassword(String srpp_VoidPassword) {
		doIT(rpp_VoidPassword, srpp_VoidPassword);
	}
	
	public void set_ACHReturn_CustReason(String sACHReturn_CustReason) {
		doIT(ACHReturn_CustReason, sACHReturn_CustReason);
	}

	public void set_rpp_password(String srpp_password) {
		new WebDriverWait(driver,120).until(ExpectedConditions.visibilityOf(rpp_password));
		doIT(rpp_password, srpp_password);
	}
	
	public void set_ACHreturn_StoreNO(String sACHreturn_StoreNO) {
		new WebDriverWait(driver,120).until(ExpectedConditions.visibilityOf(ACHreturn_StoreNO));
		doIT(ACHreturn_StoreNO, sACHreturn_StoreNO);
	}
	
	public void set_scheduleACH_Password(String sscheduleACH_Password) {
		doIT(scheduleACH_Password, sscheduleACH_Password);
	}

	public void click_rpp_finsish_paymentplan(String data) {
		doIT(rpp_finsish_paymentplan, data);
	}
	public void click_rpp_Yes_btn(String srpp_Yes_btn) {
		doIT(rpp_Yes_btn, srpp_Yes_btn);
	} 

	public String get_payDay_LoanAmount(String data){
		return doIT(payDay_LoanAmount, data).trim();
	}
	
	public String get_ACH_Status(String data){
		return doIT(ACH_Status, data);
	}

	public void set_payDay_CollateralType(String spayDay_CollateralType) {
		doIT(payDay_CollateralType, spayDay_CollateralType);
	}

	public void set_payDay_noOfChecks(String spayDay_noOfChecks) {
		doIT(payDay_noOfChecks, spayDay_noOfChecks);
	}

	public void set_payDay_checkNo(String spayDay_checkNo) {
		doIT(payDay_checkNo, spayDay_checkNo);
	}

	public void set_payDay_LoanAmount(String spayDay_LoanAmount) {
		doIT(payDay_LoanAmount, spayDay_LoanAmount);
	}

	public void set_payDay_DueDateMonth(String spayDay_DueDateMonth) {
		doIT(payDay_DueDateMonth, spayDay_DueDateMonth);
	}

	public void set_payDay_DueDateDay(String spayDay_DueDateDay) {
		doIT(payDay_DueDateDay, spayDay_DueDateDay);
	}

	public void set_payDay_DueDateYear(String spayDay_DueDateYear) {
		doIT(payDay_DueDateYear, spayDay_DueDateYear);
	}

	public void set_payDay_RoutingNo(String spayDay_RoutingNo) {
		doIT(payDay_RoutingNo, spayDay_RoutingNo);
	}

	public void set_payDay_CheckingAccountNo(String spayDay_CheckingAccountNo) {
		doIT(payDay_CheckingAccountNo, spayDay_CheckingAccountNo);
	}

	public void set_payDay_DisbType(String spayDay_DisbType) {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(payDay_DisbType));}catch(Exception e) {}
		doIT(payDay_DisbType, spayDay_DisbType);
	}

	public void set_payDay_DisbAmount(String spayDay_DisbAmount) {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(payDay_DisbAmount));}catch(Exception e) {}
		doIT(payDay_DisbAmount, spayDay_DisbAmount);
	}

	public void set_payDay_PaymentReminderConsent(String spayDay_PaymentReminderConsent) {
		doIT(payDay_PaymentReminderConsent, spayDay_PaymentReminderConsent);
	}

	public void set_payDay_ElectronicCommunicationConsent(String spayDay_ElectronicCommunicationConsent) {
		doIT(payDay_ElectronicCommunicationConsent, spayDay_ElectronicCommunicationConsent);
	}

	public void set_payDay_UserPassword(String spayDay_UserPassword) {
		doIT(payDay_UserPassword, spayDay_UserPassword);
	}

	public void click_payDay_CancelButton(String data) {
		doIT(payDay_CancelButton, data);
	}

	public boolean isDisplayed_payDay_EligibilityButton() {
		return isDisplayed(payDay_EligibilityButton);
	}
	
	public void click_payDay_EligibilityButton(String data) {
		if(!data.isEmpty()) {
			doIT(payDay_EligibilityButton, data);	
			acceptAlert();
			waitForFinshButton();
		}

	}
	
	public void waitForFinshButton() {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(payDay_FinishLoanButton));}catch(Exception e) {}
	}

	public boolean isDisplayed_payDay_FinishLoanButton() {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(payDay_FinishLoanButton));}catch(Exception e) {}
		return isDisplayed(payDay_FinishLoanButton);
	}
	
	public void click_payDay_FinishLoanButton(String data) {
		if(!data.isEmpty()) {
			doIT(payDay_FinishLoanButton, data);
			acceptAlert();
			acceptAlert();
		}
	}

	public void click_payDay_ProcessLaon(String data) {
		if(!data.isEmpty()) {
			doIT(payDay_ProcessLaon, data);
			acceptAlert();
		}
	}

	public String get_payDay_NoBankAlertMsg(String data) {
		String found="";	
		if(!data.isEmpty()) {
			found=getAlertText();
		}	
		return found;
	}
	
	public String getAlertText(String data) {
		if(!data.isEmpty()) {
			System.out.println(AlertDecesion("getText"));
			return  AlertDecesion("getText").trim();
			
		}else {
			return null;
		}
	}
	public void acceptPrinterPopUp() throws Exception {
		try {
			Robot robot = new Robot();
			Thread.sleep(2000);	
	        robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
	public boolean isDisplayed_rpp_finsish_paymentplan() {
		return isDisplayed(rpp_finsish_paymentplan);
	}
	
	public boolean isDisplayed_rpp_VoidPymentPlan() {
		return isDisplayed(rpp_VoidPymentPlan);
	}
	
	public boolean isDisplayed_reschdule_Payment() {
		return isDisplayed(reschdule_Payment);
	}
	
	public boolean isDisplayed_FinishCustomerACHReturn() {
		return isDisplayed(FinishCustomerACHReturn);
	}
}
