package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	private WebDriver driver;
	private By ProductsPageName=By.xpath("//span[@class='title']");
	private By shoppingCartBadge=By.xpath("//a[@class='shopping_cart_link']//span");
	private By menu=By.xpath("//button[text()='Open Menu']");
	private By logout=By.xpath("//a[text()='Logout']");
	private WebElement image;
	
	private WebElement product(String productName)
	{
		By product = By.xpath("By.xpath(\"//div[text()='"+productName+"']");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(product));
		
		return driver.findElement(product);
	}
	private WebElement addCart(String productName)
	{
		By cartButton = By.xpath("//div[text()='"+productName+"']//parent::div//..//..//following-sibling::div//button[text()='Add to cart']");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartButton));
		return driver.findElement(cartButton);
	}
	private WebElement RemoveCart(String productName)
	{
		By RemoveButton = By.xpath("//div[text()='"+productName+"']//parent::div//..//..//following-sibling::div//button[text()='Remove']");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RemoveButton));
		return driver.findElement(RemoveButton);
	}
	
	
	public ProductsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	public String getProductsPageName() {
		System.out.println("title is = "+ driver.findElement(ProductsPageName).getText());
		return driver.findElement(ProductsPageName).getText();
	}  
	
	public boolean verifyProductImage(String imagename) {
		// product=driver.findElement(By.xpath("//div[text()='"+imagename+"']"));
		 image=driver.findElement(By.xpath("//img[contains(@src,'"+imagename+"')]"));
		 
		 if(image.isDisplayed())
			 return true;
		 else 
			 { System.out.println("There is mismatch in Product Name and its Respective Image Visible");
			 return false;}
		
	}
	
	public boolean isProductVisible(String productName) {
		 if(product(productName).isDisplayed())
			 return true;
		 else return false;
		
	}

	public void addProducttoCart(String productName) {
		
		addCart(productName).click();
	}
	public void RemoveProductfromCart(String productName) {
		RemoveCart(productName).click();
	}
	public boolean verifyProductisAdded() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoppingCartBadge));
		return driver.findElement(shoppingCartBadge).isDisplayed();
	}
	public boolean verifyProductisRemoved(String productName ) {
		//add cart will be visible only when Remove is Not There
		return addCart(productName).isDisplayed();
	}
	public void logoutFromProductPage() {
		driver.findElement(menu).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logout));
		driver.findElement(logout).click();
	}
	
	
}
