package pageClasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	ChromeDriver driver=new ChromeDriver();
	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	@FindBy(id="accountName") private WebElement accountName;
	public void enterAccountName(String data)
	{
		accountName.sendKeys(data+ new Random().nextInt(10000));
	}
	@FindBy(id="groupNameLocal")private WebElement localName;
	public void enterLocalName(String data)
	{
		localName.sendKeys(data);
	}
	@FindBy(id="annualRevenue")private WebElement annualRevenue;
	public void enterAnnualRevenue(String data)
	{
		annualRevenue.sendKeys(data);
	}
	@FindBy(name="industryEnumId") private WebElement industry;
	public void selectIndustry(String data)
	{
		Select SI=new Select(industry);
		SI.selectByVisibleText(data);

	}
	public List<String> getIndustryMenuOptions()
	{
		Select SI1=new Select(industry);
		List<WebElement> l1=SI1.getOptions();
		List<String> l2=new ArrayList<String>();
		l2.add(l1.get(0).getText());
	//	for(List<String> l2:(l1.get(0).getText()))
		return l2;
	}

	/*	@FindBy(name="ownershipEnumId") private WebElement ownerShip;
	public void selectOwnerShip(String data)
	{
		Select SO=new Select(ownerShip);
		SO.selectByVisibleText(data);
	}*/

	@FindBy(id="primaryPhoneAreaCode") private WebElement areaCode;
	public void enterAreaCode(String data)
	{
		areaCode.sendKeys(data);
	}
	@FindBy(id="primaryEmail") private WebElement eMail;
	public void enterEmail(String data)
	{
		eMail.sendKeys(data);
	}
	@FindBy(id="primaryPhoneNumber") private WebElement phoneNum;
	public void enterPhoneNum(String data)
	{
		phoneNum.sendKeys(data);
	}
	@FindBy(id="primaryWebUrl") private WebElement webUrl;
	public void enterUrl(String data) 
	{
		webUrl.sendKeys(data);
	}
	@FindBy(id="generalAddress1") private WebElement address;
	public void enterAddress(String data)
	{
		address.sendKeys(data);
	}
	@FindBy(id="generalCity") private WebElement city;
	public void enterCity(String data)
	{
		city.sendKeys(data);
	}
	@FindBy(id="generalPostalCode") private WebElement postalCode;
	public void enterPostalcode(String data)
	{
		postalCode.sendKeys(data);
	}
	@FindBy(id="generalCountryGeoId") private WebElement Country;
	public void selectCountry(String data)
	{
		Select SC=new Select(Country);
		SC.selectByValue(data);
		
	}
	@FindBy(id="generalStateProvinceGeoId") private WebElement state;
	public void selectstate(String data)
	{
		Select SS=new Select(state);
		SS.selectByValue(data);
	}
	@FindBy(className="smallSubmit") private WebElement createAccount;
	public void clickCreateAccount()
	{
		createAccount.click();	
	}
	@FindBy(xpath="//img[@alt='Lookup']/..") private WebElement image;
	public void clickImageIcon()
	{
		image.click();
	}
	@FindBy(name="id") private WebElement fa_AccID;
	public void enterFA_AccountID(String data)
	{
		fa_AccID.sendKeys(data);
	}
	@FindBy(className="x-btn-center") private WebElement findAccount;
	public void clickFindAccount()
	{
		findAccount.click();
	}

	public void selectAccountFromAccountListTable(String data) 
	{
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();		
	}
	@FindBy(className="inputBox") private WebElement parentAccount;
	public String parentAccountReturn()
	{
		return parentAccount.getText();
	}
	public void creatingAccount(LinkedHashMap<String,String> mapdata)
	{
		enterAccountName(mapdata.get("accountName"));
		enterLocalName(mapdata.get("localName"));
		enterAnnualRevenue(mapdata.get("annualRevenue"));
		selectIndustry(mapdata.get("industry"));
		//	selectOwnerShip(mapdata.get("ownerShip"));
		enterAreaCode(mapdata.get("areaCode"));
		enterEmail(mapdata.get("eMail"));
		enterPhoneNum(mapdata.get("phoneNum"));
		enterUrl(mapdata.get("webUrl"));
		enterAddress(mapdata.get("address"));
		enterCity(mapdata.get("city"));
		enterPostalcode(mapdata.get("postalCode"));
		selectCountry(mapdata.get("Country"));
		selectstate(mapdata.get("state"));
		clickCreateAccount();
	}
	
	public List<String> menuDisplay()
	{
		List<String> l=new ArrayList<String>();
		l.add("ibbu");
		l.add("saki");
		return l;

	}


}

