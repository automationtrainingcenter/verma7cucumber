package com.ebanking.cucumber_framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestExecution {
	private WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
	}

	public void loginTest() {
		BankHomePage bankHomePageObj = new BankHomePage(driver);
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPassword("Admin");
		bankHomePageObj.clickLogin();
		
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePageObj.clickLogout();
	}

	public static void main(String[] args) {
		TestExecution obj = new TestExecution();
		obj.launchBrowser();
		obj.loginTest();
	}

}
