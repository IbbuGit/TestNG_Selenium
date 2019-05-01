package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_VINValidation_PO extends BasePage {
	
	public LoanTransactions_VINValidation_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}
	
	@FindBy(name = "requestBean.vin")
	private WebElement VINEnter;

	@FindBy(name = "requestBean.miles")
	private WebElement Miles;
	
	@FindBy(name = "requestBean.blackBookVal")
	private WebElement BlackBookValue;
	
	@FindBy(name = "requestBean.vehicleMake")
	private WebElement Vehicle_Make;

	@FindBy(name = "requestBean.vehicleModel")
	private WebElement Vehicle_Model;

	@FindBy(name = "requestBean.vehicleYear")
	private WebElement Vehicle_Year;
	
	@FindBy(name = "requestBean.bodyType")
	private WebElement Vehicle_BodyType;
	
	@FindBy(xpath = "//input[contains(@onclick,'getVinDetails')]")
	private WebElement VIN_GoSearchbtn;;
	
	public void set_VINEnter(String vINEnter) {
		wait.until(ExpectedConditions.visibilityOf(VINEnter));
		VINEnter.click();
		doIT(VINEnter, vINEnter);
	}

	public void set_Miles(String miles) {
		wait.until(ExpectedConditions.visibilityOf(Miles));
		doIT(Miles, miles);
	}

	public String get_BlackBookValue(String data){
		return doIT(BlackBookValue, data);
	}
	
	public String get_Vehicle_Make(String data){
		return doIT(Vehicle_Make, data);
	}

	public String get_Vehicle_Model(String data){
		return doIT(Vehicle_Model, data);
	}

	public String get_Vehicle_Year(String data){
		return doIT(Vehicle_Year, data);
	}

	public void click_VIN_GoSearchbtn(String data){
		doIT(VIN_GoSearchbtn,data);
	}

	public String get_Vehicle_BodyType(String data){
		return doIT(Vehicle_BodyType, data);
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
