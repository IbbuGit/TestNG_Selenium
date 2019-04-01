package testClasses;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainClass.base;
import pageClasses.AccountPageCreated;
import pageClasses.CreateAccountPage;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.MyHomePage;

public class CreateAccountTest extends base {

	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_CreateAccount(LinkedHashMap<String,String> mapdata)
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(mapdata.get("username"),mapdata.get("password"));
		HomePage hp=new HomePage(driver);
		hp.clickcrm();
		MyHomePage mh=new MyHomePage(driver);
		mh.clickCA();
		CreateAccountPage ca=new CreateAccountPage(driver);
		ca.creatingAccount(mapdata);
		AccountPageCreated AP=new AccountPageCreated(driver);
		Assert.assertEquals(AP.accountIsDisplayed(),true,"Account created successfuly");
	}
	@Test(dataProvider="ReadCSV_getRowDataForRowName")
	public void test_ParentAccountLinkage(LinkedHashMap<String,String> mapdata)
	{

		LoginPage lp=new LoginPage(driver);
		lp.loginApp(mapdata.get("username"),mapdata.get("password"));
		HomePage hp=new HomePage(driver);
		hp.clickcrm();
		MyHomePage mh=new MyHomePage(driver);
		mh.clickCA();
		CreateAccountPage ca=new CreateAccountPage(driver);
		ca.clickImageIcon();
		switchToChildWindow(2);
		ca.enterFA_AccountID(mapdata.get("accountID"));
		ca.clickFindAccount();
		ca.selectAccountFromAccountListTable(mapdata.get("accountID"));
		switchToDefaultWindow();
		Assert.assertEquals(ca.parentAccountReturn(),mapdata.get("accountID"));
	}
	public void test_DuplicatesInDropdownIndustry()
	{
		
	}
}
