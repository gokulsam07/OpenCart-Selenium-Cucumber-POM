package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/featurefiles",glue={"stepdefinitions","hooks"},plugin= {"pretty","html:report.html"})
public class MyRunner extends AbstractTestNGCucumberTests {

}
