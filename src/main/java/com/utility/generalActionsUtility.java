package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class generalActionsUtility {
    private WebDriver driver;
    public  generalActionsUtility(WebDriver driver){
        this.driver=driver;
    }


    public void enterTextInDisabledField(String jsQuery,String Text,By element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(jsQuery);
        driver.findElement(element).sendKeys(Text);
    }
}
