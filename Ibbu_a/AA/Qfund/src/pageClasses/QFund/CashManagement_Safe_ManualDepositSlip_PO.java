		

/*---------------------------------------------------------------------------------------------------------------
 * Created By			:	Akula Srikanth
 * Date Created			: 	June 13th 2018
 * Modification Log 	:	<< Sameer >>	<< 13-June-2018>> 	<<Sprint 5>>
 * 							<< ABC >> 		<< 14-June-2018>> 	<<Sprint 6>>
 * 							<< asd >> 		<< 15-June-2018>> 	<<Sprint 7>>
 * --------------------------------------------------------------------------------------------------------------- 
 */

package pageClasses.QFund;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;


public class CashManagement_Safe_ManualDepositSlip_PO extends BasePage{

	public CashManagement_Safe_ManualDepositSlip_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);			
	}

	@FindBy(xpath="//td[contains(text(),'Manual Deposit Slip')]") 
	private WebElement mds_PageHeader;
	
	@FindBy(xpath="//input[@value='Print Deposit Slip']")						
	private WebElement mds_PrintDepositSlip;

	@FindBy(xpath="//td[contains(text(),'Printed Successfully.')]") 
	private WebElement mds_Validation;
	
	@FindBy(xpath="//input[@value='Ok']") 
	private WebElement mds_Success_OKButton;
	
	public String get_mds_PageHeader(String data) {
		return doIT(mds_PageHeader, data);
	}

	public boolean isDisplayed_mds_PageHeader() {
		return isDisplayed(mds_PageHeader);
	}
	
	public void click_mds_PrintDepositSlip(String data){
		doIT(mds_PrintDepositSlip,data);
		acceptAlert();
		acceptAlert();
	}
	
	public String get_mds_Validation(String TestData_mds_Validation) {
		return doIT(mds_Validation, TestData_mds_Validation).trim();
	}

	public boolean isDisplayed_vci_Validation() {
		return isDisplayed(mds_Validation);
	}
	
	public void click_mds_Success_OKButton(String data) {
		doIT(mds_Success_OKButton, data);
	}

	public boolean isDisplayed_vci_Success_OKButton() {
		return isDisplayed(mds_Success_OKButton);
	}

	public void waitForButton() {
		wait.until(ExpectedConditions.elementToBeClickable(mds_PrintDepositSlip));

	}
}

