package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.Online_PayDayLoanPayment_PO;

public class Online_PayDayLoanPayment_PR extends Helper {
	
	public Online_PayDayLoanPayment_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}
	
	public void PartialPayment_Online() throws Exception {
		Online_PayDayLoanPayment_PO objOnline_PayDayLoanPayment_PO= new Online_PayDayLoanPayment_PO(driver, report);
		objOnline_PayDayLoanPayment_PO.click_MakeAPaymentButton(data("MakeAPaymentButton"));
		//objOnline_PayDayLoanPayment_PO.set_SelectMethod(data("PaymentMethod"), objOnline_PayDayLoanPayment_PO.MakeAPayment_PaymentMethod);
		objOnline_PayDayLoanPayment_PO.SelectMethod(data("PaymentMethod"),objOnline_PayDayLoanPayment_PO.MakeAPayment_PaymentMethod);
		objOnline_PayDayLoanPayment_PO.SelectMethod(data("PaymentOption"), objOnline_PayDayLoanPayment_PO.MakeAPayment_PaymentOption);
		objOnline_PayDayLoanPayment_PO.set_MakeAPayment_PaymentAmount(objOnline_PayDayLoanPayment_PO.get_MakeAPayment_CurrentBalance("Get"));
		objOnline_PayDayLoanPayment_PO.set_MakeAPayment_PaymentDate(data("PaymentDate"));
		//objOnline_PayDayLoanPayment_PO.click_MakeAPayment_PayNowBtn(data("PayNow"));
	}

}
