package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
	private WebElement productNotAvilable;

	@FindBy(linkText="HP LP3065")
	private WebElement hpProduct;

	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean noProductAvailableIsDisplayed() {
		return productNotAvilable.isDisplayed();
	}

	public boolean isHPProuctDisplayed() {
		return hpProduct.isDisplayed();
	}
}
