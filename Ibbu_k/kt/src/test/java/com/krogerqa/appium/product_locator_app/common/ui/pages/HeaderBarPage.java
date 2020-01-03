package com.krogerqa.appium.product_locator_app.common.ui.pages;

import com.krogerqa.appium.product_locator_app.common.ui.maps.HeaderBarMap;
import com.krogerqa.seleniumcentral.framework.main.MobileCommands;

public class HeaderBarPage {

	private MobileCommands mobileCommands = new MobileCommands();
	private HeaderBarMap headerBarMap = new HeaderBarMap();

	public void tapOnBackKdsIcon(){
		mobileCommands.tap(headerBarMap.backKdsIcon());
	}

	public void tapOnKebabMenu(){
		mobileCommands.tap(headerBarMap.kebabMenu());
	}

	public void validateHeaderBar(){
		mobileCommands.assertElementDisplayed(headerBarMap.headerBar(),true);
		mobileCommands.assertElementDisplayed(headerBarMap.backKdsIcon(),true);
		mobileCommands.assertElementDisplayed(headerBarMap.kebabMenu(),true);

	}
	public void validateScreenTitle(String expectedTitle){
		mobileCommands.assertElementText(headerBarMap.screenTitle(),expectedTitle,true);
	}

	public String getScreenTitle(){
		return mobileCommands.getElementText(headerBarMap.screenTitle()).trim();
	}
}
