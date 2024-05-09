package Divsly;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MutipleUser 
{
    
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmr7\\OneDrive\\Documents\\Selenium\\chromedriver-win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
       
                driver.get("https://dev.divsly.com/");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      		
	}
	
	@Test(dataProvider ="LoginData")
	public void loginTest(String user, String pwd)
	{
		WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
		Username.sendKeys(user);
		
		WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
		Password.sendKeys(pwd);
		
		WebElement continue_Button = driver.findElement(By.xpath("//button[@type='submit']"));
		continue_Button.click();
		
		
	}
        @DataProvider(name="LoginData")
	  public String [][] getData()
	  {   
		
    	     String loginData[][] = {
    			                  {"gnaneswarrao15@gmail.com","Anil@123"},
    			                  {"gnaneswarrao13@gmail.com","Anil@123"},
    			                  {"gnaneswarrao15@gmail.com","nani@123"},
    			                  {"gnaneswarrao203@gmail.com","nani@123"}
    	                        
    	                        };
    	        return loginData;
    	
    	
	   }
        @AfterClass
          public void tearDoen() 
	
         {
     	       
		 driver.close();
         }

     }

