package com.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
     public WebDriver driver;
	 public static ThreadLocal<WebDriver> tDriver=new ThreadLocal<>();
     public WebDriver initializeDriver(String browser) {
    	 System.out.println("Browser is = " + browser);
    	 if(browser.equalsIgnoreCase("Chrome")) {
    		// System.setProperty("webdriver.chrome.driver","/Users/sami/eclipse-workspace/MySeleniumPractice/BrowserDriver/chromedriver");
    		 //WebDriverManager.chromedriver().setup();
    		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/browserDrivers/chromedriver");
			 tDriver.set(new ChromeDriver());
    	 }else if(browser.equalsIgnoreCase("Edge")) {
    		 WebDriverManager.edgedriver().setup();
    		 driver=new EdgeDriver();
    		
    	 }else System.out.println("No Browser Exists");
    	 getDriver().manage().window().maximize();
		 return getDriver();
 		 
    	 
     }
     
     public static synchronized WebDriver getDriver() {
    	 return tDriver.get();
     }

}
