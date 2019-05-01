package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class LoanTransactions_TransactionSelection_PO extends BasePage {
	/**
	 * @author Manish Kumar Pandey
	 *
	 */

	protected LinkedHashMap<String, String> ThisPOData;

	public LoanTransactions_TransactionSelection_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	@FindBy(name = "transactionList")
	private WebElement transSel_transactionList;

	@FindBy(name = "button")
	private WebElement transSel_GoButton;

	@FindBy(xpath = "//tr[td[select[@name='transactionList']]]/td[2]")
	private WebElement transSel_GoButton_loc;

	@FindBy(xpath = "//input[@value='Back']")
	private WebElement transSel_BackButton;

	public void selectTransSel_transactionList(String transactionValue) {
		new Select(transSel_transactionList).selectByVisibleText(transactionValue);
	}

	public void click_transSel_GoButton(String data) {
		doIT(transSel_GoButton, data);
	}

	public boolean isDisplayed_click_transSel_GoButton() {
		return isDisplayed(transSel_GoButton);
	}

	public void set_TransSel_transactionList(String data) {
		doIT(transSel_transactionList, data);
	}

	public void click_transSel_GoButton_void(String data) {
		doIT(transSel_GoButton_loc, data);
	}

	public void SendDataHashmap(LinkedHashMap<String, String> data) {
		this.ThisPOData = data;
	}

	public void transactionSelection(String transactionType) throws Exception {
		if (!transactionType.isEmpty()) {
			set_TransSel_transactionList(transactionType);
			selectTransSel_transactionList(transactionType);
/*
			new Helper(driver, ThisPOData, report).assertAreEqual("Before submission ", report,
					isDisplayed_click_transSel_GoButton(), true);
			
*/			click_transSel_GoButton("Click");
		}
	}
}
