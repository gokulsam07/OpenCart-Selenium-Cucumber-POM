package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.accountspage.NewsLetterPage;

public class AccountPage {
	WebDriver driver;
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccInfo;
	
	@FindBy(partialLinkText="Subscribe")
	private WebElement newsLetter;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayOfEditAccInfo() {
		try {
			editYourAccInfo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return editYourAccInfo.isDisplayed();
	}
	
	public NewsLetterPage selectNewsLetter() {
		newsLetter.click();
		return new NewsLetterPage(driver);
	}
}
