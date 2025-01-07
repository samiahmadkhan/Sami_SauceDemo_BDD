package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

//i have added sparks report which will be generate in locations: CucumberPOM/test-output/SparkReport
	@CucumberOptions(
			features = {"src/test/resources/features"},
			glue = {"stepDefinations", "hooks"},
            //
			tags = "@login",
            monochrome = true,
			dryRun = false,
			plugin = {"pretty",
					"json:target/MyReports/report.json",
					"rerun:target/failedTest.txt"

			}
			
			)

	public class TestRunner extends AbstractTestNGCucumberTests{

}

