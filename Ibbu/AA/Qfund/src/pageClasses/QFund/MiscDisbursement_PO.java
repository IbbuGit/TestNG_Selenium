package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class MiscDisbursement_PO extends BasePage {
	public MiscDisbursement_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);		
	}
	
	@FindBy(xpath ="//td[contains(text(),'Expense Code')]")
	private WebElement MD_Header_Expense;

	
	@FindBy(xpath ="//td[@class='formHeadingLeft']")
	private WebElement MD_Header;

	@FindBy(name ="miscBean.miscCd")
	private WebElement MD_Disbursement_Type;
	
	@FindBy(name ="miscBean.tranAmt")
	private WebElement MD_Amt;
	
	@FindBy(name ="miscBean.description")
	private WebElement MD_Comments;
	
	@FindBy(name ="username")
	private WebElement MD_Username;
	
	@FindBy(name ="miscBean.empPwd")
	private WebElement MD_PIN;	
	
	@FindBy(name ="miscBean.userId")
	private WebElement MD_BankerUsername;
	
	@FindBy(name ="miscBean.password")
	private WebElement MD_Banker_PIN;	
	
	@FindBy(name ="Submit3")
	private WebElement MD_History_Button;
	
	@FindBy(name ="disbursements")
	private WebElement MD_FinishMiscDisbursements_Button;
	
	@FindBy(name ="reset")
	private WebElement MD_Cancel_Button;
	
	@FindBy(name ="ok")
	private WebElement MD_Transaction_CompletedSuccessfully_OK_Btn;
	
	public String get_MD_Header(String TestData_MD_Header) {
		return doIT(MD_Header, TestData_MD_Header);
	}

	public void set_MD_Disbursement_Type(String TestData_MD_Disbursement_Type) throws InterruptedException {
		doIT(MD_Disbursement_Type, TestData_MD_Disbursement_Type);
		Thread.sleep(2000);
	}

	public void set_MD_Amt(String TestData_MD_Amt) {
		if(TestData_MD_Amt.equalsIgnoreCase("Random")) {
			TestData_MD_Amt=Helper.getRandomNumeric(2);
		}		
		doIT(MD_Amt, TestData_MD_Amt);
	}

	public String set_MD_Comments(String TestData_MD_Comments) {
		
		if(TestData_MD_Comments.equalsIgnoreCase("Random")) {
			TestData_MD_Comments=Helper.getRandomAlphabetic(8);
		}		
		doIT(MD_Comments, TestData_MD_Comments);
		return TestData_MD_Comments;
	}
	
	public void get_MD_BankerUsername(String sMD_BankerUsername) {
		doIT(MD_BankerUsername, sMD_BankerUsername);
	}
	
	public void set_MD_Banker_PIN(String sMD_Banker_PIN) {
		doIT(MD_Banker_PIN, sMD_Banker_PIN);
	}
	
	public void set_MD_Username(String TestData_MD_Username) {
		doIT(MD_Username, TestData_MD_Username);
	}

	public void set_MD_PIN(String TestData_MD_PIN) {
		doIT(MD_PIN, TestData_MD_PIN);
	}

	public void click_MD_History_Button(String TestData_MD_History_Button) {
		doIT(MD_History_Button, TestData_MD_History_Button);
	}

	public void click_MD_FinishMiscDisbursements_Button(String TestData_MD_FinishMiscDisbursements_Button) {
		doIT(MD_FinishMiscDisbursements_Button, TestData_MD_FinishMiscDisbursements_Button);
	}

	public void click_MD_Cancel_Button(String TestData_MD_Cancel_Button) {
		doIT(MD_Cancel_Button, TestData_MD_Cancel_Button);
	}
	
	public boolean Confirm_MD_Header( ) {
		boolean Found = false;
	
		try {
			
		Found = MD_Header_Expense.isDisplayed();
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		return Found; 
	}
	
	public boolean click_MD_Transaction_CompletedSuccessfully_OK_Btn(String data) {
		boolean clicked=false;
		doIT(MD_Transaction_CompletedSuccessfully_OK_Btn, data);
		clicked=true;
		return clicked;
	}
	
	public boolean verify_MD_RecordInHistoryTable(String data) {
		boolean found=false;
		found=getWebElementForDynamicText("(//td[contains(text(),'DYNAMIC_TEXT')])[1]", data)!=null; 
		return found;
	}
}
