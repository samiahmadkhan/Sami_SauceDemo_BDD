package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//i have added sparks report which will be generate in locations: CucumberPOM/test-output/SparkReport

	@CucumberOptions(
			features = {"src/test/resources/features"},
			glue = {"stepDefinations", "hooks"},
            //tags = "@sammy",
            monochrome = true,
			plugin = {"pretty",
					"json:target/MyReports/report.json",
					"html:target/MyReports/reporthtml.html",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
			}
			
			)

	public class TestRunnerParallel extends AbstractTestNGCucumberTests {
    @Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

