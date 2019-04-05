package core;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EventHandler implements WebDriverEventListener{
	ExtentTest Report = null;
	
	EventHandler(ExtentTest testReport) {
		this.Report=testReport;
	}
	
	String getWebElementMethod() {
		String name=null;
		StackTraceElement[] stack=Thread.currentThread().getStackTrace();
		
		for(int i=8;i<=stack.length;i++) {
			if(stack[i].getClassName().toUpperCase().contains("PAGECLASSES.")){
				name=stack[i].getMethodName();
				break;
			}
		}
		return name;
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		Report.log(LogStatus.INFO, "Application URL loaded "+url+" Succesfully");	
		System.out.println(LogStatus.INFO+" :Application URL loaded "+url+" Succesfully");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		String webElementMethodName=getWebElementMethod();
		
		if(webElementMethodName.toUpperCase().contains("CLICK")) {
			Report.log(LogStatus.INFO, "Clicked " + webElementMethodName.replace("click", ""));
		}else if(webElementMethodName.toUpperCase().contains("SELECT")) {
			Report.log(LogStatus.INFO, "Value selected from" + "[" + webElementMethodName.replace("select", "") + "]");
			System.out.println(LogStatus.INFO + ": Value selected from the menu" + "["
					+ webElementMethodName.replace("select", "") + "]");
		}			
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {		
		String webElementMethodName=getWebElementMethod().replace("enter", "");
		
		Report.log(LogStatus.INFO, "Value[" + keysToSend[0] + "] entered in" + "[" + webElementMethodName + "]");		
		System.out.println(LogStatus.INFO + ": Value[" + keysToSend[0] + "] set in" + "[" + webElementMethodName + "]");
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {		
		Report.log(LogStatus.FAIL, throwable.getMessage());		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		String webElementMethodName=getWebElementMethod().replace("get", "");
		Report.log(LogStatus.INFO, "Got text[" + text + "] from [" + webElementMethodName + "]");
		System.out.println(LogStatus.INFO + ": Got text[" + text + "] from [" + webElementMethodName + "]");
		
	}

}
