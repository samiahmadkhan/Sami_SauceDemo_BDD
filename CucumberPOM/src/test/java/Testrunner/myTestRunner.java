package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resource/features"},
			glue = {"stepDefinations", "hooks"},
            tags = "@addremove",
            monochrome = true,
			plugin = {"pretty"
				
			}
			
			)

	public class myTestRunner {

	}

