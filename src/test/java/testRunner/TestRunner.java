package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/java/features",
	glue= {"stepDefinitions", "hooks"},
	plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
	monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
//	@Override
//    @DataProvider(parallel = true)  // Enable parallel execution at scenario level
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}