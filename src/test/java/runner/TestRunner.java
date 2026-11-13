package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"stepdef"},
    tags = "${cucumber.tag:@Smoke}",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true,
    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests { // <-- Essential line

    @Override
    @DataProvider(parallel = true) // Set parallel = true if running tests concurrently
    public Object[][] scenarios() {
        return super.scenarios();
    }
}