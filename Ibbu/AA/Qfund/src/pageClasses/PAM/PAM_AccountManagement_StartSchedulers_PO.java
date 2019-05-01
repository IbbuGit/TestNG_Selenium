package pageClasses.PAM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.BasePage;

public class PAM_AccountManagement_StartSchedulers_PO extends BasePage {

	public PAM_AccountManagement_StartSchedulers_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(name = "requestBean.scheduleId")
	private WebElement scheduleName;

	@FindBy(name = "requestBean.locNbr")
	private WebElement storeCode;

	@FindBy(name = "endMonth")
	private WebElement dateMonth;

	@FindBy(name = "endDay")
	private WebElement dateDay;

	@FindBy(name = "endYear")
	private WebElement dateYear;

	@FindBy(name = "runSchedulerBtn")
	private WebElement runScheduler_button;
	
	@FindBy(xpath ="//td[@class='formHeading']")
	private WebElement startScheduler_pageHeader;
	
	public String get_startScheduler_Header(String TestData_startScheduler_Header) {
		return doIT(startScheduler_pageHeader, TestData_startScheduler_Header);
	}

	public void set_scheduleName(String TestData_scheduleName){
		doIT(scheduleName, TestData_scheduleName);
	}

	public void set_storeCode(String TestData_storeCode){
		doIT(storeCode, TestData_storeCode);
	}
	
	public void set_dateMonth(String TestData_dateMonth){
		doIT(dateMonth, TestData_dateMonth);
	}
	
	public void set_dateDay(String TestData_dateDay){
		doIT(dateDay, TestData_dateDay);
	}
	
	public void set_dateYear(String TestData_dateYear){
		doIT(dateYear, TestData_dateYear);
	}
	
	public void click_runScheduler_button(String TestData_runScheduler_button){
		doIT(runScheduler_button, TestData_runScheduler_button);
	}
	
}
