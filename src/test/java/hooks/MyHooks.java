package hooks;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;

public class MyHooks {

	public WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;

	@Before
	public void setUp() {
		configReader = new ConfigReader();
		prop = configReader.initializePrpoerties();
		driver =DriverFactory.initializeDriver(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
