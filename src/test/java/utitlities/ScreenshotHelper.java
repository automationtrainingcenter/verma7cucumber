package utitlities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.w3c.dom.css.Rect;

public class ScreenshotHelper extends GenericHelper {
	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat dt = new SimpleDateFormat("dd_MMM_yyyy--HH_mm_ss--z");
		return dt.format(date);

	}

	// capture a screenshot
	// provide file name only, no need of extension
	public static String takeScreenshot(WebDriver driver, String folderName, String fileName) {
		// convert webdriver reference to the TakesScreenshot reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
		try {
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(destImg.getAbsolutePath());
		return destImg.getAbsolutePath();
	}

	// capture alert screenshot
	public static void alertScreenshot(String folderName, String fileName) {
		try {
			Thread.sleep(2000);
			Robot r = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
			ImageIO.write(bi, "png", destImg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// capture multiple screenshots of the entire web page
	public static void takeMultipleScreenshots(WebDriver driver, String folderName, String fileName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long sh = (long)js.executeScript("return document.documentElement.scrollHeight");
		long ch = (long)js.executeScript("return document.documentElement.clientHeight");
		while(sh >= 0) {
			takeScreenshot(driver, folderName, fileName);
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", ch);
			sh -= ch;
		}
	}

}
