package com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.ui.pages;

import com.kroger.mobile.kaf.appium.DeviceUtil;
import com.kroger.mobile.kaf.appium.Symbology;
import com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.ui.maps.ReviewedOrdersMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ReviewedOrdersPage {

	private Logger log = LoggerFactory.getLogger(ReviewedOrdersPage.class);
	private MobileCommands mobileCommands = new MobileCommands();
	private ReviewedOrdersMap reviewedOrdersMap = new ReviewedOrdersMap();




	public void validateReviewedOrdersScreenWithZeroProducts(String scanProductText)
	{
		mobileCommands.assertElementDisplayed(reviewedOrdersMap.scannerImage(),true);
		mobileCommands.assertElementText(reviewedOrdersMap.scanProductText(),scanProductText,true);
		validateScanImageAndTextIsCentered();
	}

	public void validateScanImageAndTextIsCentered(){
		int imageTopY = mobileCommands.element(reviewedOrdersMap.scannerImage()).getLocation().getY();
		int frameTopY = mobileCommands.element(reviewedOrdersMap.frameLayout()).getLocation().getY();
		int textBottomY = mobileCommands.element(reviewedOrdersMap.scanProductText()).getLocation().getY()
								+ mobileCommands.element(reviewedOrdersMap.scanProductText()).getSize().getHeight();
		int frameBottomY = mobileCommands.element(reviewedOrdersMap.frameLayout()).getLocation().getY()
				                   + mobileCommands.element(reviewedOrdersMap.frameLayout()).getSize().getHeight();
		int difference = Math.abs((imageTopY - frameTopY) - (frameBottomY - textBottomY));
		if(difference < 3)
			log.info("Scan Image and Scan Text View as a group are Centered between Header Bar and Android Soft Keys");
		else
			log.warn("Scan Image and Scan Text View as a group are not Centered between Header Bar and Android Soft Keys");
	}


	public void getProductAdjustedBarText(){
		mobileCommands.getElementText(reviewedOrdersMap.productAdjustedBarText());
	}


	public void mockScan(String barcode, String symbology) {
		try {
			DeviceUtil.triggerScan(((AndroidDriver) mobileCommands.getWebDriver()), barcode, Symbology.valueOf(symbology));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
