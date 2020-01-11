package com.ebanking.cucumber_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankHomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// username
	public WebElement username() {
//		WebElement uname = driver.findElement(By.id("txtuId"));
//		return uname;
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtuId")));
	}
	
	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}
	
	// login button
	public WebElement loginButton() {
		return driver.findElement(By.id("login"));
	}
	
	public BankHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	// fill username 
	public void fillUserName(String username) {
		this.username().sendKeys(username);
	}
	
	
	// fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}
	
	
	// click on login button
	public void clickLogin() {
		this.loginButton().click();
	}
	
	
	
}
