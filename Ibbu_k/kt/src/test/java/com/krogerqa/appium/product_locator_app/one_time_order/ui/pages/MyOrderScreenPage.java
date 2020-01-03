
/**
 * Test case to verify the My Order screen
 * ALM test case -1318
 * Created by -Raguapthi(syl7525)
 */

package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.MyOrderScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class MyOrderScreenPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private MyOrderScreenPageMap myOrderScreenPage;
    HashMap<String, String> mapProductCount = new HashMap<String, String>();

    public MyOrderScreenPage() {
        myOrderScreenPage = new MyOrderScreenPageMap();
    }

    public void navigateBack() {
        mobileCommands.browserBack();
    }

    public void validateMyOrderHeaderTxt(String myOrderTitle) {
        mobileCommands.assertElementText(myOrderScreenPage.myOrderHeader(), myOrderTitle, true);
    }

    public void validateAndClickProductCard() {
        mobileCommands.assertElementDisplayed(myOrderScreenPage.productCard(), true);
        mobileCommands.click(myOrderScreenPage.productCard());
    }

    public void validateMyOrderUpc(String myOrderUPC) {
        mobileCommands.assertElementText(myOrderScreenPage.txtUpcNumber(), myOrderUPC, true);
    }

    public void validateProductName(String myOrderProductName) {
        mobileCommands.assertElementText(myOrderScreenPage.txtProductName(), myOrderProductName, true);
    }

    public void validateTrashIcon() {
        mobileCommands.assertElementDisplayed(myOrderScreenPage.txtTrashIcon(), true);
    }

    public void clickTrash() {
        mobileCommands.click(myOrderScreenPage.txtTrashIcon());
    }

    public void validateAndClickSubmitBtn(String myOrderSubmit) {
        mobileCommands.assertElementText(myOrderScreenPage.btnSubmit(), myOrderSubmit, true);
        mobileCommands.click(myOrderScreenPage.btnSubmit());
    }

    public void validateAndClickPopupSubmitBtn(String myOrderSubmitOrderPopup) {
        mobileCommands.assertElementText(myOrderScreenPage.optSubmitBtn(), myOrderSubmitOrderPopup, true);
        mobileCommands.click(myOrderScreenPage.optSubmitBtn());
    }

    public void clickAddMoreBtn() {
        mobileCommands.click(myOrderScreenPage.txtBtnAddMore());
    }

    public void ClickWithoutCancelBtn() {
        //Common method is not available in Bass commands
        WebDriver driver = mobileCommands.getWebDriver();
        if ((driver.findElements(myOrderScreenPage.withoutSubmit()).size() > 0)) {
            mobileCommands.click(myOrderScreenPage.withoutSubmit());
        }
    }

    public void validateExitWithoutSubmittingTitle(String titleExitWithoutSubmitting) {
        mobileCommands.assertElementText(myOrderScreenPage.titleExitWithoutSubmitting(), titleExitWithoutSubmitting, true);
    }

    public void validateExitWithoutSubmittingMsg(String msgExitWithoutSubmitting) {
        mobileCommands.assertElementText(myOrderScreenPage.msgExitWithoutSubmitting(), msgExitWithoutSubmitting, true);
    }

    public void validateRemoveProductTitle(String titleRemoveProduct) {
        mobileCommands.assertElementText(myOrderScreenPage.titleRemoveProduct(), titleRemoveProduct, true);
    }

    public void validateRemoveProductMsg(String msgRemoveProduct) {
        mobileCommands.assertElementText(myOrderScreenPage.msgRemoveProduct(), msgRemoveProduct, true);
    }

    public void clickCancel() {
        mobileCommands.waitForElement(myOrderScreenPage.btnCancel());
        mobileCommands.click(myOrderScreenPage.btnCancel());
    }

    public void clickExit() {
        mobileCommands.waitForElement(myOrderScreenPage.btnExit());
        mobileCommands.click(myOrderScreenPage.btnExit());
    }

    public void clickSubmit() {
        mobileCommands.waitForElement(myOrderScreenPage.btnSubmit());
        mobileCommands.click(myOrderScreenPage.btnSubmit());
    }
    private int totalProductsToSubmit(){
        return Integer.parseInt(mobileCommands.element(myOrderScreenPage.txtTotalProducts()).getText().split(" ")[0]);
    }
    public HashMap<String, String> getListProductcount(){
        int totalProducts = totalProductsToSubmit();
        int i=1;
        do{
            List<WebElement> productUPC = mobileCommands.elements(myOrderScreenPage.txtUpcNumber());
            List<WebElement> productCount = mobileCommands.elements(myOrderScreenPage.txtProductCount());
            int index=0;
            int count = 0;
            for(WebElement ele: productUPC){
                String upc= ele.getText();
                try{
                    count= Integer.parseInt(productCount.get(index).getText().split(" ")[0]);
                    index++;
                }catch(Exception ignored){

                }
                if(index <= productCount.size()){
                    if (!mapProductCount.containsKey(upc)) {
                        mapProductCount.put(upc,String.valueOf(count));
                    }
                }
            }
            BaseUtil.scroll("down");
            i++;
        }while(i<=totalProducts-2);
        return mapProductCount;
    }
    //iN CASE OF PENDING ORDERS clicking on dialog submit
    public void clickDialogSubmit(){
        try{
            if(mobileCommands.elements(myOrderScreenPage.btnDialogSubmit()).size()>0){
                mobileCommands.click(myOrderScreenPage.btnDialogSubmit());
            }
        }catch(Exception ignored){

        }
    }

    public void clickItemToUpdate() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> productUPC = mobileCommands.elements(myOrderScreenPage.txtUpcNumber());
        productUPC.get(0).click();
    }
    public String clickItemToDelete() {
        //Thread.sleep(5000);
        List<WebElement> deleteUPC = mobileCommands.elements(myOrderScreenPage.txtTrashIcon());
        List<WebElement> upcMyOrder = mobileCommands.elements(myOrderScreenPage.txtUpcNumber());
        String upc = upcMyOrder.get(0).getText();
        deleteUPC.get(0).click();
        return upc;
    }
    public void clickDialogRemove() throws InterruptedException {
        Thread.sleep(1000);
        mobileCommands.click(myOrderScreenPage.btnDialogRemove());
    }
    public void clickDialogExitWOSubmiting(){
        mobileCommands.click(myOrderScreenPage.btnExit());
    }
    public void clickBack(){
        mobileCommands.click(myOrderScreenPage.back());
    }

}