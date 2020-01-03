package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_TitleTracking_TitleTrackingSearch_PO extends BasePage {

	public LoanTransaction_TitleTracking_TitleTrackingSearch_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	
	@FindBy(name = "dealNbr")
	private WebElement loanNbr;
	
	@FindBy(xpath = "//input[@onclick='f1()']")
	private WebElement loanNbr_radioButton;
	
	@FindBy(xpath = "//input[@onclick='f2()']")
	private WebElement stage_radioButton;

	@FindBy(name = "requestBean.actionType")
	private WebElement stage;

	@FindBy(name = "submit")
	private WebElement submit_Button;
	
	public void set_loanNbr(String sloc_password) throws InterruptedException{
		doIT(loanNbr, sloc_password);
	}

	public void click_submit_Button(String data) {
		doIT(submit_Button, data);
	}
	
}
