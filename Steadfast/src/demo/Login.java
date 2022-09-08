package demo;
import java.io.IOException;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
import org.testng.annotations.Test;
import static util.ConfigReader.getUsername;
import static util.ConfigReader.getPassword;
public class Login {
 
	
    
    public static void main(String[] args) throws InterruptedException, IOException{ 
    	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver.exe");// add the right path
    	//System.out.println(driverPath);
    			//"D:\\GeckoDriver\\geckodriver.exe";
        WebDriver driver;

          
     //   System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get("https://steadfast.timesinternet.in/login");
        WebElement searchbutton = driver.findElement(By.id("g-signin"));//name locator for google search
        searchbutton.click();
        
        Thread.sleep(3000);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String p = it.next();
        String c = it.next();
        driver.switchTo().window(c);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(getUsername());
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getPassword());
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(6000);
        driver.switchTo().window(p);
        Thread.sleep(2000);
         
        
         
        
    }
	
	 
}
 