package com.krogerqa.appium.product_locator_app.backroom_count.cases;

import com.krogerqa.appium.product_locator_app.backroom_count.ui.pages.*;
import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import com.krogerqa.appium.product_locator_app.common.ui.pages.MainMenuPage;
import com.krogerqa.appium.product_locator_app.common.utils.ApiRequestDataHelper;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.common.ui.pages.ScanProductPage;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.httpclient.product_locator_app.apishelper.HttpClientExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;


public class BRC_E2E extends Base {
    private String[] multipleUPCs;
    private CountProductPage countProductPage = new CountProductPage();
    private ScanproductBRCPage scanproductBRCPage = new ScanproductBRCPage();
    private ReviewCountPage reviewCountPage = new ReviewCountPage();
    private ScanProductPage scanProductPage = new ScanProductPage();
    private UnSubmittedCountPage unSubmittedCount = new UnSubmittedCountPage();
    private ThankyouBRCPage thankyouBRCPage = new ThankyouBRCPage();
    private CommonPage commonPage = new CommonPage();
    private UnSubmittedCountPage unSubmittedCountPage = new UnSubmittedCountPage();
    private MainMenuPage mainMenuPage = new MainMenuPage();
    private Random random = new Random();
    private HttpClientExecutor apiExecutor;
    private ApiRequestDataHelper dataHelper;
    private int min = 0;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        apiExecutor = new HttpClientExecutor(login_Data.getUsername(), login_Data.getPassword());
        dataHelper = new ApiRequestDataHelper();
    }

    @Test(groups = "e2e")
    public void addProductFrom_ReviewPage() throws Exception {
        unSubmittedCount.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int currentIterationNo = multipleUPCs.length - 1;
        for (String currentUPC : multipleUPCs) {
            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanproductBRCPage.waitForEnterUPCButton();
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
            } else {
                scanproductBRCPage.clickEnterUPC();
                scanproductBRCPage.enterUPC(currentUPC);
                scanproductBRCPage.clickSubmit();
            }
            countProductPage.CountProductSteppers();
            countProductPage.clickReview();

            if (currentIterationNo > 0) {
                reviewCountPage.clickAddMore(currentIterationNo--);

            }
        }
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
    }

    @Test(groups = "e2e")
    public void removeProductFrom_ReviewPage() throws Exception {
        unSubmittedCount.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int currentIterationNo = multipleUPCs.length - 1;
        int randomNum = random.nextInt((currentIterationNo - min) + 1) + min;
        for (String currentUPC : multipleUPCs) {
            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanproductBRCPage.waitForEnterUPCButton();
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
            } else {
                scanproductBRCPage.clickEnterUPC();
                scanproductBRCPage.enterUPC(currentUPC);
                scanproductBRCPage.clickSubmit();
            }

            countProductPage.clickReview();
            if (currentIterationNo > 0) {
                reviewCountPage.clickAddMore(currentIterationNo--);
            }

        }
        reviewCountPage.clickDeleteBtn(randomNum);
        reviewCountPage.clickRemove();
        reviewCountPage.productCountCheck();
        reviewCountPage.clickSubmit();

    }

    @Test(groups = "e2e")
    public void updateProductFrom_ReviewPage() throws Exception {

        unSubmittedCount.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int currentIterationNo = multipleUPCs.length - 1;
        int randomNum = random.nextInt((currentIterationNo - min) + 1) + min;
        for (String currentUPC : multipleUPCs) {
            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanproductBRCPage.waitForEnterUPCButton();
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
            } else {
                scanproductBRCPage.clickEnterUPC();
                scanproductBRCPage.enterUPC(currentUPC);
                scanproductBRCPage.clickSubmit();
            }

            countProductPage.clickReview();
            if (currentIterationNo > 0) {
                reviewCountPage.clickAddMore(currentIterationNo--);
            }
        }
        reviewCountPage.clickProductUnitCount(randomNum);
        countProductPage.clickCasesStepperPlus();
        countProductPage.clickUnitsStepperPlus();
        countProductPage.clickReview();
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
    }

    @Test(groups = "e2e")
    public void validateUnSubmittedWork() throws Exception {
        unSubmittedCount.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int currentIterationNo = multipleUPCs.length - 1;
        boolean onScanProductPage = true;
        for (String currentUPC : multipleUPCs) {
            if (onScanProductPage) {
                scanproductBRCPage.clickEnterUPC();
                onScanProductPage = false;
            } else {
                countProductPage.clickEnterUPC();
            }
            scanproductBRCPage.enterUPC(currentUPC);
            scanproductBRCPage.clickSubmit();
        }
        countProductPage.clickReview();
        commonPage.clickBackArrowButton();
        unSubmittedCountPage.ValidateAndClickUnsubmittedLeaveBtn();
        mainMenuPage.clickBackroomCount();
        unSubmittedCountPage.clickUnSubmittedContinueBtn();
        reviewCountPage.clickSubmit();
    }

    @Test(groups = "e2e")
    public void scanAndSaveMultipleProducts() throws Exception {

        unSubmittedCount.clickNewCount();
        multipleUPCs = bc_Data.getProductToScan().split(";");
        int firstTime = 0;
        for (String currentUPC : multipleUPCs) {

            if (bc_Data.getManualOrScan().equalsIgnoreCase(Consts.scanUPC)) {
                scanProductPage.scanProduct(currentUPC, Symbology.UPC_A);
                countProductPage.waitForUPCText();
            } else {
                scanproductBRCPage.clickEnterUPC(firstTime++==0);
                scanproductBRCPage.enterUPC(currentUPC);
                scanproductBRCPage.clickSubmit();
            }
        }
        countProductPage.clickReview();
        thankyouBRCPage.setBackroomCountBeforeSubmit(multipleUPCs, apiExecutor, dataHelper, prop);
        reviewCountPage.clickSubmit();
        thankyouBRCPage.validateTextThankyou(bc_Data.getThankYouText());
        thankyouBRCPage.setBackroomCountAfterSubmit(multipleUPCs, apiExecutor, dataHelper, prop);
        thankyouBRCPage.validateBackroomCount();
    }


}
