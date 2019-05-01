package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;

public class CustomerLoanHistory_PO extends BasePage {

	public CustomerLoanHistory_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);
	}

	/*
	 * Customer Information
	 */

	@FindBy(xpath = "//td[@class='formHeading']")
	private WebElement th_Header;

	public boolean verifyPage_Header() {
		return th_Header.isDisplayed();
	}

	@FindBy(xpath = "//b[contains(text(),'Customer Information')]")
	private WebElement th_CustomerInformation;

	@FindBy(xpath = "(//span/b[contains(text(),'Customer')]/../following-sibling::span)[1]")
	private WebElement history_CustomerName;

	@FindBy(xpath = "//span/b[contains(text(),'Customer Nbr')]/../following-sibling::span")
	private WebElement history_CustomerNbr;

	@FindBy(xpath = "//span/b[contains(text(),'SSN / ITIN')]/../following-sibling::span")
	private WebElement history_SsnNumber;

	@FindBy(xpath = "//td//span/[text()='Primary Phone Nbr')//following-sibling::span")
	private WebElement history_PrimaryPhoneNumber;

	@FindBy(xpath = "//span/b[contains(text(),'Phone Type')]/../following-sibling::span")
	private WebElement history_PhoneType;

	@FindBy(xpath = "//span/b[contains(text(),'State')]/../following-sibling::span")
	private WebElement history_State;

	@FindBy(xpath = "//td//span/[text()='Email')//following-sibling::span")
	private WebElement history_Email;

	@FindBy(xpath = "//span/b[contains(text(),'Customer Type')]/../following-sibling::span")
	private WebElement history_CustomerType;

	@FindBy(xpath = "//span/b[contains(text(),'Migration Source')]/../following-sibling::span")
	private WebElement history_MigrationSource;

	public String get_History_CustomerName(String data) {
		return doIT(history_CustomerName, "y");
	}

	public String get_History_CustomerNbr(String data) {
		return doIT(history_CustomerNbr, "y");
	}

	public String get_History_SsnNumber(String data) {
		return doIT(history_SsnNumber, "y");
	}

	public String get_History_PrimaryPhoneNumber(String data) {
		return doIT(history_PrimaryPhoneNumber, "y").replace("(", "").replace(")","").replace("-", "");
	}

	public String get_History_PhoneType(String data) {
		return doIT(history_PhoneType, "y");
	}

	public String get_History_State(String data) {
		return doIT(history_State, "y");
	}

	public String get_History_Email(String data) {
		return doIT(history_Email, "y");
	}

	public String get_History_CustomerType(String data) {
		return doIT(history_CustomerType, "y");
	}

	public String get_History_MigrationSource(String data) {
		return doIT(history_MigrationSource, "y");
	}

	/*
	 * Bank Information
	 */

	@FindBy(xpath = "//b[contains(text(),'Bank Information')]")
	private WebElement th_BankInformation;

	@FindBy(xpath = "//span/b[contains(text(),'Loan ABA/Routing Nbr')]/../following-sibling::span")
	private WebElement history_LoanABARoutingNbr;

	@FindBy(xpath = "//span/b[contains(text(),'ABA/Routing Nbr')]/../following-sibling::span")
	private WebElement history_ABARoutingNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Type Of Account')]/../following-sibling::span")
	private WebElement history_TypeOfAccount;

	@FindBy(xpath = "//span/b[contains(text(),'Account Nbr')]/../following-sibling::span")
	private WebElement history_AccountNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Account Nbr')]/../following-sibling::span")
	private WebElement history_LoanAccountNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Check Nbr')]/../following-sibling::span")
	private WebElement history_CheckNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Account Status')]/../following-sibling::span")
	private WebElement history_AccountStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Bank Name')]/../following-sibling::span")
	private WebElement history_BankName;

	public String get_History_TypeOfAccount(String data) {
		return doIT(history_TypeOfAccount, "y");
	}

	public String get_History_AccountNbr(String data) {
		return doIT(history_AccountNbr, "y");
	}

	public String get_History_LoanAccountNbr(String data) {
		return doIT(history_LoanAccountNbr, "y");
	}

	public String get_History_ABARoutingNbr(String data) {
		return doIT(history_ABARoutingNbr, "y");
	}

	public String get_History_LoanABARoutingNbr(String data) {
		return doIT(history_LoanABARoutingNbr, "y");
	}

	public String get_History_CheckNbr(String data) {
		return doIT(history_CheckNbr, "y");
	}

	public String get_History_AccountStatus(String data) {
		return doIT(history_AccountStatus, "y");
	}

	public boolean verifyVisibilityOfhistory_AccountStatus() {
		return history_CustomerName.isDisplayed();
	}

	public String get_History_BankName(String data) {
		return doIT(history_BankName, "y");
	}

	/*
	 * Underwriting Information
	 */

	@FindBy(xpath = "//b[contains(text(),'Underwriting Information')]")
	private WebElement th_UnderwritingInformation;

	@FindBy(xpath = "//span/b[contains(text(),'Veritec Tran Nbr')]/../following-sibling::span")
	private WebElement history_VeritecTranNbr;

	@FindBy(xpath = "//span/b[contains(text(),'MLA Status')]/../following-sibling::span")
	private WebElement history_MLAStatus;

	@FindBy(xpath = "//span/b[contains(text(),'OFAC Status')]/../following-sibling::span")
	private WebElement history_OFACStatus;

	public String get_History_VeritecTranNbr(String data) {
		return doIT(history_VeritecTranNbr, "y");
	}

	public String get_History_MLAStatus(String data) {
		return doIT(history_MLAStatus, "y");
	}

	public String get_History_OFACStatus(String data) {
		return doIT(history_OFACStatus, "y");
	}

	/*
	 * Promotion/Coupon Info
	 */

	@FindBy(xpath = "//span/b[contains(text(),'Promotion/Coupon Info')]")
	private WebElement th_PromotionCouponInfo;

	// Promotion/Coupon Info
	@FindBy(xpath = "//span/b[contains(text(),'Campaign Name')]/../following-sibling::span")
	private WebElement history_CampaignName;

	@FindBy(xpath = "//span/b[contains(text(),'Promotion/Coupon Code')]/../following-sibling::span")
	private WebElement history_PromotionCouponCode;

	public String get_History_CampaignName(String data) {
		return doIT(history_CampaignName, "y");
	}

	public String get_History_PromotionCouponCode(String data) {
		return doIT(history_PromotionCouponCode, "y");
	}

	/*
	 * Co-Owner Information
	 */

	@FindBy(xpath = "//b[contains(text(),'Co-Owner Information')]")
	private WebElement th_CoOwnerInformation;

	// Promotion/Coupon Info
	@FindBy(xpath = "//span/b[contains(text(),'Name')]/../following-sibling::span")
	private WebElement history_Name;

	@FindBy(xpath = "//span/b[contains(text(),'SSN / ITIN')]/../following-sibling::span")
	private WebElement history_SSNITIN;

	/*
	 * Employer Information
	 */

	@FindBy(xpath = "//span/b[contains(text(),'Employer Information')]")
	private WebElement th_EmployerInformation;

	@FindBy(xpath = "//span/b[contains(text(),'Primary Source Of Income')]/../following-sibling::span")
	private WebElement history_PrimarySourceOfIncome;

	@FindBy(xpath = "//span/b[contains(text(),'Current Employer')]/../following-sibling::span")
	private WebElement history_CurrentEmployer;

	@FindBy(xpath = "//span/b[contains(text(),'Net Pay')]/../following-sibling::span")
	private WebElement history_NetPay;

	@FindBy(xpath = "//span/b[contains(text(),'Gross Pay')]/../following-sibling::span")
	private WebElement history_GrossPay;

	//@FindBy(xpath = "//span/b[contains(text(),'Pay Frequency')]/../following-sibling::span")
	@FindBy(xpath = "//td//span/[text()='Pay Frequency')//following-sibling::span")

	private WebElement history_PayFrequency;

	@FindBy(xpath = "//span/b[contains(text(),'Employer Phone Nbr')]/../following-sibling::span")
	private WebElement history_EmployerPhoneNbr;

	public String get_History_PrimarySourceOfIncome(String data) {
		return doIT(history_PrimarySourceOfIncome, "y");
	}

	public String get_History_CurrentEmployer(String data) {
		return doIT(history_CurrentEmployer, "y");
	}

	public String get_History_NetPay(String data) {
		return doIT(history_NetPay, "y");
	}

	public String get_History_GrossPay(String data) {
		return doIT(history_GrossPay, "y");
	}

	public String get_History_PayFrequency(String data) {
		return doIT(history_PayFrequency, "y");
	}

	public String get_History_EmployerPhoneNbr(String data) {
		return doIT(history_EmployerPhoneNbr, "y");
	}

	/*
	 * Courtesy/Collection information
	 */

	@FindBy(xpath = "//b[contains(text(),'Courtesy/Collection information')]")
	private WebElement th_CourtesyCollectionInformation;

	@FindBy(xpath = "//span/b[contains(text(),'Courtesy Consent')]/../following-sibling::span")
	private WebElement history_CourtesyConsent;

	@FindBy(xpath = "//span/b[contains(text(),'Consent Type')]/../following-sibling::span")
	private WebElement history_ConsentType;

	@FindBy(xpath = "//span/b[contains(text(),'Status')]/../following-sibling::span")
	private WebElement history_Status;

	@FindBy(xpath = "//span/b[contains(text(),'Assigned to')]/../following-sibling::span")
	private WebElement history_AssignedTo;

	@FindBy(xpath = "//span/b[contains(text(),'CAD flag')]/../following-sibling::span")
	private WebElement history_CADflag;

	@FindBy(xpath = "//span/b[contains(text(),'DMC details')]/../following-sibling::span")
	private WebElement history_DMCdetails;

	@FindBy(xpath = "//span/b[contains(text(),'DMCCustomer')]/../following-sibling::span")
	private WebElement history_DMCCustomer;

	@FindBy(xpath = "//span/b[contains(text(),'DMC Company')]/../following-sibling::span")
	private WebElement history_DMCCompany;

	@FindBy(xpath = "//span/b[contains(text(),'DMC Phone')]/../following-sibling::span")
	private WebElement history_DMCPhone;

	@FindBy(xpath = "//span/b[contains(text(),'Legal Date')]/../following-sibling::span")
	private WebElement history_LegalDate;

	@FindBy(xpath = "//span/b[contains(text(),'Is Legal')]/../following-sibling::span")
	private WebElement history_IsLegal;

	@FindBy(xpath = "//span/b[contains(text(),'Garnishment Date')]/../following-sibling::span")
	private WebElement history_GarnishmentDate;

	@FindBy(xpath = "//span/b[contains(text(),'Is Garnishment')]/../following-sibling::span")
	private WebElement history_IsGarnishment;

	public String get_History_CourtesyConsent(String data) {
		return doIT(history_CourtesyConsent, "y");
	}

	public String get_History_ConsentType(String data) {
		return doIT(history_ConsentType, "y");
	}

	public String get_History_Status(String data) {
		return doIT(history_Status, "y");
	}

	public String get_History_AssignedTo(String data) {
		return doIT(history_AssignedTo, "y");
	}

	public String get_History_CADflag(String data) {
		return doIT(history_CADflag, "y");
	}

	public String get_History_DMCdetails(String data) {
		return doIT(history_DMCdetails, "y");
	}

	public String get_History_DMCCustomer(String data) {
		return doIT(history_DMCCustomer, "y");
	}

	public String get_History_DMCCompany(String data) {
		return doIT(history_DMCCompany, "y");
	}

	public String get_History_DMCPhone(String data) {
		return doIT(history_DMCPhone, "y");
	}

	public String get_History_LegalDate(String data) {
		return doIT(history_LegalDate, "y");
	}

	public String get_History_IsLegal(String data) {
		return doIT(history_IsLegal, "y");
	}

	public String get_History_GarnishmentDate(String data) {
		return doIT(history_GarnishmentDate, "y");
	}

	public String get_History_IsGarnishment(String data) {
		return doIT(history_IsGarnishment, "y");
	}

	/*
	 * Loan Account Status
	 */

	@FindBy(xpath = "//b[contains(text(),'Loan Account Status')]")
	private WebElement th_LoanAccountStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Status')]/../following-sibling::span")	
	//@FindBy(xpath = "//td//span[text()='Loan Status']//following-sibling::span")
	private WebElement history_LoanStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Check Status')]/../following-sibling::span")
	private WebElement history_CheckStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Balance Status')]/../following-sibling::span")
	private WebElement history_BalanceStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Due Date')]/../following-sibling::span")
	private WebElement history_NextDueDate;

	@FindBy(xpath = "//span/b[contains(text(),'Future Deposit Date')]/../following-sibling::span")
	private WebElement history_FutureDepositDate;

	@FindBy(xpath = "//span/b[contains(text(),'Latest Payment Date')]/../following-sibling::span")
	private WebElement history_LatestPaymentDate;

	@FindBy(xpath = "//span/b[contains(text(),'Re-Deposit Count')]/../following-sibling::span")
	private WebElement history_ReDepositCount;

	@FindBy(xpath = "//span/b[contains(text(),'Default Date')]/../following-sibling::span")
	private WebElement history_DefaultDate;

	@FindBy(xpath = "//span/b[contains(text(),'Write Off Date')]/../following-sibling::span")
	private WebElement history_WriteOffDate;

	@FindBy(xpath = "//span/b[contains(text(),'Pending Bankruptcy')]/../following-sibling::span")
	private WebElement history_PendingBankruptcy;

	@FindBy(xpath = "//span/b[contains(text(),'Bankruptcy Filling Date')]/../following-sibling::span")
	private WebElement history_BankruptcyFillingDate;

	@FindBy(xpath = "//span/b[contains(text(),'Bankruptcy Status')]/../following-sibling::span")
	private WebElement history_BankruptcyStatus;

	@FindBy(xpath = "//span/b[contains(text(),'Dismissed/Discharge Date')]/../following-sibling::span")
	private WebElement history_DismissedDischargeDate;

	public String get_History_LoanStatus(String data) {
		return doIT(history_LoanStatus, "y");
	}

	public String get_History_CheckStatus(String data) {
		return doIT(history_CheckStatus, "y");
	}

	public String get_History_BalanceStatus(String data) {
		return doIT(history_BalanceStatus, "y");
	}

	public String get_History_NextDueDate(String data) {
		return doIT(history_NextDueDate, "y");
	}

	public String get_History_FutureDepositDate(String data) {
		return doIT(history_FutureDepositDate, "y");
	}

	public String get_History_LatestPaymentDate(String data) {
		return doIT(history_LatestPaymentDate, "y");
	}

	public String get_History_ReDepositCount(String data) {
		return doIT(history_ReDepositCount, "y");
	}

	public String get_History_DefaultDate(String data) {
		return doIT(history_DefaultDate, "y");
	}

	public String get_History_WriteOffDate(String data) {
		return doIT(history_WriteOffDate, "y");
	}

	public String get_History_PendingBankruptcy(String data) {
		return doIT(history_PendingBankruptcy, "y");
	}

	public String get_History_BankruptcyFillingDate(String data) {
		return doIT(history_BankruptcyFillingDate, "y");
	}

	public String get_History_BankruptcyStatus(String data) {
		return doIT(history_BankruptcyStatus, "y");
	}

	public String get_History_DismissedDischargeDate(String data) {
		return doIT(history_DismissedDischargeDate, "y");
	}

	/*
	 * Loan Balance Summary
	 */

	@FindBy(xpath = "//b[contains(text(),'Loan Balance Summary')]")
	private WebElement th_LoanBalanceSummary;

	@FindBy(xpath = "//span/b[contains(text(),'Principal Balance')]/../following-sibling::span")
	private WebElement history_PrincipalBalance;

	@FindBy(xpath = "//span/b[contains(text(),'Fee Due')]/../following-sibling::span")
	private WebElement history_FeeDue;

	@FindBy(xpath = "//span/b[contains(text(),'Return Fee Due')]/../following-sibling::span")
	private WebElement history_ReturnFeeDue;

	@FindBy(xpath = "//span/b[contains(text(),'Late Fee Due')]/../following-sibling::span")
	private WebElement history_LateFeeDue;

	@FindBy(xpath = "//span/b[contains(text(),'Pay-Off Amt')]/../following-sibling::span")
	private WebElement history_PayOffAmt;

	public String get_History_PrincipalBalance(String data) {
		return doIT(history_PrincipalBalance, "y");
	}

	public String get_History_FeeDue(String data) {
		return doIT(history_FeeDue, "y");
	}

	public String get_History_ReturnFeeDue(String data) {
		return doIT(history_ReturnFeeDue, "y");
	}

	public String get_History_LateFeeDue(String data) {
		return doIT(history_LateFeeDue, "y");
	}

	/*
	 * Loan Paid To-Date Summary
	 */

	@FindBy(xpath = "//b[contains(text(),'Loan Paid To-Date Summary')]")
	private WebElement th_LoanPaidToDateSummary;

	@FindBy(xpath = "//span/b[contains(text(),'Principal Paid to date')]/../following-sibling::span")
	private WebElement history_PrincipalPaidToDate;

	@FindBy(xpath = "//span/b[contains(text(),'Fee Paid to date')]/../following-sibling::span")
	private WebElement history_FeePaidToDate;

	@FindBy(xpath = "//span/b[contains(text(),'Return Fee Paid to date')]/../following-sibling::span")
	private WebElement history_ReturnFeePaidToDate;

	@FindBy(xpath = "//span/b[contains(text(),'Late Fee Paid to date')]/../following-sibling::span")
	private WebElement history_LateFeePaidToDate;

	@FindBy(xpath = "//span/b[contains(text(),'Total Paid Amt')]/../following-sibling::span")
	private WebElement history_TotalPaidAmt;

	public String get_History_PrincipalPaidToDate(String data) {
		return doIT(history_PrincipalPaidToDate, "y");
	}

	public String get_History_FeePaidToDate(String data) {
		return doIT(history_FeePaidToDate, "y");
	}

	public String get_History_ReturnFeePaidToDate(String data) {
		return doIT(history_ReturnFeePaidToDate, "y");
	}

	public String get_History_LateFeePaidToDate(String data) {
		return doIT(history_LateFeePaidToDate, "y");
	}

	public String get_History_TotalPaidAmt(String data) {
		return doIT(history_TotalPaidAmt, "y");
	}

	public String get_History_PayOffAmt(String data) {
		return doIT(history_PayOffAmt, "y");
	}

	/*
	 * Loan Account Information
	 */

	@FindBy(xpath = "//b[contains(text(),'Loan Account Information')]")
	private WebElement th_LoanAccountInformation;

	@FindBy(xpath = "//span/b[contains(text(),'Product Name')]/../following-sibling::span")
	private WebElement history_ProductName;

	@FindBy(xpath = "//span/b[contains(text(),'Product Type')]/../following-sibling::span")
	private WebElement history_ProductType;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Nbr')]/../following-sibling::span")
	private WebElement history_LoanNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Amt')]/../following-sibling::span")
	private WebElement history_LoanAmt;

	@FindBy(xpath = "//span/b[contains(text(),'Finance Charge')]/../following-sibling::span")
	private WebElement history_FinanceCharge;

	@FindBy(xpath = "//span/b[contains(text(),'APR')]/../following-sibling::span")
	private WebElement history_APR;

	@FindBy(xpath = "//span/b[contains(text(),'Interest Rate/Fee')]/../following-sibling::span")
	private WebElement history_InterestRateFee;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Date')]/../following-sibling::span")
	private WebElement history_LoanDate;

	@FindBy(xpath = "//span/b[contains(text(),'Collateral Type')]/../following-sibling::span")
	private WebElement history_CollateralType;

	@FindBy(xpath = "//span/b[contains(text(),'Loan Frequency')]/../following-sibling::span")
	private WebElement history_LoanFrequency;

	@FindBy(xpath = "//span/b[contains(text(),'Origination Store')]/../following-sibling::span")
	private WebElement history_OriginationStore;

	@FindBy(xpath = "//span/b[contains(text(),'Origination/Documentation Fee')]/../following-sibling::span")
	private WebElement history_OriginationDocumentationFee;

	@FindBy(xpath = "//span/b[contains(text(),'Available Credit')]/../following-sibling::span")
	private WebElement history_AvailableCredit;

	@FindBy(xpath = "//span/b[contains(text(),'Renewal Flag')]/../following-sibling::span")
	private WebElement history_RenewalFlag;

	@FindBy(xpath = "//span/b[contains(text(),'Renewal Date')]/../following-sibling::span")
	private WebElement history_RenewalDate;

	@FindBy(xpath = "//span/b[contains(text(),'Title Cycle Nbr')]/../following-sibling::span")
	private WebElement history_TitleCycleNbr;

	@FindBy(xpath = "//span/b[contains(text(),'Out for Repo')]/../following-sibling::span")
	private WebElement history_OutforRepo;

	public String get_History_ProductName(String data) {
		return doIT(history_ProductName, "y");
	}

	public String get_History_ProductType(String data) {
		return doIT(history_ProductType, "y");
	}

	public String get_History_LoanNbr(String data) {
		return doIT(history_LoanNbr, "y");
	}

	public String get_History_LoanAmt(String data) {
		return doIT(history_LoanAmt, "y");
	}

	public String get_History_FinanceCharge(String data) {
		return doIT(history_FinanceCharge, "y");
	}

	public String get_History_APR(String data) {
		return doIT(history_APR, "y");
	}

	public String get_History_InterestRateFee(String data) {
		return doIT(history_InterestRateFee, "y");
	}

	public String get_History_LoanDate(String data) {
		return doIT(history_LoanDate, "y");
	}

	public String get_History_CollateralType(String data) {
		return doIT(history_CollateralType, "y");
	}

	public String get_History_LoanFrequency(String data) {
		return doIT(history_LoanFrequency, "y");
	}

	public String get_History_OriginationStore(String data) {
		return doIT(history_OriginationStore, "y");
	}

	public String get_History_OriginationDocumentationFee(String data) {
		return doIT(history_OriginationDocumentationFee, "y");
	}

	public String get_History_AvailableCredit(String data) {
		return doIT(history_AvailableCredit, "y");
	}

	public String get_History_RenewalFlag(String data) {
		return doIT(history_RenewalFlag, "y");
	}

	public String get_History_RenewalDate(String data) {
		return doIT(history_RenewalDate, "y");
	}

	public String get_History_TitleCycleNbr(String data) {
		return doIT(history_TitleCycleNbr, "y");
	}

	public String get_History_OutforRepo(String data) {
		return doIT(history_OutforRepo, "y");
	}

	/*
	 * Third Party Collection Info
	 */

	@FindBy(xpath = "//b[contains(text(),'Third Party Collection Info')]")
	private WebElement th_ThirdPartyCollectionInfo;
	//
	@FindBy(xpath = "//span/b[contains(text(),'Transfer Out Date')]/../following-sibling::span")
	private WebElement history_TransferOutDate;

	@FindBy(xpath = "//span/b[contains(text(),'Transfer In Date')]/../following-sibling::span")
	private WebElement history_TransferInDate;

	@FindBy(xpath = "//span/b[contains(text(),'Account Sold')]/../following-sibling::span")
	private WebElement history_AccountSold;

	@FindBy(xpath = "//span/b[contains(text(),'Sold To')]/../following-sibling::span")
	private WebElement history_SoldTo;

	@FindBy(xpath = "//span/b[contains(text(),'Sold Date')]/../following-sibling::span")
	private WebElement history_SoldDate;

	@FindBy(xpath = "//span/b[contains(text(),'Mark For Sale')]/../following-sibling::span")
	private WebElement history_MarkForSale;

	@FindBy(xpath = "//span/b[contains(text(),'Agency Name')]/../following-sibling::span")
	private WebElement history_AgencyName;

	public String get_History_TransferOutDate(String data) {
		return doIT(history_TransferOutDate, "y");
	}

	public String get_History_TransferInDate(String data) {
		return doIT(history_TransferInDate, "y");
	}

	public String get_History_AccountSold(String data) {
		return doIT(history_AccountSold, "y");
	}

	public String get_History_SoldTo(String data) {
		return doIT(history_SoldTo, "y");
	}

	public String get_History_SoldDate(String data) {
		return doIT(history_SoldDate, "y");
	}

	public String get_History_MarkForSale(String data) {
		return doIT(history_MarkForSale, "y");
	}

	public String get_History_AgencyName(String data) {
		return doIT(history_AgencyName, "y");
	}

	/*
	 * Revolving Credit Transaction History
	 */

	// @FindBy(xpath = "//td[contains(text(),'Revolving Credit Transaction
	// History')]")
	@FindBy(xpath = "//td[@class='formHeading']")
	private WebElement th_loc_Header;

	public String get_th_Header(String data) {
		return doIT(th_loc_Header, data).trim();
	}

	@FindBy(xpath = "(//span[contains(text(),'Customer')]/following-sibling::span)[1]")
	private WebElement th_loc_CustomerName;

	public String get_th_loc_CustomerName(String data) {
		return doIT(th_loc_CustomerName, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Customer Nbr')]/following-sibling::span")
	private WebElement th_loc_CustomerNbr;

	public String get_th_loc_CustomerNbr(String data) {
		return doIT(th_loc_CustomerNbr, data);
	}

	@FindBy(xpath = "//span[contains(text(),'SSN')]/following-sibling::a]")
	private WebElement th_loc_SSN;

	public String get_th_loc_SSN(String data) {
		return doIT(th_loc_SSN, data);
	}

	@FindBy(xpath = "//span[contains(text(),'DOB')]/following-sibling::span")
	private WebElement th_loc_DOB;

	public String get_th_loc_DOB(String data) {
		return doIT(th_loc_DOB, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Email')]/following-sibling::span")
	private WebElement th_loc_Email;

	public String get_th_loc_Email(String data) {
		return doIT(th_loc_Email, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Credit Line')]/following-sibling::span")
	private WebElement th_loc_CreditLine;

	public String get_th_loc_CreditLine(String data) {
		return doIT(th_loc_CreditLine, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Bankrupt')]/following-sibling::span")
	private WebElement th_Bankrupt;

	public String get_th_Bankrupt(String data) {
		return doIT(th_Bankrupt, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Line Status')]/following-sibling::span")
	private WebElement th_loc_LineStatus;

	public String get_th_loc_LineStatus(String data) {
		return doIT(th_loc_LineStatus, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Past Due Amount')]/following-sibling::span")
	private WebElement th_loc_PastDueAmount;

	public String get_th_loc_PastDueAmount(String data) {
		return doIT(th_loc_PastDueAmount, data).replace("$", "");
	}

	@FindBy(xpath = "//span[contains(text(),'Next Statement Date')]/following-sibling::span")
	private WebElement th_loc_NextStatementDate;

	public String get_th_loc_NextStatementDate(String data) {
		return doIT(th_loc_NextStatementDate, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Due Date ')]/following-sibling::span")
	private WebElement th_loc_DueDate;

	public String get_th_loc_DueDate(String data) {
		return doIT(th_loc_DueDate, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Pay Frequency')]/following-sibling::span")
	private WebElement th_loc_PayFrequency;

	public String get_th_loc_PayFrequency(String data) {
		return doIT(th_loc_PayFrequency, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Payment Status')]/following-sibling::span")
	private WebElement th_loc_PaymentStatus;

	public String get_th_loc_PaymentStatus(String data) {
		return doIT(th_loc_PaymentStatus, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Delinquent Date')]/following-sibling::span")
	private WebElement th_loc_DelinquentDate;

	public String get_th_loc_DelinquentDate(String data) {
		return doIT(th_loc_DelinquentDate, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Loan in Cure Period')]/following-sibling::span")
	private WebElement th_loc_LoaninCurePeriod;

	public String get_th_loc_LoaninCurePeriod(String data) {
		return doIT(th_loc_LoaninCurePeriod, data);
	}

	@FindBy(xpath = "//span[contains(text(),'Cure Period End Date')]/following-sibling::span")
	private WebElement th_loc_CurePeriodEndDate;

	public String get_th_loc_CurePeriodEndDate(String data) {
		return doIT(th_loc_CurePeriodEndDate, data);
	}
	/*
	 * Installment History
	 */
	@FindBy(xpath="//span/*[contains(text(),'r')]/../../child::span[2]")
	private WebElement Ith_Customername;
	
	@FindBy(xpath="//span[contains(text(),'Customer Nbr')]/following-sibling::span")
	private WebElement Ith_Loannumber;

	@FindBy(xpath="//span[contains(text(),'Pay Frequency')]/following-sibling::span")
	private WebElement Ith_Payfrequency;
	
	@FindBy(xpath="//span/*[contains(text(),'Next Due Date')]/../../child::span[2]")
	private WebElement Ith_Nextduedate;
	
	
	@FindBy(xpath="((//span[@class='leftHeading']//b)[40]//..//following::span)[1]")
	private WebElement Ith_PaymentStatus;
	
	@FindBy(xpath="((//span[@class='leftHeading'])[45]//following::span)[1]")
	private WebElement Ith_CurePeriodEndDate;
	
	@FindBy(xpath="//span[contains(text(),'Cure Period End Date')]/following-sibling::span")
	private WebElement Ith_LoanInCurePeriod;
	
	public String get_Ith_CurePeriodEndDate(String data) {
		return doIT(Ith_CurePeriodEndDate, data);
	}

	public String get_Ith_Customername(String data) {
		return doIT(Ith_Customername, data);
	}

	public String get_Ith_Loannumber(String data) {
		return doIT(Ith_Loannumber, data);
	}
	
	public String get_Ith_Payfrequency(String data) {
		return doIT(Ith_Payfrequency, data);
	}
	
	public String get_Ith_Nextduedate(String data) {
		return doIT(Ith_Nextduedate, data);
	}
	
	public String get_Ith_PaymentStatus(String data) {
		return doIT(Ith_PaymentStatus, data);
	}
	
	public String get_Ith_LoanInCurePeriod(String data) {
		return doIT(Ith_LoanInCurePeriod, data);
	}
	/*
	 * Transaction Details
	 */

	@FindBy(name = "rad")
	private WebElement th_TransDet_radioButton;

	@FindBy(name = "Receipt")
	private WebElement th_TransDet_ReceiptButton;

	@FindBy(xpath = "//input[@value='VCR Form']")
	private WebElement th_TransDet_VCRForm;

	@FindBy(xpath = "//input[@value='Agreement']")
	private WebElement th_TransDet_AgreementButton;

	@FindBy(xpath = "//input[@value='Cancel']")
	private WebElement th_TransDtls_CancelButton;

	@FindBy(xpath = "//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'LOC Initiation')]")
	private WebElement th_TransDet_VerifyLOCInitiation;

	@FindBy(xpath = "//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Draw')]")
	private WebElement th_TransDet_VerifyLOCDraw;

	@FindBy(xpath = "//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Revolving Payments')]")
	private WebElement th_TransDet_VerifyLOCRevolvingPayments;

	@FindBy(xpath = "//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Pay-off')]")
	private WebElement th_TransDet_VerifyLOCPayoff;

	@FindBy(xpath = "//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'LOC Closure')]")
	private WebElement th_TransDet_VerifyLOCClosure;


	public String get_th_TransDet_VerifyLOCInitiation(String data) {
		return doIT(th_TransDet_VerifyLOCInitiation, data);
	}
	public String get_th_TransDet_VerifyLOCDraw(String data) {
		return doIT(th_TransDet_VerifyLOCDraw, data);
	}
	public String get_th_TransDet_VerifyLOCRevolvingPayments(String data) {
		return doIT(th_TransDet_VerifyLOCRevolvingPayments, data);
	}
	public String get_th_TransDet_VerifyLOCPayoff(String data) {
		return doIT(th_TransDet_VerifyLOCPayoff, data);
	}
	public String get_th_TransDet_VerifyLOCClosure(String data) {
		return doIT(th_TransDet_VerifyLOCClosure, data);
	}

	
	@FindBy(xpath = "//table[@id='transactionDetailsTable']")
	private WebElement th_TransactionDetails;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'Advance')]")
	private WebElement th_TransDet_VerifyAdvance;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'Payment')]")
	private WebElement th_TransDet_VerifyPayment;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'Default')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Default')]")
	private WebElement th_TransDet_VerifyDefaultStatus;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'Write-off')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Write-off')]")
	private WebElement th_TransDet_VerifyWriteOffStatus;
	
	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'Voluntary Surrender')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'Write-off')]")
	private WebElement th_TransDet_VolSurStatus;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'REPOSSESSION')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'REPOSSESSION')]")
	private WebElement th_TransDet_VerifyRepoStatus;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'AUCTION')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'AUCTION')]")
	private WebElement th_TransDet_VerifyAuctionStatus;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'SALE')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'SALE')]")
	private WebElement th_TransDet_VerifySaleStatus;

	@FindBy(xpath = "//table[@id='transactionDetailsTable']//font[contains(text(),'SALVAGE')]|//table[@id='revolvingCreditDetailsTable']//td[contains(text(),'SALVAGE')]")
	private WebElement th_TransDet_VerifySlvStatus;
	

	
	public String get_th_TransDtls_CancelButton(String data) {
		return doIT(th_TransDtls_CancelButton, "y");
	}

	public void click_th_TransDtls_CancelButton(String data) {
		doIT(th_TransDtls_CancelButton, data);
	}

	public void click_History_radioButton(String data) {
		doIT(th_TransDet_radioButton, data);
	}

	public void click_History_VCRForm(String data) throws Exception {
		doIT(th_TransDet_VCRForm, data);
	}

	public String get_th_TransactionDetails(String data) {
		return doIT(th_TransactionDetails, "y");
	}

	public String get_th_TransDet_VerifyAdvance(String data) {
		return doIT(th_TransDet_VerifyAdvance, data);
	}

	public String get_th_TransDet_VerifyPayment(String data) {
		return doIT(th_TransDet_VerifyPayment, data);
	}

	public String get_th_TransDet_VerifyDefaultStatus(String data) {
		return doIT(th_TransDet_VerifyDefaultStatus, data);
	}

	public String get_th_TransDet_VerifyWriteOffStatus(String data) {
		return doIT(th_TransDet_VerifyWriteOffStatus, data);
	}

	public String get_th_TransDet_VolSurStatus(String data) {
		return doIT(th_TransDet_VolSurStatus, data);
	}

	public String get_th_TransDet_VerifyRepoStatus(String data) {
		return doIT(th_TransDet_VerifyRepoStatus, data);
	}

	public String get_th_TransDet_VerifyAuctionStatus(String data) {
		return doIT(th_TransDet_VerifyAuctionStatus, data);
	}

	public String get_th_TransDet_VerifySaleStatus(String data) {
		return doIT(th_TransDet_VerifySaleStatus, data);
	}

	public String get_th_TransDet_VerifySlvStatus(String data) {
		return doIT(th_TransDet_VerifySlvStatus, data);
	}

	/*
	 * ACH His
	 */

	@FindBy(xpath = "//table//tr[@class='tableheadrow']/td[contains(text(),'RPP Fees')]/../following-sibling::tr/td[contains(text(),'ACH Deposit')]")
	private WebElement th_TransDet_VerifyACHDepositStatus;	
	
	@FindBy(xpath = "//table//tr[@class='tableheadrow']/td[contains(text(),'RPP Fees')]/../following-sibling::tr/td[contains(text(),'ACH Pre-Payment')]")
	private WebElement th_TransDet_VerifyACHPrePaymentStatus;	
	
	@FindBy(xpath = "//table//tr[@class='tableheadrow']/td[contains(text(),'RPP Fees')]/../following-sibling::tr/td[contains(text(),'ACH Clear')]")
	private WebElement th_TransDet_VerifyACHClearStatus;	
	
	@FindBy(xpath = "//table//tr[@class='tableheadrow']/td[contains(text(),'RPP Fees')]/../following-sibling::tr/td[contains(text(),'Refund')]")
	private WebElement th_TransDet_VerifyRefundStatus;	
	
	public String get_th_TransDet_VerifyACHDepositStatus(String data) {
		return doIT(th_TransDet_VerifyACHDepositStatus, data);
	}

	public String get_th_TransDet_VerifyACHPrePaymentStatus(String data) {
		return doIT(th_TransDet_VerifyACHPrePaymentStatus, data);
	}

	public String get_th_TransDet_VerifyACHClearStatus(String data) {
		return doIT(th_TransDet_VerifyACHClearStatus, data);
	}
	

	public String get_th_TransDet_VerifyRefundStatus(String data) {
		return doIT(th_TransDet_VerifyRefundStatus, data);
	}

	/*
	 * Renewal Schedule
	 */

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[1]")
	private WebElement th_title_RenewalSchedule_Tableheader;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[2]")
	private WebElement th_title_RenewalSchedule_Tabledata;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[2]/td[2]")
	private WebElement th_titleRenewal_PmtDate1;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[3]/td[2]")
	private WebElement th_titleRenewal_PmtDate2;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[4]/td[2]")
	private WebElement th_titleRenewal_PmtDate3;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[5]/td[2]")
	private WebElement th_titleRenewal_PmtDate4;

	@FindBy(xpath = "//table[@id='myTable1']/tbody[2]/tr[6]/td[2]")
	private WebElement th_titleRenewal_PmtDate5;

	public String get_th_title_RenewalSchedule_Tableheader(String data) {
		return doIT(th_title_RenewalSchedule_Tableheader, data);
	}

	public String get_th_title_RenewalSchedule_Tabledata(String data) {
		return doIT(th_title_RenewalSchedule_Tabledata, data);
	}

	public String get_th_titleRenewal_PmtDate1(String data) {
		return doIT(th_titleRenewal_PmtDate1, data);
	}

	public String get_th_titleRenewal_PmtDate2(String data) {
		return doIT(th_titleRenewal_PmtDate2, data);
	}

	public String get_th_titleRenewal_PmtDate3(String data) {
		return doIT(th_titleRenewal_PmtDate3, data);
	}

	public String get_th_titleRenewal_PmtDate4(String data) {
		return doIT(th_titleRenewal_PmtDate4, data);
	}

	public String get_th_titleRenewal_PmtDate5(String data) {
		return doIT(th_titleRenewal_PmtDate5, data);
	}

	/*
	 * Email - Document Delivery
	 */

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[1]")
	private WebElement eh_Date;

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[2]")
	private WebElement eh_LoanNbr;

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[3]")
	private WebElement eh_Emailid;

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[4]")
	private WebElement eh_Desc;

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[5]")
	private WebElement eh_Status;

	@FindBy(xpath = "//*[@id='emailHistoryTable']/tbody/tr[3]/td[6]")
	private WebElement eh_Response;

	public String get_emailConstentHistory_Date(String data) {
		return doIT(eh_Date, data);
	}

	public String get_emailConstentHistory_Loannbr(String data) {
		return doIT(eh_LoanNbr, data);
	}

	public String get_emailConstentHistory_Emailid(String data) {
		return doIT(eh_Emailid, data);
	}

	public String get_email_ConstentHistory_Desc(String data) {
		return doIT(eh_Desc, data);
	}

	public String get_email_ConstentHistory_Status(String data) {
		return doIT(eh_Status, data);
	}

	public String get_email_ConstentHistory_Response(String data) {
		return doIT(eh_Response, data);
	}

	/*
	 * unkown
	 */

	@FindBy(id = "910000")
	private WebElement LoanTransactions_Tab;

	@FindBy(id = "911101")
	private WebElement Transactions;

	@FindBy(name = "Close")
	private WebElement ChildWindowClose;

	public void click_ChildWindowClose(String data) {
		doIT(ChildWindowClose, data);
	}

	public void click_LoanTransactions_Tab(String data) {
		doIT(LoanTransactions_Tab, data);
	}

	public void click_Transactions(String data) {
		doIT(Transactions, data);
	}
	
	// Title Tracking Status
	@FindBy(xpath = "//td[contains(text(),'Lien Not Applied For')]")
	private WebElement lienNotAppliedFor;

	public String get_lienNotAppliedFor(String data) {
		return doIT(lienNotAppliedFor, "Y");
	}

	public String get_EOC(String data) {
		return "Stop";
	}
	
	
}
