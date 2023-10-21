package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	private WebDriver driver;
	private By loginPageTitle = By.xpath("//div[text()='Swag Labs']");
	private By usernameTxtBox = By.xpath("//input[@placeholder='Username']");
	private By passTxtBox = By.xpath("//input[@placeholder='Password']");
	private By loginButton = By.xpath("//input[@type='submit']");
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle(); 
	}
	
	public void login(String username,String pass) {
		driver.findElement(usernameTxtBox).sendKeys(username);
		driver.findElement(passTxtBox).sendKeys(username);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
