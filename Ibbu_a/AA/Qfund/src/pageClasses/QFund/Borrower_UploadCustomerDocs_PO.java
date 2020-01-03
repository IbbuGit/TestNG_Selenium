package pageClasses.QFund;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class Borrower_UploadCustomerDocs_PO extends BasePage{

	public Borrower_UploadCustomerDocs_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
		// TODO Auto-generated constructor stub
	}

		@FindBy(xpath = "(//input[@name='scan'])[1]")
		private WebElement CustDocs_Scan;

		@FindBy(xpath = "(//input[@name='scan'])[2]")
		private WebElement CustDocs_Upload;

		/*@FindBy(xpath = "(//input[@value='4761&1'])[2]")
		private WebElement CustDocs_2checkbox;

	
		@FindBy(name = "uploadDocs[1]")
		private WebElement CustDocs_2input;
*/
		@FindBy(name = "Submit1")
		private WebElement Submit_Docs;

		@FindBy(name = "ok")
		private WebElement ok_button;
		
	
		String uploadDocCheckBox="//td[contains(text(), 'DYNAMIC_TEXT')]/preceding-sibling::td/input[@type='checkBox' and not(@disabled)]";
		String uploadDocBrowseBtn="//td[contains(text(), 'DYNAMIC_TEXT')]/following-sibling::td/input[contains(@name,'upload') and not(@disabled)]";
		
		public void click_uploadDocCheckBox(String data ) {
			doIT(getWebElementForDynamicText(uploadDocCheckBox, data),data);
		}
		
		
		
		public void click_uploadDocBrowseBtn(String data) {
			doIT(getWebElementForDynamicText(uploadDocBrowseBtn, data),data);
		}
		
		
		public void uploadDocFor(String data) {
			click_uploadDocCheckBox(data);
			click_uploadDocBrowseBtn(data);
		}
		
		
		public void click_setok_button(String data) {
			doIT(ok_button,data);
		}
		
		
				
		public void click_setSubmit_Docs(String data) {
			doIT(Submit_Docs,data);
		}
		
		
		public void click_setCustDocs_Scan(String data) {
			doIT(CustDocs_Scan,data);
		}


		

		public void click_setCustDocs_Upload(String data) {
			doIT(CustDocs_Upload,data);

			 }


		
		/*public void click_setCustDocs_2checkbox(String data) {
			doIT(CustDocs_2checkbox,data);

			}


		

		public void click_setCustDocs_2input(String data) {
			doIT(CustDocs_2input,data);

			 }


*/	

		public void uploadFile(String Filepath) throws Exception {
			
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}

	
	
}
