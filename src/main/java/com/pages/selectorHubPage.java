package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class selectorHubPage {
    public By firstName_disabledTextbox=By.xpath("//input[@placeholder='First Enter name']");
    private WebDriver driver;
    public selectorHubPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getTextBoxValue(){
        return driver.findElement(firstName_disabledTextbox).getText();
    }

}
