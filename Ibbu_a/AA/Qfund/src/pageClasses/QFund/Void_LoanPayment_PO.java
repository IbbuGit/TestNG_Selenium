/**
 * 
 */
package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author VKumar
 *
 */
public class Void_LoanPayment_PO extends BasePage{

	/**
	 * @param _driver
	 * @param report
	 */
	public Void_LoanPayment_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="910000")
	private WebElement  loanTransactions_Tab;

	@FindBy(id="911101")
	private WebElement  Transactions;

	@FindBy(name="requestBean.siilBean.disbType")
	private WebElement  voidLnPymntDisbursment_type;

	@FindBy(name="requestBean.password")
	private WebElement  voidLnPymntDrawer_PIN_Input;

	@FindBy(name="finish")
	private WebElement  voidLnPymn_Button;

	@FindBy(className="leftHeading")
	private WebElement voidLnPymn_Confirm_Text;

	@FindBy(xpath="//input[@value='Yes']")
	private WebElement  Renew_Loanbtn;

	@FindBy(xpath="//input[(@value='Ok') and (@type='submit')]")
	private WebElement  CompOk_btn;

	public void click_CompOk_btn(String data){
		doIT(CompOk_btn,data);
	}

	public void click_VoidLnPymn_Button(String data){
		doIT(voidLnPymn_Button,data);
	}

	public void click_Renew_Loanbtn(String data){
		doIT(Renew_Loanbtn,data);
	}

	public String get_Disbursment_type(String data) {
		return doIT(voidLnPymntDisbursment_type, data);
	}

	public void set_Disbursment_type(String disbursment_type) {
		doIT(voidLnPymntDisbursment_type, disbursment_type);
	}

	public String get_Drawer_PIN_Input(String data) {
		return doIT(voidLnPymntDrawer_PIN_Input, data);
	}

	public void set_Drawer_PIN_Input(String drawer_PIN_Input) {
		doIT(voidLnPymntDrawer_PIN_Input, drawer_PIN_Input);
	}

	public String get_LnPymnt_Confirm_Text(String data) {
		return doIT(voidLnPymn_Confirm_Text, data);
	}
	

	public String getAlertTextmsg(String data) {
		if(!data.isEmpty()) {
			
			return  AlertDecesion("getText").trim();
			
		}else
		{
			return null;
		}
		
	}
	
}






