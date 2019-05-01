package pageClasses.QFund;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

//**********************************
//*		Author	= Lee Huntsinger
//*		Date	= 12-October-2018
//**********************************

public class AdminTransaction_Repossession_PO  extends BasePage {
 
	public AdminTransaction_Repossession_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}


	// Store Number field on Applicant Search Page
	@FindBy(name = "requestBean.storeId")
	private WebElement Title_Admin_StoreNbr;

	// Status field on Applicant Search Page
	@FindBy(name = "requestBean.statusType")
	private WebElement Title_Admin_Status;

	// Submit button on the Applicant Search Page
	@FindBy(name = "submit")
	private WebElement Title_Admin_SubmitBtn;

	// Go Button on Search Results page
	@FindBy(xpath = "//input[@name='button' and @value='Go']")
	private WebElement SearchResultsGoBtn;
	
	// Out to Repo Company Field
	@FindBy(name = "solvageCompany")
	private WebElement OutToRepoCompany;
	
	// Repo Company Name
	@FindBy(name = "requestBean.companyName")
	private WebElement RepoCompanyName;

	// Auction Company Name
	@FindBy(id = "solvageCompany")
	private WebElement AuctionCompanyName;

	
	// Repossessed Date Month
	@FindBy(xpath = "//input[@name='rpossesdate1']" )
	private WebElement RepoDateMonth;
	
	// Repossessed Date Day
	@FindBy(xpath = "//input[@name='rpossesdate2']" )
	private WebElement RepoDateDay;
	
	// Repossessed Date Year
	@FindBy(xpath = "//input[@name='rpossesdate3']" )
	private WebElement RepoDateYear;

	// Auction Date Month
	@FindBy(xpath = "//input[@name='rpossesdate1']" )
	private WebElement AuctionDateMonth;
	
	// Auction Date Day
	@FindBy(xpath = "//input[@name='rpossesdate2']" )
	private WebElement AuctionDateDay;
	
	// Auction Date Year
	@FindBy(xpath = "//input[@name='rpossesdate3']" )
	private WebElement AuctionDateYear;

	
	// PIN# on Out To Repo page
	@FindBy(name="password")
	private WebElement UserPIN;
	
	// PIN# on Repossession page
	@FindBy(name="requestBean.password")
	private WebElement RepossessUserPIN;

	// PIN# on Auction page
	@FindBy(name="requestBean.password")
	private WebElement AuctionUserPIN;

	
	// Submit button on Out To Repo page
	@FindBy(name="finish")
	private WebElement RepoSubmitBtn;
	
	// Out To Repo Completed successfully OK button
	@FindBy(xpath="//input[@value='Ok']")
	private WebElement RepoCompletedSuccessfulOKBtn;

	// Void Out To Repo Completed successfully OK button
	@FindBy(xpath="//input[@value='Ok']")
	private WebElement VoidRepoCompletedSuccessfulOKBtn;
	
	// Transaction Completed successfully OK button
	@FindBy(name="ok")
	private WebElement TransCompletedSuccessfulOKBtn;


	
	
