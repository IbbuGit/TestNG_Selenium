package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class BorrowerRegistrationOthers_PO extends BasePage{

	/**
	 * @param _driver
	 * @param report
	 */
	public BorrowerRegistrationOthers_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="customerBean.custNumber")
	public WebElement custNumber;
	
	@FindBy(name="custok")
	public WebElement NewLoan_button;
	
	@FindBy(name="others")
	public WebElement BrwrRegOthers_Tab;
	
	@FindBy(name="Close")
	public WebElement BrwrNewloan_Pop_Close;

	@FindBy(name="customerBean.bankrupty") 
	private WebElement BrwrRegOthers_bankrupty;
	
	@FindBy(name="customerBean.othercode") 
	private WebElement BrwrRegOthers_referralCode;
	
	@FindBy(name="customerBean.referCustNbr") 
	private WebElement BrwrRegOthers_referralCustomer_TextBox;
	
	@FindBy(name="Save") 
	private WebElement BrwrRegOthers_next_Button;

	@FindBy(name="Deny") 
	private WebElement BrwrRegOthers_deny_Button;
	
	@FindBy(name="SLoan") 
	private WebElement BrwrRegOthers_saveLoan_Button;
	
	@FindBy(name="Next") 
	private WebElement BrwrRegOthers_saveNext_Button;
	
	@FindBy(name="sphoneNbr1")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr1;
	
	@FindBy(name="sphoneNbr2")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr2;
	
	@FindBy(name="sphoneNbr3")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr3;
		
	@FindBy(name="customerBean.exts")
	private WebElement BrwrRegOthers_SecondaryPhoneNbrExt;
	
	@FindBy(name="customerBean.cphoneCd")
	private WebElement BrwrRegOthers_SecondaryPhoneType;
	
	@FindBy(name="customerBean.incomeCdDisp")
	private WebElement BrwrRegOthers_IncomeType;
	

	@FindBy(id="bothRadioEmailOptIn") 
    private WebElement BrwrRegPrsnl_optInBoth_RadioButton;

	@FindBy(name="Close")
	private WebElement ChildWindowClose;

	
	
	public void click_ChildWindowClose(String data){
		doIT(ChildWindowClose,data);
	}
	
	
	public void click_BrwrRegOthers_Tab(String data){
		doIT(BrwrRegOthers_Tab,data);
	}
	
	
	public void click_BrwrRegOthers_NewLoan_button(String data){
		doIT(NewLoan_button,data);
	}
	
	public void click_BrwrRegOthers_saveNext_Button(){
		doIT(BrwrRegOthers_saveNext_Button,"y");
		
	}
	
	public void click_BrwrRegOthers_next_Button(){
		wait.until(ExpectedConditions.visibilityOf(BrwrRegOthers_next_Button));
		doIT(BrwrRegOthers_next_Button,"y");
	}


	public String get_BrwrRegOthers_bankrupty(String data) {
		return doIT(BrwrRegOthers_bankrupty, data);
	}
	
	public String get_BrwrRegOthers_custNbr() {
		return doIT(custNumber, "get");
	}
	
	public boolean isDisplayed_BrwrRegOthers_custNbr() {
		return isDisplayed(custNumber);
	}
	
	public boolean verifyVisibilityOfBrwrRegOthers_bankrupty(){
		return BrwrRegOthers_bankrupty.isDisplayed();
	}


	public void set_BrwrRegOthers_bankrupty(String brwrRegOthers_bankrupty) {
		doIT(BrwrRegOthers_bankrupty, brwrRegOthers_bankrupty);
	}


	public String get_BrwrRegOthers_referralCode(String data) {
		return doIT(BrwrRegOthers_referralCode, data);
	}


	public void set_BrwrRegOthers_referralCode(String brwrRegOthers_referralCode) {
		doIT(BrwrRegOthers_referralCode, brwrRegOthers_referralCode);
	}


	public String get_BrwrRegOthers_referralCustomer_TextBox(String data) {
		return doIT(BrwrRegOthers_referralCustomer_TextBox, data);
	}


	public void set_BrwrRegOthers_referralCustomer_TextBox(String brwrRegOthers_referralCustomer_TextBox) {
		doIT(BrwrRegOthers_referralCustomer_TextBox, brwrRegOthers_referralCustomer_TextBox);
	}


	public String get_BrwrRegOthers_SecondaryPhoneNbr1(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr1, data);
	}


	public void set_BrwrRegOthers_SecondaryPhoneNbr1(String brwrRegOthers_SecondaryPhoneNbr1) {
		doIT(BrwrRegOthers_SecondaryPhoneNbr1, brwrRegOthers_SecondaryPhoneNbr1);
	}


	public String get_BrwrRegOthers_SecondaryPhoneNbr2(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr2, data);
	}


	public void set_BrwrRegOthers_SecondaryPhoneNbr2(String brwrRegOthers_SecondaryPhoneNbr2) {
		doIT(BrwrRegOthers_SecondaryPhoneNbr2, brwrRegOthers_SecondaryPhoneNbr2);
	}


	public String get_BrwrRegOthers_SecondaryPhoneNbr3(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr3, data);
	}


	public void set_BrwrRegOthers_SecondaryPhoneNbr3(String brwrRegOthers_SecondaryPhoneNbr3) {
		doIT(BrwrRegOthers_SecondaryPhoneNbr3, brwrRegOthers_SecondaryPhoneNbr3);
	}


	public String get_BrwrRegOthers_SecondaryPhoneNbrExt(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbrExt, data);
	}


	public void set_BrwrRegOthers_SecondaryPhoneNbrExt(String brwrRegOthers_SecondaryPhoneNbrExt) {
		doIT(BrwrRegOthers_SecondaryPhoneNbrExt, brwrRegOthers_SecondaryPhoneNbrExt);
	}


	public String get_BrwrRegOthers_SecondaryPhoneType(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneType, data);
	}


	public void set_BrwrRegOthers_SecondaryPhoneType(String brwrRegOthers_SecondaryPhoneType) {
		doIT(BrwrRegOthers_SecondaryPhoneType, brwrRegOthers_SecondaryPhoneType);
	}
	
	public void click_BrwrNewloan_Pop_Close() {
		doIT(BrwrNewloan_Pop_Close,"y");
	}
	
	public boolean isDisplayed_NewLoan_button() {
		return isDisplayed(NewLoan_button);
	}
	
}
