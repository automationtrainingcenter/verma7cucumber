package com.ebanking.cucumber_framework;
// implementing using page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	private WebDriver driver;

	// home button
	@FindBy(css = "a[href*='adminflow']")
	private WebElement home;

	// logout button
	@FindBy(how = How.CSS, using = "a[href*='primusbank']")
	private WebElement logout;

	// branches
	@FindBy(how = How.CSS, using = "a[href*='banker']")
	private WebElement branches;

	// roles
	@FindBy(how = How.CSS, using = "a[href*='Roles']")
	private WebElement roles;

	// employees
	@FindBy(how = How.CSS, using = "a[href*='Emp']")
	private WebElement employees;

	// users
	@FindBy(how = How.CSS, using = "a[href*='user']")
	private WebElement users;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click home
	public void clickHome() {
		this.home.click();
	}

	// click logout
	public void clickLogout() {
		this.logout.click();
	}

	// click branches
	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	// click roles
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click employees
	public EmpoloyeeDetailsPage clickEmployees() {
		this.employees.click();
		return PageFactory.initElements(driver, EmpoloyeeDetailsPage.class);
	}

	// click users
	public void clickUsers() {
		this.users.click();
	}
	
	// verify logout link is displayed or not
	public boolean isLogoutDisplayed() {
		return this.logout.isDisplayed();
	}

}
