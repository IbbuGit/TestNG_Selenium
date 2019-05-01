package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.TitleLoanNegotiate_PO;
import pageClasses.QFund.TitleLoan_PO;

public class LoanTransactions_TitleLoan_PR extends Helper {

	public LoanTransactions_TitleLoan_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void titleLoan() throws Exception{

		TitleLoan_PO objTitleLoan_PO = new TitleLoan_PO(driver, report);
		
		objTitleLoan_PO.set_TitleLoan_VehTitleNbr(data("Title_Nbr"));
		objTitleLoan_PO.set_TitleLoan_VehRegState(data("Veh_RegState"));
		objTitleLoan_PO.set_TitleLoan_VehAppraisalVal(data("Veh_Appraisalval"));
		objTitleLoan_PO.click_TitleLoan_Update1(data("TitleLoan_Update1"));
		//assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objTitleLoan_PO.getAlertTextmsg(data("alert_message")),data("alert_message"));
		objTitleLoan_PO.set_TitleLoan_VehExteriorColor(data("Veh_Extcol"));
		objTitleLoan_PO.set_TitleLoan_VehLicPltNbr(data("Veh_PltNbr"));
		objTitleLoan_PO.set_TitleLoan_VehLicPltExp(data("Veh_LicPltExp"));
		
		objTitleLoan_PO.set_TitleLoan_VehPaintCond(data("Veh_PaintCond"));
		objTitleLoan_PO.set_TitleLoan_VehBodyCond(data("Veh_BodyCond"));
		objTitleLoan_PO.set_TitleLoan_VehGlassCond(data("Veh_GlassCond"));
		objTitleLoan_PO.set_TitleLoan_VehTyresCond(data("Veh_TyresCond"));
		
		objTitleLoan_PO.set_TitleLoan_VehInsType(data("Veh_InsType"));		
		objTitleLoan_PO.click_TitleLoan_Update2(data("TitleLoan_Update2"));
		objTitleLoan_PO.click_TitleLoan_ProcessLn(data("TitleLoan_ProcessLn"));
		objTitleLoan_PO.set_TitleLoan_CollateralType(data("Payment_CollType"));
		objTitleLoan_PO.click_TitleLoan_Eligibilty(data("TitleLoan_Eligibilty"));
		verifyAreEqual("Verifying Applicant has been denied Message", report,objTitleLoan_PO.checkApplicationDeniedMsg(data("title_EligibilityErrorMsg")), true);
		
		if(!data("Veh_NegoLnAmt").isEmpty())
		{
			TitleLoanNegotiate_PO objTitleLoanNegotiate_PO = new TitleLoanNegotiate_PO(driver, report);
			objTitleLoanNegotiate_PO.click_TitleLoan_Negotiate(data("TitleLoan_Negotiate"));
			objTitleLoan_PO.switchToChildWindow();
			objTitleLoanNegotiate_PO.set_TitleLoan_ReqLoanAmt(data("Veh_NegoLnAmt"));
			objTitleLoanNegotiate_PO.click_TitleLoan_Recalculate(data("TitleLoan_Recalculate"));
			objTitleLoanNegotiate_PO.click_TitleLoan_SelectNegoAmt(data("TitleLoan_SelectNegoAmt"));
			objTitleLoan_PO.switchToParentWindow();
			
		}
		objTitleLoan_PO.set_TitleLoan_DisbType(data("Disb_Type"));
		objTitleLoan_PO.set_TitleLoan_DisbAmt(data("Disb_Amt"));
		objTitleLoan_PO.set_TitleLoan_DisbTypeTwo(data("DisbTypeTwo"));
		objTitleLoan_PO.set_TitleLoan_DisbAmtTwo(data("DisbAmtTwo"));
		objTitleLoan_PO.set_TitleLoan_VehEmailConst(data("Veh_EmailConst"));
		objTitleLoan_PO.set_TitleLoan_ThirdpartyDisb_Payee(data("ThirdPartyDisb_Payee"));
		objTitleLoan_PO.set_TitleLoan_ThirdpartyDisb_Amt(data("ThirdPartyDisb_Amt"));
		
		// Amortization
		objTitleLoan_PO.click_TitleLoan_Amortization(data("Amortization_Disp"));
		//objTitleLoan_PO.set_TitleLoan_DrawerPwd(data("Drawer_Pwd"));
		
		objTitleLoan_PO.set_TitleLoan_DrawerPwd(data("Drawer_Pwd"));
		objTitleLoan_PO.click_TitleLoan_FinishLoan(data("TitleLoan_FinishLoan"));
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objTitleLoan_PO.get_ErrorMsg(data("alert_message")),data("alert_message"));
		objTitleLoan_PO.click_TitleLoan_Confirm(data("TitleLoan_Confirm"));
		

	}
}

