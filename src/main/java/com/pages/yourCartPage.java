package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class yourCartPage {
	private WebDriver driver;
	private By yourCartPageName=By.xpath("//span[text()='Your Cart']");
	private By checkoutButton=By.xpath("//button[text()='Checkout']");
	private By continueShoppingButton=By.xpath("//button[@data-test='continue-shopping']");
	
	private WebElement yourCartProduct(String productName)
	{   
		By product = By.xpath("//div[text()='"+productName+"']");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(product));
		
		return driver.findElement(product);
	}
	
	private WebElement yourCartRemove(String productName)
	{
		By RemoveButton = By.xpath("//div[text()='"+productName+"']//parent::div//..//..//following-sibling::div//button[text()='Remove']");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RemoveButton));
		return driver.findElement(RemoveButton);
	}

	public yourCartPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public boolean verifyYourCartPage() {
		return driver.findElement(yourCartPageName).isDisplayed();
	}
	
	public boolean isProductVisible(String productName) {
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item_label']//div[@class='inventory_item_name']"));
		
		boolean flag = false;
		for(int i=0;i<list.size();i++) {
			System.out.println("List Elements = "+list.get(i).getText()+ " and product name = "+ productName);
			if(list.get(i).getText().equals(productName)) {
				flag=true;
				break;
		     }
		}
	return flag;
		
	}
	
	public void RemoveProduct_YourCart(String productName) {
		yourCartRemove(productName).click();
	}
	
	public boolean verifyIsProductRemoved_yourCart(String productName) {
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item_label']//div[@class='inventory_item_name']"));
		
		boolean flag = false;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equals(productName)) {
				flag=true;
				break;
		     }
		}
	return flag;
	}
	
	public checkoutPage checkout() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutButton));
		driver.findElement(checkoutButton).click();
		
		return new checkoutPage(driver);
	}
}

