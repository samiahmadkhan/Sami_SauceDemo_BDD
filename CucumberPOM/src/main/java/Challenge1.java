import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.cucumber.messages.internal.com.google.protobuf.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Challenge1 {
    WebDriver driver;
	
	@BeforeMethod
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resource/browserDrivers/chromedriver");

		driver=new ChromeDriver();
		// driver.manage().window().maximize();		
		driver.get("https://www.t-mobile.com/tablets");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	
		
	}
	
	@Test
	public void test1() {
		filter("Deals",new ArrayList(Arrays.asList("New")));
	}
	@Test
	public void test2() {
		filter("Deals",new ArrayList(Arrays.asList("New","Special offer")));
	}
	@Test
	public void test3() {
		filter("Brands",new ArrayList(Arrays.asList("Samsung","Apple")));
	}
	@Test
	public void test4() {
		filter("Brands",new ArrayList(Arrays.asList("TCL")));
	}
	@Test
	public void test5() {
		filter("Operating System",new ArrayList(Arrays.asList("Android")));
	}
	@Test
	public void test6() {
		filter("Operating System",new ArrayList(Arrays.asList("Android","Other","iPadOS")));
	}
	@Test
	public void test7() {
		filter("Deals",new ArrayList(Arrays.asList("All")));
	}
	
	
	public void filter(String cat,ArrayList<String> ls) {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//legend[contains(text(),'"+cat+"')]")));
		WebElement filter=driver.findElement(By.xpath("//h2[contains(text(),'Filters')] "));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",filter);

		WebElement category=driver.findElement(By.xpath("//legend[contains(text(),'"+cat+"')]"));
		
		
		clickOption(category, 20);

		for (String opt : ls) {

			if (opt.equals("All")) {
				List<WebElement> all=driver.findElements(By.xpath("//span[@class='mat-checkbox-inner-container']"));
				for(int i=0;i<all.size();i++) {
					all.get(i).click();
				}

			
			} else {
				WebElement option = driver
						.findElement(By.xpath("//span[@class='filter-display-name' and contains(text(),'" + opt
								+ "')]//..//preceding-sibling::span[@class='mat-checkbox-inner-container']"));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", filter);
				clickOption(option, 20);
			}

		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",filter);

		
	}
	public void clickOption(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
		//element.click();
	}
	

	
	@AfterMethod
	public void quit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}
}
