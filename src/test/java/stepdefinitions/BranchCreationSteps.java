package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.cucumber_framework.AdminHomePage;
import com.ebanking.cucumber_framework.BranchCreationPage;
import com.ebanking.cucumber_framework.BranchDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import pojo.BranchData;
import utitlities.GenericHelper;

public class BranchCreationSteps {
	private CommonSteps commonSteps;
	private WebDriver driver;
	private BranchDetailsPage branchDetailsPage;
	private BranchCreationPage branchCreationPage;

	public BranchCreationSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
		this.driver = this.commonSteps.getDriver();
	}

	@Given("admin clicks branches button")
	public void admin_clicks_branches_button() {
		AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
	}

	@Given("admin clicks new branch button")
	public void admin_clicks_new_branch_button() {
		branchCreationPage = branchDetailsPage.clickNewBranch();
	}

	@When("admin clicks reset button after entering data from {string} then admin can an empty form")
	public void admin_clicks_reset_button_after_entering_data_from_then_admin_can_an_empty_form(String string) {
		try {
			FileReader reader = new FileReader(GenericHelper.getFilePath("resources", string));
			Gson gson = new Gson();
			BranchData[] branchDataObjects = gson.fromJson(reader, BranchData[].class);
			for (BranchData branchDataObj : branchDataObjects) {
				branchCreationPage.fillBranchName(branchDataObj.getBranchName());
				branchCreationPage.fillAddress1(branchDataObj.getAddress1());
				branchCreationPage.fillZipCode(branchDataObj.getZipcode());
				branchCreationPage.selectCountry(branchDataObj.getCountry());
				branchCreationPage.selectState(branchDataObj.getState());
				branchCreationPage.selectCity(branchDataObj.getCity());
				branchCreationPage.clickReset();
				Assert.assertTrue(branchCreationPage.isFormReset());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
