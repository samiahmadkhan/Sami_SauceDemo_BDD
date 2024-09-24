package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.DataProvider;

//i have added sparks report which will be generate in locations: CucumberPOM/test-output/SparkReport
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resources/features"},
			glue = {"stepDefinations", "hooks"},
            tags = "@login",
            monochrome = true,
			dryRun = false,
			plugin = {"pretty",
					"json:target/MyReports/report.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

			}
			
			)

	public class TestRunner {
}

