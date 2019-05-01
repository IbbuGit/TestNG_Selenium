package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class AdminTransactions_Title_PostDefaultTransactions_PO extends BasePage {

	public AdminTransactions_Title_PostDefaultTransactions_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Out To Repo
	 */

	@FindBy(xpath = "//*[contains(text(),'Out To Repo')]")
	private WebElement otr_PageHeader;

	@FindBy(xpath = "//*[contains(text(),'Out To Repo Details')]")
	private WebElement otr_OutToRepoDetailsHeader;

	@FindBy(name = "solvageCompany")
	private WebElement otr_OutToRepoCompany;
	// Consolidated Asset Recovery Services (CARS)
	// ALS/Resolvion
	// Primeritus

	@FindBy(xpath = "//*[contains(text(),'Principal Due')]/../following-sibling::tr/td[1]")
	private WebElement otr_VerifyPrincipalDue;

	@FindBy(xpath = "//*[contains(text(),'Interest Due')]/../following-sibling::tr/td[2]")
	private WebElement otr_VerifyInterestDue;

	@FindBy(xpath = "//*[contains(text(),'Loan Fee Due')]/../following-sibling::tr/td[3]")
	private WebElement otr_VerifyLoanFeeDue;

	@FindBy(xpath = "//*[contains(text(),'Amount Owed')]/../following-sibling::tr/td[12]")
	private WebElement otr_VerifyAmountOwed;

	@FindBy(xpath = "//*[contains(text(),'Out To Repo completed Successfully.')]")
	private WebElement otr_Validation;

	/*
	 * Repossession
	 */

	@FindBy(xpath = "//b[contains(text(),'Repossession')]")
	private WebElement rep_PageHeader;

	@FindBy(name = "requestBean.companyName")
	private WebElement rep_Company;

	@FindBy(name = "requestBean.rpocharge")
	private WebElement rep_RepoFee;

	@FindBy(name = "rpossesdate1")
	private WebElement rep_RepossessedDate1;

	@FindBy(name = "rpossesdate2")
	private WebElement rep_RepossessedDate2;

	@FindBy(name = "rpossesdate3")
	private WebElement rep_RepossessedDate3;

	@FindBy(xpath = "//*[contains(text(),'Transaction Completed Successfully.')]")
	private WebElement repossession_Validation;

	/*
	 * Repossession
	 */

	@FindBy(xpath = "//*[contains(text(),'Void Out To Repo completed Successfully.')]")
	private WebElement repVoid_Validation;

	/*
	 * Auction
	 */

	@FindBy(xpath = "//b[contains(text(),'Auction')]")
	private WebElement auc_PageHeader;

	@FindBy(name = "solvageCompany")
	private WebElement auc_AuctionCompany;
	// CARS

	@FindBy(name = "requestBean.comments")
	private WebElement auc_Comments;

	@FindBy(xpath = "//*[contains(text(),'Transaction completed Successfully.')]")
	private WebElement auc_Validation;

	/*
	 * Sale
	 */

	@FindBy(xpath = "//b[contains(text(),'Sale')]")
	private WebElement sale_PageHeader;

	@FindBy(name = "rpossesdate1")
	private WebElement sale_DateOfSale;

	@FindBy(name = "transactionDataBean.defaultPrincipal")
	private WebElement sale_VerifyDefaultPrincipal;

	@FindBy(name = "transactionDataBean.defaultInterest")
	private WebElement sale_VerifyDefaultInterest;

	@FindBy(name = "transactionDataBean.balanceLoanFee")
	private WebElement sale_VerifyBalanceLoanFee;

	@FindBy(name = "transactionDataBean.repoFeeDue")
	private WebElement sale_VerifyRepoFeeDue;

	@FindBy(name = "requestBean.saleValue")
	private WebElement sale_SaleValue;

	@FindBy(xpath = "//b[contains(text(),'Sale Transaction has  been completed successfully.')]")
	private WebElement sale_Validation;

	/*
	 * Salvage
	 */

	@FindBy(xpath = "//*[contains(text(),'Salvage')]")
	private WebElement slv_PageHeader;

	@FindBy(xpath = "//*[contains(text(),'Salvage Details')]")
	private WebElement slv_SalvageDetailsHeader;

	@FindBy(name = "solvageCompany")
	private WebElement slv_SolvageCompany;
	// Salvage Company220
	// Salvage Company200
	// salvagenew

	@FindBy(name = "rpossesdate1")
	private WebElement sale_DateOfSalvage;

	@FindBy(xpath = "//*[contains(text(),'Principal Due')]/../following-sibling::tr/td[1]")
	private WebElement slv_VerifyPrincipalDue;

	@FindBy(xpath = "//*[contains(text(),'Interest Due')]/../following-sibling::tr/td[2]")
	private WebElement slv_VerifyInterestDue;

	@FindBy(xpath = "//*[contains(text(),'Loan Fee Due')]/../following-sibling::tr/td[3]")
	private WebElement slv_VerifyLoanFeeDue;

	@FindBy(xpath = "//*[contains(text(),'Repo Fee Due')]/../following-sibling::tr/td[5]")
	private WebElement slv_VerifyRepoFeeDue;

	@FindBy(xpath = "//*[contains(text(),'Amount Owed')]/../following-sibling::tr/td[9]")
	private WebElement slv_VerifyAmountOwed;

	@FindBy(name = "requestBean.salvageValue")
	private WebElement slv_SalvageValue;

	@FindBy(name = "requestBean.comments")
	private WebElement slv_Comments;

	@FindBy(xpath = "//*[contains(text(),'Transaction completed Successfully.')]")
	private WebElement slv_Validation;

	/*
	 * Common
	 */

	@FindBy(name = "requestBean.User|empid")
	private WebElement tran_VerifyUserId;

	@FindBy(name = "password")
	private WebElement tran_PIN;

	@FindBy(name = "requestBean.password")
	private WebElement tran_PIN2;

	@FindBy(name = "finish")
	private WebElement tran_SubmitButton;

	@FindBy(xpath = "//input[@value='Finish']")
	private WebElement tran_FinishButton;

	@FindBy(name = "cancel|cancelLoan")
	private WebElement tran_CancelButton;

	@FindBy(name = "history|Submit36")
	private WebElement tran_HistoryButton;

	@FindBy(xpath = "//input[@value='Ok']")
	//@FindBy(xpath = "//input[(@value='OK') and (@type='button')]")
	private WebElement tran_ValidationOKButton;

	@FindBy(xpath = "//input[(@value='OK') and (@type='button')]")
	private WebElement tran_ValidationOKButton2;

	public String get_otr_PageHeader(String TestData_otr_PageHeader) {
		return doIT(otr_PageHeader, TestData_otr_PageHeader);
	}

	public String get_otr_OutToRepoDetailsHeader(String TestData_otr_OutToRepoDetailsHeader) {
		return doIT(otr_OutToRepoDetailsHeader, TestData_otr_OutToRepoDetailsHeader);
	}

	public void set_otr_OutToRepoCompany(String TestData_otr_OutToRepoCompany) {
		doIT(otr_OutToRepoCompany, TestData_otr_OutToRepoCompany);
	}

	public String get_otr_VerifyPrincipalDue(String TestData_otr_VerifyPrincipalDue) {
		return doIT(otr_VerifyPrincipalDue, TestData_otr_VerifyPrincipalDue);
	}

	public String get_otr_VerifyInterestDue(String TestData_otr_VerifyInterestDue) {
		return doIT(otr_VerifyInterestDue, TestData_otr_VerifyInterestDue);
	}

	public String get_otr_VerifyLoanFeeDue(String TestData_otr_VerifyLoanFeeDue) {
		return doIT(otr_VerifyLoanFeeDue, TestData_otr_VerifyLoanFeeDue);
	}

	public String get_otr_VerifyAmountOwed(String TestData_otr_VerifyAmountOwed) {
		return doIT(otr_VerifyAmountOwed, TestData_otr_VerifyAmountOwed);
	}

	public String get_otr_Validation(String TestData_otr_Validation) {
		return doIT(otr_Validation, TestData_otr_Validation);
	}

	public String get_rep_PageHeader(String TestData_rep_PageHeader) {
		return doIT(rep_PageHeader, TestData_rep_PageHeader);
	}

	public void set_rep_Company(String TestData_rep_Company) {
		doIT(rep_Company, TestData_rep_Company);
	}

	public void set_rep_RepoFee(String TestData_rep_RepoFee) {
		doIT(rep_RepoFee, TestData_rep_RepoFee);
	}

	public void set_rep_RepossessedDate(String TestData_rep_RepossessedDate) {
		if (TestData_rep_RepossessedDate != null) {
			
			String[] MMDDYYYY = TestData_rep_RepossessedDate.split("/");
			doIT(rep_RepossessedDate1, MMDDYYYY[0]);
			doIT(rep_RepossessedDate2, MMDDYYYY[1]);
			doIT(rep_RepossessedDate3,"20"+MMDDYYYY[2]);
		}

	}

	public String get_repossession_Validation(String TestData_repossession_Validation) {
		return doIT(repossession_Validation, TestData_repossession_Validation);
	}

	public String get_repVoid_Validation(String TestData_repVoid_Validation) {
		return doIT(repVoid_Validation, TestData_repVoid_Validation);
	}

	public String get_auc_PageHeader(String TestData_auc_PageHeader) {
		return doIT(auc_PageHeader, TestData_auc_PageHeader);
	}

	public void set_auc_AuctionCompany(String TestData_auc_AuctionCompany) {
		doIT(auc_AuctionCompany, TestData_auc_AuctionCompany);
	}

	public void set_auc_Comments(String TestData_auc_Comments) {
		doIT(auc_Comments, TestData_auc_Comments);
	}

	public String get_auc_Validation(String TestData_auc_Validation) {
		return doIT(auc_Validation, TestData_auc_Validation);
	}

	public String get_sale_PageHeader(String TestData_sale_PageHeader) {
		return doIT(sale_PageHeader, TestData_sale_PageHeader);
	}

	public void set_sale_DateOfSale(String TestData_sale_DateOfSale) {
		doIT(sale_DateOfSale, TestData_sale_DateOfSale);
	}

	public void get_sale_VerifyDefaultPrincipal(String TestData_sale_VerifyDefaultPrincipal) {
		doIT(sale_VerifyDefaultPrincipal, TestData_sale_VerifyDefaultPrincipal);
	}

	public void get_sale_VerifyDefaultInterest(String TestData_sale_VerifyDefaultInterest) {
		doIT(sale_VerifyDefaultInterest, TestData_sale_VerifyDefaultInterest);
	}

	public void get_sale_VerifyBalanceLoanFee(String TestData_sale_VerifyBalanceLoanFee) {
		doIT(sale_VerifyBalanceLoanFee, TestData_sale_VerifyBalanceLoanFee);
	}

	public void get_sale_VerifyRepoFeeDue(String TestData_sale_VerifyRepoFeeDue) {
		doIT(sale_VerifyRepoFeeDue, TestData_sale_VerifyRepoFeeDue);
	}

	public void set_sale_SaleValue(String TestData_sale_SaleValue) {
		sale_SaleValue.clear();
		doIT(sale_SaleValue, TestData_sale_SaleValue);
	}

	public String get_sale_Validation(String TestData_sale_Validation) {
		return doIT(sale_Validation, TestData_sale_Validation);
	}

	public String get_slv_PageHeader(String TestData_slv_PageHeader) {
		return doIT(slv_PageHeader, TestData_slv_PageHeader);
	}

	public String get_slv_SalvageDetailsHeader(String TestData_slv_SalvageDetailsHeader) {
		return doIT(slv_SalvageDetailsHeader, TestData_slv_SalvageDetailsHeader);
	}

	public void set_slv_SolvageCompany(String TestData_slv_SolvageCompany) {
		doIT(slv_SolvageCompany, TestData_slv_SolvageCompany);
	}

	public void set_sale_DateOfSalvage(String TestData_sale_DateOfSalvage) {
		doIT(sale_DateOfSalvage, TestData_sale_DateOfSalvage);
	}

	public String get_slv_VerifyPrincipalDue(String TestData_slv_VerifyPrincipalDue) {
		return doIT(slv_VerifyPrincipalDue, TestData_slv_VerifyPrincipalDue);
	}

	public String get_slv_VerifyInterestDue(String TestData_slv_VerifyInterestDue) {
		return doIT(slv_VerifyInterestDue, TestData_slv_VerifyInterestDue);
	}

	public String get_slv_VerifyLoanFeeDue(String TestData_slv_VerifyLoanFeeDue) {
		return doIT(slv_VerifyLoanFeeDue, TestData_slv_VerifyLoanFeeDue);
	}

	public String get_slv_VerifyRepoFeeDue(String TestData_slv_VerifyRepoFeeDue) {
		return doIT(slv_VerifyRepoFeeDue, TestData_slv_VerifyRepoFeeDue);
	}

	public String get_slv_VerifyAmountOwed(String TestData_slv_VerifyAmountOwed) {
		return doIT(slv_VerifyAmountOwed, TestData_slv_VerifyAmountOwed);
	}

	public void set_slv_SalvageValue(String TestData_slv_SalvageValue) {
		doIT(slv_SalvageValue, TestData_slv_SalvageValue);
	}

	public void set_slv_Comments(String TestData_slv_Comments) {
		doIT(slv_Comments, TestData_slv_Comments);
	}

	public String get_slv_Validation(String TestData_slv_Validation) {
		return doIT(slv_Validation, TestData_slv_Validation);
	}

	public String get_tran_VerifyUserId(String TestData_tran_VerifyUserId) {
		return doIT(tran_VerifyUserId, TestData_tran_VerifyUserId);
	}

	public void set_tran_PIN(String TestData_tran_PIN) {
		doIT(tran_PIN, TestData_tran_PIN);
	}

	public void set_tran_PIN2(String TestData_tran_PIN) {
		doIT(tran_PIN2, TestData_tran_PIN);
	}

	public void click_tran_SubmitButton(String TestData_tran_SubmitButton) {
		doIT(tran_SubmitButton, TestData_tran_SubmitButton);
	}
	
	public void click_tran_FinishButton(String TestData_tran_SubmitButton) {
		doIT(tran_FinishButton, TestData_tran_SubmitButton);
	}
	
	public void click_tran_CancelButton(String TestData_tran_CancelButton) {
		doIT(tran_CancelButton, TestData_tran_CancelButton);
	}

	public void click_tran_HistoryButton(String TestData_tran_HistoryButton) {
		doIT(tran_HistoryButton, TestData_tran_HistoryButton);
	}

	public void click_tran_ValidationOKButton(String TestData_tran_ValidationOKButton) {
		doIT(tran_ValidationOKButton, TestData_tran_ValidationOKButton);
	}

	public void click_tran_ValidationOKButton2(String TestData_tran_ValidationOKButton) {
		doIT(tran_ValidationOKButton2, TestData_tran_ValidationOKButton);
	}

}