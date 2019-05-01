package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_SafeAssign_PO extends BasePage {

	public CashManagement_SafeAssign_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	//locators for  Safe Deassign in Cash Management Module


	/*
	 * Page Elements
	 */


	@FindBy(xpath="//td[contains(text(),'Incorrect Processing Date')]") 
	private WebElement sa_IPD_PageHeader;
	
	@FindBy(name="previous")				
	public WebElement sa_IPD_NextButton;

	@FindBy(xpath="//td[contains(text(),'Incorrect Processing Date - Info')]") 
	private WebElement sa_IPDY_PageHeader;
	
	@FindBy(name="yes")				
	private WebElement sa_IPDY_YesButton;

	@FindBy(xpath="//td[contains(text(),'Safe Assign')]") 
	private WebElement sa_PageHeader;

	@FindBy(name="safeAssignRequestBean.noOfPennies")				
	private WebElement sa_CountOfPennies;
	
	@FindBy(name="safeAssignRequestBean.noOfNickels")				
	private WebElement sa_CountOfNickels;
	
	@FindBy(name="safeAssignRequestBean.noOfDimes")					
	private WebElement sa_CountOfDimes;
	
	@FindBy(name="safeAssignRequestBean.noOfQuarters")				
	private WebElement sa_CountOfQuarters;
	
	@FindBy(name="safeAssignRequestBean.noOfHalfDollars")			
	private WebElement sa_CountOfHalfDollarCoins;
	
	@FindBy(name="safeAssignRequestBean.noOfDollars")				
	private WebElement sa_CountOfDollarCoins;
	
	@FindBy(name="safeAssignRequestBean.noOfOneDollars")				
	private WebElement sa_CountOf1Dollar;
	
	@FindBy(name="safeAssignRequestBean.noOf5Dollars")				
	private WebElement sa_CountOf5Dollar;
	
	@FindBy(name="safeAssignRequestBean.noOf10Dollars")				
	private WebElement sa_CountOf10Dollar;
	
	@FindBy(name="safeAssignRequestBean.noOf20Dollars")				
	private WebElement sa_CountOf20Dollar;
	
	@FindBy(name="safeAssignRequestBean.noOf50Dollars")				
	private WebElement sa_CountOf50Dollar;
	
	@FindBy(name="safeAssignRequestBean.noOf100Dollars")				
	public WebElement sa_CountOf100Dollar;
	
	@FindBy(name="safeAssignRequestBean.openBal")					
	private WebElement sa_CashBalance;

	@FindBy(name="safeAssignRequestBean.checkBal")				
	private WebElement sa_CheckBalance;

	@FindBy(name="safeAssignRequestBean.CCMOBal")				
	private WebElement sa_CCMOBalance;
	
	@FindBy(name="safeAssignRequestBean.userId")						
	private WebElement sa_BankerID;
	
	@FindBy(name="safeAssignRequestBean.empPwd")					
	private WebElement sa_BankerPIN;
	
	@FindBy(name="safeassign")				
	private WebElement sa_FinishAssignButton;

	@FindBy(xpath="//td[contains(text(),'Safe assign completed successfully.')]") 
	private WebElement sa_Validation;
	
	@FindBy(xpath="//input[@value='Ok']") 
	private WebElement sa_Success_OKButton;
	
	@FindBy(xpath="//ul[text()='Safe is already Assigned']") 
	private WebElement sa_safeAlreadyAssignedError;
	
	@FindBy(xpath="//h3/font/ul") 
	private WebElement safeAssignedStoreNo;

	/*
	 * Page Elements Methods
	 */

	public String get_sa_IPD_PageHeader(String TestData_sa_IPD_PageHeader) {
		return doIT(sa_IPD_PageHeader, TestData_sa_IPD_PageHeader);
	}

	public boolean isDisplayed_sa_IPD_PageHeader() {
		return isDisplayed(sa_IPD_PageHeader);
	}

	//****************************************************************************************************************************
	public void click_sa_IPD_NextButton(String TestData_sa_IPD_NextButton) {
		doIT(sa_IPD_NextButton, TestData_sa_IPD_NextButton);
	}

	public boolean isDisplayed_sa_IPD_NextButton() {
		return isDisplayed(sa_IPD_NextButton);
	}

	//****************************************************************************************************************************
	public String get_sa_IPDY_PageHeader(String TestData_sa_IPDY_PageHeader) {
		return doIT(sa_IPDY_PageHeader, TestData_sa_IPDY_PageHeader);
	}

	public boolean isDisplayed_sa_IPDY_PageHeader() {
		return isDisplayed(sa_IPDY_PageHeader);
	}

	//****************************************************************************************************************************
	public void click_sa_IPDY_YesButton(String TestData_sa_IPDY_YesButton) {
		doIT(sa_IPDY_YesButton, TestData_sa_IPDY_YesButton);
	}

	public boolean isDisplayed_sa_IPDY_YesButton() {
		return isDisplayed(sa_IPDY_YesButton);
	}

	//****************************************************************************************************************************
	public String get_sa_PageHeader(String TestData_sa_PageHeader) {
		return doIT(sa_PageHeader, TestData_sa_PageHeader);
	}

	public boolean isDisplayed_sa_PageHeader() {
		return isDisplayed(sa_PageHeader);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfPennies(String TestData_sa_CountOfPennies) {
		doIT(sa_CountOfPennies, TestData_sa_CountOfPennies);
	}

	public boolean isDisplayed_sa_CountOfPennies() {
		return isDisplayed(sa_CountOfPennies);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfNickels(String TestData_sa_CountOfNickels) {
		doIT(sa_CountOfNickels, TestData_sa_CountOfNickels);
	}

	public boolean isDisplayed_sa_CountOfNickels() {
		return isDisplayed(sa_CountOfNickels);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfDimes(String TestData_sa_CountOfDimes) {
		doIT(sa_CountOfDimes, TestData_sa_CountOfDimes);
	}

	public boolean isDisplayed_sa_CountOfDimes() {
		return isDisplayed(sa_CountOfDimes);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfQuarters(String TestData_sa_CountOfQuarters) {
		doIT(sa_CountOfQuarters, TestData_sa_CountOfQuarters);
	}

	public boolean isDisplayed_sa_CountOfQuarters() {
		return isDisplayed(sa_CountOfQuarters);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfHalfDollarCoins(String TestData_sa_CountOfHalfDollarCoins) {
		doIT(sa_CountOfHalfDollarCoins, TestData_sa_CountOfHalfDollarCoins);
	}

	public boolean isDisplayed_sa_CountOfHalfDollarCoins() {
		return isDisplayed(sa_CountOfHalfDollarCoins);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOfDollarCoins(String TestData_sa_CountOfDollarCoins) {
		doIT(sa_CountOfDollarCoins, TestData_sa_CountOfDollarCoins);
	}

	public boolean isDisplayed_sa_CountOfDollarCoins() {
		return isDisplayed(sa_CountOfDollarCoins);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf1Dollar(String TestData_sa_CountOf1Dollar) {
		doIT(sa_CountOf1Dollar, TestData_sa_CountOf1Dollar);
	}

	public boolean isDisplayed_sa_CountOf1Dollar() {
		return isDisplayed(sa_CountOf1Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf5Dollar(String TestData_sa_CountOf5Dollar) {
		doIT(sa_CountOf5Dollar, TestData_sa_CountOf5Dollar);
	}

	public boolean isDisplayed_sa_CountOf5Dollar() {
		return isDisplayed(sa_CountOf5Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf10Dollar(String TestData_sa_CountOf10Dollar) {
		doIT(sa_CountOf10Dollar, TestData_sa_CountOf10Dollar);
	}

	public boolean isDisplayed_sa_CountOf10Dollar() {
		return isDisplayed(sa_CountOf10Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf20Dollar(String TestData_sa_CountOf20Dollar) {
		doIT(sa_CountOf20Dollar, TestData_sa_CountOf20Dollar);
	}

	public boolean isDisplayed_sa_CountOf20Dollar() {
		return isDisplayed(sa_CountOf20Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf50Dollar(String TestData_sa_CountOf50Dollar) {
		doIT(sa_CountOf50Dollar, TestData_sa_CountOf50Dollar);
	}

	public boolean isDisplayed_sa_CountOf50Dollar() {
		return isDisplayed(sa_CountOf50Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CountOf100Dollar(String TestData_sa_CountOf100Dollar) {
		doIT(sa_CountOf100Dollar, TestData_sa_CountOf100Dollar);
	}

	public boolean isDisplayed_sa_CountOf100Dollar() {
		return isDisplayed(sa_CountOf100Dollar);
	}

	//****************************************************************************************************************************
	public void set_sa_CashBalance(String TestData_sa_CashBalance) {
		doIT(sa_CashBalance, TestData_sa_CashBalance);
	}

	public boolean isDisplayed_sa_CashBalance() {
		return isDisplayed(sa_CashBalance);
	}

	//****************************************************************************************************************************
	public void set_sa_CheckBalance(String TestData_sa_CheckBalance) {
		doIT(sa_CheckBalance, TestData_sa_CheckBalance);
	}

	public boolean isDisplayed_sa_CheckBalance() {
		return isDisplayed(sa_CheckBalance);
	}

	//****************************************************************************************************************************
	public void set_sa_CCMOBalance(String TestData_sa_CCMOBalance) {
		doIT(sa_CCMOBalance, TestData_sa_CCMOBalance);
	}

	public boolean isDisplayed_sa_CCMOBalance() {
		return isDisplayed(sa_CCMOBalance);
	}

	//****************************************************************************************************************************
	public void set_sa_BankerID(String TestData_sa_BankerID) {
		doIT(sa_BankerID, TestData_sa_BankerID);
	}

	public boolean isDisplayed_sa_BankerID() {
		return isDisplayed(sa_BankerID);
	}

	//****************************************************************************************************************************
	public void set_sa_BankerPIN(String TestData_sa_BankerPIN) {
		doIT(sa_BankerPIN, TestData_sa_BankerPIN);
	}

	public boolean isDisplayed_sa_BankerPIN() {
		return isDisplayed(sa_BankerPIN);
	}

	//****************************************************************************************************************************
	public void click_sa_FinishAssignButton(String TestData_sa_FinishAssignButton) {
		doIT(sa_FinishAssignButton, TestData_sa_FinishAssignButton);
	}

	public boolean isDisplayed_sa_FinishAssignButton() {
		return isDisplayed(sa_FinishAssignButton);
	}

	//****************************************************************************************************************************
	public String get_sa_Validation(String TestData_sa_Validation) {
		return doIT(sa_Validation, TestData_sa_Validation);
	}

	public boolean isDisplayed_sa_Validation() {
		return isDisplayed(sa_Validation);
	}
	
	//****************************************************************************************************************************
	public String get_sa_safeAlreadyAssignedError(String TestData_sa_AssignedError) {
		return doIT(sa_safeAlreadyAssignedError, TestData_sa_AssignedError);
	}
	
	public String get_safeAssignedStoreNo(String ssafeAssignedStoreNo) {
		return doIT(safeAssignedStoreNo, ssafeAssignedStoreNo);
	}

	//****************************************************************************************************************************
	public void click_sa_Success_OKButton(String TestData_sa_Success_OKButton) {
		doIT(sa_Success_OKButton, TestData_sa_Success_OKButton);
	}

	public boolean isDisplayed_sa_Success_OKButton() {
		return isDisplayed(sa_Success_OKButton);
	}



	public String getVisibleObjForAssign() throws Exception {
		
		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(sa_safeAlreadyAssignedError);
		LoginOptions.add(sa_CountOfQuarters);
		LoginOptions.add(sa_IPD_NextButton);
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;
		
		if(foundIndex==1) {Found="Assigned";}
		else if(foundIndex==2) {Found="NotAssigned";}
		else if(foundIndex==3) {Found="EOD_Done";}
		else {Found="Error";}

		return Found;
	}
}
