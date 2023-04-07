package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.CommonUtils;

public class LoginTest {
	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("^user navigates to login page$")
	public void user_navigates_to_login_page()   {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnMyAccount();
		loginPage = homePage.ClickOnLogin();

	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username){
		loginPage.enterUsername(username);;
	}
	
	@When("user enters the invalid username")
	public void user_enters_the_invalid_username()   {
		loginPage.enterUsername(CommonUtils.getNewEmail());
	}


	@And("user enters the password {string}")
	public void user_enters_the_password(String password)   {
		loginPage.enterPassword(password);
	}
	@And("^click login button$")
	public void click_login_button()   {
		accountPage = loginPage.clickLogin();
	}


	@Then("^it should login and open the accounts page$")
	public void it_should_login_and_open_the_accounts_page()   {
		Assert.assertEquals(true, accountPage.getDisplayOfEditAccInfo());

	}

	@Then("^user should get a proper warning message$")
	public void user_should_get_a_proper_warning_message()   {
		Assert.assertEquals(true, loginPage.isErrorDisplayedForWrongCreds());

	}

}

