package hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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

	@After(order=1)
	public void screenshotOnFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			String scName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", scName);
		}
	}

	@After(order=0)
	public void tearDown() {
		driver.quit();
	}
}
