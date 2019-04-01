package testClasses;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainClass.base;
import pageClasses.HomePage;
import pageClasses.LoginPage;

public class LoginTest extends base {


	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_loginPositiveData(LinkedHashMap<String, String> mapdata) {
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(mapdata.get("username"),mapdata.get("password"));
		HomePage hp=new HomePage(driver);
		Assert.assertEquals(hp.loginVerification(),true,"verifying login with valid credentials");
	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_verifyloginbuttontest(LinkedHashMap<String, String> mapdata) {

		LoginPage lp=new LoginPage(driver); 
		Assert.assertEquals(lp.loginbutontext(),mapdata.get("loginbutton_text"),"verifying login button text");

	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_VerifyLoginErrorMessages(LinkedHashMap<String, String> mapdata) {
		LoginPage lp=new LoginPage(driver); 
		lp.loginApp(mapdata.get("username"),mapdata.get("password"));
		Assert.assertEquals(lp.getLoginFailError(),mapdata.get("loginPage_ErrorMessage"),"verifying login with no user text");

	}

	

}
