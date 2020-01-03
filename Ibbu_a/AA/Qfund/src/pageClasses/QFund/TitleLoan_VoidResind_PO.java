package pageClasses.QFund;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

public class TitleLoan_VoidResind_PO extends BasePage{

	public TitleLoan_VoidResind_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(id="910000")
	private WebElement loanTransactions_Tab;

	@FindBy(id="911100")
	private WebElement newLoan_LoanTransactions;

	@FindBy(id="911101")
	private WebElement Transactions;

	@FindBy(name="button")
	private WebElement TitleLoan_Select;

	@FindBy(name="transactionList")
	private WebElement TitleLoan_Transaction_type;

	@FindBy(name="button")
	private WebElement Transaction_Type_Select;

	@FindBy(name="tenderType")
	private WebElement Transaction_tender_Type;

	@FindBy(name="transactionDataBean.tenderAmtFirst")
	private WebElement Transaction_tender_Amount;

	@FindBy(xpath="//b[contains(text(),'Loan Amt')]/../following-sibling::td/b")
	private WebElement Transaction_Loan_Amount;

	@FindBy(name="requestBean.password")
	private WebElement Transaction_UserID_Pin;

	@FindBy(name="YES")
	private WebElement Transaction_EncryptionCode_Yes;


	@FindBy(name="NO")
	private WebElement Transaction_EncryptionCode_No;

	@FindBy(name="finish")
	private WebElement Transaction_FinishVoidLoan;

	@FindBy(xpath="//td[@class='leftHeading']")	
	private WebElement Transaction_VoidLoan_Completed;
	
	@FindBy(xpath="//td[contains(text(),'Transaction Selection')]")	
	private WebElement TransactionSelectionPage;
	
	@FindBy(xpath="//font/ul[contains(text(),'The entered Password is invalid.Please re-enter.')]")	
	private WebElement ErrorMsg;
	
	public String get_ErrorMsg(String data){
		return doIT(ErrorMsg, data);
	}


	public String get_Transaction_tender_Amount(String data){
		return doIT(Transaction_tender_Amount, data);
	}

	public void set_Transaction_tender_Amount(String transaction_tender_Amount) {
		doIT(Transaction_tender_Amount, transaction_tender_Amount);
	}

	public String get_Transaction_Loan_Amount(String data){
		return doIT(Transaction_Loan_Amount, data).replace("$", "").replace(" ", "").trim();
	}

	public void set_Transaction_Loan_Amount(String transaction_Loan_Amount) {
		doIT(Transaction_Loan_Amount, transaction_Loan_Amount);
	}

	//	public String get_Transaction_Loan_Amount(String data){
	//		return doIT(Transaction_Loan_Amount, data).replace("$", "").replace(" ", "").trim();
	//	}
	//
	//	public void set_Transaction_tender_Amount(String transaction_tender_Amount) {
	//		doIT(Transaction_tender_Amount, transaction_tender_Amount);
	//	}

	public String get_TitleLoan_Transaction_type(String data){
		return doIT(TitleLoan_Transaction_type, data);
	}

	public void set_TitleLoan_Transaction_type(String titleLoan_Transaction_type) {
		doIT(TitleLoan_Transaction_type, titleLoan_Transaction_type);
	}

	public String get_Transaction_tender_Type(String data){
		return doIT(Transaction_tender_Type, data);
	}

	public void set_Transaction_tender_Type(String transaction_tender_Type) {
		doIT(Transaction_tender_Type, transaction_tender_Type);
	}

	public String get_Transaction_UserID_Pin(String data){
		return doIT(Transaction_UserID_Pin, data);
	}

	public void set_Transaction_UserID_Pin(String transaction_UserID_Pin) {
		doIT(Transaction_UserID_Pin, transaction_UserID_Pin);
	}

	public void click_loanTransactions_Tab(String data){
		doIT(loanTransactions_Tab,data);
	}

	public void click_Transaction_Type_Select(String data){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0]);", Transaction_Type_Select);
	}

	public void click_Transactions(String data){
		doIT(Transactions,data);
	}

	public void click_Transaction_EncryptionCode_Yes(String data){
		doIT(Transaction_EncryptionCode_Yes,data);
	}

	public void click_Transaction_EncryptionCode_No(String data){
		doIT(Transaction_EncryptionCode_No,data);
	}

	public void click_Transaction_FinishVoidLoan(String data){
		doIT(Transaction_FinishVoidLoan,data);
	}

	public String verifyText() {		
		return Transaction_VoidLoan_Completed.getText();		

	}
	
	public String get_TransactionSelectionPage(String data){		
		return doIT(TransactionSelectionPage,data);		

	}

	public void click_CustomerForLoanNumber(String Loan_nbr) {		
		String elementStringGo="//td[contains(text(),'"+Loan_nbr+"')]/..//input[@value='Go']";
		WebElement elementGo=driver.findElement(By.xpath(elementStringGo));
		//element);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0]);", elementGo);
	}

	
	
	
	public String getAlertTextmsg(String data) {
		if(!data.isEmpty()) {
			
			return  AlertDecesion("getText").trim();
			
		}else
		{
			return null;
		}
		
	}
}

