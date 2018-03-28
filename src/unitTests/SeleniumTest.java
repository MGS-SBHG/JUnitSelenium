package unitTests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
 	private static FirefoxDriver driver;
 	WebElement element;

 //configure browser before running test.
 @BeforeClass
 public static void openBrowser(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 

 // a simple test of Login functionality of Demo application. 
 // try/catch block & assert statement. 
 // try block: test the presence of the element, 
 // if it does not find it, the element will remain as null. 
 // With that assert statement will verify that the element is not null. 
 // The basic rule of assert statement is that they act only on failure. 
 
 @Test
 public void valid_UserCredential(){

	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("http://www.store.demoqa.com");	
     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
     driver.findElement(By.id("log")).sendKeys("testuser_3");
     driver.findElement(By.id("pwd")).sendKeys("Test@123");
     driver.findElement(By.id("login")).click();
     try{
		 element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
	 }catch (Exception e){
		}
     Assert.assertNotNull(element);
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @Test
 public void inValid_UserCredential()
 {
	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("http://www.store.demoqa.com");	
     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
     driver.findElement(By.id("log")).sendKeys("testuser");
     driver.findElement(By.id("pwd")).sendKeys("Test@123");
     driver.findElement(By.id("login")).click();
     try{
		element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
     }catch (Exception e){
		}
     Assert.assertNotNull(element);
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 // tell Junit engine - execute this piece of code once all tests have been executed. 
 // close the browser down
 // no further tests would be needed 
 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}
