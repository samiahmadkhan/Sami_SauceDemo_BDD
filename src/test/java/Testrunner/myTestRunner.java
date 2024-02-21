package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//i have added sparks report which will be generate in locations: CucumberPOM/test-output/SparkReport
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resource/features"},
			glue = {"stepDefinations", "hooks"},
            //tags = "@image",
            monochrome = true,
			plugin = {"pretty",
					"json:target/MyReports/report.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
			}
			
			)

	public class myTestRunner {

	}

