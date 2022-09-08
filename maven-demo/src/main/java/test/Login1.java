package test;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 

public class Login1 {
	
	WebDriver driver;
	/*
	 * Scanner myObj = new Scanner(System.in); String emailid = myObj.nextLine();
	 * String password = myObj.nextLine();
	 */
	 String emailid = "c-deepika.singh@timesinternet.in"; String password = "Times@121";
	
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\c-deepika.singh\\Downloads\\selenium-server-3.141.59\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get ("https://cloud.timesinternet.in/");		
	}
	
	@Test(priority = 1)
	public void titleTest() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Keystone";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	 @Test(priority = 2)
	 public void loginTest() {
		 driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys(password); 
		WebElement login=driver.findElement(By.xpath("//span[text()='Login']")); 
		login.click(); 
		  String actualUrl="https://cloud.timesinternet.in/login"; 
		  String expectedUrl= driver.getCurrentUrl(); 
		  Assert.assertEquals(expectedUrl,actualUrl);
		
		}
	 
	@Test
	public void invalidEmailTest() {
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys(password);
		 WebElement login=driver.findElement(By.xpath("//span[text()='Login']"));
		 login.click();
		 String expectedErrorMsg = "Not a valid email";
		 WebElement exp = driver.findElement(By.xpath("//mat-error[text()='Not a valid email'] "));
		 String actualErrorMsg = exp.getText(); 
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);  
		
		
		
	}
	@Test
	public void emptyEmailTest() {
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys("");
		 WebElement login=driver.findElement(By.xpath("//span[text()='Login']"));
		 login.click();
		 String expectedErrorMsg = "You must enter a value";
		 WebElement exp = driver.findElement(By.xpath("//mat-error[text()='You must enter a value'] "));
		 String actualErrorMsg = exp.getText(); 
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);  
		
	}
	@Test
 	public void invalidPasswordTest() {
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys("abc"); 
		WebElement login=driver.findElement(By.xpath("//span[text()='Login']")); 
		login.click(); 	
				 
		 String expectedErrorMsg = "Either email or password is incorrect!";
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement element = wait.until(
		     ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Either email or password is incorrect!'] "))
		 );	
		 String actualErrorMsg = element.getText();
		 System.out.println(actualErrorMsg);
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	
	@Test(priority = 3)
	public void logoutTest() throws Exception {
		driver.findElement(By.xpath("//*[@id='mat-input-0']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys(password); 
		WebElement login=driver.findElement(By.xpath("//span[text()='Login']"));
		login.click();
		 
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//img[@src='https://keystone-webapp.s3.ap-south-1.amazonaws.com/profileimg.webp']")).click();
		 driver.findElement(By.xpath("//button[text()='Logout']")).click(); 
		 String actualUrl="https://cloud.timesinternet.in/login"; 
		  String expectedUrl= driver.getCurrentUrl(); 
		  Assert.assertEquals(expectedUrl,actualUrl); 
	}
	
	@AfterMethod
	public void endTest() {
		driver.close();
		driver.quit();
	}

 
}
