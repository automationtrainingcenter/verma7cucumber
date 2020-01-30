package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.cucumber_framework.AdminHomePage;
import com.ebanking.cucumber_framework.BankHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utitlities.BrowserHelper;

public class LoginSteps {
	WebDriver driver;
	CommonSteps commonSteps;
	BankHomePage bankHomePage;
	
	
	
	public LoginSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = this.commonSteps.getDriver();
	}

	@Given("admin is in bank home page")
	public void admin_is_in_bank_home_page() {
		bankHomePage = new BankHomePage(driver);
	}

	@When("admin enters valid username")
	public void admin_enters_valid_username() {
		bankHomePage.fillUserName("Admin");
	}

	@When("admin enters valid password")
	public void admin_enters_valid_password() {
		bankHomePage.fillPassword("Admin");
	}

	@When("admin clicks on login button")
	public void admin_clicks_on_login_button() {
		bankHomePage.clickLogin();
	}

	@Then("admin can see welcome to admin message with logout link")
	public void admin_can_see_welcome_to_admin_message_with_logout_link() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isLogoutDisplayed());
	}

	@When("admin enters invalid password")
	public void admin_enters_invalid_password() {
		bankHomePage.fillPassword("Adminnnnnnn");
	}

	@Then("admin can see an error message saying incorrect bankername or password")
	public void admin_can_see_an_error_message_saying_incorrect_bankername_or_password() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("incorrect bankername/password"));
	}
	
	@When("admin enters invalid username")
	public void admin_enters_invalid_username() {
		bankHomePage.fillUserName("Adminnnnn");
	}

}
