package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class VehicleConditionReport_PO extends BasePage {
	/**
	 * @author Manish Kumar Pandey
	 *
	 */
	public VehicleConditionReport_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "ssn")
	private WebElement vCR_BorrowerSsnITIN;

	@FindBy(xpath = "//td[contains(text(),'SSN/ITIN')]/../following-sibling::tr/td[2]")
	private WebElement vCR_BorrowerStatus;

	@FindBy(xpath = "//td[contains(text(),'SSN/ITIN')]/../following-sibling::tr/td[3]")
	private WebElement vCR_BorrowerName;

	@FindBy(xpath = "//td[contains(text(),'SSN/ITIN')]/../following-sibling::tr/td[4]")
	private WebElement vCR_BorrowerAddress;

	// Title Loan Borrower Overview
	@FindBy(xpath = "//tr[td[contains(text(),'Title Status')]]/td[2]")
	private WebElement vCR_TitleStatus;

	@FindBy(xpath = "//tr[td[div[contains(text(),'Title Number')]]]/td[2]")
	private WebElement vCR_TitleNumber;

	@FindBy(xpath = "//tr[td[contains(text(),'Vehicle Registration State')]]/td[2]")
	private WebElement vCR_VehicleRegistrationState;

	@FindBy(xpath = "//tr[td[div[contains(text(),'Vehicle Mileage')]]]/td[2]")
	private WebElement vCR_VehicleMileage;

	@FindBy(xpath = "//tr[td[contains(text(),'BlackBook Value')]]/td[2]")
	private WebElement vCR_BlackBookValue;

	@FindBy(xpath = "//tr[td[div[contains(text(),'VIN')]]]/td[2]")
	private WebElement vCR_VIN;

	// Vehicle Information
	@FindBy(xpath = "//tr[td[contains(text(),'Make')]]/td[2]")
	private WebElement vCR_Make;

	@FindBy(xpath = "//tr[td[contains(text(),'Model')]]/td[2]")
	private WebElement vCR_Model;

	@FindBy(xpath = "//tr[td[contains(text(),'Year')]]/td[2]")
	private WebElement vCR_Year;

	@FindBy(xpath = "//tr[td[contains(text(),'Body Style')]]/td[2]")
	private WebElement vCR_BodyStyle;

	@FindBy(xpath = "//tr[td[contains(text(),'Passengers')]]/td[2]")
	private WebElement vCR_Passengers;

	@FindBy(xpath = "//tr[td[contains(text(),'Engine Cylinders')]]/td[2]")
	private WebElement vCR_EngineCylinders;

	@FindBy(xpath = "//tr[td[contains(text(),'Drivetrain')]]/td[2]")
	private WebElement vCR_Drivetrain;

	@FindBy(xpath = "//tr[td[contains(text(),'Transmission')]]/td[2]")
	private WebElement vCR_Transmission;

	@FindBy(xpath = "//tr[td[contains(text(),'Exterior Color')]]/td[2]")
	private WebElement vCR_ExteriorColor;

	@FindBy(xpath = "//tr[td[contains(text(),'Premium Wheels')]]/td[2]")
	private WebElement vCR_PremiumWheels;

	@FindBy(xpath = "//tr[td[contains(text(),'License Plate Number')]]/td[2]")
	private WebElement vCR_LicensePlateNumber;

	@FindBy(xpath = "//tr[td[contains(text(),'Series')]]/td[2]")
	private WebElement vCR_Series;

	// Vehicle Registration Information

	@FindBy(xpath = "//tr[td[contains(text(),'County of Registration')]]/td[2]")
	private WebElement vCR_CountyOfRegistration;

	// Vehicle Insurance Information
	@FindBy(xpath = "//tr[td[contains(text(),'Insurance Company')]]/td[2]")
	private WebElement vCR_InsuranceCompany;

	@FindBy(xpath = "//tr[td[contains(text(),'Policy Number')]]/td[2]")
	private WebElement vCR_PolicyNumber;

	@FindBy(xpath = "//tr[td[contains(text(),'Phone Nbr')]]/td[2]")
	private WebElement vCR_PhoneNbr;

	@FindBy(xpath = "//tr[td[contains(text(),'Insurance Expiration Date')]]/td[2]")
	private WebElement vCR_InsuranceExpirationDate;

	// Vehicle Evaluation

	@FindBy(xpath = "//tr[td[contains(text(),'Paint Condition')]]/td[2]")
	private WebElement vCR_PaintCondition;

	@FindBy(xpath = "//tr[td[contains(text(),'Body Condition')]]/td[2]")
	private WebElement vCR_BodyCondition;

	@FindBy(xpath = "//tr[td[contains(text(),'Glass Condition')]]/td[2]")
	private WebElement vCR_GlassCondition;

	@FindBy(xpath = "//tr[td[contains(text(),'Tires Condition')]]/td[2]")
	private WebElement vCR_TiresCondition;

	public String get_vCR_BorrowerSsnITIN(String data) {
		return vCR_BorrowerSsnITIN.getAttribute("value");
	}

	public void set_vCR_BorrowerSsnITIN(String vCR_BorrowerSsnITIN) {
		doIT(this.vCR_BorrowerSsnITIN, vCR_BorrowerSsnITIN);
	}

	public String get_vCR_BorrowerStatus(String data) {
		return doIT(vCR_BorrowerStatus, data);
	}

	public void set_vCR_BorrowerStatus(String vCR_BorrowerStatus) {
		doIT(this.vCR_BorrowerStatus, vCR_BorrowerStatus);
	}

	public String get_vCR_BorrowerName(String data) {
		return doIT(vCR_BorrowerName, data);
	}

	public boolean verifyVisibilityOFvCR_TitleStatus(){
		return wait.until(ExpectedConditions.visibilityOf(vCR_TitleStatus)).isDisplayed();
	}

	public void set_vCR_BorrowerName(String vCR_BorrowerName) {
		doIT(this.vCR_BorrowerName, vCR_BorrowerName);
	}

	public String get_vCR_BorrowerAddress(String data) {
		return doIT(vCR_BorrowerAddress, data);
	}

	public void set_vCR_BorrowerAddress(String vCR_BorrowerAddress) {
		doIT(this.vCR_BorrowerAddress, vCR_BorrowerAddress);
	}

	public String get_vCR_TitleStatus(String data) {
		return doIT(vCR_TitleStatus, data);
	}

	public void set_vCR_TitleStatus(String vCR_TitleStatus) {
		doIT(this.vCR_TitleStatus, vCR_TitleStatus);
	}

	public String get_vCR_TitleNumber(String data) {
		return doIT(vCR_TitleNumber, data);
	}

	public void set_vCR_TitleNumber(String vCR_TitleNumber) {
		doIT(this.vCR_TitleNumber, vCR_TitleNumber);
	}

	public String get_vCR_VehicleRegistrationState(String data) {
		return doIT(vCR_VehicleRegistrationState, data);
	}

	public void set_vCR_VehicleRegistrationState(String vCR_VehicleRegistrationState) {
		doIT(this.vCR_VehicleRegistrationState, vCR_VehicleRegistrationState);
	}

	public String get_vCR_VehicleMileage(String data) {
		return doIT(vCR_VehicleMileage, data);
	}

	public void set_vCR_VehicleMileage(String vCR_VehicleMileage) {
		doIT(this.vCR_VehicleMileage, vCR_VehicleMileage);
	}

	public String get_vCR_BlackBookValue(String data) {
		return doIT(vCR_BlackBookValue, data);
	}

	public void set_vCR_BlackBookValue(String vCR_BlackBookValue) {
		doIT(this.vCR_BlackBookValue, vCR_BlackBookValue);
	}

	public String get_vCR_VIN(String data) {
		return doIT(vCR_VIN, data);
	}

	public void set_vCR_VIN(String vCR_VIN) {
		doIT(this.vCR_VIN, vCR_VIN);
	}

	public String get_vCR_Make(String data) {
		return doIT(vCR_Make, data);
	}

	public void set_vCR_Make(String vCR_Make) {
		doIT(this.vCR_Make, vCR_Make);
	}

	public String get_vCR_Model(String data) {
		return doIT(vCR_Model, data);
	}

	public void set_vCR_Model(String vCR_Model) {
		doIT(this.vCR_Model, vCR_Model);
	}

	public String get_vCR_Year(String data) {
		return doIT(vCR_Year, data);
	}

	public void set_vCR_Year(String vCR_Year) {
		doIT(this.vCR_Year, vCR_Year);
	}

	public String get_vCR_BodyStyle(String data) {
		return doIT(vCR_BodyStyle, data);
	}

	public void set_vCR_BodyStyle(String vCR_BodyStyle) {
		doIT(this.vCR_BodyStyle, vCR_BodyStyle);
	}

	public String get_vCR_Passengers(String data) {
		return doIT(vCR_Passengers, data);
	}

	public void set_vCR_Passengers(String vCR_Passengers) {
		doIT(this.vCR_Passengers, vCR_Passengers);
	}

	public String get_vCR_EngineCylinders(String data) {
		return doIT(vCR_EngineCylinders, data);
	}

	public void set_vCR_EngineCylinders(String vCR_EngineCylinders) {
		doIT(this.vCR_EngineCylinders, vCR_EngineCylinders);
	}

	public String get_vCR_Drivetrain(String data) {
		return doIT(vCR_Drivetrain, data);
	}

	public void set_vCR_Drivetrain(String vCR_Drivetrain) {
		doIT(this.vCR_Drivetrain, vCR_Drivetrain);
	}

	public String get_vCR_Transmission(String data) {
		return doIT(vCR_Transmission, data);
	}

	public void set_vCR_Transmission(String vCR_Transmission) {
		doIT(this.vCR_Transmission, vCR_Transmission);
	}

	public String get_vCR_ExteriorColor(String data) {
		return doIT(vCR_ExteriorColor, data);
	}

	public void set_vCR_ExteriorColor(String vCR_ExteriorColor) {
		doIT(this.vCR_ExteriorColor, vCR_ExteriorColor);
	}

	public String get_vCR_PremiumWheels(String data) {
		return doIT(vCR_PremiumWheels, data);
	}

	public void set_vCR_PremiumWheels(String vCR_PremiumWheels) {
		doIT(this.vCR_PremiumWheels, vCR_PremiumWheels);
	}

	public String get_vCR_LicensePlateNumber(String data) {
		return doIT(vCR_LicensePlateNumber, data);
	}

	public void set_vCR_LicensePlateNumber(String vCR_LicensePlateNumber) {
		doIT(this.vCR_LicensePlateNumber, vCR_LicensePlateNumber);
	}

	public String get_vCR_Series(String data) {
		return doIT(vCR_Series, data);
	}

	public void set_vCR_Series(String vCR_Series) {
		doIT(this.vCR_Series, vCR_Series);
	}

	public String get_vCR_CountyOfRegistration(String data) {
		return doIT(vCR_CountyOfRegistration, data);
	}

	public void set_vCR_CountyOfRegistration(String vCR_CountyOfRegistration) {
		doIT(this.vCR_CountyOfRegistration, vCR_CountyOfRegistration);
	}

	public String get_vCR_InsuranceCompany(String data) {
		return doIT(vCR_InsuranceCompany, data);
	}

	public void set_vCR_InsuranceCompany(String vCR_InsuranceCompany) {
		doIT(this.vCR_InsuranceCompany, vCR_InsuranceCompany);
	}

	public String get_vCR_PolicyNumber(String data) {
		return doIT(vCR_PolicyNumber, data);
	}

	public void set_vCR_PolicyNumber(String vCR_PolicyNumber) {
		doIT(this.vCR_PolicyNumber, vCR_PolicyNumber);
	}

	public String get_vCR_PhoneNbr(String data) {
		return doIT(vCR_PhoneNbr, data);
	}

	public void set_vCR_PhoneNbr(String vCR_PhoneNbr) {
		doIT(this.vCR_PhoneNbr, vCR_PhoneNbr);
	}

	public String get_vCR_InsuranceExpirationDate(String data) {
		return doIT(vCR_InsuranceExpirationDate, data);
	}

	public void set_vCR_InsuranceExpirationDate(String vCR_InsuranceExpirationDate) {
		doIT(this.vCR_InsuranceExpirationDate, vCR_InsuranceExpirationDate);
	}

	public String get_vCR_PaintCondition(String data) {
		return doIT(vCR_PaintCondition, data);
	}

	public void set_vCR_PaintCondition(String vCR_PaintCondition) {
		doIT(this.vCR_PaintCondition, vCR_PaintCondition);
	}

	public String get_vCR_BodyCondition(String data) {
		return doIT(vCR_BodyCondition, data);
	}

	public void set_vCR_BodyCondition(String vCR_BodyCondition) {
		doIT(this.vCR_BodyCondition, vCR_BodyCondition);
	}

	public String get_vCR_GlassCondition(String data) {
		return doIT(vCR_GlassCondition, data);
	}

	public void set_vCR_GlassCondition(String vCR_GlassCondition) {
		doIT(this.vCR_GlassCondition, vCR_GlassCondition);
	}

	public String get_vCR_TiresCondition(String data) {
		return doIT(vCR_TiresCondition, data);
	}

	public void set_vCR_TiresCondition(String vCR_TiresCondition) {
		doIT(this.vCR_TiresCondition, vCR_TiresCondition);
	}

}
