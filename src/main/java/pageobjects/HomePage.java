package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	WebDriver driver;
	//Objects
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccount;
	@FindBy(linkText="Register")
	private WebElement register;
	@FindBy(linkText="Login")
	private WebElement login;
	@FindBy(name="search")
	private WebElement search;
	@FindBy(css="button.btn.btn-default.btn-lg")
	private WebElement searchButton;


	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, HomePage.class); //means the same thing
	}


	//Actions

	public void ClickOnMyAccount() {
		myAccount.click();
	}

	public RegisterPage ClickOnRegister() {
		register.click();
		return new RegisterPage(driver);
	}

	public LoginPage ClickOnLogin() {
		login.click();
		return new LoginPage(driver);

	}

	public void EnterProductName(String pdtName) {
		search.sendKeys(pdtName);
	}

	public SearchPage clickSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

}
