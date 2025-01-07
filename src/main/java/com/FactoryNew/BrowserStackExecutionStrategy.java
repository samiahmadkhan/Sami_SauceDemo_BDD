package com.FactoryNew;

import com.utility.ConfigReader;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackExecutionStrategy implements ExecutionStrategy {
    @Override
    public WebDriver execute(WebDriverFactory factory) {
        MutableCapabilities caps = new MutableCapabilities();

        // Dynamically get browser name based on the factory (Chrome or Firefox)
        String browserName = factory.getClass().getSimpleName().replace("Factory", "").toLowerCase();
        caps.setCapability("browserName", browserName);

        // Add BrowserStack credentials from the config
        caps.setCapability("browserstack.user", ConfigReader.initializeProp().getProperty("BrowserStackUser"));
        caps.setCapability("browserstack.key", ConfigReader.initializeProp().getProperty("BrowserStackKey"));

        // Optionally, specify other capabilities for BrowserStack
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("project", "Your Project Name");
        caps.setCapability("build", "Build Number");
        caps.setCapability("name", "Test Name");

        // Determine the WebDriver URL
        try {
            return new RemoteWebDriver(
                    new URL(ConfigReader.initializeProp().getProperty("BrowserStackURL")),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
