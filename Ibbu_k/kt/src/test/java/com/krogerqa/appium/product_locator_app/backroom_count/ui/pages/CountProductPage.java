package com.krogerqa.appium.product_locator_app.backroom_count.ui.pages;

import com.google.gson.annotations.Since;
import com.krogerqa.appium.product_locator_app.backroom_count.ui.maps.CountProductPageMap;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class CountProductPage {
    private int beforeUnitsCount;
    private int afterUnitsCount;
    private String unitsCount;
    private String defaultCasesCount = "0";
    private String incrementedCasesCount = "1";
    private MobileCommands mobileCommands = new MobileCommands();
    private CommonPage commonPage = new CommonPage();
    private CountProductPageMap countProductPageMap;
    private DecimalFormat df;

    public CountProductPage() {
        countProductPageMap = new CountProductPageMap();
    }

    public void clickReview() {
        mobileCommands.click(countProductPageMap.btnReview());
    }

    public void validateCountProductTitle(String countProduct) {
        mobileCommands.assertElementDisplayed(countProductPageMap.headerCountProduct(), true);
        mobileCommands.assertElementText(countProductPageMap.headerCountProduct(), countProduct, true);
    }

    public void clickNavigationBtn() {
        mobileCommands.click(countProductPageMap.crossButton());
    }

    /*
     *   To validate Product details
     */
    public void validateProdDetails() {
        mobileCommands.assertElementDisplayed(countProductPageMap.txtProdUPC(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.imgProd(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.txtProdDesc(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.txtCaseSize(), true);
    }

    /*
     *   To validate Product Case size
     */
    public void validateProdTotalUnitsCount() {
        mobileCommands.assertElementDisplayed(countProductPageMap.txtTotalUnitsCount(), true);
    }

    public void clickEnterUPC() {
        mobileCommands.waitForElement(countProductPageMap.btnEnterUPC());
        mobileCommands.click(countProductPageMap.btnEnterUPC());
    }

    public void validateStepperIcons() {
        mobileCommands.assertElementDisplayed(countProductPageMap.btnCasesStepperMinus(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnCasesStepperPlus(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnUnitsStepperMinus(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnUnitsStepperPlus(), true);
    }

    public void validateCasesTxtBox() {
        mobileCommands.assertElementDisplayed(countProductPageMap.casesTxtBox(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.casesTxt(), true);
        mobileCommands.click(countProductPageMap.casesTxtBox());
    }

    public void validateCasesEnterCountPopUp() {
        mobileCommands.assertElementDisplayed(countProductPageMap.enterCountTxt(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.casesCountTxtBox(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnCancel(), true);
        mobileCommands.click(countProductPageMap.btnCancel());
    }

    public void validateErrorMsg(String maxCaseCount) {
        mobileCommands.enterText(countProductPageMap.casesCountTxtBox(), maxCaseCount, true);
        mobileCommands.click(countProductPageMap.btnSubmit());
        mobileCommands.assertElementText(countProductPageMap.maxCountErrorMsg(), "Count can't exceed 9999", true);
    }

    public void validateUnitsTxtBox() {
        mobileCommands.assertElementDisplayed(countProductPageMap.unitsTxtBox(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.unitsTxt(), true);
        mobileCommands.click(countProductPageMap.unitsTxtBox());
    }

    public void validateUnitsEnterCountPopUp() {
        mobileCommands.assertElementDisplayed(countProductPageMap.enterCountTxt(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.unitsCountTxtBox(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnCancel(), true);
        mobileCommands.click(countProductPageMap.btnCancel());
    }

    public void validateCrossButton() {
        mobileCommands.assertElementDisplayed(countProductPageMap.crossButton(), true);
        mobileCommands.click(countProductPageMap.crossButton());
    }

    public void validateAlertPopup() {
        mobileCommands.assertElementDisplayed(countProductPageMap.alertTitle(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.message(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnGoBack(), true);
        mobileCommands.assertElementDisplayed(countProductPageMap.btnRemove(), true);
        mobileCommands.click(countProductPageMap.btnGoBack());
    }

    public void validateCasesStepper() {
        String caseValue = mobileCommands.getElementText(countProductPageMap.casesCountTxtBox());
        if (caseValue.equalsIgnoreCase("0")) {
            mobileCommands.assertElementEnabled(countProductPageMap.btnCasesStepperMinus(), false);
            mobileCommands.click(countProductPageMap.btnCasesStepperMinus());
            mobileCommands.assertElementText(countProductPageMap.casesCountTxtBox(), "1", true);
        } else {
            mobileCommands.assertElementEnabled(countProductPageMap.btnCasesStepperMinus(), true);
        }

    }

    public void clickCasesStepperPlus() {
        if (mobileCommands.elementEnabled(countProductPageMap.btnCasesStepperPlus())) {
            mobileCommands.click(countProductPageMap.btnCasesStepperPlus());
        }

    }

    public void clickUnitsStepperPlus() {
        if (mobileCommands.elementEnabled(countProductPageMap.btnUnitsStepperPlus())) {
            mobileCommands.click(countProductPageMap.btnUnitsStepperPlus());
        }
    }


    public void validateCaseSizeIsOne() {
        String[] caseValue = mobileCommands.getElementText(countProductPageMap.txtCaseSize()).split(" ");
        int val = Integer.parseInt(caseValue[0]);
        if (val == 1) {
            Assert.assertFalse(commonPage.isElementVisible(countProductPageMap.casesTxt()));
            Assert.assertFalse(commonPage.isElementVisible(countProductPageMap.casesTxtBox()));
            Assert.assertFalse(commonPage.isElementVisible(countProductPageMap.btnCasesStepperPlus()));
            Assert.assertFalse(commonPage.isElementVisible(countProductPageMap.btnCasesStepperMinus()));

        }
        if (val > 1) {
            Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.casesTxt()));
            Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.casesTxtBox()));
            Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.btnCasesStepperPlus()));
            Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.btnCasesStepperMinus()));
        }
        Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.unitsTxt()));
        Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.unitsTxtBox()));
        Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.btnUnitsStepperPlus()));
        Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.btnUnitsStepperMinus()));

    }

    public void CountProductSteppers() {
        clickCasesStepperPlus();
        clickUnitsStepperPlus();
    }

    public void waitForUPCText() {
        mobileCommands.waitForElement(countProductPageMap.txtProdUPC());
    }

    public String getCasesNumberFromTextBox() {
        return mobileCommands.getElementText((countProductPageMap.unitsCountTxtBox()));
    }

    public String getProdTotalUnitsCount() {
        return mobileCommands.getElementText(countProductPageMap.txtTotalUnitsCount());
    }

    public void verifyProductCountsExists(String count){
        mobileCommands.assertElementExists(By.xpath("//android.widget.TextView[@text='"+count.trim()+"']"),true);
    }


    public void verifyScanningTipsTextEnabled(){
        mobileCommands.assertElementDisplayed(countProductPageMap.txtScanningTips(),true);
    }

    public void verifyScanningTipsTextDisabled(){
        mobileCommands.assertElementDisplayed(countProductPageMap.txtScanningTips(),false);
    }

    public void clickContinueButton(){
        mobileCommands.click(countProductPageMap.continueButton());
    }

    public void verifyUpcIsDisplayed(String upcText){
        mobileCommands.assertElementDisplayed(By.xpath("//*[@text='"+upcText+"']"),true);
    }

    public void validateScanningTipsText() {
        Assert.assertFalse(BaseUtil.isElementPresent(countProductPageMap.txtScanningTips(), 1));
    }
    public String caseSizeValue() {
        String caseSizeValue = mobileCommands.getElementText(countProductPageMap.txtCaseSize());
        return caseSizeValue;
    }

    public String getCasesCountFromTextBox() {
        List caseNumberBox = mobileCommands.elements(countProductPageMap.caseNumber());
        String caseCount;
        if (caseNumberBox.size() > 1) {
            caseCount = mobileCommands.getElementText((countProductPageMap.caseNumber()));
        } else {
            caseCount = "0";
        }

        return caseCount;
    }

    public String getUnitsCount() {
        String numberOfUnits = mobileCommands.getElementText(countProductPageMap.unitsTxtBox());
        return numberOfUnits;
    }

    public String captureTotalUnitsNumber() {
        String totalUnitsNumber = mobileCommands.getElementText(countProductPageMap.txtTotalUnitsCount());
        //Split to get number
        String[] totalUnits = totalUnitsNumber.split(" ");
        return totalUnits[0];

    }

    public void calculateTotalUnits() {
        //get the Case Size value
        String[] valueWithUnits = caseSizeValue().split(" ");
        int sizeOfCase = Integer.parseInt(valueWithUnits[0]);
        //get the case number
        int casesCount = Integer.parseInt(getCasesCountFromTextBox());
        //get the unit number
        int unitNumber = Integer.parseInt(getUnitsCount());
        //getTotalUnits
        int total = ((casesCount * sizeOfCase) + (unitNumber));
        String totalUnitCount = String.valueOf(total);
        //get total Units
        String totalUnitsFromApp = captureTotalUnitsNumber();
        //Compare both total
        Assert.assertTrue(totalUnitCount.contains(totalUnitsFromApp), "Units Count is miscalculated");

    }

    public String getUpcText() {
        String upcText = mobileCommands.getElementText(countProductPageMap.txtProdUPC());
        return upcText;

    }
    public void verifyProductCounts(String count) {
        mobileCommands.assertElementExists(By.xpath("//android.widget.TextView[@resource-id='com.kroger.sps.mobile.debug:id/caseNumberText' and @text='" + count.trim() + "']"), true);
    }

    public String getCaseSizeValue() {
        return mobileCommands.getElementText(countProductPageMap.txtCaseSize());
    }

    public void validateAutoIncCaseCount() {
        String[] caseValue = mobileCommands.getElementText(countProductPageMap.txtCaseSize()).split(" ");
        String caseVal = caseValue[0];
        boolean deciValue = caseValue[0].contains(".");
        if (deciValue) {
            String[] values = caseVal.split("\\.");
            int caseValueInt = Integer.parseInt(values[0]);
            for(int i = 0; i<caseValueInt; i++)
                clickUnitsStepperPlus();
            Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.casesTxtBox()));
            mobileCommands.assertElementText(countProductPageMap.casesTxtBox(), defaultCasesCount, true);
            clickCasesStepperPlus();
            String casesValueInTxtBoxStr = mobileCommands.getElementText(countProductPageMap.casesTxtBox());
            double casesValueInTxtBoxDbl = Double.parseDouble(casesValueInTxtBoxStr);
            String unitsValueInTxtBoxStr = mobileCommands.getElementText(countProductPageMap.unitsTxtBox());
            double unitsValueInTxtBoxDbl = Double.parseDouble(unitsValueInTxtBoxStr);
            double caseSizeDbl = Double.parseDouble(caseValue[0]);
            double totalUnits = ((casesValueInTxtBoxDbl * caseSizeDbl) + unitsValueInTxtBoxDbl);
            df = new DecimalFormat( "#.00" );
            String totalUnitsExp = df.format(totalUnits);
            StringBuilder stringBuilder = new StringBuilder(totalUnitsExp);
            stringBuilder.append(" Units");
            totalUnitsExp = stringBuilder.toString();
            mobileCommands.assertElementText(countProductPageMap.txtTotalUnitsCount(), totalUnitsExp.toUpperCase(), true);
        }
        else {
            if(caseValue[0].equals("1")){
                validateCaseSizeIsOne();
            }
            else {
                int caseValueInt = Integer.parseInt(caseValue[0]);
                for(int i = 0; i<caseValueInt; i++)
                    clickUnitsStepperPlus();
                Assert.assertTrue(commonPage.isElementVisible(countProductPageMap.casesTxtBox()));
                mobileCommands.assertElementText(countProductPageMap.casesTxtBox(), incrementedCasesCount, true);
                clickCasesStepperPlus();
                String casesValueInTxtBoxStr = mobileCommands.getElementText(countProductPageMap.casesTxtBox());
                int casesValueInTxtBoxInt = Integer.parseInt(casesValueInTxtBoxStr);
                String unitsValueInTxtBoxStr = mobileCommands.getElementText(countProductPageMap.unitsTxtBox());
                int unitsValueInTxtBoxInt = Integer.parseInt(unitsValueInTxtBoxStr);
                int caseSizeInt = Integer.parseInt(caseValue[0]);
                int totalUnits = ((casesValueInTxtBoxInt * caseSizeInt) + unitsValueInTxtBoxInt);
                String totalUnitsExp = Integer.toString(totalUnits);
                StringBuilder stringBuilder = new StringBuilder(totalUnitsExp);
                stringBuilder.append(" Units");
                totalUnitsExp = stringBuilder.toString();
                mobileCommands.assertElementText(countProductPageMap.txtTotalUnitsCount(), totalUnitsExp, true);
            }
        }
    }
}
