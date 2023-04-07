package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	WebDriver driver;

	@Given("^user navigates to login page$")
	public void user_navigates_to_login_page()   {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username)   {
		driver.findElement(By.id("input-email")).sendKeys(username);
	}


	@And("user enters the password {string}")
	public void user_enters_the_password(String password)   {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	@And("^click login button$")
	public void click_login_button()   {
		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}


	@Then("^it should login and open the accounts page$")
	public void it_should_login_and_open_the_accounts_page()   {
		Assert.assertEquals(true, driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@Then("^user should get a proper warning message$")
	public void user_should_get_a_proper_warning_message()   {
		Assert.assertEquals(true, driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed());

	}

}

