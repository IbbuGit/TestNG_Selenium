package pageClasses.QFund;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */
public class LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO extends BasePage {

	public LoanTransaction_NewLoan_LineOfCredit_Confirmation_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//td[input[@name='shareScreenBut']]/input[1]")
	private WebElement yes_Button;

	@FindBy(name = "cancleBut")
	private WebElement no_Button;

	@FindBy(xpath = "//td[contains(text(),'issuing in the name of')]")
	private WebElement confirm_Message;

	@FindBy(xpath = "//input[@onclick='drawScreenRedirect()']")
	private WebElement drawYes_Button;

	@FindBy(xpath = "//input[@value='No']")
	private WebElement drawNo_Button;

	public void click_yes_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(yes_Button));
			doIT(yes_Button, data);
			acceptAlert();
		}
	}

	public void click_no_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(yes_Button));
			doIT(no_Button, data);
		}
	}

	public String get_confirm_Message(String data) {
		return doIT(confirm_Message, data);
	}

	public void acceptPrinterPopUp() throws Exception {
		try {
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
		}
	}

	public void click_drawYes_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(drawYes_Button));
			doIT(drawYes_Button, data);
		}
	}

	public void click_drawNo_Button(String data) {
		if (!data.isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(drawNo_Button));
			doIT(drawNo_Button, data);
		}

	}

	public void waitForDrawYesButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(drawYes_Button)));
	}
}
