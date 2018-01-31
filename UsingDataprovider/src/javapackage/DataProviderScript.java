package javapackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderScript {
  WebDriver oBrowser;
 
 /* @DataProvider(name = "dealsloandata")
	public static Object[][] dataforloans()
  {
		return new Object[][] {{"200","5","8"},{"300","8","10"}};
	}
		*/
	@BeforeMethod
	
	public void openurl() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chandu\\Documents\\selenium jar files\\chromedriver/chromedriver.exe");
		WebDriver oBrowser= new ChromeDriver();
		oBrowser.get("http://www.deal4loans.com");
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	
	public void testingloan() {
	
		 
	    WebElement loanli = oBrowser.findElement(By.linkText("EMI Calculator"));
	    loanli.click();
	    
	    WebElement enterloanamt = oBrowser.findElement(By.id("Loan_Amount"));
	    enterloanamt.clear();
	    enterloanamt.sendKeys("200");
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys("10");
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys("3");
		
		
		
	}
	
	
	
	@AfterMethod
	
	public void closingbrowser()
	{ 	
		//driver.close();
	}
	
}
