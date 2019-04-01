package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewLeadPage {
	public ViewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  
	@FindBy (id="sectionHeaderTitle_leads") private WebElement viewlead;
	public boolean viewldisdisplay()
	{
		return viewlead.isDisplayed();
	}
	
}
