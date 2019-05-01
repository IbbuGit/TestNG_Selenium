package pageClasses.QFund;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_Transactions_Title_PO extends BasePage {

	public LoanTransactions_Transactions_Title_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(name = "checkok")
	private WebElement Payment_Confirm;

	@FindBy(id = "PD3")
	public WebElement PayOff_CheckBox;

	@FindBy(id = "PD4")
	public WebElement PaymentAmt_CheckBox;

	@FindBy(id = "PD5")
	public WebElement PayanyotherAmt_CheckBox;

	@FindBy(name = "cancel")
	private WebElement ts_CancelButtion;

	@FindBy(name = "submit1")
	private WebElement ts_SubmitButtion;

	@FindBy(name = "button")
	private WebElement pay_Type;

	@FindBy(name = "requestBean.siilBean.payAmt")
	private WebElement ts_PaymentAmount;

	@FindBy(name = "requestBean.siilBean.tenderTypeFirst")
	private WebElement ts_Tender_Type1;
	
	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement cl_Tender_Type1;
	
	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement cl_Tender_Amt1;

	@FindBy(name = "transactionDataBean.tenderTypeSecond")
	private WebElement cl_Tender_Type2;
	
	@FindBy(name = "transactionDataBean.tenderAmtSecond")
	private WebElement cl_Tender_Amt2;

	@FindBy(name = "transactionDataBean.paymentBalAmt")
	private WebElement cl_PaymentBal_Amt;

	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement cl_Payment_Amt;

	
	
	@FindBy(name = "requestBean.siilBean.tenderAmtFirst")
	private WebElement ts_Tender_Amt1;

	@FindBy(name = "requestBean.siilBean.tenderTypeSecond")
	private WebElement ts_Tender_Type2;

	@FindBy(name = "requestBean.siilBean.tenderAmtSecond")
	private WebElement ts_Tender_Amt2;

	@FindBy(name = "requestBean.siilBean.ccmoNbrFirst")
	private WebElement ts_Tender_CCMONBR;

	@FindBy(name = "requestBean.password")
	private WebElement ts_Drawer_PIN;

	@FindBy(name = "finish")
	private WebElement ts_Finsih_Button;

	@FindBy(className = "leftHeading")
	private WebElement ts_Confirm_Text;

	@FindBy(xpath = "(//input[(@value='Yes') and (@type='button')])[2]")
	private WebElement ts_RenewLoanButton;

	public void set_ts_paytype(String data) {
		// wait.until(ExpectedConditions.visibilityOf(PayOff_CheckBox));
		if (data.equalsIgnoreCase("Pay Off the balance")) {
			doIT(PayOff_CheckBox, data);
		} else if (data.equalsIgnoreCase("Payment Amount")) {
			doIT(PaymentAmt_CheckBox, data);
		} else if (data.equalsIgnoreCase("Pay any other Amt")) {
			doIT(PayanyotherAmt_CheckBox, data);
		}
	}

	public String get_ts_PaymentAmount(String data) {
		return doIT(ts_PaymentAmount, data);
	}

	public void set_ts_PaymentAmount(String data) {
		doIT(ts_PaymentAmount, data);
	}

	public String get_ts_Tender_Type1(String data) {
		return doIT(ts_Tender_Type1, data);
	}

	public void set_ts_Tender_Type1(String data) {
		doIT(ts_Tender_Type1, data);
	}

	public void set_ts_Tender_Type2(String data) {
		doIT(ts_Tender_Type2, data);
	}

	public String get_ts_Tender_Amt1(String data) {
		return doIT(ts_Tender_Amt1, data);
	}

	public void set_ts_Tender_Amt1(String data) {
		doIT(ts_Tender_Amt1, data);
	}

	public void set_ts_Tender_Amt2(String data) {
		doIT(ts_Tender_Amt2, data);
	}

	public String get_ts_Tender_CCMONBR(String data) {
		return doIT(ts_Tender_CCMONBR, data);
	}

	public void set_ts_Tender_CCMONBR(String data) {
		if (data.equalsIgnoreCase("Random")) {
			doIT(ts_Tender_CCMONBR, RandomStringUtils.randomNumeric(9));
		} else {
			doIT(ts_Tender_CCMONBR, data);
		}

	}

	public String get_ts_Drawer_PIN(String data) {
		return doIT(ts_Drawer_PIN, data);
	}

	public void set_ts_Drawer_PIN(String data) {
		doIT(ts_Drawer_PIN, data);
	}

	public void click_ts_SubmitButtion(String data) {
		doIT(ts_SubmitButtion, data);
	}

	public void click_ts_Finsih_Button(String data) {
		doIT(ts_Finsih_Button, data);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click_ts_RenewLoanButton(String data) {
		doIT(ts_RenewLoanButton, data);
	}

	public void click_ts_Payment_Confirm(String data) {
		doIT(Payment_Confirm, data);
	}

	public String get_ts_Confirm_Text(String data) {
		return doIT(ts_Confirm_Text, data);
	}

	public String get_ts_PayAny_Other(String data) {
		return doIT(ts_PaymentAmount, data);
	}

	public void set_ts_PayAny_Other(String lnPymnt_PayAny_Other) {
		doIT(ts_PaymentAmount, lnPymnt_PayAny_Other);
	}

	/*
	 * title trasactions
	 */

	@FindBy(name = "button")
	private WebElement ts_Select;

	@FindBy(name = "transactionList")
	private WebElement ts_SelectTransaction;

	@FindBy(name = "button")
	private WebElement ts_SelectTransaction_SelectButton;

	@FindBy(name = "tenderType")
	private WebElement ts_tenderType;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement ts_tenderAmount;

	@FindBy(xpath = "//b[contains(text(),'Loan Amt')]/../following-sibling::td/b")
	private WebElement ts_Loan_Amount;

	@FindBy(name = "requestBean.password")
	private WebElement ts_UserID_Pin;

	@FindBy(name = "YES")
	private WebElement ts_EncryptionCode_Yes;

	@FindBy(name = "NO")
	private WebElement ts_EncryptionCode_No;

	@FindBy(name = "finish")
	private WebElement ts_FinishVoidLoanButton;

	@FindBy(xpath = "//td[@class='leftHeading']")
	private WebElement ts_VoidLoan_Completed;

	@FindBy(xpath = "//td[contains(text(),'Transaction Selection')]")
	private WebElement ts_TransactionSelectionPage;

	public String get_ts_tenderAmount(String data) {
		return doIT(ts_tenderAmount, data);
	}

	public void set_ts_tenderAmount(String data) {
		doIT(ts_tenderAmount, data);
	}

	public String get_ts_Loan_Amount(String data) {
		return doIT(ts_Loan_Amount, data).replace("$", "").replace(" ", "").trim();
	}

	public void set_ts_Loan_Amount(String transaction_Loan_Amount) {
		doIT(ts_Loan_Amount, transaction_Loan_Amount);
	}

	// public String get_ts_Loan_Amount(String data){
	// return doIT(ts_Loan_Amount, data).replace("$", "").replace(" ",
	// "").trim();
	// }
	//
	// public void set_ts_tenderAmount(String ts_tenderAmount) {
	// doIT(ts_tenderAmount, ts_tenderAmount);
	// }

	public String get_ts_SelectTransaction(String data) {
		return doIT(ts_SelectTransaction, data);
	}

	public void set_ts_SelectTransaction(String data) {
		doIT(ts_SelectTransaction, data);
	}

	public String get_ts_tenderType(String data) {
		return doIT(ts_tenderType, data);
	}

	public void set_ts_tenderType(String data) {
		doIT(ts_tenderType, data);
	}

	public String get_ts_UserID_Pin(String data) {
		return doIT(ts_UserID_Pin, data);
	}

	public void set_ts_UserID_Pin(String data) {
		doIT(ts_UserID_Pin, data);
	}

	public void click_ts_SelectTransaction_SelectButton(String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0]);", ts_SelectTransaction_SelectButton);
	}

	public void click_ts_EncryptionCode_Yes(String data) {
		doIT(ts_EncryptionCode_Yes, data);
	}

	public void click_ts_EncryptionCode_No(String data) {
		doIT(ts_EncryptionCode_No, data);
	}

	public void click_ts_FinishVoidLoanButton(String data) {
		doIT(ts_FinishVoidLoanButton, data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		acceptAlert();

	}

	public String verifyText() {
		return ts_VoidLoan_Completed.getText();

	}

	public String get_ts_TransactionSelectionPage(String data) {
		return doIT(ts_TransactionSelectionPage, data);

	}

	public void click_CustomerForLoanNumber(String Loan_nbr) {
		String elementStringGo = "//td[contains(text(),'" + Loan_nbr + "')]/..//input[@value='Go']";
		WebElement elementGo = driver.findElement(By.xpath(elementStringGo));
		// element);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0]);", elementGo);
	}

	/*
	 * Voluntary Surrender Transaction
	 */

	@FindBy(xpath = "//*[contains(text(),'Voluntary Surrender Transaction')]")
	private WebElement vs_PageHeader;

	@FindBy(xpath = "//*[contains(text(),'Payment Details')]")
	private WebElement vs_PaymentDetailsHeader;

	@FindBy(xpath = "//*[contains(text(),'Principal Due')]/../following-sibling::tr/td[1]")
	private WebElement vs_VerifyPrincipalDue;

	@FindBy(xpath = "//*[contains(text(),'Interest Due')]/../following-sibling::tr/td[2]")
	private WebElement vs_VerifyInterestDue;

	@FindBy(xpath = "//*[contains(text(),'Loan Fee Due')]/../following-sibling::tr/td[3]")
	private WebElement vs_VerifyLoanFeeDue;

	@FindBy(xpath = "//*[contains(text(),'Repo Fee Due')]/../following-sibling::tr/td[5]")
	private WebElement vs_VerifyRepoFeeDue;

	@FindBy(xpath = "//*[contains(text(),'Amount Owed')]/../following-sibling::tr/td[9]")
	private WebElement vs_VerifyAmountOwed;

	@FindBy(name = "requestBean.totDueAmt")
	private WebElement vs_VeifyVoluntarySurrenderAmount;

	@FindBy(name = "requestBean.comments")
	private WebElement vs_Comments;

	@FindBy(xpath = "//*[contains(text(),'Transaction Completed Successfully.')]")
	private WebElement vs_Validation;

	@FindBy(xpath = "//*[contains(text(),'Transaction Voided Successfully.')]")
	private WebElement vp_Validation;

	public String get_vs_PageHeader(String TestData_slv_VerifyInterestDue) {
		return doIT(vs_PageHeader, TestData_slv_VerifyInterestDue.trim()).trim();
	}

	public String get_vs_PaymentDetailsHeader(String TestData_slv_VerifyInterestDue) {
		return doIT(vs_PaymentDetailsHeader, TestData_slv_VerifyInterestDue);
	}

	public String get_vs_VeifyVoluntarySurrenderAmount(String TestData_slv_VerifyInterestDue) {
		return doIT(vs_VeifyVoluntarySurrenderAmount, TestData_slv_VerifyInterestDue);
	}

	public void set_vs_Comments(String data) {
		doIT(vs_Comments, data);
	}

	public String get_vs_Validation(String TestData_slv_VerifyInterestDue) {
		return doIT(vs_Validation, TestData_slv_VerifyInterestDue);
	}

	public String get_vp_Validation(String TestData_slv_VerifyInterestDue) {
		return doIT(vp_Validation, TestData_slv_VerifyInterestDue);

	}

	/*
	 * Common
	 */

	@FindBy(name = "requestBean.User|empid")
	private WebElement tran_VerifyUserId;

	@FindBy(name = "password")
	private WebElement tran_PIN;

	@FindBy(name = "requestBean.password")
	private WebElement tran_PIN2;

	@FindBy(name = "finish")
	private WebElement tran_SubmitButton;

	@FindBy(xpath = "//input[@value='Finish']")
	private WebElement tran_FinishButton;

	@FindBy(name = "cancel|cancelLoan")
	private WebElement tran_CancelButton;

	@FindBy(name = "history|Submit36")
	private WebElement tran_HistoryButton;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement tran_ValidationOKButton;
	
	
	public String get_tran_VerifyUserId(String TestData_tran_VerifyUserId) {
		return doIT(tran_VerifyUserId, TestData_tran_VerifyUserId);
	}

	public void set_tran_PIN(String TestData_tran_PIN) {
		doIT(tran_PIN, TestData_tran_PIN);
	}

	public void set_tran_PIN2(String TestData_tran_PIN) {
		doIT(tran_PIN2, TestData_tran_PIN);
	}

	public void click_tran_SubmitButton(String TestData_tran_SubmitButton) {
		doIT(tran_SubmitButton, TestData_tran_SubmitButton);
	}

	public void click_tran_FinishButton(String TestData_tran_SubmitButton) {
		doIT(tran_FinishButton, TestData_tran_SubmitButton);
	}

	public void click_tran_CancelButton(String TestData_tran_CancelButton) {
		doIT(tran_CancelButton, TestData_tran_CancelButton);
	}

	public void click_tran_HistoryButton(String TestData_tran_HistoryButton) {
		doIT(tran_HistoryButton, TestData_tran_HistoryButton);
	}

	public void click_tran_ValidationOKButton(String TestData_tran_ValidationOKButton) {
		doIT(tran_ValidationOKButton, TestData_tran_ValidationOKButton);
	}

	
	
	
	/*
	 * 	Default Payment
	 */
	
	@FindBy(xpath = "//*[contains(text(),'Default Payment')]")
	private WebElement dp_PageHeader;

	@FindBy(xpath = "//*[contains(text(),'Payment Details')]")
	private WebElement dp_PaymentDetailsHeader;

	@FindBy(name = "transactionDataBean.paymentBalAmt")
	private WebElement dp_VerifyDefaultBalance;
	
	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement dp_PaymentAmount;

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement dp_Tender_Type1;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement dp_Tender_Amt1;

	@FindBy(name = "transactionDataBean.ccmoNbrFirst")
	private WebElement dp_Tender_CCMONBR1;

	@FindBy(name = "transactionDataBean.tenderTypeSecond")
	private WebElement dp_Tender_Type2;

	@FindBy(name = "transactionDataBean.tenderAmtSecond")
	private WebElement dp_Tender_Amt2;

	@FindBy(name = "transactionDataBean.ccmoNbrSecond")
	private WebElement dp_Tender_CCMONBR2;

	@FindBy(name = "transactionDataBean.htmlChange")
	private WebElement dp_Change;

	@FindBy(name = "password")
	private WebElement dp_Drawer_PIN;

	@FindBy(name = "Submit22")
	private WebElement dp_Finsih_Button;

	@FindBy(xpath = "//*[contains(text(),'default payment completed successfully.')]")
	private WebElement dp_Validation;
	
	public String get_dp_PageHeader(String TestData_dp_PageHeader) {
		return doIT(dp_PageHeader, TestData_dp_PageHeader);
	}

	public String get_dp_PaymentDetailsHeader(String TestData_dp_PaymentDetailsHeader) {
		return doIT(dp_PaymentDetailsHeader, TestData_dp_PaymentDetailsHeader);
	}

	public void set_dp_VerifyDefaultBalance(String TestData_dp_VerifyDefaultBalance) {
		doIT(dp_VerifyDefaultBalance, TestData_dp_VerifyDefaultBalance);
	}

	public void set_dp_PaymentAmount(String TestData_dp_PaymentAmount) {
		doIT(dp_PaymentAmount, TestData_dp_PaymentAmount);
	}

	public void set_dp_Tender_Type1(String TestData_dp_Tender_Type1) {
		doIT(dp_Tender_Type1, TestData_dp_Tender_Type1);
	}

	public void set_dp_Tender_Amt1(String TestData_dp_Tender_Amt1) {
		doIT(dp_Tender_Amt1, TestData_dp_Tender_Amt1);
	}

	public void set_dp_Tender_CCMONBR1(String TestData_dp_Tender_CCMONBR1) {
		doIT(dp_Tender_CCMONBR1, TestData_dp_Tender_CCMONBR1);
	}

	public void set_dp_Tender_Type2(String TestData_dp_Tender_Type2) {
		doIT(dp_Tender_Type2, TestData_dp_Tender_Type2);
	}

	public void set_dp_Tender_Amt2(String TestData_dp_Tender_Amt2) {
		doIT(dp_Tender_Amt2, TestData_dp_Tender_Amt2);
	}

	public void set_dp_Tender_CCMONBR2(String TestData_dp_Tender_CCMONBR2) {
		doIT(dp_Tender_CCMONBR2, TestData_dp_Tender_CCMONBR2);
	}

	public String get_dp_Change(String TestData_dp_Tender_CCMONBR2) {
		return doIT(dp_Change, TestData_dp_Tender_CCMONBR2);
	}

	public void set_dp_Drawer_PIN(String TestData_dp_Drawer_PIN) {
		doIT(dp_Drawer_PIN, TestData_dp_Drawer_PIN);
	}

	public void click_dp_Finsih_Button(String TestData_dp_Finsih_Button) {
		doIT(dp_Finsih_Button, TestData_dp_Finsih_Button);
	}

	public String get_dp_Validation(String TestData_dp_Validation) {
		return doIT(dp_Validation, TestData_dp_Validation);
	}

	public String getAlertTextmsg(String data) {
		if(!data.isEmpty()) {
			
			return  AlertDecesion("getText");
			
		}else
		{
			return null;
		}
		
	}
	
	
	


//Collections

		public String get_cl_Tender_Amt1(String data) {
			return doIT(cl_Tender_Amt1, data);
		}
		
		public void set_cl_Tender_Amt1(String data) {
			doIT(cl_Tender_Amt1, data);
		}

		public String get_cl_Tender_Type1(String data) {
			return doIT(cl_Tender_Type1, data);
		}

		public void set_cl_Tender_Type1(String data) {
			doIT(cl_Tender_Type1, data);
		}

		public String get_cl_Tender_Amt2(String data) {
			return doIT(cl_Tender_Amt2, data);
		}
		
		public void set_cl_Tender_Amt2(String data) {
			doIT(cl_Tender_Amt2, data);
		}

		public String get_cl_Tender_Type2(String data) {
			return doIT(cl_Tender_Type2, data);
		}

		public void set_cl_Tender_Type2(String data) {
			doIT(cl_Tender_Type2, data);
		}
		
		
		
		public String get_cl_PaymentBal_Amt(String data) {
			return doIT(cl_PaymentBal_Amt, data);
		}

		public void set_cl_Payment_Amt(String data) {
			cl_Payment_Amt.clear();
			doIT(cl_Payment_Amt, data);
		}


}