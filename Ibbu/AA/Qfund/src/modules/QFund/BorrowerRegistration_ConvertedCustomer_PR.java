
package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import framework.Helper;
import pageClasses.QFund.BorrowerRegistrationBanking_PO;
import pageClasses.QFund.BorrowerRegistrationIncome_PO;
import pageClasses.QFund.BorrowerRegistrationOthers_PO;
import pageClasses.QFund.BorrowerRegistrationPersonal_PO;
import pageClasses.QFund.Qfund_Navigation;

public class BorrowerRegistration_ConvertedCustomer_PR extends Helper {
	LinkedHashMap<String, String> tempData;
	String CustomerNbr, SSN, FirstName, LastName, Phone_Nbr, Email;

	public BorrowerRegistration_ConvertedCustomer_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		tempData = data;
	}

	public void brwrRegisterCustomer() throws Exception {
		int NoOfCus = Integer.parseInt(tempData.get("brwrRegisterCustomer.NoOfCustomer"));
		for (int i = 1; i <= NoOfCus; i++) {
			try {
				ulterDataAndProcess(getData("brwrRegPersonalInfo",
						// tempData.get("brwrRegisterCustomer.Customer_LoanType")
						// + "_Customer_Reg", tempData),
						tempData.get("brwrRegisterCustomer.Customer_LoanType") + i, tempData), "brwrRegPersonalInfo");
				brwrRegPersonalInfo_conv();
				ulterDataAndProcess(
						getData("brwrRegIncome",
								tempData.get("brwrRegisterCustomer.Customer_LoanType") + "_Customer_Reg", tempData),
						"brwrRegIncome");
				brwrRegIncome_conv();
				ulterDataAndProcess(
						getData("brwrRegBanking",
								tempData.get("brwrRegisterCustomer.Customer_LoanType") + "_Customer_Reg", tempData),
						"brwrRegBanking");
				brwrRegBanking_conv();
				ulterDataAndProcess(getData("brwrRegOthers", "Customer_Reg_NoNewloan", tempData), "brwrRegOthers");
				brwrRegOthers_Conv();

//				updateOutputDataSheet(
//						"INSERT INTO Customer(CustomerNbr,TypeOfCustomer,Status,SSN,FirstName,LastName,Phone_Nbr,Email) VALUES"
//								+ "('" + CustomerNbr + "','" + tempData.get("brwrRegisterCustomer.Customer_LoanType")
//								+ "','New','" + SSN + "','" + FirstName + "','" + LastName + "','" + Phone_Nbr + "','"
//								+ Email + "')");
			} catch (Exception e) {
			}
		}
	}

	public void brwrRegPersonalInfo_conv() throws Exception {
		BorrowerRegistrationPersonal_PO objBorrowerRegistrationPersonal_PO = new BorrowerRegistrationPersonal_PO(driver,
				report);
		
			objBorrowerRegistrationPersonal_PO.acceptAlert();
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_monthsAtAddress_TestBox(data("Reg_MonthsAtAddress"));
			objBorrowerRegistrationPersonal_PO
					.click_BrwrRegPrsnl_sameasmailaddress(data("BrwrRegPrsnl_sameasmailaddress"));
			objBorrowerRegistrationPersonal_PO.click_BrwrRegPrsnl_sameasmailaddress("Y");
			objBorrowerRegistrationPersonal_PO.BrwrRegPrsnl_Regemailcheck(data("Reg_Email"));
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_Regemail(data("Reg_Email"), FirstName, LastName);
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_PhotoIdNbr(data("Reg_PhotoID_Nbr"));
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_IdZipCode_clear("Y");
			objBorrowerRegistrationPersonal_PO.acceptAlert();
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_PhotoIDState_Dropdown(data("Reg_PhotoID_State"));
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_IdExpiry(data("Reg_IdExpiry"));
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_PhotoIdType_Dropdown(data("Reg_PhotoID_Type"));
			objBorrowerRegistrationPersonal_PO.set_BrwrRegPrsnl_ApplicationDate("Reg_App_Date");

		
	}

	public void brwrRegIncome_conv() throws Exception {

		BorrowerRegistrationIncome_PO objBorrowerRegistrationIncome_PO = new BorrowerRegistrationIncome_PO(driver,
				report);
		
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_WorkPhone1("985");
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_WorkPhone2(getRandomNumeric(3));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_WorkPhone3(getRandomNumeric(4));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_GrossIncomeAmt(data("Gross_Income_Amt"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_PayFrequescy(data("Pay_Frequency"));

			// objBorrowerRegistrationIncome_PO.click_BrwrRegIncm_WeekDay_Frequency(data("BrwrRegIncm_WeekDay_Frequency"));
			// objBorrowerRegistrationIncome_PO.click_BrwrRegIncm_semiMonthly_Option(data("BrwrRegIncm_semiMonthly_Option"));

			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubReviewdMonth(data("Stub_Reviewed_Month"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubReviewdDay(data("Stub_Reviewed_Day"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubReviewdYear(data("Stub_Reviewed_Year"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubMonth(data("Stub_Month"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubDay(data("Stub_Day"));
			objBorrowerRegistrationIncome_PO.set_BrwrRegIncm_payStubYear(data("Stub_Year"));

	 
		}

	public void brwrRegBanking_conv() throws Exception {
		BorrowerRegistrationBanking_PO objBorrowerRegistrationBanking_PO = new BorrowerRegistrationBanking_PO(driver,
				report);
	
			Qfund_Navigation.Borrower.Registration.Banking();
			objBorrowerRegistrationBanking_PO.click_BrwrRegBnkng_Editgo("Y");

			objBorrowerRegistrationBanking_PO
					.set_BrwrRegBnkng_accountVerificationMonth(data("Reg_AccVerificationMonth"));
			objBorrowerRegistrationBanking_PO.set_BrwrRegBnkng_accountVerificationDay(data("Reg_AccVerificationDay"));
			objBorrowerRegistrationBanking_PO.set_BrwrRegBnkng_accountVerificationYear(data("Reg_AccVerificationYear"));
			objBorrowerRegistrationBanking_PO.set_BrwrRegBnkng_bankStatementEndDate_clear("Y");
			objBorrowerRegistrationBanking_PO.click_BrwrRegBnkng_Update("Y");
			objBorrowerRegistrationBanking_PO.acceptAlert();
	

	}

	public void brwrRegOthers_Conv() throws Exception {

		BorrowerRegistrationOthers_PO objBorrowerRegistrationOthers = new BorrowerRegistrationOthers_PO(driver, report);
				
			objBorrowerRegistrationOthers.click_BrwrRegOthers_next_Button();
			objBorrowerRegistrationOthers.click_BrwrRegOthers_next_Button();
			objBorrowerRegistrationOthers.click_BrwrRegOthers_NewLoan_button("Y");

			assertAreEqual("verify SubmitButton", report, objBorrowerRegistrationOthers.isDisplayed_BrwrRegOthers_custNbr(),
				true);

		CustomerNbr = objBorrowerRegistrationOthers.get_BrwrRegOthers_custNbr();

		updateDataSheet("BrwrRegOthers_CustNbr", objBorrowerRegistrationOthers.get_BrwrRegOthers_custNbr());

		}

}
