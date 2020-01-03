package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_InternalTransfer_PO extends BasePage {


		/*
		 * Constructor
		 */
	
		public CashManagement_Safe_InternalTransfer_PO(WebDriver _driver, ExtentTest report) {
			super(_driver, report);			
		}

		/*
		 * Page Elements
		 */

		@FindBy(xpath="//*[contains(text(),'Internal Transfer')]") 
		private WebElement sit_PageHeader;
		
		@FindBy(name="D1")		
		private WebElement sit_Action;
	
		@FindBy(xpath="//input[contains(@name,'cashAmount')]")
		private WebElement sit_CashAmt;
			
		@FindBy(xpath="//input[contains(@name,'noOfPennies')]")
		private WebElement sit_CountOfPennies;
		
		@FindBy(xpath="//input[contains(@name,'noOfNickels')]")	
		private WebElement sit_CountOfNickels;

		@FindBy(xpath="//input[contains(@name,'noOfDimes')]")
		private WebElement sit_CountOfDimes;
		
		@FindBy(xpath="//input[contains(@name,'noOfQuarters')]")
		private WebElement sit_CountOfQuarters;

		@FindBy(xpath="//input[contains(@name,'noOfHalfDollars')]")		
		private WebElement sit_CountOfHalfDollarCoins;
		
		@FindBy(xpath="//input[contains(@name,'noOfDollars')]")
		private WebElement sit_CountOfDollarCoins;
		
		@FindBy(xpath="//input[contains(@name,'noOfOneDollars')]")
		private WebElement sit_CountOf1Dollar;
		
		@FindBy(xpath="//input[contains(@name,'noOf5Dollars')]")
		private WebElement sit_CountOf5Dollar;
		
		@FindBy(xpath="//input[contains(@name,'noOf10Dollars')]")
		private WebElement sit_CountOf10Dollar;
		
		@FindBy(xpath="//input[contains(@name,'noOf20Dollars')]")
		private WebElement sit_CountOf20Dollar;
		
		@FindBy(xpath="//input[contains(@name,'noOf50Dollars')]")
		private WebElement sit_CountOf50Dollar;
		
		@FindBy(xpath="//input[contains(@name,'noOf100Dollars')]")
		private WebElement sit_CountOf100Dollar;
		
		@FindBy(name="username")											
		private WebElement sit_UserID;
		
		@FindBy(name="safeToDrawerRequestBean.empPwd")						
		private WebElement sit_UserPIN;
		
		@FindBy(name=".*userId")						
		private WebElement sit_BankerID;
		
		@FindBy(xpath="//input[contains(@name,'safeToDrawerRequestBean.password')]")
		private WebElement sit_BankerPIN;
		
		@FindBy(name="internaltransfer")				
		private WebElement sit_FinishInternalTransferButton;
		
		@FindBy(xpath="//*[contains(text(),'Safe to Drawer transfer completed successfully.')]") 
		private WebElement sit_Validation;

		@FindBy(xpath="//input[@value='Ok']") 
		private WebElement sit_Success_OKButton;
		
		@FindBy(xpath="//*[contains(text(),'Safe is not assigned for this Store')]") 
		private WebElement sit_SafeNotAssigned;
		
		@FindBy(xpath="//*[contains(text(),'This transaction is not available. This drawer is not currently assigned.')]") 
		private WebElement sit_DrawerNotAssigned;




		/*
		 * Page Elements Methods
		 */

		public String get_sit_PageHeader(String TestData_sit_PageHeader) {
			return doIT(sit_PageHeader, TestData_sit_PageHeader);
		}

		public boolean isDisplayed_sit_PageHeader() {
			return isDisplayed(sit_PageHeader);
		}

		public void set_sit_Action(String TestData_sit_Action) {
			doIT(sit_Action, TestData_sit_Action);
		}

		public boolean isDisplayed_sit_Action() {
			return isDisplayed(sit_Action);
		}

		public void set_sit_CashAmt(String TestData_sit_CashAmt) {
			doIT(sit_CashAmt, TestData_sit_CashAmt);
		}

		public boolean isDisplayed_sit_CashAmt() {
			return isDisplayed(sit_CashAmt);
		}

		public void set_sit_CountOfPennies(String TestData_sit_CountOfPennies) {
			doIT(sit_CountOfPennies, TestData_sit_CountOfPennies);
		}

		public boolean isDisplayed_sit_CountOfPennies() {
			return isDisplayed(sit_CountOfPennies);
		}

		public void set_sit_CountOfNickels(String TestData_sit_CountOfNickels) {
			doIT(sit_CountOfNickels, TestData_sit_CountOfNickels);
		}

		public boolean isDisplayed_sit_CountOfNickels() {
			return isDisplayed(sit_CountOfNickels);
		}

		public void set_sit_CountOfDimes(String TestData_sit_CountOfDimes) {
			doIT(sit_CountOfDimes, TestData_sit_CountOfDimes);
		}

		public boolean isDisplayed_sit_CountOfDimes() {
			return isDisplayed(sit_CountOfDimes);
		}

		public void set_sit_CountOfQuarters(String TestData_sit_CountOfQuarters) {
			doIT(sit_CountOfQuarters, TestData_sit_CountOfQuarters);
		}

		public boolean isDisplayed_sit_CountOfQuarters() {
			return isDisplayed(sit_CountOfQuarters);
		}

		public void set_sit_CountOfHalfDollarCoins(String TestData_sit_CountOfHalfDollarCoins) {
			doIT(sit_CountOfHalfDollarCoins, TestData_sit_CountOfHalfDollarCoins);
		}

		public boolean isDisplayed_sit_CountOfHalfDollarCoins() {
			return isDisplayed(sit_CountOfHalfDollarCoins);
		}

		public void set_sit_CountOfDollarCoins(String TestData_sit_CountOfDollarCoins) {
			doIT(sit_CountOfDollarCoins, TestData_sit_CountOfDollarCoins);
		}

		public boolean isDisplayed_sit_CountOfDollarCoins() {
			return isDisplayed(sit_CountOfDollarCoins);
		}

		public void set_sit_CountOf1Dollar(String TestData_sit_CountOf1Dollar) {
			doIT(sit_CountOf1Dollar, TestData_sit_CountOf1Dollar);
		}

		public boolean isDisplayed_sit_CountOf1Dollar() {
			return isDisplayed(sit_CountOf1Dollar);
		}

		public void set_sit_CountOf5Dollar(String TestData_sit_CountOf5Dollar) {
			doIT(sit_CountOf5Dollar, TestData_sit_CountOf5Dollar);
		}

		public boolean isDisplayed_sit_CountOf5Dollar() {
			return isDisplayed(sit_CountOf5Dollar);
		}

		public void set_sit_CountOf10Dollar(String TestData_sit_CountOf10Dollar) {
			doIT(sit_CountOf10Dollar, TestData_sit_CountOf10Dollar);
		}

		public boolean isDisplayed_sit_CountOf10Dollar() {
			return isDisplayed(sit_CountOf10Dollar);
		}

		public void set_sit_CountOf20Dollar(String TestData_sit_CountOf20Dollar) {
			doIT(sit_CountOf20Dollar, TestData_sit_CountOf20Dollar);
		}

		public boolean isDisplayed_sit_CountOf20Dollar() {
			return isDisplayed(sit_CountOf20Dollar);
		}

		public void set_sit_CountOf50Dollar(String TestData_sit_CountOf50Dollar) {
			doIT(sit_CountOf50Dollar, TestData_sit_CountOf50Dollar);
		}

		public boolean isDisplayed_sit_CountOf50Dollar() {
			return isDisplayed(sit_CountOf50Dollar);
		}

		public void set_sit_CountOf100Dollar(String TestData_sit_CountOf100Dollar) {
			doIT(sit_CountOf100Dollar, TestData_sit_CountOf100Dollar);
		}

		public boolean isDisplayed_sit_CountOf100Dollar() {
			return isDisplayed(sit_CountOf100Dollar);
		}

		public void set_sit_UserID(String TestData_sit_UserID) {
			doIT(sit_UserID, TestData_sit_UserID);
		}

		public boolean isDisplayed_sit_UserID() {
			return isDisplayed(sit_UserID);
		}

		public void set_sit_UserPIN(String TestData_sit_UserPIN) {
			doIT(sit_UserPIN, TestData_sit_UserPIN);
		}

		public boolean isDisplayed_sit_UserPIN() {
			return isDisplayed(sit_UserPIN);
		}

		public void set_sit_BankerID(String TestData_sit_BankerID) {
			doIT(sit_BankerID, TestData_sit_BankerID);
		}

		public boolean isDisplayed_sit_BankerID() {
			return isDisplayed(sit_BankerID);
		}

		public void set_sit_BankerPIN(String TestData_sit_BankerPIN) {
			doIT(sit_BankerPIN, TestData_sit_BankerPIN);
		}

		public boolean isDisplayed_sit_BankerPIN() {
			return isDisplayed(sit_BankerPIN);
		}

		public void click_sit_FinishInternalTransferButton(String TestData_sit_FinishInternalTransferButton) {
			doIT(sit_FinishInternalTransferButton, TestData_sit_FinishInternalTransferButton);
		}

		public boolean isDisplayed_sit_FinishInternalTransferButton() {
			return isDisplayed(sit_FinishInternalTransferButton);
		}

		public String get_sit_Validation(String TestData_sit_Validation) {
			return doIT(sit_Validation, TestData_sit_Validation);
		}

		public boolean isDisplayed_sit_Validation() {
			return isDisplayed(sit_Validation);
		}

		public void click_sit_Success_OKButton(String TestData_sit_Success_OKButton) {
			doIT(sit_Success_OKButton, TestData_sit_Success_OKButton);
		}

		public boolean isDisplayed_sit_Success_OKButton() {
			return isDisplayed(sit_Success_OKButton);
		}
		
		public String get_sit_SafeNotAssigned(String TestData_sit_SafeNotAssigned) {
			return doIT(sit_SafeNotAssigned, TestData_sit_SafeNotAssigned);
		}

		public String get_sit_DrawerNotAssigned(String TestData_sit_DrawerNotAssigned) {
			return doIT(sit_DrawerNotAssigned, TestData_sit_DrawerNotAssigned);
		}

		
		
}