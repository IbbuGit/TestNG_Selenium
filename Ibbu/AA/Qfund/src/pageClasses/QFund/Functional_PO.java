package pageClasses.QFund;
 
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class Functional_PO extends BasePage {

	public Functional_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*-----------------------------------------------------------------------------------------------
	 * Pin Expired
	 * ---------------------------------------------------------------------------------------------
	 */

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-home']")
	public WebElement Home;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-lock']")
	private WebElement ChangePin;

	@FindBy(name = "changePasswordRequestBean.oldPassword")
	private WebElement OldPin;

	@FindBy(name = "changePasswordRequestBean.newPassword")
	private WebElement NewPin;

	@FindBy(name = "changePasswordRequestBean.confirmPassword")
	private WebElement ConfirmPin;

	@FindBy(name = "Submit")
	private WebElement Submit;

	@FindBy(xpath = "//td[contains(text(),'QFund')]")
	private WebElement Homepage_Message;

	@FindBy(xpath = "//td[contains(text(),'Password change was successful. Your new password has been activated')]")
	private WebElement ChangePassword_Message;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-log-out']")
	private WebElement Logout;

	@FindBy(name = "Change PIN")
	private WebElement PE_PageHeader;

	@FindBy(name = "PIN# Expired")
	private WebElement PE_PinExpiredMsg;

	@FindBy(name = "Change Password")
	private WebElement PE_ChangePasswordButton;

	@FindBy(name = "changePasswordRequestBean.newPassword")
	private WebElement PE_NewPin;

	@FindBy(name = "changePasswordRequestBean.confirmPassword")
	private WebElement PE_ConfirmPin;

	@FindBy(name = "Submit")
	private WebElement PE_SubmitButton;

	@FindBy(xpath = "//td[contains(text(),'Password Change was sucsessful. Your new password has been activated')]")
	private WebElement PE_PasswordChangeConfirmMsg;

	@FindBy(name = "Login Again")
	private WebElement PE_LoginAgainButton;

	// @FindBy(xpath="//tbody[tr[td[contains(text(),'Store
	// Nbr')]]]/tr[2]/td[1]")
	@FindBy(xpath = "//tbody[tr[td[text()='Store Nbr']]]/tr[2]/td[1]")
	private WebElement clockoutStoreNo;

	public String get_clockoutStoreNo(String data) {
		return doIT(clockoutStoreNo, data);
	}

	/*-----------------------------------------------------------------------------------------------
	 * Change Pin
	 * ---------------------------------------------------------------------------------------------
	 */

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-home']")
	private WebElement CP_HomeLink;

	@FindBy(name = "Change Pin")
	private WebElement CP_PageHeader;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-lock']")
	private WebElement CP_ChangePin;

	@FindBy(name = "changePasswordRequestBean.oldPassword")
	private WebElement CP_OldPin;

	@FindBy(name = "changePasswordRequestBean.newPassword")
	private WebElement CP_NewPin;

	@FindBy(name = "changePasswordRequestBean.confirmPassword")
	private WebElement CP_ConfirmPin;

	@FindBy(name = "Submit")
	private WebElement CP_SubmitButton;

	@FindBy(xpath = "//td[@class='leftHeading']")
	private WebElement CP_SuccessMessage;

	/*-----------------------------------------------------------------------------------------------
	 * ClockIn
	 * ---------------------------------------------------------------------------------------------
	 */

	@FindBy(xpath = "//td[contains(text(),'Clock In')]")
	private WebElement CI_PageHeader;

	@FindBy(name = "clockRequestBean.clockIntTime")
	private WebElement CI_ClockInTime;

	@FindBy(xpath = "//input[@value='Clock In']")
	public WebElement CI_ClockInButton;

	/*-----------------------------------------------------------------------------------------------
	 * ClockOut
	 * ---------------------------------------------------------------------------------------------
	 */

	@FindBy(xpath = "//td[@class='formHeading' and contains(text(),'Clock Out')]")
	private WebElement CO_PageHeader;

	@FindBy(xpath = "//tr[@class='formHeading' and contains(text(),'Store Nbr')]/following-sibbling::tr/td[1]")
	private WebElement CO_StoreNbr;
	@FindBy(xpath = "//tr[@class='formHeading' and contains(text(),'Clock in Time')]/following-sibbling::tr/td[2]")
	private WebElement CO_ClockInTime;
	@FindBy(xpath = "//tr[@class='formHeading' and contains(text(),'Clock in Date')]/following-sibbling::tr/td[3]")
	private WebElement CO_ClockInDate;
	@FindBy(name = "clockRequestBean.clockOutTime")
	private WebElement CO_ClockOutTime;
	@FindBy(xpath = "//tr[@class='formHeading' and contains(text(),'Clock out Date')]/following-sibbling::tr/td[5]")
	private WebElement CO_ClockOutDate;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-time']")
	private WebElement CO_ClockOutButton;

	@FindBy(xpath = "//input[@value='Clock Out']")
	public WebElement CO_confirmButton;

	/*-----------------------------------------------------------------------------------------------
	 * Home
	 * ---------------------------------------------------------------------------------------------
	 */

	@FindBy(xpath = "//td[@class='formHeading' and contains(text(),'QFund')]")
	private WebElement HO_PageHeader;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-user']")
	private WebElement HO_Search_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-info-sign']")
	private WebElement HO_Info_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-home']")
	private WebElement HO_Home_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-time']")
	private WebElement HO_ClockOut_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-in']")
	private WebElement HO_ClockIn_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-list-alt']")
	private WebElement HO_TimeSheet_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-lock']")
	private WebElement HO_ChangePin_Link;

	@FindBy(xpath = "//a[@class='glyphicon glyphicon-log-out']")
	private WebElement HO_Logout_Link;

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	/*-----------------------------------------------------------------------------------------------
	 * Pin Expired
	 * ---------------------------------------------------------------------------------------------
	 */
	public String get_OldPin(String data) {
		return doIT(OldPin, data);
	}

	public void set_OldPin(String oldPin) {
		doIT(OldPin, oldPin);

	}

	public String get_NewPin(String data) {
		return doIT(NewPin, data);
	}

	public void set_NewPin(String newPin) {
		doIT(NewPin, newPin);

	}

	public String get_ConfirmPin(String data) {
		return doIT(ConfirmPin, data);
	}

	public void set_ConfirmPin(String confirmPin) {
		doIT(ConfirmPin, confirmPin);

	}

	public String get_ChangePassword_Message(String data) {
		return doIT(ChangePassword_Message, data);
	}

	public void set_ChangePassword_Message(String changePassword_Message) {
		doIT(ChangePassword_Message, changePassword_Message);
	}

	public String get_Homepage_Message(String data) {
		return doIT(Homepage_Message, data);
	}

	public String verifyHomepage() throws InterruptedException {
		return Homepage_Message.getText();
	}

	public void click_Home(String data) {
		doIT(Home, data);
	}

	public void click_ChangePin(String data) {
		doIT(ChangePin, data);
	}

	public void click_Submit(String data) {
		doIT(Submit, data);
	}

	public void click_Logout(String data) {
		selectFrame(frameTop);
		doIT(Logout, data);
	}

	public String get_PINExpired_PageHeader(String TestData) {

		return doIT(PE_PageHeader, TestData);

	}

	public String get_PINExpired_PinExpiredMsg(String TestData) {

		return doIT(PE_PinExpiredMsg, TestData);

	}

	public void click_PINExpired_ChangePasswordButton(String TestData) {

		doIT(PE_ChangePasswordButton, TestData);

	}

	public String get_PINExpired_NewPin(String TestData) {

		return doIT(PE_NewPin, TestData);

	}

	public void set_PINExpired_NewPin(String TestData) {

		doIT(PE_NewPin, TestData);

	}

	public String get_PINExpired_ConfirmPin(String TestData) {

		return doIT(PE_ConfirmPin, TestData);

	}

	public void set_PINExpired_ConfirmPin(String TestData) {

		doIT(PE_ConfirmPin, TestData);

	}

	public void click_PinExpired_SubmitButton(String TestData) {

		doIT(PE_SubmitButton, TestData);

	}

	public String get_PinExpired_PasswordChangeConfirmMsg(String TestData) {

		return doIT(PE_PasswordChangeConfirmMsg, TestData);

	}

	public void click_PinExpired_LoginAgainButton(String TestData) {

		doIT(PE_LoginAgainButton, TestData);

	}

	/*-----------------------------------------------------------------------------------------------
	 * Clock Out
	 * ---------------------------------------------------------------------------------------------
	 */

	public void click_CO_confirmButton(String TestData) {
		waitForButton();
		doIT(CO_confirmButton, TestData);

	}

	public String get_ClockOut_PageHeader(String TestData) {

		return doIT(CO_PageHeader, TestData);

	}

	public String get_ClockOut_StoreNbr(String TestData) {

		return doIT(CO_StoreNbr, TestData);

	}

	public String get_ClockOut_ClockInTime(String TestData) {

		return doIT(CO_ClockInTime, TestData);

	}

	public String get_ClockOut_ClockInDate(String TestData) {

		return doIT(CO_ClockInDate, TestData);
	}

	public void set_CO_ClockOutTime(String TestData) {
		if (TestData != null) {
			CO_ClockOutTime.clear();
			doIT(CO_ClockOutTime, TestData);
		}


	}

	public String get_ClockOut_ClockOutDate(String TestData) {

		return doIT(CO_ClockOutDate, TestData);

	}

	public void click_CO_ClockOutButton(String TestData) {		
		doIT(CO_ClockOutButton, TestData);

	}

	/*-----------------------------------------------------------------------------------------------
	 * Clock In
	 * ---------------------------------------------------------------------------------------------
	 */

	public String get_ClockIn_PageHeader(String TestData) {

		return doIT(CI_PageHeader, TestData);
	}

	public String get_ClockIn_ClockInTime(String TestData) {
		return doIT(CI_ClockInTime, TestData);
	}

	public void set_ClockIn_ClockInTime(String TestData) {
		doIT(CI_ClockInTime, TestData);
	}

	public void click_CI_ClockInButton(String TestData) {
		wait.until(ExpectedConditions.elementToBeClickable(CI_ClockInTime));
		doIT(CI_ClockInButton, TestData);

	}

	public boolean visibilityOfClockIn() {
		return isDisplayed(CI_ClockInButton);
	}

	public boolean visibilityOfClockOut() {
		return isDisplayed(CO_confirmButton);

	}

	public boolean alertPresent() {
		return ExpectedConditions.alertIsPresent() != null;
	}

	/*-----------------------------------------------------------------------------------------------
	 * Home
	 * ---------------------------------------------------------------------------------------------
	 */

	public String get_HomePage_InfoLink(String TestData) {
		return doIT(HO_Info_Link, TestData);
	}

	public String get_HomePage_SeachLink(String TestData) {
		return doIT(HO_Search_Link, TestData);
	}

	public String get_HomePage_HomeLink(String TestData) {
		return doIT(HO_Home_Link, TestData);
	}

	public String get_HomePage_ChangePinLink(String TestData) {
		return doIT(HO_ChangePin_Link, TestData);
	}

	public String get_HomePage_ClockOutLink(String TestData) {
		return doIT(HO_ClockOut_Link, TestData);
	}

	public String get_HomePage_ClockInLink(String TestData) {
		return doIT(HO_ClockIn_Link, TestData);
	}

	public String get_HomePage_TimeSheetLink(String TestData) {
		return doIT(HO_TimeSheet_Link, TestData);
	}

	public String get_HomePage_LogoutLink(String TestData) {
		return doIT(HO_Logout_Link, TestData);
	}

	public void click_HomePage_SearchLink(String TestData) {
		doIT(HO_Search_Link, TestData);
	}

	public void click_HomePage_InfoLink(String TestData) {
		doIT(HO_Info_Link, TestData);
	}

	public void click_HomePage_HomeLink(String TestData) {
		wait.until(ExpectedConditions.elementToBeClickable(HO_Home_Link));
		doIT(HO_Home_Link, TestData);
	}

	public void click_HomePage_ChangePINLink(String TestData) {
		doIT(HO_ChangePin_Link, TestData);
	}

	public void click_HomePage_ClockOutLink(String TestData) {
		doIT(HO_ClockOut_Link, TestData);
	}

	public void click_HomePage_ClockInLink(String TestData) {
		doIT(HO_ClockIn_Link, TestData);
	}

	public void click_HomePage_TimeSheetLink(String TestData) {
		doIT(HO_TimeSheet_Link, TestData);
	}

	public void click_HomePage_LogoutLink(String TestData) {
		doIT(HO_Logout_Link, TestData);
	}

	public boolean VerifyIsDisplayed_HomePage_SearchLink(String TestData) {
		if (!TestData.isEmpty()) {
			return HO_Search_Link.isDisplayed();
		} else {
			return true;
		}
	}

	public boolean VerifyIsDisplayed_HomePage_InfoLink(String TestData) {
		if (!TestData.isEmpty()) {
			return HO_Info_Link.isDisplayed();
		} else {
			return true;
		}
	}

	public boolean VerifyIsDisplayed_HomePage_HomeLink(String TestData) {
		if (!TestData.isEmpty()) {
			return HO_Home_Link.isDisplayed();
		} else {
			return true;
		}
	}

	public boolean VerifyIsDisplayed_HomePage_ChangePINLink(String TestData) {
		return HO_ChangePin_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_ClockOutLink(String TestData) {
		return HO_ClockOut_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_ClockInLink(String TestData) {
		return HO_ClockIn_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_TimeSheetLink(String TestData) {
		return HO_TimeSheet_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_LogoutLink(String TestData) {
		return HO_Logout_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_BorrowerTab(String TestData) {
		return HO_ChangePin_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_LoanTransactionsTab(String TestData) {
		return HO_ClockOut_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_MiscTransactionsTab(String TestData) {
		return HO_ClockIn_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_CashManagemenetTab(String TestData) {
		return HO_TimeSheet_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_DailyProcessingTab(String TestData) {
		return HO_Logout_Link.isDisplayed();
	}

	public boolean VerifyIsDisplayed_HomePage_ReportsTab(String TestData) {
		return HO_Logout_Link.isDisplayed();
	}

	/*-----------------------------------------------------------------------------------------------
	 * Change PIN
	 * ---------------------------------------------------------------------------------------------
	 */

	public String get_HomePageHeader(String TestData) {
		return doIT(HO_PageHeader, TestData);
	}

	public String get_Home_HomeLink(String TestData) {
		return doIT(HO_Home_Link, TestData);
	}

	public void click_Home_HomeLink(String TestData) {

		doIT(HO_Home_Link, TestData);

	}

	public String get_ChangePIN_PageHeader(String TestData) {

		return doIT(CP_PageHeader, TestData);

	}

	public String get_ChangePIN_OldPin(String TestData) {

		return doIT(CP_OldPin, TestData);

	}

	public void set_ChangePIN_OldPin(String TestData) {

		doIT(CP_NewPin, TestData);

	}

	public String get_ChangePIN_NewPin(String TestData) {

		return doIT(CP_NewPin, TestData);

	}

	public void set_ChangePIN_NewPin(String TestData) {

		doIT(CP_NewPin, TestData);

	}

	public void set_ChangePIN_ConfirmPin(String TestData) {

		doIT(CP_ConfirmPin, TestData);

	}

	public String get_ChangePIN_ConfirmPin(String TestData) {

		return doIT(CP_ConfirmPin, TestData);

	}

	public void click_ChangePIN_SubmitButton(String TestData) {

		doIT(CP_SubmitButton, TestData);
	}

	public String get_ChangePIN_SuccessMessage(String TestData) {

		return doIT(CP_SuccessMessage, TestData);

	}

	public String verifyText() {
		return CP_SuccessMessage.getText();

	}

	public void waitForButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CO_confirmButton));

	}

	public void change_Password(String Old_pin, String New_pin, String Confirm_pin, String ChangePwd_Message)
			throws Exception {

		selectFrame(frameTop);
		click_ChangePin("y");
		selectFrame(frameMiddle);
		set_OldPin(Old_pin);
		set_NewPin(New_pin);
		set_ConfirmPin(Confirm_pin);
		click_Submit("y");
	}

	public String getVisibleObjectAfterLogin() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> LoginOptions = new ArrayList<WebElement>();
		LoginOptions.add(CO_confirmButton);
		LoginOptions.add(CI_ClockInButton);
		LoginOptions.add(topFrame);
		int foundIndex = visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;

		if (foundIndex == 1) {
			Found = "ClockOut";
		} else if (foundIndex == 2) {
			Found = "ClockIn";
		} else if (foundIndex == 3) {
			Found = "Home";
		} else {
			Found = "Error";
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return Found;
	}
}
