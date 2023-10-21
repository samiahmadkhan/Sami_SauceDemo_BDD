package com.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
     public static  WebDriver driver;
     
     
    
     public WebDriver initializeDriver(String browser) {
    	 System.out.println("Browser is = " + browser);
    	 if(browser.equalsIgnoreCase("Chrome")) {
    		 WebDriverManager.chromedriver().setup();
    		 //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resource/browserDrivers/chromedriver");
    		 driver=new ChromeDriver();
    		 
    	 }else if(browser.equalsIgnoreCase("Edge")) {
    		 WebDriverManager.edgedriver().setup();
    		 driver=new EdgeDriver();
    		
    	 }else System.out.println("No Browser Exists");
    	 getDriver().manage().window().maximize();
    	 
 		  return getDriver();
 		 
    	 
     }
     
     public static WebDriver getDriver() {
    	 return driver;
     }

}
