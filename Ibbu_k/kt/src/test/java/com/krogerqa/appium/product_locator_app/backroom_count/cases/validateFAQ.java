package com.krogerqa.appium.product_locator_app.backroom_count.cases;


import com.krogerqa.appium.product_locator_app.common.base.Base;
import com.krogerqa.appium.product_locator_app.common.ui.pages.CommonPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class validateFAQ extends Base {
    CommonPage commonPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages(Method test) {
        commonPage = new CommonPage();
    }

    @Test(groups = {"regression"})
    public void validateFAQ() {
        commonPage.clickKebabMenu();
        commonPage.clickFAQLayout();
        commonPage.verifyFAQTitle();
        commonPage.clickFAQBackroomCount();
        commonPage.clickBackButton();
        commonPage.clickBackButton();
    }
}
