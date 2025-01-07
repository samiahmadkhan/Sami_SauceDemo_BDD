package com.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.utility.ConfigReader;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
    public WebDriver driver;
    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    public WebDriver initializeDriver(String browser) {
		//browser="Chrome";
        System.out.println("Browser is = " + browser);
		ConfigReader configReader=new ConfigReader();
		Properties prop=configReader.initializeProp();
		String OS=prop.getProperty("OPERATING_SYSTEM");
		Platform platform=Platform.valueOf(OS);// to convcert string to enum
		if(prop.getProperty("execution_ENV").equals("local")){
			if (browser.equalsIgnoreCase("Chrome")) {
				tDriver.set(new ChromeDriver());
			}
			else if (browser.equalsIgnoreCase("Edge")) {
				tDriver.set(new EdgeDriver());
			}
			else if (browser.equalsIgnoreCase("Firefox")) {
				tDriver.set(new FirefoxDriver());
			}else if (browser.equalsIgnoreCase("Safari")) {
				tDriver.set(new SafariDriver());
			} else System.out.println("No Browser Exists");
		}else if(prop.getProperty("execution_ENV").equals("SauceLabs")){
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 11");
			browserOptions.setBrowserVersion("latest");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("username", "oauth-gamegamegamer786-b522c");
			sauceOptions.put("accessKey", "5b6c64a3-25bd-4027-bbea-5fa6cb510ab3");
			sauceOptions.put("build", "selenium-build-6YZU7");
			sauceOptions.put("name", "<your test name>");
			browserOptions.setCapability("sauce:options", sauceOptions);
			try {
				//driver=new RemoteWebDriver(new URL(hubUrl),cap);
				tDriver.set(new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
						browserOptions));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}

		}else if(prop.getProperty("execution_ENV").equals("BrowserStack")){
			  final String AUTOMATE_USERNAME = "sami_0S2aIu";
			  final String AUTOMATE_ACCESS_KEY = "YKprwtESk9Cz6zqhU4Cm";
			  final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 11");
			browserOptions.setBrowserVersion("latest");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("username", "oauth-gamegamegamer786-b522c");
			sauceOptions.put("accessKey", "5b6c64a3-25bd-4027-bbea-5fa6cb510ab3");
			sauceOptions.put("build", "selenium-build-6YZU7");
			sauceOptions.put("name", "<your test name>");
			browserOptions.setCapability("sauce:options", sauceOptions);
			try {
				//driver=new RemoteWebDriver(new URL(hubUrl),cap);
				tDriver.set(new RemoteWebDriver(new URL(URL), browserOptions));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}

		}else if(prop.getProperty("execution_ENV").equals("remote")){
			//for SELENIUM GRID
			DesiredCapabilities cap=new DesiredCapabilities();
			//cap.setPlatform(Platform.MAC);
			cap.setPlatform(platform);
			String hubUrl="http://localhost:4444/wd/hub";

            if (browser.equalsIgnoreCase("Chrome")) {
				cap.setBrowserName("chrome");
				//tDriver.set(new ChromeDriver());
			}   if (browser.equalsIgnoreCase("Firefox")) {
				cap.setBrowserName("firefox");
				//tDriver.set(new ChromeDriver());
			}else if (browser.equalsIgnoreCase("Edge")) {
				cap.setBrowserName("MicrosoftEdge");
				//tDriver.set(new EdgeDriver());
			} else if (browser.equalsIgnoreCase("Safari")) {
				cap.setBrowserName("safari");
				//tDriver.set(new SafariDriver());
			} else System.out.println("No Browser Exists");

			try {
				//driver=new RemoteWebDriver(new URL(hubUrl),cap);
				tDriver.set(new RemoteWebDriver(new URL(hubUrl),cap));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}

        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tDriver.get();
    }

}
