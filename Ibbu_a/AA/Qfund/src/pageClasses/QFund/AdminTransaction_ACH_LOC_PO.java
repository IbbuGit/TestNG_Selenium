package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Akula Srikanth Date = 27-July-2018
 */

public class AdminTransaction_ACH_LOC_PO extends BasePage {

	/*
	 * Constructor
	 */

	public AdminTransaction_ACH_LOC_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Page Elements
	 */

	@FindBy(xpath = "//td[contains(text(),'LOC Statement')]")
	private WebElement locsd_Header;

	@FindBy(name = "requestBean.storeCode")
	private WebElement locsd_StoreNbr;

	@FindBy(name = "beginMonth")
	private WebElement locsd_Month;

	@FindBy(name = "beginDay")
	private WebElement locsd_Day;

	@FindBy(name = "beginYear")
	private WebElement locsd_Year;

	@FindBy(name = "submit")
	private WebElement locsd_SubmitButton;

	@FindBy(name = "cancel")
	private WebElement locsd_CancelButton;

	@FindBy(xpath = "//td[contains(text(),'Process completed Successfully.')]")
	private WebElement locsd_Validation;

	@FindBy(xpath = ".//input[@value='Ok']")
	private WebElement locsd_Validation_OkButton;

	/*
	 * Page Elements Methods
	 */

	public String get_locsd_Header(String TestData_locsd_Header) {
		return doIT(locsd_Header, TestData_locsd_Header);
	}

	public boolean isDisplayed_locsd_Header() {
		return isDisplayed(locsd_Header);
	}

	// ****************************************************************************************************************************
	public void set_locsd_StoreNbr(String TestData_locsd_StoreNbr) {
		doIT(locsd_StoreNbr, TestData_locsd_StoreNbr);
	}

	public boolean isDisplayed_locsd_StoreNbr() {
		return isDisplayed(locsd_StoreNbr);
	}

	// ****************************************************************************************************************************
	public void set_locsd_Month(String TestData_locsd_Month) {
		doIT(locsd_Month, TestData_locsd_Month);
	}

	public boolean isDisplayed_locsd_Month() {
		return isDisplayed(locsd_Month);
	}

	// ****************************************************************************************************************************
	public void set_locsd_Day(String TestData_locsd_Day) {
		doIT(locsd_Day, TestData_locsd_Day);
	}

	public boolean isDisplayed_locsd_Day() {
		return isDisplayed(locsd_Day);
	}

	// ****************************************************************************************************************************
	public void set_locsd_Year(String TestData_locsd_Year) {
		doIT(locsd_Year, TestData_locsd_Year);
	}

	public boolean isDisplayed_locsd_Year() {
		return isDisplayed(locsd_Year);
	}

	public void set_locsd_Date(String data) {
		if (data != null) {
			String[] MMDDYYYY = data.split("/");
			doIT(locsd_Month, MMDDYYYY[0]);
			doIT(locsd_Day, MMDDYYYY[1]);
			doIT(locsd_Year, MMDDYYYY[2]);
		}
	}

	// ****************************************************************************************************************************
	public void click_locsd_SubmitButton(String TestData_locsd_SubmitButton) {
		doIT(locsd_SubmitButton, TestData_locsd_SubmitButton);
	}

	public boolean isDisplayed_locsd_SubmitButton() {
		return isDisplayed(locsd_SubmitButton);
	}

	// ****************************************************************************************************************************
	public void click_locsd_CancelButton(String TestData_locsd_CancelButton) {
		doIT(locsd_CancelButton, TestData_locsd_CancelButton);
	}

	public boolean isDisplayed_locsd_CancelButton() {
		return isDisplayed(locsd_CancelButton);
	}

	// ****************************************************************************************************************************
	public String get_locsd_Validation(String TestData_locsd_Validation) {
		return doIT(locsd_Validation, TestData_locsd_Validation);
	}

	public boolean isDisplayed_locsd_Validation() {
		return isDisplayed(locsd_Validation);
	}

	// ****************************************************************************************************************************
	public void click_locsd_Validation_OkButton(String TestData_locsd_Validation_OkButton) {
		doIT(locsd_Validation_OkButton, TestData_locsd_Validation_OkButton);
	}

