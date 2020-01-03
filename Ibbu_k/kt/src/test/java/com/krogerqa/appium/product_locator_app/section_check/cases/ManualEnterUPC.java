package com.krogerqa.appium.product_locator_app.section_check.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.utils.Consts;
import com.krogerqa.appium.product_locator_app.section_check.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ManualEnterUPC extends Base {
    private ManualEnterUPCPage manualEnterUPCPage;
    private SectionCheckPage sectionCheckPage;
    private UnSubmittedWorkPopUpPage unSubmittedWorkPopUpPage;
    private CountProductPage countProductPage;

    @BeforeMethod(alwaysRun = true)
    public void init(Method test) {
        manualEnterUPCPage=new ManualEnterUPCPage();
        sectionCheckPage=new SectionCheckPage();
        unSubmittedWorkPopUpPage = new UnSubmittedWorkPopUpPage();
        countProductPage = new CountProductPage();
    }
    @Test(groups = "regression")
    public void verifyManualEnterUPC_Cancel() {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.clickOnEnterUPCBtn();
        manualEnterUPCPage.validateManualEnterUPCTitle(Consts.titleManualEnterUPC_SC);
        manualEnterUPCPage.validateManualEnterHint(Consts.lblManualEnterHint);
        manualEnterUPCPage.valiateCancelButton(Consts.lblCancelButton);
        manualEnterUPCPage.validateSubmitButton(Consts.lblSubmitButton);
        manualEnterUPCPage.clickCancelButton();
        sectionCheckPage.verifySectionCheckHdr(sc_Data.getSectionCheckHdr());
    }
    @Test(groups = "regression")
    public void verifyManualEnterUPC_Submit() {
        unSubmittedWorkPopUpPage.clickEraseAndStartNewBtn();
        sectionCheckPage.clickOnEnterUPCBtn();
        manualEnterUPCPage.validateManualEnterUPCTitle(Consts.titleManualEnterUPC_SC);
        manualEnterUPCPage.enterProductUPC(sc_Data.getProductToScan());
        manualEnterUPCPage.clickSubmitButton();
        countProductPage.verifyCountProductsPageTitle(sc_Data.getCountProductScreen());
    }
}