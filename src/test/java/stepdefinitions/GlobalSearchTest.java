package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalSearchTest {
	WebDriver driver;

	@Given("^user opens the application$")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
	}

	@When("user enters {string} in the search field")
	public void user_enters_something_in_the_search_field(String validString ) {
		driver.findElement(By.name("search")).sendKeys(validString);
	}

	@And("^user clicks on the search button$")
	public void user_clicks_on_the_search_button() {
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();
	}

	@Then("^only relevant products should be displayed$")
	public void only_relevant_products_should_be_displayed() {
		Assert.assertEquals(true, driver.findElement(By.linkText("HP LP3065")).isDisplayed());  
	}

	@Then("^relevant error should be displayed$")
	public void relevant_error_should_be_displayed() {
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText());
	}


}
