package Divsly;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validating_Sortlinks_Perform
{
	
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
		 
		 
		 Thread.sleep(2000);
		 
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		List<WebElement> Col = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/td"));
		
		//*[@id="root"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/a/div/span
		
		for(int i =1 ;i<rows.size();i++)
		     {
			     for(int j=1; j<Col.size();j++)
			       {
			    	 
			    	     driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/table/tbody/tr["+i+"]/td[3]/a/div/span")).click();
			       }
			    	 
		      }

           }
    }
