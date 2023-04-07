package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	WebDriver driver;

	@Given("^user navigates to register page$")
	public void user_navigates_to_register_page()  {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("^user enters the following fields$")
	public void user_enters_the_following_fields(DataTable dataTable)  {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.id("input-firstname")).sendKeys(data.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(data.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(getNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(data.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(data.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(data.get("confirmPassword"));
	}

	@And("^user verifies the privacy policy$")
	public void user_verifies_the_privacy_policy()  {
		driver.findElement(By.name("agree")).click();
	}

	@And("^user clicks continue for page registration$")
	public void user_clicks_continue_for_page_registration()  {
		driver.findElement(By.cssSelector("input[value='Continue']")).click();
	}

	@Then("^account should be created successfully$")
	public void account_should_be_created_successfully()  {
		Assert.assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).isDisplayed());

	}

	@When("^user enters the following fields with duplicate email$")
	public void user_enters_the_following_fields_with_duplicate_email(DataTable dataTable)  {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.id("input-firstname")).sendKeys(data.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(data.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(data.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(data.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(data.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(data.get("confirmPassword"));
	}

	@When("^user do not enter any details$")
	public void user_do_not_enter_any_details()  {
		//Intentionally left blank
	}



	@Then("^proper warning should be given and account should not be created$")
	public void proper_warning_should_be_given_and_account_should_not_be_created()  {
		Assert.assertEquals(true, driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed());
	}

	@Then("^proper warning should be given for all fields and account should not be created$")
	public void proper_warning_should_be_given_for_all_fields_and_account_should_not_be_created()  {
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",  driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",  driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",  driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",  driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!",  driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
	}

	public String getNewEmail() {
		Date date = new Date();
		return "gokul"+date.toString().replace(":", "_").replace(" ", "_")+"@gmail.com";
	}

}
