
/**
 * Test case to verify the Thank you screen
 * ALM test case -2519
 * Created by -Raguapthi(syl7525)
 */

package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.ThankYouScreenPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderSummaryPage {
    MobileCommands mobileCommands = new MobileCommands();
    ThankYouScreenPageMap thankyouscreenpagemap;


    public OrderSummaryPage() {
        thankyouscreenpagemap = new ThankYouScreenPageMap();
    }

    public void validateOrderSummaryHeaderTxt(String OrderSummaryheader){
        mobileCommands.waitForElementClickability(thankyouscreenpagemap.orderSummary());
        mobileCommands.assertElementText(thankyouscreenpagemap.orderSummary(), OrderSummaryheader, true);
    }

    public void validateSubmitTxt (String SubmitthankTxt){
        mobileCommands.assertElementText(thankyouscreenpagemap.textSubmitted(), SubmitthankTxt, true);
    }

    public void validateSuccessMessage(){
        mobileCommands.assertElementDisplayed(thankyouscreenpagemap.successMessage(),true);
    }
    public void validateUnsuccessHeader(String unsuccesscat){
        mobileCommands.assertElementText(thankyouscreenpagemap.unsuccessHeader(),unsuccesscat,true);
    }
    public void validateUnsuccessUPC(String upc){
        mobileCommands.assertElementText(thankyouscreenpagemap.unsuccessUPC(),upc,true);
    }
    public void validatePendingHeader(String pendingcat){
        mobileCommands.assertElementText(thankyouscreenpagemap.pendingHeader(),pendingcat,true);
    }
    public void validatePendingUPC(String upc){
        mobileCommands.assertElementText(thankyouscreenpagemap.pendingUPC(),upc,true);
    }

    public void mainMenuBtnClick () {
        mobileCommands.click(thankyouscreenpagemap.mainMenuBtn());
    }

    public HashMap<String, String> getProductCount(int upcScannedSize){
        int k=0;
        HashMap<String, String> upcCountMap = new HashMap<>();
        List<WebElement> caseCount = new ArrayList<>();
            do{
                if(k==0) {
                    mobileCommands.waitForElement(thankyouscreenpagemap.textThankYou());
                    BaseUtil.scroll("down");
                }
                List<WebElement> upcElement = mobileCommands.elements(thankyouscreenpagemap.unsuccessUPC());
                try {
                    caseCount = mobileCommands.elements(thankyouscreenpagemap.prodCase());
                    for(int i=0;i<caseCount.size();i++)
                        upcCountMap.put(upcElement.get(i).getText(),caseCount.get(i).getText().split(" ")[0]);
                }
                catch(Exception e) {//do nothing
                }
               if(upcCountMap.size()==upcScannedSize){
                    break;
                }
                BaseUtil.scroll("down");
                k++;
        }while(k<8);
            return upcCountMap;
    }

    public String getOrderStatusTxt(){
       return mobileCommands.element(thankyouscreenpagemap.successMessage()).getText();
    }
}