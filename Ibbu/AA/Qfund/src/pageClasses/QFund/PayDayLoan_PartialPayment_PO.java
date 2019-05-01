package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class PayDayLoan_PartialPayment_PO extends BasePage {

	public PayDayLoan_PartialPayment_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(name = "transactionList")
	private WebElement payDay_TransactionSelectionType;

	@FindBy(name = "button")
	private WebElement payDay_SelectTransaction;

	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement payDay_PaymentAmount;

	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement payDay_PartialPaymentAmount;

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement payDay_PartialPaymentTenderTypeone;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement payDay_PartialPaymentTenderAmountone;

	@FindBy(name = "transactionDataBean.tenderTypeSecond")
	private WebElement payDay_PartialPaymentTenderTypeSecond;

	@FindBy(name = "transactionDataBean.tenderAmtSecond")
	private WebElement payDay_PartialPaymentTenderAmountsecond;

	@FindBy(name = "transactionDataBean.password")
	private WebElement payDay_PartialPaymentUserPassword;

	@FindBy(name = "requestBean.password")
	private WebElement ach_Password;

	@FindBy(name = "finish") // this element also uses for pam payment
	private WebElement payDay_PartialPaymentFinish;

	@FindBy(name = "Submit22") // this element also uses for pam payment
	private WebElement FinishACHPrePayment;

	@FindBy(name = "Submit22")
	private WebElement payDay_RppPaymentPlan;

	@FindBy(xpath = "//td[@class='leftHeading']")
	private WebElement payDay_Rpp_Succesmsg;

	public String get_payDay_Rpp_Succesmsg(String spayDay_Rpp_Succesmsg) {
		return doIT(payDay_Rpp_Succesmsg, spayDay_Rpp_Succesmsg)
				.replace("Would you like to complete another transaction for this Customer?", "").trim();

	}
	
	// paydayloan buyback locators

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement payDay_BuyBackTenderType;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement payDay_BuyBackTenderAmount;

	@FindBy(name = "transactionDataBean.password")
	private WebElement payDay_BuyBackUserPassword;

	@FindBy(name = "advanceRequestBean.loggedUserPassword")
	private WebElement payDay_CashAtStorePin;

	@FindBy(name = "password")
	private WebElement payDay_RPPPaymentUserPassword;

	@FindBy(name = "finish")
	private WebElement payDay_BuyBackFinishButton;

	// Cash at store
	@FindBy(name = "finishadvance")
	private WebElement payDay_CashAtStoreFinishButton;

	@FindBy(xpath = "(//*[@name='OKBut'])[2]")
	private WebElement payDay_cashAtStoreYesBtn;

	@FindBy(xpath = "//input[@name='Ok']")
	private WebElement ok_Button;

	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement payDay_PartialPaymentAmt;

	// PAM payoff elements
	@FindBy(name = "tenderType")
	private WebElement payDay_BuyBackTenderType_payoff;

	@FindBy(name = "tenderAmount")
	private WebElement payDay_BuyBackTenderAmount_payoff;

	@FindBy(name = "password")
	private WebElement payDay_BuyBackUserPassword_payoff;

	@FindBy(name = "Submit22")
	private WebElement payDay_BuyBackFinishButton_payoff;

	@FindBy(name = "payOffAmount")
	private WebElement LnPymnt_pymnt_CCMONBR_txt_payoff;

	@FindBy(xpath = "//a[contains(@href,'ssno')]")
	private WebElement payDay_RppCustInfo;

	@FindBy(name = "customerBean.accountNbrDisp")
	private WebElement payDay_CustAccountDisp;

	@FindBy(name = "transactionDataBean.chkgAcctNbr")
	private WebElement payDay_CheckingAccountNo;

	@FindBy(name = "transactionDataBean.ccmoNbrFirst")
	private WebElement LnPymnt_Tender_CCMONBR;

	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement LnPymnt_pymnt_CCMONBR_txt;
	
	@FindBy(className="leftHeading")
	private WebElement voidLnPymn_Confirm_Text;

	// PAM buback element
	@FindBy(name = "transactionDataBean.paymentAmt")
	private WebElement LnPymnt_pymnt_CCMONBR_txt_buybkpam;

	// PAM payment

	@FindBy(id = "PD4")
	private WebElement pymnt_radiobtn_paymentAmt_pam;

	@FindBy(id = "PD3")
	private WebElement pymnt_radiobtn_Payoffbalance_pam;

	@FindBy(id = "PD5")
	private WebElement pymnt_radiobtn_payotherAmt_pam;

	@FindBy(name = "requestBean.siilBean.payAmt")
	private WebElement pymnt_PaymentAmount_pam;

	@FindBy(name = "requestBean.tenderAmt")
	private WebElement pymnt_TenderAmt_pam;

	@FindBy(name = "transactionDataBean.tenderAmtFirst")
	private WebElement voidDraw_TenderAmt_pam;

	@FindBy(name = "requestBean.tenderType")
	private WebElement pymnt_DrpDwn_TenderType_pam;

	@FindBy(name = "requestBean.password")
	private WebElement pymnt_pin_pam;

	@FindBy(name = "checkno")
	private WebElement pymnt_no_pam;

	@FindBy(name = "transactionDataBean.ccmoNbrFirst")
	private WebElement Rpp_PartialPayment_CCMONo;

	@FindBy(xpath = "//input[@value='No']")
	private WebElement pay_AnotherTransactionNO;

	@FindBy(xpath = "//input[@value='Yes']")
	private WebElement pay_AnotherTransactionYES;

	@FindBy(xpath = "//input[@name='htmlPayAmt']")
	private WebElement voidDraw_drawAmt;

	@FindBy(name = "transactionDataBean.tenderTypeFirst")
	private WebElement voidDraw_TenderType_pam;
	
	@FindBy(name = "transactionDataBean.tenderType")
	private WebElement voiddraw_tendertyp_csr;

	@FindBy(xpath = "//input[@name='ok']")
	private WebElement ok_Button_payoff;
	
	public String get_LnPymnt_Confirm_Text(String data) {
		
		return doIT(voidLnPymn_Confirm_Text, data);
	}

	public void click_ok_Button_payoff(String data) {
		doIT(ok_Button_payoff, data);
	}

	public void click_pymnt_no_pam(String data) {
		//wait.until(ExpectedConditions.elementToBeClickable(pymnt_no_pam));
		doIT(pymnt_no_pam, data);
	}

	public void click_pay_AnotherTransactionYES(String data) {
		doIT(pay_AnotherTransactionYES, data);
	}

	public void click_pay_AnotherTransactionNO(String data) {
		doIT(pay_AnotherTransactionNO, data);
	}

	// PAM payment methds
	public void click_pymnt_radiobtn_paymentAmt_pam(String data) {
		doIT(pymnt_radiobtn_paymentAmt_pam, data);
	}

	public void set_pymnt_TenderAmt_pam(String spymnt_TenderAmt_pam) {
		doIT(pymnt_TenderAmt_pam, spymnt_TenderAmt_pam);
	}

	public String get_pymnt_PaymentAmount_pam(String spymnt_PaymentAmount_pam) {
		return doIT(pymnt_PaymentAmount_pam, spymnt_PaymentAmount_pam).trim();
	}

	public String get_voidDraw_drawAmt(String svoidDraw_drawAmt) {
		return doIT(voidDraw_drawAmt, svoidDraw_drawAmt).trim();
	}
	
	public String get_payDay_PaymentAmount(String spayDay_PaymentAmount) {
		return doIT(payDay_PaymentAmount, spayDay_PaymentAmount);
	}

	public void set_voidDraw_TenderAmt_pam(String svoidDraw_TenderAmt_pam) {
		doIT(voidDraw_TenderAmt_pam, svoidDraw_TenderAmt_pam);
	}

	public void set_pymnt_DrpDwn_TenderType_pam(String spymnt_DrpDwn_TenderType_pam) {
		doIT(pymnt_DrpDwn_TenderType_pam, spymnt_DrpDwn_TenderType_pam);
	}

	public void click_ok_Button(String data) {
		doIT(ok_Button, data);
	}

	public void set_pymnt_pin_pam(String spymnt_pin_pam) {
		doIT(pymnt_pin_pam, spymnt_pin_pam);
	}

	// PAM buyback
	public String get_LnPymnt_pymnt_CCMONBR_txt_buybkpam(String sLnPymnt_pymnt_CCMONBR_txt_buybkpam) {
		return doIT(LnPymnt_pymnt_CCMONBR_txt_buybkpam, sLnPymnt_pymnt_CCMONBR_txt_buybkpam).trim();
	}

	// PAM payoff methods

	public String get_LnPymnt_pymnt_CCMONBR_txt_payoff(String sLnPymnt_pymnt_CCMONBR_txt_payoff) {
		return doIT(LnPymnt_pymnt_CCMONBR_txt_payoff, sLnPymnt_pymnt_CCMONBR_txt_payoff).trim();
	}

	public void set_payDay_BuyBackTenderAmount_payoff(String spayDay_BuyBackTenderAmount_payoff) {
		doIT(payDay_BuyBackTenderAmount_payoff, spayDay_BuyBackTenderAmount_payoff);
	}

	public void set_payDay_BuyBackTenderType_payoff(String spayDay_BuyBackTenderType_payoff) {
		doIT(payDay_BuyBackTenderType_payoff, spayDay_BuyBackTenderType_payoff);
	}

	public void set_payDay_BuyBackUserPassword_payoff(String spayDay_BuyBackUserPassword_payoff) {
		doIT(payDay_BuyBackUserPassword_payoff, spayDay_BuyBackUserPassword_payoff);
	}

	public void set_Rpp_PartialPayment_CCMONo(String sRpp_PartialPayment_CCMONo) {
		doIT(Rpp_PartialPayment_CCMONo, sRpp_PartialPayment_CCMONo);
	}

	public void click_payDay_BuyBackFinishButton_payoff(String data) {
		doIT(payDay_BuyBackFinishButton_payoff, data);
	}

	public void set_voidDraw_TenderType_pam(String svoidDraw_TenderType_pam) {
		doIT(voidDraw_TenderType_pam, svoidDraw_TenderType_pam);
	}
	
	public void set_voidDraw_TenderType_csr(String svoidDraw_TenderType_csr) {
		doIT(voiddraw_tendertyp_csr,svoidDraw_TenderType_csr);
			
		}

	// Payday

	// public void set_payDay_PartialPaymentAmt(String spayDay_PartialPaymentAmt) {
	// doIT(payDay_PartialPaymentAmt, spayDay_PartialPaymentAmt);
	// }

	public String get_LnPymnt_pymnt_CCMONBR_txt(String sLnPymnt_pymnt_CCMONBR_txt) {
		return doIT(LnPymnt_pymnt_CCMONBR_txt, sLnPymnt_pymnt_CCMONBR_txt).trim();
	}

	public void set_payDay_CheckingAccountNo(String spayDay_CheckingAccountNo) {
		doIT(payDay_CheckingAccountNo, spayDay_CheckingAccountNo);
	}

	public void set_payDay_TransactionSelectionType(String spayDay_TransactionSelectionType) {
		doIT(payDay_TransactionSelectionType, spayDay_TransactionSelectionType);
	}

	public void set_payDay_SelectTransaction(String spayDay_SelectTransaction) {
		doIT(payDay_SelectTransaction, spayDay_SelectTransaction);
	}

	public void set_payDay_PaymentAmount(String spayDay_PaymentAmount) {
		if (spayDay_PaymentAmount != null) {
			payDay_PaymentAmount.clear();
		}
		doIT(payDay_PaymentAmount, spayDay_PaymentAmount);

	}

	public void set_payDay_PartialPaymentAmount(String spayDay_PartialPaymentAmount) {
		if (spayDay_PartialPaymentAmount != null) {
			payDay_PaymentAmount.clear();
		}

		doIT(payDay_PartialPaymentAmount, spayDay_PartialPaymentAmount);
	}

	public String get_payDay_PartialPaymentAmount(String spayDay_PartialPaymentAmount) {
		return doIT(payDay_PartialPaymentAmount, spayDay_PartialPaymentAmount).trim();
	}

	public String get_payDay_CustAccountDisp(String spayDay_CustAccountDisp) {
		return doIT(payDay_CustAccountDisp, spayDay_CustAccountDisp);
	}

	public void set_payDay_PartialPaymentTenderTypeone(String spayDay_PartialPaymentTenderTypeone) {
		doIT(payDay_PartialPaymentTenderTypeone, spayDay_PartialPaymentTenderTypeone);
		new Select(payDay_PartialPaymentTenderTypeone).selectByVisibleText(spayDay_PartialPaymentTenderTypeone);
	}

	public void set_payDay_PartialPaymentTenderAmountone(String spayDay_PartialPaymentTenderAmountone) {
		doIT(payDay_PartialPaymentTenderAmountone, spayDay_PartialPaymentTenderAmountone);
	}

	public void set_payDay_PartialPaymentTenderTypeSecond(String spayDay_PartialPaymentTenderTypeSecond) {
		doIT(payDay_PartialPaymentTenderTypeSecond, spayDay_PartialPaymentTenderTypeSecond);
	}

	public void set_payDay_PartialPaymentTenderAmountsecond(String spayDay_PartialPaymentTenderAmountsecond) {
		doIT(payDay_PartialPaymentTenderAmountsecond, spayDay_PartialPaymentTenderAmountsecond);
	}

	public void set_payDay_PartialPaymentUserPassword(String spayDay_PartialPaymentUserPassword) {
		doIT(payDay_PartialPaymentUserPassword, spayDay_PartialPaymentUserPassword);
	}

	public void set_ach_Password(String data) {
		doIT(ach_Password, data);
	}

	public void set_payDay_PartialPaymentFinish(String spayDay_PartialPaymentFinish) {
		doIT(payDay_PartialPaymentFinish, spayDay_PartialPaymentFinish);
	}

	public void set_payDay_BuyBackTenderType(String spayDay_BuyBackTenderType) {
		doIT(payDay_BuyBackTenderType, spayDay_BuyBackTenderType);
	}

	public void set_payDay_BuyBackTenderAmount(String spayDay_BuyBackTenderAmount) {
		doIT(payDay_BuyBackTenderAmount, spayDay_BuyBackTenderAmount);
	}

	public void set_payDay_BuyBackUserPassword(String spayDay_BuyBackUserPassword) {
		doIT(payDay_BuyBackUserPassword, spayDay_BuyBackUserPassword);
	}

	public void set_payDay_CashAtStorePin(String spayDay_BuyBackUserPassword) {
		doIT(payDay_CashAtStorePin, spayDay_BuyBackUserPassword);
	}

	public void set_payDay_RPPPaymentUserPassword(String spayDay_RPPPaymentUserPassword) {
		doIT(payDay_RPPPaymentUserPassword, spayDay_RPPPaymentUserPassword);
	}

	public void click_payDay_BuyBackFinishButton(String data) {
		doIT(payDay_BuyBackFinishButton, data);
	}

	// Cash at store
	public void click_payDay_CashAtLoanFinishButton(String data) {
		doIT(payDay_CashAtStoreFinishButton, data);
	}

	public void click_CashAtStoreYesBtn(String data) {
		selectFrame(frameMain);
		doIT(payDay_cashAtStoreYesBtn, data);
	}

	public void click_payDay_RppPaymentPlan(String spayDay_RppPaymentPlan) {
		doIT(payDay_RppPaymentPlan, spayDay_RppPaymentPlan);
	}

	public void click_payDay_PartialPaymentFinish(String data) {
		doIT(payDay_PartialPaymentFinish, data);
	}

	public boolean isDisplayed_payDay_PartialPaymentFinish() {
		return isDisplayed(payDay_PartialPaymentFinish);
	}

	public boolean isDisplayed_FinishACHPrePayment() {
		return isDisplayed(FinishACHPrePayment);
	}

	public void click_FinishACHPrePayment(String data) {
		doIT(FinishACHPrePayment, data);
	}

	public void click_payDay_RppCustInfo(String spayDay_RppCustInfo) {
		doIT(payDay_RppCustInfo, spayDay_RppCustInfo);
	}

	public void set_LnPymnt_Tender_CCMONBR(String lnPymnt_Tender_CCMONBR) {
		doIT(LnPymnt_Tender_CCMONBR, lnPymnt_Tender_CCMONBR);
	}

	public String getAlertText(String data) {
		if (!data.isEmpty()) {
			System.out.println(AlertDecesion("getText"));
			return AlertDecesion("getText").trim();

		} else {
			return null;
		}
	}
	
	public boolean isDisplayed_payDay_CashAtStoreFinishButton() {
		return isDisplayed(payDay_CashAtStoreFinishButton);
	}
}
