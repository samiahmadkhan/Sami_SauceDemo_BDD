package com.FactoryNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements WebDriverFactory{
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
