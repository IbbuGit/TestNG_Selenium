package com.krogerqa.appium.product_locator_app.common.utils;

import com.krogerqa.seleniumcentral.framework.main.MobileCommands;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

/**
 * @author Kinnari Surve
 * This class is used to select Android device soft keys
 */
public enum SystemNavigationBar {

	BACK("back", new KeyEvent(AndroidKey.BACK)),
	APP_SWITCH("appSwitch", new KeyEvent(AndroidKey.APP_SWITCH)),
	HOME("home", new KeyEvent(AndroidKey.HOME));

	private String keyName;
	private KeyEvent keyEvent;
	private static AndroidDriver driver = (AndroidDriver) new MobileCommands().getWebDriver();
	private static Logger log = LoggerFactory.getLogger(SystemNavigationBar.class);


	SystemNavigationBar(String keyName, KeyEvent keyEvent){
		this.keyName = keyName;
		this.keyEvent = keyEvent;
	}

	public String getKeyName() {
		return keyName;
	}

	public KeyEvent getKeyEvent() {
		return keyEvent;
	}

	public static void tapOn(SystemNavigationBar softKey){
		if(Stream.of(SystemNavigationBar.values()).anyMatch(key -> key.getKeyName().equalsIgnoreCase(softKey.getKeyName())))
		{
			log.info("Pressing Android Soft "+softKey.getKeyName()+" key");
			driver.pressKey(softKey.getKeyEvent());
		}
		else
			throw new IllegalArgumentException("Key passed as parameter "+softKey+" is not AndroidSoftKey on Bottom Navigation Bar");
	}
}
