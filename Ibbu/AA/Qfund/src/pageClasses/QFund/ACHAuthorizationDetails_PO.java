package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class ACHAuthorizationDetails_PO extends BasePage {

	public ACHAuthorizationDetails_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);

	}

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement ach_BackButton;

	@FindBy(xpath = "//input[@value='ACH Revoke']")
	private WebElement ach_RevokeButton;

	@FindBy(id = "aba")
	private WebElement aba_RoutingNum;

	@FindBy(id = "caba")
	private WebElement confirmABA_RoutingNum;

	@FindBy(id = "chkac")
	private WebElement checkAcctNum;

	@FindBy(id = "cchkac")
	private WebElement confirmCheckAcctNum;

	@FindBy(xpath = "//input[@value='N']")
	private WebElement ach_AllLoanNoRadioButton;

	@FindBy(xpath = "//input[@value='Y']")
	private WebElement ach_AllLoanYesRadioButton;

	@FindBy(id = "pwd")
	private WebElement pin_TextBox;

	@FindBy(xpath = "//input[@value='ACH Authorization']")
	private WebElement ach_AuthorizationButton;

	@FindBy(name = "checkyes")
	private WebElement yes_button;
	
	@FindBy(xpath = "//*[contains(text(),'ACH')]")
	private WebElement ACH_ThankMsg;

	@FindBy(xpath = "//td[contains(text(),'ACH Authorization Details')]")
	private WebElement ACH_AuthorizationPage;
	
	@FindBy(xpath = "//input[@value='OK']")
	private WebElement Ok_Button;
	
	@FindBy(xpath = "//td[contains(text(),'Customer ACH Revoke Details')]")
	private WebElement ACH_AuthorizationPage_loc;
	
	@FindBy(xpath = "//input[@value='RCC Revoke']")
	private WebElement rcc_RevokeButton;

	@FindBy(xpath = "//input[@value='RCC Authorization']")
	private WebElement rcc_AuthorizationButton;

	

	public void click_rcc_RevokeButton(String data) {
		doIT(rcc_RevokeButton, data);
	}
	

	public void click_rcc_AuthorizationButton(String data) {
		doIT(rcc_AuthorizationButton, data);
	}
	
	public void click_ACH_AuthorizationPage_loc(String data) {
		doIT(ACH_AuthorizationPage_loc, data);
	}
	

	public void click_Ok_Button(String data) {
		doIT(Ok_Button, data);
	}
	

	public boolean verifyACH_AuthorizationPage() {
		acceptAlert();		
		return isDisplayed(ACH_AuthorizationPage);
	}
	
	public boolean verifyACH_Authorization() {
		acceptAlert();		
		return isDisplayed( ACH_AuthorizationPage_loc);
	}

	public void click_ACHBackButton(String data) {
		doIT(ach_BackButton, data);
	}

	public void click_ACHRevokeButton(String data) {
		if (!data.isEmpty()) {
			doIT(ach_RevokeButton, data);
		}
	}

	public void set_ABA_RoutingNum(String data) {
		doIT(aba_RoutingNum, data);
	}

	public void set_ConfirmABA_RoutingNum(String data) {
		doIT(confirmABA_RoutingNum, data);
	}

	public void set_CheckAcctNum(String data) {
		doIT(checkAcctNum, data);
	}

	public void set_ConfirmCheckAcctNum(String data) {
		doIT(confirmCheckAcctNum, data);
	}

	public void click_ACHRadioButton(String data) {
		if (data.equals("Y")) {
			doIT(ach_AllLoanYesRadioButton, data);
		} else {
			doIT(ach_AllLoanNoRadioButton, data);
		}

	}

	public String get_ACH_ThankMsg(String data) {
		return doIT(ACH_ThankMsg, data);
	}

	public void set_pinTextBox(String data) {
		doIT(pin_TextBox, data);
	}

	public void click_ACHAuthorizationButton(String data) {
		doIT(ach_AuthorizationButton, data);
	}

	public void click_Yes_button(String data) {		
		doIT(yes_button, data);
		if(isWindowDisplayed(2)){
		switchToChildWindow();
		closeWindow();
		switchToParentWindow();
		}
	}

}
