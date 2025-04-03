package com.FactoryNew;

import com.utility.ConfigReader;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridExecutionStrategy implements ExecutionStrategy {
    @Override
    public WebDriver execute(WebDriverFactory factory) {
        MutableCapabilities caps = new MutableCapabilities();
        String hubUrl="http://localhost:4444/wd/hub";

        // Dynamically get browser name based on the factory (Chrome or Firefox)
        String browserName = factory.getClass().getSimpleName().replace("DriverFactory", "").toLowerCase();
        caps.setCapability("browserName", browserName);

        // Determine the WebDriver URL
        try {
            return new RemoteWebDriver(new URL(hubUrl), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
