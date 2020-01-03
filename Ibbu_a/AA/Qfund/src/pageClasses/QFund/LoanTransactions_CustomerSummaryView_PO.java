package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class LoanTransactions_CustomerSummaryView_PO extends BasePage {
	/**
	 * @author Manish Kumar Pandey
	 *
	 */
	public LoanTransactions_CustomerSummaryView_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[1]")
	private WebElement product_Type;
	
	@FindBy(xpath = "//td[contains(text(),'@gmail.com')]")
	private WebElement email_Id;
	
	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[2]")
	private WebElement loan_Nbr;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[3]")
	private WebElement total_Due;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[4]")
	private WebElement total_Paid;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[5]")
	private WebElement next_Due_Date;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[6]")
	private WebElement payment_Amt_Due;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Total Paid')]]]/tr[3]/td[7]")
	private WebElement check_Card_Nbr;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[4]")
	private WebElement transtion;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[5]")
	private WebElement voided;

	@FindBy(xpath = "//div[@id='all']//tbody[tr[th[contains(text(),'Transaction')]]]/tr[3]/td[9]]")
	private WebElement principal_Fee;

	public String get_product_Type(String sproduct_Type) {
		return doIT(product_Type, sproduct_Type);
	}
	
	public String get_email_Id(String sproduct_Type) {
		return doIT(email_Id, sproduct_Type);
	}

	public String get_loan_Nbr(String sloan_Nbr) {
		return doIT(loan_Nbr, sloan_Nbr);
	}

	public String get_total_Due(String stotal_Due) {
		return  doIT(total_Due, stotal_Due);
	}

	public String get_total_Paid(String stotal_Paid) {
		return doIT(total_Paid, stotal_Paid);
	}

	public void set_next_Due_Date(String snext_Due_Date) {
		doIT(next_Due_Date, snext_Due_Date);
	}

	public String get_payment_Amt_Due(String spayment_Amt_Due) {
		return doIT(payment_Amt_Due, spayment_Amt_Due);
	}

	public void set_check_Card_Nbr(String scheck_Card_Nbr) {
		doIT(check_Card_Nbr, scheck_Card_Nbr);
	}

	public void set_transaction(String stranstion) {
		doIT(transtion, stranstion);
	}

	public void set_voided(String svoided) {
		doIT(voided, svoided);
	}

	public void set_principal_Fee(String sprincipal_Fee) {
		doIT(principal_Fee, sprincipal_Fee);
	}

}
