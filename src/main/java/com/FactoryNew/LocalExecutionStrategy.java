package com.FactoryNew;

import org.openqa.selenium.WebDriver;

public class LocalExecutionStrategy implements ExecutionStrategy{
    @Override
    public WebDriver execute(WebDriverFactory factory) {
        return factory.createDriver();
    }
}
