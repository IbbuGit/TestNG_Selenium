package testClasses;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import mainClass.base;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.MyHomePage;
import pageClasses.CreateleadPage;


public class CreateLeadTest extends base {
	
	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_CreateLeadForm(LinkedHashMap<String,String>mapdata)
	{

		LoginPage lp=new LoginPage(driver);
		lp.loginApp(mapdata.get("username"),mapdata.get("password"));
		HomePage hp=new HomePage(driver);
		hp.clickcrm();
		MyHomePage mh=new MyHomePage(driver);
		mh.clickCL();
		CreateleadPage cld=new CreateleadPage(driver);
		cld.creatinglead(mapdata);
		cld.clickcreate();
	}

}
