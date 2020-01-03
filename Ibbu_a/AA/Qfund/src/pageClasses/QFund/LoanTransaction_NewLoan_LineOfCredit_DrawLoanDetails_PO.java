package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */
public class LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_DrawLoanDetails_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "loanAmt")
	private WebElement loanAmount_Textbox;

	@FindBy(name = "disbType")
	private WebElement disbTypeFirst_Listbox;

	@FindBy(name = "disbAmtFirst")
	private WebElement disbAmtFirst_Textbox;

	@FindBy(name = "disbTypeSecond")
	private WebElement disbTypeSecond_Listbox;

	@FindBy(name = "disbAmtSecond")
	private WebElement disbAmtSecond_Textbox;

	@FindBy(name = "requestBean.checkopt")
	private WebElement locdraw_NoOfCheck;

	@FindBy(name = "requestBean.checkAmt1")
	private WebElement locdraw_CheckAmt1;

	@FindBy(name = "requestBean.checkAmt2")
	private WebElement locdraw_CheckAmt2;

	@FindBy(name = "requestBean.password")
	private WebElement password_Textbox;

	@FindBy(name = "finishadvance")
	private WebElement finish_Button;

	@FindBy(name = "canceladvance")
	private WebElement cancel_Button;

	@FindBy(xpath = "//input[@value='OK']")
	private WebElement oK_Button;

	@FindBy(xpath = "(//tr[@class='trodd'])[2]//td[8]")
	private WebElement avail_credit;

	public void set_loanAmount_Textbox(String sloanAmount_Textbox) throws InterruptedException {

		// new
		// Actions(driver).clickAndHold(loanAmount_Textbox).sendKeys(Keys.chord(Keys.CONTROL,
		// "a"), sloanAmount_Textbox).build().perform();
		try {
			loanAmount_Textbox.clear();
			AlertDecesion("accept");
		} catch (Exception e) {
		}
		doIT(loanAmount_Textbox, sloanAmount_Textbox);
	}

	public String get_loanAmount_Textbox(String data) {
		return doIT(loanAmount_Textbox, data).trim();
	}

	public String get_avail_credit(String data) {
		return doIT(avail_credit, data).trim();
	}

	public void set_disbTypeFirst_Listbox(String sdisbTypeFirst_Listbox) {

		doIT(disbTypeFirst_Listbox, sdisbTypeFirst_Listbox);
	}

	public void set_disbAmtFirst_Textbox(String sdisbAmtFirst_Textbox) {

		doIT(disbAmtFirst_Textbox, sdisbAmtFirst_Textbox);
	}

	public void set_locdraw_NoOfCheck(String data) {

		doIT(locdraw_NoOfCheck, data);
	}

	public void set_locdraw_CheckAmt1(String data) {

		doIT(locdraw_CheckAmt1, data);
	}

	public void set_locdraw_CheckAmt2(String data) {

		doIT(locdraw_CheckAmt2, data);
	}

	public void set_disbTypeSecond_Listbox(String sdisbTypeSecond_Listbox) {

		doIT(disbTypeSecond_Listbox, sdisbTypeSecond_Listbox);
	}

	public void set_disbAmtSecond_Textbox(String sdisbAmtSecond_Textbox) {

		doIT(disbAmtSecond_Textbox, sdisbAmtSecond_Textbox);
	}

	public void set_password_Textbox(String spassword_Textbox) {

		doIT(password_Textbox, spassword_Textbox);
	}

	public boolean isDisplayed_finish_Button() {
		return isDisplayed(finish_Button);
	}

	public void click_finish_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(finish_Button));
			doIT(finish_Button, data);

		}
		
	}

	public void click_cancel_Button(String data) {
		doIT(cancel_Button, data);
	}

	public void click_oK_Button(String data) {
		doIT(oK_Button, data);
	}

	public String getAlertText(String data) {
		if (!data.isEmpty()) {
			return AlertDecesion("getText").trim();
		} else {
			return "";
		}
	}

	public Object checkVisibilityOfOk_Button(String data) {
		boolean Found = false;
		if (!data.isEmpty()) {
			Found = isDisplayedNoException(oK_Button);
		}
		if (Found) {
			return Found;
		} else {
			return "";
		}
	}
}
