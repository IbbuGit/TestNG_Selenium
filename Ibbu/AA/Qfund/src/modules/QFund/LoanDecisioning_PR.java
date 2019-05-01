package modules.QFund;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.LoanDecisioning_PO;

public class LoanDecisioning_PR extends Helper {

	public LoanDecisioning_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);
	}

	public void LoanDecisioningProcess() throws Exception {
		LoanDecisioning_PO objLoanDecisioning_PO = new LoanDecisioning_PO(driver, report);

		objLoanDecisioning_PO.click_OptInOutWindowClose(data("OptInOutPopUp_Close"));
		if (!data("ProductType").equals("InstallmentLoan")&&!data("ProductType").equals("PayDayLoan")) {
		objLoanDecisioning_PO.set_LoanDec_VehicleType(data("Veh_Type"));
		objLoanDecisioning_PO.set_LoanDec_VehicleVIN(data("Veh_VIN_Drop"));
		String VIN = null;
		if (data("VIN_Number").equalsIgnoreCase("Random")) {

			VIN = "2B4FK45J3KR" + RandomStringUtils.randomNumeric(6);

			// VIN = 1+"GC"+"HC231"+"81F"+RandomStringUtils.randomNumeric(6);
		} else {
			VIN = data("VIN_Number");
		}

		objLoanDecisioning_PO.set_LoanDec_VINNumber(VIN);
		objLoanDecisioning_PO.set_LoanDec_VINNumberConfirm(VIN);

		updateDataSheet("VIN", VIN);

		objLoanDecisioning_PO.click_LoanDec_Continue(data("LoanDec_Continue"));
		objLoanDecisioning_PO.set_LoanDec_VehMiles(data("Veh_Miles"));
		objLoanDecisioning_PO.click_LoanDec_HitBlackBook(data("LoanDec_HitBlackBook"));
		}
		objLoanDecisioning_PO.click_LoanDec_Prodsel(data("LoanDec_Prodsel"));
		//updateDataSheet("LD_Product", data("LoanDec_Prodsel"));

		objLoanDecisioning_PO.click_selectLOCLoan(data("selectLOCLoan"));
		
		if (objLoanDecisioning_PO.isDisplayed_selectPayDayLoan()) {
			objLoanDecisioning_PO.click_selectPayDayLoan(data("selectPayDayLoan"));	
		}
		
		
		//objLoanDecisioning_PO.click_selectInstallmentLoanTerm1(data("selectInstallmentLoanTerm1"));

		objLoanDecisioning_PO.click_HandleShareCustomer(data("ShareCustomer_Summary"), data("Confirm_Summary"));

		assertAreEqual("verify NewLoan", report, objLoanDecisioning_PO.isDisplayed_LoanDec_NewLoan(), true);

		objLoanDecisioning_PO.click_LoanDec_NewLoan(data("LoanDec_NewLoan"));

		// assertAreEqual("Verify "+data("LOC_ErrorMsg")+" Message", report,
		// objLoanDecisioning_PO.verify_ErrorMsg(data("LOC_ErrorMsg")), true);

	}

	public void customerDenial() throws Exception, Exception {
		LoanDecisioning_PO objLoanDecisioning_PO = new LoanDecisioning_PO(driver, report);

		objLoanDecisioning_PO.click_OptInOutWindowClose("Y");

		objLoanDecisioning_PO.click_DenyButton("Y");
		objLoanDecisioning_PO.switchToChildWindow();
		objLoanDecisioning_PO.click_CheckBox_DenyReason1(data("CheckBox_DenyReason1"));
		objLoanDecisioning_PO.click_CheckBox_DenyReason2(data("CheckBox_DenyReason2"));
		objLoanDecisioning_PO.click_CheckBox_DenyReason3(data("CheckBox_DenyReason3"));
		objLoanDecisioning_PO.click_CheckBox_DenyReason4(data("CheckBox_DenyReason4"));
		objLoanDecisioning_PO.click_Complete_DenyButton(data("click_Complete_DenyButton"));
		objLoanDecisioning_PO.acceptAlert();
		assertAreEqual("Verifying the Denial Msg", report, objLoanDecisioning_PO.get_Denial_msg("Denial_msg"),
				data("Denial_msg"));
		objLoanDecisioning_PO.closeWindow();
		objLoanDecisioning_PO.switchToParentWindow();

	}

}
