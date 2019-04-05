package testClasses;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.Base;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.MyHomePage;

public class LoginTest extends Base {


	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_loginPositiveData(LinkedHashMap<String, String> mapdata) {
		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		lp.loginApp(lp.data.username,lp.data.password);
		MyHomePage hp=new MyHomePage(driver,mapdata.get("MyHomeData"));
		hp.TempMeth(hp.data.temp);;
		
	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_verifyloginbuttontest(LinkedHashMap<String, String> mapdata) {

		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		Assert.assertEquals(lp.loginbutontext(),lp.data.loginButton_text,"verifying login button text");

	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_VerifyLoginErrorMessages(LinkedHashMap<String, String> mapdata) {
		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		lp.loginApp(lp.data.username,lp.data.password);
		Assert.assertEquals(lp.getLoginFailError(),lp.data.errMsg,"verifying login with no user text");

	}

	

}
