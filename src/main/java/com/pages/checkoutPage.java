package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {
	private WebDriver driver;
	
	
	private By firstName=By.xpath("//input[@placeholder='First Name']");
	private By lastName=By.xpath("//input[@placeholder='Last Name']");
	private By postCode=By.xpath("//input[@placeholder='Zip/Postal Code']");
	private By continueButton=By.xpath("//input[@type='submit']");
	
	private By orderConfirmationMessage=By.xpath("//h2[text()='Thank you for your order!']");
	
	
	private By FinishButton=By.xpath("//button[@id='finish']");
	private By CancelButton=By.xpath("//button[@id='cancel']");
	
	private WebElement yourCartProduct(String productName)
	{   
		By product = By.xpath("//div[text()='"+productName+"']");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(product));
		
		return driver.findElement(product);
	}
	
	
	public checkoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void fillYourInformation(String fname,String lname,String postcode) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(postCode).sendKeys(postcode);
		driver.findElement(continueButton).click();
	}
	
	
	
	public boolean finish() {
		driver.findElement(FinishButton).click();
		
		return driver.findElement(orderConfirmationMessage).isDisplayed();
	}
	public void  cancel() {
		driver.findElement(CancelButton).click();
		
	}

}
