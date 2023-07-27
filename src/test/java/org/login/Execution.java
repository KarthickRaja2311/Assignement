package org.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;

public class Execution extends BaseClass{
	
	
	public static void main(String[] args) throws MalformedURLException, AWTException, InterruptedException {
		
		appLaunch("Android Emulator", "Android", "10", "com.myntra.android", "com.myntra.android.SplashActivity");
		MyntraHomePage m = new MyntraHomePage();
		MobileElement searchIcon = m.getSearchIcon();
		buttonClick(searchIcon);
		MobileElement searchTextBox = m.getSearchTextBox();
		enterText(searchTextBox, "T Shirts");
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		scrolluptoElement();
		
		
	}
	
	

}
