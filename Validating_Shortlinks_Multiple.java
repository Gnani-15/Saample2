package Divsly;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class Validating_Shortlinks_Multiple 
{
     
	public WebDriver driver;
	 
	@Test
	public void launchBrowser() throws InterruptedException, IOException 
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
		 
		 
		 WebElement link_icon = driver.findElement(By.xpath("//i[@id='linkstooltip']"));
		 link_icon.click();
		  
		 
		 // Click on Add icon 
		 WebElement Add_Icon = driver.findElement(By.xpath("//i[@class ='fa-solid fa-plus fs-3']"));
		 Add_Icon.click();
		 
		 
	    
	     FileInputStream file = new FileInputStream("C:\\Users\\akmr7\\OneDrive\\Desktop\\Sample_Data.xlsx");
	     XSSFWorkbook wb = new  XSSFWorkbook(file); 
		 XSSFSheet sheet = wb.getSheet("Sheet1");
		 int noOfRows = sheet.getLastRowNum();
			 
			 for(int row =1; row<noOfRows; row++ )
			     {
				  
				     XSSFRow current_row = sheet.getRow(row);
				     
				     String DestinationUrl = current_row.getCell(2).getStringCellValue();
				     String slashtag = current_row.getCell(3).getStringCellValue();
				     String E_Date = current_row.getCell(4).getStringCellValue();
				     
				     WebElement D_Url = driver.findElement(By.xpath("//input[@placeholder='Enter your destination URL']"));
				     D_Url.sendKeys(DestinationUrl);
				     
				     WebElement slash_tag = driver.findElement(By.xpath("//input[@placeholder='Generated Slash Tag']"));
				     slash_tag.sendKeys(slashtag);
				     
				     WebElement date = driver.findElement(By.xpath("//input[@name='expirationDate']"));
				     date.sendKeys(E_Date);
			         
				     
				     WebElement create = driver.findElement(By.xpath("//button[@type='submit']"));
					 create.click();
				     
			     }
		
	
	      }
	
  }
