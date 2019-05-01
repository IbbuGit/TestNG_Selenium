package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class MiscReceipts_PO extends BasePage {

	public MiscReceipts_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);		
	}
	
	@FindBy(xpath ="//td[@class='formHeadingLeft']")
	private WebElement MOR_Header;

	@FindBy(name ="moRequestBean.receiptType")
	private WebElement MOR_Receipt_Type;
	
	@FindBy(name ="moRequestBean.lastName")
	private WebElement MOR_LastName;
	
	@FindBy(name ="moRequestBean.firstName")
	private WebElement MOR_FirstName;
	
	@FindBy(name ="moRequestBean.middleName")
	private WebElement MOR_MiddleName;
	
	@FindBy(name ="moRequestBean.custIdType")
	private WebElement MOR_CustIdType;
	
	@FindBy(name ="moRequestBean.ssn1")
	private WebElement MOR_IDNbr_SSN1;
	
	@FindBy(name ="moRequestBean.ssn2")
	private WebElement MOR_IDNbr_SSN2;
	
	@FindBy(name ="moRequestBean.ssn3")
	private WebElement MOR_IDNbr_SSN3;
	
	@FindBy(name ="itin1")
	private WebElement MOR_IDNbr_ITIN1;
	
	@FindBy(name ="itin2")
	private WebElement MOR_IDNbr_ITIN2;
	
	@FindBy(name ="itin3")
	private WebElement MOR_IDNbr_ITIN3;
	
	@FindBy(name ="custIdAI")
	private WebElement MOR_ID_Alien;
	
	@FindBy(name ="custIdFI")
	private WebElement MOR_ID_Foreign;	
	
	@FindBy(name ="moRequestBean.phoneNumber1")
	private WebElement MOR_PrimaryPhone_Nbr1;
	
	@FindBy(name ="moRequestBean.phoneNumber2")
	private WebElement MOR_PrimaryPhone_Nbr2;
	
	@FindBy(name ="moRequestBean.phoneNumber3")
	private WebElement MOR_PrimaryPhone_Nbr3;
	
	@FindBy(name ="moRequestBean.ctrlNbr")
	private WebElement MOR_CtrlNbr;
	
	@FindBy(name ="moRequestBean.price")
	private WebElement MOR_Price;
	
	@FindBy(name ="moRequestBean.otherFee")
	private WebElement MOR_OtherFee;
	
	@FindBy(name ="moRequestBean.totalAmtDue")
	private WebElement MOR_TotalAmtDue;
	
	@FindBy(name ="moRequestBean.payAmt")
	private WebElement MOR_PayAmt;
	
	@FindBy(name ="moRequestBean.tendAmt")
	private WebElement MOR_TendAmt;
	
	@FindBy(name ="moRequestBean.monetaryCd")
	private WebElement MOR_Tender_Type;
	
	@FindBy(name ="moRequestBean.change")
	private WebElement MOR_Change;
	
	@FindBy(name ="username")
	private WebElement MOR_Username;
	
	@FindBy(name ="password")
	private WebElement MOR_Password;
	
	@FindBy(name ="history")
	private WebElement MOR_History_Button;
	
	@FindBy(name ="Button2")
	private WebElement MOR_Cancel_Button;
	
	@FindBy(name ="Submit1")
	private WebElement MOR_Submit_Button;
	
	@FindBy(xpath ="//td[contains(text(),'successfully')]/../following-sibling::tr/td/input")
	private WebElement MOR_Transaction_CompletedSuccessfully_OK_Btn;
	
	
	
	
	
	
	
	public String get_MOR_Header(String TestData_MOR_Header) {
		return doIT(MOR_Header, TestData_MOR_Header);
	}

	public void set_MOR_Receipt_Type(String TestData_MOR_Receipt_Type) {
		doIT(MOR_Receipt_Type, TestData_MOR_Receipt_Type);
	}

	public void set_MOR_LastName(String TestData_MOR_LastName) {
		doIT(MOR_LastName, TestData_MOR_LastName);
	}

	public void set_MOR_FirstName(String TestData_MOR_FirstName) {
		doIT(MOR_FirstName, TestData_MOR_FirstName);
	}

	public void set_MOR_MiddleName(String TestData_MOR_MiddleName) {
		doIT(MOR_MiddleName, TestData_MOR_MiddleName);
	}

	public void set_MOR_CustIdType(String TestData_MOR_CustIdType) {
		doIT(MOR_CustIdType, TestData_MOR_CustIdType);
	}

	public void set_MOR_IDNbr_SSN1(String TestData_MOR_IDNbr_SSN1) {
		doIT(MOR_IDNbr_SSN1, TestData_MOR_IDNbr_SSN1);
	}

	public void set_MOR_IDNbr_SSN2(String TestData_MOR_IDNbr_SSN2) {
		doIT(MOR_IDNbr_SSN2, TestData_MOR_IDNbr_SSN2);
	}

	public void set_MOR_IDNbr_SSN3(String TestData_MOR_IDNbr_SSN3) {
		doIT(MOR_IDNbr_SSN3, TestData_MOR_IDNbr_SSN3);
	}

	public void set_MOR_IDNbr_ITIN1(String TestData_MOR_IDNbr_ITIN1) {
		doIT(MOR_IDNbr_ITIN1, TestData_MOR_IDNbr_ITIN1);
	}

	public void set_MOR_IDNbr_ITIN2(String TestData_MOR_IDNbr_ITIN2) {
		doIT(MOR_IDNbr_ITIN2, TestData_MOR_IDNbr_ITIN2);
	}

	public void set_MOR_IDNbr_ITIN3(String TestData_MOR_IDNbr_ITIN3) {
		doIT(MOR_IDNbr_ITIN3, TestData_MOR_IDNbr_ITIN3);
	}

	public void set_MOR_ID_Alien(String TestData_MOR_ID_Alien) {
		doIT(MOR_ID_Alien, TestData_MOR_ID_Alien);
	}

	public void set_MOR_ID_Foreign(String TestData_MOR_ID_Foreign) {
		doIT(MOR_ID_Foreign, TestData_MOR_ID_Foreign);
	}

	public void set_MOR_PrimaryPhone_Nbr1(String TestData_MOR_PrimaryPhone_Nbr1) {
		doIT(MOR_PrimaryPhone_Nbr1, TestData_MOR_PrimaryPhone_Nbr1);
	}

	public void set_MOR_PrimaryPhone_Nbr2(String TestData_MOR_PrimaryPhone_Nbr2) {
		doIT(MOR_PrimaryPhone_Nbr2, TestData_MOR_PrimaryPhone_Nbr2);
	}

	public void set_MOR_PrimaryPhone_Nbr3(String TestData_MOR_PrimaryPhone_Nbr3) {
		doIT(MOR_PrimaryPhone_Nbr3, TestData_MOR_PrimaryPhone_Nbr3);
	}

	public void set_MOR_CtrlNbr(String TestData_MOR_CtrlNbr) {
		doIT(MOR_CtrlNbr, TestData_MOR_CtrlNbr);
	}

	public String set_MOR_Price(String TestData_MOR_Price) {
		if(TestData_MOR_Price.equalsIgnoreCase("Random")) {
			TestData_MOR_Price="1"+Helper.getRandomNumeric(2);
		}
		doIT(MOR_Price, TestData_MOR_Price);
		return TestData_MOR_Price;
	}

	public void set_MOR_OtherFee(String TestData_MOR_OtherFee) {
		doIT(MOR_OtherFee, TestData_MOR_OtherFee);
	}

	public void set_MOR_TotalAmtDue(String TestData_MOR_TotalAmtDue) {
		doIT(MOR_TotalAmtDue, TestData_MOR_TotalAmtDue);
	}

	public void set_MOR_PayAmt(String TestData_MOR_PayAmt) {
		doIT(MOR_PayAmt, TestData_MOR_PayAmt);
	}

	public void set_MOR_TendAmt(String TestData_MOR_TendAmt) {
		doIT(MOR_TendAmt, TestData_MOR_TendAmt);
	}

	public void set_MOR_Tender_Type(String TestData_MOR_Tender_Type) {
		doIT(MOR_Tender_Type, TestData_MOR_Tender_Type);
	}

	public void set_MOR_Change(String TestData_MOR_Change) {
		doIT(MOR_Change, TestData_MOR_Change);
	}

	public void set_MOR_Username(String TestData_MOR_Username) {
		doIT(MOR_Username, TestData_MOR_Username);
	}

	public void set_MOR_Password(String TestData_MOR_Password) {
		doIT(MOR_Password, TestData_MOR_Password);
	}

	public void click_MOR_History_Button(String TestData_MOR_History_Button) {
		doIT(MOR_History_Button, TestData_MOR_History_Button);
	}

	public void click_MOR_Cancel_Button(String TestData_MOR_Cancel_Button) {
		doIT(MOR_Cancel_Button, TestData_MOR_Cancel_Button);
	}

	public void click_MOR_Submit_Button(String TestData_MOR_Submit_Button) {
		doIT(MOR_Submit_Button, TestData_MOR_Submit_Button);
	}
	
	public boolean click_MOR_Transaction_CompletedSuccessfully_OK_Btn(String data) {
		boolean clicked=false;
		doIT(MOR_Transaction_CompletedSuccessfully_OK_Btn, data);
		clicked=true;
		return clicked;
	}
	
	public boolean verify_MOR_RecordInHistoryTable(String data) {
		boolean found=false;
		found=getWebElementForDynamicText("//input[@value='DYNAMIC_TEXT']", data)!=null;
		return found;
	}
	
	
}
