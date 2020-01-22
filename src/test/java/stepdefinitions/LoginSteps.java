package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utitlities.BrowserHelper;

public class LoginSteps extends BrowserHelper{
	
	@Given("admin is in bank home page")
	public void admin_is_in_bank_home_page() {
	    openBrowser("chrome", "");
	}

	@When("admin enters valid username")
	public void admin_enters_valid_username() {
	   driver.findElement(By.id("")).sendKeys("Admin");
	}

	@When("admin enters valid password")
	public void admin_enters_valid_password() {
	    driver.findElement(By.id("")).sendKeys("Admin");
	}

	@When("admin clicks on login button")
	public void admin_clicks_on_login_button() {
	   driver.findElement(By.id("")).click();
	}

	@Then("admin can see welcome to admin message with logout link")
	public void admin_can_see_welcome_to_admin_message_with_logout_link() {
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());
	}




}
