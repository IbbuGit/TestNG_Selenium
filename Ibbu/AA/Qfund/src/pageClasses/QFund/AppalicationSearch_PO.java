package pageClasses.QFund;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class AppalicationSearch_PO extends BasePage {

	public AppalicationSearch_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[contains(text(),'Applicant Search')]")
	private WebElement as_AppalicantSearchHeader;

	@FindBy(name = "requestBean.storeId")
	private WebElement as_storeId;

	@FindBy(name = "requestBean.firstNames")
	private WebElement as_FirstName;

	@FindBy(name = "requestBean.lastName")
	private WebElement as_LastName;

	@FindBy(name = "ssn1")
	private WebElement as_SSN_1;

	@FindBy(name = "ssn2")
	private WebElement as_SSN_2;

	@FindBy(name = "ssn3")
	private WebElement as_SSN_3;

	@FindBy(name = "requestBean.cusNbr")
	private WebElement as_CustomerNbr;

	@FindBy(name = "requestBean.dealNbr")
	private WebElement as_LoanNbr;

	@FindBy(name = "requestBean.homePhone")
	private WebElement as_PhoneNbr;

	@FindBy(name = "requestBean.customerId")
	private WebElement as_MigratedCustomerID;

	@FindBy(name = "requestBean.loanId")
	private WebElement as_MigratedLoanID;

	@FindBy(name = "requestBean.statusType")
	private WebElement as_Status;

	@FindBy(name = "cancel")
	private WebElement as_CancelButton;

	@FindBy(xpath = "//input[contains(@name,'submit')]")
	private WebElement as_SubmitButton;

	@FindBy(name = "button")
	private WebElement as_Select_Customer;

	@FindBy(name = "history")
	private WebElement as_Select_Customer_History;

	@FindBy(xpath = "//form[@name='customerAdd']/..//input[@name='Close']")
	private WebElement as_LoanFlags_Close;

	@FindBy(xpath = "(//input[@value='Go'])[1]")
	private WebElement custSelectLoanGoBtn;

	@FindBy(xpath = "//td[contains(text(),'Loan Nbr')]/../following-sibling::tr/td[2]")
	protected WebElement loan_Nbr;

	@FindBy(name = "requestBean.applicationNo")
	private WebElement caseAtStoreApplicationNubBtn;

	public String get_loan_Nbr() {
		return doIT(loan_Nbr, "get");
	}

	public boolean verifyAppalicantSearch() {
		return isDisplayed(as_AppalicantSearchHeader);
	}

	public void set_as_storeId(String data) {
		doIT(as_storeId, data);
	}

	public String get_AppSch_AppSch_FirstName(String data) {
		return doIT(as_FirstName, data);
	}

	public void set_AppSch_AppSch_FirstName(String appSch_AppSch_FirstName) {
		doIT(as_FirstName, appSch_AppSch_FirstName);
	}

	public String get_AppSch_LastName(String data) {
		return doIT(as_LastName, data);
	}

	public void set_AppSch_LastName(String appSch_LastName) {
		doIT(as_LastName, appSch_LastName);
	}

	public String get_AppSch_SSN_1(String data) {
		return doIT(as_SSN_1, data);
	}

	public void set_AppSch_SSN_1(String appSch_SSN_1) {
		doIT(as_SSN_1, appSch_SSN_1);
	}

	public String get_AppSch_SSN_2(String data) {
		return doIT(as_SSN_2, data);
	}

	public void set_AppSch_SSN_2(String appSch_SSN_2) {
		doIT(as_SSN_2, appSch_SSN_2);
	}

	public String get_AppSch_SSN_3(String data) {
		return doIT(as_SSN_3, data);
	}

	public void set_AppSch_SSN_3(String appSch_SSN_3) {
		doIT(as_SSN_3, appSch_SSN_3);
	}

	public String get_AppSch_CustomerNbr(String data) {
		return doIT(as_CustomerNbr, data);
	}

	public void set_AppSch_CustomerNbr(String appSch_CustomerNbr) {
		doIT(as_CustomerNbr, appSch_CustomerNbr);
	}

	public String get_AppSch_LoanNbr(String data) {
		return doIT(as_LoanNbr, data);
	}

	public void set_AppSch_LoanNbr(String appSch_LoanNbr) {
		doIT(as_LoanNbr, appSch_LoanNbr);
	}

	public String get_AppSch_PhoneNbr(String data) {
		return doIT(as_PhoneNbr, data);
	}

	public void set_AppSch_PhoneNbr(String appSch_PhoneNbr) {
		doIT(as_PhoneNbr, appSch_PhoneNbr);
	}

	public String get_AppSch_MigratedCustomerID(String data) {
		return doIT(as_MigratedCustomerID, data);
	}

	public void set_AppSch_MigratedCustomerID(String appSch_MigratedCustomerID) {
		doIT(as_MigratedCustomerID, appSch_MigratedCustomerID);
	}

	public String get_AppSch_MigratedLoanID(String data) {
		return doIT(as_MigratedLoanID, data);
	}

	public void set_AppSch_MigratedLoanID(String appSch_MigratedLoanID) {
		doIT(as_MigratedLoanID, appSch_MigratedLoanID);
	}

	public void set_as_Status(String data) {
		doIT(as_Status, data);
	}

	public void click_AppSch_Submit(String data) {
		doIT(as_SubmitButton, data);
	}

	public void click_AppSch_Select_Customer(String data) {
		doIT(as_Select_Customer, data);
	}

	public void click_AppSch_LoanFlags_Close(String data) {
		doIT(as_LoanFlags_Close, data);
	}

	public void click_custSelectLoanGoBtn(String data) {
		doIT(custSelectLoanGoBtn, data);
	}

	public void click_as_Select_Customer_History(String data) {
		doIT(as_Select_Customer_History, data);
	}

	public void set_CashAtStoreApplicationNubBtn(String data) {
		selectFrame(frameMain);
		doIT(caseAtStoreApplicationNubBtn, data);
		click_AppSch_Submit("Click");
		click_cashAtStoreGoBtn("Click");
	}

	public void click_cashAtStoreGoBtn(String data) {
		doIT(as_Select_Customer, data);
	}

	public void searchByDetailAndSelectCustomer(String filedName, String value) throws Exception {
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put(filedName, value);

		set_as_storeId(data.get("as_storeId"));
		set_AppSch_AppSch_FirstName(data.get("First_Name"));
		set_AppSch_LastName(data.get("Last_Name"));
		set_AppSch_SSN(data.get("SSN"));
		set_AppSch_CustomerNbr(data.get("Customer_Nbr"));
		set_AppSch_LoanNbr(data.get("Loan_nbr"));
		set_AppSch_PhoneNbr(data.get("Phone_Nbr"));
		set_AppSch_MigratedCustomerID(data.get("Migrated_CustomerId"));
		set_AppSch_MigratedLoanID(data.get("Migrated_LoanId"));
		set_as_Status(data.get("as_Status"));

		click_AppSch_Submit("Click");
		click_AppSch_Select_Customer("Click");
	}

	public void searchByDetailsAndSelectLoan(String filedName, String value, String selectCustSelectionGoBtn)
			throws Exception {

		searchByDetailAndSelectCustomer(filedName, value);
		if (isWindowDisplayed(2)) {
			switchToChildWindow();
			closeWindow();
			switchToParentWindow();
			
			click_custSelectLoanGoBtn(selectCustSelectionGoBtn);
		} else {
			click_custSelectLoanGoBtn(selectCustSelectionGoBtn);
		}
	}

	public void adminsearchByDetailsAndSelectHistory(String filedName, String value, String as_Select_Customer_History)
			throws Exception {
		searchByDetailAndSelectCustomer(filedName, value);
		switchToChildWindow();
		closeWindow();
		switchToParentWindow();
		click_as_Select_Customer_History(as_Select_Customer_History);

	}

	public void searchByDetailsAndSelectLoanWithoutChild(String filedName, String value,
			String selectCustSelectionGoBtn) throws Exception {
		searchByDetailAndSelectCustomer(filedName, value);
		click_custSelectLoanGoBtn(selectCustSelectionGoBtn);
	}

	public String NavigateToSearchTransAndGetLoanID(String filedName, String value) throws Exception {
		Qfund_Navigation.Loan_Transaction.LoanTransaction();
		searchByDetailAndSelectCustomer(filedName, value);
		return get_loan_Nbr();
	}

	// public void search(String Loan_nbr) throws Exception{
	// set_AppSch_LoanNbr(Loan_nbr);
	// click_AppSch_Submit("y");
	// click_AppSch_Select_Customer("y");
	// }

	public void set_AppSch_SSN(String appSch_SSN) {
		if (appSch_SSN != null) {
			if (!appSch_SSN.isEmpty()) {
				String[] SSN = appSch_SSN.split("-", -2);
				doIT(as_SSN_1, SSN[0]);
				doIT(as_SSN_2, SSN[1]);
				doIT(as_SSN_3, SSN[2]);
			}
		}
	}

	public void switchToChildWindows() {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentWindowId = it.next();
		childWindowId = it.next();
		driver.switchTo().window(childWindowId);
	}

}
