package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features"},
        tags= "@priority1 or @priority2 or @priority3",
        glue = {"stepdefinations"},
        plugin = {"json:target/cucumber.json"},
        dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests{
}
