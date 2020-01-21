package com.ebanking.cucumber_framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	private WebDriver driver;

	// role name
	@FindBy(how = How.ID, using = "txtRname")
	private WebElement roleName;

	// role type
	@FindBy(how = How.ID, using = "lstRtypeN")
	private WebElement roleType;

	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// fill role name
	public void fillRoleName(String roleName) {
		this.roleName.sendKeys(roleName);
	}
	
	
	// select role type
	public void selectRoleType(String roleType) {
		Select roleTypeSelect = new Select(this.roleType);
		roleTypeSelect.selectByVisibleText(roleType);
	}
	
	// click submit
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}
	
	// click reset
	public RoleCreationPage clickReset() {
		this.reset.click();
		return this;
	}
	
	// click cancel
	public RoleDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}
	

}
