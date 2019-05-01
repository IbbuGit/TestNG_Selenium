package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class BorrowerRegistrationBanking_PO extends BasePage {

	public BorrowerRegistrationBanking_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

	// Summary Info Locators
	@FindBy(id = "900000")
	private WebElement BrwrRegBnkng_borrower;
	@FindBy(id = "901000")
	private WebElement BrwrRegBnkng_registration;

	// BANKING

	@FindBy(name = "banking")
	private WebElement BrwrRegBnkng_Tab;

	@FindBy(name = "customerBean.cardIssuerId")
	private WebElement BrwrRegBnkng_cardType;

	@FindBy(name = "ccnumber1")
	private WebElement BrwrRegBnkng_cardNbr;

	@FindBy(name = "customerBean.cardHldName")
	private WebElement BrwrRegBnkng_cardHolderName;

	@FindBy(name = "expmonth")
	private WebElement BrwrRegBnkng_cardExpiryMonth;

	@FindBy(name = "expyear")
	private WebElement BrwrRegBnkng_cardExpiryYear;

	@FindBy(name = "customerBean.crdCVV")
	private WebElement BrwrRegBnkng_cVV;

	@FindBy(name = "Swipe")
	private WebElement BrwrRegBnkng_swipCard;

	@FindBy(name = "Reset")
	private WebElement BrwrRegBnkng_ResetCard;

	@FindBy(name = "Add")
	private WebElement BrwrRegBnkng_addCard;

	@FindBy(name = "customerBean.bankDetailsFlg")
	private WebElement BrwrRegBnkng_doestNotHaveBankingDetails;

	@FindBy(name = "customerBean.activeFlgDisp")
	private WebElement BrwrRegBnkng_accountStatus;

	@FindBy(name = "customerBean.abaNbrDisp")
	private WebElement BrwrRegBnkng_routingNbr;

	@FindBy(name = "checkAbaNbrDisp")
	private WebElement BrwrRegBnkng_confirmRoutingNbr;

	@FindBy(name = "customerBean.accountNbrDisp")
	private WebElement BrwrRegBnkng_chkgAcctNbr;

	@FindBy(name = "checkAccountNbrDisp")
	private WebElement BrwrRegBnkng_confirmChkgAcctNbr;

	@FindBy(name = "statementEndDtDisp1")
	private WebElement BrwrRegBnkng_accountVerificationMonth;

	@FindBy(name = "statementEndDtDisp2")
	private WebElement BrwrRegBnkng_accountVerificationDay;

	@FindBy(name = "statementEndDtDisp3")
	private WebElement BrwrRegBnkng_accountVerificationYear;

	@FindBy(name = "acctOpeningDate1")
	private WebElement BrwrRegBnkng_bankStatementMonth;

	@FindBy(name = "acctOpeningDate2")
	private WebElement BrwrRegBnkng_bankStatementDay;

	@FindBy(name = "acctOpeningDate3")
	private WebElement BrwrRegBnkng_bankStatementYear;

	@FindBy(name = "bt_BankDetails")
	private WebElement BrwrRegBnkng_addAccount;

	@FindBy(name = "selBank")
	private WebElement BrwrRegBnkng_selectEditDelete;

	@FindBy(id = "go")
	private WebElement BrwrRegBnkng_go;

	@FindBy(xpath = "(//*[@id='go'])[1]")
	private WebElement BrwrRegBnkng_Editgo;

	@FindBy(xpath = "//input[@value='Update']")
	private WebElement BrwrRegBnkng_Update;

	@FindBy(name = "Save")
	private WebElement BrwrRegBnkng_next;

	@FindBy(name = "Deny")
	private WebElement BrwrRegBnkng_deny;

	public void click_BrwrRegBnkng_Editgo(String data) {
		doIT(BrwrRegBnkng_Editgo, data);
	}

	public void click_BrwrRegBnkng_Tab(String data) {
		doIT(BrwrRegBnkng_Tab, data);
	}

	public String get_BrwrRegBnkng_borrower(String data) {
		return doIT(BrwrRegBnkng_borrower, data);
	}

	public void set_BrwrRegBnkng_borrower(String brwrRegBnkng_borrower) {
		doIT(BrwrRegBnkng_borrower, brwrRegBnkng_borrower);
	}

	public String get_BrwrRegBnkng_registration(String data) {
		return doIT(BrwrRegBnkng_registration, data);
	}

	public void set_BrwrRegBnkng_registration(String brwrRegBnkng_registration) {
		doIT(BrwrRegBnkng_registration, brwrRegBnkng_registration);
	}

	public String get_BrwrRegBnkng_cardType(String data) {
		return doIT(BrwrRegBnkng_cardType, data);
	}

	public void set_BrwrRegBnkng_cardType(String brwrRegBnkng_cardType) {
		doIT(BrwrRegBnkng_cardType, brwrRegBnkng_cardType);
	}

	public String get_BrwrRegBnkng_cardNbr(String data) {
		return doIT(BrwrRegBnkng_cardNbr, data);
	}

	public void set_BrwrRegBnkng_cardNbr(String brwrRegBnkng_cardNbr) {
		doIT(BrwrRegBnkng_cardNbr, brwrRegBnkng_cardNbr);
	}

	public String get_BrwrRegBnkng_cardHolderName(String data) {
		return doIT(BrwrRegBnkng_cardHolderName, data);
	}

	public void set_BrwrRegBnkng_cardHolderName(String brwrRegBnkng_cardHolderName) {
		doIT(BrwrRegBnkng_cardHolderName, brwrRegBnkng_cardHolderName);
	}

	public String get_BrwrRegBnkng_cardExpiryMonth(String data) {
		return doIT(BrwrRegBnkng_cardExpiryMonth, data);
	}

	public void set_BrwrRegBnkng_cardExpiryMonth(String brwrRegBnkng_cardExpiryMonth) {
		doIT(BrwrRegBnkng_cardExpiryMonth, brwrRegBnkng_cardExpiryMonth);
	}

	public String get_BrwrRegBnkng_cardExpiryYear(String data) {
		return doIT(BrwrRegBnkng_cardExpiryYear, data);
	}

	public void set_BrwrRegBnkng_cardExpiryYear(String brwrRegBnkng_cardExpiryYear) {
		doIT(BrwrRegBnkng_cardExpiryYear, brwrRegBnkng_cardExpiryYear);
	}

	public String get_BrwrRegBnkng_cVV(String data) {
		return doIT(BrwrRegBnkng_cVV, data);
	}

	public void set_BrwrRegBnkng_cVV(String brwrRegBnkng_cVV) {
		doIT(BrwrRegBnkng_cVV, brwrRegBnkng_cVV);
	}

	public String get_BrwrRegBnkng_swipCard(String data) {
		return doIT(BrwrRegBnkng_swipCard, data);
	}

	public void set_BrwrRegBnkng_swipCard(String brwrRegBnkng_swipCard) {
		doIT(BrwrRegBnkng_swipCard, brwrRegBnkng_swipCard);
	}

	public String get_BrwrRegBnkng_ResetCard(String data) {
		return doIT(BrwrRegBnkng_ResetCard, data);
	}

	public void set_BrwrRegBnkng_ResetCard(String brwrRegBnkng_ResetCard) {
		doIT(BrwrRegBnkng_ResetCard, brwrRegBnkng_ResetCard);
	}

	public String get_BrwrRegBnkng_addCard(String data) {
		return doIT(BrwrRegBnkng_addCard, data);
	}

	public void set_BrwrRegBnkng_addCard(String brwrRegBnkng_addCard) {
		doIT(BrwrRegBnkng_addCard, brwrRegBnkng_addCard);
	}

	public String get_BrwrRegBnkng_doestNotHaveBankingDetails(String data) {
		return doIT(BrwrRegBnkng_doestNotHaveBankingDetails, data);
	}

	public void set_BrwrRegBnkng_doestNotHaveBankingDetails(String brwrRegBnkng_doestNotHaveBankingDetails) {
		doIT(BrwrRegBnkng_doestNotHaveBankingDetails, brwrRegBnkng_doestNotHaveBankingDetails);
	}

	public String get_BrwrRegBnkng_accountStatus(String data) {
		return doIT(BrwrRegBnkng_accountStatus, data);
	}

	public boolean verifyVisibilityOfBrwrRegBnkng_accountVerificationMonth() {
		return BrwrRegBnkng_accountVerificationMonth.isDisplayed();
	}

	public void set_BrwrRegBnkng_accountStatus(String brwrRegBnkng_accountStatus) {
		doIT(BrwrRegBnkng_accountStatus, brwrRegBnkng_accountStatus);
	}

	public String get_BrwrRegBnkng_routingNbr(String data) {
		return doIT(BrwrRegBnkng_routingNbr, data);
	}

	public String set_BrwrRegBnkng_routingNbr(String data) {
		if (data.equalsIgnoreCase("Random")) {
			String chkgAcctNbr = Helper.getRandomNumeric(7);
			doIT(BrwrRegBnkng_routingNbr, chkgAcctNbr);
			data = chkgAcctNbr;
		} else if (!data.isEmpty()) {
			if (data.contains("z")) {
				String s= data;
				String s1=s.replace("z", "0");
				doIT(BrwrRegBnkng_routingNbr, s1);
			}
			doIT(BrwrRegBnkng_routingNbr, data);
		}
		return data;
	}

	public String get_BrwrRegBnkng_confirmRoutingNbr(String data) {
		return doIT(BrwrRegBnkng_confirmRoutingNbr, data);
	}

	public void set_BrwrRegBnkng_confirmRoutingNbr(String data) {
		 if (!data.isEmpty()) {
			if (data.contains("z")) {
				String s= data;
				String s1=s.replace("z", "0");
				doIT(BrwrRegBnkng_confirmRoutingNbr, s1);
			}
		 
			doIT(BrwrRegBnkng_confirmRoutingNbr, data);
		 }
		 
	}

	public String get_BrwrRegBnkng_chkgAcctNbr(String data) {
		return doIT(BrwrRegBnkng_chkgAcctNbr, data);
	}

	public String set_BrwrRegBnkng_chkgAcctNbr(String data) {

		if (data.equalsIgnoreCase("Random")) {
			String chkgAcctNbr = Helper.getRandomNumeric(7);
			doIT(BrwrRegBnkng_chkgAcctNbr, chkgAcctNbr);
			data = chkgAcctNbr;
		} else if (!data.isEmpty()) {
			doIT(BrwrRegBnkng_chkgAcctNbr, data);
		}
		return data;
	}

	public String get_BrwrRegBnkng_confirmChkgAcctNbr(String data) {
		return doIT(BrwrRegBnkng_confirmChkgAcctNbr, data);
	}

	public void set_BrwrRegBnkng_confirmChkgAcctNbr(String brwrRegBnkng_confirmChkgAcctNbr) {
		doIT(BrwrRegBnkng_confirmChkgAcctNbr, brwrRegBnkng_confirmChkgAcctNbr);
	}

	public void set_BrwrRegBnkng_accountVerificationDate(String data) {
		if (!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(BrwrRegBnkng_accountVerificationMonth, MMDDYYYY[0]);
			doIT(BrwrRegBnkng_accountVerificationDay, MMDDYYYY[1]);
			doIT(BrwrRegBnkng_accountVerificationYear, MMDDYYYY[2]);
		}
	}

	public String get_BrwrRegBnkng_accountVerificationMonth(String data) {
		return doIT(BrwrRegBnkng_accountVerificationMonth, data);
	}

	public void set_BrwrRegBnkng_accountVerificationMonth(String brwrRegBnkng_accountVerificationMonth) {
		doIT(BrwrRegBnkng_accountVerificationMonth, brwrRegBnkng_accountVerificationMonth);
	}

	public String get_BrwrRegBnkng_accountVerificationDay(String data) {
		return doIT(BrwrRegBnkng_accountVerificationDay, data);
	}

	public void set_BrwrRegBnkng_accountVerificationDay(String brwrRegBnkng_accountVerificationDay) {
		doIT(BrwrRegBnkng_accountVerificationDay, brwrRegBnkng_accountVerificationDay);
	}

	public String get_BrwrRegBnkng_accountVerificationYear(String data) {
		return doIT(BrwrRegBnkng_accountVerificationYear, data);
	}

	public void set_BrwrRegBnkng_accountVerificationYear(String brwrRegBnkng_accountVerificationYear) {
		doIT(BrwrRegBnkng_accountVerificationYear, brwrRegBnkng_accountVerificationYear);
	}

	public String get_BrwrRegBnkng_bankStatementEndMonth(String data) {
		return doIT(BrwrRegBnkng_bankStatementMonth, data);
	}

	public void set_BrwrRegBnkng_bankStatementEndMonth(String brwrRegBnkng_bankStatementEndMonth) {
		doIT(BrwrRegBnkng_bankStatementMonth, brwrRegBnkng_bankStatementEndMonth);
	}

	public String get_BrwrRegBnkng_addAccount(String data) {
		return doIT(BrwrRegBnkng_addAccount, data);
	}

	public void set_BrwrRegBnkng_addAccount(String brwrRegBnkng_addAccount) {
		doIT(BrwrRegBnkng_addAccount, brwrRegBnkng_addAccount);
	}

	public String get_BrwrRegBnkng_selectEditDelete(String data) {
		return doIT(BrwrRegBnkng_selectEditDelete, data);
	}

	public void set_BrwrRegBnkng_selectEditDelete(String brwrRegBnkng_selectEditDelete) {
		doIT(BrwrRegBnkng_selectEditDelete, brwrRegBnkng_selectEditDelete);
	}

	public String get_BrwrRegBnkng_deny(String data) {
		return doIT(BrwrRegBnkng_deny, data);
	}

	public void set_BrwrRegBnkng_deny(String brwrRegBnkng_deny) {
		doIT(BrwrRegBnkng_deny, brwrRegBnkng_deny);
	}

	public void click_BrwrRegBnkng_go(String sBrwrRegBnkng_go) {
		doIT(BrwrRegBnkng_go, sBrwrRegBnkng_go);
	}

	public void click_BrwrRegBnkng_Update(String sBrwrRegBnkng_Update) {
		doIT(BrwrRegBnkng_Update, sBrwrRegBnkng_Update);
	}

	public void set_BrwrRegBnkng_bankStatementEndDate_clear(String data) {
		BrwrRegBnkng_bankStatementMonth.clear();
		BrwrRegBnkng_bankStatementDay.clear();
		BrwrRegBnkng_bankStatementYear.clear();
	}

	public void set_BrwrRegBnkng_bankStatementEndDate(String data) {
		if (!data.isEmpty()) {
			BrwrRegBnkng_bankStatementMonth.clear();
			BrwrRegBnkng_bankStatementDay.clear();
			BrwrRegBnkng_bankStatementYear.clear();

			String[] MMDDYYYY = data.split("/");
			doIT(BrwrRegBnkng_bankStatementMonth, MMDDYYYY[0]);
			doIT(BrwrRegBnkng_bankStatementDay, MMDDYYYY[1]);
			doIT(BrwrRegBnkng_bankStatementYear, MMDDYYYY[2]);
		}
	}
}
