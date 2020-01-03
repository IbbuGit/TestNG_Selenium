/**
 * Description :-Test case to verify the scan product screen
 * ALM Test case id:-1662
 * Created by :-SYL7525
 * Created Date :- 2nd Aug 2019
 */
package com.krogerqa.appium.product_locator_app.top_stock.ui.maps;

//import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.openqa.selenium.By;

public class TopStockScanProductPageMap {
    public By ScanProduct() {
        return By.xpath("//*[@text='Scan Product']");
    }

    public By ScanProductImg() {
        return By.id("scan_bar_img");
    }

    public By ScanProductText() {
        return By.id("scan_a_product");
    }

    public By BackArrow() {
        return By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

    public By ConfirmLocation() {
        return By.xpath("//android.widget.RadioButton[@index='0']");
    }

    public By ConfirmLocation(int index) {
        return By.xpath("(//android.widget.RadioButton[@index='0'])["+index+"]");
    }

    public By ConfirmOtherLocation() {
        return By.xpath("//android.widget.TextView[@text='Other']");
    }

    public By ConfirmLocationBtn() {
        return By.id("dialog_confirm_button");
    }

    public By cancelBtn() {
        return By.xpath("//*[@text='CANCEL']");
    }

    public By OrderInProgressDialog() {
        return By.xpath("//android.widget.Button[@text='NEW SESSION']");
    }

    public By newSessionBtn() {
        return By.id("new_session");
    }

    public By reviewBtn() {
        return By.xpath("//*[@text='REVIEW']");
    }
    public By networkErrorMsg(){
        return By.xpath("//*[@text='Network Error!']");
    }
    public By magicProductScanned(){
        return By.xpath("//*[@text='MAGIC Product Scanned']");
    }
    public By topStockBtn() {return By.xpath("//*[@text='Top Stock']/..");}
    public By enterUPC() {
        return By.xpath("//*[@text='Enter Product UPC']");
    }
    public By submitBtn(){
        return By.xpath("//*[@text='SUBMIT']");
    }
    public By barCodeNotRecognizedHdr(){
        return By.xpath("//*[@text='Barcode Not Recognized']");
    }
    public By productNotFountTxt(){
        return By.xpath("//*[@text='Product Not Found']");
    }
}