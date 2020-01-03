package pageClasses.QFund;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

/**
 * @author VKumar
 *
 */
public class BorrowerRegistrationPersonal_PO extends BasePage {

	/**
	 * @param _driver
	 * @param report
	 */
	public BorrowerRegistrationPersonal_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "900000")
	private WebElement BrwrRegPrsnl_borrower_Tab;

	@FindBy(id = "901000")
	private WebElement BrwrRegPrsnl_registration;

	@FindBy(name = "personal")
	private WebElement BrwrRegPrsnl_Tab;

	@FindBy(name = "customerBean.custProdType")
	private WebElement BrwrRegProd_Type;

	@FindBy(name = "customerBean.eyeColor")
	private WebElement BrwrRegEye_color;

	@FindBy(name = "customerBean.feet")
	private WebElement BrwrRegHeight_feet;

	@FindBy(name = "customerBean.inches")
	private WebElement BrwrRegHeight_inche;

	@FindBy(name = "ssn1")
	private WebElement BrwrRegPrsnl_ssn1;

	@FindBy(name = "ssn2")
	private WebElement BrwrRegPrsnl_ssn2;

	@FindBy(name = "ssn3")
	private WebElement BrwrRegPrsnl_ssn3;

	@FindBy(name = "ssn4")
	private WebElement BrwrRegPrsnl_confirm_ssn1;

	@FindBy(name = "ssn5")
	private WebElement BrwrRegPrsnl_confirm_ssn2;

	@FindBy(name = "ssn6")
	private WebElement BrwrRegPrsnl_confirm_ssn3;

	@FindBy(name = "customerBean.pin_summary")
	private WebElement BrwrRegPrsnl_pin;

	@FindBy(name = "customerBean.lastNm")
	private WebElement BrwrRegPrsnl_lastName;

	@FindBy(name = "customerBean.firstNm")
	private WebElement BrwrRegPrsnl_firstName;

	@FindBy(name = "customerBean.middleNm")
	private WebElement BrwrRegPrsnl_middleName;

	@FindBy(name = "customerBean.mailingAddressLn1")
	private WebElement BrwrRegPrsnl_address1;

	@FindBy(name = "customerBean.mailingAddressLn2")
	private WebElement BrwrRegPrsnl_address2;

	@FindBy(name = "customerBean.mailingCity")
	private WebElement BrwrRegPrsnl_city;

	@FindBy(name = "customerBean.mailingStateCd")
	private WebElement BrwrRegPrsnl_state;

	@FindBy(name = "customerBean.mailingPostalCd")
	private WebElement BrwrRegPrsnl_zip_TestBox;

	/* Mailing Address */
	@FindBy(name = "customerBean.sameMailAddress")
	private WebElement BrwrRegPrsnl_sameasmailaddress;

	@FindBy(name = "customerBean.mailingAddressLn1")
	private WebElement BrwrRegPrsnl_mailaddress1;

	@FindBy(name = "customerBean.mailingAddressLn2")
	private WebElement BrwrRegPrsnl_mailaddress2;

	@FindBy(name = "customerBean.mailingCity")
	private WebElement BrwrRegPrsnl_mailcity;

	@FindBy(name = "customerBean.mailingStateCd")
	private WebElement BrwrRegPrsnl_mailstate;

	@FindBy(name = "customerBean.mailingPostalCd")
	private WebElement BrwrRegPrsnl_mailzip;

	/* Mailing Address */

	@FindBy(name = "customerBean.monthsAtAddress")
	private WebElement BrwrRegPrsnl_monthsAtAddress_TestBox;

	@FindBy(name = "customerBean.rentOwnFlg")
	private WebElement BrwrRegPrsnl_OwnResidency;

	@FindBy(name = "customerBean.rent")
	private WebElement BrwrRegPrsnl_rentAmount_TextBox;

	@FindBy(name = "customerBean.suffixCd")
	private WebElement BrwrRegPrsnl_suffix;

	@FindBy(name = "customerBean.badAddressFlg")
	private WebElement BrwrRegPrsnl_badAddress;

	// Primary Phone Number

	@FindBy(name = "phoneNbr1")
	private WebElement BrwrRegPrsnl_PrimaryPhoneNbr1;

	@FindBy(name = "phoneNbr2")
	private WebElement BrwrRegPrsnl_PrimaryPhoneNbr2;

	@FindBy(name = "phoneNbr3")
	private WebElement BrwrRegPrsnl_PrimaryPhoneNbr3;

	@FindBy(name = "sphoneNbr1")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr1;

	@FindBy(name = "sphoneNbr2")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr2;

	@FindBy(name = "sphoneNbr3")
	private WebElement BrwrRegOthers_SecondaryPhoneNbr3;

	@FindBy(name = "customerBean.cphoneCd")
	private WebElement BrwrRegOthers_SecondaryPhoneType;

	@FindBy(name = "customerBean.extp")
	private WebElement BrwrRegPrsnl_PrimaryPhoneNbrExt;

	@FindBy(name = "customerBean.phoneCd")
	private WebElement BrwrRegPrsnl_PrimaryPhoneType_DropdownField;

	@FindBy(name = "customerBean.dncFlg")
	private WebElement BrwrRegPrsnl_PrimaryDNC_CheckBoxField;

	@FindBy(name = "customerBean.badEmailFlg")
	private WebElement BrwrRegPrsnl_badEmail;

	@FindBy(name = "customerBean.email")
	private WebElement BrwrRegPrsnl_Regemail;

	@FindBy(xpath = "//input[@name='OES' and @id='oprRadioEmailOptIn']")
	private WebElement BrwrRegPrsnl_AccEmailMaintananceOptIn;

	@FindBy(xpath = "//input[@name='OES' and @id='oprRadioEmailOptOut']")
	private WebElement BrwrRegPrsnl_AccEmailMaintananceOptOut;

	@FindBy(xpath = "//input[@name='MES' and @id='marRadioEmailOptIn']")
	private WebElement BrwrRegPrsnl_AccEmailMarkettingOptIn;

	@FindBy(xpath = "//input[@name='MES' and @id='marRadioEmailOptOut']")
	private WebElement BrwrRegPrsnl_AccEmailMarkettingOptOut;

	@FindBy(name = "customerBean.isCustomerEmailQuest")
	private WebElement BrwrRegPrsnl_doesNotHaveEmail;

	@FindBy(name = "customerBean.badPhoneFlg")
	private WebElement BrwrRegPrsnl_badPhone;

	// Miscellaneous Information

	@FindBy(name = "customerBean.driversLicNbr")
	private WebElement BrwrRegPrsnl_PhotoIdNbr;

	@FindBy(name = "customerBean.driversLicSt")
	private WebElement BrwrRegPrsnl_PhotoIDState_Dropdown;

	@FindBy(name = "dlexpiry1")
	private WebElement BrwrRegPrsnl_IdExpiryMonth;

	@FindBy(name = "dlexpiry2")
	private WebElement BrwrRegPrsnl_IdExpiryDay;

	@FindBy(name = "dlexpiry3")
	private WebElement BrwrRegPrsnl_IdExpiryYear;

	@FindBy(name = "customerBean.photoIdType")
	private WebElement BrwrRegPrsnl_PhotoIdType_Dropdown;

	@FindBy(name = "customerBean.drivingZipcode")
	private WebElement BrwrRegPrsnl_IdZipCode;

	@FindBy(name = "dob1")
	private WebElement BrwrRegPrsnl_DobMonth;

	@FindBy(name = "dob2")
	private WebElement BrwrRegPrsnl_DobDay;

	@FindBy(name = "dob3")
	private WebElement BrwrRegPrsnl_DobYear;

	@FindBy(name = "appdate1")
	private WebElement BrwrRegPrsnl_ApplicationDate;

	@FindBy(name = "appdate2")
	private WebElement BrwrRegPrsnl_ApplicationDate2;

	@FindBy(name = "appdate3")
	private WebElement BrwrRegPrsnl_ApplicationDate3;

	@FindBy(id = "902000")
	private WebElement BrwrRegPrsnl_edit;

	@FindBy(id = "bothRadioEmailOptOut")
	private WebElement BrwrRegPrsnl_optOutBoth_RadioButton;

	@FindBy(id = "bothRadioEmailOptIn")
	private WebElement BrwrRegPrsnl_optInBoth_RadioButton;

	@FindBy(id = "bothRadioEmailOptIn")
	private WebElement brp_ValidationMsg;

	public void click_BrwrRegPrsnl_sameasmailaddress(String data) {
		doIT(BrwrRegPrsnl_sameasmailaddress, data);

	}

	public boolean checkVisibiltyOfBrwrRegPrsnl_ssn() {
		return BrwrRegPrsnl_ssn1.isDisplayed();

	}

	public void click_BrwrRegPrsnl_optInBoth_RadioButton(String data) {
		doIT(BrwrRegPrsnl_optInBoth_RadioButton, data);

	}

	public void click_BrwrRegPrsnl_optOutBoth_RadioButton(String data) {
		doIT(BrwrRegPrsnl_optOutBoth_RadioButton, data);

	}

	public void click_BrwrRegPrsnl_edit(String data) {
		doIT(BrwrRegPrsnl_edit, data);

	}

	public void click_BBrwrRegPrsnl_Tab(String data) {
		doIT(BrwrRegPrsnl_Tab, data);
	}

	public void click_BrwrRegPrsnl_borrower_Tab(String data) {
		doIT(BrwrRegPrsnl_borrower_Tab, data);
	}

	public void click_BrwrRegPrsnl_Registration_Link(String data) {
		doIT(BrwrRegPrsnl_registration, data);
	}

	public String get_BrwrRegPrsnl_ssn(String data) {
		return doIT(BrwrRegPrsnl_ssn1, data);
	}

	public String get_BrwrRegPrsnl_ssnLast(String data) {
		return doIT(BrwrRegPrsnl_ssn3, data);
	}

	public String set_BrwrRegPrsnl_ssn(String brwrRegPrsnl_ssn) {
		String SSN = null;

		if (!brwrRegPrsnl_ssn.isEmpty()) {
			if (brwrRegPrsnl_ssn.toLowerCase().contains("random")) {
				String SSN1 = brwrRegPrsnl_ssn.split("_")[0];
				String SSN2 = getRandomNumSSN2(2);
				String SSN3 = getRandomNumSSN3(4);
				doIT(BrwrRegPrsnl_ssn1, SSN1);
				doIT(BrwrRegPrsnl_ssn2, SSN2);
				doIT(BrwrRegPrsnl_ssn3, SSN3);
				SSN = SSN1 + "-" + SSN2 + "-" + SSN3;
			} else {
				String[] SSNtemp = brwrRegPrsnl_ssn.split("-");
				doIT(BrwrRegPrsnl_ssn1, SSNtemp[0]);
				doIT(BrwrRegPrsnl_ssn2, SSNtemp[1]);
				doIT(BrwrRegPrsnl_ssn3, SSNtemp[2]);
				SSN = brwrRegPrsnl_ssn;
			}
		} else {
			SSN = "BLANK";
		}

		return SSN;
	}

	public static String getRandomNumSSN2(int count) {
		String randomnum1 = RandomStringUtils.randomNumeric(count);
		if (randomnum1.equals("00")) {
			return randomnum1.replace("00", "21");
		} else {
			return randomnum1;
		}
	}

	public static String getRandomNumSSN3(int count) {
		String randomnum1 = RandomStringUtils.randomNumeric(count);
		if (randomnum1.equals("0000")) {
			return randomnum1.replace("0000", "9821");
		} else {
			return randomnum1;
		}
	}

	public String get_BrwrRegPrsnl_confirm_ssn(String data) {
		return doIT(BrwrRegPrsnl_confirm_ssn3, data);
	}

	public void set_BrwrRegPrsnl_confirm_ssn(String data) {
		if (!data.isEmpty()) {
			String[] SSNtemp = data.split("-");
			doIT(BrwrRegPrsnl_confirm_ssn1, SSNtemp[0]);
			doIT(BrwrRegPrsnl_confirm_ssn2, SSNtemp[1]);
			doIT(BrwrRegPrsnl_confirm_ssn3, SSNtemp[2]);
		}
	}

	public String get_BrwrRegPrsnl_pin(String data) {
		return doIT(BrwrRegPrsnl_pin, data);
	}

	public void set_BrwrRegPrsnl_pin(String brwrRegPrsnl_pin) {
		if (brwrRegPrsnl_pin.equalsIgnoreCase("Random")) {
			doIT(BrwrRegPrsnl_pin, Helper.getRandomNumeric(5));
		} else {
			doIT(BrwrRegPrsnl_pin, brwrRegPrsnl_pin);
		}
	}

	public String get_BrwrRegPrsnl_lastName(String data) {
		return doIT(BrwrRegPrsnl_lastName, data);
	}

	public String set_BrwrRegPrsnl_lastName(String brwrRegPrsnl_lastName) {
		if (brwrRegPrsnl_lastName.equalsIgnoreCase("Auto")) {
			brwrRegPrsnl_lastName = Helper.getRandomAlphabetic(6) + "ooo" + brwrRegPrsnl_lastName;
		}
		doIT(BrwrRegPrsnl_lastName, brwrRegPrsnl_lastName);
		return brwrRegPrsnl_lastName;
	}

	public String get_BrwrRegPrsnl_firstName(String data) {
		return doIT(BrwrRegPrsnl_firstName, data);
	}

	public String set_BrwrRegPrsnl_firstName(String brwrRegPrsnl_firstName) {
		doIT(BrwrRegPrsnl_firstName, brwrRegPrsnl_firstName);
		return brwrRegPrsnl_firstName;
	}

	public String get_BrwrRegPrsnl_middleName(String data) {
		return doIT(BrwrRegPrsnl_middleName, data);
	}

	public void set_BrwrRegPrsnl_middleName(String brwrRegPrsnl_middleName) {
		doIT(BrwrRegPrsnl_middleName, brwrRegPrsnl_middleName);
	}

	public String get_BrwrRegPrsnl_address1(String data) {
		return doIT(BrwrRegPrsnl_address1, data);
	}

	public void set_BrwrRegPrsnl_address1(String brwrRegPrsnl_address1) {
		doIT(BrwrRegPrsnl_address1, brwrRegPrsnl_address1);
	}

	public String get_BrwrRegPrsnl_address2(String data) {
		return doIT(BrwrRegPrsnl_address2, data);
	}

	public void set_BrwrRegPrsnl_address2(String brwrRegPrsnl_address2) {
		doIT(BrwrRegPrsnl_address2, brwrRegPrsnl_address2);
	}

	public String get_BrwrRegPrsnl_city(String data) {
		return doIT(BrwrRegPrsnl_city, data);
	}

	public void set_BrwrRegPrsnl_city(String brwrRegPrsnl_city) {
		doIT(BrwrRegPrsnl_city, brwrRegPrsnl_city);
	}

	public String get_BrwrRegPrsnl_state(String data) {
		return doIT(BrwrRegPrsnl_state, data);
	}

	public void set_BrwrRegPrsnl_state(String brwrRegPrsnl_state) {
		doIT(BrwrRegPrsnl_state, brwrRegPrsnl_state);
	}

	public String get_BrwrRegPrsnl_zip_TestBox(String data) {
		return doIT(BrwrRegPrsnl_zip_TestBox, data);
	}

	public void set_BrwrRegPrsnl_zip_TestBox(String brwrRegPrsnl_zip_TestBox) {
		doIT(BrwrRegPrsnl_zip_TestBox, brwrRegPrsnl_zip_TestBox);		
	}

	public String get_BrwrRegPrsnl_monthsAtAddress_TestBox(String data) {
		return doIT(BrwrRegPrsnl_monthsAtAddress_TestBox, data);
	}

	public void set_BrwrRegPrsnl_monthsAtAddress_TestBox(String brwrRegPrsnl_monthsAtAddress_TestBox) {
		doIT(BrwrRegPrsnl_monthsAtAddress_TestBox, brwrRegPrsnl_monthsAtAddress_TestBox);
	}

	public String get_BrwrRegPrsnl_OwnResidency(String data) {
		return doIT(BrwrRegPrsnl_OwnResidency, data);
	}

	public void set_BrwrRegPrsnl_OwnResidency(String brwrRegPrsnl_OwnResidency) {
		doIT(BrwrRegPrsnl_OwnResidency, brwrRegPrsnl_OwnResidency);
	}

	public String get_BrwrRegPrsnl_rentAmount_TextBox(String data) {
		return doIT(BrwrRegPrsnl_rentAmount_TextBox, data);
	}

	public void set_BrwrRegPrsnl_rentAmount_TextBox(String brwrRegPrsnl_rentAmount_TextBox) {
		doIT(BrwrRegPrsnl_rentAmount_TextBox, brwrRegPrsnl_rentAmount_TextBox);
	}

	public String get_BrwrRegPrsnl_suffix(String data) {
		return doIT(BrwrRegPrsnl_suffix, data);
	}

	public void set_BrwrRegPrsnl_suffix(String brwrRegPrsnl_suffix) {
		doIT(BrwrRegPrsnl_suffix, brwrRegPrsnl_suffix);
	}

	public String get_BrwrRegPrsnl_badAddress(String data) {
		return doIT(BrwrRegPrsnl_badAddress, data);
	}

	public void set_BrwrRegPrsnl_badAddress(String brwrRegPrsnl_badAddress) {
		doIT(BrwrRegPrsnl_badAddress, brwrRegPrsnl_badAddress);
	}

	public String get_BrwrRegPrsnl_PrimaryPhoneNbr1(String data) {
		return doIT(BrwrRegPrsnl_PrimaryPhoneNbr1, data);
	}

	public void set_BrwrRegPrsnl_PrimaryPhoneNbr1(String brwrRegPrsnl_PrimaryPhoneNbr1) {
		doIT(BrwrRegPrsnl_PrimaryPhoneNbr1, brwrRegPrsnl_PrimaryPhoneNbr1);
	}

	public String get_BrwrRegPrsnl_PrimaryPhoneNbr2(String data) {
		return doIT(BrwrRegPrsnl_PrimaryPhoneNbr2, data);
	}

	public void set_BrwrRegPrsnl_PrimaryPhoneNbr2(String brwrRegPrsnl_PrimaryPhoneNbr2) {
		doIT(BrwrRegPrsnl_PrimaryPhoneNbr2, brwrRegPrsnl_PrimaryPhoneNbr2);
	}

	public String get_BrwrRegPrsnl_PrimaryPhoneNbr3(String data) {
		return doIT(BrwrRegPrsnl_PrimaryPhoneNbr3, data);
	}

	public void set_BrwrRegPrsnl_PrimaryPhoneNbr3(String brwrRegPrsnl_PrimaryPhoneNbr3) {
		doIT(BrwrRegPrsnl_PrimaryPhoneNbr3, brwrRegPrsnl_PrimaryPhoneNbr3);
	}

	public String get_BrwrRegPrsnl_PrimaryPhoneNbrExt(String data) {
		return doIT(BrwrRegPrsnl_PrimaryPhoneNbrExt, data);
	}

	public void set_BrwrRegPrsnl_PrimaryPhoneNbrExt(String brwrRegPrsnl_PrimaryPhoneNbrExt) {
		doIT(BrwrRegPrsnl_PrimaryPhoneNbrExt, brwrRegPrsnl_PrimaryPhoneNbrExt);
	}

	public String get_BrwrRegPrsnl_PrimaryPhoneType_DropdownField(String data) {
		return doIT(BrwrRegPrsnl_PrimaryPhoneType_DropdownField, data);
	}

	public void set_BrwrRegPrsnl_PrimaryPhoneType_DropdownField(String brwrRegPrsnl_PrimaryPhoneType_DropdownField) {
		doIT(BrwrRegPrsnl_PrimaryPhoneType_DropdownField, brwrRegPrsnl_PrimaryPhoneType_DropdownField);
	}

	public void click_BrwrRegPrsnl_PrimaryDNC_CheckBoxField(String data) {
		doIT(BrwrRegPrsnl_PrimaryDNC_CheckBoxField, data);
	}

	public String get_BrwrRegPrsnl_badEmail(String data) {
		return doIT(BrwrRegPrsnl_badEmail, data);
	}

	public void set_BrwrRegPrsnl_badEmail(String brwrRegPrsnl_badEmail) {
		doIT(BrwrRegPrsnl_badEmail, brwrRegPrsnl_badEmail);
	}

	public String get_BrwrRegPrsnl_Regemail(String data) {
		return doIT(BrwrRegPrsnl_Regemail, data);
	}

	public void BrwrRegPrsnl_Regemailcheck(String brwrRegPrsnl_Regemail) {
		String emailget = BrwrRegPrsnl_Regemail.getAttribute("value");
		if (emailget.isEmpty()) {
			set_BrwrRegPrsnl_Regemail(brwrRegPrsnl_Regemail);
		}
	}

	public String set_BrwrRegPrsnl_Regemail(String brwrRegPrsnl_Regemail) {
		String email = null;
		if (brwrRegPrsnl_Regemail.equalsIgnoreCase("Random")) {
			String emailfirspart = RandomStringUtils.randomAlphanumeric(7);
			// email= emailfirspart+"@gmail.com";
			email = "qfund123@gmail.com";
			doIT(BrwrRegPrsnl_Regemail, email);
		} else {
			email = brwrRegPrsnl_Regemail;
			doIT(BrwrRegPrsnl_Regemail, brwrRegPrsnl_Regemail);
		}
		return email;
	}

	public String set_BrwrRegPrsnl_Regemail(String brwrRegPrsnl_Regemail, String FN, String LN) {
		String email = null;
		if (brwrRegPrsnl_Regemail.equalsIgnoreCase("Random")) {
			email = FN + "." + LN + "@gmail.com";
			doIT(BrwrRegPrsnl_Regemail, email);
		} else {
			email = brwrRegPrsnl_Regemail;
			doIT(BrwrRegPrsnl_Regemail, brwrRegPrsnl_Regemail);
		}
		return email;
	}

	public String get_BrwrRegPrsnl_doesNotHaveEmail(String data) {
		return doIT(BrwrRegPrsnl_doesNotHaveEmail, data);
	}

	public void set_BrwrRegPrsnl_doesNotHaveEmail(String brwrRegPrsnl_doesNotHaveEmail) {
		doIT(BrwrRegPrsnl_doesNotHaveEmail, brwrRegPrsnl_doesNotHaveEmail);
	}

	public String get_BrwrRegPrsnl_badPhone(String data) {
		return doIT(BrwrRegPrsnl_badPhone, data);
	}

	public void set_BrwrRegPrsnl_badPhone(String brwrRegPrsnl_badPhone) {
		doIT(BrwrRegPrsnl_badPhone, brwrRegPrsnl_badPhone);
	}

	public String get_BrwrRegPrsnl_PhotoIdNbr(String data) {
		return doIT(BrwrRegPrsnl_PhotoIdNbr, data);
	}

	public String set_BrwrRegPrsnl_PhotoIdNbr(String brwrRegPrsnl_PhotoIdNbr) {
		String photoidnbr="";
		if (brwrRegPrsnl_PhotoIdNbr.equalsIgnoreCase("Random")) {
			doIT(BrwrRegPrsnl_PhotoIdNbr, RandomStringUtils.randomNumeric(8));
			photoidnbr=brwrRegPrsnl_PhotoIdNbr;
		} else {
			doIT(BrwrRegPrsnl_PhotoIdNbr, brwrRegPrsnl_PhotoIdNbr);
			photoidnbr=brwrRegPrsnl_PhotoIdNbr;
			}
		return photoidnbr;
	}

	public String get_BrwrRegPrsnl_PhotoIDState_Dropdown(String data) {
		return doIT(BrwrRegPrsnl_PhotoIDState_Dropdown, data);
	}

	public void set_BrwrRegPrsnl_PhotoIDState_Dropdown(String brwrRegPrsnl_PhotoIDState_Dropdown) {
		doIT(BrwrRegPrsnl_PhotoIDState_Dropdown, brwrRegPrsnl_PhotoIDState_Dropdown);
	}

	/*
	 * public String get_BrwrRegPrsnl_IdExpiry(String data) { return
	 * doIT(brwrRegPrsnl_IdExpiry, data); }
	 */

	public void set_BrwrRegPrsnl_IdExpiry(String brwrRegPrsnl_IdExpiry) {
		if (!brwrRegPrsnl_IdExpiry.isEmpty()) {
			String[] IdExpiry = brwrRegPrsnl_IdExpiry.split("/", -2);
			doIT(BrwrRegPrsnl_IdExpiryMonth, IdExpiry[0]);
			doIT(BrwrRegPrsnl_IdExpiryDay, IdExpiry[1]);
			doIT(BrwrRegPrsnl_IdExpiryYear, IdExpiry[2]);
		}

	}

	/*
	 * public String get_BrwrRegPrsnl_IdExpiryMonth(String data) { return
	 * doIT(BrwrRegPrsnl_IdExpiryMonth, data); }
	 * 
	 * public void set_BrwrRegPrsnl_IdExpiryMonth(String
	 * brwrRegPrsnl_IdExpiryMonth) { doIT(BrwrRegPrsnl_IdExpiryMonth,
	 * brwrRegPrsnl_IdExpiryMonth); }
	 * 
	 */ public String get_BrwrRegPrsnl_PhotoIdType_Dropdown(String data) {
		return doIT(BrwrRegPrsnl_PhotoIdType_Dropdown, data);
	}

	public void set_BrwrRegPrsnl_PhotoIdType_Dropdown(String brwrRegPrsnl_PhotoIdType_Dropdown) {
		doIT(BrwrRegPrsnl_PhotoIdType_Dropdown, brwrRegPrsnl_PhotoIdType_Dropdown);
	}

	public String get_BrwrRegPrsnl_IdZipCode(String data) {
		return doIT(BrwrRegPrsnl_IdZipCode, data);
	}

	public void set_BrwrRegPrsnl_IdZipCode(String brwrRegPrsnl_IdZipCode) {
		// BrwrRegPrsnl_IdZipCode.clear();
		doIT(BrwrRegPrsnl_IdZipCode, brwrRegPrsnl_IdZipCode);
	}

	public void set_BrwrRegPrsnl_IdZipCode_clear(String data) {
		BrwrRegPrsnl_IdZipCode.clear();
	}

	public String set_BrwrRegPrsnl_CustomerDOB(String brwrRegPrsnl_CustomerDOB) {
		String DOB="";
		if (!brwrRegPrsnl_CustomerDOB.isEmpty()) {
			String[] CustDOB = brwrRegPrsnl_CustomerDOB.split("/", -2);
			doIT(BrwrRegPrsnl_DobMonth, CustDOB[0]);
			doIT(BrwrRegPrsnl_DobDay, CustDOB[1]);
			doIT(BrwrRegPrsnl_DobYear, CustDOB[2]);
			DOB=brwrRegPrsnl_CustomerDOB;
		}
		return DOB;

	}

	public String get_BrwrRegPrsnl_DobMonth(String data) {
		return doIT(BrwrRegPrsnl_DobMonth, data);
	}

	public String get_BrwrRegPrsnl_DobDay(String data) {
		return doIT(BrwrRegPrsnl_DobDay, data);
	}

	public String get_BrwrRegPrsnl_DobYear(String data) {
		return doIT(BrwrRegPrsnl_DobYear, data);
	}

	public String get_DOB() {

		String s1 = get_BrwrRegPrsnl_DobMonth("Get");
		String s2 = get_BrwrRegPrsnl_DobDay("Get");
		String s3 = get_BrwrRegPrsnl_DobYear("Get");
		String s = s1 + s2 + s3;
		return s;

	}

	/*
	 * public String get_BrwrRegPrsnl_DobMonth(String data) { return
	 * doIT(BrwrRegPrsnl_DobMonth, data); }
	 * 
	 * public void set_BrwrRegPrsnl_DobMonth(String brwrRegPrsnl_DobMonth) {
	 * doIT(BrwrRegPrsnl_DobMonth, brwrRegPrsnl_DobMonth); }
	 * 
	 * public String get_BrwrRegPrsnl_DobDay(String data) { return
	 * doIT(BrwrRegPrsnl_DobDay, data); }
	 * 
	 * public void set_BrwrRegPrsnl_DobDay(String brwrRegPrsnl_DobDay) {
	 * doIT(BrwrRegPrsnl_DobDay, brwrRegPrsnl_DobDay); }
	 * 
	 * public String get_BrwrRegPrsnl_DobYear(String data) { return
	 * doIT(BrwrRegPrsnl_DobYear, data); }
	 * 
	 * public void set_BrwrRegPrsnl_DobYear(String brwrRegPrsnl_DobYear) {
	 * doIT(BrwrRegPrsnl_DobYear, brwrRegPrsnl_DobYear); }
	 */
	public String get_BrwrRegPrsnl_ApplicationDate(String data) {
		return doIT(BrwrRegPrsnl_ApplicationDate, data);
	}

	public void set_BrwrRegPrsnl_ApplicationDate(String brwrRegPrsnl_ApplicationDate) {
		doIT(BrwrRegPrsnl_ApplicationDate, brwrRegPrsnl_ApplicationDate);
	}

	public void set_BrwrRegPrsnl_ApplicationDates(String brwrRegPrsnl_ApplicationDate) {
		if (brwrRegPrsnl_ApplicationDate != null) {
			if (!brwrRegPrsnl_ApplicationDate.isEmpty()) {
				String[] appdate = brwrRegPrsnl_ApplicationDate.split("/", -2);
				doIT(BrwrRegPrsnl_ApplicationDate, appdate[0]);
				doIT(BrwrRegPrsnl_ApplicationDate2, appdate[1]);
				doIT(BrwrRegPrsnl_ApplicationDate3, appdate[2]);
			}
		}
	}

	public String get_BrwrRegOthers_SecondaryPhoneNbr1(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr1, data);
	}

	public void set_BrwrRegOthers_SecondaryPhoneNbr1(String brwrRegOthers_SecondaryPhoneNbr1) {
		// setValKeybord(BrwrRegOthers_SecondaryPhoneNbr1,brwrRegOthers_SecondaryPhoneNbr1);
		doIT(BrwrRegOthers_SecondaryPhoneNbr1, brwrRegOthers_SecondaryPhoneNbr1);
	}

	public String get_BrwrRegOthers_SecondaryPhoneNbr2(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr2, data);
	}

	public void set_BrwrRegOthers_SecondaryPhoneNbr2(String brwrRegOthers_SecondaryPhoneNbr2) {
		doIT(BrwrRegOthers_SecondaryPhoneNbr2, brwrRegOthers_SecondaryPhoneNbr2);
	}

	public String get_BrwrRegOthers_SecondaryPhoneNbr3(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneNbr3, data);
	}

	public void set_BrwrRegOthers_SecondaryPhoneNbr3(String brwrRegOthers_SecondaryPhoneNbr3) {
		doIT(BrwrRegOthers_SecondaryPhoneNbr3, brwrRegOthers_SecondaryPhoneNbr3);
	}

	public String get_BrwrRegOthers_SecondaryPhoneType(String data) {
		return doIT(BrwrRegOthers_SecondaryPhoneType, data);
	}

	public void set_BrwrRegOthers_SecondaryPhoneType(String brwrRegOthers_SecondaryPhoneType) {
		doIT(BrwrRegOthers_SecondaryPhoneType, brwrRegOthers_SecondaryPhoneType);
	}

	/**
	 * @return the brwrRegProd_Type
	 */
	public String get_BrwrRegProd_Type(String data) {
		return doIT(BrwrRegProd_Type, data);
	}

	/**
	 * @param brwrRegProd_Type
	 *            the brwrRegProd_Type to set
	 */
	public void set_BrwrRegProd_Type(String brwrRegProd_Type) {
		doIT(BrwrRegProd_Type, brwrRegProd_Type);
	}

	/**
	 * @return the brwrRegEye_color
	 */
	public String get_BrwrRegEye_color(String data) {
		return doIT(BrwrRegEye_color, data);

	}

	/**
	 * @param brwrRegEye_color
	 *            the brwrRegEye_color to set
	 */
	public void set_BrwrRegEye_color(String brwrRegEye_color) {
		doIT(BrwrRegEye_color, brwrRegEye_color);

	}

	/**
	 * @return the brwrRegHeight_feet
	 */
	public String get_BrwrRegHeight_feet(String data) {
		return doIT(BrwrRegHeight_feet, data);

	}

	/**
	 * @param brwrRegHeight_feet
	 *            the brwrRegHeight_feet to set
	 */
	public void set_BrwrRegHeight_feet(String brwrRegHeight_feet) {
		doIT(BrwrRegHeight_feet, brwrRegHeight_feet);

	}

	/**
	 * @return the brwrRegHeight_inche
	 */
	public String get_BrwrRegHeight_inche(String data) {
		return doIT(BrwrRegHeight_inche, data);

	}

	/**
	 * @param brwrRegHeight_inche
	 *            the brwrRegHeight_inche to set
	 */
	public void set_BrwrRegHeight_inche(String brwrRegHeight_inche) {
		doIT(BrwrRegHeight_inche, brwrRegHeight_inche);

	}

	/**
	 * @return the brwrRegPrsnl_IdExpiryDay
	 */
	/*
	 * public String get_BrwrRegPrsnl_IdExpiryDay(String data) { return
	 * doIT(BrwrRegPrsnl_IdExpiryDay, data);
	 * 
	 * }
	 * 
	 *//**
		 * @param brwrRegPrsnl_IdExpiryDay
		 *            the brwrRegPrsnl_IdExpiryDay to set
		 */
	/*
	 * public void set_BrwrRegPrsnl_IdExpiryDay(String brwrRegPrsnl_IdExpiryDay)
	 * { doIT(BrwrRegPrsnl_IdExpiryDay, brwrRegPrsnl_IdExpiryDay);
	 * 
	 * }
	 * 
	 *//**
		 * @return the brwrRegPrsnl_IdExpiryYear
		 */
	/*
	 * public String get_BrwrRegPrsnl_IdExpiryYear(String data) { return
	 * doIT(BrwrRegPrsnl_IdExpiryYear, data);
	 * 
	 * }
	 * 
	 *//**
		 * @param brwrRegPrsnl_IdExpiryYear
		 *            the brwrRegPrsnl_IdExpiryYear to set
		 *//*
		 * public void set_BrwrRegPrsnl_IdExpiryYear(String
		 * brwrRegPrsnl_IdExpiryYear) { doIT(BrwrRegPrsnl_IdExpiryYear,
		 * brwrRegPrsnl_IdExpiryYear);
		 * 
		 * }
		 * 
		 */
	/* Mailing Address */

	/**
	 * @return the brwrRegPrsnl_mailaddress1
	 */
	public String get_BrwrRegPrsnl_mailaddress1(String data) {
		return doIT(BrwrRegPrsnl_mailaddress1, data);

	}

	/**
	 * @param brwrRegPrsnl_mailaddress1
	 *            the brwrRegPrsnl_mailaddress1 to set
	 */
	public void set_BrwrRegPrsnl_mailaddress1(String brwrRegPrsnl_mailaddress1) {
		doIT(BrwrRegPrsnl_mailaddress1, brwrRegPrsnl_mailaddress1);

	}

	/**
	 * @return the brwrRegPrsnl_mailaddress2
	 */
	public String get_BrwrRegPrsnl_mailaddress2(String data) {
		return doIT(BrwrRegPrsnl_mailaddress2, data);

	}

	/**
	 * @param brwrRegPrsnl_mailaddress2
	 *            the brwrRegPrsnl_mailaddress2 to set
	 */
	public void set_BrwrRegPrsnl_mailaddress2(String brwrRegPrsnl_mailaddress2) {
		doIT(BrwrRegPrsnl_mailaddress2, brwrRegPrsnl_mailaddress2);

	}

	/**
	 * @return the brwrRegPrsnl_mailcity
	 */
	public String get_BrwrRegPrsnl_mailcity(String data) {
		return doIT(BrwrRegPrsnl_mailcity, data);

	}

	/**
	 * @param brwrRegPrsnl_mailcity
	 *            the brwrRegPrsnl_mailcity to set
	 */
	public void set_BrwrRegPrsnl_mailcity(String brwrRegPrsnl_mailcity) {
		doIT(BrwrRegPrsnl_mailcity, brwrRegPrsnl_mailcity);

	}

	/**
	 * @return the brwrRegPrsnl_mailstate
	 */
	public String get_BrwrRegPrsnl_mailstate(String data) {
		return doIT(BrwrRegPrsnl_mailstate, data);

	}

	/**
	 * @param brwrRegPrsnl_mailstate
	 *            the brwrRegPrsnl_mailstate to set
	 */
	public void set_BrwrRegPrsnl_mailstate(String brwrRegPrsnl_mailstate) {
		doIT(BrwrRegPrsnl_mailstate, brwrRegPrsnl_mailstate);

	}

	/**
	 * @return the brwrRegPrsnl_mailzip
	 */
	public String get_BrwrRegPrsnl_mailzip(String data) {
		return doIT(BrwrRegPrsnl_mailzip, data);

	}

	public String click_BrwrRegPrsnl_AccEmailMaintananceOptIn(String data) {
		if (!data.isEmpty()) {
			doIT(BrwrRegPrsnl_AccEmailMaintananceOptOut, data);
			if (isAlertPresent()) {
				acceptAlert();
			}
			doIT(BrwrRegPrsnl_AccEmailMaintananceOptIn, data);
			if (getAlertText().contains("like to receive Marketing E-Mails")) {
				dismissAlert();
			}
			String alertText = getAlertText();
			acceptAlert();
			return alertText;
		} else {
			return "";
		}
	}

	public String click_BrwrRegPrsnl_AccEmailMaintananceOptOut(String data) {
		if (!data.isEmpty()) {
			doIT(BrwrRegPrsnl_AccEmailMaintananceOptIn, data);
			if (isAlertPresent()) {
				dismissAlert();
			}
			doIT(BrwrRegPrsnl_AccEmailMaintananceOptOut, data);
			String alertText = getAlertText();
			acceptAlert();
			return alertText;
		} else {
			return "";
		}
	}

	public String click_BrwrRegPrsnl_AccEmailMarkettingOptIn(String data) {
		if (!data.isEmpty()) {
			doIT(BrwrRegPrsnl_AccEmailMarkettingOptOut, data);
			if (isAlertPresent()) {
				acceptAlert();
			}
			doIT(BrwrRegPrsnl_AccEmailMarkettingOptIn, data);
			String alertText = getAlertText();
			acceptAlert();
			return alertText;
		} else {
			return "";
		}
	}

	public String click_BrwrRegPrsnl_AccEmailMarkettingOptOut(String data) {
		if (!data.isEmpty()) {
			doIT(BrwrRegPrsnl_AccEmailMarkettingOptIn, data);
			if (isAlertPresent()) {
				acceptAlert();
			}
			doIT(BrwrRegPrsnl_AccEmailMarkettingOptOut, data);
			String alertText = getAlertText();
			acceptAlert();
			return alertText;
		} else {
			return "";
		}
	}

	/**
	 * @param brwrRegPrsnl_mailzip
	 *            the brwrRegPrsnl_mailzip to set
	 */
	public void set_BrwrRegPrsnl_mailzip(String brwrRegPrsnl_mailzip) {
		doIT(BrwrRegPrsnl_mailzip, brwrRegPrsnl_mailzip);

	}

	public void set_BrwrRegPrsnl_PrimaryPhoneNbr(String brwrRegPrsnl_PrimaryPhoneNbr) {
		if (!brwrRegPrsnl_PrimaryPhoneNbr.isEmpty()) {
			String[] PrimaryPhNbr = brwrRegPrsnl_PrimaryPhoneNbr.split("-", -2);
			doIT(BrwrRegPrsnl_PrimaryPhoneNbr1, PrimaryPhNbr[0]);
			doIT(BrwrRegPrsnl_PrimaryPhoneNbr2, PrimaryPhNbr[1]);
			doIT(BrwrRegPrsnl_PrimaryPhoneNbr3, PrimaryPhNbr[2]);
		}

	}

	public void set_BrwrRegOthers_SecondaryPhoneNbr(String brwrRegOthers_SecondaryPhoneNbr) {
		if (!brwrRegOthers_SecondaryPhoneNbr.isEmpty()) {
			String[] SecondaryPhNbr = brwrRegOthers_SecondaryPhoneNbr.split("-", -2);
			doIT(BrwrRegOthers_SecondaryPhoneNbr1, SecondaryPhNbr[0]);
			doIT(BrwrRegOthers_SecondaryPhoneNbr2, SecondaryPhNbr[1]);
			doIT(BrwrRegOthers_SecondaryPhoneNbr3, SecondaryPhNbr[2]);
		}
	}

	public String set_BrwrReg_PrimaryPhoneNbr(String reg_Pri_PhNbr) {

		if (reg_Pri_PhNbr.equalsIgnoreCase("Random")) {
			String n1, n2, n3;
			n1 = "987";
			n2 = Helper.getRandomNumeric(3);
			n3 = Helper.getRandomNumeric(4);
			set_BrwrRegPrsnl_PrimaryPhoneNbr1(n1);
			set_BrwrRegPrsnl_PrimaryPhoneNbr2(n2);
			set_BrwrRegPrsnl_PrimaryPhoneNbr3(n3);
			reg_Pri_PhNbr = n1 + n2 + n3;
		} else if (!reg_Pri_PhNbr.isEmpty()) {
			set_BrwrRegPrsnl_PrimaryPhoneNbr(reg_Pri_PhNbr);
		}
		return reg_Pri_PhNbr;
	}

	/*
	 * public void set_BrwrReg_PrimaryPhoneNbr(String reg_Pri_PhNbr) {
	 * 
	 * if (reg_Pri_PhNbr.equalsIgnoreCase("Random")) {
	 * set_BrwrRegPrsnl_PrimaryPhoneNbr1(Helper.getRandomNumeric(3));
	 * set_BrwrRegPrsnl_PrimaryPhoneNbr2(Helper.getRandomNumeric(3));
	 * set_BrwrRegPrsnl_PrimaryPhoneNbr3(Helper.getRandomNumeric(4)); } else if
	 * (!reg_Pri_PhNbr.isEmpty()) {
	 * set_BrwrRegPrsnl_PrimaryPhoneNbr(reg_Pri_PhNbr); } }
	 */

	public void set_BrwrReg_SecondaryPhoneNbr(String reg_Sec_PhNbr) {

		if (reg_Sec_PhNbr.equalsIgnoreCase("Random")) {
			set_BrwrRegOthers_SecondaryPhoneNbr1("986");
			set_BrwrRegOthers_SecondaryPhoneNbr2(Helper.getRandomNumeric(3));
			set_BrwrRegOthers_SecondaryPhoneNbr3(Helper.getRandomNumeric(4));
		} else if (!reg_Sec_PhNbr.isEmpty()) {

			set_BrwrRegOthers_SecondaryPhoneNbr(reg_Sec_PhNbr);
		}

	}

	public String get_BrwrRegPrsnl_ssn1(String data) {
		return doIT(BrwrRegPrsnl_ssn1, data);
	}

	public String get_BrwrRegPrsnl_ssn2(String data) {
		return doIT(BrwrRegPrsnl_ssn2, data);
	}

	public String get_BrwrRegPrsnl_ssn3(String data) {
		return doIT(BrwrRegPrsnl_ssn3, data);
	}

	public String get_custSSN() {

		String s1 = get_BrwrRegPrsnl_ssn1("Get");
		String s2 = get_BrwrRegPrsnl_ssn2("Get");
		String s3 = get_BrwrRegPrsnl_ssn3("Get");
		String s = s1 + "-" + s2 + "-" + s3;
		return s;
		// TODO Auto-generated method stub

	}

}
