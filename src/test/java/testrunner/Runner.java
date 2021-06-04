package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/Resources/features"},
        glue = {"stepdefinitions", "cucumberHooks"},
        plugin = {"pretty",
                "html:testResult/Drivewyze_cucumber_reports.html"},
        monochrome = true,
        dryRun = false
)

public class Runner {
}
