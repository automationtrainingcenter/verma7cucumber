package utitlities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
	
	// retrieve the text of text field
	public static String getTextfieldValue(WebDriver driver, WebElement textField) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", textField).toString();
	}
	
	// bring an element to view i.e. top most position of the window
	public static void bringElementToView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	// scroll the page
	public static void scrollPage(WebDriver driver, long x, long y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
	}
	
	// execute java script
	public static Object executeScript(WebDriver driver, String script, Object... arguments) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script, arguments);
	}

}
