package com.krogerqa.appium.product_locator_app.common.dataBeans;

public class Login_TestDataBean {

	private String testName;
	private String username;
	private String password;
	private String errMsg;
	private String secureWEBPageTitle;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getSecureWEBPageTitle() {
		return secureWEBPageTitle;
	}

	public void setSecureWEBPageTitle(String secureWEBPageTitle) {
		this.secureWEBPageTitle = secureWEBPageTitle;
	}

}