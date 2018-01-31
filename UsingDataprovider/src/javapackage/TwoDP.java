package javapackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDP {

	WebDriver oBrowser;
	
	@DataProvider(name = "entertwovalues")
	public static Object[][] enteringtwovalues(){
		
		return new Object[][] {{"60000","10"},{"20000","21"}};
		
	}
	

	@DataProvider(name = "enterthreevalues")
	public static Object[][] enteringthreevalues(){
		
	return new Object[][] {{"60000","10","500"},{"5000","60","8"}};
		
	}
	
	@BeforeMethod
	public void openurl() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chandu\\Documents\\selenium jar files\\chromedriver/chromedriver.exe");
		oBrowser = new ChromeDriver();
		oBrowser.get("http://www.deal4loans.com");
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "entertwovalues")
	
	public void onesetdp(String ) {
		
		  WebElement loanlink = oBrowser.findElement(By.linkText("EMI Calculator"));
		    loanlink.click();
		    
		    WebElement loanamount = oBrowser.findElement(By.id("Loan_Amount"));
		    loanamount.clear();
		    loanamount.sendKeys(loanamt);
			
			oBrowser.findElement(By.name("months")).clear();
			oBrowser.findElement(By.name("months")).sendKeys(tenure);
	}
	
	public void secsetdp() {
		
		
	}
	
}
