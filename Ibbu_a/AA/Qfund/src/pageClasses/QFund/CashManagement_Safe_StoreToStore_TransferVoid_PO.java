package pageClasses.QFund;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class CashManagement_Safe_StoreToStore_TransferVoid_PO extends BasePage{

	public CashManagement_Safe_StoreToStore_TransferVoid_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	//------------------------------------------------------------------------------------------------------------------
	//	Module Name			:	Cash Management
	//	Method				:	safeStoreToStoreVoid
	//	Class Name			:	CashManagement_Safe_StoreToStore_VoidTransfer_PO
	//	Page Name(QFundX)	:	Store to Store Transfer
	//	Responsible			:	Lee Huntsinger
	//	Date				:	01-Aug-2018	
	//	Prerequisite		:	1) Safe MUST be assigned first
	//							2) Cash In process should be performed
	//							3) A Store Number MUST be known for transfer
	//							4) A Store Transfer MUST have been performed and in PENDING status
	//							
	//	Expected results	:	Store to Store Void Transfer should be successful
	//------------------------------------------------------------------------------------------------------------------



	// Store to Store Transfer Header
	@FindBy(xpath="formHeading")	
	private WebElement CM_Safe_StoretoStoreTransfer_Header;
	
	// Action to perform (Sending, Receiving and Pending)
	@FindBy(name="locToLocRequestBean.actionCode")
	private WebElement CM_Safe_StoretoStore_Action;
	
	// Store Nbr Field
	@FindBy(name="locToLocRequestBean.locationNbr")	
	private WebElement CM_Safe_StoreToStore_Nbr;	

	// Count of Pennies 
	@FindBy(name="locToLocRequestBean.noOfPennies")			
	private WebElement CM_StoreToStore_PennyCount;
	
	// Count of Nickels 
	@FindBy(name="locToLocRequestBean.noOfNickels")			
	private WebElement CM_StoreToStore_NickelCount;
	
	// Count of Dimes 
	@FindBy(name="locToLocRequestBean.noOfDimes")			
	private WebElement CM_StoreToStore_DimeCount;
	
	// Count of Quarters
	@FindBy(name="locToLocRequestBean.noOfQuarters")			
	private WebElement CM_StoreToStore_QuarterCount;

	// Count of Half Dollars
	@FindBy(name="locToLocRequestBean.noOfHalfDollars")		
	private WebElement CM_StoreToStore_HalfDollarCount;
	
	// Count of Dollar Coins
	@FindBy(name="locToLocRequestBean.noOfDollars")			
	private WebElement CM_StoreToStore_DollarCoinCount;
	
	// Count of $1 Bills
	@FindBy(name="locToLocRequestBean.noOfOneDollars")		
	private WebElement CM_StoreToStore_DollarBillCount;
	
	// Count of $5 Bills
	@FindBy(name="locToLocRequestBean.noOf5Dollars")			
	private WebElement CM_StoreToStore_5DollarBillCount;
	
	// Count of $10 Bills
	@FindBy(name="locToLocRequestBean.noOf10Dollars")		
	private WebElement CM_StoreToStore_10DollarBillCount;
	
	// Count of $20 Bills
	@FindBy(name="locToLocRequestBean.noOf20Dollars")		
	private WebElement CM_StoreToStore_20DollarBillCount;
	
	// Count of $50 Bills
	@FindBy(name="locToLocRequestBean.noOf50Dollars")		
	private WebElement CM_StoreToStore_50DollarBillCount;
	
	// Count of $100 Bills
	@FindBy(name="locToLocRequestBean.noOf100Dollars")		
	private WebElement CM_StoreToStore_100DollarBillCount;
	
	// Cash Field
	@FindBy(name="locToLocRequestBean.cashAmt")
	private WebElement CM_StoreToStore_Cash;
	
	// Banker ID
	@FindBy(name="locToLocRequestBean.userId")		
	private WebElement CM_StoreToStore_BankerID;

	// Banker PIN#
	@FindBy(name="locToLocRequestBean.password")		
	private WebElement CM_StoreToStore_BankerPIN;

	// Finish Void Store to Store Transfer Button
	@FindBy(name="voidloctoloc")							
	private WebElement CM_FinishVoidStoreToStoreTransfer_Btn;
	
	// Transaction voided successfully OK button
	@FindBy(xpath="//input[@value='Ok']")				
	private WebElement CM_VoidTransfer_SuccessfulOKBtn;

	// Store to Store Transfer History button
	@FindBy(xpath="//input[@value='History' and @class='sortbuttons']")				
	private WebElement CM_StoreToStoreTransfer_HistoryBtn;
	
	@FindBy(xpath="//input[@value='More' and @class='sortbuttons']")				
	private WebElement CM_StoreToStoreTransfer_MoreBtn;
	
	@FindBy(name="requestBean.searchBean.pageNum")							
	private WebElement CM_VoidPagesMenu;
	
	@FindBy(xpath="//input[@value='Go' and @class='sortbuttons']")				
	private WebElement CM_VoidPagesGo_Btn;
	
	// Check for Store Nbr Field on Store to Store Transfer Page
    public boolean checkVisibiltyOfStoreNbr(){
    	return isDisplayed(CM_Safe_StoreToStore_Nbr);
    }
    
	// Check for History Button on Store to Store Transfer Page
    public boolean checkVisibiltyOfHistoryBtn() throws InterruptedException{
      	Thread.sleep(3000);
    	return isDisplayed(CM_StoreToStoreTransfer_HistoryBtn);
    }
    
    // Check for Finish Void Store to Store Transfer Button on Void Store to Store Transfer Page
    public boolean checkVisibiltyOfFinishVoidTransferBtn(){
    	return isDisplayed(CM_FinishVoidStoreToStoreTransfer_Btn);    
    }
    
    // Check for Void Transaction Page
    public boolean checkVisibiltyOfVoidTransactionOKBtn(){
    	return isDisplayed(CM_VoidTransfer_SuccessfulOKBtn);    
    }
    
    // Get Transfer Transaction for Void
    private String transCode="//td[text()='DYNAMIC_TEXT']/preceding-sibling::td";
    public String get_transferVoidTransaction(String storeID){
    	return doIT(getWebElementForDynamicText(transCode,storeID),"y").trim();
	}
    
    private WebElement get_VoidTransactionRadioBtn(String storeID) {
    	WebElement TransactionRadioBtn=null;
    	String test="//input[contains(@value,'DYNAMIC_TEXT')]";
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	try {TransactionRadioBtn=getWebElementForDynamicText(test,storeID);}catch(Exception e) { }  
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	return TransactionRadioBtn;
    }


     
    public void click_VoidTransactionRadioBtn(String storeID,String data) {
    	wait.until(ExpectedConditions.elementToBeClickable(CM_FinishVoidStoreToStoreTransfer_Btn));
    	WebElement TransactionRadioBtn=null;
     	if ((TransactionRadioBtn=get_VoidTransactionRadioBtn(storeID))!=null) {
    		doIT(TransactionRadioBtn,data);
		} else {
			if(isDisplayedNoException(CM_StoreToStoreTransfer_MoreBtn)) {
				CM_StoreToStoreTransfer_MoreBtn.click();
			}			
			if ((TransactionRadioBtn=get_VoidTransactionRadioBtn(storeID))!=null) {
	    		doIT(TransactionRadioBtn,data);
			}else {
				Select PagesMenu=new Select(CM_VoidPagesMenu);
				int pageSize=new Select(CM_VoidPagesMenu).getOptions().size();
				for(int i=2;i<pageSize;i++) {
					PagesMenu.selectByValue(String.valueOf(i));
					CM_VoidPagesGo_Btn.click();
					if ((TransactionRadioBtn=get_VoidTransactionRadioBtn(storeID))!=null) {
						doIT(TransactionRadioBtn,data);
						break;
					}
				}
			}			
		}    	
    }

        
	public void set_CM_Safe_StoretoStoreTransfer_Header(String cM_Safe_StoretoStoreTransfer_Header) {
		doIT(CM_Safe_StoretoStoreTransfer_Header, cM_Safe_StoretoStoreTransfer_Header);
	}
	
	public void set_CM_Safe_StoreToStore_Nbr(String cM_Safe_StoreToStore_Nbr) {
		doIT(CM_Safe_StoreToStore_Nbr, cM_Safe_StoreToStore_Nbr);
	}


	public void set_CM_StoreToStore_PennyCount(String cM_StoreToStore_PennyCount) {
		doIT(CM_StoreToStore_PennyCount, cM_StoreToStore_PennyCount);
	}

	public void set_CM_StoreToStore_NickelCount(String cM_StoreToStore_NickelCount) {
		doIT(CM_StoreToStore_NickelCount, cM_StoreToStore_NickelCount);
	}

	public void set_CM_StoreToStore_DimeCount(String cM_StoreToStore_DimeCount) {
		doIT(CM_StoreToStore_DimeCount, cM_StoreToStore_DimeCount);
	}

	public void set_CM_StoreToStore_QuarterCount(String cM_StoreToStore_QuarterCount) {
		doIT(CM_StoreToStore_QuarterCount, cM_StoreToStore_QuarterCount);
	}

	public void set_CM_StoreToStore_HalfDollarCount(String cM_StoreToStore_HalfDollarCount) {
		doIT(CM_StoreToStore_HalfDollarCount, cM_StoreToStore_HalfDollarCount);
	}

	public void set_CM_StoreToStore_DollarCoinCount(String cM_StoreToStore_DollarCoinCount) {
		doIT(CM_StoreToStore_DollarCoinCount, cM_StoreToStore_DollarCoinCount);
	}

	public void set_CM_StoreToStore_DollarBillCount(String cM_StoreToStore_DollarBillCount) {
		doIT(CM_StoreToStore_DollarBillCount, cM_StoreToStore_DollarBillCount);
	}

	public void set_CM_StoreToStore_5DollarBillCount(String cM_StoreToStore_5DollarBillCount) {
		doIT(CM_StoreToStore_5DollarBillCount, cM_StoreToStore_5DollarBillCount);
	}

	public void set_CM_StoreToStore_10DollarBillCount(String cM_StoreToStore_10DollarBillCount) {
		doIT(CM_StoreToStore_10DollarBillCount, cM_StoreToStore_10DollarBillCount);
	}

	public void set_CM_StoreToStore_20DollarBillCount(String cM_StoreToStore_20DollarBillCount) {
		doIT(CM_StoreToStore_20DollarBillCount, cM_StoreToStore_20DollarBillCount);
	}

	public void set_CM_StoreToStore_50DollarBillCount(String cM_StoreToStore_50DollarBillCount) {
		doIT(CM_StoreToStore_50DollarBillCount, cM_StoreToStore_50DollarBillCount);
	}

	public void set_CM_StoreToStore_100DollarBillCount(String cM_StoreToStore_100DollarBillCount) {
		doIT(CM_StoreToStore_100DollarBillCount, cM_StoreToStore_100DollarBillCount);
	}


	public void set_CM_StoreToStore_BankerID(String cM_StoreToStore_BankerID) {
		doIT(CM_StoreToStore_BankerID, cM_StoreToStore_BankerID);
	}

	public void set_CM_StoreToStore_BankerPIN(String cM_StoreToStore_BankerPIN) {
		doIT(CM_StoreToStore_BankerPIN, cM_StoreToStore_BankerPIN);
	}
	
	
	// Select Store to Store Transfer Action
	public void set_CM_Safe_StoretoStore_Action(String cM_Safe_StoretoStore_Action) {
		doIT(CM_Safe_StoretoStore_Action, cM_Safe_StoretoStore_Action);
	}

	// Click Finish Void Store to Store Transfer Button
	public void click_FinishVoidStoreToStoreTransferBtn(String data) {
		doIT(CM_FinishVoidStoreToStoreTransfer_Btn,data);
	}
	
	// Click Store to Store Transfer Completed Successfully OK Button
	public void click_VoidTransfer_SuccessfulOKBtn(String data) {
		doIT(CM_VoidTransfer_SuccessfulOKBtn,data);
	}

	// Click Store to Store Transfer History Button
	public void click_StoreToStoreTransfer_HistoryBtn(String data) {
		doIT(CM_StoreToStoreTransfer_HistoryBtn,data);
	}
	
	public void click_CM_StoreToStoreTransfer_MoreBtn(String data) {
		doIT(CM_StoreToStoreTransfer_MoreBtn,data);
	}
	
	
}