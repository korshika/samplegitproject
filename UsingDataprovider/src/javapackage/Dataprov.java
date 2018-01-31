package javapackage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dataprov {

	@Test
	public void eMICalculatorDataDrivenScript() throws InterruptedException
	{
		ExcelRead oEMICalcSheet = new ExcelRead("C:\\Users\\chandu\\Documents\\selenium jar files\\Excelsheet/EMICalculator.xls", "EMI");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chandu\\Documents\\selenium jar files\\chromedriver/chromedriver.exe");
		String sLoanAmount;
		WebDriver driver= new ChromeDriver();
		
		for(int iEachRowData=1; iEachRowData<oEMICalcSheet.rowCount(); iEachRowData++)
		{
			
			driver.get("http://www.deal4loans.com/Contents_Calculators.php");
			driver.manage().window().maximize();
			Thread.sleep(4000);	
			
			sLoanAmount = oEMICalcSheet.getCellData("LoanAmount", iEachRowData);
			
			//selecting loan amount
			driver.findElement(By.id("Loan_Amount")).clear();
			driver.findElement(By.id("Loan_Amount")).sendKeys(sLoanAmount);
	
			//selecting Interest Rate (Reducing)
			driver.findElement(By.name("rate")).clear();
			driver.findElement(By.name("rate")).sendKeys(oEMICalcSheet.getCellData("IR", iEachRowData));
	
			//selecting	Loan Tenure
			driver.findElement(By.name("months")).clear();
			driver.findElement(By.name("months")).sendKeys(oEMICalcSheet.getCellData("Tenure", iEachRowData));
	
			//Click on Calculate Button
			driver.findElement(By.name("button")).click();
		}
	
	
	}
}
