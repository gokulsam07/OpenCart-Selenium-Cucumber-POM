package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;

public class MyHooks {

	public WebDriver driver;


	@Before
	public void setUp() {
		Properties prop = ConfigReader.initializePrpoerties();
		DriverFactory.initializeDriver(prop.getProperty("browserName"));
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
