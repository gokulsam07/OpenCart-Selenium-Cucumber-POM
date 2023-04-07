package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	public WebDriver driver;
	
	@Before
	public void setUp() {
		DriverFactory.initializeDriver("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
