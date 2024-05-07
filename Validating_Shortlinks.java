package Divsly;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Validating_Shortlinks{
	
	
 public WebDriver driver;
	 
	@Test
	public void launchBrowser() throws InterruptedException 
	   {
	  	
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmr7\\OneDrive\\Documents\\Selenium\\chromedriver-win32\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get("https://dev.divsly.com/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
		
		 WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
		 Username.sendKeys("gnaneswarrao15@gmail.com");
		 
		 WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
		 Password.sendKeys("Anil@123");
		 
		 WebElement continue_Button = driver.findElement(By.xpath("//button[@type='submit']"));
		 continue_Button.click();
		 
		 String Expected = "Divsly";
		 String Actual = driver.getTitle();
		 
		 Assert.assertEquals(Expected, Actual);
		 
		 //Click on Links Icon
		 
		 WebElement link_icon = driver.findElement(By.xpath("//i[@id='linkstooltip']"));
		 link_icon.click();
		  
		 
		 // Click on Add icon 
		 WebElement Add_Icon = driver.findElement(By.xpath("//i[@class ='fa-solid fa-plus fs-3']"));
		 Add_Icon.click();
		
		
		 //Enter Destination URL
		 
		 WebElement D_Url = driver.findElement(By.xpath("//input[@placeholder='Enter your destination URL']"));
		 D_Url.sendKeys("https://mvnrepository.com/search?q=Apache+poi");
		 
		 //Enter Slash tag
		 
		 WebElement slash_tag = driver.findElement(By.xpath("//input[@placeholder='Generated Slash Tag']"));
		 slash_tag.sendKeys("Poi");
		 
		 //Expiry date
		 
		 WebElement date = driver.findElement(By.xpath("//input[@name='expirationDate']"));
		 date.sendKeys("05/30/2024");
		 
		 WebElement create = driver.findElement(By.xpath("//button[@type='submit']"));
		 create.click();
	    }
		 
	
	}
	    
	
	

