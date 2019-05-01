package pageClasses.QFund;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CashManagement_Drawer_DeAssign_DeAssignDrawer_PO extends BasePage {
	// WebDriver driver;
	public CashManagement_Drawer_DeAssign_DeAssignDrawer_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Module Name : Cash Management
	// Method : deAssignDrawer
	// Class Name : CashManagement_Drawer_DeAssign_DeAssignDrawer_PO
	// Page Name(QFundX) : Drawer De-assignment
	// Responsible : Lee Huntsinger
	// Date : 14-Jun-2018
	// Prerequisite : 1) Safe MUST be assigned first
	// 2) Cash In process should be performed
	// 3) The cash in Safe should exceed amount in Drawer(s) in current store
	// 4) Drawer must be assigned
	// Expected results : Drawer should be de-assigned successfully and display
	// "Not
	// Assigned" in the Drawer field
	// ------------------------------------------------------------------------------------------------------------------

	// Emp Name
	@FindBy(name = "drawerAssignRequestBean.assignedEmpNbr")
	private WebElement dd_EmpName;

	// Count of Pennies
	@FindBy(name = "drawerDeassignRequestBean.noOfPennies")
	private WebElement dd_PennyCount;

	// Count of Nickels
	@FindBy(name = "drawerDeassignRequestBean.noOfNickels")
	private WebElement dd_NickelCount;

	// Count of Dimes
	@FindBy(name = "drawerDeassignRequestBean.noOfDimes")
	private WebElement dd_DimeCount;

	// Count of Quarters
	@FindBy(name = "drawerDeassignRequestBean.noOfQuarters")
	private WebElement dd_QuarterCount;

	// Count of Half Dollar Coins
	@FindBy(name = "drawerDeassignRequestBean.noOfHalfDollars")
	private WebElement dd_HalfDollarCount;

	// Count of Dollar Coins
	@FindBy(name = "drawerDeassignRequestBean.noOfDollars")
	private WebElement dd_DollarCoinCount;

	// Count of $1
	@FindBy(name = "drawerDeassignRequestBean.noOfOneDollars")
	private WebElement dd_DollarBillCount;

	// Count of $5
	@FindBy(name = "drawerDeassignRequestBean.noOf5Dollars")
	private WebElement dd_5DollarBillCount;

	// Count of $10
	@FindBy(name = "drawerDeassignRequestBean.noOf10Dollars")
	private WebElement dd_10DollarBillCount;

	// Count of $20
	@FindBy(name = "drawerDeassignRequestBean.noOf20Dollars")
	private WebElement dd_20DollarBillCount;

	// Count of $50
	@FindBy(name = "drawerDeassignRequestBean.noOf50Dollars")
	private WebElement dd_50DollarBillCount;

	// Count of $100
	@FindBy(name = "drawerDeassignRequestBean.noOf100Dollars")
	private WebElement dd_100DollarBillCount;

	// Current Cash Balance
	@FindBy(name = "drawerDeassignRequestBean.currentCashBalance")
	private WebElement dd_CurrentCashBalance;

	// BankerID
	@FindBy(name = "drawerDeassignRequestBean.userId")
	private WebElement dd_BankerName;

	// Finish De-assign Button
	@FindBy(name = "drawerdeassign")
	public WebElement dd_FinishDeAssignButton;

	// Drawer De-assigned successfully Button
	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement dd_SuccessfulDeAssignOKButton;

	@FindBy(name = "drawerDeassignRequestBean.empPwd")
	private WebElement admindd_Password;

	@FindBy(id = "500000")
	private WebElement AdminTransactionsTabButton;

	@FindBy(id = "502000")
	private WebElement AdminTransactions_BorrowerButton;

	@FindBy(id = "502070")
	private WebElement admindd_Button;

	@FindBy(name = "requestBean.locationNbr")
	private WebElement admindd_StoreNo;

	@FindBy(name = "Submit2")
	private WebElement admindd_SubmitButton;

	@FindBy(xpath = "//input[@value='Go']")
	private List<WebElement> admindd_GoButtons;
	
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement admindd_GoButton;
	
	@FindBy(xpath = "//ul[text()='Drawer Not Assigned']")
	private WebElement admindd_Drawer_Not_Assigned_MSG;	

	@FindBy(name = "drawerRequestBean.drawerOverShort")
	private WebElement admindd_OverShortAmount;

	@FindBy(name = "drawerRequestBean.amount")
	private WebElement admindd_DifferenceAmount;

	@FindBy(name = "drawerRequestBean.primary")
	private WebElement admindd_DifferenceAmountPrimaryReason;

	@FindBy(name = "drawerRequestBean.product")
	private WebElement admindd_DifferenceAmountProduct;

	@FindBy(name = "drawerRequestBean.loanNbr")
	private WebElement admindd_DifferenceAmountLoanNbr;

	@FindBy(name = "drawerRequestBean.notes")
	private WebElement admindd_DifferenceAmountNotes;

	@FindBy(name = "bt_AddDrawer")
	private WebElement admindd_AddOSinstanceButton;

	@FindBy(name = "transactionDataBean.password")
	private WebElement admindd_UserPassword;

	@FindBy(xpath = "//input[contains(@value,'Finish Drawer O/S')]")
	private WebElement admindd_FinishDesignButton;

	@FindBy(name = "drawerRequestBean.amount")
	private WebElement admindd_EnterShortAmount;

	@FindBy(name = "drawerRequestBean.primary")
	private WebElement admindd_PrimaryReason;

	@FindBy(name = "drawerRequestBean.notes")
	private WebElement admindd_ShortNotes;

	@FindBy(name = "bt_AddDrawer")
	private WebElement admindd_OverShortAddOSInstanceButton;

	@FindBy(name = "transactionDataBean.password")
	private WebElement admindd_OverShortUserPassword;

	@FindBy(name = "drawerDeassignRequestBean.empPwd")
	private WebElement dd_UserPassword;

	// Banker PIN#
	@FindBy(name = "drawerDeassignRequestBean.password")
	private WebElement dd_BankerPwd;

	@FindBy(xpath = "//ul[text()='This transaction is not available. This drawer is not currently assigned.']")
	private WebElement drawerNotAssignedError;
	
	@FindBy(xpath = "//ul[text()='A drawer does not exist for this workstation. Please contact the Help Desk']")
	private WebElement drawerNotAssignedWorkStationError;
	
	@FindBy(xpath = "//ul[text()='The password entered is not valid. Please re-enter']")
	private WebElement drawerDeassignInvalidUserPIN;
	
	@FindBy(xpath = "//input[@value='Go']")
	private List<WebElement> admindd_osInstancOKbtnList;

	public void set_dd_UserPassword(String data) {
		doIT(dd_UserPassword, data);
	}

	// Check for Banker ID Field on Drawer De-assignment Page
	public boolean checkVisibiltyOfDeAssignBtn() {
		return dd_FinishDeAssignButton.isDisplayed();
	}

	// Check for Drawer De-assign Successful message
	public boolean checkVisibiltyOfSuccessfulOKBtn() {
		return dd_SuccessfulDeAssignOKButton.isDisplayed();
	}

	// Set Number of Pennies from data sheet
	public String get_dd_PennyCount(String data) {
		return doIT(dd_PennyCount, data);
	}

	public void set_dd_PennyCount(String data) {
		doIT(dd_PennyCount, data);
	}

	// Set Number of Nickels from data sheet
	public String get_dd_NickelCount(String data) {
		return doIT(dd_NickelCount, data);
	}

	public void set_dd_NickelCount(String data) {
		doIT(dd_NickelCount, data);
	}

	// Set Number of Dimes from data sheet
	public String get_dd_DimeCount(String data) {
		return doIT(dd_DimeCount, data);
	}

	public void set_dd_DimeCount(String data) {
		doIT(dd_DimeCount, data);
	}

	// Set Number of Quarters from data sheet
	public String get_dd_QuarterCount(String data) {
		return doIT(dd_QuarterCount, data);
	}

	public void set_dd_QuarterCount(String data) {
		doIT(dd_QuarterCount, data);
	}

	// Set Number of Half Dollars from data sheet
	public String get_dd_HalfDollarCount(String data) {
		return doIT(dd_HalfDollarCount, data);
	}

	public void set_dd_HalfDollarCount(String data) {
		doIT(dd_HalfDollarCount, data);
	}

	// Set Number of Dollar Coins from data sheet
	public String get_dd_DollarCoinCount(String data) {
		return doIT(dd_DollarCoinCount, data);
	}

	public void set_dd_DollarCoinCount(String data) {
		doIT(dd_DollarCoinCount, data);
	}

	// Set Number of $1 Bills from data sheet
	public String get_dd_DollarBillCount(String data) {
		return doIT(dd_DollarBillCount, data);
	}

	public void set_dd_DollarBillCount(String data) {
		doIT(dd_DollarBillCount, data);
		dd_5DollarBillCount.click();
	}

	// Set Number of $5 Bills from data sheet
	public String get_dd_5DollarBillCount(String data) {
		return doIT(dd_5DollarBillCount, data);
	}

	public void set_dd_5DollarBillCount(String data) {
		doIT(dd_5DollarBillCount, data);
	}

	// Set Number of $10 Bills from data sheet
	public String get_dd_10DollarBillCount(String data) {
		return doIT(dd_10DollarBillCount, data);
	}

	public void set_dd_10DollarBillCount(String data) {
		doIT(dd_10DollarBillCount, data);
	}

	// Set Number of $20 Bills from data sheet
	public String get_dd_20DollarBillCount(String data) {
		return doIT(dd_20DollarBillCount, data);
	}

	public void set_dd_20DollarBillCount(String data) {
		doIT(dd_20DollarBillCount, data);
	}

	// Set Number of $50 Bills from data sheet
	public String get_dd_50DollarBillCount(String data) {
		return doIT(dd_50DollarBillCount, data);
	}

	public void set_dd_50DollarBillCount(String data) {
		doIT(dd_50DollarBillCount, data);
	}

	// Set Number of $100 Bills from data sheet
	public String get_dd_100DollarBillCount(String data) {
		return doIT(dd_100DollarBillCount, data);
	}

	public void set_dd_100DollarBillCount(String data) {
		doIT(dd_100DollarBillCount, data);
	}

	// Set Banker PIN#
	public String get_dd_BankerPwd(String data) {
		return doIT(dd_BankerPwd, data);
	}

	public void set_dd_BankerPwd(String data) {
		doIT(dd_BankerPwd, data);

	}
	
	public String get_drawerDeassignInvalidPINMsg(String TestData_drawerDeassignInvalidUserPIN) {
		return doIT(drawerDeassignInvalidUserPIN, TestData_drawerDeassignInvalidUserPIN);
	}


	public void waitForButton() {
		wait.until(ExpectedConditions.elementToBeClickable(dd_FinishDeAssignButton));

	}

	public void set_admindd_Password(String data) {
		// wait.until(ExpectedConditions.textToBePresentInElementValue(admindd_Password,
		// ""));
		// admindd_Password.clear();
		doIT(admindd_Password, data);
	}

	// Click Finish De-Assign Button
	
	public boolean isDisplayed_dd_FinishDeAssignButton() {
		return isDisplayed(dd_FinishDeAssignButton);
	}
	
	public void click_dd_FinishDeAssignButton(String data) {
		doIT(dd_FinishDeAssignButton, data);
	}

	// Click Drawer De-Assigned Successfully OK button
	public void click_dd_SuccessfulDeAssignOKButton(String data) {
		doIT(dd_SuccessfulDeAssignOKButton, data);
	}

	public void click_AdminTransactionsTabButton(String data) {
		doIT(AdminTransactionsTabButton, data);
	}

	public void click_AdminTransactions_BorrowerButton(String data) {
		doIT(AdminTransactions_BorrowerButton, data);
	}

	public void click_admindd_Button(String data) {
		doIT(admindd_Button, data);
	}
	public boolean isDisplayed_admindd_SubmitButton() {
		return isDisplayed(admindd_SubmitButton);
	}
	public void click_admindd_SubmitButton(String data) {
		doIT(admindd_SubmitButton, data);
	}

	public void click_DrawerRow_GoButton(String data) {
		if (!data.isEmpty()) {
			List<WebElement> GoButton = driver.findElements(By.xpath("//input[@value='Go']"));
			doIT(GoButton.get(0), data);
		}
	}
	
	public String getVisibleObjForAdminDrawerDeAssign() throws Exception {

		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(admindd_GoButton);
		LoginOptions.add(admindd_Drawer_Not_Assigned_MSG);
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;

		if(foundIndex==1) {Found="Assigned";}
		else if(foundIndex==2) {Found="NotAssigned";}
		else {Found="Error";}

		return Found;
	}

	public void set_admindd_StoreNo(String data) {
		doIT(admindd_StoreNo, data);
	}

	public String get_admindd_OverShortAmount(String data) {
		return doIT(admindd_OverShortAmount, data);
	}

	public void set_admindd_DifferenceAmount(String data) {
		doIT(admindd_DifferenceAmount, data);
	}

	public void set_admindd_DifferenceAmountPrimaryReason(String sadmindd_DifferenceAmountPrimaryReason) {
		doIT(admindd_DifferenceAmountPrimaryReason, sadmindd_DifferenceAmountPrimaryReason);
	}

	public void set_admindd_DifferenceAmountProduct(String sadmindd_DifferenceAmountProduct) {
		doIT(admindd_DifferenceAmountProduct, sadmindd_DifferenceAmountProduct);
	}

	public void set_admindd_DifferenceAmountLoanNbr(String sadmindd_DifferenceAmountLoanNbr) {
		doIT(admindd_DifferenceAmountLoanNbr, sadmindd_DifferenceAmountLoanNbr);
	}

	public void set_admindd_DifferenceAmountNotes(String sadmindd_DifferenceAmountNotes) {
		doIT(admindd_DifferenceAmountNotes, sadmindd_DifferenceAmountNotes);
	}

	public void click_admindd_AddOSinstanceButton(String data) {
		doIT(admindd_AddOSinstanceButton, data);
	}

	public void set_admindd_UserPassword(String sadmindd_UserPassword) {
		doIT(admindd_UserPassword, sadmindd_UserPassword);
	}

	public boolean isDisplayed_admindd_FinishDesignButton() {
		return isDisplayed(admindd_FinishDesignButton);
	}
	
	public void click_admindd_FinishDesignButton(String data) {
		doIT(admindd_FinishDesignButton, data);
	}

	public void set_admindd_OverShortAmount(String sadmindd_OverShortAmount) {
		doIT(admindd_OverShortAmount, sadmindd_OverShortAmount);
	}

	public void set_admindd_EnterShortAmount(String sadmindd_EnterShortAmount) {
		doIT(admindd_EnterShortAmount, sadmindd_EnterShortAmount);
	}

	public void set_admindd_PrimaryReason(String data) {
		doIT(admindd_PrimaryReason, data);
	}

	public void set_admindd_ShortNotes(String data) {
		doIT(admindd_ShortNotes, data);
	}

	public void click_admindd_OverShortAddOSInstanceButton(String data) {
		doIT(admindd_OverShortAddOSInstanceButton, data);
	}

	public void set_admindd_OverShortUserPassword(String data) {
		doIT(admindd_OverShortUserPassword, data);
	}
	


	public String getVisibleObjForDeAssign() throws Exception {
		
		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(drawerNotAssignedError);
		LoginOptions.add(dd_100DollarBillCount);
		LoginOptions.add(drawerNotAssignedWorkStationError);
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;
		
		if(foundIndex==1) {Found="NotAssigned";}
		else if(foundIndex==2) {Found="Assigned";}
		else if(foundIndex==3) {Found="EOD_Done";}

		return Found;
	}

	public void DeleteOSInsatances() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {

			admindd_osInstancOKbtnList.get(0).isDisplayed();
			int count = admindd_osInstancOKbtnList.size();

			if (count != 0) {
				for (int i = 0; i < count; i++) {
					WebElement AddosInstancMenu = driver.findElement(By.xpath("(//select[@name='menu'])[1]"));
					WebElement AddosInstancOKbtn = driver.findElement(By.xpath("(//input[@value='Go'])[1]"));
					new Select(AddosInstancMenu).selectByVisibleText("Delete");
					AddosInstancOKbtn.click();
					acceptAlert();
				}
				report.log(LogStatus.INFO, "Deleted OS Insatances");
				System.out.println(LogStatus.INFO + "Deleted OS Insatances");
			}

		} catch (Exception e) {
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Click De-Assign Message Dialog box
	public void click_dd_Message_Box(String data) {
		Alert confirmdeassigndrawer = driver.switchTo().alert();
		String strconfirmmsg = confirmdeassigndrawer.getText();
		System.out.println(strconfirmmsg);
		confirmdeassigndrawer.accept();
	}

	public int noOfDrawers() throws Exception {
		return admindd_GoButtons.size();
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
