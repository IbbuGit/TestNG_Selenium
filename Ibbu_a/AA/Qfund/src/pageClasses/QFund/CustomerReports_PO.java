package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class CustomerReports_PO extends BasePage{
	
	public CustomerReports_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		
	}
	
	
	//------------------------------------------------------------------------------------------------------------------
		//	Module Name			:	Customer Reports
		//	Method				:	Page objects and Set and Get Methods
		//	Class Name			:	CustomerReports_PO
		//	Page Name(QFundX)	:	Customer Reports
		//	Responsible			:	Gowri
		//	Date				:	11-April-2019
		//--------------------------------------------------------------------------------------------------------------
	
	
	@FindBy(name="beginMonth")			
	private WebElement customerReports_beginMonth;
	
	@FindBy(name="beginDay")			
	private WebElement customerReports_beginDay;
	
	@FindBy(name="beginYear")			
	private WebElement customerReports_beginYear;
	
	@FindBy(name="endMonth")			
	private WebElement customerReports_endMonth;
	
	@FindBy(name="endDay")			
	private WebElement customerReports_endDay;
	
	@FindBy(name="endYear")			
	private WebElement customerReports_endYear;
	
	@FindBy(name="btnPreview")			
	private WebElement customerReports_btnPreview;
	
	@FindBy(name="B2")			
	private WebElement customerReports_btnReset;
	
	@FindBy(xpath="//input[@value='Generate Excel']")			
	private WebElement GenerateExcel;
	
	@FindBy(name="requestBean.loanType")			
	private WebElement customerReports_LoanType;
	
	@FindBy(name="custNbr")			
	private WebElement customerReports_CustomerNo;
	
	@FindBy(name="productType")			
	private WebElement customerReports_ProductType;
	
	@FindBy(xpath="//input[@value='getOne']")			
	private WebElement customerReports_DeceasedDateOption;
	
	@FindBy(xpath="//input[@value='getTwo']")			
	private WebElement customerReports_CustomerNoOption;
	
	@FindBy(xpath="//input[@value='getThree']")			
	private WebElement customerReports_CustomerNameOption;
	
	@FindBy(xpath="//input[@value='getFour']")			
	private WebElement customerReports_CheckNbrOption;
	
	@FindBy(xpath="//input[@value='getFive']")			
	private WebElement customerReports_CheckAmountOption;
	
	@FindBy(xpath="//input[@value='getSix']")			
	private WebElement customerReports_TotalOwedOption;
	
	@FindBy(xpath="//input[@value='getSeven']")			
	private WebElement customerReports_ProductsOption;
	
	@FindBy(xpath="//input[@value='getEight']")			
	private WebElement customerReports_EmployeeNameOption;
	
	@FindBy(xpath="//input[@value='getNine']")			
	private WebElement customerReports_StoreNoOption;
	
	
	
	public void set_customerReports_beginMonth(String scustomerReports_beginMonth) {
		doIT(customerReports_beginMonth, scustomerReports_beginMonth);
	}
	
	public void set_customerReports_beginDay(String scustomerReports_beginDay) {
		doIT(customerReports_beginDay, scustomerReports_beginDay);
	}
	
	public void set_customerReports_beginYear(String scustomerReports_beginYear) {
		customerReports_beginYear.clear();
		doIT(customerReports_beginYear, scustomerReports_beginYear);
	}
	
	public void set_customerReports_endMonth(String scustomerReports_endMonth) {
		doIT(customerReports_endMonth, scustomerReports_endMonth);
	}
	
	public void set_customerReports_endDay(String scustomerReports_endDay) {
		doIT(customerReports_endDay, scustomerReports_endDay);
	}
	
	public void set_customerReports_endYear(String scustomerReports_endYear) {
		customerReports_endYear.clear();
		doIT(customerReports_endYear, scustomerReports_endYear);
	}
	
	public void click_customerReports_btnPreview(String data){
		doIT(customerReports_btnPreview,data);
	}
	
	public void click_GenerateExcel(String data){
		doIT(GenerateExcel,data);
	}
	
	public void click_customerReports_btnReset(String data){
		doIT(customerReports_btnReset,data);
	}
	
	public void saveFileAndClose() {
		
		//Thread.sleep(5000);
		  
		/*  Local $hIE = WinGetHandle("[Class:IEFrame]")
		  Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:DirectUIHWND1]")
		  ControlSend($hIE ,"",$hCtrl,"{TAB}")          ; Gives focus to Open Button
		  Sleep(500)
		  ControlSend($hIE ,"",$hCtrl,"{TAB}")          ; Gives focus to Save Button
		  Sleep(500)
		  ControlSend($hIE ,"",$hCtrl,"{enter}")        ; Submit whatever control has focus*/
		  
		
		 //.sleep(5000);

	}
	
}
