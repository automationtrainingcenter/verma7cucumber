package utitlities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper extends GenericHelper{
	
	protected WebDriver driver;
	
	
	
	
	// launch browser method
	public void openBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException(browserName+" browser does not exist");
		}
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	// sleep
	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// close browser
	public void closeBrowser() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}

}
