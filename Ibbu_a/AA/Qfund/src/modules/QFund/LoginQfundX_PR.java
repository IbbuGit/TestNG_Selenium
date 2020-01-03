
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.Functional_PO;
import pageClasses.QFund.LoginQfundX_PO;

public class LoginQfundX_PR extends Helper {

	public LoginQfundX_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
	}

	/*--------------------------------------------------------------------------------------------------
	 * 		Process Name			: loginApplication
	 * 		Test data sheet Name	: loginApplication
	 * 		Description				: This module allow user to login into the application.	
	 * 		Prerequisite			: 1.URL of the application should be valid, 2. Open only in IE with system IP 
	 * 		Verification Points		: Verify User name and store number	
	 * 		Output values			: NA
	 * 		Responsible				: Manish Kumar Pandey	
	 * 		Date Created			: Jul 5, 2018 9:22:45 AM
	 * 		Date Modified			: 
	 *  --------------------------------------------------------------------------------------------------
	 */

	public void onlineData() throws Exception {

	}


	public void loginApplication() throws Exception {
		try {

			LoginQfundX_PO objLoginQfundX_PO = new LoginQfundX_PO(driver, report);
			if (objLoginQfundX_PO.isLoggedIn()) {
				logoutApplication();
			}
			objLoginQfundX_PO.loadURL_QfundXApplication(data("APP_URL"));
			// objLoginQfundX_PO.loadURL_QfundXApplication("https://stackoverflow1.com/");

			String visibleLoginElement = objLoginQfundX_PO.visibleLoginOption();
			if (data("APP_URL").contains("qfund")) {

				//updateDataSheet("APP_URL", data("APP_URL"));

				if (visibleLoginElement.equals("LDAP")) {

					assertAreEqual("Verification Point", report,
							objLoginQfundX_PO.isDisplayed_qfundxsf_LDAPLogin_SigninMessage(), true);

					objLoginQfundX_PO.set_qfundxsf_LDAPLogin_UserName(data("qfundxsf_LDAPLogin_UserName"));
					objLoginQfundX_PO.click_qfundxsf_LDAPLogin_NextButton("Y");

					// objLoginQfundX_PO.get_qfundxsf_LDAPLogin_InvalidUserErrorMessage(data("qfundxsf_LDAPLogin_InvalidUserErrorMessage"));
					// objLoginQfundX_PO.isDisplayed_qfundxsf_LDAPLogin_InvalidUserErrorMessage(data("qfundxsf_LDAPLogin_InvalidUserErrorMessage"));

					assertAreEqual("Verification Point", report,
							objLoginQfundX_PO.get_qfundxsf_LDAPLogin_InvalidUserErrorMessage(
									data("qfundxsf_LDAPLogin_InvalidUserErrorMessage")),
							data("qfundxsf_LDAPLogin_InvalidUserErrorMessage"));

					objLoginQfundX_PO.set_qfundxsf_LDAPLogin_Password(data("qfundxsf_LDAPLogin_Password"));

					objLoginQfundX_PO.click_qfundxsf_LDAPLogin_SignInButton("Y");

					// objLoginQfundX_PO.get_qfundxsf_LDAPLogin_LoginFailedMessage(data("qfundxsf_LDAPLogin_LoginFailedMessage"));
					// objLoginQfundX_PO.isDisplayed_qfundxsf_LDAPLogin_LoginFailedMessage(data("qfundxsf_LDAPLogin_LoginFailedMessage"));

					assertAreEqual("Verification Point", report,
							objLoginQfundX_PO.get_qfundxsf_LDAPLogin_LoginFailedMessage(
									data("qfundxsf_LDAPLogin_LoginFailedMessage")),
							data("qfundxsf_LDAPLogin_LoginFailedMessage"));
				} else if (visibleLoginElement.equals("Page not loaded")) {
					assertAreEqual("Verification failed login page not loaded ", report, true, false);
				}

				assertAreEqual("Verifying CSR page username field filled with valid user ID",report,objLoginQfundX_PO.get_qfundxsf_Login_UserName(), data("qfundxsf_Login_UserName"));

				objLoginQfundX_PO.set_qfundXsf_Login_Password(data("qfundXsf_Login_Password"));
				objLoginQfundX_PO.set_qfundxsf_Login_StoreId(data("qfundxsf_Login_StoreId"));
				/*
				updateDataSheet("UN", data("qfundxsf_Login_UserName"));
				updateDataSheet("PW", data("qfundXsf_Login_Password"));
				updateDataSheet("Store", data("qfundxsf_Login_StoreId"));
				 */
				assertAreEqual("Before submission ",report,objLoginQfundX_PO.isDisplayed_qfundxsf_Login_SubmitButton(), true);

				objLoginQfundX_PO.click_qfundxsf_Login_SubmitButton("Y");

				// objLoginQfundX_PO.set_qfundxsf_Login_LocalIP(data("qfundxsf_Login_LocalIP"));

				// objLoginQfundX_PO.get_qfundxsf_Login_ErrorMessage(data("qfundxsf_Login_ErrorMessage"));
				// objLoginQfundX_PO.isDisplayed_qfundxsf_Login_ErrorMessage(data("qfundxsf_Login_ErrorMessage"));

				assertAreEqual("Verification Point", report,
						objLoginQfundX_PO.get_qfundxsf_Login_ErrorMessage(data("qfundxsf_Login_ErrorMessage")),
						data("qfundxsf_Login_ErrorMessage"));

				LoginClockChecking();
			} else {
				assertAreEqual("Verification Point", report, objLoginQfundX_PO.isDisplayed_AdvanceAmericaLogo(), true);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void LoginClockChecking() throws Exception {

		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		LoginQfundX_PO objLoginQfundX_PO = new LoginQfundX_PO(driver, report);

		String VisibleObjectAfterLogin = objFunctional_PO.getVisibleObjectAfterLogin();

		if (VisibleObjectAfterLogin.toLowerCase().equals("home")) {
			return;
		} else if (VisibleObjectAfterLogin.toLowerCase().equals("clockout")) {
			String s = objFunctional_PO.get_clockoutStoreNo("get");
			objFunctional_PO.click_CO_confirmButton("Click");
			if (objFunctional_PO.isAlertPresent()) {
				objFunctional_PO.acceptAlert();

				if (!s.equals(data("qfundxsf_Login_StoreId"))) {
					objLoginQfundX_PO.loadURL_QfundXApplication(data("APP_URL"));
					if (objLoginQfundX_PO.visibleLoginOption().equals("LDAP")) {
						objLoginQfundX_PO.set_qfundxsf_LDAPLogin_UserName(data("qfundxsf_LDAPLogin_UserName"));
						objLoginQfundX_PO.click_qfundxsf_LDAPLogin_NextButton(data("qfundxsf_LDAPLogin_NextButton"));
					}
					objLoginQfundX_PO.set_qfundxsf_Login_UserName(data("qfundxsf_Login_UserName"));
					objLoginQfundX_PO.set_qfundXsf_Login_Password(data("qfundXsf_Login_Password"));
					objLoginQfundX_PO.set_qfundxsf_Login_StoreId(s);
					objLoginQfundX_PO.click_qfundxsf_Login_SubmitButton(data("qfundxsf_Login_SubmitButton"));

					/*
					 * ClockOut screen
					 */
					try {
						clockOutscreen("", "", "2359");
						objFunctional_PO.click_CI_ClockInButton(data("CI_ClockInButton"));
					} catch (Exception e) {

					}
					clockOutscreen("navigate", "frame", "");

					try {
						/*
						 * ClockIn screen
						 */
						clockInscreen("");

						/*
						 * Do Logout
						 */
						clockOutscreen("navigate", "frame", "");
						if (objFunctional_PO.getAlertText().contains("Out Time should be greater than In Time")) {
							Thread.sleep(600000);
							clockOutscreen("navigate", "frame", "");
						}
					} catch (Exception e) {

					}

					loginApplication();
					return;
				} else {
					clockOutscreen("", "", "2359");
				}
			}

			clockInscreen("navigate");
		} else if (VisibleObjectAfterLogin.toLowerCase().equals("clockin")) {
			clockInscreen("navigate");
		} else if (VisibleObjectAfterLogin.toLowerCase().equals("error")) {
			throw new Exception("Login Failed");
		}
	}

	public void logoutApplication() throws Exception {

		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		objFunctional_PO.selectFrame(objFunctional_PO.frameTop);
		objFunctional_PO.click_Logout("Y");
		Thread.sleep(3000);
	}

	public void clockIn() throws Exception {
		Functional_PO objFunctional_PO = new Functional_PO(driver, report);

		// objFunctional_PO.get_ClockIn_PageHeader(data("CI_PageHeader"));

		// objFunctional_PO.set_ClockIn_ClockInTime(data("CI_ClockInTime"));
		try {
			objFunctional_PO.click_CI_ClockInButton(data("CI_ClockInButton"));
		} catch (Exception e) {

		}
	}

	public void clockOut() throws Exception {

		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		driver.navigate().refresh();

		clockOutscreen("navigate", "frame", "");

		if (objFunctional_PO.isAlertPresent()) {
			if (objFunctional_PO.getAlertText().contains("Out Time should be greater than In Time")) {
				objFunctional_PO.acceptAlert();
				Thread.sleep(10000);
				clockOutscreen("navigate", "frame", "");
			}
		}
		
/*		for (int i = 1; i <= 6; i++) {
			if (objFunctional_PO.isAlertPresent()) {
				if (objFunctional_PO.getAlertText().contains("Out Time should be greater than In Time")) {
					objFunctional_PO.acceptAlert();
					Thread.sleep(10000);
					clockOutscreen("navigate", "frame", "");
				}
			} else {
				break;
			}
		}*/
	}

	public void clockOutscreen(String strNavigate, String strframe, String strTime) throws Exception {

		Functional_PO objFunctional_PO = new Functional_PO(driver, report);
		/*
		 * objFunctional_PO.selectFrame(objFunctional_PO.frameMiddle);
		 * objFunctional_PO.waitForButton();
		 * objFunctional_PO.click_ClockoutconfirmButton("Y");
		 */

		if (strNavigate.equalsIgnoreCase("navigate")) {
			objFunctional_PO.selectFrame(objFunctional_PO.frameTop);
			objFunctional_PO.click_HomePage_ClockOutLink("Click");
		}
		if (strframe.equalsIgnoreCase("frame")) {
			objFunctional_PO.selectFrame(objFunctional_PO.frameMiddle);
		}

		if (!strTime.isEmpty()) {
			objFunctional_PO.set_CO_ClockOutTime(strTime);
		}

		objFunctional_PO.click_CO_confirmButton("Click");
		//updateDataSheet("ClockOut", "Yes");

	}

	public void clockInscreen(String strNavigate) throws Exception {

		Functional_PO objFunctional_PO = new Functional_PO(driver, report);

		if (strNavigate.equalsIgnoreCase("navigate")) {
			objFunctional_PO.click_CI_ClockInButton("Click");
			objFunctional_PO.selectFrame(objFunctional_PO.frameTop);
		}

		objFunctional_PO.click_HomePage_HomeLink("Click");

		//updateDataSheet("ClockIn", "Yes");

	}
}
