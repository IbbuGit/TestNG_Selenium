package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_Closer_LineOfCredit_PO extends BasePage {

	public LoanTransaction_Closer_LineOfCredit_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}


	@FindBy(name = "requestBean.password")
	private WebElement loc_password;

	@FindBy(name = "cancel")
	private WebElement loc_cancel_Button;

	@FindBy(name = "close loc")
	private WebElement loc_closer_Button;

	@FindBy(name = "ok")
	private WebElement loc_close_Yes_Button;
	
	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement loc_close_OKButton;
	
	public void set_loc_password(String sloc_password) throws InterruptedException{
		doIT(loc_password, sloc_password);
	}

	public void click_loc_closer(String loc_closer) {
		doIT(loc_closer_Button, loc_closer);
	}
	
	public void click_loc_close_Yes_Button(String loc_closer) {
		doIT(loc_close_Yes_Button, loc_closer);
	}
	public void click_loc_close_OKButton(String loc_closer) {
		doIT(loc_close_OKButton, loc_closer);
	}
}
