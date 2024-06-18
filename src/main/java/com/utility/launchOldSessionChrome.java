package com.utility;

//import com.assertthat.selenium_shutterbug.core.Capture;
//import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;


public class launchOldSessionChrome {
    static WebDriver driver;
    public static void main(String arr[]){
        tst();
    }
    public static void tst(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.setExperimentalOption("debuggerAddress", "localhost:8080");
         driver = new ChromeDriver(option);//ON LATEST Selenium Manager
        //getFullPageScreenShotOne();
//        WebElement txtMessage = driver.findElement(By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']//h2"));
//        System.out.println("text message is = " + txtMessage.getText());
//        WebElement signinButton = driver.findElement(By.xpath("//span[@class='a-size-base-plus' and contains(text(),'Sign in')]"));
//        signinButton.click();
    }

    public static void getFullPageScInChrome(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Get the scroll height of the webpage
        long scrollHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

        // Save the screenshot
        try {
            FileUtils.copyFile(screenshot, new File("/Users/samikhan/Desktop/SC/fullpage_screenshot.png"));

            // Scroll the page and capture screenshot in chunks if needed
            for (int scroll = 0; scroll < scrollHeight; scroll += 1000) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + scroll + ");");
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("/Users/samikhan/Desktop/SC/fullpage_screenshot_" + scroll + ".png"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void getFullPageScreenShotOne(){
//        Shutterbug.shootPage(driver, Capture.FULL,true).save("/Users/samikhan/Desktop/SC/fullpage_screenshot.png");
//    }
}
