/**
 * 
 */
package pageClasses.QFund;

import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;


/**
 * @author VKumar
 *
 */
public class TitleLoan_PO extends BasePage {
	
	public TitleLoan_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}
	
	
	@FindBy(xpath="//input[(@name='renSchedule') and (@value='Amortization')]")
	private WebElement TitleLoan_Amortization;
	
	
	@FindBy(name="requestBean.appraisalVal")
	private WebElement TitleLoan_VehAppraisalVal;
	
	@FindBy(name="requestBean.licenceState")
	private WebElement TitleLoan_VehRegState;
	
	/**
	 * @return the titleLoan_VehAppraisalVal
	 */
		@FindBy(name="requestBean.licensePltExpire")
	private WebElement TitleLoan_VehLicPltExp;
	
	
	@FindBy(name="requestBean.siilBean.emailConsentFlag")
	private WebElement TitleLoan_VehEmailConst;
	
	
	@FindBy(name="process")
	private WebElement TitleLoan_ProcessLn;
	
	
	
	
	@FindBy(xpath="//input[@text()='Update']")
	private WebElement TitleLoan_VehUpdate;
	
	
	@FindBy(name="requestBean.licensePltNbr")
	private WebElement TitleLoan_VehLicPltNbr;
	
	@FindBy(name="requestBean.extClr")
	private WebElement TitleLoan_VehExteriorColor;
	
		
	@FindBy(name="requestBean.paintCondition")
	private WebElement TitleLoan_VehPaintCond;
	
	
	@FindBy(name="requestBean.bodyCondition")
	private WebElement TitleLoan_VehBodyCond;
	
	
	@FindBy(name="requestBean.glassCondition")
	private WebElement TitleLoan_VehGlassCond;
	
	
	@FindBy(name="requestBean.tiresCondition")
	private WebElement TitleLoan_VehTyresCond;
	
	
	@FindBy(name="requestBean.coverageType")
	private WebElement TitleLoan_VehInsType;
	
	
	@FindBy(name="button1")
	private WebElement TitleLoan_Update1;
	
	
	@FindBy(name="button2")
	private WebElement TitleLoan_Update2;
	
	
	@FindBy(name="process")
	private WebElement TitleLoan_ProcessLoan;
	
	
	@FindBy(name="collateralType")
	private WebElement TitleLoan_CollateralType;
	
	@FindBy(name="requestBean.siilBean.disbType")
	private WebElement TitleLoan_DisbType;
	
	@FindBy(name="requestBean.siilBean.disbTypeSecond")
	private WebElement TitleLoan_DisbTypeTwo;
	
	@FindBy(name="requestBean.siilBean.disbAmtSecond")
	private WebElement TitleLoan_DisbAmtTwo;
		
	@FindBy(name="requestBean.siilBean.disbAmtFirst")
	private WebElement TitleLoan_DisbAmt;
	
	@FindBy(name="vehicleKey")
	private WebElement TitleLoan_VehKey;
	
	@FindBy(name="requestBean.siilBean.courtesyCallFlag")
	private WebElement TitleLoan_CourtesyCall;
	
	

	@FindBy(name="requestBean.password")
	private WebElement TitleLoan_DrawerPwd;
	
		
	@FindBy(name="finishLoan")
	private WebElement TitleLoan_FinishLoan;
	
	//@FindBy(xpath="//input[(@value='Ok') and (@type='button')]")
	@FindBy(id="OKBut")
	private WebElement TitleLoan_Confirm;
	
	@FindBy(name="eeeComm")
	private WebElement TitleLoan_Eligibilty;
	
	@FindBy(name="requestBean.siilBean.CSOName")
	private WebElement TitleLoan_ThirdpartyDisb_Payee;
	
	@FindBy(name="requestBean.siilBean.CSOChkAmt")
	private WebElement TitleLoan_ThirdpartyDisb_Amt;
	
	@FindBy(xpath="//font/ul[contains(text(),'The entered Password is invalid.Please re-enter.')]")	
	private WebElement ErrorMsg;
	
	public String get_ErrorMsg(String data){
		return doIT(ErrorMsg, data);
	}
	
	public void click_TitleLoan_Confirm(String data){
		doIT(TitleLoan_Confirm,data);
		acceptAlert();
	}
	
	
	
	public void click_TitleLoan_Amortization(String data){
		doIT(TitleLoan_Amortization,data);
	//	try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_ProcessLn));}catch(Exception e) {}
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable((TitleLoan_Amortization)));
		doIT(TitleLoan_Amortization,data);

	}
	
	public void click_TitleLoan_Eligibilty(String data){
		doIT(TitleLoan_Eligibilty,data);
		acceptAlert();
	}
	
	public void click_TitleLoan_ProcessLn(String data){
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_ProcessLn));}catch(Exception e) {}
		doIT(TitleLoan_ProcessLn,data);
		acceptAlert();
	}	
	
	public void click_TitleLoan_FinishLoan(String data){
		doIT(TitleLoan_FinishLoan,data);
		//try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_Confirm));}catch(Exception e) {}	
	}
	public void click_TitleLoan_FinishLN(String data){
		doIT(TitleLoan_FinishLoan,data);
		//new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_Confirm));
	}
	public void click_TitleLoan_ProcessLoan(String data){
		doIT(TitleLoan_VehUpdate,data);
	}

	public void click_TitleLoan_Update2(String data){		
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_Update2));}catch(Exception e) {}
		doIT(TitleLoan_Update2,data);
	}
	
	public void click_TitleLoan_Update1(String data){
		//try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_Update1));}catch(Exception e) {}
		doIT(TitleLoan_Update1,data);
		//try{Thread.sleep(20000);}catch(Exception e) {}
	}
	public void click_TitleLoan_Updat1(String data){
		doIT(TitleLoan_Update1,data);
	}
	
	public void click_TitleLoan_VehUpdate(String data){
		doIT(TitleLoan_VehUpdate,data);
	}
	
	@FindBy(name="requestBean.titleNumber")
	private WebElement TitleLoan_VehTitleNbr;
	
	
	public String get_TitleLoan_VehAppraisalVal(String data) {
		return doIT(TitleLoan_VehAppraisalVal, data);
	}

	/**
	 * @param titleLoan_VehAppraisalVal the titleLoan_VehAppraisalVal to set
	 */
	public void set_TitleLoan_VehAppraisalVal(String titleLoan_VehAppraisalVal) {
		doIT(TitleLoan_VehAppraisalVal, titleLoan_VehAppraisalVal);
	}
	
	/**
	 * @param titleLoan_VehRegState the titleLoan_VehRegState to set
	 */
	public void set_TitleLoan_VehRegState(String titleLoan_VehRegState) {
		doIT(TitleLoan_VehRegState, titleLoan_VehRegState);
	}

	/**
	 * @return the titleLoan_VehLicPltExp
	 */
	public String get_TitleLoan_VehLicPltExp(String data) {
		return doIT(TitleLoan_VehLicPltExp, data);
	}

	/**
	 * @param titleLoan_VehLicPltExp the titleLoan_VehLicPltExp to set
	 */
	public void set_TitleLoan_VehLicPltExp(String titleLoan_VehLicPltExp) {
		doIT(TitleLoan_VehLicPltExp, titleLoan_VehLicPltExp);
	}

	/**
	 * @return the titleLoan_VehEmailConst
	 */
	public String get_TitleLoan_VehEmailConst(String data) {
		return doIT(TitleLoan_VehEmailConst, data);
	}

	/**
	 * @param titleLoan_VehEmailConst the titleLoan_VehEmailConst to set
	 */
	public void set_TitleLoan_VehEmailConst(String titleLoan_VehEmailConst) {
		doIT(TitleLoan_VehEmailConst, titleLoan_VehEmailConst);
	}


	
	
	
	
	/**
	 * @return the titleLoan_CourtesyCall
	 */
	public String get_TitleLoan_CourtesyCall(String data) {
		return doIT(TitleLoan_CourtesyCall, data);
	}

	/**
	 * @param titleLoan_CourtesyCall the titleLoan_CourtesyCall to set
	 */
	public void set_TitleLoan_CourtesyCall(String titleLoan_CourtesyCall) {
		doIT(TitleLoan_CourtesyCall, titleLoan_CourtesyCall);
	}

	
	/**
	 * @return the titleLoan_VehTitleNbr
	 */
	public String get_TitleLoan_VehTitleNbr(String data) {
		return doIT(TitleLoan_VehTitleNbr, data);
	}


	/**
	 * @param titleLoan_VehTitleNbr the titleLoan_VehTitleNbr to set
	 */
	public void set_TitleLoan_VehTitleNbr(String titleLoan_VehTitleNbr) {
		if (titleLoan_VehTitleNbr.equalsIgnoreCase("Random")) {			
			try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_VehTitleNbr));}catch(Exception e) {}
			doIT(TitleLoan_VehTitleNbr, RandomStringUtils.randomAlphabetic(2)+RandomStringUtils.randomNumeric(6));
		}else {doIT(TitleLoan_VehTitleNbr, titleLoan_VehTitleNbr);}	
	}


	/**
	 * @return the titleLoan_VehLicPltNbr
	 */
	public String get_TitleLoan_VehLicPltNbr(String data) {
		return doIT(TitleLoan_VehLicPltNbr, data);
	}


	/**
	 * @param titleLoan_VehLicPltNbr the titleLoan_VehLicPltNbr to set
	 */
	public void set_TitleLoan_VehLicPltNbr(String titleLoan_VehLicPltNbr) {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_VehLicPltNbr));}catch(Exception e) {}
		doIT(TitleLoan_VehLicPltNbr, titleLoan_VehLicPltNbr);
	}
	
	public void set_TitleLoan_ThirdpartyDisb_Payee(String titleLoan_ThirdpartyDisb_Payee) {
		doIT(TitleLoan_ThirdpartyDisb_Payee, titleLoan_ThirdpartyDisb_Payee);
	}
	
	public void set_TitleLoan_ThirdpartyDisb_Amt(String titleLoan_ThirdpartyDisb_Amt) {
		doIT(TitleLoan_ThirdpartyDisb_Amt, titleLoan_ThirdpartyDisb_Amt);
	}

	/**
	 * @return the titleLoan_VehExteriorColor
	 */
	public String get_TitleLoan_VehExteriorColor(String data) {
		return doIT(TitleLoan_VehExteriorColor, data);
	}


	/**
	 * @param titleLoan_VehExteriorColor the titleLoan_VehExteriorColor to set
	 */
	public void set_TitleLoan_VehExteriorColor(String titleLoan_VehExteriorColor) {
		try{new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_VehExteriorColor));}catch(Exception e) {}
		doIT(TitleLoan_VehExteriorColor, titleLoan_VehExteriorColor);
	}


	/**
	 * @return the titleLoan_VehPaintCond
	 */
	public String get_TitleLoan_VehPaintCond(String data) {
		return doIT(TitleLoan_VehPaintCond, data);
	}


	/**
	 * @param titleLoan_VehPaintCond the titleLoan_VehPaintCond to set
	 */
	public void set_TitleLoan_VehPaintCond(String titleLoan_VehPaintCond) {
		doIT(TitleLoan_VehPaintCond, titleLoan_VehPaintCond);
	}


	/**
	 * @return the titleLoan_VehBodyCond
	 */
	public String get_TitleLoan_VehBodyCond(String data) {
		return doIT(TitleLoan_VehBodyCond, data);
	}


	/**
	 * @param titleLoan_VehBodyCond the titleLoan_VehBodyCond to set
	 */
	public void set_TitleLoan_VehBodyCond(String titleLoan_VehBodyCond) {
		doIT(TitleLoan_VehBodyCond, titleLoan_VehBodyCond);
	}


	/**
	 * @return the titleLoan_VehGlassCond
	 */
	public String get_TitleLoan_VehGlassCond(String data) {
		return doIT(TitleLoan_VehGlassCond, data);
	}


	/**
	 * @param titleLoan_VehGlassCond the titleLoan_VehGlassCond to set
	 */
	public void set_TitleLoan_VehGlassCond(String titleLoan_VehGlassCond) {
		doIT(TitleLoan_VehGlassCond, titleLoan_VehGlassCond);
	}


	/**
	 * @return the titleLoan_VehTyresCond
	 */
	public String get_TitleLoan_VehTyresCond(String data) {
		return doIT(TitleLoan_VehTyresCond, data);
	}


	/**
	 * @param titleLoan_VehTyresCond the titleLoan_VehTyresCond to set
	 */
	public void set_TitleLoan_VehTyresCond(String titleLoan_VehTyresCond) {
		doIT(TitleLoan_VehTyresCond, titleLoan_VehTyresCond);
	}


	/**
	 * @return the titleLoan_VehInsType
	 */
	public String get_TitleLoan_VehInsType(String data) {
		return doIT(TitleLoan_VehInsType, data);
	}


	/**
	 * @param titleLoan_VehInsType the titleLoan_VehInsType to set
	 */
	public void set_TitleLoan_VehInsType(String titleLoan_VehInsType) {
		doIT(TitleLoan_VehInsType, titleLoan_VehInsType);
	}


	/**
	 * @return the titleLoan_CollateralType
	 */
	public String get_TitleLoan_CollateralType(String data) {
		return doIT(TitleLoan_CollateralType, data);
	}


	/**
	 * @param titleLoan_CollateralType the titleLoan_CollateralType to set
	 */
	public void set_TitleLoan_CollateralType(String titleLoan_CollateralType) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_CollateralType));		
		doIT(TitleLoan_CollateralType, titleLoan_CollateralType);
	}


	/**
	 * @return the titleLoan_DisbType
	 */
	public String get_TitleLoan_DisbType(String data) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DisbType));
		return doIT(TitleLoan_DisbType, data);
	}


	/**
	 * @param titleLoan_DisbType the titleLoan_DisbType to set
	 */
	public void set_TitleLoan_DisbType(String titleLoan_DisbType) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DisbType));
		doIT(TitleLoan_DisbType, titleLoan_DisbType);
	}
	
	public void set_TitleLoan_DisbTypeTwo(String titleLoan_DisbTypeTwo) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DisbTypeTwo));
		doIT(TitleLoan_DisbTypeTwo, titleLoan_DisbTypeTwo);
	}


	/**
	 * @return the titleLoan_DisbAmt
	 */
	public String get_TitleLoan_DisbAmt(String data) {
		return doIT(TitleLoan_DisbAmt, data);
	}


	/**
	 * @param titleLoan_DisbAmt the titleLoan_DisbAmt to set
	 */
	public void set_TitleLoan_DisbAmt(String titleLoan_DisbAmt) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DisbAmt));
		TitleLoan_DisbAmt.clear();
		doIT(TitleLoan_DisbAmt, titleLoan_DisbAmt);
	}

	
	public void set_TitleLoan_DisbAmtTwo(String titleLoan_DisbAmtTwo) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DisbAmtTwo));
		doIT(TitleLoan_DisbAmtTwo, titleLoan_DisbAmtTwo);
	}

	/**
	 * @return the titleLoan_VehKey
	 */
	public String get_TitleLoan_VehKey(String data) {
		return doIT(TitleLoan_VehKey, data);
	}


	/**
	 * @param titleLoan_VehKey the titleLoan_VehKey to set
	 */
	public void set_TitleLoan_VehKey(String titleLoan_VehKey) {
		doIT(TitleLoan_VehKey, titleLoan_VehKey);
	}


	/**
	 * @return the titleLoan_DrawerPwd
	 */
	public String get_TitleLoan_DrawerPwd(String data) {
		return doIT(TitleLoan_DrawerPwd, data);
	}


	/**
	 * @param titleLoan_DrawerPwd the titleLoan_DrawerPwd to set
	 */
	public void set_TitleLoan_DrawerPwd(String titleLoan_DrawerPwd) {
		new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(TitleLoan_DrawerPwd));
		TitleLoan_DrawerPwd.clear();
		doIT(TitleLoan_DrawerPwd, titleLoan_DrawerPwd);
	}

	/*public void new WebDriverWait(driver,120)forTitleLoan_DrawerPwd(WebElement webobj) {
		try{
	WebDrivernew WebDriverWait(driver,120) new WebDriverWait(driver,120) = new WebDrivernew WebDriverWait(driver,120)(driver, 10);
	new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickableAllElements(webobj));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	/*public void new WebDriverWait(driver,120)forTitleLoan_Amortization(String data){
		try{
	WebDrivernew WebDriverWait(driver,120) new WebDriverWait(driver,120) = new WebDrivernew WebDriverWait(driver,120)(driver, 10);
	new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickableAllElements(TitleLoan_Amortization));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
*/	
	
	public void Alerthandle() {
		new WebDriverWait(driver,120).until(ExpectedConditions.alertIsPresent());
		Alert alt=	driver.switchTo().alert();
		alt.accept();
		System.out.println(alt.getText());
	}
	
	public String getAlertTextmsg(String data) {
		if(!data.isEmpty()) {
			
			return  AlertDecesion("getText").trim();
			
		}else
		{
			return null;
		}
		
	}
	
	
		
	

}
