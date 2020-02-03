package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.cucumber_framework.AdminHomePage;
import com.ebanking.cucumber_framework.EmployeeCreationPage;
import com.ebanking.cucumber_framework.EmpoloyeeDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EmployeeSteps {
	private CommonSteps commonSteps;
	private WebDriver driver;
	private EmpoloyeeDetailsPage employeeDetailsPage;
	private EmployeeCreationPage employeeCreationPage;
	private String alertText;

	public EmployeeSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = this.commonSteps.getDriver();
	}

	@Given("admin clicks employee button")
	public void admin_clicks_employee_button() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		employeeDetailsPage = adminHomePage.clickEmployees();
	}

	@Given("admin clicks new employee button")
	public void admin_clicks_new_employee_button() {
		employeeCreationPage = employeeDetailsPage.clickNewEmpoloyee();
	}

	@When("admin enters employee name {string}")
	public void admin_enters_employee_name(String string) {
		employeeCreationPage.fillEmpName(string);
	}

	@When("admin enters login password {string}")
	public void admin_enters_login_password(String string) {
		employeeCreationPage.fillLoginPass(string);
	}

	@When("admin selects role {string}")
	public void admin_selects_role(String string) {
		employeeCreationPage.selectRole(string);
	}

	@When("admin selects branch name {string}")
	public void admin_selects_branch_name(String string) {
		employeeCreationPage.selectBranch(string);
	}

	@When("admin clicks on submit button")
	public void admin_clicks_on_submit_button() {
		Alert alert = employeeCreationPage.clickSubmit();
		alertText = alert.getText();
		alert.accept();
	}

	@Then("admin can see a message saying employee created successfully")
	public void admin_can_see_a_message_saying_employee_created_successfully() {
		Assert.assertTrue(alertText.toLowerCase().contains("new employer"));
	}

	@When("admin enters invalid employee name then admin can see an error message")
	public void admin_enters_invalid_employee_name_then_admin_can_see_an_error_message(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> data = dataTable.asMaps();
		for (Map<String, String> row : data) {
			String empName = row.get("empName");
			try {
				employeeCreationPage.clearEmpName();
				employeeCreationPage.fillEmpName(empName + Keys.TAB);
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			} catch (Exception e) {
//				if (e instanceof UnhandledAlertException) {
//					Alert alert = driver.switchTo().alert();
//					System.out.println(alert.getText());
//					alert.accept();
//				}
			}
		}

	}
}
