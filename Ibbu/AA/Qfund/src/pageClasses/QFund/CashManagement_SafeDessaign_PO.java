package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CashManagement_SafeDessaign_PO extends BasePage {

	public CashManagement_SafeDessaign_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}
	// locators for Safe Deassign in Cash Management Module

	@FindBy(id = "930000")
	private WebElement cashmanagement_Tab;

	@FindBy(xpath = "//a[contains(text(),'Safe')]")
	private WebElement cashmanagement_Safe;

	@FindBy(xpath = "//input[@value='Go']")
	private List<WebElement> AddosInstancOKbtnList;

	@FindBy(id = "932030")
	private WebElement cashmanagement_Safe_Deassign;

	@FindBy(name = "safeDeassignRequestBean.noOfPennies")
	private WebElement safe_Deassign_CountOfPennies;

	@FindBy(name = "safeDeassignRequestBean.noOfNickels")
	private WebElement safe_Deassign_CountOfNickels;

	@FindBy(name = "safeDeassignRequestBean.noOfDimes")
	private WebElement safe_Deassign_CountOfDimes;

	@FindBy(name = "safeDeassignRequestBean.noOfQuarters")
	private WebElement safe_Deassign_CountOfQuarters;

	@FindBy(name = "safeDeassignRequestBean.noOfHalfDollars")
	private WebElement safe_Deassign_CountOfHalfDollarsCoins;

	@FindBy(name = "safeDeassignRequestBean.noOfDollars")
	private WebElement safe_Deassign_CountOfDollarsCoins;

	@FindBy(name = "safeDeassignRequestBean.noOfOneDollars")
	private WebElement safe_Deassign_CountOfOneDollars;

	@FindBy(name = "safeDeassignRequestBean.noOf5Dollars")
	private WebElement safe_Deassign_CountOfFiveDollars;

	@FindBy(name = "safeDeassignRequestBean.noOf10Dollars")
	private WebElement safe_Deassign_CountOfTenDollars;

	@FindBy(name = "safeDeassignRequestBean.noOf20Dollars")
	private WebElement safe_Deassign_CountOfTwentyDollars;

	@FindBy(name = "safeDeassignRequestBean.noOf50Dollars")
	private WebElement safe_Deassign_CountOfFiftyDollars;

	@FindBy(name = "safeDeassignRequestBean.noOf100Dollars")
	public WebElement safe_Deassign_CountOfHundredDollars;

	@FindBy(name = "safeDeassignRequestBean.password")
	private WebElement safe_Deassign_BankerPin;

	@FindBy(name = "safedeassign")
	private WebElement safe_Deassign_Finish;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement safe_Deassign_Done;

	@FindBy(name = "safeRequestBean.safeOverShort")
	private WebElement safeOverShortAmount;

	@FindBy(name = "safeRequestBean.amount")
	private WebElement safeDifferenceAmount;

	@FindBy(name = "safeRequestBean.primary")
	private WebElement safeDifferenceAmountPrimaryReason;

	@FindBy(name = "safeRequestBean.product")
	private WebElement safeDifferenceAmountProduct;

	@FindBy(name = "safeRequestBean.loanNbr")
	private WebElement safeDifferenceAmountLoanNbr;

	@FindBy(name = "safeRequestBean.notes")
	private WebElement safeDifferenceAmountNotes;

	@FindBy(name = "bt_AddDrawer")
	private WebElement safeAddOSinstanceButton;

	@FindBy(name = "transactionDataBean.password")
	private WebElement safeDesignUserPassword;

	@FindBy(xpath = "//input[contains(@value,'Finish Safe O/S')]")
	private WebElement safeDesignFinishDesignButton;

	@FindBy(xpath="//ul[text()='Safe is not assigned for this Store']") 
	private WebElement safeNotAssignedError;
	
	@FindBy(xpath="//ul[text()='The Banker Password entered is not valid. Please re-enter']") 
	private WebElement safeBankerPINInvalidError;
	
	@FindBy(name = "requestBean.locationNbr")
	private WebElement admindd_StoreNo;

	@FindBy(name = "Submit2")
	private WebElement admindd_SubmitButton;

	
	public void set_admindd_StoreNo(String data) {
		doIT(admindd_StoreNo, data);
	}
	
	public void click_admindd_SubmitButton(String data) {
		doIT(admindd_SubmitButton, data);
	}
	
	public String get_Safe_Deassign_CountOfPennies(String data) {
		return doIT(safe_Deassign_CountOfPennies, data);
	}

	public void set_Safe_Deassign_CountOfPennies(String safe_Deassign_CountOfPennies) {
		doIT(this.safe_Deassign_CountOfPennies, safe_Deassign_CountOfPennies);
	}

	public String get_Safe_Deassign_CountOfNickels(String data) {
		return doIT(safe_Deassign_CountOfNickels, data);
	}

	public void set_Safe_Deassign_CountOfNickels(String safe_Deassign_CountOfNickels) {
		doIT(this.safe_Deassign_CountOfNickels, safe_Deassign_CountOfNickels);
	}

	public String get_Safe_Deassign_CountOfDimes(String data) {
		return doIT(safe_Deassign_CountOfDimes, data);
	}

	public void set_Safe_Deassign_CountOfDimes(String safe_Deassign_CountOfDimes) {
		doIT(this.safe_Deassign_CountOfDimes, safe_Deassign_CountOfDimes);
	}

	public String get_Safe_Deassign_CountOfQuarters(String data) {
		return doIT(safe_Deassign_CountOfQuarters, data);
	}

	public void set_Safe_Deassign_CountOfQuarters(String safe_Deassign_CountOfQuarters) {
		doIT(this.safe_Deassign_CountOfQuarters, safe_Deassign_CountOfQuarters);

	}

	public String get_Safe_Deassign_CountOfHalfDollarsCoins(String data) {
		return doIT(safe_Deassign_CountOfHalfDollarsCoins, data);
	}

	public void set_Safe_Deassign_CountOfHalfDollarsCoins(String safe_Deassign_CountOfHalfDollarsCoins) {
		doIT(this.safe_Deassign_CountOfHalfDollarsCoins, safe_Deassign_CountOfHalfDollarsCoins);
	}

	public String get_Safe_Deassign_CountOfDollarsCoins(String data) {
		return doIT(safe_Deassign_CountOfDollarsCoins, data);
	}

	public void set_Safe_Deassign_CountOfDollarsCoins(String safe_Deassign_CountOfDollarsCoins) {
		doIT(this.safe_Deassign_CountOfDollarsCoins, safe_Deassign_CountOfDollarsCoins);
	}

	public String get_Safe_Deassign_CountOfOneDollars(String data) {
		return doIT(safe_Deassign_CountOfOneDollars, data);
	}

	public void set_Safe_Deassign_CountOfOneDollars(String safe_Deassign_CountOfOneDollars) {
		doIT(this.safe_Deassign_CountOfOneDollars, safe_Deassign_CountOfOneDollars);
	}

	public String get_Safe_Deassign_CountOfFiveDollars(String data) {
		return doIT(safe_Deassign_CountOfFiveDollars, data);
	}

	public void set_Safe_Deassign_CountOfFiveDollars(String safe_Deassign_CountOfFiveDollars) {
		doIT(this.safe_Deassign_CountOfFiveDollars, safe_Deassign_CountOfFiveDollars);
	}

	public String get_Safe_Deassign_CountOfTenDollars(String data) {
		return doIT(safe_Deassign_CountOfTenDollars, data);
	}

	public void set_Safe_Deassign_CountOfTenDollars(String safe_Deassign_CountOfTenDollars) {
		doIT(this.safe_Deassign_CountOfTenDollars, safe_Deassign_CountOfTenDollars);
	}

	public String get_Safe_Deassign_CountOfTwentyDollars(String data) {
		return doIT(safe_Deassign_CountOfTwentyDollars, data);
	}

	public void set_Safe_Deassign_CountOfTwentyDollars(String safe_Deassign_CountOfTwentyDollars) {
		doIT(this.safe_Deassign_CountOfTwentyDollars, safe_Deassign_CountOfTwentyDollars);
	}

	public String get_Safe_Deassign_CountOfFiftyDollars(String data) {
		return doIT(safe_Deassign_CountOfFiftyDollars, data);
	}

	public void set_Safe_Deassign_CountOfFiftyDollars(String safe_Deassign_CountOfFiftyDollars) {
		doIT(this.safe_Deassign_CountOfFiftyDollars, safe_Deassign_CountOfFiftyDollars);
	}

	public String get_Safe_Deassign_CountOfHundredDollars(String data) {
		return doIT(safe_Deassign_CountOfHundredDollars, data);
	}

	public void set_Safe_Deassign_CountOfHundredDollars(String safe_Deassign_CountOfHundredDollars) {
		doIT(this.safe_Deassign_CountOfHundredDollars, safe_Deassign_CountOfHundredDollars);
	}

	public String get_Safe_Deassign_BankerPin(String data) {
		return doIT(safe_Deassign_BankerPin, data);
	}

	public void set_Safe_Deassign_BankerPin(String safe_Deassign_BankerPin) {
		doIT(this.safe_Deassign_BankerPin, safe_Deassign_BankerPin);
	}

	public void click_cashmanagement_Safe_Deassign(String data) {
		doIT(cashmanagement_Safe_Deassign, data);
	}
	public boolean isDisplayed_safe_Deassign_Finish() {
		return isDisplayed(safe_Deassign_Finish);
	}
	public void click_safe_Deassign_Finish(String data) {
		doIT(safe_Deassign_Finish, data);
	}

	public void click_safe_Deassign_Done(String data) {
		doIT(safe_Deassign_Done, data);
	}

	public boolean verify_safe_Deassign_Done() {
		return isDisplayedNoException(safe_Deassign_Done);
	}

	public void click_cashmanagement_Tab(String data) {
		doIT(cashmanagement_Tab, data);
	}

	public void click_cashmanagement_Safe(String data) {
		doIT(cashmanagement_Safe, data);
	}

	public String get_safeOverShortAmount(String data) {
		return doIT(safeOverShortAmount, data);
	}

	public void set_safeDifferenceAmount(String ssafeDifferenceAmount) {
		doIT(safeDifferenceAmount, ssafeDifferenceAmount);
	}

	public void set_safeDifferenceAmountPrimaryReason(String ssafeDifferenceAmountPrimaryReason) {
		doIT(safeDifferenceAmountPrimaryReason, ssafeDifferenceAmountPrimaryReason);
	}

	public void set_safeDifferenceAmountProduct(String ssafeDifferenceAmountProduct) {
		doIT(safeDifferenceAmountProduct, ssafeDifferenceAmountProduct);
	}

	public void set_safeDifferenceAmountLoanNbr(String ssafeDifferenceAmountLoanNbr) {
		doIT(safeDifferenceAmountLoanNbr, ssafeDifferenceAmountLoanNbr);
	}

	public void set_safeDifferenceAmountNotes(String ssafeDifferenceAmountNotes) {
		doIT(safeDifferenceAmountNotes, ssafeDifferenceAmountNotes);
	}

	public void click_safeAddOSinstanceButton(String data) {
		doIT(safeAddOSinstanceButton, data);
	}

	public void set_safeDesignUserPassword(String ssafeDesignUserPassword) {
		doIT(safeDesignUserPassword, ssafeDesignUserPassword);
	}

	public void click_safeDesignFinishDesignButton(String data) {
		doIT(safeDesignFinishDesignButton, data);
	}
	
	public String get_sd_BankerPINInvalid(String TestData_safeBankerPINInvalidError) {
		return doIT(safeBankerPINInvalidError, TestData_safeBankerPINInvalidError);
	}


	public void DeleteOSInsatances() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try{
			
			AddosInstancOKbtnList.get(0).isDisplayed();
			int count=AddosInstancOKbtnList.size();

			if(count!=0) {
				for(int i=0;i<count;i++) {
					WebElement AddosInstancMenu=driver.findElement(By.xpath("(//select[@name='menu'])[1]"));
					WebElement AddosInstancOKbtn=driver.findElement(By.xpath("(//input[@value='Go'])[1]"));
					new Select(AddosInstancMenu).selectByVisibleText("Delete");
					AddosInstancOKbtn.click();
					acceptAlert();
				}
				report.log(LogStatus.INFO, "Deleted OS Insatances");
				System.out.println(LogStatus.INFO+ "Deleted OS Insatances");	
			}

		}catch(Exception e) {}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	public void waitForButton() {
		wait.until(ExpectedConditions.elementToBeClickable(safe_Deassign_Finish));

	}

	public String getVisibleObjForDeAssign() throws Exception {

		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(safeNotAssignedError);
		LoginOptions.add(safe_Deassign_CountOfHundredDollars);
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;

		if(foundIndex==1) {Found="NotAssigned";}
		else if(foundIndex==2) {Found="Assigned";}
		else {Found="Error";}

		return Found;
	}
	
	public String getAlertText(String data) {
		if (!data.isEmpty()) {
			System.out.println(AlertDecesion("getText"));
			return AlertDecesion("getText").trim();

		} else {
			return null;
		}

}
}