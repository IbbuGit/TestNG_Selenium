package com.krogerqa.appium.product_locator_app.remove_from_inventory.dataBeans;

public class Remove_From_Inventory_TestDataBean {

    public String textCountTitle;
    private String testName;
    private String login_Data;
    private String productToScan;
    private String mainMenuPageTitle;
    private String enterUPC;
    private String productsToScan;
    private String scanproductScreen;
    private String manualOrScan;
    private String messageTitle;
    private String reclamationMessage,limitedSticker;
    private String incrVal;

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

    public String getProductToScan() {
        return productToScan;
    }

    public void setProductToScan(String productToScan) {
        this.productToScan = productToScan;
    }

    public String getMainMenuPageTitle ( ) { return mainMenuPageTitle; }

    public void setEnterUPC(String enterUPC) {
        this.enterUPC = enterUPC;
    }

    public String getEnterUPCText() {
        return enterUPC;
    }

    public String getProductsToScan ( ) {
        return productsToScan;
    }
    public void setProductsToScan ( String productsToScan ) {
        this.productsToScan
                = productsToScan;
    }
    public String getScanproductScreen() {
        return scanproductScreen;
    }
    public void setScanproductScreen(String scanproductScreen) {
        this.scanproductScreen = scanproductScreen;
    }
    public String getManualOrScan() {
        return manualOrScan;
    }
    public String getReclamationMessage() {
        return reclamationMessage;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getLimitedSticker(){
        return limitedSticker;
    }
    public String getTextCountTitle(){return textCountTitle;}
    public String getIncrVal(){return incrVal;}
}