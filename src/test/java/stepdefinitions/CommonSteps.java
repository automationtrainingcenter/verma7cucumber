package stepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import utitlities.BrowserHelper;

public class CommonSteps extends BrowserHelper{
	
	private static boolean isInitialized = false;

	public WebDriver getDriver() {
		if(!isInitialized) {
			openBrowser("chrome", "http://primusbank.qedgetech.com/");
			isInitialized = true;
		}
		return driver;
	}
	
	@After
	public void teardown() {
		closeBrowser();
		isInitialized = false;
	}
	
	

}

