package stepDefenition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;

import org.junit.Assert;
import managers.FileReaderManager;
import pageObjects.LoginPage;
import testDataTypes.LoginData; 

public class LoginSteps {

	TestContext testContext;
	LoginPage login;

	public LoginSteps(TestContext context) {
		testContext = context;
		login = testContext.getPageObjectManager().getLoginPage();
	}

	@Then("^Login to Contact center application Using \"([^\"]*)\"$")
	public void login_to_Contact_center_application_Using_UserName_and_Password(String loginDataScenario) {		
		LoginData loginData = FileReaderManager.getInstance().getCsvReader().getLoginDataByScenario(loginDataScenario);
		login.loginApp(loginData);
		testContext.getScenarioContext().setContext(Context.USER_NAME,loginData.username);		
	}

	@Then("^Verify Login$")
	public void verify_Login() {
		Assert.assertEquals("verifying login", testContext.getScenarioContext().getContext(Context.USER_NAME), login.getVerifyUserName());
	}	

}
