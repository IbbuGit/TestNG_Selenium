package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class AdminTransaction_Drawer_Dessign_PO extends BasePage {

	public AdminTransaction_Drawer_Dessign_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);

	}

	@FindBy(id = "500000")
	private WebElement AdminTransactionsTabButton;

	@FindBy(id = "500000")
	private WebElement AdminTransactionsTab_BorrowerButton;

	@FindBy(id = "502070")
	private WebElement AdminTransactionsTab_BorrowerDrawerDessignButton;

	@FindBy(name = "requestBean.locationNbr")
	private WebElement BorrowerDrawerDessign_StoreNo;
	
	@FindBy(name = "requestBean.locationNbr")
	private WebElement BorrowerSaferDessign_StoreNo;

	@FindBy(name = "Submit2")
	private WebElement BorrowerDrawerDessign_SubmitButton;
	
	@FindBy(name = "Submit2")
	private WebElement BorrowerSafeDessign_SubmitButton;

	@FindBy(xpath = "//input[contains(@onlick,'drawerDeassign')]")
	public WebElement BorrowerDrawerDessign_DrawerGoButton;
	
	@FindBy(xpath = "//input[contains(@onlick,'drawerDeassign')]")
	public WebElement BorrowerSafeDessign_SafeGoButton;

	public void click_AdminTransactionsTabButton(String data) {
		doIT(AdminTransactionsTabButton, data);
	}

	public void click_AdminTransactionsTab_BorrowerButton(String data) {
		doIT(AdminTransactionsTab_BorrowerButton, data);
	}

	public void click_AdminTransactionsTab_BorrowerDrawerDessignButton(String data) {
		doIT(AdminTransactionsTab_BorrowerDrawerDessignButton, data);
	}

	public void set_BorrowerDrawerDessign_StoreNo(String sBorrowerDrawerDessign_StoreNo) {
		doIT(BorrowerDrawerDessign_StoreNo, sBorrowerDrawerDessign_StoreNo);
	}

	public void click_BorrowerDrawerDessign_SubmitButton(String data) {
		doIT(BorrowerDrawerDessign_SubmitButton, data);
	}

	public void click_BorrowerDrawerDessign_DrawerGoButton(String data) {
		doIT(BorrowerDrawerDessign_DrawerGoButton, data);
	}
	
	

}
