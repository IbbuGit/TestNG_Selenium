package pageClasses.QFund;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class AdminCustomerBankruptAndDeceased_PO extends BasePage {

	public AdminCustomerBankruptAndDeceased_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);

	}

	@FindBy(name = "loanCode")
	private WebElement Loan_CheckBox;

	@FindBy(name = "requestBean.bnkStatus")
	private WebElement Loan_Status;

	@FindBy(name = "bankruptcyFilingDate1")
	private WebElement FilingMonth;

	@FindBy(name = "bankruptcyFilingDate2")
	private WebElement FilingDay;

	@FindBy(name = "bankruptcyFilingDate3")
	private WebElement FilingYear;

	@FindBy(name = "bkrCaseNbr")
	private WebElement CaseNbr;

	@FindBy(name = "requestBean.typeOfBankruptcy")
	private WebElement Chapter;

	@FindBy(name = "attorneyName")
	private WebElement AttyName;

	@FindBy(name = "debtorAttorneyPhone1")
	private WebElement AttyPhone1;

	@FindBy(name = "debtorAttorneyPhone2")
	private WebElement AttyPhone2;

	@FindBy(name = "debtorAttorneyPhone3")
	private WebElement AttyPhone3;

	@FindBy(name = "ubnkDate1")
	private WebElement DismissedOrDecesedDateMonth;

	@FindBy(name = "ubnkDate2")
	private WebElement DismissedOrDecesedDateDay;

	@FindBy(name = "ubnkDate3")
	private WebElement DismissedOrDecesedDateYear;

	@FindBy(name = "bt_AddBankruptcy")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[contains(@value,'Go')]")
	private WebElement Gobtn;
	
	@FindBy(xpath = "//td[contains(text(),'Bankruptcy')]")
	private WebElement PendingMessage;
	
	@FindBy(xpath = "//td[contains(text(),'Date')]")
	private WebElement Date;
	
	public void waitForElement() {
		wait.until(ExpectedConditions.visibilityOf(PendingMessage));

	}

	public void click_Loan_CheckBox(String sLoan_CheckBox) {
		doIT(Loan_CheckBox, sLoan_CheckBox);
	}
	
	public void click_Gobtn(String sGobtn) {
		doIT(Gobtn, sGobtn);
	}
	
	public String get_Date(String sDate){
		return doIT(Date, sDate).replaceAll("Date:   ", "");
	}
	
	public String get_PendingMessage(String sPendingMessage){
		return doIT(PendingMessage, sPendingMessage);
	}

	public void set_Loan_CheckBox(String sLoan_CheckBox) {
		doIT(Loan_CheckBox, sLoan_CheckBox);
	}

	public void set_Loan_Status(String sLoan_Status) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-1000)");
		 wait.until(ExpectedConditions.visibilityOf(Loan_Status));
		doIT(Loan_Status, sLoan_Status);
	}

	public void set_FilingMonth(String sFilingMonth) {
		doIT(FilingMonth, sFilingMonth);
	}

	public void set_FilingDay(String sFilingDay) {
		doIT(FilingDay, sFilingDay);
	}

	public void set_FilingYear(String sFilingYear) {
		doIT(FilingYear, sFilingYear);
	}

	public void set_CaseNbr(String sCaseNbr) {
		doIT(CaseNbr, sCaseNbr);
	}

	public void set_Chapter(String sChapter) {
		doIT(Chapter, sChapter);
	}

	public void set_AttyName(String sAttyName) {
		doIT(AttyName, sAttyName);
	}

	public void set_AttyPhone1(String sAttyPhone1) {
		doIT(AttyPhone1, sAttyPhone1);
	}

	public void set_AttyPhone2(String sAttyPhone2) {
		doIT(AttyPhone2, sAttyPhone2);
	}

	public void set_AttyPhone3(String sAttyPhone3) {
		doIT(AttyPhone3, sAttyPhone3);
	}

	public void set_DismissedOrDecesedDateMonth(String sDismissedOrDecesedDateMonth) {
		doIT(DismissedOrDecesedDateMonth, sDismissedOrDecesedDateMonth);
	}

	public void set_DismissedOrDecesedDateDay(String sDismissedOrDecesedDateDay) {
		doIT(DismissedOrDecesedDateDay, sDismissedOrDecesedDateDay);
	}

	public void set_DismissedOrDecesedDateYear(String sDismissedOrDecesedDateYear) {
		doIT(DismissedOrDecesedDateYear, sDismissedOrDecesedDateYear);
	}

	public void click_SaveBtn(String sSaveBtn) {
		doIT(SaveBtn, sSaveBtn);
	}
	
	public String getAlertText(String data) {
		if(!data.isEmpty()) {
			System.out.println(AlertDecesion("getText"));
			return  AlertDecesion("getText").trim();
			
		}else {
			return null;
		}
	}

}
