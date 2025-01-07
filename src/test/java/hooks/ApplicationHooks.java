//package hooks;
//
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import io.qameta.allure.Allure;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import com.factory.driverFactory;
//import com.utility.ConfigReader;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class ApplicationHooks {
//private driverFactory df;
//private ConfigReader configread;
//Properties prop;
//private WebDriver driver;
//
//@Before(order = 0)
//public void getProperty() {
//	configread=new ConfigReader();
//    prop=configread.initializeProp();
//}
//
//@Before(order = 1)
//public void launchBrowser() {
//	//String browser=prop.getProperty("browser");
//	String browser=System.getProperty("browserProperty");
//	String url=prop.getProperty("url");
//	df=new driverFactory();
//	driver=df.initializeDriver(browser);
//	driver.get(url);
//	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//}
//
//@After(order = 0)
//public void quitDriver() {
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	driver.quit();
//}
//
//@After(order=1)
//public void tearDown(Scenario scenario) {
//	if(scenario.isFailed()) {
//		String screenshotName=scenario.getName().replaceAll(" ", "_");
//		byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(sourcePath, "image/png", screenshotName);
//        try {
//            Allure.addAttachment("Screenshot", "image/png",
//					new FileInputStream(new File("target/allure-results/" + scenario.getName() + ".png")), "png");
//        } catch (FileNotFoundException e) {
//
//        }
//
//    }
//}
//}
