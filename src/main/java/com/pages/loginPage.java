package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public ProductsPage login(String username,String pass) {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameTxtBox));
		driver.findElement(usernameTxtBox).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passTxtBox));
		driver.findElement(passTxtBox).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		
		return new ProductsPage(driver);
		
	}
	
	public Boolean verifyErrorMessage(String message) {
		return driver.findElement(By.xpath("//h3[text()='"+message+"']")).isDisplayed();
		
	}
	

}
