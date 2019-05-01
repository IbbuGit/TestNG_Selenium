package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class BorrowerRegistrationIncome_PO extends BasePage {

	/**
	 * @param _driver
	 * @param report
	 */
	public BorrowerRegistrationIncome_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "income")
	private WebElement BrwrRegIncm_registration_Income;

	@FindBy(name = "customerBean.jointApplIncFlgDisp")
	private WebElement BrwrRegIncm_incomeHolder;

	@FindBy(name = "customerBean.incomeCdDisp")
	private WebElement BrwrRegIncm_incomeType;

	@FindBy(name = "customerBean.roomEmpStatus")
	private WebElement BrwrRegIncm_employeeStatus;

	@FindBy(name = "customerBean.empNmDisp")
	private WebElement BrwrRegIncm_Employer;

	@FindBy(name = "customerBean.emplAddress1")
	private WebElement BrwrRegIncm_AddressLine1;

	@FindBy(name = "customerBean.emplAddress2")
	private WebElement BrwrRegIncm_AddressLine2;

	@FindBy(name = "customerBean.emplCity")
	private WebElement BrwrRegIncm_City;

	@FindBy(name = "customerBean.emplState")
	private WebElement BrwrRegIncm_State;

	@FindBy(name = "customerBean.emplzipcode")
	private WebElement BrwrRegIncm_ZipCode;

	@FindBy(name = "customerBean.emplshift")
	private WebElement BrwrRegIncm_EmploymentShift;

	@FindBy(name = "workPhoneNbrDisp1")
	private WebElement BrwrRegIncm_WorkPhone1;

	@FindBy(name = "workPhoneNbrDisp2")
	private WebElement BrwrRegIncm_WorkPhone2;

	@FindBy(name = "workPhoneNbrDisp3")
	private WebElement BrwrRegIncm_WorkPhone3;

	@FindBy(name = "customerBean.incDncFlgDisp")
	private WebElement BrwrRegIncm_DNC_Checkbox;

	@FindBy(name = "customerBean.wrkBadPhoneFlgIncome")
	private WebElement BrwrRegIncm_BadPhone_Checkbox;

	@FindBy(name = "customerBean.wrkBadPhoneFlgSummary")
	private WebElement BrwrRegIncm_BadPhoneSummery_Checkbox;

	@FindBy(name = "customerBean.garnishAmtDisp")
	private WebElement BrwrRegIncm_GarnishAmt;

	@FindBy(name = "customerBean.incomeAmtDisp")
	private WebElement BrwrRegIncm_NetIncomeAmt;

	@FindBy(name = "customerBean.grossAmtDisp")
	private WebElement BrwrRegIncm_GrossIncomeAmt;

	@FindBy(name = "customerBean.payFreqCdDisp")
	private WebElement BrwrRegIncm_PayFrequescy;

	@FindBy(name = "bt_Income")
	private WebElement bri_AddIncomeSource;

	@FindBy(name = "biwk")
	private WebElement BrwrRegIncm_nextPayDate_Button;

	@FindBy(name = "rad_monthly")
	private WebElement BrwrRegIncm_dayOfEachMonth_Button;

	@FindBy(name = "customerBean.monthlyDate")
	private WebElement BrwrRegIncm_dayOfEachMonth;

	@FindBy(name = "customerBean.roomMatePosition")
	private WebElement BrwrRegIncm_JobTitle;

	@FindBy(name = "customerBean.roomSupervisor")
	private WebElement BrwrRegIncm_Supervioser;

	@FindBy(name = "customerBean.directDeposit")
	private WebElement BrwrRegIncm_DirectDeposit;

	@FindBy(name = "hireDate1")
	private WebElement BrwrRegIncm_hireDate;

	@FindBy(name = "payStubReviewed1")
	private WebElement BrwrRegIncm_payStubReviewdMonth;

	@FindBy(name = "payStubReviewed2")
	private WebElement BrwrRegIncm_payStubReviewdDay;

	@FindBy(name = "payStubReviewed3")
	private WebElement BrwrRegIncm_payStubReviewdYear;

	@FindBy(name = "payStubDate1")
	private WebElement BrwrRegIncm_payStubMonth;

	@FindBy(name = "payStubDate2")
	private WebElement BrwrRegIncm_payStubDay;

	@FindBy(name = "payStubDate3")
	private WebElement BrwrRegIncm_payStubYear;

	@FindBy(name = "hireDate1")
	private WebElement BrwrRegIncm_HireMonth;

	@FindBy(name = "hireDate2")
	private WebElement BrwrRegIncm_HireDay;

	@FindBy(name = "hireDate3")
	private WebElement BrwrRegIncm_HireYear;

	@FindBy(name = "customerBean.directDeposit")
	private WebElement BrwrRegIncm_directDeposit;

	@FindBy(name = "appdate1")
	private WebElement ApplicationMnth_MonthlyDate;
	
	@FindBy(name = "appdate2")
	private WebElement ApplicationDay_DailyDate;
	
	@FindBy(name = "appdate3")
	private WebElement ApplicationYear_YearlyDate;
	
	@FindBy(name = "customerBean.monthlyDate")
	private WebElement BrwrRegIncm_MonthlyDate;

	@FindBy(id = "rad_semi1")
	private WebElement BrwrRegIncm_SemiMonthlyDate;

	private String BrwrRegIncm_WeekDay_Frequency = "//td[text()='DYNAMIC_TEXT']/input";
	private String BrwrRegIncm_semiMonthly_Option = "//td[text()='DYNAMIC_TEXT']/input";

	public void click_BrwrRegIncm_semiMonthly_Option(String semiMonthly_Option) {
		doIT(getWebElementForDynamicText(BrwrRegIncm_semiMonthly_Option, semiMonthly_Option), semiMonthly_Option);
	}

	public void click_BrwrRegIncm_WeekDay_Frequency(String WeekDay) {
		doIT(getWebElementForDynamicText(BrwrRegIncm_WeekDay_Frequency, WeekDay), WeekDay);
	}

	public void click_BrwrRegIncm_DNC_Checkbox(String data) {
		doIT(BrwrRegIncm_DNC_Checkbox, data);
	}

	public void click_bri_AddIncomeSource(String data) {
		doIT(bri_AddIncomeSource, data);
	}

	public void click_BrwrRegIncm_SemiMonthlyDate(String data) {
		doIT(BrwrRegIncm_SemiMonthlyDate, data);
	}

	public void click_BrwrRegIncm_registration_Income(String data) {
		doIT(BrwrRegIncm_registration_Income, data);
	}

	public String get_BrwrRegIncm_registration_Income(String data) {
		return doIT(BrwrRegIncm_registration_Income, data);
	}
	
	public String get_ApplicationMnth_MonthlyDate(String data) {
		return doIT(ApplicationMnth_MonthlyDate, data);
	}
	
	public String get_ApplicationDay_DailyDate(String data) {
		return doIT(ApplicationDay_DailyDate, data);
	}
	
	public String get_ApplicationYear_YearlyDate(String data) {
		return doIT(ApplicationYear_YearlyDate, data);
	}

	public String get_ApplicationDate(String data) {
		return get_ApplicationMnth_MonthlyDate("get") + "/" +  get_ApplicationDay_DailyDate("get") + "/" + get_ApplicationYear_YearlyDate("get") ;
	}

	public void set_BrwrRegIncm_registration_Income(String brwrRegIncm_registration_Income) {
		doIT(BrwrRegIncm_registration_Income, brwrRegIncm_registration_Income);
	}

	public void set_BrwrRegIncm_MonthlyDate(String sBrwrRegIncm_MonthlyDate) {
		doIT(BrwrRegIncm_MonthlyDate, sBrwrRegIncm_MonthlyDate);
	}

	public String get_BrwrRegIncm_incomeHolder(String data) {
		return doIT(BrwrRegIncm_incomeHolder, data);
	}

	public void set_BrwrRegIncm_incomeHolder(String brwrRegIncm_incomeHolder) {
		doIT(BrwrRegIncm_incomeHolder, brwrRegIncm_incomeHolder);
	}

	public String get_BrwrRegIncm_incomeType(String data) {
		return doIT(BrwrRegIncm_incomeType, data);
	}

	public void set_BrwrRegIncm_incomeType(String brwrRegIncm_incomeType) {
		doIT(BrwrRegIncm_incomeType, brwrRegIncm_incomeType);
	}

	public String get_BrwrRegIncm_employeeStatus(String data) {
		return doIT(BrwrRegIncm_employeeStatus, data);
	}

	public void set_BrwrRegIncm_employeeStatus(String brwrRegIncm_employeeStatus) {
		doIT(BrwrRegIncm_employeeStatus, brwrRegIncm_employeeStatus);
	}

	public String get_BrwrRegIncm_Employer(String data) {
		return doIT(BrwrRegIncm_Employer, data);
	}

	public void set_BrwrRegIncm_Employer(String brwrRegIncm_Employer) {
		doIT(BrwrRegIncm_Employer, brwrRegIncm_Employer);
	}

	public String get_BrwrRegIncm_AddressLine1(String data) {
		return doIT(BrwrRegIncm_AddressLine1, data);
	}

	public boolean checkVisibilityOfBrwrRegIncm_incomeType() {
		return BrwrRegIncm_incomeType.isDisplayed();
	}

	public void set_BrwrRegIncm_AddressLine1(String brwrRegIncm_AddressLine1) {
		doIT(BrwrRegIncm_AddressLine1, brwrRegIncm_AddressLine1);
	}

	public String get_BrwrRegIncm_AddressLine2(String data) {
		return doIT(BrwrRegIncm_AddressLine2, data);
	}

	public void set_BrwrRegIncm_AddressLine2(String brwrRegIncm_AddressLine2) {
		doIT(BrwrRegIncm_AddressLine2, brwrRegIncm_AddressLine2);
	}

	public String get_BrwrRegIncm_City(String data) {
		return doIT(BrwrRegIncm_City, data);
	}

	public void set_BrwrRegIncm_City(String brwrRegIncm_City) {
		doIT(BrwrRegIncm_City, brwrRegIncm_City);
	}

	public String get_BrwrRegIncm_State(String data) {
		return doIT(BrwrRegIncm_State, data);
	}

	public void set_BrwrRegIncm_State(String brwrRegIncm_State) {
		doIT(BrwrRegIncm_State, brwrRegIncm_State);
	}

	public String get_BrwrRegIncm_ZipCode(String data) {
		return doIT(BrwrRegIncm_ZipCode, data);
	}

	public void set_BrwrRegIncm_ZipCode(String brwrRegIncm_ZipCode) {
		doIT(BrwrRegIncm_ZipCode, brwrRegIncm_ZipCode);
	}

	public String get_BrwrRegIncm_EmploymentShift(String data) {
		return doIT(BrwrRegIncm_EmploymentShift, data);
	}

	public void set_BrwrRegIncm_EmploymentShift(String brwrRegIncm_EmploymentShift) {
		doIT(BrwrRegIncm_EmploymentShift, brwrRegIncm_EmploymentShift);
	}

	public String get_BrwrRegIncm_WorkPhone1(String data) {
		return doIT(BrwrRegIncm_WorkPhone1, data);
	}

	public void set_BrwrRegIncm_WorkPhone1(String brwrRegIncm_WorkPhone1) {
		doIT(BrwrRegIncm_WorkPhone1, brwrRegIncm_WorkPhone1);
	}

	public String get_BrwrRegIncm_WorkPhone2(String data) {
		return doIT(BrwrRegIncm_WorkPhone2, data);
	}

	public void set_BrwrRegIncm_WorkPhone2(String brwrRegIncm_WorkPhone2) {
		doIT(BrwrRegIncm_WorkPhone2, brwrRegIncm_WorkPhone2);
	}

	public String get_BrwrRegIncm_WorkPhone3(String data) {
		return doIT(BrwrRegIncm_WorkPhone3, data);
	}

	public void set_BrwrRegIncm_WorkPhone3(String brwrRegIncm_WorkPhone3) {
		doIT(BrwrRegIncm_WorkPhone3, brwrRegIncm_WorkPhone3);
	}

	public void set_BrwrRegIncm_WorkPhone(String data) {

		if (data.equalsIgnoreCase("Random")) {
			set_BrwrRegIncm_WorkPhone1("985");
			set_BrwrRegIncm_WorkPhone2(Helper.getRandomNumeric(3));
			set_BrwrRegIncm_WorkPhone3(Helper.getRandomNumeric(4));
		} else if (!data.isEmpty()) {

			String[] WorkPhNbr = data.split("-", -2);
			doIT(BrwrRegIncm_WorkPhone1, WorkPhNbr[0]);
			doIT(BrwrRegIncm_WorkPhone2, WorkPhNbr[1]);
			doIT(BrwrRegIncm_WorkPhone3, WorkPhNbr[2]);
		}

	}

	public String get_BrwrRegIncm_DNC_Checkbox(String data) {
		return doIT(BrwrRegIncm_DNC_Checkbox, data);
	}

	public void set_BrwrRegIncm_DNC_Checkbox(String brwrRegIncm_DNC_Checkbox) {
		doIT(BrwrRegIncm_DNC_Checkbox, brwrRegIncm_DNC_Checkbox);
	}

	public String get_BrwrRegIncm_GarnishAmt(String data) {
		return doIT(BrwrRegIncm_GarnishAmt, data);
	}

	public void set_BrwrRegIncm_GarnishAmt(String brwrRegIncm_GarnishAmt) {
		doIT(BrwrRegIncm_GarnishAmt, brwrRegIncm_GarnishAmt);
	}

	public String get_BrwrRegIncm_NetIncomeAmt(String data) {
		return doIT(BrwrRegIncm_NetIncomeAmt, data);
	}

	public void set_BrwrRegIncm_NetIncomeAmt(String brwrRegIncm_NetIncomeAmt) {
		doIT(BrwrRegIncm_NetIncomeAmt, brwrRegIncm_NetIncomeAmt);
	}

	public String get_BrwrRegIncm_GrossIncomeAmt(String data) {
		return doIT(BrwrRegIncm_GrossIncomeAmt, data);
	}

	public void set_BrwrRegIncm_GrossIncomeAmt(String brwrRegIncm_GrossIncomeAmt) {
		doIT(BrwrRegIncm_GrossIncomeAmt, brwrRegIncm_GrossIncomeAmt);
	}

	public String get_BrwrRegIncm_PayFrequescy(String data) {
		return doIT(BrwrRegIncm_PayFrequescy, data);
	}

	public void set_BrwrRegIncm_PayFrequescy(String brwrRegIncm_PayFrequescy) {
		doIT(BrwrRegIncm_PayFrequescy, brwrRegIncm_PayFrequescy);
	}

	public String get_BrwrRegIncm_dayOfEachMonth_Button(String data) {
		return doIT(BrwrRegIncm_dayOfEachMonth_Button, data);
	}

	public void set_BrwrRegIncm_dayOfEachMonth_Button(String brwrRegIncm_dayOfEachMonth_Button) {
		doIT(BrwrRegIncm_dayOfEachMonth_Button, brwrRegIncm_dayOfEachMonth_Button);
	}

	public String get_BrwrRegIncm_dayOfEachMonth(String data) {
		return doIT(BrwrRegIncm_dayOfEachMonth, data);
	}

	public void set_BrwrRegIncm_dayOfEachMonth(String brwrRegIncm_dayOfEachMonth) {
		doIT(BrwrRegIncm_dayOfEachMonth, brwrRegIncm_dayOfEachMonth);
	}

	public String get_BrwrRegIncm_JobTitle(String data) {
		return doIT(BrwrRegIncm_JobTitle, data);
	}

	public void set_BrwrRegIncm_JobTitle(String brwrRegIncm_JobTitle) {
		doIT(BrwrRegIncm_JobTitle, brwrRegIncm_JobTitle);
	}

	public String get_BrwrRegIncm_Supervioser(String data) {
		return doIT(BrwrRegIncm_Supervioser, data);
	}

	public void set_BrwrRegIncm_Supervioser(String brwrRegIncm_Supervioser) {
		doIT(BrwrRegIncm_Supervioser, brwrRegIncm_Supervioser);
	}

	public String get_BrwrRegIncm_DirectDeposit(String data) {
		return doIT(BrwrRegIncm_DirectDeposit, data);
	}

	public void set_BrwrRegIncm_DirectDeposit(String brwrRegIncm_DirectDeposit) {
		doIT(BrwrRegIncm_DirectDeposit, brwrRegIncm_DirectDeposit);
	}

	public String get_BrwrRegIncm_hireDate(String data) {
		return doIT(BrwrRegIncm_hireDate, data);
	}

	public void set_BrwrRegIncm_hireDate(String brwrRegIncm_hireDate) {
		doIT(BrwrRegIncm_hireDate, brwrRegIncm_hireDate);
	}

	public String get_BrwrRegIncm_payStubReviewdMonth(String data) {
		return doIT(BrwrRegIncm_payStubReviewdMonth, data);
	}

	public void set_BrwrRegIncm_payStubReviewdMonth(String brwrRegIncm_payStubReviewdMonth) {
		doIT(BrwrRegIncm_payStubReviewdMonth, brwrRegIncm_payStubReviewdMonth);
	}

	public String get_BrwrRegIncm_payStubReviewdDay(String data) {
		return doIT(BrwrRegIncm_payStubReviewdDay, data);
	}

	public void set_BrwrRegIncm_payStubReviewdDay(String brwrRegIncm_payStubReviewdDay) {
		doIT(BrwrRegIncm_payStubReviewdDay, brwrRegIncm_payStubReviewdDay);
	}

	public String get_BrwrRegIncm_payStubReviewdYear(String data) {
		return doIT(BrwrRegIncm_payStubReviewdYear, data);
	}

	public void set_BrwrRegIncm_payStubReviewdYear(String brwrRegIncm_payStubReviewdYear) {
		doIT(BrwrRegIncm_payStubReviewdYear, brwrRegIncm_payStubReviewdYear);
	}
	public void set_PayStubReview_Date(String data) {
		if(!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(BrwrRegIncm_payStubReviewdMonth, MMDDYYYY[0]);
			doIT(BrwrRegIncm_payStubReviewdDay, MMDDYYYY[1]);
			doIT(BrwrRegIncm_payStubReviewdYear, MMDDYYYY[2]);
		}
	}
	public String get_BrwrRegIncm_payStubMonth(String data) {
		return doIT(BrwrRegIncm_payStubMonth, data);
	}

	public void set_BrwrRegIncm_payStubMonth(String brwrRegIncm_payStubMonth) {
		doIT(BrwrRegIncm_payStubMonth, brwrRegIncm_payStubMonth);
	}

	public String get_BrwrRegIncm_payStubDay(String data) {
		return doIT(BrwrRegIncm_payStubDay, data);
	}

	public void set_BrwrRegIncm_payStubDay(String brwrRegIncm_payStubDay) {
		doIT(BrwrRegIncm_payStubDay, brwrRegIncm_payStubDay);
	}

	public String get_BrwrRegIncm_payStubYear(String data) {
		return doIT(BrwrRegIncm_payStubYear, data);
	}

	public void set_BrwrRegIncm_payStubYear(String brwrRegIncm_payStubYear) {
		doIT(BrwrRegIncm_payStubYear, brwrRegIncm_payStubYear);
	}

	public void set_PayStub_Date(String data) {
		if(!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(BrwrRegIncm_payStubMonth, MMDDYYYY[0]);
			doIT(BrwrRegIncm_payStubDay, MMDDYYYY[1]);
			doIT(BrwrRegIncm_payStubYear, MMDDYYYY[2]);
		}
	}
	public void set_Hire_Date(String data) {
		if(!data.isEmpty()) {
			String[] MMDDYYYY = data.split("/");
			doIT(BrwrRegIncm_HireMonth, MMDDYYYY[0]);
			doIT(BrwrRegIncm_HireDay, MMDDYYYY[1]);
			doIT(BrwrRegIncm_HireYear, MMDDYYYY[2]);
		}
	}

	public String get_BrwrRegIncm_directDeposit(String data) {
		return doIT(BrwrRegIncm_directDeposit, data);
	}

	public void set_BrwrRegIncm_directDeposit(String brwrRegIncm_directDeposit) {
		doIT(BrwrRegIncm_directDeposit, brwrRegIncm_directDeposit);
	}

}
