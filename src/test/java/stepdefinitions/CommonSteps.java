package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
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
	
	@AfterStep
	public void afterStepDef(Scenario scenario) {
		// adding screenshot to the report
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
	}
	
	@After
	public void teardown() {
		closeBrowser();
		isInitialized = false;
	}
	
	

}

