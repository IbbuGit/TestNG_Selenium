package com.krogerqa.appium.product_locator_app.common.ui.maps;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HeaderBarMap {

	public By headerBar(){return  MobileBy.id("toolbar");}

	public By backKdsIcon(){return MobileBy.AccessibilityId("Navigate up");}

	public By kebabMenu(){return MobileBy.AccessibilityId("More options");}

	public By screenTitle(){return MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*:id/toolbar\")"+
																	   ".childSelector(new UiSelector().className(\"android.widget.TextView\"))");
	}
}
