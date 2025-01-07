package com.FactoryNew;

import org.openqa.selenium.WebDriver;

public interface ExecutionStrategy {
    WebDriver execute(WebDriverFactory factory);
}
