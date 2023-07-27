package org.steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import org.login.BaseClass;
import org.login.MyntraHomePage;

import io.cucumber.java.en.*;

public class StepDefintionClass extends BaseClass{
	
	MyntraHomePage m;
	
	
	@Given("User navigates to the myntra Application")
	public void user_navigates_to_the_myntra_application() throws MalformedURLException {
	  appLaunch("Android Emulator", "Android", "10", "com.myntra.android", "com.myntra.android.SplashActivity");
	    
	}
	@When("User clicks on the Search ICon")
	public void user_clicks_on_the_search_i_con() {
	    m = new MyntraHomePage();
	    buttonClick(m.getSearchIcon());
	    
	}
//	@When("User enteres the product name {string}")
//	public void user_enteres_the_product_name(String string) throws InterruptedException, AWTException {
//	    enterText(m.getSearchTextBox(), string);
//	    Thread.sleep(5000);
//	    Robot r = new Robot();
//	    r.keyPress(KeyEvent.VK_ENTER);
//	    r.keyRelease(KeyEvent.VK_ENTER);
//	    
//	}
//	@Then("User scrolls to the expected Product")
//	public void user_scrolls_to_the_expected_product() {
//	    scrolluptoElement();
//	    
//	}



}