	public boolean isDisplayed_locsd_Validation_OkButton() {
		return isDisplayed(locsd_Validation_OkButton);
	}
	
	

	/*
	 * Page Elements
	 */

	@FindBy(xpath = "//td[contains(text(),'LOC Statement')]")
	private WebElement locsw_Header;

	@FindBy(name = "requestBean.storeCode")
	private WebElement locsw_StoreNbr;

	@FindBy(name = "beginMonth")
	private WebElement locsw_Month;

	@FindBy(name = "beginDay")
	private WebElement locsw_Day;

	@FindBy(name = "beginYear")
	private WebElement locsw_Year;

	@FindBy(name = "submit")
	private WebElement locsw_SubmitButton;

	@FindBy(name = "cancel")
	private WebElement locsw_CancelButton;

	@FindBy(xpath = "//td[contains(text(),'Process completed Successfully.')]")
	private WebElement locsw_Validation;

	@FindBy(xpath = ".//input[@value='Ok']")
	private WebElement locsw_Validation_OkButton;

	/*
	 * Page Elements Methods
	 */

	public String get_locsw_Header(String TestData_locsw_Header) {
		return doIT(locsw_Header, TestData_locsw_Header);
	}

	public boolean isDisplayed_locsw_Header() {
		return isDisplayed(locsw_Header);
	}

	// ****************************************************************************************************************************
	public void set_locsw_StoreNbr(String TestData_locsw_StoreNbr) {
		doIT(locsw_StoreNbr, TestData_locsw_StoreNbr);
	}

	public boolean isDisplayed_locsw_StoreNbr() {
		return isDisplayed(locsw_StoreNbr);
	}

	// ****************************************************************************************************************************
	public void set_locsw_Month(String TestData_locsw_Month) {
		doIT(locsw_Month, TestData_locsw_Month);
	}

	public boolean isDisplayed_locsw_Month() {
		return isDisplayed(locsw_Month);
	}

	// ****************************************************************************************************************************
	public void set_locsw_Day(String TestData_locsw_Day) {
		doIT(locsw_Day, TestData_locsw_Day);
	}

	public boolean isDisplayed_locsw_Day() {
		return isDisplayed(locsw_Day);
	}

	// ****************************************************************************************************************************
	public void set_locsw_Year(String TestData_locsw_Year) {
		doIT(locsw_Year, TestData_locsw_Year);
	}

	public boolean isDisplayed_locsw_Year() {
		return isDisplayed(locsw_Year);
	}

	public void set_locsw_Date(String data) {
		if (data != null) {
			String[] MMDDYYYY = data.split("/");
			doIT(locsw_Month, MMDDYYYY[0]);
			doIT(locsw_Day, MMDDYYYY[1]);
			doIT(locsw_Year, MMDDYYYY[2]);
		}
	}

	// ****************************************************************************************************************************
	public void click_locsw_SubmitButton(String TestData_locsw_SubmitButton) {
		doIT(locsw_SubmitButton, TestData_locsw_SubmitButton);
	}

	public boolean isDisplayed_locsw_SubmitButton() {
		return isDisplayed(locsw_SubmitButton);
	}

	// ****************************************************************************************************************************
	public void click_locsw_CancelButton(String TestData_locsw_CancelButton) {
		doIT(locsw_CancelButton, TestData_locsw_CancelButton);
	}

	public boolean isDisplayed_locsw_CancelButton() {
		return isDisplayed(locsw_CancelButton);
	}

	// ****************************************************************************************************************************
	public String get_locsw_Validation(String TestData_locsw_Validation) {
		return doIT(locsw_Validation, TestData_locsw_Validation);
	}

	public boolean isDisplayed_locsw_Validation() {
		return isDisplayed(locsw_Validation);
	}

	// ****************************************************************************************************************************
	public void click_locsw_Validation_OkButton(String TestData_locsw_Validation_OkButton) {
		doIT(locsw_Validation_OkButton, TestData_locsw_Validation_OkButton);
	}

	public boolean isDisplayed_locsw_Validation_OkButton() {
		return isDisplayed(locsw_Validation_OkButton);
	}
	
	

}