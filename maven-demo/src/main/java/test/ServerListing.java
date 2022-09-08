package test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServerListing {
	
	WebDriver driver;
	
	/*
	 * Scanner myObj = new Scanner(System.in); String emailid = myObj.nextLine();
	 * String password = myObj.nextLine();
	 */
	 String emailid = "c-deepika.singh@timesinternet.in"; String password = "Times@121"; 
	  
	
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
	public void headerTest() {
		
		String expectedHeader = "My Servers";
				WebElement regionElement1 =driver.findElement(By.xpath("//li[@class='breadcrumb-item active']"));
		 	
		 String actualHeader = regionElement1.getText();
		 //System.out.println(actualHeader);
		 Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(priority = 2)
	public void listCountTest() throws Exception   {
	 	 	 Thread.sleep(1000);
		int eleCount = driver.findElements(By.xpath("//tr")).size();
		 int actualNumber = eleCount-1;
		 Assert.assertEquals(actualNumber, 10); 
		
		}
	
	 
	 @Test(priority = 4)
	 public void paginatorTest() throws Exception  {
		  
		 String expectedMsg = "1 – 30 of 57";
		 WebElement totalCount =driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
		 totalCount.click();
		 WebElement totalCount1 =driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'30')]"));
		 totalCount1.click();
		 Thread.sleep(3000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 WebElement totalCount2 = driver.findElement(By.xpath("//div[@class='mat-paginator-range-label']"));
		  String actualMsg = totalCount2.getText();
		  System.out.println(actualMsg);
	 		 Assert.assertEquals(actualMsg, expectedMsg);
		 
		 
	 }

	

}
