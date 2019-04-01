package pageClasses;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateleadPage {
	
	public CreateleadPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//div[@id=\"sectionHeaderTitle_leads\"]") private WebElement createlead;
	public boolean CLDisplay() 
	{
			return createlead.isDisplayed();
	}
	
	@FindBy (id="createLeadForm_companyName") private WebElement companyName;
	public void entercompanyname(String data)
	{
		companyName.sendKeys(data);		
	}
	
	@FindBy (id="createLeadForm_firstName") private WebElement firstname;
	public void enterfirstname(String data)
	{
		firstname.sendKeys(data);
	}
	
	@FindBy (id="createLeadForm_lastName") private WebElement lastname;
	public void enterlastname(String data)
	{
		lastname.sendKeys(data);
	}
	
	@FindBy (id="createLeadForm_dataSourceId") private WebElement source;
	public void selectSource( String data)
	{
		Select ss1=new Select(source);
		ss1.selectByVisibleText(data);
	}

	@FindBy (id="createLeadForm_firstNameLocal") private  WebElement  fname;
	public void enterfname(String data)
	{
		fname.sendKeys(data);
	}
	
	@FindBy (id="createLeadForm_lastNameLocal") private WebElement lname;
	public void enterlname(String data)
	{
		lname.sendKeys(data);
	}
	
	@FindBy (id="createLeadForm_generalProfTitle") private WebElement salutation;
	public void entersalutation(String data)
	{
		salutation.sendKeys(data);
	}
	
	@FindBy (name="description") private WebElement descript;
	public void enterdescription(String data)
	{
		descript.sendKeys(data);
	}
	
	@FindBy (name="importantNote") private WebElement note;
	public void enternote(String data)
	{
		note.sendKeys(data);
	}
	
	@FindBy (id="createLeadForm_primaryPhoneNumber") private WebElement phonenumber;
	public void enterphnnum(String string)
	{
		phonenumber.sendKeys(string);	
	}
	
	@FindBy (name="primaryWebUrl") private WebElement url;
	public void enterurl(String data) 
	{
	
		url.sendKeys(data);
	}
	
	@FindBy (name="generalCity") private WebElement city;
	public void entercity(String data)
	{
		city.sendKeys(data);
	}
	
	@FindBy (name="submitButton") private WebElement createld;
	public void clickcreate()
	{
		createld.click();
	}
	public void creatinglead(LinkedHashMap<String,String> mapdata)
	{
		entercompanyname(mapdata.get("companyName"));
		enterfirstname(mapdata.get("firstName"));
		enterlastname(mapdata.get("lastName"));
		selectSource(mapdata.get("source"));
		enterfname(mapdata.get("fName"));
		enterlname(mapdata.get("lName"));
		entersalutation(mapdata.get("salutation"));
		enterdescription(mapdata.get("description"));
		enternote(mapdata.get("note"));
		enterphnnum(mapdata.get("phoneNum"));
		enterurl(mapdata.get("url"));
		entercity(mapdata.get("city"));
	}
}