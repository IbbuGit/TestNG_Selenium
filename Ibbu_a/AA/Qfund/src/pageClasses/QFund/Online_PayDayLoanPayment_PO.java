package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class Online_PayDayLoanPayment_PO extends BasePage {
	
	public Online_PayDayLoanPayment_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Make a Payment')]")				
	private WebElement MakeAPaymentButton;
	
	
	
	@FindBy(id="MakePaymentInStoreModel1_SelectedPaymentTypeItemID")				
	public WebElement MakeAPayment_PaymentMethod;
	
		
	@FindBy(id="MakePaymentInStoreModel1_SelectedPaymentOption")				
	public WebElement MakeAPayment_PaymentOption;
	
	@FindBy(id="MakePaymentInStoreModel1_SelectedOtherPmtAmt")				
	public WebElement MakeAPayment_PaymentAmount;
	
	@FindBy(xpath="//label[contains(text(),'Current balance')]//following-sibling::label")				
	public WebElement MakeAPayment_CurrentBalance;
	
	@FindBy(id="MakePaymentInStoreModel1_SelectedOtherPmtDate")				
	public WebElement MakeAPayment_PaymentDate;
	
	@FindBy(id="MakePaymentInStoreModel1_MakePaymentSubmit")				
	public WebElement MakeAPayment_PayNowBtn;
	
	
	public String get_MakeAPayment_CurrentBalance(String sMakeAPayment_CurrentBalance) {
		return doIT(MakeAPayment_CurrentBalance, sMakeAPayment_CurrentBalance).trim().replace("$", "");
	}
	
	
	public void click_MakeAPaymentButton(String sMakeAPaymentButton) throws Exception {
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(MakeAPaymentButton));
		//doIT(MakeAPaymentButton, sMakeAPaymentButton);
		Actions a = new Actions(driver);
		a.moveToElement(MakeAPaymentButton).click().build().perform();
	}
	
	public void click_MakeAPayment_PayNowBtn(String sMakeAPayment_PayNowBtn) {
		wait.until(ExpectedConditions.elementToBeClickable(MakeAPayment_PayNowBtn));
		doIT(MakeAPayment_PayNowBtn, sMakeAPayment_PayNowBtn);
	}
	
	public void set_MakeAPayment_PaymentAmount(String sMakeAPayment_PaymentAmount) {
		doIT(MakeAPayment_PaymentAmount, sMakeAPayment_PaymentAmount);
	}
	
	public void set_MakeAPayment_PaymentDate(String sMakeAPayment_PaymentDate) {
		MakeAPayment_PaymentDate.click();
		doIT(MakeAPayment_PaymentDate, sMakeAPayment_PaymentDate);
	}
	
	public void set_SelectMethod(String data, WebElement webElement) {
		webElement.click();
		wait.until(ExpectedConditions.visibilityOf(webElement));
		//Select s= new Select(webElement);
		//s.selectByValue(data);
		Actions a = new Actions(driver);
		a.moveToElement(webElement).click().build().perform();
	}
	
	public void SelectMethod(String data, WebElement element) {
		if (!data.isEmpty()) {
			set_MakeAPayment_PaymentMethod(data,element);
			selectMakeAPayment_PaymentMethod(data,element);
					
		}
	}
	
	public void set_MakeAPayment_PaymentMethod(String data,WebElement element) {
		//doIT(MakeAPayment_PaymentMethod,data);
		doIT(element,data);
	}
	
	public void selectMakeAPayment_PaymentMethod(String data,WebElement element) {
		//new Select(MakeAPayment_PaymentMethod).selectByVisibleText(data);
		new Select(element).selectByVisibleText(data);
	}
}
