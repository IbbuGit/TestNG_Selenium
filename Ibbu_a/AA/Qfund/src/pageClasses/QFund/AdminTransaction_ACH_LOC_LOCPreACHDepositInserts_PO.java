package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Sameer Chauhan Date = 06-Nov-2018
 */

public class AdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO extends BasePage {

	/*
	 * Constructor
	 */

	public AdminTransaction_ACH_LOC_LOCPreACHDepositInserts_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Page locators
	 */

	@FindBy(xpath ="//td[@class='formHeading']")
	private WebElement LOCPreAchDepositInserts_pageHeader;

	@FindBy(name = "beginMonth")
	private WebElement businessDate_Month;

	@FindBy(name = "beginDay")
	private WebElement businessDate_Day;

	@FindBy(name = "beginYear")
	private WebElement businessDate_Year;

	@FindBy(name = "btnPreview")
	private WebElement submitButton;

	/*
	 * Page locator Methods
	 */
	
	//get value for the page header
	public String get_locPreACHDepositInsert_pageHeader(String TestData_pageHeader) {
		return doIT(LOCPreAchDepositInserts_pageHeader, TestData_pageHeader);
	}
	
	//set month in the date
	public void set_businessDate_Month(String TestData_businessDate_Month) {
		doIT(businessDate_Month, TestData_businessDate_Month);
	}

	//set day in the month
	public void set_businessDate_Day(String TestData_businessDate_Day) {
		doIT(businessDate_Day, TestData_businessDate_Day);
	}
	
	//set year in the month
	public void set_businessDate_Year(String TestData_businessDate_Year) {
		doIT(businessDate_Year, TestData_businessDate_Year);
	}
	
	//click on submit button
	public void click_submitButton(String TestData_submitButton) {
		doIT(submitButton, TestData_submitButton);
	}
}