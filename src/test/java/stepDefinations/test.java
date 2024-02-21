package stepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovy.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("testing selenium");
		
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='erkvQe']//ul[@role='listbox']//li")));
		
		try{
			List<WebElement> ls=driver.findElements(By.xpath("//div[@class='erkvQe']//ul[@role='listbox']//li"));
     	    System.out.println(ls.size());
     	   for(int i=0;i<ls.size();i++) {
   			if(ls.get(i).getText().equals("testing selenium java"))
   				ls.get(i).click();
   		}
		}catch(Exception e){
			
		}
		driver.close();
		
		

	}

}
