package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/java/features",
	glue= {"stepDefinitions"},
	plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
	monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
