package org.login;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//StaleElement reference Exception
//Locators - Seprate Pojo class 
public class MyntraHomePage extends BaseClass{
	
	public MyntraHomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"search\"]")
	private MobileElement searchIcon;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"search_default_search_text_input\"]")
	private MobileElement searchTextBox;

	public MobileElement getSearchIcon() {
		return searchIcon;
	}

	public void setSearchIcon(MobileElement searchIcon) {
		this.searchIcon = searchIcon;
	}

	public MobileElement getSearchTextBox() {
		return searchTextBox;
	}

	public void setSearchTextBox(MobileElement searchTextBox) {
		this.searchTextBox = searchTextBox;
	}
	

}
