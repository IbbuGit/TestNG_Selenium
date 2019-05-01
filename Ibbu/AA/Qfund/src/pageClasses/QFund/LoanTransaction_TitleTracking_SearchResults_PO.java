package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */

public class LoanTransaction_TitleTracking_SearchResults_PO extends BasePage {

	public LoanTransaction_TitleTracking_SearchResults_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}
	
	@FindBy(name = "requestBean.chkLoanCode")
	private WebElement select_checkBox;
	
	@FindBy(name = "requestBean.actionTypeNew")
	private WebElement title_Track_Id_ListBox;
	
	@FindBy(name = "CmdTitleTrack")
	private WebElement submit_Button;
	
	@FindBy(name = "button")
	private WebElement history_Button;
	
	@FindBy(xpath = "//td[contains(text(),'Title Status Updated Successfully')]")
	private WebElement success_Msg;
		
	public void click_select_checkBox(String data) {
		doIT(select_checkBox, data);
	}
	public void title_Track_Id_ListBox(String data) {
		new Select(title_Track_Id_ListBox).selectByVisibleText(data);
	}	
	public void click_submit_Button(String data) {
		doIT(submit_Button, data);
	}
	
}
