package modules.QFund;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.LoanTransactions_VINValidation_PO;
import pageClasses.QFund.Qfund_Navigation;;

public class LoanTransactions_VINValidation_PR extends Helper{

	public LoanTransactions_VINValidation_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}
	public void vinValidation() throws Exception, Exception {
		LoanTransactions_VINValidation_PO objLoanTransactions_VINValidation_PO = new LoanTransactions_VINValidation_PO(driver,report);
		Qfund_Navigation.Loan_Transaction.VIN_Validation();
		
		if(data("VINnumber").equalsIgnoreCase("Random"))
		{
		String	VINno = 1+"GC"+"HC231"+"81F"+RandomStringUtils.randomNumeric(6);
		objLoanTransactions_VINValidation_PO.set_VINEnter(VINno);

		}else if(!data("VINnumber").isEmpty())
		{
			objLoanTransactions_VINValidation_PO.set_VINEnter(data("VINnumber"));
		}
		objLoanTransactions_VINValidation_PO.set_Miles(data("Miles"));
		objLoanTransactions_VINValidation_PO.click_VIN_GoSearchbtn("Y");
		assertAreEqual("Assertion for Alert Text "+data("alert_message"), report,objLoanTransactions_VINValidation_PO.getAlertTextmsg(data("alert_message")),data("alert_message"));

		
		System.out.println("Black Book Value:"+objLoanTransactions_VINValidation_PO.get_BlackBookValue("get"));
		System.out.println("Vehicle Make:"+objLoanTransactions_VINValidation_PO.get_Vehicle_Make("get"));
		System.out.println("Vehicle Model:"+objLoanTransactions_VINValidation_PO.get_Vehicle_Model("get"));
		System.out.println("Vehicle Year:"+objLoanTransactions_VINValidation_PO.get_Vehicle_Year("get"));
		System.out.println("Vehicle BodyType:"+objLoanTransactions_VINValidation_PO.get_Vehicle_BodyType("get"));
		
		updateDataSheet("VIN_BlackBookValue",objLoanTransactions_VINValidation_PO.get_BlackBookValue("get"));
		updateDataSheet("VIN_Vehicle_Make",objLoanTransactions_VINValidation_PO.get_Vehicle_Make("get"));
		updateDataSheet("VIN_Vehicle_Model",objLoanTransactions_VINValidation_PO.get_Vehicle_Model("get"));
		updateDataSheet("VIN_Vehicle_Year",objLoanTransactions_VINValidation_PO.get_Vehicle_Year("get"));
		updateDataSheet("VIN_Vehicle_BodyType",objLoanTransactions_VINValidation_PO.get_Vehicle_BodyType("get"));
					
	}
	
	}
