package hooks;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.factory.driverFactory;
import com.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
private driverFactory df;
private ConfigReader configread; 
Properties prop;
private WebDriver driver;

@Before(order = 0)
public void getProperty() {
	configread=new ConfigReader();
    prop=configread.initializeProp();
}

@Before(order = 1)
public void launchBrowser() {
	String browser=prop.getProperty("browser");
	String url=prop.getProperty("url");
	df=new driverFactory();
	driver=df.initializeDriver(browser);
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
}

@After(order = 0)
public void quitDriver() {
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}
}
