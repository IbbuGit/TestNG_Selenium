package com.krogerqa.appium.product_locator_app.fresh_assisted_ordering.ui.maps;

import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ReviewedOrdersMap {

	public By productAdjustedBar() {return MobileBy.id("constraintLayout2"); }

	public By productAdjustedBarText(){return MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*:id:/constraintLayout2\")"+
			                                                             "childSelector(new UiSelector().className(android.widget.TextView))");}

     public By frameLayout(){return MobileBy.id("freshorder_framelayout");}

	public By scannerImage(){return MobileBy.id("scan_image"); }

	public By scanProductText(){return MobileBy.id("scan_product_text");}
}
