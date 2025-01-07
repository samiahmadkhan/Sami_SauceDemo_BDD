package com.FactoryNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory{
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}
