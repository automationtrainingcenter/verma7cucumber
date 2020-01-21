package com.ebanking.cucumber_framework;

import org.openqa.selenium.Alert;
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
	}
	
	public void roleCreationWithValidData() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		RoleDetailsPage roleDetailsPage = adminHomePageObj.clickRoles();
		RoleCreationPage roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("adminstratorOne");
		roleCreationPage.selectRoleType("E");
		Alert alert = roleCreationPage.clickSubmit();
		System.out.println("alert text = "+alert.getText());
		alert.accept();
	}

	public void roleCreationReset() {
		AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		RoleDetailsPage roleDetailsPage = adminHomePageObj.clickRoles();
		RoleCreationPage roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("BankerOne");
		roleCreationPage.selectRoleType("E");
		roleCreationPage = roleCreationPage.clickReset();
	}
	
	public static void main(String[] args) {
		TestExecution obj = new TestExecution();
		obj.launchBrowser();
		obj.loginTest();
		obj.roleCreationWithValidData();
		obj.roleCreationReset();
	}

}
