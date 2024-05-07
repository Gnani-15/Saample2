package Divsly;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DivslyDemo 
{
  
	 public WebDriver driver;
	 
	 //WebElement link_icon = driver.findElement(By.xpath("//i[@id='linkstooltip']"));
	 
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
		 
	    }
		 
	
	}
	    
  

