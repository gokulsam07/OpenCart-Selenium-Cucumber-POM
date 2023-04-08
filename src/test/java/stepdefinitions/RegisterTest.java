package stepdefinitions;


import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utilities.CommonUtils;

public class RegisterTest {
	public WebDriver driver;
	private RegisterPage registerPage;


	@Given("^user navigates to register page$")
	public void user_navigates_to_register_page()  {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnMyAccount();
		registerPage = homePage.ClickOnRegister();

	}

	@When("^user enters the following fields$")
	public void user_enters_the_following_fields(DataTable dataTable)  {
		Map<String, String> data = dataTable.asMap();
		registerPage.enterFirstName(data.get("firstName"));
		registerPage.enterLastName(data.get("lastName"));
		registerPage.enterEmail(CommonUtils.getNewEmail());
		registerPage.enterTelephone(data.get("telephone"));
		registerPage.enterPassword(data.get("password"));
		registerPage.confirmPassword(data.get("confirmPassword"));
	}

	@And("^user verifies the privacy policy$")
	public void user_verifies_the_privacy_policy()  {
		registerPage.agreePolicy();
	}

	@And("^user clicks continue for page registration$")
	public void user_clicks_continue_for_page_registration()  {
		registerPage.save();
	}

	@Then("^account should be created successfully$")
	public void account_should_be_created_successfully()  {
		Assert.assertEquals("Your Account Has Been Created!",registerPage.confirmationMessageIsDisplayed() );

	}

	@When("^user enters the following fields with duplicate email$")
	public void user_enters_the_following_fields_with_duplicate_email(DataTable dataTable)  {
		Map<String, String> data = dataTable.asMap();
		registerPage.enterFirstName(data.get("firstName"));
		registerPage.enterLastName(data.get("lastName"));
		registerPage.enterEmail(data.get("email"));
		registerPage.enterTelephone(data.get("telephone"));
		registerPage.enterPassword(data.get("password"));
		registerPage.confirmPassword(data.get("confirmPassword"));
	}


	@When("^user do not enter any details$")
	public void user_do_not_enter_any_details()  {
		//Intentionally left blank
	}



	@Then("^proper warning should be given and account should not be created$")
	public void proper_warning_should_be_given_and_account_should_not_be_created()  {
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.isErrorDisplayedForPreConfiguredMail());
	}

	@Then("^proper warning should be given for all fields and account should not be created$")
	public void proper_warning_should_be_given_for_all_fields_and_account_should_not_be_created()  {
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerPage.isErrorDisplayedForpolicy());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",  registerPage.isErrorDisplayedForfirstName());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",  registerPage.isErrorDisplayedForlastName());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",  registerPage.isErrorDisplayedForEmail());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",  registerPage.isErrorDisplayedFortelephone());
		Assert.assertEquals("Password must be between 4 and 20 characters!",  registerPage.isErrorDisplayedForpassword());
	}


}
