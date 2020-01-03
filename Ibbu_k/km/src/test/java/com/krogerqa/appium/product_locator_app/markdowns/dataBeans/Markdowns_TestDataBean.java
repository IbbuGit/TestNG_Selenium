package com.krogerqa.appium.product_locator_app.markdowns.dataBeans;

public class Markdowns_TestDataBean {

    private String testName;
    private String login_Data;
    private String productToScan;
    private String mainMenuPageTitle;
    private String markdownsPageTitle;
    private String enterAmountPageTitle;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getLogin_Data() {
        return login_Data;
    }

    public void setLogin_Data(String login_Data) {
        this.login_Data = login_Data;
    }

    public String getproductToScan() {
        return productToScan;
    }

    public void setManualEnterUPCOrPLU(String productToScan) {
        this.productToScan = productToScan;
    }

    public String getMainMenuPageTitle() {
        return mainMenuPageTitle;
    }

    public void setMainMenuPageTitle(String mainMenuPageTitle) {
        this.mainMenuPageTitle = mainMenuPageTitle;
    }

    public String getMarkdownsPageTitle() {
        return markdownsPageTitle;
    }

    public void setMarkdownsPageTitle(String markdownsPageTitle) {
        this.markdownsPageTitle = markdownsPageTitle;
    }


    public String getEnterAmountPageTitle() {
        return enterAmountPageTitle;
    }

    public void setEnterAmountPageTitle(String enterAmountPageTitle) {
        this.enterAmountPageTitle = enterAmountPageTitle;
    }


}
