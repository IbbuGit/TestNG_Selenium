package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class InstallmentLoanpayments_po extends BasePage {
	
	
	public InstallmentLoanpayments_po(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}
	
	@FindBy(id ="PD3")
	private WebElement PayOffTheBalance_btn;
	
	@FindBy(id ="PD4")
	private WebElement PayInstallmentAmt_btn;
	
	@FindBy(id ="PD5")
	private WebElement PayAnyOtherAmt_btn;
	
	@FindBy(name="requestBean.siilBean.payAmt")
	private WebElement PaymentAmt_textbox;
	
	@FindBy(name="requestBean.siilBean.tenderTypeFirst")
	private WebElement TenderType1_dropdown;
	
	@FindBy(name="requestBean.siilBean.tenderAmtFirst")
	private WebElement TenderAmt1_textbox;
	
	@FindBy(name="requestBean.siilBean.tenderTypeSecond")
	private WebElement TenderType2_dropdown;
	
	@FindBy(name="requestBean.siilBean.tenderAmtSecond")
	private WebElement TenderAmt2_textbox;
	
	@FindBy(name="requestBean.password")
	private WebElement Pin_textbox;
	
    @FindBy(name="back")
	private WebElement Back_btn;
	
    @FindBy(name="finish")
	private WebElement Finish_btn;
	
    @FindBy(name="history")
	private WebElement History_btn;
    
    @FindBy(xpath="//td[contains(@class,'leftHeading')]")
	private WebElement Earlypayoff_message;
    
    
    @FindBy(xpath="//td[contains(@class,'leftHeading')]")
	private WebElement Transactionsuccessfull_message;
    
    public String get_Transactionsuccessfull_message(String sPaymentAmt_textbox) {
		return doIT(  Transactionsuccessfull_message, sPaymentAmt_textbox).trim();
	}
    
    @FindBy(name="checkno")
	private WebElement AnotherTransaction_btn;
    
    public void click_AnotherTransaction_btn(String data) {
		doIT(AnotherTransaction_btn, data);
	}
    
    public String get_Earlypayoff_message(String TestData) {
		return doIT(Earlypayoff_message, TestData);
	}
    
    public String get_PayOffTheBalance_btn(String sPaymentAmt_textbox) {
		return doIT( PayOffTheBalance_btn, sPaymentAmt_textbox).trim();
	}
    
    public void click_PayOffTheBalance_btn(String data) {
		doIT(PayOffTheBalance_btn, data);
	}
	
    public void click_PayInstallmentAmt_btn(String data) {
		doIT(PayInstallmentAmt_btn, data);
	}
	
    public void click_PayAnyOtherAmt_btn(String data) {
  		doIT(PayAnyOtherAmt_btn, data);
  	}
  	
    public void set_PaymentAmt_textbox(String TestData) {
		doIT(PaymentAmt_textbox , TestData);
	}
    
    public String get_PaymentAmt_textbox(String sPaymentAmt_textbox) {
		return doIT(PaymentAmt_textbox, sPaymentAmt_textbox).trim();
	}
	
    public void set_TenderType1_dropdown(String TestData) {
		doIT(TenderType1_dropdown , TestData);
	}
	
    public void set_TenderAmt1_textbox(String TestData) {
		doIT( TenderAmt1_textbox , TestData);
	}
	
    public void set_TenderType2_dropdown(String TestData) {
		doIT(TenderType2_dropdown , TestData);
	}
	
    public void set_TenderAmt2_textbox(String TestData) {
		doIT(TenderAmt2_textbox , TestData);
	}
	
    public void set_Pin_textbox(String TestData) {
		doIT(Pin_textbox , TestData);
	}
	
    public void click_Back_btn(String TestData) {
		doIT(Back_btn , TestData);
	}
	
    public void click_Finish_btn(String TestData) {
		doIT(Finish_btn , TestData);
	}
	
    public void click_History_btn(String TestData) {
 		doIT(History_btn , TestData);
 	}
 	
	
	
	
	
}


