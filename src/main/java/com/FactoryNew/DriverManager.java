package com.FactoryNew;

import com.utility.ConfigReader;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static volatile DriverManager driverManager;
    private static WebDriver driver;
    private static String executionEnv;
    private static String browser;

    private DriverManager() {
        try {
            executionEnv = System.getProperty("execution_ENV", ConfigReader.initializeProp().getProperty("execution_ENV"));
            browser = System.getProperty("browser", ConfigReader.initializeProp().getProperty("browser"));

            if (executionEnv == null || executionEnv.isEmpty()) {
                throw new IllegalStateException("Execution Environment is not specified. Please configure 'ExecutionEnvironment'.");
            }
            if (browser == null || browser.isEmpty()) {
                throw new IllegalStateException("Browser is not specified. Please configure 'Browser'.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during initialization of DriverManager: " + e.getMessage(), e);
        }
    }

    public static DriverManager getInstance() {
        if (driverManager == null) {
            synchronized (DriverManager.class) {
                if (driverManager == null) {
                    driverManager = new DriverManager();
                }

            }
        }
        if (driver == null && threadLocalDriver.get() == null) {
            driverManager.initializeDriver();
        }
        return driverManager;
    }

    public static WebDriver getDriver() {
        switch (executionEnv) {
            case "browserstack":
                return driver;
            default:
                return threadLocalDriver.get();
        }
    }

    private void initializeDriver() {
//        executionEnv = System.getProperty("execution_ENV", ConfigReader.initializeProp().getProperty("execution_ENV"));
//        browser = System.getProperty("Browser", ConfigReader.initializeProp().getProperty("browser"));
        if (driver == null && threadLocalDriver.get() == null) {
            if ("browserstack".equalsIgnoreCase(executionEnv)) {
                // BrowserStack does not require ThreadLocal
                if (driver == null) {
                    driver = createDriver(executionEnv, browser);
                }
                // return driver;
            } else {
                // Use ThreadLocal for local execution
                if (threadLocalDriver.get() == null) {
                    threadLocalDriver.set(createDriver(executionEnv, browser));
                }
                //return threadLocalDriver.get();
            }
        }
    }

    private static WebDriver createDriver(String executionEnv, String browser) {
        WebDriverFactory factory = getBrowserFactory(browser);
        ExecutionStrategy strategy = getExecutionStrategy(executionEnv);
        return strategy.execute(factory);
    }

    private static WebDriverFactory getBrowserFactory(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriverFactory();
            case "firefox":
                return new FirefoxDriverFactory();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static ExecutionStrategy getExecutionStrategy(String executionEnv) {
        switch (executionEnv.toLowerCase()) {
            case "local":
                return new LocalExecutionStrategy();
            case "browserstack":
                return new BrowserStackExecutionStrategy();
            default:
                throw new IllegalArgumentException("Unsupported execution environment: " + executionEnv);
        }
    }

    public static void quitDriver() {
        String executionEnv = System.getProperty("ExecutionEnvironment", ConfigReader.initializeProp().getProperty("ExecutionEnvironment"));
        if ("browserstack".equalsIgnoreCase(executionEnv)) {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        } else {
            if (threadLocalDriver.get() != null) {
                threadLocalDriver.get().quit();
                threadLocalDriver.remove();
            }
        }
    }
}
