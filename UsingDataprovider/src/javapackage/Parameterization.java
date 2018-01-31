package javapackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameterization {

	public void eMICalculator() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chandu\\Documents\\selenium jar files\\chromedriver/chromedriver.exe");
		 
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.deal4loans.com/Contents_Calculators.php");
		driver.manage().window().maximize();
		Thread.sleep(4000);	
		
		//selecting loan amount
		driver.findElement(By.id("Loan_Amount")).clear();
		driver.findElement(By.id("Loan_Amount")).sendKeys("3000000");

		//selecting Interest Rate (Reducing)
		driver.findElement(By.name("rate")).clear();
		driver.findElement(By.name("rate")).sendKeys("11.5");

		//selecting	Loan Tenure
		driver.findElement(By.name("months")).clear();
		driver.findElement(By.name("months")).sendKeys("250");

		//Click on Calculate Button
		driver.findElement(By.name("button")).click();
	}
	
	public void eMICalculatorParameterized() throws InterruptedException
	{
		ExcelRead oEMICalcSheet = new ExcelRead("/Users/narkandukuri/Documents/Personal/Sel/P2S5/Deal4Loans.xls", "EMICalculator");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chandu\\Documents\\selenium jar files\\chromedriver/chromedriver.exe");
		 
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.deal4loans.com/Contents_Calculators.php");
		driver.manage().window().maximize();
		Thread.sleep(4000);	
		
		String sLoanAmount = oEMICalcSheet.getCellData("LoanAmount", 1);
		
		//selecting loan amount
		driver.findElement(By.id("Loan_Amount")).clear();
		driver.findElement(By.id("Loan_Amount")).sendKeys(sLoanAmount);

		//selecting Interest Rate (Reducing)
		driver.findElement(By.name("rate")).clear();
		driver.findElement(By.name("rate")).sendKeys(oEMICalcSheet.getCellData("IR", 1));

		//selecting	Loan Tenure
		driver.findElement(By.name("months")).clear();
		driver.findElement(By.name("months")).sendKeys(oEMICalcSheet.getCellData("Tenure", 1));

		//Click on Calculate Button
		driver.findElement(By.name("button")).click();
	}
	
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
