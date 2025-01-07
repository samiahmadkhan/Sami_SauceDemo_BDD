package hooks;

import com.FactoryNew.DriverManager;
import com.utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CucumberHooks_Updated {
    private ConfigReader configread;
    Properties prop;
    private WebDriver driver;
    @Before(order = 0)
    public void getProperty() {
        System.out.println("hi samiiiii in before");
        configread=new ConfigReader();
        prop=configread.initializeProp();
        System.out.println("Execution Environment: " + prop.getProperty("execution_ENV"));
        System.out.println("Browser: " + prop.getProperty("browser"));
    }
    @Before(order = 1)
    public void setUp() {
        // Get WebDriver instance from DriverManager
        driver=DriverManager.getInstance().getDriver();
        System.out.println("Initializing WebDriver for thread: " + Thread.currentThread().getId());
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        // Quit the WebDriver instance
        System.out.println("Quitting WebDriver for thread: " + Thread.currentThread().getId());
        DriverManager.quitDriver();
    }

}
