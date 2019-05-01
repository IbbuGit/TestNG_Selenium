package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Akula Srikanth Date = 27-July-2018
 */

public class AdminTransaction_ACH_GreenBank_PO extends BasePage {

	/*
	 * Constructor
	 */

	public AdminTransaction_ACH_GreenBank_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(xpath = "//td[contains(text(),'Green Bank NACHA File')]")
	private WebElement GBNF_Header;

	@FindBy(name = "beginMonth")
	private WebElement GBNF_Month;

	@FindBy(name = "beginDay")
	private WebElement GBNF_Day;

	@FindBy(name = "beginYear")
	private WebElement GBNF_Year;

	@FindBy(name = "btnPreview")
	private WebElement GBNF_SubmitButton;

	@FindBy(name = "B2")
	private WebElement GBNF_ResetButton;

	@FindBy(xpath = "//td[contains(text(),'Your Transaction finished successfully.')]")
	private WebElement GBNF_Validation;

	@FindBy(xpath = ".//input[@value='Ok']")
	private WebElement GBNF_Validation_OkButton;

	/*-----------------------------------------------------------
	 *  Locator Methods
	 * ---------------------------------------------------------
	 */

	public String get_GBNF_Header(String strGBNF_Month) {
		return doIT(GBNF_Header, strGBNF_Month);
	}

	public void set_GBNF_Date(String data) {
		if (data != null) {
			String[] MMDDYYYY = data.split("/");
			GBNF_Month.click();
			doIT(GBNF_Month, MMDDYYYY[0]);
			doIT(GBNF_Day, MMDDYYYY[1]);
			doIT(GBNF_Year, MMDDYYYY[2]);
		}
	}

	public void set_GBNF_Month(String strGBNF_Month) {
		doIT(GBNF_Month, strGBNF_Month);
	}

	public void set_GBNF_Day(String strGBNF_Day) {
		doIT(GBNF_Day, strGBNF_Day);
	}

	public void set_GBNF_Year(String strGBNF_Year) {
		doIT(GBNF_Year, strGBNF_Year);
	}

	public void click_GBNF_SubmitButton(String strGBNF_SubmitButton) {
		doIT(GBNF_SubmitButton, strGBNF_SubmitButton);
	}

	public boolean isDisplayed_GBNF_SubmitButton() {
		return isDisplayed(GBNF_SubmitButton);
	}

	public void click_GBNF_ResetButton(String strGBNF_ResetButton) {
		doIT(GBNF_ResetButton, strGBNF_ResetButton);
	}

	public String get_GBNF_Validation(String data) {
		return doIT(GBNF_Validation, data);
	}

	public void click_GBNF_Validation_OkButton(String strGBNF_Validation_OkButton) {
		wait.until(ExpectedConditions.elementToBeClickable(GBNF_Validation_OkButton));
		doIT(GBNF_Validation_OkButton, strGBNF_Validation_OkButton);
	}

}