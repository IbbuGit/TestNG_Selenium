package pageClasses.QFund;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * author = Akula Srikanth Date = 27-July-2018
 */

public class AdminTransaction_QAJobs_ProcessDateChange_PO extends BasePage {

	public AdminTransaction_QAJobs_ProcessDateChange_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[contains(text(),'Process Date Change')]")
	private WebElement PDC_ProcessDateChange_Header;

	@FindBy(xpath = "//td[contains(text(),'LOC Statement')]")
	private WebElement us_Header;

	@FindBy(name = "storeCode")
	private WebElement PDC_StoreNbr;

	@FindBy(xpath = "//input[contains(@name,'storeCode')]")
	private WebElement us_StoreNbr;

	@FindBy(name = "beginMonth")
	private WebElement PDC_Month;

	@FindBy(name = "beginDay")
	private WebElement PDC_Day;

	@FindBy(name = "beginYear")
	private WebElement PDC_Year;

	@FindBy(name = "btnPreview")
	private WebElement PDC_SubmitButton;

	@FindBy(name = "submit")
	private WebElement us_SubmitButton;

	@FindBy(name = "B2")
	private WebElement PDC_CancelButton;

	@FindBy(xpath = "//td[contains(text(),'Process Date updated successfully.')]")
	private WebElement PDC_ProcessDateUpdatedSuccessfully;

	@FindBy(xpath = ".//input[@value='Ok']")
	private WebElement PDC_UpdatedSuccess_OkButton;

	@FindBy(name = "locationBean.locNbr")
	private WebElement Edit_StoreNo;

	@FindBy(name = "Submit2")
	private WebElement Edit_StoreNo_SubmitBtn;

	@FindBy(name = "locationBean.locStatusCd")
	private WebElement Edit_StoreStatus;

	@FindBy(name = "locationBean.rom")
	private WebElement Edit_StoreStatus_RM;

	@FindBy(name = "locationBean.dvp")
	private WebElement Edit_StoreStatus_DVP;

	@FindBy(name = "submitButton")
	private WebElement Edit_StoreStatus_Submitbtn;
	

	
	

	/*-----------------------------------------------------------
	 *  Locator Methods
	 * ---------------------------------------------------------
	 */

	public String get_ProcessDateChange_Header(String data) {
		return doIT(PDC_ProcessDateChange_Header, data);
	}

	public String get_us_Header(String data) {
		return doIT(us_Header, data);
	}

	public void set_PDC_StoreNbr(String strPDC_StoreNbr) {
		doIT(PDC_StoreNbr, strPDC_StoreNbr);
	}

	public void set_us_StoreNbr(String data) {
		doIT(us_StoreNbr, data);
	}

	public void set_PDC_Date(String data) {
		if(!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(PDC_Month, MMDDYYYY[0]);
			doIT(PDC_Day, MMDDYYYY[1]);
			doIT(PDC_Year, MMDDYYYY[2]);
		}
	}

	public void set_PDC_Month(String strPDC_Month) {
		doIT(PDC_Month, strPDC_Month);
	}

	public void set_PDC_Day(String strPDC_Day) {
		doIT(PDC_Day, strPDC_Day);
	}

	public void set_PDC_Year(String strPDC_Year) {
		doIT(PDC_Year, strPDC_Year);
	}

	public void set_Edit_StoreNo(String sEdit_StoreNo) {
		doIT(Edit_StoreNo, sEdit_StoreNo);
	}

	public void set_Edit_StoreStatus(String sEdit_StoreStatus) {
		doIT(Edit_StoreStatus, sEdit_StoreStatus);
	}

	public void set_Edit_StoreStatus_RM(String sEdit_StoreStatus_RM) {
		doIT(Edit_StoreStatus_RM, sEdit_StoreStatus_RM);
	}

	public void set_Edit_StoreStatus_DVP(String sEdit_StoreStatus_DVP) {
		doIT(Edit_StoreStatus_DVP, sEdit_StoreStatus_DVP);
	}

	public void click_PDC_SubmitButton(String strPDC_SubmitButton) {
		doIT(PDC_SubmitButton, strPDC_SubmitButton);
	}

	public void click_us_SubmitButton(String data) {
		doIT(us_SubmitButton, data);
	}

	public boolean isDisplayed_PDC_SubmitButton() {
		return isDisplayed(PDC_SubmitButton);
	}
	
	public boolean isDisplayed_us_SubmitButton() {
		return isDisplayed(us_SubmitButton);
	}

	public boolean isDisplayed_Edit_StoreStatus_Submitbtn() {
		return isDisplayed(Edit_StoreStatus_Submitbtn);
	}
	
	public void click_Edit_StoreStatus_Submitbtn(String sEdit_StoreStatus_Submitbtn) {
		doIT(Edit_StoreStatus_Submitbtn, sEdit_StoreStatus_Submitbtn);
	}

	public void click_Edit_StoreNo_SubmitBtn(String sEdit_StoreNo_SubmitBtn) {
		doIT(Edit_StoreNo_SubmitBtn, sEdit_StoreNo_SubmitBtn);
	}

	public void click_PDC_CancelButton(String strPDC_CancelButton) {
		doIT(PDC_CancelButton, strPDC_CancelButton);
	}

	public String get_PDC_ProcessDateUpdatedSuccessfully(String data) {
		return doIT(PDC_ProcessDateUpdatedSuccessfully, data);
	}

	public void click_PDC_UpdatedSuccess_OkButton(String strPDC_UpdatedSuccess_OkButton) {
		doIT(PDC_UpdatedSuccess_OkButton, strPDC_UpdatedSuccess_OkButton);
	}

	public void set_businessDate(String data, String moveDate) {
		if (data.toUpperCase().equals("TODAY") && moveDate != null) {
			int mdate = Integer.parseInt(moveDate);
			DateFormat dateFormat = new SimpleDateFormat("E, MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, mdate);
			if (dateFormat.format(c.getTime()).contains("Sun")) {
				c.add(Calendar.DATE, 1);
			}
			set_Date(new SimpleDateFormat("MM/dd/yyyy").format(c.getTime()));
		} else {
			set_Date(data);
		}
	}

	public void set_Date(String date) {
		String[] s_Date = date.split("/", -2);
		doIT(PDC_Month, s_Date[0]);
		doIT(PDC_Day, s_Date[1]);
		doIT(PDC_Year, s_Date[2]);
	}
}
