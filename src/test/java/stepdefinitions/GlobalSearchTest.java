package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class GlobalSearchTest {
	public WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;


	@Given("^user opens the application$")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
		
	}

	@When("user enters {string} in the search field")
	public void user_enters_something_in_the_search_field(String validString ) {
		homePage = new HomePage(driver);
		homePage.EnterProductName(validString);
	}

	@And("^user clicks on the search button$")
	public void user_clicks_on_the_search_button() {
		searchPage = homePage.clickSearchButton();
	}

	@Then("^only relevant products should be displayed$")
	public void only_relevant_products_should_be_displayed() {
		Assert.assertEquals(true, searchPage.isHPProuctDisplayed());  
	}

	@Then("^relevant error should be displayed$")
	public void relevant_error_should_be_displayed() {
		Assert.assertEquals(true, searchPage.noProductAvailableIsDisplayed());
	}


}
