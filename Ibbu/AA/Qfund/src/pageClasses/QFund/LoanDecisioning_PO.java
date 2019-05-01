/**
 * 
 */
package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author VKumar
 *
 */
public class LoanDecisioning_PO extends BasePage {

	public LoanDecisioning_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}



	@FindBy(id="vehicleType_dd")
	private WebElement LoanDec_VehicleType;


	@FindBy(name="existingVin")
	private WebElement LoanDec_VehicleVIN;


	@FindBy(name="vinOne")
	private WebElement LoanDec_VINNumber;

	@FindBy(name="confirmVin")
	private WebElement LoanDec_VINNumberConfirm;


	@FindBy(name="custok")
	private WebElement LoanDec_NewLoanbtn;

	@FindBy(name="button2")
	private WebElement Payday_NewLoanbtn;

	@FindBy(name="miles")
	private WebElement LoanDec_VehMiles;


	@FindBy(name="bbHit_Button")
	private WebElement LoanDec_HitBlackBook;


	@FindBy(name="prodSel")
	private WebElement LoanDec_Prodsel;

	@FindBy(id="LoanButtonId")
	private WebElement LoanDec_NewLoan;

	@FindBy(name="su")
	public WebElement LoanDec_Continue;

	@FindBy(name="prodSel")
	public WebElement selectLOCLoan;
	
	@FindBy(name="prodSel")
	public WebElement selectInstallmentLoanTerm1;

	@FindBy(xpath="//input[contains(@onclick,'PDL ')]")
	public WebElement selectPayDayLoan;

	private String selectProductType="//td[text()='DYNAMIC_TEXT']/input";

	@FindBy(name="ShareScreenBtn")
	public WebElement ShareCustomer_Summary;

	@FindBy(name="confirmSummary")
	public WebElement Confirm_Summary;

	@FindBy(id="preview")
	public WebElement Confirm_SignaturePad;


	@FindBy(name="Close")
	private WebElement ChildWindowClose;

	//Deny Loan Reason and Confirmation

	//@FindBy(xpath="//input[@id=deny_Button]")
	@FindBy(xpath="//input[contains(@onclick,'denialButton')]")
	public WebElement DenyButton;

	@FindBy(id="printCheck0")
	public WebElement CheckBox_DenyReason1;

	@FindBy(id="printCheck1")
	public WebElement CheckBox_DenyReason2;

	@FindBy(id="printCheck2")
	public WebElement CheckBox_DenyReason3;

	@FindBy(id="printCheck3")
	public WebElement CheckBox_DenyReason4;

	@FindBy(id="printCheck4")
	public WebElement CheckBox_DenyReason5;

	@FindBy(id="printCheck5")
	public WebElement CheckBox_DenyReason6;

	@FindBy(id="printCheck6")
	public WebElement CheckBox_DenyReason7;

	@FindBy(id="printCheck7")
	public WebElement CheckBox_DenyReason8;

	@FindBy(xpath="//input[contains(@onclick,'submitDenailDocs')]")
	public WebElement Complete_DenyButton;

	@FindBy(xpath="//table/tbody/tr/td/b")
	public WebElement Denial_msg;


	public String get_Denial_msg(String data){
		return doIT(Denial_msg, data);
	}

	public void click_DenyButton(String data){
		wait.until(ExpectedConditions.elementToBeClickable(DenyButton));
		doIT(DenyButton,data);
	}

	public void click_CheckBox_DenyReason1(String data){
		wait.until(ExpectedConditions.visibilityOf(CheckBox_DenyReason1));
		doIT(CheckBox_DenyReason1,data);
	}
	public void click_CheckBox_DenyReason2(String data){
		doIT(CheckBox_DenyReason2,data);
	}
	public void click_CheckBox_DenyReason3(String data){
		doIT(CheckBox_DenyReason3,data);
	}
	public void click_CheckBox_DenyReason4(String data){
		doIT(CheckBox_DenyReason4,data);
	}
	public void click_CheckBox_DenyReason5(String data){
		doIT(CheckBox_DenyReason5,data);
	}
	public void click_CheckBox_DenyReason6(String data){
		doIT(CheckBox_DenyReason6,data);
	}
	public void click_CheckBox_DenyReason7(String data){
		doIT(CheckBox_DenyReason7,data);
	}
	public void click_CheckBox_DenyReason8(String data){
		doIT(CheckBox_DenyReason8,data);
	}
	public void click_Complete_DenyButton(String data){
		doIT(Complete_DenyButton,data);
	}	
	public void click_selectInstallmentLoanTerm1(String data){
		doIT(selectInstallmentLoanTerm1,data);
	}

	public void click_OptInOutWindowClose(String data){
		if(!data.isEmpty()) {
			try {	
				new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
				switchToChildWindow();		
				doIT(ChildWindowClose,data);	
				switchToParentWindow();
			} catch (Exception e) {	}			
		}
	}

	public void click_HandleShareCustomer(String data,String Confirm_Summary) throws InterruptedException{
		if(ShareCustomer_Summary.isEnabled()) {
			doIT(ShareCustomer_Summary,data);
			click_Confirm_Summary(Confirm_Summary);
		}
	}

	public void click_Confirm_Summary(String data) throws InterruptedException{
		if(!data.isEmpty()) {
			switchToChildWindow();
			wait.until(ExpectedConditions.elementToBeClickable(Confirm_Summary));
			doIT(Confirm_Summary,data);
			switchToParentWindow();							
		}
	}

	public void click_Confirm_Signaturepad(String data) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(Confirm_SignaturePad));
		//wait.until(ExpectedConditions.visibilityOf(Confirm_SignaturePad));
		doIT(Confirm_SignaturePad,data);

	}

	public void click_ProductTypeOption(String product_Option) {
		doIT(getWebElementForDynamicText(selectProductType,product_Option),product_Option);
	}

	private String test="//input[contains(@value,'DYNAMIC_TEXT')]";
	public void Test(String tradNo) {
		doIT(getWebElementForDynamicText(test,tradNo),tradNo);
	}

	public void click_LoanDec_Continue(String data){
		doIT(LoanDec_Continue,data);
	}

	public void click_selectLOCLoan(String data){
		doIT(selectLOCLoan,data);
	}

	public void click_selectPayDayLoan(String data){
		doIT(selectPayDayLoan,data);
	}


	public void click_LoanDec_NewLoanbtn(String data){
		doIT(LoanDec_NewLoanbtn,data);
	}

	public void click_LoanDec_HitBlackBook(String data){		
		if(!data.isEmpty()) {				
			doIT(LoanDec_HitBlackBook,data);
			switchToChildWindow();		
			doIT(ChildWindowClose,data);	
			switchToParentWindow();	
		}
	}

	public void click_LoanDec_Prodsel(String data){
		doIT(LoanDec_Prodsel,data);
	}

	public boolean isDisplayed_LoanDec_NewLoan() {
		return isDisplayed(LoanDec_NewLoan);
	}
	
	public boolean isDisplayed_selectPayDayLoan() {
		return isDisplayed(selectPayDayLoan);
	}

	public void click_LoanDec_NewLoan(String data) throws InterruptedException{

		if(!data.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(LoanDec_NewLoan));
			doIT(LoanDec_NewLoan,data);
		}
	}

	public void click_Payday_NewLoanbtn(String data){
		doIT(Payday_NewLoanbtn,data);
	}


	/**
	 * @return the loanDec_VehicleType
	 */
	public String get_LoanDec_VehicleType(String data){
		return doIT(LoanDec_VehicleType, data);
	}


	/**
	 * @param loanDec_VehicleType the loanDec_VehicleType to set
	 */
	public void set_LoanDec_VehicleType(String loanDec_VehicleType) {
		wait.until(ExpectedConditions.elementToBeClickable(LoanDec_VehicleType));
		doIT(LoanDec_VehicleType, loanDec_VehicleType);
	}


	/**
	 * @return the loanDec_VehicleVIN
	 */
	public String get_LoanDec_VehicleVIN(String data){
		return doIT(LoanDec_VehicleVIN, data);
	}


	/**
	 * @param loanDec_VehicleVIN the loanDec_VehicleVIN to set
	 */
	public void set_LoanDec_VehicleVIN(String loanDec_VehicleVIN) {
		doIT(LoanDec_VehicleVIN, loanDec_VehicleVIN);
	}


	/**
	 * @return the loanDec_VINNumber
	 */
	public String get_LoanDec_VINNumber(String data){
		return doIT(LoanDec_VINNumber, data);
	}


	/**
	 * @param loanDec_VINNumber the loanDec_VINNumber to set
	 */
	public void set_LoanDec_VINNumber(String loanDec_VINNumber) {
		doIT(LoanDec_VINNumber, loanDec_VINNumber);
	}


	/**
	 * @return the loanDec_VINNumberConfirm
	 */
	public String get_LoanDec_VINNumberConfirm(String data){
		return doIT(LoanDec_VINNumberConfirm, data);
	}


	/**
	 * @param loanDec_VINNumberConfirm the loanDec_VINNumberConfirm to set
	 */
	public void set_LoanDec_VINNumberConfirm(String loanDec_VINNumberConfirm) {
		doIT(LoanDec_VINNumberConfirm, loanDec_VINNumberConfirm);
	}


	/**
	 * @return the loanDec_VehMiles
	 */
	public String get_LoanDec_VehMiles(String data){
		return doIT(LoanDec_VehMiles, data);
	}


	/**
	 * @param loanDec_VehMiles the loanDec_VehMiles to set
	 */
	public void set_LoanDec_VehMiles(String loanDec_VehMiles) {
		doIT(LoanDec_VehMiles, loanDec_VehMiles);
	}

	public String verify_ErrorMsg(String data){	
		String Found=null;
		if (!data.isEmpty()) {
			if(getWebElementForDynamicText("//*[contains(text(),'DYNAMIC_TEXT')]", data)!=null) {
				Found="true";
			}			
		}else {Found="";}
		return Found;

	}

}

