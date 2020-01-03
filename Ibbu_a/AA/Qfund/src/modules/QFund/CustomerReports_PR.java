package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.QFund.CustomerReports_PO;
import pageClasses.QFund.Qfund_Navigation;

public class CustomerReports_PR extends Helper{
	
	public CustomerReports_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest _report) {
		super(_driver, data, _report);
	}
	
	public void customerReports() throws Exception {
				
		switch(data("ReportType")) {
		
		case "bankruptedCustomers":
			bankruptReport();
			saveInLocation();
			break;
			
			
			
		
		}
		
		
	}
	
	public void bankruptReport() throws Exception {
		CustomerReports_PO objCustomerReports_PO= new CustomerReports_PO(driver, report);
		Qfund_Navigation.Reports_Tab.CustomerReports.BankruptcyReport();
		objCustomerReports_PO.set_customerReports_beginMonth(data("beginMonth"));
		objCustomerReports_PO.set_customerReports_beginDay(data("beginDay"));
		objCustomerReports_PO.set_customerReports_beginYear(data("beginYear"));
		objCustomerReports_PO.set_customerReports_endMonth(data("endMonth"));
		objCustomerReports_PO.set_customerReports_endDay(data("endDay"));
		objCustomerReports_PO.set_customerReports_endYear(data("endYear"));
		objCustomerReports_PO.click_customerReports_btnPreview(data("PreviewBtn"));
		objCustomerReports_PO.click_GenerateExcel(data("GenerateExcel"));

	}
	
	public void saveInLocation() throws Exception {
		CustomerReports_PO objCustomerReports_PO= new CustomerReports_PO(driver, report);
		try {
			objCustomerReports_PO.saveAs_Robot(data("ReportType"));
			} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
