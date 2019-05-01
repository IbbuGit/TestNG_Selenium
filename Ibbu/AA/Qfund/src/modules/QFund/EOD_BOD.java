package modules.QFund;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;

public class EOD_BOD extends Helper {

	LinkedHashMap<String, String> tempData;

	public EOD_BOD(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver, data, report);
		tempData = data;
	}


	public void EOD() throws Exception{

		ulterDataAndProcess(getData("loginApplication",tempData.get("EOD.loginApplication_Admin"), tempData),"loginApplication");
		new LoginQfundX_PR(driver,allProcessData,report).loginApplication();

		ulterDataAndProcess(getData("adminDrawerDessign",tempData.get("EOD.adminDrawerDessign"), tempData),"adminDrawerDessign");
		new CashManagement_Drawer(driver,allProcessData,report).adminDrawerDessign();

		ulterDataAndProcess(getData("loginApplication",tempData.get("EOD.loginApplication_Qfund_Safe"), tempData),"loginApplication");
		new LoginQfundX_PR(driver,allProcessData,report).loginApplication();

		ulterDataAndProcess(getData("safeCheck","DeAssign_Safe", tempData),"safeCheck");
		new CashManagement_SafeDrawer_Check(driver,allProcessData,report).safeCheck();

		ulterDataAndProcess(getData("safeAssign","CommonSafeAssign", tempData),"safeAssign");
		new CashManagement_Safe(driver,allProcessData,report).safeAssign();

		ulterDataAndProcess(getData("safeBalance","CommonSafeBalance", tempData),"safeBalance");
		new CashManagement_Safe(driver,allProcessData,report).safeBalance();

		ulterDataAndProcess(getData("safeDeposit","CommonSafeDep", tempData),"safeDeposit");
		new CashManagement_Safe(driver,allProcessData,report).safeDeposit();

		ulterDataAndProcess(getData("eodProcessing","Commoneod", tempData),"eodProcessing");
		new DailyProcessing_EOD_PR(driver,allProcessData,report).eodProcessing();
		
	}

	public void BOD() throws Exception{


		ulterDataAndProcess(getData("loginApplication",tempData.get("BOD.loginApplication_Admin"), tempData),"loginApplication");
		new LoginQfundX_PR(driver,allProcessData,report).loginApplication();

		ulterDataAndProcess(getData("storeStatusChange",tempData.get("BOD.storeStatusChange"), tempData),"storeStatusChange");
		new AdminTransaction_QAJobs_ProcessDateChange_PR(driver,allProcessData,report).storeStatusChange();
		
		ulterDataAndProcess(getData("logoutApplication","Common_Logout", tempData),"logoutApplication");
		new LoginQfundX_PR(driver,allProcessData,report).logoutApplication();
		
		driver.manage().deleteAllCookies();
		
		ulterDataAndProcess(getData("loginApplication",tempData.get("BOD.loginApplication_Qfund_Safe"), tempData),"loginApplication");
		new LoginQfundX_PR(driver,allProcessData,report).loginApplication();
		
		ulterDataAndProcess(getData("safeCheck","DeAssign_Safe", tempData),"safeCheck");
		new CashManagement_SafeDrawer_Check(driver,allProcessData,report).safeCheck();
		
		ulterDataAndProcess(getData("safeAssign","CommonSafeAssign", tempData),"safeAssign");
		new CashManagement_Safe(driver,allProcessData,report).safeAssign();
		
		ulterDataAndProcess(getData("clockOut","autoClockOut", tempData),"clockOut");
		new LoginQfundX_PR(driver,allProcessData,report).clockOut();
		
		ulterDataAndProcess(getData("loginApplication",tempData.get("BOD.loginApplication_Qfund_Drawer"), tempData),"loginApplication");
		new LoginQfundX_PR(driver,allProcessData,report).loginApplication();
		
		ulterDataAndProcess(getData("drawerCheck","DeAssign_Drawer", tempData),"drawerCheck");
		new CashManagement_SafeDrawer_Check(driver,allProcessData,report).drawerCheck();
		
		ulterDataAndProcess(getData("drawerAssign","CommonDrawerAssign", tempData),"drawerAssign");
		new CashManagement_Drawer(driver,allProcessData,report).drawerAssign();
		
	}


}
