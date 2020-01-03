package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.common.utils.BaseUtil;
import com.krogerqa.appium.product_locator_app.common.utils.Symbology;
import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.ManualEnterUPCMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

import java.io.IOException;

public class ManualEnterUPCPage {
    private MobileCommands mobileCommands = new MobileCommands();
    private ManualEnterUPCMap manualEnterUPCMap;

    public ManualEnterUPCPage() {
        manualEnterUPCMap = new ManualEnterUPCMap();
    }

    public void validateManualEnterUPCTitle(String titleManualEnterUPC) {
        mobileCommands.assertElementText(manualEnterUPCMap.titleManualProduct(), titleManualEnterUPC, true);
    }

    public void validateEnterUPCOrPLU(String enterUPCOrPLU) {
        mobileCommands.assertElementText(manualEnterUPCMap.lblEnterUPCOrPLU(), enterUPCOrPLU, true);
    }

    public void validateManualEnterHint(String manualEnterHint) {
        mobileCommands.assertElementText(manualEnterUPCMap.lblManualEntryUPCHint(), manualEnterHint, true);
    }

    public void enterProductUPC(String productUPCNo) {
        mobileCommands.enterText(manualEnterUPCMap.txtUPCEdit(), productUPCNo, false);
        mobileCommands.click(manualEnterUPCMap.dlgManualEnterSubmitBtn());
    }

    public void validateCancelButton(String lblCancelBtn) {
        mobileCommands.assertElementText(manualEnterUPCMap.dlgManualEnterCancelBtn(), lblCancelBtn, true);
        mobileCommands.assertElementEnabled(manualEnterUPCMap.dlgManualEnterCancelBtn(),true);
    }

    public void clickCancelButton(){
        mobileCommands.click(manualEnterUPCMap.dlgManualEnterCancelBtn());
    }

    public void clickSubmitButton(){
        mobileCommands.click(manualEnterUPCMap.dlgManualEnterSubmitBtn());
    }

    public void validateSubmitButton(String lblSubmitBtn) {
        mobileCommands.assertElementText(manualEnterUPCMap.dlgManualEnterSubmitBtn(), lblSubmitBtn, true);
        mobileCommands.assertElementEnabled(manualEnterUPCMap.dlgManualEnterSubmitBtn(),false);
    }
    public void scanProduct (String upc, Symbology symbology) throws IOException {
        BaseUtil.scanUPC(mobileCommands.getWebDriver(),upc, symbology);
    }
}
