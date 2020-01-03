package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Akula Srikanth Date = 27-July-2018
 */

public class AdminTransaction_EODBatchProcess_PO extends BasePage {

	public AdminTransaction_EODBatchProcess_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[contains(text(),'EOD Batch Process')]")
	private WebElement EOD_BP_Admin_EODBatchProcess_Header;

	@FindBy(name = "requestBean.storeCode")
	private WebElement EOD_BP_Admin_StoreNbr;

	@FindBy(name = "beginMonth")
	private WebElement EOD_BP_Admin_Month;

	@FindBy(name = "beginDay")
	private WebElement EOD_BP_Admin_Day;

	@FindBy(name = "beginYear")
	private WebElement EOD_BP_Admin_Year;

	@FindBy(name = "submit")
	private WebElement EOD_BP_Admin_SubmitButton;

	@FindBy(name = "B2")
	private WebElement EOD_BP_Admin_CancelButton;

	@FindBy(xpath = "//td[contains(text(),'EOD Batch Process completed Successfully. .')]")
	private WebElement EOD_BP_Admin_EODSuccess;

	/*-----------------------------------------------------------
	 *  Locator Methods
	 * ---------------------------------------------------------
	 */

	public String get_EOD_BP_Admin_EODBatchProcess_Header(String data) {
		return doIT(EOD_BP_Admin_EODBatchProcess_Header, data);
	}

	public void set_EOD_BP_Admin_StoreNbr(String data) {
		doIT(EOD_BP_Admin_StoreNbr, data);
		// WebElement element =
		// driver.findElement(By.name("requestBean.storeCode"));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		// element);
	}

	public void c(String strEOD_BP_Admin_Month) {
		doIT(EOD_BP_Admin_Month, strEOD_BP_Admin_Month);
	}

	public void set_EOD_BP_Admin_Day(String strEOD_BP_Admin_Day) {
		doIT(EOD_BP_Admin_Day, strEOD_BP_Admin_Day);
	}

	public void set_EOD_BP_Admin_Year(String strEOD_BP_Admin_Year) {
		doIT(EOD_BP_Admin_Year, strEOD_BP_Admin_Year);
	}

	public void set_EOD_BP_Admin_Date(String data) {
		if(!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(EOD_BP_Admin_Month, MMDDYYYY[0]);			
			doIT(EOD_BP_Admin_Day, MMDDYYYY[1]);
			doIT(EOD_BP_Admin_Year, MMDDYYYY[2]);
		}
	}

	public boolean isDisplayed_EOD_BP_Admin_SubmitButton() {
		return isDisplayed(EOD_BP_Admin_SubmitButton);
	}
	
	public void click_EOD_BP_Admin_SubmitButton(String strEOD_BP_Admin_SubmitButton) {
		doIT(EOD_BP_Admin_SubmitButton, strEOD_BP_Admin_SubmitButton);
	}

	public void click_EOD_BP_Admin_CancelButton(String strEOD_BP_Admin_CancelButton) {
		doIT(EOD_BP_Admin_CancelButton, strEOD_BP_Admin_CancelButton);
	}

	public String get_EOD_BP_Admin_ProcessDateUpdatedSuccessfully(String data) {
		return doIT(EOD_BP_Admin_EODBatchProcess_Header, data);
	}

}
