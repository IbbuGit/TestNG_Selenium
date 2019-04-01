package testClasses;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mainClass.base;
import pageClasses.CreateleadPage;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.MyHomePage;

public class basicTests extends base{

	@Test(enabled=true)
	public void test_listShortcutNames(){

		LoginPage lp=new LoginPage(driver);
		lp.loginApp("DemoSalesManager","crmsfa");
		HomePage hp=new HomePage(driver);
		try
		{
			hp.clickcrm();		  

		}
		catch(Exception e)
		{
			lp.loginApp("DemoSalesManager1","crmsfa");
			hp.clickcrm();
		}
		MyHomePage mh=new MyHomePage(driver);
		List<WebElement> ls=mh.shortcutList();
		for(WebElement ele:ls)
		{
			System.out.println(ele.getText());
		}	

	}

	@Test(enabled=true)
	public void test_DisplayCreateLead()
	{

		LoginPage lp=new LoginPage(driver);
		lp.loginApp("DemoSalesManager","crmsfa1");
		HomePage hp=new HomePage(driver);
		hp.clickcrm();
		MyHomePage mh=new MyHomePage(driver);
		mh.clickCL();
		CreateleadPage cld=new CreateleadPage(driver);
		Assert.assertEquals(cld.CLDisplay(),true,"Verifying lead page landed properly");

	}

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
//	@Test(enabled=true,groups= {"Important"},dependsOnMethods= {"test_DisplayCreateLead"})	
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
	//	viewLead vl=new viewLead(driver);
		//Assert.assertEquals(vl.viewldisdisplay(),true,"ViewLead is displayed");

	}
	
	@Parameters({"username","password"})
	@Test(enabled=false,groups= {"Important"})
	public void test_loginPositiveData1(String Username,String Password) {

		LoginPage lp=new LoginPage(driver);
		lp.loginApp(Username,Password);
		HomePage hp=new HomePage(driver);
		Assert.assertEquals(hp.loginVerification(),true,"verifying login with valid credentials");
	}
	
	@Parameters({"username","password"})
	@Test(enabled=false)	
	public void test_VerifyAppDownErrorMessage(String uname,String pword) {

		LoginPage lp=new LoginPage(driver);
		lp.loginApp(uname,pword);
		Assert.assertEquals(lp.displayAppDownError(),true,"verifying application downtime message");
	}
}
