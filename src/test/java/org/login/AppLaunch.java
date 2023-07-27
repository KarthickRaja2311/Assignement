package org.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppLaunch {

	static AndroidDriver<MobileElement> driver;

	public static List<MobileElement> elementsFind() {
		List<MobileElement> findElements = driver
				.findElements(By.xpath
	("(//android.widget.TextView[@content-desc=\"text_brand\"])[2]"));
		return findElements;
	}

	public static void performScroll() {
		Dimension size = driver.manage().window().getSize();
		// Set the Anchor Point and end point
		Double d = size.getHeight() * 0.5;
		Double s = size.getHeight() * 0.2;

		// Double to integer
		int start = d.intValue();
		int end = s.intValue();

		// TouchAction
		TouchAction tc = new TouchAction(driver);
		tc.press(PointOption.point(0, start))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(0, end)).release().perform();
	}

	public static void scrolluptoElement() {
		while (elementsFind().size() == 0) {
			performScroll();
		}
		if (elementsFind().size() != 0) {
			elementsFind().get(0).click();
		}
	}

	public static void main(String[] args) throws MalformedURLException, AWTException, InterruptedException {
		// DesiredCapabilities - Pre defined class
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("appPackage", "com.dream11.fantasy.cricket.football.kabaddi");
		dc.setCapability("appActivity", "com.app.dream11.dream11.SplashActivity");

		// URL - Pre defined Class
		URL u = new URL("http://0.0.0.0:4723/wd/hub");

		// AndroidDriver - Pre defined class - object
		driver = new AndroidDriver<MobileElement>(u, dc);

		Thread.sleep(3000);
		// to find a mobileElement
		MobileElement searchIcon = driver.findElement
				(By.xpath("//android.widget.ImageView[@content-desc=\"search\"]"));
		searchIcon.click();

		Thread.sleep(3000);
		MobileElement textBox = driver
				.findElement(By.xpath
("//android.widget.EditText[@content-desc=\"search_default_search_text_input\"]"));
		textBox.sendKeys("T shirts");

		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		scrolluptoElement();

	}

}
