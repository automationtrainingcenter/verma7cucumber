package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.cucumber_framework.AdminHomePage;
import com.ebanking.cucumber_framework.BankHomePage;
import com.ebanking.cucumber_framework.RoleCreationPage;
import com.ebanking.cucumber_framework.RoleDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utitlities.BrowserHelper;

public class RoleCreationSteps {
	private WebDriver driver;
	private CommonSteps commonSteps;
	private RoleDetailsPage roleDetailsPage;
	private RoleCreationPage roleCreationPage;
	Alert alert;

	// constructor
	public RoleCreationSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = this.commonSteps.getDriver();
	}

	@Given("admin is in admin home page by doing valid login")
	public void admin_is_in_admin_home_page_by_doing_valid_login() {
		BankHomePage bankHomePage = new BankHomePage(driver);
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLogin();
	}

	@Given("admin clicks roles button")
	public void admin_clicks_roles_button() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		roleDetailsPage = adminHomePage.clickRoles();
	}

	@Given("admin clicks on new role button")
	public void admin_clicks_on_new_role_button() {
		roleCreationPage = roleDetailsPage.clickNewRole();
	}

	@When("admin enters role name")
	public void admin_enters_role_name() {
		roleCreationPage.fillRoleName("adminFour");
	}

	@When("admin selects role type")
	public void admin_selects_role_type() {
		roleCreationPage.selectRoleType("E");
	}

	@When("admin click on submit button")
	public void admin_click_on_submit_button() {
		alert = roleCreationPage.clickSubmit();
	}

	@Then("admin can see a message saying new role created successfully with some id")
	public void admin_can_see_a_message_saying_new_role_created_successfully_with_some_id() {
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("created sucessfully123"));
	}
	
	@When("admin enters role name {string}")
	public void admin_enters_role_name(String string) {
	   roleCreationPage.fillRoleName(string);
	}

	@When("admin selects role type {string}")
	public void admin_selects_role_type(String string) {
	    roleCreationPage.selectRoleType(string);
	}

}
