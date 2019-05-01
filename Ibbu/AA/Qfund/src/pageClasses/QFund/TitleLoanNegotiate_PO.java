/**
 * 
 */
package pageClasses.QFund;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author VKumar
 *
 */
public class TitleLoanNegotiate_PO extends BasePage {
	
	public TitleLoanNegotiate_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}
	
	@FindBy(name="negLoanAmt")
	private WebElement TitleLoan_Negotiate;
	
	
	
	@FindBy(name="requestBean.siilBean.advAmt")
	private WebElement TitleLoan_ReqLoanAmt;
	
	
	@FindBy(name="reCalculate")
	private WebElement TitleLoan_Recalculate;
	
	@FindBy(name="negSel")
	private WebElement TitleLoan_SelectNegoAmt;	
	
	
	
	public void click_TitleLoan_Negotiate(String data){
		doIT(TitleLoan_Negotiate,data);
	}
	
	
	public void click_TitleLoan_Recalculate(String data){
		doIT(TitleLoan_Recalculate,data);
	}
	
	public void click_TitleLoan_SelectNegoAmt(String data){
		doIT(TitleLoan_SelectNegoAmt,data);
	}
	
	
	
	
	
	/**
	 * @return the titleLoan_ReqLoanAmt
	 */
	public String get_TitleLoan_ReqLoanAmt(String data) {
		return doIT(TitleLoan_ReqLoanAmt, data);
	}


	/**
	 * @param titleLoan_ReqLoanAmt the titleLoan_ReqLoanAmt to set
	 */
	public void set_TitleLoan_ReqLoanAmt(String titleLoan_ReqLoanAmt) {
		doIT(TitleLoan_ReqLoanAmt,titleLoan_ReqLoanAmt);
		TitleLoan_ReqLoanAmt.sendKeys(Keys.CONTROL + "a");
		doIT(TitleLoan_ReqLoanAmt,titleLoan_ReqLoanAmt);	
	}


	/**
	 * @param titleLoan_ReqLoanAmt the titleLoan_ReqLoanAmt to set
	 */
	public void clearTitleLoan_ReqLoanAmt(String data){
		TitleLoan_ReqLoanAmt.clear();
	}
		

}
