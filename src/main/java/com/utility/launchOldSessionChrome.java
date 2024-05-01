package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class launchOldSessionChrome {
    public static void main(String arr[]){
        tst();
    }
    public static void tst(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.setExperimentalOption("debuggerAddress", "localhost:8080");
        WebDriver driver = new ChromeDriver(option);//ON LATEST Selenium Manager
//        WebElement txtMessage = driver.findElement(By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']//h2"));
//        System.out.println("text message is = " + txtMessage.getText());
        WebElement signinButton = driver.findElement(By.xpath("//span[@class='a-size-base-plus' and contains(text(),'Sign in')]"));
        signinButton.click();
    }
}
