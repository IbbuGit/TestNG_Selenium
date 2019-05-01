
package modules.QFund;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.Helper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BorrowerRegistration_RestAPI extends Helper {
	LinkedHashMap<String,String> tempData;

	String	productCode,CustomerNbr,SSN,FirstName,LastName,MidleName,Phone_Nbr,Email,DOB,PhotoIdNbr,State,City,	postalCode,collateralType,payNextDateTime,secondPayDate;

	public BorrowerRegistration_RestAPI(WebDriver _driver,LinkedHashMap<String,String> data,ExtentTest report) {
		super(_driver,data,report);
	}

	public  void brwRegisterCustomerUsingAPI() throws Exception {


		FirstName=RandomStringUtils.randomAlphabetic(6);
		MidleName=RandomStringUtils.randomAlphabetic(3);
		LastName=RandomStringUtils.randomAlphabetic(6);
		SSN="411"+RandomStringUtils.randomNumeric(6);
		Phone_Nbr="988465758";
		productCode="ILP";
		Email=FirstName+LastName+"@gmail.com";
		DOB="1990-04-06";
		PhotoIdNbr="DL"+RandomStringUtils.randomNumeric(9);
		State="OH";
		City="cincinati";
		postalCode="43916";
		collateralType="ACH";
		payNextDateTime="2019-04-22";
		secondPayDate="2019-04-29";

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://svcsqa1.int.advanceamerica.net/services/Customer/v1/rs";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification request = RestAssured.given();

		// Add a header stating the Request body is a JSON
		request.header("Content-Type","application/json");
		request.header("X_ConsumerName","test");
		request.header("X_ConsumerTrackingId","test");

		JSONObject requestParams = new JSONObject();
		requestParams.put("ownAddress","O"); 
		requestParams.put("employmentStatus","A");		  
		requestParams.put("activeMilitary","N");
		requestParams.put("monthsAtAddress","0");		 

		requestParams.put("customerWebInfo",customerWebInfo());
		requestParams.put("customerInfo",customerInfo());

		// Add the Json to the body of the request
		request.body(requestParams.toString());		 

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = request.request(Method.POST,"/customerCreate");

		CustomerNbr=response.path("customerInfo.customerId");

		request=null;
		RestAssured.baseURI=null;
		RestAssured.baseURI = "https://svcsqa1.int.advanceamerica.net/services/EligibleProductOffers/v1/rs";
		request = RestAssured.given();

		// Add a header stating the Request body is a JSON
		request.header("Content-Type","application/json");
		request.header("X_ConsumerName","test");
		request.header("X_ConsumerTrackingId","test");


		JSONObject objC1_eligible = new JSONObject();
		objC1_eligible.put("secureToken","950001");		  
		objC1_eligible.put("customerId",CustomerNbr);
		objC1_eligible.put("applicationSource","WEB");
		objC1_eligible.put("promoApplied","FALSE");		  
		objC1_eligible.put("customerIp","198.25.86.12");
		objC1_eligible.put("collateralType",collateralType);
		objC1_eligible.put("productCode",productCode);

		JSONObject objState = new JSONObject();
		objState.put("code",State);

		objC1_eligible.put("stateCode", objState);
		request.body(objC1_eligible.toString());	
		response = request.request(Method.POST,"/eligibleProductOffersGet");

		updateDataSheet("CustomerNbr", CustomerNbr);
		
		report.log(LogStatus.INFO, "Customer created by REST API:"+CustomerNbr);
		System.out.println(LogStatus.INFO+": Customer created by REST API:"+CustomerNbr);
	}

	public JSONObject customerWebInfo() {
		JSONObject objP1 = new JSONObject();
		objP1.put("webPassword","Advance1!"); 

		JSONObject objC1_Sec = new JSONObject();
		objC1_Sec.put("thirdSecurityQuestionAnswer",JSONObject.NULL);		  
		objC1_Sec.put("secondSecurityQuestionAnswer",JSONObject.NULL);
		objC1_Sec.put("thirdSecurityQuestion",JSONObject.NULL);
		objC1_Sec.put("firstSecurityQuestionAnswer","test");		  
		objC1_Sec.put("secondSecurityQuestion",JSONObject.NULL);
		objC1_Sec.put("firstSecurityQuestion","1");

		objP1.put("securityQuestionsInfo",objC1_Sec);

		return objP1;		 
	}

	public JSONObject customerInfo() {

		JSONObject objP1_customerInfo = new JSONObject();
		objP1_customerInfo.put("incomes",incomes());
		objP1_customerInfo.put("addresses",addresses());
		objP1_customerInfo.put("identities",identities());
		objP1_customerInfo.put("bankings",bankings());
		objP1_customerInfo.put("references",references());
		objP1_customerInfo.put("dob",DOB);
		objP1_customerInfo.put("centerNumber",JSONObject.NULL);
		objP1_customerInfo.put("canMarketFlag",JSONObject.NULL);
		objP1_customerInfo.put("ssnEncrypted",RandomStringUtils.randomNumeric(9));

		JSONObject objC1_customerName = new JSONObject();

		objC1_customerName.put("firstName",FirstName);
		objC1_customerName.put("middleName",MidleName);
		objC1_customerName.put("lastName",LastName);
		objC1_customerName.put("fullName",FirstName+" "+MidleName+" "+LastName);


		objP1_customerInfo.put("customerName",objC1_customerName);
		objP1_customerInfo.put("canContactFlag",JSONObject.NULL);
		objP1_customerInfo.put("contacts",contacts());


		return objP1_customerInfo;
	}

	public JSONObject incomes() {
		JSONObject objP1_incomes = new JSONObject();
		objP1_incomes.put("payNextDateTime",payNextDateTime);
		objP1_incomes.put("secondPayDate",secondPayDate);
		objP1_incomes.put("employerAddress",JSONObject.NULL); 

		JSONObject objC1_incomeType = new JSONObject();
		objC1_incomeType.put("code","FULLTIME");
		objC1_incomeType.put("description",JSONObject.NULL);

		JSONObject objC2_payFrequency = new JSONObject();
		objC2_payFrequency.put("code","WEEKLY");
		objC2_payFrequency.put("description",JSONObject.NULL);

		objP1_incomes.put("incomeType",objC1_incomeType);
		objP1_incomes.put("payFrequency",objC2_payFrequency);		 
		objP1_incomes.put("employerName","Emp"); 
		objP1_incomes.put("employerCanContact","true");
		objP1_incomes.put("isDirectDeposit","true");
		objP1_incomes.put("directDepositAccount",JSONObject.NULL);         
		objP1_incomes.put("annualGrossIncome","0");
		objP1_incomes.put("payStubDateTime",JSONObject.NULL);
		objP1_incomes.put("netIncomeForPeriod","3500");
		objP1_incomes.put("grossIncomeForPeriod","4500");
		objP1_incomes.put("employeeMonthsOfService",JSONObject.NULL);
		objP1_incomes.put("payOccurrence",JSONObject.NULL);
		objP1_incomes.put("employeeJobTitle","NA");
		objP1_incomes.put("status","CURRENT");
		objP1_incomes.put("employerPhoneNumber","8088088088");

		JSONObject objR_incomes = new JSONObject();
		objR_incomes.put("incomes",new JSONArray().put(objP1_incomes));
		return objR_incomes;
	}

	public JSONObject addresses() {
		JSONObject objP1_addresses = new JSONObject();
		objP1_addresses.put("city","BBVFNLDBVYasd"); 

		JSONObject objC1_addressType= new JSONObject();
		objC1_addressType.put("code","MAILING");
		objC1_addressType.put("description",JSONObject.NULL);

		objP1_addresses.put("addressType",objC1_addressType); 
		objP1_addresses.put("postalCode",postalCode);
		objP1_addresses.put("addressLine1","123 VWABE"); 

		JSONObject objC2_State= new JSONObject();
		objC2_State.put("code",State);
		objC2_State.put("description",JSONObject.NULL);

		objP1_addresses.put("state",objC2_State); 
		objP1_addresses.put("countryType",JSONObject.NULL);

		JSONObject objR_addresses = new JSONObject();
		objR_addresses.put("addresses",new JSONArray().put(objP1_addresses));

		return objR_addresses;
	}

	public JSONObject identities() {

		JSONObject objP1_identities = new JSONObject();
		objP1_identities.put("number",PhotoIdNbr);
		objP1_identities.put("expiresDateTime","2022-07-06T12:31:03.000-05:00"); 

		JSONObject objC1_identityType = new JSONObject();
		objC1_identityType.put("code","DRIVERS_LICENSE");

		JSONObject objC2_issuingCountry = new JSONObject();
		objC2_issuingCountry.put("code","USA");
		objC2_issuingCountry.put("description","United States of America");

		JSONObject objC3_issuingAuthorityType = new JSONObject();
		objC3_issuingAuthorityType.put("code","STATE_DMV");

		JSONObject objC4_issuingState = new JSONObject();
		objC4_issuingState.put("code","TN");
		objC4_issuingState.put("description","Tennessee");

		objP1_identities.put("identityType",objC1_identityType);
		objP1_identities.put("issuingCountry",objC2_issuingCountry);
		objP1_identities.put("issuedDateTime","2018-07-06T12:31:03.000-05:00"); 
		objP1_identities.put("issuingAuthorityType",objC3_issuingAuthorityType);
		objP1_identities.put("issuingState",objC4_issuingState);

		JSONObject objR_identities = new JSONObject();	
		objR_identities.put("identities",new JSONArray().put(objP1_identities));

		return objR_identities;
	}

	public JSONObject bankings() {

		JSONObject objP1_bankings = new JSONObject();
		objP1_bankings.put("statementEndBal",JSONObject.NULL);
		objP1_bankings.put("statementEndDate",JSONObject.NULL); 

		JSONObject objC1_statementType = new JSONObject();
		objC1_statementType.put("code","MONTHLY");
		objC1_statementType.put("description",JSONObject.NULL);

		JSONObject objC2_account = new JSONObject();
		objC2_account.put("abaNumber","071921891");
		objC2_account.put("accountStatusType",JSONObject.NULL);		 
		JSONObject objC2C1_accountType = new JSONObject();
		objC2C1_accountType.put("code","CHECKING");
		objC2C1_accountType.put("description",JSONObject.NULL);
		objC2_account.put("accountType",objC2C1_accountType);
		objC2_account.put("accountNumber",RandomStringUtils.randomNumeric(8));

		objP1_bankings.put("statementType",objC1_statementType);		 
		objP1_bankings.put("account",objC2_account);		

		JSONObject objR_bankings = new JSONObject();
		objR_bankings.put("bankings",new JSONArray().put(objP1_bankings));

		return objR_bankings;
	}

	public JSONObject references() {

		JSONObject objP1_references = new JSONObject();

		JSONObject objC1_addressCountry = new JSONObject();
		objC1_addressCountry.put("code","USA");

		JSONObject objC2_phoneType = new JSONObject();
		objC2_phoneType.put("code","HOME");

		JSONObject objC3_addressType = new JSONObject();
		objC3_addressType.put("code","PHYSICAL");	 

		JSONObject objC4_addressState = new JSONObject();
		objC4_addressState.put("code","SC");

		JSONObject objC5_relationship = new JSONObject();
		objC5_relationship.put("code","FRIEND");
		objC5_relationship.put("description","Friend");


		objP1_references.put("addressCountry",objC1_addressCountry);
		objP1_references.put("firstName","sOUQF");
		objP1_references.put("lastName","faeaf");
		objP1_references.put("phoneType",objC2_phoneType);
		objP1_references.put("phoneNumber","5998839977");
		objP1_references.put("addressType",objC3_addressType);
		objP1_references.put("addressState",objC4_addressState);
		objP1_references.put("relationship",objC5_relationship);

		JSONObject objR_references = new JSONObject();
		objR_references.put("references",new JSONArray().put(objP1_references));

		return objR_references;
	}

	public JSONObject contacts() {

		JSONObject objP1_contacts = new JSONObject();
		objP1_contacts.put("contactNumber",JSONObject.NULL);
		objP1_contacts.put("preferredFlag","true");

		JSONObject objP1C1_contactType = new JSONObject();
		objP1C1_contactType.put("code","EMAIL");
		objP1C1_contactType.put("description",JSONObject.NULL);

		objP1_contacts.put("contactType",objP1C1_contactType);
		objP1_contacts.put("canMarketFlag","true");		
		objP1_contacts.put("addr",Email);
		objP1_contacts.put("allowAcctMaintenanceFlag","true");
		objP1_contacts.put("canContactFlag","true");

		JSONObject objP2_contacts = new JSONObject();
		Phone_Nbr=RandomStringUtils.randomNumeric(10);
		objP2_contacts.put("contactNumber",Phone_Nbr);
		objP2_contacts.put("preferredFlag","true");

		JSONObject objP2C1_contactType = new JSONObject();
		objP2C1_contactType.put("code","MESSAGE");
		objP2C1_contactType.put("description",JSONObject.NULL);

		objP2_contacts.put("contactType",objP2C1_contactType);
		objP2_contacts.put("canMarketFlag","true");
		objP2_contacts.put("addr",JSONObject.NULL);
		objP2_contacts.put("allowAcctMaintenanceFlag","true");
		objP2_contacts.put("canContactFlag","true");

		JSONArray contactArray = new JSONArray();
		contactArray.put(objP1_contacts);
		contactArray.put(objP2_contacts);

		JSONObject objR_contacts = new JSONObject();
		objR_contacts.put("contacts",contactArray);

		return objR_contacts;
	}

}
