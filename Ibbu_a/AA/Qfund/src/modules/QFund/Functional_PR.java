
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.Functional_PO;
 
public class Functional_PR extends Helper {

	public Functional_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	public void pinExpired() throws Exception {
		Functional_PO objFunctional_PO = new Functional_PO(driver, report);

		objFunctional_PO.get_PINExpired_PageHeader(data("PE_PageHeader"));
		objFunctional_PO.get_PINExpired_PinExpiredMsg(data("PE_PinExpiredMsg"));
		objFunctional_PO.click_PINExpired_ChangePasswordButton(data("PE_ChangePasswordButton"));

		objFunctional_PO.set_PINExpired_NewPin(data("PE_NewPin"));
		objFunctional_PO.set_PINExpired_ConfirmPin(data("PE_ConfirmPin"));
		objFunctional_PO.click_PinExpired_SubmitButton(data("PE_SubmitButton"));

		objFunctional_PO.get_PinExpired_PasswordChangeConfirmMsg(data("PE_PasswordChangeConfirmMsg"));
		objFunctional_PO.click_PinExpired_LoginAgainButton(data("PE_LoginAgainButton"));

	}

	public void homeScreen() throws Exception {
		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		objFunctional_PO.selectFrame(objFunctional_PO.frameTop);
		// objFunctional_PO.VerifyIsDisplayed_HomePage_InfoLink(data("HO_HomeLink"));
		objFunctional_PO.click_Home(data("click_Home"));

		// objFunctional_PO.selectFrame(objFunctional_PO.frameMiddle);
		// assertAreEqual("Homepage Loaded
		// successfully",report,objFunctional_PO.verifyHomepage().trim(),data("VerifyText"));
	}

	public void changePassword() throws Exception {
		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		objFunctional_PO.change_Password(data("Old_pin"), data("New_pin"), data("Confirm_pin"), data("VerifyText"));
		assertAreEqual("Password changed succesfully", report, objFunctional_PO.verifyText(), data("VerifyText"));
	}

}
