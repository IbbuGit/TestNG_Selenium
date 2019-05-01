package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;


 
	
public class CashManagement_Drawer_Assign_AssignDrawer_PO extends BasePage{


	/*
	 * Constructor
	 */

public CashManagement_Drawer_Assign_AssignDrawer_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
		// TODO Auto-generated constructor stub
	}

	//	Drawer Nbr
	@FindBy(name="drawerAssignRequestBean.drawerNbr")		
	private WebElement da_Drawer_Nbr;

	//	Employee Name
	@FindBy(name="drawerAssignRequestBean.assignedEmpNbr")	
	private WebElement da_EmployeeName;	

	//Count of Pennies
	@FindBy(name="drawerAssignRequestBean.noOfPennies")		
	private WebElement da_PennyCount;
	
	//Count of Nickels 
	@FindBy(name="drawerAssignRequestBean.noOfNickels")		
	private WebElement da_NickelCount;
	
	//Count of Dimes
	@FindBy(name="drawerAssignRequestBean.noOfDimes")		
	private WebElement da_DimeCount;
	
	//Count of Quarters
	@FindBy(name="drawerAssignRequestBean.noOfQuarters")	
	private WebElement da_QuarterCount;
	
	//Count of Half Dollar Coins
	@FindBy(name="drawerAssignRequestBean.noOfHalfDollars")	
	private WebElement da_HalfDollarCount;
	
	//Count of Dollar Coins
	@FindBy(name="drawerAssignRequestBean.noOfDollars")		
	private WebElement da_DollarCoinCount;
	
	//Count of $1
	@FindBy(name="drawerAssignRequestBean.noOfOneDollars")	
	private WebElement da_DollarBillCount;
	
	//Count of $5
	@FindBy(name="drawerAssignRequestBean.noOf5Dollars")	
	private WebElement da_5DollarBillCount;
	
	//Count of $10
	@FindBy(name="drawerAssignRequestBean.noOf10Dollars")	
	private WebElement da_10DollarBillCount;
	
	//Count of $20
	@FindBy(name="drawerAssignRequestBean.noOf20Dollars")	
	private WebElement da_20DollarBillCount;
	
	//Count of $50
	@FindBy(name="drawerAssignRequestBean.noOf50Dollars")	
	private WebElement da_50DollarBillCount;
	
	//Count of $100
	@FindBy(name="drawerAssignRequestBean.noOf100Dollars")	
	private WebElement da_100DollarBillCount;
	
	//Opening Balance
	@FindBy(name="drawerAssignRequestBean.openBal")			
	private WebElement da_OpeningBalance;
	
	//Banker Id
	@FindBy(name="drawerAssignRequestBean.userId")			
	private WebElement da_BankerID;
	
	//Banker PIN#
	@FindBy(name="drawerAssignRequestBean.password")		
	private WebElement da_BankerPassword;
	
	@FindBy(name="drawerAssignRequestBean.empPwd")		
	private WebElement da_UserPassword;
	
	//Finish Assign Button
	@FindBy(name="drawerassign")							
	private WebElement da_FinishAssignButton;
	
	//Drawer Assigned successfully message OK button
	@FindBy(name="done")									
	private WebElement da_SuccessfulAssignOKButton;
	
	@FindBy(xpath="//ul[text()='This drawer is already assigned. You must de-assign the drawer before it can be re-assigned to a different employee']") 
	private WebElement drawerAlreadyAssignedError;
	
	@FindBy(xpath="//ul[text()='Employees Not Available']") 
	private WebElement drawerEmployeeNotAvailable;
	
	@FindBy(name="previous")				
	private WebElement da_IPD_NextButton;
	
	@FindBy(name="yes")				
	private WebElement da_IPDY_YesButton;

	//Sets User ID Password if present
	public void set_da_UserPassword(String sda_UserPassword) {
		doIT(da_UserPassword, sda_UserPassword);
	}
	
	// Check for Banker ID Field on Drawer Assignment Page
    public Object checkVisibiltyOfBankerID(String data){
    	if (!data.isEmpty()) {
    		return da_BankerID.isDisplayed();
    			
    	}
    	else return ""; 
    		
    }
    
    public void set_EmployeeName(String data){
    	doIT(da_EmployeeName,data);
    }
    
	// Check for OK Button Successful Drawer Assign Page
    public Object checkVisibiltyOfSuccessfulOKBtn(String data){
    	if (!data.isEmpty()) {
    		return da_SuccessfulAssignOKButton.isDisplayed();
    	}
    	else return "";
    }	
	
	// Set Number of Pennies from data sheet
	public String get_da_PennyCount(String data) {
		return doIT(da_PennyCount, data);
	}
		
	public void set_da_PennyCount(String data) {
		doIT(da_PennyCount, data);
	}
	
	// Set Number of Nickels from data sheet
	public String get_da_NickelCount(String data) {
		return doIT(da_NickelCount, data);
	}
		
	public void set_da_NickelCount(String data) {
		doIT(da_NickelCount, data);
	}
	
	// Set Number of Dimes from data sheet
	public String get_da_DimeCount(String data) {
		return doIT(da_DimeCount, data);
	}
		
	public void set_da_DimeCount(String data) {
		doIT(da_DimeCount, data);
	}
	
	//Set Number of Quarters from data sheet
	public String get_da_QuarterCount(String data) {
		return doIT(da_QuarterCount, data);
	}
		
	public void set_da_QuarterCount(String data) {
		doIT(da_QuarterCount, data);
	}
	
	// Set Number of Half Dollars from data sheet
	public String get_da_HalfDollarCount(String data) {
		return doIT(da_HalfDollarCount, data);
	}
		
	public void set_da_HalfDollarCount(String data) {
		doIT(da_HalfDollarCount, data);
	}
	
	// Set Number of Dollar Coins from data sheet
	public String get_da_DollarCoinCount(String data) {
		return doIT(da_DollarCoinCount, data);
	}
		
	public void set_da_DollarCoinCount(String data) {
		doIT(da_DollarCoinCount, data);
	}
	
	// Set Number of $1 Bills from data sheet
	public String get_da_DollarBillCount(String data) {
		return doIT(da_DollarBillCount, data);
	}
		
	public void set_da_DollarBillCount(String data) {
		doIT(da_DollarBillCount, data);
	}
	
	// Set Number of $5 Bills from data sheet
	public String get_da_5DollarBillCount(String data) {
		return doIT(da_5DollarBillCount, data);
	}
		
	public void set_da_5DollarBillCount(String data) {
		doIT(da_5DollarBillCount, data);
	}
	
	// Set Number of $10 Bills from data sheet
	public String get_da_10DollarBillCount(String data) {
		return doIT(da_10DollarBillCount, data);
	}
		
	public void set_da_10DollarBillCount(String data) {
		doIT(da_10DollarBillCount, data);
	}
	
	// Set Number of $20 Bills from data sheet
	public String get_da_20DollarBillCount(String data) {
		return doIT(da_20DollarBillCount, data);
	}
		
	public void set_da_20DollarBillCount(String data) {
		doIT(da_20DollarBillCount, data);
	}
	
	// Set Number of $50 Bills from data sheet
	public String get_da_50DollarBillCount(String data) {
		return doIT(da_50DollarBillCount, data);
	}
		
	public void set_da_50DollarBillCount(String data) {
		doIT(da_50DollarBillCount, data);
	}
	
	// Set Number of $100 Bills from data sheet
	public String get_da_100DollarBillCount(String data) {
		return doIT(da_100DollarBillCount, data);
	}
	
	public void set_da_100DollarBillCount(String data) {
		doIT(da_100DollarBillCount, data);
	}
	
	// Set Banker Password
	public String get_da_BankerPassword(String data) {
		return doIT(da_BankerPassword, data);
	}
	
	public void set_da_BankerPassword(String data) {
		doIT(da_BankerPassword, data);
	}
	
	// Click Finish Assign Button
	public void click_da_FinishAssignButton(String data) {
		doIT(da_FinishAssignButton,data);
	}
	
	//Click Drawer Assigned Successfully OK button
	public void click_da_SuccessfulAssignOKButton(String data) {
		doIT(da_SuccessfulAssignOKButton,data);
	}
	
	public void click_da_IPD_NextButton() {
		doIT(da_IPD_NextButton, "Y");
	}
	
	public void click_da_IPDY_YesButton() {
		doIT(da_IPDY_YesButton, "Y");
	}
	
	public String get_drawerAlreadyAssignedError(String TestData_drawerAlreadyAssignedError) {
		return doIT(drawerAlreadyAssignedError, TestData_drawerAlreadyAssignedError);
	}

	
	public String getVisibleObjForAssign() throws Exception {
		
		List<WebElement> LoginOptions=new ArrayList<WebElement>();
		LoginOptions.add(drawerAlreadyAssignedError);
		LoginOptions.add(da_100DollarBillCount);
		LoginOptions.add(da_IPD_NextButton);
		LoginOptions.add(drawerEmployeeNotAvailable);
		
		int foundIndex=visibleWebElementFromListofWebElement(LoginOptions);
		String Found = null;
		
		if(foundIndex==1) {Found="Assigned";}
		else if(foundIndex==2) {Found="NotAssigned";}
		else if(foundIndex==3) {Found="EOD_Done";}
		else if(foundIndex==4) {Found="EmloyeeNotAvailable";}

		return Found;
	}

}
