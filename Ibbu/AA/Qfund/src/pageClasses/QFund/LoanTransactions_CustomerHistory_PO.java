package pageClasses.QFund;

import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_CustomerHistory_PO extends BasePage {
	/**
	 * @author Manish Kumar Pandey
	 *
	 */
	public LoanTransactions_CustomerHistory_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "Flags")
	private WebElement custHist_Flags;

	@FindBy(xpath = "//input[@value='Notes']")
	private WebElement custHist_Notes;

	@FindBy(xpath = "//input[@value='Customer Summary View']")
	private WebElement custHist_CustomerSummaryView;
	
	@FindBy(xpath = "//tbody[tr[@class='tableheadrow']/td[text()='Loan Nbr']]/tr[5]/td[2]")
	//@FindBy(xpath = "//tbody[tr[td[text()='Loan Nbr']]]/tr[5]/td[2]")
	private WebElement loan_Nbr;
	
	public String get_loan_Nbr(String data) {
		return doIT(loan_Nbr, data);
	}

	public void click_custHist_Flags(String data) {
		doIT(custHist_Flags, data);
	}

	public void click_custHist_Notes(String data) {
		doIT(custHist_Notes, data);
	}

	public void click_custHist_CustomerSummaryView(String data) {
		doIT(custHist_CustomerSummaryView, data);
	}

//	public void click_GoButon(String data) {
//		// String elementString =
//		// "//td[contains(text(),'DYNAMIC_TEXT')]/..//input[@value='Go']";
//		doIT(custHist_Go, data);
//
//	}

	public void switchToFlagwindow() {
		if (wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			parentWindowId = it.next();
			childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			driver.close();
			driver.switchTo().window(parentWindowId);
		}
	}

}
