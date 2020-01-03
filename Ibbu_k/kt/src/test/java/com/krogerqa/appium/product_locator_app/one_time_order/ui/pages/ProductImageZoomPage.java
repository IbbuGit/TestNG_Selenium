package com.krogerqa.appium.product_locator_app.one_time_order.ui.pages;

import com.krogerqa.appium.product_locator_app.one_time_order.ui.maps.ProductImageZoomPageMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class ProductImageZoomPage {
    MobileCommands mobileCommands = new MobileCommands();
    ProductImageZoomPageMap productImgPage;

    public ProductImageZoomPage() {
        productImgPage = new ProductImageZoomPageMap();
    }
    public void validateProductImg() {
        mobileCommands.assertElementDisplayed(productImgPage.productZoomedImage(),true);
    }
    public void validateBtnProductCancel() {
        mobileCommands.assertElementDisplayed(productImgPage.productCancelBtn(),true);
    }
    public void validateAndClickOrderHead(String ZoomOrderHead) {
        mobileCommands.assertElementText(productImgPage.orderAddBtn(),ZoomOrderHead,true);
        mobileCommands.click(productImgPage.orderAddBtn());
    }
}