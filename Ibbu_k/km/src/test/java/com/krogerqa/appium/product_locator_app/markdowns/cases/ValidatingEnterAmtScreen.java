package com.krogerqa.appium.product_locator_app.markdowns.cases;

import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.markdowns.ui.pages.EnterAmountPage;
import com.krogerqa.appium.product_locator_app.markdowns.ui.pages.MarkdownsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ValidatingEnterAmtScreen extends Base {

    EnterAmountPage EnterAmountPage;
    MarkdownsPage MarkdownsPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        EnterAmountPage = new EnterAmountPage();
        MarkdownsPage = new MarkdownsPage();
    }

    @Test(groups = {"story"})
    public void validateEnterAmountScreenINMarkdowns()  {
        MarkdownsPage.verifyMarkdownsPageTitle(md_Data.getMarkdownsPageTitle());
        MarkdownsPage.selectingPrinter();
        MarkdownsPage.clickEnterUPC();
        MarkdownsPage. provideDataInEnterUPC(md_Data.getproductToScan());
        MarkdownsPage.clickEnterUPCSubmitLink();
        EnterAmountPage.verifyEnterAmountPageTitle(md_Data.getEnterAmountPageTitle());
    }

}
