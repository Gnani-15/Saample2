package Divsly;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Divsly_DashboardStatus 
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
		 
        //DashBoard Status
		 
		   //TotalClick
		   List<WebElement> Total_Clicks = driver.findElements(By.xpath("//span[text()='Total Clicks']/parent::div/following-sibling::div"));
		   for(WebElement e : Total_Clicks)
		     {
			   System.out.println(e.getText());
		     }
		   
		   //TotalSacns
		   //WebElement Total_Scans = driver.findElement(By.xpath("//span[text()='Total Scans']/parent::div/following-sibling::div"));
		   //Total_Scans.getText();
		   
		   //TotalLinksCreated
		   // WebElement Total_Links_Created = driver.findElement(By.xpath("//span[text()='Total Links Created']/parent::div/following-sibling::div"));
		   //Total_Links_Created.getText();
		   
		   //TotalQRcodes
		   //WebElement Total_QRCodes = driver.findElement(By.xpath("//span[text()='Total QR Codes']/parent::div/following-sibling::div"));
		   //Total_QRCodes.getText();
		   
		 
	    }
		 
	
	
    }
