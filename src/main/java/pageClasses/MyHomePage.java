package pageClasses;

import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.bean.CsvToBeanBuilder;

import testDataTypes.MyHomeData;

public class MyHomePage {
	public MyHomeData data;
	
	public MyHomePage(WebDriver driver,String dataScenario)
	{		
		PageFactory.initElements(driver,this);
		try {
			data=new CsvToBeanBuilder<MyHomeData>(new FileReader("testDataSource\\pageData\\MyHomeData.csv")).withType(MyHomeData.class).build().parse()
					.stream().filter(x -> x.dataScenarios.equalsIgnoreCase(dataScenario)).findAny().get();
		}catch (Exception e) {e.printStackTrace();}

	}

	@FindBy(xpath="//ul[@class='shortcuts']/li") private List<WebElement> shortCuts;
	public List<WebElement> shortcutList()
	{
		return shortCuts;

	}
	@FindBy(linkText="Create Lead") private WebElement createLead;
	public void clickCL()
	{
		createLead.click();

	}
	@FindBy(linkText="Create Account") private WebElement createAccount;
	public void clickCA()
	{
		createAccount.click();
	}
	
	public void TempMeth(String data)
	{
		System.out.println(data);
	}
}
