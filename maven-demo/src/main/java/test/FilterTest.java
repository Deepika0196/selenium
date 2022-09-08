package test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterTest {
	WebDriver driver;
	  Scanner myObj = new Scanner(System.in); String emailid = myObj.nextLine();
	  String password = myObj.nextLine();
	 
	  
	 
	 @BeforeTest
	 public void setup(){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\c-deepika.singh\\Downloads\\selenium-server-3.141.59\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get ("https://cloud.timesinternet.in/");	
			driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(emailid);
			driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys(password); 
			WebElement login=driver.findElement(By.xpath("//span[text()='Login']")); 
			login.click(); 
		}
	 
	 @Test(priority = 1)
		public void projectfilterTest()  {
			
		 WebDriverWait wait = new WebDriverWait(driver, 10);	
			 
			 WebElement projectButton = wait.until(
			     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Project ']"))
			 );	
			projectButton.click(); 
					 
			WebElement projectElement1 =driver.findElement(By.xpath("//span[contains(text(),'R&D')]"));
			projectElement1.click();
			WebElement apply = wait.until(
				     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Apply ']"))
				 );	
			apply.click();
			int selectedProject = driver.findElements(By.xpath("//td[text()= ' Sysadmin ']")).size();
			 Assert.assertEquals(selectedProject, 2);		 
	 
	 }
	 @Test(priority = 2)
		public void regionfilterTest()  
	 {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
				
			
			 WebElement regionButton = wait.until(
			     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Region ']"))
			 );	
		 	regionButton.click(); 
			WebElement regionElement =driver.findElement(By.xpath("//span[contains(text(),'MUM-SST-Z2')]"));
			regionElement.click();
			
			WebElement apply = wait.until(
				     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Apply ']"))
				 );	
		  
			apply.click();
			 
			int selectedRegion = driver.findElements(By.xpath("//td[text()= ' MUM-SST-Z2 ']")).size();
			Assert.assertEquals(selectedRegion, 1);
		}
	 
	 @Test(priority = 3)
		public void tagsfilterTest()  
	 {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
				
			
			 WebElement tagButton = wait.until(
			     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Tags ']"))
			 );	
			 tagButton.click(); 
			WebElement tagElement =driver.findElement(By.xpath("//span[contains(text(),'PRODUCTION')]"));
			tagElement.click();
			
			WebElement apply = wait.until(
				     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Apply ']"))
				 );	
		  
			apply.click();
			 
			int selectedTag = driver.findElements(By.xpath("//span[text()= ' Production ']")).size();
			 Assert.assertEquals(selectedTag, 1);
		}
	 
	 @Test(priority = 4)
		public void MoreFiltersTest()  
	 {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
				
			
			 WebElement moreFilterButton = wait.until(
			     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' More Filters ']"))
			 );	
			 moreFilterButton.click(); 
			WebElement moreFilterElement =driver.findElement(By.xpath("//span[contains(text(),'ONLINE')]"));
			moreFilterElement.click();
			
			WebElement apply = wait.until(
				     ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Apply ']"))
				 );	
		  
			apply.click();
			 
			int selectedFilter = driver.findElements(By.xpath("//span[text()= ' Production ']")).size();
			 Assert.assertEquals(selectedFilter, 1);
		}
	

}
