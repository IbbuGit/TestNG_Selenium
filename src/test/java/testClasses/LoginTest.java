package testClasses;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import core.Base;
import pageClasses.LoginPage;
import pageClasses.MyHomePage;

public class LoginTest extends Base {


	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_loginPositiveData(LinkedHashMap<String, String> mapdata) {
		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		lp.loginApp(lp.data.username,lp.data.password);
		MyHomePage hp=new MyHomePage(driver,mapdata.get("MyHomeData"));
		hp.TempMeth(hp.data.temp);		
	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_verifyloginbuttontest(LinkedHashMap<String, String> mapdata) throws Exception {

		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		assertAreEqual("verifying login button text",lp.loginbutontext(),lp.data.loginButton_text+"123");

	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_VerifyLoginErrorMessages(LinkedHashMap<String, String> mapdata) throws Exception {
		LoginPage lp=new LoginPage(driver,mapdata.get("LoginData"));
		lp.loginApp(lp.data.username,lp.data.password);
		assertAreEqual("verifying login with no user text",lp.getLoginFailError(),lp.data.errMsg);
	}

	

}