//***********************************************************
//*  Locator Methods
//***********************************************************
	
	// Check for Status Field on Applicant Search Page
    public boolean checkVisibiltyStatus(){
    	return Title_Admin_Status.isDisplayed();
    }

	// Check for Go Button on Search Results Page
    public boolean checkVisibiltyofGoBtn(){
    	return SearchResultsGoBtn.isDisplayed();
    }

	// Check for Out To Repo Company on Out To Repo Page
    public boolean checkVisibiltyofOutToRepo(){
    	return OutToRepoCompany.isDisplayed();
    }
    
	// Check for Repo Company Name on Repossession Page
    public boolean checkVisibiltyofRepossession(){
    	return RepoCompanyName.isDisplayed();
    }
    
	// Check for Auction Company Name on Auction Page
    public boolean checkVisibiltyofAuctionCompany(){
    	return AuctionCompanyName.isDisplayed();
    }


	// Check for OK Button on Out To Repo Completed Successfully Page
    public boolean checkVisibiltyofOutToRepoCompleteOKBtn(){
    	return RepoCompletedSuccessfulOKBtn.isDisplayed();
    }

	// Check for OK Button on Repossession Completed Successfully Page
    public boolean checkVisibiltyofRepoCompleteOKBtn(){
    	return TransCompletedSuccessfulOKBtn.isDisplayed();
    }

	// Check for Transaction Completed Successfully OK Button
    public boolean checkVisibiltyofTransCompleteOKBtn(){
    	return TransCompletedSuccessfulOKBtn.isDisplayed();
    }

    

	public void set_Title_Admin_Status	(String strTitle_Admin_Status) {
		doIT(Title_Admin_Status,	strTitle_Admin_Status);
	}

	public void set_Title_Admin_StoreNbr	(String strTitle_Admin_StoreNbr) {
		doIT(Title_Admin_StoreNbr,	strTitle_Admin_StoreNbr);
	}


	public void click_Title_Admin_SubmitBtn	(String strTitle_Admin_SubmitBtn){
		doIT(Title_Admin_SubmitBtn,	strTitle_Admin_SubmitBtn);
	}
	
	public void click_SearchResultsGoBtn	(String strSearchResultsGoBtn){
		doIT(SearchResultsGoBtn,	strSearchResultsGoBtn);
	}
	
	public void set_OutToRepoCompany	(String strOutToRepoCompany) {
		doIT(OutToRepoCompany,	strOutToRepoCompany);
	}
	
	public void set_RepoCompanyName	(String strRepoCompanyName) {
		doIT(RepoCompanyName,	strRepoCompanyName);
	}


	public void set_UserPIN	(String strUserPIN) {
		doIT(UserPIN,	strUserPIN);
	}
	
	public void set_RepoUserPIN	(String strRepossessUserPIN) {
		doIT(RepossessUserPIN,	strRepossessUserPIN);
	}

	public void set_AuctionUserPIN	(String strAuctionUserPIN) {
		doIT(AuctionUserPIN,	strAuctionUserPIN);
	}

	
	public void set_RepoDateMonth(String sRepoDateMonth) {
		doIT(RepoDateMonth, sRepoDateMonth);
	}

	public void set_RepoDateDay(String sRepoDateDay) {
		doIT(RepoDateDay, sRepoDateDay);
	}

	public void set_RepoDateYear(String sRepoDateYear) {
		doIT(RepoDateYear, sRepoDateYear);
	}

	public void set_RepossessionDate(String sRepossessionDate) throws InterruptedException {
		if(!sRepossessionDate.isEmpty()) {
			String[] IdExpiry = sRepossessionDate.split("-", -2);
			Thread.sleep(3000);
			doIT(RepoDateMonth, IdExpiry[0]);
			doIT(RepoDateDay, IdExpiry[1]);
			doIT(RepoDateYear, IdExpiry[2]);
		}
	}	
	
	public void set_AuctionDateMonth(String sAuctionDateMonth) {
		doIT(AuctionDateMonth, sAuctionDateMonth);
	}

	public void set_AuctionDateDay(String sAuctionDateDay) {
		doIT(AuctionDateDay, sAuctionDateDay);
	}

	public void set_AuctionDateYear(String sAuctionDateYear) {
		doIT(AuctionDateYear, sAuctionDateYear);
	}
	
	public void set_AuctionDate(String sAuctionDate) throws InterruptedException {
		if(!sAuctionDate.isEmpty()) {
			String[] IdExpiry = sAuctionDate.split("-", -2);
			Thread.sleep(3000);
			doIT(AuctionDateMonth, IdExpiry[0]);
			doIT(AuctionDateDay, IdExpiry[1]);
			doIT(AuctionDateYear, IdExpiry[2]);
		}
	}	


	
	public void click_RepoSubmitBtn	(String strRepoSubmitBtn){
		doIT(RepoSubmitBtn,	strRepoSubmitBtn);
	}

	public void click_RepoCompletedSuccessfulOKBtn	(String strRepoCompletedSuccessfulOKBtn){
		doIT(RepoCompletedSuccessfulOKBtn,	strRepoCompletedSuccessfulOKBtn);
	}

	public void click_VoidRepoCompletedSuccessfulOKBtn	(String strVoidRepoCompletedSuccessfulOKBtn){
		doIT(VoidRepoCompletedSuccessfulOKBtn,	strVoidRepoCompletedSuccessfulOKBtn);
	}

	public void click_TransCompletedSuccessfulOKBtn	(String strTransCompletedSuccessfulOKBtn){
		doIT(TransCompletedSuccessfulOKBtn,	strTransCompletedSuccessfulOKBtn);
	}

	
	
}
