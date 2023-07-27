package org.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static AndroidDriver<MobileElement> driver;

	// Launch the Application
	public static void appLaunch(String deviceName, String platformName, String platformVersion, String appPackage,
			String appActivity) throws MalformedURLException {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", platformName);
			dc.setCapability("platformVersion", platformVersion);
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);

			URL u = new URL("http://0.0.0.0:4723/wd/hub");

			driver = new AndroidDriver<MobileElement>(u, dc);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		catch (SessionNotCreatedException e) {
			System.out.println("Check your Desired Capabilites");
		} catch (WebDriverException e) {
			System.out.println("Check Appium Started or not");
		} catch (Exception e) {
			System.out.println("Change the Version and update");
		}

	}

	// insatalling the Application
	public static void installAPp(String deviceName, String platformName, String appPath) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", platformName);
			dc.setCapability("app", appPath);
			URL u = new URL("http://0.0.0.0:4723/wd/hub");

			driver = new AndroidDriver<MobileElement>(u, dc);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		catch (SessionNotCreatedException e) {
			System.out.println("Check your Desired Capabilites");
		} catch (WebDriverException e) {
			System.out.println("Check Appium Started or not");
		} catch (Exception e) {
			System.out.println("Change the Version and update");
		}

	}

	// Scroll Up and Scroll Down
	public static List<MobileElement> elements(){
		List<MobileElement> findElements = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"text_brand\"])[2])"));
		return findElements;
	}
	
	public static void performScroll() {
		Dimension size = driver.manage().window().getSize();
		Double anchor = size.getHeight()*0.5;
		Double end = size.getHeight()*0.2;
		int start = anchor.intValue();
		int endPoint = end.intValue();
		
		TouchAction tc = new TouchAction(driver);
		tc.press(PointOption.point(0, start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(0, endPoint))
		.release().perform();
		
	}

	
	public static void scrolluptoElement() {
		while(elements().size()==0) {
			performScroll();
		}
		if(elements().size()!=0) {
			elements().get(0).click();
		}
	}
	
	// Drag and Drop
	public static void performDragAndDrop(String sourceLocator, String targetLocator) {
		MobileElement sourceElement = driver.findElement(By.xpath(sourceLocator));
		MobileElement targetElement = driver.findElement(By.xpath(targetLocator));
		TouchAction tc = new TouchAction(driver);
		//to get the location of the Source Element
		tc.longPress(PointOption.point(sourceElement.getLocation().x, sourceElement.getLocation().y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
		moveTo(PointOption.point(targetElement.getLocation().x, targetElement.getLocation().y)).
		release().perform();
	}

	// Enter the text
	public static void enterText(MobileElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}
	
	
	// Click
	public static void buttonClick(MobileElement element) {
		element.click();
	}

	// Quit the Driver
	public static void quitDriver() {
		driver.quit();
	}

}
